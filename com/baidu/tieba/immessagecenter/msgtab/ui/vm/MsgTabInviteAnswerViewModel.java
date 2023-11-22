package com.baidu.tieba.immessagecenter.msgtab.ui.vm;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel;
import com.baidu.tieba.ku4;
import com.baidu.tieba.moc;
import com.baidu.tieba.t69;
import com.baidu.tieba.u69;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0003H\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0014J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgTabInviteAnswerViewModel;", "Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterInviteAnswerUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterInviteAnswerUiIntent;", "()V", "mNewMessageListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mShieldInvitationListener", "gotoWebActivity", "", "context", "Landroid/content/Context;", "objType", "", "handleUiIntent", "intent", "initUiState", "onAttachedUi", "onDetachedUi", "registerSubscribe", "Lrx/subscriptions/CompositeSubscription;", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabInviteAnswerViewModel extends BaseViewModel<u69, t69> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener d;
    public final CustomMessageListener e;

    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    public moc l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (moc) invokeV.objValue;
    }

    public MsgTabInviteAnswerViewModel() {
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
        this.d = new CustomMessageListener(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgTabInviteAnswerViewModel$mShieldInvitationListener$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsgTabInviteAnswerViewModel a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2921727);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> msg) {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, msg) == null) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    if (getCmd() == 2921727) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Boolean bool = null;
                    if (!z) {
                        msg = null;
                    }
                    if (msg != null) {
                        Object data = msg.getData();
                        if (data instanceof Boolean) {
                            bool = (Boolean) data;
                        }
                        if (bool != null) {
                            MsgTabInviteAnswerViewModel msgTabInviteAnswerViewModel = this.a;
                            final boolean booleanValue = bool.booleanValue();
                            msgTabInviteAnswerViewModel.c(new Function1<u69, u69>(booleanValue) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgTabInviteAnswerViewModel$mShieldInvitationListener$1$onMessage$3$1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ boolean $it;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                                        newInitContext2.initArgs = r2;
                                        Object[] objArr = {Boolean.valueOf(booleanValue)};
                                        interceptable3.invokeUnInit(65536, newInitContext2);
                                        int i3 = newInitContext2.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            super(((Integer) newInitContext2.callArgs[0]).intValue());
                                            newInitContext2.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext2);
                                            return;
                                        }
                                    }
                                    this.$it = booleanValue;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // kotlin.jvm.functions.Function1
                                public final u69 invoke(u69 emitUiState) {
                                    InterceptResult invokeL;
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || (invokeL = interceptable3.invokeL(1048576, this, emitUiState)) == null) {
                                        Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                                        return new u69.b(this.$it);
                                    }
                                    return (u69) invokeL.objValue;
                                }
                            });
                        }
                    }
                }
            }
        };
        this.e = new CustomMessageListener(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgTabInviteAnswerViewModel$mNewMessageListener$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsgTabInviteAnswerViewModel a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2001120);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(final CustomResponsedMessage<?> msg) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, msg) == null) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    if (msg.getCmd() == 2001120 && (msg instanceof NewsNotifyMessage)) {
                        this.a.c(new Function1<u69, u69>(msg) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgTabInviteAnswerViewModel$mNewMessageListener$1$onMessage$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ CustomResponsedMessage<?> $msg;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {msg};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i3 = newInitContext2.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.$msg = msg;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // kotlin.jvm.functions.Function1
                            public final u69 invoke(u69 emitUiState) {
                                InterceptResult invokeL;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || (invokeL = interceptable3.invokeL(1048576, this, emitUiState)) == null) {
                                    Intrinsics.checkNotNullParameter(emitUiState, "$this$emitUiState");
                                    return new u69.a(((NewsNotifyMessage) this.$msg).getMsgInvitation());
                                }
                                return (u69) invokeL.objValue;
                            }
                        });
                    }
                }
            }
        };
    }

    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel, com.baidu.tieba.ox8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.b();
            MessageManager.getInstance().registerListener(this.d);
            MessageManager.getInstance().registerListener(this.e);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel, com.baidu.tieba.ox8
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.g();
            MessageManager.getInstance().unRegisterListener(this.d);
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: p */
    public u69 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new u69.b(SharedPrefHelper.getInstance().getBoolean("key_question_msg_no_remind", false));
        }
        return (u69) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel
    /* renamed from: o */
    public void i(t69 intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (intent instanceof t69.a) {
                t69.a aVar = (t69.a) intent;
                n(aVar.a(), aVar.b());
            }
        }
    }

    public final void n(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, context, i) == null) {
            SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("msg_tab_entrance_invitation_answer_unread_num"), 0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2008024));
            new StatisticItem(CommonStatisticKey.KEY_QUESTION_ENTRANCE_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", i).eventStat();
            ku4 j = ku4.j(context, TbConfig.QUESTION_THREAD_LIST);
            j.r(context.getString(R.string.obfuscated_res_0x7f0f0b23));
            j.k(true);
            j.d(true);
            TbWebViewActivityConfig b = j.b();
            if (b != null) {
                b.setNoClose(true);
                b.setNoHelp(false);
                b.setCustomMoreHelp(true);
                b.start();
            }
        }
    }
}
