package com.baidu.tieba.video;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001/BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J]\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000f¨\u00060"}, d2 = {"Lcom/baidu/tieba/video/LiveConfig;", "Ljava/io/Serializable;", "closeMax", "", "showMax", "singleMax", "type", "waitSecond", "cutList", "", "", "verticalHorizontalBoundary", "", "(IIIIILjava/util/Map;F)V", "getCloseMax", "()I", "currentId", "getCurrentId", "()Ljava/lang/String;", "setCurrentId", "(Ljava/lang/String;)V", "currentRealHitStrategy", "getCurrentRealHitStrategy", "setCurrentRealHitStrategy", "(I)V", "getCutList", "()Ljava/util/Map;", "getShowMax", "getSingleMax", "getType", "getVerticalHorizontalBoundary", "()F", "getWaitSecond", "component1", "component2", "component3", "component4", "component5", "component6", "component7", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "toString", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class LiveConfig implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CUT_LIST_HORIZONTAL_KEY = "horizontal";
    public static final String CUT_LIST_VERTICAL_KEY = "vertical";
    public static final a Companion;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("video_mid_page_auto_in_close_max")
    public final int closeMax;
    public String currentId;
    public int currentRealHitStrategy;
    @SerializedName("cut_list")
    public final Map<String, Integer> cutList;
    @SerializedName("video_mid_page_auto_in_show_max")
    public final int showMax;
    @SerializedName("video_mid_page_auto_in_max_single")
    public final int singleMax;
    @SerializedName("video_mid_page_in_type")
    public final int type;
    @SerializedName("vertical_horizontal_boundary")
    public final float verticalHorizontalBoundary;
    @SerializedName("video_mid_page_auto_in_wait_second")
    public final int waitSecond;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1676494571, "Lcom/baidu/tieba/video/LiveConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1676494571, "Lcom/baidu/tieba/video/LiveConfig;");
                return;
            }
        }
        Companion = new a(null);
    }

    public static /* synthetic */ LiveConfig copy$default(LiveConfig liveConfig, int i, int i2, int i3, int i4, int i5, Map map, float f, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = liveConfig.closeMax;
        }
        if ((i6 & 2) != 0) {
            i2 = liveConfig.showMax;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = liveConfig.singleMax;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = liveConfig.type;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = liveConfig.waitSecond;
        }
        int i10 = i5;
        Map<String, Integer> map2 = map;
        if ((i6 & 32) != 0) {
            map2 = liveConfig.cutList;
        }
        Map map3 = map2;
        if ((i6 & 64) != 0) {
            f = liveConfig.verticalHorizontalBoundary;
        }
        return liveConfig.copy(i, i7, i8, i9, i10, map3, f);
    }

    public final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.closeMax : invokeV.intValue;
    }

    public final int component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.showMax : invokeV.intValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.singleMax : invokeV.intValue;
    }

    public final int component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.type : invokeV.intValue;
    }

    public final int component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.waitSecond : invokeV.intValue;
    }

    public final Map<String, Integer> component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.cutList : (Map) invokeV.objValue;
    }

    public final float component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.verticalHorizontalBoundary : invokeV.floatValue;
    }

    public final LiveConfig copy(int i, int i2, int i3, int i4, int i5, Map<String, Integer> map, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), map, Float.valueOf(f)})) == null) ? new LiveConfig(i, i2, i3, i4, i5, map, f) : (LiveConfig) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LiveConfig) {
                LiveConfig liveConfig = (LiveConfig) obj;
                return this.closeMax == liveConfig.closeMax && this.showMax == liveConfig.showMax && this.singleMax == liveConfig.singleMax && this.type == liveConfig.type && this.waitSecond == liveConfig.waitSecond && Intrinsics.areEqual(this.cutList, liveConfig.cutList) && Intrinsics.areEqual((Object) Float.valueOf(this.verticalHorizontalBoundary), (Object) Float.valueOf(liveConfig.verticalHorizontalBoundary));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i = ((((((((this.closeMax * 31) + this.showMax) * 31) + this.singleMax) * 31) + this.type) * 31) + this.waitSecond) * 31;
            Map<String, Integer> map = this.cutList;
            return ((i + (map == null ? 0 : map.hashCode())) * 31) + Float.floatToIntBits(this.verticalHorizontalBoundary);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "LiveConfig(closeMax=" + this.closeMax + ", showMax=" + this.showMax + ", singleMax=" + this.singleMax + ", type=" + this.type + ", waitSecond=" + this.waitSecond + ", cutList=" + this.cutList + ", verticalHorizontalBoundary=" + this.verticalHorizontalBoundary + ')';
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public LiveConfig(int i, int i2, int i3, int i4, int i5, Map<String, Integer> map, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), map, Float.valueOf(f)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.closeMax = i;
        this.showMax = i2;
        this.singleMax = i3;
        this.type = i4;
        this.waitSecond = i5;
        this.cutList = map;
        this.verticalHorizontalBoundary = f;
        this.currentRealHitStrategy = 1;
    }

    public final int getCloseMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.closeMax;
        }
        return invokeV.intValue;
    }

    public final String getCurrentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.currentId;
        }
        return (String) invokeV.objValue;
    }

    public final int getCurrentRealHitStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.currentRealHitStrategy;
        }
        return invokeV.intValue;
    }

    public final Map<String, Integer> getCutList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.cutList;
        }
        return (Map) invokeV.objValue;
    }

    public final int getShowMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.showMax;
        }
        return invokeV.intValue;
    }

    public final int getSingleMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.singleMax;
        }
        return invokeV.intValue;
    }

    public final int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public final float getVerticalHorizontalBoundary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.verticalHorizontalBoundary;
        }
        return invokeV.floatValue;
    }

    public final int getWaitSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.waitSecond;
        }
        return invokeV.intValue;
    }

    public final void setCurrentId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.currentId = str;
        }
    }

    public final void setCurrentRealHitStrategy(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.currentRealHitStrategy = i;
        }
    }
}
