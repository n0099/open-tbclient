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
    private EditText gIG;
    private VerificationCodeView gIH;
    private String gII;
    private String gIJ;

    public EditView(Context context) {
        super(context);
        this.gIG = null;
        this.gIH = null;
        this.gII = "";
        this.gIJ = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIG = null;
        this.gIH = null;
        this.gII = "";
        this.gIJ = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIG = null;
        this.gIH = null;
        this.gII = "";
        this.gIJ = "";
        init();
    }

    private void init() {
        bti();
        btj();
    }

    private void bti() {
        this.gIG = new EditText(this.mContext);
        this.gIG.setId(1);
        this.gIG.setTextSize(0, this.mFontSize);
        this.gIG.setTextColor(this.gJh);
        this.gIG.setHintTextColor(this.gJi);
        this.gIG.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gIG.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bth()) {
                    EditView.this.a(EditView.this.gIG, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gIG, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gIG, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gIG, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void btj() {
        this.gIH = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gJe);
        layoutParams.topMargin = this.gJc;
        layoutParams.addRule(3, this.gIG.getId());
        addView(this.gIH, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gIG.setTextSize(0, this.mFontSize);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gJe;
                    this.gIG.setInputType(1);
                    this.gIG.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gJg;
                    this.gIG.setInputType(131072);
                    this.gIG.setFilters(new InputFilter[]{new a(100)});
                    this.gIG.setSingleLine(false);
                    this.gIG.setHorizontallyScrolling(false);
                    this.gIG.setGravity(51);
                    this.gIG.setPadding(this.gJb, this.gJb, this.gJb, this.gJb);
                    i = i3;
                    break;
                case 5:
                    i = this.gJe;
                    this.gIG.setInputType(2);
                    this.gIG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gGc != null) {
                        this.gIH.setVisibility(0);
                        this.gIH.ay(this.gIW);
                        this.gIH.a(dVar.gGc);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gIH.getLayoutParams();
                        marginLayoutParams.topMargin = this.gJc;
                        marginLayoutParams.height = this.gJe;
                        this.gIH.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void btk() {
                                EditView.this.gIH.setVerificationInfo(((Object) EditView.this.gIG.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gIG.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gIG.setLayoutParams(layoutParams2);
            }
            this.gIG.setHint(dVar.content);
            this.gII = dVar.gGb;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gIG.setPadding(this.gJb, 0, 0, 0);
        this.gIG.setText("");
        this.gIG.setGravity(19);
        this.gIG.setSingleLine(true);
        this.gIG.setHorizontallyScrolling(true);
        this.gIG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gIH.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bth() {
        if (TextUtils.isEmpty(this.gII)) {
            return true;
        }
        Editable text = this.gIG.getText();
        if (text != null) {
            this.gIJ = text.toString().trim();
        }
        return Pattern.matches(this.gII, this.gIJ);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gIJ;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gIL;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gIL = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + ug(spanned.toString());
            int length2 = charSequence.toString().length() + ug(charSequence.toString());
            if (length + length2 > this.gIL) {
                int i5 = this.gIL - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (uh(charAt + "")) {
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

        private int ug(String str) {
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

        private boolean uh(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
