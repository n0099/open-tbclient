package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.h5.FrsTabWebFragment;
import com.baidu.tieba.frs.h5.NewFrsTabWebFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class qo7 extends wo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener h;
    public final CustomMessageListener i;
    public final NetMessageListener j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qo7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qo7 qo7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo7Var, Integer.valueOf(i)};
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
            this.a = qo7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && this.a.b.d1() != null) {
                    FrsViewData d1 = this.a.b.d1();
                    d1.removeThread(str);
                    po7 po7Var = this.a.g;
                    if (po7Var != null) {
                        po7Var.k(str);
                    }
                    this.a.a.M1(d1.getThreadList(), d1);
                    if (z9a.i() != null) {
                        z9a.i().n(this.a.b.v(), false);
                    }
                    if (this.a.b != null) {
                        if (gf7.g()) {
                            new BdTopToast(this.a.b.getContext()).setIcon(true).setContent(this.a.b.getContext().getString(R.string.shield_success)).show((ViewGroup) this.a.b.W3());
                        } else {
                            new BdTopToast(this.a.b.getContext()).setIcon(true).setContent(this.a.b.getContext().getString(R.string.delete_success)).show((ViewGroup) this.a.b.W3());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qo7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qo7 qo7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo7Var, Integer.valueOf(i)};
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
            this.a = qo7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumManageModel.e eVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e)) {
                qo7 qo7Var = this.a;
                if (qo7Var.b != null && qo7Var.a != null && qo7Var.d != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.a) && this.a.b.d1() != null) {
                    String str = eVar.a;
                    String str2 = eVar.b;
                    String str3 = eVar.c;
                    if (eVar.d == 4) {
                        FrsViewData d1 = this.a.b.d1();
                        ThreadData threadDataById = d1.getThreadDataById(str);
                        d1.removeThreadData(threadDataById);
                        List<ym> topThreadList = d1.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        this.a.a.M1(d1.getThreadList(), d1);
                        this.a.d.q0(d1);
                    }
                    if (TextUtils.equals(this.a.b.v(), str3)) {
                        z9a.i().n(this.a.b.v(), false);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qo7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(qo7 qo7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = qo7Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.qo7.a(com.baidu.tieba.qo7, org.json.JSONObject, com.baidu.tieba.homepage.RequestGetMyPostNetMessage):org.json.JSONObject
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(com.baidu.adp.framework.message.ResponsedMessage<?> r8) {
            /*
                r7 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.qo7.c.$ic
                if (r0 != 0) goto Le1
            L4:
                if (r8 == 0) goto L1f
                com.baidu.adp.framework.message.Message r0 = r8.getOrginalMessage()
                if (r0 == 0) goto L1f
                com.baidu.adp.framework.message.Message r0 = r8.getOrginalMessage()
                java.lang.Object r0 = r0.getExtra()
                boolean r1 = r0 instanceof com.baidu.tieba.homepage.RequestGetMyPostNetMessage
                if (r1 == 0) goto L1f
                com.baidu.tieba.homepage.RequestGetMyPostNetMessage r0 = (com.baidu.tieba.homepage.RequestGetMyPostNetMessage) r0
                boolean r0 = r0.showErrorToast()
                goto L20
            L1f:
                r0 = 1
            L20:
                org.json.JSONObject r6 = new org.json.JSONObject
                r6.<init>()
                boolean r1 = r8 instanceof com.baidu.tieba.homepage.GetMyPostHttpResponseMessage
                r2 = 0
                r3 = 2131693089(0x7f0f0e21, float:1.9015296E38)
                if (r1 == 0) goto L85
                r1 = r8
                com.baidu.tieba.homepage.GetMyPostHttpResponseMessage r1 = (com.baidu.tieba.homepage.GetMyPostHttpResponseMessage) r1
                java.lang.String r4 = r1.getErrorString()
                boolean r4 = com.baidu.adp.lib.util.StringUtils.isNull(r4)
                if (r4 == 0) goto L47
                com.baidu.tieba.qo7 r4 = r7.a
                com.baidu.tieba.frs.FrsFragment r4 = r4.b
                android.content.res.Resources r4 = r4.getResources()
                java.lang.String r3 = r4.getString(r3)
                goto L4b
            L47:
                java.lang.String r3 = r1.getErrorString()
            L4b:
                com.baidu.adp.framework.message.Message r4 = r8.getOrginalMessage()
                java.lang.Object r4 = r4.getExtra()
                boolean r4 = r4 instanceof com.baidu.tieba.homepage.RequestGetMyPostNetMessage
                if (r4 == 0) goto L6c
                com.baidu.adp.framework.message.Message r8 = r8.getOrginalMessage()
                java.lang.Object r8 = r8.getExtra()
                com.baidu.tieba.homepage.RequestGetMyPostNetMessage r8 = (com.baidu.tieba.homepage.RequestGetMyPostNetMessage) r8
                int r2 = r8.getProZone()
                com.baidu.tieba.qo7 r4 = r7.a
                com.baidu.tieba.qo7.a(r4, r6, r8)
                r5 = r2
                goto L6d
            L6c:
                r5 = 0
            L6d:
                if (r0 != 0) goto L76
                int r8 = r1.getError()
                if (r8 == 0) goto L76
                return
            L76:
                com.baidu.tieba.qo7 r8 = r7.a
                int r2 = r1.getError()
                tbclient.GetMyPost.GetMyPostResIdl r4 = r1.getResponseData()
                r1 = r8
                com.baidu.tieba.qo7.b(r1, r2, r3, r4, r5, r6)
                goto Le0
            L85:
                boolean r1 = r8 instanceof com.baidu.tieba.homepage.GetMyPostSocketResponseMessage
                if (r1 == 0) goto Le0
                r1 = r8
                com.baidu.tieba.homepage.GetMyPostSocketResponseMessage r1 = (com.baidu.tieba.homepage.GetMyPostSocketResponseMessage) r1
                java.lang.String r4 = r1.getErrorString()
                boolean r4 = com.baidu.adp.lib.util.StringUtils.isNull(r4)
                if (r4 == 0) goto La3
                com.baidu.tieba.qo7 r4 = r7.a
                com.baidu.tieba.frs.FrsFragment r4 = r4.b
                android.content.res.Resources r4 = r4.getResources()
                java.lang.String r3 = r4.getString(r3)
                goto La7
            La3:
                java.lang.String r3 = r1.getErrorString()
            La7:
                com.baidu.adp.framework.message.Message r4 = r8.getOrginalMessage()
                java.lang.Object r4 = r4.getExtra()
                boolean r4 = r4 instanceof com.baidu.tieba.homepage.RequestGetMyPostNetMessage
                if (r4 == 0) goto Lc8
                com.baidu.adp.framework.message.Message r8 = r8.getOrginalMessage()
                java.lang.Object r8 = r8.getExtra()
                com.baidu.tieba.homepage.RequestGetMyPostNetMessage r8 = (com.baidu.tieba.homepage.RequestGetMyPostNetMessage) r8
                int r2 = r8.getProZone()
                com.baidu.tieba.qo7 r4 = r7.a
                com.baidu.tieba.qo7.a(r4, r6, r8)
                r5 = r2
                goto Lc9
            Lc8:
                r5 = 0
            Lc9:
                if (r0 != 0) goto Ld2
                int r8 = r1.getError()
                if (r8 == 0) goto Ld2
                return
            Ld2:
                com.baidu.tieba.qo7 r8 = r7.a
                int r2 = r1.getError()
                tbclient.GetMyPost.GetMyPostResIdl r4 = r1.getResponseData()
                r1 = r8
                com.baidu.tieba.qo7.b(r1, r2, r3, r4, r5, r6)
            Le0:
                return
            Le1:
                r5 = r0
                r6 = 1048576(0x100000, float:1.469368E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r5.invokeL(r6, r7, r8)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.qo7.c.onMessage(com.baidu.adp.framework.message.ResponsedMessage):void");
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ qo7 d;

        public d(qo7 qo7Var, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo7Var, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = qo7Var;
            this.a = j;
            this.b = j2;
            this.c = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setParams(this.a, this.b, this.c, equipmentWidth, equipmentHeight, f, i);
                this.d.b.sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qo7(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, 2921031);
        this.i = new b(this, 2921316);
        c cVar = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.j = cVar;
        cVar.getSocketMessageListener().setSelfListener(true);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.h.setSelfListener(false);
        this.b.registerListener(this.h);
        this.b.registerListener(this.j);
        this.b.registerListener(this.i);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ org.json.JSONObject a(com.baidu.tieba.qo7 r0, org.json.JSONObject r1, com.baidu.tieba.homepage.RequestGetMyPostNetMessage r2) {
        /*
            r0.e(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.qo7.a(com.baidu.tieba.qo7, org.json.JSONObject, com.baidu.tieba.homepage.RequestGetMyPostNetMessage):org.json.JSONObject");
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.qo7.c.onMessage(com.baidu.adp.framework.message.ResponsedMessage<?>):void] */
    public static /* synthetic */ void b(qo7 qo7Var, int i, String str, GetMyPostResIdl getMyPostResIdl, int i2, JSONObject jSONObject) {
        qo7Var.g(i, str, getMyPostResIdl, i2, jSONObject);
    }

    public final void c(ThreadData threadData, FrsNewAreaFragment frsNewAreaFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, frsNewAreaFragment) == null) {
            frsNewAreaFragment.k2(threadData);
        }
    }

    public final void d(q25 q25Var) {
        FrsViewData d1;
        ArrayList<ym> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q25Var) != null) || (d1 = this.b.d1()) == null) {
            return;
        }
        this.e.X(q25Var);
        if (this.e.L0()) {
            ArrayList<ym> arrayList = new ArrayList<>();
            arrayList.add(q25Var);
            threadList = this.g.c(false, true, arrayList, null, true, -1, null);
        } else {
            threadList = d1.getThreadList();
        }
        if (threadList != null) {
            d1.setThreadList(threadList);
            d1.checkLiveStageInThreadList();
            this.a.M1(threadList, d1);
        }
    }

    public final JSONObject e(JSONObject jSONObject, RequestGetMyPostNetMessage requestGetMyPostNetMessage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, requestGetMyPostNetMessage)) == null) {
            f(jSONObject, String.valueOf(requestGetMyPostNetMessage.getForumId()), String.valueOf(requestGetMyPostNetMessage.getThreadId()), String.valueOf(requestGetMyPostNetMessage.getPostId()), requestGetMyPostNetMessage.getQType(), requestGetMyPostNetMessage.getFrom(), String.valueOf(requestGetMyPostNetMessage.getCallFrom()));
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final JSONObject f(JSONObject jSONObject, String str, String str2, String str3, int i, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{jSONObject, str, str2, str3, Integer.valueOf(i), str4, str5})) == null) {
            try {
                jSONObject.put("forum_id", str);
                jSONObject.put("thread_id", str2);
                jSONObject.put("post_id", str3);
                jSONObject.put("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                jSONObject.put("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                jSONObject.put("scr_dip", TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                jSONObject.put("q_type", i);
                jSONObject.put("bfrom", str4);
                jSONObject.put(IntentConfig.CALL_FROM, str5);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public final void g(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2, JSONObject jSONObject) {
        DataRes dataRes;
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, getMyPostResIdl, Integer.valueOf(i2), jSONObject}) == null) {
            if (i != 0) {
                this.b.showToast(str);
                return;
            }
            FrsViewData d1 = this.b.d1();
            if (d1 != null && d1.getForum() != null && getMyPostResIdl != null && this.a != null && this.e != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                q25 q25Var = new q25();
                ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
                User.Builder builder2 = new User.Builder(builder.author);
                h(builder2, getMyPostResIdl.data.user_info);
                User user = builder.author;
                if (user == null || TextUtils.isEmpty(user.name)) {
                    builder.author = builder2.build(true);
                }
                User user2 = builder.author;
                if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
                    builder.author = builder2.build(true);
                }
                builder.cheak_repeat = 1;
                builder.fname = d1.getForum().getName();
                builder.fid = Long.valueOf(JavaTypesHelper.toLong(d1.getForum().getId(), 0L));
                q25Var.parserProtobuf(builder.build(true));
                i(q25Var, i2, jSONObject);
            }
        }
    }

    public final void h(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, builder, user_Info) != null) || user_Info == null) {
            return;
        }
        Long l = user_Info.id;
        builder.id = l;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        if (l.longValue() == TbadkCoreApplication.getCurrentAccountId()) {
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        } else {
            builder.portrait = user_Info.portrait;
        }
        builder.god_data = user_Info.god_data;
        builder.fans_num = user_Info.fans_num;
        builder.fans_nickname = user_Info.fans_nickname;
        builder.is_bawu = user_Info.is_bawu;
        builder.bawu_type = user_Info.bawu_type;
        builder.new_god_data = user_Info.new_god_data;
        builder.business_account_info = user_Info.business_account_info;
    }

    public final void i(q25 q25Var, int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, q25Var, i, jSONObject) == null) {
            if (i == 2) {
                FrsTabViewController.i I = this.b.Y3().I(301);
                if (I != null && (I.b instanceof FrsGoodFragment)) {
                    this.c.b(301);
                    ((FrsGoodFragment) I.b).i2(q25Var);
                }
            } else if (q25Var.getTabId() > 0) {
                FrsTabViewController.i I2 = this.b.Y3().I(q25Var.getTabId());
                if (I2 != null) {
                    Fragment fragment = I2.b;
                    if (fragment instanceof FrsCommonTabFragment) {
                        ((FrsCommonTabFragment) fragment).S1(q25Var);
                    } else if (fragment instanceof FrsTabWebFragment) {
                        ((FrsTabWebFragment) fragment).i2(q25Var, jSONObject);
                    } else if (fragment instanceof NewFrsTabWebFragment) {
                        ((NewFrsTabWebFragment) fragment).h2(q25Var, jSONObject);
                    }
                }
            } else {
                if (!ListUtils.isEmpty(q25Var.getItemStar())) {
                    q25Var.insertItemToTitleOrAbstractText();
                }
                FrsTabViewController.i I3 = this.b.Y3().I(this.b.Y3().E());
                if (I3 != null) {
                    Fragment fragment2 = I3.b;
                    if (fragment2 instanceof FrsNewAreaFragment) {
                        c(q25Var, (FrsNewAreaFragment) fragment2);
                    } else {
                        d(q25Var);
                    }
                }
            }
        }
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        FrsModelController frsModelController;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, postWriteCallBackData) != null) || (frsModelController = this.e) == null) {
            return;
        }
        int i = 0;
        if (frsModelController.v0() != null && this.e.v0().getIsBrandForum()) {
            z = true;
        } else {
            z = false;
        }
        int i0 = this.e.i0();
        int i2 = 2;
        if (i0 != 2 && i0 != 3 && i0 != 7 && i0 != 8 && !z) {
            return;
        }
        int n0 = this.e.n0();
        if (bg7.a().b(1) != null) {
            i = n0;
        }
        if (i == 0 && postWriteCallBackData != null) {
            long j = JavaTypesHelper.toLong(postWriteCallBackData.getPostId(), 0L);
            long j2 = JavaTypesHelper.toLong(postWriteCallBackData.getThreadId(), 0L);
            long j3 = JavaTypesHelper.toLong(this.b.w(), 0L);
            if (j != 0 && j2 != 0 && j3 != 0) {
                SafeHandler.getInst().postDelayed(new d(this, j2, j, j3), 1000L);
                return;
            }
            WriteData writeData = postWriteCallBackData.writeDataForVideo;
            if (writeData != null) {
                q25 q25Var = new q25();
                q25Var.parseFromWriteData(writeData);
                JSONObject jSONObject = new JSONObject();
                String forumId = writeData.getForumId();
                String threadId = writeData.getThreadId();
                String repostId = writeData.getRepostId();
                if (!TbImageHelper.getInstance().isShowBigImage()) {
                    i2 = 1;
                }
                f(jSONObject, forumId, threadId, repostId, i2, "", "0");
                i(q25Var, -1, jSONObject);
            }
        }
    }
}
