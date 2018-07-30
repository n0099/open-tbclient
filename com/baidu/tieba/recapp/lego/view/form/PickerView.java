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
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int Jn;
    private int Jo;
    private int Jp;
    private int Jq;
    private int Jr;
    private TextView dsu;
    private ImageView gsT;
    private String[] gsU;
    private DialogInterface.OnClickListener gsV;
    private String gsk;
    private String mContent;
    private int mType;

    public PickerView(Context context) {
        super(context);
        this.dsu = null;
        this.gsT = null;
        this.mType = -1;
        this.Jn = 0;
        this.Jo = 0;
        this.Jp = 0;
        this.Jr = 0;
        this.Jq = 0;
        this.gsU = null;
        this.mContent = "";
        this.gsk = "";
        this.gsV = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gsk = PickerView.this.gsU[i];
                PickerView.this.dsu.setText(PickerView.this.gsk);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dsu = null;
        this.gsT = null;
        this.mType = -1;
        this.Jn = 0;
        this.Jo = 0;
        this.Jp = 0;
        this.Jr = 0;
        this.Jq = 0;
        this.gsU = null;
        this.mContent = "";
        this.gsk = "";
        this.gsV = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.gsk = PickerView.this.gsU[i];
                PickerView.this.dsu.setText(PickerView.this.gsk);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dsu = null;
        this.gsT = null;
        this.mType = -1;
        this.Jn = 0;
        this.Jo = 0;
        this.Jp = 0;
        this.Jr = 0;
        this.Jq = 0;
        this.gsU = null;
        this.mContent = "";
        this.gsk = "";
        this.gsV = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.gsk = PickerView.this.gsU[i2];
                PickerView.this.dsu.setText(PickerView.this.gsk);
            }
        };
        init();
    }

    private void init() {
        bnY();
        bnZ();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void bnY() {
        this.dsu = new TextView(this.mContext);
        this.dsu.setTextSize(0, this.gsK);
        this.dsu.setTextColor(this.gsJ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.dsu, layoutParams);
    }

    private void bnZ() {
        Drawable drawable = this.mResources.getDrawable(d.f.form_picker_arrow);
        this.gsT = new ImageView(this.mContext);
        this.gsT.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gsT, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.dsu.setText(this.mContent);
            this.dsu.setTextSize(0, this.gsK);
            ((ViewGroup.MarginLayoutParams) this.dsu.getLayoutParams()).leftMargin = this.gsC;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gsT.getLayoutParams();
            marginLayoutParams.width = this.gsC;
            marginLayoutParams.rightMargin = this.gsC;
            switch (this.mType) {
                case 6:
                    if (eVar.gpG != null && eVar.gpG.length > 0) {
                        this.gsU = eVar.gpG;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Jn = calendar.get(1);
                    this.Jo = calendar.get(2);
                    this.Jp = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Jq = calendar2.get(10);
                    this.Jr = calendar2.get(12);
                    break;
                default:
                    this.Jn = 0;
                    this.Jo = 0;
                    this.Jp = 0;
                    this.Jq = 0;
                    this.Jr = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int bnX() {
        return this.gsF;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Jn = datePicker.getYear();
        this.Jo = datePicker.getMonth();
        this.Jp = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Jn).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Jo + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Jp);
        this.gsk = sb.toString();
        this.dsu.setText(this.gsk);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.gsk = bC(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.gsk)) {
                this.gsk = bC(this.Jq, this.Jr);
            }
            this.dsu.setText(this.gsk);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.gsU != null && this.gsU.length > 0) {
                    a(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.gsU, this.gsV).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Jn, this.Jo, this.Jp);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                a(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Jq));
                timePicker.setCurrentMinute(Integer.valueOf(this.Jr));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                a(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(d.j.dialog_ok, this).setNegativeButton(d.j.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void a(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!PickerView.this.bnO()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bnO() {
        return !TextUtils.isEmpty(this.gsk);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.gsk;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gsk = "";
    }

    private String bC(int i, int i2) {
        this.Jq = i;
        this.Jr = i2;
        String num = Integer.toString(this.Jr);
        String num2 = Integer.toString(this.Jq);
        if (Pattern.matches("\\d", num2)) {
            num2 = "0" + num2;
        }
        if (Pattern.matches("\\d", num)) {
            num = "0" + num;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num2).append(SystemInfoUtil.COLON).append(num);
        return sb.toString();
    }
}
