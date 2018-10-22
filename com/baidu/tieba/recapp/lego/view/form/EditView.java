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
    private EditText gHf;
    private VerificationCodeView gHg;
    private String gHh;
    private String gHi;

    public EditView(Context context) {
        super(context);
        this.gHf = null;
        this.gHg = null;
        this.gHh = "";
        this.gHi = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHf = null;
        this.gHg = null;
        this.gHh = "";
        this.gHi = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gHf = null;
        this.gHg = null;
        this.gHh = "";
        this.gHi = "";
        init();
    }

    private void init() {
        btM();
        btN();
    }

    private void btM() {
        this.gHf = new EditText(this.mContext);
        this.gHf.setId(1);
        this.gHf.setTextSize(0, this.mFontSize);
        this.gHf.setTextColor(this.gHG);
        this.gHf.setHintTextColor(this.gHH);
        this.gHf.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gHf.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.btL()) {
                    EditView.this.a(EditView.this.gHf, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gHf, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gHf, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gHf, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void btN() {
        this.gHg = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gHD);
        layoutParams.topMargin = this.gHB;
        layoutParams.addRule(3, this.gHf.getId());
        addView(this.gHg, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gHf.setTextSize(0, this.mFontSize);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gHD;
                    this.gHf.setInputType(1);
                    this.gHf.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gHF;
                    this.gHf.setInputType(131072);
                    this.gHf.setFilters(new InputFilter[]{new a(100)});
                    this.gHf.setSingleLine(false);
                    this.gHf.setHorizontallyScrolling(false);
                    this.gHf.setGravity(51);
                    this.gHf.setPadding(this.gHA, this.gHA, this.gHA, this.gHA);
                    i = i3;
                    break;
                case 5:
                    i = this.gHD;
                    this.gHf.setInputType(2);
                    this.gHf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gEB != null) {
                        this.gHg.setVisibility(0);
                        this.gHg.aw(this.gHv);
                        this.gHg.a(dVar.gEB);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gHg.getLayoutParams();
                        marginLayoutParams.topMargin = this.gHB;
                        marginLayoutParams.height = this.gHD;
                        this.gHg.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void btO() {
                                EditView.this.gHg.setVerificationInfo(((Object) EditView.this.gHf.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHf.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gHf.setLayoutParams(layoutParams2);
            }
            this.gHf.setHint(dVar.content);
            this.gHh = dVar.gEA;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gHf.setPadding(this.gHA, 0, 0, 0);
        this.gHf.setText("");
        this.gHf.setGravity(19);
        this.gHf.setSingleLine(true);
        this.gHf.setHorizontallyScrolling(true);
        this.gHf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gHg.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean btL() {
        if (TextUtils.isEmpty(this.gHh)) {
            return true;
        }
        Editable text = this.gHf.getText();
        if (text != null) {
            this.gHi = text.toString().trim();
        }
        return Pattern.matches(this.gHh, this.gHi);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gHi;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gHk;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gHk = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + uc(spanned.toString());
            int length2 = charSequence.toString().length() + uc(charSequence.toString());
            if (length + length2 > this.gHk) {
                int i5 = this.gHk - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (ud(charAt + "")) {
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

        private int uc(String str) {
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

        private boolean ud(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
