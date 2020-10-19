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
    private String meA;
    private String meB;
    private EditText mey;
    private VerificationCodeView mez;

    public EditView(Context context) {
        super(context);
        this.mey = null;
        this.mez = null;
        this.meA = "";
        this.meB = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mey = null;
        this.mez = null;
        this.meA = "";
        this.meB = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mey = null;
        this.mez = null;
        this.meA = "";
        this.meB = "";
        init();
    }

    private void init() {
        dvg();
        dvh();
    }

    private void dvg() {
        this.mey = new EditText(this.mContext);
        this.mey.setId(1);
        this.mey.setTextSize(0, this.cnX);
        this.mey.setTextColor(this.meY);
        this.mey.setHintTextColor(this.meZ);
        this.mey.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mey.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dvf()) {
                    EditView.this.a(EditView.this.mey, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.mey, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.mey, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mey, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dvh() {
        this.mez = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.meV);
        layoutParams.topMargin = this.meT;
        layoutParams.addRule(3, this.mey.getId());
        addView(this.mez, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.mey.setTextSize(0, this.cnX);
            switch (dVar.type) {
                case 3:
                    int i2 = this.meV;
                    this.mey.setInputType(1);
                    this.mey.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.meX;
                    this.mey.setInputType(131072);
                    this.mey.setFilters(new InputFilter[]{new a(100)});
                    this.mey.setSingleLine(false);
                    this.mey.setHorizontallyScrolling(false);
                    this.mey.setGravity(51);
                    this.mey.setPadding(this.meS, this.meS, this.meS, this.meS);
                    i = i3;
                    break;
                case 5:
                    i = this.meV;
                    this.mey.setInputType(2);
                    this.mey.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.mcj != null) {
                        this.mez.setVisibility(0);
                        this.mez.aI(this.meN);
                        this.mez.a(dVar.mcj);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mez.getLayoutParams();
                        marginLayoutParams.topMargin = this.meT;
                        marginLayoutParams.height = this.meV;
                        this.mez.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dvi() {
                                EditView.this.mez.setVerificationInfo(((Object) EditView.this.mey.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mey.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.mey.setLayoutParams(layoutParams2);
            }
            this.mey.setHint(dVar.content);
            this.meA = dVar.mci;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mey.setPadding(this.meS, 0, 0, 0);
        this.mey.setText("");
        this.mey.setGravity(19);
        this.mey.setSingleLine(true);
        this.mey.setHorizontallyScrolling(true);
        this.mey.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mez.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dvf() {
        if (TextUtils.isEmpty(this.meA)) {
            return true;
        }
        Editable text = this.mey.getText();
        if (text != null) {
            this.meB = text.toString().trim();
        }
        return Pattern.matches(this.meA, this.meB);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.meB;
    }

    /* loaded from: classes26.dex */
    private class a implements InputFilter {
        int meD;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.meD = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + QM(spanned.toString());
            int length2 = charSequence.toString().length() + QM(charSequence.toString());
            if (length + length2 > this.meD) {
                int i5 = this.meD - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (QN(charAt + "")) {
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

        private int QM(String str) {
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

        private boolean QN(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
