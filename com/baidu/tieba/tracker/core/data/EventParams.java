package com.baidu.tieba.tracker.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0016\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003B5\u0012.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00060\u0005\"\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\u0010\bJ\u0013\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0086\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002J\u001d\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00110\u0010H\u0096\u0002J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0000J\u001c\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0016J\u001b\u0010\u0017\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0086\u0002J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0016R.\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/tracker/core/data/EventParams;", "", "", "Ljava/io/Serializable;", "params", "", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)V", "data", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "key", "default", "iterator", "", "", "merge", "other", "putAll", "", "", "set", "value", "setIfNull", "toString", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public class EventParams implements Iterable<Object>, Serializable, KMappedMarker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Object> data;

    public EventParams(Pair<String, ? extends Object>... params) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {params};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(params, "params");
        HashMap<String, Object> hashMap = new HashMap<>();
        this.data = hashMap;
        MapsKt__MapsKt.putAll(hashMap, params);
    }

    public final EventParams merge(EventParams eventParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eventParams)) == null) {
            if (eventParams != null) {
                Iterator<Object> it = eventParams.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    setIfNull((String) entry.getKey(), entry.getValue());
                }
            }
            return this;
        }
        return (EventParams) invokeL.objValue;
    }

    public final Object get(String key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, key)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.data.get(key);
        }
        return invokeL.objValue;
    }

    public final void putAll(Map<String, String> other) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, other) == null) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.data.putAll(other);
        }
    }

    public final Object get(String key, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, key, obj)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Object obj2 = this.data.get(key);
            if (obj2 != null) {
                return obj2;
            }
            return obj;
        }
        return invokeLL.objValue;
    }

    public final EventParams set(String key, Object obj) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, key, obj)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            HashMap<String, Object> hashMap = this.data;
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            hashMap.put(key, str);
            return this;
        }
        return (EventParams) invokeLL.objValue;
    }

    public final EventParams setIfNull(String key, Object obj) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, key, obj)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (this.data.get(key) == null) {
                HashMap<String, Object> hashMap = this.data;
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = null;
                }
                hashMap.put(key, str);
            }
            return this;
        }
        return (EventParams) invokeLL.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'java.util.Iterator<java.util.Map$Entry<java.lang.String, java.lang.Object>>' to match base method */
    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.data.entrySet().iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            for (Map.Entry<String, Object> entry : this.data.entrySet()) {
                Object value = entry.getValue();
                sb.append(WebvttCueParser.CHAR_SPACE + entry.getKey() + " = " + value + " ,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply {\n…\"]\")\n        }.toString()");
            return sb2;
        }
        return (String) invokeV.objValue;
    }
}
