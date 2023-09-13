package com.baidu.tieba.tbadkCore.tiebaStatMsg;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class Static {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null || TextUtils.isEmpty(p.getCmd())) {
                return;
            }
            String content = p.getContent();
            if (TextUtils.isEmpty(content)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                BdUploadStatMsgData bdUploadStatMsgData = new BdUploadStatMsgData();
                bdUploadStatMsgData.parentType = jSONObject.optString("type");
                bdUploadStatMsgData.childType = jSONObject.optString("sub_type");
                boolean z = true;
                if (jSONObject.optInt("is_wifi") != 1) {
                    z = false;
                }
                bdUploadStatMsgData.isWifi = z;
                if (jSONObject.optLong("continue_time") > 0) {
                    bdUploadStatMsgData.deadLineTime = System.currentTimeMillis() + (jSONObject.optLong("continue_time") * 1000);
                }
                BdStatisticsManager.getInstance().addEntryToTmpSwitchConfDic(bdUploadStatMsgData.parentType, bdUploadStatMsgData.childType, bdUploadStatMsgData);
            } catch (Exception unused) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1453505152, "Lcom/baidu/tieba/tbadkCore/tiebaStatMsg/Static;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1453505152, "Lcom/baidu/tieba/tbadkCore/tiebaStatMsg/Static;");
                return;
            }
        }
        a aVar = new a(0);
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(2001320, aVar);
        }
    }

    public Static() {
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
}
