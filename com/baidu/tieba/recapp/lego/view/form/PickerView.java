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
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int Jn;
    private int Jo;
    private int Jp;
    private int Jq;
    private int Jr;
    private TextView dsr;
    private ImageView gsW;
    private String[] gsX;
    private DialogInterface.OnClickListener gsY;
    private String gsn;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.dsr = null;
        this.gsW = null;
        this.mType = -1;
        this.Jn = 0;
        this.Jo = 0;
        this.Jp = 0;
        this.Jr = 0;
        this.Jq = 0;
        this.gsX = null;
        this.mContent = "";
        this.gsn = "";
        this.gsY = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gsn = PickerView.this.gsX[i];
                PickerView.this.dsr.setText(PickerView.this.gsn);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dsr = null;
        this.gsW = null;
        this.mType = -1;
        this.Jn = 0;
        this.Jo = 0;
        this.Jp = 0;
        this.Jr = 0;
        this.Jq = 0;
        this.gsX = null;
        this.mContent = "";
        this.gsn = "";
        this.gsY = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gsn = PickerView.this.gsX[i];
                PickerView.this.dsr.setText(PickerView.this.gsn);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dsr = null;
        this.gsW = null;
        this.mType = -1;
        this.Jn = 0;
        this.Jo = 0;
        this.Jp = 0;
        this.Jr = 0;
        this.Jq = 0;
        this.gsX = null;
        this.mContent = "";
        this.gsn = "";
        this.gsY = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.gsn = PickerView.this.gsX[i2];
                PickerView.this.dsr.setText(PickerView.this.gsn);
            }
        };
        init();
    }

    private void init() {
        bnZ();
        boa();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void bnZ() {
        this.dsr = new TextView(this.mContext);
        this.dsr.setTextSize(0, this.gsN);
        this.dsr.setTextColor(this.gsM);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.dsr, layoutParams);
    }

    private void boa() {
        Drawable drawable = this.mResources.getDrawable(f.C0146f.form_picker_arrow);
        this.gsW = new ImageView(this.mContext);
        this.gsW.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gsW, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.dsr.setText(this.mContent);
            this.dsr.setTextSize(0, this.gsN);
            ((ViewGroup.MarginLayoutParams) this.dsr.getLayoutParams()).leftMargin = this.gsF;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gsW.getLayoutParams();
            marginLayoutParams.width = this.gsF;
            marginLayoutParams.rightMargin = this.gsF;
            switch (this.mType) {
                case 6:
                    if (eVar.gpJ != null && eVar.gpJ.length > 0) {
                        this.gsX = eVar.gpJ;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Jn = calendar.get(1);
                    this.Jo = calendar.get(2);
                    this.Jp = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Jq = calendar2.get(10);
                    this.Jr = calendar2.get(12);
                    break;
                default:
                    this.Jn = 0;
                    this.Jo = 0;
                    this.Jp = 0;
                    this.Jq = 0;
                    this.Jr = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int bnY() {
        return this.gsI;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Jn = datePicker.getYear();
        this.Jo = datePicker.getMonth();
        this.Jp = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Jn).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Jo + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Jp);
        this.gsn = sb.toString();
        this.dsr.setText(this.gsn);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gsn = bC(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gsn)) {
                this.gsn = bC(this.Jq, this.Jr);
            }
            this.dsr.setText(this.gsn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.gsX != null && this.gsX.length > 0) {
                    a(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.gsX, this.gsY).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Jn, this.Jo, this.Jp);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                a(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Jq));
                timePicker.setCurrentMinute(Integer.valueOf(this.Jr));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                a(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(f.j.dialog_ok, this).setNegativeButton(f.j.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void a(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!PickerView.this.bnP()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bnP() {
        return !TextUtils.isEmpty(this.gsn);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gsn;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gsn = "";
    }

    private String bC(int i, int i2) {
        this.Jq = i;
        this.Jr = i2;
        String num = Integer.toString(this.Jr);
        String num2 = Integer.toString(this.Jq);
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
