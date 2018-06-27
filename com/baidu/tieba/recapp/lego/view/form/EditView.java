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
    private EditText gqV;
    private VerificationCodeView gqW;
    private String gqX;
    private String gqY;

    public EditView(Context context) {
        super(context);
        this.gqV = null;
        this.gqW = null;
        this.gqX = "";
        this.gqY = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gqV = null;
        this.gqW = null;
        this.gqX = "";
        this.gqY = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gqV = null;
        this.gqW = null;
        this.gqX = "";
        this.gqY = "";
        init();
    }

    private void init() {
        bpl();
        bpm();
    }

    private void bpl() {
        this.gqV = new EditText(this.mContext);
        this.gqV.setId(1);
        this.gqV.setTextSize(0, this.gry);
        this.gqV.setTextColor(this.grw);
        this.gqV.setHintTextColor(this.grx);
        this.gqV.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gqV.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.bpk()) {
                    EditView.this.a(EditView.this.gqV, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gqV, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gqV, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gqV, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bpm() {
        this.gqW = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.grt);
        layoutParams.topMargin = this.grr;
        layoutParams.addRule(3, this.gqV.getId());
        addView(this.gqW, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gqV.setTextSize(0, this.gry);
            switch (dVar.type) {
                case 3:
                    int i2 = this.grt;
                    this.gqV.setInputType(1);
                    this.gqV.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.grv;
                    this.gqV.setInputType(131072);
                    this.gqV.setFilters(new InputFilter[]{new a(100)});
                    this.gqV.setSingleLine(false);
                    this.gqV.setHorizontallyScrolling(false);
                    this.gqV.setGravity(51);
                    this.gqV.setPadding(this.grq, this.grq, this.grq, this.grq);
                    i = i3;
                    break;
                case 5:
                    i = this.grt;
                    this.gqV.setInputType(2);
                    this.gqV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gov != null) {
                        this.gqW.setVisibility(0);
                        this.gqW.aB(this.grl);
                        this.gqW.a(dVar.gov);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gqW.getLayoutParams();
                        marginLayoutParams.topMargin = this.grr;
                        marginLayoutParams.height = this.grt;
                        this.gqW.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bpn() {
                                EditView.this.gqW.setVerificationInfo(((Object) EditView.this.gqV.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqV.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gqV.setLayoutParams(layoutParams2);
            }
            this.gqV.setHint(dVar.content);
            this.gqX = dVar.gou;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gqV.setPadding(this.grq, 0, 0, 0);
        this.gqV.setText("");
        this.gqV.setGravity(19);
        this.gqV.setSingleLine(true);
        this.gqV.setHorizontallyScrolling(true);
        this.gqV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gqW.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bpk() {
        if (TextUtils.isEmpty(this.gqX)) {
            return true;
        }
        Editable text = this.gqV.getText();
        if (text != null) {
            this.gqY = text.toString().trim();
        }
        return Pattern.matches(this.gqX, this.gqY);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gqY;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gra;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gra = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + sT(spanned.toString());
            int length2 = charSequence.toString().length() + sT(charSequence.toString());
            if (length + length2 > this.gra) {
                int i5 = this.gra - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (sU(charAt + "")) {
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

        private int sT(String str) {
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

        private boolean sU(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
