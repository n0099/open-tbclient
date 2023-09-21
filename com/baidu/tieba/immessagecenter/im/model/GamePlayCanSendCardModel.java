package com.baidu.tieba.immessagecenter.im.model;

import androidx.annotation.Keep;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Keep
/* loaded from: classes6.dex */
public class GamePlayCanSendCardModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b mPostAsyncTask;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, String str, String str2);
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Object, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;
        public a b;
        public final /* synthetic */ GamePlayCanSendCardModel c;

        public b(GamePlayCanSendCardModel gamePlayCanSendCardModel, String str, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCanSendCardModel, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gamePlayCanSendCardModel;
            this.a = null;
            this.b = aVar;
            this.a = new NetWork("https://peiwan.baidu.com/peiwan/api/god/can_send_card");
            this.a.addPostData("to_uid", str);
            this.a.setNeedBdussForGet(true);
            this.a.getNetContext().getRequest().mIsNeedTbs = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    String netString = this.a.getNetString();
                    if (this.a.getNetContext().getResponse().isRequestSuccess() && netString != null) {
                        return netString;
                    }
                    return "";
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a != null) {
                    this.a.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.c.parseNetString(str, this.b);
            }
        }
    }

    public GamePlayCanSendCardModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void release() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bVar = this.mPostAsyncTask) != null) {
            bVar.cancel();
            this.mPostAsyncTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseNetString(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, aVar) == null) {
            try {
                if (StringUtils.isNull(str)) {
                    return;
                }
                String optString = new JSONObject(str).optString("data");
                if (StringUtils.isNull(optString)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(optString);
                int i = jSONObject.getInt("can_send_card");
                String string = jSONObject.getString("toast_txt");
                String string2 = jSONObject.getString("content");
                if (aVar != null) {
                    aVar.a(i, string, string2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                aVar.a(3, "", null);
            }
        }
    }

    public void loadSendCardFromServer(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            b bVar = new b(this, str, aVar);
            this.mPostAsyncTask = bVar;
            bVar.execute(new Object[0]);
        }
    }
}
