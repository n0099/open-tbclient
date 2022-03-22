package com.baidu.tieba.newinterest.model.msg;

import c.a.p0.s2.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetInterestClassListResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> interestSelectionInfoList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetInterestClassListResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.interestSelectionInfoList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error != 0 || jSONObject == null || (jSONArray = jSONObject.getJSONArray("class_list")) == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                b bVar = new b();
                bVar.k(jSONArray.getJSONObject(i2).optInt("class_id"));
                bVar.i(jSONArray.getJSONObject(i2).optString(ForumSquareActivityConfig.FORUM_CLASS_NAME));
                bVar.m(jSONArray.getJSONObject(i2).optString(ForumSquareActivityConfig.FORUM_CLASS_NAME));
                bVar.h(jSONArray.getJSONObject(i2).optString("class_icon"));
                bVar.j(jSONArray.getJSONObject(i2).optString("class_pic"));
                this.interestSelectionInfoList.add(bVar);
            }
        }
    }

    public List<b> getInterestSelectionInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.interestSelectionInfoList : (List) invokeV.objValue;
    }
}
