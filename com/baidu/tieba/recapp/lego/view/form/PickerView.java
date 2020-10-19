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
    private int UQ;
    private int UR;
    private int US;
    private int UT;
    private int UU;
    private TextView ixw;
    private String mContent;
    private int mType;
    private String meB;
    private ImageView mfi;
    private String[] mfj;
    private DialogInterface.OnClickListener mfk;

    public PickerView(Context context) {
        super(context);
        this.ixw = null;
        this.mfi = null;
        this.mType = -1;
        this.UQ = 0;
        this.UR = 0;
        this.US = 0;
        this.UU = 0;
        this.UT = 0;
        this.mfj = null;
        this.mContent = "";
        this.meB = "";
        this.mfk = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.meB = PickerView.this.mfj[i];
                PickerView.this.ixw.setText(PickerView.this.meB);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ixw = null;
        this.mfi = null;
        this.mType = -1;
        this.UQ = 0;
        this.UR = 0;
        this.US = 0;
        this.UU = 0;
        this.UT = 0;
        this.mfj = null;
        this.mContent = "";
        this.meB = "";
        this.mfk = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.meB = PickerView.this.mfj[i];
                PickerView.this.ixw.setText(PickerView.this.meB);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ixw = null;
        this.mfi = null;
        this.mType = -1;
        this.UQ = 0;
        this.UR = 0;
        this.US = 0;
        this.UU = 0;
        this.UT = 0;
        this.mfj = null;
        this.mContent = "";
        this.meB = "";
        this.mfk = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.meB = PickerView.this.mfj[i2];
                PickerView.this.ixw.setText(PickerView.this.meB);
            }
        };
        init();
    }

    private void init() {
        Yn();
        dvp();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Yn() {
        this.ixw = new TextView(this.mContext);
        this.ixw.setTextSize(0, this.cnX);
        this.ixw.setTextColor(this.meZ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.ixw, layoutParams);
    }

    private void dvp() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.mfi = new ImageView(this.mContext);
        this.mfi.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mfi, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.ixw.setText(this.mContent);
            this.ixw.setTextSize(0, this.cnX);
            ((ViewGroup.MarginLayoutParams) this.ixw.getLayoutParams()).leftMargin = this.meS;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mfi.getLayoutParams();
            marginLayoutParams.width = this.meS;
            marginLayoutParams.rightMargin = this.meS;
            switch (this.mType) {
                case 6:
                    if (eVar.mck != null && eVar.mck.length > 0) {
                        this.mfj = eVar.mck;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.UQ = calendar.get(1);
                    this.UR = calendar.get(2);
                    this.US = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.UT = calendar2.get(10);
                    this.UU = calendar2.get(12);
                    break;
                default:
                    this.UQ = 0;
                    this.UR = 0;
                    this.US = 0;
                    this.UT = 0;
                    this.UU = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int dvo() {
        return this.meV;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.UQ = datePicker.getYear();
        this.UR = datePicker.getMonth();
        this.US = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.UQ).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.UR + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.US);
        this.meB = sb.toString();
        this.ixw.setText(this.meB);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.meB = dh(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.meB)) {
                this.meB = dh(this.UT, this.UU);
            }
            this.ixw.setText(this.meB);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.mfj != null && this.mfj.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.mfj, this.mfk).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.UQ, this.UR, this.US);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.UT));
                timePicker.setCurrentMinute(Integer.valueOf(this.UU));
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
                if (!PickerView.this.dvf()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dvf() {
        return !TextUtils.isEmpty(this.meB);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.meB;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.meB = "";
    }

    private String dh(int i, int i2) {
        this.UT = i;
        this.UU = i2;
        String num = Integer.toString(this.UU);
        String num2 = Integer.toString(this.UT);
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
