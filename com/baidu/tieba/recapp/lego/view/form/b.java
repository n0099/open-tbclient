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
    private EditText gFJ;
    private f gFK;
    private String gFL;
    private String gFM;

    public b(Context context) {
        super(context);
        this.gFJ = null;
        this.gFK = null;
        this.gFL = "";
        this.gFM = "";
        init();
    }

    private void init() {
        boG();
        boH();
    }

    private void boG() {
        this.gFJ = new EditText(this.mContext);
        this.gFJ.setId(1);
        this.gFJ.setTextSize(0, this.gGm);
        this.gFJ.setTextColor(this.gGk);
        this.gFJ.setHintTextColor(this.gGl);
        this.gFJ.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gFJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.b.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || b.this.boF()) {
                    b.this.a(b.this.gFJ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    b.this.a(b.this.gFJ, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gFJ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gFJ, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void boH() {
        this.gFK = new f(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gGh);
        layoutParams.topMargin = this.gGf;
        layoutParams.addRule(3, this.gFJ.getId());
        addView(this.gFK, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gFJ.setTextSize(0, this.gGm);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gGh;
                    this.gFJ.setInputType(1);
                    this.gFJ.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gGj;
                    this.gFJ.setInputType(131072);
                    this.gFJ.setFilters(new InputFilter[]{new a(100)});
                    this.gFJ.setSingleLine(false);
                    this.gFJ.setHorizontallyScrolling(false);
                    this.gFJ.setGravity(51);
                    this.gFJ.setPadding(this.gGe, this.gGe, this.gGe, this.gGe);
                    i = i3;
                    break;
                case 5:
                    i = this.gGh;
                    this.gFJ.setInputType(2);
                    this.gFJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gDv != null) {
                        this.gFK.setVisibility(0);
                        this.gFK.aD(this.gFZ);
                        this.gFK.a(dVar.gDv);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gFK.getLayoutParams();
                        marginLayoutParams.topMargin = this.gGf;
                        marginLayoutParams.height = this.gGh;
                        this.gFK.setListener(new f.a() { // from class: com.baidu.tieba.recapp.lego.view.form.b.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.f.a
                            public void boI() {
                                b.this.gFK.setVerificationInfo(((Object) b.this.gFJ.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFJ.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gFJ.setLayoutParams(layoutParams2);
            }
            this.gFJ.setHint(dVar.content);
            this.gFL = dVar.gDu;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gFJ.setPadding(this.gGe, 0, 0, 0);
        this.gFJ.setText("");
        this.gFJ.setGravity(19);
        this.gFJ.setSingleLine(true);
        this.gFJ.setHorizontallyScrolling(true);
        this.gFJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gFK.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public boolean boF() {
        if (TextUtils.isEmpty(this.gFL)) {
            return true;
        }
        Editable text = this.gFJ.getText();
        if (text != null) {
            this.gFM = text.toString().trim();
        }
        return Pattern.matches(this.gFL, this.gFM);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return this.gFM;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gFO;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gFO = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + rS(spanned.toString());
            int length2 = charSequence.toString().length() + rS(charSequence.toString());
            if (length + length2 > this.gFO) {
                int i5 = this.gFO - length;
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
