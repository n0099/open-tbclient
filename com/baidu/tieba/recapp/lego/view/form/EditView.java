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
    private EditText mVm;
    private VerificationCodeView mVn;
    private String mVo;
    private String mVp;

    public EditView(Context context) {
        super(context);
        this.mVm = null;
        this.mVn = null;
        this.mVo = "";
        this.mVp = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVm = null;
        this.mVn = null;
        this.mVo = "";
        this.mVp = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVm = null;
        this.mVn = null;
        this.mVo = "";
        this.mVp = "";
        init();
    }

    private void init() {
        dDK();
        dDL();
    }

    private void dDK() {
        this.mVm = new EditText(this.mContext);
        this.mVm.setId(1);
        this.mVm.setTextSize(0, this.cKa);
        this.mVm.setTextColor(this.mVM);
        this.mVm.setHintTextColor(this.mVN);
        this.mVm.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mVm.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dDJ()) {
                    EditView.this.a(EditView.this.mVm, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mVm, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mVm, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mVm, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dDL() {
        this.mVn = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mVJ);
        layoutParams.topMargin = this.mVH;
        layoutParams.addRule(3, this.mVm.getId());
        addView(this.mVn, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mVm.setTextSize(0, this.cKa);
            switch (dVar.type) {
                case 3:
                    int i2 = this.mVJ;
                    this.mVm.setInputType(1);
                    this.mVm.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.mVL;
                    this.mVm.setInputType(131072);
                    this.mVm.setFilters(new InputFilter[]{new a(100)});
                    this.mVm.setSingleLine(false);
                    this.mVm.setHorizontallyScrolling(false);
                    this.mVm.setGravity(51);
                    this.mVm.setPadding(this.mVG, this.mVG, this.mVG, this.mVG);
                    i = i3;
                    break;
                case 5:
                    i = this.mVJ;
                    this.mVm.setInputType(2);
                    this.mVm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.mSW != null) {
                        this.mVn.setVisibility(0);
                        this.mVn.aZ(this.mVB);
                        this.mVn.a(dVar.mSW);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mVn.getLayoutParams();
                        marginLayoutParams.topMargin = this.mVH;
                        marginLayoutParams.height = this.mVJ;
                        this.mVn.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dDM() {
                                EditView.this.mVn.setVerificationInfo(((Object) EditView.this.mVm.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVm.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mVm.setLayoutParams(layoutParams2);
            }
            this.mVm.setHint(dVar.content);
            this.mVo = dVar.mSV;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mVm.setPadding(this.mVG, 0, 0, 0);
        this.mVm.setText("");
        this.mVm.setGravity(19);
        this.mVm.setSingleLine(true);
        this.mVm.setHorizontallyScrolling(true);
        this.mVm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mVn.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDJ() {
        if (TextUtils.isEmpty(this.mVo)) {
            return true;
        }
        Editable text = this.mVm.getText();
        if (text != null) {
            this.mVp = text.toString().trim();
        }
        return Pattern.matches(this.mVo, this.mVp);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mVp;
    }

    /* loaded from: classes8.dex */
    private class a implements InputFilter {
        int mVr;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.mVr = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5;
            int length = spanned.toString().length() + Rx(spanned.toString());
            int length2 = charSequence.toString().length() + Rx(charSequence.toString());
            if (length + length2 > this.mVr) {
                int i6 = this.mVr - length;
                String str = "";
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Ry(charAt + "")) {
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

        private int Rx(String str) {
            Matcher matcher = Pattern.compile(this.regEx).matcher(str);
            int i = 0;
            while (matcher.find()) {
                for (int i2 = 0; i2 <= matcher.groupCount(); i2++) {
                    i++;
                }
            }
            return i;
        }

        private boolean Ry(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
