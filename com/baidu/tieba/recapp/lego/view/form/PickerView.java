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
    private int LH;
    private int LI;
    private int LJ;
    private int LK;
    private int LM;
    private TextView dyH;
    private ImageView gAq;
    private String[] gAr;
    private DialogInterface.OnClickListener gAs;
    private String gzH;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.dyH = null;
        this.gAq = null;
        this.mType = -1;
        this.LH = 0;
        this.LI = 0;
        this.LJ = 0;
        this.LM = 0;
        this.LK = 0;
        this.gAr = null;
        this.mContent = "";
        this.gzH = "";
        this.gAs = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gzH = PickerView.this.gAr[i];
                PickerView.this.dyH.setText(PickerView.this.gzH);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyH = null;
        this.gAq = null;
        this.mType = -1;
        this.LH = 0;
        this.LI = 0;
        this.LJ = 0;
        this.LM = 0;
        this.LK = 0;
        this.gAr = null;
        this.mContent = "";
        this.gzH = "";
        this.gAs = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gzH = PickerView.this.gAr[i];
                PickerView.this.dyH.setText(PickerView.this.gzH);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dyH = null;
        this.gAq = null;
        this.mType = -1;
        this.LH = 0;
        this.LI = 0;
        this.LJ = 0;
        this.LM = 0;
        this.LK = 0;
        this.gAr = null;
        this.mContent = "";
        this.gzH = "";
        this.gAs = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.gzH = PickerView.this.gAr[i2];
                PickerView.this.dyH.setText(PickerView.this.gzH);
            }
        };
        init();
    }

    private void init() {
        bqG();
        bqH();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void bqG() {
        this.dyH = new TextView(this.mContext);
        this.dyH.setTextSize(0, this.gAh);
        this.dyH.setTextColor(this.gAg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.dyH, layoutParams);
    }

    private void bqH() {
        Drawable drawable = this.mResources.getDrawable(e.f.form_picker_arrow);
        this.gAq = new ImageView(this.mContext);
        this.gAq.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gAq, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.dyH.setText(this.mContent);
            this.dyH.setTextSize(0, this.gAh);
            ((ViewGroup.MarginLayoutParams) this.dyH.getLayoutParams()).leftMargin = this.gzZ;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gAq.getLayoutParams();
            marginLayoutParams.width = this.gzZ;
            marginLayoutParams.rightMargin = this.gzZ;
            switch (this.mType) {
                case 6:
                    if (eVar.gxb != null && eVar.gxb.length > 0) {
                        this.gAr = eVar.gxb;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.LH = calendar.get(1);
                    this.LI = calendar.get(2);
                    this.LJ = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.LK = calendar2.get(10);
                    this.LM = calendar2.get(12);
                    break;
                default:
                    this.LH = 0;
                    this.LI = 0;
                    this.LJ = 0;
                    this.LK = 0;
                    this.LM = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int bqF() {
        return this.gAc;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.LH = datePicker.getYear();
        this.LI = datePicker.getMonth();
        this.LJ = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.LH).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.LI + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.LJ);
        this.gzH = sb.toString();
        this.dyH.setText(this.gzH);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gzH = bE(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gzH)) {
                this.gzH = bE(this.LK, this.LM);
            }
            this.dyH.setText(this.gzH);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.gAr != null && this.gAr.length > 0) {
                    a(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.gAr, this.gAs).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.LH, this.LI, this.LJ);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                a(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.LK));
                timePicker.setCurrentMinute(Integer.valueOf(this.LM));
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
                if (!PickerView.this.bqw()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bqw() {
        return !TextUtils.isEmpty(this.gzH);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gzH;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gzH = "";
    }

    private String bE(int i, int i2) {
        this.LK = i;
        this.LM = i2;
        String num = Integer.toString(this.LM);
        String num2 = Integer.toString(this.LK);
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
