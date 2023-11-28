package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.immessagecenter.msgtab.obs.NewsRemindMsgMonitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class sa9 extends cg1<ba5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements ba5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ba5
        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a() {
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

        @Override // com.baidu.tieba.ba5
        public NewsRemindMessage a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return NewsRemindMsgMonitor.f.a().m();
            }
            return (NewsRemindMessage) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ba5
        public eoc<Boolean> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return NewsRemindMsgMonitor.f.a().i();
            }
            return (eoc) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ba5
        public eoc<NewsRemindMessage> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return NewsRemindMsgMonitor.f.a().k();
            }
            return (eoc) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ba5
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                NewsRemindMsgMonitor.f.a().j().onNext(Boolean.valueOf(z));
            }
        }

        @Override // com.baidu.tieba.ba5
        public boolean d() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Long valueOf = Long.valueOf(SharedPrefHelper.getInstance().getLong("key_msg_remind_frequency_minute", 0L));
                if (valueOf.longValue() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    valueOf = null;
                }
                if (valueOf == null) {
                    return false;
                }
                if (System.currentTimeMillis() - SharedPrefHelper.getInstance().getLong("key_msg_remind_last_show_time", 0L) < valueOf.longValue()) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ba5
        public void e() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || TbSingleton.MsgUpgradeTips.isMsgTabUpgradeTipsShowing() || d()) {
                return;
            }
            NewsRemindMessage m = NewsRemindMsgMonitor.f.a().m();
            int msgCount = m.getMsgCount() + m.getChatCount() + m.getNotificationCount();
            if (!m.hasMsgRemind() && !m.hasChatRemind() && !m.hasNotificationRemind()) {
                z = false;
            } else {
                z = true;
            }
            if (msgCount <= 0 && z && SharedPrefHelper.getInstance().getLong("key_msg_remind_frequency_minute", 0L) > 0) {
                SharedPrefHelper.getInstance().putLong("key_msg_remind_last_show_time", System.currentTimeMillis());
                NewsRemindMsgMonitor.f.a().f();
            }
        }
    }

    public sa9() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cg1
    /* renamed from: a */
    public ba5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (ba5) invokeV.objValue;
    }
}
