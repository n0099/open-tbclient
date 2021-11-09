package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.n.a;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class CDNLogSyncData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50915a;

    /* renamed from: b  reason: collision with root package name */
    public int f50916b;

    /* renamed from: c  reason: collision with root package name */
    public int f50917c;

    /* renamed from: d  reason: collision with root package name */
    public int f50918d;

    /* renamed from: e  reason: collision with root package name */
    public int f50919e;

    /* renamed from: f  reason: collision with root package name */
    public int f50920f;

    /* renamed from: g  reason: collision with root package name */
    public int f50921g;

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
        this.f50919e = 25;
        this.f50920f = 25;
        this.f50921g = 10;
    }

    public final void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f50915a = true;
            } else {
                this.f50915a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f50918d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f50917c = optJSONObject2.optInt("time");
                this.f50916b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f50919e = optJSONObject3.optInt("succ");
                this.f50920f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f50921g = optJSONObject3.optInt("slow");
            }
            if (this.f50917c <= 0 || this.f50916b <= 0 || this.f50918d <= 0) {
                this.f50915a = false;
            }
        } catch (Exception e2) {
            this.f50915a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public int getErrNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50918d : invokeV.intValue;
    }

    public int getErrRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50920f : invokeV.intValue;
    }

    public int getSlowNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f50916b : invokeV.intValue;
    }

    public int getSlowRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50921g : invokeV.intValue;
    }

    public int getSuccRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f50919e : invokeV.intValue;
    }

    public int getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f50917c : invokeV.intValue;
    }

    public boolean ismSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f50915a : invokeV.booleanValue;
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
                this.f50915a = false;
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void setErrNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f50918d = i2;
        }
    }

    public void setErrRank(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f50920f = i2;
        }
    }

    public void setSlowNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f50916b = i2;
        }
    }

    public void setSlowRank(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f50921g = i2;
        }
    }

    public void setSuccRank(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f50919e = i2;
        }
    }

    public void setTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f50917c = i2;
        }
    }

    public void setmSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (this.f50915a != z) {
                a logItem = ImageLogger.getLogItem();
                logItem.b("act", "fallback");
                logItem.b("result", z ? "1" : "0");
                logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
                BdStatisticsManager.getInstance().debug("img", logItem);
            }
            this.f50915a = z;
        }
    }
}
