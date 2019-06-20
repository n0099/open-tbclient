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
    private int Km;
    private int Kn;
    private int Ko;
    private int Kp;
    private int Kq;
    private TextView fvU;
    private String iDv;
    private ImageView iEd;
    private String[] iEe;
    private DialogInterface.OnClickListener iEf;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.fvU = null;
        this.iEd = null;
        this.mType = -1;
        this.Km = 0;
        this.Kn = 0;
        this.Ko = 0;
        this.Kq = 0;
        this.Kp = 0;
        this.iEe = null;
        this.mContent = "";
        this.iDv = "";
        this.iEf = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.iDv = PickerView.this.iEe[i];
                PickerView.this.fvU.setText(PickerView.this.iDv);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fvU = null;
        this.iEd = null;
        this.mType = -1;
        this.Km = 0;
        this.Kn = 0;
        this.Ko = 0;
        this.Kq = 0;
        this.Kp = 0;
        this.iEe = null;
        this.mContent = "";
        this.iDv = "";
        this.iEf = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.iDv = PickerView.this.iEe[i];
                PickerView.this.fvU.setText(PickerView.this.iDv);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fvU = null;
        this.iEd = null;
        this.mType = -1;
        this.Km = 0;
        this.Kn = 0;
        this.Ko = 0;
        this.Kq = 0;
        this.Kp = 0;
        this.iEe = null;
        this.mContent = "";
        this.iDv = "";
        this.iEf = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.iDv = PickerView.this.iEe[i2];
                PickerView.this.fvU.setText(PickerView.this.iDv);
            }
        };
        init();
    }

    private void init() {
        cfx();
        cfy();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void cfx() {
        this.fvU = new TextView(this.mContext);
        this.fvU.setTextSize(0, this.amc);
        this.fvU.setTextColor(this.iDU);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.fvU, layoutParams);
    }

    private void cfy() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.iEd = new ImageView(this.mContext);
        this.iEd.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iEd, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.fvU.setText(this.mContent);
            this.fvU.setTextSize(0, this.amc);
            ((ViewGroup.MarginLayoutParams) this.fvU.getLayoutParams()).leftMargin = this.iDN;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iEd.getLayoutParams();
            marginLayoutParams.width = this.iDN;
            marginLayoutParams.rightMargin = this.iDN;
            switch (this.mType) {
                case 6:
                    if (eVar.iAQ != null && eVar.iAQ.length > 0) {
                        this.iEe = eVar.iAQ;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Km = calendar.get(1);
                    this.Kn = calendar.get(2);
                    this.Ko = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Kp = calendar2.get(10);
                    this.Kq = calendar2.get(12);
                    break;
                default:
                    this.Km = 0;
                    this.Kn = 0;
                    this.Ko = 0;
                    this.Kp = 0;
                    this.Kq = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cfw() {
        return this.iDQ;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Km = datePicker.getYear();
        this.Kn = datePicker.getMonth();
        this.Ko = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Km).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Kn + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Ko);
        this.iDv = sb.toString();
        this.fvU.setText(this.iDv);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.iDv = cl(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.iDv)) {
                this.iDv = cl(this.Kp, this.Kq);
            }
            this.fvU.setText(this.iDv);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.iEe != null && this.iEe.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.iEe, this.iEf).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Km, this.Kn, this.Ko);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Kp));
                timePicker.setCurrentMinute(Integer.valueOf(this.Kq));
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
                if (!PickerView.this.cfn()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfn() {
        return !TextUtils.isEmpty(this.iDv);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iDv;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iDv = "";
    }

    private String cl(int i, int i2) {
        this.Kp = i;
        this.Kq = i2;
        String num = Integer.toString(this.Kq);
        String num2 = Integer.toString(this.Kp);
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
