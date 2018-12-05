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
    private EditText gPw;
    private VerificationCodeView gPx;
    private String gPy;
    private String gPz;

    public EditView(Context context) {
        super(context);
        this.gPw = null;
        this.gPx = null;
        this.gPy = "";
        this.gPz = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gPw = null;
        this.gPx = null;
        this.gPy = "";
        this.gPz = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gPw = null;
        this.gPx = null;
        this.gPy = "";
        this.gPz = "";
        init();
    }

    private void init() {
        bvb();
        bvc();
    }

    private void bvb() {
        this.gPw = new EditText(this.mContext);
        this.gPw.setId(1);
        this.gPw.setTextSize(0, this.mFontSize);
        this.gPw.setTextColor(this.gPX);
        this.gPw.setHintTextColor(this.gPY);
        this.gPw.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gPw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bva()) {
                    EditView.this.a(EditView.this.gPw, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gPw, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gPw, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gPw, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bvc() {
        this.gPx = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gPU);
        layoutParams.topMargin = this.gPS;
        layoutParams.addRule(3, this.gPw.getId());
        addView(this.gPx, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gPw.setTextSize(0, this.mFontSize);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gPU;
                    this.gPw.setInputType(1);
                    this.gPw.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gPW;
                    this.gPw.setInputType(131072);
                    this.gPw.setFilters(new InputFilter[]{new a(100)});
                    this.gPw.setSingleLine(false);
                    this.gPw.setHorizontallyScrolling(false);
                    this.gPw.setGravity(51);
                    this.gPw.setPadding(this.gPR, this.gPR, this.gPR, this.gPR);
                    i = i3;
                    break;
                case 5:
                    i = this.gPU;
                    this.gPw.setInputType(2);
                    this.gPw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gMS != null) {
                        this.gPx.setVisibility(0);
                        this.gPx.ay(this.gPM);
                        this.gPx.a(dVar.gMS);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gPx.getLayoutParams();
                        marginLayoutParams.topMargin = this.gPS;
                        marginLayoutParams.height = this.gPU;
                        this.gPx.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bvd() {
                                EditView.this.gPx.setVerificationInfo(((Object) EditView.this.gPw.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPw.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gPw.setLayoutParams(layoutParams2);
            }
            this.gPw.setHint(dVar.content);
            this.gPy = dVar.gMR;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gPw.setPadding(this.gPR, 0, 0, 0);
        this.gPw.setText("");
        this.gPw.setGravity(19);
        this.gPw.setSingleLine(true);
        this.gPw.setHorizontallyScrolling(true);
        this.gPw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gPx.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bva() {
        if (TextUtils.isEmpty(this.gPy)) {
            return true;
        }
        Editable text = this.gPw.getText();
        if (text != null) {
            this.gPz = text.toString().trim();
        }
        return Pattern.matches(this.gPy, this.gPz);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gPz;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gPB;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gPB = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + uH(spanned.toString());
            int length2 = charSequence.toString().length() + uH(charSequence.toString());
            if (length + length2 > this.gPB) {
                int i5 = this.gPB - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (uI(charAt + "")) {
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

        private int uH(String str) {
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

        private boolean uI(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
