package com.baidu.tieba.recapp.lego.view.form;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class d extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int asI;
    private int asJ;
    private int asK;
    private int asL;
    private int asM;
    private TextView efg;
    private String gFM;
    private ImageView gGw;
    private String[] gGx;
    private DialogInterface.OnClickListener gGy;
    private String mContent;
    private int mType;

    public d(Context context) {
        super(context);
        this.efg = null;
        this.gGw = null;
        this.mType = -1;
        this.asI = 0;
        this.asJ = 0;
        this.asK = 0;
        this.asM = 0;
        this.asL = 0;
        this.gGx = null;
        this.mContent = "";
        this.gFM = "";
        this.gGy = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                d.this.gFM = d.this.gGx[i];
                d.this.efg.setText(d.this.gFM);
            }
        };
        init();
    }

    private void init() {
        Jp();
        boP();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Jp() {
        this.efg = new TextView(this.mContext);
        this.efg.setTextSize(0, this.gGm);
        this.efg.setTextColor(this.gGl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.efg, layoutParams);
    }

    private void boP() {
        Drawable drawable = this.mResources.getDrawable(d.f.form_picker_arrow);
        this.gGw = new ImageView(this.mContext);
        this.gGw.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gGw, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.efg.setText(this.mContent);
            this.efg.setTextSize(0, this.gGm);
            ((ViewGroup.MarginLayoutParams) this.efg.getLayoutParams()).leftMargin = this.gGe;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gGw.getLayoutParams();
            marginLayoutParams.width = this.gGe;
            marginLayoutParams.rightMargin = this.gGe;
            switch (this.mType) {
                case 6:
                    if (eVar.gDw != null && eVar.gDw.length > 0) {
                        this.gGx = eVar.gDw;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.asI = calendar.get(1);
                    this.asJ = calendar.get(2);
                    this.asK = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.asL = calendar2.get(10);
                    this.asM = calendar2.get(12);
                    break;
                default:
                    this.asI = 0;
                    this.asJ = 0;
                    this.asK = 0;
                    this.asL = 0;
                    this.asM = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int boO() {
        return this.gGh;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.asI = datePicker.getYear();
        this.asJ = datePicker.getMonth();
        this.asK = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.asI).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.asJ + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.asK);
        this.gFM = sb.toString();
        this.efg.setText(this.gFM);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gFM = cz(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gFM)) {
                this.gFM = cz(this.asL, this.asM);
            }
            this.efg.setText(this.gFM);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.gGx != null && this.gGx.length > 0) {
                    a(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.gGx, this.gGy).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.asI, this.asJ, this.asK);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                a(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.asL));
                timePicker.setCurrentMinute(Integer.valueOf(this.asM));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                a(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(d.j.dialog_ok, this).setNegativeButton(d.j.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void a(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.d.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!d.this.boF()) {
                    d.this.a(d.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    d.this.a(d.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public boolean boF() {
        return !TextUtils.isEmpty(this.gFM);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return this.gFM;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gFM = "";
    }

    private String cz(int i, int i2) {
        this.asL = i;
        this.asM = i2;
        String num = Integer.toString(this.asM);
        String num2 = Integer.toString(this.asL);
        if (Pattern.matches("\\d", num2)) {
            num2 = "0" + num2;
        }
        if (Pattern.matches("\\d", num)) {
            num = "0" + num;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num2).append(":").append(num);
        return sb.toString();
    }
}
