package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pi;
import com.baidu.tieba.rr6;
import com.baidu.tieba.sr6;
import com.baidu.tieba.tr6;
import com.baidu.tieba.z5b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.NovelRecomCard;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/pb/data/PbFirstFloorRecommendData;", "Lcom/baidu/adp/widget/ListView/IAdapterData;", "novelRecomCard", "Ltbclient/NovelRecomCard;", "(Ltbclient/NovelRecomCard;)V", "getNovelRecomCard", "()Ltbclient/NovelRecomCard;", "tid", "", "getTid", "()Ljava/lang/String;", "setTid", "(Ljava/lang/String;)V", "component1", "convert2RecommendCardItem", "Lcom/baidu/tieba/core/widget/recommendcard/RecommendCardItemBuilder;", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "getType", "Lcom/baidu/adp/BdUniqueId;", "hashCode", "", "toString", "Companion", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PbFirstFloorRecommendData implements pi {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    @JvmField
    public static final BdUniqueId d;
    public static final Lazy<ThemeElement> e;
    public static final Lazy<ThemeColorInfo> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final NovelRecomCard a;
    public String b;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PbFirstFloorRecommendData) && Intrinsics.areEqual(this.a, ((PbFirstFloorRecommendData) obj).a);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "PbFirstFloorRecommendData(novelRecomCard=" + this.a + ')';
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
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

        public final ThemeColorInfo c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (ThemeColorInfo) PbFirstFloorRecommendData.f.getValue();
            }
            return (ThemeColorInfo) invokeV.objValue;
        }

        public final ThemeElement d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (ThemeElement) PbFirstFloorRecommendData.e.getValue();
            }
            return (ThemeElement) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-461038407, "Lcom/baidu/tieba/pb/data/PbFirstFloorRecommendData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-461038407, "Lcom/baidu/tieba/pb/data/PbFirstFloorRecommendData;");
                return;
            }
        }
        c = new a(null);
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        d = gen;
        e = LazyKt__LazyJVMKt.lazy(PbFirstFloorRecommendData$Companion$emptyThemeElement$2.INSTANCE);
        f = LazyKt__LazyJVMKt.lazy(PbFirstFloorRecommendData$Companion$emptyThemeColorInfo$2.INSTANCE);
    }

    public PbFirstFloorRecommendData(NovelRecomCard novelRecomCard) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {novelRecomCard};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(novelRecomCard, "novelRecomCard");
        this.a = novelRecomCard;
        this.b = "";
    }

    public final NovelRecomCard d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (NovelRecomCard) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return d;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final rr6 c() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds229);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds304);
            String str3 = this.a.icon_url;
            String str4 = "";
            if (str3 == null) {
                str3 = "";
            }
            sr6 sr6Var = new sr6(dimens, dimens2, str3);
            String str5 = this.a.title;
            if (str5 == null) {
                str = "";
            } else {
                str = str5;
            }
            List<ThemeColorInfo> list = this.a.title_labels;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            tr6 tr6Var = new tr6(str, list, false, 4, null);
            ThemeColorInfo themeColorInfo = this.a.chapter_bg_color;
            if (themeColorInfo == null) {
                themeColorInfo = c.c();
            }
            Intrinsics.checkNotNullExpressionValue(themeColorInfo, "novelRecomCard.chapter_b…or ?: emptyThemeColorInfo");
            String c2 = z5b.c(themeColorInfo);
            int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
            ThemeColorInfo themeColorInfo2 = this.a.chapter_new_labels;
            if (themeColorInfo2 == null) {
                themeColorInfo2 = c.c();
            }
            Intrinsics.checkNotNullExpressionValue(themeColorInfo2, "novelRecomCard.chapter_n…ls ?: emptyThemeColorInfo");
            sr6 a2 = z5b.a(themeColorInfo2);
            ThemeColorInfo themeColorInfo3 = this.a.chapter_name_color;
            if (themeColorInfo3 == null) {
                themeColorInfo3 = c.c();
            }
            Intrinsics.checkNotNullExpressionValue(themeColorInfo3, "novelRecomCard.chapter_n…or ?: emptyThemeColorInfo");
            String c3 = z5b.c(themeColorInfo3);
            String str6 = this.a.chapter_name;
            if (str6 == null) {
                str2 = "";
            } else {
                str2 = str6;
            }
            rr6 rr6Var = new rr6(R.color.CAM_X0204, sr6Var, tr6Var, c2, dimens3, a2, c3, str2);
            String str7 = this.a.author;
            if (str7 == null) {
                str7 = "";
            }
            rr6Var.F(str7);
            String str8 = this.a._abstract;
            if (str8 == null) {
                str8 = "";
            }
            rr6Var.g(str8);
            String str9 = this.a.button_name;
            if (str9 == null) {
                str9 = "";
            }
            rr6Var.D(str9);
            ThemeColorInfo themeColorInfo4 = this.a.bottom_left_icon;
            if (themeColorInfo4 == null) {
                themeColorInfo4 = c.c();
            }
            Intrinsics.checkNotNullExpressionValue(themeColorInfo4, "novelRecomCard.bottom_le…on ?: emptyThemeColorInfo");
            rr6Var.a(z5b.a(themeColorInfo4));
            String str10 = this.a.bottom_title;
            if (str10 == null) {
                str10 = "";
            }
            rr6Var.b(str10);
            ThemeColorInfo themeColorInfo5 = this.a.bottom_right_icon;
            if (themeColorInfo5 == null) {
                themeColorInfo5 = c.c();
            }
            Intrinsics.checkNotNullExpressionValue(themeColorInfo5, "novelRecomCard.bottom_ri…on ?: emptyThemeColorInfo");
            rr6Var.e(z5b.a(themeColorInfo5));
            String str11 = this.a.bottom_guide;
            if (str11 != null) {
                str4 = str11;
            }
            rr6Var.d(str4);
            ThemeColorInfo themeColorInfo6 = this.a.bottom_right_icon_2;
            if (themeColorInfo6 == null) {
                themeColorInfo6 = c.c();
            }
            Intrinsics.checkNotNullExpressionValue(themeColorInfo6, "novelRecomCard.bottom_ri…_2 ?: emptyThemeColorInfo");
            rr6Var.c(z5b.a(themeColorInfo6));
            return rr6Var;
        }
        return (rr6) invokeV.objValue;
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.b = str;
        }
    }
}
