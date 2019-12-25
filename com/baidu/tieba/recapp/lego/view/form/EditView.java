package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.tieba.recapp.lego.view.form.VerificationCodeView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class EditView extends FormItemBaseView {
    private EditText jFB;
    private VerificationCodeView jFC;
    private String jFD;
    private String jFE;

    public EditView(Context context) {
        super(context);
        this.jFB = null;
        this.jFC = null;
        this.jFD = "";
        this.jFE = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jFB = null;
        this.jFC = null;
        this.jFD = "";
        this.jFE = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jFB = null;
        this.jFC = null;
        this.jFD = "";
        this.jFE = "";
        init();
    }

    private void init() {
        cAr();
        cAs();
    }

    private void cAr() {
        this.jFB = new EditText(this.mContext);
        this.jFB.setId(1);
        this.jFB.setTextSize(0, this.bbM);
        this.jFB.setTextColor(this.jGb);
        this.jFB.setHintTextColor(this.jGc);
        this.jFB.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.jFB.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cAq()) {
                    EditView.this.a(EditView.this.jFB, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.jFB, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.jFB, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jFB, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cAs() {
        this.jFC = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jFY);
        layoutParams.topMargin = this.jFW;
        layoutParams.addRule(3, this.jFB.getId());
        addView(this.jFC, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.jFB.setTextSize(0, this.bbM);
            switch (dVar.type) {
                case 3:
                    int i2 = this.jFY;
                    this.jFB.setInputType(1);
                    this.jFB.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.jGa;
                    this.jFB.setInputType(131072);
                    this.jFB.setFilters(new InputFilter[]{new a(100)});
                    this.jFB.setSingleLine(false);
                    this.jFB.setHorizontallyScrolling(false);
                    this.jFB.setGravity(51);
                    this.jFB.setPadding(this.jFV, this.jFV, this.jFV, this.jFV);
                    i = i3;
                    break;
                case 5:
                    i = this.jFY;
                    this.jFB.setInputType(2);
                    this.jFB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.jCY != null) {
                        this.jFC.setVisibility(0);
                        this.jFC.aL(this.jFQ);
                        this.jFC.a(dVar.jCY);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jFC.getLayoutParams();
                        marginLayoutParams.topMargin = this.jFW;
                        marginLayoutParams.height = this.jFY;
                        this.jFC.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cAt() {
                                EditView.this.jFC.setVerificationInfo(((Object) EditView.this.jFB.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jFB.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.jFB.setLayoutParams(layoutParams2);
            }
            this.jFB.setHint(dVar.content);
            this.jFD = dVar.jCX;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jFB.setPadding(this.jFV, 0, 0, 0);
        this.jFB.setText("");
        this.jFB.setGravity(19);
        this.jFB.setSingleLine(true);
        this.jFB.setHorizontallyScrolling(true);
        this.jFB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.jFC.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cAq() {
        if (TextUtils.isEmpty(this.jFD)) {
            return true;
        }
        Editable text = this.jFB.getText();
        if (text != null) {
            this.jFE = text.toString().trim();
        }
        return Pattern.matches(this.jFD, this.jFE);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.jFE;
    }

    /* loaded from: classes10.dex */
    private class a implements InputFilter {
        int jFG;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.jFG = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Hx(spanned.toString());
            int length2 = charSequence.toString().length() + Hx(charSequence.toString());
            if (length + length2 > this.jFG) {
                int i5 = this.jFG - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Hy(charAt + "")) {
                        if (length2 >= 2) {
                            str = str + charAt;
                        }
                        i6 -= 2;
                    } else {
                        str = str + charAt;
                        i6--;
                    }
                    i7++;
                }
                return str;
            }
            return charSequence;
        }

        private int Hx(String str) {
            Matcher matcher = Pattern.compile(this.regEx).matcher(str);
            int i = 0;
            while (matcher.find()) {
                int i2 = 0;
                while (i2 <= matcher.groupCount()) {
                    i2++;
                    i++;
                }
            }
            return i;
        }

        private boolean Hy(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
