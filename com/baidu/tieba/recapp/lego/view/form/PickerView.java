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
    private int SQ;
    private int SR;
    private int SS;
    private int ST;
    private int SU;
    private TextView hfq;
    private ImageView kvU;
    private String[] kvV;
    private DialogInterface.OnClickListener kvW;
    private String kvn;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.hfq = null;
        this.kvU = null;
        this.mType = -1;
        this.SQ = 0;
        this.SR = 0;
        this.SS = 0;
        this.SU = 0;
        this.ST = 0;
        this.kvV = null;
        this.mContent = "";
        this.kvn = "";
        this.kvW = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.kvn = PickerView.this.kvV[i];
                PickerView.this.hfq.setText(PickerView.this.kvn);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hfq = null;
        this.kvU = null;
        this.mType = -1;
        this.SQ = 0;
        this.SR = 0;
        this.SS = 0;
        this.SU = 0;
        this.ST = 0;
        this.kvV = null;
        this.mContent = "";
        this.kvn = "";
        this.kvW = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.kvn = PickerView.this.kvV[i];
                PickerView.this.hfq.setText(PickerView.this.kvn);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hfq = null;
        this.kvU = null;
        this.mType = -1;
        this.SQ = 0;
        this.SR = 0;
        this.SS = 0;
        this.SU = 0;
        this.ST = 0;
        this.kvV = null;
        this.mContent = "";
        this.kvn = "";
        this.kvW = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.kvn = PickerView.this.kvV[i2];
                PickerView.this.hfq.setText(PickerView.this.kvn);
            }
        };
        init();
    }

    private void init() {
        Mf();
        cNX();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Mf() {
        this.hfq = new TextView(this.mContext);
        this.hfq.setTextSize(0, this.bFr);
        this.hfq.setTextColor(this.kvL);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.hfq, layoutParams);
    }

    private void cNX() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.kvU = new ImageView(this.mContext);
        this.kvU.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.kvU, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.hfq.setText(this.mContent);
            this.hfq.setTextSize(0, this.bFr);
            ((ViewGroup.MarginLayoutParams) this.hfq.getLayoutParams()).leftMargin = this.kvE;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kvU.getLayoutParams();
            marginLayoutParams.width = this.kvE;
            marginLayoutParams.rightMargin = this.kvE;
            switch (this.mType) {
                case 6:
                    if (eVar.ksW != null && eVar.ksW.length > 0) {
                        this.kvV = eVar.ksW;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.SQ = calendar.get(1);
                    this.SR = calendar.get(2);
                    this.SS = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.ST = calendar2.get(10);
                    this.SU = calendar2.get(12);
                    break;
                default:
                    this.SQ = 0;
                    this.SR = 0;
                    this.SS = 0;
                    this.ST = 0;
                    this.SU = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cNW() {
        return this.kvH;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.SQ = datePicker.getYear();
        this.SR = datePicker.getMonth();
        this.SS = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.SQ).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.SR + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.SS);
        this.kvn = sb.toString();
        this.hfq.setText(this.kvn);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.kvn = cJ(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.kvn)) {
                this.kvn = cJ(this.ST, this.SU);
            }
            this.hfq.setText(this.kvn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.kvV != null && this.kvV.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.kvV, this.kvW).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.SQ, this.SR, this.SS);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.ST));
                timePicker.setCurrentMinute(Integer.valueOf(this.SU));
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
                if (!PickerView.this.cNN()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cNN() {
        return !TextUtils.isEmpty(this.kvn);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.kvn;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kvn = "";
    }

    private String cJ(int i, int i2) {
        this.ST = i;
        this.SU = i2;
        String num = Integer.toString(this.SU);
        String num2 = Integer.toString(this.ST);
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
