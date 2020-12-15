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
    private EditText mLv;
    private VerificationCodeView mLw;
    private String mLx;
    private String mLy;

    public EditView(Context context) {
        super(context);
        this.mLv = null;
        this.mLw = null;
        this.mLx = "";
        this.mLy = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLv = null;
        this.mLw = null;
        this.mLx = "";
        this.mLy = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLv = null;
        this.mLw = null;
        this.mLx = "";
        this.mLy = "";
        init();
    }

    private void init() {
        dFE();
        dFF();
    }

    private void dFE() {
        this.mLv = new EditText(this.mContext);
        this.mLv.setId(1);
        this.mLv.setTextSize(0, this.cHF);
        this.mLv.setTextColor(this.mLV);
        this.mLv.setHintTextColor(this.mLW);
        this.mLv.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mLv.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dFD()) {
                    EditView.this.a(EditView.this.mLv, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mLv, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mLv, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mLv, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dFF() {
        this.mLw = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mLS);
        layoutParams.topMargin = this.mLQ;
        layoutParams.addRule(3, this.mLv.getId());
        addView(this.mLw, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mLv.setTextSize(0, this.cHF);
            switch (dVar.type) {
                case 3:
                    int i2 = this.mLS;
                    this.mLv.setInputType(1);
                    this.mLv.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.mLU;
                    this.mLv.setInputType(131072);
                    this.mLv.setFilters(new InputFilter[]{new a(100)});
                    this.mLv.setSingleLine(false);
                    this.mLv.setHorizontallyScrolling(false);
                    this.mLv.setGravity(51);
                    this.mLv.setPadding(this.mLP, this.mLP, this.mLP, this.mLP);
                    i = i3;
                    break;
                case 5:
                    i = this.mLS;
                    this.mLv.setInputType(2);
                    this.mLv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.mJk != null) {
                        this.mLw.setVisibility(0);
                        this.mLw.aU(this.mLK);
                        this.mLw.a(dVar.mJk);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mLw.getLayoutParams();
                        marginLayoutParams.topMargin = this.mLQ;
                        marginLayoutParams.height = this.mLS;
                        this.mLw.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dFG() {
                                EditView.this.mLw.setVerificationInfo(((Object) EditView.this.mLv.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLv.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mLv.setLayoutParams(layoutParams2);
            }
            this.mLv.setHint(dVar.content);
            this.mLx = dVar.mJj;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mLv.setPadding(this.mLP, 0, 0, 0);
        this.mLv.setText("");
        this.mLv.setGravity(19);
        this.mLv.setSingleLine(true);
        this.mLv.setHorizontallyScrolling(true);
        this.mLv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mLw.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFD() {
        if (TextUtils.isEmpty(this.mLx)) {
            return true;
        }
        Editable text = this.mLv.getText();
        if (text != null) {
            this.mLy = text.toString().trim();
        }
        return Pattern.matches(this.mLx, this.mLy);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mLy;
    }

    /* loaded from: classes26.dex */
    private class a implements InputFilter {
        int mLA;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.mLA = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Sf(spanned.toString());
            int length2 = charSequence.toString().length() + Sf(charSequence.toString());
            if (length + length2 > this.mLA) {
                int i5 = this.mLA - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Sg(charAt + "")) {
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

        private int Sf(String str) {
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

        private boolean Sg(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
