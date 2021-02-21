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
/* loaded from: classes8.dex */
public class EditView extends FormItemBaseView {
    private EditText mVM;
    private VerificationCodeView mVN;
    private String mVO;
    private String mVP;

    public EditView(Context context) {
        super(context);
        this.mVM = null;
        this.mVN = null;
        this.mVO = "";
        this.mVP = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVM = null;
        this.mVN = null;
        this.mVO = "";
        this.mVP = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVM = null;
        this.mVN = null;
        this.mVO = "";
        this.mVP = "";
        init();
    }

    private void init() {
        dDS();
        dDT();
    }

    private void dDS() {
        this.mVM = new EditText(this.mContext);
        this.mVM.setId(1);
        this.mVM.setTextSize(0, this.cKa);
        this.mVM.setTextColor(this.mWm);
        this.mVM.setHintTextColor(this.mWn);
        this.mVM.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mVM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dDR()) {
                    EditView.this.a(EditView.this.mVM, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mVM, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mVM, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mVM, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dDT() {
        this.mVN = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mWj);
        layoutParams.topMargin = this.mWh;
        layoutParams.addRule(3, this.mVM.getId());
        addView(this.mVN, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mVM.setTextSize(0, this.cKa);
            switch (dVar.type) {
                case 3:
                    int i2 = this.mWj;
                    this.mVM.setInputType(1);
                    this.mVM.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.mWl;
                    this.mVM.setInputType(131072);
                    this.mVM.setFilters(new InputFilter[]{new a(100)});
                    this.mVM.setSingleLine(false);
                    this.mVM.setHorizontallyScrolling(false);
                    this.mVM.setGravity(51);
                    this.mVM.setPadding(this.mWg, this.mWg, this.mWg, this.mWg);
                    i = i3;
                    break;
                case 5:
                    i = this.mWj;
                    this.mVM.setInputType(2);
                    this.mVM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.mTy != null) {
                        this.mVN.setVisibility(0);
                        this.mVN.aZ(this.mWb);
                        this.mVN.a(dVar.mTy);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mVN.getLayoutParams();
                        marginLayoutParams.topMargin = this.mWh;
                        marginLayoutParams.height = this.mWj;
                        this.mVN.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dDU() {
                                EditView.this.mVN.setVerificationInfo(((Object) EditView.this.mVM.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVM.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mVM.setLayoutParams(layoutParams2);
            }
            this.mVM.setHint(dVar.content);
            this.mVO = dVar.mTx;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mVM.setPadding(this.mWg, 0, 0, 0);
        this.mVM.setText("");
        this.mVM.setGravity(19);
        this.mVM.setSingleLine(true);
        this.mVM.setHorizontallyScrolling(true);
        this.mVM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mVN.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDR() {
        if (TextUtils.isEmpty(this.mVO)) {
            return true;
        }
        Editable text = this.mVM.getText();
        if (text != null) {
            this.mVP = text.toString().trim();
        }
        return Pattern.matches(this.mVO, this.mVP);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mVP;
    }

    /* loaded from: classes8.dex */
    private class a implements InputFilter {
        int mVR;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.mVR = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5;
            int length = spanned.toString().length() + RJ(spanned.toString());
            int length2 = charSequence.toString().length() + RJ(charSequence.toString());
            if (length + length2 > this.mVR) {
                int i6 = this.mVR - length;
                String str = "";
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (RK(charAt + "")) {
                        if (length2 >= 2) {
                            str = str + charAt;
                        }
                        i5 = i6 - 2;
                    } else {
                        str = str + charAt;
                        i5 = i6 - 1;
                    }
                    i7++;
                    i6 = i5;
                }
                return str;
            }
            return charSequence;
        }

        private int RJ(String str) {
            Matcher matcher = Pattern.compile(this.regEx).matcher(str);
            int i = 0;
            while (matcher.find()) {
                for (int i2 = 0; i2 <= matcher.groupCount(); i2++) {
                    i++;
                }
            }
            return i;
        }

        private boolean RK(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
