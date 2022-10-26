package com.baidu.tieba.write.write.relevance;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.write.write.relevance.list.ReleavanceItemListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class RelevanceItemSearchData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Gson gson;
    public ReleavanceItemListData mDataList;

    public RelevanceItemSearchData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.gson = new Gson();
    }

    public ReleavanceItemListData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mDataList;
        }
        return (ReleavanceItemListData) invokeV.objValue;
    }

    public void parseJson(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || str == null) {
            return;
        }
        this.mDataList = (ReleavanceItemListData) this.gson.fromJson(str, (Class<Object>) ReleavanceItemListData.class);
    }
}
