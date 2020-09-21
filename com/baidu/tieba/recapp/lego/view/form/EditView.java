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
/* loaded from: classes25.dex */
public class EditView extends FormItemBaseView {
    private EditText lPg;
    private VerificationCodeView lPh;
    private String lPi;
    private String lPj;

    public EditView(Context context) {
        super(context);
        this.lPg = null;
        this.lPh = null;
        this.lPi = "";
        this.lPj = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lPg = null;
        this.lPh = null;
        this.lPi = "";
        this.lPj = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lPg = null;
        this.lPh = null;
        this.lPi = "";
        this.lPj = "";
        init();
    }

    private void init() {
        drv();
        drw();
    }

    private void drv() {
        this.lPg = new EditText(this.mContext);
        this.lPg.setId(1);
        this.lPg.setTextSize(0, this.cbH);
        this.lPg.setTextColor(this.lPG);
        this.lPg.setHintTextColor(this.lPH);
        this.lPg.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.lPg.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dru()) {
                    EditView.this.a(EditView.this.lPg, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.lPg, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.lPg, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lPg, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void drw() {
        this.lPh = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lPD);
        layoutParams.topMargin = this.lPB;
        layoutParams.addRule(3, this.lPg.getId());
        addView(this.lPh, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.lPg.setTextSize(0, this.cbH);
            switch (dVar.type) {
                case 3:
                    int i2 = this.lPD;
                    this.lPg.setInputType(1);
                    this.lPg.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.lPF;
                    this.lPg.setInputType(131072);
                    this.lPg.setFilters(new InputFilter[]{new a(100)});
                    this.lPg.setSingleLine(false);
                    this.lPg.setHorizontallyScrolling(false);
                    this.lPg.setGravity(51);
                    this.lPg.setPadding(this.lPA, this.lPA, this.lPA, this.lPA);
                    i = i3;
                    break;
                case 5:
                    i = this.lPD;
                    this.lPg.setInputType(2);
                    this.lPg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.lMS != null) {
                        this.lPh.setVisibility(0);
                        this.lPh.aC(this.lPv);
                        this.lPh.a(dVar.lMS);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lPh.getLayoutParams();
                        marginLayoutParams.topMargin = this.lPB;
                        marginLayoutParams.height = this.lPD;
                        this.lPh.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void drx() {
                                EditView.this.lPh.setVerificationInfo(((Object) EditView.this.lPg.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lPg.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.lPg.setLayoutParams(layoutParams2);
            }
            this.lPg.setHint(dVar.content);
            this.lPi = dVar.lMR;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lPg.setPadding(this.lPA, 0, 0, 0);
        this.lPg.setText("");
        this.lPg.setGravity(19);
        this.lPg.setSingleLine(true);
        this.lPg.setHorizontallyScrolling(true);
        this.lPg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.lPh.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dru() {
        if (TextUtils.isEmpty(this.lPi)) {
            return true;
        }
        Editable text = this.lPg.getText();
        if (text != null) {
            this.lPj = text.toString().trim();
        }
        return Pattern.matches(this.lPi, this.lPj);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.lPj;
    }

    /* loaded from: classes25.dex */
    private class a implements InputFilter {
        int lPl;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.lPl = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + PY(spanned.toString());
            int length2 = charSequence.toString().length() + PY(charSequence.toString());
            if (length + length2 > this.lPl) {
                int i5 = this.lPl - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (PZ(charAt + "")) {
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

        private int PY(String str) {
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

        private boolean PZ(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
