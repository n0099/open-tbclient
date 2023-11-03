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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
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
import com.baidu.tieba.bp4;
import com.baidu.tieba.bu9;
import com.baidu.tieba.e5a;
import com.baidu.tieba.k6a;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.p6a;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.qd;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.zk9;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.ResourceConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
    public k6a k;
    public long l;
    public String m;
    public String n;
    public AntiHelper.k o;
    public CustomMessageListener p;
    public HttpMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView J1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class i implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPolymericFragment a;

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* loaded from: classes7.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.getPageContext().getPageActivity() != null) {
                    bu9.a(this.b.a.getPageContext(), this.a).show();
                }
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
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                SafeHandler.getInst().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.b.getActivity().getSystemService("input_method");
                BdUtilHelper.hideSoftKeyPad(this.b.getActivity(), this.a.getChatMsgView());
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public void onNavigationButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.b) {
                return;
            }
            this.a.i = true;
        }
    }

    /* loaded from: classes7.dex */
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
                if (statusCode == 200 && error == 0 && this.a.k != null) {
                    this.a.k.p(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !this.a.b) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (!TextUtils.isEmpty(str) && this.a.k != null) {
                    p6a p = this.a.k.p(true);
                    this.a.j = str;
                    if (p != null && (j = p.j()) != null) {
                        j.setName_show(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage.UpdateAttentionData data = ((UpdateAttentionMessage) customResponsedMessage).getData();
            if (data.blockData != null && AntiHelper.t(this.a.getActivity(), data.blockData, this.a.o) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPolymericFragment a;

        public g(PersonPolymericFragment personPolymericFragment) {
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

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.OnSchemeParsedCallback
        public void onCallBack(HashMap<String, Object> hashMap) {
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

    /* loaded from: classes7.dex */
    public class h implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
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

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.OnSchemeParsedCallback
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(BdUniDispatchSchemeController.PARAM_PORTRAIT) instanceof String)) {
                this.a.c = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_PORTRAIT);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                if (this.g.getActivity() != null) {
                    BdUtilHelper.hideSoftKeyPad(this.g.getActivity(), this.a.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.g.getActivity(), this.b, this.c, this.d, this.e, 0, this.a.getLeaveMsg(), this.f.toChatMessageContent())));
                }
                zz4Var.dismiss();
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.getStats() != null) {
                    Bundle stats = shareItem.getStats();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", stats.getInt("obj_type")).param("obj_param1", 3).param("fid", stats.getString("fid")).param("tid", stats.getString("tid")).param("obj_locate", 8));
                }
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
        this.l = 0L;
        this.o = new b(this);
        this.p = new c(this, 2921004);
        this.q = new d(this, CmdConfigHttp.GETPAYINFO_CMD);
        this.r = new e(this, 2921033);
        this.s = new f(this, 2001115);
    }

    public final ShareFromPBMsgData D2() {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            VoiceManager X0 = X0();
            this.e = X0;
            if (X0 != null) {
                X0.onPause();
            }
            if (this.l > 0) {
                TiebaStatic.log(new StatisticItem("c12263").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf((System.currentTimeMillis() - this.l) / 1000)).param("obj_type", 2));
                this.l = 0L;
            }
        }
    }

    public final void C2(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, intent) == null) && intent != null) {
            try {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                k6a k6aVar = this.k;
                if (k6aVar != null && !k6aVar.k(postWriteCallBackData)) {
                    this.k.y(postWriteCallBackData);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void E2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            J2(D2(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            super.onChangeSkinType(i2);
            k6a k6aVar = this.k;
            if (k6aVar != null) {
                k6aVar.s(i2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putLong("user_id", this.a);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.b);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.d);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.f);
            }
        }
    }

    public final void F2(Bundle bundle) {
        boolean z;
        Map<String, String> paramPair;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            Intent intent = getActivity().getIntent();
            boolean z2 = true;
            if (intent != null) {
                long j2 = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                this.a = j2;
                if (j2 == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    z = true;
                } else {
                    z = false;
                }
                this.b = z;
                if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
                    Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
                    String uri2 = uri.toString();
                    if (BdUniDispatchSchemeController.isUniScheme(uri)) {
                        BdUniDispatchSchemeController.getInstance().parseUserCenterScheme(uri, new g(this));
                        return;
                    } else if (!StringUtils.isNull(uri2) && (uri2.startsWith("tbusercenter://") || uri2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_USER_CENTER))) {
                        String decode = Uri.decode(uri.getEncodedPath());
                        if (StringUtils.isNull(decode)) {
                            return;
                        }
                        if (uri2.startsWith("tbusercenter://")) {
                            I2(decode);
                            Matcher matcher = Pattern.compile(".*fr=(.*)&portrait=([\\d]+).*").matcher(decode);
                            if (matcher.find()) {
                                this.c = matcher.group(2);
                                return;
                            }
                            int indexOf = decode.indexOf("portrait=");
                            if (indexOf < 0 || (i2 = indexOf + 9) > decode.length()) {
                                return;
                            }
                            String substring = decode.substring(i2);
                            this.c = substring;
                            if (!StringUtils.isNull(substring)) {
                                this.b = false;
                                return;
                            }
                            return;
                        } else if (uri2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_USER_CENTER)) {
                            if (decode.startsWith(ResourceConstants.CMT)) {
                                decode = decode.substring(2);
                            }
                            if (StringUtils.isNull(decode) || (paramPair = UrlManager.getParamPair(decode)) == null) {
                                return;
                            }
                            String str = paramPair.get("uid");
                            if (!StringUtils.isNull(str)) {
                                this.a = JavaTypesHelper.toLong(str, 0L);
                            } else {
                                this.a = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                            }
                            if (this.a != JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                z2 = false;
                            }
                            this.b = z2;
                            return;
                        } else {
                            return;
                        }
                    } else if (!StringUtils.isNull(uri2) && uri2.startsWith("tiebaapp://router/portal")) {
                        BdUniDispatchSchemeController.getInstance().parseUserCenterScheme2(uri, new h(this));
                        return;
                    } else {
                        return;
                    }
                }
                this.a = intent.getLongExtra("user_id", JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.b = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
                this.d = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
                this.f = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
                this.m = intent.getStringExtra("st_type");
                this.n = intent.getStringExtra("thread_id");
                intent.getStringExtra("nid");
            } else if (bundle != null) {
                this.a = bundle.getLong("user_id", JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.b = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
                this.d = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
                this.f = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
                this.m = bundle.getString("st_type");
                this.n = bundle.getString("thread_id");
                bundle.getString("nid");
            }
        }
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13576");
            statisticItem.param("obj_type", this.b ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.e == null) {
                this.e = VoiceManager.instance();
            }
            return this.e;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.e;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            this.e = null;
            k6a k6aVar = this.k;
            if (k6aVar != null) {
                k6aVar.t();
            }
            BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
            BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                this.k.u(isPrimary());
                PersonRedTipManager.getInstance().setIsPrimary(isPrimary());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStart();
            VoiceManager X0 = X0();
            this.e = X0;
            if (X0 != null) {
                X0.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onStop();
            VoiceManager X0 = X0();
            this.e = X0;
            if (X0 != null) {
                X0.onStop(getPageContext());
            }
        }
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || TextUtils.isEmpty(this.m)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13541");
        statisticItem.param("tid", this.n);
        statisticItem.param("uid", this.a);
        int i2 = 5;
        if (AddFriendActivityConfig.TYPE_PB_HEAD.equals(this.m)) {
            i2 = 1;
        } else if (AddFriendActivityConfig.TYPE_HOME_HEAD.equals(this.m)) {
            i2 = 2;
        } else if (AddFriendActivityConfig.TYPE_FRS_HEAD.equals(this.m)) {
            i2 = 3;
        } else if (AddFriendActivityConfig.TYPE_CONCERN_HEAD.equals(this.m)) {
            i2 = 4;
        }
        statisticItem.param("obj_source", i2);
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            VoiceManager X0 = X0();
            this.e = X0;
            if (X0 != null) {
                X0.onResume(getPageContext());
            }
            this.k.x();
            if (!this.b && this.d) {
                this.l = System.currentTimeMillis();
            } else {
                this.l = -1L;
            }
            if (this.k.n() != null) {
                if (!StringUtils.isNull(this.j)) {
                    this.k.n().f(this.j);
                    this.j = null;
                }
                if (this.i) {
                    this.k.n().e();
                    this.i = false;
                }
            }
        }
    }

    public final void I2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str.startsWith(ResourceConstants.CMT)) {
                str = str.substring(2);
            }
            Map<String, String> paramPair = UrlManager.getParamPair(str);
            if (paramPair != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
                bp4.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("tid", paramPair.get("tid"));
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 3);
                statisticItem.param("obj_id", paramPair.get(TiebaStatic.Params.BDID));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!qd.isEmpty(paramPair.get(BasicVideoParserKt.EXT_LOG))) {
                    try {
                        JSONObject jSONObject = new JSONObject(paramPair.get(BasicVideoParserKt.EXT_LOG));
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

    public final void J2(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{shareFromPBMsgData, Long.valueOf(j2), str, str2, str3}) != null) || shareFromPBMsgData == null) {
            return;
        }
        zz4 zz4Var = new zz4(getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        zz4Var.setContentViewSize(1);
        zz4Var.setContentView(thread2GroupShareView);
        zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f13c7, new j(this, thread2GroupShareView, j2, str, str2, str3, shareFromPBMsgData));
        zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d3, new a(this, thread2GroupShareView));
        zz4Var.setCanceledOnTouchOutside(true);
        zz4Var.create(getPageContext()).show();
        if (!qd.isEmpty(shareFromPBMsgData.getImageUrl())) {
            thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.k = new k6a(this, this.g, getUniqueId(), this.a, this.b, this.f, this.c);
            this.h = new ShareSuccessReplyToServerModel();
            e5a.d().k(System.currentTimeMillis() - e5a.d().a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            super.onAttach(activity);
            this.mIsLogin = TbadkCoreApplication.isLogin();
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.r);
            MessageManager.getInstance().registerListener(this.q);
            MessageManager.getInstance().registerListener(this.s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            e5a.d().i();
            e5a.d().j(currentTimeMillis);
            super.onCreate(bundle);
            VoiceManager X0 = X0();
            this.e = X0;
            if (X0 != null) {
                X0.onCreate(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        k6a k6aVar;
        k6a k6aVar2;
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        k6a k6aVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 101) {
                    if (i2 != 12002) {
                        if (i2 != 12014) {
                            if (i2 != 13003) {
                                if (i2 != 13011) {
                                    if (i2 != 23007) {
                                        if (i2 != 24001) {
                                            if (i2 != 24007) {
                                                if ((i2 != 12009 && i2 != 12010) || intent == null) {
                                                    return;
                                                }
                                                int intExtra = intent.getIntExtra("upload_image_type", 0);
                                                if (intExtra == 1) {
                                                    k6a k6aVar4 = this.k;
                                                    if (k6aVar4 != null) {
                                                        k6aVar4.n().b().M().q();
                                                        this.k.a();
                                                        return;
                                                    }
                                                    return;
                                                } else if (intExtra == 2 && (k6aVar3 = this.k) != null) {
                                                    k6aVar3.i();
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            int intExtra2 = intent.getIntExtra("extra_share_status", 2);
                                            int intExtra3 = intent.getIntExtra("extra_show_channel", 1);
                                            if (intExtra2 == 1) {
                                                RateManager.getInstance().notifyShare(getPageContext());
                                                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                                                statisticItem.param("obj_locate", 8);
                                                if (shareItem != null) {
                                                    statisticItem.param("tid", shareItem.tid);
                                                }
                                                statisticItem.param("pid", intent.getStringExtra("pid"));
                                                TiebaStatic.log(statisticItem);
                                                if (shareItem != null && (str = shareItem.linkUrl) != null && (shareSuccessReplyToServerModel = this.h) != null) {
                                                    shareSuccessReplyToServerModel.O(str, intExtra3, new i(this));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } else if (intent != null && (this.k.n() instanceof zk9)) {
                                            ((zk9) this.k.n()).resetData();
                                            ((zk9) this.k.n()).c();
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    E2(intent);
                                    return;
                                }
                                RateManager.getInstance().notifyShare(getPageContext());
                                return;
                            }
                            C2(intent);
                        } else if (intent == null) {
                        } else {
                            int intExtra4 = intent.getIntExtra("upload_image_type", 0);
                            if (intExtra4 == 1) {
                                k6a k6aVar5 = this.k;
                                if (k6aVar5 != null) {
                                    k6aVar5.n().b().M().q();
                                    this.k.a();
                                }
                            } else if (intExtra4 == 2 && (k6aVar2 = this.k) != null) {
                                k6aVar2.i();
                            }
                        }
                    } else if (intent != null && (k6aVar = this.k) != null) {
                        k6aVar.n().b().M().A(intent);
                    }
                } else if (this.k.n() instanceof zk9) {
                    ((zk9) this.k.n()).resetData();
                    ((zk9) this.k.n()).c();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            F2(bundle);
            H2();
            G2();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0345, (ViewGroup) null);
            if (this.a <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                this.a = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            this.g = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDetach();
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.q);
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }
}
