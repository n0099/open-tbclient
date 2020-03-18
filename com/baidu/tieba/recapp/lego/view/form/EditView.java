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
/* loaded from: classes13.dex */
public class EditView extends FormItemBaseView {
    private EditText jLU;
    private VerificationCodeView jLV;
    private String jLW;
    private String jLX;

    public EditView(Context context) {
        super(context);
        this.jLU = null;
        this.jLV = null;
        this.jLW = "";
        this.jLX = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jLU = null;
        this.jLV = null;
        this.jLW = "";
        this.jLX = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jLU = null;
        this.jLV = null;
        this.jLW = "";
        this.jLX = "";
        init();
    }

    private void init() {
        cDt();
        cDu();
    }

    private void cDt() {
        this.jLU = new EditText(this.mContext);
        this.jLU.setId(1);
        this.jLU.setTextSize(0, this.bhg);
        this.jLU.setTextColor(this.jMu);
        this.jLU.setHintTextColor(this.jMv);
        this.jLU.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.jLU.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cDs()) {
                    EditView.this.a(EditView.this.jLU, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.jLU, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.jLU, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jLU, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cDu() {
        this.jLV = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jMr);
        layoutParams.topMargin = this.jMp;
        layoutParams.addRule(3, this.jLU.getId());
        addView(this.jLV, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.jLU.setTextSize(0, this.bhg);
            switch (dVar.type) {
                case 3:
                    int i2 = this.jMr;
                    this.jLU.setInputType(1);
                    this.jLU.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.jMt;
                    this.jLU.setInputType(131072);
                    this.jLU.setFilters(new InputFilter[]{new a(100)});
                    this.jLU.setSingleLine(false);
                    this.jLU.setHorizontallyScrolling(false);
                    this.jLU.setGravity(51);
                    this.jLU.setPadding(this.jMo, this.jMo, this.jMo, this.jMo);
                    i = i3;
                    break;
                case 5:
                    i = this.jMr;
                    this.jLU.setInputType(2);
                    this.jLU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.jJj != null) {
                        this.jLV.setVisibility(0);
                        this.jLV.aJ(this.jMj);
                        this.jLV.a(dVar.jJj);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jLV.getLayoutParams();
                        marginLayoutParams.topMargin = this.jMp;
                        marginLayoutParams.height = this.jMr;
                        this.jLV.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cDv() {
                                EditView.this.jLV.setVerificationInfo(((Object) EditView.this.jLU.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jLU.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.jLU.setLayoutParams(layoutParams2);
            }
            this.jLU.setHint(dVar.content);
            this.jLW = dVar.jJi;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jLU.setPadding(this.jMo, 0, 0, 0);
        this.jLU.setText("");
        this.jLU.setGravity(19);
        this.jLU.setSingleLine(true);
        this.jLU.setHorizontallyScrolling(true);
        this.jLU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.jLV.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cDs() {
        if (TextUtils.isEmpty(this.jLW)) {
            return true;
        }
        Editable text = this.jLU.getText();
        if (text != null) {
            this.jLX = text.toString().trim();
        }
        return Pattern.matches(this.jLW, this.jLX);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.jLX;
    }

    /* loaded from: classes13.dex */
    private class a implements InputFilter {
        int jLZ;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.jLZ = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + HV(spanned.toString());
            int length2 = charSequence.toString().length() + HV(charSequence.toString());
            if (length + length2 > this.jLZ) {
                int i5 = this.jLZ - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (HW(charAt + "")) {
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

        private int HV(String str) {
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

        private boolean HW(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
