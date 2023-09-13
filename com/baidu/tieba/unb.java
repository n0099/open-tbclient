package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tieba.aob;
import com.baidu.tieba.ynb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class unb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public int b;
    public int c;
    public wnb d;
    public final Set<Ssp> e;
    public final Set<aob> f;
    public final Set<ynb> g;

    public unb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new HashSet();
        this.f = new HashSet();
        this.g = new HashSet();
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                c(str);
                LogPrinter.v("Config cfgv:%d parsed over.", Long.valueOf(this.a));
                if (d()) {
                    a();
                    LogPrinter.v("Config cfgv:%d persisted over.", Long.valueOf(this.a));
                    return true;
                }
            } catch (JSONException e) {
                LogPrinter.e(e);
            }
            this.e.clear();
            this.f.clear();
            this.g.clear();
            return false;
        }
        return invokeL.booleanValue;
    }

    @VisibleForTesting
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (Ssp ssp : this.e) {
                if (hashSet.contains(ssp.type)) {
                    LogPrinter.e("Duplicate ssp:type(%s) found.", ssp.type);
                    return false;
                }
                hashSet.add(ssp.type);
                for (Ssp.Pid pid : ssp.pids) {
                    if (hashSet2.contains(Long.valueOf(pid.id))) {
                        LogPrinter.e("Duplicate pid(%d) found.", Long.valueOf(pid.id));
                        return false;
                    }
                    hashSet2.add(Long.valueOf(pid.id));
                }
            }
            HashSet hashSet3 = new HashSet();
            for (aob aobVar : this.f) {
                if (hashSet3.contains(aobVar.a)) {
                    LogPrinter.e("Duplicate sid(%s) found in SlotId", aobVar.a);
                    return false;
                }
                hashSet3.add(aobVar.a);
                for (aob.c cVar : aobVar.e) {
                    HashSet hashSet4 = new HashSet();
                    for (aob.b bVar : cVar.b) {
                        if (!hashSet2.contains(Long.valueOf(bVar.a))) {
                            LogPrinter.e("Unregistered adId:(%d) in SlotId", Long.valueOf(bVar.a));
                            return false;
                        } else if (hashSet4.contains(Long.valueOf(bVar.a))) {
                            LogPrinter.e("Duplicate adId:(%d) found in one sid:(%s) in SlotId", Long.valueOf(bVar.a), aobVar.a);
                            return false;
                        } else {
                            hashSet4.add(Long.valueOf(bVar.a));
                        }
                    }
                }
            }
            if (this.c == 2) {
                for (ynb ynbVar : this.g) {
                    if (hashSet3.contains(ynbVar.a)) {
                        LogPrinter.e("Duplicate sid(%s) found in SerialSlotId.", ynbVar.a);
                        return false;
                    }
                    hashSet3.add(ynbVar.a);
                    for (ynb.b bVar2 : ynbVar.b) {
                        for (ynb.a aVar : bVar2.b) {
                            if (!hashSet2.contains(Long.valueOf(aVar.a))) {
                                LogPrinter.e("Unregistered adId:(%d) in SerialSlotId", Long.valueOf(aVar.a));
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void a() {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j = this.a;
            int i = this.b;
            int i2 = this.c;
            nnb nnbVar = new nnb(this.e, this.f, this.g);
            wnb wnbVar = this.d;
            Object obj = dob.a;
            String d = rnb.d(nnbVar);
            Object[] objArr = new Object[1];
            if (d == null) {
                length = -1;
            } else {
                length = d.length();
            }
            objArr[0] = Integer.valueOf(length);
            LogPrinter.v("sspsUTF len:%d", objArr);
            dob.b.edit().putLong("key_config_v", j).putInt("key_config_interval", i).putInt("key_V", i2).putString("key_adcfg", d).putString("key_rptcfg", rnb.d(wnbVar)).apply();
        }
    }

    @VisibleForTesting
    public void c(String str) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("config");
            this.a = NumberUtils.adjustLong(jSONObject2.getLong("ver"), 0L);
            this.b = NumberUtils.adjustInt(jSONObject2.getInt("interval"), 1, 1440);
            this.c = NumberUtils.adjustInt(jSONObject2.optInt(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 1), 1);
            JSONObject jSONObject3 = jSONObject.getJSONObject("adConfig");
            JSONArray jSONArray = jSONObject3.getJSONArray("ssps");
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                Ssp ssp = new Ssp(jSONArray.getJSONObject(i));
                for (Ssp.Pid pid : ssp.pids) {
                    hashMap.put(Long.valueOf(pid.id), pid);
                }
                this.e.add(ssp);
            }
            JSONArray jSONArray2 = jSONObject3.getJSONArray(Config.SID);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                this.f.add(new aob(jSONArray2.getJSONObject(i2), hashMap));
            }
            if (this.c >= 2 && (optJSONArray = jSONObject3.optJSONArray("serialSids")) != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.g.add(new ynb(optJSONArray.getJSONObject(i3), hashMap));
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("rptConfig");
            if (optJSONObject != null) {
                this.d = new wnb(optJSONObject);
            }
        }
    }
}
