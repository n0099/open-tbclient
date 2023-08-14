package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes8.dex */
public class x25 extends rba {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId o1;
    public transient /* synthetic */ FieldHolder $fh;
    public String f1;
    public String g1;
    public String h1;
    public String i1;
    public String j1;
    public String k1;
    public List<String> l1;
    public String m1;
    public String n1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948248494, "Lcom/baidu/tieba/x25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948248494, "Lcom/baidu/tieba/x25;");
                return;
            }
        }
        o1 = BdUniqueId.gen();
    }

    public x25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.rba, com.baidu.tieba.ym
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return o1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!StringUtils.isNull(this.i1)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void A1(RecommendBook recommendBook) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, recommendBook) != null) || recommendBook == null) {
            return;
        }
        this.f1 = recommendBook.recommend_text;
        this.g1 = recommendBook.suggest_text;
        this.h1 = recommendBook.suggest_url;
        this.i1 = recommendBook.book_id;
        recommendBook.book_type.intValue();
        this.j1 = recommendBook.book_cover;
        this.k1 = recommendBook.book_title;
        this.l1 = recommendBook.book_tips;
        this.m1 = recommendBook.botton_text;
        this.n1 = recommendBook.subscript_icon;
    }
}
