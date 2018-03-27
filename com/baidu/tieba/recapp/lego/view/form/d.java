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
    private int asA;
    private int asB;
    private int asC;
    private int asD;
    private int asE;
    private TextView efk;
    private String gFN;
    private ImageView gGx;
    private String[] gGy;
    private DialogInterface.OnClickListener gGz;
    private String mContent;
    private int mType;

    public d(Context context) {
        super(context);
        this.efk = null;
        this.gGx = null;
        this.mType = -1;
        this.asA = 0;
        this.asB = 0;
        this.asC = 0;
        this.asE = 0;
        this.asD = 0;
        this.gGy = null;
        this.mContent = "";
        this.gFN = "";
        this.gGz = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                d.this.gFN = d.this.gGy[i];
                d.this.efk.setText(d.this.gFN);
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
        this.efk = new TextView(this.mContext);
        this.efk.setTextSize(0, this.gGn);
        this.efk.setTextColor(this.gGm);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.efk, layoutParams);
    }

    private void boP() {
        Drawable drawable = this.mResources.getDrawable(d.f.form_picker_arrow);
        this.gGx = new ImageView(this.mContext);
        this.gGx.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gGx, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.efk.setText(this.mContent);
            this.efk.setTextSize(0, this.gGn);
            ((ViewGroup.MarginLayoutParams) this.efk.getLayoutParams()).leftMargin = this.gGf;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gGx.getLayoutParams();
            marginLayoutParams.width = this.gGf;
            marginLayoutParams.rightMargin = this.gGf;
            switch (this.mType) {
                case 6:
                    if (eVar.gDx != null && eVar.gDx.length > 0) {
                        this.gGy = eVar.gDx;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.asA = calendar.get(1);
                    this.asB = calendar.get(2);
                    this.asC = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.asD = calendar2.get(10);
                    this.asE = calendar2.get(12);
                    break;
                default:
                    this.asA = 0;
                    this.asB = 0;
                    this.asC = 0;
                    this.asD = 0;
                    this.asE = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int boO() {
        return this.gGi;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.asA = datePicker.getYear();
        this.asB = datePicker.getMonth();
        this.asC = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.asA).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.asB + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.asC);
        this.gFN = sb.toString();
        this.efk.setText(this.gFN);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gFN = cz(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gFN)) {
                this.gFN = cz(this.asD, this.asE);
            }
            this.efk.setText(this.gFN);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.gGy != null && this.gGy.length > 0) {
                    a(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.gGy, this.gGz).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.asA, this.asB, this.asC);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                a(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.asD));
                timePicker.setCurrentMinute(Integer.valueOf(this.asE));
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
        return !TextUtils.isEmpty(this.gFN);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return this.gFN;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gFN = "";
    }

    private String cz(int i, int i2) {
        this.asD = i;
        this.asE = i2;
        String num = Integer.toString(this.asE);
        String num2 = Integer.toString(this.asD);
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
