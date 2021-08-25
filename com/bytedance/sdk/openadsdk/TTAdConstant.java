package com.bytedance.sdk.openadsdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.q.q;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes9.dex */
public class TTAdConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long AD_MAX_EVENT_TIME = 600000;
    public static final int AD_TYPE_COMMON_VIDEO = 0;
    public static final int AD_TYPE_PLAYABLE = 2;
    public static final int AD_TYPE_PLAYABLE_VIDEO = 1;
    public static final int AD_TYPE_UNKNOWN = -1;
    public static final int FALLBACK_TYPE_DOWNLOAD = 2;
    public static final int FALLBACK_TYPE_LANDING_PAGE = 1;
    public static final int FULL_INTERACTION_MARGIN = 20;
    public static final float FULL_INTERACTION_TYPE_DEFAULT = 100.0f;
    public static final int HORIZONTAL = 2;
    public static final int IMAGE_MODE_GROUP_IMG = 4;
    public static final int IMAGE_MODE_LARGE_IMG = 3;
    public static final int IMAGE_MODE_SMALL_IMG = 2;
    public static final int IMAGE_MODE_UNKNOWN = -1;
    public static final int IMAGE_MODE_VERTICAL_IMG = 16;
    public static final int IMAGE_MODE_VIDEO = 5;
    public static final int IMAGE_MODE_VIDEO_VERTICAL = 15;
    public static final int INTERACTION_TYPE_BROWSER = 2;
    public static final int INTERACTION_TYPE_DIAL = 5;
    public static final int INTERACTION_TYPE_DOWNLOAD = 4;
    public static final int INTERACTION_TYPE_LANDING_PAGE = 3;
    public static final int INTERACTION_TYPE_UNKNOWN = -1;
    public static final String MULTI_PROCESS_DATA = "multi_process_data";
    public static final String MULTI_PROCESS_MATERIALMETA = "multi_process_materialmeta";
    public static final int NETWORK_STATE_2G = 2;
    public static final int NETWORK_STATE_3G = 3;
    public static final int NETWORK_STATE_4G = 5;
    public static final int NETWORK_STATE_5G = 6;
    public static final int NETWORK_STATE_MOBILE = 1;
    public static final int NETWORK_STATE_WIFI = 4;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int STYLE_SIZE_RADIO_16_9 = 1777;
    public static final int STYLE_SIZE_RADIO_1_1 = 1000;
    public static final int STYLE_SIZE_RADIO_2_3 = 666;
    public static final int STYLE_SIZE_RADIO_3_2 = 1500;
    public static final int STYLE_SIZE_RADIO_9_16 = 562;
    public static final float STYLE_SIZE_RADIO_FULL = 100.0f;
    public static final String TAG = "TT_AD_SDK";
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public static final int VERTICAL = 1;
    public transient /* synthetic */ FieldHolder $fh;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes9.dex */
    public @interface NATIVE_AD_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes9.dex */
    public @interface NETWORK_STATE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes9.dex */
    public @interface ORIENTATION_STATE {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class RitScenes {
        public static /* synthetic */ Interceptable $ic;
        public static final RitScenes CUSTOMIZE_SCENES;
        public static final RitScenes GAME_FINISH_REWARDS;
        public static final RitScenes GAME_GIFT_BONUS;
        public static final RitScenes GAME_MORE_KLLKRTUNITIES;
        public static final RitScenes GAME_REDUCE_WAITING;
        public static final RitScenes GAME_START_BONUS;
        public static final RitScenes HOME_GET_BONUS;
        public static final RitScenes HOME_GET_PROPS;
        public static final RitScenes HOME_GIFT_BONUS;
        public static final RitScenes HOME_OPEN_BONUS;
        public static final RitScenes HOME_SVIP_BONUS;
        public static final RitScenes HOME_TRY_PROPS;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ RitScenes[] f65210b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f65211a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1720524287, "Lcom/bytedance/sdk/openadsdk/TTAdConstant$RitScenes;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1720524287, "Lcom/bytedance/sdk/openadsdk/TTAdConstant$RitScenes;");
                    return;
                }
            }
            CUSTOMIZE_SCENES = new RitScenes("CUSTOMIZE_SCENES", 0, "customize_scenes");
            HOME_OPEN_BONUS = new RitScenes("HOME_OPEN_BONUS", 1, "home_open_bonus");
            HOME_SVIP_BONUS = new RitScenes("HOME_SVIP_BONUS", 2, "home_svip_bonus");
            HOME_GET_PROPS = new RitScenes("HOME_GET_PROPS", 3, "home_get_props");
            HOME_TRY_PROPS = new RitScenes("HOME_TRY_PROPS", 4, "home_try_props");
            HOME_GET_BONUS = new RitScenes("HOME_GET_BONUS", 5, "home_get_bonus");
            HOME_GIFT_BONUS = new RitScenes("HOME_GIFT_BONUS", 6, "home_gift_bonus");
            GAME_START_BONUS = new RitScenes("GAME_START_BONUS", 7, "game_start_bonus");
            GAME_REDUCE_WAITING = new RitScenes("GAME_REDUCE_WAITING", 8, "geme_reduce_waiting");
            GAME_MORE_KLLKRTUNITIES = new RitScenes("GAME_MORE_KLLKRTUNITIES", 9, q.m("game_more_kllkrtunities"));
            GAME_FINISH_REWARDS = new RitScenes("GAME_FINISH_REWARDS", 10, "game_finish_rewards");
            RitScenes ritScenes = new RitScenes("GAME_GIFT_BONUS", 11, "game_gift_bonus");
            GAME_GIFT_BONUS = ritScenes;
            f65210b = new RitScenes[]{CUSTOMIZE_SCENES, HOME_OPEN_BONUS, HOME_SVIP_BONUS, HOME_GET_PROPS, HOME_TRY_PROPS, HOME_GET_BONUS, HOME_GIFT_BONUS, GAME_START_BONUS, GAME_REDUCE_WAITING, GAME_MORE_KLLKRTUNITIES, GAME_FINISH_REWARDS, ritScenes};
        }

        public RitScenes(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f65211a = str2;
        }

        public static RitScenes valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RitScenes) Enum.valueOf(RitScenes.class, str) : (RitScenes) invokeL.objValue;
        }

        public static RitScenes[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RitScenes[]) f65210b.clone() : (RitScenes[]) invokeV.objValue;
        }

        public String getScenesName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65211a : (String) invokeV.objValue;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes9.dex */
    public @interface TITLE_BAR_THEME {
    }

    public TTAdConstant() {
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
}
