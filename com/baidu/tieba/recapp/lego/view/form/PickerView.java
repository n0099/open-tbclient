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
    private int Df;
    private int Dg;
    private int Dh;
    private int Di;
    private int Dj;
    private TextView dzQ;
    private String gaM;
    private ImageView gbv;
    private String[] gbw;
    private DialogInterface.OnClickListener gbx;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.dzQ = null;
        this.gbv = null;
        this.mType = -1;
        this.Df = 0;
        this.Dg = 0;
        this.Dh = 0;
        this.Dj = 0;
        this.Di = 0;
        this.gbw = null;
        this.mContent = "";
        this.gaM = "";
        this.gbx = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gaM = PickerView.this.gbw[i];
                PickerView.this.dzQ.setText(PickerView.this.gaM);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzQ = null;
        this.gbv = null;
        this.mType = -1;
        this.Df = 0;
        this.Dg = 0;
        this.Dh = 0;
        this.Dj = 0;
        this.Di = 0;
        this.gbw = null;
        this.mContent = "";
        this.gaM = "";
        this.gbx = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gaM = PickerView.this.gbw[i];
                PickerView.this.dzQ.setText(PickerView.this.gaM);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dzQ = null;
        this.gbv = null;
        this.mType = -1;
        this.Df = 0;
        this.Dg = 0;
        this.Dh = 0;
        this.Dj = 0;
        this.Di = 0;
        this.gbw = null;
        this.mContent = "";
        this.gaM = "";
        this.gbx = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.gaM = PickerView.this.gbw[i2];
                PickerView.this.dzQ.setText(PickerView.this.gaM);
            }
        };
        init();
    }

    private void init() {
        initContentView();
        bjV();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void initContentView() {
        this.dzQ = new TextView(this.mContext);
        this.dzQ.setTextSize(0, this.gbm);
        this.dzQ.setTextColor(this.gbl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.dzQ, layoutParams);
    }

    private void bjV() {
        Drawable drawable = this.mResources.getDrawable(d.f.form_picker_arrow);
        this.gbv = new ImageView(this.mContext);
        this.gbv.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gbv, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.dzQ.setText(this.mContent);
            this.dzQ.setTextSize(0, this.gbm);
            ((ViewGroup.MarginLayoutParams) this.dzQ.getLayoutParams()).leftMargin = this.gbe;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gbv.getLayoutParams();
            marginLayoutParams.width = this.gbe;
            marginLayoutParams.rightMargin = this.gbe;
            switch (this.mType) {
                case 6:
                    if (eVar.fYl != null && eVar.fYl.length > 0) {
                        this.gbw = eVar.fYl;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Df = calendar.get(1);
                    this.Dg = calendar.get(2);
                    this.Dh = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Di = calendar2.get(10);
                    this.Dj = calendar2.get(12);
                    break;
                default:
                    this.Df = 0;
                    this.Dg = 0;
                    this.Dh = 0;
                    this.Di = 0;
                    this.Dj = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int bjU() {
        return this.gbh;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Df = datePicker.getYear();
        this.Dg = datePicker.getMonth();
        this.Dh = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Df).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Dg + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Dh);
        this.gaM = sb.toString();
        this.dzQ.setText(this.gaM);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gaM = bB(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gaM)) {
                this.gaM = bB(this.Di, this.Dj);
            }
            this.dzQ.setText(this.gaM);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        switch (this.mType) {
            case 6:
                if (this.gbw != null && this.gbw.length > 0) {
                    b(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.gbw, this.gbx).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Df, this.Dg, this.Dh);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                b(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Di));
                timePicker.setCurrentMinute(Integer.valueOf(this.Dj));
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
                if (!PickerView.this.bjL()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bjL() {
        return !TextUtils.isEmpty(this.gaM);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gaM;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gaM = "";
    }

    private String bB(int i, int i2) {
        this.Di = i;
        this.Dj = i2;
        String num = Integer.toString(this.Dj);
        String num2 = Integer.toString(this.Di);
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
