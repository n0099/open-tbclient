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
    private int Te;
    private int Tf;
    private int Tg;
    private int Th;
    private int Ti;
    private TextView huk;
    private ImageView kNR;
    private String[] kNS;
    private DialogInterface.OnClickListener kNT;
    private String kNk;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.huk = null;
        this.kNR = null;
        this.mType = -1;
        this.Te = 0;
        this.Tf = 0;
        this.Tg = 0;
        this.Ti = 0;
        this.Th = 0;
        this.kNS = null;
        this.mContent = "";
        this.kNk = "";
        this.kNT = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.kNk = PickerView.this.kNS[i];
                PickerView.this.huk.setText(PickerView.this.kNk);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.huk = null;
        this.kNR = null;
        this.mType = -1;
        this.Te = 0;
        this.Tf = 0;
        this.Tg = 0;
        this.Ti = 0;
        this.Th = 0;
        this.kNS = null;
        this.mContent = "";
        this.kNk = "";
        this.kNT = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.kNk = PickerView.this.kNS[i];
                PickerView.this.huk.setText(PickerView.this.kNk);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.huk = null;
        this.kNR = null;
        this.mType = -1;
        this.Te = 0;
        this.Tf = 0;
        this.Tg = 0;
        this.Ti = 0;
        this.Th = 0;
        this.kNS = null;
        this.mContent = "";
        this.kNk = "";
        this.kNT = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.kNk = PickerView.this.kNS[i2];
                PickerView.this.huk.setText(PickerView.this.kNk);
            }
        };
        init();
    }

    private void init() {
        Or();
        cUV();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Or() {
        this.huk = new TextView(this.mContext);
        this.huk.setTextSize(0, this.bOo);
        this.huk.setTextColor(this.kNI);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.huk, layoutParams);
    }

    private void cUV() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.kNR = new ImageView(this.mContext);
        this.kNR.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.kNR, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.huk.setText(this.mContent);
            this.huk.setTextSize(0, this.bOo);
            ((ViewGroup.MarginLayoutParams) this.huk.getLayoutParams()).leftMargin = this.kNB;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kNR.getLayoutParams();
            marginLayoutParams.width = this.kNB;
            marginLayoutParams.rightMargin = this.kNB;
            switch (this.mType) {
                case 6:
                    if (eVar.kKU != null && eVar.kKU.length > 0) {
                        this.kNS = eVar.kKU;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Te = calendar.get(1);
                    this.Tf = calendar.get(2);
                    this.Tg = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Th = calendar2.get(10);
                    this.Ti = calendar2.get(12);
                    break;
                default:
                    this.Te = 0;
                    this.Tf = 0;
                    this.Tg = 0;
                    this.Th = 0;
                    this.Ti = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cUU() {
        return this.kNE;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Te = datePicker.getYear();
        this.Tf = datePicker.getMonth();
        this.Tg = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Te).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Tf + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Tg);
        this.kNk = sb.toString();
        this.huk.setText(this.kNk);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.kNk = cO(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.kNk)) {
                this.kNk = cO(this.Th, this.Ti);
            }
            this.huk.setText(this.kNk);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.kNS != null && this.kNS.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.kNS, this.kNT).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Te, this.Tf, this.Tg);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Th));
                timePicker.setCurrentMinute(Integer.valueOf(this.Ti));
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
                if (!PickerView.this.cUL()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cUL() {
        return !TextUtils.isEmpty(this.kNk);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.kNk;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kNk = "";
    }

    private String cO(int i, int i2) {
        this.Th = i;
        this.Ti = i2;
        String num = Integer.toString(this.Ti);
        String num2 = Integer.toString(this.Th);
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
