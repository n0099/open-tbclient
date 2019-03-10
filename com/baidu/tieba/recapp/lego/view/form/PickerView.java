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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int MB;
    private int MC;
    private int MD;
    private int ME;
    private int MF;
    private TextView ffU;
    private ImageView ilI;
    private String[] ilJ;
    private DialogInterface.OnClickListener ilK;
    private String ila;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.ffU = null;
        this.ilI = null;
        this.mType = -1;
        this.MB = 0;
        this.MC = 0;
        this.MD = 0;
        this.MF = 0;
        this.ME = 0;
        this.ilJ = null;
        this.mContent = "";
        this.ila = "";
        this.ilK = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.ila = PickerView.this.ilJ[i];
                PickerView.this.ffU.setText(PickerView.this.ila);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ffU = null;
        this.ilI = null;
        this.mType = -1;
        this.MB = 0;
        this.MC = 0;
        this.MD = 0;
        this.MF = 0;
        this.ME = 0;
        this.ilJ = null;
        this.mContent = "";
        this.ila = "";
        this.ilK = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.ila = PickerView.this.ilJ[i];
                PickerView.this.ffU.setText(PickerView.this.ila);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ffU = null;
        this.ilI = null;
        this.mType = -1;
        this.MB = 0;
        this.MC = 0;
        this.MD = 0;
        this.MF = 0;
        this.ME = 0;
        this.ilJ = null;
        this.mContent = "";
        this.ila = "";
        this.ilK = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.ila = PickerView.this.ilJ[i2];
                PickerView.this.ffU.setText(PickerView.this.ila);
            }
        };
        init();
    }

    private void init() {
        bXs();
        bXt();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void bXs() {
        this.ffU = new TextView(this.mContext);
        this.ffU.setTextSize(0, this.alK);
        this.ffU.setTextColor(this.ilz);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.ffU, layoutParams);
    }

    private void bXt() {
        Drawable drawable = this.mResources.getDrawable(d.f.form_picker_arrow);
        this.ilI = new ImageView(this.mContext);
        this.ilI.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.ilI, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.ffU.setText(this.mContent);
            this.ffU.setTextSize(0, this.alK);
            ((ViewGroup.MarginLayoutParams) this.ffU.getLayoutParams()).leftMargin = this.ils;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilI.getLayoutParams();
            marginLayoutParams.width = this.ils;
            marginLayoutParams.rightMargin = this.ils;
            switch (this.mType) {
                case 6:
                    if (eVar.iiu != null && eVar.iiu.length > 0) {
                        this.ilJ = eVar.iiu;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.MB = calendar.get(1);
                    this.MC = calendar.get(2);
                    this.MD = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.ME = calendar2.get(10);
                    this.MF = calendar2.get(12);
                    break;
                default:
                    this.MB = 0;
                    this.MC = 0;
                    this.MD = 0;
                    this.ME = 0;
                    this.MF = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int bXr() {
        return this.ilv;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.MB = datePicker.getYear();
        this.MC = datePicker.getMonth();
        this.MD = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.MB).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.MC + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.MD);
        this.ila = sb.toString();
        this.ffU.setText(this.ila);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.ila = ce(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.ila)) {
                this.ila = ce(this.ME, this.MF);
            }
            this.ffU.setText(this.ila);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.ilJ != null && this.ilJ.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.ilJ, this.ilK).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.MB, this.MC, this.MD);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.ME));
                timePicker.setCurrentMinute(Integer.valueOf(this.MF));
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
                if (!PickerView.this.bXi()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXi() {
        return !TextUtils.isEmpty(this.ila);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.ila;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ila = "";
    }

    private String ce(int i, int i2) {
        this.ME = i;
        this.MF = i2;
        String num = Integer.toString(this.MF);
        String num2 = Integer.toString(this.ME);
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
