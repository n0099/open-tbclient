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
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int Jq;
    private int Jr;
    private int Js;
    private int Jt;
    private int Ju;
    private TextView dpH;
    private String gqY;
    private ImageView grH;
    private String[] grI;
    private DialogInterface.OnClickListener grJ;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.dpH = null;
        this.grH = null;
        this.mType = -1;
        this.Jq = 0;
        this.Jr = 0;
        this.Js = 0;
        this.Ju = 0;
        this.Jt = 0;
        this.grI = null;
        this.mContent = "";
        this.gqY = "";
        this.grJ = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gqY = PickerView.this.grI[i];
                PickerView.this.dpH.setText(PickerView.this.gqY);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dpH = null;
        this.grH = null;
        this.mType = -1;
        this.Jq = 0;
        this.Jr = 0;
        this.Js = 0;
        this.Ju = 0;
        this.Jt = 0;
        this.grI = null;
        this.mContent = "";
        this.gqY = "";
        this.grJ = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gqY = PickerView.this.grI[i];
                PickerView.this.dpH.setText(PickerView.this.gqY);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dpH = null;
        this.grH = null;
        this.mType = -1;
        this.Jq = 0;
        this.Jr = 0;
        this.Js = 0;
        this.Ju = 0;
        this.Jt = 0;
        this.grI = null;
        this.mContent = "";
        this.gqY = "";
        this.grJ = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.gqY = PickerView.this.grI[i2];
                PickerView.this.dpH.setText(PickerView.this.gqY);
            }
        };
        init();
    }

    private void init() {
        initContentView();
        bpu();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void initContentView() {
        this.dpH = new TextView(this.mContext);
        this.dpH.setTextSize(0, this.gry);
        this.dpH.setTextColor(this.grx);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.dpH, layoutParams);
    }

    private void bpu() {
        Drawable drawable = this.mResources.getDrawable(d.f.form_picker_arrow);
        this.grH = new ImageView(this.mContext);
        this.grH.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.grH, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.dpH.setText(this.mContent);
            this.dpH.setTextSize(0, this.gry);
            ((ViewGroup.MarginLayoutParams) this.dpH.getLayoutParams()).leftMargin = this.grq;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.grH.getLayoutParams();
            marginLayoutParams.width = this.grq;
            marginLayoutParams.rightMargin = this.grq;
            switch (this.mType) {
                case 6:
                    if (eVar.gow != null && eVar.gow.length > 0) {
                        this.grI = eVar.gow;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Jq = calendar.get(1);
                    this.Jr = calendar.get(2);
                    this.Js = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Jt = calendar2.get(10);
                    this.Ju = calendar2.get(12);
                    break;
                default:
                    this.Jq = 0;
                    this.Jr = 0;
                    this.Js = 0;
                    this.Jt = 0;
                    this.Ju = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int bpt() {
        return this.grt;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Jq = datePicker.getYear();
        this.Jr = datePicker.getMonth();
        this.Js = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Jq).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Jr + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Js);
        this.gqY = sb.toString();
        this.dpH.setText(this.gqY);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gqY = bB(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gqY)) {
                this.gqY = bB(this.Jt, this.Ju);
            }
            this.dpH.setText(this.gqY);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.grI != null && this.grI.length > 0) {
                    b(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.grI, this.grJ).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Jq, this.Jr, this.Js);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                b(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Jt));
                timePicker.setCurrentMinute(Integer.valueOf(this.Ju));
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
                if (!PickerView.this.bpk()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bpk() {
        return !TextUtils.isEmpty(this.gqY);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gqY;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gqY = "";
    }

    private String bB(int i, int i2) {
        this.Jt = i;
        this.Ju = i2;
        String num = Integer.toString(this.Ju);
        String num2 = Integer.toString(this.Jt);
        if (Pattern.matches("\\d", num2)) {
            num2 = "0" + num2;
        }
        if (Pattern.matches("\\d", num)) {
            num = "0" + num;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num2).append(SystemInfoUtil.COLON).append(num);
        return sb.toString();
    }
}
