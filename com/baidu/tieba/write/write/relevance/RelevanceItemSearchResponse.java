package com.baidu.tieba.write.write.relevance;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class RelevanceItemSearchResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RelevanceItemSearchResp";
    public transient /* synthetic */ FieldHolder $fh;
    public RelevanceItemSearchData mRelevanceItemSearchData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelevanceItemSearchResponse(int i2) {
        super(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (jSONObject != null) {
                RelevanceItemSearchData relevanceItemSearchData = new RelevanceItemSearchData();
                this.mRelevanceItemSearchData = relevanceItemSearchData;
                relevanceItemSearchData.parseJson(jSONObject.toString());
            }
        }
    }

    public RelevanceItemSearchData getResponseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRelevanceItemSearchData : (RelevanceItemSearchData) invokeV.objValue;
    }
}
