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
    private EditText kOq;
    private VerificationCodeView kOr;
    private String kOs;
    private String kOt;

    public EditView(Context context) {
        super(context);
        this.kOq = null;
        this.kOr = null;
        this.kOs = "";
        this.kOt = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kOq = null;
        this.kOr = null;
        this.kOs = "";
        this.kOt = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kOq = null;
        this.kOr = null;
        this.kOs = "";
        this.kOt = "";
        init();
    }

    private void init() {
        cVc();
        cVd();
    }

    private void cVc() {
        this.kOq = new EditText(this.mContext);
        this.kOq.setId(1);
        this.kOq.setTextSize(0, this.bOo);
        this.kOq.setTextColor(this.kOQ);
        this.kOq.setHintTextColor(this.kOR);
        this.kOq.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.kOq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cVb()) {
                    EditView.this.a(EditView.this.kOq, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.kOq, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.kOq, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.kOq, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cVd() {
        this.kOr = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kON);
        layoutParams.topMargin = this.kOL;
        layoutParams.addRule(3, this.kOq.getId());
        addView(this.kOr, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.kOq.setTextSize(0, this.bOo);
            switch (dVar.type) {
                case 3:
                    int i2 = this.kON;
                    this.kOq.setInputType(1);
                    this.kOq.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.kOP;
                    this.kOq.setInputType(131072);
                    this.kOq.setFilters(new InputFilter[]{new a(100)});
                    this.kOq.setSingleLine(false);
                    this.kOq.setHorizontallyScrolling(false);
                    this.kOq.setGravity(51);
                    this.kOq.setPadding(this.kOK, this.kOK, this.kOK, this.kOK);
                    i = i3;
                    break;
                case 5:
                    i = this.kON;
                    this.kOq.setInputType(2);
                    this.kOq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.kMc != null) {
                        this.kOr.setVisibility(0);
                        this.kOr.as(this.kOF);
                        this.kOr.a(dVar.kMc);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kOr.getLayoutParams();
                        marginLayoutParams.topMargin = this.kOL;
                        marginLayoutParams.height = this.kON;
                        this.kOr.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cVe() {
                                EditView.this.kOr.setVerificationInfo(((Object) EditView.this.kOq.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kOq.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.kOq.setLayoutParams(layoutParams2);
            }
            this.kOq.setHint(dVar.content);
            this.kOs = dVar.kMb;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kOq.setPadding(this.kOK, 0, 0, 0);
        this.kOq.setText("");
        this.kOq.setGravity(19);
        this.kOq.setSingleLine(true);
        this.kOq.setHorizontallyScrolling(true);
        this.kOq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.kOr.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cVb() {
        if (TextUtils.isEmpty(this.kOs)) {
            return true;
        }
        Editable text = this.kOq.getText();
        if (text != null) {
            this.kOt = text.toString().trim();
        }
        return Pattern.matches(this.kOs, this.kOt);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.kOt;
    }

    /* loaded from: classes13.dex */
    private class a implements InputFilter {
        int kOv;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.kOv = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Lq(spanned.toString());
            int length2 = charSequence.toString().length() + Lq(charSequence.toString());
            if (length + length2 > this.kOv) {
                int i5 = this.kOv - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Lr(charAt + "")) {
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

        private int Lq(String str) {
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

        private boolean Lr(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
