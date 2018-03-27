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
    private EditText gFK;
    private f gFL;
    private String gFM;
    private String gFN;

    public b(Context context) {
        super(context);
        this.gFK = null;
        this.gFL = null;
        this.gFM = "";
        this.gFN = "";
        init();
    }

    private void init() {
        boG();
        boH();
    }

    private void boG() {
        this.gFK = new EditText(this.mContext);
        this.gFK.setId(1);
        this.gFK.setTextSize(0, this.gGn);
        this.gFK.setTextColor(this.gGl);
        this.gFK.setHintTextColor(this.gGm);
        this.gFK.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.gFK.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.b.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || b.this.boF()) {
                    b.this.a(b.this.gFK, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    b.this.a(b.this.gFK, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        a(this.gFK, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gFK, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void boH() {
        this.gFL = new f(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gGi);
        layoutParams.topMargin = this.gGg;
        layoutParams.addRule(3, this.gFK.getId());
        addView(this.gFL, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        int i;
        if (super.a(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.gFK.setTextSize(0, this.gGn);
            switch (dVar.type) {
                case 3:
                    int i2 = this.gGi;
                    this.gFK.setInputType(1);
                    this.gFK.setFilters(new InputFilter[]{new a(20)});
                    i = i2;
                    break;
                case 4:
                    int i3 = this.gGk;
                    this.gFK.setInputType(131072);
                    this.gFK.setFilters(new InputFilter[]{new a(100)});
                    this.gFK.setSingleLine(false);
                    this.gFK.setHorizontallyScrolling(false);
                    this.gFK.setGravity(51);
                    this.gFK.setPadding(this.gGf, this.gGf, this.gGf, this.gGf);
                    i = i3;
                    break;
                case 5:
                    i = this.gGi;
                    this.gFK.setInputType(2);
                    this.gFK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.gDw != null) {
                        this.gFL.setVisibility(0);
                        this.gFL.aD(this.gGa);
                        this.gFL.a(dVar.gDw);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gFL.getLayoutParams();
                        marginLayoutParams.topMargin = this.gGg;
                        marginLayoutParams.height = this.gGi;
                        this.gFL.setListener(new f.a() { // from class: com.baidu.tieba.recapp.lego.view.form.b.2
                            @Override // com.baidu.tieba.recapp.lego.view.form.f.a
                            public void boI() {
                                b.this.gFL.setVerificationInfo(((Object) b.this.gFK.getText()) + "");
                            }
                        });
                        break;
                    }
                    break;
                default:
                    return false;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFK.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i;
                this.gFK.setLayoutParams(layoutParams2);
            }
            this.gFK.setHint(dVar.content);
            this.gFM = dVar.gDv;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gFK.setPadding(this.gGf, 0, 0, 0);
        this.gFK.setText("");
        this.gFK.setGravity(19);
        this.gFK.setSingleLine(true);
        this.gFK.setHorizontallyScrolling(true);
        this.gFK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.gFL.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public boolean boF() {
        if (TextUtils.isEmpty(this.gFM)) {
            return true;
        }
        Editable text = this.gFK.getText();
        if (text != null) {
            this.gFN = text.toString().trim();
        }
        return Pattern.matches(this.gFM, this.gFN);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return this.gFN;
    }

    /* loaded from: classes3.dex */
    private class a implements InputFilter {
        int gFP;
        String regEx = "[\\u4e00-\\u9fa5]";

        public a(int i) {
            this.gFP = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.toString().length() + rS(spanned.toString());
            int length2 = charSequence.toString().length() + rS(charSequence.toString());
            if (length + length2 > this.gFP) {
                int i5 = this.gFP - length;
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
