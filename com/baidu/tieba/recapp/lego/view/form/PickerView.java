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
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int Mk;
    private TextView dOv;
    private String gPz;
    private ImageView gQh;
    private String[] gQi;
    private DialogInterface.OnClickListener gQj;
    private String mContent;
    private int mDay;
    private int mMinute;
    private int mMonth;
    private int mType;
    private int mYear;

    public PickerView(Context context) {
        super(context);
        this.dOv = null;
        this.gQh = null;
        this.mType = -1;
        this.mYear = 0;
        this.mMonth = 0;
        this.mDay = 0;
        this.mMinute = 0;
        this.Mk = 0;
        this.gQi = null;
        this.mContent = "";
        this.gPz = "";
        this.gQj = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gPz = PickerView.this.gQi[i];
                PickerView.this.dOv.setText(PickerView.this.gPz);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dOv = null;
        this.gQh = null;
        this.mType = -1;
        this.mYear = 0;
        this.mMonth = 0;
        this.mDay = 0;
        this.mMinute = 0;
        this.Mk = 0;
        this.gQi = null;
        this.mContent = "";
        this.gPz = "";
        this.gQj = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gPz = PickerView.this.gQi[i];
                PickerView.this.dOv.setText(PickerView.this.gPz);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dOv = null;
        this.gQh = null;
        this.mType = -1;
        this.mYear = 0;
        this.mMonth = 0;
        this.mDay = 0;
        this.mMinute = 0;
        this.Mk = 0;
        this.gQi = null;
        this.mContent = "";
        this.gPz = "";
        this.gQj = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.gPz = PickerView.this.gQi[i2];
                PickerView.this.dOv.setText(PickerView.this.gPz);
            }
        };
        init();
    }

    private void init() {
        bvj();
        bvk();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void bvj() {
        this.dOv = new TextView(this.mContext);
        this.dOv.setTextSize(0, this.mFontSize);
        this.dOv.setTextColor(this.gPY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.dOv, layoutParams);
    }

    private void bvk() {
        Drawable drawable = this.mResources.getDrawable(e.f.form_picker_arrow);
        this.gQh = new ImageView(this.mContext);
        this.gQh.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gQh, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.dOv.setText(this.mContent);
            this.dOv.setTextSize(0, this.mFontSize);
            ((ViewGroup.MarginLayoutParams) this.dOv.getLayoutParams()).leftMargin = this.gPR;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gQh.getLayoutParams();
            marginLayoutParams.width = this.gPR;
            marginLayoutParams.rightMargin = this.gPR;
            switch (this.mType) {
                case 6:
                    if (eVar.gMT != null && eVar.gMT.length > 0) {
                        this.gQi = eVar.gMT;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.mYear = calendar.get(1);
                    this.mMonth = calendar.get(2);
                    this.mDay = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Mk = calendar2.get(10);
                    this.mMinute = calendar2.get(12);
                    break;
                default:
                    this.mYear = 0;
                    this.mMonth = 0;
                    this.mDay = 0;
                    this.Mk = 0;
                    this.mMinute = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int bvi() {
        return this.gPU;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.mYear = datePicker.getYear();
        this.mMonth = datePicker.getMonth();
        this.mDay = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mYear).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.mMonth + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.mDay);
        this.gPz = sb.toString();
        this.dOv.setText(this.gPz);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gPz = bH(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gPz)) {
                this.gPz = bH(this.Mk, this.mMinute);
            }
            this.dOv.setText(this.gPz);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.gQi != null && this.gQi.length > 0) {
                    a(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.gQi, this.gQj).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.mYear, this.mMonth, this.mDay);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                a(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Mk));
                timePicker.setCurrentMinute(Integer.valueOf(this.mMinute));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                a(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(e.j.dialog_ok, this).setNegativeButton(e.j.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void a(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!PickerView.this.buZ()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean buZ() {
        return !TextUtils.isEmpty(this.gPz);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gPz;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gPz = "";
    }

    private String bH(int i, int i2) {
        this.Mk = i;
        this.mMinute = i2;
        String num = Integer.toString(this.mMinute);
        String num2 = Integer.toString(this.Mk);
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
