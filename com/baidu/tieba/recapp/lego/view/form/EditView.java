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
/* loaded from: classes13.dex */
public class EditView extends FormItemBaseView {
    private EditText kvo;
    private VerificationCodeView kvp;
    private String kvq;
    private String kvr;

    public EditView(Context context) {
        super(context);
        this.kvo = null;
        this.kvp = null;
        this.kvq = "";
        this.kvr = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kvo = null;
        this.kvp = null;
        this.kvq = "";
        this.kvr = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kvo = null;
        this.kvp = null;
        this.kvq = "";
        this.kvr = "";
        init();
    }

    private void init() {
        cNL();
        cNM();
    }

    private void cNL() {
        this.kvo = new EditText(this.mContext);
        this.kvo.setId(1);
        this.kvo.setTextSize(0, this.bFw);
        this.kvo.setTextColor(this.kvO);
        this.kvo.setHintTextColor(this.kvP);
        this.kvo.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.kvo.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cNK()) {
                    EditView.this.a(EditView.this.kvo, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.kvo, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.kvo, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.kvo, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cNM() {
        this.kvp = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kvL);
        layoutParams.topMargin = this.kvJ;
        layoutParams.addRule(3, this.kvo.getId());
        addView(this.kvp, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.kvo.setTextSize(0, this.bFw);
            switch (dVar.type) {
                case 3:
                    int i2 = this.kvL;
                    this.kvo.setInputType(1);
                    this.kvo.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.kvN;
                    this.kvo.setInputType(131072);
                    this.kvo.setFilters(new InputFilter[]{new a(100)});
                    this.kvo.setSingleLine(false);
                    this.kvo.setHorizontallyScrolling(false);
                    this.kvo.setGravity(51);
                    this.kvo.setPadding(this.kvI, this.kvI, this.kvI, this.kvI);
                    i = i3;
                    break;
                case 5:
                    i = this.kvL;
                    this.kvo.setInputType(2);
                    this.kvo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.ksZ != null) {
                        this.kvp.setVisibility(0);
                        this.kvp.at(this.kvD);
                        this.kvp.a(dVar.ksZ);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kvp.getLayoutParams();
                        marginLayoutParams.topMargin = this.kvJ;
                        marginLayoutParams.height = this.kvL;
                        this.kvp.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cNN() {
                                EditView.this.kvp.setVerificationInfo(((Object) EditView.this.kvo.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kvo.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.kvo.setLayoutParams(layoutParams2);
            }
            this.kvo.setHint(dVar.content);
            this.kvq = dVar.ksY;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kvo.setPadding(this.kvI, 0, 0, 0);
        this.kvo.setText("");
        this.kvo.setGravity(19);
        this.kvo.setSingleLine(true);
        this.kvo.setHorizontallyScrolling(true);
        this.kvo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.kvp.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cNK() {
        if (TextUtils.isEmpty(this.kvq)) {
            return true;
        }
        Editable text = this.kvo.getText();
        if (text != null) {
            this.kvr = text.toString().trim();
        }
        return Pattern.matches(this.kvq, this.kvr);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.kvr;
    }

    /* loaded from: classes13.dex */
    private class a implements InputFilter {
        int kvt;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.kvt = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + JD(spanned.toString());
            int length2 = charSequence.toString().length() + JD(charSequence.toString());
            if (length + length2 > this.kvt) {
                int i5 = this.kvt - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (JE(charAt + "")) {
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

        private int JD(String str) {
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

        private boolean JE(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
