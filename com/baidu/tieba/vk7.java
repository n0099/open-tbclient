package com.baidu.tieba;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes8.dex */
public final class vk7 implements tk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity a;

    public vk7(FragmentActivity activity) {
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
        this.a = activity;
    }

    public final String f(NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, newsRemindMessage)) == null) {
            int chatCount = newsRemindMessage.getChatCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getNotificationCount();
            if (!newsRemindMessage.hasChatRemind() && !newsRemindMessage.hasMsgRemind() && !newsRemindMessage.hasNotificationRemind()) {
                z = false;
            } else {
                z = true;
            }
            if (chatCount > 0) {
                return "1";
            }
            if (z) {
                return "3";
            }
            return "2";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tk7
    public void a(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            StatisticItem item = new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2);
            Intrinsics.checkNotNullExpressionValue(item, "item");
            e(item);
            TiebaStatic.log(item);
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", i);
            if (i > 0) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(param.param("obj_type", i2).param("obj_source", 2));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_NEW_MSG_TAB_CLICK);
            NewsRemindMessage a = ((w95) ServiceManager.getService(w95.a)).a();
            Intrinsics.checkNotNullExpressionValue(a, "api.newsRemindMessage");
            statisticItem.addParam("obj_type", f(a));
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", 2);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.tk7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem item = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 11);
            Intrinsics.checkNotNullExpressionValue(item, "item");
            e(item);
            TiebaStatic.log(item);
        }
    }

    @Override // com.baidu.tieba.tk7
    public void c(String url, long j, String forumName, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{url, Long.valueOf(j), forumName, Integer.valueOf(i)}) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            TiebaStatic.log(new StatisticItem("c13387").param("fid", j).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i));
            if (StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "/mo/q/forumtarget", false, 2, (Object) null)) {
                TiebaStatic.log(new StatisticItem("c14683").param("fid", j).param("fname", forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    @Override // com.baidu.tieba.tk7
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem item = new StatisticItem("c12402").param("uid", TbadkCoreApplication.getCurrentAccount());
            Intrinsics.checkNotNullExpressionValue(item, "item");
            e(item);
            TiebaStatic.log(item);
        }
    }

    public final void e(StatisticItem statisticItem) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, statisticItem) == null) {
            ViewModel viewModel = new ViewModelProvider(this.a).get(ForumViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…rumViewModel::class.java)");
            ForumViewModel forumViewModel = (ForumViewModel) viewModel;
            hh7 value = forumViewModel.c().getValue();
            String str = null;
            if (value != null) {
                l = Long.valueOf(value.d());
            } else {
                l = null;
            }
            StatisticItem param = statisticItem.param("fid", String.valueOf(l));
            hh7 value2 = forumViewModel.c().getValue();
            if (value2 != null) {
                str = value2.e();
            }
            param.param("fname", str);
        }
    }
}
