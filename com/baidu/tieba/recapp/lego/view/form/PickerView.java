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
/* loaded from: classes13.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int ST;
    private int SU;
    private int SV;
    private int SW;
    private int SX;
    private TextView hfw;
    private ImageView kvY;
    private String[] kvZ;
    private String kvr;
    private DialogInterface.OnClickListener kwa;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.hfw = null;
        this.kvY = null;
        this.mType = -1;
        this.ST = 0;
        this.SU = 0;
        this.SV = 0;
        this.SX = 0;
        this.SW = 0;
        this.kvZ = null;
        this.mContent = "";
        this.kvr = "";
        this.kwa = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.kvr = PickerView.this.kvZ[i];
                PickerView.this.hfw.setText(PickerView.this.kvr);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hfw = null;
        this.kvY = null;
        this.mType = -1;
        this.ST = 0;
        this.SU = 0;
        this.SV = 0;
        this.SX = 0;
        this.SW = 0;
        this.kvZ = null;
        this.mContent = "";
        this.kvr = "";
        this.kwa = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.kvr = PickerView.this.kvZ[i];
                PickerView.this.hfw.setText(PickerView.this.kvr);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hfw = null;
        this.kvY = null;
        this.mType = -1;
        this.ST = 0;
        this.SU = 0;
        this.SV = 0;
        this.SX = 0;
        this.SW = 0;
        this.kvZ = null;
        this.mContent = "";
        this.kvr = "";
        this.kwa = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.kvr = PickerView.this.kvZ[i2];
                PickerView.this.hfw.setText(PickerView.this.kvr);
            }
        };
        init();
    }

    private void init() {
        Me();
        cNV();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Me() {
        this.hfw = new TextView(this.mContext);
        this.hfw.setTextSize(0, this.bFw);
        this.hfw.setTextColor(this.kvP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.hfw, layoutParams);
    }

    private void cNV() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.kvY = new ImageView(this.mContext);
        this.kvY.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.kvY, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.hfw.setText(this.mContent);
            this.hfw.setTextSize(0, this.bFw);
            ((ViewGroup.MarginLayoutParams) this.hfw.getLayoutParams()).leftMargin = this.kvI;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kvY.getLayoutParams();
            marginLayoutParams.width = this.kvI;
            marginLayoutParams.rightMargin = this.kvI;
            switch (this.mType) {
                case 6:
                    if (eVar.kta != null && eVar.kta.length > 0) {
                        this.kvZ = eVar.kta;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.ST = calendar.get(1);
                    this.SU = calendar.get(2);
                    this.SV = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.SW = calendar2.get(10);
                    this.SX = calendar2.get(12);
                    break;
                default:
                    this.ST = 0;
                    this.SU = 0;
                    this.SV = 0;
                    this.SW = 0;
                    this.SX = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cNU() {
        return this.kvL;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.ST = datePicker.getYear();
        this.SU = datePicker.getMonth();
        this.SV = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.ST).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.SU + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.SV);
        this.kvr = sb.toString();
        this.hfw.setText(this.kvr);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.kvr = cJ(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.kvr)) {
                this.kvr = cJ(this.SW, this.SX);
            }
            this.hfw.setText(this.kvr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.kvZ != null && this.kvZ.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.kvZ, this.kwa).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.ST, this.SU, this.SV);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.SW));
                timePicker.setCurrentMinute(Integer.valueOf(this.SX));
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
                if (!PickerView.this.cNL()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cNL() {
        return !TextUtils.isEmpty(this.kvr);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.kvr;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kvr = "";
    }

    private String cJ(int i, int i2) {
        this.SW = i;
        this.SX = i2;
        String num = Integer.toString(this.SX);
        String num2 = Integer.toString(this.SW);
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
