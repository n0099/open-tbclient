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
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int Kn;
    private int Ko;
    private int Kp;
    private int Kq;
    private int Kr;
    private TextView fvT;
    private String iDs;
    private ImageView iEa;
    private String[] iEb;
    private DialogInterface.OnClickListener iEc;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.fvT = null;
        this.iEa = null;
        this.mType = -1;
        this.Kn = 0;
        this.Ko = 0;
        this.Kp = 0;
        this.Kr = 0;
        this.Kq = 0;
        this.iEb = null;
        this.mContent = "";
        this.iDs = "";
        this.iEc = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.iDs = PickerView.this.iEb[i];
                PickerView.this.fvT.setText(PickerView.this.iDs);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fvT = null;
        this.iEa = null;
        this.mType = -1;
        this.Kn = 0;
        this.Ko = 0;
        this.Kp = 0;
        this.Kr = 0;
        this.Kq = 0;
        this.iEb = null;
        this.mContent = "";
        this.iDs = "";
        this.iEc = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.iDs = PickerView.this.iEb[i];
                PickerView.this.fvT.setText(PickerView.this.iDs);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fvT = null;
        this.iEa = null;
        this.mType = -1;
        this.Kn = 0;
        this.Ko = 0;
        this.Kp = 0;
        this.Kr = 0;
        this.Kq = 0;
        this.iEb = null;
        this.mContent = "";
        this.iDs = "";
        this.iEc = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.iDs = PickerView.this.iEb[i2];
                PickerView.this.fvT.setText(PickerView.this.iDs);
            }
        };
        init();
    }

    private void init() {
        cfu();
        cfv();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void cfu() {
        this.fvT = new TextView(this.mContext);
        this.fvT.setTextSize(0, this.amc);
        this.fvT.setTextColor(this.iDR);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.fvT, layoutParams);
    }

    private void cfv() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.iEa = new ImageView(this.mContext);
        this.iEa.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iEa, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.fvT.setText(this.mContent);
            this.fvT.setTextSize(0, this.amc);
            ((ViewGroup.MarginLayoutParams) this.fvT.getLayoutParams()).leftMargin = this.iDK;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iEa.getLayoutParams();
            marginLayoutParams.width = this.iDK;
            marginLayoutParams.rightMargin = this.iDK;
            switch (this.mType) {
                case 6:
                    if (eVar.iAN != null && eVar.iAN.length > 0) {
                        this.iEb = eVar.iAN;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Kn = calendar.get(1);
                    this.Ko = calendar.get(2);
                    this.Kp = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Kq = calendar2.get(10);
                    this.Kr = calendar2.get(12);
                    break;
                default:
                    this.Kn = 0;
                    this.Ko = 0;
                    this.Kp = 0;
                    this.Kq = 0;
                    this.Kr = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cft() {
        return this.iDN;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Kn = datePicker.getYear();
        this.Ko = datePicker.getMonth();
        this.Kp = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Kn).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Ko + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Kp);
        this.iDs = sb.toString();
        this.fvT.setText(this.iDs);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.iDs = cl(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.iDs)) {
                this.iDs = cl(this.Kq, this.Kr);
            }
            this.fvT.setText(this.iDs);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.iEb != null && this.iEb.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.iEb, this.iEc).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Kn, this.Ko, this.Kp);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Kq));
                timePicker.setCurrentMinute(Integer.valueOf(this.Kr));
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
                if (!PickerView.this.cfk()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfk() {
        return !TextUtils.isEmpty(this.iDs);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iDs;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iDs = "";
    }

    private String cl(int i, int i2) {
        this.Kq = i;
        this.Kr = i2;
        String num = Integer.toString(this.Kr);
        String num2 = Integer.toString(this.Kq);
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
