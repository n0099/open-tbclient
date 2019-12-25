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
/* loaded from: classes10.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private TextView gqd;
    private String jFE;
    private ImageView jGl;
    private String[] jGm;
    private DialogInterface.OnClickListener jGn;
    private String mContent;
    private int mType;
    private int zh;
    private int zi;
    private int zj;
    private int zk;
    private int zl;

    public PickerView(Context context) {
        super(context);
        this.gqd = null;
        this.jGl = null;
        this.mType = -1;
        this.zh = 0;
        this.zi = 0;
        this.zj = 0;
        this.zl = 0;
        this.zk = 0;
        this.jGm = null;
        this.mContent = "";
        this.jFE = "";
        this.jGn = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.jFE = PickerView.this.jGm[i];
                PickerView.this.gqd.setText(PickerView.this.jFE);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gqd = null;
        this.jGl = null;
        this.mType = -1;
        this.zh = 0;
        this.zi = 0;
        this.zj = 0;
        this.zl = 0;
        this.zk = 0;
        this.jGm = null;
        this.mContent = "";
        this.jFE = "";
        this.jGn = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.jFE = PickerView.this.jGm[i];
                PickerView.this.gqd.setText(PickerView.this.jFE);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gqd = null;
        this.jGl = null;
        this.mType = -1;
        this.zh = 0;
        this.zi = 0;
        this.zj = 0;
        this.zl = 0;
        this.zk = 0;
        this.jGm = null;
        this.mContent = "";
        this.jFE = "";
        this.jGn = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.jFE = PickerView.this.jGm[i2];
                PickerView.this.gqd.setText(PickerView.this.jFE);
            }
        };
        init();
    }

    private void init() {
        initContentView();
        cAA();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void initContentView() {
        this.gqd = new TextView(this.mContext);
        this.gqd.setTextSize(0, this.bbM);
        this.gqd.setTextColor(this.jGc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.gqd, layoutParams);
    }

    private void cAA() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.jGl = new ImageView(this.mContext);
        this.jGl.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.jGl, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.gqd.setText(this.mContent);
            this.gqd.setTextSize(0, this.bbM);
            ((ViewGroup.MarginLayoutParams) this.gqd.getLayoutParams()).leftMargin = this.jFV;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jGl.getLayoutParams();
            marginLayoutParams.width = this.jFV;
            marginLayoutParams.rightMargin = this.jFV;
            switch (this.mType) {
                case 6:
                    if (eVar.jCZ != null && eVar.jCZ.length > 0) {
                        this.jGm = eVar.jCZ;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.zh = calendar.get(1);
                    this.zi = calendar.get(2);
                    this.zj = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.zk = calendar2.get(10);
                    this.zl = calendar2.get(12);
                    break;
                default:
                    this.zh = 0;
                    this.zi = 0;
                    this.zj = 0;
                    this.zk = 0;
                    this.zl = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cAz() {
        return this.jFY;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.zh = datePicker.getYear();
        this.zi = datePicker.getMonth();
        this.zj = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.zh).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.zi + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.zj);
        this.jFE = sb.toString();
        this.gqd.setText(this.jFE);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.jFE = cC(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.jFE)) {
                this.jFE = cC(this.zk, this.zl);
            }
            this.gqd.setText(this.jFE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.jGm != null && this.jGm.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.jGm, this.jGn).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.zh, this.zi, this.zj);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.zk));
                timePicker.setCurrentMinute(Integer.valueOf(this.zl));
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
                if (!PickerView.this.cAq()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cAq() {
        return !TextUtils.isEmpty(this.jFE);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.jFE;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jFE = "";
    }

    private String cC(int i, int i2) {
        this.zk = i;
        this.zl = i2;
        String num = Integer.toString(this.zl);
        String num2 = Integer.toString(this.zk);
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
