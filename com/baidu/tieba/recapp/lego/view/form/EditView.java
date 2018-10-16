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
/* loaded from: classes3.dex */
public class EditView extends FormItemBaseView {
    private EditText gHe;
    private VerificationCodeView gHf;
    private String gHg;
    private String gHh;

    public EditView(Context context) {
        super(context);
        this.gHe = null;
        this.gHf = null;
        this.gHg = "";
        this.gHh = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHe = null;
        this.gHf = null;
        this.gHg = "";
        this.gHh = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gHe = null;
        this.gHf = null;
        this.gHg = "";
        this.gHh = "";
        init();
    }

    private void init() {
        btM();
        btN();
    }

    private void btM() {
        this.gHe = new EditText(this.mContext);
        this.gHe.setId(1);
        this.gHe.setTextSize(0, this.mFontSize);
        this.gHe.setTextColor(this.gHF);
        this.gHe.setHintTextColor(this.gHG);
        this.gHe.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gHe.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.btL()) {
                    EditView.this.a(EditView.this.gHe, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gHe, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gHe, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gHe, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void btN() {
        this.gHf = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gHC);
        layoutParams.topMargin = this.gHA;
        layoutParams.addRule(3, this.gHe.getId());
        addView(this.gHf, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gHe.setTextSize(0, this.mFontSize);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gHC;
                    this.gHe.setInputType(1);
                    this.gHe.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gHE;
                    this.gHe.setInputType(131072);
                    this.gHe.setFilters(new InputFilter[]{new a(100)});
                    this.gHe.setSingleLine(false);
                    this.gHe.setHorizontallyScrolling(false);
                    this.gHe.setGravity(51);
                    this.gHe.setPadding(this.gHz, this.gHz, this.gHz, this.gHz);
                    i = i3;
                    break;
                case 5:
                    i = this.gHC;
                    this.gHe.setInputType(2);
                    this.gHe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gEA != null) {
                        this.gHf.setVisibility(0);
                        this.gHf.aw(this.gHu);
                        this.gHf.a(dVar.gEA);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gHf.getLayoutParams();
                        marginLayoutParams.topMargin = this.gHA;
                        marginLayoutParams.height = this.gHC;
                        this.gHf.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void btO() {
                                EditView.this.gHf.setVerificationInfo(((Object) EditView.this.gHe.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHe.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gHe.setLayoutParams(layoutParams2);
            }
            this.gHe.setHint(dVar.content);
            this.gHg = dVar.gEz;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gHe.setPadding(this.gHz, 0, 0, 0);
        this.gHe.setText("");
        this.gHe.setGravity(19);
        this.gHe.setSingleLine(true);
        this.gHe.setHorizontallyScrolling(true);
        this.gHe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gHf.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean btL() {
        if (TextUtils.isEmpty(this.gHg)) {
            return true;
        }
        Editable text = this.gHe.getText();
        if (text != null) {
            this.gHh = text.toString().trim();
        }
        return Pattern.matches(this.gHg, this.gHh);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gHh;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gHj;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gHj = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + uc(spanned.toString());
            int length2 = charSequence.toString().length() + uc(charSequence.toString());
            if (length + length2 > this.gHj) {
                int i5 = this.gHj - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (ud(charAt + "")) {
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

        private int uc(String str) {
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

        private boolean ud(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
