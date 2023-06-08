package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import tbclient.Loop.FestivalInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public class sg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @SerializedName("main_fname")
    public String a;
    @SerializedName("main_fid")
    public long b;
    @Nullable
    @SerializedName("bless")
    public String c;
    @Nullable
    @SerializedName("write_select_tips")
    public String d;
    @Nullable
    @SerializedName("comment_tips")
    public String e;
    @Nullable
    @SerializedName("tips_color")
    public ThemeColorInfo f;

    public sg5() {
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

    public void a(FestivalInfo festivalInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, festivalInfo) != null) || festivalInfo == null) {
            return;
        }
        this.a = festivalInfo.main_fname;
        this.b = festivalInfo.main_fid.longValue();
        this.c = festivalInfo.bless;
        this.d = festivalInfo.write_select_tips;
        this.e = festivalInfo.comment_tips;
        this.f = festivalInfo.tips_color;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || sg5.class != obj.getClass()) {
                return false;
            }
            sg5 sg5Var = (sg5) obj;
            if (Objects.equals(this.a, sg5Var.a) && this.b == sg5Var.b && Objects.equals(this.c, sg5Var.c) && Objects.equals(this.d, sg5Var.d) && Objects.equals(this.e, sg5Var.e)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return Objects.hash(this.a, Long.valueOf(this.b), this.c, this.d, this.e);
        }
        return invokeV.intValue;
    }
}
