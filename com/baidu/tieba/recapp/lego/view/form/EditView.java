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
    private EditText kvk;
    private VerificationCodeView kvl;
    private String kvm;
    private String kvn;

    public EditView(Context context) {
        super(context);
        this.kvk = null;
        this.kvl = null;
        this.kvm = "";
        this.kvn = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kvk = null;
        this.kvl = null;
        this.kvm = "";
        this.kvn = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kvk = null;
        this.kvl = null;
        this.kvm = "";
        this.kvn = "";
        init();
    }

    private void init() {
        cNO();
        cNP();
    }

    private void cNO() {
        this.kvk = new EditText(this.mContext);
        this.kvk.setId(1);
        this.kvk.setTextSize(0, this.bFr);
        this.kvk.setTextColor(this.kvK);
        this.kvk.setHintTextColor(this.kvL);
        this.kvk.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.kvk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cNN()) {
                    EditView.this.a(EditView.this.kvk, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.kvk, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.kvk, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.kvk, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cNP() {
        this.kvl = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kvH);
        layoutParams.topMargin = this.kvF;
        layoutParams.addRule(3, this.kvk.getId());
        addView(this.kvl, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.kvk.setTextSize(0, this.bFr);
            switch (dVar.type) {
                case 3:
                    int i2 = this.kvH;
                    this.kvk.setInputType(1);
                    this.kvk.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.kvJ;
                    this.kvk.setInputType(131072);
                    this.kvk.setFilters(new InputFilter[]{new a(100)});
                    this.kvk.setSingleLine(false);
                    this.kvk.setHorizontallyScrolling(false);
                    this.kvk.setGravity(51);
                    this.kvk.setPadding(this.kvE, this.kvE, this.kvE, this.kvE);
                    i = i3;
                    break;
                case 5:
                    i = this.kvH;
                    this.kvk.setInputType(2);
                    this.kvk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.ksV != null) {
                        this.kvl.setVisibility(0);
                        this.kvl.at(this.kvz);
                        this.kvl.a(dVar.ksV);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kvl.getLayoutParams();
                        marginLayoutParams.topMargin = this.kvF;
                        marginLayoutParams.height = this.kvH;
                        this.kvl.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cNQ() {
                                EditView.this.kvl.setVerificationInfo(((Object) EditView.this.kvk.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kvk.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.kvk.setLayoutParams(layoutParams2);
            }
            this.kvk.setHint(dVar.content);
            this.kvm = dVar.ksU;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kvk.setPadding(this.kvE, 0, 0, 0);
        this.kvk.setText("");
        this.kvk.setGravity(19);
        this.kvk.setSingleLine(true);
        this.kvk.setHorizontallyScrolling(true);
        this.kvk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.kvl.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cNN() {
        if (TextUtils.isEmpty(this.kvm)) {
            return true;
        }
        Editable text = this.kvk.getText();
        if (text != null) {
            this.kvn = text.toString().trim();
        }
        return Pattern.matches(this.kvm, this.kvn);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.kvn;
    }

    /* loaded from: classes13.dex */
    private class a implements InputFilter {
        int kvp;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.kvp = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + JA(spanned.toString());
            int length2 = charSequence.toString().length() + JA(charSequence.toString());
            if (length + length2 > this.kvp) {
                int i5 = this.kvp - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (JB(charAt + "")) {
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

        private int JA(String str) {
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

        private boolean JB(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
