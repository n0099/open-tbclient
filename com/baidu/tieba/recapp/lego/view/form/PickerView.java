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
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int Jo;
    private int Jp;
    private int Jq;
    private int Jr;
    private int Js;
    private TextView dMe;
    private ImageView gnQ;
    private String[] gnR;
    private DialogInterface.OnClickListener gnS;
    private String gnh;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.dMe = null;
        this.gnQ = null;
        this.mType = -1;
        this.Jo = 0;
        this.Jp = 0;
        this.Jq = 0;
        this.Js = 0;
        this.Jr = 0;
        this.gnR = null;
        this.mContent = "";
        this.gnh = "";
        this.gnS = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gnh = PickerView.this.gnR[i];
                PickerView.this.dMe.setText(PickerView.this.gnh);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dMe = null;
        this.gnQ = null;
        this.mType = -1;
        this.Jo = 0;
        this.Jp = 0;
        this.Jq = 0;
        this.Js = 0;
        this.Jr = 0;
        this.gnR = null;
        this.mContent = "";
        this.gnh = "";
        this.gnS = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gnh = PickerView.this.gnR[i];
                PickerView.this.dMe.setText(PickerView.this.gnh);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dMe = null;
        this.gnQ = null;
        this.mType = -1;
        this.Jo = 0;
        this.Jp = 0;
        this.Jq = 0;
        this.Js = 0;
        this.Jr = 0;
        this.gnR = null;
        this.mContent = "";
        this.gnh = "";
        this.gnS = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.gnh = PickerView.this.gnR[i2];
                PickerView.this.dMe.setText(PickerView.this.gnh);
            }
        };
        init();
    }

    private void init() {
        initContentView();
        boT();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void initContentView() {
        this.dMe = new TextView(this.mContext);
        this.dMe.setTextSize(0, this.gnH);
        this.dMe.setTextColor(this.gnG);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.dMe, layoutParams);
    }

    private void boT() {
        Drawable drawable = this.mResources.getDrawable(d.f.form_picker_arrow);
        this.gnQ = new ImageView(this.mContext);
        this.gnQ.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gnQ, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.dMe.setText(this.mContent);
            this.dMe.setTextSize(0, this.gnH);
            ((ViewGroup.MarginLayoutParams) this.dMe.getLayoutParams()).leftMargin = this.gnz;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gnQ.getLayoutParams();
            marginLayoutParams.width = this.gnz;
            marginLayoutParams.rightMargin = this.gnz;
            switch (this.mType) {
                case 6:
                    if (eVar.gkG != null && eVar.gkG.length > 0) {
                        this.gnR = eVar.gkG;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Jo = calendar.get(1);
                    this.Jp = calendar.get(2);
                    this.Jq = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Jr = calendar2.get(10);
                    this.Js = calendar2.get(12);
                    break;
                default:
                    this.Jo = 0;
                    this.Jp = 0;
                    this.Jq = 0;
                    this.Jr = 0;
                    this.Js = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int boS() {
        return this.gnC;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Jo = datePicker.getYear();
        this.Jp = datePicker.getMonth();
        this.Jq = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Jo).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Jp + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Jq);
        this.gnh = sb.toString();
        this.dMe.setText(this.gnh);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gnh = bC(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gnh)) {
                this.gnh = bC(this.Jr, this.Js);
            }
            this.dMe.setText(this.gnh);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.gnR != null && this.gnR.length > 0) {
                    b(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.gnR, this.gnS).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Jo, this.Jp, this.Jq);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                b(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Jr));
                timePicker.setCurrentMinute(Integer.valueOf(this.Js));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                b(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(d.k.dialog_ok, this).setNegativeButton(d.k.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void b(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!PickerView.this.boJ()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean boJ() {
        return !TextUtils.isEmpty(this.gnh);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gnh;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gnh = "";
    }

    private String bC(int i, int i2) {
        this.Jr = i;
        this.Js = i2;
        String num = Integer.toString(this.Js);
        String num2 = Integer.toString(this.Jr);
        if (Pattern.matches("\\d", num2)) {
            num2 = "0" + num2;
        }
        if (Pattern.matches("\\d", num)) {
            num = "0" + num;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num2).append(SystemInfoUtil.COLON).append(num);
        return sb.toString();
    }
}
