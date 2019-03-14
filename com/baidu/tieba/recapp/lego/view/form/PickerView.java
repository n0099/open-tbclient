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
import com.baidu.mobstat.Config;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int MC;
    private int MD;
    private int ME;
    private int MF;
    private int MG;
    private TextView ffT;
    private String ikT;
    private ImageView ilB;
    private String[] ilC;
    private DialogInterface.OnClickListener ilD;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.ffT = null;
        this.ilB = null;
        this.mType = -1;
        this.MC = 0;
        this.MD = 0;
        this.ME = 0;
        this.MG = 0;
        this.MF = 0;
        this.ilC = null;
        this.mContent = "";
        this.ikT = "";
        this.ilD = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.ikT = PickerView.this.ilC[i];
                PickerView.this.ffT.setText(PickerView.this.ikT);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ffT = null;
        this.ilB = null;
        this.mType = -1;
        this.MC = 0;
        this.MD = 0;
        this.ME = 0;
        this.MG = 0;
        this.MF = 0;
        this.ilC = null;
        this.mContent = "";
        this.ikT = "";
        this.ilD = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.ikT = PickerView.this.ilC[i];
                PickerView.this.ffT.setText(PickerView.this.ikT);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ffT = null;
        this.ilB = null;
        this.mType = -1;
        this.MC = 0;
        this.MD = 0;
        this.ME = 0;
        this.MG = 0;
        this.MF = 0;
        this.ilC = null;
        this.mContent = "";
        this.ikT = "";
        this.ilD = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.ikT = PickerView.this.ilC[i2];
                PickerView.this.ffT.setText(PickerView.this.ikT);
            }
        };
        init();
    }

    private void init() {
        bXu();
        bXv();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void bXu() {
        this.ffT = new TextView(this.mContext);
        this.ffT.setTextSize(0, this.alL);
        this.ffT.setTextColor(this.ils);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.ffT, layoutParams);
    }

    private void bXv() {
        Drawable drawable = this.mResources.getDrawable(d.f.form_picker_arrow);
        this.ilB = new ImageView(this.mContext);
        this.ilB.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.ilB, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.ffT.setText(this.mContent);
            this.ffT.setTextSize(0, this.alL);
            ((ViewGroup.MarginLayoutParams) this.ffT.getLayoutParams()).leftMargin = this.ill;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilB.getLayoutParams();
            marginLayoutParams.width = this.ill;
            marginLayoutParams.rightMargin = this.ill;
            switch (this.mType) {
                case 6:
                    if (eVar.iio != null && eVar.iio.length > 0) {
                        this.ilC = eVar.iio;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.MC = calendar.get(1);
                    this.MD = calendar.get(2);
                    this.ME = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.MF = calendar2.get(10);
                    this.MG = calendar2.get(12);
                    break;
                default:
                    this.MC = 0;
                    this.MD = 0;
                    this.ME = 0;
                    this.MF = 0;
                    this.MG = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int bXt() {
        return this.ilo;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.MC = datePicker.getYear();
        this.MD = datePicker.getMonth();
        this.ME = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.MC).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.MD + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.ME);
        this.ikT = sb.toString();
        this.ffT.setText(this.ikT);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.ikT = ce(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.ikT)) {
                this.ikT = ce(this.MF, this.MG);
            }
            this.ffT.setText(this.ikT);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.ilC != null && this.ilC.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.ilC, this.ilD).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.MC, this.MD, this.ME);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.MF));
                timePicker.setCurrentMinute(Integer.valueOf(this.MG));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                c(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(d.j.dialog_ok, this).setNegativeButton(d.j.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void c(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!PickerView.this.bXk()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXk() {
        return !TextUtils.isEmpty(this.ikT);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.ikT;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ikT = "";
    }

    private String ce(int i, int i2) {
        this.MF = i;
        this.MG = i2;
        String num = Integer.toString(this.MG);
        String num2 = Integer.toString(this.MF);
        if (Pattern.matches("\\d", num2)) {
            num2 = "0" + num2;
        }
        if (Pattern.matches("\\d", num)) {
            num = "0" + num;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num2).append(Config.TRACE_TODAY_VISIT_SPLIT).append(num);
        return sb.toString();
    }
}
