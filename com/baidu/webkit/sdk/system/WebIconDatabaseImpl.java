package com.baidu.webkit.sdk.system;

import android.graphics.Bitmap;
import android.os.Looper;
import android.webkit.WebIconDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebIconDatabase;
/* loaded from: classes11.dex */
public final class WebIconDatabaseImpl extends WebIconDatabase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class IconWrapper implements WebIconDatabase.IconListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebIconDatabase.IconListener mListener;

        public IconWrapper(WebIconDatabase.IconListener iconListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iconListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mListener = iconListener;
        }

        public static WebIconDatabase.IconListener from(WebIconDatabase.IconListener iconListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iconListener)) == null) {
                if (iconListener == null) {
                    return null;
                }
                return new IconWrapper(iconListener);
            }
            return (WebIconDatabase.IconListener) invokeL.objValue;
        }

        @Override // android.webkit.WebIconDatabase.IconListener
        public void onReceivedIcon(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                this.mListener.onReceivedIcon(str, bitmap);
            }
        }
    }

    public WebIconDatabaseImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            android.webkit.WebIconDatabase.getInstance().close();
        }
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void open(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Looper.prepare();
            android.webkit.WebIconDatabase.getInstance().open(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void releaseIconForPageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void removeAllIcons() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        }
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void requestIconForPageUrl(String str, WebIconDatabase.IconListener iconListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, iconListener) == null) {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, IconWrapper.from(iconListener));
        }
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void retainIconForPageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        }
    }
}
