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
    private int KA;
    private int KB;
    private int KC;
    private int Ky;
    private int Kz;
    private TextView fAQ;
    private String iJN;
    private ImageView iKv;
    private String[] iKw;
    private DialogInterface.OnClickListener iKx;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.fAQ = null;
        this.iKv = null;
        this.mType = -1;
        this.Ky = 0;
        this.Kz = 0;
        this.KA = 0;
        this.KC = 0;
        this.KB = 0;
        this.iKw = null;
        this.mContent = "";
        this.iJN = "";
        this.iKx = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.iJN = PickerView.this.iKw[i];
                PickerView.this.fAQ.setText(PickerView.this.iJN);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAQ = null;
        this.iKv = null;
        this.mType = -1;
        this.Ky = 0;
        this.Kz = 0;
        this.KA = 0;
        this.KC = 0;
        this.KB = 0;
        this.iKw = null;
        this.mContent = "";
        this.iJN = "";
        this.iKx = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.iJN = PickerView.this.iKw[i];
                PickerView.this.fAQ.setText(PickerView.this.iJN);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAQ = null;
        this.iKv = null;
        this.mType = -1;
        this.Ky = 0;
        this.Kz = 0;
        this.KA = 0;
        this.KC = 0;
        this.KB = 0;
        this.iKw = null;
        this.mContent = "";
        this.iJN = "";
        this.iKx = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.iJN = PickerView.this.iKw[i2];
                PickerView.this.fAQ.setText(PickerView.this.iJN);
            }
        };
        init();
    }

    private void init() {
        cio();
        cip();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void cio() {
        this.fAQ = new TextView(this.mContext);
        this.fAQ.setTextSize(0, this.amF);
        this.fAQ.setTextColor(this.iKm);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.fAQ, layoutParams);
    }

    private void cip() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.iKv = new ImageView(this.mContext);
        this.iKv.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iKv, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.fAQ.setText(this.mContent);
            this.fAQ.setTextSize(0, this.amF);
            ((ViewGroup.MarginLayoutParams) this.fAQ.getLayoutParams()).leftMargin = this.iKf;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iKv.getLayoutParams();
            marginLayoutParams.width = this.iKf;
            marginLayoutParams.rightMargin = this.iKf;
            switch (this.mType) {
                case 6:
                    if (eVar.iHi != null && eVar.iHi.length > 0) {
                        this.iKw = eVar.iHi;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Ky = calendar.get(1);
                    this.Kz = calendar.get(2);
                    this.KA = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.KB = calendar2.get(10);
                    this.KC = calendar2.get(12);
                    break;
                default:
                    this.Ky = 0;
                    this.Kz = 0;
                    this.KA = 0;
                    this.KB = 0;
                    this.KC = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cin() {
        return this.iKi;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Ky = datePicker.getYear();
        this.Kz = datePicker.getMonth();
        this.KA = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Ky).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Kz + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.KA);
        this.iJN = sb.toString();
        this.fAQ.setText(this.iJN);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.iJN = cr(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.iJN)) {
                this.iJN = cr(this.KB, this.KC);
            }
            this.fAQ.setText(this.iJN);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.iKw != null && this.iKw.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.iKw, this.iKx).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Ky, this.Kz, this.KA);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.KB));
                timePicker.setCurrentMinute(Integer.valueOf(this.KC));
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
                if (!PickerView.this.cie()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cie() {
        return !TextUtils.isEmpty(this.iJN);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iJN;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iJN = "";
    }

    private String cr(int i, int i2) {
        this.KB = i;
        this.KC = i2;
        String num = Integer.toString(this.KC);
        String num2 = Integer.toString(this.KB);
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
