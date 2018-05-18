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
    private EditText gbM;
    private VerificationCodeView gbN;
    private String gbO;
    private String gbP;

    public EditView(Context context) {
        super(context);
        this.gbM = null;
        this.gbN = null;
        this.gbO = "";
        this.gbP = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbM = null;
        this.gbN = null;
        this.gbO = "";
        this.gbP = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbM = null;
        this.gbN = null;
        this.gbO = "";
        this.gbP = "";
        init();
    }

    private void init() {
        bjL();
        bjM();
    }

    private void bjL() {
        this.gbM = new EditText(this.mContext);
        this.gbM.setId(1);
        this.gbM.setTextSize(0, this.gcp);
        this.gbM.setTextColor(this.gcn);
        this.gbM.setHintTextColor(this.gco);
        this.gbM.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gbM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z || EditView.this.bjK()) {
                    EditView.this.a(EditView.this.gbM, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gbM, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gbM, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gbM, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bjM() {
        this.gbN = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gck);
        layoutParams.topMargin = this.gci;
        layoutParams.addRule(3, this.gbM.getId());
        addView(this.gbN, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gbM.setTextSize(0, this.gcp);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gck;
                    this.gbM.setInputType(1);
                    this.gbM.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gcm;
                    this.gbM.setInputType(131072);
                    this.gbM.setFilters(new InputFilter[]{new a(100)});
                    this.gbM.setSingleLine(false);
                    this.gbM.setHorizontallyScrolling(false);
                    this.gbM.setGravity(51);
                    this.gbM.setPadding(this.gch, this.gch, this.gch, this.gch);
                    i = i3;
                    break;
                case 5:
                    i = this.gck;
                    this.gbM.setInputType(2);
                    this.gbM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.fZn != null) {
                        this.gbN.setVisibility(0);
                        this.gbN.ar(this.gcc);
                        this.gbN.a(dVar.fZn);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gbN.getLayoutParams();
                        marginLayoutParams.topMargin = this.gci;
                        marginLayoutParams.height = this.gck;
                        this.gbN.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bjN() {
                                EditView.this.gbN.setVerificationInfo(((Object) EditView.this.gbM.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gbM.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gbM.setLayoutParams(layoutParams2);
            }
            this.gbM.setHint(dVar.content);
            this.gbO = dVar.fZm;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gbM.setPadding(this.gch, 0, 0, 0);
        this.gbM.setText("");
        this.gbM.setGravity(19);
        this.gbM.setSingleLine(true);
        this.gbM.setHorizontallyScrolling(true);
        this.gbM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gbN.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bjK() {
        if (TextUtils.isEmpty(this.gbO)) {
            return true;
        }
        Editable text = this.gbM.getText();
        if (text != null) {
            this.gbP = text.toString().trim();
        }
        return Pattern.matches(this.gbO, this.gbP);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gbP;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gbR;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gbR = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + sc(spanned.toString());
            int length2 = charSequence.toString().length() + sc(charSequence.toString());
            if (length + length2 > this.gbR) {
                int i5 = this.gbR - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (sd(charAt + "")) {
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

        private int sc(String str) {
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

        private boolean sd(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
