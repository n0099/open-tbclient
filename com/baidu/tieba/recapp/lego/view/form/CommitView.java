package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes4.dex */
public class CommitView extends FormItemBaseView {
    public String A;
    public CheckBox x;
    public Button y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                CommitView.this.y.setClickable(true);
                CommitView.this.y.setBackgroundResource(R.color.form_button_bg_color_enable);
                return;
            }
            CommitView.this.y.setClickable(false);
            CommitView.this.y.setBackgroundResource(R.color.form_button_bg_color_unenable);
        }
    }

    public CommitView(Context context) {
        super(context);
        this.x = null;
        this.y = null;
        this.z = 1;
        this.A = "";
        j();
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean a() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean g(FormCard.b bVar) {
        if (super.g(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.f20418d)) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
                this.x.setTextSize(0, this.o);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.x.getLayoutParams();
                marginLayoutParams.bottomMargin = this.i;
                marginLayoutParams.height = i(this.x.getPaint(), cVar.f20418d);
                Drawable drawable = this.f20509f.getDrawable(R.drawable.form_checkbox_selector);
                int i = this.f20510g;
                drawable.setBounds(0, 0, i, i);
                this.x.setCompoundDrawables(drawable, null, null, null);
                this.x.setCompoundDrawablePadding(this.f20510g);
                this.x.setText(cVar.f20418d);
            }
            String str = cVar.f20416b;
            if (TextUtils.isEmpty(str)) {
                str = this.f20509f.getString(R.string.push_commit);
            }
            this.y.getLayoutParams().height = this.j;
            this.y.setPadding(0, 0, 0, 0);
            this.y.setTextSize(0, this.n);
            this.y.setText(str);
            this.A = cVar.f20419e;
            return true;
        }
        return false;
    }

    public Button getCommitButton() {
        return this.y;
    }

    public String getPostUrl() {
        return this.A;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public final int i(Paint paint, String str) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return fontMetricsInt.bottom - fontMetricsInt.top;
    }

    public final void j() {
        k();
        l();
        setBackgroundColor(0);
    }

    public final void k() {
        CheckBox checkBox = new CheckBox(this.f20508e, null, R.style.form_check_box_style);
        this.x = checkBox;
        checkBox.setId(this.z);
        this.x.setTextSize(0, (int) this.f20509f.getDimension(R.dimen.fontsize20));
        this.x.setTextColor(this.m);
        this.x.setGravity(19);
        this.x.setChecked(true);
        this.x.setButtonDrawable((Drawable) null);
        this.x.setOnCheckedChangeListener(new a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.i;
        addView(this.x, layoutParams);
    }

    public final void l() {
        Button button = new Button(this.f20508e);
        this.y = button;
        button.setGravity(17);
        this.y.setTextColor(this.q);
        this.y.setTextSize(0, this.n);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.j);
        layoutParams.addRule(3, this.x.getId());
        this.y.setBackgroundDrawable(this.f20509f.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.y, layoutParams);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.y.setClickable(z);
        this.x.setClickable(z);
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = null;
        this.y = null;
        this.z = 1;
        this.A = "";
        j();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = null;
        this.y = null;
        this.z = 1;
        this.A = "";
        j();
    }
}
