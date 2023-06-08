package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.xml.sax.Attributes;
/* loaded from: classes6.dex */
public class jk6 extends ik6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ik6
    public void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
        }
    }

    public jk6() {
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

    @Override // com.baidu.tieba.ik6
    public void b(boolean z, String str, Attributes attributes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, attributes}) == null) {
            String value = attributes.getValue("", NativeConstants.HREF);
            if (TextUtils.equals(attributes.getValue("", "rel"), "stylesheet") && !TextUtils.isEmpty(value)) {
                String str2 = "http";
                if (!value.startsWith("http")) {
                    StringBuilder sb = new StringBuilder();
                    if (z) {
                        str2 = "https";
                    }
                    sb.append(str2);
                    sb.append(":");
                    sb.append(value);
                    value = sb.toString();
                }
                mk6.g().b(value, value, new HashMap());
            }
        }
    }
}
