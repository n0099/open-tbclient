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
    private EditText mXX;
    private VerificationCodeView mXY;
    private String mXZ;
    private String mYa;

    public EditView(Context context) {
        super(context);
        this.mXX = null;
        this.mXY = null;
        this.mXZ = "";
        this.mYa = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mXX = null;
        this.mXY = null;
        this.mXZ = "";
        this.mYa = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mXX = null;
        this.mXY = null;
        this.mXZ = "";
        this.mYa = "";
        init();
    }

    private void init() {
        dEa();
        dEb();
    }

    private void dEa() {
        this.mXX = new EditText(this.mContext);
        this.mXX.setId(1);
        this.mXX.setTextSize(0, this.cLA);
        this.mXX.setTextColor(this.mYx);
        this.mXX.setHintTextColor(this.mYy);
        this.mXX.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mXX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dDZ()) {
                    EditView.this.a(EditView.this.mXX, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mXX, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mXX, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mXX, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dEb() {
        this.mXY = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mYu);
        layoutParams.topMargin = this.mYs;
        layoutParams.addRule(3, this.mXX.getId());
        addView(this.mXY, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mXX.setTextSize(0, this.cLA);
            switch (dVar.type) {
                case 3:
                    int i2 = this.mYu;
                    this.mXX.setInputType(1);
                    this.mXX.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.mYw;
                    this.mXX.setInputType(131072);
                    this.mXX.setFilters(new InputFilter[]{new a(100)});
                    this.mXX.setSingleLine(false);
                    this.mXX.setHorizontallyScrolling(false);
                    this.mXX.setGravity(51);
                    this.mXX.setPadding(this.mYr, this.mYr, this.mYr, this.mYr);
                    i = i3;
                    break;
                case 5:
                    i = this.mYu;
                    this.mXX.setInputType(2);
                    this.mXX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.mVI != null) {
                        this.mXY.setVisibility(0);
                        this.mXY.bd(this.mYm);
                        this.mXY.a(dVar.mVI);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mXY.getLayoutParams();
                        marginLayoutParams.topMargin = this.mYs;
                        marginLayoutParams.height = this.mYu;
                        this.mXY.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dEc() {
                                EditView.this.mXY.setVerificationInfo(((Object) EditView.this.mXX.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mXX.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mXX.setLayoutParams(layoutParams2);
            }
            this.mXX.setHint(dVar.content);
            this.mXZ = dVar.mVH;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mXX.setPadding(this.mYr, 0, 0, 0);
        this.mXX.setText("");
        this.mXX.setGravity(19);
        this.mXX.setSingleLine(true);
        this.mXX.setHorizontallyScrolling(true);
        this.mXX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mXY.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDZ() {
        if (TextUtils.isEmpty(this.mXZ)) {
            return true;
        }
        Editable text = this.mXX.getText();
        if (text != null) {
            this.mYa = text.toString().trim();
        }
        return Pattern.matches(this.mXZ, this.mYa);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mYa;
    }

    /* loaded from: classes7.dex */
    private class a implements InputFilter {
        int mYc;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.mYc = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5;
            int length = spanned.toString().length() + RP(spanned.toString());
            int length2 = charSequence.toString().length() + RP(charSequence.toString());
            if (length + length2 > this.mYc) {
                int i6 = this.mYc - length;
                String str = "";
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (RQ(charAt + "")) {
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

        private int RP(String str) {
            Matcher matcher = Pattern.compile(this.regEx).matcher(str);
            int i = 0;
            while (matcher.find()) {
                for (int i2 = 0; i2 <= matcher.groupCount(); i2++) {
                    i++;
                }
            }
            return i;
        }

        private boolean RQ(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
