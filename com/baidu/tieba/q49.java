package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.j05;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final v39 b;

    /* loaded from: classes5.dex */
    public class a implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q49 a;

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.q49$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0403a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ a b;

            public RunnableC0403a(a aVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    xa8.a(this.b.a.a.getPageContext(), this.a).show();
                }
            }
        }

        public a(q49 q49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q49Var;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                gh.a().postDelayed(new RunnableC0403a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ShareFromPBMsgData f;
        public final /* synthetic */ q49 g;

        public b(q49 q49Var, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q49Var, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = q49Var;
            this.a = thread2GroupShareView;
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = shareFromPBMsgData;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                this.g.a.HidenSoftKeyPad((InputMethodManager) this.g.a.getSystemService("input_method"), this.a.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.g.a.getPageContext().getPageActivity(), this.b, this.c, this.d, this.e, 0, this.a.getLeaveMsg(), this.f.toChatMessageContent())));
                j05Var.dismiss();
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.f() != null) {
                    Bundle f = shareItem.f();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", f.getInt("obj_type")).param("obj_param1", 3).param("fid", f.getString("fid")).param("tid", f.getString("tid")).param("obj_locate", 5));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ q49 b;

        public c(q49 q49Var, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q49Var, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q49Var;
            this.a = thread2GroupShareView;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                this.b.a.HidenSoftKeyPad((InputMethodManager) this.b.a.getSystemService("input_method"), this.a.getChatMsgView());
                j05Var.dismiss();
            }
        }
    }

    public q49(MainTabActivity mainTabActivity, v39 v39Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, v39Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = v39Var;
    }

    public final void d(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            f(c(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    public final void b(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, intent) == null) && intent != null) {
            PostWriteCallBackData postWriteCallBackData = null;
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921030, postWriteCallBackData));
            v39 v39Var = this.b;
            if (v39Var != null && !v39Var.t(postWriteCallBackData)) {
                this.b.Q(postWriteCallBackData);
            }
        }
    }

    public final ShareFromPBMsgData c() {
        InterceptResult invokeV;
        String uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            if (shareItem == null) {
                return null;
            }
            Uri uri2 = shareItem.z;
            if (uri2 == null) {
                uri = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
            } else {
                uri = uri2.toString();
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setTitle(shareItem.v);
            shareFromPBMsgData.setContent(shareItem.H);
            shareFromPBMsgData.setImageUrl(uri);
            shareFromPBMsgData.setForumName(shareItem.t);
            shareFromPBMsgData.setThreadId(shareItem.O);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeV.objValue;
    }

    public void e(int i, int i2, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            if (i2 != -1) {
                if (i == 25059) {
                    gw5.d();
                } else if (i == 25060) {
                    gw5.d();
                }
            }
            if (fq5.c(i, i2, intent)) {
                return;
            }
            if (i2 != -1) {
                v39 v39Var = this.b;
                if (v39Var != null && v39Var.y() != null && this.b.y().getCurrentFragment() != null) {
                    this.b.y().getCurrentFragment().onActivityResult(i, i2, intent);
                }
            } else if (i == 25046) {
                if (TbadkCoreApplication.isLogin()) {
                    pr4.f().k(this.a.getPageContext());
                }
            } else if (i == 25066) {
                MainTabActivity mainTabActivity = this.a;
                mainTabActivity.c = true;
                mainTabActivity.b = mainTabActivity.getCurrentTabType();
                TbSingleton.getInstance().setVideoChannelRelogin(true);
            } else if (i != 13003 && i != 25048) {
                if (i == 23007) {
                    d(intent);
                } else if (i == 13011) {
                    pq8.g().m(this.a.getPageContext());
                } else if (i == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra == 1) {
                        pq8.g().m(this.a.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        if (shareItem != null) {
                            int i3 = shareItem.M;
                            if (i3 == 0) {
                                statisticItem.param("obj_locate", 15);
                            } else {
                                statisticItem.param("obj_locate", i3);
                            }
                        }
                        if (shareItem != null) {
                            statisticItem.param("tid", shareItem.O);
                        }
                        statisticItem.param("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(statisticItem);
                        if (shareItem != null && (str = shareItem.x) != null && (shareSuccessReplyToServerModel = this.a.u) != null) {
                            shareSuccessReplyToServerModel.G(str, intExtra2, new a(this));
                        }
                    }
                } else if (i == 25059) {
                    if (UbsABTestHelper.isFirstLoginTestA()) {
                        if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkCoreApplication.isLogin()) {
                            InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(this.a, 4);
                            interestGuideActivityConfig.setRequestCode(25060);
                            interestGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
                            return;
                        }
                        return;
                    }
                    gw5.d();
                } else if (i == 25060) {
                    if (UbsABTestHelper.isFirstLoginTestB()) {
                        if (!TbadkCoreApplication.isLogin()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921535, this));
                            return;
                        }
                        return;
                    }
                    gw5.d();
                } else if (i == 25064) {
                    MainTabActivity mainTabActivity2 = this.a;
                    ig9 ig9Var = mainTabActivity2.q;
                    if (ig9Var != null) {
                        ig9Var.c(mainTabActivity2.getPageContext());
                    }
                } else if (i == 25071) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(LoginDialogActivityConfig.HOME_OPERATE_JUMP_URL);
                        if (!TextUtils.isEmpty(stringExtra)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a, null, stringExtra, true)));
                        }
                    }
                } else {
                    v39 v39Var2 = this.b;
                    if (v39Var2 != null && v39Var2.y() != null && this.b.y().getCurrentFragment() != null) {
                        this.b.y().getCurrentFragment().onActivityResult(i, i2, intent);
                    }
                }
            } else {
                b(intent);
            }
        }
    }

    public final void f(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{shareFromPBMsgData, Long.valueOf(j), str, str2, str3}) != null) || shareFromPBMsgData == null) {
            return;
        }
        j05 j05Var = new j05(this.a.getPageContext().getPageActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.a.getPageContext().getPageActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        j05Var.setContentViewSize(1);
        j05Var.setContentView(thread2GroupShareView);
        j05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f11e9, new b(this, thread2GroupShareView, j, str, str2, str3, shareFromPBMsgData));
        j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new c(this, thread2GroupShareView));
        j05Var.setCanceledOnTouchOutside(true);
        j05Var.create(this.a.getPageContext()).show();
        if (!dj.isEmpty(shareFromPBMsgData.getImageUrl())) {
            thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
        }
    }
}
