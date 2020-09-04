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
    private EditText lGm;
    private VerificationCodeView lGn;
    private String lGo;
    private String lGp;

    public EditView(Context context) {
        super(context);
        this.lGm = null;
        this.lGn = null;
        this.lGo = "";
        this.lGp = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lGm = null;
        this.lGn = null;
        this.lGo = "";
        this.lGp = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lGm = null;
        this.lGn = null;
        this.lGo = "";
        this.lGp = "";
        init();
    }

    private void init() {
        dnM();
        dnN();
    }

    private void dnM() {
        this.lGm = new EditText(this.mContext);
        this.lGm.setId(1);
        this.lGm.setTextSize(0, this.bZG);
        this.lGm.setTextColor(this.lGM);
        this.lGm.setHintTextColor(this.lGN);
        this.lGm.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.lGm.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dnL()) {
                    EditView.this.a(EditView.this.lGm, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.lGm, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.lGm, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lGm, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dnN() {
        this.lGn = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lGJ);
        layoutParams.topMargin = this.lGH;
        layoutParams.addRule(3, this.lGm.getId());
        addView(this.lGn, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.lGm.setTextSize(0, this.bZG);
            switch (dVar.type) {
                case 3:
                    int i2 = this.lGJ;
                    this.lGm.setInputType(1);
                    this.lGm.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.lGL;
                    this.lGm.setInputType(131072);
                    this.lGm.setFilters(new InputFilter[]{new a(100)});
                    this.lGm.setSingleLine(false);
                    this.lGm.setHorizontallyScrolling(false);
                    this.lGm.setGravity(51);
                    this.lGm.setPadding(this.lGG, this.lGG, this.lGG, this.lGG);
                    i = i3;
                    break;
                case 5:
                    i = this.lGJ;
                    this.lGm.setInputType(2);
                    this.lGm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.lDY != null) {
                        this.lGn.setVisibility(0);
                        this.lGn.aC(this.lGB);
                        this.lGn.a(dVar.lDY);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lGn.getLayoutParams();
                        marginLayoutParams.topMargin = this.lGH;
                        marginLayoutParams.height = this.lGJ;
                        this.lGn.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dnO() {
                                EditView.this.lGn.setVerificationInfo(((Object) EditView.this.lGm.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lGm.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.lGm.setLayoutParams(layoutParams2);
            }
            this.lGm.setHint(dVar.content);
            this.lGo = dVar.lDX;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lGm.setPadding(this.lGG, 0, 0, 0);
        this.lGm.setText("");
        this.lGm.setGravity(19);
        this.lGm.setSingleLine(true);
        this.lGm.setHorizontallyScrolling(true);
        this.lGm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.lGn.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dnL() {
        if (TextUtils.isEmpty(this.lGo)) {
            return true;
        }
        Editable text = this.lGm.getText();
        if (text != null) {
            this.lGp = text.toString().trim();
        }
        return Pattern.matches(this.lGo, this.lGp);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.lGp;
    }

    /* loaded from: classes20.dex */
    private class a implements InputFilter {
        int lGr;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.lGr = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Py(spanned.toString());
            int length2 = charSequence.toString().length() + Py(charSequence.toString());
            if (length + length2 > this.lGr) {
                int i5 = this.lGr - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Pz(charAt + "")) {
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

        private int Py(String str) {
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

        private boolean Pz(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
