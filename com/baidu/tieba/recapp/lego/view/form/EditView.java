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
    private EditText ikW;
    private VerificationCodeView ikX;
    private String ikY;
    private String ikZ;

    public EditView(Context context) {
        super(context);
        this.ikW = null;
        this.ikX = null;
        this.ikY = "";
        this.ikZ = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ikW = null;
        this.ikX = null;
        this.ikY = "";
        this.ikZ = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ikW = null;
        this.ikX = null;
        this.ikY = "";
        this.ikZ = "";
        init();
    }

    private void init() {
        bXi();
        bXj();
    }

    private void bXi() {
        this.ikW = new EditText(this.mContext);
        this.ikW.setId(1);
        this.ikW.setTextSize(0, this.alK);
        this.ikW.setTextColor(this.ilx);
        this.ikW.setHintTextColor(this.ily);
        this.ikW.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.ikW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bXh()) {
                    EditView.this.a(EditView.this.ikW, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.ikW, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.ikW, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ikW, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bXj() {
        this.ikX = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilu);
        layoutParams.topMargin = this.ils;
        layoutParams.addRule(3, this.ikW.getId());
        addView(this.ikX, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.ikW.setTextSize(0, this.alK);
            switch (dVar.type) {
                case 3:
                    int i2 = this.ilu;
                    this.ikW.setInputType(1);
                    this.ikW.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.ilw;
                    this.ikW.setInputType(131072);
                    this.ikW.setFilters(new InputFilter[]{new a(100)});
                    this.ikW.setSingleLine(false);
                    this.ikW.setHorizontallyScrolling(false);
                    this.ikW.setGravity(51);
                    this.ikW.setPadding(this.ilr, this.ilr, this.ilr, this.ilr);
                    i = i3;
                    break;
                case 5:
                    i = this.ilu;
                    this.ikW.setInputType(2);
                    this.ikW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iis != null) {
                        this.ikX.setVisibility(0);
                        this.ikX.aL(this.ilm);
                        this.ikX.a(dVar.iis);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ikX.getLayoutParams();
                        marginLayoutParams.topMargin = this.ils;
                        marginLayoutParams.height = this.ilu;
                        this.ikX.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bXk() {
                                EditView.this.ikX.setVerificationInfo(((Object) EditView.this.ikW.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ikW.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.ikW.setLayoutParams(layoutParams2);
            }
            this.ikW.setHint(dVar.content);
            this.ikY = dVar.iir;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ikW.setPadding(this.ilr, 0, 0, 0);
        this.ikW.setText("");
        this.ikW.setGravity(19);
        this.ikW.setSingleLine(true);
        this.ikW.setHorizontallyScrolling(true);
        this.ikW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.ikX.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXh() {
        if (TextUtils.isEmpty(this.ikY)) {
            return true;
        }
        Editable text = this.ikW.getText();
        if (text != null) {
            this.ikZ = text.toString().trim();
        }
        return Pattern.matches(this.ikY, this.ikZ);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.ikZ;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int ilb;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.ilb = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + BF(spanned.toString());
            int length2 = charSequence.toString().length() + BF(charSequence.toString());
            if (length + length2 > this.ilb) {
                int i5 = this.ilb - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (BG(charAt + "")) {
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

        private int BF(String str) {
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

        private boolean BG(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
