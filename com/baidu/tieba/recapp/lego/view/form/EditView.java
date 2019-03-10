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
    private EditText ikX;
    private VerificationCodeView ikY;
    private String ikZ;
    private String ila;

    public EditView(Context context) {
        super(context);
        this.ikX = null;
        this.ikY = null;
        this.ikZ = "";
        this.ila = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ikX = null;
        this.ikY = null;
        this.ikZ = "";
        this.ila = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ikX = null;
        this.ikY = null;
        this.ikZ = "";
        this.ila = "";
        init();
    }

    private void init() {
        bXj();
        bXk();
    }

    private void bXj() {
        this.ikX = new EditText(this.mContext);
        this.ikX.setId(1);
        this.ikX.setTextSize(0, this.alK);
        this.ikX.setTextColor(this.ily);
        this.ikX.setHintTextColor(this.ilz);
        this.ikX.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.ikX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bXi()) {
                    EditView.this.a(EditView.this.ikX, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.ikX, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.ikX, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ikX, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bXk() {
        this.ikY = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilv);
        layoutParams.topMargin = this.ilt;
        layoutParams.addRule(3, this.ikX.getId());
        addView(this.ikY, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.ikX.setTextSize(0, this.alK);
            switch (dVar.type) {
                case 3:
                    int i2 = this.ilv;
                    this.ikX.setInputType(1);
                    this.ikX.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.ilx;
                    this.ikX.setInputType(131072);
                    this.ikX.setFilters(new InputFilter[]{new a(100)});
                    this.ikX.setSingleLine(false);
                    this.ikX.setHorizontallyScrolling(false);
                    this.ikX.setGravity(51);
                    this.ikX.setPadding(this.ils, this.ils, this.ils, this.ils);
                    i = i3;
                    break;
                case 5:
                    i = this.ilv;
                    this.ikX.setInputType(2);
                    this.ikX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iit != null) {
                        this.ikY.setVisibility(0);
                        this.ikY.aL(this.iln);
                        this.ikY.a(dVar.iit);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ikY.getLayoutParams();
                        marginLayoutParams.topMargin = this.ilt;
                        marginLayoutParams.height = this.ilv;
                        this.ikY.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bXl() {
                                EditView.this.ikY.setVerificationInfo(((Object) EditView.this.ikX.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ikX.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.ikX.setLayoutParams(layoutParams2);
            }
            this.ikX.setHint(dVar.content);
            this.ikZ = dVar.iis;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ikX.setPadding(this.ils, 0, 0, 0);
        this.ikX.setText("");
        this.ikX.setGravity(19);
        this.ikX.setSingleLine(true);
        this.ikX.setHorizontallyScrolling(true);
        this.ikX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.ikY.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXi() {
        if (TextUtils.isEmpty(this.ikZ)) {
            return true;
        }
        Editable text = this.ikX.getText();
        if (text != null) {
            this.ila = text.toString().trim();
        }
        return Pattern.matches(this.ikZ, this.ila);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.ila;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int ilc;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.ilc = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + BG(spanned.toString());
            int length2 = charSequence.toString().length() + BG(charSequence.toString());
            if (length + length2 > this.ilc) {
                int i5 = this.ilc - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (BH(charAt + "")) {
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

        private int BG(String str) {
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

        private boolean BH(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
