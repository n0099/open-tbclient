package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class yza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity a;
    public PollingModel b;
    public List<Map<String, Long>> c;
    public final Runnable d;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yza a;

        /* renamed from: com.baidu.tieba.yza$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0548a extends nu5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0548a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.nu5
            public String doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.a.a.c();
                }
                return (String) invokeV.objValue;
            }
        }

        /* loaded from: classes9.dex */
        public class b implements st5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.st5
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null) {
                    this.a.a.b.getGroupUnReadCountData(PollingModel.SUBSCRIBE_GROUP_CHAT_LIST, String.valueOf(System.currentTimeMillis()), str);
                    SafeHandler.getInst().postDelayed(this.a.a.d, m45.a().c());
                }
            }
        }

        public a(yza yzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yzaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yzaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b == null) {
                return;
            }
            ru5.c(new C0548a(this), new b(this));
        }
    }

    public yza(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = new a(this);
        this.a = mainTabActivity;
        this.b = new PollingModel(mainTabActivity.getPageContext(), this.a.getUniqueId());
    }

    @WorkerThread
    public final synchronized String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new ArrayList();
                }
                this.c.clear();
                List<GroupChatRoomPojo> l = au8.j().l(TbadkCoreApplication.getCurrentAccount());
                if (ListUtils.isEmpty(l)) {
                    return "";
                }
                for (GroupChatRoomPojo groupChatRoomPojo : l) {
                    if (groupChatRoomPojo.P() == 0) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("room_id", Long.valueOf(groupChatRoomPojo.getRoomId()));
                        hashMap.put("msg_id", Long.valueOf(groupChatRoomPojo.getLatestMsgId()));
                        hashMap.put("time", Long.valueOf(groupChatRoomPojo.getLastExitChatRoomTime()));
                        this.c.add(hashMap);
                    }
                }
                if (ListUtils.isEmpty(this.c)) {
                    return "";
                }
                String json = DataExt.toJson(this.c);
                if (TextUtils.isEmpty(json)) {
                    return "";
                }
                return json;
            }
        }
        return (String) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.d);
            this.a = null;
        }
    }
}
