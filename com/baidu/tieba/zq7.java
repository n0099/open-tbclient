package com.baidu.tieba;

import android.content.DialogInterface;
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
/* loaded from: classes8.dex */
public class zq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                d65.s("frsShield");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ c3a b;

        public b(AlertDialog alertDialog, c3a c3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alertDialog, c3aVar};
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
            this.b = c3aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
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
    }

    /* loaded from: classes8.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;

        public c(g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g55 g55Var = this.a;
                if (g55Var != null) {
                    g55Var.dismiss();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ String d;

        public d(g55 g55Var, int i, FrsFragment frsFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g55Var, Integer.valueOf(i), frsFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g55Var;
            this.b = i;
            this.c = frsFragment;
            this.d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g55 g55Var = this.a;
                if (g55Var != null) {
                    g55Var.dismiss();
                }
                int i = this.b;
                if (i == 1) {
                    UrlManager.getInstance().dealOneLink(this.c.getPageContext(), new String[]{TbConfig.BAWUTEAME_ADDRESS + "?fn=" + this.c.v() + "&fid=" + this.c.w()});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", this.c.w());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.c.getActivity(), "ForumDetailPage", hashMap)));
                } else if (i == 3 && !TextUtils.isEmpty(this.d)) {
                    UrlManager.getInstance().dealOneLink(this.c.getPageContext(), new String[]{this.d});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                d65.s("frsForumManage");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NavigationBarCoverTip c;

        public f(FrsFragment frsFragment, String str, NavigationBarCoverTip navigationBarCoverTip) {
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
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                new StatisticItem("c13439").eventStat();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && !TextUtils.isEmpty(frsFragment.w()) && !TextUtils.isEmpty(this.b) && this.a.getActivity() != null) {
                    NavigationBarCoverTip navigationBarCoverTip = this.c;
                    if (navigationBarCoverTip != null) {
                        navigationBarCoverTip.e();
                    }
                    if (r95.p().q("key_bawu_task_toast", 0) == -1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + this.a.w() + "&fn=" + this.b + "&noread=" + i});
                }
            }
        }
    }

    public static boolean a(c3a c3aVar, FrsFragment frsFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, c3aVar, frsFragment)) == null) {
            if (c3aVar != null && c3aVar.getUserData() != null && frsFragment != null) {
                int is_manager = c3aVar.getUserData().getIs_manager();
                boolean l = r95.p().l("key_forum_tool_find_dialog_show", false);
                if (is_manager == 1 && !l) {
                    c(1, frsFragment.getString(R.string.obfuscated_res_0x7f0f07d9), String.valueOf((int) R.drawable.obfuscated_res_0x7f0811de), "", frsFragment);
                    r95.p().A("key_forum_tool_find_dialog_show", true);
                    if (frsFragment != null) {
                        frsFragment.P4(true);
                    }
                    return true;
                } else if (!l && is_manager == 2) {
                    c(2, frsFragment.getString(R.string.obfuscated_res_0x7f0f07d8), String.valueOf((int) R.drawable.obfuscated_res_0x7f0811de), "", frsFragment);
                    r95.p().A("key_forum_tool_find_dialog_show", true);
                    if (frsFragment != null) {
                        frsFragment.P4(true);
                    }
                    return true;
                } else {
                    AddBawuPopInfo addBawuPopInfo = c3aVar.bawuPopInfo;
                    if (addBawuPopInfo != null) {
                        c(3, addBawuPopInfo.content, addBawuPopInfo.img_url, addBawuPopInfo.jump_url, frsFragment);
                        if (frsFragment != null) {
                            frsFragment.P4(true);
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
        if ((interceptable == null || interceptable.invokeLLL(65537, null, navigationBarCoverTip, frsFragment, str) == null) && navigationBarCoverTip != null && frsFragment != null && frsFragment.getActivity() != null) {
            View inflate = View.inflate(frsFragment.getActivity(), R.layout.write_thread_share_guide, null);
            TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.share_icon);
            if (TextUtils.isEmpty(str)) {
                textView.setText("吧主您好，本吧考核新制度上线啦");
            } else {
                textView.setText(str + "吧吧主您好，本吧考核新制度上线啦");
            }
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
            qa5 qa5Var = new qa5();
            qa5Var.t();
            tBSpecificationBtn.setConfig(qa5Var);
            tBSpecificationBtn.k();
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
            tBSpecificationBtn.setOnClickListener(new f(frsFragment, str, navigationBarCoverTip));
            navigationBarCoverTip.m(frsFragment.getActivity(), inflate, 30000);
            new StatisticItem("c13438").eventStat();
            int q = r95.p().q("key_bawu_task_toast", 0);
            if (q >= 0) {
                r95.p().F("key_bawu_task_toast", q + 1);
            }
        }
    }

    public static void c(int i, String str, String str2, String str3, FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), str, str2, str3, frsFragment}) != null) || frsFragment == null) {
            return;
        }
        g55 g55Var = new g55(frsFragment.getActivity());
        g55Var.setContentViewSize(2);
        g55Var.setCanceledOnTouchOutside(false);
        FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(frsFragment.getActivity());
        frsForumToolDialogView.setStartLoadUrl(i, str2);
        frsForumToolDialogView.setContent(str);
        frsForumToolDialogView.setCancleButtonListener(new c(g55Var));
        frsForumToolDialogView.setConfirmButtonListener(new d(g55Var, i, frsFragment, str3));
        g55Var.setOnDismissListener(new e());
        g55Var.setContentView(frsForumToolDialogView);
        g55Var.create(frsFragment.getPageContext()).show();
        d65.m("frsForumManage");
    }

    public static boolean d(c3a c3aVar, FrsFragment frsFragment) {
        InterceptResult invokeLL;
        PopInfo popInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, c3aVar, frsFragment)) == null) {
            if (frsFragment == null || r95.p().l(r95.t("key_frs_shield_thread_dialog"), false) || c3aVar.getUserData() == null || c3aVar.getUserData().getIs_manager() <= 0 || (popInfo = c3aVar.frsMaskPopInfo) == null || popInfo.if_pop.intValue() != 1) {
                return false;
            }
            ImageView imageView = new ImageView(frsFragment.getActivity());
            imageView.setImageResource(SkinManager.getResourceId(R.drawable.pic_frs_popup_shield));
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0488, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(frsFragment.getActivity());
            tBAlertBuilder.x(c3aVar.frsMaskPopInfo.title);
            tBAlertBuilder.q(c3aVar.frsMaskPopInfo.v_title);
            tBAlertBuilder.o(true);
            tBAlertBuilder.k(imageView);
            tBAlertBuilder.u(aVar);
            tBAlertBuilder.j(false);
            AlertDialog z = tBAlertBuilder.z();
            z.setOnDismissListener(new a());
            aVar.a(new b(z, c3aVar));
            r95.p().A(r95.t("key_frs_shield_thread_dialog"), true);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (c3aVar.getForum() != null) {
                statisticItem.param("fid", c3aVar.getForum().getId());
                statisticItem.param("fname", c3aVar.getForum().getName());
            }
            TiebaStatic.log(statisticItem);
            if (frsFragment != null) {
                frsFragment.P4(true);
            }
            d65.m("frsShield");
            return true;
        }
        return invokeLL.booleanValue;
    }
}
