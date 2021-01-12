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
/* loaded from: classes7.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int VJ;
    private int VK;
    private int VL;
    private int VM;
    private int VN;
    private TextView jjc;
    private String mContent;
    private ImageView mMH;
    private String[] mMI;
    private DialogInterface.OnClickListener mMJ;
    private String mMa;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.jjc = null;
        this.mMH = null;
        this.mType = -1;
        this.VJ = 0;
        this.VK = 0;
        this.VL = 0;
        this.VN = 0;
        this.VM = 0;
        this.mMI = null;
        this.mContent = "";
        this.mMa = "";
        this.mMJ = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mMa = PickerView.this.mMI[i];
                PickerView.this.jjc.setText(PickerView.this.mMa);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjc = null;
        this.mMH = null;
        this.mType = -1;
        this.VJ = 0;
        this.VK = 0;
        this.VL = 0;
        this.VN = 0;
        this.VM = 0;
        this.mMI = null;
        this.mContent = "";
        this.mMa = "";
        this.mMJ = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mMa = PickerView.this.mMI[i];
                PickerView.this.jjc.setText(PickerView.this.mMa);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jjc = null;
        this.mMH = null;
        this.mType = -1;
        this.VJ = 0;
        this.VK = 0;
        this.VL = 0;
        this.VN = 0;
        this.VM = 0;
        this.mMI = null;
        this.mContent = "";
        this.mMa = "";
        this.mMJ = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.mMa = PickerView.this.mMI[i2];
                PickerView.this.jjc.setText(PickerView.this.mMa);
            }
        };
        init();
    }

    private void init() {
        Xv();
        dBL();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Xv() {
        this.jjc = new TextView(this.mContext);
        this.jjc.setTextSize(0, this.cHI);
        this.jjc.setTextColor(this.mMy);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.jjc, layoutParams);
    }

    private void dBL() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.mMH = new ImageView(this.mContext);
        this.mMH.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mMH, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.jjc.setText(this.mContent);
            this.jjc.setTextSize(0, this.cHI);
            ((ViewGroup.MarginLayoutParams) this.jjc.getLayoutParams()).leftMargin = this.mMr;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMH.getLayoutParams();
            marginLayoutParams.width = this.mMr;
            marginLayoutParams.rightMargin = this.mMr;
            switch (this.mType) {
                case 6:
                    if (eVar.mJO != null && eVar.mJO.length > 0) {
                        this.mMI = eVar.mJO;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.VJ = calendar.get(1);
                    this.VK = calendar.get(2);
                    this.VL = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.VM = calendar2.get(10);
                    this.VN = calendar2.get(12);
                    break;
                default:
                    this.VJ = 0;
                    this.VK = 0;
                    this.VL = 0;
                    this.VM = 0;
                    this.VN = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int dBK() {
        return this.mMu;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.VJ = datePicker.getYear();
        this.VK = datePicker.getMonth();
        this.VL = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.VJ).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.VK + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.VL);
        this.mMa = sb.toString();
        this.jjc.setText(this.mMa);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.mMa = dm(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.mMa)) {
                this.mMa = dm(this.VM, this.VN);
            }
            this.jjc.setText(this.mMa);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.mMI != null && this.mMI.length > 0) {
                    g(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.mMI, this.mMJ).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.VJ, this.VK, this.VL);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                g(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.VM));
                timePicker.setCurrentMinute(Integer.valueOf(this.VN));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                g(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(R.string.dialog_ok, this).setNegativeButton(R.string.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void g(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!PickerView.this.dBB()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dBB() {
        return !TextUtils.isEmpty(this.mMa);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mMa;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mMa = "";
    }

    private String dm(int i, int i2) {
        this.VM = i;
        this.VN = i2;
        String num = Integer.toString(this.VN);
        String num2 = Integer.toString(this.VM);
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
