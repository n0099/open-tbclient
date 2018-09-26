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
    private EditText gzE;
    private VerificationCodeView gzF;
    private String gzG;
    private String gzH;

    public EditView(Context context) {
        super(context);
        this.gzE = null;
        this.gzF = null;
        this.gzG = "";
        this.gzH = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzE = null;
        this.gzF = null;
        this.gzG = "";
        this.gzH = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzE = null;
        this.gzF = null;
        this.gzG = "";
        this.gzH = "";
        init();
    }

    private void init() {
        bqx();
        bqy();
    }

    private void bqx() {
        this.gzE = new EditText(this.mContext);
        this.gzE.setId(1);
        this.gzE.setTextSize(0, this.gAh);
        this.gzE.setTextColor(this.gAf);
        this.gzE.setHintTextColor(this.gAg);
        this.gzE.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gzE.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bqw()) {
                    EditView.this.a(EditView.this.gzE, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gzE, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gzE, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gzE, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bqy() {
        this.gzF = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gAc);
        layoutParams.topMargin = this.gAa;
        layoutParams.addRule(3, this.gzE.getId());
        addView(this.gzF, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gzE.setTextSize(0, this.gAh);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gAc;
                    this.gzE.setInputType(1);
                    this.gzE.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gAe;
                    this.gzE.setInputType(131072);
                    this.gzE.setFilters(new InputFilter[]{new a(100)});
                    this.gzE.setSingleLine(false);
                    this.gzE.setHorizontallyScrolling(false);
                    this.gzE.setGravity(51);
                    this.gzE.setPadding(this.gzZ, this.gzZ, this.gzZ, this.gzZ);
                    i = i3;
                    break;
                case 5:
                    i = this.gAc;
                    this.gzE.setInputType(2);
                    this.gzE.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gxa != null) {
                        this.gzF.setVisibility(0);
                        this.gzF.av(this.gzU);
                        this.gzF.a(dVar.gxa);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gzF.getLayoutParams();
                        marginLayoutParams.topMargin = this.gAa;
                        marginLayoutParams.height = this.gAc;
                        this.gzF.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bqz() {
                                EditView.this.gzF.setVerificationInfo(((Object) EditView.this.gzE.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gzE.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gzE.setLayoutParams(layoutParams2);
            }
            this.gzE.setHint(dVar.content);
            this.gzG = dVar.gwZ;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gzE.setPadding(this.gzZ, 0, 0, 0);
        this.gzE.setText("");
        this.gzE.setGravity(19);
        this.gzE.setSingleLine(true);
        this.gzE.setHorizontallyScrolling(true);
        this.gzE.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gzF.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bqw() {
        if (TextUtils.isEmpty(this.gzG)) {
            return true;
        }
        Editable text = this.gzE.getText();
        if (text != null) {
            this.gzH = text.toString().trim();
        }
        return Pattern.matches(this.gzG, this.gzH);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gzH;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gzJ;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gzJ = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + tA(spanned.toString());
            int length2 = charSequence.toString().length() + tA(charSequence.toString());
            if (length + length2 > this.gzJ) {
                int i5 = this.gzJ - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (tB(charAt + "")) {
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

        private int tA(String str) {
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

        private boolean tB(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
