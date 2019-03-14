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
    private EditText ikQ;
    private VerificationCodeView ikR;
    private String ikS;
    private String ikT;

    public EditView(Context context) {
        super(context);
        this.ikQ = null;
        this.ikR = null;
        this.ikS = "";
        this.ikT = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ikQ = null;
        this.ikR = null;
        this.ikS = "";
        this.ikT = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ikQ = null;
        this.ikR = null;
        this.ikS = "";
        this.ikT = "";
        init();
    }

    private void init() {
        bXl();
        bXm();
    }

    private void bXl() {
        this.ikQ = new EditText(this.mContext);
        this.ikQ.setId(1);
        this.ikQ.setTextSize(0, this.alL);
        this.ikQ.setTextColor(this.ilr);
        this.ikQ.setHintTextColor(this.ils);
        this.ikQ.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.ikQ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bXk()) {
                    EditView.this.a(EditView.this.ikQ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.ikQ, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.ikQ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ikQ, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bXm() {
        this.ikR = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilo);
        layoutParams.topMargin = this.ilm;
        layoutParams.addRule(3, this.ikQ.getId());
        addView(this.ikR, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.ikQ.setTextSize(0, this.alL);
            switch (dVar.type) {
                case 3:
                    int i2 = this.ilo;
                    this.ikQ.setInputType(1);
                    this.ikQ.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.ilq;
                    this.ikQ.setInputType(131072);
                    this.ikQ.setFilters(new InputFilter[]{new a(100)});
                    this.ikQ.setSingleLine(false);
                    this.ikQ.setHorizontallyScrolling(false);
                    this.ikQ.setGravity(51);
                    this.ikQ.setPadding(this.ill, this.ill, this.ill, this.ill);
                    i = i3;
                    break;
                case 5:
                    i = this.ilo;
                    this.ikQ.setInputType(2);
                    this.ikQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iin != null) {
                        this.ikR.setVisibility(0);
                        this.ikR.aL(this.ilg);
                        this.ikR.a(dVar.iin);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ikR.getLayoutParams();
                        marginLayoutParams.topMargin = this.ilm;
                        marginLayoutParams.height = this.ilo;
                        this.ikR.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bXn() {
                                EditView.this.ikR.setVerificationInfo(((Object) EditView.this.ikQ.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ikQ.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.ikQ.setLayoutParams(layoutParams2);
            }
            this.ikQ.setHint(dVar.content);
            this.ikS = dVar.iim;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ikQ.setPadding(this.ill, 0, 0, 0);
        this.ikQ.setText("");
        this.ikQ.setGravity(19);
        this.ikQ.setSingleLine(true);
        this.ikQ.setHorizontallyScrolling(true);
        this.ikQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.ikR.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXk() {
        if (TextUtils.isEmpty(this.ikS)) {
            return true;
        }
        Editable text = this.ikQ.getText();
        if (text != null) {
            this.ikT = text.toString().trim();
        }
        return Pattern.matches(this.ikS, this.ikT);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.ikT;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int ikV;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.ikV = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + BE(spanned.toString());
            int length2 = charSequence.toString().length() + BE(charSequence.toString());
            if (length + length2 > this.ikV) {
                int i5 = this.ikV - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (BF(charAt + "")) {
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

        private int BE(String str) {
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

        private boolean BF(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
