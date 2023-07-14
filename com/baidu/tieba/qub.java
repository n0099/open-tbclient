package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.preference.Preference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public long b;
    public int c;
    public int d;
    public long e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public ArrayList<String> j;
    public String k;
    public uvb l;

    public qub(String str) {
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
        this.l = new uvb();
        this.a = str;
        this.c = 0;
        this.f = 1;
        this.g = 1;
        this.h = false;
        this.i = true;
        this.b = Preference.e();
    }

    public qub(String str, int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new uvb();
        this.a = str;
        this.c = i;
        this.f = i2;
        this.g = i3;
        this.h = z;
        this.i = true;
        this.b = Preference.e();
        TLog.g(this, "liveMode " + this.h + " fastAccess " + this.i + "taskId " + this.b);
    }

    public static qub a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            qub qubVar = new qub("");
            try {
                JSONObject jSONObject = new JSONObject(str);
                qubVar.a = jSONObject.optString("mUrl");
                qubVar.c = jSONObject.optInt("mProtocol");
                qubVar.f = jSONObject.optInt("mSourceFormat");
                qubVar.g = jSONObject.optInt("mCachePolicy");
                qubVar.h = jSONObject.optBoolean("mIsLiveMode");
                qubVar.i = jSONObject.optBoolean("mIsFastAccess");
                qubVar.d = jSONObject.optInt("mMaxPreloadBufferSize");
                qubVar.b = jSONObject.optLong("mTaskId");
                qubVar.e = jSONObject.optLong("mCurrentMs");
                qubVar.k = jSONObject.optString("mPcdnManufacturer");
                String optString = jSONObject.optString("mProperties");
                if (!optString.isEmpty()) {
                    qubVar.l.a(optString);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("mPcdnUrls");
                if (optJSONArray != null) {
                    qubVar.j = new ArrayList<>();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        qubVar.j.add(optJSONArray.optString(i));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return qubVar;
        }
        return (qub) invokeL.objValue;
    }

    public static String r(qub qubVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, qubVar)) == null) {
            if (qubVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mUrl", qubVar.a);
                jSONObject.put("mProtocol", qubVar.c);
                jSONObject.put("mSourceFormat", qubVar.f);
                jSONObject.put("mCachePolicy", qubVar.g);
                jSONObject.put("mIsLiveMode", qubVar.h);
                jSONObject.put("mIsFastAccess", qubVar.i);
                jSONObject.put("mMaxPreloadBufferSize", qubVar.d);
                jSONObject.put("mProperties", qubVar.l.c());
                jSONObject.put("mTaskId", qubVar.b);
                jSONObject.put("mCurrentMs", qubVar.e);
                jSONObject.put("mPcdnManufacturer", qubVar.k);
                if (qubVar.j != null && !qubVar.j.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<String> it = qubVar.j.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObject.put("mPcdnUrls", jSONArray);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (ArrayList) invokeV.objValue;
    }

    public uvb g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (uvb) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.i = z;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.d = i;
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.e = j;
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.b = j;
        }
    }

    public boolean o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            if (this.l.a.put(str, str2) != null) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "DataSource [mUrl=" + this.a + ", mProtocol=" + this.c + ", mSourceFormat=" + this.f + ", mCachePolicy=" + this.g + ", mIsLiveMode=" + this.h + ", mIsFastAccess=" + this.i + ", mMaxPreloadBufferSize=" + this.d + ", mProperties=" + this.l.c() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
