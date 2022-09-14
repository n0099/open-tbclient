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
/* loaded from: classes5.dex */
public class qs4 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c1;
    public transient /* synthetic */ FieldHolder $fh;
    public String T0;
    public String U0;
    public String V0;
    public String W0;
    public String X0;
    public String Y0;
    public List<String> Z0;
    public String a1;
    public String b1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948102391, "Lcom/baidu/tieba/qs4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948102391, "Lcom/baidu/tieba/qs4;");
                return;
            }
        }
        c1 = BdUniqueId.gen();
    }

    public qs4() {
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

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.tieba.Cdo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c1 : (BdUniqueId) invokeV.objValue;
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !StringUtils.isNull(this.W0) : invokeV.booleanValue;
    }

    public void k1(RecommendBook recommendBook) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recommendBook) == null) || recommendBook == null) {
            return;
        }
        this.T0 = recommendBook.recommend_text;
        this.U0 = recommendBook.suggest_text;
        this.V0 = recommendBook.suggest_url;
        this.W0 = recommendBook.book_id;
        recommendBook.book_type.intValue();
        this.X0 = recommendBook.book_cover;
        this.Y0 = recommendBook.book_title;
        this.Z0 = recommendBook.book_tips;
        this.a1 = recommendBook.botton_text;
        this.b1 = recommendBook.subscript_icon;
    }
}
