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
/* loaded from: classes7.dex */
public class PickerView extends FormItemBaseView implements DatePickerDialog.OnDateSetListener, DialogInterface.OnClickListener, View.OnClickListener, TimePicker.OnTimeChangedListener {
    private int Xc;
    private int Xe;
    private int Xf;
    private int Xg;
    private int Xh;
    private TextView jqG;
    private String mContent;
    private int mType;
    private ImageView mYG;
    private String[] mYH;
    private DialogInterface.OnClickListener mYI;
    private String mYa;

    public PickerView(Context context) {
        super(context);
        this.jqG = null;
        this.mYG = null;
        this.mType = -1;
        this.Xc = 0;
        this.Xe = 0;
        this.Xf = 0;
        this.Xh = 0;
        this.Xg = 0;
        this.mYH = null;
        this.mContent = "";
        this.mYa = "";
        this.mYI = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mYa = PickerView.this.mYH[i];
                PickerView.this.jqG.setText(PickerView.this.mYa);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jqG = null;
        this.mYG = null;
        this.mType = -1;
        this.Xc = 0;
        this.Xe = 0;
        this.Xf = 0;
        this.Xh = 0;
        this.Xg = 0;
        this.mYH = null;
        this.mContent = "";
        this.mYa = "";
        this.mYI = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PickerView.this.mYa = PickerView.this.mYH[i];
                PickerView.this.jqG.setText(PickerView.this.mYa);
            }
        };
        init();
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jqG = null;
        this.mYG = null;
        this.mType = -1;
        this.Xc = 0;
        this.Xe = 0;
        this.Xf = 0;
        this.Xh = 0;
        this.Xg = 0;
        this.mYH = null;
        this.mContent = "";
        this.mYa = "";
        this.mYI = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.PickerView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PickerView.this.mYa = PickerView.this.mYH[i2];
                PickerView.this.jqG.setText(PickerView.this.mYa);
            }
        };
        init();
    }

    private void init() {
        Zo();
        dEj();
        setOnClickListener(this);
        a(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
    }

    private void Zo() {
        this.jqG = new TextView(this.mContext);
        this.jqG.setTextSize(0, this.cLA);
        this.jqG.setTextColor(this.mYy);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(this.jqG, layoutParams);
    }

    private void dEj() {
        Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
        this.mYG = new ImageView(this.mContext);
        this.mYG.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mYG, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.e eVar = (FormCard.e) bVar;
            this.mType = eVar.type;
            this.mContent = eVar.content;
            this.jqG.setText(this.mContent);
            this.jqG.setTextSize(0, this.cLA);
            ((ViewGroup.MarginLayoutParams) this.jqG.getLayoutParams()).leftMargin = this.mYr;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mYG.getLayoutParams();
            marginLayoutParams.width = this.mYr;
            marginLayoutParams.rightMargin = this.mYr;
            switch (this.mType) {
                case 6:
                    if (eVar.mVJ != null && eVar.mVJ.length > 0) {
                        this.mYH = eVar.mVJ;
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    Calendar calendar = Calendar.getInstance();
                    this.Xc = calendar.get(1);
                    this.Xe = calendar.get(2);
                    this.Xf = calendar.get(5);
                    break;
                case 8:
                    Calendar calendar2 = Calendar.getInstance();
                    this.Xg = calendar2.get(10);
                    this.Xh = calendar2.get(12);
                    break;
                default:
                    this.Xc = 0;
                    this.Xe = 0;
                    this.Xf = 0;
                    this.Xg = 0;
                    this.Xh = 0;
                    return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int dEi() {
        return this.mYu;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.Xc = datePicker.getYear();
        this.Xe = datePicker.getMonth();
        this.Xf = datePicker.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Xc).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Xe + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.Xf);
        this.mYa = sb.toString();
        this.jqG.setText(this.mYa);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.mYa = dk(i, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (TextUtils.isEmpty(this.mYa)) {
                this.mYa = dk(this.Xg, this.Xh);
            }
            this.jqG.setText(this.mYa);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 6:
                if (this.mYH != null && this.mYH.length > 0) {
                    g(new AlertDialog.Builder(this.mContext).setTitle(this.mContent).setItems(this.mYH, this.mYI).show());
                    return;
                }
                return;
            case 7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.Xc, this.Xe, this.Xf);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                g(datePickerDialog);
                return;
            case 8:
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.Xg));
                timePicker.setCurrentMinute(Integer.valueOf(this.Xh));
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
                if (!PickerView.this.dDZ()) {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ERROR_FRAME);
                } else {
                    PickerView.this.a(PickerView.this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDZ() {
        return !TextUtils.isEmpty(this.mYa);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return this.mYa;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mYa = "";
    }

    private String dk(int i, int i2) {
        this.Xg = i;
        this.Xh = i2;
        String num = Integer.toString(this.Xh);
        String num2 = Integer.toString(this.Xg);
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
