package com.baidu.webkit.sdk.system;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebBackForwardList;
import com.baidu.webkit.sdk.WebHistoryItem;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public final class WebBackForwardListImpl extends WebBackForwardList implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static Method cloneMethod;
    public transient /* synthetic */ FieldHolder $fh;
    public final android.webkit.WebBackForwardList mList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-463272281, "Lcom/baidu/webkit/sdk/system/WebBackForwardListImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-463272281, "Lcom/baidu/webkit/sdk/system/WebBackForwardListImpl;");
                return;
            }
        }
        try {
            cloneMethod = android.webkit.WebBackForwardList.class.getDeclaredMethod("clone", null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public WebBackForwardListImpl(android.webkit.WebBackForwardList webBackForwardList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webBackForwardList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mList = webBackForwardList;
    }

    public static WebBackForwardList from(android.webkit.WebBackForwardList webBackForwardList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, webBackForwardList)) == null) {
            if (webBackForwardList == null) {
                return null;
            }
            return new WebBackForwardListImpl(webBackForwardList);
        }
        return (WebBackForwardList) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.webkit.sdk.WebBackForwardList
    public final WebBackForwardList clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (cloneMethod != null && this.mList != null) {
                    return from((android.webkit.WebBackForwardList) cloneMethod.invoke(this.mList, null));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
        return (WebBackForwardList) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebBackForwardList
    public final int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mList.getCurrentIndex() : invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebBackForwardList
    public final WebHistoryItem getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? WebHistoryItemImpl.from(this.mList.getCurrentItem()) : (WebHistoryItem) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebBackForwardList
    public final WebHistoryItem getItemAtIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? WebHistoryItemImpl.from(this.mList.getItemAtIndex(i2)) : (WebHistoryItem) invokeI.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebBackForwardList
    public final int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mList.getSize() : invokeV.intValue;
    }
}
