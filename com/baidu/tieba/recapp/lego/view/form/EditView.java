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
    private EditText lpE;
    private VerificationCodeView lpF;
    private String lpG;
    private String lpH;

    public EditView(Context context) {
        super(context);
        this.lpE = null;
        this.lpF = null;
        this.lpG = "";
        this.lpH = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lpE = null;
        this.lpF = null;
        this.lpG = "";
        this.lpH = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lpE = null;
        this.lpF = null;
        this.lpG = "";
        this.lpH = "";
        init();
    }

    private void init() {
        dcA();
        dcB();
    }

    private void dcA() {
        this.lpE = new EditText(this.mContext);
        this.lpE.setId(1);
        this.lpE.setTextSize(0, this.bTU);
        this.lpE.setTextColor(this.lqe);
        this.lpE.setHintTextColor(this.lqf);
        this.lpE.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.lpE.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.dcz()) {
                    EditView.this.a(EditView.this.lpE, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.lpE, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.lpE, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lpE, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void dcB() {
        this.lpF = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lqb);
        layoutParams.topMargin = this.lpZ;
        layoutParams.addRule(3, this.lpE.getId());
        addView(this.lpF, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.lpE.setTextSize(0, this.bTU);
            switch (dVar.type) {
                case 3:
                    int i2 = this.lqb;
                    this.lpE.setInputType(1);
                    this.lpE.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.lqd;
                    this.lpE.setInputType(131072);
                    this.lpE.setFilters(new InputFilter[]{new a(100)});
                    this.lpE.setSingleLine(false);
                    this.lpE.setHorizontallyScrolling(false);
                    this.lpE.setGravity(51);
                    this.lpE.setPadding(this.lpY, this.lpY, this.lpY, this.lpY);
                    i = i3;
                    break;
                case 5:
                    i = this.lqb;
                    this.lpE.setInputType(2);
                    this.lpE.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.lnn != null) {
                        this.lpF.setVisibility(0);
                        this.lpF.aw(this.lpT);
                        this.lpF.a(dVar.lnn);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lpF.getLayoutParams();
                        marginLayoutParams.topMargin = this.lpZ;
                        marginLayoutParams.height = this.lqb;
                        this.lpF.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void dcC() {
                                EditView.this.lpF.setVerificationInfo(((Object) EditView.this.lpE.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lpE.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.lpE.setLayoutParams(layoutParams2);
            }
            this.lpE.setHint(dVar.content);
            this.lpG = dVar.lnm;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lpE.setPadding(this.lpY, 0, 0, 0);
        this.lpE.setText("");
        this.lpE.setGravity(19);
        this.lpE.setSingleLine(true);
        this.lpE.setHorizontallyScrolling(true);
        this.lpE.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.lpF.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dcz() {
        if (TextUtils.isEmpty(this.lpG)) {
            return true;
        }
        Editable text = this.lpE.getText();
        if (text != null) {
            this.lpH = text.toString().trim();
        }
        return Pattern.matches(this.lpG, this.lpH);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.lpH;
    }

    /* loaded from: classes20.dex */
    private class a implements InputFilter {
        int lpJ;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.lpJ = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Mz(spanned.toString());
            int length2 = charSequence.toString().length() + Mz(charSequence.toString());
            if (length + length2 > this.lpJ) {
                int i5 = this.lpJ - length;
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
