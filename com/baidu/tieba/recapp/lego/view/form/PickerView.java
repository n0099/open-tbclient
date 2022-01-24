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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes12.dex */
public class PickerView extends FormItemBaseView implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePicker.OnTimeChangedListener, DialogInterface.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f47636e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f47637f;

    /* renamed from: g  reason: collision with root package name */
    public int f47638g;

    /* renamed from: h  reason: collision with root package name */
    public int f47639h;

    /* renamed from: i  reason: collision with root package name */
    public int f47640i;

    /* renamed from: j  reason: collision with root package name */
    public int f47641j;
    public int k;
    public int l;
    public String[] m;
    public String n;
    public String o;
    public DialogInterface.OnClickListener p;

    /* loaded from: classes12.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickerView f47642e;

        public a(PickerView pickerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47642e = pickerView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                PickerView pickerView = this.f47642e;
                pickerView.o = pickerView.m[i2];
                this.f47642e.f47636e.setText(this.f47642e.o);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickerView f47643e;

        public b(PickerView pickerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47643e = pickerView;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (!this.f47643e.isPrepareToCommit()) {
                    PickerView pickerView = this.f47643e;
                    pickerView.drawBackgroundFrame(pickerView, FormItemBaseView.DrawableType.ERROR_FRAME);
                    return;
                }
                PickerView pickerView2 = this.f47643e;
                pickerView2.drawBackgroundFrame(pickerView2, FormItemBaseView.DrawableType.ORDINARY_FRAME);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47636e = null;
        this.f47637f = null;
        this.f47638g = -1;
        this.f47639h = 0;
        this.f47640i = 0;
        this.f47641j = 0;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = "";
        this.o = "";
        this.p = new a(this);
        f();
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int compoundHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSize80 : invokeV.intValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
            g();
            setOnClickListener(this);
            drawBackgroundFrame(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Drawable drawable = this.mResources.getDrawable(R.drawable.form_picker_arrow);
            ImageView imageView = new ImageView(this.mContext);
            this.f47637f = imageView;
            imageView.setBackgroundDrawable(drawable);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.f47637f, layoutParams);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TextView textView = new TextView(this.mContext);
            this.f47636e = textView;
            textView.setTextSize(0, this.mFontSize);
            this.f47636e.setTextColor(this.mHintFontColor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            layoutParams.addRule(9);
            addView(this.f47636e, layoutParams);
        }
    }

    public final void i(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dialog) == null) {
            dialog.setOnDismissListener(new b(this));
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView, com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean isPrepareToCommit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(this.o) : invokeV.booleanValue;
    }

    public final String j(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
            this.l = i2;
            this.k = i3;
            String num = Integer.toString(i3);
            String num2 = Integer.toString(this.l);
            if (Pattern.matches("\\d", num2)) {
                num2 = "0" + num2;
            }
            if (Pattern.matches("\\d", num)) {
                num = "0" + num;
            }
            return num2 + ":" + num;
        }
        return (String) invokeII.objValue;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, dialogInterface, i2) == null) && i2 == -1) {
            if (TextUtils.isEmpty(this.o)) {
                this.o = j(this.l, this.k);
            }
            this.f47636e.setText(this.o);
        }
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048586, this, datePicker, i2, i3, i4) == null) {
            this.f47639h = datePicker.getYear();
            this.f47640i = datePicker.getMonth();
            this.f47641j = datePicker.getDayOfMonth();
            String str = this.f47639h + "-" + (this.f47640i + 1) + "-" + this.f47641j;
            this.o = str;
            this.f47636e.setText(str);
        }
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048587, this, timePicker, i2, i3) == null) {
            this.o = j(i2, i3);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.o = "";
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean updateView(FormCard.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bVar)) == null) {
            if (super.updateView(bVar)) {
                FormCard.e eVar = (FormCard.e) bVar;
                this.f47638g = eVar.a;
                String str = eVar.f47545b;
                this.n = str;
                this.f47636e.setText(str);
                this.f47636e.setTextSize(0, this.mFontSize);
                ((ViewGroup.MarginLayoutParams) this.f47636e.getLayoutParams()).leftMargin = this.mSize20;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47637f.getLayoutParams();
                int i2 = this.mSize20;
                marginLayoutParams.width = i2;
                marginLayoutParams.rightMargin = i2;
                int i3 = this.f47638g;
                if (i3 == 6) {
                    String[] strArr = eVar.f47551d;
                    if (strArr == null || strArr.length <= 0) {
                        return false;
                    }
                    this.m = strArr;
                } else if (i3 == 7) {
                    Calendar calendar = Calendar.getInstance();
                    this.f47639h = calendar.get(1);
                    this.f47640i = calendar.get(2);
                    this.f47641j = calendar.get(5);
                } else if (i3 != 8) {
                    this.f47639h = 0;
                    this.f47640i = 0;
                    this.f47641j = 0;
                    this.l = 0;
                    this.k = 0;
                    return false;
                } else {
                    Calendar calendar2 = Calendar.getInstance();
                    this.l = calendar2.get(10);
                    this.k = calendar2.get(12);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            int i2 = this.f47638g;
            if (i2 == 6) {
                String[] strArr = this.m;
                if (strArr == null || strArr.length <= 0) {
                    return;
                }
                i(new AlertDialog.Builder(this.mContext).setTitle(this.n).setItems(this.m, this.p).show());
            } else if (i2 == 7) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, this, this.f47639h, this.f47640i, this.f47641j);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                i(datePickerDialog);
            } else if (i2 != 8) {
            } else {
                TimePicker timePicker = new TimePicker(this.mContext);
                timePicker.setCurrentHour(Integer.valueOf(this.l));
                timePicker.setCurrentMinute(Integer.valueOf(this.k));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(Boolean.TRUE);
                i(new AlertDialog.Builder(this.mContext).setView(timePicker).setPositiveButton(R.string.dialog_ok, this).setNegativeButton(R.string.dialog_cancel, this).show());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47636e = null;
        this.f47637f = null;
        this.f47638g = -1;
        this.f47639h = 0;
        this.f47640i = 0;
        this.f47641j = 0;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = "";
        this.o = "";
        this.p = new a(this);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47636e = null;
        this.f47637f = null;
        this.f47638g = -1;
        this.f47639h = 0;
        this.f47640i = 0;
        this.f47641j = 0;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = "";
        this.o = "";
        this.p = new a(this);
        f();
    }
}
