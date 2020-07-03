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
    private EditText lij;
    private VerificationCodeView lik;
    private String lil;
    private String lim;

    public EditView(Context context) {
        super(context);
        this.lij = null;
        this.lik = null;
        this.lil = "";
        this.lim = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lij = null;
        this.lik = null;
        this.lil = "";
        this.lim = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lij = null;
        this.lik = null;
        this.lil = "";
        this.lim = "";
        init();
    }

    private void init() {
        cZs();
        cZt();
    }

    private void cZs() {
        this.lij = new EditText(this.mContext);
        this.lij.setId(1);
        this.lij.setTextSize(0, this.bTc);
        this.lij.setTextColor(this.liJ);
        this.lij.setHintTextColor(this.liK);
        this.lij.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.lij.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cZr()) {
                    EditView.this.a(EditView.this.lij, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.lij, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.lij, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lij, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cZt() {
        this.lik = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.liG);
        layoutParams.topMargin = this.liE;
        layoutParams.addRule(3, this.lij.getId());
        addView(this.lik, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.lij.setTextSize(0, this.bTc);
            switch (dVar.type) {
                case 3:
                    int i2 = this.liG;
                    this.lij.setInputType(1);
                    this.lij.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.liI;
                    this.lij.setInputType(131072);
                    this.lij.setFilters(new InputFilter[]{new a(100)});
                    this.lij.setSingleLine(false);
                    this.lij.setHorizontallyScrolling(false);
                    this.lij.setGravity(51);
                    this.lij.setPadding(this.liD, this.liD, this.liD, this.liD);
                    i = i3;
                    break;
                case 5:
                    i = this.liG;
                    this.lij.setInputType(2);
                    this.lij.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.lfW != null) {
                        this.lik.setVisibility(0);
                        this.lik.ax(this.liy);
                        this.lik.a(dVar.lfW);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lik.getLayoutParams();
                        marginLayoutParams.topMargin = this.liE;
                        marginLayoutParams.height = this.liG;
                        this.lik.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cZu() {
                                EditView.this.lik.setVerificationInfo(((Object) EditView.this.lij.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lij.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.lij.setLayoutParams(layoutParams2);
            }
            this.lij.setHint(dVar.content);
            this.lil = dVar.lfV;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lij.setPadding(this.liD, 0, 0, 0);
        this.lij.setText("");
        this.lij.setGravity(19);
        this.lij.setSingleLine(true);
        this.lij.setHorizontallyScrolling(true);
        this.lij.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.lik.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cZr() {
        if (TextUtils.isEmpty(this.lil)) {
            return true;
        }
        Editable text = this.lij.getText();
        if (text != null) {
            this.lim = text.toString().trim();
        }
        return Pattern.matches(this.lil, this.lim);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.lim;
    }

    /* loaded from: classes13.dex */
    private class a implements InputFilter {
        int lio;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.lio = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + LR(spanned.toString());
            int length2 = charSequence.toString().length() + LR(charSequence.toString());
            if (length + length2 > this.lio) {
                int i5 = this.lio - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (LS(charAt + "")) {
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

        private int LR(String str) {
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

        private boolean LS(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
