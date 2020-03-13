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
/* loaded from: classes13.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private TextView gvB;
    private String jKv;
    private ImageView jLc;
    private String[] jLd;
    private DialogInterface.OnClickListener jLe;
    private String mContent;
    private int mType;
    private int zD;
    private int zE;
    private int zF;
    private int zG;
    private int zH;

    public PickerView(Context context) {
        super(context);
        this.gvB = null;
        this.jLc = null;
        this.mType = -1;
        this.zD = 0;
        this.zE = 0;
        this.zF = 0;
        this.zH = 0;
        this.zG = 0;
        this.jLd = null;
        this.mContent = "";
        this.jKv = "";
        this.jLe = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.jKv = PickerView.this.jLd[i];
                PickerView.this.gvB.setText(PickerView.this.jKv);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvB = null;
        this.jLc = null;
        this.mType = -1;
        this.zD = 0;
        this.zE = 0;
        this.zF = 0;
        this.zH = 0;
        this.zG = 0;
        this.jLd = null;
        this.mContent = "";
        this.jKv = "";
        this.jLe = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.jKv = PickerView.this.jLd[i];
                PickerView.this.gvB.setText(PickerView.this.jKv);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvB = null;
        this.jLc = null;
        this.mType = -1;
        this.zD = 0;
        this.zE = 0;
        this.zF = 0;
        this.zH = 0;
        this.zG = 0;
        this.jLd = null;
        this.mContent = "";
        this.jKv = "";
        this.jLe = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.jKv = PickerView.this.jLd[i2];
                PickerView.this.gvB.setText(PickerView.this.jKv);
            }
        };
        init();
    }

    private void init() {
        initContentView();
        bLS();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void initContentView() {
        this.gvB = new TextView(this.mContext);
        this.gvB.setTextSize(0, this.bgT);
        this.gvB.setTextColor(this.jKT);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.gvB, layoutParams);
    }

    private void bLS() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.jLc = new ImageView(this.mContext);
        this.jLc.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.jLc, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.gvB.setText(this.mContent);
            this.gvB.setTextSize(0, this.bgT);
            ((ViewGroup.MarginLayoutParams) this.gvB.getLayoutParams()).leftMargin = this.jKM;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jLc.getLayoutParams();
            marginLayoutParams.width = this.jKM;
            marginLayoutParams.rightMargin = this.jKM;
            switch (this.mType) {
                case 6:
                    if (eVar.jHL != null && eVar.jHL.length > 0) {
                        this.jLd = eVar.jHL;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.zD = calendar.get(1);
                    this.zE = calendar.get(2);
                    this.zF = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.zG = calendar2.get(10);
                    this.zH = calendar2.get(12);
                    break;
                default:
                    this.zD = 0;
                    this.zE = 0;
                    this.zF = 0;
                    this.zG = 0;
                    this.zH = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int cDh() {
        return this.jKP;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.zD = datePicker.getYear();
        this.zE = datePicker.getMonth();
        this.zF = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.zD).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.zE + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.zF);
        this.jKv = sb.toString();
        this.gvB.setText(this.jKv);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.jKv = cC(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.jKv)) {
                this.jKv = cC(this.zG, this.zH);
            }
            this.gvB.setText(this.jKv);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.jLd != null && this.jLd.length > 0) {
                    c(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.jLd, this.jLe).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.zD, this.zE, this.zF);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                c(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.zG));
                timePicker.setCurrentMinute(Integer.valueOf(this.zH));
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
                if (!PickerView.this.cCY()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cCY() {
        return !TextUtils.isEmpty(this.jKv);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.jKv;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jKv = "";
    }

    private String cC(int i, int i2) {
        this.zG = i;
        this.zH = i2;
        String num = Integer.toString(this.zH);
        String num2 = Integer.toString(this.zG);
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
