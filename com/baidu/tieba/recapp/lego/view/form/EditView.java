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
    private EditText iDs;
    private VerificationCodeView iDt;
    private String iDu;
    private String iDv;

    public EditView(Context context) {
        super(context);
        this.iDs = null;
        this.iDt = null;
        this.iDu = "";
        this.iDv = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iDs = null;
        this.iDt = null;
        this.iDu = "";
        this.iDv = "";
        init();
    }

    public EditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iDs = null;
        this.iDt = null;
        this.iDu = "";
        this.iDv = "";
        init();
    }

    private void init() {
        cfo();
        cfp();
    }

    private void cfo() {
        this.iDs = new EditText(this.mContext);
        this.iDs.setId(1);
        this.iDs.setTextSize(0, this.amc);
        this.iDs.setTextColor(this.iDT);
        this.iDs.setHintTextColor(this.iDU);
        this.iDs.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.iDs.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || EditView.this.cfn()) {
                    EditView.this.a(EditView.this.iDs, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    EditView.this.a(EditView.this.iDs, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.iDs, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iDs, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void cfp() {
        this.iDt = new VerificationCodeView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iDQ);
        layoutParams.topMargin = this.iDO;
        layoutParams.addRule(3, this.iDs.getId());
        addView(this.iDt, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.iDs.setTextSize(0, this.amc);
            switch (dVar.type) {
                case 3:
                    int i2 = this.iDQ;
                    this.iDs.setInputType(1);
                    this.iDs.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.iDS;
                    this.iDs.setInputType(131072);
                    this.iDs.setFilters(new InputFilter[]{new a(100)});
                    this.iDs.setSingleLine(false);
                    this.iDs.setHorizontallyScrolling(false);
                    this.iDs.setGravity(51);
                    this.iDs.setPadding(this.iDN, this.iDN, this.iDN, this.iDN);
                    i = i3;
                    break;
                case 5:
                    i = this.iDQ;
                    this.iDs.setInputType(2);
                    this.iDs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.iAP != null) {
                        this.iDt.setVisibility(0);
                        this.iDt.aP(this.iDI);
                        this.iDt.a(dVar.iAP);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iDt.getLayoutParams();
                        marginLayoutParams.topMargin = this.iDO;
                        marginLayoutParams.height = this.iDQ;
                        this.iDt.setListener(new VerificationCodeView.a() { // from class: com.baidu.tieba.recapp.lego.view.form.EditView.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.a
                            public void cfq() {
                                EditView.this.iDt.setVerificationInfo(((Object) EditView.this.iDs.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDs.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.iDs.setLayoutParams(layoutParams2);
            }
            this.iDs.setHint(dVar.content);
            this.iDu = dVar.iAO;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iDs.setPadding(this.iDN, 0, 0, 0);
        this.iDs.setText("");
        this.iDs.setGravity(19);
        this.iDs.setSingleLine(true);
        this.iDs.setHorizontallyScrolling(true);
        this.iDs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.iDt.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfn() {
        if (TextUtils.isEmpty(this.iDu)) {
            return true;
        }
        Editable text = this.iDs.getText();
        if (text != null) {
            this.iDv = text.toString().trim();
        }
        return Pattern.matches(this.iDu, this.iDv);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iDv;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int iDx;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.iDx = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + Db(spanned.toString());
            int length2 = charSequence.toString().length() + Db(charSequence.toString());
            if (length + length2 > this.iDx) {
                int i5 = this.iDx - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (Dc(charAt + "")) {
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

        private int Db(String str) {
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

        private boolean Dc(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
