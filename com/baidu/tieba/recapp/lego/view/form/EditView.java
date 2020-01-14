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
/* loaded from: classes11.dex */
public class EditView extends FormItemBaseView {
    private EditText jJi;
    private VerificationCodeView jJj;
    private String jJk;
    private String jJl;

    public EditView(Context context) {
        super(context);
        this.jJi = null;
        this.jJj = null;
        this.jJk = "";
        this.jJl = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jJi = null;
        this.jJj = null;
        this.jJk = "";
        this.jJl = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jJi = null;
        this.jJj = null;
        this.jJk = "";
        this.jJl = "";
        init();
    }

    private void init() {
        cBA();
        cBB();
    }

    private void cBA() {
        this.jJi = new EditText(this.mContext);
        this.jJi.setId(1);
        this.jJi.setTextSize(0, this.bcC);
        this.jJi.setTextColor(this.jJI);
        this.jJi.setHintTextColor(this.jJJ);
        this.jJi.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.jJi.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cBz()) {
                    EditView.this.a(EditView.this.jJi, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.jJi, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.jJi, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jJi, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cBB() {
        this.jJj = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jJF);
        layoutParams.topMargin = this.jJD;
        layoutParams.addRule(3, this.jJi.getId());
        addView(this.jJj, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.jJi.setTextSize(0, this.bcC);
            switch (dVar.type) {
                case 3:
                    int i2 = this.jJF;
                    this.jJi.setInputType(1);
                    this.jJi.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.jJH;
                    this.jJi.setInputType(131072);
                    this.jJi.setFilters(new InputFilter[]{new a(100)});
                    this.jJi.setSingleLine(false);
                    this.jJi.setHorizontallyScrolling(false);
                    this.jJi.setGravity(51);
                    this.jJi.setPadding(this.jJC, this.jJC, this.jJC, this.jJC);
                    i = i3;
                    break;
                case 5:
                    i = this.jJF;
                    this.jJi.setInputType(2);
                    this.jJi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.jGF != null) {
                        this.jJj.setVisibility(0);
                        this.jJj.aK(this.jJx);
                        this.jJj.a(dVar.jGF);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jJj.getLayoutParams();
                        marginLayoutParams.topMargin = this.jJD;
                        marginLayoutParams.height = this.jJF;
                        this.jJj.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cBC() {
                                EditView.this.jJj.setVerificationInfo(((Object) EditView.this.jJi.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jJi.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.jJi.setLayoutParams(layoutParams2);
            }
            this.jJi.setHint(dVar.content);
            this.jJk = dVar.jGE;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jJi.setPadding(this.jJC, 0, 0, 0);
        this.jJi.setText("");
        this.jJi.setGravity(19);
        this.jJi.setSingleLine(true);
        this.jJi.setHorizontallyScrolling(true);
        this.jJi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.jJj.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cBz() {
        if (TextUtils.isEmpty(this.jJk)) {
            return true;
        }
        Editable text = this.jJi.getText();
        if (text != null) {
            this.jJl = text.toString().trim();
        }
        return Pattern.matches(this.jJk, this.jJl);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.jJl;
    }

    /* loaded from: classes11.dex */
    private class a implements InputFilter {
        int jJn;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.jJn = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + HH(spanned.toString());
            int length2 = charSequence.toString().length() + HH(charSequence.toString());
            if (length + length2 > this.jJn) {
                int i5 = this.jJn - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (HI(charAt + "")) {
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

        private int HH(String str) {
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

        private boolean HI(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
