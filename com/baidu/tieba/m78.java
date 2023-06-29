package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.data.StatisticInfoField;
import com.baidu.tieba.gm5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m78 extends BdAsyncTask<String, Integer, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetWork a;
    public String b;
    public String c;
    public long d;
    public long e;
    public String f;
    public Context g;
    public boolean h;
    public HashMap<String, Boolean> i;

    public m78(@NonNull Context context, @NonNull String str, long j, @Nullable String str2, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j), str2, Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new HashMap<>();
        this.g = context;
        this.b = str;
        this.e = j;
        this.f = str2;
        this.d = j2;
        this.h = z;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.i.containsKey(this.c) && this.i.get(this.c).booleanValue()) {
                xi.P(TbadkCoreApplication.getInst(), R.string.save_emotion_duplicate);
            } else if (this.c == null) {
            } else {
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    gm5.b bVar = new gm5.b();
                    bVar.c = this.c;
                    String str = this.b;
                    bVar.a = str;
                    bVar.b = str;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                    return;
                }
                Intent intent = new Intent(gm5.a);
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra(gm5.b, this.b);
                intent.putExtra(gm5.c, this.b);
                intent.putExtra(gm5.d, this.c);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPreExecute();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            NetWork netWork = new NetWork(TbConfig.URL_REQUEST_PID);
            this.a = netWork;
            String str = null;
            try {
                netWork.addPostData("pic_url", this.b);
                str = this.a.postMultiNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    c(str);
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
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            super.onPostExecute((m78) str);
            if (this.h) {
                b();
                e78.a(2, 1, this.e, this.d);
                return;
            }
            PersonalMsgImageActivityConfig personalMsgImageActivityConfig = new PersonalMsgImageActivityConfig(this.g, this.b, TbadkCoreApplication.getCurrentAccountId(), "");
            StatisticInfoField statisticInfoField = new StatisticInfoField();
            String str2 = this.f;
            if (str2 != null) {
                statisticInfoField.setForumName(str2);
            }
            statisticInfoField.setForumId(String.valueOf(this.e));
            statisticInfoField.setChatRoomId(String.valueOf(this.d));
            personalMsgImageActivityConfig.setStatisticInfoFild(statisticInfoField);
            personalMsgImageActivityConfig.setFrom(1);
            personalMsgImageActivityConfig.setPid(this.c);
            personalMsgImageActivityConfig.isFromGroupChat(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalMsgImageActivityConfig));
            e78.a(1, 2, this.e, this.d);
        }
    }
}
