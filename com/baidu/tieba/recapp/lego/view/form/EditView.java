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
    private EditText jKg;
    private VerificationCodeView jKh;
    private String jKi;
    private String jKj;

    public EditView(Context context) {
        super(context);
        this.jKg = null;
        this.jKh = null;
        this.jKi = "";
        this.jKj = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jKg = null;
        this.jKh = null;
        this.jKi = "";
        this.jKj = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jKg = null;
        this.jKh = null;
        this.jKi = "";
        this.jKj = "";
        init();
    }

    private void init() {
        cCY();
        cCZ();
    }

    private void cCY() {
        this.jKg = new EditText(this.mContext);
        this.jKg.setId(1);
        this.jKg.setTextSize(0, this.bgS);
        this.jKg.setTextColor(this.jKG);
        this.jKg.setHintTextColor(this.jKH);
        this.jKg.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.jKg.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cCX()) {
                    EditView.this.a(EditView.this.jKg, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.jKg, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.jKg, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jKg, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cCZ() {
        this.jKh = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jKD);
        layoutParams.topMargin = this.jKB;
        layoutParams.addRule(3, this.jKg.getId());
        addView(this.jKh, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.jKg.setTextSize(0, this.bgS);
            switch (dVar.type) {
                case 3:
                    int i2 = this.jKD;
                    this.jKg.setInputType(1);
                    this.jKg.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.jKF;
                    this.jKg.setInputType(131072);
                    this.jKg.setFilters(new InputFilter[]{new a(100)});
                    this.jKg.setSingleLine(false);
                    this.jKg.setHorizontallyScrolling(false);
                    this.jKg.setGravity(51);
                    this.jKg.setPadding(this.jKA, this.jKA, this.jKA, this.jKA);
                    i = i3;
                    break;
                case 5:
                    i = this.jKD;
                    this.jKg.setInputType(2);
                    this.jKg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.jHy != null) {
                        this.jKh.setVisibility(0);
                        this.jKh.aJ(this.jKv);
                        this.jKh.a(dVar.jHy);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jKh.getLayoutParams();
                        marginLayoutParams.topMargin = this.jKB;
                        marginLayoutParams.height = this.jKD;
                        this.jKh.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cDa() {
                                EditView.this.jKh.setVerificationInfo(((Object) EditView.this.jKg.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jKg.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.jKg.setLayoutParams(layoutParams2);
            }
            this.jKg.setHint(dVar.content);
            this.jKi = dVar.jHx;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jKg.setPadding(this.jKA, 0, 0, 0);
        this.jKg.setText("");
        this.jKg.setGravity(19);
        this.jKg.setSingleLine(true);
        this.jKg.setHorizontallyScrolling(true);
        this.jKg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.jKh.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cCX() {
        if (TextUtils.isEmpty(this.jKi)) {
            return true;
        }
        Editable text = this.jKg.getText();
        if (text != null) {
            this.jKj = text.toString().trim();
        }
        return Pattern.matches(this.jKi, this.jKj);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.jKj;
    }

    /* loaded from: classes13.dex */
    private class a implements InputFilter {
        int jKl;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.jKl = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + HV(spanned.toString());
            int length2 = charSequence.toString().length() + HV(charSequence.toString());
            if (length + length2 > this.jKl) {
                int i5 = this.jKl - length;
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
