package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class LazyHeaders implements Headers {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Map<String, String> combinedHeaders;
    public final Map<String, List<LazyHeaderFactory>> headers;

    /* loaded from: classes5.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Map<String, List<LazyHeaderFactory>> DEFAULT_HEADERS;
        public static final String DEFAULT_USER_AGENT;
        public static final String USER_AGENT_HEADER = "User-Agent";
        public transient /* synthetic */ FieldHolder $fh;
        public boolean copyOnModify;
        public Map<String, List<LazyHeaderFactory>> headers;
        public boolean isUserAgentDefault;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(618151758, "Lcom/bumptech/glide/load/model/LazyHeaders$Builder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(618151758, "Lcom/bumptech/glide/load/model/LazyHeaders$Builder;");
                    return;
                }
            }
            DEFAULT_USER_AGENT = getSanitizedUserAgent();
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(DEFAULT_USER_AGENT)) {
                hashMap.put("User-Agent", Collections.singletonList(new StringHeaderFactory(DEFAULT_USER_AGENT)));
            }
            DEFAULT_HEADERS = Collections.unmodifiableMap(hashMap);
        }

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.copyOnModify = true;
            this.headers = DEFAULT_HEADERS;
            this.isUserAgentDefault = true;
        }

        private Map<String, List<LazyHeaderFactory>> copyHeaders() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                HashMap hashMap = new HashMap(this.headers.size());
                for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.headers.entrySet()) {
                    hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
                }
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        private void copyIfNecessary() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.copyOnModify) {
                this.copyOnModify = false;
                this.headers = copyHeaders();
            }
        }

        private List<LazyHeaderFactory> getFactories(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
                List<LazyHeaderFactory> list = this.headers.get(str);
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    this.headers.put(str, arrayList);
                    return arrayList;
                }
                return list;
            }
            return (List) invokeL.objValue;
        }

        @VisibleForTesting
        public static String getSanitizedUserAgent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                String property = System.getProperty("http.agent");
                if (TextUtils.isEmpty(property)) {
                    return property;
                }
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = property.charAt(i2);
                    if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                        sb.append(charAt);
                    } else {
                        sb.append('?');
                    }
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public Builder addHeader(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? addHeader(str, new StringHeaderFactory(str2)) : (Builder) invokeLL.objValue;
        }

        public LazyHeaders build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.copyOnModify = true;
                return new LazyHeaders(this.headers);
            }
            return (LazyHeaders) invokeV.objValue;
        }

        public Builder setHeader(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                return setHeader(str, str2 == null ? null : new StringHeaderFactory(str2));
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder addHeader(String str, LazyHeaderFactory lazyHeaderFactory) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, lazyHeaderFactory)) == null) {
                if (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(str)) {
                    return setHeader(str, lazyHeaderFactory);
                }
                copyIfNecessary();
                getFactories(str).add(lazyHeaderFactory);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setHeader(String str, LazyHeaderFactory lazyHeaderFactory) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, lazyHeaderFactory)) == null) {
                copyIfNecessary();
                if (lazyHeaderFactory == null) {
                    this.headers.remove(str);
                } else {
                    List<LazyHeaderFactory> factories = getFactories(str);
                    factories.clear();
                    factories.add(lazyHeaderFactory);
                }
                if (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(str)) {
                    this.isUserAgentDefault = false;
                }
                return this;
            }
            return (Builder) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class StringHeaderFactory implements LazyHeaderFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        public StringHeaderFactory(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = str;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String buildHeader() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (String) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof StringHeaderFactory) {
                    return this.value.equals(((StringHeaderFactory) obj).value);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.value.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "StringHeaderFactory{value='" + this.value + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    public LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.headers = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String buildHeaderValue(@NonNull List<LazyHeaderFactory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                String buildHeader = list.get(i2).buildHeader();
                if (!TextUtils.isEmpty(buildHeader)) {
                    sb.append(buildHeader);
                    if (i2 != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private Map<String, String> generateHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.headers.entrySet()) {
                String buildHeaderValue = buildHeaderValue(entry.getValue());
                if (!TextUtils.isEmpty(buildHeaderValue)) {
                    hashMap.put(entry.getKey(), buildHeaderValue);
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof LazyHeaders) {
                return this.headers.equals(((LazyHeaders) obj).headers);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.combinedHeaders == null) {
                synchronized (this) {
                    if (this.combinedHeaders == null) {
                        this.combinedHeaders = Collections.unmodifiableMap(generateHeaders());
                    }
                }
            }
            return this.combinedHeaders;
        }
        return (Map) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.headers.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "LazyHeaders{headers=" + this.headers + '}';
        }
        return (String) invokeV.objValue;
    }
}
