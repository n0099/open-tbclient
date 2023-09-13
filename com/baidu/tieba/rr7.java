package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.h5.FrsTabWebFragment;
import com.baidu.tieba.frs.h5.NewFrsTabWebFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class rr7 extends as7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ur7 h;
    public fk7 i;
    public final CustomMessageListener j;
    public final CustomMessageListener k;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rr7 rr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr7Var, Integer.valueOf(i)};
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
            this.a = rr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                return;
            }
            PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
            if (this.a.h != null) {
                this.a.h.j(postWriteCallBackData);
            }
            if (this.a.l(postWriteCallBackData)) {
                kg5.c(this.a.b.u(), postWriteCallBackData, 1);
            } else {
                this.a.e(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(rr7 rr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr7Var, Integer.valueOf(i)};
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
            this.a = rr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof hk7)) {
                this.a.i.D(((hk7) customResponsedMessage.getData()).a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ShareFromPBMsgData f;
        public final /* synthetic */ rr7 g;

        public c(rr7 rr7Var, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr7Var, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = rr7Var;
            this.a = thread2GroupShareView;
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = shareFromPBMsgData;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                FrsFragment frsFragment = this.g.b;
                if (frsFragment != null && frsFragment.getActivity() != null) {
                    BdUtilHelper.hideSoftKeyPad(this.g.b.getActivity(), this.a.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.g.b.getActivity(), this.b, this.c, this.d, this.e, 0, this.a.getLeaveMsg(), this.f.toChatMessageContent())));
                }
                y45Var.dismiss();
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.getStats() != null) {
                    Bundle stats = shareItem.getStats();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", stats.getInt("obj_type")).param("obj_param1", 3).param("fid", stats.getString("fid")).param("tid", stats.getString("tid")));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ rr7 b;

        public d(rr7 rr7Var, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr7Var, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rr7Var;
            this.a = thread2GroupShareView;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                BdUtilHelper.hideSoftKeyPad(this.b.b.getActivity(), this.a.getChatMsgView());
                y45Var.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rr7(FrsFragment frsFragment) {
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
        this.j = new a(this, 2001383);
        this.k = new b(this, 2921662);
        this.h = this.b.X3();
        this.j.setTag(this.b.getPageContext().getUniqueId());
        this.j.setSelfListener(true);
        this.b.registerListener(this.j);
        this.k.setTag(this.b.getUniqueId());
        this.k.setSelfListener(true);
        this.b.registerListener(this.k);
        this.i = new fk7(this.b);
    }

    public final boolean e(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ei.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.b.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            p(g(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    public final boolean l(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void i(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, intent) == null) && i == 18003) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public static void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            StatisticItem statisticItem = new StatisticItem("c11959");
            statisticItem.param("tid", str);
            statisticItem.param("fid", str2);
            statisticItem.param("obj_type", 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.h == null) {
            this.h = this.b.X3();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            fk7 fk7Var = this.i;
            if (fk7Var != null) {
                fk7Var.t();
            }
        }
    }

    public final ShareFromPBMsgData g() {
        InterceptResult invokeV;
        String uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            if (shareItem == null) {
                return null;
            }
            Uri uri2 = shareItem.imageUri;
            if (uri2 == null) {
                uri = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
            } else {
                uri = uri2.toString();
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setTitle(shareItem.title);
            shareFromPBMsgData.setContent(shareItem.shareAbstract);
            shareFromPBMsgData.setImageUrl(uri);
            shareFromPBMsgData.setForumName(shareItem.fName);
            shareFromPBMsgData.setThreadId(shareItem.tid);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeV.objValue;
    }

    public final void h(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<cn> e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048579, this, frsViewData, intent, str) != null) || frsViewData == null || intent == null || TextUtils.isEmpty(str) || this.e == null) {
            return;
        }
        int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        if (this.e.K0()) {
            Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
            if ((serializableExtra instanceof CardHListViewData) && (e = this.g.e()) != null) {
                CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                cardHListViewData.threadId = str;
                if (qt7.a(e, str, cardHListViewData, intExtra)) {
                    frsViewData.setThreadList(e);
                    this.a.M1(e, frsViewData);
                    q(str, this.b.w());
                }
            }
        }
    }

    public final void j(int i, Intent intent) {
        ShareItem shareItem;
        fx7 fx7Var;
        bx7 c0;
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, intent) == null) {
            FrsViewData m1 = this.b.m1();
            if (i != 11002) {
                if (i != 11014) {
                    if (i != 11016) {
                        if (i != 11036) {
                            if (i != 23007) {
                                if (i != 24002) {
                                    if (i != 24007) {
                                        if (i != 25050) {
                                            if (i != 25052) {
                                                if (i != 25054) {
                                                    if (i != 11011) {
                                                        if (i != 11012) {
                                                            if (i != 18003) {
                                                                if (i == 18004) {
                                                                    uw7.e(this.b.getPageContext(), m1);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                                                            this.a.a0().notifyDataSetChanged();
                                                            fx7 fx7Var2 = this.d;
                                                            if (fx7Var2 != null) {
                                                                fx7Var2.u0();
                                                            }
                                                            int intExtra = intent.getIntExtra("type", -1);
                                                            if (intExtra == 4) {
                                                                this.b.R4(6);
                                                                return;
                                                            }
                                                            String stringExtra = intent.getStringExtra("tid");
                                                            if (stringExtra != null && (threadDataById = m1.getThreadDataById(stringExtra)) != null) {
                                                                if (intExtra == 2) {
                                                                    threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                                                                    threadDataById.parser_title();
                                                                }
                                                                h(m1, intent, stringExtra);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        FrsFragment frsFragment = this.b;
                                                        uw7.h(frsFragment, frsFragment.o4(), FrsFragment.t2, this.b.x4());
                                                        return;
                                                    }
                                                    FrsFragment frsFragment2 = this.b;
                                                    uw7.g(frsFragment2, frsFragment2.o4(), FrsFragment.t2, this.b.x4());
                                                    return;
                                                }
                                                li7 N1 = this.b.N1();
                                                if (N1 != null && (c0 = N1.c0()) != null) {
                                                    c0.B();
                                                    return;
                                                }
                                                return;
                                            }
                                            String stringExtra2 = intent.getStringExtra("group_name");
                                            boolean booleanExtra = intent.getBooleanExtra("from", true);
                                            this.b.K5(stringExtra2);
                                            if (!booleanExtra && (fx7Var = this.d) != null) {
                                                fx7Var.m0();
                                                return;
                                            }
                                            return;
                                        }
                                        this.b.refresh();
                                        return;
                                    }
                                    int intExtra2 = intent.getIntExtra("extra_share_status", 2);
                                    if (intExtra2 == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null) {
                                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                                        statisticItem.param("obj_locate", 4);
                                        statisticItem.param("tid", shareItem.tid);
                                        statisticItem.param("pid", intent.getStringExtra("pid"));
                                        TiebaStatic.log(statisticItem);
                                    }
                                    if (intExtra2 == 1) {
                                        this.b.N4(intent.getStringExtra("tid"));
                                        return;
                                    }
                                    return;
                                } else if (intent == null) {
                                    return;
                                } else {
                                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                                    int intExtra6 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                                    if (intExtra3 == JavaTypesHelper.toInt(this.b.w(), 0)) {
                                        this.d.U0(intExtra4, intExtra5, intExtra6);
                                        return;
                                    }
                                    return;
                                }
                            }
                            k(intent);
                            return;
                        }
                        this.d.S0();
                        return;
                    }
                    this.a.Y1();
                    return;
                }
                this.d.Q0();
                return;
            }
            this.d.P0(true);
        }
    }

    public void m(int i) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (frsFragment = this.b) != null && frsFragment.m4() != null) {
            if (i > 0) {
                FrsTabViewController.i I = this.b.m4().I(i);
                if (I != null) {
                    Fragment fragment = I.b;
                    if ((fragment instanceof FrsCommonTabFragment) || (fragment instanceof FrsTabWebFragment) || (fragment instanceof NewFrsTabWebFragment)) {
                        this.c.b(i);
                        return;
                    }
                    return;
                }
                return;
            }
            int E = this.b.m4().E();
            if (this.b.m4().I(E) != null) {
                this.c.b(E);
            }
        }
    }

    public void n(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, intent) == null) {
            f();
            if (VcodeTool.tryProcessActivityResultOnWriteScene(i, i2, intent)) {
                return;
            }
            if (i2 == -1) {
                j(i, intent);
            } else if (i2 == 0) {
                i(i, intent);
            }
            fk7 fk7Var = this.i;
            if (fk7Var != null && fk7Var.v() != null) {
                this.i.v().a(i, i2, intent);
            }
        }
    }

    public final void p(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{shareFromPBMsgData, Long.valueOf(j), str, str2, str3}) != null) || shareFromPBMsgData == null) {
            return;
        }
        y45 y45Var = new y45(this.b.getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.b.getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        y45Var.setContentViewSize(1);
        y45Var.setContentView(thread2GroupShareView);
        y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f13a0, new c(this, thread2GroupShareView, j, str, str2, str3, shareFromPBMsgData));
        y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new d(this, thread2GroupShareView));
        y45Var.setCanceledOnTouchOutside(true);
        y45Var.create(this.b.getPageContext()).show();
        if (!ei.isEmpty(shareFromPBMsgData.getImageUrl())) {
            thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
        }
    }
}
