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
/* loaded from: classes26.dex */
public class EditView extends FormItemBaseView {
    private EditText mwT;
    private VerificationCodeView mwU;
    private String mwV;
    private String mwW;

    public EditView(Context context) {
        super(context);
        this.mwT = null;
        this.mwU = null;
        this.mwV = "";
        this.mwW = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mwT = null;
        this.mwU = null;
        this.mwV = "";
        this.mwW = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mwT = null;
        this.mwU = null;
        this.mwV = "";
        this.mwW = "";
        init();
    }

    private void init() {
        dAP();
        dAQ();
    }

    private void dAP() {
        this.mwT = new EditText(this.mContext);
        this.mwT.setId(1);
        this.mwT.setTextSize(0, this.cCt);
        this.mwT.setTextColor(this.mxt);
        this.mwT.setHintTextColor(this.mxu);
        this.mwT.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mwT.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dAO()) {
                    EditView.this.a(EditView.this.mwT, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mwT, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mwT, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mwT, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dAQ() {
        this.mwU = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mxq);
        layoutParams.topMargin = this.mxo;
        layoutParams.addRule(3, this.mwT.getId());
        addView(this.mwU, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mwT.setTextSize(0, this.cCt);
            switch (dVar.type) {
                case 3:
                    int i2 = this.mxq;
                    this.mwT.setInputType(1);
                    this.mwT.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.mxs;
                    this.mwT.setInputType(131072);
                    this.mwT.setFilters(new InputFilter[]{new a(100)});
                    this.mwT.setSingleLine(false);
                    this.mwT.setHorizontallyScrolling(false);
                    this.mwT.setGravity(51);
                    this.mwT.setPadding(this.mxn, this.mxn, this.mxn, this.mxn);
                    i = i3;
                    break;
                case 5:
                    i = this.mxq;
                    this.mwT.setInputType(2);
                    this.mwT.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.muF != null) {
                        this.mwU.setVisibility(0);
                        this.mwU.aM(this.mxi);
                        this.mwU.a(dVar.muF);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mwU.getLayoutParams();
                        marginLayoutParams.topMargin = this.mxo;
                        marginLayoutParams.height = this.mxq;
                        this.mwU.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dAR() {
                                EditView.this.mwU.setVerificationInfo(((Object) EditView.this.mwT.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mwT.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mwT.setLayoutParams(layoutParams2);
            }
            this.mwT.setHint(dVar.content);
            this.mwV = dVar.muE;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mwT.setPadding(this.mxn, 0, 0, 0);
        this.mwT.setText("");
        this.mwT.setGravity(19);
        this.mwT.setSingleLine(true);
        this.mwT.setHorizontallyScrolling(true);
        this.mwT.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mwU.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dAO() {
        if (TextUtils.isEmpty(this.mwV)) {
            return true;
        }
        Editable text = this.mwT.getText();
        if (text != null) {
            this.mwW = text.toString().trim();
        }
        return Pattern.matches(this.mwV, this.mwW);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mwW;
    }

    /* loaded from: classes26.dex */
    private class a implements InputFilter {
        int mwY;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.mwY = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + RB(spanned.toString());
            int length2 = charSequence.toString().length() + RB(charSequence.toString());
            if (length + length2 > this.mwY) {
                int i5 = this.mwY - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (RC(charAt + "")) {
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

        private int RB(String str) {
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

        private boolean RC(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
