package com.baidu.webkit.sdk.system;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebHistoryItem;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class WebHistoryItemImpl extends WebHistoryItem implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static Method cloneMethod;
    public transient /* synthetic */ FieldHolder $fh;
    public final android.webkit.WebHistoryItem mItem;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1447637668, "Lcom/baidu/webkit/sdk/system/WebHistoryItemImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1447637668, "Lcom/baidu/webkit/sdk/system/WebHistoryItemImpl;");
                return;
            }
        }
        try {
            cloneMethod = android.webkit.WebHistoryItem.class.getDeclaredMethod("clone", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebHistoryItemImpl(android.webkit.WebHistoryItem webHistoryItem) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webHistoryItem};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mItem = webHistoryItem;
    }

    public static WebHistoryItem from(android.webkit.WebHistoryItem webHistoryItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, webHistoryItem)) == null) {
            if (webHistoryItem == null) {
                return null;
            }
            return new WebHistoryItemImpl(webHistoryItem);
        }
        return (WebHistoryItem) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.webkit.sdk.WebHistoryItem
    /* renamed from: clone */
    public final WebHistoryItem mo76clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (cloneMethod != null && this.mItem != null) {
                    return from((android.webkit.WebHistoryItem) cloneMethod.invoke(this.mItem, null));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        return (WebHistoryItem) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebHistoryItem
    public final Bitmap getFavicon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mItem.getFavicon() : (Bitmap) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebHistoryItem
    public final String getOriginalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mItem.getOriginalUrl() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebHistoryItem
    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mItem.getTitle() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebHistoryItem
    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mItem.getUrl() : (String) invokeV.objValue;
    }
}
