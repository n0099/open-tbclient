package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.data.StatisticInfoField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class x48 extends BdAsyncTask<String, Integer, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetWork a;
    public String b;
    public String c;
    public long d;
    public long e;
    public String f;
    public Context g;

    public x48(@NonNull Context context, @NonNull String str, long j, @Nullable String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j), str2, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = context;
        this.b = str;
        this.e = j;
        this.f = str2;
        this.d = j2;
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                this.c = new JSONObject(str).getString("pid");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NetWork netWork = this.a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            this.c = null;
            super.cancel(true);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPreExecute();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
            NetWork netWork = new NetWork(TbConfig.URL_REQUEST_PID);
            this.a = netWork;
            String str = null;
            try {
                netWork.addPostData("pic_url", this.b);
                str = this.a.postMultiNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    b(str);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            super.onPostExecute((x48) str);
            PersonalMsgImageActivityConfig personalMsgImageActivityConfig = new PersonalMsgImageActivityConfig(this.g, this.b, TbadkCoreApplication.getCurrentAccountId(), "");
            if (this.f != null) {
                StatisticInfoField statisticInfoField = new StatisticInfoField();
                statisticInfoField.setForumId(String.valueOf(this.e));
                statisticInfoField.setForumName(this.f);
                statisticInfoField.setChatRoomId(String.valueOf(this.d));
                personalMsgImageActivityConfig.setStatisticInfoFild(statisticInfoField);
            }
            personalMsgImageActivityConfig.setFrom(1);
            personalMsgImageActivityConfig.setPid(this.c);
            personalMsgImageActivityConfig.isFromGroupChat(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalMsgImageActivityConfig));
        }
    }
}
