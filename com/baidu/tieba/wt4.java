package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes6.dex */
public class wt4 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId e1;
    public transient /* synthetic */ FieldHolder $fh;
    public String V0;
    public String W0;
    public String X0;
    public String Y0;
    public String Z0;
    public String a1;
    public List<String> b1;
    public String c1;
    public String d1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948282098, "Lcom/baidu/tieba/wt4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948282098, "Lcom/baidu/tieba/wt4;");
                return;
            }
        }
        e1 = BdUniqueId.gen();
    }

    public wt4() {
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

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.tieba.wn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return e1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!StringUtils.isNull(this.Y0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m1(RecommendBook recommendBook) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recommendBook) != null) || recommendBook == null) {
            return;
        }
        this.V0 = recommendBook.recommend_text;
        this.W0 = recommendBook.suggest_text;
        this.X0 = recommendBook.suggest_url;
        this.Y0 = recommendBook.book_id;
        recommendBook.book_type.intValue();
        this.Z0 = recommendBook.book_cover;
        this.a1 = recommendBook.book_title;
        this.b1 = recommendBook.book_tips;
        this.c1 = recommendBook.botton_text;
        this.d1 = recommendBook.subscript_icon;
    }
}
