package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.n0.a0.d;
import d.a.n0.b1.m.f;
import d.a.n0.h.a;
import d.a.n0.r.f0.f;
import d.a.n0.r.q.b1;
import d.a.n0.r.s.a;
import d.a.n0.r.s.b;
import d.a.n0.r.s.l;
import d.a.o0.e2.i.c;
import d.a.o0.e2.k.e.c1.b;
import d.a.o0.e2.k.e.e0;
import d.a.o0.e2.k.e.q;
import d.a.o0.e2.p.e;
import d.a.o0.e3.j0.a;
import d.a.o0.g0.a;
import d.a.o0.g0.b;
import d.a.o0.r0.f2.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ForumToolPerm;
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class PbFragment extends BaseFragment implements d.a.n0.b1.m.h, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a.e, TbRichTextView.r, TbPageContextSupport, d.a.o0.e2.o.i, e.b {
    public static final AntiHelper.k A2 = new g0();
    public static final b.InterfaceC1400b B2 = new e2();
    public d.a.o0.e2.k.e.v0 D0;
    public d.a.c.e.k.b<TextView> E;
    public d.a.n0.r.s.j E0;
    public d.a.c.e.k.b<TbImageView> F;
    public d.a.n0.r.s.l F0;
    public d.a.c.e.k.b<ImageView> G;
    public String G0;
    public boolean G1;
    public d.a.c.e.k.b<View> H;
    public d.a.c.e.k.b<LinearLayout> I;
    public boolean I0;
    public d.a.c.e.k.b<RelativeLayout> J;
    public d.a.o0.e3.h0.f M0;
    public d.a.c.e.k.b<GifView> N;
    public d.a.n0.w.w.g N0;
    public d.a.n0.w.w.e O0;
    public boolean P0;
    public PermissionJudgePolicy Q0;
    public ReplyPrivacyCheckController R0;
    public d.a.o0.e2.k.e.b1.f.a S;
    public d.a.o0.r0.f2.a.c S0;
    public LikeModel T;
    public d.a.o0.r0.f2.a.c T0;
    public View U;
    public EmotionImageData U0;
    public View V;
    public View W;
    public View X;
    public String Y;
    public Object Z0;
    public boolean a0;
    public d.a.c.a.f a1;
    public d.a.n0.r.f0.c b1;
    public int c0;
    public BdUniqueId c1;
    public Runnable d1;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19058e;
    public d.a.o0.e2.k.e.x0 e1;
    public d.a.c.k.d.a f1;
    public String g1;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.g0.b f19061h;
    public TbRichTextMemeInfo h1;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.e2.k.e.c1.b f19062i;
    public boolean i2;
    public boolean j;
    public d.a.n0.r.q.k1 k0;
    public List<p2> l1;
    public boolean m;
    public d.a.n0.r.b0.a m0;
    public String n1;
    public VoiceManager o;
    public d.a.o0.e3.h0.e o0;
    public d.a.o0.y.a o1;
    public d.a.o0.e2.k.f.a t0;
    public boolean w;
    public String y2;
    public d.a.n0.r.q.t z2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19059f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19060g = false;
    public boolean k = false;
    public boolean l = false;
    public boolean n = true;
    public int p = 0;
    public d.a.n0.r.s.b q = null;
    public long r = -1;
    public long s = 0;
    public long t = 0;
    public long u = 0;
    public long v = 0;
    public boolean x = false;
    public d.a.n0.m0.b y = null;
    public long z = 0;
    public boolean A = false;
    public long B = 0;
    public int C = 1;
    public String D = null;
    public boolean K = false;
    public boolean L = false;
    public boolean M = false;
    public String O = "";
    public boolean P = true;
    public boolean Q = false;
    public String R = "";
    public int Z = 3;
    public int[] b0 = new int[2];
    public int i0 = -1;
    public int j0 = -1;
    public BdUniqueId l0 = BdUniqueId.gen();
    public boolean n0 = false;
    public boolean p0 = d.a.n0.b.d.W();
    public PbInterviewStatusView.f q0 = new k();
    public final Handler r0 = new Handler(new v());
    public PbModel s0 = null;
    public d.a.n0.h.a u0 = null;
    public ForumManageModel v0 = null;
    public d.a.n0.s.e.a w0 = null;
    public d.a.o0.e2.h.s x0 = null;
    public ShareSuccessReplyToServerModel y0 = null;
    public d.a.o0.e2.k.e.t0 z0 = null;
    public boolean A0 = false;
    public boolean B0 = false;
    public boolean C0 = false;
    public boolean H0 = false;
    public boolean J0 = false;
    public boolean K0 = false;
    public boolean L0 = false;
    public d.a.n0.w.w.c V0 = new r0();
    public d.a.n0.w.w.b W0 = new c1();
    public d.a.n0.w.w.b X0 = new n1();
    public int Y0 = 0;
    public boolean i1 = false;
    public int j1 = 0;
    public int k1 = -1;
    public int m1 = 0;
    public final p2 p1 = new y1();
    public final e0.b q1 = new j2();
    public final CustomMessageListener r1 = new o2(2004016);
    public CustomMessageListener s1 = new a(2016485);
    public CustomMessageListener t1 = new b(2001269);
    public CustomMessageListener u1 = new c(2004008);
    public CustomMessageListener v1 = new d(2004007);
    public CustomMessageListener w1 = new e(2004005);
    public CustomMessageListener x1 = new f(2001332);
    public final CustomMessageListener y1 = new g(2921391);
    public View.OnClickListener z1 = new h();
    public CustomMessageListener A1 = new i(2001369);
    public CustomMessageListener B1 = new j(2016488);
    public CustomMessageListener C1 = new l(2016331);
    public SuggestEmotionModel.c D1 = new m();
    public CustomMessageListener E1 = new n(2921509);
    public GetSugMatchWordsModel.b F1 = new o();
    public PraiseModel H1 = new PraiseModel(getPageContext(), new p());
    public b.h I1 = new q();
    public CustomMessageListener J1 = new s(2001115);
    public d.a.n0.f0.i K1 = new t();
    public CheckRealNameModel.b L1 = new x();
    public d.a.o0.e2.i.c M1 = new d.a.o0.e2.i.c(new z());
    public CustomMessageListener N1 = new b0(2001427);
    public CustomMessageListener O1 = new c0(2001428);
    public CustomMessageListener P1 = new d0(2001426);
    public CustomMessageListener Q1 = new e0(2004021);
    public CustomMessageListener R1 = new f0(2921033);
    public a.e S1 = new h0();
    public l.e T1 = new i0();
    public SortSwitchButton.f U1 = new m0();
    public final View.OnClickListener V1 = new p0();
    public CustomMessageListener W1 = new q0(2921480);
    public final NewWriteModel.g X1 = new s0();
    public NewWriteModel.g Y1 = new t0();
    public d.a.c.c.g.a Z1 = new u0(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
    public final PbModel.g a2 = new v0();
    public CustomMessageListener b2 = new w0(2016450);
    public HttpMessageListener c2 = new x0(CmdConfigHttp.SET_PRIVATE_CMD, true);
    public final a.InterfaceC1183a d2 = new y0();
    public final AbsListView.OnScrollListener e2 = new b1();
    public final d.a.c.a.e f2 = new f1();
    public final r2 g2 = new h1();
    public final f.g h2 = new i1();
    public final BdListView.p j2 = new j1();
    public int k2 = 0;
    public final TbRichTextView.x l2 = new u1();
    public boolean m2 = false;
    public PostData n2 = null;
    public final b.c o2 = new v1();
    public final b.c p2 = new w1();
    public final AdapterView.OnItemClickListener q2 = new x1();
    public final View.OnLongClickListener r2 = new z1();
    public final NoNetworkView.b s2 = new a2();
    public View.OnTouchListener t2 = new c2();
    public a.b u2 = new d2();
    public final q.b v2 = new f2();
    public int w2 = -1;
    public int x2 = -1;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.n0.t.n)) {
                PbFragment.this.s0.c2((d.a.n0.t.n) customResponsedMessage.getData());
                if (PbFragment.this.z0 != null && PbFragment.this.s0 != null) {
                    PbFragment.this.z0.b2(PbFragment.this.s0.C0(), PbFragment.this.s0.Q0(), PbFragment.this.s0.M0(), PbFragment.this.z0.Q0());
                }
                if (PbFragment.this.z0 == null || PbFragment.this.z0.l0() == null) {
                    return;
                }
                PbFragment.this.z0.l0().U();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements b.c {
        public a0() {
        }

        @Override // d.a.n0.r.s.b.c
        public void a(d.a.n0.r.s.b bVar, int i2, View view) {
            if (i2 == 0) {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                PbFragment pbFragment = PbFragment.this;
                pbFragment.G0 = pbFragment.G0.trim();
                UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.G0);
                new d.a.o0.e2.k.e.d(PbFragment.this.s0.S0(), PbFragment.this.G0, "1").start();
                bVar.e();
            } else if (i2 == 1) {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                PbFragment pbFragment2 = PbFragment.this;
                pbFragment2.G0 = pbFragment2.G0.trim();
                UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.G0);
                new d.a.o0.e2.k.e.d(PbFragment.this.s0.S0(), PbFragment.this.G0, "2").start();
                bVar.e();
            } else if (i2 == 2) {
                PbFragment pbFragment3 = PbFragment.this;
                pbFragment3.G0 = pbFragment3.G0.trim();
                UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.G0);
                bVar.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f19065e;

        public a1(MetaData metaData) {
            this.f19065e = metaData;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f19065e.getUserId()).param("obj_locate", 1));
            aVar.dismiss();
            PbFragment.this.w0.m(!this.f19065e.hadConcerned(), this.f19065e.getPortrait(), this.f19065e.getUserId(), this.f19065e.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.s0.getForumId(), "0");
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements NoNetworkView.b {
        public a2() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (!PbFragment.this.k && z && !PbFragment.this.s0.s0()) {
                PbFragment.this.F5();
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(pbFragment.getContext(), R.dimen.ds360));
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (PbFragment.this.z0 == null) {
                return;
            }
            if (booleanValue) {
                PbFragment.this.z0.l3();
            } else {
                PbFragment.this.z0.c1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 extends CustomMessageListener {
        public b0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.c1) {
                PbFragment.this.z0.a1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                d.a.o0.e2.h.e C0 = PbFragment.this.s0.C0();
                if (C0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    C0.u().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.b1.c(PbFragment.this.a1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.a1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.f6(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.a6();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.a.c.e.p.k.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.a1.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.b1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements AbsListView.OnScrollListener {
        public b1() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            ArrayList<PostData> D;
            if (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || PbFragment.this.z0 == null || PbFragment.this.z0.l0() == null) {
                return;
            }
            PbFragment.this.z0.N1(absListView, i2, i3, i4);
            if (PbFragment.this.f19062i != null) {
                PbFragment.this.f19062i.q(absListView, i2, i3, i4);
            }
            if (!PbFragment.this.s0.c1() || (D = PbFragment.this.s0.C0().D()) == null || D.isEmpty()) {
                return;
            }
            int v = ((i2 + i3) - PbFragment.this.z0.l0().v()) - 1;
            d.a.o0.e2.h.e C0 = PbFragment.this.s0.C0();
            if (C0 == null) {
                return;
            }
            if (C0.B() != null && C0.B().C0()) {
                v--;
            }
            if (C0.C() != null && C0.C().C0()) {
                v--;
            }
            int size = D.size();
            if (v < 0 || v >= size) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            PbFragment pbFragment = PbFragment.this;
            if (!pbFragment.i5(pbFragment.Y0) && PbFragment.this.i5(i2)) {
                if (PbFragment.this.z0 != null) {
                    PbFragment.this.z0.a0();
                    if (PbFragment.this.O0 != null && !PbFragment.this.z0.n1()) {
                        PbFragment.this.z0.o2(PbFragment.this.O0.C());
                    }
                    if (!PbFragment.this.L) {
                        PbFragment.this.z0.h2();
                    }
                }
                if (!PbFragment.this.x) {
                    PbFragment.this.x = true;
                }
            }
            if (PbFragment.this.z0 != null) {
                PbFragment.this.z0.O1(absListView, i2);
            }
            if (PbFragment.this.f19062i != null) {
                PbFragment.this.f19062i.r(absListView, i2);
            }
            if (PbFragment.this.y == null) {
                PbFragment.this.y = new d.a.n0.m0.b();
                PbFragment.this.y.a(1001);
            }
            if (i2 == 0) {
                PbFragment.this.y.e();
            } else {
                PbFragment.this.y.d();
            }
            PbFragment.this.Y0 = i2;
            if (i2 == 0) {
                PbFragment.this.K5(false, null);
                d.a.o0.d3.c.g().h(PbFragment.this.getUniqueId(), true);
                PbFragment.this.W3(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b2 implements d.a.c.e.k.c<LinearLayout> {
        public b2() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        public LinearLayout e(LinearLayout linearLayout) {
            return linearLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            linearLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            LinearLayout linearLayout = new LinearLayout(PbFragment.this.getPageContext().getPageActivity());
            linearLayout.setId(R.id.pb_text_voice_layout);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setGravity(16);
            linearLayout.setBaselineAligned(true);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams);
            return linearLayout;
        }

        public LinearLayout h(LinearLayout linearLayout) {
            linearLayout.removeAllViews();
            return linearLayout;
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
            if (customResponsedMessage == null) {
                return;
            }
            if (PbFragment.this.O0 != null) {
                PbFragment.this.z0.o2(PbFragment.this.O0.C());
            }
            PbFragment.this.z0.V2(false);
        }
    }

    /* loaded from: classes5.dex */
    public class c0 extends CustomMessageListener {
        public c0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.c1) {
                PbFragment.this.z0.a1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.b1.c(PbFragment.this.a1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.a.c.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.a1.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.b1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements d.a.n0.w.w.b {
        public c1() {
        }

        @Override // d.a.n0.w.w.b
        public boolean a() {
            d.a.o0.e2.k.e.v0 v0Var = PbFragment.this.D0;
            if (v0Var == null || v0Var.e() == null || !PbFragment.this.D0.e().d()) {
                return !PbFragment.this.b4(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.showToast(pbFragment.D0.e().c());
            if (PbFragment.this.O0 != null && (PbFragment.this.O0.B() || PbFragment.this.O0.D())) {
                PbFragment.this.O0.z(false, PbFragment.this.D0.h());
            }
            PbFragment.this.D0.a(true);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class c2 implements View.OnTouchListener {
        public c2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                View childAt = frameLayout.getChildAt(i2);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.f19061h.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.a.o0.e2.e eVar = (d.a.o0.e2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                PbFragment.this.E5((d.a.o0.e2.h.r) eVar.a());
            } else if (b2 == 1) {
                PbFragment.this.n4((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    PbFragment.this.D5(false, null);
                } else {
                    PbFragment.this.D5(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends CustomMessageListener {
        public d0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.o0.p3.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.c1) {
                d.a.o0.p3.a aVar = (d.a.o0.p3.a) customResponsedMessage.getData();
                PbFragment.this.z0.a1();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.Z0;
                DataRes dataRes = aVar.f61976a;
                if (aVar.f61978c == 0 && dataRes != null) {
                    int d2 = d.a.c.e.m.b.d(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = d2 == 1;
                    if (d.a.c.e.p.k.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    PbFragment.this.b6(r2, sparseArray);
                } else if (intValue == 1) {
                    PbFragment.this.z0.T1(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements Comparator<d.a.n0.t.a> {
        public d1() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a.n0.t.a aVar, d.a.n0.t.a aVar2) {
            return aVar.compareTo(aVar2);
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final int f19079a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        public d2() {
        }

        @Override // d.a.o0.g0.a.b
        public void a(int i2, int i3) {
            if (!e(i3) || PbFragment.this.z0 == null || PbFragment.this.f19062i == null) {
                return;
            }
            PbFragment.this.f19062i.u(true);
            if (Math.abs(i3) > this.f19079a) {
                PbFragment.this.f19062i.l();
            }
            if (PbFragment.this.C4()) {
                PbFragment.this.z0.b1();
                PbFragment.this.z0.j2();
            }
        }

        @Override // d.a.o0.g0.a.b
        public void b(int i2, int i3) {
            if (!e(i3) || PbFragment.this.z0 == null || PbFragment.this.f19062i == null) {
                return;
            }
            PbFragment.this.z0.j3();
            PbFragment.this.f19062i.u(false);
            PbFragment.this.f19062i.x();
        }

        @Override // d.a.o0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.o0.g0.a.b
        public void d(int i2, int i3) {
        }

        public final boolean e(float f2) {
            return Math.abs(f2) >= 1.0f;
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
            if (PbFragment.this.z0 == null || PbFragment.this.z0.l0() == null) {
                return;
            }
            PbFragment.this.z0.l0().U();
        }
    }

    /* loaded from: classes5.dex */
    public class e0 extends CustomMessageListener {
        public e0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.z0.n1() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.k4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements AntiHelper.k {
        public e1() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.n0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.n0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }
    }

    /* loaded from: classes5.dex */
    public static class e2 implements b.InterfaceC1400b {
        @Override // d.a.o0.g0.b.InterfaceC1400b
        public void a(boolean z) {
            if (z) {
                d.a.o0.e2.i.b.d();
            } else {
                d.a.o0.e2.i.b.c();
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof f.a)) {
                return;
            }
            f.a aVar = (f.a) customResponsedMessage.getData();
            d.a.n0.b1.m.f.c(PbFragment.this.getPageContext(), PbFragment.this, aVar.f52910a, aVar.f52911b, aVar.f52912c);
        }
    }

    /* loaded from: classes5.dex */
    public class f0 extends CustomMessageListener {
        public f0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            PbFragment.this.i1 = true;
        }
    }

    /* loaded from: classes5.dex */
    public class f1 extends d.a.c.a.e {
        public f1() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (PbFragment.this.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (PbFragment.this.v0.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.s0.Y0();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            PbFragment.this.n4(bVar, (bVar.f20988e != 1002 || bVar.f20989f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.z0.i0(1, dVar.f20991a, dVar.f20992b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = PbFragment.this;
                            pbFragment.o4(pbFragment.v0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.z0.i0(PbFragment.this.v0.getLoadDataMode(), gVar.f21005a, gVar.f21006b, false);
                            PbFragment.this.z0.P1(gVar.f21007c);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.z0.i0(PbFragment.this.v0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f2 implements q.b {
        public f2() {
        }

        @Override // d.a.o0.e2.k.e.q.b
        public void a(int i2, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i2 == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i2 != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.z0.Y(str);
            } else {
                PbFragment.this.showToast(str);
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
            if (PbFragment.this.k) {
                return;
            }
            PbFragment.this.h6();
        }
    }

    /* loaded from: classes5.dex */
    public static class g0 implements AntiHelper.k {
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.n0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.n0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements a.e {
        public g1() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g2 implements a.e {
        public g2() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            if (Build.VERSION.SDK_INT < 11) {
                aVar.dismiss();
                ((TbPageContext) PbFragment.this.a1).showToast(R.string.frs_header_games_unavailable);
                return;
            }
            TiebaStatic.log("c10025");
            aVar.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.a1.getPageActivity(), 2, true, 4);
            if (!StringUtils.isNULL("4010001001")) {
                memberPayActivityConfig.setSceneId("4010001001");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment pbFragment = PbFragment.this;
            pbFragment.showToast(pbFragment.D);
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements a.e {
        public h0() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            PbFragment.this.X4();
            d.a.n0.r.q.z0 A0 = PbFragment.this.s0.A0();
            int G0 = PbFragment.this.z0.G0();
            if (G0 <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (A0 == null || G0 <= A0.h()) {
                PbFragment.this.z0.a0();
                PbFragment.this.k6();
                PbFragment.this.z0.J2();
                if (d.a.c.e.p.j.z()) {
                    PbFragment.this.s0.U1(PbFragment.this.z0.G0());
                    if (PbFragment.this.f19062i != null) {
                        PbFragment.this.f19062i.x();
                    }
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
                aVar.dismiss();
            } else {
                PbFragment.this.showToast(R.string.pb_page_error);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements r2 {
        public h1() {
        }
    }

    /* loaded from: classes5.dex */
    public class h2 implements a.e {
        public h2() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.n0.r.q.i0)) {
                return;
            }
            d.a.n0.r.q.i0 i0Var = (d.a.n0.r.q.i0) customResponsedMessage.getData();
            b1.a aVar = new b1.a();
            int i2 = i0Var.f53826a;
            String str = i0Var.f53827b;
            aVar.f53731a = i0Var.f53829d;
            d.a.o0.e2.h.e C0 = PbFragment.this.s0.C0();
            if (C0 == null) {
                return;
            }
            if (PbFragment.this.s0.g0() != null && PbFragment.this.s0.g0().getUserIdLong() == i0Var.p) {
                PbFragment.this.z0.a2(i0Var.l, PbFragment.this.s0.C0(), PbFragment.this.s0.Q0(), PbFragment.this.s0.M0());
            }
            if (C0.D() == null || C0.D().size() < 1 || C0.D().get(0) == null) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(C0.D().get(0).E(), 0L);
            long f3 = d.a.c.e.m.b.f(PbFragment.this.s0.S0(), 0L);
            if (f2 == i0Var.n && f3 == i0Var.m) {
                d.a.n0.r.q.b1 D = C0.D().get(0).D();
                if (D == null) {
                    D = new d.a.n0.r.q.b1();
                }
                ArrayList<b1.a> a2 = D.a();
                if (a2 == null) {
                    a2 = new ArrayList<>();
                }
                a2.add(0, aVar);
                D.e(D.b() + i0Var.l);
                D.d(a2);
                C0.D().get(0).k0(D);
                PbFragment.this.z0.l0().U();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements l.e {
        public i0() {
        }

        @Override // d.a.n0.r.s.l.e
        public void onItemClick(d.a.n0.r.s.l lVar, int i2, View view) {
            SparseArray sparseArray;
            if (PbFragment.this.E0 != null) {
                PbFragment.this.E0.dismiss();
            }
            PbFragment.this.n6(i2);
            int i3 = 4;
            switch (i2) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    PbFragment.this.B5(view2);
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    }
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    PbFragment.this.B5(view3);
                    if (view3 != null) {
                        view3.performClick();
                        return;
                    }
                    return;
                case -2:
                    View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                    if (view4 != null) {
                        AgreeView agreeView = (AgreeView) view4;
                        PbFragment.this.B5(view4);
                        if (agreeView.getImgDisagree() != null) {
                            agreeView.getImgDisagree().performClick();
                            return;
                        }
                        return;
                    }
                    return;
                case -1:
                    View view5 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                    if (view5 != null) {
                        PbFragment.this.B5(view5);
                        AgreeView agreeView2 = (AgreeView) view5;
                        if (agreeView2.getImgAgree() != null) {
                            agreeView2.getImgAgree().performClick();
                            return;
                        }
                        return;
                    }
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (PbFragment.this.f1 == null || TextUtils.isEmpty(PbFragment.this.g1)) {
                        return;
                    }
                    if (PbFragment.this.h1 == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbFragment.this.g1));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f52600a = PbFragment.this.g1;
                        String str = "";
                        if (PbFragment.this.h1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + PbFragment.this.h1.memeInfo.pck_id;
                        }
                        aVar.f52601b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                    PbFragment.this.f1 = null;
                    PbFragment.this.g1 = null;
                    return;
                case 2:
                    if (PbFragment.this.f1 == null || TextUtils.isEmpty(PbFragment.this.g1)) {
                        return;
                    }
                    if (PbFragment.this.Q0 == null) {
                        PbFragment.this.Q0 = new PermissionJudgePolicy();
                    }
                    PbFragment.this.Q0.clearRequestPermissionList();
                    PbFragment.this.Q0.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (PbFragment.this.Q0.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (PbFragment.this.e1 == null) {
                        PbFragment pbFragment = PbFragment.this;
                        pbFragment.e1 = new d.a.o0.e2.k.e.x0(pbFragment.getPageContext());
                    }
                    PbFragment.this.e1.b(PbFragment.this.g1, PbFragment.this.f1.n());
                    PbFragment.this.f1 = null;
                    PbFragment.this.g1 = null;
                    return;
                case 3:
                    PbFragment pbFragment2 = PbFragment.this;
                    PostData postData = pbFragment2.n2;
                    if (postData != null) {
                        postData.h0(pbFragment2.getPageContext().getPageActivity());
                        PbFragment.this.n2 = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.s5(view);
                        if (PbFragment.this.s0.C0().L() == null || PbFragment.this.s0.C0().L().T() == null || PbFragment.this.s0.C0().L().T().getUserId() == null || PbFragment.this.u0 == null) {
                            return;
                        }
                        PbFragment pbFragment3 = PbFragment.this;
                        int Q4 = pbFragment3.Q4(pbFragment3.s0.C0());
                        d.a.n0.r.q.a2 L = PbFragment.this.s0.C0().L();
                        if (L.R1()) {
                            i3 = 2;
                        } else if (L.U1()) {
                            i3 = 3;
                        } else if (!L.S1()) {
                            i3 = L.T1() ? 5 : 1;
                        }
                        TiebaStatic.log(new StatisticItem("c12526").param("tid", PbFragment.this.s0.f19254e).param("obj_locate", 2).param("obj_id", PbFragment.this.s0.C0().L().T().getUserId()).param("obj_type", !PbFragment.this.u0.e()).param("obj_source", Q4).param("obj_param1", i3));
                        return;
                    }
                    return;
                case 5:
                    if (!d.a.c.e.p.j.z()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new StatisticItem("c13079"));
                        PbFragment.this.V4((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.Z3(sparseArray2);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean) && (sparseArray3.get(R.id.tag_has_sub_post) instanceof Boolean)) {
                        boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue = ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue();
                        boolean isHost = PbFragment.this.B().isHost(TbadkCoreApplication.getCurrentAccount());
                        if (isHost) {
                            if (!booleanValue2) {
                                PbFragment.this.V5(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                PbFragment.this.z0.S1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, isHost);
                                return;
                            }
                        } else if (booleanValue && !booleanValue2) {
                            PbFragment.this.V5(sparseArray3, intValue, booleanValue);
                            return;
                        } else {
                            PbFragment.this.z0.Q1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                            return;
                        }
                    }
                    return;
                case 7:
                    if (!d.a.c.e.p.j.z()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 == null) {
                        return;
                    }
                    boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                    boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                    boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                    if (!booleanValue3) {
                        if (booleanValue4) {
                            PbFragment.this.z0.Q1(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        }
                        return;
                    } else if (booleanValue5) {
                        sparseArray4.put(R.id.tag_from, 1);
                        sparseArray4.put(R.id.tag_check_mute_from, 2);
                        PbFragment.this.Z3(sparseArray4);
                        return;
                    } else {
                        sparseArray4.put(R.id.tag_check_mute_from, 2);
                        PbFragment.this.z0.U1(view);
                        return;
                    }
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData2.q() == null) {
                            return;
                        }
                        PbFragment.this.c4(postData2.q());
                        return;
                    }
                    return;
                case 9:
                    if (!PbFragment.this.checkUpIsLogin() || PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null) {
                        return;
                    }
                    PbFragment.this.f19058e.showBlockDialog(d.a.o0.o3.a.b(view));
                    return;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements f.g {
        public i1() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.C4()) {
                PbFragment.this.f19058e.finish();
            }
            if (!PbFragment.this.s0.o1(true)) {
                PbFragment.this.z0.h0();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements a.e {
        public i2() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null) {
                return;
            }
            PbFragment.this.s0.C0().a();
            PbFragment.this.s0.Y0();
            if (PbFragment.this.z0.l0() != null) {
                PbFragment.this.z0.l1(PbFragment.this.s0.C0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19100e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19101f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f19102g;

        public j0(SparseArray sparseArray, int i2, boolean z) {
            this.f19100e = sparseArray;
            this.f19101f = i2;
            this.f19102g = z;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            if (aVar != null) {
                aVar.dismiss();
            }
            PbFragment.this.j4(((Integer) this.f19100e.get(R.id.tag_del_post_type)).intValue(), (String) this.f19100e.get(R.id.tag_del_post_id), this.f19101f, this.f19102g);
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements BdListView.p {
        public j1() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (PbFragment.this.i2 && PbFragment.this.C4()) {
                PbFragment.this.l5();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.n0 && PbFragment.this.z0 != null && PbFragment.this.z0.S() && PbFragment.this.s0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", PbFragment.this.s0.S0());
                    statisticItem.param("fid", PbFragment.this.s0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i2 = 5;
                    if (PbFragment.this.s0.i0()) {
                        i2 = 4;
                    } else if (PbFragment.this.s0.j0()) {
                        i2 = 3;
                    } else if (PbFragment.this.s0.l0()) {
                        i2 = 1;
                    }
                    statisticItem.param("obj_type", i2);
                    TiebaStatic.log(statisticItem);
                    PbFragment.this.n0 = true;
                }
                if (PbFragment.this.s0.k1(false)) {
                    PbFragment.this.z0.K2();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.s0.C0() != null) {
                    PbFragment.this.z0.d2();
                }
                PbFragment.this.i2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j2 implements e0.b {
        public j2() {
        }

        @Override // d.a.o0.e2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            if (StringUtils.isNull(str)) {
                return;
            }
            PbFragment.this.z0.r3(str);
        }

        @Override // d.a.o0.e2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
        }
    }

    /* loaded from: classes5.dex */
    public class k implements PbInterviewStatusView.f {
        public k() {
        }

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            PbFragment.this.z0.o3(!PbFragment.this.P);
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements a.e {
        public k0() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements Runnable {
        public k1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PbFragment.this.s0 != null) {
                PbFragment.this.s0.LoadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f19109e;

        public k2(UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            this.f19109e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            PbFragment.this.z0.c3();
            MessageManager.getInstance().sendMessage(this.f19109e);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public l(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            PbFragment.this.g4(str);
            PbFragment.this.s0.Y0();
            if (!TextUtils.isEmpty(str) && PbFragment.this.s0.C0().D() != null) {
                ArrayList<PostData> D = PbFragment.this.s0.C0().D();
                d.a.o0.e3.h0.o oVar = null;
                Iterator<PostData> it = D.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof d.a.o0.e3.h0.o) {
                        d.a.o0.e3.h0.o oVar2 = (d.a.o0.e3.h0.o) next;
                        if (str.equals(oVar2.D0())) {
                            oVar = oVar2;
                            break;
                        }
                    }
                }
                if (oVar != null) {
                    D.remove(oVar);
                    if (PbFragment.this.z0.l0() != null && PbFragment.this.z0.l0().r() != null) {
                        PbFragment.this.z0.l0().r().remove(oVar);
                    }
                    if (PbFragment.this.z0.B0() != null && PbFragment.this.z0.B0().getData() != null) {
                        PbFragment.this.z0.B0().getData().remove(oVar);
                    }
                    if (PbFragment.this.z0.l0() != null) {
                        PbFragment.this.z0.l0().U();
                        return;
                    }
                }
            }
            if (PbFragment.this.z0.l0() != null) {
                PbFragment.this.z0.l1(PbFragment.this.s0.C0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements c.d {
        public l0() {
        }

        @Override // d.a.o0.r0.f2.a.c.d
        public void a(boolean z, int i2) {
        }

        @Override // d.a.o0.r0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                if (PbFragment.this.O0 != null && PbFragment.this.O0.a() != null) {
                    PbFragment.this.O0.a().A(new d.a.n0.w.a(45, 27, null));
                }
                PbFragment.this.z0.T();
            }
        }

        @Override // d.a.o0.r0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements ShareSuccessReplyToServerModel.b {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f19114e;

            public a(CustomDialogData customDialogData) {
                this.f19114e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.o0.e2.j.c.a(PbFragment.this.getPageContext(), this.f19114e).show();
            }
        }

        public l1() {
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
    public class l2 implements a.e {
        public l2() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class m implements SuggestEmotionModel.c {
        public m() {
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(d.a.o0.e2.k.e.b1.e.a aVar) {
            if (aVar == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.c()));
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void onFail(int i2, String str) {
            BdLog.e(str);
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements SortSwitchButton.f {
        public m0() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            PbFragment.this.z0.a0();
            boolean z = false;
            if (d.a.c.e.p.j.z()) {
                if (PbFragment.this.s0 != null && !PbFragment.this.s0.isLoading) {
                    PbFragment.this.k6();
                    PbFragment.this.z0.J2();
                    z = true;
                    if (PbFragment.this.s0.C0() != null && PbFragment.this.s0.C0().f56738f != null && PbFragment.this.s0.C0().f56738f.size() > i2) {
                        int intValue = PbFragment.this.s0.C0().f56738f.get(i2).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", PbFragment.this.s0.T0()).param("fid", PbFragment.this.s0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (PbFragment.this.s0.a2(intValue)) {
                            PbFragment.this.m = true;
                            PbFragment.this.z0.y2(true);
                        }
                    }
                }
                return z;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        public final int b(int i2) {
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 0) {
                return 2;
            }
            return i2 == 1 ? 3 : 0;
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19119e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f19120f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f19121g;

        public m1(MarkData markData, MarkData markData2, d.a.n0.r.s.a aVar) {
            this.f19119e = markData;
            this.f19120f = markData2;
            this.f19121g = aVar;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            if (PbFragment.this.u0 != null) {
                if (PbFragment.this.u0.e()) {
                    PbFragment.this.u0.d();
                    PbFragment.this.u0.h(false);
                }
                PbFragment.this.u0.i(this.f19119e);
                PbFragment.this.u0.h(true);
                PbFragment.this.u0.a();
            }
            this.f19120f.setPostId(this.f19119e.getPostId());
            Intent intent = new Intent();
            intent.putExtra("mark", this.f19120f);
            PbFragment.this.f19058e.setResult(-1, intent);
            this.f19121g.dismiss();
            PbFragment.this.l6();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
        }
    }

    /* loaded from: classes5.dex */
    public class m2 extends d.a.n0.z0.f0<ShareItem> {
        public m2() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.a.o0.e2.k.e.e1.b.c(PbFragment.this.getContext(), PbFragment.this.r4(), ShareSwitch.isOn() ? 1 : 6, PbFragment.this.s0);
        }
    }

    /* loaded from: classes5.dex */
    public class n extends CustomMessageListener {
        public n(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue() || PbFragment.this.z0 == null || PbFragment.this.s0 == null) {
                return;
            }
            PbFragment.this.z0.U(false);
            if (PbFragment.this.s0.k1(false)) {
                PbFragment.this.z0.K2();
            } else if (PbFragment.this.s0.C0() != null) {
                PbFragment.this.z0.d2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19125e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19126f;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public a() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.a.o0.e2.k.e.v0 v0Var = PbFragment.this.D0;
                if (v0Var == null || v0Var.g() == null) {
                    return;
                }
                if (!PbFragment.this.D0.g().e()) {
                    PbFragment.this.D0.b(false);
                }
                PbFragment.this.D0.g().l(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        }

        public n0(String str, String str2) {
            this.f19125e = str;
            this.f19126f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            int i3 = d.a.c.e.p.l.i(PbFragment.this.f19058e.getApplicationContext());
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                g2 = d.a.c.e.p.l.g(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
            } else {
                i2 = i3 / 2;
                g2 = d.a.c.e.p.l.g(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
            }
            int i4 = i3 - (i2 + g2);
            PbFragment pbFragment = PbFragment.this;
            boolean z = true;
            pbFragment.N4().B0().smoothScrollBy((pbFragment.b0[1] + pbFragment.c0) - i4, 50);
            if (PbFragment.this.N4().J0() != null) {
                PbFragment.this.O0.a().setVisibility(8);
                PbFragment.this.N4().J0().n(this.f19125e, this.f19126f, PbFragment.this.N4().M0(), (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || PbFragment.this.s0.C0().L() == null || !PbFragment.this.s0.C0().L().V1()) ? false : false);
                d.a.n0.w.w.h b2 = PbFragment.this.N4().J0().b();
                if (b2 != null && PbFragment.this.s0 != null && PbFragment.this.s0.C0() != null) {
                    b2.E(PbFragment.this.s0.C0().d());
                    b2.X(PbFragment.this.s0.C0().L());
                }
                if (PbFragment.this.D0.f() == null && PbFragment.this.N4().J0().b().s() != null) {
                    PbFragment.this.N4().J0().b().s().g(new a());
                    PbFragment pbFragment2 = PbFragment.this;
                    pbFragment2.D0.n(pbFragment2.N4().J0().b().s().i());
                    PbFragment.this.N4().J0().b().K(PbFragment.this.X0);
                }
            }
            PbFragment.this.N4().W0();
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements d.a.n0.w.w.b {
        public n1() {
        }

        @Override // d.a.n0.w.w.b
        public boolean a() {
            d.a.o0.e2.k.e.v0 v0Var = PbFragment.this.D0;
            if (v0Var == null || v0Var.g() == null || !PbFragment.this.D0.g().d()) {
                return !PbFragment.this.b4(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.showToast(pbFragment.D0.g().c());
            if (PbFragment.this.z0 != null && PbFragment.this.z0.J0() != null && PbFragment.this.z0.J0().b() != null && PbFragment.this.z0.J0().b().v()) {
                PbFragment.this.z0.J0().b().t(PbFragment.this.D0.h());
            }
            PbFragment.this.D0.b(true);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements d.a.n0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19130a;

        public n2(int i2) {
            this.f19130a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Bundle bundle = new Bundle();
            bundle.putInt("source", 2);
            shareItem.k(bundle);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(PbFragment.this.getContext(), this.f19130a, shareItem, false));
        }
    }

    /* loaded from: classes5.dex */
    public class o implements GetSugMatchWordsModel.b {
        public o() {
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onFail(int i2, String str) {
            BdLog.e(str);
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            if (ListUtils.isEmpty(list) || PbFragment.this.z0 == null) {
                return;
            }
            PbFragment.this.z0.Q2(list);
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f19133a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19134b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$o0$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0209a implements TextWatcher {
                public C0209a() {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    d.a.o0.e2.k.e.v0 v0Var = PbFragment.this.D0;
                    if (v0Var == null || v0Var.g() == null) {
                        return;
                    }
                    if (!PbFragment.this.D0.g().e()) {
                        PbFragment.this.D0.b(false);
                    }
                    PbFragment.this.D0.g().l(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                int i3 = d.a.c.e.p.l.i(PbFragment.this.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                } else {
                    i2 = i3 / 2;
                    g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                }
                int i4 = i3 - (i2 + g2);
                PbFragment pbFragment = PbFragment.this;
                boolean z = true;
                pbFragment.N4().B0().smoothScrollBy((pbFragment.b0[1] + pbFragment.c0) - i4, 50);
                if (PbFragment.this.N4().J0() != null) {
                    PbFragment.this.O0.a().setVisibility(8);
                    z = (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || PbFragment.this.s0.C0().L() == null || !PbFragment.this.s0.C0().L().V1()) ? false : false;
                    d.a.o0.e2.k.e.u J0 = PbFragment.this.N4().J0();
                    o0 o0Var = o0.this;
                    J0.n(o0Var.f19133a, o0Var.f19134b, PbFragment.this.N4().M0(), z);
                    d.a.n0.w.w.h b2 = PbFragment.this.N4().J0().b();
                    if (b2 != null && PbFragment.this.s0 != null && PbFragment.this.s0.C0() != null) {
                        b2.E(PbFragment.this.s0.C0().d());
                        b2.X(PbFragment.this.s0.C0().L());
                    }
                    if (PbFragment.this.D0.f() == null && PbFragment.this.N4().J0().b().s() != null) {
                        PbFragment.this.N4().J0().b().s().g(new C0209a());
                        PbFragment pbFragment2 = PbFragment.this;
                        pbFragment2.D0.n(pbFragment2.N4().J0().b().s().i());
                        PbFragment.this.N4().J0().b().K(PbFragment.this.X0);
                    }
                }
                PbFragment.this.N4().W0();
            }
        }

        public o0(String str, String str2) {
            this.f19133a = str;
            this.f19134b = str2;
        }

        @Override // d.a.o0.r0.f2.a.c.d
        public void a(boolean z, int i2) {
        }

        @Override // d.a.o0.r0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                d.a.c.e.m.e.a().postDelayed(new a(), 0L);
            }
        }

        @Override // d.a.o0.r0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes5.dex */
    public class o1 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19138e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f19139f;

        public o1(MarkData markData, d.a.n0.r.s.a aVar) {
            this.f19138e = markData;
            this.f19139f = aVar;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            Intent intent = new Intent();
            intent.putExtra("mark", this.f19138e);
            PbFragment.this.f19058e.setResult(-1, intent);
            this.f19139f.dismiss();
            PbFragment.this.l6();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
        }
    }

    /* loaded from: classes5.dex */
    public class o2 extends CustomMessageListener {
        public o2(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.s0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (PbFragment.this.O0 != null) {
                PbFragment.this.z0.o2(PbFragment.this.O0.C());
            }
            PbFragment.this.z0.h2();
            PbFragment.this.z0.a0();
        }
    }

    /* loaded from: classes5.dex */
    public class p implements PraiseModel.b {
        public p() {
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            PbFragment.this.G1 = false;
            if (PbFragment.this.H1 == null) {
                return;
            }
            d.a.o0.e2.h.e C0 = PbFragment.this.s0.C0();
            if (C0.L().R0().getIsLike() == 1) {
                PbFragment.this.q6(0);
            } else {
                PbFragment.this.q6(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, C0.L()));
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            PbFragment.this.G1 = false;
            if (PbFragment.this.H1 == null || str == null) {
                return;
            }
            if (AntiHelper.m(i2, str)) {
                AntiHelper.u(PbFragment.this.getPageContext().getPageActivity(), str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements View.OnClickListener {

        /* loaded from: classes5.dex */
        public class a implements l.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.r.s.j f19144e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ View f19145f;

            public a(d.a.n0.r.s.j jVar, View view) {
                this.f19144e = jVar;
                this.f19145f = view;
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
                if (r4.f19146g.f19143e.s0.P0() != 3) goto L5;
             */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
            /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
            @Override // d.a.n0.r.s.l.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(d.a.n0.r.s.l lVar, int i2, View view) {
                boolean a2;
                this.f19144e.dismiss();
                int i3 = 3;
                if (PbFragment.this.s0.P0() != 1 || i2 != 1) {
                    if (PbFragment.this.s0.P0() == 2 && i2 == 0) {
                        i3 = 1;
                    } else if (PbFragment.this.s0.P0() == 3 && i2 != 2) {
                        i3 = 2;
                    } else if (i2 == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f19145f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                    if (PbFragment.this.s0.C0().f56738f != null && PbFragment.this.s0.C0().f56738f.size() > i2) {
                        i2 = PbFragment.this.s0.C0().f56738f.get(i2).sort_type.intValue();
                    }
                    a2 = PbFragment.this.s0.a2(i2);
                    this.f19145f.setTag(Integer.valueOf(PbFragment.this.s0.O0()));
                    if (a2) {
                        return;
                    }
                    PbFragment.this.m = true;
                    PbFragment.this.z0.y2(true);
                    return;
                }
                i3 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f19145f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (PbFragment.this.s0.C0().f56738f != null) {
                    i2 = PbFragment.this.s0.C0().f56738f.get(i2).sort_type.intValue();
                }
                a2 = PbFragment.this.s0.a2(i2);
                this.f19145f.setTag(Integer.valueOf(PbFragment.this.s0.O0()));
                if (a2) {
                }
            }
        }

        public p0() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:836:0x1d95, code lost:
            if (r36.f19143e.z0.P0.f57302c.a().getTop() <= ((r36.f19143e.z0.K0() == null || r36.f19143e.z0.K0().c() == null) ? 0 : r36.f19143e.z0.K0().c().getBottom())) goto L785;
         */
        /* JADX WARN: Code restructure failed: missing block: B:837:0x1d97, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:839:0x1da0, code lost:
            if (r0 >= r36.f19143e.s4()) goto L785;
         */
        /* JADX WARN: Code restructure failed: missing block: B:861:0x1e47, code lost:
            if ((r36.f19143e.z0.P0.f57302c.a().getTop() - r36.f19143e.z0.f57261h.f57137a.getBottom()) < (r36.f19143e.z0.P0.f57302c.f19295g.getHeight() + 10)) goto L785;
         */
        /* JADX WARN: Removed duplicated region for block: B:1104:0x26e6  */
        /* JADX WARN: Removed duplicated region for block: B:1105:0x26fb  */
        /* JADX WARN: Removed duplicated region for block: B:1108:0x2734  */
        /* JADX WARN: Removed duplicated region for block: B:283:0x0919  */
        /* JADX WARN: Removed duplicated region for block: B:284:0x091e  */
        /* JADX WARN: Removed duplicated region for block: B:287:0x092c  */
        /* JADX WARN: Removed duplicated region for block: B:322:0x09e3  */
        /* JADX WARN: Removed duplicated region for block: B:325:0x09f6  */
        /* JADX WARN: Removed duplicated region for block: B:328:0x0a08  */
        /* JADX WARN: Removed duplicated region for block: B:330:0x0a10  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            d.a.n0.r.s.h hVar;
            d.a.n0.r.s.h hVar2;
            d.a.n0.r.s.h hVar3;
            PbFragment pbFragment;
            int i2;
            boolean z;
            d.a.n0.r.s.h hVar4;
            d.a.n0.r.s.h hVar5;
            d.a.n0.r.s.h hVar6;
            String name;
            int i3;
            boolean z2;
            int fixedNavHeight;
            int i4;
            d.a.n0.r.q.f2 f2Var;
            String[] strArr;
            d.a.o0.e2.h.e C0;
            int i5;
            int i6;
            boolean Z1;
            int i7;
            int i8;
            String name2;
            if (view == null || !PbFragment.this.isAdded()) {
                return;
            }
            if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                if (view == PbFragment.this.z0.F0()) {
                    if (PbFragment.this.m) {
                        return;
                    }
                    if (PbFragment.this.s0.k1(true)) {
                        PbFragment.this.m = true;
                        PbFragment.this.z0.K2();
                    }
                } else if (PbFragment.this.z0.f57261h.g() == null || view != PbFragment.this.z0.f57261h.g().l()) {
                    if (PbFragment.this.z0.f57261h.g() == null || view != PbFragment.this.z0.f57261h.g().d()) {
                        if (view == PbFragment.this.z0.f57261h.f57142f) {
                            if (PbFragment.this.z0.R(PbFragment.this.s0.q0())) {
                                PbFragment.this.k6();
                                return;
                            }
                            PbFragment.this.n = false;
                            PbFragment.this.j = false;
                            d.a.c.e.p.l.x(PbFragment.this.f19058e, PbFragment.this.z0.f57261h.f57142f);
                            PbFragment.this.f19058e.finish();
                        } else if (view != PbFragment.this.z0.n0() && (PbFragment.this.z0.f57261h.g() == null || (view != PbFragment.this.z0.f57261h.g().m() && view != PbFragment.this.z0.f57261h.g().n()))) {
                            if (view == PbFragment.this.z0.v0()) {
                                if (PbFragment.this.s0 != null) {
                                    d.a.n0.l.a.l(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.s0.C0().L().D1().b());
                                }
                            } else if (view != PbFragment.this.z0.f57261h.f57139c) {
                                if (view == PbFragment.this.z0.f57261h.f57140d) {
                                    if (d.a.n0.z0.l.a()) {
                                        return;
                                    }
                                    if (PbFragment.this.s0 != null && PbFragment.this.s0.C0() != null) {
                                        ArrayList<PostData> D = PbFragment.this.s0.C0().D();
                                        if ((D == null || D.size() <= 0) && PbFragment.this.s0.Q0()) {
                                            d.a.c.e.p.l.M(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new StatisticItem("c12378").param("tid", PbFragment.this.s0.S0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", PbFragment.this.s0.getForumId()));
                                        if (!PbFragment.this.z0.x1()) {
                                            PbFragment.this.z0.h2();
                                        }
                                        PbFragment.this.x5();
                                    } else {
                                        d.a.c.e.p.l.M(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (d.a.c.e.p.j.z()) {
                                        PbFragment.this.z0.v2(true);
                                        PbFragment.this.z0.h2();
                                        if (PbFragment.this.m) {
                                            return;
                                        }
                                        PbFragment.this.m = true;
                                        PbFragment.this.z0.l3();
                                        PbFragment.this.k6();
                                        PbFragment.this.z0.J2();
                                        PbFragment.this.s0.Y1(PbFragment.this.x4());
                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.z0.f57261h.g() == null || view != PbFragment.this.z0.f57261h.g().i()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.z0.f57261h.g() != null && view == PbFragment.this.z0.f57261h.g().e()) {
                                            PbFragment.this.z0.f57261h.e();
                                        } else if (view.getId() == R.id.share_num_container) {
                                            if (!PbFragment.this.Y3(11009)) {
                                                return;
                                            }
                                            PbFragment.this.Z4(3);
                                        } else if (view.getId() != R.id.pb_editor_tool_share) {
                                            if (PbFragment.this.z0.f57261h.g() == null || view != PbFragment.this.z0.f57261h.g().k()) {
                                                if (PbFragment.this.z0.f57261h.g() == null || view != PbFragment.this.z0.f57261h.g().r()) {
                                                    if (PbFragment.this.z0.f57261h.g() == null || view != PbFragment.this.z0.f57261h.g().q()) {
                                                        if (PbFragment.this.z0.f57261h.g() == null || view != PbFragment.this.z0.f57261h.g().o()) {
                                                            if (PbFragment.this.z0.y0() == view) {
                                                                if (PbFragment.this.z0.y0().getIndicateStatus()) {
                                                                    d.a.o0.e2.h.e C02 = PbFragment.this.s0.C0();
                                                                    if (C02 != null && C02.L() != null && C02.L().q1() != null) {
                                                                        String d2 = C02.L().q1().d();
                                                                        if (StringUtils.isNull(d2)) {
                                                                            d2 = C02.L().q1().f();
                                                                        }
                                                                        TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d2));
                                                                    }
                                                                } else {
                                                                    d.a.o0.e3.j0.a.d("c10725", null);
                                                                }
                                                                PbFragment.this.S4();
                                                            } else if (PbFragment.this.z0.f57261h.g() == null || view != PbFragment.this.z0.f57261h.g().h()) {
                                                                if (PbFragment.this.z0.f57261h.g() != null && view == PbFragment.this.z0.f57261h.g().f()) {
                                                                    if (d.a.c.e.p.j.z()) {
                                                                        SparseArray<Object> C03 = PbFragment.this.z0.C0(PbFragment.this.s0.C0(), PbFragment.this.s0.Q0(), 1);
                                                                        if (C03 != null) {
                                                                            if (StringUtils.isNull((String) C03.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.z0.Q1(((Integer) C03.get(R.id.tag_del_post_type)).intValue(), (String) C03.get(R.id.tag_del_post_id), ((Integer) C03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) C03.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.z0.R1(((Integer) C03.get(R.id.tag_del_post_type)).intValue(), (String) C03.get(R.id.tag_del_post_id), ((Integer) C03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) C03.get(R.id.tag_del_post_is_self)).booleanValue(), (String) C03.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.z0.f57261h.e();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.s0 == null) {
                                                                            return;
                                                                        }
                                                                        StatisticItem statisticItem2 = new StatisticItem("c13398");
                                                                        statisticItem2.param("tid", PbFragment.this.s0.S0());
                                                                        statisticItem2.param("fid", PbFragment.this.s0.getForumId());
                                                                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        statisticItem2.param("obj_locate", 5);
                                                                        TiebaStatic.log(statisticItem2);
                                                                        if (view.getId() == R.id.pb_post_reply_count && !DialogLoginHelper.checkUpIsLogin(new d.a.n0.r.q.r0(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                                                            PbFragment.this.V = view;
                                                                            return;
                                                                        } else if (!PbFragment.this.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
                                                                            return;
                                                                        } else {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (!(sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData)) {
                                                                                return;
                                                                            }
                                                                            PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                            StatisticItem statisticItem3 = postData.j0;
                                                                            if (statisticItem3 != null) {
                                                                                StatisticItem copy = statisticItem3.copy();
                                                                                copy.delete("obj_locate");
                                                                                copy.param("obj_locate", 8);
                                                                                TiebaStatic.log(copy);
                                                                            }
                                                                            if (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null) {
                                                                                return;
                                                                            }
                                                                            String S0 = PbFragment.this.s0.S0();
                                                                            String E = postData.E();
                                                                            int S = PbFragment.this.s0.C0() != null ? PbFragment.this.s0.C0().S() : 0;
                                                                            PbActivity.e A5 = PbFragment.this.A5(E);
                                                                            if (A5 == null) {
                                                                                return;
                                                                            }
                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(S0, E, "pb", true, null, false, null, S, postData.O(), PbFragment.this.s0.C0().d(), false, postData.t().getIconInfo()).addBigImageData(A5.f19014a, A5.f19015b, A5.f19020g, A5.j);
                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.s0.B0());
                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.s0.getFromForumId());
                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.s0.getForumId());
                                                                            addBigImageData.setBjhData(PbFragment.this.s0.X());
                                                                            if (PbFragment.this.s0.C0().o() != null) {
                                                                                addBigImageData.setHasForumRule(PbFragment.this.s0.C0().o().has_forum_rule.intValue());
                                                                            }
                                                                            if (PbFragment.this.s0.C0().R() != null) {
                                                                                addBigImageData.setIsManager(PbFragment.this.s0.C0().R().getIs_manager());
                                                                            }
                                                                            if (PbFragment.this.s0.C0().l().getDeletedReasonInfo() != null) {
                                                                                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.s0.C0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.s0.C0().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                            }
                                                                            if (PbFragment.this.s0.C0().l() != null) {
                                                                                addBigImageData.setForumHeadUrl(PbFragment.this.s0.C0().l().getImage_url());
                                                                                addBigImageData.setUserLevel(PbFragment.this.s0.C0().l().getUser_level());
                                                                            }
                                                                            if (PbFragment.this.z0 != null) {
                                                                                addBigImageData.setMainPostMaskVisibly(PbFragment.this.z0.t0(PbFragment.this.s0.I, PbFragment.this.s0.Q0()).S || postData.S);
                                                                            }
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                        if (PbFragment.this.s0 == null) {
                                                                            return;
                                                                        }
                                                                        if (view.getId() == R.id.pb_post_reply) {
                                                                            StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                                            statisticItem4.param("tid", PbFragment.this.s0.S0());
                                                                            statisticItem4.param("fid", PbFragment.this.s0.getForumId());
                                                                            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            statisticItem4.param("obj_locate", 6);
                                                                            TiebaStatic.log(statisticItem4);
                                                                        }
                                                                        if (view.getId() == R.id.post_info_commont_img) {
                                                                            if (!DialogLoginHelper.checkUpIsLogin(new d.a.n0.r.q.r0(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                PbFragment.this.W = view;
                                                                                return;
                                                                            }
                                                                        } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new d.a.n0.r.q.r0(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                            PbFragment.this.W = view;
                                                                            return;
                                                                        }
                                                                        if (!PbFragment.this.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
                                                                            return;
                                                                        }
                                                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                        if (!(sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData)) {
                                                                            return;
                                                                        }
                                                                        PostData postData2 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                        if (view.getId() == R.id.pb_post_reply && (statisticItem = postData2.j0) != null) {
                                                                            StatisticItem copy2 = statisticItem.copy();
                                                                            copy2.delete("obj_locate");
                                                                            copy2.param("obj_locate", 8);
                                                                            TiebaStatic.log(copy2);
                                                                        } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", PbFragment.this.s0.T0()).param("fid", PbFragment.this.s0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                                                        }
                                                                        if (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || PbFragment.this.N4().I0() == null || postData2.t() == null || postData2.A() == 1) {
                                                                            return;
                                                                        }
                                                                        if (PbFragment.this.N4().J0() != null) {
                                                                            PbFragment.this.N4().J0().c();
                                                                        }
                                                                        if (PbFragment.this.p0 && postData2.M() != null && postData2.M().size() != 0) {
                                                                            PbFragment.this.j6(postData2, true);
                                                                        } else {
                                                                            d.a.o0.e2.h.r rVar = new d.a.o0.e2.h.r();
                                                                            rVar.A(PbFragment.this.s0.C0().l());
                                                                            rVar.E(PbFragment.this.s0.C0().L());
                                                                            rVar.C(postData2);
                                                                            PbFragment.this.N4().I0().I(rVar);
                                                                            PbFragment.this.N4().I0().setPostId(postData2.E());
                                                                            PbFragment.this.p5(view, postData2.t().getUserId(), "", postData2);
                                                                            if (PbFragment.this.O0 != null) {
                                                                                PbFragment.this.z0.o2(PbFragment.this.O0.C());
                                                                            }
                                                                        }
                                                                    } else if (view.getId() != R.id.pb_floor_feedback) {
                                                                        if (view != PbFragment.this.z0.x0()) {
                                                                            if (view == PbFragment.this.z0.f57261h.h()) {
                                                                                PbFragment.this.z0.T2();
                                                                            } else if (PbFragment.this.z0.f57261h.g() != null && view == PbFragment.this.z0.f57261h.g().p()) {
                                                                                PbFragment.this.z0.f57261h.f();
                                                                                PbFragment.this.z0.i3(PbFragment.this.q2);
                                                                            } else {
                                                                                int id = view.getId();
                                                                                if (id == R.id.pb_u9_text_view) {
                                                                                    if (!PbFragment.this.checkUpIsLogin() || (f2Var = (d.a.n0.r.q.f2) view.getTag()) == null || StringUtils.isNull(f2Var.C0())) {
                                                                                        return;
                                                                                    }
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                    UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{f2Var.C0()});
                                                                                } else if (id != R.id.replybtn && id != R.id.cover_reply_content && id != R.id.replybtn_top_right && id != R.id.cover_reply_content_top_right) {
                                                                                    if (id == R.id.pb_act_btn) {
                                                                                        if (PbFragment.this.s0.C0() != null && PbFragment.this.s0.C0().L() != null && PbFragment.this.s0.C0().L().H() != null) {
                                                                                            d.a.n0.l.a.l(PbFragment.this.getActivity(), PbFragment.this.s0.C0().L().H());
                                                                                            if (PbFragment.this.s0.C0().L().G() != 1) {
                                                                                                if (PbFragment.this.s0.C0().L().G() == 2) {
                                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                }
                                                                                            } else {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.lottery_tail) {
                                                                                        if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                            String str = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                            TiebaStatic.log(new StatisticItem("c10912").param("fid", PbFragment.this.s0.C0().m()).param("tid", PbFragment.this.s0.C0().N()).param("lotterytail", StringUtils.string(str, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                            if (PbFragment.this.s0.C0().N().equals(str)) {
                                                                                                PbFragment.this.z0.N2(0);
                                                                                            } else {
                                                                                                PbFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str, (String) null, (String) null, (String) null)));
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.pb_item_tail_content) {
                                                                                        if (ViewHelper.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                            String p = d.a.n0.r.d0.b.j().p("tail_link", "");
                                                                                            if (!StringUtils.isNull(p)) {
                                                                                                TiebaStatic.log("c10056");
                                                                                                d.a.n0.l.a.o(view.getContext(), string, p, true, true, true);
                                                                                            }
                                                                                            PbFragment.this.z0.h2();
                                                                                        }
                                                                                    } else if (id == R.id.join_vote_tv) {
                                                                                        if (view != null) {
                                                                                            d.a.n0.l.a.l(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                            if (PbFragment.this.r4() == 1 && PbFragment.this.s0 != null && PbFragment.this.s0.C0() != null) {
                                                                                                TiebaStatic.log(new StatisticItem("c10397").param("fid", PbFragment.this.s0.C0().m()).param("tid", PbFragment.this.s0.C0().N()).param("uid", currentAccount));
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.look_all_tv) {
                                                                                        if (view != null) {
                                                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                            d.a.n0.l.a.l(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                            if (PbFragment.this.r4() == 1 && PbFragment.this.s0 != null && PbFragment.this.s0.C0() != null) {
                                                                                                TiebaStatic.log(new StatisticItem("c10507").param("fid", PbFragment.this.s0.C0().m()).param("tid", PbFragment.this.s0.C0().N()).param("uid", currentAccount2));
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.manga_prev_btn) {
                                                                                        PbFragment.this.o5();
                                                                                    } else if (id == R.id.manga_next_btn) {
                                                                                        PbFragment.this.l5();
                                                                                    } else if (id == R.id.yule_head_img_img) {
                                                                                        if (PbFragment.this.s0 != null && PbFragment.this.s0.C0() != null && PbFragment.this.s0.C0().y() != null) {
                                                                                            d.a.o0.e2.h.e C04 = PbFragment.this.s0.C0();
                                                                                            TiebaStatic.log(new StatisticItem("c11679").param("fid", C04.m()));
                                                                                            UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{C04.y().b()});
                                                                                        }
                                                                                    } else if (id == R.id.yule_head_img_all_rank) {
                                                                                        if (PbFragment.this.s0 != null && PbFragment.this.s0.C0() != null && PbFragment.this.s0.C0().y() != null) {
                                                                                            d.a.o0.e2.h.e C05 = PbFragment.this.s0.C0();
                                                                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", C05.m()));
                                                                                            UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{C05.y().b()});
                                                                                        }
                                                                                    } else if (id == R.id.tv_pb_reply_more) {
                                                                                        if (PbFragment.this.j1 >= 0) {
                                                                                            if (PbFragment.this.s0 != null) {
                                                                                                PbFragment.this.s0.G1();
                                                                                            }
                                                                                            if (PbFragment.this.s0 == null || PbFragment.this.z0.l0() == null) {
                                                                                                i4 = 0;
                                                                                            } else {
                                                                                                i4 = 0;
                                                                                                PbFragment.this.z0.l0().Z(PbFragment.this.s0.C0(), false);
                                                                                            }
                                                                                            PbFragment.this.j1 = i4;
                                                                                            if (PbFragment.this.s0 != null) {
                                                                                                PbFragment.this.z0.B0().setSelection(PbFragment.this.s0.v0());
                                                                                                PbFragment.this.s0.K1(0, 0);
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.qq_share_container) {
                                                                                        if (!PbFragment.this.Y3(11009)) {
                                                                                            return;
                                                                                        }
                                                                                        PbFragment.this.Z4(8);
                                                                                    } else if (id == R.id.new_sub_pb_list_richText) {
                                                                                        SparseArray sparseArray4 = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                                                                                        if (sparseArray4 == null) {
                                                                                            return;
                                                                                        }
                                                                                        PbFragment.this.i6(sparseArray4);
                                                                                    } else if (id == R.id.pb_editor_tool_comment_icon) {
                                                                                        if (PbFragment.this.z0.B0() == null || PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null) {
                                                                                            return;
                                                                                        }
                                                                                        int firstVisiblePosition = PbFragment.this.z0.B0().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.z0.B0().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean f0 = PbFragment.this.s0.C0().f0();
                                                                                        boolean z3 = PbFragment.this.z0.K0() != null && PbFragment.this.z0.K0().g();
                                                                                        boolean v1 = PbFragment.this.z0.v1();
                                                                                        boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                        if (!f0 || PbFragment.this.z0.K0() == null || PbFragment.this.z0.K0().c() == null) {
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            int k = ((int) (d.a.c.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.z0.K0().e();
                                                                                            i3 = k;
                                                                                            z4 = firstVisiblePosition == 0 && (top == k || top == PbFragment.this.z0.K0().c().getHeight() - PbFragment.this.z0.K0().e());
                                                                                        }
                                                                                        PbFragment.this.m4(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                        if ((PbFragment.this.s0.C0().L() != null && PbFragment.this.s0.C0().L().b1() <= 0) || (v1 && z4)) {
                                                                                            if (!PbFragment.this.checkUpIsLogin()) {
                                                                                                return;
                                                                                            }
                                                                                            PbFragment.this.z5();
                                                                                            if (PbFragment.this.s0.C0().L().T() != null) {
                                                                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.s0.f19254e).param("fid", PbFragment.this.s0.C0().m()).param("obj_locate", 2).param("uid", PbFragment.this.s0.C0().L().T().getUserId()));
                                                                                            }
                                                                                        } else {
                                                                                            int i9 = (int) (d.a.c.e.p.l.i(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (f0) {
                                                                                                if (PbFragment.this.z0.P0 != null && PbFragment.this.z0.P0.f57302c != null && PbFragment.this.z0.P0.f57302c.a() != null) {
                                                                                                    if (PbFragment.this.z0.P0.f57302c.a().getParent() != null) {
                                                                                                    }
                                                                                                }
                                                                                                z2 = false;
                                                                                            } else {
                                                                                                if (PbFragment.this.z0.H0() != null) {
                                                                                                    z2 = PbFragment.this.z0.H0().getVisibility() == 0;
                                                                                                    if (!z2 && PbFragment.this.z0.P0 != null && PbFragment.this.z0.P0.f57302c != null && PbFragment.this.z0.P0.f57302c.a() != null && PbFragment.this.z0.P0.f57302c.a().getParent() != null && PbFragment.this.z0.f57261h != null && PbFragment.this.z0.f57261h.f57137a != null) {
                                                                                                    }
                                                                                                }
                                                                                                z2 = false;
                                                                                            }
                                                                                            if (z2 || v1) {
                                                                                                PbFragment.this.i0 = firstVisiblePosition;
                                                                                                PbFragment.this.j0 = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i9))) {
                                                                                                    PbFragment.this.z0.B0().setSelectionFromTop(0, i3 - i9);
                                                                                                    PbFragment.this.z0.B0().smoothScrollBy(-i9, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.z0.B0().E(0, i3, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.i0 > 0) {
                                                                                                if (PbFragment.this.z0.B0().getChildAt(PbFragment.this.i0) != null) {
                                                                                                    PbFragment.this.z0.B0().E(PbFragment.this.i0, PbFragment.this.j0, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.z0.B0().setSelectionFromTop(PbFragment.this.i0, PbFragment.this.j0 + i9);
                                                                                                    PbFragment.this.z0.B0().smoothScrollBy(i9, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int s4 = PbFragment.this.s4();
                                                                                                if (PbFragment.this.v4() != -1) {
                                                                                                    s4--;
                                                                                                }
                                                                                                int g2 = d.a.c.e.p.l.g(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (s4 < 0) {
                                                                                                    s4 = (ListUtils.getCount(PbFragment.this.z0.B0().getData()) - 1) + PbFragment.this.z0.B0().getHeaderViewsCount();
                                                                                                    g2 = 0;
                                                                                                }
                                                                                                if (!z3) {
                                                                                                    if (!f0 || PbFragment.this.z0.K0() == null) {
                                                                                                        if (PbFragment.this.z0.f57261h != null && PbFragment.this.z0.f57261h.f57137a != null) {
                                                                                                            fixedNavHeight = PbFragment.this.z0.f57261h.f57137a.getFixedNavHeight() - 10;
                                                                                                        }
                                                                                                        if (PbFragment.this.z0.P0 != null || PbFragment.this.z0.P0.f57302c == null || PbFragment.this.z0.P0.f57302c.a() == null || PbFragment.this.z0.P0.f57302c.a().getParent() == null) {
                                                                                                            PbFragment.this.z0.B0().setSelectionFromTop(s4, g2 + i9);
                                                                                                            PbFragment.this.z0.B0().smoothScrollBy(i9, 500);
                                                                                                        } else if (!z3) {
                                                                                                            PbFragment.this.z0.B0().E(s4, g2, 200);
                                                                                                        } else {
                                                                                                            PbFragment.this.z0.B0().smoothScrollBy(PbFragment.this.z0.P0.f57302c.a().getTop() - ((int) (d.a.c.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                        }
                                                                                                    } else {
                                                                                                        fixedNavHeight = PbFragment.this.z0.K0().d();
                                                                                                    }
                                                                                                } else {
                                                                                                    fixedNavHeight = (int) (d.a.c.e.p.l.k(PbFragment.this.getContext()) * 0.5625d);
                                                                                                }
                                                                                                g2 += fixedNavHeight;
                                                                                                if (PbFragment.this.z0.P0 != null) {
                                                                                                }
                                                                                                PbFragment.this.z0.B0().setSelectionFromTop(s4, g2 + i9);
                                                                                                PbFragment.this.z0.B0().smoothScrollBy(i9, 500);
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.s0.C0().L() != null && PbFragment.this.s0.C0().L().T() != null) {
                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.s0.f19254e).param("fid", PbFragment.this.s0.C0().m()).param("obj_locate", 2).param("uid", PbFragment.this.s0.C0().L().T().getUserId()));
                                                                                        }
                                                                                    } else if (id == R.id.pb_nav_title_forum_image || id == R.id.pb_nav_title_forum_name) {
                                                                                        if (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || PbFragment.this.s0.C0().l() == null || d.a.c.e.p.k.isEmpty(PbFragment.this.s0.C0().l().getName())) {
                                                                                            return;
                                                                                        }
                                                                                        if (PbFragment.this.s0.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.s0.e0()) || PbFragment.this.s0.U() == null) {
                                                                                                PbFragment.this.f19058e.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.s0.U().f56728b;
                                                                                        } else {
                                                                                            name = PbFragment.this.s0.C0().l().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.f19058e.finish();
                                                                                            return;
                                                                                        }
                                                                                        String e0 = PbFragment.this.s0.e0();
                                                                                        if (PbFragment.this.s0.i0() && e0 != null && e0.equals(name)) {
                                                                                            PbFragment.this.f19058e.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.s0.C0().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13401");
                                                                                        statisticItem5.param("tid", PbFragment.this.s0.S0());
                                                                                        statisticItem5.param("fid", PbFragment.this.s0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.s0.C0().L() != null) {
                                                                                            statisticItem5.param("nid", PbFragment.this.s0.C0().L().M0());
                                                                                        }
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    } else if (id != R.id.forum_name_text && id != R.id.forum_enter_button_one && id != R.id.forum_enter_button_two && id != R.id.forum_enter_button_three) {
                                                                                        if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                            if (PbFragment.this.s0 == null) {
                                                                                                return;
                                                                                            }
                                                                                            StatisticItem statisticItem6 = new StatisticItem("c13398");
                                                                                            statisticItem6.param("tid", PbFragment.this.s0.S0());
                                                                                            statisticItem6.param("fid", PbFragment.this.s0.getForumId());
                                                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                            statisticItem6.param("obj_locate", 2);
                                                                                            TiebaStatic.log(statisticItem6);
                                                                                        } else if (id == R.id.pb_thread_post_button) {
                                                                                            if (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null) {
                                                                                                return;
                                                                                            }
                                                                                            d.a.o0.e2.h.e C06 = PbFragment.this.s0.C0();
                                                                                            if (PbFragment.this.x0 == null) {
                                                                                                PbFragment pbFragment2 = PbFragment.this;
                                                                                                pbFragment2.x0 = new d.a.o0.e2.h.s(pbFragment2.getPageContext());
                                                                                            }
                                                                                            long f2 = d.a.c.e.m.b.f(C06.N(), 0L);
                                                                                            long f3 = d.a.c.e.m.b.f(C06.m(), 0L);
                                                                                            new StatisticItem("c13446").param("forum_id", f3).eventStat();
                                                                                            PbFragment pbFragment3 = PbFragment.this;
                                                                                            pbFragment3.registerListener(pbFragment3.Z1);
                                                                                            PbFragment.this.x0.a(f2, f3);
                                                                                        } else if (id == R.id.pb_video_thread_smart_app_layout) {
                                                                                            if (view.getTag() instanceof SmartApp) {
                                                                                                SmartApp smartApp = (SmartApp) view.getTag();
                                                                                                if (!d.a.o0.u.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                    if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    d.a.n0.l.a.l(PbFragment.this.getActivity(), smartApp.h5_url);
                                                                                                }
                                                                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", PbFragment.this.s0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", PbFragment.this.s0.S0()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                            }
                                                                                        } else if (id == R.id.id_pb_business_promotion_wrapper) {
                                                                                            if (!(view.getTag() instanceof d.a.n0.r.q.a2)) {
                                                                                                return;
                                                                                            }
                                                                                            d.a.n0.r.q.a2 a2Var = (d.a.n0.r.q.a2) view.getTag();
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(a2Var.i0(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", a2Var.c0()).param("tid", a2Var.o0()).param("thread_type", a2Var.v1()).param(TiebaStatic.Params.IS_ZP, a2Var.H2() ? 1 : 0));
                                                                                        } else if (id == R.id.id_pb_business_promotion_attention) {
                                                                                            if (!(view.getTag() instanceof d.a.n0.r.q.a2) || !PbFragment.this.checkUpIsLogin()) {
                                                                                                return;
                                                                                            }
                                                                                            d.a.n0.r.q.a2 a2Var2 = (d.a.n0.r.q.a2) view.getTag();
                                                                                            if (PbFragment.this.T != null) {
                                                                                                PbFragment.this.T.L(a2Var2.i0(), String.valueOf(a2Var2.c0()));
                                                                                            }
                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", a2Var2.c0()).param("tid", a2Var2.o0()).param("thread_type", a2Var2.v1()).param(TiebaStatic.Params.IS_ZP, a2Var2.H2() ? 1 : 0));
                                                                                        } else if (id == R.id.pb_floor_right_top_feedback || id == R.id.pb_post_op_more) {
                                                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                            statisticItem7.param("tid", PbFragment.this.s0.S0());
                                                                                            statisticItem7.param("fid", PbFragment.this.s0.getForumId());
                                                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                            statisticItem7.param("obj_locate", 7);
                                                                                            TiebaStatic.log(statisticItem7);
                                                                                            PbFragment pbFragment4 = PbFragment.this;
                                                                                            pbFragment4.f19059f = false;
                                                                                            pbFragment4.e4(view);
                                                                                        }
                                                                                    } else if (!(view.getTag() instanceof d.a.n0.r.q.a2)) {
                                                                                        return;
                                                                                    } else {
                                                                                        d.a.n0.r.q.a2 a2Var3 = (d.a.n0.r.q.a2) view.getTag();
                                                                                        if (PbFragment.this.s0.B0() == 3 && PbFragment.this.isSimpleForum() && PbFragment.this.s0.C0() != null && ListUtils.isEmpty(PbFragment.this.s0.C0().p())) {
                                                                                            PbFragment.this.f19058e.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(a2Var3.i0(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg2.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                        }
                                                                                        StatisticItem statisticItem8 = new StatisticItem("c13399");
                                                                                        statisticItem8.param("tid", a2Var3.o0());
                                                                                        statisticItem8.param("fid", a2Var3.c0());
                                                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem8.param("nid", a2Var3.M0());
                                                                                        TiebaStatic.log(statisticItem8);
                                                                                    }
                                                                                } else {
                                                                                    d.a.n0.r.s.h hVar7 = null;
                                                                                    if (!PbFragment.this.checkUpIsLogin()) {
                                                                                        return;
                                                                                    }
                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                    if (view != null && view.getTag() != null) {
                                                                                        SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                        PostData postData3 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                        if (id == R.id.replybtn_top_right || id == R.id.cover_reply_content_top_right) {
                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", PbFragment.this.s0.f19254e));
                                                                                        }
                                                                                        if (PbFragment.this.F0 == null) {
                                                                                            PbFragment pbFragment5 = PbFragment.this;
                                                                                            pbFragment5.F0 = new d.a.n0.r.s.l(pbFragment5.getContext());
                                                                                            PbFragment.this.F0.n(PbFragment.this.T1);
                                                                                        }
                                                                                        ArrayList arrayList = new ArrayList();
                                                                                        PbFragment.this.g5(view);
                                                                                        if (PbFragment.this.g5(view) && PbFragment.this.f1 != null) {
                                                                                            PbFragment.this.f1.t();
                                                                                        }
                                                                                        if (sparseArray5.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                            ((Boolean) sparseArray5.get(R.id.tag_is_subpb)).booleanValue();
                                                                                        }
                                                                                        boolean booleanValue = sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                                        boolean booleanValue2 = sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                                        boolean booleanValue3 = sparseArray5.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                                        boolean booleanValue4 = sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                                        boolean booleanValue5 = sparseArray5.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                                        String str2 = sparseArray5.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray5.get(R.id.tag_forbid_user_post_id) : null;
                                                                                        if (postData3 != null) {
                                                                                            if (postData3.K() != null && postData3.K().toString().length() > 0) {
                                                                                                d.a.n0.r.s.h hVar8 = new d.a.n0.r.s.h(3, PbFragment.this.getString(R.string.copy), PbFragment.this.F0);
                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                sparseArray6.put(R.id.tag_clip_board, postData3);
                                                                                                hVar8.f54037d.setTag(sparseArray6);
                                                                                                arrayList.add(hVar8);
                                                                                            }
                                                                                            PbFragment.this.n2 = postData3;
                                                                                        }
                                                                                        if (PbFragment.this.s0.C0().r()) {
                                                                                            String t = PbFragment.this.s0.C0().t();
                                                                                            if (postData3 != null && !d.a.c.e.p.k.isEmpty(t) && t.equals(postData3.E())) {
                                                                                                z = true;
                                                                                                if (!z) {
                                                                                                    hVar4 = new d.a.n0.r.s.h(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.F0);
                                                                                                } else {
                                                                                                    hVar4 = new d.a.n0.r.s.h(4, PbFragment.this.getString(R.string.mark), PbFragment.this.F0);
                                                                                                }
                                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                                sparseArray7.put(R.id.tag_clip_board, PbFragment.this.n2);
                                                                                                sparseArray7.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                                hVar4.f54037d.setTag(sparseArray7);
                                                                                                arrayList.add(hVar4);
                                                                                                if (PbFragment.this.mIsLogin) {
                                                                                                    if (d.a.o0.e2.k.e.e1.a.h(PbFragment.this.s0) || booleanValue3 || !booleanValue2) {
                                                                                                        if (PbFragment.this.j5(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                            d.a.n0.r.s.h hVar9 = new d.a.n0.r.s.h(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.F0);
                                                                                                            hVar9.f54037d.setTag(str2);
                                                                                                            arrayList.add(hVar9);
                                                                                                        }
                                                                                                    } else {
                                                                                                        d.a.n0.r.s.h hVar10 = new d.a.n0.r.s.h(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.F0);
                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                        sparseArray8.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                                        int i10 = R.id.tag_is_mem;
                                                                                                        sparseArray8.put(i10, sparseArray5.get(i10));
                                                                                                        int i11 = R.id.tag_user_mute_mute_userid;
                                                                                                        sparseArray8.put(i11, sparseArray5.get(i11));
                                                                                                        int i12 = R.id.tag_user_mute_mute_username;
                                                                                                        sparseArray8.put(i12, sparseArray5.get(i12));
                                                                                                        int i13 = R.id.tag_user_mute_mute_nameshow;
                                                                                                        sparseArray8.put(i13, sparseArray5.get(i13));
                                                                                                        int i14 = R.id.tag_user_mute_post_id;
                                                                                                        sparseArray8.put(i14, sparseArray5.get(i14));
                                                                                                        int i15 = R.id.tag_user_mute_thread_id;
                                                                                                        sparseArray8.put(i15, sparseArray5.get(i15));
                                                                                                        int i16 = R.id.tag_del_post_is_self;
                                                                                                        sparseArray8.put(i16, sparseArray5.get(i16));
                                                                                                        int i17 = R.id.tag_del_post_type;
                                                                                                        sparseArray8.put(i17, sparseArray5.get(i17));
                                                                                                        int i18 = R.id.tag_del_post_id;
                                                                                                        sparseArray8.put(i18, sparseArray5.get(i18));
                                                                                                        int i19 = R.id.tag_manage_user_identity;
                                                                                                        sparseArray8.put(i19, sparseArray5.get(i19));
                                                                                                        hVar4.f54037d.setTag(sparseArray8);
                                                                                                        arrayList.add(hVar10);
                                                                                                    }
                                                                                                    if (booleanValue3) {
                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                        sparseArray9.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                                                                                                        int i20 = R.id.tag_manage_user_identity;
                                                                                                        sparseArray9.put(i20, sparseArray5.get(i20));
                                                                                                        int i21 = R.id.tag_forbid_user_name;
                                                                                                        sparseArray9.put(i21, sparseArray5.get(i21));
                                                                                                        int i22 = R.id.tag_forbid_user_name_show;
                                                                                                        sparseArray9.put(i22, sparseArray5.get(i22));
                                                                                                        int i23 = R.id.tag_forbid_user_portrait;
                                                                                                        sparseArray9.put(i23, sparseArray5.get(i23));
                                                                                                        sparseArray9.put(R.id.tag_forbid_user_post_id, str2);
                                                                                                        if (booleanValue4) {
                                                                                                            sparseArray9.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                                            int i24 = R.id.tag_is_mem;
                                                                                                            sparseArray9.put(i24, sparseArray5.get(i24));
                                                                                                            int i25 = R.id.tag_user_mute_mute_userid;
                                                                                                            sparseArray9.put(i25, sparseArray5.get(i25));
                                                                                                            int i26 = R.id.tag_user_mute_mute_username;
                                                                                                            sparseArray9.put(i26, sparseArray5.get(i26));
                                                                                                            int i27 = R.id.tag_user_mute_mute_nameshow;
                                                                                                            sparseArray9.put(i27, sparseArray5.get(i27));
                                                                                                            int i28 = R.id.tag_user_mute_post_id;
                                                                                                            sparseArray9.put(i28, sparseArray5.get(i28));
                                                                                                            int i29 = R.id.tag_user_mute_thread_id;
                                                                                                            sparseArray9.put(i29, sparseArray5.get(i29));
                                                                                                        } else {
                                                                                                            sparseArray9.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                                        }
                                                                                                        if (booleanValue5) {
                                                                                                            sparseArray9.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                                            sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                                                            int i30 = R.id.tag_del_post_id;
                                                                                                            sparseArray9.put(i30, sparseArray5.get(i30));
                                                                                                            int i31 = R.id.tag_del_post_type;
                                                                                                            sparseArray9.put(i31, sparseArray5.get(i31));
                                                                                                            int i32 = R.id.tag_has_sub_post;
                                                                                                            sparseArray9.put(i32, sparseArray5.get(i32));
                                                                                                            hVar7 = new d.a.n0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.F0);
                                                                                                            hVar7.f54037d.setTag(sparseArray9);
                                                                                                        } else {
                                                                                                            sparseArray9.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                                        }
                                                                                                        hVar5 = new d.a.n0.r.s.h(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.F0);
                                                                                                        hVar5.f54037d.setTag(sparseArray9);
                                                                                                    } else if (booleanValue5) {
                                                                                                        SparseArray sparseArray10 = new SparseArray();
                                                                                                        sparseArray10.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                                                                                                        sparseArray10.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                                        sparseArray10.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                                        int i33 = R.id.tag_manage_user_identity;
                                                                                                        sparseArray10.put(i33, sparseArray5.get(i33));
                                                                                                        sparseArray10.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                                                        int i34 = R.id.tag_del_post_id;
                                                                                                        sparseArray10.put(i34, sparseArray5.get(i34));
                                                                                                        int i35 = R.id.tag_del_post_type;
                                                                                                        sparseArray10.put(i35, sparseArray5.get(i35));
                                                                                                        int i36 = R.id.tag_has_sub_post;
                                                                                                        sparseArray10.put(i36, sparseArray5.get(i36));
                                                                                                        if (PbFragment.this.s0.C0().S() == 1002 && !booleanValue) {
                                                                                                            hVar6 = new d.a.n0.r.s.h(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.F0);
                                                                                                        } else {
                                                                                                            hVar6 = new d.a.n0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.F0);
                                                                                                        }
                                                                                                        hVar6.f54037d.setTag(sparseArray10);
                                                                                                        hVar7 = hVar6;
                                                                                                        hVar5 = null;
                                                                                                    } else {
                                                                                                        hVar5 = null;
                                                                                                    }
                                                                                                    if (hVar7 != null) {
                                                                                                        arrayList.add(hVar7);
                                                                                                    }
                                                                                                    if (hVar5 != null) {
                                                                                                        arrayList.add(hVar5);
                                                                                                    }
                                                                                                }
                                                                                                PbFragment.this.F0.k(arrayList);
                                                                                                PbFragment.this.E0 = new d.a.n0.r.s.j(PbFragment.this.getPageContext(), PbFragment.this.F0);
                                                                                                PbFragment.this.E0.l();
                                                                                            }
                                                                                        }
                                                                                        z = false;
                                                                                        if (!z) {
                                                                                        }
                                                                                        SparseArray sparseArray72 = new SparseArray();
                                                                                        sparseArray72.put(R.id.tag_clip_board, PbFragment.this.n2);
                                                                                        sparseArray72.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                        hVar4.f54037d.setTag(sparseArray72);
                                                                                        arrayList.add(hVar4);
                                                                                        if (PbFragment.this.mIsLogin) {
                                                                                        }
                                                                                        PbFragment.this.F0.k(arrayList);
                                                                                        PbFragment.this.E0 = new d.a.n0.r.s.j(PbFragment.this.getPageContext(), PbFragment.this.F0);
                                                                                        PbFragment.this.E0.l();
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), 24008, d.a.c.e.m.b.f(PbFragment.this.s0.C0().m(), 0L), d.a.c.e.m.b.f(PbFragment.this.s0.S0(), 0L), d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.s0.C0().L().U0())));
                                                                        }
                                                                    } else {
                                                                        try {
                                                                            sparseArray = (SparseArray) view.getTag();
                                                                        } catch (ClassCastException e2) {
                                                                            e2.printStackTrace();
                                                                            sparseArray = null;
                                                                        }
                                                                        PostData postData4 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                        if (postData4 == null) {
                                                                            return;
                                                                        }
                                                                        if (PbFragment.this.F0 == null) {
                                                                            PbFragment pbFragment6 = PbFragment.this;
                                                                            pbFragment6.F0 = new d.a.n0.r.s.l(pbFragment6.getContext());
                                                                            PbFragment.this.F0.n(PbFragment.this.T1);
                                                                        }
                                                                        ArrayList arrayList2 = new ArrayList();
                                                                        boolean z5 = PbFragment.this.A().C0() != null && PbFragment.this.A().C0().a0();
                                                                        if (view != null && sparseArray != null) {
                                                                            boolean booleanValue6 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                            boolean booleanValue7 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                            boolean booleanValue8 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                            boolean booleanValue9 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                            boolean booleanValue10 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                            String str3 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                                                                            if (postData4.q() != null) {
                                                                                boolean z6 = postData4.q().hasAgree;
                                                                                int s = postData4.s();
                                                                                if (z6 && s == 5) {
                                                                                    pbFragment = PbFragment.this;
                                                                                    i2 = R.string.action_cancel_dislike;
                                                                                } else {
                                                                                    pbFragment = PbFragment.this;
                                                                                    i2 = R.string.action_dislike;
                                                                                }
                                                                                d.a.n0.r.s.h hVar11 = new d.a.n0.r.s.h(8, pbFragment.getString(i2), PbFragment.this.F0);
                                                                                SparseArray sparseArray11 = new SparseArray();
                                                                                sparseArray11.put(R.id.tag_clip_board, postData4);
                                                                                hVar11.f54037d.setTag(sparseArray11);
                                                                                arrayList2.add(hVar11);
                                                                            }
                                                                            if (PbFragment.this.mIsLogin) {
                                                                                if (d.a.o0.e2.k.e.e1.a.h(PbFragment.this.s0) || booleanValue8 || !booleanValue7) {
                                                                                    if ((PbFragment.this.j5(booleanValue6) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                        d.a.n0.r.s.h hVar12 = new d.a.n0.r.s.h(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.F0);
                                                                                        hVar12.f54037d.setTag(str3);
                                                                                        arrayList2.add(hVar12);
                                                                                    }
                                                                                } else {
                                                                                    d.a.n0.r.s.h hVar13 = new d.a.n0.r.s.h(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.F0);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                    int i37 = R.id.tag_is_mem;
                                                                                    sparseArray12.put(i37, sparseArray.get(i37));
                                                                                    int i38 = R.id.tag_user_mute_mute_userid;
                                                                                    sparseArray12.put(i38, sparseArray.get(i38));
                                                                                    int i39 = R.id.tag_user_mute_mute_username;
                                                                                    sparseArray12.put(i39, sparseArray.get(i39));
                                                                                    int i40 = R.id.tag_user_mute_mute_nameshow;
                                                                                    sparseArray12.put(i40, sparseArray.get(i40));
                                                                                    int i41 = R.id.tag_user_mute_post_id;
                                                                                    sparseArray12.put(i41, sparseArray.get(i41));
                                                                                    int i42 = R.id.tag_user_mute_thread_id;
                                                                                    sparseArray12.put(i42, sparseArray.get(i42));
                                                                                    int i43 = R.id.tag_del_post_is_self;
                                                                                    sparseArray12.put(i43, sparseArray.get(i43));
                                                                                    int i44 = R.id.tag_del_post_type;
                                                                                    sparseArray12.put(i44, sparseArray.get(i44));
                                                                                    int i45 = R.id.tag_del_post_id;
                                                                                    sparseArray12.put(i45, sparseArray.get(i45));
                                                                                    int i46 = R.id.tag_manage_user_identity;
                                                                                    sparseArray12.put(i46, sparseArray.get(i46));
                                                                                    hVar13.f54037d.setTag(sparseArray12);
                                                                                    arrayList2.add(hVar13);
                                                                                }
                                                                                if (booleanValue8) {
                                                                                    SparseArray sparseArray13 = new SparseArray();
                                                                                    sparseArray13.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                                                                                    int i47 = R.id.tag_manage_user_identity;
                                                                                    sparseArray13.put(i47, sparseArray.get(i47));
                                                                                    int i48 = R.id.tag_forbid_user_name;
                                                                                    sparseArray13.put(i48, sparseArray.get(i48));
                                                                                    int i49 = R.id.tag_forbid_user_name_show;
                                                                                    sparseArray13.put(i49, sparseArray.get(i49));
                                                                                    int i50 = R.id.tag_forbid_user_portrait;
                                                                                    sparseArray13.put(i50, sparseArray.get(i50));
                                                                                    sparseArray13.put(R.id.tag_forbid_user_post_id, str3);
                                                                                    if (booleanValue9) {
                                                                                        sparseArray13.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                        int i51 = R.id.tag_is_mem;
                                                                                        sparseArray13.put(i51, sparseArray.get(i51));
                                                                                        int i52 = R.id.tag_user_mute_mute_userid;
                                                                                        sparseArray13.put(i52, sparseArray.get(i52));
                                                                                        int i53 = R.id.tag_user_mute_mute_username;
                                                                                        sparseArray13.put(i53, sparseArray.get(i53));
                                                                                        int i54 = R.id.tag_user_mute_mute_nameshow;
                                                                                        sparseArray13.put(i54, sparseArray.get(i54));
                                                                                        int i55 = R.id.tag_user_mute_post_id;
                                                                                        sparseArray13.put(i55, sparseArray.get(i55));
                                                                                        int i56 = R.id.tag_user_mute_thread_id;
                                                                                        sparseArray13.put(i56, sparseArray.get(i56));
                                                                                    } else {
                                                                                        sparseArray13.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                    }
                                                                                    if (booleanValue10) {
                                                                                        sparseArray13.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                        sparseArray13.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue6));
                                                                                        int i57 = R.id.tag_del_post_id;
                                                                                        sparseArray13.put(i57, sparseArray.get(i57));
                                                                                        int i58 = R.id.tag_del_post_type;
                                                                                        sparseArray13.put(i58, sparseArray.get(i58));
                                                                                        int i59 = R.id.tag_has_sub_post;
                                                                                        sparseArray13.put(i59, sparseArray.get(i59));
                                                                                        hVar2 = new d.a.n0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.F0);
                                                                                        hVar2.f54037d.setTag(sparseArray13);
                                                                                    } else {
                                                                                        sparseArray13.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                        hVar2 = null;
                                                                                    }
                                                                                    hVar = new d.a.n0.r.s.h(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.F0);
                                                                                    hVar.f54037d.setTag(sparseArray13);
                                                                                } else if (booleanValue10) {
                                                                                    SparseArray sparseArray14 = new SparseArray();
                                                                                    sparseArray14.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                                                                                    sparseArray14.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                    sparseArray14.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                    int i60 = R.id.tag_manage_user_identity;
                                                                                    sparseArray14.put(i60, sparseArray.get(i60));
                                                                                    sparseArray14.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue6));
                                                                                    int i61 = R.id.tag_del_post_id;
                                                                                    sparseArray14.put(i61, sparseArray.get(i61));
                                                                                    int i62 = R.id.tag_del_post_type;
                                                                                    sparseArray14.put(i62, sparseArray.get(i62));
                                                                                    int i63 = R.id.tag_has_sub_post;
                                                                                    sparseArray14.put(i63, sparseArray.get(i63));
                                                                                    if (PbFragment.this.s0.C0().S() == 1002 && !booleanValue6) {
                                                                                        hVar3 = new d.a.n0.r.s.h(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.F0);
                                                                                    } else {
                                                                                        hVar3 = new d.a.n0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.F0);
                                                                                    }
                                                                                    hVar3.f54037d.setTag(sparseArray14);
                                                                                    hVar2 = hVar3;
                                                                                    hVar = null;
                                                                                } else {
                                                                                    hVar = null;
                                                                                    hVar2 = null;
                                                                                }
                                                                                if (hVar2 != null) {
                                                                                    arrayList2.add(hVar2);
                                                                                }
                                                                                if (hVar != null) {
                                                                                    arrayList2.add(hVar);
                                                                                }
                                                                            }
                                                                            PbFragment.this.F0.k(arrayList2);
                                                                            PbFragment.this.E0 = new d.a.n0.r.s.j(PbFragment.this.getPageContext(), PbFragment.this.F0);
                                                                            PbFragment.this.E0.l();
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                                        statisticItem9.param("tid", PbFragment.this.s0.S0());
                                                                        statisticItem9.param("fid", PbFragment.this.s0.getForumId());
                                                                        statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        statisticItem9.param("obj_locate", 4);
                                                                        TiebaStatic.log(statisticItem9);
                                                                    }
                                                                    if (view.getId() == R.id.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new d.a.n0.r.q.r0(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                                                        PbFragment.this.V = view;
                                                                        return;
                                                                    } else if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null) {
                                                                            return;
                                                                        }
                                                                        PbFragment.this.z0.a0();
                                                                        SparseArray sparseArray15 = (SparseArray) view.getTag();
                                                                        PostData postData5 = (PostData) sparseArray15.get(R.id.tag_load_sub_data);
                                                                        PostData postData6 = (PostData) sparseArray15.get(R.id.tag_load_sub_reply_data);
                                                                        View view2 = (View) sparseArray15.get(R.id.tag_load_sub_view);
                                                                        if (postData5 == null || view2 == null) {
                                                                            return;
                                                                        }
                                                                        if (postData5.C() == 1) {
                                                                            TiebaStatic.log(new StatisticItem("c12630"));
                                                                        }
                                                                        StatisticItem statisticItem10 = postData5.j0;
                                                                        if (statisticItem10 != null) {
                                                                            StatisticItem copy3 = statisticItem10.copy();
                                                                            copy3.delete("obj_locate");
                                                                            if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                copy3.param("obj_locate", 6);
                                                                            } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                copy3.param("obj_locate", 8);
                                                                            }
                                                                            TiebaStatic.log(copy3);
                                                                        }
                                                                        String S02 = PbFragment.this.s0.S0();
                                                                        String E2 = postData5.E();
                                                                        String E3 = postData6 != null ? postData6.E() : "";
                                                                        int S2 = PbFragment.this.s0.C0() != null ? PbFragment.this.s0.C0().S() : 0;
                                                                        PbFragment.this.k6();
                                                                        if (view.getId() == R.id.replybtn) {
                                                                            PbActivity.e A52 = PbFragment.this.A5(E2);
                                                                            if (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || A52 == null) {
                                                                                return;
                                                                            }
                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(S02, E2, "pb", true, null, true, null, S2, postData5.O(), PbFragment.this.s0.C0().d(), false, postData5.t().getIconInfo()).addBigImageData(A52.f19014a, A52.f19015b, A52.f19020g, A52.j);
                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.s0.B0());
                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.s0.getFromForumId());
                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.s0.getForumId());
                                                                            addBigImageData2.setBjhData(PbFragment.this.s0.X());
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                        } else {
                                                                            TiebaStatic.log("c11742");
                                                                            PbActivity.e A53 = PbFragment.this.A5(E2);
                                                                            if (postData5 == null || PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || A53 == null) {
                                                                                return;
                                                                            }
                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(S02, E2, "pb", true, null, false, E3, S2, postData5.O(), PbFragment.this.s0.C0().d(), false, postData5.t().getIconInfo()).addBigImageData(A53.f19014a, A53.f19015b, A53.f19020g, A53.j);
                                                                            if (!d.a.c.e.p.k.isEmpty(E3)) {
                                                                                addBigImageData3.setHighLightPostId(E3);
                                                                                addBigImageData3.setKeyIsUseSpid(true);
                                                                            }
                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.s0.getForumId());
                                                                            addBigImageData3.setBjhData(PbFragment.this.s0.X());
                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.s0.B0());
                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.s0.getFromForumId());
                                                                            if (PbFragment.this.z0 != null) {
                                                                                addBigImageData3.setMainPostMaskVisibly(PbFragment.this.z0.t0(PbFragment.this.s0.I, PbFragment.this.s0.Q0()).S || postData5.S);
                                                                            }
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                        }
                                                                    } else {
                                                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", PbFragment.this.s0.C0().m()));
                                                                        return;
                                                                    }
                                                                }
                                                            } else if (d.a.c.e.p.j.z()) {
                                                                PbFragment.this.z0.a0();
                                                                SparseArray<Object> C07 = PbFragment.this.z0.C0(PbFragment.this.s0.C0(), PbFragment.this.s0.Q0(), 1);
                                                                if (C07 == null) {
                                                                    return;
                                                                }
                                                                PbFragment.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.s0.C0().l().getId(), PbFragment.this.s0.C0().l().getName(), PbFragment.this.s0.C0().L().o0(), String.valueOf(PbFragment.this.s0.C0().R().getUserId()), (String) C07.get(R.id.tag_forbid_user_name), (String) C07.get(R.id.tag_forbid_user_name_show), (String) C07.get(R.id.tag_forbid_user_post_id), (String) C07.get(R.id.tag_forbid_user_portrait))));
                                                            } else {
                                                                PbFragment.this.showToast(R.string.network_not_available);
                                                                return;
                                                            }
                                                        } else {
                                                            int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                            if (skinType == 1) {
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                                            }
                                                            PbFragment.this.z0.f57261h.f();
                                                        }
                                                    } else if (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || PbFragment.this.s0.C0().L() == null) {
                                                        return;
                                                    } else {
                                                        PbFragment.this.z0.f57261h.e();
                                                        TiebaStatic.log(new StatisticItem("c13062"));
                                                        PbFragment pbFragment7 = PbFragment.this;
                                                        pbFragment7.V4(pbFragment7.s0.C0().L().f0());
                                                    }
                                                } else {
                                                    PbFragment.this.z0.a0();
                                                    if (d.a.c.e.p.j.z()) {
                                                        if (PbFragment.this.m) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.s0.O0()));
                                                            return;
                                                        }
                                                        PbFragment.this.k6();
                                                        PbFragment.this.z0.J2();
                                                        d.a.n0.r.s.j jVar = new d.a.n0.r.s.j(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.s0.C0().f56738f == null || PbFragment.this.s0.C0().f56738f.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            strArr = new String[PbFragment.this.s0.C0().f56738f.size()];
                                                            for (int i64 = 0; i64 < PbFragment.this.s0.C0().f56738f.size(); i64++) {
                                                                strArr[i64] = PbFragment.this.s0.C0().f56738f.get(i64).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                            }
                                                        }
                                                        jVar.i(null, strArr, new a(jVar, view));
                                                        jVar.l();
                                                    } else {
                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                        return;
                                                    }
                                                }
                                            } else {
                                                PbFragment.this.z0.a0();
                                                if (PbFragment.this.A().C0().f56739g != 2) {
                                                    if (PbFragment.this.s0.A0() != null) {
                                                        PbFragment.this.z0.n3(PbFragment.this.s0.A0(), PbFragment.this.S1);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (!(ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) || (C0 = PbFragment.this.s0.C0()) == null) {
                                            return;
                                        } else {
                                            d.a.n0.r.q.a2 L = C0.L();
                                            if (L != null && L.T() != null) {
                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.s0.f19254e).param("fid", C0.m()).param("obj_locate", 4).param("uid", L.T().getUserId()));
                                            }
                                            if (L != null) {
                                                if (L.R1()) {
                                                    i5 = 2;
                                                } else if (L.U1()) {
                                                    i5 = 3;
                                                } else if (L.S1()) {
                                                    i5 = 4;
                                                } else if (L.T1()) {
                                                    i5 = 5;
                                                }
                                                StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                statisticItem11.param("tid", PbFragment.this.s0.S0());
                                                statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem11.param("fid", PbFragment.this.s0.getForumId());
                                                if (view.getId() != R.id.share_num_container) {
                                                    statisticItem11.param("obj_locate", 5);
                                                } else {
                                                    statisticItem11.param("obj_locate", 6);
                                                }
                                                statisticItem11.param("obj_name", i5);
                                                statisticItem11.param("obj_type", 1);
                                                if (L != null) {
                                                    if (L.R1()) {
                                                        statisticItem11.param("obj_type", 10);
                                                    } else if (L.U1()) {
                                                        statisticItem11.param("obj_type", 9);
                                                    } else if (L.T1()) {
                                                        statisticItem11.param("obj_type", 8);
                                                    } else if (L.S1()) {
                                                        statisticItem11.param("obj_type", 7);
                                                    } else if (L.u1) {
                                                        statisticItem11.param("obj_type", 6);
                                                    } else {
                                                        int i65 = L.Z;
                                                        if (i65 == 0) {
                                                            statisticItem11.param("obj_type", 1);
                                                        } else if (i65 == 40) {
                                                            statisticItem11.param("obj_type", 2);
                                                        } else if (i65 == 49) {
                                                            statisticItem11.param("obj_type", 3);
                                                        } else if (i65 == 54) {
                                                            statisticItem11.param("obj_type", 4);
                                                        } else {
                                                            statisticItem11.param("obj_type", 5);
                                                        }
                                                    }
                                                    statisticItem11.param("card_type", L.W0());
                                                    statisticItem11.param("recom_source", L.T0);
                                                    statisticItem11.param("ab_tag", L.V0);
                                                    statisticItem11.param("weight", L.U0);
                                                    statisticItem11.param("extra", L.W0);
                                                    statisticItem11.param("nid", L.M0());
                                                    if (L.V() != null && !d.a.c.e.p.k.isEmpty(L.V().oriUgcVid)) {
                                                        statisticItem11.param(TiebaStatic.Params.OBJ_PARAM6, L.V().oriUgcVid);
                                                    }
                                                }
                                                if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    statisticItem11.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.B() != null) {
                                                    d.a.n0.j0.c.e(PbFragment.this.B(), statisticItem11);
                                                }
                                                TiebaStatic.log(statisticItem11);
                                                if (d.a.c.e.p.l.D()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (C0 != null) {
                                                    ArrayList<PostData> D2 = PbFragment.this.s0.C0().D();
                                                    if ((D2 != null && D2.size() > 0) || !PbFragment.this.s0.Q0()) {
                                                        PbFragment.this.z0.a0();
                                                        PbFragment.this.k6();
                                                        if (C0.y() != null && !StringUtils.isNull(C0.y().a(), true)) {
                                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", PbFragment.this.s0.C0().m()));
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c11939"));
                                                        if (AntiHelper.e(PbFragment.this.getContext(), L)) {
                                                            return;
                                                        }
                                                        if (PbFragment.this.z0 != null) {
                                                            PbFragment.this.z0.c0();
                                                            PbFragment.this.z0.z3(C0);
                                                        }
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.z0.c3();
                                                            PbFragment.this.s0.Z().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                        } else {
                                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                                i6 = 2;
                                                            } else {
                                                                i6 = view.getId() == R.id.share_num_container ? 1 : 6;
                                                            }
                                                            PbFragment.this.e6(i6);
                                                        }
                                                    } else {
                                                        d.a.c.e.p.l.M(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                        return;
                                                    }
                                                } else {
                                                    d.a.c.e.p.l.M(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            i5 = 1;
                                            StatisticItem statisticItem112 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            statisticItem112.param("tid", PbFragment.this.s0.S0());
                                            statisticItem112.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem112.param("fid", PbFragment.this.s0.getForumId());
                                            if (view.getId() != R.id.share_num_container) {
                                            }
                                            statisticItem112.param("obj_name", i5);
                                            statisticItem112.param("obj_type", 1);
                                            if (L != null) {
                                            }
                                            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                            }
                                            if (PbFragment.this.B() != null) {
                                            }
                                            TiebaStatic.log(statisticItem112);
                                            if (d.a.c.e.p.l.D()) {
                                            }
                                        }
                                    } else if (d.a.c.e.p.j.z()) {
                                        PbFragment.this.z0.a0();
                                        if (PbFragment.this.z0.f57261h.g() != null && view == PbFragment.this.z0.f57261h.g().i() && !PbFragment.this.z0.x1()) {
                                            PbFragment.this.z0.h2();
                                        }
                                        if (!PbFragment.this.m) {
                                            PbFragment.this.k6();
                                            PbFragment.this.z0.J2();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                Z1 = PbFragment.this.s0.Z1(true, PbFragment.this.x4());
                                            } else {
                                                Z1 = view.getId() == R.id.reply_title ? PbFragment.this.s0.Z1(false, PbFragment.this.x4()) : PbFragment.this.s0.Y1(PbFragment.this.x4());
                                            }
                                            view.setTag(Boolean.valueOf(Z1));
                                            if (Z1) {
                                                i7 = 1;
                                                PbFragment.this.z0.v2(true);
                                                PbFragment.this.z0.l3();
                                                PbFragment.this.m = true;
                                                PbFragment.this.z0.y2(true);
                                            } else {
                                                i7 = 1;
                                            }
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                        } else {
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        view.setTag(Boolean.FALSE);
                                        return;
                                    }
                                } else if (d.a.c.e.p.j.z()) {
                                    PbFragment.this.z0.a0();
                                    if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new d.a.n0.r.q.r0(PbFragment.this.getActivity(), "pb_shoucang"))) {
                                        if (!PbFragment.this.Y3(11009) || PbFragment.this.s0.V(PbFragment.this.z0.A0()) == null) {
                                            return;
                                        }
                                        PbFragment.this.r5();
                                        if (PbFragment.this.s0.C0() != null && PbFragment.this.s0.C0().L() != null && PbFragment.this.s0.C0().L().T() != null) {
                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.s0.f19254e).param("fid", PbFragment.this.s0.C0().m()).param("obj_locate", 3).param("uid", PbFragment.this.s0.C0().L().T().getUserId()));
                                        }
                                        if (PbFragment.this.s0.C0().L() != null && PbFragment.this.s0.C0().L().T() != null && PbFragment.this.s0.C0().L().T().getUserId() != null && PbFragment.this.u0 != null) {
                                            PbFragment pbFragment8 = PbFragment.this;
                                            int Q4 = pbFragment8.Q4(pbFragment8.s0.C0());
                                            d.a.n0.r.q.a2 L2 = PbFragment.this.s0.C0().L();
                                            if (L2.R1()) {
                                                i8 = 2;
                                            } else if (L2.U1()) {
                                                i8 = 3;
                                            } else if (L2.S1()) {
                                                i8 = 4;
                                            } else {
                                                i8 = L2.T1() ? 5 : 1;
                                            }
                                            TiebaStatic.log(new StatisticItem("c12526").param("tid", PbFragment.this.s0.f19254e).param("obj_locate", 1).param("obj_id", PbFragment.this.s0.C0().L().T().getUserId()).param("obj_type", !PbFragment.this.u0.e()).param("obj_source", Q4).param("obj_param1", i8));
                                        }
                                    } else {
                                        PbFragment.this.X = view;
                                        return;
                                    }
                                } else {
                                    PbFragment.this.showToast(R.string.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbFragment.this.s0.C0() != null && PbFragment.this.s0.C0().L() != null && PbFragment.this.s0.C0().L().D2() && PbFragment.this.s0.C0().L().x1() != null) {
                                    TiebaStatic.log(new StatisticItem("c11922"));
                                }
                                if (PbFragment.this.s0.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.s0.e0()) || PbFragment.this.s0.U() == null) {
                                        PbFragment.this.f19058e.finish();
                                        return;
                                    }
                                    name2 = PbFragment.this.s0.U().f56728b;
                                } else {
                                    name2 = PbFragment.this.s0.C0().l().getName();
                                }
                                if (StringUtils.isNull(name2)) {
                                    PbFragment.this.f19058e.finish();
                                    return;
                                }
                                String e02 = PbFragment.this.s0.e0();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.s0.i0() && e02 != null && e02.equals(name2)) {
                                    PbFragment.this.f19058e.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                }
                            }
                        } else if (d.a.c.e.p.j.z()) {
                            if (PbFragment.this.s0.C0() == null || PbFragment.this.v0.O()) {
                                return;
                            }
                            PbFragment.this.z0.a0();
                            int i66 = (PbFragment.this.z0.f57261h.g() == null || view != PbFragment.this.z0.f57261h.g().n()) ? (PbFragment.this.z0.f57261h.g() == null || view != PbFragment.this.z0.f57261h.g().m()) ? view == PbFragment.this.z0.n0() ? 2 : 0 : PbFragment.this.s0.C0().L().x0() == 1 ? 3 : 6 : PbFragment.this.s0.C0().L().y0() == 1 ? 5 : 4;
                            ForumData l = PbFragment.this.s0.C0().l();
                            String name3 = l.getName();
                            String id2 = l.getId();
                            String o0 = PbFragment.this.s0.C0().L().o0();
                            PbFragment.this.z0.t3();
                            PbFragment.this.v0.S(id2, name3, o0, i66, PbFragment.this.z0.o0());
                        } else {
                            PbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                    } else {
                        PbFragment.this.z0.f57261h.f();
                        if (PbFragment.this.s0 != null) {
                            PbFragment.this.o1.i(PbFragment.this.s0.S0());
                        }
                        if (PbFragment.this.s0 == null || !PbFragment.this.s0.isPrivacy()) {
                            PbFragment.this.o1.c();
                            int i67 = (TbSingleton.getInstance().mCanCallFans || PbFragment.this.A() == null || PbFragment.this.A().C0() == null || PbFragment.this.A().C0().N() == null || !PbFragment.this.A().C0().N().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                            if (PbFragment.this.A() != null && PbFragment.this.A().C0() != null) {
                                PbFragment.this.o1.e(3, i67, PbFragment.this.A().C0().N());
                            }
                        } else {
                            PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                            if (PbFragment.this.A() == null || PbFragment.this.A().C0() == null) {
                                return;
                            }
                            PbFragment.this.o1.e(3, 3, PbFragment.this.A().C0().N());
                            return;
                        }
                    }
                } else if (d.a.c.e.p.j.z()) {
                    PbFragment.this.z0.a0();
                    PbFragment.this.k6();
                    PbFragment.this.z0.J2();
                    PbFragment.this.z0.c3();
                    if (PbFragment.this.z0.H0() != null) {
                        PbFragment.this.z0.H0().setVisibility(8);
                    }
                    PbFragment.this.s0.U1(1);
                    if (PbFragment.this.f19062i != null) {
                        PbFragment.this.f19062i.x();
                    }
                } else {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                    String w4 = PbFragment.this.w4();
                    if (TextUtils.isEmpty(w4)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{w4});
                    return;
                }
                return;
            }
            StatisticItem statisticItem12 = new StatisticItem("c13398");
            statisticItem12.param("tid", PbFragment.this.s0.S0());
            statisticItem12.param("fid", PbFragment.this.s0.getForumId());
            statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem12.param("obj_locate", 1);
            TiebaStatic.log(statisticItem12);
            if (PbFragment.this.A) {
                PbFragment.this.A = false;
                return;
            }
            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
            if (tbRichTextView.getTag() instanceof SparseArray) {
                Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData7 = (PostData) obj;
                    if (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || PbFragment.this.N4().I0() == null || postData7.t() == null || postData7.A() == 1 || !PbFragment.this.checkUpIsLogin()) {
                        return;
                    }
                    if (PbFragment.this.N4().J0() != null) {
                        PbFragment.this.N4().J0().c();
                    }
                    d.a.o0.e2.h.r rVar2 = new d.a.o0.e2.h.r();
                    rVar2.A(PbFragment.this.s0.C0().l());
                    rVar2.E(PbFragment.this.s0.C0().L());
                    rVar2.C(postData7);
                    PbFragment.this.N4().I0().I(rVar2);
                    PbFragment.this.N4().I0().setPostId(postData7.E());
                    PbFragment.this.p5(view, postData7.t().getUserId(), "", postData7);
                    TiebaStatic.log("c11743");
                    d.a.o0.e2.m.a.b(PbFragment.this.s0.C0(), postData7, postData7.i0, 8, 1);
                    if (PbFragment.this.O0 != null) {
                        PbFragment.this.z0.o2(PbFragment.this.O0.C());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19147e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f19148f;

        public p1(MarkData markData, d.a.n0.r.s.a aVar) {
            this.f19147e = markData;
            this.f19148f = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            int[] iArr = new int[2];
            if (PbFragment.this.z0 != null && PbFragment.this.z0.U0() != null) {
                PbFragment.this.z0.U0().getLocationOnScreen(iArr);
            }
            if (iArr[0] > 0) {
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19147e);
                PbFragment.this.f19058e.setResult(-1, intent);
                this.f19148f.dismiss();
                PbFragment.this.l6();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface p2 {
        boolean onBackPressed();
    }

    /* loaded from: classes5.dex */
    public class q implements b.h {
        public q() {
        }

        @Override // d.a.o0.e2.k.e.c1.b.h
        public void a(boolean z) {
            PbFragment.this.N5(z);
            if (PbFragment.this.z0.y0() != null && z) {
                PbFragment.this.z0.o3(false);
            }
            PbFragment.this.z0.K1(z);
        }
    }

    /* loaded from: classes5.dex */
    public class q0 extends CustomMessageListener {
        public q0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || PbFragment.this.s0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.s0.f19254e)) {
                return;
            }
            PbFragment.this.d6((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class q1 implements d.a.c.e.k.c<ImageView> {
        public q1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setTag(null);
                if (d.a.n0.r.k.c().g()) {
                    tbImageView.setAdjustViewBounds(false);
                    tbImageView.setInterceptOnClick(false);
                } else {
                    tbImageView.setDefaultResource(R.drawable.icon_click);
                    tbImageView.setAdjustViewBounds(true);
                    tbImageView.setInterceptOnClick(true);
                }
            }
            return imageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.Z();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
            boolean g2 = d.a.n0.r.k.c().g();
            foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
            if (g2) {
                foreDrawableImageView.setAdjustViewBounds(false);
                foreDrawableImageView.setInterceptOnClick(false);
            } else {
                foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                foreDrawableImageView.setAdjustViewBounds(true);
                foreDrawableImageView.setInterceptOnClick(true);
            }
            return foreDrawableImageView;
        }

        public ImageView h(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.Z();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                foreDrawableImageView.Q();
            }
            return imageView;
        }
    }

    /* loaded from: classes5.dex */
    public interface q2 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public class r implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19153e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19154f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19155g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19156h;

        public r(SparseArray sparseArray, boolean z, String str, String str2) {
            this.f19153e = sparseArray;
            this.f19154f = z;
            this.f19155g = str;
            this.f19156h = str2;
        }

        @Override // d.a.n0.r.s.l.e
        public void onItemClick(d.a.n0.r.s.l lVar, int i2, View view) {
            if (PbFragment.this.E0 != null) {
                PbFragment.this.E0.dismiss();
            }
            if (i2 == 0) {
                PbFragment.this.z0.Q1(((Integer) this.f19153e.get(R.id.tag_del_post_type)).intValue(), (String) this.f19153e.get(R.id.tag_del_post_id), ((Integer) this.f19153e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f19153e.get(R.id.tag_del_post_is_self)).booleanValue());
            } else if (i2 == 1) {
                String str = (String) this.f19153e.get(R.id.tag_user_mute_mute_username);
                String str2 = (String) this.f19153e.get(R.id.tag_user_mute_thread_id);
                String str3 = (String) this.f19153e.get(R.id.tag_user_mute_post_id);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(this.f19154f, this.f19155g, str, str2, str3, 1, this.f19156h, PbFragment.this.c1);
                userMuteAddAndDelCustomMessage.setTag(PbFragment.this.c1);
                PbFragment.this.g6(this.f19154f, userMuteAddAndDelCustomMessage, this.f19156h, str, (String) this.f19153e.get(R.id.tag_user_mute_mute_nameshow));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements d.a.n0.w.w.c {
        public r0() {
        }

        @Override // d.a.n0.w.w.c
        public void a() {
            PbFragment.this.showProgressBar();
        }
    }

    /* loaded from: classes5.dex */
    public class r1 implements d.a.c.e.k.c<GifView> {
        public r1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            gifView.setTag(null);
            if (d.a.n0.r.k.c().g()) {
                gifView.setAdjustViewBounds(false);
                gifView.setInterceptOnClick(false);
            } else {
                gifView.setDefaultResource(R.drawable.icon_click);
                gifView.setAdjustViewBounds(true);
                gifView.setInterceptOnClick(true);
            }
            return gifView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            gifView.setBackgroundDrawable(null);
            gifView.setImageDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            gifView.l0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
            boolean g2 = d.a.n0.r.k.c().g();
            gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
            if (g2) {
                gifView.setAdjustViewBounds(false);
                gifView.setInterceptOnClick(false);
            } else {
                gifView.setDefaultResource(R.drawable.icon_click);
                gifView.setAdjustViewBounds(true);
                gifView.setInterceptOnClick(true);
            }
            return gifView;
        }

        public GifView h(GifView gifView) {
            gifView.q0();
            gifView.l0();
            gifView.setImageDrawable(null);
            gifView.s0();
            gifView.setBackgroundDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            return gifView;
        }
    }

    /* loaded from: classes5.dex */
    public interface r2 {
    }

    /* loaded from: classes5.dex */
    public class s extends CustomMessageListener {
        public s(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f12720c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != PbFragment.this.getUniqueId() || AntiHelper.t(PbFragment.this.getActivity(), updateAttentionMessage.getData().l, PbFragment.A2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().f12718a) {
                    if (PbFragment.this.t4().t() != null && PbFragment.this.t4().t().getGodUserData() != null) {
                        PbFragment.this.t4().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || PbFragment.this.s0.C0().L() == null || PbFragment.this.s0.C0().L().T() == null) {
                        return;
                    }
                    PbFragment.this.s0.C0().L().T().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements NewWriteModel.g {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19162e;

            public a(PostWriteCallBackData postWriteCallBackData) {
                this.f19162e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PbFragment.this.z0 == null || this.f19162e == null) {
                    return;
                }
                PbFragment.this.z0.u3();
                PbFragment.this.z0.V1(this.f19162e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b(s0 s0Var) {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class c implements a.e {
            public c() {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                aVar.dismiss();
                PbFragment.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public s0() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.n0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13268");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.s0.C0() != null) {
                    statisticItem.param("fid", PbFragment.this.s0.C0().m());
                }
                statisticItem.param("tid", PbFragment.this.s0.S0());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
            }
            PbFragment.this.k6();
            PbFragment.this.z0.H2(z, postWriteCallBackData);
            int i2 = -1;
            if (postWriteCallBackData != null) {
                i2 = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            } else {
                str = "";
            }
            boolean z2 = false;
            if (z) {
                PbFragment.this.d6(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbFragment.this.T5(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (PbFragment.this.s0.h0()) {
                        d.a.o0.e2.h.e C0 = PbFragment.this.s0.C0();
                        if (C0 != null && C0.L() != null && C0.L().T() != null && (userId = C0.L().T().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.s0.X1()) {
                            PbFragment.this.z0.J2();
                        }
                    } else if (!PbReplySwitch.getInOn() && PbFragment.this.s0.X1()) {
                        PbFragment.this.z0.J2();
                    }
                } else if (floor != null) {
                    PbFragment.this.z0.l1(PbFragment.this.s0.C0());
                }
                if (PbFragment.this.s0.k0()) {
                    TiebaStatic.log(new StatisticItem("c10369").param("tid", PbFragment.this.s0.S0()));
                }
                if (postWriteCallBackData.getmAdverSegmentData() != null) {
                    d.a.c.e.m.e.a().postDelayed(new a(postWriteCallBackData), 500L);
                }
                PbFragment pbFragment = PbFragment.this;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                pbFragment.U3(z2);
            } else if (i2 == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.O0.B() || PbFragment.this.O0.D()) {
                    PbFragment.this.O0.z(false, postWriteCallBackData);
                }
                PbFragment.this.D0.k(postWriteCallBackData);
            } else if (i2 == 238010) {
                ReplyPrivacyCheckController replyPrivacyCheckController = PbFragment.this.R0;
                if (replyPrivacyCheckController != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(PbFragment.this.getActivity());
                if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.setPositiveButton(R.string.open_now, new c());
                aVar.create(PbFragment.this.getPageContext()).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
            } else if (d.a.o0.o3.a.c(i2) || i0Var != null || i2 == 227001) {
            } else {
                PbFragment.this.S5(i2, antiData, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements d.a.c.e.k.c<View> {
        public s1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            ((PlayVoiceBntNew) view).m();
            return view;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(View view) {
            ((PlayVoiceBntNew) view).l();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public View d() {
            PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
            playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
            playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
            return playVoiceBntNew;
        }

        public View h(View view) {
            ((PlayVoiceBntNew) view).l();
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class t extends d.a.n0.f0.i<TipEvent> {
        public t() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.f0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            if (tipEvent.pageId <= 0 || PbFragment.this.f19058e.getPageId() != tipEvent.pageId) {
                return true;
            }
            DefaultNavigationBarCoverTip.s(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements NewWriteModel.g {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19168e;

            public a(PostWriteCallBackData postWriteCallBackData) {
                this.f19168e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PbFragment.this.z0 == null || this.f19168e == null) {
                    return;
                }
                PbFragment.this.z0.u3();
                PbFragment.this.z0.V1(this.f19168e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b(t0 t0Var) {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class c implements a.e {
            public c() {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                aVar.dismiss();
                PbFragment.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public t0() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.n0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13268");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.s0 != null && PbFragment.this.s0.C0() != null) {
                    statisticItem.param("fid", PbFragment.this.s0.C0().m());
                }
                if (PbFragment.this.s0 != null) {
                    statisticItem.param("tid", PbFragment.this.s0.S0());
                }
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
            }
            if (z) {
                d.a.o0.e2.k.e.v0 v0Var = PbFragment.this.D0;
                if (v0Var != null) {
                    v0Var.d();
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    d.a.n0.s.h.b.a(PbFragment.this.getPageContext(), postWriteCallBackData);
                }
                if (postWriteCallBackData.getmAdverSegmentData() != null) {
                    d.a.c.e.m.e.a().postDelayed(new a(postWriteCallBackData), 500L);
                    return;
                }
                return;
            }
            if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                ReplyPrivacyCheckController replyPrivacyCheckController = PbFragment.this.R0;
                if (replyPrivacyCheckController != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(PbFragment.this.getActivity());
                if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.setPositiveButton(R.string.open_now, new c());
                aVar.create(PbFragment.this.getPageContext()).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
            }
            if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                return;
            }
            PbFragment pbFragment = PbFragment.this;
            if (pbFragment.D0 == null) {
                return;
            }
            if (pbFragment.z0 != null && PbFragment.this.z0.J0() != null && PbFragment.this.z0.J0().b() != null && PbFragment.this.z0.J0().b().v()) {
                PbFragment.this.z0.J0().b().t(postWriteCallBackData);
            }
            PbFragment.this.D0.l(postWriteCallBackData);
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements d.a.c.e.k.c<RelativeLayout> {
        public t1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        public RelativeLayout e(RelativeLayout relativeLayout) {
            return relativeLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            return new RelativeLayout(PbFragment.this.getPageContext().getPageActivity());
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            return relativeLayout;
        }
    }

    /* loaded from: classes5.dex */
    public class u implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f19172e;

        public u(Intent intent) {
            this.f19172e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.o0.e2.k.e.t0 t0Var = PbFragment.this.z0;
            t0Var.M2("@" + this.f19172e.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes5.dex */
    public class u0 extends d.a.c.c.g.a {
        public u0(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView S0;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.f19058e.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                    if (PbFragment.this.z0 == null || (S0 = PbFragment.this.z0.S0()) == null || PbFragment.this.z0.B0() == null) {
                        return;
                    }
                    PbFragment.this.z0.B0().removeHeaderView(S0);
                    return;
                }
                d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements TbRichTextView.x {
        public u1() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            d.a.o0.e2.k.e.i l0;
            int i3;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.z0.H1((TbRichText) view.getTag());
                        TiebaStatic.log(new StatisticItem("c12490"));
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13398");
                statisticItem.param("tid", PbFragment.this.s0.S0());
                statisticItem.param("fid", PbFragment.this.s0.getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_locate", 3);
                statisticItem.param("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(statisticItem);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.s0.I.a0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        int i4 = -1;
                        if (tbRichTextView == null || tbRichTextView.getRichText() == null || tbRichTextView.getRichText().A() == null) {
                            i3 = -1;
                        } else {
                            ArrayList<TbRichTextImageInfo> A = tbRichTextView.getRichText().A();
                            int i5 = 0;
                            int i6 = -1;
                            while (i5 < A.size()) {
                                if (A.get(i5) != null) {
                                    arrayList.add(A.get(i5).B());
                                    if (i6 == i4 && str != null && (str.equals(A.get(i5).B()) || str.equals(A.get(i5).y()) || str.equals(A.get(i5).w()) || str.equals(A.get(i5).x()) || str.equals(A.get(i5).A()))) {
                                        i6 = i5;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = A.get(i5).B();
                                    imageUrlData.originalUrl = A.get(i5).B();
                                    imageUrlData.isLongPic = A.get(i5).E();
                                    concurrentHashMap.put(A.get(i5).B(), imageUrlData);
                                }
                                i5++;
                                i4 = -1;
                            }
                            i3 = i6;
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.p4(rect);
                        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                        bVar.x(arrayList);
                        bVar.B(i3);
                        bVar.C(false);
                        bVar.F(PbFragment.this.s0.N0());
                        bVar.w(concurrentHashMap);
                        bVar.H(true);
                        bVar.K(false);
                        bVar.G(PbFragment.this.f5());
                        bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.s0 != null) {
                            bVar.A(PbFragment.this.s0.getFromForumId());
                            if (PbFragment.this.s0.C0() != null) {
                                bVar.N(PbFragment.this.s0.C0().L());
                            }
                        }
                        ImageViewerConfig v = bVar.v(PbFragment.this.getPageContext().getPageActivity());
                        v.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage(2010000, v));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    PbActivity.e eVar = new PbActivity.e();
                    PbFragment.this.y5(str, i2, eVar);
                    if (eVar.f19021h) {
                        TbRichText r6 = PbFragment.this.r6(str, i2);
                        if (r6 != null && PbFragment.this.k2 >= 0 && PbFragment.this.k2 < r6.y().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a2 = d.a.o0.e2.h.f.a(r6.y().get(PbFragment.this.k2));
                            int i7 = 0;
                            while (true) {
                                if (i7 >= eVar.f19014a.size()) {
                                    break;
                                } else if (eVar.f19014a.get(i7).equals(a2)) {
                                    eVar.j = i7;
                                    arrayList2.add(a2);
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                            if (r6.getPostId() != 0 && (l0 = PbFragment.this.z0.l0()) != null) {
                                ArrayList<d.a.c.k.e.n> r = l0.r();
                                if (ListUtils.getCount(r) > 0) {
                                    Iterator<d.a.c.k.e.n> it = r.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        d.a.c.k.e.n next = it.next();
                                        if ((next instanceof PostData) && r6.getPostId() == d.a.c.e.m.b.f(((PostData) next).E(), 0L)) {
                                            d.a.o0.e2.m.a.b(PbFragment.this.s0.C0(), (PostData) next, ((PostData) next).i0, r6.getPostId() == d.a.c.e.m.b.f(PbFragment.this.s0.d0(), 0L) ? 1 : 8, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.f19015b.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.p4(rect2);
                            ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                            bVar2.x(arrayList2);
                            bVar2.z(eVar.f19016c);
                            bVar2.y(eVar.f19017d);
                            bVar2.O(eVar.f19018e);
                            bVar2.C(eVar.f19020g);
                            bVar2.H(true);
                            bVar2.J(eVar.f19022i);
                            bVar2.F(PbFragment.this.s0.N0());
                            bVar2.w(concurrentHashMap2);
                            bVar2.K(false);
                            bVar2.G(PbFragment.this.f5());
                            bVar2.L(eVar.f19019f);
                            bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.s0 != null) {
                                bVar2.A(PbFragment.this.s0.getFromForumId());
                                if (PbFragment.this.s0.C0() != null) {
                                    bVar2.N(PbFragment.this.s0.C0().L());
                                }
                            }
                            ImageViewerConfig v2 = bVar2.v(PbFragment.this.getPageContext().getPageActivity());
                            v2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage(2010000, v2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(ListUtils.getItem(eVar.f19014a, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!ListUtils.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, eVar.f19015b.get(str3));
                    }
                    ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                    bVar3.x(arrayList3);
                    bVar3.z(eVar.f19016c);
                    bVar3.y(eVar.f19017d);
                    bVar3.O(eVar.f19018e);
                    bVar3.C(eVar.f19020g);
                    bVar3.H(true);
                    bVar3.J(eVar.f19014a.get(0));
                    bVar3.F(PbFragment.this.s0.N0());
                    bVar3.w(concurrentHashMap3);
                    bVar3.K(false);
                    bVar3.G(PbFragment.this.f5());
                    bVar3.L(eVar.f19019f);
                    bVar3.D(false);
                    if (PbFragment.this.s0 != null) {
                        bVar3.A(PbFragment.this.s0.getFromForumId());
                        if (PbFragment.this.s0.C0() != null) {
                            bVar3.N(PbFragment.this.s0.C0().L());
                        }
                    }
                    ImageViewerConfig v3 = bVar3.v(PbFragment.this.getPageContext().getPageActivity());
                    v3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage(2010000, v3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean H = ((TbImageView) view).H();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, H)));
                }
                PbFragment.this.U = view;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements Handler.Callback {
        public v() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 2 && PbFragment.this.s0 != null && PbFragment.this.s0.o0()) {
                PbFragment.this.q5();
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class v0 implements PbModel.g {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19178e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f19179f;

            public a(int i2, int i3) {
                this.f19178e = i2;
                this.f19179f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PbFragment.this.getListView() != null) {
                    PbFragment.this.getListView().setSelectionFromTop(this.f19178e, this.f19179f);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19181e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f19182f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f19183g;

            public b(int i2, boolean z, int i3) {
                this.f19181e = i2;
                this.f19182f = z;
                this.f19183g = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f19181e == -1 || PbFragment.this.getListView() == null) {
                    return;
                }
                if (this.f19182f) {
                    PbFragment.this.z0.O2(this.f19181e, this.f19183g);
                } else {
                    PbFragment.this.z0.O2(this.f19181e - 1, this.f19183g);
                }
            }
        }

        public v0() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            if (d.a.n0.m0.k.d().g()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.r : j;
                if (PbFragment.this.s == 0) {
                    PbFragment.this.s = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                d.a.n0.m0.h hVar = new d.a.n0.m0.h(i2, z, responsedMessage, PbFragment.this.v, PbFragment.this.u, PbFragment.this.s, z2, 0L, 0L, j3);
                PbFragment.this.u = 0L;
                PbFragment.this.v = 0L;
                hVar.c();
                if (z2) {
                    j2 = j3;
                    hVar.B = j2;
                    hVar.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || PbFragment.this.s0.C0().L() == null) {
                    return;
                }
                int v1 = PbFragment.this.s0.C0().L().v1();
                if (v1 == 0 || v1 == 40) {
                    if (!StringHelper.equals(PbFragment.this.O, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                        if (StringHelper.equals(PbFragment.this.O, "from_frs")) {
                            d.a.n0.m0.h hVar2 = new d.a.n0.m0.h();
                            hVar2.a(1000);
                            hVar2.D = j2;
                            hVar2.d(v1);
                            return;
                        }
                        return;
                    }
                    d.a.n0.m0.d dVar = new d.a.n0.m0.d();
                    dVar.F = 1;
                    dVar.a(1005);
                    dVar.D = j2;
                    dVar.d(v1);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.a.o0.e2.h.e eVar) {
            PbFragment.this.z0.l1(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, d.a.o0.e2.h.e eVar, String str, int i5) {
            d.a.n0.w.h m;
            if (!z || eVar == null || eVar.T() != null || ListUtils.getCount(eVar.D()) >= 1) {
                PbFragment.this.l = true;
                PbFragment.this.z0.I2();
                if (eVar == null || !eVar.c0()) {
                    PbFragment pbFragment = PbFragment.this;
                    pbFragment.hideLoadingView(pbFragment.z0.U0());
                }
                PbFragment.this.z0.c1();
                if (PbFragment.this.L || PbFragment.this.z0.x1()) {
                    PbFragment.this.z0.W0();
                } else if (!PbFragment.this.z0.q1()) {
                    PbFragment.this.z0.V2(false);
                }
                if (PbFragment.this.m) {
                    PbFragment.this.m = false;
                }
                if (i5 == 0 && eVar != null) {
                    PbFragment.this.H0 = true;
                }
                if (eVar != null) {
                    PbFragment pbFragment2 = PbFragment.this;
                    pbFragment2.hideNetRefreshView(pbFragment2.z0.U0());
                    PbFragment.this.z0.S2();
                }
                if (z && eVar != null) {
                    d.a.n0.r.q.a2 L = eVar.L();
                    if (L != null && L.C2()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = PbFragment.this;
                        pbFragment3.O5(pbFragment3.N0);
                    }
                    PbFragment.this.z0.J0().l(eVar);
                    PbFragment.this.z0.b3();
                    if (L != null && L.W() != null) {
                        PbFragment.this.p6(L.W());
                    }
                    if (PbFragment.this.O0 != null) {
                        PbFragment.this.z0.o2(PbFragment.this.O0.C());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.R().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.R().getBimg_end_time());
                    if (eVar.D() != null && eVar.D().size() >= 1 && eVar.D().get(0) != null) {
                        PbFragment.this.s0.L1(eVar.D().get(0).E());
                    } else if (eVar.T() != null) {
                        PbFragment.this.s0.L1(eVar.T().E());
                    }
                    if (PbFragment.this.O0 != null) {
                        PbFragment.this.O0.M(eVar.d());
                        PbFragment.this.O0.N(eVar.l(), eVar.R());
                        PbFragment.this.O0.r0(L);
                        PbFragment.this.O0.O(PbFragment.this.s0.g0(), PbFragment.this.s0.S0(), PbFragment.this.s0.d0());
                        if (L != null) {
                            PbFragment.this.O0.h0(L.o2());
                        }
                    }
                    if (PbFragment.this.u0 != null) {
                        PbFragment.this.u0.h(eVar.r());
                    }
                    if (eVar.s() == 1) {
                        PbFragment.this.w = true;
                    } else {
                        PbFragment.this.w = false;
                    }
                    if (eVar.a0()) {
                        PbFragment.this.w = true;
                    }
                    PbFragment.this.z0.p2(PbFragment.this.w);
                    PbFragment.this.z0.e3(eVar, i3, i4, PbFragment.this.s0.Q0(), i5, PbFragment.this.s0.m0());
                    PbFragment.this.z0.q3(eVar, PbFragment.this.s0.Q0());
                    PbFragment.this.z0.w3(PbFragment.this.s0.h0());
                    AntiData d2 = eVar.d();
                    if (d2 != null) {
                        PbFragment.this.D = d2.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.D) && PbFragment.this.O0 != null && PbFragment.this.O0.a() != null && (m = PbFragment.this.O0.a().m(6)) != null && !TextUtils.isEmpty(PbFragment.this.D)) {
                            ((View) m).setOnClickListener(PbFragment.this.z1);
                        }
                    }
                    if (PbFragment.this.J0) {
                        PbFragment.this.J0 = false;
                        int v4 = PbFragment.this.v4();
                        if (!eVar.f0()) {
                            PbFragment.this.z0.P2(v4);
                        } else {
                            d.a.c.e.m.e.a().post(new a(v4, (int) (d.a.c.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)));
                        }
                    }
                    if (!PbFragment.this.a0 && !ListUtils.isEmpty(PbFragment.this.s0.C0().D()) && !PbFragment.this.s0.b1()) {
                        PbFragment.this.a0 = true;
                        PbFragment.this.W3(false);
                    }
                    if (PbFragment.this.K0) {
                        PbFragment.this.K0 = false;
                        int v42 = PbFragment.this.v4();
                        boolean z2 = v42 != -1;
                        if (!z2) {
                            v42 = PbFragment.this.s4();
                        }
                        if (PbFragment.this.z0 != null) {
                            if (!eVar.f0()) {
                                PbFragment.this.z0.P2(v42);
                            } else {
                                d.a.c.e.m.e.a().post(new b(v42, z2, (int) (d.a.c.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)));
                                PbFragment.this.z0.q2(true);
                                PbFragment.this.z0.V2(false);
                            }
                        }
                    } else if (PbFragment.this.L0) {
                        PbFragment.this.L0 = false;
                        PbFragment.this.z0.O2(0, 0);
                    } else {
                        PbFragment.this.z0.a3();
                    }
                    PbFragment.this.s0.j1(eVar.l(), PbFragment.this.D1);
                    PbFragment.this.s0.p1(PbFragment.this.F1);
                    if (PbFragment.this.R0 != null && L != null && L.T() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(L.T());
                        PbFragment.this.R0.setLikeUserData(attentionHostData);
                    }
                } else if (str != null) {
                    if (PbFragment.this.H0 || i5 != 1) {
                        PbFragment.this.showToast(str);
                    } else if (i3 == 3 || i3 == 4 || i3 == 6) {
                        if (i2 == 4) {
                            if (PbFragment.this.s0.U() != null && !StringUtils.isNull(PbFragment.this.s0.U().f56729c)) {
                                PbFragment.this.z0.y3(PbFragment.this.s0.U());
                            } else {
                                PbFragment pbFragment4 = PbFragment.this;
                                pbFragment4.showNetRefreshView(pbFragment4.z0.U0(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                                PbFragment pbFragment5 = PbFragment.this;
                                pbFragment5.setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(pbFragment5.getContext(), R.dimen.ds360));
                            }
                        } else {
                            PbFragment pbFragment6 = PbFragment.this;
                            pbFragment6.showNetRefreshView(pbFragment6.z0.U0(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                            PbFragment pbFragment7 = PbFragment.this;
                            pbFragment7.setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(pbFragment7.getContext(), R.dimen.ds360));
                        }
                        PbFragment.this.z0.W0();
                        PbFragment.this.z0.V0();
                    }
                    if (i2 == 4 || i2 == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.s0.S0());
                            jSONObject.put("fid", PbFragment.this.s0.getForumId());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i2 != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (i2 != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.s0 != null && PbFragment.this.s0.C0() != null) {
                            arrayList = PbFragment.this.s0.C0().D();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                            PbFragment.this.z0.l2(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.f5()) {
                                PbFragment.this.z0.m2(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.z0.m2(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.z0.l1(PbFragment.this.s0.C0());
                        }
                    } else {
                        PbFragment.this.z0.l2("");
                    }
                    PbFragment.this.z0.g0();
                }
                if (eVar != null && eVar.m && PbFragment.this.s == 0) {
                    PbFragment.this.s = System.currentTimeMillis() - PbFragment.this.r;
                }
                if (PbFragment.this.A().Q0() && PbFragment.this.A().C0().w().c() == 0 && !PbFragment.this.A().Z0()) {
                    return;
                }
                PbFragment.this.P0 = true;
                return;
            }
            PbFragment.this.s0.U1(1);
            if (PbFragment.this.f19062i != null) {
                PbFragment.this.f19062i.x();
            }
        }

        public final void d() {
            if (PbFragment.this.s0 == null) {
                return;
            }
            if (PbFragment.this.O0 == null || !PbFragment.this.O0.z) {
                d.a.n0.w.w.d dVar = new d.a.n0.w.w.d();
                PbFragment.this.O5(dVar);
                PbFragment pbFragment = PbFragment.this;
                pbFragment.O0 = (d.a.n0.w.w.e) dVar.a(pbFragment.getContext());
                PbFragment.this.O0.e0(PbFragment.this.f19058e.getPageContext());
                PbFragment.this.O0.n0(PbFragment.this.X1);
                PbFragment.this.O0.o0(PbFragment.this.V0);
                PbFragment.this.O0.F(PbFragment.this.f19058e.getPageContext(), PbFragment.this.f19058e.getIntent() == null ? null : PbFragment.this.f19058e.getIntent().getExtras());
                PbFragment.this.O0.a().C(true);
                PbFragment.this.z0.k2(PbFragment.this.O0.a());
                if (!PbFragment.this.s0.q0()) {
                    PbFragment.this.O0.s(PbFragment.this.s0.S0());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    PbFragment.this.O0.k0(TbSingleton.getInstance().getAdVertiComment());
                } else if (PbFragment.this.s0.a1()) {
                    PbFragment.this.O0.k0(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else if (PbFragment.this.z0 != null) {
                    PbFragment.this.O0.k0(PbFragment.this.z0.M0());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements b.c {
        public v1() {
        }

        @Override // d.a.n0.r.s.b.c
        public void a(d.a.n0.r.s.b bVar, int i2, View view) {
            if (bVar != null) {
                bVar.e();
            }
            PbFragment pbFragment = PbFragment.this;
            PostData postData = pbFragment.n2;
            if (postData != null) {
                if (i2 == 0) {
                    postData.h0(pbFragment.getPageContext().getPageActivity());
                    PbFragment.this.n2 = null;
                } else if (i2 == 1 && pbFragment.checkUpIsLogin()) {
                    PbFragment pbFragment2 = PbFragment.this;
                    pbFragment2.t5(pbFragment2.n2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public w() {
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            if (z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    PbFragment.this.O0.L(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && PbFragment.this.z0 != null && PbFragment.this.z0.J0() != null && PbFragment.this.z0.J0().b() != null) {
                    PbFragment.this.z0.J0().b().D();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = PbFragment.this;
                    pbFragment.I5(pbFragment.U0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 extends CustomMessageListener {
        public w0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.o6();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements b.c {
        public w1() {
        }

        @Override // d.a.n0.r.s.b.c
        public void a(d.a.n0.r.s.b bVar, int i2, View view) {
            if (bVar != null) {
                bVar.e();
            }
            if (PbFragment.this.f1 == null || TextUtils.isEmpty(PbFragment.this.g1)) {
                return;
            }
            if (i2 == 0) {
                if (PbFragment.this.h1 == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbFragment.this.g1));
                } else {
                    d.a aVar = new d.a();
                    aVar.f52600a = PbFragment.this.g1;
                    String str = "";
                    if (PbFragment.this.h1.memeInfo.pck_id.intValue() >= 0) {
                        str = "" + PbFragment.this.h1.memeInfo.pck_id;
                    }
                    aVar.f52601b = str;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                }
            } else if (i2 == 1) {
                if (PbFragment.this.Q0 == null) {
                    PbFragment.this.Q0 = new PermissionJudgePolicy();
                }
                PbFragment.this.Q0.clearRequestPermissionList();
                PbFragment.this.Q0.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (PbFragment.this.Q0.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                    return;
                }
                if (PbFragment.this.e1 == null) {
                    PbFragment pbFragment = PbFragment.this;
                    pbFragment.e1 = new d.a.o0.e2.k.e.x0(pbFragment.getPageContext());
                }
                PbFragment.this.e1.b(PbFragment.this.g1, PbFragment.this.f1.n());
            }
            PbFragment.this.f1 = null;
            PbFragment.this.g1 = null;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements CheckRealNameModel.b {
        public x() {
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i2, String str, String str2, Object obj) {
            PbFragment.this.z0.a1();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i2 == 0) {
                    Integer num = 0;
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    }
                    PbFragment.this.e6(num.intValue());
                } else if (i2 == 1990055) {
                    TiebaStatic.log("c12142");
                    d.a.o0.y0.a.d();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x0 extends HttpMessageListener {
        public x0(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (PbFragment.this.z0 != null) {
                PbFragment pbFragment = PbFragment.this;
                pbFragment.hideLoadingView(pbFragment.z0.U0());
                PbFragment.this.hideProgressBar();
            }
            if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                    int type = privacySettingMessage.getType();
                    if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                        BdTopToast bdTopToast = new BdTopToast(PbFragment.this.getContext());
                        bdTopToast.i(true);
                        bdTopToast.h(PbFragment.this.getString(R.string.block_user_success));
                        bdTopToast.j((ViewGroup) PbFragment.this.getView());
                        PbFragment.this.P5(type);
                        return;
                    }
                    String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PbFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString();
                    BdTopToast bdTopToast2 = new BdTopToast(PbFragment.this.getContext());
                    bdTopToast2.i(false);
                    bdTopToast2.h(string);
                    bdTopToast2.j((ViewGroup) PbFragment.this.getView());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements AdapterView.OnItemClickListener {
        public x1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (PbFragment.this.s0 == null || PbFragment.this.s0.L0() == i2 + 1) {
                return;
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.M5(pbFragment.M4(i2));
        }
    }

    /* loaded from: classes5.dex */
    public class y implements q2 {
        public y() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.q2
        public void a(Object obj) {
            if (!d.a.c.e.p.j.z()) {
                PbFragment.this.showToast(R.string.network_not_available);
                return;
            }
            Object[] objArr = (Object[]) obj;
            PbFragment.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.s0.C0().l().getId(), PbFragment.this.s0.C0().l().getName(), PbFragment.this.s0.C0().L().o0(), String.valueOf(PbFragment.this.s0.C0().R().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
        }
    }

    /* loaded from: classes5.dex */
    public class y0 implements a.InterfaceC1183a {
        public y0() {
        }

        @Override // d.a.n0.h.a.InterfaceC1183a
        public void a(boolean z, boolean z2, String str) {
            PbFragment.this.z0.I2();
            if (z) {
                if (PbFragment.this.u0 != null) {
                    PbFragment.this.u0.h(z2);
                }
                PbFragment.this.s0.W1(z2);
                if (PbFragment.this.s0.o0()) {
                    PbFragment.this.q5();
                } else {
                    PbFragment.this.z0.l1(PbFragment.this.s0.C0());
                }
                if (z2) {
                    if (PbFragment.this.u0 != null) {
                        if (PbFragment.this.u0.f() == null || PbFragment.this.s0 == null || PbFragment.this.s0.C0() == null || PbFragment.this.s0.C0().L() == null || PbFragment.this.s0.C0().L().T() == null) {
                            return;
                        }
                        MarkData f2 = PbFragment.this.u0.f();
                        MetaData T = PbFragment.this.s0.C0().L().T();
                        if (f2 != null && T != null) {
                            if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), T.getUserId()) && !T.hadConcerned()) {
                                PbFragment.this.Z5(T);
                            } else {
                                PbFragment.this.showToast(R.string.add_mark_on_pb);
                                if (d.a.n0.s.h.a.e(PbFragment.this.getContext(), 0)) {
                                    d.a.n0.s.h.a.g(PbFragment.this.getPageContext(), 6, 2000L);
                                }
                            }
                        } else {
                            PbFragment pbFragment = PbFragment.this;
                            pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                        }
                    }
                    PbFragment.this.T3();
                    return;
                }
                PbFragment pbFragment2 = PbFragment.this;
                pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbFragment pbFragment3 = PbFragment.this;
            pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.update_mark_failed));
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements p2 {
        public y1() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.p2
        public boolean onBackPressed() {
            if (PbFragment.this.z0 != null && PbFragment.this.z0.J0() != null) {
                d.a.o0.e2.k.e.u J0 = PbFragment.this.z0.J0();
                if (J0.f()) {
                    J0.d();
                    return true;
                }
            }
            if (PbFragment.this.z0 == null || !PbFragment.this.z0.z1()) {
                return false;
            }
            PbFragment.this.z0.e1();
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class z implements c.a {
        public z() {
        }

        @Override // d.a.o0.e2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.o0.e2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                if (view != null) {
                    if (view.getId() == R.id.richText) {
                        if (PbFragment.this.H5(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.i6((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.z0.s1() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.getEventController() != null && PbFragment.this.getEventController().f57009b != null) {
                                PbFragment.this.getEventController().f57009b.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                        if (sparseArray == null) {
                            return false;
                        }
                        PbFragment.this.i6(sparseArray);
                    }
                }
                if (PbFragment.this.O0 != null) {
                    PbFragment.this.z0.o2(PbFragment.this.O0.C());
                }
                PbFragment.this.z0.h2();
                PbFragment.this.z0.a0();
                return true;
            }
            return true;
        }

        @Override // d.a.o0.e2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.k4();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f19196e;

        public z0(MetaData metaData) {
            this.f19196e = metaData;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f19196e.getUserId()).param("obj_locate", 2));
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements View.OnLongClickListener {
        public z1() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PbFragment pbFragment = PbFragment.this;
            pbFragment.f19059f = true;
            return pbFragment.e4(view);
        }
    }

    public static PbFragment v5() {
        return new PbFragment();
    }

    @Override // d.a.o0.e2.o.i
    public PbModel A() {
        return this.s0;
    }

    public PbInterviewStatusView.f A4() {
        return this.q0;
    }

    public final PbActivity.e A5(String str) {
        String str2 = null;
        if (this.s0.C0() != null && this.s0.C0().D() != null && this.s0.C0().D().size() != 0 && !StringUtils.isNull(str)) {
            PbActivity.e eVar = new PbActivity.e();
            int i3 = 0;
            while (true) {
                if (i3 >= this.s0.C0().D().size()) {
                    i3 = 0;
                    break;
                } else if (str.equals(this.s0.C0().D().get(i3).E())) {
                    break;
                } else {
                    i3++;
                }
            }
            PostData postData = this.s0.C0().D().get(i3);
            if (postData.K() != null && postData.K().y() != null) {
                Iterator<TbRichTextData> it = postData.K().y().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        if (next.B() != null) {
                            str2 = next.B().y();
                        }
                    }
                }
                y5(str2, 0, eVar);
                d.a.o0.e2.h.f.b(postData, eVar);
                return eVar;
            }
        }
        return null;
    }

    @Override // d.a.o0.e2.o.i
    public PbActivity B() {
        return this.f19058e;
    }

    public final boolean B4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.B() == null) {
            return false;
        }
        return tbRichTextData.B().E();
    }

    public final void B5(View view) {
        if (view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.f19059f ? 2 : 3));
        view.setTag(sparseArray);
    }

    @Override // d.a.o0.e2.o.i
    public PbFragment C0() {
        return this;
    }

    public boolean C4() {
        return (!this.f19060g && this.w2 == -1 && this.x2 == -1) ? false : true;
    }

    public void C5(d.a.o0.e2.h.r rVar) {
        String E = rVar.i().E();
        List<PostData> list = this.s0.C0().Q().f56790a;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                break;
            }
            PostData postData = list.get(i3);
            if (postData.E() == null || !postData.E().equals(E)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = rVar.k();
                postData.u0(rVar.m());
                if (postData.M() != null) {
                    postData.M().clear();
                    postData.M().addAll(k3);
                }
            }
        }
        if (this.s0.m0()) {
            return;
        }
        this.z0.l1(this.s0.C0());
    }

    public final boolean D4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.B() == null) {
            return false;
        }
        return tbRichTextData.B().F();
    }

    public void D5(boolean z2, MarkData markData) {
        this.z0.I2();
        this.s0.W1(z2);
        d.a.n0.h.a aVar = this.u0;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.u0.i(markData);
            }
        }
        if (this.s0.o0()) {
            q5();
        } else {
            this.z0.l1(this.s0.C0());
        }
    }

    public boolean E4() {
        return this.M;
    }

    public void E5(d.a.o0.e2.h.r rVar) {
        boolean z2;
        MetaData metaData;
        if (rVar.i() == null) {
            return;
        }
        String E = rVar.i().E();
        ArrayList<PostData> D = this.s0.C0().D();
        int i3 = 0;
        while (true) {
            z2 = true;
            if (i3 >= D.size()) {
                break;
            }
            PostData postData = D.get(i3);
            if (postData.E() == null || !postData.E().equals(E)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = rVar.k();
                postData.u0(rVar.m());
                if (postData.M() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.S() != null && next != null && next.t() != null && (metaData = postData.S().get(next.t().getUserId())) != null) {
                            next.g0(metaData);
                            next.o0(true);
                            next.z0(getPageContext(), this.s0.i1(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k3.size() != postData.M().size();
                    if (postData.M() != null && postData.M().size() < 2) {
                        postData.M().clear();
                        postData.M().addAll(k3);
                    }
                    z2 = z3;
                }
                if (postData.x() != null) {
                    postData.e0();
                }
            }
        }
        if (!this.s0.m0() && z2) {
            this.z0.l1(this.s0.C0());
        }
        if (z2) {
            C5(rVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.b1.m.h
    /* renamed from: F4 */
    public BdListView getListView() {
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        if (t0Var == null) {
            return null;
        }
        return t0Var.B0();
    }

    public final void F5() {
        hideNetRefreshView(this.z0.U0());
        c6();
        if (this.s0.q1()) {
            this.z0.J2();
        }
        this.z0.S2();
    }

    public int G4() {
        return this.x2;
    }

    public void G5(p2 p2Var) {
        List<p2> list;
        if (p2Var == null || (list = this.l1) == null) {
            return;
        }
        list.remove(p2Var);
    }

    public int H4() {
        return this.w2;
    }

    public final boolean H5(View view) {
        PbModel pbModel;
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.w0 && !TextUtils.isEmpty(postData.u()) && d.a.n0.r.k.c().g()) {
                    return u5(postData.E());
                }
                if (checkUpIsLogin() && (pbModel = this.s0) != null && pbModel.C0() != null) {
                    if (N4().J0() != null) {
                        N4().J0().c();
                    }
                    d.a.o0.e2.h.r rVar = new d.a.o0.e2.h.r();
                    rVar.A(this.s0.C0().l());
                    rVar.E(this.s0.C0().L());
                    rVar.C(postData);
                    N4().I0().I(rVar);
                    N4().I0().setPostId(postData.E());
                    p5(view, postData.t().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    d.a.n0.w.w.e eVar = this.O0;
                    if (eVar != null) {
                        this.z0.o2(eVar.C());
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final String I4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.B() == null) {
            return null;
        }
        return tbRichTextData.B().A();
    }

    public final void I5(EmotionImageData emotionImageData) {
        if (emotionImageData == null) {
            return;
        }
        if (this.S == null) {
            d.a.o0.e2.k.e.b1.f.a aVar = new d.a.o0.e2.k.e.b1.f.a(this.f19058e);
            this.S = aVar;
            aVar.n(this.V0);
            this.S.m(this.X1);
        }
        this.S.k(emotionImageData, A(), A().C0());
    }

    public final long J4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.B() == null) {
            return 0L;
        }
        return tbRichTextData.B().getOriginalSize();
    }

    public final void J5() {
        PbModel pbModel = this.s0;
        if (pbModel == null || pbModel.C0() == null || this.s0.C0().L() == null || !this.s0.C0().L().D2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public d.a.n0.w.w.e K4() {
        return this.O0;
    }

    public final void K5(boolean z2, PostData postData) {
        d.a.o0.e2.k.e.t0 t0Var;
        d.a.o0.e2.k.e.i l02;
        ArrayList<PostData> D;
        String str;
        String str2;
        String str3;
        String str4;
        d.a.n0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense == null || !adAdSense.h() || (t0Var = this.z0) == null || (l02 = t0Var.l0()) == null || (D = l02.D()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        Iterator<PostData> it = D.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PostData next = it.next();
            String E = next.E();
            i3++;
            if (z2) {
                if (next == postData) {
                    a.c cVar = new a.c();
                    cVar.f57889b = E;
                    cVar.f57890c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.E == 1 && !TextUtils.isEmpty(E)) {
                next.E = 2;
                a.c cVar2 = new a.c();
                cVar2.f57889b = E;
                cVar2.f57890c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.s0;
            if (pbModel == null || pbModel.C0() == null || this.s0.C0().l() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.s0.C0().l().getFirst_class();
                str2 = this.s0.C0().l().getSecond_class();
                str3 = this.s0.C0().l().getId();
                str4 = this.s0.S0();
                str = first_class;
            }
            d.a.o0.t2.y.v(z2, str, str2, str3, str4, arrayList, adAdSense.j());
        }
    }

    public d.a.o0.e2.k.e.c1.b L4() {
        return this.f19062i;
    }

    public final void L5() {
        PbModel pbModel = this.s0;
        if (pbModel == null || pbModel.C0() == null || this.s0.C0().L() == null || !this.s0.C0().L().D2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public final int M4(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return i3 != 3 ? 1 : 7;
            }
            return 6;
        }
        return 5;
    }

    public final void M5(int i3) {
        if (this.s0 != null) {
            c6();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
            privacySettingMessage.setTid(this.s0.f19254e);
            sendMessage(privacySettingMessage);
        }
    }

    public d.a.o0.e2.k.e.t0 N4() {
        return this.z0;
    }

    public void N5(boolean z2) {
        this.P = z2;
    }

    public d.a.n0.r.q.k1 O4() {
        return this.k0;
    }

    public final void O5(d.a.n0.w.w.g gVar) {
        PbModel pbModel;
        if (gVar == null || (pbModel = this.s0) == null) {
            return;
        }
        gVar.o(pbModel.e0());
        if (this.s0.C0() != null && this.s0.C0().l() != null) {
            gVar.n(this.s0.C0().l());
        }
        gVar.p("pb");
        gVar.q(this.s0);
    }

    public String P4() {
        return this.Y;
    }

    public final void P5(int i3) {
        PbModel pbModel = this.s0;
        if (pbModel == null) {
            return;
        }
        int L0 = pbModel.L0();
        if (i3 == 5) {
            this.s0.T1(2);
        } else if (i3 == 6) {
            this.s0.T1(3);
        } else if (i3 != 7) {
            this.s0.T1(1);
        } else {
            this.s0.T1(4);
        }
        int L02 = this.s0.L0();
        if (L0 == 4 || L02 == 4) {
            w5();
        }
    }

    public final int Q4(d.a.o0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return 0;
        }
        if (eVar.L().v1() == 0) {
            return 1;
        }
        if (eVar.L().v1() == 54) {
            return 2;
        }
        return eVar.L().v1() == 40 ? 3 : 4;
    }

    public void Q5(boolean z2) {
        this.M = z2;
    }

    public void R3(p2 p2Var) {
        if (p2Var != null) {
            if (this.l1 == null) {
                this.l1 = new ArrayList();
            }
            if (this.l1.contains(p2Var)) {
                return;
            }
            this.l1.add(p2Var);
        }
    }

    public String R4() {
        return this.R;
    }

    public final void R5(boolean z2) {
        this.O0.f0(z2);
        this.O0.i0(z2);
        this.O0.p0(z2);
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.r
    public void S(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (d.a.n0.b1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d.a.n0.b1.m.f.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (d.a.o0.e2.k.e.y0.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new d.a.n0.b1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void S3(p2 p2Var) {
        if (p2Var != null) {
            if (this.l1 == null) {
                this.l1 = new ArrayList();
            }
            if (this.l1.contains(p2Var)) {
                return;
            }
            this.l1.add(0, p2Var);
        }
    }

    public void S4() {
        if (this.k) {
            this.Q = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.s0.C0() == null || this.s0.C0().L() == null || this.s0.C0().L().q1() == null) {
        } else {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.s0.C0().L().q1().g(), this.s0.C0().L().q1().f(), this.s0.C0().L().q1().b(), this.s0.C0().L().q1().c(), this.s0.C0().L().y0(), this.s0.C0().L().x0())));
            this.f19058e.finish();
        }
    }

    public final void S5(int i3, AntiData antiData, String str) {
        if (AntiHelper.m(i3, str)) {
            if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new e1()) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        } else if (i3 == 230277) {
            f6(str);
        } else {
            this.z0.r3(str);
        }
    }

    public final void T3() {
        d.a.o0.e2.h.e eVar;
        PbModel pbModel = this.s0;
        if (pbModel == null || (eVar = pbModel.I) == null || eVar.L() == null) {
            return;
        }
        d.a.n0.r.q.a2 L = this.s0.I.L();
        L.V0 = this.s0.H0();
        L.U0 = this.s0.K0();
        L.T0 = this.s0.J0();
        L.W0 = this.s0.I0();
        L.C2 = this.s0.q0();
        if (L.c0() == 0) {
            L.y3(d.a.c.e.m.b.f(this.s0.getForumId(), 0L));
        }
        StatisticItem i3 = d.a.n0.j0.c.i(getContext(), L, "c13562");
        TbPageTag l3 = d.a.n0.j0.c.l(getContext());
        if (l3 != null && "a008".equals(l3.locatePage)) {
            i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
        }
        if (l3 != null && "a002".equals(l3.locatePage)) {
            i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
        }
        if (i3 != null) {
            TiebaStatic.log(i3);
        }
    }

    public final void T4(int i3, Intent intent) {
        d.a.n0.w.n nVar;
        d.a.n0.w.n nVar2;
        if (i3 == 0) {
            this.z0.Y0();
            this.z0.J0().c();
            this.z0.V2(false);
        }
        this.z0.h2();
        if (intent == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
        if (serializableExtra instanceof PbEditorData) {
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
            int editorType = pbEditorData.getEditorType();
            if (editorType != 0) {
                if (editorType != 1 || this.z0.J0() == null || this.z0.J0().b() == null) {
                    return;
                }
                d.a.n0.w.w.h b3 = this.z0.J0().b();
                b3.X(this.s0.C0().L());
                b3.z(writeData);
                b3.Y(pbEditorData.getVoiceModel());
                d.a.n0.w.m n3 = b3.a().n(6);
                if (n3 != null && (nVar2 = n3.k) != null) {
                    nVar2.onAction(new d.a.n0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    b3.D();
                    return;
                }
                return;
            }
            this.O0.S();
            this.O0.t0(pbEditorData.getVoiceModel());
            this.O0.G(writeData);
            d.a.n0.w.m n4 = this.O0.a().n(6);
            if (n4 != null && (nVar = n4.k) != null) {
                nVar.onAction(new d.a.n0.w.a(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i3 == -1) {
                this.O0.L(null, null);
            }
        }
    }

    public final void T5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (N4() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    d.a.n0.s.h.b.a(getPageContext(), postWriteCallBackData);
                    return;
                } else {
                    d.a.o0.e3.q0.g.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.s0.q0()) {
            antiData.setBlock_forum_name(this.s0.C0().l().getName());
            antiData.setBlock_forum_id(this.s0.C0().l().getId());
            antiData.setUser_name(this.s0.C0().R().getUserName());
            antiData.setUser_id(this.s0.C0().R().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void U3(boolean z2) {
        d.a.o0.e2.h.e eVar;
        PbModel pbModel = this.s0;
        if (pbModel == null || (eVar = pbModel.I) == null || eVar.L() == null) {
            return;
        }
        d.a.n0.r.q.a2 L = this.s0.I.L();
        L.V0 = this.s0.H0();
        L.U0 = this.s0.K0();
        L.T0 = this.s0.J0();
        L.W0 = this.s0.I0();
        if (L.c0() == 0) {
            L.y3(d.a.c.e.m.b.f(this.s0.getForumId(), 0L));
        }
        StatisticItem i3 = d.a.n0.j0.c.i(getContext(), L, "c13563");
        TbPageTag l3 = d.a.n0.j0.c.l(getContext());
        if (l3 != null && "a008".equals(l3.locatePage)) {
            i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
        }
        if (l3 != null && "a002".equals(l3.locatePage)) {
            i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
        }
        if (i3 != null) {
            i3.param(TiebaStatic.Params.REPLY_TYPE, 1);
            if (z2) {
                i3.param("obj_type", 2);
            } else {
                i3.param("obj_type", 1);
            }
            d.a.n0.i0.c k3 = TbPageExtraHelper.k(getContext());
            if (k3 != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, k3.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i3);
        }
    }

    public void U4(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
        String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
        String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
        String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
        String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.c1);
        userMuteAddAndDelCustomMessage.setTag(this.c1);
        g6(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public final void U5(long j3, String str, long j4) {
        d.a.o0.e2.k.e.e1.b.j(this, j3, str, j4);
    }

    public final void V3(d.a.o0.e2.h.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar == null || eVar.Q() == null || eVar.Q().f56790a == null || (list = eVar.Q().f56790a) == null || arrayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list.size() <= 0 || arrayList.size() <= 0) {
            return;
        }
        arrayList3.addAll(list);
        Iterator<PostData> it = arrayList.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null) {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    PostData postData = (PostData) it2.next();
                    if (postData != null && !TextUtils.isEmpty(next.E()) && !TextUtils.isEmpty(postData.E()) && next.E().equals(postData.E())) {
                        arrayList2.add(postData);
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            arrayList3.removeAll(arrayList2);
        }
        if (arrayList3.size() > 0) {
            arrayList.addAll(arrayList3);
        }
    }

    public final void V4(String str) {
        PbModel pbModel = this.s0;
        if (pbModel != null && pbModel.C0() != null && this.s0.C0().a0()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.s0.S0(), str);
            d.a.n0.r.q.a2 L = this.s0.C0().L();
            if (L.R1()) {
                format = format + "&channelid=33833";
            } else if (L.W1()) {
                format = format + "&channelid=33842";
            } else if (L.U1()) {
                format = format + "&channelid=33840";
            }
            k5(format);
            return;
        }
        this.t0.i(str);
    }

    public final void V5(SparseArray<Object> sparseArray, int i3, boolean z2) {
        d.a.o0.e2.k.e.e1.a.d(getActivity(), getPageContext(), new j0(sparseArray, i3, z2), new k0());
    }

    public void W3(boolean z2) {
        int v2;
        int v3;
        PostData postData;
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        if (t0Var == null || t0Var.B0() == null) {
            return;
        }
        int firstVisiblePosition = this.z0.B0().getFirstVisiblePosition();
        int lastVisiblePosition = this.z0.B0().getLastVisiblePosition();
        d.a.o0.e2.k.e.i l02 = this.z0.l0();
        if (l02 == null || this.s0.C0() == null) {
            return;
        }
        if (lastVisiblePosition <= l02.v()) {
            v2 = 0;
            v3 = 1;
        } else {
            v2 = firstVisiblePosition > l02.v() ? firstVisiblePosition - l02.v() : 0;
            v3 = (lastVisiblePosition - l02.v()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (v3 > v2) {
            while (v2 < v3) {
                if (this.z0.B0().G(v2) != null && (this.z0.B0().G(v2) instanceof PostData) && (postData = (PostData) this.z0.B0().G(v2)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.s0.C0().D(), postData.A() - 1);
                    if (postData.p() == null && postData2 != null) {
                        postData.f0(postData2.p());
                    }
                    if (postData.p() != null) {
                        postData.p().j(postData.A());
                        arrayList.add(postData.p());
                    }
                }
                v2++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new d1());
            if (((d.a.n0.t.a) ListUtils.getItem(arrayList, 0)).c() != 1) {
                this.z0.u3();
                this.z0.V1((d.a.n0.t.a) ListUtils.getItem(arrayList, 0), 1);
            } else if (z2) {
            } else {
                this.z0.u3();
                this.z0.V1((d.a.n0.t.a) ListUtils.getItem(arrayList, 0), 0);
            }
        }
    }

    public final void W4(Intent intent) {
        d.a.o0.e2.k.e.e1.b.i(this, intent);
    }

    public final boolean W5(boolean z2) {
        d.a.n0.r.q.d0 d0Var;
        int i3;
        PbModel pbModel = this.s0;
        if (pbModel == null || pbModel.C0() == null) {
            return false;
        }
        d.a.o0.e2.h.e C0 = this.s0.C0();
        d.a.n0.r.q.a2 L = C0.L();
        if (L != null) {
            if (L.R1() || L.U1()) {
                return false;
            }
            if (L.S1() || L.T1()) {
                return z2;
            }
        }
        if (z2) {
            return true;
        }
        if (L == null || L.T() == null || !L.T().isForumBusinessAccount() || d.a.o0.r0.w0.isOn()) {
            if (C0.l() == null || !C0.l().isBlockBawuDelete) {
                if (C0.S() != 0) {
                    return C0.S() != 3;
                }
                List<d.a.n0.r.q.w1> p3 = C0.p();
                if (ListUtils.getCount(p3) > 0) {
                    for (d.a.n0.r.q.w1 w1Var : p3) {
                        if (w1Var != null && (d0Var = w1Var.f53946g) != null && d0Var.f53771a && !d0Var.f53773c && ((i3 = d0Var.f53772b) == 1 || i3 == 2)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final boolean X3() {
        PbModel pbModel = this.s0;
        if (pbModel == null || pbModel.C0() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.s0.C0().L()) || AntiHelper.d(getPageContext(), this.s0.C0().d());
    }

    public void X4() {
        if (this.f19058e == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.f19058e.getCurrentFocus() == null) {
            return;
        }
        d.a.c.e.p.l.x(getPageContext().getPageActivity(), this.f19058e.getCurrentFocus());
    }

    public final boolean X5(boolean z2) {
        PbModel pbModel;
        if (z2 || (pbModel = this.s0) == null || pbModel.C0() == null || (this.s0.C0().l() != null && this.s0.C0().l().isBlockBawuDelete)) {
            return false;
        }
        d.a.o0.e2.h.e C0 = this.s0.C0();
        return ((C0.L() != null && C0.L().T() != null && C0.L().T().isForumBusinessAccount() && !d.a.o0.r0.w0.isOn()) || this.s0.C0().S() == 0 || this.s0.C0().S() == 3) ? false : true;
    }

    @Override // d.a.o0.e2.o.i
    public PbModel.g Y() {
        return this.a2;
    }

    public final boolean Y3(int i3) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
            return false;
        }
        return true;
    }

    public void Y4() {
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        if (t0Var != null) {
            t0Var.Y0();
            X4();
        }
    }

    public final boolean Y5() {
        PbModel pbModel = this.s0;
        if (pbModel != null && pbModel.Q0()) {
            return this.s0.A0() == null || this.s0.A0().c() != 0;
        }
        return false;
    }

    public void Z3(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.z0.c3();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = d.a.c.e.m.b.f(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = d.a.c.e.m.b.f((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        BdUniqueId bdUniqueId = this.c1;
        userMuteCheckCustomMessage.mId = bdUniqueId;
        userMuteCheckCustomMessage.setTag(bdUniqueId);
        this.Z0 = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public final void Z4(int i3) {
        d.a.n0.z0.h0.b(new m2(), new n2(i3));
        StatisticItem statisticItem = new StatisticItem("c13833");
        statisticItem.param("obj_locate", 1);
        if (i3 == 3) {
            statisticItem.param("obj_type", 1);
        } else if (i3 == 8) {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void Z5(MetaData metaData) {
        if (metaData == null) {
            return;
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(getActivity());
        aVar.setTitle(getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(getResources().getString(R.string.mark_like_cancel), new z0(metaData));
        aVar.setPositiveButton(getResources().getString(R.string.mark_like_confirm), new a1(metaData));
        aVar.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public boolean a4() {
        if ((this.s0.C0() != null && (this.s0.C0().a0() || ThreadCardUtils.isSelf(this.s0.C0().L()))) || this.R0 == null || this.s0.C0() == null || this.s0.C0().d() == null) {
            return true;
        }
        return this.R0.checkPrivacyBeforeInvokeEditor(this.s0.C0().d().replyPrivateFlag);
    }

    public final void a5(Bundle bundle) {
        d.a.n0.h.a c3 = d.a.n0.h.a.c(this.f19058e);
        this.u0 = c3;
        if (c3 != null) {
            c3.j(this.d2);
        }
        ForumManageModel forumManageModel = new ForumManageModel(this.f19058e);
        this.v0 = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.f2);
        this.w0 = new d.a.n0.s.e.a(getPageContext());
        this.H1.setUniqueId(getUniqueId());
        this.H1.registerListener();
    }

    public final void a6() {
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessage(getResources().getString(R.string.mute_is_super_member_function));
        aVar.setPositiveButton(R.string.open_now, new g2());
        aVar.setNegativeButton(R.string.cancel, new h2());
        aVar.create(this.a1).show();
    }

    public boolean b4(int i3) {
        if (this.R0 == null || this.s0.C0() == null || ThreadCardUtils.isSelf(this.s0.C0().L()) || this.s0.C0().d() == null) {
            return true;
        }
        return this.R0.checkPrivacyBeforeSend(this.s0.C0().d().replyPrivateFlag, i3);
    }

    public final void b5() {
        this.T = new LikeModel(getPageContext());
    }

    public final void b6(boolean z2, SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            d.a.n0.r.s.j jVar = this.E0;
            if (jVar != null && jVar.isShowing()) {
                this.E0.dismiss();
                this.E0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                d.a.n0.r.s.l lVar = new d.a.n0.r.s.l(getContext());
                lVar.n(new r(sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new d.a.n0.r.s.h(0, getResources().getString(R.string.delete), lVar));
                }
                if (z2) {
                    arrayList.add(new d.a.n0.r.s.h(1, getResources().getString(R.string.un_mute), lVar));
                } else {
                    arrayList.add(new d.a.n0.r.s.h(1, getResources().getString(R.string.mute), lVar));
                }
                lVar.k(arrayList);
                d.a.n0.r.s.j jVar2 = new d.a.n0.r.s.j(getPageContext(), lVar);
                this.E0 = jVar2;
                jVar2.l();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c4(AgreeData agreeData) {
        d.a.n0.i0.c k3;
        PbModel pbModel;
        if (agreeData == null) {
            return;
        }
        if (this.m0 == null) {
            this.m0 = new d.a.n0.r.b0.a();
        }
        if (this.o0 == null) {
            d.a.o0.e3.h0.e eVar = new d.a.o0.e3.h0.e();
            this.o0 = eVar;
            eVar.f57810a = getUniqueId();
        }
        d.a.n0.r.q.e eVar2 = new d.a.n0.r.q.e();
        eVar2.f53777b = 5;
        eVar2.f53783h = 8;
        eVar2.f53782g = 2;
        if (A() != null) {
            eVar2.f53781f = A().B0();
        }
        eVar2.f53776a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                eVar2.f53784i = 0;
                k3 = TbPageExtraHelper.k(getContext());
                if (k3 != null) {
                    agreeData.objSource = k3.a();
                }
                this.m0.c(agreeData, i3, getUniqueId(), false);
                this.m0.d(agreeData, this.o0);
                pbModel = this.s0;
                if (pbModel != null || pbModel.C0() == null) {
                }
                this.m0.b(B(), eVar2, agreeData, this.s0.C0().L());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            eVar2.f53784i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            eVar2.f53784i = 1;
        }
        i3 = 0;
        k3 = TbPageExtraHelper.k(getContext());
        if (k3 != null) {
        }
        this.m0.c(agreeData, i3, getUniqueId(), false);
        this.m0.d(agreeData, this.o0);
        pbModel = this.s0;
        if (pbModel != null) {
        }
    }

    public final void c5() {
        if (this.q != null) {
            return;
        }
        this.q = new d.a.n0.r.s.b(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        d.a.n0.r.s.b bVar = this.q;
        bVar.j(strArr, new a0());
        bVar.g(b.C1206b.f54007a);
        bVar.h(17);
        bVar.c(getPageContext());
    }

    public final void c6() {
        showLoadingView(this.z0.U0(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View i3 = getLoadingView().i();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) i3.getLayoutParams();
        layoutParams.addRule(3, this.z0.T0().getId());
        i3.setLayoutParams(layoutParams);
    }

    public final void d4() {
        if (this.s0.i0() || this.s0.l0()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.s0.S0());
            this.f19058e.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.s0.S0()));
        if (m6()) {
            this.f19058e.finish();
        }
    }

    public boolean d5() {
        PbModel pbModel = this.s0;
        if (pbModel != null) {
            return pbModel.i0();
        }
        return false;
    }

    public final void d6(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && A() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            A().O(postWriteCallBackData.getPostId());
            int p02 = this.z0.p0();
            this.j1 = p02;
            this.s0.K1(p02, this.z0.w0());
        }
        this.z0.a0();
        this.D0.c();
        d.a.n0.w.w.e eVar = this.O0;
        if (eVar != null) {
            this.z0.o2(eVar.C());
        }
        this.z0.Y0();
        this.z0.V2(true);
        this.s0.Y0();
    }

    public final boolean e4(View view) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        List<d.a.n0.r.s.h> b3;
        d.a.n0.r.s.h hVar;
        d.a.n0.r.s.h hVar2;
        d.a.n0.r.s.h hVar3;
        d.a.n0.r.s.h hVar4;
        d.a.c.k.d.a aVar;
        SparseArray sparseArray2;
        if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
            d.a.o0.e2.k.e.t0 t0Var = this.z0;
            if (t0Var != null) {
                if (t0Var.p1()) {
                    return true;
                }
                this.z0.j0();
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e3) {
                e3.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (g5(view)) {
                    if (view instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view;
                        this.f1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.g1 = url;
                        if (this.f1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.h1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.h1 = null;
                        }
                    } else if (view instanceof GifView) {
                        GifView gifView = (GifView) view;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.f1 = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.g1 = gifView.getBdImage().q();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.h1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.h1 = null;
                        }
                    } else if (view instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.f1 = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.g1 = tbMemeImageView.getBdImage().q();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.h1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.h1 = null;
                            }
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e4) {
                            e4.printStackTrace();
                        }
                    } else if (view.getParent().getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e5) {
                            e5.printStackTrace();
                        }
                    } else {
                        this.z0.g3(this.p2, this.f1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            this.n2 = postData;
            if (postData == null) {
                return true;
            }
            if (postData.A() == 1 && g5(view)) {
                this.z0.g3(this.p2, this.f1.t());
                return true;
            }
            d.a.n0.h.a aVar2 = this.u0;
            if (aVar2 == null) {
                return true;
            }
            boolean z4 = aVar2.e() && this.n2.E() != null && this.n2.E().equals(this.s0.x0());
            boolean z5 = A().C0() != null && A().C0().a0();
            if (this.n2.A() == 1) {
                if (!z5) {
                    this.z0.h3(this.o2, z4, false);
                }
                return true;
            }
            if (this.F0 == null) {
                d.a.n0.r.s.l lVar = new d.a.n0.r.s.l(getContext());
                this.F0 = lVar;
                lVar.n(this.T1);
            }
            ArrayList arrayList = new ArrayList();
            if (view == null || sparseArray == null) {
                return true;
            }
            boolean z6 = g5(view) && !z5;
            boolean z7 = (!g5(view) || (aVar = this.f1) == null || aVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (z6) {
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new d.a.n0.r.s.h(1, getString(R.string.save_to_emotion), this.F0));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
            }
            if (z7) {
                arrayList.add(new d.a.n0.r.s.h(2, getString(R.string.save_to_local), this.F0));
            }
            if (!z6 && !z7) {
                d.a.n0.r.s.h hVar5 = new d.a.n0.r.s.h(3, getString(R.string.copy), this.F0);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.n2);
                hVar5.f54037d.setTag(sparseArray3);
                arrayList.add(hVar5);
            }
            if (!booleanValue && !z5) {
                if (z4) {
                    hVar4 = new d.a.n0.r.s.h(4, getString(R.string.remove_mark), this.F0);
                } else {
                    hVar4 = new d.a.n0.r.s.h(4, getString(R.string.mark), this.F0);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.n2);
                sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                hVar4.f54037d.setTag(sparseArray4);
                arrayList.add(hVar4);
            }
            if (this.mIsLogin && !this.p0) {
                if (!d.a.o0.e2.k.e.e1.a.h(this.s0) && !booleanValue4 && booleanValue3) {
                    d.a.n0.r.s.h hVar6 = new d.a.n0.r.s.h(5, getString(R.string.mute_option), this.F0);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    int i3 = R.id.tag_is_mem;
                    sparseArray5.put(i3, sparseArray.get(i3));
                    int i4 = R.id.tag_user_mute_mute_userid;
                    sparseArray5.put(i4, sparseArray.get(i4));
                    int i5 = R.id.tag_user_mute_mute_username;
                    sparseArray5.put(i5, sparseArray.get(i5));
                    int i6 = R.id.tag_user_mute_mute_nameshow;
                    sparseArray5.put(i6, sparseArray.get(i6));
                    int i7 = R.id.tag_user_mute_post_id;
                    sparseArray5.put(i7, sparseArray.get(i7));
                    int i8 = R.id.tag_user_mute_thread_id;
                    sparseArray5.put(i8, sparseArray.get(i8));
                    int i9 = R.id.tag_del_post_is_self;
                    sparseArray5.put(i9, sparseArray.get(i9));
                    int i10 = R.id.tag_del_post_type;
                    sparseArray5.put(i10, sparseArray.get(i10));
                    int i11 = R.id.tag_del_post_id;
                    sparseArray5.put(i11, sparseArray.get(i11));
                    int i12 = R.id.tag_manage_user_identity;
                    sparseArray5.put(i12, sparseArray.get(i12));
                    hVar6.f54037d.setTag(sparseArray5);
                    arrayList.add(hVar6);
                } else {
                    if ((j5(booleanValue2) && TbadkCoreApplication.isLogin()) && !z5) {
                        d.a.n0.r.s.h hVar7 = new d.a.n0.r.s.h(5, getString(R.string.report_text), this.F0);
                        hVar7.f54037d.setTag(str);
                        arrayList.add(hVar7);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    int i13 = R.id.tag_manage_user_identity;
                    sparseArray6.put(i13, sparseArray.get(i13));
                    int i14 = R.id.tag_forbid_user_name;
                    sparseArray6.put(i14, sparseArray.get(i14));
                    int i15 = R.id.tag_forbid_user_name_show;
                    sparseArray6.put(i15, sparseArray.get(i15));
                    int i16 = R.id.tag_forbid_user_portrait;
                    sparseArray6.put(i16, sparseArray.get(i16));
                    sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                    if (!d.a.o0.e2.k.e.e1.a.h(this.s0) && z2) {
                        sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        int i17 = R.id.tag_is_mem;
                        sparseArray6.put(i17, sparseArray.get(i17));
                        int i18 = R.id.tag_user_mute_mute_userid;
                        sparseArray6.put(i18, sparseArray.get(i18));
                        int i19 = R.id.tag_user_mute_mute_username;
                        sparseArray6.put(i19, sparseArray.get(i19));
                        int i20 = R.id.tag_user_mute_mute_nameshow;
                        sparseArray6.put(i20, sparseArray.get(i20));
                        int i21 = R.id.tag_user_mute_post_id;
                        sparseArray6.put(i21, sparseArray.get(i21));
                        int i22 = R.id.tag_user_mute_thread_id;
                        sparseArray6.put(i22, sparseArray.get(i22));
                    } else {
                        sparseArray6.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i23 = R.id.tag_del_post_id;
                        sparseArray6.put(i23, sparseArray.get(i23));
                        int i24 = R.id.tag_del_post_type;
                        sparseArray6.put(i24, sparseArray.get(i24));
                        int i25 = R.id.tag_has_sub_post;
                        sparseArray6.put(i25, sparseArray.get(i25));
                        hVar2 = new d.a.n0.r.s.h(6, getString(R.string.delete), this.F0);
                        hVar2.f54037d.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        hVar2 = null;
                    }
                    hVar = new d.a.n0.r.s.h(7, getString(R.string.bar_manager), this.F0);
                    hVar.f54037d.setTag(sparseArray6);
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray7.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray7.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    int i26 = R.id.tag_manage_user_identity;
                    sparseArray7.put(i26, sparseArray.get(i26));
                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                    int i27 = R.id.tag_del_post_id;
                    sparseArray7.put(i27, sparseArray.get(i27));
                    int i28 = R.id.tag_del_post_type;
                    sparseArray7.put(i28, sparseArray.get(i28));
                    int i29 = R.id.tag_has_sub_post;
                    sparseArray7.put(i29, sparseArray.get(i29));
                    if (this.s0.C0().S() == 1002 && !booleanValue2) {
                        hVar3 = new d.a.n0.r.s.h(6, getString(R.string.report_text), this.F0);
                    } else {
                        hVar3 = new d.a.n0.r.s.h(6, getString(R.string.delete), this.F0);
                    }
                    hVar3.f54037d.setTag(sparseArray7);
                    hVar2 = hVar3;
                    hVar = null;
                } else {
                    hVar = null;
                    hVar2 = null;
                }
                if (hVar2 != null) {
                    arrayList.add(hVar2);
                }
                if (hVar != null) {
                    arrayList.add(hVar);
                }
                d.a.o0.e2.k.e.e1.a.a(arrayList, this.F0, this.n2, this.s0);
            }
            if (d.a.n0.b.d.z()) {
                b3 = d.a.o0.e2.k.e.e1.a.c(arrayList, this.n2.q(), sparseArray, this.F0);
            } else {
                b3 = d.a.o0.e2.k.e.e1.a.b(arrayList, this.n2.q(), sparseArray, this.F0);
            }
            d.a.o0.e2.k.e.e1.a.k(b3, this.f19059f);
            d.a.o0.e2.k.e.e1.a.e(b3);
            this.F0.o(d.a.o0.e2.k.e.e1.a.f(this.n2));
            if (d.a.n0.b.d.z()) {
                this.F0.l(b3, false);
            } else {
                this.F0.l(b3, true);
            }
            d.a.n0.r.s.j jVar = new d.a.n0.r.s.j(getPageContext(), this.F0);
            this.E0 = jVar;
            jVar.l();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.s0.f19254e).param("fid", this.s0.getForumId()).param("uid", this.s0.C0().L().T().getUserId()).param("post_id", this.s0.w()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return true;
    }

    public final boolean e5() {
        PostData c3 = d.a.o0.e2.h.f.c(this.s0.C0(), this.s0.Q0(), this.s0.M0());
        return (c3 == null || c3.t() == null || c3.t().getGodUserData() == null || c3.t().getGodUserData().getType() != 2) ? false : true;
    }

    public final void e6(int i3) {
        d.a.o0.e2.k.e.e1.b.m(this, r4(), i3);
    }

    public void f4(ForumManageModel.b bVar, d.a.o0.e2.k.e.t0 t0Var) {
        List<PostData> list = this.s0.C0().Q().f56790a;
        int size = list.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= list.get(i3).M().size()) {
                    break;
                } else if (bVar.f20990g.equals(list.get(i3).M().get(i4).E())) {
                    list.get(i3).M().remove(i4);
                    list.get(i3).l();
                    z2 = true;
                    break;
                } else {
                    i4++;
                }
            }
            list.get(i3).n(bVar.f20990g);
        }
        if (z2) {
            t0Var.l1(this.s0.C0());
        }
    }

    public boolean f5() {
        PbModel pbModel = this.s0;
        if (pbModel != null) {
            return pbModel.h0();
        }
        return false;
    }

    public final void f6(String str) {
        if (str == null) {
            str = "";
        }
        d.a.c.a.f fVar = this.a1;
        if (fVar == null) {
            return;
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(fVar.getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new i2());
        aVar.create(this.a1).show();
    }

    @Override // d.a.o0.e2.o.i
    public void finish() {
        d.a.o0.e2.k.e.t0 t0Var;
        CardHListViewData q3;
        d.a.o0.e2.k.e.t0 t0Var2 = this.z0;
        if (t0Var2 != null) {
            t0Var2.a0();
        }
        PbModel pbModel = this.s0;
        if (pbModel != null && pbModel.C0() != null && !this.s0.C0().a0()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.s0.C0().L().o0();
            if (this.s0.isShareThread() && this.s0.C0().L().t1 != null) {
                historyMessage.threadName = this.s0.C0().L().t1.f12178b;
            } else {
                historyMessage.threadName = this.s0.C0().L().A1();
            }
            if (this.s0.isShareThread() && !isSimpleForum()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.s0.C0().l().getName();
            }
            ArrayList<PostData> D = this.s0.C0().D();
            d.a.o0.e2.k.e.t0 t0Var3 = this.z0;
            int s02 = t0Var3 != null ? t0Var3.s0() : 0;
            if (D != null && s02 >= 0 && s02 < D.size()) {
                historyMessage.postID = D.get(s02).E();
            }
            historyMessage.isHostOnly = this.s0.h0();
            historyMessage.isSquence = this.s0.Q0();
            historyMessage.isShareThread = this.s0.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        d.a.n0.w.w.e eVar = this.O0;
        if (eVar != null) {
            eVar.I();
        }
        if (this.n && N4() != null) {
            N4().f0();
        }
        PbModel pbModel2 = this.s0;
        if (pbModel2 != null && (pbModel2.i0() || this.s0.l0())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.s0.S0());
            if (this.A0) {
                if (this.C0) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.s0.r0());
                }
                if (this.B0) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.s0.n0());
                }
            }
            if (this.s0.C0() != null && System.currentTimeMillis() - this.t >= 40000 && (q3 = this.s0.C0().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                intent.putExtra("guess_like_data", q3);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.k1);
            }
            this.f19058e.setResult(-1, intent);
        }
        if (m6()) {
            if (this.s0 != null && (t0Var = this.z0) != null && t0Var.B0() != null) {
                d.a.o0.e2.h.e C0 = this.s0.C0();
                if (C0 != null) {
                    if (C0.R() != null) {
                        C0.R().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!C0.c0() && !this.K && C0.f56740h == null) {
                        d.a.o0.e2.k.e.m0.b().n(this.s0.D0(), this.z0.B0().onSaveInstanceState(), this.s0.Q0(), this.s0.h0(), this.z0.H0() != null && this.z0.H0().getVisibility() == 0);
                        if (this.j1 >= 0 || this.s0.U0() != null) {
                            d.a.o0.e2.k.e.m0.b().q(this.s0.U0());
                            d.a.o0.e2.k.e.m0.b().r(this.s0.V0());
                            d.a.o0.e2.k.e.m0.b().o(this.s0.v0());
                        }
                    }
                }
            } else {
                d.a.o0.e2.k.e.m0.b().m();
            }
            l6();
        }
    }

    public final void g4(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.o0.e3.h0.o x2 = this.s0.C0().x();
        if (x2 != null && str.equals(x2.D0())) {
            if (x2.getAdvertAppInfo() != null) {
                x2.getAdvertAppInfo().R3 = null;
            }
            this.s0.C0().b();
        }
        d.a.o0.e3.h0.o Y = this.s0.Y();
        if (Y == null || !str.equals(Y.D0())) {
            return;
        }
        this.s0.N();
    }

    public boolean g5(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public final void g6(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z2) {
            this.z0.c3();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.a1.getPageActivity());
        if (d.a.c.e.p.k.isEmpty(str)) {
            aVar.setMessage(this.a1.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.setMessage(str);
        }
        aVar.setPositiveButton(R.string.confirm, new k2(userMuteAddAndDelCustomMessage));
        aVar.setNegativeButton(R.string.cancel, new l2());
        aVar.create(this.a1).show();
    }

    public d.a.o0.e2.k.e.c1.a getEventController() {
        return this.f19058e.getEventController();
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<GifView> getGifViewPool() {
        if (this.N == null) {
            this.N = new d.a.c.e.k.b<>(new r1(), 20, 0);
        }
        return this.N;
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<ImageView> getImageViewPool() {
        if (this.G == null) {
            this.G = new d.a.c.e.k.b<>(new q1(), 8, 0);
        }
        return this.G;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        d.a.c.e.k.b<RelativeLayout> bVar = new d.a.c.e.k.b<>(new t1(), 10, 0);
        this.J = bVar;
        return bVar;
    }

    @Override // d.a.n0.b1.m.h
    public int getRichTextViewId() {
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        if (t0Var == null) {
            return 0;
        }
        return t0Var.O0();
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<TextView> getTextViewPool() {
        if (this.E == null) {
            this.E = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.E;
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        if (this.I == null) {
            this.I = new d.a.c.e.k.b<>(new b2(), 15, 0);
        }
        return this.I;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.a.c.e.k.b<TbImageView> getUserIconPool() {
        if (this.F == null) {
            this.F = UserIconBox.c(getPageContext().getPageActivity(), 8);
        }
        return this.F;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        return this.o;
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<View> getVoiceViewPool() {
        if (this.H == null) {
            this.H = new d.a.c.e.k.b<>(new s1(), 8, 0);
        }
        return this.H;
    }

    public void h4(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        int intValue = ((Integer) sparseArray.get(d.a.o0.e2.k.e.t0.X1)).intValue();
        if (intValue == d.a.o0.e2.k.e.t0.Y1) {
            if (this.v0.O()) {
                return;
            }
            this.z0.t3();
            String str = (String) sparseArray.get(R.id.tag_del_post_id);
            int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            if (jSONArray != null) {
                this.v0.Q(StringHelper.JsonArrayToString(jSONArray));
            }
            this.v0.R(this.s0.C0().l().getId(), this.s0.C0().l().getName(), this.s0.C0().L().o0(), str, intValue3, intValue2, booleanValue, this.s0.C0().L().V());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
        } else if (intValue == d.a.o0.e2.k.e.t0.Z1 || intValue == d.a.o0.e2.k.e.t0.b2) {
            if (this.s0.a0() != null) {
                this.s0.a0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
            }
            if (intValue == d.a.o0.e2.k.e.t0.Z1) {
                TiebaStatic.log("c10499");
            }
        }
    }

    public boolean h5(int i3) {
        List<ForumToolPerm> forumToolAuth;
        if (i3 == 1) {
            return true;
        }
        if (this.s0.C0().R() != null && (forumToolAuth = this.s0.C0().R().getForumToolAuth()) != null) {
            for (int i4 = 0; i4 < forumToolAuth.size(); i4++) {
                ForumToolPerm forumToolPerm = forumToolAuth.get(i4);
                if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void h6() {
        PbModel pbModel = this.s0;
        if (pbModel == null || d.a.c.e.p.k.isEmpty(pbModel.S0())) {
            return;
        }
        d.a.n0.a.d.y().P(d.a.n0.a.c.W, d.a.c.e.m.b.f(this.s0.S0(), 0L));
    }

    public void i4(d.a.n0.r.s.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (aVar.getYesButtonTag() instanceof SparseArray) {
                h4((SparseArray) aVar.getYesButtonTag(), jSONArray);
                return;
            }
            return;
        }
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
    }

    public final boolean i5(int i3) {
        return i3 == 2 || i3 == 1;
    }

    public final void i6(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            j6(postData, false);
        }
    }

    public boolean isSimpleForum() {
        PbModel pbModel = this.s0;
        if (pbModel == null) {
            return false;
        }
        return pbModel.h1();
    }

    public void j4(int i3, String str, int i4, boolean z2) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
        sparseArray.put(d.a.o0.e2.k.e.t0.X1, Integer.valueOf(d.a.o0.e2.k.e.t0.Y1));
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            h4(sparseArray, null);
        } else {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final boolean j5(boolean z2) {
        PbModel pbModel = this.s0;
        if (pbModel != null && pbModel.C0() != null) {
            return ((this.s0.C0().S() != 0) || this.s0.C0().L() == null || this.s0.C0().L().T() == null || TextUtils.equals(this.s0.C0().L().T().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
        }
        return false;
    }

    public final void j6(PostData postData, boolean z2) {
        PbModel pbModel;
        if (postData == null || (pbModel = this.s0) == null || pbModel.C0() == null || postData.A() == 1) {
            return;
        }
        String S0 = this.s0.S0();
        String E = postData.E();
        int S = this.s0.C0() != null ? this.s0.C0().S() : 0;
        PbActivity.e A5 = A5(E);
        if (A5 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(S0, E, "pb", true, null, false, null, S, postData.O(), this.s0.C0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null).addBigImageData(A5.f19014a, A5.f19015b, A5.f19020g, A5.j);
        addBigImageData.setKeyPageStartFrom(this.s0.B0());
        addBigImageData.setFromFrsForumId(this.s0.getFromForumId());
        addBigImageData.setKeyFromForumId(this.s0.getForumId());
        addBigImageData.setBjhData(this.s0.X());
        addBigImageData.setIsOpenEditor(z2);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public void k4() {
        TiebaStatic.log("c12181");
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        if (t0Var == null || this.s0 == null) {
            return;
        }
        if ((t0Var != null && !t0Var.n1()) || this.s0.C0() == null || this.s0.C0().P() == null) {
            return;
        }
        d.a.o0.e2.k.e.t0 t0Var2 = this.z0;
        if (t0Var2 == null || t0Var2.r0() == null || !this.z0.r0().c()) {
            d.a.o0.e2.h.p P = this.s0.C0().P();
            if (checkUpIsLogin()) {
                if ((!P.g() || P.b() != 2) && this.z0.l0() != null && this.z0.l0().y() != null) {
                    this.z0.l0().y().i0(this.s0.S0());
                }
                if (System.currentTimeMillis() - this.B > 2000) {
                    new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                    this.B = System.currentTimeMillis();
                }
            }
        }
    }

    public final void k5(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    public final void k6() {
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
        PbActivity pbActivity = this.f19058e;
        if (pbActivity != null) {
            pbActivity.stopVoice();
        }
    }

    public void l4() {
        PbModel pbModel;
        if (this.z0 == null || (pbModel = this.s0) == null) {
            return;
        }
        if ((pbModel.C0() == null && this.s0.C0().P() == null) || !checkUpIsLogin() || this.z0.l0() == null || this.z0.l0().y() == null) {
            return;
        }
        this.z0.l0().y().i0(this.s0.S0());
    }

    public final void l5() {
        if (this.z2 != null) {
            if (this.x2 == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.z2.a(), this.x2, 0)));
                this.f19058e.finish();
            }
        }
    }

    public final void l6() {
        this.f19058e.superCloseActivity();
    }

    @Override // d.a.o0.e2.p.e.b
    public void m0(boolean z2) {
        this.I0 = z2;
    }

    public final void m4(String str) {
        PbModel pbModel = this.s0;
        if (pbModel == null || pbModel.C0() == null || this.s0.C0().L() == null || !this.s0.C0().L().C2()) {
            return;
        }
        d.a.n0.r.q.a2 L = this.s0.C0().L();
        int i3 = 0;
        if (L.R1()) {
            i3 = 1;
        } else if (L.U1()) {
            i3 = 2;
        } else if (L.S1()) {
            i3 = 3;
        } else if (L.T1()) {
            i3 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i3);
        TiebaStatic.log(statisticItem);
    }

    public void m5(String str) {
        d.a.o0.e2.k.e.t0 t0Var;
        if (this.s0 == null || StringUtils.isNull(str) || (t0Var = this.z0) == null) {
            return;
        }
        t0Var.t2(true);
        this.s0.m1(str);
        this.K = true;
        this.z0.a0();
        this.z0.W0();
    }

    public final boolean m6() {
        PbModel pbModel = this.s0;
        if (pbModel == null) {
            return true;
        }
        if (pbModel.C0() == null || !this.s0.C0().a0()) {
            if (this.s0.o0()) {
                MarkData b02 = this.s0.b0();
                if (b02 != null && this.s0.m0()) {
                    MarkData V = this.s0.V(this.z0.s0());
                    if (V == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", b02);
                        this.f19058e.setResult(-1, intent);
                        return true;
                    } else if (V.getPostId() != null && !V.getPostId().equals(b02.getPostId())) {
                        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(getPageContext().getPageActivity());
                        aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                        aVar.setPositiveButton(R.string.confirm, new m1(V, b02, aVar));
                        aVar.setNegativeButton(R.string.cancel, new o1(b02, aVar));
                        aVar.setOnCalcelListener(new p1(b02, aVar));
                        aVar.create(getPageContext());
                        aVar.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", b02);
                        this.f19058e.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (this.s0.C0() != null && this.s0.C0().D() != null && this.s0.C0().D().size() > 0 && this.s0.m0()) {
                this.f19058e.setResult(1);
            }
            return true;
        }
        return true;
    }

    public final void n4(ForumManageModel.b bVar, boolean z2) {
        if (bVar == null || !isAdded()) {
            return;
        }
        String string = !TextUtils.isEmpty(bVar.f20985b) ? bVar.f20985b : getString(R.string.delete_fail);
        int i3 = 0;
        if (bVar.f20986c == 1211066) {
            hideProgressBar();
            d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(getPageContext().getPageActivity());
            aVar.setMessage(string);
            aVar.setPositiveButton(R.string.dialog_known, new g1());
            aVar.setCancelable(true);
            aVar.create(getPageContext());
            aVar.show();
        } else {
            this.z0.i0(0, bVar.f20984a, bVar.f20985b, z2);
        }
        if (bVar.f20984a) {
            int i4 = bVar.f20987d;
            if (i4 == 1) {
                ArrayList<PostData> D = this.s0.C0().D();
                int size = D.size();
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (bVar.f20990g.equals(D.get(i3).E())) {
                        D.remove(i3);
                        break;
                    } else {
                        i3++;
                    }
                }
                this.s0.C0().L().d4(this.s0.C0().L().b1() - 1);
                this.z0.l1(this.s0.C0());
            } else if (i4 == 0) {
                d4();
            } else if (i4 == 2) {
                ArrayList<PostData> D2 = this.s0.C0().D();
                int size2 = D2.size();
                boolean z3 = false;
                for (int i5 = 0; i5 < size2 && !z3; i5++) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= D2.get(i5).M().size()) {
                            break;
                        } else if (bVar.f20990g.equals(D2.get(i5).M().get(i6).E())) {
                            D2.get(i5).M().remove(i6);
                            D2.get(i5).l();
                            z3 = true;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    D2.get(i5).n(bVar.f20990g);
                }
                if (z3) {
                    this.z0.l1(this.s0.C0());
                }
                f4(bVar, this.z0);
            }
        }
    }

    public final void n5(Bundle bundle) {
        PbModel pbModel = this.f19058e.getPbModel();
        this.s0 = pbModel;
        if (pbModel.a0() != null) {
            this.s0.a0().c(this.v2);
        }
        if (this.s0.y0() != null) {
            this.s0.y0().f(this.q1);
        }
        if (StringUtils.isNull(this.s0.S0())) {
            this.f19058e.finish();
        } else if (!"from_tieba_kuang".equals(this.O) || this.O == null) {
        } else {
            this.s0.Q1(6);
        }
    }

    public final void n6(int i3) {
        TiebaStatic.log(new StatisticItem("c14000").param("tid", this.s0.f19254e).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(d.a.o0.e2.k.e.e1.a.m(i3))));
    }

    public final void o4(int i3, ForumManageModel.g gVar) {
        String string;
        if (gVar == null) {
            return;
        }
        this.z0.i0(this.v0.getLoadDataMode(), gVar.f21005a, gVar.f21006b, false);
        if (gVar.f21005a) {
            this.A0 = true;
            if (i3 == 2 || i3 == 3) {
                this.B0 = true;
                this.C0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.B0 = false;
                this.C0 = true;
            }
            if (i3 == 2) {
                this.s0.C0().L().P3(1);
                this.s0.M1(1);
            } else if (i3 == 3) {
                this.s0.C0().L().P3(0);
                this.s0.M1(0);
            } else if (i3 == 4) {
                this.s0.C0().L().Q3(1);
                this.s0.N1(1);
            } else if (i3 == 5) {
                this.s0.C0().L().Q3(0);
                this.s0.N1(0);
            }
            this.z0.A3(this.s0.C0(), this.s0.Q0());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f21006b)) {
            string = gVar.f21006b;
        } else {
            string = getString(R.string.operation_failed);
        }
        d.a.c.e.p.l.M(getPageContext().getPageActivity(), string);
    }

    public final void o5() {
        if (this.z2 != null) {
            if (this.w2 == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.z2.a(), this.w2, 0)));
                this.f19058e.finish();
            }
        }
    }

    public final void o6() {
        if (!TbadkCoreApplication.isLogin() || !AddExperiencedModel.B(this.s0.getForumId()) || this.s0.C0() == null || this.s0.C0().l() == null) {
            return;
        }
        if (this.s0.C0().l().isLike() == 1) {
            this.s0.S().A(this.s0.getForumId(), this.s0.S0());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.a2.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d(), "", 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        EmotionImageData emotionImageData;
        String str;
        super.onActivityResult(i3, i4, intent);
        this.O0.H(i3, i4, intent);
        d.a.o0.e2.k.e.b1.f.a aVar = this.S;
        if (aVar != null) {
            aVar.i(i3, i4, intent);
        }
        if (N4().J0() != null) {
            N4().J0().g(i3, i4, intent);
        }
        if (i3 == 25035) {
            T4(i4, intent);
        }
        if (i4 == -1) {
            if (i3 == 11009) {
                r5();
            } else if (i3 == 13008) {
                d.a.o0.e2.k.e.m0.b().m();
                this.r0.postDelayed(new k1(), 1000L);
            } else if (i3 == 13011) {
                d.a.o0.s2.a.g().m(getPageContext());
            } else if (i3 == 23003) {
                if (intent == null || this.s0 == null) {
                    return;
                }
                U5(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
            } else if (i3 == 23007) {
                W4(intent);
            } else if (i3 == 25012) {
                intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                intent.getStringExtra("KEY_FORUM_NAME");
            } else if (i3 == 25016 || i3 == 25023) {
                Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                    return;
                }
                this.U0 = emotionImageData;
                if (b4(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                    I5(emotionImageData);
                }
            } else if (i3 == 25033) {
                View view = this.U;
                if (view != null) {
                    this.z0.Z2(view);
                }
            } else if (i3 == 24007) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                if (intent != null) {
                    statisticItem.param("tid", intent.getStringExtra("tid"));
                    statisticItem.param("post_id", intent.getStringExtra("pid"));
                    statisticItem.param("obj_locate", intent.getIntExtra("source", 0));
                    TiebaStatic.log(statisticItem);
                }
                int intExtra = intent.getIntExtra("extra_show_channel", 1);
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    d.a.o0.s2.a.g().m(getPageContext());
                    o6();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.y0;
                    if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.t) == null) {
                        return;
                    }
                    shareSuccessReplyToServerModel.w(str, intExtra, new l1());
                }
            } else if (i3 != 24008) {
                switch (i3) {
                    case 25055:
                        View view2 = this.V;
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case 25056:
                        View view3 = this.W;
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case 25057:
                        d.a.o0.e2.k.e.t0 t0Var = this.z0;
                        if (t0Var == null || t0Var.m0() == null) {
                            return;
                        }
                        this.z0.m0().performClick();
                        return;
                    case 25058:
                        View view4 = this.X;
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                this.z0.L2(false);
                if (this.s0.C0() == null || this.s0.C0().L() == null || this.s0.C0().L().U0() == null) {
                    return;
                }
                this.s0.C0().L().U0().setStatus(2);
            }
        }
    }

    @Override // d.a.n0.b1.m.h
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.A = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f19058e = (PbActivity) context;
    }

    public void onBackPressed() {
        List<p2> list = this.l1;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.l1.size();
        while (true) {
            size--;
            if (size <= -1 || this.l1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        if (this.Z == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.z0.E1(i3);
        d.a.n0.w.w.e eVar = this.O0;
        if (eVar != null && eVar.a() != null) {
            this.O0.a().w(i3);
        }
        if (this.z0.a() != null) {
            this.z0.a().c(getPageContext(), i3);
        }
        this.D0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.Z = i3;
        k6();
    }

    @Override // d.a.n0.r.s.a.e
    public void onClick(d.a.n0.r.s.a aVar) {
        i4(aVar, null);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i3 = configuration.orientation;
        if (i3 == this.C) {
            return;
        }
        this.C = i3;
        if (i3 == 2) {
            this.L = true;
        } else {
            this.L = false;
        }
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        if (t0Var != null) {
            t0Var.F1(configuration);
        }
        d.a.n0.r.s.j jVar = this.E0;
        if (jVar != null) {
            jVar.dismiss();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        d.a.o0.e2.k.e.t0 t0Var;
        d.a.o0.e2.k.e.t0 t0Var2;
        this.t = System.currentTimeMillis();
        this.a1 = getPageContext();
        Intent intent = this.f19058e.getIntent();
        if (intent != null) {
            this.r = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.O = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.O)) {
                    this.O = data.getQueryParameter("from");
                }
            }
            this.Y = intent.getStringExtra("st_type");
            "from_interview_live".equals(this.O);
            this.w2 = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.x2 = intent.getIntExtra("key_manga_next_chapter", -1);
            this.y2 = intent.getStringExtra("key_manga_title");
            this.J0 = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.K0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.L0 = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (C4()) {
                this.f19058e.setUseStyleImmersiveSticky(false);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.R = stringExtra;
            this.R = d.a.c.e.p.k.isEmpty(stringExtra) ? "" : this.R;
            this.k1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            d.a.n0.r.q.k1 k1Var = new d.a.n0.r.q.k1();
            this.k0 = k1Var;
            k1Var.a(intent);
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            this.m1 = intExtra;
            if (intExtra == 0) {
                this.m1 = intent.getIntExtra("key_start_from", 0);
            }
            this.n1 = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.r = System.currentTimeMillis();
        }
        this.v = this.t - this.r;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.p = 0;
        n5(bundle);
        if (this.s0.C0() != null) {
            this.s0.C0().x0(this.R);
        }
        b5();
        if (intent != null && (t0Var2 = this.z0) != null) {
            t0Var2.f57255b = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.d1 == null) {
                    this.d1 = new u(intent);
                }
                d.a.c.e.m.e.a().postDelayed(this.d1, 1500L);
            }
            String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra2) && this.s0.C0() != null) {
                this.s0.R1(stringExtra2);
            }
        }
        VoiceManager voiceManager = new VoiceManager();
        this.o = voiceManager;
        voiceManager.onCreate(getPageContext());
        a5(bundle);
        d.a.n0.w.w.g gVar = new d.a.n0.w.w.g();
        this.N0 = gVar;
        O5(gVar);
        d.a.n0.w.w.e eVar = (d.a.n0.w.w.e) this.N0.a(getActivity());
        this.O0 = eVar;
        eVar.e0(this.f19058e.getPageContext());
        this.O0.n0(this.X1);
        this.O0.o0(this.V0);
        this.O0.g0(1);
        this.O0.F(this.f19058e.getPageContext(), bundle);
        this.O0.a().b(new d.a.n0.w.k(getActivity()));
        this.O0.a().C(true);
        R5(true);
        this.O0.O(this.s0.g0(), this.s0.S0(), this.s0.d0());
        registerListener(this.u1);
        if (!this.s0.q0()) {
            this.O0.s(this.s0.S0());
        }
        if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
            this.O0.k0(TbSingleton.getInstance().getAdVertiComment());
        } else if (this.s0.a1()) {
            this.O0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            d.a.o0.e2.k.e.t0 t0Var3 = this.z0;
            if (t0Var3 != null) {
                this.O0.k0(t0Var3.M0());
            }
        }
        registerListener(this.t1);
        registerListener(this.v1);
        registerListener(this.w1);
        registerListener(this.s1);
        registerListener(this.Q1);
        registerListener(this.c2);
        registerListener(this.r1);
        d.a.o0.e3.h0.f fVar = new d.a.o0.e3.h0.f("pb", d.a.o0.e3.h0.f.f57813d);
        this.M0 = fVar;
        fVar.d();
        registerListener(this.A1);
        registerListener(this.J1);
        this.s0.t1();
        registerListener(this.b2);
        registerListener(this.R1);
        registerListener(this.W1);
        registerListener(this.E1);
        d.a.o0.e2.k.e.t0 t0Var4 = this.z0;
        if (t0Var4 != null && t0Var4.T0() != null && this.z0.R0() != null) {
            d.a.o0.e2.k.e.c1.b bVar = new d.a.o0.e2.k.e.c1.b(getActivity(), this.z0.T0(), this.z0.R0(), this.z0.H0());
            this.f19062i = bVar;
            bVar.t(this.I1);
        }
        if (this.f19060g && (t0Var = this.z0) != null && t0Var.R0() != null) {
            this.z0.R0().setVisibility(8);
        }
        d.a.n0.r.f0.c cVar = new d.a.n0.r.f0.c();
        this.b1 = cVar;
        cVar.f53491a = 1000L;
        registerListener(this.P1);
        registerListener(this.N1);
        registerListener(this.O1);
        registerListener(this.C1);
        registerListener(this.y1);
        this.B1.setSelfListener(true);
        this.B1.setTag(this.f19058e.getUniqueId());
        this.B1.setPriority(-1);
        MessageManager.getInstance().registerListener(this.B1);
        registerResponsedEventListener(TipEvent.class, this.K1);
        this.c1 = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        BdUniqueId bdUniqueId = this.c1;
        userMuteAddAndDelCustomMessage.mId = bdUniqueId;
        userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        BdUniqueId bdUniqueId2 = this.c1;
        userMuteCheckCustomMessage.mId = bdUniqueId2;
        userMuteCheckCustomMessage.setTag(bdUniqueId2);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.s0.Z().A(this.L1);
        this.D0 = new d.a.o0.e2.k.e.v0();
        if (this.O0.v() != null) {
            this.D0.m(this.O0.v().i());
        }
        this.O0.d0(this.W0);
        this.y0 = new ShareSuccessReplyToServerModel();
        R3(this.p1);
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
        this.R0 = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new w());
        d.a.o0.e2.k.f.a aVar = new d.a.o0.e2.k.f.a(getContext());
        this.t0 = aVar;
        aVar.a(getUniqueId());
        d.a.o0.d3.c.g().i(getUniqueId());
        d.a.n0.r.o.a.b().l("3", "");
        this.o1 = new d.a.o0.y.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && d.a.c.e.p.j.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
        }
        this.u = System.currentTimeMillis() - this.t;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.z0 = new d.a.o0.e2.k.e.t0(this, this.V1, this.M1);
        d.a.o0.g0.b bVar = new d.a.o0.g0.b(getActivity());
        this.f19061h = bVar;
        bVar.i(B2);
        this.f19061h.d(this.u2);
        this.z0.D2(this.e2);
        this.z0.C2(this.j2);
        this.z0.w2(this.h2);
        this.z0.u2(d.a.n0.r.k.c().g());
        this.z0.A2(this.l2);
        this.z0.F2(this.r2);
        this.z0.B2(this.s2);
        this.z0.z2(this.g2);
        this.z0.x3(this.mIsLogin);
        if (this.f19058e.getIntent() != null) {
            this.z0.s2(this.f19058e.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.z0.I0().setFromForumId(this.s0.getFromForumId());
        this.z0.k2(this.O0.a());
        if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
            this.O0.k0(TbSingleton.getInstance().getAdVertiComment());
        } else {
            this.O0.k0(this.z0.M0());
        }
        this.z0.n2(new y());
        this.z0.r2(this.s0.l0());
        this.z0.E2(this.s0.B0());
        return this.z0.U0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.a.o0.e2.k.e.f1.c cVar;
        d.a.o0.d3.c.g().k(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            StatisticItem statisticItem = new StatisticItem("c13266");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.s0.C0().m());
            statisticItem.param("tid", this.s0.S0());
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(statisticItem);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.x && this.z0 != null) {
            this.x = true;
            K5(false, null);
        }
        PbModel pbModel = this.s0;
        if (pbModel != null) {
            pbModel.cancelLoadData();
            this.s0.destory();
            if (this.s0.y0() != null) {
                this.s0.y0().d();
            }
        }
        d.a.n0.w.w.e eVar = this.O0;
        if (eVar != null) {
            eVar.I();
        }
        ForumManageModel forumManageModel = this.v0;
        if (forumManageModel != null) {
            forumManageModel.cancelLoadData();
        }
        LikeModel likeModel = this.T;
        if (likeModel != null) {
            likeModel.I();
        }
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        if (t0Var != null) {
            t0Var.G1();
            d.a.o0.e2.k.e.f1.c cVar2 = this.z0.f57261h;
            if (cVar2 != null) {
                cVar2.p();
            }
        }
        d.a.n0.m0.b bVar = this.y;
        if (bVar != null) {
            bVar.c();
        }
        d.a.o0.e2.k.e.c1.b bVar2 = this.f19062i;
        if (bVar2 != null) {
            bVar2.k();
        }
        super.onDestroy();
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.a.o0.e2.k.e.t0 t0Var2 = this.z0;
        if (t0Var2 != null) {
            t0Var2.a0();
        }
        MessageManager.getInstance().unRegisterListener(this.N1);
        MessageManager.getInstance().unRegisterListener(this.O1);
        MessageManager.getInstance().unRegisterListener(this.P1);
        MessageManager.getInstance().unRegisterListener(this.c1);
        MessageManager.getInstance().unRegisterListener(this.Q1);
        MessageManager.getInstance().unRegisterListener(this.R1);
        MessageManager.getInstance().unRegisterListener(this.C1);
        MessageManager.getInstance().unRegisterListener(this.Z1);
        MessageManager.getInstance().unRegisterListener(this.B1);
        MessageManager.getInstance().unRegisterListener(this.E1);
        this.a1 = null;
        this.b1 = null;
        d.a.o0.t2.g0.a.e().g();
        if (this.d1 != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.d1);
        }
        d.a.o0.e2.k.e.b1.f.a aVar = this.S;
        if (aVar != null) {
            aVar.f();
        }
        d.a.o0.e2.k.e.t0 t0Var3 = this.z0;
        if (t0Var3 != null && (cVar = t0Var3.f57261h) != null) {
            cVar.j();
        }
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.y0;
        if (shareSuccessReplyToServerModel != null) {
            shareSuccessReplyToServerModel.cancelLoadData();
        }
        d.a.o0.e2.k.e.v0 v0Var = this.D0;
        if (v0Var != null) {
            v0Var.j();
        }
        PbModel pbModel2 = this.s0;
        if (pbModel2 != null && pbModel2.S() != null) {
            this.s0.S().onDestroy();
        }
        ReplyPrivacyCheckController replyPrivacyCheckController = this.R0;
        if (replyPrivacyCheckController != null) {
            replyPrivacyCheckController.onDestroy();
        }
        d.a.o0.e2.k.e.t0 t0Var4 = this.z0;
        if (t0Var4 != null) {
            t0Var4.u3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.l0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.c.k.e.q onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        d.a.o0.e2.k.e.t0 t0Var;
        return (keyEvent == null || (t0Var = this.z0) == null || !t0Var.I1(i3)) ? false : true;
    }

    @Override // d.a.n0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        this.A = true;
    }

    @Override // d.a.n0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        PbModel pbModel;
        if (d.a.o0.e2.k.e.y0.c(str) && (pbModel = this.s0) != null && pbModel.S0() != null) {
            TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.s0.S0()));
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                d.a.n0.t.m mVar = new d.a.n0.t.m();
                mVar.f54581a = str;
                mVar.f54582b = 3;
                mVar.f54583c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, mVar));
            }
        } else {
            d.a.o0.e2.k.e.y0.a().e(getPageContext(), str);
        }
        this.A = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        F5();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.k = false;
        } else {
            this.k = true;
        }
        super.onPause();
        BdListView listView = getListView();
        int viewLayer = CompatibleUtile.getInstance().getViewLayer(listView);
        this.p = viewLayer;
        if (viewLayer == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        if (t0Var != null) {
            t0Var.L1();
        }
        if (!this.s0.q0()) {
            this.O0.U(this.s0.S0());
        }
        PbModel pbModel = this.s0;
        if (pbModel != null) {
            pbModel.s1();
        }
        d.a.n0.a.d.y().E();
        MessageManager.getInstance().unRegisterListener(this.x1);
        J5();
        MessageManager.getInstance().unRegisterListener(this.N1);
        MessageManager.getInstance().unRegisterListener(this.O1);
        MessageManager.getInstance().unRegisterListener(this.P1);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    @Override // d.a.n0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.G0 = str;
        if (this.q == null) {
            c5();
        }
        TiebaStatic.log("pb_show_phonedialog");
        if (str2.equals("2")) {
            this.q.f(1).setVisibility(8);
        } else {
            this.q.f(1).setVisibility(0);
        }
        this.q.m();
        this.A = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.c.a.i
    public void onPreLoad(d.a.c.k.e.q qVar) {
        PreLoadImageHelper.load(qVar, getUniqueId(), 3);
        PreLoadVideoHelper.load(qVar, getUniqueId(), this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.k = false;
        super.onResume();
        if (this.Q) {
            this.Q = false;
            S4();
        }
        if (e5()) {
            this.z = System.currentTimeMillis();
        } else {
            this.z = -1L;
        }
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        if (t0Var != null && t0Var.U0() != null) {
            if (!this.l) {
                c6();
            } else {
                hideLoadingView(this.z0.U0());
            }
            this.z0.M1();
        }
        if (this.p == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        d.a.o0.e2.k.e.t0 t0Var2 = this.z0;
        NoNetworkView a3 = t0Var2 != null ? t0Var2.a() : null;
        if (a3 != null && a3.getVisibility() == 0 && d.a.c.e.p.j.z()) {
            a3.e(false);
        }
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        registerListener(this.x1);
        this.I0 = false;
        L5();
        registerListener(this.N1);
        registerListener(this.O1);
        registerListener(this.P1);
        if (this.i1) {
            F5();
            this.i1 = false;
        }
        h6();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.s0.H1(bundle);
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.O0.K(bundle);
    }

    @Override // d.a.n0.b1.m.h
    public void onSongClicked(Context context, String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.z > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.z;
            StatisticItem statisticItem = new StatisticItem("c10804");
            TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
            this.z = 0L;
        }
        if (N4().J0() != null) {
            N4().J0().i();
        }
        d.a.o0.e2.k.e.f1.c cVar = this.z0.f57261h;
        if (cVar != null && !cVar.l()) {
            this.z0.f57261h.p();
        }
        PbModel pbModel = this.s0;
        if (pbModel != null && pbModel.C0() != null && this.s0.C0().l() != null && this.s0.C0().L() != null) {
            d.a.n0.u.a.k().y(getPageContext().getPageActivity(), "pb", this.s0.C0().l().getId(), d.a.c.e.m.b.f(this.s0.C0().L().o0(), 0L));
        }
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
        d.a.o0.d3.c.g().h(getUniqueId(), false);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        super.onUserChanged(z2);
        this.z0.x3(z2);
        d.a.n0.r.s.j jVar = this.E0;
        if (jVar != null) {
            jVar.dismiss();
        }
        if (z2 && this.I0) {
            this.z0.K2();
            this.s0.k1(true);
        }
    }

    @Override // d.a.n0.b1.m.h
    public void onVideoClicked(Context context, String str) {
        d.a.o0.e2.k.e.y0.a().e(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.A = true;
    }

    @Override // d.a.n0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
    }

    public final void p4(Rect rect) {
        d.a.o0.e2.k.e.t0 t0Var;
        if (rect == null || (t0Var = this.z0) == null || t0Var.T0() == null || rect.top > this.z0.T0().getHeight()) {
            return;
        }
        rect.top += this.z0.T0().getHeight() - rect.top;
    }

    public final void p5(View view, String str, String str2, PostData postData) {
        if (view == null || str == null || str2 == null || X3() || !a4()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.b0);
            this.c0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (N4().J0() != null && postData != null) {
            N4().J0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
        }
        if (this.s0.C0() != null && this.s0.C0().a0()) {
            d.a.c.e.m.e.a().postDelayed(new n0(str, str2), 0L);
            return;
        }
        if (this.T0 == null) {
            d.a.o0.r0.f2.a.c cVar = new d.a.o0.r0.f2.a.c(getPageContext());
            this.T0 = cVar;
            cVar.j(1);
            this.T0.i(new o0(str, str2));
        }
        PbModel pbModel = this.s0;
        if (pbModel == null || pbModel.C0() == null || this.s0.C0().l() == null) {
            return;
        }
        this.T0.g(this.s0.C0().l().getId(), d.a.c.e.m.b.f(this.s0.S0(), 0L));
    }

    public final void p6(d.a.n0.r.q.t tVar) {
        if (tVar != null) {
            this.z2 = tVar;
            this.f19060g = true;
            this.z0.e2();
            this.z0.x2(this.y2);
        }
    }

    public AntiData q4() {
        PbModel pbModel = this.s0;
        if (pbModel == null || pbModel.C0() == null) {
            return null;
        }
        return this.s0.C0().d();
    }

    public final void q5() {
        d.a.o0.e2.h.e C0 = this.s0.C0();
        this.s0.W1(true);
        d.a.n0.h.a aVar = this.u0;
        if (aVar != null) {
            C0.q0(aVar.g());
        }
        this.z0.l1(C0);
    }

    public final void q6(int i3) {
        d.a.n0.r.q.a2 L;
        PbModel pbModel = this.s0;
        if (pbModel == null || pbModel.C0() == null || (L = this.s0.C0().L()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData R0 = L.R0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (R0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i3);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    L.c4(praiseData);
                } else {
                    L.R0().getUser().add(0, metaData);
                    L.R0().setNum(L.R0().getNum() + 1);
                    L.R0().setIsLike(i3);
                }
            }
            if (L.R0() != null) {
                if (L.R0().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    StringHelper.numFormatOver10000(L.R0().getNum());
                }
            }
        } else if (L.R0() != null) {
            L.R0().setIsLike(i3);
            L.R0().setNum(L.R0().getNum() - 1);
            ArrayList<MetaData> user = L.R0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        L.R0().getUser().remove(next);
                        break;
                    }
                }
            }
            if (L.R0().getNum() < 1) {
                getResources().getString(R.string.zan);
            } else {
                String str = L.R0().getNum() + "";
            }
        }
        if (this.s0.Q0()) {
            this.z0.l0().U();
        } else {
            this.z0.C3(this.s0.C0());
        }
    }

    public final int r4() {
        if (this.s0.C0() == null || this.s0.C0().L() == null) {
            return -1;
        }
        return this.s0.C0().L().G();
    }

    public final void r5() {
        MarkData V;
        if (this.u0 != null) {
            if (this.s0.C0() != null && this.s0.C0().a0()) {
                V = this.s0.V(0);
            } else {
                V = this.s0.V(this.z0.A0());
            }
            if (V == null) {
                return;
            }
            if (V.isApp() && (V = this.s0.V(this.z0.A0() + 1)) == null) {
                return;
            }
            this.z0.J2();
            this.u0.i(V);
            if (!this.u0.e()) {
                this.u0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.u0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final TbRichText r6(String str, int i3) {
        PbModel pbModel = this.s0;
        TbRichText tbRichText = null;
        if (pbModel == null || pbModel.C0() == null || str == null || i3 < 0) {
            return null;
        }
        d.a.o0.e2.h.e C0 = this.s0.C0();
        if (C0.j() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(C0.j());
            tbRichText = y4(arrayList, str, i3);
        }
        if (tbRichText == null) {
            ArrayList<PostData> D = C0.D();
            V3(C0, D);
            return y4(D, str, i3);
        }
        return tbRichText;
    }

    public final int s4() {
        if (N4() != null && N4().B0() != null) {
            BdTypeListView B0 = N4().B0();
            List<d.a.c.k.e.n> data = B0.getData();
            int headerViewsCount = B0.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i3 = 0; i3 < size; i3++) {
                    d.a.c.k.e.n nVar = data.get(i3);
                    if ((nVar instanceof PostData) && nVar.getType() == PostData.u0) {
                        return i3 + headerViewsCount;
                    }
                }
            }
        }
        return -1;
    }

    public final void s5(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e3) {
            e3.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        t5(postData);
    }

    public PostData t4() {
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        PbModel pbModel = this.s0;
        return t0Var.t0(pbModel.I, pbModel.Q0());
    }

    public void t5(PostData postData) {
        PostData t4;
        if (postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.E() != null && postData.E().equals(this.s0.x0())) {
            z2 = true;
        }
        MarkData w02 = this.s0.w0(postData);
        if (this.s0.C0() != null && this.s0.C0().a0() && (t4 = t4()) != null) {
            w02 = this.s0.w0(t4);
        }
        if (w02 == null) {
            return;
        }
        this.z0.J2();
        d.a.n0.h.a aVar = this.u0;
        if (aVar != null) {
            aVar.i(w02);
            if (!z2) {
                this.u0.a();
            } else {
                this.u0.d();
            }
        }
    }

    public String u4() {
        return this.O;
    }

    public final boolean u5(String str) {
        if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String p3 = d.a.n0.r.d0.b.j().p("bubble_link", "");
            if (StringUtils.isNull(p3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                d.a.n0.l.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p3 + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return false;
    }

    public int v4() {
        if (N4() != null && N4().B0() != null) {
            BdTypeListView B0 = N4().B0();
            List<d.a.c.k.e.n> data = B0.getData();
            int headerViewsCount = B0.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i3 = 0; i3 < size; i3++) {
                    d.a.c.k.e.n nVar = data.get(i3);
                    if ((nVar instanceof d.a.o0.e2.h.o) && ((d.a.o0.e2.h.o) nVar).f56770f == d.a.o0.e2.h.o.m) {
                        return i3 + headerViewsCount;
                    }
                }
            }
        }
        return -1;
    }

    public final String w4() {
        d.a.o0.e2.h.e C0;
        PbModel pbModel = this.s0;
        if (pbModel == null || (C0 = pbModel.C0()) == null) {
            return null;
        }
        return C0.Q().f56792c;
    }

    public final void w5() {
        if (!d.a.c.e.p.j.z()) {
            showToast(R.string.network_not_available);
            return;
        }
        this.z0.a0();
        if (this.m) {
            return;
        }
        k6();
        this.z0.J2();
        if (this.s0.LoadData()) {
            this.z0.l3();
        }
    }

    @Override // d.a.o0.e2.o.i
    public VideoPbFragment x() {
        return null;
    }

    public final String x4() {
        ArrayList<PostData> D;
        int count;
        PbModel pbModel = this.s0;
        if (pbModel == null || pbModel.C0() == null || this.s0.C0().D() == null || (count = ListUtils.getCount((D = this.s0.C0().D()))) == 0) {
            return "";
        }
        if (this.s0.N0()) {
            Iterator<PostData> it = D.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.A() == 1) {
                    return next.E();
                }
            }
        }
        int s02 = this.z0.s0();
        PostData postData = (PostData) ListUtils.getItem(D, s02);
        if (postData != null && postData.t() != null) {
            if (this.s0.i1(postData.t().getUserId())) {
                return postData.E();
            }
            for (int i3 = s02 - 1; i3 != 0; i3--) {
                PostData postData2 = (PostData) ListUtils.getItem(D, i3);
                if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                    break;
                } else if (this.s0.i1(postData2.t().getUserId())) {
                    return postData2.E();
                }
            }
            for (int i4 = s02 + 1; i4 < count; i4++) {
                PostData postData3 = (PostData) ListUtils.getItem(D, i4);
                if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                    break;
                } else if (this.s0.i1(postData3.t().getUserId())) {
                    return postData3.E();
                }
            }
        }
        return "";
    }

    public void x5() {
        d.a.o0.e2.h.e C0;
        d.a.n0.r.q.a2 L;
        PbModel pbModel = this.s0;
        if (pbModel == null || pbModel.C0() == null || (L = (C0 = this.s0.C0()).L()) == null || L.T() == null) {
            return;
        }
        this.z0.Y0();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), L.T().getUserId());
        d.a.o0.e2.k.e.g0 g0Var = new d.a.o0.e2.k.e.g0();
        int S = this.s0.C0().S();
        if (S != 1 && S != 3) {
            g0Var.f57156g = false;
        } else {
            g0Var.f57156g = true;
            g0Var.q = L.y0() == 1;
        }
        if (h5(S)) {
            g0Var.f57157h = true;
            g0Var.p = L.x0() == 1;
        } else {
            g0Var.f57157h = false;
        }
        if (S == 1002 && !equals) {
            g0Var.r = true;
        }
        g0Var.f57154e = W5(equals);
        g0Var.f57158i = Y5();
        g0Var.f57155f = X5(equals);
        g0Var.k = equals && C0.R() != null && C0.R().showPbPrivate();
        g0Var.o = this.s0.Q0();
        g0Var.f57151b = true;
        g0Var.f57150a = j5(equals);
        if (equals) {
            this.z0.m1();
        }
        g0Var.n = TbadkCoreApplication.getInst().getSkinType() == 1;
        g0Var.j = true;
        g0Var.m = this.s0.h0();
        g0Var.f57153d = true;
        if (L.x1() == null) {
            g0Var.f57152c = true;
        } else {
            g0Var.f57152c = false;
        }
        if (C0.a0()) {
            g0Var.f57151b = false;
            g0Var.f57153d = false;
            g0Var.f57152c = false;
            g0Var.f57156g = false;
            g0Var.f57157h = false;
        }
        g0Var.s = TbSingleton.getInstance().mShowCallFans && equals && !C0.a0();
        d.a.o0.e2.k.e.t0 t0Var = this.z0;
        if (t0Var != null) {
            PbModel pbModel2 = this.s0;
            PostData t02 = t0Var.t0(pbModel2.I, pbModel2.Q0());
            g0Var.t = t02 != null ? t02.S : false;
        }
        g0Var.l = true;
        if (d.a.n0.c1.b.e.d()) {
            g0Var.f57153d = false;
            g0Var.f57151b = false;
            g0Var.f57152c = false;
            g0Var.l = false;
        }
        this.z0.f57261h.w(g0Var);
    }

    public final TbRichText y4(ArrayList<PostData> arrayList, String str, int i3) {
        ArrayList<TbRichTextData> y2;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                TbRichText K = arrayList.get(i4).K();
                if (K != null && (y2 = K.y()) != null) {
                    int size = y2.size();
                    int i5 = -1;
                    for (int i6 = 0; i6 < size; i6++) {
                        if (y2.get(i6) != null && y2.get(i6).getType() == 8) {
                            i5++;
                            if (y2.get(i6).B().y().equals(str) || y2.get(i6).B().z().equals(str)) {
                                int h3 = (int) d.a.c.e.p.l.h(TbadkCoreApplication.getInst());
                                int width = y2.get(i6).B().getWidth() * h3;
                                int height = y2.get(i6).B().getHeight() * h3;
                                if (width < 80 || height < 80 || width * height < 10000) {
                                    return null;
                                }
                                this.k2 = i6;
                                return K;
                            } else if (i5 > i3) {
                                break;
                            }
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public final void y5(String str, int i3, PbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        if (eVar == null) {
            return;
        }
        d.a.o0.e2.h.e C0 = this.s0.C0();
        TbRichText r6 = r6(str, i3);
        if (r6 == null || (tbRichTextData = r6.y().get(this.k2)) == null) {
            return;
        }
        eVar.f19019f = String.valueOf(r6.getPostId());
        eVar.f19014a = new ArrayList<>();
        eVar.f19015b = new ConcurrentHashMap<>();
        if (!tbRichTextData.B().D()) {
            eVar.f19021h = false;
            String a3 = d.a.o0.e2.h.f.a(tbRichTextData);
            eVar.f19014a.add(a3);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.w ? 17 : 18;
            }
            imageUrlData.originalUrl = I4(tbRichTextData);
            imageUrlData.originalUrl = I4(tbRichTextData);
            imageUrlData.originalSize = J4(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = D4(tbRichTextData);
            imageUrlData.isLongPic = B4(tbRichTextData);
            imageUrlData.postId = r6.getPostId();
            imageUrlData.mIsReserver = this.s0.N0();
            imageUrlData.mIsSeeHost = this.s0.h0();
            eVar.f19015b.put(a3, imageUrlData);
            if (C0 != null) {
                if (C0.l() != null) {
                    eVar.f19016c = C0.l().getName();
                    eVar.f19017d = C0.l().getId();
                }
                if (C0.L() != null) {
                    eVar.f19018e = C0.L().o0();
                }
                eVar.f19020g = C0.s() == 1;
            }
            imageUrlData.threadId = d.a.c.e.m.b.f(eVar.f19018e, -1L);
            return;
        }
        eVar.f19021h = true;
        int size = C0.D().size();
        this.m2 = false;
        eVar.j = -1;
        int z4 = C0.j() != null ? z4(C0.j().K(), r6, i3, i3, eVar.f19014a, eVar.f19015b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = C0.D().get(i4);
            if (postData.E() == null || C0.j() == null || C0.j().E() == null || !postData.E().equals(C0.j().E())) {
                z4 = z4(postData.K(), r6, z4, i3, eVar.f19014a, eVar.f19015b);
            }
        }
        if (eVar.f19014a.size() > 0) {
            ArrayList<String> arrayList = eVar.f19014a;
            eVar.f19022i = arrayList.get(arrayList.size() - 1);
        }
        if (C0 != null) {
            if (C0.l() != null) {
                eVar.f19016c = C0.l().getName();
                eVar.f19017d = C0.l().getId();
            }
            if (C0.L() != null) {
                eVar.f19018e = C0.L().o0();
            }
            eVar.f19020g = C0.s() == 1;
        }
        eVar.j = z4;
    }

    public final int z4(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        TbRichTextImageInfo B;
        if (tbRichText == tbRichText2) {
            this.m2 = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.y().size();
            int i5 = i3;
            int i6 = -1;
            for (int i7 = 0; i7 < size; i7++) {
                TbRichTextData tbRichTextData = tbRichText.y().get(i7);
                if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                    i6++;
                    int h3 = (int) d.a.c.e.p.l.h(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.B().getWidth() * h3;
                    int height = tbRichTextData.B().getHeight() * h3;
                    if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.B().D()) {
                        if (tbRichText == tbRichText2) {
                            if (i6 <= i4) {
                                i5--;
                            }
                        }
                    } else if (tbRichTextData.getType() != 20) {
                        String a3 = d.a.o0.e2.h.f.a(tbRichTextData);
                        if (!TextUtils.isEmpty(a3)) {
                            arrayList.add(a3);
                            if (tbRichTextData != null && (B = tbRichTextData.B()) != null) {
                                String y2 = B.y();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    y2 = B.z();
                                } else {
                                    imageUrlData.urlType = this.w ? 17 : 18;
                                }
                                imageUrlData.imageUrl = y2;
                                imageUrlData.originalUrl = I4(tbRichTextData);
                                imageUrlData.originalSize = J4(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = D4(tbRichTextData);
                                imageUrlData.isLongPic = B4(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = d.a.c.e.m.b.f(this.s0.S0(), -1L);
                                imageUrlData.mIsReserver = this.s0.N0();
                                imageUrlData.mIsSeeHost = this.s0.h0();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(a3, imageUrlData);
                                }
                            }
                        }
                        if (!this.m2) {
                            i5++;
                        }
                    }
                }
            }
            return i5;
        }
        return i3;
    }

    public void z5() {
        PbModel pbModel;
        if (!checkUpIsLogin() || (pbModel = this.s0) == null || pbModel.C0() == null || this.s0.C0().l() == null || X3()) {
            return;
        }
        if (this.s0.C0().a0()) {
            this.z0.T();
            return;
        }
        if (this.S0 == null) {
            d.a.o0.r0.f2.a.c cVar = new d.a.o0.r0.f2.a.c(getPageContext());
            this.S0 = cVar;
            cVar.j(0);
            this.S0.i(new l0());
        }
        this.S0.g(this.s0.C0().l().getId(), d.a.c.e.m.b.f(this.s0.S0(), 0L));
    }
}
