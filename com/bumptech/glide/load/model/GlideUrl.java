package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes7.dex */
public class GlideUrl implements Key {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile byte[] cacheKeyBytes;
    public int hashCode;
    public final Headers headers;
    public String safeStringUrl;
    public URL safeUrl;
    public final String stringUrl;
    public final URL url;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlideUrl(String str) {
        this(str, Headers.DEFAULT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Headers) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public GlideUrl(String str, Headers headers) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, headers};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.url = null;
        this.stringUrl = Preconditions.checkNotEmpty(str);
        this.headers = (Headers) Preconditions.checkNotNull(headers);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlideUrl(URL url) {
        this(url, Headers.DEFAULT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URL) objArr2[0], (Headers) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public GlideUrl(URL url, Headers headers) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, headers};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.url = (URL) Preconditions.checkNotNull(url);
        this.stringUrl = null;
        this.headers = (Headers) Preconditions.checkNotNull(headers);
    }

    private byte[] getCacheKeyBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.cacheKeyBytes == null) {
                this.cacheKeyBytes = getCacheKey().getBytes(Key.CHARSET);
            }
            return this.cacheKeyBytes;
        }
        return (byte[]) invokeV.objValue;
    }

    private URL getSafeUrl() throws MalformedURLException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.safeUrl == null) {
                this.safeUrl = new URL(getSafeStringUrl());
            }
            return this.safeUrl;
        }
        return (URL) invokeV.objValue;
    }

    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.stringUrl;
            if (str == null) {
                return ((URL) Preconditions.checkNotNull(this.url)).toString();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public Map getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.headers.getHeaders();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.hashCode == 0) {
                int hashCode = getCacheKey().hashCode();
                this.hashCode = hashCode;
                this.hashCode = (hashCode * 31) + this.headers.hashCode();
            }
            return this.hashCode;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return getCacheKey();
        }
        return (String) invokeV.objValue;
    }

    public String toStringUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return getSafeStringUrl();
        }
        return (String) invokeV.objValue;
    }

    public URL toURL() throws MalformedURLException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getSafeUrl();
        }
        return (URL) invokeV.objValue;
    }

    private String getSafeStringUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (TextUtils.isEmpty(this.safeStringUrl)) {
                String str = this.stringUrl;
                if (TextUtils.isEmpty(str)) {
                    str = ((URL) Preconditions.checkNotNull(this.url)).toString();
                }
                this.safeStringUrl = Uri.encode(str, ALLOWED_URI_CHARS);
            }
            return this.safeStringUrl;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof GlideUrl)) {
                return false;
            }
            GlideUrl glideUrl = (GlideUrl) obj;
            if (!getCacheKey().equals(glideUrl.getCacheKey()) || !this.headers.equals(glideUrl.headers)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, messageDigest) == null) {
            messageDigest.update(getCacheKeyBytes());
        }
    }
}
