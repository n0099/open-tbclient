package com.baidu.tieba;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.BdToken.DecryptCodeHttpRespMsg;
import com.baidu.tbadk.BdToken.DecryptCodeReqMsg;
import com.baidu.tbadk.BdToken.DecryptCodeSocketRespMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckHttpResMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckReqMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckSocketResMsg;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.switchs.AsyncGetClipboardSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tl4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class sl4 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern i;
    public static final Pattern j;
    public static final Pattern k;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public long b;
    public im4 c;
    public tl4 d;
    public AtomicBoolean e;
    public AtomicBoolean f;
    public zm4 g;
    public tl4.b h;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, Integer, ym4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        public a(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ym4 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (strArr == null || strArr.length < 1) {
                    return null;
                }
                String str = strArr[0];
                if (dj.isEmpty(str)) {
                    return null;
                }
                if (this.a.g == null) {
                    this.a.g = new zm4();
                }
                return this.a.g.a(str);
            }
            return (ym4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ym4 ym4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ym4Var) == null) {
                super.onPostExecute(ym4Var);
                if (ym4Var == null) {
                    return;
                }
                if (!ym4Var.d) {
                    if (StringUtils.isNull(ym4Var.a)) {
                        return;
                    }
                    this.a.P(ym4Var.a, ym4Var.c);
                    return;
                }
                UtilHelper.clearClipBoard();
                if (this.a.w(ym4Var.e)) {
                    this.a.I(ym4Var.e);
                    bn4.b(ym4Var.c, ym4Var.e);
                } else if (StringUtils.isNull(ym4Var.a)) {
                } else {
                    this.a.P(ym4Var.a, ym4Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        public b(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public m doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (strArr == null || strArr.length < 1) {
                    return null;
                }
                String str = strArr[0];
                if (!dj.isEmpty(str) && (matcher = sl4.j.matcher(str)) != null && matcher.find() && matcher.groupCount() >= 2) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    if (TextUtils.isEmpty(group2)) {
                        return null;
                    }
                    UserData e = b85.d().e();
                    String tiebaUid = e != null ? e.getTiebaUid() : "";
                    if ((TextUtils.isEmpty(group) || !group.equals(TbadkCoreApplication.getCurrentAccountNameShow())) && !group2.equals(tiebaUid)) {
                        m mVar = new m();
                        mVar.c(group);
                        mVar.d(group2);
                        return mVar;
                    }
                    return null;
                }
                return null;
            }
            return (m) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
                super.onPostExecute(mVar);
                if (mVar == null || this.a.f.get()) {
                    return;
                }
                this.a.f.compareAndSet(false, true);
                TiebaUidCheckReqMsg tiebaUidCheckReqMsg = new TiebaUidCheckReqMsg();
                tiebaUidCheckReqMsg.setTiebaUid(mVar);
                MessageManager.getInstance().sendMessage(tiebaUidCheckReqMsg);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements tl4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        public c(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        @Override // com.baidu.tieba.tl4.b
        public void a(boolean z, om4 om4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, om4Var) == null) && z && om4Var != null) {
                this.a.u();
                this.a.v(om4Var.a(), om4Var.c());
                this.a.x(om4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends di5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.di5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getClipBoardContent() : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ih5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ sl4 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.O(0L);
                }
            }
        }

        public e(sl4 sl4Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl4Var;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ih5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!dj.isEmpty(str)) {
                    sl4.D().r(str);
                } else if (this.a > 0) {
                    gh.a().postDelayed(new a(this), this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        public f(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.O(0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(sl4 sl4Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage responsedMessage) {
            vl4 decryptData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.e.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (!(responsedMessage instanceof DecryptCodeSocketRespMsg)) {
                    return;
                } else {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                }
                if (decryptData == null) {
                    return;
                }
                bn4.c(responsedMessage.getError(), decryptData.g());
                GrowthStatsUtil.statisticClipBoard(decryptData.f());
                UtilHelper.clearClipBoard();
                int g = decryptData.g();
                if (g == 1 || g == 0) {
                    if (MessageManager.getInstance().findTask(2921361) == null || decryptData.g.equals(TbadkCoreApplication.getInst().getCurAiAppid())) {
                        return;
                    }
                    bn4.e();
                    TbadkCoreApplication.getInst().setCurAiAppid(null);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                } else if (g == 2) {
                    bn4.e();
                    this.a.v(decryptData.e(), decryptData.f());
                } else if (g == 4 || g != 3 || StringUtils.isNull(decryptData.f())) {
                } else {
                    bn4.e();
                    this.a.w(decryptData.f());
                    this.a.I(decryptData.f());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(sl4 sl4Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tbadk.core.data.UserData userData;
            TiebaUidCheckReqMsg tiebaUidCheckReqMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f.compareAndSet(true, false);
                if (responsedMessage instanceof TiebaUidCheckSocketResMsg) {
                    userData = ((TiebaUidCheckSocketResMsg) responsedMessage).getUserData();
                } else if (!(responsedMessage instanceof TiebaUidCheckHttpResMsg)) {
                    return;
                } else {
                    userData = ((TiebaUidCheckHttpResMsg) responsedMessage).getUserData();
                }
                m mVar = (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof TiebaUidCheckReqMsg) || (tiebaUidCheckReqMsg = (TiebaUidCheckReqMsg) responsedMessage.getOrginalMessage().getExtra()) == null) ? null : tiebaUidCheckReqMsg.mTiebaUidData;
                if (userData == null || mVar == null) {
                    return;
                }
                UtilHelper.clearClipBoard();
                mm4 d = mm4.d();
                d.b();
                d.e(userData, mVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        /* loaded from: classes5.dex */
        public class a extends di5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.di5
            public String doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a.B() : (String) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements ih5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public b(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ih5
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null) {
                    return;
                }
                this.a.a.r(str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(sl4 sl4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var, Integer.valueOf(i)};
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
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            if (!AsyncGetClipboardSwitch.isOn() || !TbadkCoreApplication.getInst().isMIUIRom()) {
                this.a.r(this.a.B());
                return;
            }
            hi5.b(new a(this), new b(this));
        }
    }

    /* loaded from: classes5.dex */
    public class j extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        public j(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr != null && strArr.length >= 1) {
                    String str = strArr[0];
                    if (dj.isEmpty(str)) {
                        return null;
                    }
                    String E = this.a.E();
                    if (!dj.isEmpty(E) && (matcher = Pattern.compile(E).matcher(str)) != null && matcher.find()) {
                        return str;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((j) str);
                if (str == null) {
                    if (this.a.c == null || !this.a.H()) {
                        return;
                    }
                    this.a.c.b();
                    return;
                }
                this.a.s(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        public k(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr != null && strArr.length >= 1) {
                    String str = strArr[0];
                    if (!dj.isEmpty(str) && (matcher = sl4.k.matcher(str)) != null && matcher.find()) {
                        return str;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((k) str);
                if (str != null) {
                    this.a.w(str.substring(1, str.length() - 1));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final sl4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-428568346, "Lcom/baidu/tieba/sl4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-428568346, "Lcom/baidu/tieba/sl4$l;");
                    return;
                }
            }
            a = new sl4();
        }
    }

    /* loaded from: classes5.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public m() {
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

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.b = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948155246, "Lcom/baidu/tieba/sl4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948155246, "Lcom/baidu/tieba/sl4;");
                return;
            }
        }
        i = Pattern.compile("\\$[0-9A-Za-z@_]{5,300}[#$]", 2);
        j = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2);
        k = Pattern.compile("\\$(com.baidu.tieba://unidispatch/)[0-9a-zA-Z]{1,10}\\?[0-9a-zA-Z_=&%\\-.]{1,300}[$]", 2);
    }

    public sl4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.h = new c(this);
    }

    public static final sl4 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? l.a : (sl4) invokeV.objValue;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || dj.isEmpty(str)) {
            return;
        }
        new b(this).execute(str);
    }

    public final String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (System.currentTimeMillis() - this.b < 2000) {
                return null;
            }
            this.b = System.currentTimeMillis();
            return UtilHelper.getClipBoardContent();
        }
        return (String) invokeV.objValue;
    }

    public final TbPageContext C(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public final String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new String(Base64.decode(ox4.k().q("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0)) : (String) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (dj.isEmpty(clipBoardContent)) {
                return false;
            }
            return J(E(), clipBoardContent) || clipBoardContent.contains("^sZqulxTVsT$") || K(i, clipBoardContent) || K(k, clipBoardContent) || K(j, clipBoardContent);
        }
        return invokeV.booleanValue;
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.a) {
            return;
        }
        L();
        N();
        M();
        tl4 tl4Var = new tl4();
        this.d = tl4Var;
        tl4Var.g(this.h);
        this.c = new im4();
        O(z ? 4000L : 2000L);
        this.a = true;
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String topActivityClassName = UtilHelper.getTopActivityClassName();
            return !dj.isEmpty(topActivityClassName) && topActivityClassName.equals(SpeedRuntimeProvider.MAIN_ACTIVITY_NAME) && TbSingleton.getInstance().isRecommendPage();
        }
        return invokeV.booleanValue;
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse != null ? parse.getQueryParameter("obj_source") : "";
            String queryParameter2 = parse != null ? parse.getQueryParameter("obj_type") : "";
            String queryParameter3 = parse != null ? parse.getQueryParameter("tid") : "";
            String queryParameter4 = parse != null ? parse.getQueryParameter("fname") : "";
            String queryParameter5 = parse != null ? parse.getQueryParameter(TiebaStatic.Params.EQID) : "";
            if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2) && queryParameter2.startsWith("tbcm")) {
                TiebaStatic.log(new StatisticItem("c13390").param("obj_type", queryParameter2).param("obj_source", queryParameter).param("tid", queryParameter3).param("fname", queryParameter4));
            } else {
                TiebaStatic.log(new StatisticItem("c13390").param("obj_type", queryParameter2).param("obj_source", queryParameter).param("tid", queryParameter3).param("fname", queryParameter4).param("query", queryParameter5));
            }
        }
    }

    public boolean J(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            return K(Pattern.compile(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean K(Pattern pattern, String str) {
        InterceptResult invokeLL;
        Matcher matcher;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, pattern, str)) == null) ? (pattern == null || TextUtils.isEmpty(str) || (matcher = pattern.matcher(str)) == null || !matcher.find()) ? false : true : invokeLL.booleanValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            sm8.h(309626, DecryptCodeSocketRespMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, sm8.a(TbConfig.DECRYPT_CODE_URL, 309626));
            tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().registerListener(new g(this, CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626));
            MessageManager.getInstance().registerListener(new h(this, CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, 309702));
            MessageManager.getInstance().registerListener(new i(this, 2001011));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            sm8.h(309702, TiebaUidCheckSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, sm8.a(TbConfig.URL_GET_USER_BY_TIEBA_UID, 309702));
            tbHttpMessageTask.setResponsedClass(TiebaUidCheckHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void O(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                hi5.b(new d(this), new e(this, j2));
                return;
            }
            String B = B();
            if (!dj.isEmpty(B)) {
                D().r(B);
            } else if (j2 > 0) {
                gh.a().postDelayed(new f(this), j2);
            }
        }
    }

    public final void P(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) || this.e.get()) {
            return;
        }
        bn4.b = str;
        bn4.d(str2);
        this.e.compareAndSet(false, true);
        DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
        decryptCodeReqMsg.setCode(str);
        MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || dj.isEmpty(str)) {
            return;
        }
        new j(this).execute(str);
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            q(str);
            t(str);
            y(str);
            z(str);
            A(str);
        }
    }

    public final void s(String str) {
        tl4 tl4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (tl4Var = this.d) == null) {
            return;
        }
        tl4Var.c(str);
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && !dj.isEmpty(str) && str.contains("^sZqulxTVsT$")) {
            s(str);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            UtilHelper.clearClipBoard();
        }
    }

    public final void v(String str, String str2) {
        TbPageContext<?> C;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) || dj.isEmpty(str2) || (C = C(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(C, str, new String[]{str2});
    }

    public final boolean w(String str) {
        InterceptResult invokeL;
        Activity currentActivity;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (dj.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (parse = Uri.parse(str)) == null) {
                return false;
            }
            if (str.startsWith(BdUniDispatchSchemeController.SCHEME)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(BdUniDispatchSchemeController.PARAM_SCHEME_FROM, BdUniDispatchSchemeController.SCHEME_FROM_TB_TOKEN);
                parse = buildUpon.build();
            }
            return UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
        return invokeL.booleanValue;
    }

    public final void x(om4 om4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, om4Var) == null) || om4Var == null || om4Var.b() == null || dj.isEmpty(om4Var.b().a) || !H()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, om4Var.b().a));
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || dj.isEmpty(str)) {
            return;
        }
        new a(this).execute(str);
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || dj.isEmpty(str)) {
            return;
        }
        new k(this).execute(str);
    }
}
