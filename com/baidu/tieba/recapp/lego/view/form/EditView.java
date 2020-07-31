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
/* loaded from: classes20.dex */
public class EditView extends FormItemBaseView {
    private EditText lpC;
    private VerificationCodeView lpD;
    private String lpE;
    private String lpF;

    public EditView(Context context) {
        super(context);
        this.lpC = null;
        this.lpD = null;
        this.lpE = "";
        this.lpF = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lpC = null;
        this.lpD = null;
        this.lpE = "";
        this.lpF = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lpC = null;
        this.lpD = null;
        this.lpE = "";
        this.lpF = "";
        init();
    }

    private void init() {
        dcA();
        dcB();
    }

    private void dcA() {
        this.lpC = new EditText(this.mContext);
        this.lpC.setId(1);
        this.lpC.setTextSize(0, this.bTU);
        this.lpC.setTextColor(this.lqc);
        this.lpC.setHintTextColor(this.lqd);
        this.lpC.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.lpC.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dcz()) {
                    EditView.this.a(EditView.this.lpC, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.lpC, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.lpC, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lpC, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dcB() {
        this.lpD = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lpZ);
        layoutParams.topMargin = this.lpX;
        layoutParams.addRule(3, this.lpC.getId());
        addView(this.lpD, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.lpC.setTextSize(0, this.bTU);
            switch (dVar.type) {
                case 3:
                    int i2 = this.lpZ;
                    this.lpC.setInputType(1);
                    this.lpC.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.lqb;
                    this.lpC.setInputType(131072);
                    this.lpC.setFilters(new InputFilter[]{new a(100)});
                    this.lpC.setSingleLine(false);
                    this.lpC.setHorizontallyScrolling(false);
                    this.lpC.setGravity(51);
                    this.lpC.setPadding(this.lpW, this.lpW, this.lpW, this.lpW);
                    i = i3;
                    break;
                case 5:
                    i = this.lpZ;
                    this.lpC.setInputType(2);
                    this.lpC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.lnl != null) {
                        this.lpD.setVisibility(0);
                        this.lpD.aw(this.lpR);
                        this.lpD.a(dVar.lnl);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lpD.getLayoutParams();
                        marginLayoutParams.topMargin = this.lpX;
                        marginLayoutParams.height = this.lpZ;
                        this.lpD.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dcC() {
                                EditView.this.lpD.setVerificationInfo(((Object) EditView.this.lpC.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lpC.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.lpC.setLayoutParams(layoutParams2);
            }
            this.lpC.setHint(dVar.content);
            this.lpE = dVar.lnk;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lpC.setPadding(this.lpW, 0, 0, 0);
        this.lpC.setText("");
        this.lpC.setGravity(19);
        this.lpC.setSingleLine(true);
        this.lpC.setHorizontallyScrolling(true);
        this.lpC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.lpD.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dcz() {
        if (TextUtils.isEmpty(this.lpE)) {
            return true;
        }
        Editable text = this.lpC.getText();
        if (text != null) {
            this.lpF = text.toString().trim();
        }
        return Pattern.matches(this.lpE, this.lpF);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.lpF;
    }

    /* loaded from: classes20.dex */
    private class a implements InputFilter {
        int lpH;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.lpH = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Mz(spanned.toString());
            int length2 = charSequence.toString().length() + Mz(charSequence.toString());
            if (length + length2 > this.lpH) {
                int i5 = this.lpH - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (MA(charAt + "")) {
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

        private int Mz(String str) {
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

        private boolean MA(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
