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
    private EditText iDr;
    private VerificationCodeView iDs;
    private String iDt;
    private String iDu;

    public EditView(Context context) {
        super(context);
        this.iDr = null;
        this.iDs = null;
        this.iDt = "";
        this.iDu = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iDr = null;
        this.iDs = null;
        this.iDt = "";
        this.iDu = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iDr = null;
        this.iDs = null;
        this.iDt = "";
        this.iDu = "";
        init();
    }

    private void init() {
        cfn();
        cfo();
    }

    private void cfn() {
        this.iDr = new EditText(this.mContext);
        this.iDr.setId(1);
        this.iDr.setTextSize(0, this.amc);
        this.iDr.setTextColor(this.iDS);
        this.iDr.setHintTextColor(this.iDT);
        this.iDr.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.iDr.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cfm()) {
                    EditView.this.a(EditView.this.iDr, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.iDr, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.iDr, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iDr, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cfo() {
        this.iDs = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iDP);
        layoutParams.topMargin = this.iDN;
        layoutParams.addRule(3, this.iDr.getId());
        addView(this.iDs, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.iDr.setTextSize(0, this.amc);
            switch (dVar.type) {
                case 3:
                    int i2 = this.iDP;
                    this.iDr.setInputType(1);
                    this.iDr.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.iDR;
                    this.iDr.setInputType(131072);
                    this.iDr.setFilters(new InputFilter[]{new a(100)});
                    this.iDr.setSingleLine(false);
                    this.iDr.setHorizontallyScrolling(false);
                    this.iDr.setGravity(51);
                    this.iDr.setPadding(this.iDM, this.iDM, this.iDM, this.iDM);
                    i = i3;
                    break;
                case 5:
                    i = this.iDP;
                    this.iDr.setInputType(2);
                    this.iDr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iAO != null) {
                        this.iDs.setVisibility(0);
                        this.iDs.aP(this.iDH);
                        this.iDs.a(dVar.iAO);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iDs.getLayoutParams();
                        marginLayoutParams.topMargin = this.iDN;
                        marginLayoutParams.height = this.iDP;
                        this.iDs.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cfp() {
                                EditView.this.iDs.setVerificationInfo(((Object) EditView.this.iDr.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDr.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.iDr.setLayoutParams(layoutParams2);
            }
            this.iDr.setHint(dVar.content);
            this.iDt = dVar.iAN;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iDr.setPadding(this.iDM, 0, 0, 0);
        this.iDr.setText("");
        this.iDr.setGravity(19);
        this.iDr.setSingleLine(true);
        this.iDr.setHorizontallyScrolling(true);
        this.iDr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.iDs.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfm() {
        if (TextUtils.isEmpty(this.iDt)) {
            return true;
        }
        Editable text = this.iDr.getText();
        if (text != null) {
            this.iDu = text.toString().trim();
        }
        return Pattern.matches(this.iDt, this.iDu);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iDu;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int iDw;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.iDw = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + CZ(spanned.toString());
            int length2 = charSequence.toString().length() + CZ(charSequence.toString());
            if (length + length2 > this.iDw) {
                int i5 = this.iDw - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Da(charAt + "")) {
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

        private int CZ(String str) {
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

        private boolean Da(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
