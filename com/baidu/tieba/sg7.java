package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public final class sg7 extends og7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public ForumData c;
    public final int d;
    public PublishProgressView e;
    public final CustomMessageListener f;
    public final CustomMessageListener g;
    public final HttpMessageListener h;
    public final CustomMessageListener i;

    /* loaded from: classes8.dex */
    public static final class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sg7 sg7Var) {
            super(CmdConfigHttp.CMD_GET_MY_POST);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.sg7.r(com.baidu.tieba.sg7, org.json.JSONObject, com.baidu.tieba.homepage.RequestGetMyPostNetMessage):org.json.JSONObject
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
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(com.baidu.adp.framework.message.HttpResponsedMessage r6) {
            /*
                r5 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.sg7.a.$ic
                if (r0 != 0) goto L8b
            L4:
                java.lang.String r0 = "responsedMessage"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                com.baidu.adp.framework.message.Message r0 = r6.getOrginalMessage()
                if (r0 == 0) goto L22
                com.baidu.adp.framework.message.Message r0 = r6.getOrginalMessage()
                java.lang.Object r0 = r0.getExtra()
                boolean r1 = r0 instanceof com.baidu.tieba.homepage.RequestGetMyPostNetMessage
                if (r1 == 0) goto L22
                com.baidu.tieba.homepage.RequestGetMyPostNetMessage r0 = (com.baidu.tieba.homepage.RequestGetMyPostNetMessage) r0
                boolean r0 = r0.showErrorToast()
                goto L23
            L22:
                r0 = 1
            L23:
                org.json.JSONObject r1 = new org.json.JSONObject
                r1.<init>()
                boolean r2 = r6 instanceof com.baidu.tieba.homepage.GetMyPostHttpResponseMessage
                if (r2 == 0) goto L8a
                r2 = r6
                com.baidu.tieba.homepage.GetMyPostHttpResponseMessage r2 = (com.baidu.tieba.homepage.GetMyPostHttpResponseMessage) r2
                java.lang.String r3 = r2.getErrorString()
                boolean r3 = com.baidu.adp.lib.util.StringUtils.isNull(r3)
                if (r3 == 0) goto L4b
                com.baidu.tieba.sg7 r3 = r5.a
                androidx.fragment.app.FragmentActivity r3 = r3.w()
                android.content.res.Resources r3 = r3.getResources()
                r4 = 2131693153(0x7f0f0e61, float:1.9015426E38)
                java.lang.String r3 = r3.getString(r4)
                goto L4f
            L4b:
                java.lang.String r3 = r2.getErrorString()
            L4f:
                com.baidu.adp.framework.message.Message r4 = r6.getOrginalMessage()
                java.lang.Object r4 = r4.getExtra()
                boolean r4 = r4 instanceof com.baidu.tieba.homepage.RequestGetMyPostNetMessage
                if (r4 == 0) goto L6c
                com.baidu.adp.framework.message.Message r6 = r6.getOrginalMessage()
                java.lang.Object r6 = r6.getExtra()
                com.baidu.tieba.homepage.RequestGetMyPostNetMessage r6 = (com.baidu.tieba.homepage.RequestGetMyPostNetMessage) r6
                if (r6 == 0) goto L6c
                com.baidu.tieba.sg7 r4 = r5.a
                com.baidu.tieba.sg7.r(r4, r1, r6)
            L6c:
                if (r0 != 0) goto L75
                int r6 = r2.getError()
                if (r6 == 0) goto L75
                return
            L75:
                com.baidu.tieba.sg7 r6 = r5.a
                int r0 = r2.getError()
                java.lang.String r4 = "errorString"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                tbclient.GetMyPost.GetMyPostResIdl r2 = r2.getResponseData()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                com.baidu.tieba.sg7.t(r6, r0, r3, r2, r1)
            L8a:
                return
            L8b:
                r3 = r0
                r4 = 1048576(0x100000, float:1.469368E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r3.invokeL(r4, r5, r6)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.sg7.a.onMessage(com.baidu.adp.framework.message.HttpResponsedMessage):void");
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sg7 sg7Var) {
            super(2001378);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getData() instanceof WriteData) {
                    WriteData writeData = (WriteData) responsedMessage.getData();
                    Intrinsics.checkNotNull(writeData);
                    String forumId = writeData.getForumId();
                    ForumData forumData = this.a.c;
                    if (forumData == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("forumData");
                        forumData = null;
                    }
                    if (StringHelper.equals(forumId, forumData.getId())) {
                        sg7 sg7Var = this.a;
                        WriteData writeData2 = (WriteData) responsedMessage.getData();
                        Intrinsics.checkNotNull(writeData2);
                        sg7Var.B(writeData2.getTabId());
                        MessageManager.getInstance().abortResponsedMessage(responsedMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(sg7 sg7Var) {
            super(2001383);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (!(responsedMessage.getData() instanceof PostWriteCallBackData)) {
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) responsedMessage.getData();
                this.a.H(postWriteCallBackData);
                if (!this.a.A(postWriteCallBackData)) {
                    this.a.v(postWriteCallBackData);
                } else if (this.a.w() instanceof TbPageContextSupport) {
                    pb5.c(((TbPageContextSupport) this.a.w()).getPageContext(), postWriteCallBackData, 1);
                } else {
                    pb5.c(TbadkApplication.getInst().getCurrentPageContext(this.a.w()), postWriteCallBackData, 1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(sg7 sg7Var) {
            super(2921526);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responseMessage) {
            PublishProgressData publishProgressData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responseMessage) == null) {
                Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
                if (responseMessage.getData() == null || !(responseMessage.getData() instanceof PublishProgressData) || (publishProgressData = (PublishProgressData) responseMessage.getData()) == null || WriteMsgHolder.isFromVideoHotTopic() || WriteMsgHolder.getCurrentWriteActivityFromTag() == null) {
                    return;
                }
                PublishProgressView publishProgressView = this.a.e;
                if (publishProgressView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishProgressView");
                    publishProgressView = null;
                }
                publishProgressView.c(publishProgressData);
            }
        }
    }

    public sg7(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.d = 1000;
        this.f = new c(this);
        this.g = new d(this);
        this.h = new a(this);
        this.i = new b(this);
    }

    public final boolean v(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || qd.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.b).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final void F(sg7 this$0, eh7 eh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, eh7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ForumData forumData = new ForumData();
            this$0.c = forumData;
            if (forumData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumData");
                forumData = null;
            }
            forumData.parserProtobuf(eh7Var.e());
        }
    }

    @Override // com.baidu.tieba.og7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            PublishProgressView publishProgressView = binding.i;
            Intrinsics.checkNotNullExpressionValue(publishProgressView, "binding.forumPublishProgressView");
            this.e = publishProgressView;
            E();
            G();
        }
    }

    public static final void I(long j, long j2, long j3) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setParams(j, j2, j3, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public final boolean A(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == 0) {
                i = tg7.k(this.b).B();
            }
            if (tg7.k(this.b).x(i) != null) {
                tg7.k(this.b).K(i);
            }
        }
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
    public static final /* synthetic */ org.json.JSONObject r(com.baidu.tieba.sg7 r0, org.json.JSONObject r1, com.baidu.tieba.homepage.RequestGetMyPostNetMessage r2) {
        /*
            r0.x(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.sg7.r(com.baidu.tieba.sg7, org.json.JSONObject, com.baidu.tieba.homepage.RequestGetMyPostNetMessage):org.json.JSONObject");
    }

    @Override // com.baidu.tieba.og7
    public void g(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.g(i, i2, intent);
            VcodeTool.tryProcessActivityResultOnWriteScene(i, i2, intent);
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.sg7.a.onMessage(com.baidu.adp.framework.message.HttpResponsedMessage):void] */
    public static final /* synthetic */ void t(sg7 sg7Var, int i, String str, GetMyPostResIdl getMyPostResIdl, JSONObject jSONObject) {
        sg7Var.z(i, str, getMyPostResIdl, jSONObject);
    }

    public final void C(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, builder, user_Info) != null) || user_Info == null) {
            return;
        }
        Long l = user_Info.id;
        builder.id = l;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (l != null && l.longValue() == currentAccountId) {
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

    public final void D(by4 by4Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, by4Var, jSONObject) == null) {
            int tabId = by4Var.getTabId();
            if (tabId == 0) {
                tabId = tg7.k(this.b).B();
            }
            pl7 x = tg7.k(this.b).x(tabId);
            if (x != null) {
                tg7.k(this.b).K(tabId);
                if (x.a() instanceof ql7) {
                    ((ql7) x.a()).q2(by4Var, jSONObject);
                }
            }
        }
    }

    public final JSONObject x(JSONObject jSONObject, RequestGetMyPostNetMessage requestGetMyPostNetMessage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, jSONObject, requestGetMyPostNetMessage)) == null) {
            y(jSONObject, String.valueOf(requestGetMyPostNetMessage.getForumId()), String.valueOf(requestGetMyPostNetMessage.getThreadId()), String.valueOf(requestGetMyPostNetMessage.getPostId()), requestGetMyPostNetMessage.getQType(), requestGetMyPostNetMessage.getFrom(), String.valueOf(requestGetMyPostNetMessage.getCallFrom()));
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().observe(this.b, new Observer() { // from class: com.baidu.tieba.tf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        sg7.F(sg7.this, (eh7) obj);
                    }
                }
            });
        }
    }

    public final FragmentActivity w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().registerListener(this.f);
            MessageManager.getInstance().registerListener(this.h);
            MessageManager.getInstance().registerListener(this.g);
            this.i.setSelfListener(true);
            FragmentActivity fragmentActivity = this.b;
            if (fragmentActivity instanceof TbPageContextSupport) {
                this.i.setTag(((TbPageContextSupport) fragmentActivity).getPageContext().getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.i);
        }
    }

    public final void H(PostWriteCallBackData postWriteCallBackData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, postWriteCallBackData) == null) && postWriteCallBackData != null) {
            final long j = JavaTypesHelper.toLong(postWriteCallBackData.getPostId(), 0L);
            final long j2 = JavaTypesHelper.toLong(postWriteCallBackData.getThreadId(), 0L);
            ForumData forumData = this.c;
            if (forumData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumData");
                forumData = null;
            }
            final long j3 = JavaTypesHelper.toLong(forumData.getId(), 0L);
            if (j != 0 && j2 != 0 && j3 != 0) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.bg7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            sg7.I(j2, j, j3);
                        }
                    }
                }, this.d);
                return;
            }
            WriteData writeData = postWriteCallBackData.writeDataForVideo;
            if (writeData != null) {
                by4 by4Var = new by4();
                by4Var.parseFromWriteData(writeData);
                JSONObject jSONObject = new JSONObject();
                String forumId = writeData.getForumId();
                Intrinsics.checkNotNullExpressionValue(forumId, "writeData.forumId");
                String threadId = writeData.getThreadId();
                Intrinsics.checkNotNullExpressionValue(threadId, "writeData.threadId");
                String repostId = writeData.getRepostId();
                Intrinsics.checkNotNullExpressionValue(repostId, "writeData.repostId");
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                y(jSONObject, forumId, threadId, repostId, i, "", "0");
                D(by4Var, jSONObject);
            }
        }
    }

    @Override // com.baidu.tieba.og7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.l();
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public final JSONObject y(JSONObject jSONObject, String str, String str2, String str3, int i, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{jSONObject, str, str2, str3, Integer.valueOf(i), str4, str5})) == null) {
            try {
                jSONObject.put("forum_id", str);
                jSONObject.put("thread_id", str2);
                jSONObject.put("post_id", str3);
                jSONObject.put("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                jSONObject.put("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                jSONObject.put("scr_dip", Float.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
                jSONObject.put("q_type", i);
                if (str4 == null) {
                    str4 = "";
                }
                jSONObject.put("bfrom", str4);
                jSONObject.put(IntentConfig.CALL_FROM, str5);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public final void z(int i, String str, GetMyPostResIdl getMyPostResIdl, JSONObject jSONObject) {
        DataRes dataRes;
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, getMyPostResIdl, jSONObject}) == null) {
            if (i != 0) {
                BdUtilHelper.showToast(this.b, str);
            } else if (getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                by4 by4Var = new by4();
                ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
                User.Builder builder2 = new User.Builder(builder.author);
                C(builder2, getMyPostResIdl.data.user_info);
                User user = builder.author;
                if (user == null || TextUtils.isEmpty(user.name)) {
                    builder.author = builder2.build(true);
                }
                User user2 = builder.author;
                if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && Intrinsics.areEqual(user2.name, user_Info.name)) {
                    builder.author = builder2.build(true);
                }
                builder.cheak_repeat = 1;
                ForumData forumData = this.c;
                ForumData forumData2 = null;
                if (forumData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumData");
                    forumData = null;
                }
                builder.fname = forumData.getName();
                ForumData forumData3 = this.c;
                if (forumData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumData");
                } else {
                    forumData2 = forumData3;
                }
                builder.fid = Long.valueOf(JavaTypesHelper.toLong(forumData2.getId(), 0L));
                by4Var.parserProtobuf(builder.build(true));
                D(by4Var, jSONObject);
            }
        }
    }
}
