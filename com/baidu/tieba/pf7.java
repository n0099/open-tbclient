package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class pf7 implements lf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final StatisticItem a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b implements lf7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.baidu.tieba.lf7
        public void a(ICardInfo iCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iCardInfo) == null) {
            }
        }

        @Override // com.baidu.tieba.lf7
        public lf7 b(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) ? this : (lf7) invokeLI.objValue;
        }

        @Override // com.baidu.tieba.lf7
        public lf7 c(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) ? this : (lf7) invokeLJ.objValue;
        }

        @Override // com.baidu.tieba.lf7
        public lf7 d(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this : (lf7) invokeLL.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public pf7(BaseLegoCardInfo baseLegoCardInfo) {
        this(baseLegoCardInfo.getStatistics(), baseLegoCardInfo.getStatTab(), baseLegoCardInfo.getCardType(), baseLegoCardInfo.getItemId());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseLegoCardInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static lf7 e(BaseLegoCardInfo baseLegoCardInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, baseLegoCardInfo)) == null) {
            return baseLegoCardInfo != null && !TextUtils.isEmpty(baseLegoCardInfo.getStatistics()) ? new pf7(baseLegoCardInfo) : new b(null);
        }
        return (lf7) invokeL.objValue;
    }

    public static lf7 f(String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) ? !TextUtils.isEmpty(str) ? new pf7(str, i, i2, str2) : new b(null) : (lf7) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.lf7
    public void a(ICardInfo iCardInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iCardInfo) == null) {
            g(iCardInfo);
            TiebaStatic.log(this.a);
        }
    }

    @Override // com.baidu.tieba.lf7
    public lf7 b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.a.param(str, i);
            }
            return this;
        }
        return (lf7) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.lf7
    public lf7 c(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.a.param(str, String.valueOf(j));
            }
            return this;
        }
        return (lf7) invokeLJ.objValue;
    }

    @Override // com.baidu.tieba.lf7
    public lf7 d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.a.param(str, str2);
            }
            return this;
        }
        return (lf7) invokeLL.objValue;
    }

    public final void g(ICardInfo iCardInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iCardInfo) == null) {
            BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) iCardInfo;
            if (TextUtils.isEmpty(baseLegoCardInfo.getStatistics()) || TextUtils.isEmpty(baseLegoCardInfo.getsExtras())) {
                return;
            }
            List<Object> params = this.a.getParams();
            for (String str : baseLegoCardInfo.getsExtras().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    String str2 = split[0];
                    String str3 = split[1];
                    boolean z = false;
                    for (int i = 0; i < params.size() && !z; i += 2) {
                        if (TextUtils.equals(str2, params.get(i).toString())) {
                            int i2 = i + 1;
                            if (i2 < params.size()) {
                                params.set(i2, str3);
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        this.a.param(str2, str3);
                    }
                }
            }
            d(TiebaStatic.Params.OBJ_PARAM3, g16.e());
        }
    }

    public pf7(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        StatisticItem statisticItem = new StatisticItem(str);
        this.a = statisticItem;
        statisticItem.param("obj_source", i);
        this.a.param("obj_type", i2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.a.param("obj_card", str2);
    }
}
