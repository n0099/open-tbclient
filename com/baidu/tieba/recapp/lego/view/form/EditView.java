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
/* loaded from: classes5.dex */
public class EditView extends FormItemBaseView {
    public String A;
    public EditText x;
    public VerificationCodeView y;
    public String z;

    /* loaded from: classes5.dex */
    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z && !EditView.this.a()) {
                EditView editView = EditView.this;
                editView.c(editView.x, FormItemBaseView.DrawableType.ERROR_FRAME);
                return;
            }
            EditView editView2 = EditView.this;
            editView2.c(editView2.x, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements VerificationCodeView.c {
        public b() {
        }

        @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.c
        public void a() {
            EditView.this.y.setVerificationInfo(((Object) EditView.this.x.getText()) + "");
        }
    }

    /* loaded from: classes5.dex */
    public class c implements InputFilter {

        /* renamed from: e  reason: collision with root package name */
        public int f21054e;

        /* renamed from: f  reason: collision with root package name */
        public String f21055f = "[\\u4e00-\\u9fa5]";

        public c(int i2) {
            this.f21054e = i2;
        }

        public final int a(String str) {
            Matcher matcher = Pattern.compile(this.f21055f).matcher(str);
            int i2 = 0;
            while (matcher.find()) {
                for (int i3 = 0; i3 <= matcher.groupCount(); i3++) {
                    i2++;
                }
            }
            return i2;
        }

        public final boolean b(String str) {
            return Pattern.matches(this.f21055f, str);
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            int length = spanned.toString().length() + a(spanned.toString());
            int length2 = charSequence.toString().length() + a(charSequence.toString());
            int i6 = length + length2;
            int i7 = this.f21054e;
            if (i6 > i7) {
                int i8 = i7 - length;
                int i9 = 0;
                String str = "";
                while (i8 > 0) {
                    char charAt = charSequence.charAt(i9);
                    if (b(charAt + "")) {
                        if (length2 >= 2) {
                            str = str + charAt;
                        }
                        i8 -= 2;
                    } else {
                        str = str + charAt;
                        i8--;
                    }
                    i9++;
                }
                return str;
            }
            return charSequence;
        }
    }

    public EditView(Context context) {
        super(context);
        this.x = null;
        this.y = null;
        this.z = "";
        this.A = "";
        j();
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean a() {
        if (TextUtils.isEmpty(this.z)) {
            return true;
        }
        Editable text = this.x.getText();
        if (text != null) {
            this.A = text.toString().trim();
        }
        return Pattern.matches(this.z, this.A);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public void e() {
        this.x.setPadding(this.f21062g, 0, 0, 0);
        this.x.setText("");
        this.x.setGravity(19);
        this.x.setSingleLine(true);
        this.x.setHorizontallyScrolling(true);
        this.x.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.y.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean g(FormCard.b bVar) {
        int i2;
        if (super.g(bVar)) {
            FormCard.d dVar = (FormCard.d) bVar;
            this.x.setTextSize(0, this.n);
            int i3 = dVar.f20966a;
            if (i3 == 3) {
                i2 = this.j;
                this.x.setInputType(1);
                this.x.setFilters(new InputFilter[]{new c(20)});
            } else if (i3 == 4) {
                i2 = this.k;
                this.x.setInputType(131072);
                this.x.setFilters(new InputFilter[]{new c(100)});
                this.x.setSingleLine(false);
                this.x.setHorizontallyScrolling(false);
                this.x.setGravity(51);
                EditText editText = this.x;
                int i4 = this.f21062g;
                editText.setPadding(i4, i4, i4, i4);
            } else if (i3 != 5) {
                return false;
            } else {
                i2 = this.j;
                this.x.setInputType(2);
                this.x.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                if (dVar.f20972e != null) {
                    this.y.setVisibility(0);
                    this.y.f(this.w);
                    this.y.g(dVar.f20972e);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                    marginLayoutParams.topMargin = this.f21063h;
                    marginLayoutParams.height = this.j;
                    this.y.setListener(new b());
                }
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i2;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.height = i2;
                this.x.setLayoutParams(layoutParams2);
            }
            this.x.setHint(dVar.f20967b);
            this.z = dVar.f20971d;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        return this.A;
    }

    public final void j() {
        k();
        l();
    }

    public final void k() {
        EditText editText = new EditText(this.f21060e);
        this.x = editText;
        editText.setId(1);
        this.x.setTextSize(0, this.n);
        this.x.setTextColor(this.l);
        this.x.setHintTextColor(this.m);
        this.x.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.x.setOnFocusChangeListener(new a());
        c(this.x, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.x, new RelativeLayout.LayoutParams(-1, -2));
    }

    public final void l() {
        this.y = new VerificationCodeView(this.f21060e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.j);
        layoutParams.topMargin = this.f21063h;
        layoutParams.addRule(3, this.x.getId());
        addView(this.y, layoutParams);
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = null;
        this.y = null;
        this.z = "";
        this.A = "";
        j();
    }

    public EditView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = null;
        this.y = null;
        this.z = "";
        this.A = "";
        j();
    }
}
