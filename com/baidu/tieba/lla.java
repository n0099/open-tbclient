package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lla {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final kka b;

    /* loaded from: classes6.dex */
    public class a implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lla a;

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.lla$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0382a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ a b;

            public RunnableC0382a(a aVar, CustomDialogData customDialogData) {
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
                    yk9.a(this.b.a.a.getPageContext(), this.a).show();
                }
            }
        }

        public a(lla llaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {llaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = llaVar;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                SafeHandler.getInst().postDelayed(new RunnableC0382a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ShareFromPBMsgData f;
        public final /* synthetic */ lla g;

        public b(lla llaVar, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {llaVar, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = llaVar;
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
                this.g.a.HidenSoftKeyPad((InputMethodManager) this.g.a.getSystemService("input_method"), this.a.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.g.a.getPageContext().getPageActivity(), this.b, this.c, this.d, this.e, 0, this.a.getLeaveMsg(), this.f.toChatMessageContent())));
                y45Var.dismiss();
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.getStats() != null) {
                    Bundle stats = shareItem.getStats();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", stats.getInt("obj_type")).param("obj_param1", 3).param("fid", stats.getString("fid")).param("tid", stats.getString("tid")).param("obj_locate", 5));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ lla b;

        public c(lla llaVar, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {llaVar, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = llaVar;
            this.a = thread2GroupShareView;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                this.b.a.HidenSoftKeyPad((InputMethodManager) this.b.a.getSystemService("input_method"), this.a.getChatMsgView());
                y45Var.dismiss();
            }
        }
    }

    public lla(MainTabActivity mainTabActivity, kka kkaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, kkaVar};
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
        this.b = kkaVar;
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
            kka kkaVar = this.b;
            if (kkaVar != null && !kkaVar.u(postWriteCallBackData)) {
                this.b.V(postWriteCallBackData);
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

    public void e(int i, int i2, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            if (i2 != -1) {
                if (i == 25059) {
                    i56.d();
                } else if (i == 25060) {
                    i56.d();
                }
            }
            if (VcodeTool.tryProcessActivityResultOnWriteScene(i, i2, intent)) {
                return;
            }
            if (i2 != -1) {
                kka kkaVar = this.b;
                if (kkaVar != null && kkaVar.A() != null && this.b.A().getCurrentFragment() != null) {
                    this.b.A().getCurrentFragment().onActivityResult(i, i2, intent);
                }
            } else if (i == 25046) {
                if (TbadkCoreApplication.isLogin()) {
                    bu4.f().k(this.a.getPageContext());
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
                    RateManager.getInstance().notifyShare(this.a.getPageContext());
                } else if (i == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra == 1) {
                        RateManager.getInstance().notifyShare(this.a.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        if (shareItem != null) {
                            int i3 = shareItem.objLocate;
                            if (i3 == 0) {
                                statisticItem.param("obj_locate", 15);
                            } else {
                                statisticItem.param("obj_locate", i3);
                            }
                        }
                        if (shareItem != null) {
                            statisticItem.param("tid", shareItem.tid);
                        }
                        statisticItem.param("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(statisticItem);
                        if (shareItem != null && (str = shareItem.linkUrl) != null && (shareSuccessReplyToServerModel = this.a.v) != null) {
                            shareSuccessReplyToServerModel.M(str, intExtra2, new a(this));
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
                    i56.d();
                } else if (i == 25060) {
                    if (UbsABTestHelper.isFirstLoginTestB()) {
                        if (!TbadkCoreApplication.isLogin()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921535, this));
                            return;
                        }
                        return;
                    }
                    i56.d();
                } else if (i == 25064) {
                    MainTabActivity mainTabActivity2 = this.a;
                    hza hzaVar = mainTabActivity2.r;
                    if (hzaVar != null) {
                        hzaVar.c(mainTabActivity2.getPageContext());
                    }
                } else if (i == 25071) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(LoginDialogActivityConfig.HOME_OPERATE_JUMP_URL);
                        if (!TextUtils.isEmpty(stringExtra)) {
                            BrowserHelper.startWebActivity((Context) this.a, (String) null, stringExtra, true);
                        }
                    }
                } else {
                    kka kkaVar2 = this.b;
                    if (kkaVar2 != null && kkaVar2.A() != null && this.b.A().getCurrentFragment() != null) {
                        this.b.A().getCurrentFragment().onActivityResult(i, i2, intent);
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
        y45 y45Var = new y45(this.a.getPageContext().getPageActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.a.getPageContext().getPageActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        y45Var.setContentViewSize(1);
        y45Var.setContentView(thread2GroupShareView);
        y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f13a0, new b(this, thread2GroupShareView, j, str, str2, str3, shareFromPBMsgData));
        y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new c(this, thread2GroupShareView));
        y45Var.setCanceledOnTouchOutside(true);
        y45Var.create(this.a.getPageContext()).show();
        if (!ei.isEmpty(shareFromPBMsgData.getImageUrl())) {
            thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
        }
    }
}
