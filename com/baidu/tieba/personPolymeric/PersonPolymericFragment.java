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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.a.g;
import d.a.m0.a.x;
import d.a.m0.r.s.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PersonPolymericFragment extends BaseFragment implements VoiceManager.j {

    /* renamed from: e  reason: collision with root package name */
    public long f19894e;

    /* renamed from: i  reason: collision with root package name */
    public VoiceManager f19898i;
    public View k;
    public ShareSuccessReplyToServerModel l;
    public String n;
    public String o;
    public d.a.n0.j2.d.g p;
    public String r;
    public String s;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19895f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f19896g = "";
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public boolean f19897h = false;
    public boolean j = false;
    public boolean m = false;
    public long q = 0;
    public AntiHelper.k t = new b();
    public CustomMessageListener u = new c(2921004);
    public HttpMessageListener v = new d(CmdConfigHttp.GETPAYINFO_CMD);
    public CustomMessageListener w = new e(2921033);
    public CustomMessageListener x = new f(2921378);
    public CustomMessageListener y = new g(2001115);

    /* loaded from: classes5.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f19899e;

        public a(Thread2GroupShareView thread2GroupShareView) {
            this.f19899e = thread2GroupShareView;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
            l.x(PersonPolymericFragment.this.getActivity(), this.f19899e.getChatMsgView());
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AntiHelper.k {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonPolymericFragment.this.f19895f) {
                PersonPolymericFragment.this.m = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends HttpMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001505) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && PersonPolymericFragment.this.p != null) {
                PersonPolymericFragment.this.p.p(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserData j;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !PersonPolymericFragment.this.f19895f) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (TextUtils.isEmpty(str) || PersonPolymericFragment.this.p == null) {
                    return;
                }
                d.a.n0.j2.e.a p = PersonPolymericFragment.this.p.p(true);
                PersonPolymericFragment.this.n = str;
                if (p == null || (j = p.j()) == null) {
                    return;
                }
                j.setName_show(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !PersonPolymericFragment.this.f19895f) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                PersonPolymericFragment.this.o = (String) data;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.l == null || AntiHelper.t(PersonPolymericFragment.this.getActivity(), data.l, PersonPolymericFragment.this.t) == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements g.b {
        public h() {
        }

        @Override // d.a.m0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(d.a.m0.a.g.t) instanceof String)) {
                PersonPolymericFragment.this.f19896g = (String) hashMap.get(d.a.m0.a.g.t);
                if (StringUtils.isNull(PersonPolymericFragment.this.f19896g)) {
                    return;
                }
                PersonPolymericFragment.this.f19895f = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ShareSuccessReplyToServerModel.b {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f19909e;

            public a(CustomDialogData customDialogData) {
                this.f19909e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PersonPolymericFragment.this.getPageContext().getPageActivity() != null) {
                    d.a.n0.e2.j.c.a(PersonPolymericFragment.this.getPageContext(), this.f19909e).show();
                }
            }
        }

        public i() {
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            d.a.c.e.m.e.a().postDelayed(new a(customDialogData), 1000L);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f19911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f19912f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19913g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19914h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f19915i;
        public final /* synthetic */ ShareFromPBMsgData j;

        public j(Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            this.f19911e = thread2GroupShareView;
            this.f19912f = j;
            this.f19913g = str;
            this.f19914h = str2;
            this.f19915i = str3;
            this.j = shareFromPBMsgData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
            l.x(PersonPolymericFragment.this.getActivity(), this.f19911e.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PersonPolymericFragment.this.getActivity(), this.f19912f, this.f19913g, this.f19914h, this.f19915i, 0, this.f19911e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            if (shareItem == null || shareItem.e() == null) {
                return;
            }
            Bundle e2 = shareItem.e();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", e2.getInt("obj_type")).param("obj_param1", 3).param("fid", e2.getString("fid")).param("tid", e2.getString("tid")).param("obj_locate", 8));
        }
    }

    public final void P0(Intent intent) {
        if (intent != null) {
            try {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                d.a.n0.j2.d.g gVar = this.p;
                if (gVar == null || gVar.k(postWriteCallBackData)) {
                    return;
                }
                this.p.w(postWriteCallBackData);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final ShareFromPBMsgData Q0() {
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

    public final void R0(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        W0(Q0(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    public final void S0(Bundle bundle) {
        Map<String, String> paramPair;
        int i2;
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            if (bundle != null) {
                this.f19894e = bundle.getLong("user_id", d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.f19895f = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
                this.f19897h = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
                this.j = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
                this.r = bundle.getString("st_type");
                this.s = bundle.getString("thread_id");
                bundle.getString("nid");
                return;
            }
            return;
        }
        long f2 = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.f19894e = f2;
        this.f19895f = f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (d.a.m0.a.g.c(uri)) {
                d.a.m0.a.g.b().h(uri, new h());
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
                        V0(decode);
                        Matcher matcher = Pattern.compile(".*fr=(.*)&portrait=([\\d]+).*").matcher(decode);
                        if (matcher.find()) {
                            this.f19896g = matcher.group(2);
                            return;
                        }
                        int indexOf = decode.indexOf("portrait=");
                        if (indexOf >= 0 && (i2 = indexOf + 9) <= decode.length()) {
                            String substring = decode.substring(i2);
                            this.f19896g = substring;
                            if (StringUtils.isNull(substring)) {
                                return;
                            }
                            this.f19895f = false;
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
                            this.f19894e = d.a.c.e.m.b.f(str, 0L);
                        } else {
                            this.f19894e = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
                        }
                        this.f19895f = this.f19894e == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
        }
        this.f19894e = intent.getLongExtra("user_id", d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
        this.f19895f = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
        this.f19897h = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
        this.j = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
        this.r = intent.getStringExtra("st_type");
        this.s = intent.getStringExtra("thread_id");
        intent.getStringExtra("nid");
    }

    public final void T0() {
        StatisticItem statisticItem = new StatisticItem("c13576");
        statisticItem.param("obj_type", this.f19895f ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
    }

    public final void U0() {
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13541");
        statisticItem.param("tid", this.s);
        statisticItem.param("uid", this.f19894e);
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

    public final void V0(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = UrlManager.getParamPair(str);
        if (paramPair != null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
            x.b(statisticItem, paramPair);
            statisticItem.param("obj_locate", paramPair.get("obj_locate"));
            statisticItem.param("obj_type", 1);
            statisticItem.param("tid", paramPair.get("tid"));
            statisticItem.param("obj_source", paramPair.get("obj_source"));
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
            statisticItem.param(TiebaStatic.Params.OBJ_TO, 3);
            statisticItem.param("obj_id", paramPair.get("bdid"));
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

    public final void W0(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        if (shareFromPBMsgData == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new j(thread2GroupShareView, j2, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(R.string.cancel, new a(thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(getPageContext()).show();
        if (k.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.f19898i == null) {
            this.f19898i = VoiceManager.instance();
        }
        return this.f19898i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.p = new d.a.n0.j2.d.g(this, this.k, getUniqueId(), this.f19894e, this.f19895f, this.j, this.f19896g);
        this.l = new ShareSuccessReplyToServerModel();
        d.a.n0.j2.b.d().k(System.currentTimeMillis() - d.a.n0.j2.b.d().a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        d.a.n0.j2.d.g gVar;
        d.a.n0.j2.d.g gVar2;
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        d.a.n0.j2.d.g gVar3;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 101) {
                if (this.p.n() instanceof d.a.n0.t1.a) {
                    ((d.a.n0.t1.a) this.p.n()).f();
                    ((d.a.n0.t1.a) this.p.n()).loadData();
                }
            } else if (i2 == 12002) {
                if (intent == null || (gVar = this.p) == null) {
                    return;
                }
                gVar.n().a().P().A(intent);
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
                d.a.n0.j2.d.g gVar4 = this.p;
                if (gVar4 != null) {
                    gVar4.n().a().P().q();
                    this.p.h();
                }
            } else if (i2 == 13003) {
                P0(intent);
            } else if (i2 == 13011) {
                d.a.n0.s2.a.g().m(getPageContext());
            } else if (i2 == 23007) {
                R0(intent);
            } else if (i2 == 24001) {
                if (intent != null && (this.p.n() instanceof d.a.n0.t1.a)) {
                    ((d.a.n0.t1.a) this.p.n()).f();
                    ((d.a.n0.t1.a) this.p.n()).loadData();
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
                    d.a.n0.j2.d.g gVar5 = this.p;
                    if (gVar5 != null) {
                        gVar5.n().a().P().q();
                        this.p.h();
                    }
                }
            } else {
                int intExtra3 = intent.getIntExtra("extra_share_status", 2);
                int intExtra4 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra3 == 1) {
                    d.a.n0.s2.a.g().m(getPageContext());
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
                    shareSuccessReplyToServerModel.w(str, intExtra4, new i());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        MessageManager.getInstance().registerListener(this.u);
        MessageManager.getInstance().registerListener(this.w);
        MessageManager.getInstance().registerListener(this.x);
        MessageManager.getInstance().registerListener(this.v);
        MessageManager.getInstance().registerListener(this.y);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.j2.d.g gVar = this.p;
        if (gVar != null) {
            gVar.s(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        d.a.n0.j2.b.d().i();
        d.a.n0.j2.b.d().j(currentTimeMillis);
        super.onCreate(bundle);
        VoiceManager voiceManager = getVoiceManager();
        this.f19898i = voiceManager;
        if (voiceManager != null) {
            voiceManager.onCreate(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        S0(bundle);
        U0();
        T0();
        View inflate = layoutInflater.inflate(R.layout.fragment_person_center_layout, (ViewGroup) null);
        if (this.f19894e <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.f19894e = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.k = inflate;
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VoiceManager voiceManager = this.f19898i;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        this.f19898i = null;
        d.a.n0.j2.d.g gVar = this.p;
        if (gVar != null) {
            gVar.t();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.u);
        MessageManager.getInstance().unRegisterListener(this.w);
        MessageManager.getInstance().unRegisterListener(this.x);
        MessageManager.getInstance().unRegisterListener(this.v);
        MessageManager.getInstance().unRegisterListener(this.y);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VoiceManager voiceManager = getVoiceManager();
        this.f19898i = voiceManager;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        if (this.q > 0) {
            TiebaStatic.log(new StatisticItem("c12263").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf((System.currentTimeMillis() - this.q) / 1000)).param("obj_type", 2));
            this.q = 0L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.p.u(isPrimary());
            d.a.n0.u2.a.v().I(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VoiceManager voiceManager = getVoiceManager();
        this.f19898i = voiceManager;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        this.p.v();
        if (!this.f19895f && this.f19897h) {
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

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putLong("user_id", this.f19894e);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.f19895f);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.f19897h);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.j);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = getVoiceManager();
        this.f19898i = voiceManager;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        VoiceManager voiceManager = getVoiceManager();
        this.f19898i = voiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }
}
