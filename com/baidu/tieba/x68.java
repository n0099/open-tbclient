package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.WindowToast;
/* loaded from: classes9.dex */
public class x68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements iv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ BaseFragment b;
        public final /* synthetic */ ms7 c;

        public a(View view2, BaseFragment baseFragment, ms7 ms7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, baseFragment, ms7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = baseFragment;
            this.c = ms7Var;
        }

        @Override // com.baidu.tieba.iv4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    zh5.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    View view2 = this.a;
                    if (view2 != null) {
                        view2.setVisibility(8);
                        return;
                    }
                    return;
                }
                new BdTopToast(this.b.getContext()).setIcon(false).setContent(this.b.getString(R.string.forum_broadcast_copy_no_permission_hint)).show(this.c.r0());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements iv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // com.baidu.tieba.iv4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                zh5.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                View view2 = this.a;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        }
    }

    public static void a(BaseFragment baseFragment, String str, boolean z, View view2, ms7 ms7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{baseFragment, str, Boolean.valueOf(z), view2, ms7Var}) == null) && baseFragment != null && ms7Var != null && view2 != null && FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(str) && !z) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(baseFragment.getContext())) {
                    d(baseFragment, view2, ms7Var);
                    return;
                } else {
                    new BdTopToast(baseFragment.getContext()).setIcon(false).setContent(baseFragment.getString(R.string.forum_broadcast_copy_no_permission_hint)).show(ms7Var.r0());
                    return;
                }
            }
            d(baseFragment, view2, ms7Var);
        }
    }

    public static void b(BaseFragment baseFragment, String str, boolean z, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{baseFragment, str, Boolean.valueOf(z), view2}) == null) && baseFragment != null && view2 != null && FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(str) && !z) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(baseFragment.getContext())) {
                    e(baseFragment, view2);
                    return;
                } else if (Build.VERSION.SDK_INT < 23 || !SharedPrefHelper.getInstance().getBoolean("key_forum_rule_dialog_show_frs", false)) {
                    e(baseFragment, view2);
                    SharedPrefHelper.getInstance().putBoolean("key_forum_rule_dialog_show_frs", true);
                    return;
                } else {
                    return;
                }
            }
            e(baseFragment, view2);
        }
    }

    public static void c(Activity activity, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, activity, frsViewData) == null) && activity != null && activity.getIntent() != null) {
            String stringExtra = activity.getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                activity.getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(activity);
                achievementActivityConfig.setUrl(stringExtra);
                if (frsViewData != null && frsViewData.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(frsViewData.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, achievementActivityConfig));
            }
        }
    }

    public static void d(BaseFragment baseFragment, View view2, ms7 ms7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, baseFragment, view2, ms7Var) == null) && baseFragment != null && ms7Var != null && view2 != null && baseFragment.getPageContext() != null && baseFragment.getPageContext().getOrignalPage() != null) {
            zh5.h().m(new wh5(baseFragment.getContext()));
            zh5.h().n(85, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (zh5.h().j()) {
                baseFragment.getPageContext().getOrignalPage().grantWindowPermission(new a(view2, baseFragment, ms7Var), true);
            }
        }
    }

    public static void e(BaseFragment baseFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, baseFragment, view2) == null) && baseFragment != null && view2 != null && baseFragment.getPageContext() != null && baseFragment.getPageContext().getOrignalPage() != null) {
            zh5.h().m(new xh5(baseFragment.getContext()));
            zh5.h().n(85, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (zh5.h().j()) {
                baseFragment.getPageContext().getOrignalPage().grantWindowPermission(new b(view2), true);
            }
        }
    }

    public static void g(FrsViewData frsViewData, ms7 ms7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, frsViewData, ms7Var) == null) {
            if (frsViewData != null && frsViewData.getForum() == null) {
                if (ms7Var != null && frsViewData.getForum() != null && frsViewData.getForum().getYuleData() != null) {
                    if (frsViewData.getForum().getYuleData() != null && frsViewData.getForum().getYuleData().a()) {
                        TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                        ms7Var.S1(frsViewData.getForum().getYuleData().b());
                        return;
                    }
                    ms7Var.A0();
                }
            } else if (ms7Var != null) {
                ms7Var.A0();
            }
        }
    }

    public static void f(Context context, int i, FrsViewData frsViewData) {
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65541, null, context, i, frsViewData) == null) && TbadkCoreApplication.isLogin() && frsViewData != null && (list = frsViewData.mWindowToast) != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                WindowToast windowToast = list.get(i2);
                if (windowToast != null && windowToast.toast_type.intValue() == i) {
                    if (!rd.isEmpty(windowToast.toast_link)) {
                        BrowserHelper.startWebActivity(context, "", WebviewHelper.addParamsForPageTranslucent(windowToast.toast_link), true);
                        return;
                    }
                    return;
                }
            }
        }
    }
}
