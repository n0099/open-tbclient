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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int De;
    private int Df;
    private int Dg;
    private int Dh;
    private int Di;
    private TextView dAU;
    private String gbP;
    private DialogInterface.OnClickListener gcA;
    private ImageView gcy;
    private String[] gcz;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.dAU = null;
        this.gcy = null;
        this.mType = -1;
        this.De = 0;
        this.Df = 0;
        this.Dg = 0;
        this.Di = 0;
        this.Dh = 0;
        this.gcz = null;
        this.mContent = "";
        this.gbP = "";
        this.gcA = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gbP = PickerView.this.gcz[i];
                PickerView.this.dAU.setText(PickerView.this.gbP);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dAU = null;
        this.gcy = null;
        this.mType = -1;
        this.De = 0;
        this.Df = 0;
        this.Dg = 0;
        this.Di = 0;
        this.Dh = 0;
        this.gcz = null;
        this.mContent = "";
        this.gbP = "";
        this.gcA = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gbP = PickerView.this.gcz[i];
                PickerView.this.dAU.setText(PickerView.this.gbP);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dAU = null;
        this.gcy = null;
        this.mType = -1;
        this.De = 0;
        this.Df = 0;
        this.Dg = 0;
        this.Di = 0;
        this.Dh = 0;
        this.gcz = null;
        this.mContent = "";
        this.gbP = "";
        this.gcA = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.gbP = PickerView.this.gcz[i2];
                PickerView.this.dAU.setText(PickerView.this.gbP);
            }
        };
        init();
    }

    private void init() {
        initContentView();
        bjU();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void initContentView() {
        this.dAU = new TextView(this.mContext);
        this.dAU.setTextSize(0, this.gcp);
        this.dAU.setTextColor(this.gco);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.dAU, layoutParams);
    }

    private void bjU() {
        Drawable drawable = this.mResources.getDrawable(d.f.form_picker_arrow);
        this.gcy = new ImageView(this.mContext);
        this.gcy.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gcy, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.dAU.setText(this.mContent);
            this.dAU.setTextSize(0, this.gcp);
            ((ViewGroup.MarginLayoutParams) this.dAU.getLayoutParams()).leftMargin = this.gch;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gcy.getLayoutParams();
            marginLayoutParams.width = this.gch;
            marginLayoutParams.rightMargin = this.gch;
            switch (this.mType) {
                case 6:
                    if (eVar.fZo != null && eVar.fZo.length > 0) {
                        this.gcz = eVar.fZo;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.De = calendar.get(1);
                    this.Df = calendar.get(2);
                    this.Dg = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Dh = calendar2.get(10);
                    this.Di = calendar2.get(12);
                    break;
                default:
                    this.De = 0;
                    this.Df = 0;
                    this.Dg = 0;
                    this.Dh = 0;
                    this.Di = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int bjT() {
        return this.gck;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.De = datePicker.getYear();
        this.Df = datePicker.getMonth();
        this.Dg = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.De).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Df + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Dg);
        this.gbP = sb.toString();
        this.dAU.setText(this.gbP);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gbP = bA(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gbP)) {
                this.gbP = bA(this.Dh, this.Di);
            }
            this.dAU.setText(this.gbP);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        switch (this.mType) {
            case 6:
                if (this.gcz != null && this.gcz.length > 0) {
                    b(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.gcz, this.gcA).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.De, this.Df, this.Dg);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                b(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Dh));
                timePicker.setCurrentMinute(Integer.valueOf(this.Di));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                b(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(d.k.dialog_ok, this).setNegativeButton(d.k.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void b(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!PickerView.this.bjK()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bjK() {
        return !TextUtils.isEmpty(this.gbP);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gbP;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gbP = "";
    }

    private String bA(int i, int i2) {
        this.Dh = i;
        this.Di = i2;
        String num = Integer.toString(this.Di);
        String num2 = Integer.toString(this.Dh);
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
