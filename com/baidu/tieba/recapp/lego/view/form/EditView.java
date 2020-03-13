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
    private EditText jKs;
    private VerificationCodeView jKt;
    private String jKu;
    private String jKv;

    public EditView(Context context) {
        super(context);
        this.jKs = null;
        this.jKt = null;
        this.jKu = "";
        this.jKv = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jKs = null;
        this.jKt = null;
        this.jKu = "";
        this.jKv = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jKs = null;
        this.jKt = null;
        this.jKu = "";
        this.jKv = "";
        init();
    }

    private void init() {
        cCZ();
        cDa();
    }

    private void cCZ() {
        this.jKs = new EditText(this.mContext);
        this.jKs.setId(1);
        this.jKs.setTextSize(0, this.bgT);
        this.jKs.setTextColor(this.jKS);
        this.jKs.setHintTextColor(this.jKT);
        this.jKs.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.jKs.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cCY()) {
                    EditView.this.a(EditView.this.jKs, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.jKs, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.jKs, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jKs, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cDa() {
        this.jKt = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jKP);
        layoutParams.topMargin = this.jKN;
        layoutParams.addRule(3, this.jKs.getId());
        addView(this.jKt, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.jKs.setTextSize(0, this.bgT);
            switch (dVar.type) {
                case 3:
                    int i2 = this.jKP;
                    this.jKs.setInputType(1);
                    this.jKs.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.jKR;
                    this.jKs.setInputType(131072);
                    this.jKs.setFilters(new InputFilter[]{new a(100)});
                    this.jKs.setSingleLine(false);
                    this.jKs.setHorizontallyScrolling(false);
                    this.jKs.setGravity(51);
                    this.jKs.setPadding(this.jKM, this.jKM, this.jKM, this.jKM);
                    i = i3;
                    break;
                case 5:
                    i = this.jKP;
                    this.jKs.setInputType(2);
                    this.jKs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.jHK != null) {
                        this.jKt.setVisibility(0);
                        this.jKt.aJ(this.jKH);
                        this.jKt.a(dVar.jHK);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jKt.getLayoutParams();
                        marginLayoutParams.topMargin = this.jKN;
                        marginLayoutParams.height = this.jKP;
                        this.jKt.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cDb() {
                                EditView.this.jKt.setVerificationInfo(((Object) EditView.this.jKs.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jKs.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.jKs.setLayoutParams(layoutParams2);
            }
            this.jKs.setHint(dVar.content);
            this.jKu = dVar.jHJ;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jKs.setPadding(this.jKM, 0, 0, 0);
        this.jKs.setText("");
        this.jKs.setGravity(19);
        this.jKs.setSingleLine(true);
        this.jKs.setHorizontallyScrolling(true);
        this.jKs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.jKt.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cCY() {
        if (TextUtils.isEmpty(this.jKu)) {
            return true;
        }
        Editable text = this.jKs.getText();
        if (text != null) {
            this.jKv = text.toString().trim();
        }
        return Pattern.matches(this.jKu, this.jKv);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.jKv;
    }

    /* loaded from: classes13.dex */
    private class a implements InputFilter {
        int jKx;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.jKx = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + HW(spanned.toString());
            int length2 = charSequence.toString().length() + HW(charSequence.toString());
            if (length + length2 > this.jKx) {
                int i5 = this.jKx - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (HX(charAt + "")) {
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

        private int HW(String str) {
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

        private boolean HX(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
