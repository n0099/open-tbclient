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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.view.FrsBroadcastCopyGuideDialogView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.WindowToast;
/* loaded from: classes5.dex */
public class ni7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c05 a;
        public final /* synthetic */ BaseFragment b;
        public final /* synthetic */ View c;
        public final /* synthetic */ e57 d;

        public a(c05 c05Var, BaseFragment baseFragment, View view2, e57 e57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c05Var, baseFragment, view2, e57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c05Var;
            this.b = baseFragment;
            this.c = view2;
            this.d = e57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c05 c05Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (c05Var = this.a) != null) {
                c05Var.dismiss();
                ni7.f(this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements kv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ BaseFragment b;
        public final /* synthetic */ e57 c;

        public b(View view2, BaseFragment baseFragment, e57 e57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, baseFragment, e57Var};
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
            this.c = e57Var;
        }

        @Override // com.baidu.tieba.kv4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    jf5.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    View view2 = this.a;
                    if (view2 != null) {
                        view2.setVisibility(8);
                        return;
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.b.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.b.getString(R.string.obfuscated_res_0x7f0f06b9));
                bdTopToast.i(this.c.r0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements kv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public c(View view2) {
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

        @Override // com.baidu.tieba.kv4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                jf5.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                View view2 = this.a;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        }
    }

    public static void b(BaseFragment baseFragment, String str, boolean z, View view2, e57 e57Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{baseFragment, str, Boolean.valueOf(z), view2, e57Var}) == null) && baseFragment != null && e57Var != null && view2 != null && FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(str) && !z) {
            int n = p45.m().n("key_forum_broadcast_edit_tip_number", 0);
            if (n < 2) {
                p45.m().z("key_forum_broadcast_edit_tip_number", n + 1);
                e(baseFragment, view2, e57Var);
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(baseFragment.getContext())) {
                    f(baseFragment, view2, e57Var);
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(baseFragment.getContext());
                bdTopToast.h(false);
                bdTopToast.g(baseFragment.getString(R.string.obfuscated_res_0x7f0f06b9));
                bdTopToast.i(e57Var.r0());
            } else {
                f(baseFragment, view2, e57Var);
            }
        }
    }

    public static void c(BaseFragment baseFragment, String str, boolean z, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{baseFragment, str, Boolean.valueOf(z), view2}) == null) && baseFragment != null && view2 != null && FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(str) && !z) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(baseFragment.getContext())) {
                    g(baseFragment, view2);
                    return;
                } else if (Build.VERSION.SDK_INT < 23 || !p45.m().i("key_forum_rule_dialog_show_frs", false)) {
                    g(baseFragment, view2);
                    p45.m().w("key_forum_rule_dialog_show_frs", true);
                    return;
                } else {
                    return;
                }
            }
            g(baseFragment, view2);
        }
    }

    public static void d(Activity activity, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, activity, frsViewData) == null) && activity != null && activity.getIntent() != null) {
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

    public static void e(BaseFragment baseFragment, View view2, e57 e57Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, baseFragment, view2, e57Var) == null) && baseFragment != null && view2 != null && e57Var != null) {
            c05 c05Var = new c05(baseFragment.getFragmentActivity());
            c05Var.setContentViewSize(2);
            c05Var.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(baseFragment.getContext());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new a(c05Var, baseFragment, view2, e57Var));
            c05Var.setContentView(frsBroadcastCopyGuideDialogView);
            c05Var.create(baseFragment.getPageContext()).show();
        }
    }

    public static void h(Context context, int i, FrsViewData frsViewData) {
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65543, null, context, i, frsViewData) == null) && TbadkCoreApplication.isLogin() && frsViewData != null && (list = frsViewData.mWindowToast) != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                WindowToast windowToast = list.get(i2);
                if (windowToast != null && windowToast.toast_type.intValue() == i) {
                    if (!hi.isEmpty(windowToast.toast_link)) {
                        it4.v(context, "", ur5.a(windowToast.toast_link), true);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static void f(BaseFragment baseFragment, View view2, e57 e57Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, baseFragment, view2, e57Var) == null) && baseFragment != null && e57Var != null && view2 != null && baseFragment.getPageContext() != null && baseFragment.getPageContext().getOrignalPage() != null) {
            jf5.h().m(new gf5(baseFragment.getContext()));
            jf5.h().n(85, 0, ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (jf5.h().j()) {
                baseFragment.getPageContext().getOrignalPage().grantWindowPermission(new b(view2, baseFragment, e57Var), true);
            }
        }
    }

    public static void g(BaseFragment baseFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, baseFragment, view2) == null) && baseFragment != null && view2 != null && baseFragment.getPageContext() != null && baseFragment.getPageContext().getOrignalPage() != null) {
            jf5.h().m(new hf5(baseFragment.getContext()));
            jf5.h().n(85, 0, ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (jf5.h().j()) {
                baseFragment.getPageContext().getOrignalPage().grantWindowPermission(new c(view2), true);
            }
        }
    }

    public static void i(FrsViewData frsViewData, e57 e57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, frsViewData, e57Var) == null) {
            if (frsViewData != null && frsViewData.getForum() == null) {
                if (e57Var != null && frsViewData.getForum() != null && frsViewData.getForum().getYuleData() != null) {
                    if (frsViewData.getForum().getYuleData() != null && frsViewData.getForum().getYuleData().a()) {
                        TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                        e57Var.R1(frsViewData.getForum().getYuleData().b());
                        return;
                    }
                    e57Var.A0();
                }
            } else if (e57Var != null) {
                e57Var.A0();
            }
        }
    }
}
