package com.baidu.tieba;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o36 {
    public static /* synthetic */ Interceptable $ic;
    public static final o36 k;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981367, "Lcom/baidu/tieba/o36;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981367, "Lcom/baidu/tieba/o36;");
                return;
            }
        }
        k = new o36();
    }

    public o36() {
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
        this.a = new AtomicBoolean(false);
    }

    public static o36 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return k;
        }
        return (o36) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("tieba_pic_ad_req_num", 3);
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("video_flow_first_floor", 4);
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("video_flow_floor_interval", 7);
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.g == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("ad_photo_browser_insert_mode", -1) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.b == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.j == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.h == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.d == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.i == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.e == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) {
            boolean z = this.a.get();
            if (jSONObject != null && !z) {
                this.a.set(true);
                this.b = jSONObject.optInt("tieba_lazy_launch_switch", 1);
                this.c = jSONObject.optInt("tieba_lazy_launch_internal", 60);
                jSONObject.optInt("tieba_max_fake_progress", 50);
                jSONObject.optInt("tieba_max_fake_time", 60);
                jSONObject.optLong("tieba_max_fake_speed", 768000L);
                SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0);
                this.j = jSONObject.optInt("tieba_video_mobile_net_autoplay", 1);
                this.g = jSONObject.optInt("tieba_12.4_download_path", 1);
                jSONObject.optInt("tieba_landing_page_type_switch", -1);
                this.d = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
                this.e = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
                this.f = jSONObject.optInt("tieba_12.3_ad_discard_optimize", -1);
                jSONObject.optString("tieba_follow_up_cmatch_switchs", "");
                jSONObject.optInt("tieba_follow_up_expire_time", 7);
                jSONObject.optInt("tieba_follow_up_max_remind_times", 3);
                jSONObject.optInt("tieba_follow_up_gap_time", 5);
                this.h = jSONObject.optInt("tieba_video_ad_jump_switch", 0);
                this.i = jSONObject.optInt("hide_landing_page_ad_download_tip", 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("video_flow_first_floor", jSONObject.optInt("video_flow_first_floor", 4));
                edit.putInt("video_flow_floor_interval", jSONObject.optInt("video_flow_floor_interval", 7));
                int optInt = jSONObject.optInt("ad_photo_browser_insert_mode", -1);
                if (optInt != -1) {
                    edit.putInt("ad_photo_browser_insert_mode", optInt);
                }
                int optInt2 = jSONObject.optInt("tieba_pic_ad_req_num", -1);
                if (optInt2 != -1) {
                    edit.putInt("tieba_pic_ad_req_num", optInt2);
                }
                edit.commit();
            }
        }
    }
}
