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
    private EditText gTt;
    private VerificationCodeView gTu;
    private String gTv;
    private String gTw;

    public EditView(Context context) {
        super(context);
        this.gTt = null;
        this.gTu = null;
        this.gTv = "";
        this.gTw = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gTt = null;
        this.gTu = null;
        this.gTv = "";
        this.gTw = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gTt = null;
        this.gTu = null;
        this.gTv = "";
        this.gTw = "";
        init();
    }

    private void init() {
        bwv();
        bww();
    }

    private void bwv() {
        this.gTt = new EditText(this.mContext);
        this.gTt.setId(1);
        this.gTt.setTextSize(0, this.mFontSize);
        this.gTt.setTextColor(this.gTU);
        this.gTt.setHintTextColor(this.gTV);
        this.gTt.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gTt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bwu()) {
                    EditView.this.a(EditView.this.gTt, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gTt, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gTt, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gTt, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bww() {
        this.gTu = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gTR);
        layoutParams.topMargin = this.gTP;
        layoutParams.addRule(3, this.gTt.getId());
        addView(this.gTu, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gTt.setTextSize(0, this.mFontSize);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gTR;
                    this.gTt.setInputType(1);
                    this.gTt.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gTT;
                    this.gTt.setInputType(131072);
                    this.gTt.setFilters(new InputFilter[]{new a(100)});
                    this.gTt.setSingleLine(false);
                    this.gTt.setHorizontallyScrolling(false);
                    this.gTt.setGravity(51);
                    this.gTt.setPadding(this.gTO, this.gTO, this.gTO, this.gTO);
                    i = i3;
                    break;
                case 5:
                    i = this.gTR;
                    this.gTt.setInputType(2);
                    this.gTt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gQN != null) {
                        this.gTu.setVisibility(0);
                        this.gTu.ay(this.gTJ);
                        this.gTu.a(dVar.gQN);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gTu.getLayoutParams();
                        marginLayoutParams.topMargin = this.gTP;
                        marginLayoutParams.height = this.gTR;
                        this.gTu.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bwx() {
                                EditView.this.gTu.setVerificationInfo(((Object) EditView.this.gTt.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTt.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gTt.setLayoutParams(layoutParams2);
            }
            this.gTt.setHint(dVar.content);
            this.gTv = dVar.gQM;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gTt.setPadding(this.gTO, 0, 0, 0);
        this.gTt.setText("");
        this.gTt.setGravity(19);
        this.gTt.setSingleLine(true);
        this.gTt.setHorizontallyScrolling(true);
        this.gTt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gTu.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bwu() {
        if (TextUtils.isEmpty(this.gTv)) {
            return true;
        }
        Editable text = this.gTt.getText();
        if (text != null) {
            this.gTw = text.toString().trim();
        }
        return Pattern.matches(this.gTv, this.gTw);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gTw;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gTy;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gTy = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + va(spanned.toString());
            int length2 = charSequence.toString().length() + va(charSequence.toString());
            if (length + length2 > this.gTy) {
                int i5 = this.gTy - length;
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
