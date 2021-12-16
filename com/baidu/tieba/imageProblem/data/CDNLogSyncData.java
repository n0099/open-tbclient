package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.n.a;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class CDNLogSyncData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f46893b;

    /* renamed from: c  reason: collision with root package name */
    public int f46894c;

    /* renamed from: d  reason: collision with root package name */
    public int f46895d;

    /* renamed from: e  reason: collision with root package name */
    public int f46896e;

    /* renamed from: f  reason: collision with root package name */
    public int f46897f;

    /* renamed from: g  reason: collision with root package name */
    public int f46898g;

    public CDNLogSyncData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46896e = 25;
        this.f46897f = 25;
        this.f46898g = 10;
    }

    public final void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt("switch") == 1) {
                this.a = true;
            } else {
                this.a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f46895d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f46894c = optJSONObject2.optInt("time");
                this.f46893b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f46896e = optJSONObject3.optInt("succ");
                this.f46897f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f46898g = optJSONObject3.optInt("slow");
            }
            if (this.f46894c <= 0 || this.f46893b <= 0 || this.f46895d <= 0) {
                this.a = false;
            }
        } catch (Exception e2) {
            this.a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public int getErrNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f46895d : invokeV.intValue;
    }

    public int getErrRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46897f : invokeV.intValue;
    }

    public int getSlowNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46893b : invokeV.intValue;
    }

    public int getSlowRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f46898g : invokeV.intValue;
    }

    public int getSuccRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f46896e : invokeV.intValue;
    }

    public int getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f46894c : invokeV.intValue;
    }

    public boolean ismSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public void parseJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                a(new JSONObject(str));
            } catch (Exception e2) {
                this.a = false;
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void setErrNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f46895d = i2;
        }
    }

    public void setErrRank(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f46897f = i2;
        }
    }

    public void setSlowNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f46893b = i2;
        }
    }

    public void setSlowRank(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f46898g = i2;
        }
    }

    public void setSuccRank(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f46896e = i2;
        }
    }

    public void setTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f46894c = i2;
        }
    }

    public void setmSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (this.a != z) {
                a logItem = ImageLogger.getLogItem();
                logItem.b("act", "fallback");
                logItem.b("result", z ? "1" : "0");
                logItem.b("type", "switch");
                BdStatisticsManager.getInstance().debug("img", logItem);
            }
            this.a = z;
        }
    }
}
