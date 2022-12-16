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
/* loaded from: classes7.dex */
public class zt4 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId f1;
    public transient /* synthetic */ FieldHolder $fh;
    public String W0;
    public String X0;
    public String Y0;
    public String Z0;
    public String a1;
    public String b1;
    public List<String> c1;
    public String d1;
    public String e1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948371471, "Lcom/baidu/tieba/zt4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948371471, "Lcom/baidu/tieba/zt4;");
                return;
            }
        }
        f1 = BdUniqueId.gen();
    }

    public zt4() {
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

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return f1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!StringUtils.isNull(this.Z0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n1(RecommendBook recommendBook) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recommendBook) != null) || recommendBook == null) {
            return;
        }
        this.W0 = recommendBook.recommend_text;
        this.X0 = recommendBook.suggest_text;
        this.Y0 = recommendBook.suggest_url;
        this.Z0 = recommendBook.book_id;
        recommendBook.book_type.intValue();
        this.a1 = recommendBook.book_cover;
        this.b1 = recommendBook.book_title;
        this.c1 = recommendBook.book_tips;
        this.d1 = recommendBook.botton_text;
        this.e1 = recommendBook.subscript_icon;
    }
}
