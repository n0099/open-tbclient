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
    private int US;
    private int UT;
    private int UU;
    private int UV;
    private int UW;
    private TextView iQC;
    private String mContent;
    private int mType;
    private ImageView mxR;
    private String[] mxS;
    private DialogInterface.OnClickListener mxT;
    private String mxk;

    public PickerView(Context context) {
        super(context);
        this.iQC = null;
        this.mxR = null;
        this.mType = -1;
        this.US = 0;
        this.UT = 0;
        this.UU = 0;
        this.UW = 0;
        this.UV = 0;
        this.mxS = null;
        this.mContent = "";
        this.mxk = "";
        this.mxT = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mxk = PickerView.this.mxS[i];
                PickerView.this.iQC.setText(PickerView.this.mxk);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iQC = null;
        this.mxR = null;
        this.mType = -1;
        this.US = 0;
        this.UT = 0;
        this.UU = 0;
        this.UW = 0;
        this.UV = 0;
        this.mxS = null;
        this.mContent = "";
        this.mxk = "";
        this.mxT = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mxk = PickerView.this.mxS[i];
                PickerView.this.iQC.setText(PickerView.this.mxk);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iQC = null;
        this.mxR = null;
        this.mType = -1;
        this.US = 0;
        this.UT = 0;
        this.UU = 0;
        this.UW = 0;
        this.UV = 0;
        this.mxS = null;
        this.mContent = "";
        this.mxk = "";
        this.mxT = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.mxk = PickerView.this.mxS[i2];
                PickerView.this.iQC.setText(PickerView.this.mxk);
            }
        };
        init();
    }

    private void init() {
        Xh();
        dAv();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Xh() {
        this.iQC = new TextView(this.mContext);
        this.iQC.setTextSize(0, this.cAJ);
        this.iQC.setTextColor(this.mxI);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.iQC, layoutParams);
    }

    private void dAv() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.mxR = new ImageView(this.mContext);
        this.mxR.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mxR, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.iQC.setText(this.mContent);
            this.iQC.setTextSize(0, this.cAJ);
            ((ViewGroup.MarginLayoutParams) this.iQC.getLayoutParams()).leftMargin = this.mxB;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mxR.getLayoutParams();
            marginLayoutParams.width = this.mxB;
            marginLayoutParams.rightMargin = this.mxB;
            switch (this.mType) {
                case 6:
                    if (eVar.muX != null && eVar.muX.length > 0) {
                        this.mxS = eVar.muX;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.US = calendar.get(1);
                    this.UT = calendar.get(2);
                    this.UU = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.UV = calendar2.get(10);
                    this.UW = calendar2.get(12);
                    break;
                default:
                    this.US = 0;
                    this.UT = 0;
                    this.UU = 0;
                    this.UV = 0;
                    this.UW = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int dAu() {
        return this.mxE;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.US = datePicker.getYear();
        this.UT = datePicker.getMonth();
        this.UU = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.US).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.UT + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.UU);
        this.mxk = sb.toString();
        this.iQC.setText(this.mxk);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.mxk = dl(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.mxk)) {
                this.mxk = dl(this.UV, this.UW);
            }
            this.iQC.setText(this.mxk);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.mxS != null && this.mxS.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.mxS, this.mxT).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.US, this.UT, this.UU);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.UV));
                timePicker.setCurrentMinute(Integer.valueOf(this.UW));
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
                if (!PickerView.this.dAl()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dAl() {
        return !TextUtils.isEmpty(this.mxk);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mxk;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mxk = "";
    }

    private String dl(int i, int i2) {
        this.UV = i;
        this.UW = i2;
        String num = Integer.toString(this.UW);
        String num2 = Integer.toString(this.UV);
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
