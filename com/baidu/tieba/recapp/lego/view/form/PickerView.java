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
/* loaded from: classes4.dex */
public class PickerView extends FormItemBaseView implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePicker.OnTimeChangedListener, DialogInterface.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public String[] F;
    public String G;
    public String H;
    public DialogInterface.OnClickListener I;
    public TextView x;
    public ImageView y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickerView f20704e;

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
            this.f20704e = pickerView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                PickerView pickerView = this.f20704e;
                pickerView.H = pickerView.F[i2];
                this.f20704e.x.setText(this.f20704e.H);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickerView f20705e;

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
            this.f20705e = pickerView;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (!this.f20705e.a()) {
                    PickerView pickerView = this.f20705e;
                    pickerView.c(pickerView, FormItemBaseView.DrawableType.ERROR_FRAME);
                    return;
                }
                PickerView pickerView2 = this.f20705e;
                pickerView2.c(pickerView2, FormItemBaseView.DrawableType.ORDINARY_FRAME);
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
        this.x = null;
        this.y = null;
        this.z = -1;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = "";
        this.H = "";
        this.I = new a(this);
        l();
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.H) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.H = "";
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean g(FormCard.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            if (super.g(bVar)) {
                FormCard.e eVar = (FormCard.e) bVar;
                this.z = eVar.f20619a;
                String str = eVar.f20620b;
                this.G = str;
                this.x.setText(str);
                this.x.setTextSize(0, this.n);
                ((ViewGroup.MarginLayoutParams) this.x.getLayoutParams()).leftMargin = this.f20700g;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                int i2 = this.f20700g;
                marginLayoutParams.width = i2;
                marginLayoutParams.rightMargin = i2;
                int i3 = this.z;
                if (i3 == 6) {
                    String[] strArr = eVar.f20626d;
                    if (strArr == null || strArr.length <= 0) {
                        return false;
                    }
                    this.F = strArr;
                } else if (i3 == 7) {
                    Calendar calendar = Calendar.getInstance();
                    this.A = calendar.get(1);
                    this.B = calendar.get(2);
                    this.C = calendar.get(5);
                } else if (i3 != 8) {
                    this.A = 0;
                    this.B = 0;
                    this.C = 0;
                    this.E = 0;
                    this.D = 0;
                    return false;
                } else {
                    Calendar calendar2 = Calendar.getInstance();
                    this.E = calendar2.get(10);
                    this.D = calendar2.get(12);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.H : (String) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            n();
            m();
            setOnClickListener(this);
            c(this, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Drawable drawable = this.f20699f.getDrawable(R.drawable.form_picker_arrow);
            ImageView imageView = new ImageView(this.f20698e);
            this.y = imageView;
            imageView.setBackgroundDrawable(drawable);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.y, layoutParams);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TextView textView = new TextView(this.f20698e);
            this.x = textView;
            textView.setTextSize(0, this.n);
            this.x.setTextColor(this.m);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            layoutParams.addRule(9);
            addView(this.x, layoutParams);
        }
    }

    public final void o(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dialog) == null) {
            dialog.setOnDismissListener(new b(this));
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, dialogInterface, i2) == null) && i2 == -1) {
            if (TextUtils.isEmpty(this.H)) {
                this.H = p(this.E, this.D);
            }
            this.x.setText(this.H);
        }
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048587, this, datePicker, i2, i3, i4) == null) {
            this.A = datePicker.getYear();
            this.B = datePicker.getMonth();
            this.C = datePicker.getDayOfMonth();
            String str = this.A + "-" + (this.B + 1) + "-" + this.C;
            this.H = str;
            this.x.setText(str);
        }
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, timePicker, i2, i3) == null) {
            this.H = p(i2, i3);
        }
    }

    public final String p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
            this.E = i2;
            this.D = i3;
            String num = Integer.toString(i3);
            String num2 = Integer.toString(this.E);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            int i2 = this.z;
            if (i2 == 6) {
                String[] strArr = this.F;
                if (strArr == null || strArr.length <= 0) {
                    return;
                }
                o(new AlertDialog.Builder(this.f20698e).setTitle(this.G).setItems(this.F, this.I).show());
            } else if (i2 == 7) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.f20698e, this, this.A, this.B, this.C);
                datePickerDialog.getDatePicker().setDescendantFocusability(393216);
                datePickerDialog.show();
                o(datePickerDialog);
            } else if (i2 != 8) {
            } else {
                TimePicker timePicker = new TimePicker(this.f20698e);
                timePicker.setCurrentHour(Integer.valueOf(this.E));
                timePicker.setCurrentMinute(Integer.valueOf(this.D));
                timePicker.setDescendantFocusability(393216);
                timePicker.setOnTimeChangedListener(this);
                timePicker.setIs24HourView(Boolean.TRUE);
                o(new AlertDialog.Builder(this.f20698e).setView(timePicker).setPositiveButton(R.string.dialog_ok, this).setNegativeButton(R.string.dialog_cancel, this).show());
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
        this.x = null;
        this.y = null;
        this.z = -1;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = "";
        this.H = "";
        this.I = new a(this);
        l();
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
        this.x = null;
        this.y = null;
        this.z = -1;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = "";
        this.H = "";
        this.I = new a(this);
        l();
    }
}
