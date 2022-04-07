package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TbMobileCdnGetIPListHttpResponseMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBCdnMobileListData mobileCdnData;

    /* loaded from: classes3.dex */
    public static class TBCdnMobileListData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public ArrayList<String> c;

        public TBCdnMobileListData() {
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
            this.a = null;
            this.b = null;
            this.c = new ArrayList<>();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMobileCdnGetIPListHttpResponseMsg(int i) {
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
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject == null) {
                return;
            }
            try {
                if (jSONObject.optInt("status", -1) != 0) {
                    return;
                }
                if (this.mobileCdnData == null) {
                    this.mobileCdnData = new TBCdnMobileListData();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                JSONArray optJSONArray = optJSONObject.optJSONArray("vips");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length() && this.mobileCdnData.c.size() <= 5; i2++) {
                        String string = optJSONArray.getString(i2);
                        if (string != null) {
                            this.mobileCdnData.c.add(string);
                        }
                    }
                }
                this.mobileCdnData.a = optJSONObject.optString("testimg_url");
                this.mobileCdnData.b = optJSONObject.optString("testimg_md5");
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
