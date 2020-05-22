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
    private EditText kNh;
    private VerificationCodeView kNi;
    private String kNj;
    private String kNk;

    public EditView(Context context) {
        super(context);
        this.kNh = null;
        this.kNi = null;
        this.kNj = "";
        this.kNk = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kNh = null;
        this.kNi = null;
        this.kNj = "";
        this.kNk = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kNh = null;
        this.kNi = null;
        this.kNj = "";
        this.kNk = "";
        init();
    }

    private void init() {
        cUM();
        cUN();
    }

    private void cUM() {
        this.kNh = new EditText(this.mContext);
        this.kNh.setId(1);
        this.kNh.setTextSize(0, this.bOo);
        this.kNh.setTextColor(this.kNH);
        this.kNh.setHintTextColor(this.kNI);
        this.kNh.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.kNh.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cUL()) {
                    EditView.this.a(EditView.this.kNh, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.kNh, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.kNh, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.kNh, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cUN() {
        this.kNi = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kNE);
        layoutParams.topMargin = this.kNC;
        layoutParams.addRule(3, this.kNh.getId());
        addView(this.kNi, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.kNh.setTextSize(0, this.bOo);
            switch (dVar.type) {
                case 3:
                    int i2 = this.kNE;
                    this.kNh.setInputType(1);
                    this.kNh.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.kNG;
                    this.kNh.setInputType(131072);
                    this.kNh.setFilters(new InputFilter[]{new a(100)});
                    this.kNh.setSingleLine(false);
                    this.kNh.setHorizontallyScrolling(false);
                    this.kNh.setGravity(51);
                    this.kNh.setPadding(this.kNB, this.kNB, this.kNB, this.kNB);
                    i = i3;
                    break;
                case 5:
                    i = this.kNE;
                    this.kNh.setInputType(2);
                    this.kNh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.kKT != null) {
                        this.kNi.setVisibility(0);
                        this.kNi.as(this.kNw);
                        this.kNi.a(dVar.kKT);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kNi.getLayoutParams();
                        marginLayoutParams.topMargin = this.kNC;
                        marginLayoutParams.height = this.kNE;
                        this.kNi.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cUO() {
                                EditView.this.kNi.setVerificationInfo(((Object) EditView.this.kNh.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kNh.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.kNh.setLayoutParams(layoutParams2);
            }
            this.kNh.setHint(dVar.content);
            this.kNj = dVar.kKS;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kNh.setPadding(this.kNB, 0, 0, 0);
        this.kNh.setText("");
        this.kNh.setGravity(19);
        this.kNh.setSingleLine(true);
        this.kNh.setHorizontallyScrolling(true);
        this.kNh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.kNi.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cUL() {
        if (TextUtils.isEmpty(this.kNj)) {
            return true;
        }
        Editable text = this.kNh.getText();
        if (text != null) {
            this.kNk = text.toString().trim();
        }
        return Pattern.matches(this.kNj, this.kNk);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.kNk;
    }

    /* loaded from: classes13.dex */
    private class a implements InputFilter {
        int kNm;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.kNm = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Lp(spanned.toString());
            int length2 = charSequence.toString().length() + Lp(charSequence.toString());
            if (length + length2 > this.kNm) {
                int i5 = this.kNm - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Lq(charAt + "")) {
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

        private int Lp(String str) {
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

        private boolean Lq(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
