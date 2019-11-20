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
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private TextView fBR;
    private ImageView iLW;
    private String[] iLX;
    private DialogInterface.OnClickListener iLY;
    private String iLp;
    private String mContent;
    private int mType;
    private int wH;
    private int wI;
    private int wJ;
    private int wK;
    private int wL;

    public PickerView(Context context) {
        super(context);
        this.fBR = null;
        this.iLW = null;
        this.mType = -1;
        this.wH = 0;
        this.wI = 0;
        this.wJ = 0;
        this.wL = 0;
        this.wK = 0;
        this.iLX = null;
        this.mContent = "";
        this.iLp = "";
        this.iLY = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.iLp = PickerView.this.iLX[i];
                PickerView.this.fBR.setText(PickerView.this.iLp);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBR = null;
        this.iLW = null;
        this.mType = -1;
        this.wH = 0;
        this.wI = 0;
        this.wJ = 0;
        this.wL = 0;
        this.wK = 0;
        this.iLX = null;
        this.mContent = "";
        this.iLp = "";
        this.iLY = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.iLp = PickerView.this.iLX[i];
                PickerView.this.fBR.setText(PickerView.this.iLp);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBR = null;
        this.iLW = null;
        this.mType = -1;
        this.wH = 0;
        this.wI = 0;
        this.wJ = 0;
        this.wL = 0;
        this.wK = 0;
        this.iLX = null;
        this.mContent = "";
        this.iLp = "";
        this.iLY = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.iLp = PickerView.this.iLX[i2];
                PickerView.this.fBR.setText(PickerView.this.iLp);
            }
        };
        init();
    }

    private void init() {
        cgw();
        cgx();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void cgw() {
        this.fBR = new TextView(this.mContext);
        this.fBR.setTextSize(0, this.aGd);
        this.fBR.setTextColor(this.iLN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.fBR, layoutParams);
    }

    private void cgx() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.iLW = new ImageView(this.mContext);
        this.iLW.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iLW, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.fBR.setText(this.mContent);
            this.fBR.setTextSize(0, this.aGd);
            ((ViewGroup.MarginLayoutParams) this.fBR.getLayoutParams()).leftMargin = this.iLG;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iLW.getLayoutParams();
            marginLayoutParams.width = this.iLG;
            marginLayoutParams.rightMargin = this.iLG;
            switch (this.mType) {
                case 6:
                    if (eVar.iII != null && eVar.iII.length > 0) {
                        this.iLX = eVar.iII;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.wH = calendar.get(1);
                    this.wI = calendar.get(2);
                    this.wJ = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.wK = calendar2.get(10);
                    this.wL = calendar2.get(12);
                    break;
                default:
                    this.wH = 0;
                    this.wI = 0;
                    this.wJ = 0;
                    this.wK = 0;
                    this.wL = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cgv() {
        return this.iLJ;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.wH = datePicker.getYear();
        this.wI = datePicker.getMonth();
        this.wJ = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.wH).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.wI + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.wJ);
        this.iLp = sb.toString();
        this.fBR.setText(this.iLp);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.iLp = ci(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.iLp)) {
                this.iLp = ci(this.wK, this.wL);
            }
            this.fBR.setText(this.iLp);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.iLX != null && this.iLX.length > 0) {
                    d(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.iLX, this.iLY).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.wH, this.wI, this.wJ);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                d(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.wK));
                timePicker.setCurrentMinute(Integer.valueOf(this.wL));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                d(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(R.string.dialog_ok, this).setNegativeButton(R.string.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void d(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!PickerView.this.cgm()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cgm() {
        return !TextUtils.isEmpty(this.iLp);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iLp;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iLp = "";
    }

    private String ci(int i, int i2) {
        this.wK = i;
        this.wL = i2;
        String num = Integer.toString(this.wL);
        String num2 = Integer.toString(this.wK);
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
