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
/* loaded from: classes26.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int VJ;
    private int VK;
    private int VL;
    private int VM;
    private int VN;
    private TextView jbv;
    private String mContent;
    private String mLy;
    private ImageView mMf;
    private String[] mMg;
    private DialogInterface.OnClickListener mMh;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.jbv = null;
        this.mMf = null;
        this.mType = -1;
        this.VJ = 0;
        this.VK = 0;
        this.VL = 0;
        this.VN = 0;
        this.VM = 0;
        this.mMg = null;
        this.mContent = "";
        this.mLy = "";
        this.mMh = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mLy = PickerView.this.mMg[i];
                PickerView.this.jbv.setText(PickerView.this.mLy);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jbv = null;
        this.mMf = null;
        this.mType = -1;
        this.VJ = 0;
        this.VK = 0;
        this.VL = 0;
        this.VN = 0;
        this.VM = 0;
        this.mMg = null;
        this.mContent = "";
        this.mLy = "";
        this.mMh = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mLy = PickerView.this.mMg[i];
                PickerView.this.jbv.setText(PickerView.this.mLy);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jbv = null;
        this.mMf = null;
        this.mType = -1;
        this.VJ = 0;
        this.VK = 0;
        this.VL = 0;
        this.VN = 0;
        this.VM = 0;
        this.mMg = null;
        this.mContent = "";
        this.mLy = "";
        this.mMh = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.mLy = PickerView.this.mMg[i2];
                PickerView.this.jbv.setText(PickerView.this.mLy);
            }
        };
        init();
    }

    private void init() {
        ZG();
        dFN();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void ZG() {
        this.jbv = new TextView(this.mContext);
        this.jbv.setTextSize(0, this.cHF);
        this.jbv.setTextColor(this.mLW);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.jbv, layoutParams);
    }

    private void dFN() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.mMf = new ImageView(this.mContext);
        this.mMf.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mMf, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.jbv.setText(this.mContent);
            this.jbv.setTextSize(0, this.cHF);
            ((ViewGroup.MarginLayoutParams) this.jbv.getLayoutParams()).leftMargin = this.mLP;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMf.getLayoutParams();
            marginLayoutParams.width = this.mLP;
            marginLayoutParams.rightMargin = this.mLP;
            switch (this.mType) {
                case 6:
                    if (eVar.mJl != null && eVar.mJl.length > 0) {
                        this.mMg = eVar.mJl;
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
    public int dFM() {
        return this.mLS;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.VJ = datePicker.getYear();
        this.VK = datePicker.getMonth();
        this.VL = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.VJ).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.VK + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.VL);
        this.mLy = sb.toString();
        this.jbv.setText(this.mLy);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.mLy = dq(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.mLy)) {
                this.mLy = dq(this.VM, this.VN);
            }
            this.jbv.setText(this.mLy);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.mMg != null && this.mMg.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.mMg, this.mMh).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.VJ, this.VK, this.VL);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.VM));
                timePicker.setCurrentMinute(Integer.valueOf(this.VN));
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
                if (!PickerView.this.dFD()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFD() {
        return !TextUtils.isEmpty(this.mLy);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mLy;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mLy = "";
    }

    private String dq(int i, int i2) {
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
