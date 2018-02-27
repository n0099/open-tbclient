package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.tieba.recapp.lego.view.form.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b extends FormItemBaseView {
    private EditText gFu;
    private f gFv;
    private String gFw;
    private String gFx;

    public b(Context context) {
        super(context);
        this.gFu = null;
        this.gFv = null;
        this.gFw = "";
        this.gFx = "";
        init();
    }

    private void init() {
        boF();
        boG();
    }

    private void boF() {
        this.gFu = new EditText(this.mContext);
        this.gFu.setId(1);
        this.gFu.setTextSize(0, this.gFX);
        this.gFu.setTextColor(this.gFV);
        this.gFu.setHintTextColor(this.gFW);
        this.gFu.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gFu.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.b.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || b.this.boE()) {
                    b.this.a(b.this.gFu, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    b.this.a(b.this.gFu, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gFu, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gFu, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void boG() {
        this.gFv = new f(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gFS);
        layoutParams.topMargin = this.gFQ;
        layoutParams.addRule(3, this.gFu.getId());
        addView(this.gFv, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gFu.setTextSize(0, this.gFX);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gFS;
                    this.gFu.setInputType(1);
                    this.gFu.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gFU;
                    this.gFu.setInputType(131072);
                    this.gFu.setFilters(new InputFilter[]{new a(100)});
                    this.gFu.setSingleLine(false);
                    this.gFu.setHorizontallyScrolling(false);
                    this.gFu.setGravity(51);
                    this.gFu.setPadding(this.gFP, this.gFP, this.gFP, this.gFP);
                    i = i3;
                    break;
                case 5:
                    i = this.gFS;
                    this.gFu.setInputType(2);
                    this.gFu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gDg != null) {
                        this.gFv.setVisibility(0);
                        this.gFv.aD(this.gFK);
                        this.gFv.a(dVar.gDg);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gFv.getLayoutParams();
                        marginLayoutParams.topMargin = this.gFQ;
                        marginLayoutParams.height = this.gFS;
                        this.gFv.setListener(new f.a() { // from class: com.baidu.tieba.recapp.lego.view.form.b.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.f.a
                            public void boH() {
                                b.this.gFv.setVerificationInfo(((Object) b.this.gFu.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFu.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gFu.setLayoutParams(layoutParams2);
            }
            this.gFu.setHint(dVar.content);
            this.gFw = dVar.gDf;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gFu.setPadding(this.gFP, 0, 0, 0);
        this.gFu.setText("");
        this.gFu.setGravity(19);
        this.gFu.setSingleLine(true);
        this.gFu.setHorizontallyScrolling(true);
        this.gFu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gFv.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public boolean boE() {
        if (TextUtils.isEmpty(this.gFw)) {
            return true;
        }
        Editable text = this.gFu.getText();
        if (text != null) {
            this.gFx = text.toString().trim();
        }
        return Pattern.matches(this.gFw, this.gFx);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return this.gFx;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gFz;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gFz = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + rS(spanned.toString());
            int length2 = charSequence.toString().length() + rS(charSequence.toString());
            if (length + length2 > this.gFz) {
                int i5 = this.gFz - length;
                String str = "";
                int i6 = i5;
                int i7 = 0;
                while (i6 > 0) {
                    char charAt = charSequence.charAt(i7);
                    if (rT(charAt + "")) {
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

        private int rS(String str) {
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

        private boolean rT(String str) {
            return Pattern.matches(this.regEx, str);
        }
    }
}
