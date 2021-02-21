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
/* loaded from: classes8.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int VH;
    private int VI;
    private int VJ;
    private int VK;
    private int VL;
    private TextView joX;
    private String mContent;
    private int mType;
    private String mVP;
    private ImageView mWv;
    private String[] mWw;
    private DialogInterface.OnClickListener mWx;

    public PickerView(Context context) {
        super(context);
        this.joX = null;
        this.mWv = null;
        this.mType = -1;
        this.VH = 0;
        this.VI = 0;
        this.VJ = 0;
        this.VL = 0;
        this.VK = 0;
        this.mWw = null;
        this.mContent = "";
        this.mVP = "";
        this.mWx = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mVP = PickerView.this.mWw[i];
                PickerView.this.joX.setText(PickerView.this.mVP);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.joX = null;
        this.mWv = null;
        this.mType = -1;
        this.VH = 0;
        this.VI = 0;
        this.VJ = 0;
        this.VL = 0;
        this.VK = 0;
        this.mWw = null;
        this.mContent = "";
        this.mVP = "";
        this.mWx = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mVP = PickerView.this.mWw[i];
                PickerView.this.joX.setText(PickerView.this.mVP);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.joX = null;
        this.mWv = null;
        this.mType = -1;
        this.VH = 0;
        this.VI = 0;
        this.VJ = 0;
        this.VL = 0;
        this.VK = 0;
        this.mWw = null;
        this.mContent = "";
        this.mVP = "";
        this.mWx = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.mVP = PickerView.this.mWw[i2];
                PickerView.this.joX.setText(PickerView.this.mVP);
            }
        };
        init();
    }

    private void init() {
        Zl();
        dEb();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Zl() {
        this.joX = new TextView(this.mContext);
        this.joX.setTextSize(0, this.cKa);
        this.joX.setTextColor(this.mWn);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.joX, layoutParams);
    }

    private void dEb() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.mWv = new ImageView(this.mContext);
        this.mWv.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mWv, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.joX.setText(this.mContent);
            this.joX.setTextSize(0, this.cKa);
            ((ViewGroup.MarginLayoutParams) this.joX.getLayoutParams()).leftMargin = this.mWg;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWv.getLayoutParams();
            marginLayoutParams.width = this.mWg;
            marginLayoutParams.rightMargin = this.mWg;
            switch (this.mType) {
                case 6:
                    if (eVar.mTz != null && eVar.mTz.length > 0) {
                        this.mWw = eVar.mTz;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.VH = calendar.get(1);
                    this.VI = calendar.get(2);
                    this.VJ = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.VK = calendar2.get(10);
                    this.VL = calendar2.get(12);
                    break;
                default:
                    this.VH = 0;
                    this.VI = 0;
                    this.VJ = 0;
                    this.VK = 0;
                    this.VL = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int dEa() {
        return this.mWj;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.VH = datePicker.getYear();
        this.VI = datePicker.getMonth();
        this.VJ = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.VH).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.VI + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.VJ);
        this.mVP = sb.toString();
        this.joX.setText(this.mVP);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.mVP = dk(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.mVP)) {
                this.mVP = dk(this.VK, this.VL);
            }
            this.joX.setText(this.mVP);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.mWw != null && this.mWw.length > 0) {
                    g(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.mWw, this.mWx).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.VH, this.VI, this.VJ);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                g(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.VK));
                timePicker.setCurrentMinute(Integer.valueOf(this.VL));
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
                if (!PickerView.this.dDR()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDR() {
        return !TextUtils.isEmpty(this.mVP);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mVP;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mVP = "";
    }

    private String dk(int i, int i2) {
        this.VK = i;
        this.VL = i2;
        String num = Integer.toString(this.VL);
        String num2 = Integer.toString(this.VK);
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
