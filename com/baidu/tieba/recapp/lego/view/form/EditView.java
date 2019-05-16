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
    private EditText iDp;
    private VerificationCodeView iDq;
    private String iDr;
    private String iDs;

    public EditView(Context context) {
        super(context);
        this.iDp = null;
        this.iDq = null;
        this.iDr = "";
        this.iDs = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iDp = null;
        this.iDq = null;
        this.iDr = "";
        this.iDs = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iDp = null;
        this.iDq = null;
        this.iDr = "";
        this.iDs = "";
        init();
    }

    private void init() {
        cfl();
        cfm();
    }

    private void cfl() {
        this.iDp = new EditText(this.mContext);
        this.iDp.setId(1);
        this.iDp.setTextSize(0, this.amc);
        this.iDp.setTextColor(this.iDQ);
        this.iDp.setHintTextColor(this.iDR);
        this.iDp.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.iDp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cfk()) {
                    EditView.this.a(EditView.this.iDp, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.iDp, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.iDp, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iDp, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cfm() {
        this.iDq = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iDN);
        layoutParams.topMargin = this.iDL;
        layoutParams.addRule(3, this.iDp.getId());
        addView(this.iDq, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.iDp.setTextSize(0, this.amc);
            switch (dVar.type) {
                case 3:
                    int i2 = this.iDN;
                    this.iDp.setInputType(1);
                    this.iDp.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.iDP;
                    this.iDp.setInputType(131072);
                    this.iDp.setFilters(new InputFilter[]{new a(100)});
                    this.iDp.setSingleLine(false);
                    this.iDp.setHorizontallyScrolling(false);
                    this.iDp.setGravity(51);
                    this.iDp.setPadding(this.iDK, this.iDK, this.iDK, this.iDK);
                    i = i3;
                    break;
                case 5:
                    i = this.iDN;
                    this.iDp.setInputType(2);
                    this.iDp.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iAM != null) {
                        this.iDq.setVisibility(0);
                        this.iDq.aP(this.iDF);
                        this.iDq.a(dVar.iAM);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iDq.getLayoutParams();
                        marginLayoutParams.topMargin = this.iDL;
                        marginLayoutParams.height = this.iDN;
                        this.iDq.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cfn() {
                                EditView.this.iDq.setVerificationInfo(((Object) EditView.this.iDp.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDp.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.iDp.setLayoutParams(layoutParams2);
            }
            this.iDp.setHint(dVar.content);
            this.iDr = dVar.iAL;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iDp.setPadding(this.iDK, 0, 0, 0);
        this.iDp.setText("");
        this.iDp.setGravity(19);
        this.iDp.setSingleLine(true);
        this.iDp.setHorizontallyScrolling(true);
        this.iDp.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.iDq.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfk() {
        if (TextUtils.isEmpty(this.iDr)) {
            return true;
        }
        Editable text = this.iDp.getText();
        if (text != null) {
            this.iDs = text.toString().trim();
        }
        return Pattern.matches(this.iDr, this.iDs);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iDs;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int iDu;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.iDu = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + CZ(spanned.toString());
            int length2 = charSequence.toString().length() + CZ(charSequence.toString());
            if (length + length2 > this.iDu) {
                int i5 = this.iDu - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Da(charAt + "")) {
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

        private int CZ(String str) {
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

        private boolean Da(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
