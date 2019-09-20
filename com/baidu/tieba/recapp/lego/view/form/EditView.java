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
    private EditText iNk;
    private VerificationCodeView iNl;
    private String iNm;
    private String iNn;

    public EditView(Context context) {
        super(context);
        this.iNk = null;
        this.iNl = null;
        this.iNm = "";
        this.iNn = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iNk = null;
        this.iNl = null;
        this.iNm = "";
        this.iNn = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iNk = null;
        this.iNl = null;
        this.iNm = "";
        this.iNn = "";
        init();
    }

    private void init() {
        cjl();
        cjm();
    }

    private void cjl() {
        this.iNk = new EditText(this.mContext);
        this.iNk.setId(1);
        this.iNk.setTextSize(0, this.and);
        this.iNk.setTextColor(this.iNL);
        this.iNk.setHintTextColor(this.iNM);
        this.iNk.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.iNk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cjk()) {
                    EditView.this.a(EditView.this.iNk, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.iNk, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.iNk, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iNk, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cjm() {
        this.iNl = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iNI);
        layoutParams.topMargin = this.iNG;
        layoutParams.addRule(3, this.iNk.getId());
        addView(this.iNl, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.iNk.setTextSize(0, this.and);
            switch (dVar.type) {
                case 3:
                    int i2 = this.iNI;
                    this.iNk.setInputType(1);
                    this.iNk.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.iNK;
                    this.iNk.setInputType(131072);
                    this.iNk.setFilters(new InputFilter[]{new a(100)});
                    this.iNk.setSingleLine(false);
                    this.iNk.setHorizontallyScrolling(false);
                    this.iNk.setGravity(51);
                    this.iNk.setPadding(this.iNF, this.iNF, this.iNF, this.iNF);
                    i = i3;
                    break;
                case 5:
                    i = this.iNI;
                    this.iNk.setInputType(2);
                    this.iNk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iKH != null) {
                        this.iNl.setVisibility(0);
                        this.iNl.aR(this.iNA);
                        this.iNl.a(dVar.iKH);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iNl.getLayoutParams();
                        marginLayoutParams.topMargin = this.iNG;
                        marginLayoutParams.height = this.iNI;
                        this.iNl.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cjn() {
                                EditView.this.iNl.setVerificationInfo(((Object) EditView.this.iNk.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iNk.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.iNk.setLayoutParams(layoutParams2);
            }
            this.iNk.setHint(dVar.content);
            this.iNm = dVar.iKG;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iNk.setPadding(this.iNF, 0, 0, 0);
        this.iNk.setText("");
        this.iNk.setGravity(19);
        this.iNk.setSingleLine(true);
        this.iNk.setHorizontallyScrolling(true);
        this.iNk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.iNl.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cjk() {
        if (TextUtils.isEmpty(this.iNm)) {
            return true;
        }
        Editable text = this.iNk.getText();
        if (text != null) {
            this.iNn = text.toString().trim();
        }
        return Pattern.matches(this.iNm, this.iNn);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iNn;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int iNp;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.iNp = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Ep(spanned.toString());
            int length2 = charSequence.toString().length() + Ep(charSequence.toString());
            if (length + length2 > this.iNp) {
                int i5 = this.iNp - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Eq(charAt + "")) {
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

        private int Ep(String str) {
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

        private boolean Eq(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
