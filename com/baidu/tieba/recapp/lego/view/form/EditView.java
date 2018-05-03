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
    private EditText gaG;
    private VerificationCodeView gaH;
    private String gaI;
    private String gaJ;

    public EditView(Context context) {
        super(context);
        this.gaG = null;
        this.gaH = null;
        this.gaI = "";
        this.gaJ = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaG = null;
        this.gaH = null;
        this.gaI = "";
        this.gaJ = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaG = null;
        this.gaH = null;
        this.gaI = "";
        this.gaJ = "";
        init();
    }

    private void init() {
        bjM();
        bjN();
    }

    private void bjM() {
        this.gaG = new EditText(this.mContext);
        this.gaG.setId(1);
        this.gaG.setTextSize(0, this.gbj);
        this.gaG.setTextColor(this.gbh);
        this.gaG.setHintTextColor(this.gbi);
        this.gaG.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gaG.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z || EditView.this.bjL()) {
                    EditView.this.a(EditView.this.gaG, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.gaG, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gaG, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gaG, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void bjN() {
        this.gaH = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gbe);
        layoutParams.topMargin = this.gbc;
        layoutParams.addRule(3, this.gaG.getId());
        addView(this.gaH, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gaG.setTextSize(0, this.gbj);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gbe;
                    this.gaG.setInputType(1);
                    this.gaG.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gbg;
                    this.gaG.setInputType(131072);
                    this.gaG.setFilters(new InputFilter[]{new a(100)});
                    this.gaG.setSingleLine(false);
                    this.gaG.setHorizontallyScrolling(false);
                    this.gaG.setGravity(51);
                    this.gaG.setPadding(this.gbb, this.gbb, this.gbb, this.gbb);
                    i = i3;
                    break;
                case 5:
                    i = this.gbe;
                    this.gaG.setInputType(2);
                    this.gaG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.fYh != null) {
                        this.gaH.setVisibility(0);
                        this.gaH.ar(this.gaW);
                        this.gaH.a(dVar.fYh);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gaH.getLayoutParams();
                        marginLayoutParams.topMargin = this.gbc;
                        marginLayoutParams.height = this.gbe;
                        this.gaH.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void bjO() {
                                EditView.this.gaH.setVerificationInfo(((Object) EditView.this.gaG.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gaG.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gaG.setLayoutParams(layoutParams2);
            }
            this.gaG.setHint(dVar.content);
            this.gaI = dVar.fYg;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gaG.setPadding(this.gbb, 0, 0, 0);
        this.gaG.setText("");
        this.gaG.setGravity(19);
        this.gaG.setSingleLine(true);
        this.gaG.setHorizontallyScrolling(true);
        this.gaG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gaH.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bjL() {
        if (TextUtils.isEmpty(this.gaI)) {
            return true;
        }
        Editable text = this.gaG.getText();
        if (text != null) {
            this.gaJ = text.toString().trim();
        }
        return Pattern.matches(this.gaI, this.gaJ);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gaJ;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gaL;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gaL = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + rZ(spanned.toString());
            int length2 = charSequence.toString().length() + rZ(charSequence.toString());
            if (length + length2 > this.gaL) {
                int i5 = this.gaL - length;
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
