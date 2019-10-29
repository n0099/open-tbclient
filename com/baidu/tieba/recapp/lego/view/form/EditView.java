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
    private EditText iMd;
    private VerificationCodeView iMe;
    private String iMf;
    private String iMg;

    public EditView(Context context) {
        super(context);
        this.iMd = null;
        this.iMe = null;
        this.iMf = "";
        this.iMg = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iMd = null;
        this.iMe = null;
        this.iMf = "";
        this.iMg = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iMd = null;
        this.iMe = null;
        this.iMf = "";
        this.iMg = "";
        init();
    }

    private void init() {
        cgp();
        cgq();
    }

    private void cgp() {
        this.iMd = new EditText(this.mContext);
        this.iMd.setId(1);
        this.iMd.setTextSize(0, this.aGv);
        this.iMd.setTextColor(this.iMD);
        this.iMd.setHintTextColor(this.iME);
        this.iMd.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.iMd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cgo()) {
                    EditView.this.a(EditView.this.iMd, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.iMd, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.iMd, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iMd, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cgq() {
        this.iMe = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iMA);
        layoutParams.topMargin = this.iMy;
        layoutParams.addRule(3, this.iMd.getId());
        addView(this.iMe, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.iMd.setTextSize(0, this.aGv);
            switch (dVar.type) {
                case 3:
                    int i2 = this.iMA;
                    this.iMd.setInputType(1);
                    this.iMd.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.iMC;
                    this.iMd.setInputType(131072);
                    this.iMd.setFilters(new InputFilter[]{new a(100)});
                    this.iMd.setSingleLine(false);
                    this.iMd.setHorizontallyScrolling(false);
                    this.iMd.setGravity(51);
                    this.iMd.setPadding(this.iMx, this.iMx, this.iMx, this.iMx);
                    i = i3;
                    break;
                case 5:
                    i = this.iMA;
                    this.iMd.setInputType(2);
                    this.iMd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iJy != null) {
                        this.iMe.setVisibility(0);
                        this.iMe.au(this.iMs);
                        this.iMe.a(dVar.iJy);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iMe.getLayoutParams();
                        marginLayoutParams.topMargin = this.iMy;
                        marginLayoutParams.height = this.iMA;
                        this.iMe.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cgr() {
                                EditView.this.iMe.setVerificationInfo(((Object) EditView.this.iMd.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iMd.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.iMd.setLayoutParams(layoutParams2);
            }
            this.iMd.setHint(dVar.content);
            this.iMf = dVar.iJx;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iMd.setPadding(this.iMx, 0, 0, 0);
        this.iMd.setText("");
        this.iMd.setGravity(19);
        this.iMd.setSingleLine(true);
        this.iMd.setHorizontallyScrolling(true);
        this.iMd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.iMe.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cgo() {
        if (TextUtils.isEmpty(this.iMf)) {
            return true;
        }
        Editable text = this.iMd.getText();
        if (text != null) {
            this.iMg = text.toString().trim();
        }
        return Pattern.matches(this.iMf, this.iMg);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iMg;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int iMi;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.iMi = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + CK(spanned.toString());
            int length2 = charSequence.toString().length() + CK(charSequence.toString());
            if (length + length2 > this.iMi) {
                int i5 = this.iMi - length;
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
