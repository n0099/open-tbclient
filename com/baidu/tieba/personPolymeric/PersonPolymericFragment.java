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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.a.g;
import c.a.q0.a.w;
import c.a.q0.s.s.a;
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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PersonPolymericFragment extends BaseFragment implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f56019e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56020f;

    /* renamed from: g  reason: collision with root package name */
    public String f56021g;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public boolean f56022h;

    /* renamed from: i  reason: collision with root package name */
    public VoiceManager f56023i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f56024j;
    public View k;
    public ShareSuccessReplyToServerModel l;
    public boolean m;
    public String n;
    public String o;
    public c.a.r0.p2.d.g p;
    public long q;
    public String r;
    public String s;
    public AntiHelper.k t;
    public CustomMessageListener u;
    public HttpMessageListener v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;

    /* loaded from: classes7.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f56025e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericFragment f56026f;

        public a(PersonPolymericFragment personPolymericFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56026f = personPolymericFragment;
            this.f56025e = thread2GroupShareView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f56026f.getActivity().getSystemService("input_method");
                l.x(this.f56026f.getActivity(), this.f56025e.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericFragment f56027a;

        public b(PersonPolymericFragment personPolymericFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56027a = personPolymericFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericFragment f56028a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonPolymericFragment personPolymericFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56028a = personPolymericFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f56028a.f56020f) {
                this.f56028a.m = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericFragment f56029a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonPolymericFragment personPolymericFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56029a = personPolymericFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && this.f56029a.p != null) {
                    this.f56029a.p.p(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericFragment f56030a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonPolymericFragment personPolymericFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56030a = personPolymericFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserData j2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !this.f56030a.f56020f) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (TextUtils.isEmpty(str) || this.f56030a.p == null) {
                    return;
                }
                c.a.r0.p2.e.a p = this.f56030a.p.p(true);
                this.f56030a.n = str;
                if (p == null || (j2 = p.j()) == null) {
                    return;
                }
                j2.setName_show(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericFragment f56031a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonPolymericFragment personPolymericFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56031a = personPolymericFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !this.f56031a.f56020f) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                this.f56031a.o = (String) data;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericFragment f56032a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonPolymericFragment personPolymericFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56032a = personPolymericFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.l == null || AntiHelper.t(this.f56032a.getActivity(), data.l, this.f56032a.t) == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericFragment f56033a;

        public h(PersonPolymericFragment personPolymericFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56033a = personPolymericFragment;
        }

        @Override // c.a.q0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(c.a.q0.a.g.u) instanceof String)) {
                this.f56033a.f56021g = (String) hashMap.get(c.a.q0.a.g.u);
                if (StringUtils.isNull(this.f56033a.f56021g)) {
                    return;
                }
                this.f56033a.f56020f = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericFragment f56034a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f56035e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f56036f;

            public a(i iVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56036f = iVar;
                this.f56035e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56036f.f56034a.getPageContext().getPageActivity() == null) {
                    return;
                }
                c.a.r0.k2.j.c.a(this.f56036f.f56034a.getPageContext(), this.f56035e).show();
            }
        }

        public i(PersonPolymericFragment personPolymericFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56034a = personPolymericFragment;
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
                c.a.e.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f56037e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f56038f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f56039g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f56040h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f56041i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f56042j;
        public final /* synthetic */ PersonPolymericFragment k;

        public j(PersonPolymericFragment personPolymericFragment, Thread2GroupShareView thread2GroupShareView, long j2, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericFragment, thread2GroupShareView, Long.valueOf(j2), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = personPolymericFragment;
            this.f56037e = thread2GroupShareView;
            this.f56038f = j2;
            this.f56039g = str;
            this.f56040h = str2;
            this.f56041i = str3;
            this.f56042j = shareFromPBMsgData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.k.getActivity().getSystemService("input_method");
                l.x(this.k.getActivity(), this.f56037e.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.k.getActivity(), this.f56038f, this.f56039g, this.f56040h, this.f56041i, 0, this.f56037e.getLeaveMsg(), this.f56042j.toChatMessageContent())));
                aVar.dismiss();
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem == null || shareItem.e() == null) {
                    return;
                }
                Bundle e2 = shareItem.e();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", e2.getInt("obj_type")).param("obj_param1", 3).param("fid", e2.getString("fid")).param("tid", e2.getString("tid")).param("obj_locate", 8));
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
        this.f56020f = true;
        this.f56021g = "";
        this.f56022h = false;
        this.f56024j = false;
        this.m = false;
        this.q = 0L;
        this.t = new b(this);
        this.u = new c(this, 2921004);
        this.v = new d(this, CmdConfigHttp.GETPAYINFO_CMD);
        this.w = new e(this, 2921033);
        this.x = new f(this, 2921378);
        this.y = new g(this, 2001115);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f56023i == null) {
                this.f56023i = VoiceManager.instance();
            }
            return this.f56023i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void j(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        try {
            PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            c.a.r0.p2.d.g gVar = this.p;
            if (gVar == null || gVar.k(postWriteCallBackData)) {
                return;
            }
            this.p.w(postWriteCallBackData);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final ShareFromPBMsgData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            if (shareItem == null) {
                return null;
            }
            Uri uri = shareItem.v;
            String uri2 = uri == null ? "https://tb5.bdstatic.com/yunying/tieba_logo.jpg" : uri.toString();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setTitle(shareItem.r);
            shareFromPBMsgData.setContent(shareItem.D);
            shareFromPBMsgData.setImageUrl(uri2);
            shareFromPBMsgData.setForumName(shareItem.p);
            shareFromPBMsgData.setThreadId(shareItem.K);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeV.objValue;
    }

    public final void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            q(k(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    public final void m(Bundle bundle) {
        Map<String, String> paramPair;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            Intent intent = getActivity().getIntent();
            if (intent == null) {
                if (bundle != null) {
                    this.f56019e = bundle.getLong("user_id", c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.f56020f = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
                    this.f56022h = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
                    this.f56024j = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
                    this.r = bundle.getString("st_type");
                    this.s = bundle.getString("thread_id");
                    bundle.getString("nid");
                    return;
                }
                return;
            }
            long g2 = c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            this.f56019e = g2;
            this.f56020f = g2 == c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
                Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
                String uri2 = uri.toString();
                if (c.a.q0.a.g.c(uri)) {
                    c.a.q0.a.g.b().h(uri, new h(this));
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
                            p(decode);
                            Matcher matcher = Pattern.compile(".*fr=(.*)&portrait=([\\d]+).*").matcher(decode);
                            if (matcher.find()) {
                                this.f56021g = matcher.group(2);
                                return;
                            }
                            int indexOf = decode.indexOf("portrait=");
                            if (indexOf >= 0 && (i2 = indexOf + 9) <= decode.length()) {
                                String substring = decode.substring(i2);
                                this.f56021g = substring;
                                if (StringUtils.isNull(substring)) {
                                    return;
                                }
                                this.f56020f = false;
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
                                this.f56019e = c.a.e.e.m.b.g(str, 0L);
                            } else {
                                this.f56019e = c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                            }
                            this.f56020f = this.f56019e == c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
            this.f56019e = intent.getLongExtra("user_id", c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.f56020f = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.f56022h = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
            this.f56024j = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
            this.r = intent.getStringExtra("st_type");
            this.s = intent.getStringExtra("thread_id");
            intent.getStringExtra("nid");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13576");
            statisticItem.param("obj_type", this.f56020f ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || TextUtils.isEmpty(this.r)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13541");
        statisticItem.param("tid", this.s);
        statisticItem.param("uid", this.f56019e);
        int i2 = 5;
        if (AddFriendActivityConfig.TYPE_PB_HEAD.equals(this.r)) {
            i2 = 1;
        } else if (AddFriendActivityConfig.TYPE_HOME_HEAD.equals(this.r)) {
            i2 = 2;
        } else if (AddFriendActivityConfig.TYPE_FRS_HEAD.equals(this.r)) {
            i2 = 3;
        } else if (AddFriendActivityConfig.TYPE_CONCERN_HEAD.equals(this.r)) {
            i2 = 4;
        }
        statisticItem.param("obj_source", i2);
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.p = new c.a.r0.p2.d.g(this, this.k, getUniqueId(), this.f56019e, this.f56020f, this.f56024j, this.f56021g);
            this.l = new ShareSuccessReplyToServerModel();
            c.a.r0.p2.b.d().k(System.currentTimeMillis() - c.a.r0.p2.b.d().a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        c.a.r0.p2.d.g gVar;
        c.a.r0.p2.d.g gVar2;
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        c.a.r0.p2.d.g gVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 101) {
                    if (this.p.n() instanceof c.a.r0.z1.a) {
                        ((c.a.r0.z1.a) this.p.n()).f();
                        ((c.a.r0.z1.a) this.p.n()).loadData();
                    }
                } else if (i2 == 12002) {
                    if (intent == null || (gVar = this.p) == null) {
                        return;
                    }
                    gVar.n().a().L().A(intent);
                } else if (i2 == 12014) {
                    if (intent == null) {
                        return;
                    }
                    int intExtra = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra != 1) {
                        if (intExtra != 2 || (gVar2 = this.p) == null) {
                            return;
                        }
                        gVar2.j();
                        return;
                    }
                    c.a.r0.p2.d.g gVar4 = this.p;
                    if (gVar4 != null) {
                        gVar4.n().a().L().q();
                        this.p.g();
                    }
                } else if (i2 == 13003) {
                    j(intent);
                } else if (i2 == 13011) {
                    c.a.r0.y2.a.g().m(getPageContext());
                } else if (i2 == 23007) {
                    l(intent);
                } else if (i2 == 24001) {
                    if (intent != null && (this.p.n() instanceof c.a.r0.z1.a)) {
                        ((c.a.r0.z1.a) this.p.n()).f();
                        ((c.a.r0.z1.a) this.p.n()).loadData();
                    }
                } else if (i2 != 24007) {
                    if ((i2 == 12009 || i2 == 12010) && intent != null) {
                        int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra2 != 1) {
                            if (intExtra2 != 2 || (gVar3 = this.p) == null) {
                                return;
                            }
                            gVar3.j();
                            return;
                        }
                        c.a.r0.p2.d.g gVar5 = this.p;
                        if (gVar5 != null) {
                            gVar5.n().a().L().q();
                            this.p.g();
                        }
                    }
                } else {
                    int intExtra3 = intent.getIntExtra("extra_share_status", 2);
                    int intExtra4 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra3 == 1) {
                        c.a.r0.y2.a.g().m(getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        statisticItem.param("obj_locate", 8);
                        if (shareItem != null) {
                            statisticItem.param("tid", shareItem.K);
                        }
                        statisticItem.param("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(statisticItem);
                        if (shareItem == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.l) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.w(str, intExtra4, new i(this));
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, activity) == null) {
            super.onAttach(activity);
            this.mIsLogin = TbadkCoreApplication.isLogin();
            MessageManager.getInstance().registerListener(this.u);
            MessageManager.getInstance().registerListener(this.w);
            MessageManager.getInstance().registerListener(this.x);
            MessageManager.getInstance().registerListener(this.v);
            MessageManager.getInstance().registerListener(this.y);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.r0.p2.d.g gVar = this.p;
            if (gVar != null) {
                gVar.s(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.r0.p2.b.d().i();
            c.a.r0.p2.b.d().j(currentTimeMillis);
            super.onCreate(bundle);
            VoiceManager voiceManager = getVoiceManager();
            this.f56023i = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            m(bundle);
            o();
            n();
            View inflate = layoutInflater.inflate(R.layout.fragment_person_center_layout, (ViewGroup) null);
            if (this.f56019e <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                this.f56019e = c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            this.k = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.f56023i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            this.f56023i = null;
            c.a.r0.p2.d.g gVar = this.p;
            if (gVar != null) {
                gVar.t();
            }
            BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
            BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetach();
            MessageManager.getInstance().unRegisterListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.w);
            MessageManager.getInstance().unRegisterListener(this.x);
            MessageManager.getInstance().unRegisterListener(this.v);
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
            VoiceManager voiceManager = getVoiceManager();
            this.f56023i = voiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            if (this.q > 0) {
                TiebaStatic.log(new StatisticItem("c12263").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf((System.currentTimeMillis() - this.q) / 1000)).param("obj_type", 2));
                this.q = 0L;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                this.p.u(isPrimary());
                c.a.r0.a3.a.v().I(isPrimary());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            VoiceManager voiceManager = getVoiceManager();
            this.f56023i = voiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.p.v();
            if (!this.f56020f && this.f56022h) {
                this.q = System.currentTimeMillis();
            } else {
                this.q = -1L;
            }
            if (this.p.n() != null) {
                if (!StringUtils.isNull(this.n)) {
                    this.p.n().e(this.n);
                    this.n = null;
                }
                if (!StringUtils.isNull(this.o)) {
                    this.p.n().c(this.o);
                    this.o = null;
                }
                if (this.m) {
                    this.p.n().d();
                    this.m = false;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putLong("user_id", this.f56019e);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.f56020f);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.f56022h);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.f56024j);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.f56023i = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStop();
            VoiceManager voiceManager = getVoiceManager();
            this.f56023i = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (str.startsWith("//")) {
                str = str.substring(2);
            }
            Map<String, String> paramPair = UrlManager.getParamPair(str);
            if (paramPair != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
                w.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("tid", paramPair.get("tid"));
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 3);
                statisticItem.param("obj_id", paramPair.get(TiebaStatic.Params.BDID));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!k.isEmpty(paramPair.get("ext_log"))) {
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

    public final void q(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{shareFromPBMsgData, Long.valueOf(j2), str, str2, str3}) == null) || shareFromPBMsgData == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new j(this, thread2GroupShareView, j2, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(R.string.cancel, new a(this, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(getPageContext()).show();
        if (k.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.loadImageIcon(shareFromPBMsgData.getImageUrl(), false);
    }
}
