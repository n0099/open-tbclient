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
/* loaded from: classes7.dex */
public class EditView extends FormItemBaseView {
    private EditText mLX;
    private VerificationCodeView mLY;
    private String mLZ;
    private String mMa;

    public EditView(Context context) {
        super(context);
        this.mLX = null;
        this.mLY = null;
        this.mLZ = "";
        this.mMa = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLX = null;
        this.mLY = null;
        this.mLZ = "";
        this.mMa = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLX = null;
        this.mLY = null;
        this.mLZ = "";
        this.mMa = "";
        init();
    }

    private void init() {
        dBC();
        dBD();
    }

    private void dBC() {
        this.mLX = new EditText(this.mContext);
        this.mLX.setId(1);
        this.mLX.setTextSize(0, this.cHI);
        this.mLX.setTextColor(this.mMx);
        this.mLX.setHintTextColor(this.mMy);
        this.mLX.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mLX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dBB()) {
                    EditView.this.a(EditView.this.mLX, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mLX, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mLX, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mLX, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dBD() {
        this.mLY = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mMu);
        layoutParams.topMargin = this.mMs;
        layoutParams.addRule(3, this.mLX.getId());
        addView(this.mLY, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mLX.setTextSize(0, this.cHI);
            switch (dVar.type) {
                case 3:
                    int i2 = this.mMu;
                    this.mLX.setInputType(1);
                    this.mLX.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.mMw;
                    this.mLX.setInputType(131072);
                    this.mLX.setFilters(new InputFilter[]{new a(100)});
                    this.mLX.setSingleLine(false);
                    this.mLX.setHorizontallyScrolling(false);
                    this.mLX.setGravity(51);
                    this.mLX.setPadding(this.mMr, this.mMr, this.mMr, this.mMr);
                    i = i3;
                    break;
                case 5:
                    i = this.mMu;
                    this.mLX.setInputType(2);
                    this.mLX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.mJN != null) {
                        this.mLY.setVisibility(0);
                        this.mLY.aW(this.mMm);
                        this.mLY.a(dVar.mJN);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mLY.getLayoutParams();
                        marginLayoutParams.topMargin = this.mMs;
                        marginLayoutParams.height = this.mMu;
                        this.mLY.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dBE() {
                                EditView.this.mLY.setVerificationInfo(((Object) EditView.this.mLX.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLX.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mLX.setLayoutParams(layoutParams2);
            }
            this.mLX.setHint(dVar.content);
            this.mLZ = dVar.mJM;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mLX.setPadding(this.mMr, 0, 0, 0);
        this.mLX.setText("");
        this.mLX.setGravity(19);
        this.mLX.setSingleLine(true);
        this.mLX.setHorizontallyScrolling(true);
        this.mLX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mLY.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dBB() {
        if (TextUtils.isEmpty(this.mLZ)) {
            return true;
        }
        Editable text = this.mLX.getText();
        if (text != null) {
            this.mMa = text.toString().trim();
        }
        return Pattern.matches(this.mLZ, this.mMa);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mMa;
    }

    /* loaded from: classes7.dex */
    private class a implements InputFilter {
        int mMc;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.mMc = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5;
            int length = spanned.toString().length() + QB(spanned.toString());
            int length2 = charSequence.toString().length() + QB(charSequence.toString());
            if (length + length2 > this.mMc) {
                int i6 = this.mMc - length;
                String str = "";
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (QC(charAt + "")) {
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

        private int QB(String str) {
            Matcher matcher = Pattern.compile(this.regEx).matcher(str);
            int i = 0;
            while (matcher.find()) {
                for (int i2 = 0; i2 <= matcher.groupCount(); i2++) {
                    i++;
                }
            }
            return i;
        }

        private boolean QC(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
