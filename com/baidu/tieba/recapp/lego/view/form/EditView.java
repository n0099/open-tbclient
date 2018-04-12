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
    private EditText gaJ;
    private VerificationCodeView gaK;
    private String gaL;
    private String gaM;

    public EditView(Context context) {
        super(context);
        this.gaJ = null;
        this.gaK = null;
        this.gaL = "";
        this.gaM = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaJ = null;
        this.gaK = null;
        this.gaL = "";
        this.gaM = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaJ = null;
        this.gaK = null;
        this.gaL = "";
        this.gaM = "";
        init();
    }

    private void init() {
        bjM();
        bjN();
    }

    private void bjM() {
        this.gaJ = new EditText(this.mContext);
        this.gaJ.setId(1);
        this.gaJ.setTextSize(0, this.gbm);
        this.gaJ.setTextColor(this.gbk);
        this.gaJ.setHintTextColor(this.gbl);
        this.gaJ.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gaJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z || EditView.this.bjL()) {
                    EditView.this.a(EditView.this.gaJ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gaJ, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gaJ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gaJ, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bjN() {
        this.gaK = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gbh);
        layoutParams.topMargin = this.gbf;
        layoutParams.addRule(3, this.gaJ.getId());
        addView(this.gaK, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gaJ.setTextSize(0, this.gbm);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gbh;
                    this.gaJ.setInputType(1);
                    this.gaJ.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gbj;
                    this.gaJ.setInputType(131072);
                    this.gaJ.setFilters(new InputFilter[]{new a(100)});
                    this.gaJ.setSingleLine(false);
                    this.gaJ.setHorizontallyScrolling(false);
                    this.gaJ.setGravity(51);
                    this.gaJ.setPadding(this.gbe, this.gbe, this.gbe, this.gbe);
                    i = i3;
                    break;
                case 5:
                    i = this.gbh;
                    this.gaJ.setInputType(2);
                    this.gaJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.fYk != null) {
                        this.gaK.setVisibility(0);
                        this.gaK.ar(this.gaZ);
                        this.gaK.a(dVar.fYk);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gaK.getLayoutParams();
                        marginLayoutParams.topMargin = this.gbf;
                        marginLayoutParams.height = this.gbh;
                        this.gaK.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bjO() {
                                EditView.this.gaK.setVerificationInfo(((Object) EditView.this.gaJ.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gaJ.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gaJ.setLayoutParams(layoutParams2);
            }
            this.gaJ.setHint(dVar.content);
            this.gaL = dVar.fYj;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gaJ.setPadding(this.gbe, 0, 0, 0);
        this.gaJ.setText("");
        this.gaJ.setGravity(19);
        this.gaJ.setSingleLine(true);
        this.gaJ.setHorizontallyScrolling(true);
        this.gaJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gaK.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bjL() {
        if (TextUtils.isEmpty(this.gaL)) {
            return true;
        }
        Editable text = this.gaJ.getText();
        if (text != null) {
            this.gaM = text.toString().trim();
        }
        return Pattern.matches(this.gaL, this.gaM);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gaM;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gaO;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gaO = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + rZ(spanned.toString());
            int length2 = charSequence.toString().length() + rZ(charSequence.toString());
            if (length + length2 > this.gaO) {
                int i5 = this.gaO - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (sa(charAt + "")) {
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

        private int rZ(String str) {
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

        private boolean sa(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
