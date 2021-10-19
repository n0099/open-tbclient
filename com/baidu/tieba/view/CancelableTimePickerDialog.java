package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CancelableTimePickerDialog extends TimePickerDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f58221e;

    /* renamed from: f  reason: collision with root package name */
    public int f58222f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58223g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CancelableTimePickerDialog(Context context, int i2, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i3, int i4, boolean z) {
        super(context, i2, onTimeSetListener, i3, i4, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i2), onTimeSetListener, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (TimePickerDialog.OnTimeSetListener) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58221e = -1;
        this.f58222f = -1;
        this.f58223g = false;
        this.f58221e = i3;
        this.f58222f = i4;
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
            if (i2 == -1) {
                this.f58223g = true;
            } else {
                int i4 = this.f58221e;
                if (i4 >= 0 && (i3 = this.f58222f) >= 0) {
                    updateTime(i4, i3);
                }
            }
            super.onClick(dialogInterface, i2);
        }
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            updateTime(0, 0);
            this.f58221e = bundle.getInt("hour_key");
            int i2 = bundle.getInt("min_key");
            this.f58222f = i2;
            updateTime(this.f58221e, i2);
        }
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundle;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                bundle = super.onSaveInstanceState();
            } catch (Exception unused) {
                bundle = null;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("hour_key", this.f58221e);
            bundle.putInt("min_key", this.f58222f);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // android.app.Dialog
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.f58223g) {
                updateTime(this.f58221e, this.f58222f);
            }
            super.onStop();
        }
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.updateTime(i2, i3);
            this.f58221e = i2;
            this.f58222f = i3;
            this.f58223g = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CancelableTimePickerDialog(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, boolean z) {
        super(context, onTimeSetListener, i2, i3, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onTimeSetListener, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (TimePickerDialog.OnTimeSetListener) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58221e = -1;
        this.f58222f = -1;
        this.f58223g = false;
        this.f58221e = i2;
        this.f58222f = i3;
    }
}
