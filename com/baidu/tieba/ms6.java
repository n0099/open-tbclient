package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsForumToolDialogView;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.AddBawuPopInfo;
import tbclient.PopInfo;
/* loaded from: classes5.dex */
public class ms6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ kl8 b;

        public a(AlertDialog alertDialog, kl8 kl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alertDialog, kl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
            this.b = kl8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_CANCEL);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.b.getForum() != null) {
                statisticItem.param("fid", this.b.getForum().getId());
                statisticItem.param("fname", this.b.getForum().getName());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;

        public b(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                au4 au4Var = this.a;
                if (au4Var != null) {
                    au4Var.dismiss();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ String d;

        public c(au4 au4Var, int i, FrsFragment frsFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au4Var, Integer.valueOf(i), frsFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au4Var;
            this.b = i;
            this.c = frsFragment;
            this.d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                au4 au4Var = this.a;
                if (au4Var != null) {
                    au4Var.dismiss();
                }
                int i = this.b;
                if (i == 1) {
                    UrlManager.getInstance().dealOneLink(this.c.getPageContext(), new String[]{TbConfig.BAWUTEAME_ADDRESS + "?fn=" + this.c.c() + "&fid=" + this.c.d()});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", this.c.d());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.c.getActivity(), "ForumDetailPage", hashMap)));
                } else if (i != 3 || TextUtils.isEmpty(this.d)) {
                } else {
                    UrlManager.getInstance().dealOneLink(this.c.getPageContext(), new String[]{this.d});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NavigationBarCoverTip c;

        public d(FrsFragment frsFragment, String str, NavigationBarCoverTip navigationBarCoverTip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, str, navigationBarCoverTip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
            this.b = str;
            this.c = navigationBarCoverTip;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                new StatisticItem("c13439").eventStat();
                FrsFragment frsFragment = this.a;
                if (frsFragment == null || TextUtils.isEmpty(frsFragment.d()) || TextUtils.isEmpty(this.b) || this.a.getActivity() == null) {
                    return;
                }
                NavigationBarCoverTip navigationBarCoverTip = this.c;
                if (navigationBarCoverTip != null) {
                    navigationBarCoverTip.e();
                }
                int i = bx4.k().l("key_bawu_task_toast", 0) == -1 ? 1 : 0;
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + this.a.d() + "&fn=" + this.b + "&noread=" + i});
            }
        }
    }

    public static boolean a(kl8 kl8Var, FrsFragment frsFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, kl8Var, frsFragment)) == null) {
            if (kl8Var != null && kl8Var.getUserData() != null && frsFragment != null) {
                int is_manager = kl8Var.getUserData().getIs_manager();
                boolean h = bx4.k().h("key_forum_tool_find_dialog_show", false);
                if (is_manager == 1 && !h) {
                    c(1, frsFragment.getString(R.string.obfuscated_res_0x7f0f06d9), String.valueOf((int) R.drawable.obfuscated_res_0x7f080f69), "", frsFragment);
                    bx4.k().u("key_forum_tool_find_dialog_show", true);
                    if (frsFragment != null) {
                        frsFragment.z4(true);
                    }
                    return true;
                } else if (!h && is_manager == 2) {
                    c(2, frsFragment.getString(R.string.obfuscated_res_0x7f0f06d8), String.valueOf((int) R.drawable.obfuscated_res_0x7f080f69), "", frsFragment);
                    bx4.k().u("key_forum_tool_find_dialog_show", true);
                    if (frsFragment != null) {
                        frsFragment.z4(true);
                    }
                    return true;
                } else {
                    AddBawuPopInfo addBawuPopInfo = kl8Var.bawuPopInfo;
                    if (addBawuPopInfo != null) {
                        c(3, addBawuPopInfo.content, addBawuPopInfo.img_url, addBawuPopInfo.jump_url, frsFragment);
                        if (frsFragment != null) {
                            frsFragment.z4(true);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void b(NavigationBarCoverTip navigationBarCoverTip, FrsFragment frsFragment, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, navigationBarCoverTip, frsFragment, str) == null) || navigationBarCoverTip == null || frsFragment == null || frsFragment.getActivity() == null) {
            return;
        }
        View inflate = View.inflate(frsFragment.getActivity(), R.layout.obfuscated_res_0x7f0d093c, null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0926c6);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f091e85);
        if (TextUtils.isEmpty(str)) {
            textView.setText("吧主您好，本吧考核新制度上线啦");
        } else {
            textView.setText(str + "吧吧主您好，本吧考核新制度上线啦");
        }
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03b8));
        by4 by4Var = new by4();
        by4Var.s();
        tBSpecificationBtn.setConfig(by4Var);
        tBSpecificationBtn.k();
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
        tBSpecificationBtn.setOnClickListener(new d(frsFragment, str, navigationBarCoverTip));
        navigationBarCoverTip.n(frsFragment.getActivity(), inflate, 30000);
        new StatisticItem("c13438").eventStat();
        int l = bx4.k().l("key_bawu_task_toast", 0);
        if (l >= 0) {
            bx4.k().w("key_bawu_task_toast", l + 1);
        }
    }

    public static void c(int i, String str, String str2, String str3, FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), str, str2, str3, frsFragment}) == null) || frsFragment == null) {
            return;
        }
        au4 au4Var = new au4(frsFragment.getActivity());
        au4Var.setContentViewSize(2);
        au4Var.setCanceledOnTouchOutside(false);
        FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(frsFragment.getActivity());
        frsForumToolDialogView.setStartLoadUrl(i, str2);
        frsForumToolDialogView.setContent(str);
        frsForumToolDialogView.setCancleButtonListener(new b(au4Var));
        frsForumToolDialogView.setConfirmButtonListener(new c(au4Var, i, frsFragment, str3));
        au4Var.setContentView(frsForumToolDialogView);
        au4Var.create(frsFragment.getPageContext()).show();
    }

    public static boolean d(kl8 kl8Var, FrsFragment frsFragment) {
        InterceptResult invokeLL;
        PopInfo popInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, kl8Var, frsFragment)) == null) {
            if (frsFragment == null || bx4.k().h(bx4.o("key_frs_shield_thread_dialog"), false) || kl8Var.getUserData() == null || kl8Var.getUserData().getIs_manager() <= 0 || (popInfo = kl8Var.frsMaskPopInfo) == null || popInfo.if_pop.intValue() != 1) {
                return false;
            }
            ImageView imageView = new ImageView(frsFragment.getActivity());
            imageView.setImageResource(SkinManager.getResourceId(R.drawable.pic_frs_popup_shield));
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0411, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(frsFragment.getActivity());
            tBAlertBuilder.u(kl8Var.frsMaskPopInfo.title);
            tBAlertBuilder.o(kl8Var.frsMaskPopInfo.v_title);
            tBAlertBuilder.m(true);
            tBAlertBuilder.i(imageView);
            tBAlertBuilder.r(aVar);
            tBAlertBuilder.h(false);
            aVar.a(new a(tBAlertBuilder.w(), kl8Var));
            bx4.k().u(bx4.o("key_frs_shield_thread_dialog"), true);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (kl8Var.getForum() != null) {
                statisticItem.param("fid", kl8Var.getForum().getId());
                statisticItem.param("fname", kl8Var.getForum().getName());
            }
            TiebaStatic.log(statisticItem);
            if (frsFragment != null) {
                frsFragment.z4(true);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
