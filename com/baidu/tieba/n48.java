package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.gametab.FrsNewUserGuideTipController;
import com.baidu.tieba.oq6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class n48 extends j15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewUserGuideTipController a;
    public final CustomMessageListener b;
    public final CustomMessageListener c;

    /* loaded from: classes7.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n48 n48Var) {
            super(2921827);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n48Var};
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
            this.a = n48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                FrsNewUserGuideTipController frsNewUserGuideTipController = this.a.a;
                if (frsNewUserGuideTipController != null) {
                    frsNewUserGuideTipController.m();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n48 a;

        public b(n48 n48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n48Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
                return (CustomResponsedMessage) invokeL.objValue;
            }
            FrsNewUserGuideTipController frsNewUserGuideTipController = this.a.a;
            if (frsNewUserGuideTipController != null) {
                z = frsNewUserGuideTipController.n();
            } else {
                z = false;
            }
            return new CustomResponsedMessage<>(2921828, Boolean.valueOf(z));
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(n48 n48Var) {
            super(2001304);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n48Var};
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
            this.a = n48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                FrsNewUserGuideTipController frsNewUserGuideTipController = this.a.a;
                if (frsNewUserGuideTipController != null) {
                    frsNewUserGuideTipController.o();
                }
            }
        }
    }

    public n48() {
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
        this.b = new c(this);
        this.c = new a(this);
    }

    public static final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
            MessageManager.getInstance().unRegisterTask(2921828);
        }
    }

    @Override // com.baidu.tieba.j15
    public void a(Context context, x05 data) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (context instanceof f25) {
                f25 f25Var = (f25) context;
                if (f25Var.i1() != null) {
                    if (context instanceof BaseFragmentActivity) {
                        baseFragmentActivity = (BaseFragmentActivity) context;
                    } else {
                        baseFragmentActivity = null;
                    }
                    if (baseFragmentActivity == null) {
                        YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
                        return;
                    }
                    e25 i1 = f25Var.i1();
                    if (i1.F0() != null && i1.a1() != null) {
                        ForumData a1 = i1.a1();
                        Intrinsics.checkNotNull(a1);
                        if (!TextUtils.isEmpty(a1.getId())) {
                            if (!i1.y1()) {
                                YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
                                return;
                            }
                            ForumData a12 = i1.a1();
                            Intrinsics.checkNotNull(a12);
                            String id = a12.getId();
                            Intrinsics.checkNotNullExpressionValue(id, "iDialogExtSupoort.getForumData()!!.id");
                            FrsSpriteNewUserGuide F0 = i1.F0();
                            FrsNewUserGuideTipController frsNewUserGuideTipController = new FrsNewUserGuideTipController(baseFragmentActivity);
                            this.a = frsNewUserGuideTipController;
                            Intrinsics.checkNotNull(frsNewUserGuideTipController);
                            frsNewUserGuideTipController.t(id);
                            FrsNewUserGuideTipController frsNewUserGuideTipController2 = this.a;
                            Intrinsics.checkNotNull(frsNewUserGuideTipController2);
                            frsNewUserGuideTipController2.u(new oq6.e() { // from class: com.baidu.tieba.u38
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // com.baidu.tieba.oq6.e
                                public final void onDismiss() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        n48.c();
                                    }
                                }
                            });
                            FrsNewUserGuideTipController frsNewUserGuideTipController3 = this.a;
                            Intrinsics.checkNotNull(frsNewUserGuideTipController3);
                            Intrinsics.checkNotNull(F0);
                            frsNewUserGuideTipController3.w(F0);
                            new k68().c(TbadkCoreApplication.getCurrentAccount(), id, System.currentTimeMillis(), false);
                            i1.I1(false);
                            baseFragmentActivity.registerListener(this.b);
                            baseFragmentActivity.registerListener(this.c);
                            CustomMessageTask customMessageTask = new CustomMessageTask(2921828, new b(this));
                            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                            MessageManager.getInstance().registerTask(customMessageTask);
                            return;
                        }
                    }
                    YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
                    return;
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示新用户引导弹窗失败：获取到的IForumDialogExtSupport为空");
            YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
        }
    }
}
