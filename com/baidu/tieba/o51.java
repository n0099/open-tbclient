package com.baidu.tieba;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface o51 {
    public static final ServiceReference a = new ServiceReference("nad.core", "toast");
    public static final o51 b = new a();

    void a(@NonNull Context context, @StringRes int i);

    void b(@NonNull Context context, String str, int i);

    void c(@NonNull Context context, @StringRes int i, int i2);

    void showToast(@NonNull Context context, String str);

    /* loaded from: classes7.dex */
    public class a implements o51 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.o51
        public void a(@NonNull Context context, @StringRes int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, context, i) == null) {
                Toast.makeText(context, i, 0).show();
            }
        }

        @Override // com.baidu.tieba.o51
        public void showToast(@NonNull Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
                Toast.makeText(context, str, 0).show();
            }
        }

        @Override // com.baidu.tieba.o51
        public void b(@NonNull Context context, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, i) == null) {
                Toast.makeText(context, str, i).show();
            }
        }

        @Override // com.baidu.tieba.o51
        public void c(@NonNull Context context, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, context, i, i2) == null) {
                Toast.makeText(context, i, i2).show();
            }
        }
    }
}
