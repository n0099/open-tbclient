package com.baidu.tieba.newinterest.model.msg;

import c.a.t0.p2.c.b;
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
/* loaded from: classes12.dex */
public class GetInterestClassListResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> interestSelectionInfoList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetInterestClassListResponseMessage(int i2) {
        super(i2);
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
        this.interestSelectionInfoList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error != 0 || jSONObject == null || (jSONArray = jSONObject.getJSONArray("class_list")) == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                b bVar = new b();
                bVar.k(jSONArray.getJSONObject(i3).optInt("class_id"));
                bVar.i(jSONArray.getJSONObject(i3).optString(ForumSquareActivityConfig.FORUM_CLASS_NAME));
                bVar.m(jSONArray.getJSONObject(i3).optString(ForumSquareActivityConfig.FORUM_CLASS_NAME));
                bVar.h(jSONArray.getJSONObject(i3).optString("class_icon"));
                bVar.j(jSONArray.getJSONObject(i3).optString("class_pic"));
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
