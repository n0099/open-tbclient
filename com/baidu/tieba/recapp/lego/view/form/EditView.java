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
    private EditText gsh;
    private VerificationCodeView gsi;
    private String gsj;
    private String gsk;

    public EditView(Context context) {
        super(context);
        this.gsh = null;
        this.gsi = null;
        this.gsj = "";
        this.gsk = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gsh = null;
        this.gsi = null;
        this.gsj = "";
        this.gsk = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gsh = null;
        this.gsi = null;
        this.gsj = "";
        this.gsk = "";
        init();
    }

    private void init() {
        bnP();
        bnQ();
    }

    private void bnP() {
        this.gsh = new EditText(this.mContext);
        this.gsh.setId(1);
        this.gsh.setTextSize(0, this.gsK);
        this.gsh.setTextColor(this.gsI);
        this.gsh.setHintTextColor(this.gsJ);
        this.gsh.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gsh.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bnO()) {
                    EditView.this.a(EditView.this.gsh, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gsh, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gsh, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gsh, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bnQ() {
        this.gsi = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gsF);
        layoutParams.topMargin = this.gsD;
        layoutParams.addRule(3, this.gsh.getId());
        addView(this.gsi, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gsh.setTextSize(0, this.gsK);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gsF;
                    this.gsh.setInputType(1);
                    this.gsh.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gsH;
                    this.gsh.setInputType(131072);
                    this.gsh.setFilters(new InputFilter[]{new a(100)});
                    this.gsh.setSingleLine(false);
                    this.gsh.setHorizontallyScrolling(false);
                    this.gsh.setGravity(51);
                    this.gsh.setPadding(this.gsC, this.gsC, this.gsC, this.gsC);
                    i = i3;
                    break;
                case 5:
                    i = this.gsF;
                    this.gsh.setInputType(2);
                    this.gsh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gpF != null) {
                        this.gsi.setVisibility(0);
                        this.gsi.aC(this.gsx);
                        this.gsi.a(dVar.gpF);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gsi.getLayoutParams();
                        marginLayoutParams.topMargin = this.gsD;
                        marginLayoutParams.height = this.gsF;
                        this.gsi.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bnR() {
                                EditView.this.gsi.setVerificationInfo(((Object) EditView.this.gsh.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsh.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gsh.setLayoutParams(layoutParams2);
            }
            this.gsh.setHint(dVar.content);
            this.gsj = dVar.gpE;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gsh.setPadding(this.gsC, 0, 0, 0);
        this.gsh.setText("");
        this.gsh.setGravity(19);
        this.gsh.setSingleLine(true);
        this.gsh.setHorizontallyScrolling(true);
        this.gsh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gsi.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bnO() {
        if (TextUtils.isEmpty(this.gsj)) {
            return true;
        }
        Editable text = this.gsh.getText();
        if (text != null) {
            this.gsk = text.toString().trim();
        }
        return Pattern.matches(this.gsj, this.gsk);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gsk;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gsm;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gsm = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + sP(spanned.toString());
            int length2 = charSequence.toString().length() + sP(charSequence.toString());
            if (length + length2 > this.gsm) {
                int i5 = this.gsm - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (sQ(charAt + "")) {
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

        private int sP(String str) {
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

        private boolean sQ(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
