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
    private EditText iJK;
    private VerificationCodeView iJL;
    private String iJM;
    private String iJN;

    public EditView(Context context) {
        super(context);
        this.iJK = null;
        this.iJL = null;
        this.iJM = "";
        this.iJN = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iJK = null;
        this.iJL = null;
        this.iJM = "";
        this.iJN = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iJK = null;
        this.iJL = null;
        this.iJM = "";
        this.iJN = "";
        init();
    }

    private void init() {
        cif();
        cig();
    }

    private void cif() {
        this.iJK = new EditText(this.mContext);
        this.iJK.setId(1);
        this.iJK.setTextSize(0, this.amF);
        this.iJK.setTextColor(this.iKl);
        this.iJK.setHintTextColor(this.iKm);
        this.iJK.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.iJK.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cie()) {
                    EditView.this.a(EditView.this.iJK, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.iJK, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.iJK, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iJK, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cig() {
        this.iJL = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iKi);
        layoutParams.topMargin = this.iKg;
        layoutParams.addRule(3, this.iJK.getId());
        addView(this.iJL, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.iJK.setTextSize(0, this.amF);
            switch (dVar.type) {
                case 3:
                    int i2 = this.iKi;
                    this.iJK.setInputType(1);
                    this.iJK.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.iKk;
                    this.iJK.setInputType(131072);
                    this.iJK.setFilters(new InputFilter[]{new a(100)});
                    this.iJK.setSingleLine(false);
                    this.iJK.setHorizontallyScrolling(false);
                    this.iJK.setGravity(51);
                    this.iJK.setPadding(this.iKf, this.iKf, this.iKf, this.iKf);
                    i = i3;
                    break;
                case 5:
                    i = this.iKi;
                    this.iJK.setInputType(2);
                    this.iJK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iHh != null) {
                        this.iJL.setVisibility(0);
                        this.iJL.aQ(this.iKa);
                        this.iJL.a(dVar.iHh);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iJL.getLayoutParams();
                        marginLayoutParams.topMargin = this.iKg;
                        marginLayoutParams.height = this.iKi;
                        this.iJL.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cih() {
                                EditView.this.iJL.setVerificationInfo(((Object) EditView.this.iJK.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iJK.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.iJK.setLayoutParams(layoutParams2);
            }
            this.iJK.setHint(dVar.content);
            this.iJM = dVar.iHg;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iJK.setPadding(this.iKf, 0, 0, 0);
        this.iJK.setText("");
        this.iJK.setGravity(19);
        this.iJK.setSingleLine(true);
        this.iJK.setHorizontallyScrolling(true);
        this.iJK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.iJL.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cie() {
        if (TextUtils.isEmpty(this.iJM)) {
            return true;
        }
        Editable text = this.iJK.getText();
        if (text != null) {
            this.iJN = text.toString().trim();
        }
        return Pattern.matches(this.iJM, this.iJN);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iJN;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int iJP;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.iJP = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + DO(spanned.toString());
            int length2 = charSequence.toString().length() + DO(charSequence.toString());
            if (length + length2 > this.iJP) {
                int i5 = this.iJP - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (DP(charAt + "")) {
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

        private int DO(String str) {
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

        private boolean DP(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
