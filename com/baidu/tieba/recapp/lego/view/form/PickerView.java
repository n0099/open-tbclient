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
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes26.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int UR;
    private int US;
    private int UT;
    private int UU;
    private int UV;
    private TextView iJS;
    private String mContent;
    private int mType;
    private String mqZ;
    private ImageView mrG;
    private String[] mrH;
    private DialogInterface.OnClickListener mrI;

    public PickerView(Context context) {
        super(context);
        this.iJS = null;
        this.mrG = null;
        this.mType = -1;
        this.UR = 0;
        this.US = 0;
        this.UT = 0;
        this.UV = 0;
        this.UU = 0;
        this.mrH = null;
        this.mContent = "";
        this.mqZ = "";
        this.mrI = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mqZ = PickerView.this.mrH[i];
                PickerView.this.iJS.setText(PickerView.this.mqZ);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iJS = null;
        this.mrG = null;
        this.mType = -1;
        this.UR = 0;
        this.US = 0;
        this.UT = 0;
        this.UV = 0;
        this.UU = 0;
        this.mrH = null;
        this.mContent = "";
        this.mqZ = "";
        this.mrI = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mqZ = PickerView.this.mrH[i];
                PickerView.this.iJS.setText(PickerView.this.mqZ);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iJS = null;
        this.mrG = null;
        this.mType = -1;
        this.UR = 0;
        this.US = 0;
        this.UT = 0;
        this.UV = 0;
        this.UU = 0;
        this.mrH = null;
        this.mContent = "";
        this.mqZ = "";
        this.mrI = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.mqZ = PickerView.this.mrH[i2];
                PickerView.this.iJS.setText(PickerView.this.mqZ);
            }
        };
        init();
    }

    private void init() {
        Vr();
        dyw();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Vr() {
        this.iJS = new TextView(this.mContext);
        this.iJS.setTextSize(0, this.cwA);
        this.iJS.setTextColor(this.mrx);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.iJS, layoutParams);
    }

    private void dyw() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.mrG = new ImageView(this.mContext);
        this.mrG.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mrG, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.iJS.setText(this.mContent);
            this.iJS.setTextSize(0, this.cwA);
            ((ViewGroup.MarginLayoutParams) this.iJS.getLayoutParams()).leftMargin = this.mrq;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mrG.getLayoutParams();
            marginLayoutParams.width = this.mrq;
            marginLayoutParams.rightMargin = this.mrq;
            switch (this.mType) {
                case 6:
                    if (eVar.moJ != null && eVar.moJ.length > 0) {
                        this.mrH = eVar.moJ;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.UR = calendar.get(1);
                    this.US = calendar.get(2);
                    this.UT = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.UU = calendar2.get(10);
                    this.UV = calendar2.get(12);
                    break;
                default:
                    this.UR = 0;
                    this.US = 0;
                    this.UT = 0;
                    this.UU = 0;
                    this.UV = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int dyv() {
        return this.mrt;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.UR = datePicker.getYear();
        this.US = datePicker.getMonth();
        this.UT = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.UR).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.US + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.UT);
        this.mqZ = sb.toString();
        this.iJS.setText(this.mqZ);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.mqZ = dj(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.mqZ)) {
                this.mqZ = dj(this.UU, this.UV);
            }
            this.iJS.setText(this.mqZ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.mrH != null && this.mrH.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.mrH, this.mrI).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.UR, this.US, this.UT);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.UU));
                timePicker.setCurrentMinute(Integer.valueOf(this.UV));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                c(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(R.string.dialog_ok, this).setNegativeButton(R.string.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void c(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!PickerView.this.dym()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dym() {
        return !TextUtils.isEmpty(this.mqZ);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mqZ;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mqZ = "";
    }

    private String dj(int i, int i2) {
        this.UU = i;
        this.UV = i2;
        String num = Integer.toString(this.UV);
        String num2 = Integer.toString(this.UU);
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
