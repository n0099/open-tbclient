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
    private EditText gsk;
    private VerificationCodeView gsl;
    private String gsm;
    private String gsn;

    public EditView(Context context) {
        super(context);
        this.gsk = null;
        this.gsl = null;
        this.gsm = "";
        this.gsn = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gsk = null;
        this.gsl = null;
        this.gsm = "";
        this.gsn = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gsk = null;
        this.gsl = null;
        this.gsm = "";
        this.gsn = "";
        init();
    }

    private void init() {
        bnQ();
        bnR();
    }

    private void bnQ() {
        this.gsk = new EditText(this.mContext);
        this.gsk.setId(1);
        this.gsk.setTextSize(0, this.gsN);
        this.gsk.setTextColor(this.gsL);
        this.gsk.setHintTextColor(this.gsM);
        this.gsk.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gsk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bnP()) {
                    EditView.this.a(EditView.this.gsk, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gsk, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gsk, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gsk, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bnR() {
        this.gsl = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gsI);
        layoutParams.topMargin = this.gsG;
        layoutParams.addRule(3, this.gsk.getId());
        addView(this.gsl, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gsk.setTextSize(0, this.gsN);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gsI;
                    this.gsk.setInputType(1);
                    this.gsk.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gsK;
                    this.gsk.setInputType(131072);
                    this.gsk.setFilters(new InputFilter[]{new a(100)});
                    this.gsk.setSingleLine(false);
                    this.gsk.setHorizontallyScrolling(false);
                    this.gsk.setGravity(51);
                    this.gsk.setPadding(this.gsF, this.gsF, this.gsF, this.gsF);
                    i = i3;
                    break;
                case 5:
                    i = this.gsI;
                    this.gsk.setInputType(2);
                    this.gsk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gpI != null) {
                        this.gsl.setVisibility(0);
                        this.gsl.aB(this.gsA);
                        this.gsl.a(dVar.gpI);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gsl.getLayoutParams();
                        marginLayoutParams.topMargin = this.gsG;
                        marginLayoutParams.height = this.gsI;
                        this.gsl.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bnS() {
                                EditView.this.gsl.setVerificationInfo(((Object) EditView.this.gsk.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsk.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gsk.setLayoutParams(layoutParams2);
            }
            this.gsk.setHint(dVar.content);
            this.gsm = dVar.gpH;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gsk.setPadding(this.gsF, 0, 0, 0);
        this.gsk.setText("");
        this.gsk.setGravity(19);
        this.gsk.setSingleLine(true);
        this.gsk.setHorizontallyScrolling(true);
        this.gsk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gsl.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bnP() {
        if (TextUtils.isEmpty(this.gsm)) {
            return true;
        }
        Editable text = this.gsk.getText();
        if (text != null) {
            this.gsn = text.toString().trim();
        }
        return Pattern.matches(this.gsm, this.gsn);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gsn;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gsp;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gsp = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + sT(spanned.toString());
            int length2 = charSequence.toString().length() + sT(charSequence.toString());
            if (length + length2 > this.gsp) {
                int i5 = this.gsp - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (sU(charAt + "")) {
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

        private int sT(String str) {
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

        private boolean sU(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
