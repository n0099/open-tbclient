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
    private int asz;
    private TextView eeU;
    private String gFx;
    private ImageView gGh;
    private String[] gGi;
    private DialogInterface.OnClickListener gGj;
    private String mContent;
    private int mType;

    public d(Context context) {
        super(context);
        this.eeU = null;
        this.gGh = null;
        this.mType = -1;
        this.asz = 0;
        this.asA = 0;
        this.asB = 0;
        this.asD = 0;
        this.asC = 0;
        this.gGi = null;
        this.mContent = "";
        this.gFx = "";
        this.gGj = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                d.this.gFx = d.this.gGi[i];
                d.this.eeU.setText(d.this.gFx);
            }
        };
        init();
    }

    private void init() {
        Jo();
        boO();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Jo() {
        this.eeU = new TextView(this.mContext);
        this.eeU.setTextSize(0, this.gFX);
        this.eeU.setTextColor(this.gFW);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.eeU, layoutParams);
    }

    private void boO() {
        Drawable drawable = this.mResources.getDrawable(d.f.form_picker_arrow);
        this.gGh = new ImageView(this.mContext);
        this.gGh.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gGh, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.eeU.setText(this.mContent);
            this.eeU.setTextSize(0, this.gFX);
            ((ViewGroup.MarginLayoutParams) this.eeU.getLayoutParams()).leftMargin = this.gFP;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gGh.getLayoutParams();
            marginLayoutParams.width = this.gFP;
            marginLayoutParams.rightMargin = this.gFP;
            switch (this.mType) {
                case 6:
                    if (eVar.gDh != null && eVar.gDh.length > 0) {
                        this.gGi = eVar.gDh;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.asz = calendar.get(1);
                    this.asA = calendar.get(2);
                    this.asB = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.asC = calendar2.get(10);
                    this.asD = calendar2.get(12);
                    break;
                default:
                    this.asz = 0;
                    this.asA = 0;
                    this.asB = 0;
                    this.asC = 0;
                    this.asD = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int boN() {
        return this.gFS;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.asz = datePicker.getYear();
        this.asA = datePicker.getMonth();
        this.asB = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.asz).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.asA + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.asB);
        this.gFx = sb.toString();
        this.eeU.setText(this.gFx);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gFx = cz(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gFx)) {
                this.gFx = cz(this.asC, this.asD);
            }
            this.eeU.setText(this.gFx);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.gGi != null && this.gGi.length > 0) {
                    a(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.gGi, this.gGj).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.asz, this.asA, this.asB);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                a(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.asC));
                timePicker.setCurrentMinute(Integer.valueOf(this.asD));
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
                if (!d.this.boE()) {
                    d.this.a(d.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    d.this.a(d.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public boolean boE() {
        return !TextUtils.isEmpty(this.gFx);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return this.gFx;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gFx = "";
    }

    private String cz(int i, int i2) {
        this.asC = i;
        this.asD = i2;
        String num = Integer.toString(this.asD);
        String num2 = Integer.toString(this.asC);
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
