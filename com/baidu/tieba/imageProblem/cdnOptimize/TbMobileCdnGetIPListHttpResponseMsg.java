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
/* loaded from: classes7.dex */
public class TbMobileCdnGetIPListHttpResponseMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBCdnMobileListData mobileCdnData;

    /* loaded from: classes7.dex */
    public static class TBCdnMobileListData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f53749a;

        /* renamed from: b  reason: collision with root package name */
        public String f53750b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f53751c;

        public TBCdnMobileListData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53749a = null;
            this.f53750b = null;
            this.f53751c = new ArrayList<>();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMobileCdnGetIPListHttpResponseMsg(int i2) {
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
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
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
                    for (int i3 = 0; i3 < optJSONArray.length() && this.mobileCdnData.f53751c.size() <= 5; i3++) {
                        String string = optJSONArray.getString(i3);
                        if (string != null) {
                            this.mobileCdnData.f53751c.add(string);
                        }
                    }
                }
                this.mobileCdnData.f53749a = optJSONObject.optString("testimg_url");
                this.mobileCdnData.f53750b = optJSONObject.optString("testimg_md5");
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}
