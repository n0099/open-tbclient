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
    private EditText iLm;
    private VerificationCodeView iLn;
    private String iLo;
    private String iLp;

    public EditView(Context context) {
        super(context);
        this.iLm = null;
        this.iLn = null;
        this.iLo = "";
        this.iLp = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLm = null;
        this.iLn = null;
        this.iLo = "";
        this.iLp = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLm = null;
        this.iLn = null;
        this.iLo = "";
        this.iLp = "";
        init();
    }

    private void init() {
        cgn();
        cgo();
    }

    private void cgn() {
        this.iLm = new EditText(this.mContext);
        this.iLm.setId(1);
        this.iLm.setTextSize(0, this.aGd);
        this.iLm.setTextColor(this.iLM);
        this.iLm.setHintTextColor(this.iLN);
        this.iLm.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.iLm.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cgm()) {
                    EditView.this.a(EditView.this.iLm, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.iLm, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.iLm, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iLm, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cgo() {
        this.iLn = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iLJ);
        layoutParams.topMargin = this.iLH;
        layoutParams.addRule(3, this.iLm.getId());
        addView(this.iLn, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.iLm.setTextSize(0, this.aGd);
            switch (dVar.type) {
                case 3:
                    int i2 = this.iLJ;
                    this.iLm.setInputType(1);
                    this.iLm.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.iLL;
                    this.iLm.setInputType(131072);
                    this.iLm.setFilters(new InputFilter[]{new a(100)});
                    this.iLm.setSingleLine(false);
                    this.iLm.setHorizontallyScrolling(false);
                    this.iLm.setGravity(51);
                    this.iLm.setPadding(this.iLG, this.iLG, this.iLG, this.iLG);
                    i = i3;
                    break;
                case 5:
                    i = this.iLJ;
                    this.iLm.setInputType(2);
                    this.iLm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iIH != null) {
                        this.iLn.setVisibility(0);
                        this.iLn.au(this.iLB);
                        this.iLn.a(dVar.iIH);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iLn.getLayoutParams();
                        marginLayoutParams.topMargin = this.iLH;
                        marginLayoutParams.height = this.iLJ;
                        this.iLn.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cgp() {
                                EditView.this.iLn.setVerificationInfo(((Object) EditView.this.iLm.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iLm.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.iLm.setLayoutParams(layoutParams2);
            }
            this.iLm.setHint(dVar.content);
            this.iLo = dVar.iIG;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iLm.setPadding(this.iLG, 0, 0, 0);
        this.iLm.setText("");
        this.iLm.setGravity(19);
        this.iLm.setSingleLine(true);
        this.iLm.setHorizontallyScrolling(true);
        this.iLm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.iLn.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cgm() {
        if (TextUtils.isEmpty(this.iLo)) {
            return true;
        }
        Editable text = this.iLm.getText();
        if (text != null) {
            this.iLp = text.toString().trim();
        }
        return Pattern.matches(this.iLo, this.iLp);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iLp;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int iLr;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.iLr = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + CK(spanned.toString());
            int length2 = charSequence.toString().length() + CK(charSequence.toString());
            if (length + length2 > this.iLr) {
                int i5 = this.iLr - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (CL(charAt + "")) {
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

        private int CK(String str) {
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

        private boolean CL(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
