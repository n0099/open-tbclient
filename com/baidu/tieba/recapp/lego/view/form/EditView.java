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
    private EditText gSo;
    private VerificationCodeView gSp;
    private String gSq;
    private String gSr;

    public EditView(Context context) {
        super(context);
        this.gSo = null;
        this.gSp = null;
        this.gSq = "";
        this.gSr = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gSo = null;
        this.gSp = null;
        this.gSq = "";
        this.gSr = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gSo = null;
        this.gSp = null;
        this.gSq = "";
        this.gSr = "";
        init();
    }

    private void init() {
        bvM();
        bvN();
    }

    private void bvM() {
        this.gSo = new EditText(this.mContext);
        this.gSo.setId(1);
        this.gSo.setTextSize(0, this.mFontSize);
        this.gSo.setTextColor(this.gSP);
        this.gSo.setHintTextColor(this.gSQ);
        this.gSo.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gSo.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bvL()) {
                    EditView.this.a(EditView.this.gSo, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gSo, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gSo, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gSo, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bvN() {
        this.gSp = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gSM);
        layoutParams.topMargin = this.gSK;
        layoutParams.addRule(3, this.gSo.getId());
        addView(this.gSp, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gSo.setTextSize(0, this.mFontSize);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gSM;
                    this.gSo.setInputType(1);
                    this.gSo.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gSO;
                    this.gSo.setInputType(131072);
                    this.gSo.setFilters(new InputFilter[]{new a(100)});
                    this.gSo.setSingleLine(false);
                    this.gSo.setHorizontallyScrolling(false);
                    this.gSo.setGravity(51);
                    this.gSo.setPadding(this.gSJ, this.gSJ, this.gSJ, this.gSJ);
                    i = i3;
                    break;
                case 5:
                    i = this.gSM;
                    this.gSo.setInputType(2);
                    this.gSo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gPK != null) {
                        this.gSp.setVisibility(0);
                        this.gSp.ay(this.gSE);
                        this.gSp.a(dVar.gPK);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gSp.getLayoutParams();
                        marginLayoutParams.topMargin = this.gSK;
                        marginLayoutParams.height = this.gSM;
                        this.gSp.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bvO() {
                                EditView.this.gSp.setVerificationInfo(((Object) EditView.this.gSo.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gSo.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gSo.setLayoutParams(layoutParams2);
            }
            this.gSo.setHint(dVar.content);
            this.gSq = dVar.gPJ;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gSo.setPadding(this.gSJ, 0, 0, 0);
        this.gSo.setText("");
        this.gSo.setGravity(19);
        this.gSo.setSingleLine(true);
        this.gSo.setHorizontallyScrolling(true);
        this.gSo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gSp.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bvL() {
        if (TextUtils.isEmpty(this.gSq)) {
            return true;
        }
        Editable text = this.gSo.getText();
        if (text != null) {
            this.gSr = text.toString().trim();
        }
        return Pattern.matches(this.gSq, this.gSr);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gSr;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gSt;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gSt = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + uK(spanned.toString());
            int length2 = charSequence.toString().length() + uK(charSequence.toString());
            if (length + length2 > this.gSt) {
                int i5 = this.gSt - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (uL(charAt + "")) {
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

        private int uK(String str) {
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

        private boolean uL(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
