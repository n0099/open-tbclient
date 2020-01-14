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
/* loaded from: classes11.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private TextView gtm;
    private ImageView jJS;
    private String[] jJT;
    private DialogInterface.OnClickListener jJU;
    private String jJl;
    private String mContent;
    private int mType;
    private int zl;
    private int zm;
    private int zn;
    private int zo;
    private int zp;

    public PickerView(Context context) {
        super(context);
        this.gtm = null;
        this.jJS = null;
        this.mType = -1;
        this.zl = 0;
        this.zm = 0;
        this.zn = 0;
        this.zp = 0;
        this.zo = 0;
        this.jJT = null;
        this.mContent = "";
        this.jJl = "";
        this.jJU = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.jJl = PickerView.this.jJT[i];
                PickerView.this.gtm.setText(PickerView.this.jJl);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtm = null;
        this.jJS = null;
        this.mType = -1;
        this.zl = 0;
        this.zm = 0;
        this.zn = 0;
        this.zp = 0;
        this.zo = 0;
        this.jJT = null;
        this.mContent = "";
        this.jJl = "";
        this.jJU = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.jJl = PickerView.this.jJT[i];
                PickerView.this.gtm.setText(PickerView.this.jJl);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtm = null;
        this.jJS = null;
        this.mType = -1;
        this.zl = 0;
        this.zm = 0;
        this.zn = 0;
        this.zp = 0;
        this.zo = 0;
        this.jJT = null;
        this.mContent = "";
        this.jJl = "";
        this.jJU = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.jJl = PickerView.this.jJT[i2];
                PickerView.this.gtm.setText(PickerView.this.jJl);
            }
        };
        init();
    }

    private void init() {
        initContentView();
        bKn();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void initContentView() {
        this.gtm = new TextView(this.mContext);
        this.gtm.setTextSize(0, this.bcC);
        this.gtm.setTextColor(this.jJJ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.gtm, layoutParams);
    }

    private void bKn() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.jJS = new ImageView(this.mContext);
        this.jJS.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.jJS, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.gtm.setText(this.mContent);
            this.gtm.setTextSize(0, this.bcC);
            ((ViewGroup.MarginLayoutParams) this.gtm.getLayoutParams()).leftMargin = this.jJC;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jJS.getLayoutParams();
            marginLayoutParams.width = this.jJC;
            marginLayoutParams.rightMargin = this.jJC;
            switch (this.mType) {
                case 6:
                    if (eVar.jGG != null && eVar.jGG.length > 0) {
                        this.jJT = eVar.jGG;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.zl = calendar.get(1);
                    this.zm = calendar.get(2);
                    this.zn = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.zo = calendar2.get(10);
                    this.zp = calendar2.get(12);
                    break;
                default:
                    this.zl = 0;
                    this.zm = 0;
                    this.zn = 0;
                    this.zo = 0;
                    this.zp = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cBI() {
        return this.jJF;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.zl = datePicker.getYear();
        this.zm = datePicker.getMonth();
        this.zn = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.zl).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.zm + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.zn);
        this.jJl = sb.toString();
        this.gtm.setText(this.jJl);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.jJl = cB(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.jJl)) {
                this.jJl = cB(this.zo, this.zp);
            }
            this.gtm.setText(this.jJl);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.jJT != null && this.jJT.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.jJT, this.jJU).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.zl, this.zm, this.zn);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.zo));
                timePicker.setCurrentMinute(Integer.valueOf(this.zp));
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
                if (!PickerView.this.cBz()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cBz() {
        return !TextUtils.isEmpty(this.jJl);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.jJl;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jJl = "";
    }

    private String cB(int i, int i2) {
        this.zo = i;
        this.zp = i2;
        String num = Integer.toString(this.zp);
        String num2 = Integer.toString(this.zo);
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
