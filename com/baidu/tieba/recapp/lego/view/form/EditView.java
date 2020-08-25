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
/* loaded from: classes20.dex */
public class EditView extends FormItemBaseView {
    private EditText lFZ;
    private VerificationCodeView lGa;
    private String lGb;
    private String lGc;

    public EditView(Context context) {
        super(context);
        this.lFZ = null;
        this.lGa = null;
        this.lGb = "";
        this.lGc = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lFZ = null;
        this.lGa = null;
        this.lGb = "";
        this.lGc = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lFZ = null;
        this.lGa = null;
        this.lGb = "";
        this.lGc = "";
        init();
    }

    private void init() {
        dnJ();
        dnK();
    }

    private void dnJ() {
        this.lFZ = new EditText(this.mContext);
        this.lFZ.setId(1);
        this.lFZ.setTextSize(0, this.bZC);
        this.lFZ.setTextColor(this.lGz);
        this.lFZ.setHintTextColor(this.lGA);
        this.lFZ.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.lFZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dnI()) {
                    EditView.this.a(EditView.this.lFZ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.lFZ, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.lFZ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lFZ, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dnK() {
        this.lGa = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lGw);
        layoutParams.topMargin = this.lGu;
        layoutParams.addRule(3, this.lFZ.getId());
        addView(this.lGa, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.lFZ.setTextSize(0, this.bZC);
            switch (dVar.type) {
                case 3:
                    int i2 = this.lGw;
                    this.lFZ.setInputType(1);
                    this.lFZ.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.lGy;
                    this.lFZ.setInputType(131072);
                    this.lFZ.setFilters(new InputFilter[]{new a(100)});
                    this.lFZ.setSingleLine(false);
                    this.lFZ.setHorizontallyScrolling(false);
                    this.lFZ.setGravity(51);
                    this.lFZ.setPadding(this.lGt, this.lGt, this.lGt, this.lGt);
                    i = i3;
                    break;
                case 5:
                    i = this.lGw;
                    this.lFZ.setInputType(2);
                    this.lFZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.lDN != null) {
                        this.lGa.setVisibility(0);
                        this.lGa.aC(this.lGo);
                        this.lGa.a(dVar.lDN);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lGa.getLayoutParams();
                        marginLayoutParams.topMargin = this.lGu;
                        marginLayoutParams.height = this.lGw;
                        this.lGa.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dnL() {
                                EditView.this.lGa.setVerificationInfo(((Object) EditView.this.lFZ.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lFZ.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.lFZ.setLayoutParams(layoutParams2);
            }
            this.lFZ.setHint(dVar.content);
            this.lGb = dVar.lDM;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lFZ.setPadding(this.lGt, 0, 0, 0);
        this.lFZ.setText("");
        this.lFZ.setGravity(19);
        this.lFZ.setSingleLine(true);
        this.lFZ.setHorizontallyScrolling(true);
        this.lFZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.lGa.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dnI() {
        if (TextUtils.isEmpty(this.lGb)) {
            return true;
        }
        Editable text = this.lFZ.getText();
        if (text != null) {
            this.lGc = text.toString().trim();
        }
        return Pattern.matches(this.lGb, this.lGc);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.lGc;
    }

    /* loaded from: classes20.dex */
    private class a implements InputFilter {
        int lGe;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.lGe = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Px(spanned.toString());
            int length2 = charSequence.toString().length() + Px(charSequence.toString());
            if (length + length2 > this.lGe) {
                int i5 = this.lGe - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Py(charAt + "")) {
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

        private int Px(String str) {
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

        private boolean Py(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
