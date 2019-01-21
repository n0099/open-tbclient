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
    private EditText gTu;
    private VerificationCodeView gTv;
    private String gTw;
    private String gTx;

    public EditView(Context context) {
        super(context);
        this.gTu = null;
        this.gTv = null;
        this.gTw = "";
        this.gTx = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gTu = null;
        this.gTv = null;
        this.gTw = "";
        this.gTx = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gTu = null;
        this.gTv = null;
        this.gTw = "";
        this.gTx = "";
        init();
    }

    private void init() {
        bwv();
        bww();
    }

    private void bwv() {
        this.gTu = new EditText(this.mContext);
        this.gTu.setId(1);
        this.gTu.setTextSize(0, this.mFontSize);
        this.gTu.setTextColor(this.gTV);
        this.gTu.setHintTextColor(this.gTW);
        this.gTu.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gTu.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bwu()) {
                    EditView.this.a(EditView.this.gTu, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gTu, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gTu, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gTu, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bww() {
        this.gTv = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gTS);
        layoutParams.topMargin = this.gTQ;
        layoutParams.addRule(3, this.gTu.getId());
        addView(this.gTv, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gTu.setTextSize(0, this.mFontSize);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gTS;
                    this.gTu.setInputType(1);
                    this.gTu.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gTU;
                    this.gTu.setInputType(131072);
                    this.gTu.setFilters(new InputFilter[]{new a(100)});
                    this.gTu.setSingleLine(false);
                    this.gTu.setHorizontallyScrolling(false);
                    this.gTu.setGravity(51);
                    this.gTu.setPadding(this.gTP, this.gTP, this.gTP, this.gTP);
                    i = i3;
                    break;
                case 5:
                    i = this.gTS;
                    this.gTu.setInputType(2);
                    this.gTu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gQO != null) {
                        this.gTv.setVisibility(0);
                        this.gTv.ay(this.gTK);
                        this.gTv.a(dVar.gQO);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gTv.getLayoutParams();
                        marginLayoutParams.topMargin = this.gTQ;
                        marginLayoutParams.height = this.gTS;
                        this.gTv.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bwx() {
                                EditView.this.gTv.setVerificationInfo(((Object) EditView.this.gTu.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTu.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gTu.setLayoutParams(layoutParams2);
            }
            this.gTu.setHint(dVar.content);
            this.gTw = dVar.gQN;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gTu.setPadding(this.gTP, 0, 0, 0);
        this.gTu.setText("");
        this.gTu.setGravity(19);
        this.gTu.setSingleLine(true);
        this.gTu.setHorizontallyScrolling(true);
        this.gTu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gTv.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bwu() {
        if (TextUtils.isEmpty(this.gTw)) {
            return true;
        }
        Editable text = this.gTu.getText();
        if (text != null) {
            this.gTx = text.toString().trim();
        }
        return Pattern.matches(this.gTw, this.gTx);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gTx;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gTz;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gTz = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + va(spanned.toString());
            int length2 = charSequence.toString().length() + va(charSequence.toString());
            if (length + length2 > this.gTz) {
                int i5 = this.gTz - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (vb(charAt + "")) {
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

        private int va(String str) {
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

        private boolean vb(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
