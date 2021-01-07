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
/* loaded from: classes8.dex */
public class EditView extends FormItemBaseView {
    private EditText mQD;
    private VerificationCodeView mQE;
    private String mQF;
    private String mQG;

    public EditView(Context context) {
        super(context);
        this.mQD = null;
        this.mQE = null;
        this.mQF = "";
        this.mQG = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mQD = null;
        this.mQE = null;
        this.mQF = "";
        this.mQG = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mQD = null;
        this.mQE = null;
        this.mQF = "";
        this.mQG = "";
        init();
    }

    private void init() {
        dFu();
        dFv();
    }

    private void dFu() {
        this.mQD = new EditText(this.mContext);
        this.mQD.setId(1);
        this.mQD.setTextSize(0, this.cMu);
        this.mQD.setTextColor(this.mRd);
        this.mQD.setHintTextColor(this.mRe);
        this.mQD.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mQD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dFt()) {
                    EditView.this.a(EditView.this.mQD, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mQD, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mQD, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mQD, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dFv() {
        this.mQE = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mRa);
        layoutParams.topMargin = this.mQY;
        layoutParams.addRule(3, this.mQD.getId());
        addView(this.mQE, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mQD.setTextSize(0, this.cMu);
            switch (dVar.type) {
                case 3:
                    int i2 = this.mRa;
                    this.mQD.setInputType(1);
                    this.mQD.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.mRc;
                    this.mQD.setInputType(131072);
                    this.mQD.setFilters(new InputFilter[]{new a(100)});
                    this.mQD.setSingleLine(false);
                    this.mQD.setHorizontallyScrolling(false);
                    this.mQD.setGravity(51);
                    this.mQD.setPadding(this.mQX, this.mQX, this.mQX, this.mQX);
                    i = i3;
                    break;
                case 5:
                    i = this.mRa;
                    this.mQD.setInputType(2);
                    this.mQD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.mOr != null) {
                        this.mQE.setVisibility(0);
                        this.mQE.aW(this.mQS);
                        this.mQE.a(dVar.mOr);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mQE.getLayoutParams();
                        marginLayoutParams.topMargin = this.mQY;
                        marginLayoutParams.height = this.mRa;
                        this.mQE.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dFw() {
                                EditView.this.mQE.setVerificationInfo(((Object) EditView.this.mQD.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mQD.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mQD.setLayoutParams(layoutParams2);
            }
            this.mQD.setHint(dVar.content);
            this.mQF = dVar.mOq;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mQD.setPadding(this.mQX, 0, 0, 0);
        this.mQD.setText("");
        this.mQD.setGravity(19);
        this.mQD.setSingleLine(true);
        this.mQD.setHorizontallyScrolling(true);
        this.mQD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mQE.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFt() {
        if (TextUtils.isEmpty(this.mQF)) {
            return true;
        }
        Editable text = this.mQD.getText();
        if (text != null) {
            this.mQG = text.toString().trim();
        }
        return Pattern.matches(this.mQF, this.mQG);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mQG;
    }

    /* loaded from: classes8.dex */
    private class a implements InputFilter {
        int mQI;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.mQI = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5;
            int length = spanned.toString().length() + RJ(spanned.toString());
            int length2 = charSequence.toString().length() + RJ(charSequence.toString());
            if (length + length2 > this.mQI) {
                int i6 = this.mQI - length;
                String str = "";
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (RK(charAt + "")) {
                        if (length2 >= 2) {
                            str = str + charAt;
                        }
                        i5 = i6 - 2;
                    } else {
                        str = str + charAt;
                        i5 = i6 - 1;
                    }
                    i7++;
                    i6 = i5;
                }
                return str;
            }
            return charSequence;
        }

        private int RJ(String str) {
            Matcher matcher = Pattern.compile(this.regEx).matcher(str);
            int i = 0;
            while (matcher.find()) {
                for (int i2 = 0; i2 <= matcher.groupCount(); i2++) {
                    i++;
                }
            }
            return i;
        }

        private boolean RK(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
