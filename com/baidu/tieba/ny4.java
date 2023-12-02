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
/* loaded from: classes7.dex */
public class ny4 extends mwa {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId r1;
    public transient /* synthetic */ FieldHolder $fh;
    public String i1;
    public String j1;
    public String k1;
    public String l1;
    public String m1;
    public String n1;
    public List<String> o1;
    public String p1;
    public String q1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948018784, "Lcom/baidu/tieba/ny4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948018784, "Lcom/baidu/tieba/ny4;");
                return;
            }
        }
        r1 = BdUniqueId.gen();
    }

    public ny4() {
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

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.l1)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mwa, com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return r1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void I1(RecommendBook recommendBook) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recommendBook) != null) || recommendBook == null) {
            return;
        }
        this.i1 = recommendBook.recommend_text;
        this.j1 = recommendBook.suggest_text;
        this.k1 = recommendBook.suggest_url;
        this.l1 = recommendBook.book_id;
        recommendBook.book_type.intValue();
        this.m1 = recommendBook.book_cover;
        this.n1 = recommendBook.book_title;
        this.o1 = recommendBook.book_tips;
        this.p1 = recommendBook.botton_text;
        this.q1 = recommendBook.subscript_icon;
    }
}
