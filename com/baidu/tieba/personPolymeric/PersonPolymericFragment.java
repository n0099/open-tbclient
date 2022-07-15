package com.baidu.tieba.personPolymeric;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.e48;
import com.repackage.ej4;
import com.repackage.ng;
import com.repackage.oi;
import com.repackage.os7;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.t28;
import com.repackage.v88;
import com.repackage.z38;
import com.repackage.zk7;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonPolymericFragment extends BaseFragment implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public boolean b;
    public String c;
    @Deprecated
    public boolean d;
    public VoiceManager e;
    public boolean f;
    public View g;
    public ShareSuccessReplyToServerModel h;
    public boolean i;
    public String j;
    public String k;
    public z38 l;
    public long m;
    public String n;
    public String o;
    public AntiHelper.k p;
    public CustomMessageListener q;
    public HttpMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public CustomMessageListener u;

    /* loaded from: classes3.dex */
    public class a implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ PersonPolymericFragment b;

        public a(PersonPolymericFragment personPolymericFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personPolymericFragment;
            this.a = thread2GroupShareView;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.b.getActivity().getSystemService("input_method");
                pi.x(this.b.getActivity(), this.a.getChatMsgView());
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPolymericFragment a;

        public b(PersonPolymericFragment personPolymericFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personPolymericFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPolymericFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonPolymericFragment personPolymericFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, Integer.valueOf(i)};
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
            this.a = personPolymericFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.b) {
                this.a.i = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPolymericFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonPolymericFragment personPolymericFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, Integer.valueOf(i)};
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
            this.a = personPolymericFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && this.a.l != null) {
                    this.a.l.q(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPolymericFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonPolymericFragment personPolymericFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, Integer.valueOf(i)};
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
            this.a = personPolymericFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserData j;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !this.a.b) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (TextUtils.isEmpty(str) || this.a.l == null) {
                    return;
                }
                e48 q = this.a.l.q(true);
                this.a.j = str;
                if (q == null || (j = q.j()) == null) {
                    return;
                }
                j.setName_show(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPolymericFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonPolymericFragment personPolymericFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, Integer.valueOf(i)};
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
            this.a = personPolymericFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !this.a.b) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                this.a.k = (String) data;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPolymericFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonPolymericFragment personPolymericFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, Integer.valueOf(i)};
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
            this.a = personPolymericFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.l == null || AntiHelper.t(this.a.getActivity(), data.l, this.a.p) == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPolymericFragment a;

        public h(PersonPolymericFragment personPolymericFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personPolymericFragment;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(BdUniDispatchSchemeController.PARAM_PORTRAIT) instanceof String)) {
                this.a.c = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_PORTRAIT);
                if (StringUtils.isNull(this.a.c)) {
                    return;
                }
                this.a.b = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPolymericFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ i b;

            public a(i iVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.getPageContext().getPageActivity() == null) {
                    return;
                }
                os7.a(this.b.a.getPageContext(), this.a).show();
            }
        }

        public i(PersonPolymericFragment personPolymericFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personPolymericFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                qg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ShareFromPBMsgData f;
        public final /* synthetic */ PersonPolymericFragment g;

        public j(PersonPolymericFragment personPolymericFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = personPolymericFragment;
            this.a = thread2GroupShareView;
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = shareFromPBMsgData;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.g.getActivity().getSystemService("input_method");
                pi.x(this.g.getActivity(), this.a.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.g.getActivity(), this.b, this.c, this.d, this.e, 0, this.a.getLeaveMsg(), this.f.toChatMessageContent())));
                cr4Var.dismiss();
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem == null || shareItem.e() == null) {
                    return;
                }
                Bundle e = shareItem.e();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", e.getInt("obj_type")).param("obj_param1", 3).param("fid", e.getString("fid")).param("tid", e.getString("tid")).param("obj_locate", 8));
            }
        }
    }

    public PersonPolymericFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = "";
        this.d = false;
        this.f = false;
        this.i = false;
        this.m = 0L;
        this.p = new b(this);
        this.q = new c(this, 2921004);
        this.r = new d(this, CmdConfigHttp.GETPAYINFO_CMD);
        this.s = new e(this, 2921033);
        this.t = new f(this, 2921378);
        this.u = new g(this, 2001115);
    }

    public final void C1(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        try {
            PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            z38 z38Var = this.l;
            if (z38Var == null || z38Var.l(postWriteCallBackData)) {
                return;
            }
            this.l.x(postWriteCallBackData);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final ShareFromPBMsgData D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            if (shareItem == null) {
                return null;
            }
            Uri uri = shareItem.y;
            String uri2 = uri == null ? "https://tb5.bdstatic.com/yunying/tieba_logo.jpg" : uri.toString();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setTitle(shareItem.u);
            shareFromPBMsgData.setContent(shareItem.G);
            shareFromPBMsgData.setImageUrl(uri2);
            shareFromPBMsgData.setForumName(shareItem.s);
            shareFromPBMsgData.setThreadId(shareItem.N);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeV.objValue;
    }

    public final void E1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            J1(D1(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    public final void F1(Bundle bundle) {
        Map<String, String> paramPair;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            Intent intent = getActivity().getIntent();
            if (intent == null) {
                if (bundle != null) {
                    this.a = bundle.getLong("user_id", ng.g(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.b = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
                    this.d = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
                    this.f = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
                    this.n = bundle.getString("st_type");
                    this.o = bundle.getString("thread_id");
                    bundle.getString("nid");
                    return;
                }
                return;
            }
            long g2 = ng.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            this.a = g2;
            this.b = g2 == ng.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
                Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
                String uri2 = uri.toString();
                if (BdUniDispatchSchemeController.isUniScheme(uri)) {
                    BdUniDispatchSchemeController.getInstance().parseUserCenterScheme(uri, new h(this));
                    return;
                } else if (StringUtils.isNull(uri2)) {
                    return;
                } else {
                    if (uri2.startsWith("tbusercenter://") || uri2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_USER_CENTER)) {
                        String decode = Uri.decode(uri.getEncodedPath());
                        if (StringUtils.isNull(decode)) {
                            return;
                        }
                        if (uri2.startsWith("tbusercenter://")) {
                            I1(decode);
                            Matcher matcher = Pattern.compile(".*fr=(.*)&portrait=([\\d]+).*").matcher(decode);
                            if (matcher.find()) {
                                this.c = matcher.group(2);
                                return;
                            }
                            int indexOf = decode.indexOf("portrait=");
                            if (indexOf >= 0 && (i2 = indexOf + 9) <= decode.length()) {
                                String substring = decode.substring(i2);
                                this.c = substring;
                                if (StringUtils.isNull(substring)) {
                                    return;
                                }
                                this.b = false;
                                return;
                            }
                            return;
                        } else if (uri2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_USER_CENTER)) {
                            if (decode.startsWith("//")) {
                                decode = decode.substring(2);
                            }
                            if (StringUtils.isNull(decode) || (paramPair = UrlManager.getParamPair(decode)) == null) {
                                return;
                            }
                            String str = paramPair.get("uid");
                            if (!StringUtils.isNull(str)) {
                                this.a = ng.g(str, 0L);
                            } else {
                                this.a = ng.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                            }
                            this.b = this.a == ng.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
            this.a = intent.getLongExtra("user_id", ng.g(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.b = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.d = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
            this.f = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
            this.n = intent.getStringExtra("st_type");
            this.o = intent.getStringExtra("thread_id");
            intent.getStringExtra("nid");
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13576");
            statisticItem.param("obj_type", this.b ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || TextUtils.isEmpty(this.n)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13541");
        statisticItem.param("tid", this.o);
        statisticItem.param("uid", this.a);
        int i2 = 5;
        if (AddFriendActivityConfig.TYPE_PB_HEAD.equals(this.n)) {
            i2 = 1;
        } else if (AddFriendActivityConfig.TYPE_HOME_HEAD.equals(this.n)) {
            i2 = 2;
        } else if (AddFriendActivityConfig.TYPE_FRS_HEAD.equals(this.n)) {
            i2 = 3;
        } else if (AddFriendActivityConfig.TYPE_CONCERN_HEAD.equals(this.n)) {
            i2 = 4;
        }
        statisticItem.param("obj_source", i2);
        TiebaStatic.log(statisticItem);
    }

    public final void I1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str.startsWith("//")) {
                str = str.substring(2);
            }
            Map<String, String> paramPair = UrlManager.getParamPair(str);
            if (paramPair != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
                ej4.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("tid", paramPair.get("tid"));
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 3);
                statisticItem.param("obj_id", paramPair.get(TiebaStatic.Params.BDID));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!oi.isEmpty(paramPair.get("ext_log"))) {
                    try {
                        JSONObject jSONObject = new JSONObject(paramPair.get("ext_log"));
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            statisticItem.param(next, jSONObject.getString(next));
                        }
                    } catch (JSONException e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public final void J1(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{shareFromPBMsgData, Long.valueOf(j2), str, str2, str3}) == null) || shareFromPBMsgData == null) {
            return;
        }
        cr4 cr4Var = new cr4(getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        cr4Var.setContentViewSize(1);
        cr4Var.setContentView(thread2GroupShareView);
        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f113c, new j(this, thread2GroupShareView, j2, str, str2, str3, shareFromPBMsgData));
        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new a(this, thread2GroupShareView));
        cr4Var.setCanceledOnTouchOutside(true);
        cr4Var.create(getPageContext()).show();
        if (oi.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.l = new z38(this, this.g, getUniqueId(), this.a, this.b, this.f, this.c);
            this.h = new ShareSuccessReplyToServerModel();
            t28.d().k(System.currentTimeMillis() - t28.d().a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        z38 z38Var;
        z38 z38Var2;
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        z38 z38Var3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 101) {
                    if (this.l.o() instanceof zk7) {
                        ((zk7) this.l.o()).h();
                        ((zk7) this.l.o()).a();
                    }
                } else if (i2 == 12002) {
                    if (intent == null || (z38Var = this.l) == null) {
                        return;
                    }
                    z38Var.o().c().L().A(intent);
                } else if (i2 == 12014) {
                    if (intent == null) {
                        return;
                    }
                    int intExtra = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra != 1) {
                        if (intExtra != 2 || (z38Var2 = this.l) == null) {
                            return;
                        }
                        z38Var2.k();
                        return;
                    }
                    z38 z38Var4 = this.l;
                    if (z38Var4 != null) {
                        z38Var4.o().c().L().q();
                        this.l.b();
                    }
                } else if (i2 == 13003) {
                    C1(intent);
                } else if (i2 == 13011) {
                    v88.g().m(getPageContext());
                } else if (i2 == 23007) {
                    E1(intent);
                } else if (i2 == 24001) {
                    if (intent != null && (this.l.o() instanceof zk7)) {
                        ((zk7) this.l.o()).h();
                        ((zk7) this.l.o()).a();
                    }
                } else if (i2 != 24007) {
                    if ((i2 == 12009 || i2 == 12010) && intent != null) {
                        int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra2 != 1) {
                            if (intExtra2 != 2 || (z38Var3 = this.l) == null) {
                                return;
                            }
                            z38Var3.k();
                            return;
                        }
                        z38 z38Var5 = this.l;
                        if (z38Var5 != null) {
                            z38Var5.o().c().L().q();
                            this.l.b();
                        }
                    }
                } else {
                    int intExtra3 = intent.getIntExtra("extra_share_status", 2);
                    int intExtra4 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra3 == 1) {
                        v88.g().m(getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        statisticItem.param("obj_locate", 8);
                        if (shareItem != null) {
                            statisticItem.param("tid", shareItem.N);
                        }
                        statisticItem.param("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(statisticItem);
                        if (shareItem == null || (str = shareItem.w) == null || (shareSuccessReplyToServerModel = this.h) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.A(str, intExtra4, new i(this));
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activity) == null) {
            super.onAttach(activity);
            this.mIsLogin = TbadkCoreApplication.isLogin();
            MessageManager.getInstance().registerListener(this.q);
            MessageManager.getInstance().registerListener(this.s);
            MessageManager.getInstance().registerListener(this.t);
            MessageManager.getInstance().registerListener(this.r);
            MessageManager.getInstance().registerListener(this.u);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.onChangeSkinType(i2);
            z38 z38Var = this.l;
            if (z38Var != null) {
                z38Var.t(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            t28.d().i();
            t28.d().j(currentTimeMillis);
            super.onCreate(bundle);
            VoiceManager u0 = u0();
            this.e = u0;
            if (u0 != null) {
                u0.onCreate(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            F1(bundle);
            H1();
            G1();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02d8, (ViewGroup) null);
            if (this.a <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                this.a = ng.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            this.g = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.e;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            this.e = null;
            z38 z38Var = this.l;
            if (z38Var != null) {
                z38Var.u();
            }
            BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
            BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDetach();
            MessageManager.getInstance().unRegisterListener(this.q);
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            VoiceManager u0 = u0();
            this.e = u0;
            if (u0 != null) {
                u0.onPause(getPageContext());
            }
            if (this.m > 0) {
                TiebaStatic.log(new StatisticItem("c12263").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf((System.currentTimeMillis() - this.m) / 1000)).param("obj_type", 2));
                this.m = 0L;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                this.l.v(isPrimary());
                PersonRedTipManager.getInstance().setIsPrimary(isPrimary());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            VoiceManager u0 = u0();
            this.e = u0;
            if (u0 != null) {
                u0.onResume(getPageContext());
            }
            this.l.w();
            if (!this.b && this.d) {
                this.m = System.currentTimeMillis();
            } else {
                this.m = -1L;
            }
            if (this.l.o() != null) {
                if (!StringUtils.isNull(this.j)) {
                    this.l.o().g(this.j);
                    this.j = null;
                }
                if (!StringUtils.isNull(this.k)) {
                    this.l.o().e(this.k);
                    this.k = null;
                }
                if (this.i) {
                    this.l.o().f();
                    this.i = false;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putLong("user_id", this.a);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.b);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.d);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.f);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStart();
            VoiceManager u0 = u0();
            this.e = u0;
            if (u0 != null) {
                u0.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
            VoiceManager u0 = u0();
            this.e = u0;
            if (u0 != null) {
                u0.onStop(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.e == null) {
                this.e = VoiceManager.instance();
            }
            return this.e;
        }
        return (VoiceManager) invokeV.objValue;
    }
}
