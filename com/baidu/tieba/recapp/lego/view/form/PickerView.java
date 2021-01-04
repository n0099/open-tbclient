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
    private int VL;
    private int VM;
    private int VN;
    private int VP;
    private int VQ;
    private TextView jnJ;
    private String mContent;
    private String mQH;
    private ImageView mRo;
    private String[] mRp;
    private DialogInterface.OnClickListener mRq;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.jnJ = null;
        this.mRo = null;
        this.mType = -1;
        this.VL = 0;
        this.VM = 0;
        this.VN = 0;
        this.VQ = 0;
        this.VP = 0;
        this.mRp = null;
        this.mContent = "";
        this.mQH = "";
        this.mRq = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mQH = PickerView.this.mRp[i];
                PickerView.this.jnJ.setText(PickerView.this.mQH);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jnJ = null;
        this.mRo = null;
        this.mType = -1;
        this.VL = 0;
        this.VM = 0;
        this.VN = 0;
        this.VQ = 0;
        this.VP = 0;
        this.mRp = null;
        this.mContent = "";
        this.mQH = "";
        this.mRq = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mQH = PickerView.this.mRp[i];
                PickerView.this.jnJ.setText(PickerView.this.mQH);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jnJ = null;
        this.mRo = null;
        this.mType = -1;
        this.VL = 0;
        this.VM = 0;
        this.VN = 0;
        this.VQ = 0;
        this.VP = 0;
        this.mRp = null;
        this.mContent = "";
        this.mQH = "";
        this.mRq = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.mQH = PickerView.this.mRp[i2];
                PickerView.this.jnJ.setText(PickerView.this.mQH);
            }
        };
        init();
    }

    private void init() {
        abn();
        dFC();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void abn() {
        this.jnJ = new TextView(this.mContext);
        this.jnJ.setTextSize(0, this.cMu);
        this.jnJ.setTextColor(this.mRf);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.jnJ, layoutParams);
    }

    private void dFC() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.mRo = new ImageView(this.mContext);
        this.mRo.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mRo, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.jnJ.setText(this.mContent);
            this.jnJ.setTextSize(0, this.cMu);
            ((ViewGroup.MarginLayoutParams) this.jnJ.getLayoutParams()).leftMargin = this.mQY;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRo.getLayoutParams();
            marginLayoutParams.width = this.mQY;
            marginLayoutParams.rightMargin = this.mQY;
            switch (this.mType) {
                case 6:
                    if (eVar.mOt != null && eVar.mOt.length > 0) {
                        this.mRp = eVar.mOt;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.VL = calendar.get(1);
                    this.VM = calendar.get(2);
                    this.VN = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.VP = calendar2.get(10);
                    this.VQ = calendar2.get(12);
                    break;
                default:
                    this.VL = 0;
                    this.VM = 0;
                    this.VN = 0;
                    this.VP = 0;
                    this.VQ = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int dFB() {
        return this.mRb;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.VL = datePicker.getYear();
        this.VM = datePicker.getMonth();
        this.VN = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.VL).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.VM + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.VN);
        this.mQH = sb.toString();
        this.jnJ.setText(this.mQH);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.mQH = dm(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.mQH)) {
                this.mQH = dm(this.VP, this.VQ);
            }
            this.jnJ.setText(this.mQH);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.mRp != null && this.mRp.length > 0) {
                    g(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.mRp, this.mRq).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.VL, this.VM, this.VN);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                g(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.VP));
                timePicker.setCurrentMinute(Integer.valueOf(this.VQ));
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
                if (!PickerView.this.dFs()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFs() {
        return !TextUtils.isEmpty(this.mQH);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mQH;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mQH = "";
    }

    private String dm(int i, int i2) {
        this.VP = i;
        this.VQ = i2;
        String num = Integer.toString(this.VQ);
        String num2 = Integer.toString(this.VP);
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
