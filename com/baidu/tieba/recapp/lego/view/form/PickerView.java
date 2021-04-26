package com.baidu.tieba.recapp.lego.view.form;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class PickerView extends FormItemBaseView implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePicker.OnTimeChangedListener, DialogInterface.OnClickListener {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public String[] F;
    public String G;
    public String H;
    public DialogInterface.OnClickListener I;
    public TextView x;
    public ImageView y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            PickerView pickerView = PickerView.this;
            pickerView.H = pickerView.F[i2];
            PickerView.this.x.setText(PickerView.this.H);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (!PickerView.this.a()) {
                PickerView pickerView = PickerView.this;
                pickerView.c(pickerView, FormItemBaseView.DrawableType.ERROR_FRAME);
                return;
            }
            PickerView pickerView2 = PickerView.this;
            pickerView2.c(pickerView2, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        }
    }

    public PickerView(Context context) {
        super(context);
        this.x = null;
        this.y = null;
        this.z = -1;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = "";
        this.H = "";
        this.I = new a();
        l();
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean a() {
        return !TextUtils.isEmpty(this.H);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int b() {
        return this.j;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public void e() {
        this.H = "";
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean g(FormCard.b bVar) {
        if (super.g(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.z = eVar.f20966a;
            String str = eVar.f20967b;
            this.G = str;
            this.x.setText(str);
            this.x.setTextSize(0, this.n);
            ((ViewGroup.MarginLayoutParams) this.x.getLayoutParams()).leftMargin = this.f21062g;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
            int i2 = this.f21062g;
            marginLayoutParams.width = i2;
            marginLayoutParams.rightMargin = i2;
            int i3 = this.z;
            if (i3 == 6) {
                String[] strArr = eVar.f20973d;
                if (strArr == null || strArr.length <= 0) {
                    return false;
                }
                this.F = strArr;
            } else if (i3 == 7) {
                Calendar calendar = Calendar.getInstance();
                this.A = calendar.get(1);
                this.B = calendar.get(2);
                this.C = calendar.get(5);
            } else if (i3 != 8) {
                this.A = 0;
                this.B = 0;
                this.C = 0;
                this.E = 0;
                this.D = 0;
                return false;
            } else {
                Calendar calendar2 = Calendar.getInstance();
                this.E = calendar2.get(10);
                this.D = calendar2.get(12);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        return this.H;
    }

    public final void l() {
        n();
        m();
        setOnClickListener(this);
        c(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    public final void m() {
        Drawable drawable = this.f21061f.getDrawable(R.drawable.form_picker_arrow);
        ImageView imageView = new ImageView(this.f21060e);
        this.y = imageView;
        imageView.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.y, layoutParams);
    }

    public final void n() {
        TextView textView = new TextView(this.f21060e);
        this.x = textView;
        textView.setTextSize(0, this.n);
        this.x.setTextColor(this.m);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.x, layoutParams);
    }

    public final void o(Dialog dialog) {
        dialog.setOnDismissListener(new b());
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            if (TextUtils.isEmpty(this.H)) {
                this.H = p(this.E, this.D);
            }
            this.x.setText(this.H);
        }
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        this.A = datePicker.getYear();
        this.B = datePicker.getMonth();
        this.C = datePicker.getDayOfMonth();
        String str = this.A + "-" + (this.B + 1) + "-" + this.C;
        this.H = str;
        this.x.setText(str);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i2, int i3) {
        this.H = p(i2, i3);
    }

    public final String p(int i2, int i3) {
        this.E = i2;
        this.D = i3;
        String num = Integer.toString(i3);
        String num2 = Integer.toString(this.E);
        if (Pattern.matches("\\d", num2)) {
            num2 = "0" + num2;
        }
        if (Pattern.matches("\\d", num)) {
            num = "0" + num;
        }
        return num2 + ":" + num;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2 = this.z;
        if (i2 == 6) {
            String[] strArr = this.F;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            o(new AlertDialog.Builder(this.f21060e).setTitle(this.G).setItems(this.F, this.I).show());
        } else if (i2 == 7) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this.f21060e, this, this.A, this.B, this.C);
            datePickerDialog.getDatePicker().setDescendantFocusability(393216);
            datePickerDialog.show();
            o(datePickerDialog);
        } else if (i2 != 8) {
        } else {
            TimePicker timePicker = new TimePicker(this.f21060e);
            timePicker.setCurrentHour(Integer.valueOf(this.E));
            timePicker.setCurrentMinute(Integer.valueOf(this.D));
            timePicker.setDescendantFocusability(393216);
            timePicker.setOnTimeChangedListener(this);
            timePicker.setIs24HourView(Boolean.TRUE);
            o(new AlertDialog.Builder(this.f21060e).setView(timePicker).setPositiveButton(R.string.dialog_ok, this).setNegativeButton(R.string.dialog_cancel, this).show());
        }
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = null;
        this.y = null;
        this.z = -1;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = "";
        this.H = "";
        this.I = new a();
        l();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = null;
        this.y = null;
        this.z = -1;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = "";
        this.H = "";
        this.I = new a();
        l();
    }
}
