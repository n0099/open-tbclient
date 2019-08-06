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
    private EditText iKO;
    private VerificationCodeView iKP;
    private String iKQ;
    private String iKR;

    public EditView(Context context) {
        super(context);
        this.iKO = null;
        this.iKP = null;
        this.iKQ = "";
        this.iKR = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iKO = null;
        this.iKP = null;
        this.iKQ = "";
        this.iKR = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iKO = null;
        this.iKP = null;
        this.iKQ = "";
        this.iKR = "";
        init();
    }

    private void init() {
        cix();
        ciy();
    }

    private void cix() {
        this.iKO = new EditText(this.mContext);
        this.iKO.setId(1);
        this.iKO.setTextSize(0, this.amF);
        this.iKO.setTextColor(this.iLp);
        this.iKO.setHintTextColor(this.iLq);
        this.iKO.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.iKO.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.ciw()) {
                    EditView.this.a(EditView.this.iKO, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.iKO, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.iKO, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iKO, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void ciy() {
        this.iKP = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iLm);
        layoutParams.topMargin = this.iLk;
        layoutParams.addRule(3, this.iKO.getId());
        addView(this.iKP, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.iKO.setTextSize(0, this.amF);
            switch (dVar.type) {
                case 3:
                    int i2 = this.iLm;
                    this.iKO.setInputType(1);
                    this.iKO.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.iLo;
                    this.iKO.setInputType(131072);
                    this.iKO.setFilters(new InputFilter[]{new a(100)});
                    this.iKO.setSingleLine(false);
                    this.iKO.setHorizontallyScrolling(false);
                    this.iKO.setGravity(51);
                    this.iKO.setPadding(this.iLj, this.iLj, this.iLj, this.iLj);
                    i = i3;
                    break;
                case 5:
                    i = this.iLm;
                    this.iKO.setInputType(2);
                    this.iKO.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iIl != null) {
                        this.iKP.setVisibility(0);
                        this.iKP.aQ(this.iLe);
                        this.iKP.a(dVar.iIl);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iKP.getLayoutParams();
                        marginLayoutParams.topMargin = this.iLk;
                        marginLayoutParams.height = this.iLm;
                        this.iKP.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void ciz() {
                                EditView.this.iKP.setVerificationInfo(((Object) EditView.this.iKO.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iKO.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.iKO.setLayoutParams(layoutParams2);
            }
            this.iKO.setHint(dVar.content);
            this.iKQ = dVar.iIk;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iKO.setPadding(this.iLj, 0, 0, 0);
        this.iKO.setText("");
        this.iKO.setGravity(19);
        this.iKO.setSingleLine(true);
        this.iKO.setHorizontallyScrolling(true);
        this.iKO.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.iKP.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean ciw() {
        if (TextUtils.isEmpty(this.iKQ)) {
            return true;
        }
        Editable text = this.iKO.getText();
        if (text != null) {
            this.iKR = text.toString().trim();
        }
        return Pattern.matches(this.iKQ, this.iKR);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iKR;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int iKT;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.iKT = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + DP(spanned.toString());
            int length2 = charSequence.toString().length() + DP(charSequence.toString());
            if (length + length2 > this.iKT) {
                int i5 = this.iKT - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (DQ(charAt + "")) {
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

        private int DP(String str) {
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

        private boolean DQ(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
