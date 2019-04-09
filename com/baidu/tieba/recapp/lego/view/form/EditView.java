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
    private EditText ikD;
    private VerificationCodeView ikE;
    private String ikF;
    private String ikG;

    public EditView(Context context) {
        super(context);
        this.ikD = null;
        this.ikE = null;
        this.ikF = "";
        this.ikG = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ikD = null;
        this.ikE = null;
        this.ikF = "";
        this.ikG = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ikD = null;
        this.ikE = null;
        this.ikF = "";
        this.ikG = "";
        init();
    }

    private void init() {
        bXh();
        bXi();
    }

    private void bXh() {
        this.ikD = new EditText(this.mContext);
        this.ikD.setId(1);
        this.ikD.setTextSize(0, this.alQ);
        this.ikD.setTextColor(this.ile);
        this.ikD.setHintTextColor(this.ilf);
        this.ikD.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.ikD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bXg()) {
                    EditView.this.a(EditView.this.ikD, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.ikD, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.ikD, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ikD, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bXi() {
        this.ikE = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilb);
        layoutParams.topMargin = this.ikZ;
        layoutParams.addRule(3, this.ikD.getId());
        addView(this.ikE, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.ikD.setTextSize(0, this.alQ);
            switch (dVar.type) {
                case 3:
                    int i2 = this.ilb;
                    this.ikD.setInputType(1);
                    this.ikD.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.ild;
                    this.ikD.setInputType(131072);
                    this.ikD.setFilters(new InputFilter[]{new a(100)});
                    this.ikD.setSingleLine(false);
                    this.ikD.setHorizontallyScrolling(false);
                    this.ikD.setGravity(51);
                    this.ikD.setPadding(this.ikY, this.ikY, this.ikY, this.ikY);
                    i = i3;
                    break;
                case 5:
                    i = this.ilb;
                    this.ikD.setInputType(2);
                    this.ikD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iia != null) {
                        this.ikE.setVisibility(0);
                        this.ikE.aL(this.ikT);
                        this.ikE.a(dVar.iia);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ikE.getLayoutParams();
                        marginLayoutParams.topMargin = this.ikZ;
                        marginLayoutParams.height = this.ilb;
                        this.ikE.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bXj() {
                                EditView.this.ikE.setVerificationInfo(((Object) EditView.this.ikD.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ikD.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.ikD.setLayoutParams(layoutParams2);
            }
            this.ikD.setHint(dVar.content);
            this.ikF = dVar.ihZ;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ikD.setPadding(this.ikY, 0, 0, 0);
        this.ikD.setText("");
        this.ikD.setGravity(19);
        this.ikD.setSingleLine(true);
        this.ikD.setHorizontallyScrolling(true);
        this.ikD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.ikE.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXg() {
        if (TextUtils.isEmpty(this.ikF)) {
            return true;
        }
        Editable text = this.ikD.getText();
        if (text != null) {
            this.ikG = text.toString().trim();
        }
        return Pattern.matches(this.ikF, this.ikG);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.ikG;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int ikI;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.ikI = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + BD(spanned.toString());
            int length2 = charSequence.toString().length() + BD(charSequence.toString());
            if (length + length2 > this.ikI) {
                int i5 = this.ikI - length;
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
