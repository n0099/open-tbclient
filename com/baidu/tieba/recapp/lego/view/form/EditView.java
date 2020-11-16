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
    private EditText mxh;
    private VerificationCodeView mxi;
    private String mxj;
    private String mxk;

    public EditView(Context context) {
        super(context);
        this.mxh = null;
        this.mxi = null;
        this.mxj = "";
        this.mxk = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mxh = null;
        this.mxi = null;
        this.mxj = "";
        this.mxk = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mxh = null;
        this.mxi = null;
        this.mxj = "";
        this.mxk = "";
        init();
    }

    private void init() {
        dAm();
        dAn();
    }

    private void dAm() {
        this.mxh = new EditText(this.mContext);
        this.mxh.setId(1);
        this.mxh.setTextSize(0, this.cAJ);
        this.mxh.setTextColor(this.mxH);
        this.mxh.setHintTextColor(this.mxI);
        this.mxh.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mxh.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dAl()) {
                    EditView.this.a(EditView.this.mxh, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mxh, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mxh, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mxh, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dAn() {
        this.mxi = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mxE);
        layoutParams.topMargin = this.mxC;
        layoutParams.addRule(3, this.mxh.getId());
        addView(this.mxi, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mxh.setTextSize(0, this.cAJ);
            switch (dVar.type) {
                case 3:
                    int i2 = this.mxE;
                    this.mxh.setInputType(1);
                    this.mxh.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.mxG;
                    this.mxh.setInputType(131072);
                    this.mxh.setFilters(new InputFilter[]{new a(100)});
                    this.mxh.setSingleLine(false);
                    this.mxh.setHorizontallyScrolling(false);
                    this.mxh.setGravity(51);
                    this.mxh.setPadding(this.mxB, this.mxB, this.mxB, this.mxB);
                    i = i3;
                    break;
                case 5:
                    i = this.mxE;
                    this.mxh.setInputType(2);
                    this.mxh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.muW != null) {
                        this.mxi.setVisibility(0);
                        this.mxi.aT(this.mxw);
                        this.mxi.a(dVar.muW);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mxi.getLayoutParams();
                        marginLayoutParams.topMargin = this.mxC;
                        marginLayoutParams.height = this.mxE;
                        this.mxi.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dAo() {
                                EditView.this.mxi.setVerificationInfo(((Object) EditView.this.mxh.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mxh.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mxh.setLayoutParams(layoutParams2);
            }
            this.mxh.setHint(dVar.content);
            this.mxj = dVar.muV;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mxh.setPadding(this.mxB, 0, 0, 0);
        this.mxh.setText("");
        this.mxh.setGravity(19);
        this.mxh.setSingleLine(true);
        this.mxh.setHorizontallyScrolling(true);
        this.mxh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mxi.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dAl() {
        if (TextUtils.isEmpty(this.mxj)) {
            return true;
        }
        Editable text = this.mxh.getText();
        if (text != null) {
            this.mxk = text.toString().trim();
        }
        return Pattern.matches(this.mxj, this.mxk);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mxk;
    }

    /* loaded from: classes25.dex */
    private class a implements InputFilter {
        int mxm;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.mxm = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + QW(spanned.toString());
            int length2 = charSequence.toString().length() + QW(charSequence.toString());
            if (length + length2 > this.mxm) {
                int i5 = this.mxm - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (QX(charAt + "")) {
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

        private int QW(String str) {
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

        private boolean QX(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
