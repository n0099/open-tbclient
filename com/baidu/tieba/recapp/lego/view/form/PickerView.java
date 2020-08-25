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
    private int Ue;
    private int Uf;
    private int Ug;
    private int Uh;
    private int Ui;
    private TextView ibo;
    private ImageView lGJ;
    private String[] lGK;
    private DialogInterface.OnClickListener lGL;
    private String lGc;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.ibo = null;
        this.lGJ = null;
        this.mType = -1;
        this.Ue = 0;
        this.Uf = 0;
        this.Ug = 0;
        this.Ui = 0;
        this.Uh = 0;
        this.lGK = null;
        this.mContent = "";
        this.lGc = "";
        this.lGL = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.lGc = PickerView.this.lGK[i];
                PickerView.this.ibo.setText(PickerView.this.lGc);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ibo = null;
        this.lGJ = null;
        this.mType = -1;
        this.Ue = 0;
        this.Uf = 0;
        this.Ug = 0;
        this.Ui = 0;
        this.Uh = 0;
        this.lGK = null;
        this.mContent = "";
        this.lGc = "";
        this.lGL = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.lGc = PickerView.this.lGK[i];
                PickerView.this.ibo.setText(PickerView.this.lGc);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ibo = null;
        this.lGJ = null;
        this.mType = -1;
        this.Ue = 0;
        this.Uf = 0;
        this.Ug = 0;
        this.Ui = 0;
        this.Uh = 0;
        this.lGK = null;
        this.mContent = "";
        this.lGc = "";
        this.lGL = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.lGc = PickerView.this.lGK[i2];
                PickerView.this.ibo.setText(PickerView.this.lGc);
            }
        };
        init();
    }

    private void init() {
        VH();
        dnS();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void VH() {
        this.ibo = new TextView(this.mContext);
        this.ibo.setTextSize(0, this.bZC);
        this.ibo.setTextColor(this.lGA);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.ibo, layoutParams);
    }

    private void dnS() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.lGJ = new ImageView(this.mContext);
        this.lGJ.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.lGJ, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.ibo.setText(this.mContent);
            this.ibo.setTextSize(0, this.bZC);
            ((ViewGroup.MarginLayoutParams) this.ibo.getLayoutParams()).leftMargin = this.lGt;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lGJ.getLayoutParams();
            marginLayoutParams.width = this.lGt;
            marginLayoutParams.rightMargin = this.lGt;
            switch (this.mType) {
                case 6:
                    if (eVar.lDO != null && eVar.lDO.length > 0) {
                        this.lGK = eVar.lDO;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Ue = calendar.get(1);
                    this.Uf = calendar.get(2);
                    this.Ug = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Uh = calendar2.get(10);
                    this.Ui = calendar2.get(12);
                    break;
                default:
                    this.Ue = 0;
                    this.Uf = 0;
                    this.Ug = 0;
                    this.Uh = 0;
                    this.Ui = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int dnR() {
        return this.lGw;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Ue = datePicker.getYear();
        this.Uf = datePicker.getMonth();
        this.Ug = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Ue).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Uf + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Ug);
        this.lGc = sb.toString();
        this.ibo.setText(this.lGc);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.lGc = de(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.lGc)) {
                this.lGc = de(this.Uh, this.Ui);
            }
            this.ibo.setText(this.lGc);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.lGK != null && this.lGK.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.lGK, this.lGL).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Ue, this.Uf, this.Ug);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Uh));
                timePicker.setCurrentMinute(Integer.valueOf(this.Ui));
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
                if (!PickerView.this.dnI()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dnI() {
        return !TextUtils.isEmpty(this.lGc);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.lGc;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lGc = "";
    }

    private String de(int i, int i2) {
        this.Uh = i;
        this.Ui = i2;
        String num = Integer.toString(this.Ui);
        String num2 = Integer.toString(this.Uh);
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
