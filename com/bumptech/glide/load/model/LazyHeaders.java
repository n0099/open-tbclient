package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class LazyHeaders implements Headers {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Map combinedHeaders;
    public final Map headers;

    /* loaded from: classes7.dex */
    public final class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Map DEFAULT_HEADERS;
        public static final String DEFAULT_USER_AGENT;
        public static final String USER_AGENT_HEADER = "User-Agent";
        public transient /* synthetic */ FieldHolder $fh;
        public boolean copyOnModify;
        public Map headers;
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

        private Map copyHeaders() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                HashMap hashMap = new HashMap(this.headers.size());
                for (Map.Entry entry : this.headers.entrySet()) {
                    hashMap.put(entry.getKey(), new ArrayList((Collection) entry.getValue()));
                }
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        public static String getSanitizedUserAgent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                String property = System.getProperty("http.agent");
                if (TextUtils.isEmpty(property)) {
                    return property;
                }
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
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

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.copyOnModify = true;
            this.headers = DEFAULT_HEADERS;
            this.isUserAgentDefault = true;
        }

        private void copyIfNecessary() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.copyOnModify) {
                this.copyOnModify = false;
                this.headers = copyHeaders();
            }
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

        private List getFactories(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
                List list = (List) this.headers.get(str);
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    this.headers.put(str, arrayList);
                    return arrayList;
                }
                return list;
            }
            return (List) invokeL.objValue;
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

        public Builder setHeader(String str, String str2) {
            InterceptResult invokeLL;
            StringHeaderFactory stringHeaderFactory;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                if (str2 == null) {
                    stringHeaderFactory = null;
                } else {
                    stringHeaderFactory = new StringHeaderFactory(str2);
                }
                return setHeader(str, stringHeaderFactory);
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder addHeader(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                return addHeader(str, new StringHeaderFactory(str2));
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
                    List factories = getFactories(str);
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

    /* loaded from: classes7.dex */
    public final class StringHeaderFactory implements LazyHeaderFactory {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = str;
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

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String buildHeader() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.value;
            }
            return (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.value.hashCode();
            }
            return invokeV.intValue;
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

    public LazyHeaders(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.headers = Collections.unmodifiableMap(map);
    }

    private String buildHeaderValue(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String buildHeader = ((LazyHeaderFactory) list.get(i)).buildHeader();
                if (!TextUtils.isEmpty(buildHeader)) {
                    sb.append(buildHeader);
                    if (i != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private Map generateHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : this.headers.entrySet()) {
                String buildHeaderValue = buildHeaderValue((List) entry.getValue());
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
    public Map getHeaders() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.headers.hashCode();
        }
        return invokeV.intValue;
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
