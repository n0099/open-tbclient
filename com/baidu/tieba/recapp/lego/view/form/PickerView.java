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
/* loaded from: classes25.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int UB;
    private int Uw;
    private int Ux;
    private int Uy;
    private int Uz;
    private TextView iiz;
    private ImageView lPQ;
    private String[] lPR;
    private DialogInterface.OnClickListener lPS;
    private String lPj;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.iiz = null;
        this.lPQ = null;
        this.mType = -1;
        this.Uw = 0;
        this.Ux = 0;
        this.Uy = 0;
        this.UB = 0;
        this.Uz = 0;
        this.lPR = null;
        this.mContent = "";
        this.lPj = "";
        this.lPS = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.lPj = PickerView.this.lPR[i];
                PickerView.this.iiz.setText(PickerView.this.lPj);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iiz = null;
        this.lPQ = null;
        this.mType = -1;
        this.Uw = 0;
        this.Ux = 0;
        this.Uy = 0;
        this.UB = 0;
        this.Uz = 0;
        this.lPR = null;
        this.mContent = "";
        this.lPj = "";
        this.lPS = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.lPj = PickerView.this.lPR[i];
                PickerView.this.iiz.setText(PickerView.this.lPj);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iiz = null;
        this.lPQ = null;
        this.mType = -1;
        this.Uw = 0;
        this.Ux = 0;
        this.Uy = 0;
        this.UB = 0;
        this.Uz = 0;
        this.lPR = null;
        this.mContent = "";
        this.lPj = "";
        this.lPS = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.lPj = PickerView.this.lPR[i2];
                PickerView.this.iiz.setText(PickerView.this.lPj);
            }
        };
        init();
    }

    private void init() {
        Wq();
        drE();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Wq() {
        this.iiz = new TextView(this.mContext);
        this.iiz.setTextSize(0, this.cbH);
        this.iiz.setTextColor(this.lPH);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.iiz, layoutParams);
    }

    private void drE() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.lPQ = new ImageView(this.mContext);
        this.lPQ.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.lPQ, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.iiz.setText(this.mContent);
            this.iiz.setTextSize(0, this.cbH);
            ((ViewGroup.MarginLayoutParams) this.iiz.getLayoutParams()).leftMargin = this.lPA;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lPQ.getLayoutParams();
            marginLayoutParams.width = this.lPA;
            marginLayoutParams.rightMargin = this.lPA;
            switch (this.mType) {
                case 6:
                    if (eVar.lMT != null && eVar.lMT.length > 0) {
                        this.lPR = eVar.lMT;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Uw = calendar.get(1);
                    this.Ux = calendar.get(2);
                    this.Uy = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Uz = calendar2.get(10);
                    this.UB = calendar2.get(12);
                    break;
                default:
                    this.Uw = 0;
                    this.Ux = 0;
                    this.Uy = 0;
                    this.Uz = 0;
                    this.UB = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int drD() {
        return this.lPD;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Uw = datePicker.getYear();
        this.Ux = datePicker.getMonth();
        this.Uy = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Uw).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Ux + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Uy);
        this.lPj = sb.toString();
        this.iiz.setText(this.lPj);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.lPj = dh(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.lPj)) {
                this.lPj = dh(this.Uz, this.UB);
            }
            this.iiz.setText(this.lPj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.lPR != null && this.lPR.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.lPR, this.lPS).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Uw, this.Ux, this.Uy);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Uz));
                timePicker.setCurrentMinute(Integer.valueOf(this.UB));
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
                if (!PickerView.this.dru()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dru() {
        return !TextUtils.isEmpty(this.lPj);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.lPj;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lPj = "";
    }

    private String dh(int i, int i2) {
        this.Uz = i;
        this.UB = i2;
        String num = Integer.toString(this.UB);
        String num2 = Integer.toString(this.Uz);
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
