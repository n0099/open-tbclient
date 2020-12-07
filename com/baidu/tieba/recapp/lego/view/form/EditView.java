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
    private EditText mLt;
    private VerificationCodeView mLu;
    private String mLv;
    private String mLw;

    public EditView(Context context) {
        super(context);
        this.mLt = null;
        this.mLu = null;
        this.mLv = "";
        this.mLw = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLt = null;
        this.mLu = null;
        this.mLv = "";
        this.mLw = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLt = null;
        this.mLu = null;
        this.mLv = "";
        this.mLw = "";
        init();
    }

    private void init() {
        dFD();
        dFE();
    }

    private void dFD() {
        this.mLt = new EditText(this.mContext);
        this.mLt.setId(1);
        this.mLt.setTextSize(0, this.cHF);
        this.mLt.setTextColor(this.mLT);
        this.mLt.setHintTextColor(this.mLU);
        this.mLt.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mLt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dFC()) {
                    EditView.this.a(EditView.this.mLt, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mLt, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mLt, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mLt, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dFE() {
        this.mLu = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mLQ);
        layoutParams.topMargin = this.mLO;
        layoutParams.addRule(3, this.mLt.getId());
        addView(this.mLu, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mLt.setTextSize(0, this.cHF);
            switch (dVar.type) {
                case 3:
                    int i2 = this.mLQ;
                    this.mLt.setInputType(1);
                    this.mLt.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.mLS;
                    this.mLt.setInputType(131072);
                    this.mLt.setFilters(new InputFilter[]{new a(100)});
                    this.mLt.setSingleLine(false);
                    this.mLt.setHorizontallyScrolling(false);
                    this.mLt.setGravity(51);
                    this.mLt.setPadding(this.mLN, this.mLN, this.mLN, this.mLN);
                    i = i3;
                    break;
                case 5:
                    i = this.mLQ;
                    this.mLt.setInputType(2);
                    this.mLt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.mJi != null) {
                        this.mLu.setVisibility(0);
                        this.mLu.aU(this.mLI);
                        this.mLu.a(dVar.mJi);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mLu.getLayoutParams();
                        marginLayoutParams.topMargin = this.mLO;
                        marginLayoutParams.height = this.mLQ;
                        this.mLu.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dFF() {
                                EditView.this.mLu.setVerificationInfo(((Object) EditView.this.mLt.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLt.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mLt.setLayoutParams(layoutParams2);
            }
            this.mLt.setHint(dVar.content);
            this.mLv = dVar.mJh;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mLt.setPadding(this.mLN, 0, 0, 0);
        this.mLt.setText("");
        this.mLt.setGravity(19);
        this.mLt.setSingleLine(true);
        this.mLt.setHorizontallyScrolling(true);
        this.mLt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mLu.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFC() {
        if (TextUtils.isEmpty(this.mLv)) {
            return true;
        }
        Editable text = this.mLt.getText();
        if (text != null) {
            this.mLw = text.toString().trim();
        }
        return Pattern.matches(this.mLv, this.mLw);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mLw;
    }

    /* loaded from: classes26.dex */
    private class a implements InputFilter {
        int mLy;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.mLy = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Sf(spanned.toString());
            int length2 = charSequence.toString().length() + Sf(charSequence.toString());
            if (length + length2 > this.mLy) {
                int i5 = this.mLy - length;
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
