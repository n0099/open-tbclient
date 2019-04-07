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
    private EditText ikC;
    private VerificationCodeView ikD;
    private String ikE;
    private String ikF;

    public EditView(Context context) {
        super(context);
        this.ikC = null;
        this.ikD = null;
        this.ikE = "";
        this.ikF = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ikC = null;
        this.ikD = null;
        this.ikE = "";
        this.ikF = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ikC = null;
        this.ikD = null;
        this.ikE = "";
        this.ikF = "";
        init();
    }

    private void init() {
        bXh();
        bXi();
    }

    private void bXh() {
        this.ikC = new EditText(this.mContext);
        this.ikC.setId(1);
        this.ikC.setTextSize(0, this.alP);
        this.ikC.setTextColor(this.ild);
        this.ikC.setHintTextColor(this.ile);
        this.ikC.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.ikC.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bXg()) {
                    EditView.this.a(EditView.this.ikC, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.ikC, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.ikC, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ikC, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bXi() {
        this.ikD = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ila);
        layoutParams.topMargin = this.ikY;
        layoutParams.addRule(3, this.ikC.getId());
        addView(this.ikD, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.ikC.setTextSize(0, this.alP);
            switch (dVar.type) {
                case 3:
                    int i2 = this.ila;
                    this.ikC.setInputType(1);
                    this.ikC.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.ilc;
                    this.ikC.setInputType(131072);
                    this.ikC.setFilters(new InputFilter[]{new a(100)});
                    this.ikC.setSingleLine(false);
                    this.ikC.setHorizontallyScrolling(false);
                    this.ikC.setGravity(51);
                    this.ikC.setPadding(this.ikX, this.ikX, this.ikX, this.ikX);
                    i = i3;
                    break;
                case 5:
                    i = this.ila;
                    this.ikC.setInputType(2);
                    this.ikC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.ihZ != null) {
                        this.ikD.setVisibility(0);
                        this.ikD.aL(this.ikS);
                        this.ikD.a(dVar.ihZ);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ikD.getLayoutParams();
                        marginLayoutParams.topMargin = this.ikY;
                        marginLayoutParams.height = this.ila;
                        this.ikD.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bXj() {
                                EditView.this.ikD.setVerificationInfo(((Object) EditView.this.ikC.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ikC.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.ikC.setLayoutParams(layoutParams2);
            }
            this.ikC.setHint(dVar.content);
            this.ikE = dVar.ihY;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ikC.setPadding(this.ikX, 0, 0, 0);
        this.ikC.setText("");
        this.ikC.setGravity(19);
        this.ikC.setSingleLine(true);
        this.ikC.setHorizontallyScrolling(true);
        this.ikC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.ikD.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXg() {
        if (TextUtils.isEmpty(this.ikE)) {
            return true;
        }
        Editable text = this.ikC.getText();
        if (text != null) {
            this.ikF = text.toString().trim();
        }
        return Pattern.matches(this.ikE, this.ikF);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.ikF;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int ikH;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.ikH = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + BD(spanned.toString());
            int length2 = charSequence.toString().length() + BD(charSequence.toString());
            if (length + length2 > this.ikH) {
                int i5 = this.ikH - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (BE(charAt + "")) {
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

        private int BD(String str) {
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

        private boolean BE(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
