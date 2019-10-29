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
/* loaded from: classes3.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private TextView fCI;
    private ImageView iMN;
    private String[] iMO;
    private DialogInterface.OnClickListener iMP;
    private String iMg;
    private String mContent;
    private int mType;
    private int xh;
    private int xi;
    private int xj;
    private int xk;
    private int xl;

    public PickerView(Context context) {
        super(context);
        this.fCI = null;
        this.iMN = null;
        this.mType = -1;
        this.xh = 0;
        this.xi = 0;
        this.xj = 0;
        this.xl = 0;
        this.xk = 0;
        this.iMO = null;
        this.mContent = "";
        this.iMg = "";
        this.iMP = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.iMg = PickerView.this.iMO[i];
                PickerView.this.fCI.setText(PickerView.this.iMg);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCI = null;
        this.iMN = null;
        this.mType = -1;
        this.xh = 0;
        this.xi = 0;
        this.xj = 0;
        this.xl = 0;
        this.xk = 0;
        this.iMO = null;
        this.mContent = "";
        this.iMg = "";
        this.iMP = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.iMg = PickerView.this.iMO[i];
                PickerView.this.fCI.setText(PickerView.this.iMg);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fCI = null;
        this.iMN = null;
        this.mType = -1;
        this.xh = 0;
        this.xi = 0;
        this.xj = 0;
        this.xl = 0;
        this.xk = 0;
        this.iMO = null;
        this.mContent = "";
        this.iMg = "";
        this.iMP = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.iMg = PickerView.this.iMO[i2];
                PickerView.this.fCI.setText(PickerView.this.iMg);
            }
        };
        init();
    }

    private void init() {
        cgy();
        cgz();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void cgy() {
        this.fCI = new TextView(this.mContext);
        this.fCI.setTextSize(0, this.aGv);
        this.fCI.setTextColor(this.iME);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.fCI, layoutParams);
    }

    private void cgz() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.iMN = new ImageView(this.mContext);
        this.iMN.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iMN, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.fCI.setText(this.mContent);
            this.fCI.setTextSize(0, this.aGv);
            ((ViewGroup.MarginLayoutParams) this.fCI.getLayoutParams()).leftMargin = this.iMx;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iMN.getLayoutParams();
            marginLayoutParams.width = this.iMx;
            marginLayoutParams.rightMargin = this.iMx;
            switch (this.mType) {
                case 6:
                    if (eVar.iJz != null && eVar.iJz.length > 0) {
                        this.iMO = eVar.iJz;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.xh = calendar.get(1);
                    this.xi = calendar.get(2);
                    this.xj = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.xk = calendar2.get(10);
                    this.xl = calendar2.get(12);
                    break;
                default:
                    this.xh = 0;
                    this.xi = 0;
                    this.xj = 0;
                    this.xk = 0;
                    this.xl = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cgx() {
        return this.iMA;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.xh = datePicker.getYear();
        this.xi = datePicker.getMonth();
        this.xj = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.xh).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.xi + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.xj);
        this.iMg = sb.toString();
        this.fCI.setText(this.iMg);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.iMg = ck(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.iMg)) {
                this.iMg = ck(this.xk, this.xl);
            }
            this.fCI.setText(this.iMg);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.iMO != null && this.iMO.length > 0) {
                    d(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.iMO, this.iMP).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.xh, this.xi, this.xj);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                d(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.xk));
                timePicker.setCurrentMinute(Integer.valueOf(this.xl));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(true);
                d(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(R.string.dialog_ok, this).setNegativeButton(R.string.dialog_cancel, this).show());
                return;
            default:
                return;
        }
    }

    private void d(Dialog dialog) {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!PickerView.this.cgo()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cgo() {
        return !TextUtils.isEmpty(this.iMg);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.iMg;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iMg = "";
    }

    private String ck(int i, int i2) {
        this.xk = i;
        this.xl = i2;
        String num = Integer.toString(this.xl);
        String num2 = Integer.toString(this.xk);
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
