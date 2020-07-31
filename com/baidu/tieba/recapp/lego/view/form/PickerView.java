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
/* loaded from: classes20.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int TA;
    private int TB;
    private int TC;
    private int TD;
    private int TF;
    private TextView hNh;
    private String lpF;
    private ImageView lqm;
    private String[] lqn;
    private DialogInterface.OnClickListener lqo;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.hNh = null;
        this.lqm = null;
        this.mType = -1;
        this.TA = 0;
        this.TB = 0;
        this.TC = 0;
        this.TF = 0;
        this.TD = 0;
        this.lqn = null;
        this.mContent = "";
        this.lpF = "";
        this.lqo = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.lpF = PickerView.this.lqn[i];
                PickerView.this.hNh.setText(PickerView.this.lpF);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNh = null;
        this.lqm = null;
        this.mType = -1;
        this.TA = 0;
        this.TB = 0;
        this.TC = 0;
        this.TF = 0;
        this.TD = 0;
        this.lqn = null;
        this.mContent = "";
        this.lpF = "";
        this.lqo = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.lpF = PickerView.this.lqn[i];
                PickerView.this.hNh.setText(PickerView.this.lpF);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNh = null;
        this.lqm = null;
        this.mType = -1;
        this.TA = 0;
        this.TB = 0;
        this.TC = 0;
        this.TF = 0;
        this.TD = 0;
        this.lqn = null;
        this.mContent = "";
        this.lpF = "";
        this.lqo = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.lpF = PickerView.this.lqn[i2];
                PickerView.this.hNh.setText(PickerView.this.lpF);
            }
        };
        init();
    }

    private void init() {
        PM();
        dcJ();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void PM() {
        this.hNh = new TextView(this.mContext);
        this.hNh.setTextSize(0, this.bTU);
        this.hNh.setTextColor(this.lqd);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.hNh, layoutParams);
    }

    private void dcJ() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.lqm = new ImageView(this.mContext);
        this.lqm.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.lqm, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.hNh.setText(this.mContent);
            this.hNh.setTextSize(0, this.bTU);
            ((ViewGroup.MarginLayoutParams) this.hNh.getLayoutParams()).leftMargin = this.lpW;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lqm.getLayoutParams();
            marginLayoutParams.width = this.lpW;
            marginLayoutParams.rightMargin = this.lpW;
            switch (this.mType) {
                case 6:
                    if (eVar.lnm != null && eVar.lnm.length > 0) {
                        this.lqn = eVar.lnm;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.TA = calendar.get(1);
                    this.TB = calendar.get(2);
                    this.TC = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.TD = calendar2.get(10);
                    this.TF = calendar2.get(12);
                    break;
                default:
                    this.TA = 0;
                    this.TB = 0;
                    this.TC = 0;
                    this.TD = 0;
                    this.TF = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int dcI() {
        return this.lpZ;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.TA = datePicker.getYear();
        this.TB = datePicker.getMonth();
        this.TC = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.TA).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.TB + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.TC);
        this.lpF = sb.toString();
        this.hNh.setText(this.lpF);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.lpF = cW(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.lpF)) {
                this.lpF = cW(this.TD, this.TF);
            }
            this.hNh.setText(this.lpF);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.lqn != null && this.lqn.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.lqn, this.lqo).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.TA, this.TB, this.TC);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.TD));
                timePicker.setCurrentMinute(Integer.valueOf(this.TF));
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
                if (!PickerView.this.dcz()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dcz() {
        return !TextUtils.isEmpty(this.lpF);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.lpF;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lpF = "";
    }

    private String cW(int i, int i2) {
        this.TD = i;
        this.TF = i2;
        String num = Integer.toString(this.TF);
        String num2 = Integer.toString(this.TD);
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
