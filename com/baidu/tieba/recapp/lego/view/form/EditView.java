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
    private EditText jKe;
    private VerificationCodeView jKf;
    private String jKg;
    private String jKh;

    public EditView(Context context) {
        super(context);
        this.jKe = null;
        this.jKf = null;
        this.jKg = "";
        this.jKh = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jKe = null;
        this.jKf = null;
        this.jKg = "";
        this.jKh = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jKe = null;
        this.jKf = null;
        this.jKg = "";
        this.jKh = "";
        init();
    }

    private void init() {
        cCW();
        cCX();
    }

    private void cCW() {
        this.jKe = new EditText(this.mContext);
        this.jKe.setId(1);
        this.jKe.setTextSize(0, this.bgR);
        this.jKe.setTextColor(this.jKE);
        this.jKe.setHintTextColor(this.jKF);
        this.jKe.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.jKe.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cCV()) {
                    EditView.this.a(EditView.this.jKe, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.jKe, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.jKe, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jKe, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cCX() {
        this.jKf = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jKB);
        layoutParams.topMargin = this.jKz;
        layoutParams.addRule(3, this.jKe.getId());
        addView(this.jKf, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.jKe.setTextSize(0, this.bgR);
            switch (dVar.type) {
                case 3:
                    int i2 = this.jKB;
                    this.jKe.setInputType(1);
                    this.jKe.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.jKD;
                    this.jKe.setInputType(131072);
                    this.jKe.setFilters(new InputFilter[]{new a(100)});
                    this.jKe.setSingleLine(false);
                    this.jKe.setHorizontallyScrolling(false);
                    this.jKe.setGravity(51);
                    this.jKe.setPadding(this.jKy, this.jKy, this.jKy, this.jKy);
                    i = i3;
                    break;
                case 5:
                    i = this.jKB;
                    this.jKe.setInputType(2);
                    this.jKe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.jHw != null) {
                        this.jKf.setVisibility(0);
                        this.jKf.aJ(this.jKt);
                        this.jKf.a(dVar.jHw);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jKf.getLayoutParams();
                        marginLayoutParams.topMargin = this.jKz;
                        marginLayoutParams.height = this.jKB;
                        this.jKf.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cCY() {
                                EditView.this.jKf.setVerificationInfo(((Object) EditView.this.jKe.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jKe.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.jKe.setLayoutParams(layoutParams2);
            }
            this.jKe.setHint(dVar.content);
            this.jKg = dVar.jHv;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jKe.setPadding(this.jKy, 0, 0, 0);
        this.jKe.setText("");
        this.jKe.setGravity(19);
        this.jKe.setSingleLine(true);
        this.jKe.setHorizontallyScrolling(true);
        this.jKe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.jKf.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cCV() {
        if (TextUtils.isEmpty(this.jKg)) {
            return true;
        }
        Editable text = this.jKe.getText();
        if (text != null) {
            this.jKh = text.toString().trim();
        }
        return Pattern.matches(this.jKg, this.jKh);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.jKh;
    }

    /* loaded from: classes13.dex */
    private class a implements InputFilter {
        int jKj;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.jKj = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + HV(spanned.toString());
            int length2 = charSequence.toString().length() + HV(charSequence.toString());
            if (length + length2 > this.jKj) {
                int i5 = this.jKj - length;
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
