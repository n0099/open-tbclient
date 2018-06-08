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
    private EditText gne;
    private VerificationCodeView gnf;
    private String gng;
    private String gnh;

    public EditView(Context context) {
        super(context);
        this.gne = null;
        this.gnf = null;
        this.gng = "";
        this.gnh = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gne = null;
        this.gnf = null;
        this.gng = "";
        this.gnh = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gne = null;
        this.gnf = null;
        this.gng = "";
        this.gnh = "";
        init();
    }

    private void init() {
        boK();
        boL();
    }

    private void boK() {
        this.gne = new EditText(this.mContext);
        this.gne.setId(1);
        this.gne.setTextSize(0, this.gnH);
        this.gne.setTextColor(this.gnF);
        this.gne.setHintTextColor(this.gnG);
        this.gne.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gne.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.boJ()) {
                    EditView.this.a(EditView.this.gne, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gne, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gne, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gne, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void boL() {
        this.gnf = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gnC);
        layoutParams.topMargin = this.gnA;
        layoutParams.addRule(3, this.gne.getId());
        addView(this.gnf, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gne.setTextSize(0, this.gnH);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gnC;
                    this.gne.setInputType(1);
                    this.gne.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gnE;
                    this.gne.setInputType(131072);
                    this.gne.setFilters(new InputFilter[]{new a(100)});
                    this.gne.setSingleLine(false);
                    this.gne.setHorizontallyScrolling(false);
                    this.gne.setGravity(51);
                    this.gne.setPadding(this.gnz, this.gnz, this.gnz, this.gnz);
                    i = i3;
                    break;
                case 5:
                    i = this.gnC;
                    this.gne.setInputType(2);
                    this.gne.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gkF != null) {
                        this.gnf.setVisibility(0);
                        this.gnf.aB(this.gnu);
                        this.gnf.a(dVar.gkF);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gnf.getLayoutParams();
                        marginLayoutParams.topMargin = this.gnA;
                        marginLayoutParams.height = this.gnC;
                        this.gnf.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void boM() {
                                EditView.this.gnf.setVerificationInfo(((Object) EditView.this.gne.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gne.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gne.setLayoutParams(layoutParams2);
            }
            this.gne.setHint(dVar.content);
            this.gng = dVar.gkE;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gne.setPadding(this.gnz, 0, 0, 0);
        this.gne.setText("");
        this.gne.setGravity(19);
        this.gne.setSingleLine(true);
        this.gne.setHorizontallyScrolling(true);
        this.gne.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gnf.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean boJ() {
        if (TextUtils.isEmpty(this.gng)) {
            return true;
        }
        Editable text = this.gne.getText();
        if (text != null) {
            this.gnh = text.toString().trim();
        }
        return Pattern.matches(this.gng, this.gnh);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gnh;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gnj;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gnj = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + sU(spanned.toString());
            int length2 = charSequence.toString().length() + sU(charSequence.toString());
            if (length + length2 > this.gnj) {
                int i5 = this.gnj - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (sV(charAt + "")) {
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

        private int sU(String str) {
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

        private boolean sV(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
