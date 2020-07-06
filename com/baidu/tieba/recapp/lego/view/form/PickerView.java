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
    private int TG;
    private int TH;
    private int TI;
    private int TJ;
    private int TK;
    private TextView hHl;
    private ImageView liT;
    private String[] liU;
    private DialogInterface.OnClickListener liV;
    private String lim;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.hHl = null;
        this.liT = null;
        this.mType = -1;
        this.TG = 0;
        this.TH = 0;
        this.TI = 0;
        this.TK = 0;
        this.TJ = 0;
        this.liU = null;
        this.mContent = "";
        this.lim = "";
        this.liV = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.lim = PickerView.this.liU[i];
                PickerView.this.hHl.setText(PickerView.this.lim);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hHl = null;
        this.liT = null;
        this.mType = -1;
        this.TG = 0;
        this.TH = 0;
        this.TI = 0;
        this.TK = 0;
        this.TJ = 0;
        this.liU = null;
        this.mContent = "";
        this.lim = "";
        this.liV = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.lim = PickerView.this.liU[i];
                PickerView.this.hHl.setText(PickerView.this.lim);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hHl = null;
        this.liT = null;
        this.mType = -1;
        this.TG = 0;
        this.TH = 0;
        this.TI = 0;
        this.TK = 0;
        this.TJ = 0;
        this.liU = null;
        this.mContent = "";
        this.lim = "";
        this.liV = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.lim = PickerView.this.liU[i2];
                PickerView.this.hHl.setText(PickerView.this.lim);
            }
        };
        init();
    }

    private void init() {
        Px();
        cZC();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Px() {
        this.hHl = new TextView(this.mContext);
        this.hHl.setTextSize(0, this.bTc);
        this.hHl.setTextColor(this.liK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.hHl, layoutParams);
    }

    private void cZC() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.liT = new ImageView(this.mContext);
        this.liT.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.liT, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.hHl.setText(this.mContent);
            this.hHl.setTextSize(0, this.bTc);
            ((ViewGroup.MarginLayoutParams) this.hHl.getLayoutParams()).leftMargin = this.liD;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.liT.getLayoutParams();
            marginLayoutParams.width = this.liD;
            marginLayoutParams.rightMargin = this.liD;
            switch (this.mType) {
                case 6:
                    if (eVar.lfX != null && eVar.lfX.length > 0) {
                        this.liU = eVar.lfX;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.TG = calendar.get(1);
                    this.TH = calendar.get(2);
                    this.TI = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.TJ = calendar2.get(10);
                    this.TK = calendar2.get(12);
                    break;
                default:
                    this.TG = 0;
                    this.TH = 0;
                    this.TI = 0;
                    this.TJ = 0;
                    this.TK = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cZB() {
        return this.liG;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.TG = datePicker.getYear();
        this.TH = datePicker.getMonth();
        this.TI = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.TG).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.TH + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.TI);
        this.lim = sb.toString();
        this.hHl.setText(this.lim);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.lim = cU(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.lim)) {
                this.lim = cU(this.TJ, this.TK);
            }
            this.hHl.setText(this.lim);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.liU != null && this.liU.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.liU, this.liV).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.TG, this.TH, this.TI);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.TJ));
                timePicker.setCurrentMinute(Integer.valueOf(this.TK));
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
                if (!PickerView.this.cZs()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cZs() {
        return !TextUtils.isEmpty(this.lim);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.lim;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lim = "";
    }

    private String cU(int i, int i2) {
        this.TJ = i;
        this.TK = i2;
        String num = Integer.toString(this.TK);
        String num2 = Integer.toString(this.TJ);
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
