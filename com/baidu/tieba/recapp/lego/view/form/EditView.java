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
    private EditText mqW;
    private VerificationCodeView mqX;
    private String mqY;
    private String mqZ;

    public EditView(Context context) {
        super(context);
        this.mqW = null;
        this.mqX = null;
        this.mqY = "";
        this.mqZ = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mqW = null;
        this.mqX = null;
        this.mqY = "";
        this.mqZ = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mqW = null;
        this.mqX = null;
        this.mqY = "";
        this.mqZ = "";
        init();
    }

    private void init() {
        dyn();
        dyo();
    }

    private void dyn() {
        this.mqW = new EditText(this.mContext);
        this.mqW.setId(1);
        this.mqW.setTextSize(0, this.cwA);
        this.mqW.setTextColor(this.mrw);
        this.mqW.setHintTextColor(this.mrx);
        this.mqW.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mqW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dym()) {
                    EditView.this.a(EditView.this.mqW, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mqW, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mqW, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mqW, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dyo() {
        this.mqX = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mrt);
        layoutParams.topMargin = this.mrr;
        layoutParams.addRule(3, this.mqW.getId());
        addView(this.mqX, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mqW.setTextSize(0, this.cwA);
            switch (dVar.type) {
                case 3:
                    int i2 = this.mrt;
                    this.mqW.setInputType(1);
                    this.mqW.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.mrv;
                    this.mqW.setInputType(131072);
                    this.mqW.setFilters(new InputFilter[]{new a(100)});
                    this.mqW.setSingleLine(false);
                    this.mqW.setHorizontallyScrolling(false);
                    this.mqW.setGravity(51);
                    this.mqW.setPadding(this.mrq, this.mrq, this.mrq, this.mrq);
                    i = i3;
                    break;
                case 5:
                    i = this.mrt;
                    this.mqW.setInputType(2);
                    this.mqW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.moI != null) {
                        this.mqX.setVisibility(0);
                        this.mqX.aK(this.mrl);
                        this.mqX.a(dVar.moI);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mqX.getLayoutParams();
                        marginLayoutParams.topMargin = this.mrr;
                        marginLayoutParams.height = this.mrt;
                        this.mqX.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dyp() {
                                EditView.this.mqX.setVerificationInfo(((Object) EditView.this.mqW.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mqW.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mqW.setLayoutParams(layoutParams2);
            }
            this.mqW.setHint(dVar.content);
            this.mqY = dVar.moH;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mqW.setPadding(this.mrq, 0, 0, 0);
        this.mqW.setText("");
        this.mqW.setGravity(19);
        this.mqW.setSingleLine(true);
        this.mqW.setHorizontallyScrolling(true);
        this.mqW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mqX.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dym() {
        if (TextUtils.isEmpty(this.mqY)) {
            return true;
        }
        Editable text = this.mqW.getText();
        if (text != null) {
            this.mqZ = text.toString().trim();
        }
        return Pattern.matches(this.mqY, this.mqZ);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mqZ;
    }

    /* loaded from: classes26.dex */
    private class a implements InputFilter {
        int mrb;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.mrb = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Rk(spanned.toString());
            int length2 = charSequence.toString().length() + Rk(charSequence.toString());
            if (length + length2 > this.mrb) {
                int i5 = this.mrb - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Rl(charAt + "")) {
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

        private int Rk(String str) {
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

        private boolean Rl(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
