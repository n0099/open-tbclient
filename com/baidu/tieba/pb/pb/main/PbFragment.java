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
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
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
import d.a.m0.a0.d;
import d.a.m0.b1.m.f;
import d.a.m0.h.a;
import d.a.m0.r.f0.f;
import d.a.m0.r.q.b1;
import d.a.m0.r.s.a;
import d.a.m0.r.s.b;
import d.a.m0.r.s.l;
import d.a.n0.e2.i.c;
import d.a.n0.e2.k.e.c1.b;
import d.a.n0.e2.k.e.e0;
import d.a.n0.e2.k.e.q;
import d.a.n0.e2.p.e;
import d.a.n0.e3.j0.a;
import d.a.n0.g0.a;
import d.a.n0.g0.b;
import d.a.n0.r0.f2.a.c;
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
public class PbFragment extends BaseFragment implements d.a.m0.b1.m.h, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a.e, TbRichTextView.r, TbPageContextSupport, d.a.n0.e2.o.i, e.b {
    public static final AntiHelper.k A2 = new g0();
    public static final b.InterfaceC1340b B2 = new e2();
    public d.a.m0.r.s.l A0;
    public String B0;
    public boolean D0;
    public d.a.c.e.k.b<TextView> E;
    public d.a.c.e.k.b<TbImageView> F;
    public d.a.c.e.k.b<ImageView> G;
    public boolean G1;
    public d.a.c.e.k.b<View> H;
    public d.a.c.e.k.b<LinearLayout> I;
    public d.a.c.e.k.b<RelativeLayout> J;
    public d.a.n0.e3.h0.f M0;
    public d.a.c.e.k.b<GifView> N;
    public d.a.m0.w.w.g N0;
    public d.a.m0.w.w.e O0;
    public boolean P0;
    public PermissionJudgePolicy Q0;
    public ReplyPrivacyCheckController R0;
    public d.a.n0.e2.k.e.b1.f.a S;
    public d.a.n0.r0.f2.a.c S0;
    public LikeModel T;
    public d.a.n0.r0.f2.a.c T0;
    public View U;
    public EmotionImageData U0;
    public View V;
    public View W;
    public View X;
    public String Y;
    public Object Z0;
    public boolean a0;
    public d.a.c.a.f a1;
    public d.a.m0.r.f0.c b1;
    public int c0;
    public BdUniqueId c1;
    public Runnable d1;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f18899e;
    public d.a.n0.e2.k.e.x0 e1;
    public d.a.m0.r.q.k1 f0;
    public d.a.c.j.d.a f1;
    public String g1;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.g0.b f18902h;
    public d.a.m0.r.b0.a h0;
    public TbRichTextMemeInfo h1;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.e2.k.e.c1.b f18903i;
    public boolean i2;
    public boolean j;
    public d.a.n0.e3.h0.e j0;
    public List<p2> l1;
    public boolean m;
    public String n1;
    public VoiceManager o;
    public d.a.n0.e2.k.f.a o0;
    public d.a.n0.y.a o1;
    public boolean w;
    public d.a.n0.e2.k.e.v0 y0;
    public String y2;
    public d.a.m0.r.s.j z0;
    public d.a.m0.r.q.t z2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18900f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18901g = false;
    public boolean k = false;
    public boolean l = false;
    public boolean n = true;
    public int p = 0;
    public d.a.m0.r.s.b q = null;
    public long r = -1;
    public long s = 0;
    public long t = 0;
    public long u = 0;
    public long v = 0;
    public boolean x = false;
    public d.a.m0.m0.b y = null;
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
    public int d0 = -1;
    public int e0 = -1;
    public BdUniqueId g0 = BdUniqueId.gen();
    public boolean i0 = false;
    public boolean k0 = d.a.m0.b.d.W();
    public PbInterviewStatusView.f l0 = new k();
    public final Handler m0 = new Handler(new v());
    public PbModel n0 = null;
    public d.a.m0.h.a p0 = null;
    public ForumManageModel q0 = null;
    public d.a.m0.s.e.a r0 = null;
    public d.a.n0.e2.h.s s0 = null;
    public ShareSuccessReplyToServerModel t0 = null;
    public d.a.n0.e2.k.e.t0 u0 = null;
    public boolean v0 = false;
    public boolean w0 = false;
    public boolean x0 = false;
    public boolean C0 = false;
    public boolean E0 = false;
    public boolean K0 = false;
    public boolean L0 = false;
    public d.a.m0.w.w.c V0 = new r0();
    public d.a.m0.w.w.b W0 = new c1();
    public d.a.m0.w.w.b X0 = new n1();
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
    public d.a.m0.f0.i K1 = new t();
    public CheckRealNameModel.b L1 = new x();
    public d.a.n0.e2.i.c M1 = new d.a.n0.e2.i.c(new z());
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
    public final a.InterfaceC1124a d2 = new y0();
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
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.m0.t.n)) {
                PbFragment.this.n0.Z1((d.a.m0.t.n) customResponsedMessage.getData());
                if (PbFragment.this.u0 != null && PbFragment.this.n0 != null) {
                    PbFragment.this.u0.b2(PbFragment.this.n0.y0(), PbFragment.this.n0.M0(), PbFragment.this.n0.I0(), PbFragment.this.u0.Q0());
                }
                if (PbFragment.this.u0 == null || PbFragment.this.u0.l0() == null) {
                    return;
                }
                PbFragment.this.u0.l0().U();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements b.c {
        public a0() {
        }

        @Override // d.a.m0.r.s.b.c
        public void a(d.a.m0.r.s.b bVar, int i2, View view) {
            if (i2 == 0) {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                PbFragment pbFragment = PbFragment.this;
                pbFragment.B0 = pbFragment.B0.trim();
                UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.B0);
                new d.a.n0.e2.k.e.d(PbFragment.this.n0.O0(), PbFragment.this.B0, "1").start();
                bVar.e();
            } else if (i2 == 1) {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                PbFragment pbFragment2 = PbFragment.this;
                pbFragment2.B0 = pbFragment2.B0.trim();
                UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.B0);
                new d.a.n0.e2.k.e.d(PbFragment.this.n0.O0(), PbFragment.this.B0, "2").start();
                bVar.e();
            } else if (i2 == 2) {
                PbFragment pbFragment3 = PbFragment.this;
                pbFragment3.B0 = pbFragment3.B0.trim();
                UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.B0);
                bVar.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f18906e;

        public a1(MetaData metaData) {
            this.f18906e = metaData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f18906e.getUserId()).param("obj_locate", 1));
            aVar.dismiss();
            PbFragment.this.r0.m(!this.f18906e.hadConcerned(), this.f18906e.getPortrait(), this.f18906e.getUserId(), this.f18906e.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.n0.getForumId(), "0");
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements NoNetworkView.b {
        public a2() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (!PbFragment.this.k && z && !PbFragment.this.n0.o0()) {
                PbFragment.this.C5();
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
            if (PbFragment.this.u0 == null) {
                return;
            }
            if (booleanValue) {
                PbFragment.this.u0.l3();
            } else {
                PbFragment.this.u0.c1();
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
                PbFragment.this.u0.a1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                d.a.n0.e2.h.e y0 = PbFragment.this.n0.y0();
                if (y0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    y0.u().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.b1.c(PbFragment.this.a1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.a1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.c6(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.X5();
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
            if (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || PbFragment.this.u0 == null || PbFragment.this.u0.l0() == null) {
                return;
            }
            PbFragment.this.u0.N1(absListView, i2, i3, i4);
            if (PbFragment.this.f18903i != null) {
                PbFragment.this.f18903i.q(absListView, i2, i3, i4);
            }
            if (!PbFragment.this.n0.Z0() || (D = PbFragment.this.n0.y0().D()) == null || D.isEmpty()) {
                return;
            }
            int v = ((i2 + i3) - PbFragment.this.u0.l0().v()) - 1;
            d.a.n0.e2.h.e y0 = PbFragment.this.n0.y0();
            if (y0 == null) {
                return;
            }
            if (y0.B() != null && y0.B().C0()) {
                v--;
            }
            if (y0.C() != null && y0.C().C0()) {
                v--;
            }
            int size = D.size();
            if (v < 0 || v >= size) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            PbFragment pbFragment = PbFragment.this;
            if (!pbFragment.f5(pbFragment.Y0) && PbFragment.this.f5(i2)) {
                if (PbFragment.this.u0 != null) {
                    PbFragment.this.u0.a0();
                    if (PbFragment.this.O0 != null && !PbFragment.this.u0.n1()) {
                        PbFragment.this.u0.o2(PbFragment.this.O0.C());
                    }
                    if (!PbFragment.this.L) {
                        PbFragment.this.u0.h2();
                    }
                }
                if (!PbFragment.this.x) {
                    PbFragment.this.x = true;
                }
            }
            if (PbFragment.this.u0 != null) {
                PbFragment.this.u0.O1(absListView, i2);
            }
            if (PbFragment.this.f18903i != null) {
                PbFragment.this.f18903i.r(absListView, i2);
            }
            if (PbFragment.this.y == null) {
                PbFragment.this.y = new d.a.m0.m0.b();
                PbFragment.this.y.a(1001);
            }
            if (i2 == 0) {
                PbFragment.this.y.e();
            } else {
                PbFragment.this.y.d();
            }
            PbFragment.this.Y0 = i2;
            if (i2 == 0) {
                PbFragment.this.H5(false, null);
                d.a.n0.d3.c.g().h(PbFragment.this.getUniqueId(), true);
                PbFragment.this.T3(true);
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
                PbFragment.this.u0.o2(PbFragment.this.O0.C());
            }
            PbFragment.this.u0.V2(false);
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
                PbFragment.this.u0.a1();
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
    public class c1 implements d.a.m0.w.w.b {
        public c1() {
        }

        @Override // d.a.m0.w.w.b
        public boolean a() {
            d.a.n0.e2.k.e.v0 v0Var = PbFragment.this.y0;
            if (v0Var == null || v0Var.e() == null || !PbFragment.this.y0.e().d()) {
                return !PbFragment.this.Y3(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.showToast(pbFragment.y0.e().c());
            if (PbFragment.this.O0 != null && (PbFragment.this.O0.B() || PbFragment.this.O0.D())) {
                PbFragment.this.O0.z(false, PbFragment.this.y0.h());
            }
            PbFragment.this.y0.a(true);
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
            PbFragment.this.f18902h.c(motionEvent);
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
            d.a.n0.e2.e eVar = (d.a.n0.e2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                PbFragment.this.B5((d.a.n0.e2.h.r) eVar.a());
            } else if (b2 == 1) {
                PbFragment.this.k4((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    PbFragment.this.A5(false, null);
                } else {
                    PbFragment.this.A5(true, (MarkData) eVar.a());
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
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.n0.p3.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.c1) {
                d.a.n0.p3.a aVar = (d.a.n0.p3.a) customResponsedMessage.getData();
                PbFragment.this.u0.a1();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.Z0;
                DataRes dataRes = aVar.f58160a;
                if (aVar.f58162c == 0 && dataRes != null) {
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
                    PbFragment.this.Y5(r2, sparseArray);
                } else if (intValue == 1) {
                    PbFragment.this.u0.T1(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements Comparator<d.a.m0.t.a> {
        public d1() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a.m0.t.a aVar, d.a.m0.t.a aVar2) {
            return aVar.compareTo(aVar2);
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final int f18920a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        public d2() {
        }

        @Override // d.a.n0.g0.a.b
        public void a(int i2, int i3) {
            if (!e(i3) || PbFragment.this.u0 == null || PbFragment.this.f18903i == null) {
                return;
            }
            PbFragment.this.f18903i.u(true);
            if (Math.abs(i3) > this.f18920a) {
                PbFragment.this.f18903i.l();
            }
            if (PbFragment.this.z4()) {
                PbFragment.this.u0.b1();
                PbFragment.this.u0.j2();
            }
        }

        @Override // d.a.n0.g0.a.b
        public void b(int i2, int i3) {
            if (!e(i3) || PbFragment.this.u0 == null || PbFragment.this.f18903i == null) {
                return;
            }
            PbFragment.this.u0.j3();
            PbFragment.this.f18903i.u(false);
            PbFragment.this.f18903i.x();
        }

        @Override // d.a.n0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.n0.g0.a.b
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
            if (PbFragment.this.u0 == null || PbFragment.this.u0.l0() == null) {
                return;
            }
            PbFragment.this.u0.l0().U();
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
            if (PbFragment.this.u0.n1() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.h4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements AntiHelper.k {
        public e1() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }
    }

    /* loaded from: classes5.dex */
    public static class e2 implements b.InterfaceC1340b {
        @Override // d.a.n0.g0.b.InterfaceC1340b
        public void a(boolean z) {
            if (z) {
                d.a.n0.e2.i.b.d();
            } else {
                d.a.n0.e2.i.b.c();
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
            d.a.m0.b1.m.f.c(PbFragment.this.getPageContext(), PbFragment.this, aVar.f49129a, aVar.f49130b, aVar.f49131c);
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
                    switch (PbFragment.this.q0.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.n0.V0();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            PbFragment.this.k4(bVar, (bVar.f20829e != 1002 || bVar.f20830f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.u0.i0(1, dVar.f20832a, dVar.f20833b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = PbFragment.this;
                            pbFragment.l4(pbFragment.q0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.u0.i0(PbFragment.this.q0.getLoadDataMode(), gVar.f20846a, gVar.f20847b, false);
                            PbFragment.this.u0.P1(gVar.f20848c);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.u0.i0(PbFragment.this.q0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f2 implements q.b {
        public f2() {
        }

        @Override // d.a.n0.e2.k.e.q.b
        public void a(int i2, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i2 == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i2 != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.u0.Y(str);
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
            PbFragment.this.e6();
        }
    }

    /* loaded from: classes5.dex */
    public static class g0 implements AntiHelper.k {
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
    public class g1 implements a.e {
        public g1() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g2 implements a.e {
        public g2() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
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

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            PbFragment.this.U4();
            d.a.m0.r.q.z0 w0 = PbFragment.this.n0.w0();
            int G0 = PbFragment.this.u0.G0();
            if (G0 <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (w0 == null || G0 <= w0.h()) {
                PbFragment.this.u0.a0();
                PbFragment.this.h6();
                PbFragment.this.u0.J2();
                if (d.a.c.e.p.j.z()) {
                    PbFragment.this.n0.R1(PbFragment.this.u0.G0());
                    if (PbFragment.this.f18903i != null) {
                        PbFragment.this.f18903i.x();
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

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.m0.r.q.i0)) {
                return;
            }
            d.a.m0.r.q.i0 i0Var = (d.a.m0.r.q.i0) customResponsedMessage.getData();
            b1.a aVar = new b1.a();
            int i2 = i0Var.f50043a;
            String str = i0Var.f50044b;
            aVar.f49948a = i0Var.f50046d;
            d.a.n0.e2.h.e y0 = PbFragment.this.n0.y0();
            if (y0 == null) {
                return;
            }
            if (PbFragment.this.n0.c0() != null && PbFragment.this.n0.c0().getUserIdLong() == i0Var.p) {
                PbFragment.this.u0.a2(i0Var.l, PbFragment.this.n0.y0(), PbFragment.this.n0.M0(), PbFragment.this.n0.I0());
            }
            if (y0.D() == null || y0.D().size() < 1 || y0.D().get(0) == null) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(y0.D().get(0).E(), 0L);
            long f3 = d.a.c.e.m.b.f(PbFragment.this.n0.O0(), 0L);
            if (f2 == i0Var.n && f3 == i0Var.m) {
                d.a.m0.r.q.b1 D = y0.D().get(0).D();
                if (D == null) {
                    D = new d.a.m0.r.q.b1();
                }
                ArrayList<b1.a> a2 = D.a();
                if (a2 == null) {
                    a2 = new ArrayList<>();
                }
                a2.add(0, aVar);
                D.e(D.b() + i0Var.l);
                D.d(a2);
                y0.D().get(0).k0(D);
                PbFragment.this.u0.l0().U();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements l.e {
        public i0() {
        }

        @Override // d.a.m0.r.s.l.e
        public void onItemClick(d.a.m0.r.s.l lVar, int i2, View view) {
            SparseArray sparseArray;
            if (PbFragment.this.z0 != null) {
                PbFragment.this.z0.dismiss();
            }
            PbFragment.this.k6(i2);
            int i3 = 4;
            switch (i2) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    PbFragment.this.y5(view2);
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    }
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    PbFragment.this.y5(view3);
                    if (view3 != null) {
                        view3.performClick();
                        return;
                    }
                    return;
                case -2:
                    View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                    if (view4 != null) {
                        AgreeView agreeView = (AgreeView) view4;
                        PbFragment.this.y5(view4);
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
                        PbFragment.this.y5(view5);
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
                        aVar.f48819a = PbFragment.this.g1;
                        String str = "";
                        if (PbFragment.this.h1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + PbFragment.this.h1.memeInfo.pck_id;
                        }
                        aVar.f48820b = str;
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
                        pbFragment.e1 = new d.a.n0.e2.k.e.x0(pbFragment.getPageContext());
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
                        PbFragment.this.p5(view);
                        if (PbFragment.this.n0.y0().L() == null || PbFragment.this.n0.y0().L().T() == null || PbFragment.this.n0.y0().L().T().getUserId() == null || PbFragment.this.p0 == null) {
                            return;
                        }
                        PbFragment pbFragment3 = PbFragment.this;
                        int N4 = pbFragment3.N4(pbFragment3.n0.y0());
                        d.a.m0.r.q.a2 L = PbFragment.this.n0.y0().L();
                        if (L.Q1()) {
                            i3 = 2;
                        } else if (L.T1()) {
                            i3 = 3;
                        } else if (!L.R1()) {
                            i3 = L.S1() ? 5 : 1;
                        }
                        TiebaStatic.log(new StatisticItem("c12526").param("tid", PbFragment.this.n0.f19095e).param("obj_locate", 2).param("obj_id", PbFragment.this.n0.y0().L().T().getUserId()).param("obj_type", !PbFragment.this.p0.e()).param("obj_source", N4).param("obj_param1", i3));
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
                        PbFragment.this.S4((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.W3(sparseArray2);
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
                        boolean isHost = PbFragment.this.A().isHost(TbadkCoreApplication.getCurrentAccount());
                        if (isHost) {
                            if (!booleanValue2) {
                                PbFragment.this.S5(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                PbFragment.this.u0.S1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, isHost);
                                return;
                            }
                        } else if (booleanValue && !booleanValue2) {
                            PbFragment.this.S5(sparseArray3, intValue, booleanValue);
                            return;
                        } else {
                            PbFragment.this.u0.Q1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
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
                            PbFragment.this.u0.Q1(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        }
                        return;
                    } else if (booleanValue5) {
                        sparseArray4.put(R.id.tag_from, 1);
                        sparseArray4.put(R.id.tag_check_mute_from, 2);
                        PbFragment.this.W3(sparseArray4);
                        return;
                    } else {
                        sparseArray4.put(R.id.tag_check_mute_from, 2);
                        PbFragment.this.u0.U1(view);
                        return;
                    }
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData2.r() == null) {
                            return;
                        }
                        PbFragment.this.Z3(postData2.r());
                        return;
                    }
                    return;
                case 9:
                    if (!PbFragment.this.checkUpIsLogin() || PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null) {
                        return;
                    }
                    PbFragment.this.f18899e.showBlockDialog(d.a.n0.o3.a.b(view));
                    return;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements f.g {
        public i1() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.z4()) {
                PbFragment.this.f18899e.finish();
            }
            if (!PbFragment.this.n0.l1(true)) {
                PbFragment.this.u0.h0();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements a.e {
        public i2() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
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
            if (customResponsedMessage == null || PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null) {
                return;
            }
            PbFragment.this.n0.y0().a();
            PbFragment.this.n0.V0();
            if (PbFragment.this.u0.l0() != null) {
                PbFragment.this.u0.l1(PbFragment.this.n0.y0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f18941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f18942f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f18943g;

        public j0(SparseArray sparseArray, int i2, boolean z) {
            this.f18941e = sparseArray;
            this.f18942f = i2;
            this.f18943g = z;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (aVar != null) {
                aVar.dismiss();
            }
            PbFragment.this.g4(((Integer) this.f18941e.get(R.id.tag_del_post_type)).intValue(), (String) this.f18941e.get(R.id.tag_del_post_id), this.f18942f, this.f18943g);
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements BdListView.p {
        public j1() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (PbFragment.this.i2 && PbFragment.this.z4()) {
                PbFragment.this.i5();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.i0 && PbFragment.this.u0 != null && PbFragment.this.u0.S() && PbFragment.this.n0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", PbFragment.this.n0.O0());
                    statisticItem.param("fid", PbFragment.this.n0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i2 = 5;
                    if (PbFragment.this.n0.e0()) {
                        i2 = 4;
                    } else if (PbFragment.this.n0.f0()) {
                        i2 = 3;
                    } else if (PbFragment.this.n0.h0()) {
                        i2 = 1;
                    }
                    statisticItem.param("obj_type", i2);
                    TiebaStatic.log(statisticItem);
                    PbFragment.this.i0 = true;
                }
                if (PbFragment.this.n0.h1(false)) {
                    PbFragment.this.u0.K2();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.n0.y0() != null) {
                    PbFragment.this.u0.d2();
                }
                PbFragment.this.i2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j2 implements e0.b {
        public j2() {
        }

        @Override // d.a.n0.e2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            if (StringUtils.isNull(str)) {
                return;
            }
            PbFragment.this.u0.r3(str);
        }

        @Override // d.a.n0.e2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
        }
    }

    /* loaded from: classes5.dex */
    public class k implements PbInterviewStatusView.f {
        public k() {
        }

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            PbFragment.this.u0.o3(!PbFragment.this.P);
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements a.e {
        public k0() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements Runnable {
        public k1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PbFragment.this.n0 != null) {
                PbFragment.this.n0.LoadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f18950e;

        public k2(UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            this.f18950e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            PbFragment.this.u0.c3();
            MessageManager.getInstance().sendMessage(this.f18950e);
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
            if (customResponsedMessage == null || PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            PbFragment.this.d4(str);
            PbFragment.this.n0.V0();
            if (!TextUtils.isEmpty(str) && PbFragment.this.n0.y0().D() != null) {
                ArrayList<PostData> D = PbFragment.this.n0.y0().D();
                d.a.n0.e3.h0.o oVar = null;
                Iterator<PostData> it = D.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof d.a.n0.e3.h0.o) {
                        d.a.n0.e3.h0.o oVar2 = (d.a.n0.e3.h0.o) next;
                        if (str.equals(oVar2.D0())) {
                            oVar = oVar2;
                            break;
                        }
                    }
                }
                if (oVar != null) {
                    D.remove(oVar);
                    if (PbFragment.this.u0.l0() != null && PbFragment.this.u0.l0().r() != null) {
                        PbFragment.this.u0.l0().r().remove(oVar);
                    }
                    if (PbFragment.this.u0.B0() != null && PbFragment.this.u0.B0().getData() != null) {
                        PbFragment.this.u0.B0().getData().remove(oVar);
                    }
                    if (PbFragment.this.u0.l0() != null) {
                        PbFragment.this.u0.l0().U();
                        return;
                    }
                }
            }
            if (PbFragment.this.u0.l0() != null) {
                PbFragment.this.u0.l1(PbFragment.this.n0.y0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements c.d {
        public l0() {
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void a(boolean z, int i2) {
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                if (PbFragment.this.O0 != null && PbFragment.this.O0.a() != null) {
                    PbFragment.this.O0.a().A(new d.a.m0.w.a(45, 27, null));
                }
                PbFragment.this.u0.T();
            }
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements ShareSuccessReplyToServerModel.b {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f18955e;

            public a(CustomDialogData customDialogData) {
                this.f18955e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.n0.e2.j.c.a(PbFragment.this.getPageContext(), this.f18955e).show();
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

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class m implements SuggestEmotionModel.c {
        public m() {
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(d.a.n0.e2.k.e.b1.e.a aVar) {
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
            PbFragment.this.u0.a0();
            boolean z = false;
            if (d.a.c.e.p.j.z()) {
                if (PbFragment.this.n0 != null && !PbFragment.this.n0.isLoading) {
                    PbFragment.this.h6();
                    PbFragment.this.u0.J2();
                    z = true;
                    if (PbFragment.this.n0.y0() != null && PbFragment.this.n0.y0().f52924f != null && PbFragment.this.n0.y0().f52924f.size() > i2) {
                        int intValue = PbFragment.this.n0.y0().f52924f.get(i2).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", PbFragment.this.n0.P0()).param("fid", PbFragment.this.n0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (PbFragment.this.n0.X1(intValue)) {
                            PbFragment.this.m = true;
                            PbFragment.this.u0.y2(true);
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
        public final /* synthetic */ MarkData f18960e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f18961f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f18962g;

        public m1(MarkData markData, MarkData markData2, d.a.m0.r.s.a aVar) {
            this.f18960e = markData;
            this.f18961f = markData2;
            this.f18962g = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
            if (PbFragment.this.p0 != null) {
                if (PbFragment.this.p0.e()) {
                    PbFragment.this.p0.d();
                    PbFragment.this.p0.h(false);
                }
                PbFragment.this.p0.i(this.f18960e);
                PbFragment.this.p0.h(true);
                PbFragment.this.p0.a();
            }
            this.f18961f.setPostId(this.f18960e.getPostId());
            Intent intent = new Intent();
            intent.putExtra("mark", this.f18961f);
            PbFragment.this.f18899e.setResult(-1, intent);
            this.f18962g.dismiss();
            PbFragment.this.i6();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
        }
    }

    /* loaded from: classes5.dex */
    public class m2 extends d.a.m0.z0.f0<ShareItem> {
        public m2() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.a.n0.e2.k.e.e1.b.c(PbFragment.this.getContext(), PbFragment.this.o4(), ShareSwitch.isOn() ? 1 : 6, PbFragment.this.n0);
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
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue() || PbFragment.this.u0 == null || PbFragment.this.n0 == null) {
                return;
            }
            PbFragment.this.u0.U(false);
            if (PbFragment.this.n0.h1(false)) {
                PbFragment.this.u0.K2();
            } else if (PbFragment.this.n0.y0() != null) {
                PbFragment.this.u0.d2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18966e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f18967f;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public a() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.a.n0.e2.k.e.v0 v0Var = PbFragment.this.y0;
                if (v0Var == null || v0Var.g() == null) {
                    return;
                }
                if (!PbFragment.this.y0.g().e()) {
                    PbFragment.this.y0.b(false);
                }
                PbFragment.this.y0.g().l(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        }

        public n0(String str, String str2) {
            this.f18966e = str;
            this.f18967f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            int i3 = d.a.c.e.p.l.i(PbFragment.this.f18899e.getApplicationContext());
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
            pbFragment.K4().B0().smoothScrollBy((pbFragment.b0[1] + pbFragment.c0) - i4, 50);
            if (PbFragment.this.K4().J0() != null) {
                PbFragment.this.O0.a().setVisibility(8);
                PbFragment.this.K4().J0().n(this.f18966e, this.f18967f, PbFragment.this.K4().M0(), (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || PbFragment.this.n0.y0().L() == null || !PbFragment.this.n0.y0().L().U1()) ? false : false);
                d.a.m0.w.w.h b2 = PbFragment.this.K4().J0().b();
                if (b2 != null && PbFragment.this.n0 != null && PbFragment.this.n0.y0() != null) {
                    b2.E(PbFragment.this.n0.y0().d());
                    b2.X(PbFragment.this.n0.y0().L());
                }
                if (PbFragment.this.y0.f() == null && PbFragment.this.K4().J0().b().s() != null) {
                    PbFragment.this.K4().J0().b().s().g(new a());
                    PbFragment pbFragment2 = PbFragment.this;
                    pbFragment2.y0.n(pbFragment2.K4().J0().b().s().i());
                    PbFragment.this.K4().J0().b().K(PbFragment.this.X0);
                }
            }
            PbFragment.this.K4().W0();
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements d.a.m0.w.w.b {
        public n1() {
        }

        @Override // d.a.m0.w.w.b
        public boolean a() {
            d.a.n0.e2.k.e.v0 v0Var = PbFragment.this.y0;
            if (v0Var == null || v0Var.g() == null || !PbFragment.this.y0.g().d()) {
                return !PbFragment.this.Y3(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.showToast(pbFragment.y0.g().c());
            if (PbFragment.this.u0 != null && PbFragment.this.u0.J0() != null && PbFragment.this.u0.J0().b() != null && PbFragment.this.u0.J0().b().v()) {
                PbFragment.this.u0.J0().b().t(PbFragment.this.y0.h());
            }
            PbFragment.this.y0.b(true);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements d.a.m0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f18971a;

        public n2(int i2) {
            this.f18971a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Bundle bundle = new Bundle();
            bundle.putInt("source", 2);
            shareItem.k(bundle);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(PbFragment.this.getContext(), this.f18971a, shareItem, false));
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
            if (ListUtils.isEmpty(list) || PbFragment.this.u0 == null) {
                return;
            }
            PbFragment.this.u0.Q2(list);
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f18974a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18975b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$o0$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0204a implements TextWatcher {
                public C0204a() {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    d.a.n0.e2.k.e.v0 v0Var = PbFragment.this.y0;
                    if (v0Var == null || v0Var.g() == null) {
                        return;
                    }
                    if (!PbFragment.this.y0.g().e()) {
                        PbFragment.this.y0.b(false);
                    }
                    PbFragment.this.y0.g().l(false);
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
                pbFragment.K4().B0().smoothScrollBy((pbFragment.b0[1] + pbFragment.c0) - i4, 50);
                if (PbFragment.this.K4().J0() != null) {
                    PbFragment.this.O0.a().setVisibility(8);
                    z = (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || PbFragment.this.n0.y0().L() == null || !PbFragment.this.n0.y0().L().U1()) ? false : false;
                    d.a.n0.e2.k.e.u J0 = PbFragment.this.K4().J0();
                    o0 o0Var = o0.this;
                    J0.n(o0Var.f18974a, o0Var.f18975b, PbFragment.this.K4().M0(), z);
                    d.a.m0.w.w.h b2 = PbFragment.this.K4().J0().b();
                    if (b2 != null && PbFragment.this.n0 != null && PbFragment.this.n0.y0() != null) {
                        b2.E(PbFragment.this.n0.y0().d());
                        b2.X(PbFragment.this.n0.y0().L());
                    }
                    if (PbFragment.this.y0.f() == null && PbFragment.this.K4().J0().b().s() != null) {
                        PbFragment.this.K4().J0().b().s().g(new C0204a());
                        PbFragment pbFragment2 = PbFragment.this;
                        pbFragment2.y0.n(pbFragment2.K4().J0().b().s().i());
                        PbFragment.this.K4().J0().b().K(PbFragment.this.X0);
                    }
                }
                PbFragment.this.K4().W0();
            }
        }

        public o0(String str, String str2) {
            this.f18974a = str;
            this.f18975b = str2;
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void a(boolean z, int i2) {
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                d.a.c.e.m.e.a().postDelayed(new a(), 0L);
            }
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes5.dex */
    public class o1 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f18979e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f18980f;

        public o1(MarkData markData, d.a.m0.r.s.a aVar) {
            this.f18979e = markData;
            this.f18980f = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
            Intent intent = new Intent();
            intent.putExtra("mark", this.f18979e);
            PbFragment.this.f18899e.setResult(-1, intent);
            this.f18980f.dismiss();
            PbFragment.this.i6();
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
            if (PbFragment.this.n0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (PbFragment.this.O0 != null) {
                PbFragment.this.u0.o2(PbFragment.this.O0.C());
            }
            PbFragment.this.u0.h2();
            PbFragment.this.u0.a0();
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
            d.a.n0.e2.h.e y0 = PbFragment.this.n0.y0();
            if (y0.L().Q0().getIsLike() == 1) {
                PbFragment.this.n6(0);
            } else {
                PbFragment.this.n6(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, y0.L()));
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
            public final /* synthetic */ d.a.m0.r.s.j f18985e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ View f18986f;

            public a(d.a.m0.r.s.j jVar, View view) {
                this.f18985e = jVar;
                this.f18986f = view;
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
                if (r4.f18987g.f18984e.n0.L0() != 3) goto L5;
             */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
            /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
            @Override // d.a.m0.r.s.l.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(d.a.m0.r.s.l lVar, int i2, View view) {
                boolean X1;
                this.f18985e.dismiss();
                int i3 = 3;
                if (PbFragment.this.n0.L0() != 1 || i2 != 1) {
                    if (PbFragment.this.n0.L0() == 2 && i2 == 0) {
                        i3 = 1;
                    } else if (PbFragment.this.n0.L0() == 3 && i2 != 2) {
                        i3 = 2;
                    } else if (i2 == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f18986f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                    if (PbFragment.this.n0.y0().f52924f != null && PbFragment.this.n0.y0().f52924f.size() > i2) {
                        i2 = PbFragment.this.n0.y0().f52924f.get(i2).sort_type.intValue();
                    }
                    X1 = PbFragment.this.n0.X1(i2);
                    this.f18986f.setTag(Integer.valueOf(PbFragment.this.n0.K0()));
                    if (X1) {
                        return;
                    }
                    PbFragment.this.m = true;
                    PbFragment.this.u0.y2(true);
                    return;
                }
                i3 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f18986f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (PbFragment.this.n0.y0().f52924f != null) {
                    i2 = PbFragment.this.n0.y0().f52924f.get(i2).sort_type.intValue();
                }
                X1 = PbFragment.this.n0.X1(i2);
                this.f18986f.setTag(Integer.valueOf(PbFragment.this.n0.K0()));
                if (X1) {
                }
            }
        }

        public p0() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:841:0x1dd0, code lost:
            if (r36.f18984e.u0.P0.f53488c.a().getTop() <= ((r36.f18984e.u0.K0() == null || r36.f18984e.u0.K0().c() == null) ? 0 : r36.f18984e.u0.K0().c().getBottom())) goto L790;
         */
        /* JADX WARN: Code restructure failed: missing block: B:842:0x1dd2, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:844:0x1ddb, code lost:
            if (r0 >= r36.f18984e.p4()) goto L790;
         */
        /* JADX WARN: Code restructure failed: missing block: B:866:0x1e82, code lost:
            if ((r36.f18984e.u0.P0.f53488c.a().getTop() - r36.f18984e.u0.f53447h.f53323a.getBottom()) < (r36.f18984e.u0.P0.f53488c.f19136g.getHeight() + 10)) goto L790;
         */
        /* JADX WARN: Removed duplicated region for block: B:1109:0x2721  */
        /* JADX WARN: Removed duplicated region for block: B:1110:0x2736  */
        /* JADX WARN: Removed duplicated region for block: B:1113:0x276f  */
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
            d.a.m0.r.s.h hVar;
            d.a.m0.r.s.h hVar2;
            d.a.m0.r.s.h hVar3;
            PbFragment pbFragment;
            int i2;
            boolean z;
            d.a.m0.r.s.h hVar4;
            d.a.m0.r.s.h hVar5;
            d.a.m0.r.s.h hVar6;
            String name;
            int i3;
            boolean z2;
            int fixedNavHeight;
            int i4;
            d.a.m0.r.q.f2 f2Var;
            String[] strArr;
            d.a.n0.e2.h.e y0;
            int i5;
            int i6;
            boolean W1;
            int i7;
            int i8;
            String name2;
            if (view == null || !PbFragment.this.isAdded()) {
                return;
            }
            if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                if (view == PbFragment.this.u0.F0()) {
                    if (PbFragment.this.m) {
                        return;
                    }
                    if (PbFragment.this.n0.h1(true)) {
                        PbFragment.this.m = true;
                        PbFragment.this.u0.K2();
                    }
                } else if (PbFragment.this.u0.f53447h.g() == null || view != PbFragment.this.u0.f53447h.g().k()) {
                    if (PbFragment.this.u0.f53447h.g() == null || view != PbFragment.this.u0.f53447h.g().d()) {
                        if (view == PbFragment.this.u0.f53447h.f53328f) {
                            if (PbFragment.this.u0.R(PbFragment.this.n0.m0())) {
                                PbFragment.this.h6();
                                return;
                            }
                            PbFragment.this.n = false;
                            PbFragment.this.j = false;
                            d.a.c.e.p.l.x(PbFragment.this.f18899e, PbFragment.this.u0.f53447h.f53328f);
                            PbFragment.this.f18899e.finish();
                        } else if (view != PbFragment.this.u0.n0() && (PbFragment.this.u0.f53447h.g() == null || (view != PbFragment.this.u0.f53447h.g().l() && view != PbFragment.this.u0.f53447h.g().m()))) {
                            if (view == PbFragment.this.u0.v0()) {
                                if (PbFragment.this.n0 != null) {
                                    d.a.m0.l.a.l(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.n0.y0().L().C1().b());
                                }
                            } else if (view != PbFragment.this.u0.f53447h.f53325c) {
                                if (view == PbFragment.this.u0.f53447h.f53326d) {
                                    if (d.a.m0.z0.l.a()) {
                                        return;
                                    }
                                    if (PbFragment.this.n0 != null && PbFragment.this.n0.y0() != null) {
                                        ArrayList<PostData> D = PbFragment.this.n0.y0().D();
                                        if ((D == null || D.size() <= 0) && PbFragment.this.n0.M0()) {
                                            d.a.c.e.p.l.M(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new StatisticItem("c12378").param("tid", PbFragment.this.n0.O0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", PbFragment.this.n0.getForumId()));
                                        if (!PbFragment.this.u0.x1()) {
                                            PbFragment.this.u0.h2();
                                        }
                                        PbFragment.this.u5();
                                    } else {
                                        d.a.c.e.p.l.M(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (d.a.c.e.p.j.z()) {
                                        PbFragment.this.u0.v2(true);
                                        PbFragment.this.u0.h2();
                                        if (PbFragment.this.m) {
                                            return;
                                        }
                                        PbFragment.this.m = true;
                                        PbFragment.this.u0.l3();
                                        PbFragment.this.h6();
                                        PbFragment.this.u0.J2();
                                        PbFragment.this.n0.V1(PbFragment.this.u4());
                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.u0.f53447h.g() == null || view != PbFragment.this.u0.f53447h.g().h()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.u0.f53447h.g() != null && view == PbFragment.this.u0.f53447h.g().e()) {
                                            PbFragment.this.u0.f53447h.e();
                                        } else if (view.getId() == R.id.share_num_container) {
                                            if (!PbFragment.this.V3(11009)) {
                                                return;
                                            }
                                            PbFragment.this.W4(3);
                                        } else if (view.getId() != R.id.pb_editor_tool_share) {
                                            if (PbFragment.this.u0.f53447h.g() == null || view != PbFragment.this.u0.f53447h.g().j()) {
                                                if (PbFragment.this.u0.f53447h.g() == null || view != PbFragment.this.u0.f53447h.g().q()) {
                                                    if (PbFragment.this.u0.f53447h.g() == null || view != PbFragment.this.u0.f53447h.g().p()) {
                                                        if (PbFragment.this.u0.f53447h.g() == null || view != PbFragment.this.u0.f53447h.g().n()) {
                                                            if (PbFragment.this.u0.y0() == view) {
                                                                if (PbFragment.this.u0.y0().getIndicateStatus()) {
                                                                    d.a.n0.e2.h.e y02 = PbFragment.this.n0.y0();
                                                                    if (y02 != null && y02.L() != null && y02.L().p1() != null) {
                                                                        String d2 = y02.L().p1().d();
                                                                        if (StringUtils.isNull(d2)) {
                                                                            d2 = y02.L().p1().f();
                                                                        }
                                                                        TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d2));
                                                                    }
                                                                } else {
                                                                    d.a.n0.e3.j0.a.d("c10725", null);
                                                                }
                                                                PbFragment.this.P4();
                                                            } else if (PbFragment.this.u0.f53447h.g() == null || view != PbFragment.this.u0.f53447h.g().g()) {
                                                                if (PbFragment.this.u0.f53447h.g() != null && view == PbFragment.this.u0.f53447h.g().f()) {
                                                                    if (d.a.c.e.p.j.z()) {
                                                                        SparseArray<Object> C0 = PbFragment.this.u0.C0(PbFragment.this.n0.y0(), PbFragment.this.n0.M0(), 1);
                                                                        if (C0 != null) {
                                                                            if (StringUtils.isNull((String) C0.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.u0.Q1(((Integer) C0.get(R.id.tag_del_post_type)).intValue(), (String) C0.get(R.id.tag_del_post_id), ((Integer) C0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) C0.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.u0.R1(((Integer) C0.get(R.id.tag_del_post_type)).intValue(), (String) C0.get(R.id.tag_del_post_id), ((Integer) C0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) C0.get(R.id.tag_del_post_is_self)).booleanValue(), (String) C0.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.u0.f53447h.e();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.n0 == null) {
                                                                            return;
                                                                        }
                                                                        StatisticItem statisticItem2 = new StatisticItem("c13398");
                                                                        statisticItem2.param("tid", PbFragment.this.n0.O0());
                                                                        statisticItem2.param("fid", PbFragment.this.n0.getForumId());
                                                                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        statisticItem2.param("obj_locate", 5);
                                                                        TiebaStatic.log(statisticItem2);
                                                                        if (view.getId() == R.id.pb_post_reply_count && !DialogLoginHelper.checkUpIsLogin(new d.a.m0.r.q.r0(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
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
                                                                            StatisticItem statisticItem3 = postData.e0;
                                                                            if (statisticItem3 != null) {
                                                                                StatisticItem copy = statisticItem3.copy();
                                                                                copy.delete("obj_locate");
                                                                                copy.param("obj_locate", 8);
                                                                                TiebaStatic.log(copy);
                                                                            }
                                                                            if (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null) {
                                                                                return;
                                                                            }
                                                                            String O0 = PbFragment.this.n0.O0();
                                                                            String E = postData.E();
                                                                            int S = PbFragment.this.n0.y0() != null ? PbFragment.this.n0.y0().S() : 0;
                                                                            PbActivity.e x5 = PbFragment.this.x5(E);
                                                                            if (x5 == null) {
                                                                                return;
                                                                            }
                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(O0, E, "pb", true, null, false, null, S, postData.O(), PbFragment.this.n0.y0().d(), false, postData.t().getIconInfo()).addBigImageData(x5.f18855a, x5.f18856b, x5.f18861g, x5.j);
                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.n0.x0());
                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.n0.getFromForumId());
                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.n0.getForumId());
                                                                            addBigImageData.setBjhData(PbFragment.this.n0.T());
                                                                            if (PbFragment.this.n0.y0().o() != null) {
                                                                                addBigImageData.setHasForumRule(PbFragment.this.n0.y0().o().has_forum_rule.intValue());
                                                                            }
                                                                            if (PbFragment.this.n0.y0().R() != null) {
                                                                                addBigImageData.setIsManager(PbFragment.this.n0.y0().R().getIs_manager());
                                                                            }
                                                                            if (PbFragment.this.n0.y0().l().getDeletedReasonInfo() != null) {
                                                                                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.n0.y0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.n0.y0().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                            }
                                                                            if (PbFragment.this.n0.y0().l() != null) {
                                                                                addBigImageData.setForumHeadUrl(PbFragment.this.n0.y0().l().getImage_url());
                                                                                addBigImageData.setUserLevel(PbFragment.this.n0.y0().l().getUser_level());
                                                                            }
                                                                            if (PbFragment.this.u0 != null) {
                                                                                addBigImageData.setMainPostMaskVisibly(PbFragment.this.u0.t0(PbFragment.this.n0.I, PbFragment.this.n0.M0()).S || postData.S);
                                                                            }
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                        if (PbFragment.this.n0 == null) {
                                                                            return;
                                                                        }
                                                                        if (view.getId() == R.id.pb_post_reply) {
                                                                            StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                                            statisticItem4.param("tid", PbFragment.this.n0.O0());
                                                                            statisticItem4.param("fid", PbFragment.this.n0.getForumId());
                                                                            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            statisticItem4.param("obj_locate", 6);
                                                                            TiebaStatic.log(statisticItem4);
                                                                        }
                                                                        if (view.getId() == R.id.post_info_commont_img) {
                                                                            if (!DialogLoginHelper.checkUpIsLogin(new d.a.m0.r.q.r0(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                PbFragment.this.W = view;
                                                                                return;
                                                                            }
                                                                        } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new d.a.m0.r.q.r0(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
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
                                                                        if (view.getId() == R.id.pb_post_reply && (statisticItem = postData2.e0) != null) {
                                                                            StatisticItem copy2 = statisticItem.copy();
                                                                            copy2.delete("obj_locate");
                                                                            copy2.param("obj_locate", 8);
                                                                            TiebaStatic.log(copy2);
                                                                        } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", PbFragment.this.n0.P0()).param("fid", PbFragment.this.n0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                                                        }
                                                                        if (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || PbFragment.this.K4().I0() == null || postData2.t() == null || postData2.A() == 1) {
                                                                            return;
                                                                        }
                                                                        if (PbFragment.this.K4().J0() != null) {
                                                                            PbFragment.this.K4().J0().c();
                                                                        }
                                                                        if (PbFragment.this.k0 && postData2.M() != null && postData2.M().size() != 0) {
                                                                            PbFragment.this.g6(postData2, true);
                                                                        } else {
                                                                            d.a.n0.e2.h.r rVar = new d.a.n0.e2.h.r();
                                                                            rVar.A(PbFragment.this.n0.y0().l());
                                                                            rVar.E(PbFragment.this.n0.y0().L());
                                                                            rVar.C(postData2);
                                                                            PbFragment.this.K4().I0().E(rVar);
                                                                            PbFragment.this.K4().I0().setPostId(postData2.E());
                                                                            PbFragment.this.m5(view, postData2.t().getUserId(), "", postData2);
                                                                            if (PbFragment.this.O0 != null) {
                                                                                PbFragment.this.u0.o2(PbFragment.this.O0.C());
                                                                            }
                                                                        }
                                                                    } else if (view.getId() != R.id.pb_floor_feedback) {
                                                                        if (view != PbFragment.this.u0.x0()) {
                                                                            if (view == PbFragment.this.u0.f53447h.h()) {
                                                                                PbFragment.this.u0.T2();
                                                                            } else if (PbFragment.this.u0.f53447h.g() != null && view == PbFragment.this.u0.f53447h.g().o()) {
                                                                                PbFragment.this.u0.f53447h.f();
                                                                                PbFragment.this.u0.i3(PbFragment.this.q2);
                                                                            } else {
                                                                                int id = view.getId();
                                                                                if (id == R.id.pb_u9_text_view) {
                                                                                    if (!PbFragment.this.checkUpIsLogin() || (f2Var = (d.a.m0.r.q.f2) view.getTag()) == null || StringUtils.isNull(f2Var.C0())) {
                                                                                        return;
                                                                                    }
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                    UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{f2Var.C0()});
                                                                                } else if (id != R.id.replybtn && id != R.id.cover_reply_content && id != R.id.replybtn_top_right && id != R.id.cover_reply_content_top_right) {
                                                                                    if (id == R.id.pb_act_btn) {
                                                                                        if (PbFragment.this.n0.y0() != null && PbFragment.this.n0.y0().L() != null && PbFragment.this.n0.y0().L().H() != null) {
                                                                                            d.a.m0.l.a.l(PbFragment.this.getActivity(), PbFragment.this.n0.y0().L().H());
                                                                                            if (PbFragment.this.n0.y0().L().G() != 1) {
                                                                                                if (PbFragment.this.n0.y0().L().G() == 2) {
                                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                }
                                                                                            } else {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.lottery_tail) {
                                                                                        if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                            String str = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                            TiebaStatic.log(new StatisticItem("c10912").param("fid", PbFragment.this.n0.y0().m()).param("tid", PbFragment.this.n0.y0().N()).param("lotterytail", StringUtils.string(str, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                            if (PbFragment.this.n0.y0().N().equals(str)) {
                                                                                                PbFragment.this.u0.N2(0);
                                                                                            } else {
                                                                                                PbFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str, (String) null, (String) null, (String) null)));
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.pb_item_tail_content) {
                                                                                        if (ViewHelper.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                            String p = d.a.m0.r.d0.b.j().p("tail_link", "");
                                                                                            if (!StringUtils.isNull(p)) {
                                                                                                TiebaStatic.log("c10056");
                                                                                                d.a.m0.l.a.o(view.getContext(), string, p, true, true, true);
                                                                                            }
                                                                                            PbFragment.this.u0.h2();
                                                                                        }
                                                                                    } else if (id == R.id.join_vote_tv) {
                                                                                        if (view != null) {
                                                                                            d.a.m0.l.a.l(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                            if (PbFragment.this.o4() == 1 && PbFragment.this.n0 != null && PbFragment.this.n0.y0() != null) {
                                                                                                TiebaStatic.log(new StatisticItem("c10397").param("fid", PbFragment.this.n0.y0().m()).param("tid", PbFragment.this.n0.y0().N()).param("uid", currentAccount));
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.look_all_tv) {
                                                                                        if (view != null) {
                                                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                            d.a.m0.l.a.l(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                            if (PbFragment.this.o4() == 1 && PbFragment.this.n0 != null && PbFragment.this.n0.y0() != null) {
                                                                                                TiebaStatic.log(new StatisticItem("c10507").param("fid", PbFragment.this.n0.y0().m()).param("tid", PbFragment.this.n0.y0().N()).param("uid", currentAccount2));
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.manga_prev_btn) {
                                                                                        PbFragment.this.l5();
                                                                                    } else if (id == R.id.manga_next_btn) {
                                                                                        PbFragment.this.i5();
                                                                                    } else if (id == R.id.yule_head_img_img) {
                                                                                        if (PbFragment.this.n0 != null && PbFragment.this.n0.y0() != null && PbFragment.this.n0.y0().y() != null) {
                                                                                            d.a.n0.e2.h.e y03 = PbFragment.this.n0.y0();
                                                                                            TiebaStatic.log(new StatisticItem("c11679").param("fid", y03.m()));
                                                                                            UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{y03.y().b()});
                                                                                        }
                                                                                    } else if (id == R.id.yule_head_img_all_rank) {
                                                                                        if (PbFragment.this.n0 != null && PbFragment.this.n0.y0() != null && PbFragment.this.n0.y0().y() != null) {
                                                                                            d.a.n0.e2.h.e y04 = PbFragment.this.n0.y0();
                                                                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", y04.m()));
                                                                                            UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{y04.y().b()});
                                                                                        }
                                                                                    } else if (id == R.id.tv_pb_reply_more) {
                                                                                        if (PbFragment.this.j1 >= 0) {
                                                                                            if (PbFragment.this.n0 != null) {
                                                                                                PbFragment.this.n0.D1();
                                                                                            }
                                                                                            if (PbFragment.this.n0 == null || PbFragment.this.u0.l0() == null) {
                                                                                                i4 = 0;
                                                                                            } else {
                                                                                                i4 = 0;
                                                                                                PbFragment.this.u0.l0().Z(PbFragment.this.n0.y0(), false);
                                                                                            }
                                                                                            PbFragment.this.j1 = i4;
                                                                                            if (PbFragment.this.n0 != null) {
                                                                                                PbFragment.this.u0.B0().setSelection(PbFragment.this.n0.r0());
                                                                                                PbFragment.this.n0.H1(0, 0);
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.pb_post_recommend_live_layout) {
                                                                                        if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                            TiebaStatic.log("c12640");
                                                                                        }
                                                                                    } else if (id == R.id.qq_share_container) {
                                                                                        if (!PbFragment.this.V3(11009)) {
                                                                                            return;
                                                                                        }
                                                                                        PbFragment.this.W4(8);
                                                                                    } else if (id == R.id.new_sub_pb_list_richText) {
                                                                                        SparseArray sparseArray4 = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                                                                                        if (sparseArray4 == null) {
                                                                                            return;
                                                                                        }
                                                                                        PbFragment.this.f6(sparseArray4);
                                                                                    } else if (id == R.id.pb_editor_tool_comment_icon) {
                                                                                        if (PbFragment.this.u0.B0() == null || PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null) {
                                                                                            return;
                                                                                        }
                                                                                        int firstVisiblePosition = PbFragment.this.u0.B0().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.u0.B0().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean f0 = PbFragment.this.n0.y0().f0();
                                                                                        boolean z3 = PbFragment.this.u0.K0() != null && PbFragment.this.u0.K0().g();
                                                                                        boolean v1 = PbFragment.this.u0.v1();
                                                                                        boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                        if (!f0 || PbFragment.this.u0.K0() == null || PbFragment.this.u0.K0().c() == null) {
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            int k = ((int) (d.a.c.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.u0.K0().e();
                                                                                            i3 = k;
                                                                                            z4 = firstVisiblePosition == 0 && (top == k || top == PbFragment.this.u0.K0().c().getHeight() - PbFragment.this.u0.K0().e());
                                                                                        }
                                                                                        PbFragment.this.j4(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                        if ((PbFragment.this.n0.y0().L() != null && PbFragment.this.n0.y0().L().a1() <= 0) || (v1 && z4)) {
                                                                                            if (!PbFragment.this.checkUpIsLogin()) {
                                                                                                return;
                                                                                            }
                                                                                            PbFragment.this.w5();
                                                                                            if (PbFragment.this.n0.y0().L().T() != null) {
                                                                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.n0.f19095e).param("fid", PbFragment.this.n0.y0().m()).param("obj_locate", 2).param("uid", PbFragment.this.n0.y0().L().T().getUserId()));
                                                                                            }
                                                                                        } else {
                                                                                            int i9 = (int) (d.a.c.e.p.l.i(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (f0) {
                                                                                                if (PbFragment.this.u0.P0 != null && PbFragment.this.u0.P0.f53488c != null && PbFragment.this.u0.P0.f53488c.a() != null) {
                                                                                                    if (PbFragment.this.u0.P0.f53488c.a().getParent() != null) {
                                                                                                    }
                                                                                                }
                                                                                                z2 = false;
                                                                                            } else {
                                                                                                if (PbFragment.this.u0.H0() != null) {
                                                                                                    z2 = PbFragment.this.u0.H0().getVisibility() == 0;
                                                                                                    if (!z2 && PbFragment.this.u0.P0 != null && PbFragment.this.u0.P0.f53488c != null && PbFragment.this.u0.P0.f53488c.a() != null && PbFragment.this.u0.P0.f53488c.a().getParent() != null && PbFragment.this.u0.f53447h != null && PbFragment.this.u0.f53447h.f53323a != null) {
                                                                                                    }
                                                                                                }
                                                                                                z2 = false;
                                                                                            }
                                                                                            if (z2 || v1) {
                                                                                                PbFragment.this.d0 = firstVisiblePosition;
                                                                                                PbFragment.this.e0 = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i9))) {
                                                                                                    PbFragment.this.u0.B0().setSelectionFromTop(0, i3 - i9);
                                                                                                    PbFragment.this.u0.B0().smoothScrollBy(-i9, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.u0.B0().E(0, i3, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.d0 > 0) {
                                                                                                if (PbFragment.this.u0.B0().getChildAt(PbFragment.this.d0) != null) {
                                                                                                    PbFragment.this.u0.B0().E(PbFragment.this.d0, PbFragment.this.e0, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.u0.B0().setSelectionFromTop(PbFragment.this.d0, PbFragment.this.e0 + i9);
                                                                                                    PbFragment.this.u0.B0().smoothScrollBy(i9, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int p4 = PbFragment.this.p4();
                                                                                                if (PbFragment.this.s4() != -1) {
                                                                                                    p4--;
                                                                                                }
                                                                                                int g2 = d.a.c.e.p.l.g(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (p4 < 0) {
                                                                                                    p4 = (ListUtils.getCount(PbFragment.this.u0.B0().getData()) - 1) + PbFragment.this.u0.B0().getHeaderViewsCount();
                                                                                                    g2 = 0;
                                                                                                }
                                                                                                if (!z3) {
                                                                                                    if (!f0 || PbFragment.this.u0.K0() == null) {
                                                                                                        if (PbFragment.this.u0.f53447h != null && PbFragment.this.u0.f53447h.f53323a != null) {
                                                                                                            fixedNavHeight = PbFragment.this.u0.f53447h.f53323a.getFixedNavHeight() - 10;
                                                                                                        }
                                                                                                        if (PbFragment.this.u0.P0 != null || PbFragment.this.u0.P0.f53488c == null || PbFragment.this.u0.P0.f53488c.a() == null || PbFragment.this.u0.P0.f53488c.a().getParent() == null) {
                                                                                                            PbFragment.this.u0.B0().setSelectionFromTop(p4, g2 + i9);
                                                                                                            PbFragment.this.u0.B0().smoothScrollBy(i9, 500);
                                                                                                        } else if (!z3) {
                                                                                                            PbFragment.this.u0.B0().E(p4, g2, 200);
                                                                                                        } else {
                                                                                                            PbFragment.this.u0.B0().smoothScrollBy(PbFragment.this.u0.P0.f53488c.a().getTop() - ((int) (d.a.c.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                        }
                                                                                                    } else {
                                                                                                        fixedNavHeight = PbFragment.this.u0.K0().d();
                                                                                                    }
                                                                                                } else {
                                                                                                    fixedNavHeight = (int) (d.a.c.e.p.l.k(PbFragment.this.getContext()) * 0.5625d);
                                                                                                }
                                                                                                g2 += fixedNavHeight;
                                                                                                if (PbFragment.this.u0.P0 != null) {
                                                                                                }
                                                                                                PbFragment.this.u0.B0().setSelectionFromTop(p4, g2 + i9);
                                                                                                PbFragment.this.u0.B0().smoothScrollBy(i9, 500);
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.n0.y0().L() != null && PbFragment.this.n0.y0().L().T() != null) {
                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.n0.f19095e).param("fid", PbFragment.this.n0.y0().m()).param("obj_locate", 2).param("uid", PbFragment.this.n0.y0().L().T().getUserId()));
                                                                                        }
                                                                                    } else if (id == R.id.pb_nav_title_forum_image || id == R.id.pb_nav_title_forum_name) {
                                                                                        if (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || PbFragment.this.n0.y0().l() == null || d.a.c.e.p.k.isEmpty(PbFragment.this.n0.y0().l().getName())) {
                                                                                            return;
                                                                                        }
                                                                                        if (PbFragment.this.n0.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.n0.a0()) || PbFragment.this.n0.Q() == null) {
                                                                                                PbFragment.this.f18899e.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.n0.Q().f52914b;
                                                                                        } else {
                                                                                            name = PbFragment.this.n0.y0().l().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.f18899e.finish();
                                                                                            return;
                                                                                        }
                                                                                        String a0 = PbFragment.this.n0.a0();
                                                                                        if (PbFragment.this.n0.e0() && a0 != null && a0.equals(name)) {
                                                                                            PbFragment.this.f18899e.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.n0.y0().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13401");
                                                                                        statisticItem5.param("tid", PbFragment.this.n0.O0());
                                                                                        statisticItem5.param("fid", PbFragment.this.n0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.n0.y0().L() != null) {
                                                                                            statisticItem5.param("nid", PbFragment.this.n0.y0().L().M0());
                                                                                        }
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    } else if (id != R.id.forum_name_text && id != R.id.forum_enter_button_one && id != R.id.forum_enter_button_two && id != R.id.forum_enter_button_three) {
                                                                                        if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                            if (PbFragment.this.n0 == null) {
                                                                                                return;
                                                                                            }
                                                                                            StatisticItem statisticItem6 = new StatisticItem("c13398");
                                                                                            statisticItem6.param("tid", PbFragment.this.n0.O0());
                                                                                            statisticItem6.param("fid", PbFragment.this.n0.getForumId());
                                                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                            statisticItem6.param("obj_locate", 2);
                                                                                            TiebaStatic.log(statisticItem6);
                                                                                        } else if (id == R.id.pb_thread_post_button) {
                                                                                            if (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null) {
                                                                                                return;
                                                                                            }
                                                                                            d.a.n0.e2.h.e y05 = PbFragment.this.n0.y0();
                                                                                            if (PbFragment.this.s0 == null) {
                                                                                                PbFragment pbFragment2 = PbFragment.this;
                                                                                                pbFragment2.s0 = new d.a.n0.e2.h.s(pbFragment2.getPageContext());
                                                                                            }
                                                                                            long f2 = d.a.c.e.m.b.f(y05.N(), 0L);
                                                                                            long f3 = d.a.c.e.m.b.f(y05.m(), 0L);
                                                                                            new StatisticItem("c13446").param("forum_id", f3).eventStat();
                                                                                            PbFragment pbFragment3 = PbFragment.this;
                                                                                            pbFragment3.registerListener(pbFragment3.Z1);
                                                                                            PbFragment.this.s0.a(f2, f3);
                                                                                        } else if (id == R.id.pb_video_thread_smart_app_layout) {
                                                                                            if (view.getTag() instanceof SmartApp) {
                                                                                                SmartApp smartApp = (SmartApp) view.getTag();
                                                                                                if (!d.a.n0.u.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                    if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    d.a.m0.l.a.l(PbFragment.this.getActivity(), smartApp.h5_url);
                                                                                                }
                                                                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", PbFragment.this.n0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", PbFragment.this.n0.O0()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                            }
                                                                                        } else if (id == R.id.id_pb_business_promotion_wrapper) {
                                                                                            if (!(view.getTag() instanceof d.a.m0.r.q.a2)) {
                                                                                                return;
                                                                                            }
                                                                                            d.a.m0.r.q.a2 a2Var = (d.a.m0.r.q.a2) view.getTag();
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(a2Var.i0(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", a2Var.c0()).param("tid", a2Var.o0()).param("thread_type", a2Var.u1()).param(TiebaStatic.Params.IS_ZP, a2Var.G2() ? 1 : 0));
                                                                                        } else if (id == R.id.id_pb_business_promotion_attention) {
                                                                                            if (!(view.getTag() instanceof d.a.m0.r.q.a2) || !PbFragment.this.checkUpIsLogin()) {
                                                                                                return;
                                                                                            }
                                                                                            d.a.m0.r.q.a2 a2Var2 = (d.a.m0.r.q.a2) view.getTag();
                                                                                            if (PbFragment.this.T != null) {
                                                                                                PbFragment.this.T.H(a2Var2.i0(), String.valueOf(a2Var2.c0()));
                                                                                            }
                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", a2Var2.c0()).param("tid", a2Var2.o0()).param("thread_type", a2Var2.u1()).param(TiebaStatic.Params.IS_ZP, a2Var2.G2() ? 1 : 0));
                                                                                        } else if (id == R.id.pb_floor_right_top_feedback || id == R.id.pb_post_op_more) {
                                                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                            statisticItem7.param("tid", PbFragment.this.n0.O0());
                                                                                            statisticItem7.param("fid", PbFragment.this.n0.getForumId());
                                                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                            statisticItem7.param("obj_locate", 7);
                                                                                            TiebaStatic.log(statisticItem7);
                                                                                            PbFragment pbFragment4 = PbFragment.this;
                                                                                            pbFragment4.f18900f = false;
                                                                                            pbFragment4.b4(view);
                                                                                        }
                                                                                    } else if (!(view.getTag() instanceof d.a.m0.r.q.a2)) {
                                                                                        return;
                                                                                    } else {
                                                                                        d.a.m0.r.q.a2 a2Var3 = (d.a.m0.r.q.a2) view.getTag();
                                                                                        if (PbFragment.this.n0.x0() == 3 && PbFragment.this.isSimpleForum() && PbFragment.this.n0.y0() != null && ListUtils.isEmpty(PbFragment.this.n0.y0().p())) {
                                                                                            PbFragment.this.f18899e.finish();
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
                                                                                    d.a.m0.r.s.h hVar7 = null;
                                                                                    if (!PbFragment.this.checkUpIsLogin()) {
                                                                                        return;
                                                                                    }
                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                    if (view != null && view.getTag() != null) {
                                                                                        SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                        PostData postData3 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                        if (id == R.id.replybtn_top_right || id == R.id.cover_reply_content_top_right) {
                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", PbFragment.this.n0.f19095e));
                                                                                        }
                                                                                        if (PbFragment.this.A0 == null) {
                                                                                            PbFragment pbFragment5 = PbFragment.this;
                                                                                            pbFragment5.A0 = new d.a.m0.r.s.l(pbFragment5.getContext());
                                                                                            PbFragment.this.A0.n(PbFragment.this.T1);
                                                                                        }
                                                                                        ArrayList arrayList = new ArrayList();
                                                                                        PbFragment.this.d5(view);
                                                                                        if (PbFragment.this.d5(view) && PbFragment.this.f1 != null) {
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
                                                                                                d.a.m0.r.s.h hVar8 = new d.a.m0.r.s.h(3, PbFragment.this.getString(R.string.copy), PbFragment.this.A0);
                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                sparseArray6.put(R.id.tag_clip_board, postData3);
                                                                                                hVar8.f50254d.setTag(sparseArray6);
                                                                                                arrayList.add(hVar8);
                                                                                            }
                                                                                            PbFragment.this.n2 = postData3;
                                                                                        }
                                                                                        if (PbFragment.this.n0.y0().r()) {
                                                                                            String t = PbFragment.this.n0.y0().t();
                                                                                            if (postData3 != null && !d.a.c.e.p.k.isEmpty(t) && t.equals(postData3.E())) {
                                                                                                z = true;
                                                                                                if (!z) {
                                                                                                    hVar4 = new d.a.m0.r.s.h(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.A0);
                                                                                                } else {
                                                                                                    hVar4 = new d.a.m0.r.s.h(4, PbFragment.this.getString(R.string.mark), PbFragment.this.A0);
                                                                                                }
                                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                                sparseArray7.put(R.id.tag_clip_board, PbFragment.this.n2);
                                                                                                sparseArray7.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                                hVar4.f50254d.setTag(sparseArray7);
                                                                                                arrayList.add(hVar4);
                                                                                                if (PbFragment.this.mIsLogin) {
                                                                                                    if (d.a.n0.e2.k.e.e1.a.h(PbFragment.this.n0) || booleanValue3 || !booleanValue2) {
                                                                                                        if (PbFragment.this.g5(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                            d.a.m0.r.s.h hVar9 = new d.a.m0.r.s.h(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.A0);
                                                                                                            hVar9.f50254d.setTag(str2);
                                                                                                            arrayList.add(hVar9);
                                                                                                        }
                                                                                                    } else {
                                                                                                        d.a.m0.r.s.h hVar10 = new d.a.m0.r.s.h(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.A0);
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
                                                                                                        hVar4.f50254d.setTag(sparseArray8);
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
                                                                                                            hVar7 = new d.a.m0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.A0);
                                                                                                            hVar7.f50254d.setTag(sparseArray9);
                                                                                                        } else {
                                                                                                            sparseArray9.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                                        }
                                                                                                        hVar5 = new d.a.m0.r.s.h(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.A0);
                                                                                                        hVar5.f50254d.setTag(sparseArray9);
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
                                                                                                        if (PbFragment.this.n0.y0().S() == 1002 && !booleanValue) {
                                                                                                            hVar6 = new d.a.m0.r.s.h(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.A0);
                                                                                                        } else {
                                                                                                            hVar6 = new d.a.m0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.A0);
                                                                                                        }
                                                                                                        hVar6.f50254d.setTag(sparseArray10);
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
                                                                                                PbFragment.this.A0.k(arrayList);
                                                                                                PbFragment.this.z0 = new d.a.m0.r.s.j(PbFragment.this.getPageContext(), PbFragment.this.A0);
                                                                                                PbFragment.this.z0.l();
                                                                                            }
                                                                                        }
                                                                                        z = false;
                                                                                        if (!z) {
                                                                                        }
                                                                                        SparseArray sparseArray72 = new SparseArray();
                                                                                        sparseArray72.put(R.id.tag_clip_board, PbFragment.this.n2);
                                                                                        sparseArray72.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                        hVar4.f50254d.setTag(sparseArray72);
                                                                                        arrayList.add(hVar4);
                                                                                        if (PbFragment.this.mIsLogin) {
                                                                                        }
                                                                                        PbFragment.this.A0.k(arrayList);
                                                                                        PbFragment.this.z0 = new d.a.m0.r.s.j(PbFragment.this.getPageContext(), PbFragment.this.A0);
                                                                                        PbFragment.this.z0.l();
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), 24008, d.a.c.e.m.b.f(PbFragment.this.n0.y0().m(), 0L), d.a.c.e.m.b.f(PbFragment.this.n0.O0(), 0L), d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.n0.y0().L().T0())));
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
                                                                        if (PbFragment.this.A0 == null) {
                                                                            PbFragment pbFragment6 = PbFragment.this;
                                                                            pbFragment6.A0 = new d.a.m0.r.s.l(pbFragment6.getContext());
                                                                            PbFragment.this.A0.n(PbFragment.this.T1);
                                                                        }
                                                                        ArrayList arrayList2 = new ArrayList();
                                                                        boolean z5 = PbFragment.this.z().y0() != null && PbFragment.this.z().y0().a0();
                                                                        if (view != null && sparseArray != null) {
                                                                            boolean booleanValue6 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                            boolean booleanValue7 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                            boolean booleanValue8 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                            boolean booleanValue9 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                            boolean booleanValue10 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                            String str3 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                                                                            if (postData4.r() != null) {
                                                                                boolean z6 = postData4.r().hasAgree;
                                                                                int s = postData4.s();
                                                                                if (z6 && s == 5) {
                                                                                    pbFragment = PbFragment.this;
                                                                                    i2 = R.string.action_cancel_dislike;
                                                                                } else {
                                                                                    pbFragment = PbFragment.this;
                                                                                    i2 = R.string.action_dislike;
                                                                                }
                                                                                d.a.m0.r.s.h hVar11 = new d.a.m0.r.s.h(8, pbFragment.getString(i2), PbFragment.this.A0);
                                                                                SparseArray sparseArray11 = new SparseArray();
                                                                                sparseArray11.put(R.id.tag_clip_board, postData4);
                                                                                hVar11.f50254d.setTag(sparseArray11);
                                                                                arrayList2.add(hVar11);
                                                                            }
                                                                            if (PbFragment.this.mIsLogin) {
                                                                                if (d.a.n0.e2.k.e.e1.a.h(PbFragment.this.n0) || booleanValue8 || !booleanValue7) {
                                                                                    if ((PbFragment.this.g5(booleanValue6) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                        d.a.m0.r.s.h hVar12 = new d.a.m0.r.s.h(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.A0);
                                                                                        hVar12.f50254d.setTag(str3);
                                                                                        arrayList2.add(hVar12);
                                                                                    }
                                                                                } else {
                                                                                    d.a.m0.r.s.h hVar13 = new d.a.m0.r.s.h(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.A0);
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
                                                                                    hVar13.f50254d.setTag(sparseArray12);
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
                                                                                        hVar2 = new d.a.m0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.A0);
                                                                                        hVar2.f50254d.setTag(sparseArray13);
                                                                                    } else {
                                                                                        sparseArray13.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                        hVar2 = null;
                                                                                    }
                                                                                    hVar = new d.a.m0.r.s.h(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.A0);
                                                                                    hVar.f50254d.setTag(sparseArray13);
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
                                                                                    if (PbFragment.this.n0.y0().S() == 1002 && !booleanValue6) {
                                                                                        hVar3 = new d.a.m0.r.s.h(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.A0);
                                                                                    } else {
                                                                                        hVar3 = new d.a.m0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.A0);
                                                                                    }
                                                                                    hVar3.f50254d.setTag(sparseArray14);
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
                                                                            PbFragment.this.A0.k(arrayList2);
                                                                            PbFragment.this.z0 = new d.a.m0.r.s.j(PbFragment.this.getPageContext(), PbFragment.this.A0);
                                                                            PbFragment.this.z0.l();
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                                        statisticItem9.param("tid", PbFragment.this.n0.O0());
                                                                        statisticItem9.param("fid", PbFragment.this.n0.getForumId());
                                                                        statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        statisticItem9.param("obj_locate", 4);
                                                                        TiebaStatic.log(statisticItem9);
                                                                    }
                                                                    if (view.getId() == R.id.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new d.a.m0.r.q.r0(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                                                        PbFragment.this.V = view;
                                                                        return;
                                                                    } else if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null) {
                                                                            return;
                                                                        }
                                                                        PbFragment.this.u0.a0();
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
                                                                        StatisticItem statisticItem10 = postData5.e0;
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
                                                                        String O02 = PbFragment.this.n0.O0();
                                                                        String E2 = postData5.E();
                                                                        String E3 = postData6 != null ? postData6.E() : "";
                                                                        int S2 = PbFragment.this.n0.y0() != null ? PbFragment.this.n0.y0().S() : 0;
                                                                        PbFragment.this.h6();
                                                                        if (view.getId() == R.id.replybtn) {
                                                                            PbActivity.e x52 = PbFragment.this.x5(E2);
                                                                            if (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || x52 == null) {
                                                                                return;
                                                                            }
                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(O02, E2, "pb", true, null, true, null, S2, postData5.O(), PbFragment.this.n0.y0().d(), false, postData5.t().getIconInfo()).addBigImageData(x52.f18855a, x52.f18856b, x52.f18861g, x52.j);
                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.n0.x0());
                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.n0.getFromForumId());
                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.n0.getForumId());
                                                                            addBigImageData2.setBjhData(PbFragment.this.n0.T());
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                        } else {
                                                                            TiebaStatic.log("c11742");
                                                                            PbActivity.e x53 = PbFragment.this.x5(E2);
                                                                            if (postData5 == null || PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || x53 == null) {
                                                                                return;
                                                                            }
                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(O02, E2, "pb", true, null, false, E3, S2, postData5.O(), PbFragment.this.n0.y0().d(), false, postData5.t().getIconInfo()).addBigImageData(x53.f18855a, x53.f18856b, x53.f18861g, x53.j);
                                                                            if (!d.a.c.e.p.k.isEmpty(E3)) {
                                                                                addBigImageData3.setHighLightPostId(E3);
                                                                                addBigImageData3.setKeyIsUseSpid(true);
                                                                            }
                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.n0.getForumId());
                                                                            addBigImageData3.setBjhData(PbFragment.this.n0.T());
                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.n0.x0());
                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.n0.getFromForumId());
                                                                            if (PbFragment.this.u0 != null) {
                                                                                addBigImageData3.setMainPostMaskVisibly(PbFragment.this.u0.t0(PbFragment.this.n0.I, PbFragment.this.n0.M0()).S || postData5.S);
                                                                            }
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                        }
                                                                    } else {
                                                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", PbFragment.this.n0.y0().m()));
                                                                        return;
                                                                    }
                                                                }
                                                            } else if (d.a.c.e.p.j.z()) {
                                                                PbFragment.this.u0.a0();
                                                                SparseArray<Object> C02 = PbFragment.this.u0.C0(PbFragment.this.n0.y0(), PbFragment.this.n0.M0(), 1);
                                                                if (C02 == null) {
                                                                    return;
                                                                }
                                                                PbFragment.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.n0.y0().l().getId(), PbFragment.this.n0.y0().l().getName(), PbFragment.this.n0.y0().L().o0(), String.valueOf(PbFragment.this.n0.y0().R().getUserId()), (String) C02.get(R.id.tag_forbid_user_name), (String) C02.get(R.id.tag_forbid_user_name_show), (String) C02.get(R.id.tag_forbid_user_post_id), (String) C02.get(R.id.tag_forbid_user_portrait))));
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
                                                            PbFragment.this.u0.f53447h.f();
                                                        }
                                                    } else if (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || PbFragment.this.n0.y0().L() == null) {
                                                        return;
                                                    } else {
                                                        PbFragment.this.u0.f53447h.e();
                                                        TiebaStatic.log(new StatisticItem("c13062"));
                                                        PbFragment pbFragment7 = PbFragment.this;
                                                        pbFragment7.S4(pbFragment7.n0.y0().L().f0());
                                                    }
                                                } else {
                                                    PbFragment.this.u0.a0();
                                                    if (d.a.c.e.p.j.z()) {
                                                        if (PbFragment.this.m) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.n0.K0()));
                                                            return;
                                                        }
                                                        PbFragment.this.h6();
                                                        PbFragment.this.u0.J2();
                                                        d.a.m0.r.s.j jVar = new d.a.m0.r.s.j(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.n0.y0().f52924f == null || PbFragment.this.n0.y0().f52924f.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            strArr = new String[PbFragment.this.n0.y0().f52924f.size()];
                                                            for (int i64 = 0; i64 < PbFragment.this.n0.y0().f52924f.size(); i64++) {
                                                                strArr[i64] = PbFragment.this.n0.y0().f52924f.get(i64).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
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
                                                PbFragment.this.u0.a0();
                                                if (PbFragment.this.z().y0().f52925g != 2) {
                                                    if (PbFragment.this.n0.w0() != null) {
                                                        PbFragment.this.u0.n3(PbFragment.this.n0.w0(), PbFragment.this.S1);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (!(ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) || (y0 = PbFragment.this.n0.y0()) == null) {
                                            return;
                                        } else {
                                            d.a.m0.r.q.a2 L = y0.L();
                                            if (L != null && L.T() != null) {
                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.n0.f19095e).param("fid", y0.m()).param("obj_locate", 4).param("uid", L.T().getUserId()));
                                            }
                                            if (L != null) {
                                                if (L.Q1()) {
                                                    i5 = 2;
                                                } else if (L.T1()) {
                                                    i5 = 3;
                                                } else if (L.R1()) {
                                                    i5 = 4;
                                                } else if (L.S1()) {
                                                    i5 = 5;
                                                }
                                                StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                statisticItem11.param("tid", PbFragment.this.n0.O0());
                                                statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem11.param("fid", PbFragment.this.n0.getForumId());
                                                if (view.getId() != R.id.share_num_container) {
                                                    statisticItem11.param("obj_locate", 5);
                                                } else {
                                                    statisticItem11.param("obj_locate", 6);
                                                }
                                                statisticItem11.param("obj_name", i5);
                                                statisticItem11.param("obj_type", 1);
                                                if (L != null) {
                                                    if (L.Q1()) {
                                                        statisticItem11.param("obj_type", 10);
                                                    } else if (L.T1()) {
                                                        statisticItem11.param("obj_type", 9);
                                                    } else if (L.S1()) {
                                                        statisticItem11.param("obj_type", 8);
                                                    } else if (L.R1()) {
                                                        statisticItem11.param("obj_type", 7);
                                                    } else if (L.t1) {
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
                                                    statisticItem11.param("card_type", L.V0());
                                                    statisticItem11.param("recom_source", L.S0);
                                                    statisticItem11.param("ab_tag", L.U0);
                                                    statisticItem11.param("weight", L.T0);
                                                    statisticItem11.param("extra", L.V0);
                                                    statisticItem11.param("nid", L.M0());
                                                    if (L.V() != null && !d.a.c.e.p.k.isEmpty(L.V().oriUgcVid)) {
                                                        statisticItem11.param(TiebaStatic.Params.OBJ_PARAM6, L.V().oriUgcVid);
                                                    }
                                                }
                                                if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    statisticItem11.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.A() != null) {
                                                    d.a.m0.j0.c.e(PbFragment.this.A(), statisticItem11);
                                                }
                                                TiebaStatic.log(statisticItem11);
                                                if (d.a.c.e.p.l.D()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (y0 != null) {
                                                    ArrayList<PostData> D2 = PbFragment.this.n0.y0().D();
                                                    if ((D2 != null && D2.size() > 0) || !PbFragment.this.n0.M0()) {
                                                        PbFragment.this.u0.a0();
                                                        PbFragment.this.h6();
                                                        if (y0.y() != null && !StringUtils.isNull(y0.y().a(), true)) {
                                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", PbFragment.this.n0.y0().m()));
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c11939"));
                                                        if (AntiHelper.e(PbFragment.this.getContext(), L)) {
                                                            return;
                                                        }
                                                        if (PbFragment.this.u0 != null) {
                                                            PbFragment.this.u0.c0();
                                                            PbFragment.this.u0.z3(y0);
                                                        }
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.u0.c3();
                                                            PbFragment.this.n0.V().u(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                        } else {
                                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                                i6 = 2;
                                                            } else {
                                                                i6 = view.getId() == R.id.share_num_container ? 1 : 6;
                                                            }
                                                            PbFragment.this.b6(i6);
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
                                            statisticItem112.param("tid", PbFragment.this.n0.O0());
                                            statisticItem112.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem112.param("fid", PbFragment.this.n0.getForumId());
                                            if (view.getId() != R.id.share_num_container) {
                                            }
                                            statisticItem112.param("obj_name", i5);
                                            statisticItem112.param("obj_type", 1);
                                            if (L != null) {
                                            }
                                            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                            }
                                            if (PbFragment.this.A() != null) {
                                            }
                                            TiebaStatic.log(statisticItem112);
                                            if (d.a.c.e.p.l.D()) {
                                            }
                                        }
                                    } else if (d.a.c.e.p.j.z()) {
                                        PbFragment.this.u0.a0();
                                        if (PbFragment.this.u0.f53447h.g() != null && view == PbFragment.this.u0.f53447h.g().h() && !PbFragment.this.u0.x1()) {
                                            PbFragment.this.u0.h2();
                                        }
                                        if (!PbFragment.this.m) {
                                            PbFragment.this.h6();
                                            PbFragment.this.u0.J2();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                W1 = PbFragment.this.n0.W1(true, PbFragment.this.u4());
                                            } else {
                                                W1 = view.getId() == R.id.reply_title ? PbFragment.this.n0.W1(false, PbFragment.this.u4()) : PbFragment.this.n0.V1(PbFragment.this.u4());
                                            }
                                            view.setTag(Boolean.valueOf(W1));
                                            if (W1) {
                                                i7 = 1;
                                                PbFragment.this.u0.v2(true);
                                                PbFragment.this.u0.l3();
                                                PbFragment.this.m = true;
                                                PbFragment.this.u0.y2(true);
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
                                    PbFragment.this.u0.a0();
                                    if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new d.a.m0.r.q.r0(PbFragment.this.getActivity(), "pb_shoucang"))) {
                                        if (!PbFragment.this.V3(11009) || PbFragment.this.n0.R(PbFragment.this.u0.A0()) == null) {
                                            return;
                                        }
                                        PbFragment.this.o5();
                                        if (PbFragment.this.n0.y0() != null && PbFragment.this.n0.y0().L() != null && PbFragment.this.n0.y0().L().T() != null) {
                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.n0.f19095e).param("fid", PbFragment.this.n0.y0().m()).param("obj_locate", 3).param("uid", PbFragment.this.n0.y0().L().T().getUserId()));
                                        }
                                        if (PbFragment.this.n0.y0().L() != null && PbFragment.this.n0.y0().L().T() != null && PbFragment.this.n0.y0().L().T().getUserId() != null && PbFragment.this.p0 != null) {
                                            PbFragment pbFragment8 = PbFragment.this;
                                            int N4 = pbFragment8.N4(pbFragment8.n0.y0());
                                            d.a.m0.r.q.a2 L2 = PbFragment.this.n0.y0().L();
                                            if (L2.Q1()) {
                                                i8 = 2;
                                            } else if (L2.T1()) {
                                                i8 = 3;
                                            } else if (L2.R1()) {
                                                i8 = 4;
                                            } else {
                                                i8 = L2.S1() ? 5 : 1;
                                            }
                                            TiebaStatic.log(new StatisticItem("c12526").param("tid", PbFragment.this.n0.f19095e).param("obj_locate", 1).param("obj_id", PbFragment.this.n0.y0().L().T().getUserId()).param("obj_type", !PbFragment.this.p0.e()).param("obj_source", N4).param("obj_param1", i8));
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
                                if (PbFragment.this.n0.y0() != null && PbFragment.this.n0.y0().L() != null && PbFragment.this.n0.y0().L().C2() && PbFragment.this.n0.y0().L().w1() != null) {
                                    TiebaStatic.log(new StatisticItem("c11922"));
                                }
                                if (PbFragment.this.n0.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.n0.a0()) || PbFragment.this.n0.Q() == null) {
                                        PbFragment.this.f18899e.finish();
                                        return;
                                    }
                                    name2 = PbFragment.this.n0.Q().f52914b;
                                } else {
                                    name2 = PbFragment.this.n0.y0().l().getName();
                                }
                                if (StringUtils.isNull(name2)) {
                                    PbFragment.this.f18899e.finish();
                                    return;
                                }
                                String a02 = PbFragment.this.n0.a0();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.n0.e0() && a02 != null && a02.equals(name2)) {
                                    PbFragment.this.f18899e.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                }
                            }
                        } else if (d.a.c.e.p.j.z()) {
                            if (PbFragment.this.n0.y0() == null || PbFragment.this.q0.K()) {
                                return;
                            }
                            PbFragment.this.u0.a0();
                            int i66 = (PbFragment.this.u0.f53447h.g() == null || view != PbFragment.this.u0.f53447h.g().m()) ? (PbFragment.this.u0.f53447h.g() == null || view != PbFragment.this.u0.f53447h.g().l()) ? view == PbFragment.this.u0.n0() ? 2 : 0 : PbFragment.this.n0.y0().L().x0() == 1 ? 3 : 6 : PbFragment.this.n0.y0().L().y0() == 1 ? 5 : 4;
                            ForumData l = PbFragment.this.n0.y0().l();
                            String name3 = l.getName();
                            String id2 = l.getId();
                            String o0 = PbFragment.this.n0.y0().L().o0();
                            PbFragment.this.u0.t3();
                            PbFragment.this.q0.O(id2, name3, o0, i66, PbFragment.this.u0.o0());
                        } else {
                            PbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                    } else {
                        PbFragment.this.u0.f53447h.f();
                        if (PbFragment.this.n0 != null) {
                            PbFragment.this.o1.i(PbFragment.this.n0.O0());
                        }
                        if (PbFragment.this.n0 == null || !PbFragment.this.n0.isPrivacy()) {
                            PbFragment.this.o1.c();
                            int i67 = (TbSingleton.getInstance().mCanCallFans || PbFragment.this.z() == null || PbFragment.this.z().y0() == null || PbFragment.this.z().y0().N() == null || !PbFragment.this.z().y0().N().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                            if (PbFragment.this.z() != null && PbFragment.this.z().y0() != null) {
                                PbFragment.this.o1.e(3, i67, PbFragment.this.z().y0().N());
                            }
                        } else {
                            PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                            if (PbFragment.this.z() == null || PbFragment.this.z().y0() == null) {
                                return;
                            }
                            PbFragment.this.o1.e(3, 3, PbFragment.this.z().y0().N());
                            return;
                        }
                    }
                } else if (d.a.c.e.p.j.z()) {
                    PbFragment.this.u0.a0();
                    PbFragment.this.h6();
                    PbFragment.this.u0.J2();
                    PbFragment.this.u0.c3();
                    if (PbFragment.this.u0.H0() != null) {
                        PbFragment.this.u0.H0().setVisibility(8);
                    }
                    PbFragment.this.n0.R1(1);
                    if (PbFragment.this.f18903i != null) {
                        PbFragment.this.f18903i.x();
                    }
                } else {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                    String t4 = PbFragment.this.t4();
                    if (TextUtils.isEmpty(t4)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{t4});
                    return;
                }
                return;
            }
            StatisticItem statisticItem12 = new StatisticItem("c13398");
            statisticItem12.param("tid", PbFragment.this.n0.O0());
            statisticItem12.param("fid", PbFragment.this.n0.getForumId());
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
                    if (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || PbFragment.this.K4().I0() == null || postData7.t() == null || postData7.A() == 1 || !PbFragment.this.checkUpIsLogin()) {
                        return;
                    }
                    if (PbFragment.this.K4().J0() != null) {
                        PbFragment.this.K4().J0().c();
                    }
                    d.a.n0.e2.h.r rVar2 = new d.a.n0.e2.h.r();
                    rVar2.A(PbFragment.this.n0.y0().l());
                    rVar2.E(PbFragment.this.n0.y0().L());
                    rVar2.C(postData7);
                    PbFragment.this.K4().I0().E(rVar2);
                    PbFragment.this.K4().I0().setPostId(postData7.E());
                    PbFragment.this.m5(view, postData7.t().getUserId(), "", postData7);
                    TiebaStatic.log("c11743");
                    d.a.n0.e2.m.a.b(PbFragment.this.n0.y0(), postData7, postData7.d0, 8, 1);
                    if (PbFragment.this.O0 != null) {
                        PbFragment.this.u0.o2(PbFragment.this.O0.C());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f18988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f18989f;

        public p1(MarkData markData, d.a.m0.r.s.a aVar) {
            this.f18988e = markData;
            this.f18989f = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            int[] iArr = new int[2];
            if (PbFragment.this.u0 != null && PbFragment.this.u0.U0() != null) {
                PbFragment.this.u0.U0().getLocationOnScreen(iArr);
            }
            if (iArr[0] > 0) {
                Intent intent = new Intent();
                intent.putExtra("mark", this.f18988e);
                PbFragment.this.f18899e.setResult(-1, intent);
                this.f18989f.dismiss();
                PbFragment.this.i6();
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

        @Override // d.a.n0.e2.k.e.c1.b.h
        public void a(boolean z) {
            PbFragment.this.K5(z);
            if (PbFragment.this.u0.y0() != null && z) {
                PbFragment.this.u0.o3(false);
            }
            PbFragment.this.u0.K1(z);
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
            if (customResponsedMessage == null || PbFragment.this.n0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.n0.f19095e)) {
                return;
            }
            PbFragment.this.a6((PostWriteCallBackData) customResponsedMessage.getData());
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
                if (d.a.m0.r.k.c().g()) {
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
            boolean g2 = d.a.m0.r.k.c().g();
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
        public final /* synthetic */ SparseArray f18994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f18995f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f18996g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f18997h;

        public r(SparseArray sparseArray, boolean z, String str, String str2) {
            this.f18994e = sparseArray;
            this.f18995f = z;
            this.f18996g = str;
            this.f18997h = str2;
        }

        @Override // d.a.m0.r.s.l.e
        public void onItemClick(d.a.m0.r.s.l lVar, int i2, View view) {
            if (PbFragment.this.z0 != null) {
                PbFragment.this.z0.dismiss();
            }
            if (i2 == 0) {
                PbFragment.this.u0.Q1(((Integer) this.f18994e.get(R.id.tag_del_post_type)).intValue(), (String) this.f18994e.get(R.id.tag_del_post_id), ((Integer) this.f18994e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f18994e.get(R.id.tag_del_post_is_self)).booleanValue());
            } else if (i2 == 1) {
                String str = (String) this.f18994e.get(R.id.tag_user_mute_mute_username);
                String str2 = (String) this.f18994e.get(R.id.tag_user_mute_thread_id);
                String str3 = (String) this.f18994e.get(R.id.tag_user_mute_post_id);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(this.f18995f, this.f18996g, str, str2, str3, 1, this.f18997h, PbFragment.this.c1);
                userMuteAddAndDelCustomMessage.setTag(PbFragment.this.c1);
                PbFragment.this.d6(this.f18995f, userMuteAddAndDelCustomMessage, this.f18997h, str, (String) this.f18994e.get(R.id.tag_user_mute_mute_nameshow));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements d.a.m0.w.w.c {
        public r0() {
        }

        @Override // d.a.m0.w.w.c
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
            if (d.a.m0.r.k.c().g()) {
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
            gifView.n0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
            boolean g2 = d.a.m0.r.k.c().g();
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
            gifView.s0();
            gifView.n0();
            gifView.setImageDrawable(null);
            gifView.t0();
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
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f12576c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != PbFragment.this.getUniqueId() || AntiHelper.t(PbFragment.this.getActivity(), updateAttentionMessage.getData().l, PbFragment.A2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().f12574a) {
                    if (PbFragment.this.q4().t() != null && PbFragment.this.q4().t().getGodUserData() != null) {
                        PbFragment.this.q4().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || PbFragment.this.n0.y0().L() == null || PbFragment.this.n0.y0().L().T() == null) {
                        return;
                    }
                    PbFragment.this.n0.y0().L().T().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements NewWriteModel.g {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19003e;

            public a(PostWriteCallBackData postWriteCallBackData) {
                this.f19003e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PbFragment.this.u0 == null || this.f19003e == null) {
                    return;
                }
                PbFragment.this.u0.u3();
                PbFragment.this.u0.V1(this.f19003e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b(s0 s0Var) {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class c implements a.e {
            public c() {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                aVar.dismiss();
                PbFragment.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public s0() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.m0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13268");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.n0.y0() != null) {
                    statisticItem.param("fid", PbFragment.this.n0.y0().m());
                }
                statisticItem.param("tid", PbFragment.this.n0.O0());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
            }
            PbFragment.this.h6();
            PbFragment.this.u0.H2(z, postWriteCallBackData);
            int i2 = -1;
            if (postWriteCallBackData != null) {
                i2 = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            } else {
                str = "";
            }
            boolean z2 = false;
            if (z) {
                PbFragment.this.a6(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbFragment.this.Q5(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (PbFragment.this.n0.d0()) {
                        d.a.n0.e2.h.e y0 = PbFragment.this.n0.y0();
                        if (y0 != null && y0.L() != null && y0.L().T() != null && (userId = y0.L().T().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.n0.U1()) {
                            PbFragment.this.u0.J2();
                        }
                    } else if (!PbReplySwitch.getInOn() && PbFragment.this.n0.U1()) {
                        PbFragment.this.u0.J2();
                    }
                } else if (floor != null) {
                    PbFragment.this.u0.l1(PbFragment.this.n0.y0());
                }
                if (PbFragment.this.n0.g0()) {
                    TiebaStatic.log(new StatisticItem("c10369").param("tid", PbFragment.this.n0.O0()));
                }
                if (postWriteCallBackData.getmAdverSegmentData() != null) {
                    d.a.c.e.m.e.a().postDelayed(new a(postWriteCallBackData), 500L);
                }
                PbFragment pbFragment = PbFragment.this;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                pbFragment.R3(z2);
            } else if (i2 == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.O0.B() || PbFragment.this.O0.D()) {
                    PbFragment.this.O0.z(false, postWriteCallBackData);
                }
                PbFragment.this.y0.k(postWriteCallBackData);
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
                d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(PbFragment.this.getActivity());
                if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.setPositiveButton(R.string.open_now, new c());
                aVar.create(PbFragment.this.getPageContext()).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
            } else if (d.a.n0.o3.a.c(i2) || i0Var != null || i2 == 227001) {
            } else {
                PbFragment.this.P5(i2, antiData, str);
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
            ((PlayVoiceBntNew) view).l();
            return view;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(View view) {
            ((PlayVoiceBntNew) view).k();
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
            ((PlayVoiceBntNew) view).k();
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class t extends d.a.m0.f0.i<TipEvent> {
        public t() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.f0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            if (tipEvent.pageId <= 0 || PbFragment.this.f18899e.getPageId() != tipEvent.pageId) {
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
            public final /* synthetic */ PostWriteCallBackData f19009e;

            public a(PostWriteCallBackData postWriteCallBackData) {
                this.f19009e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PbFragment.this.u0 == null || this.f19009e == null) {
                    return;
                }
                PbFragment.this.u0.u3();
                PbFragment.this.u0.V1(this.f19009e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b(t0 t0Var) {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class c implements a.e {
            public c() {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                aVar.dismiss();
                PbFragment.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public t0() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.m0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13268");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.n0 != null && PbFragment.this.n0.y0() != null) {
                    statisticItem.param("fid", PbFragment.this.n0.y0().m());
                }
                if (PbFragment.this.n0 != null) {
                    statisticItem.param("tid", PbFragment.this.n0.O0());
                }
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
            }
            if (z) {
                d.a.n0.e2.k.e.v0 v0Var = PbFragment.this.y0;
                if (v0Var != null) {
                    v0Var.d();
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    d.a.m0.s.h.b.a(PbFragment.this.getPageContext(), postWriteCallBackData);
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
                d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(PbFragment.this.getActivity());
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
            if (pbFragment.y0 == null) {
                return;
            }
            if (pbFragment.u0 != null && PbFragment.this.u0.J0() != null && PbFragment.this.u0.J0().b() != null && PbFragment.this.u0.J0().b().v()) {
                PbFragment.this.u0.J0().b().t(postWriteCallBackData);
            }
            PbFragment.this.y0.l(postWriteCallBackData);
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
        public final /* synthetic */ Intent f19013e;

        public u(Intent intent) {
            this.f19013e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.e2.k.e.t0 t0Var = PbFragment.this.u0;
            t0Var.M2("@" + this.f19013e.getStringExtra("big_pic_type") + " ");
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
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.f18899e.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                    if (PbFragment.this.u0 == null || (S0 = PbFragment.this.u0.S0()) == null || PbFragment.this.u0.B0() == null) {
                        return;
                    }
                    PbFragment.this.u0.B0().removeHeaderView(S0);
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
            d.a.n0.e2.k.e.i l0;
            int i3;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.u0.H1((TbRichText) view.getTag());
                        TiebaStatic.log(new StatisticItem("c12490"));
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13398");
                statisticItem.param("tid", PbFragment.this.n0.O0());
                statisticItem.param("fid", PbFragment.this.n0.getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_locate", 3);
                statisticItem.param("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(statisticItem);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.n0.I.a0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        int i4 = -1;
                        if (tbRichTextView == null || tbRichTextView.getRichText() == null || tbRichTextView.getRichText().w() == null) {
                            i3 = -1;
                        } else {
                            ArrayList<TbRichTextImageInfo> w = tbRichTextView.getRichText().w();
                            int i5 = 0;
                            int i6 = -1;
                            while (i5 < w.size()) {
                                if (w.get(i5) != null) {
                                    arrayList.add(w.get(i5).x());
                                    if (i6 == i4 && str != null && (str.equals(w.get(i5).x()) || str.equals(w.get(i5).u()) || str.equals(w.get(i5).s()) || str.equals(w.get(i5).t()) || str.equals(w.get(i5).w()))) {
                                        i6 = i5;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = w.get(i5).x();
                                    imageUrlData.originalUrl = w.get(i5).x();
                                    imageUrlData.isLongPic = w.get(i5).A();
                                    concurrentHashMap.put(w.get(i5).x(), imageUrlData);
                                }
                                i5++;
                                i4 = -1;
                            }
                            i3 = i6;
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.m4(rect);
                        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                        bVar.x(arrayList);
                        bVar.B(i3);
                        bVar.C(false);
                        bVar.F(PbFragment.this.n0.J0());
                        bVar.w(concurrentHashMap);
                        bVar.H(true);
                        bVar.K(false);
                        bVar.G(PbFragment.this.c5());
                        bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.n0 != null) {
                            bVar.A(PbFragment.this.n0.getFromForumId());
                            if (PbFragment.this.n0.y0() != null) {
                                bVar.N(PbFragment.this.n0.y0().L());
                            }
                        }
                        ImageViewerConfig v = bVar.v(PbFragment.this.getPageContext().getPageActivity());
                        v.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage(2010000, v));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    PbActivity.e eVar = new PbActivity.e();
                    PbFragment.this.v5(str, i2, eVar);
                    if (eVar.f18862h) {
                        TbRichText o6 = PbFragment.this.o6(str, i2);
                        if (o6 != null && PbFragment.this.k2 >= 0 && PbFragment.this.k2 < o6.u().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a2 = d.a.n0.e2.h.f.a(o6.u().get(PbFragment.this.k2));
                            int i7 = 0;
                            while (true) {
                                if (i7 >= eVar.f18855a.size()) {
                                    break;
                                } else if (eVar.f18855a.get(i7).equals(a2)) {
                                    eVar.j = i7;
                                    arrayList2.add(a2);
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                            if (o6.getPostId() != 0 && (l0 = PbFragment.this.u0.l0()) != null) {
                                ArrayList<d.a.c.j.e.n> r = l0.r();
                                if (ListUtils.getCount(r) > 0) {
                                    Iterator<d.a.c.j.e.n> it = r.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        d.a.c.j.e.n next = it.next();
                                        if ((next instanceof PostData) && o6.getPostId() == d.a.c.e.m.b.f(((PostData) next).E(), 0L)) {
                                            d.a.n0.e2.m.a.b(PbFragment.this.n0.y0(), (PostData) next, ((PostData) next).d0, o6.getPostId() == d.a.c.e.m.b.f(PbFragment.this.n0.Z(), 0L) ? 1 : 8, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.f18856b.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.m4(rect2);
                            ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                            bVar2.x(arrayList2);
                            bVar2.z(eVar.f18857c);
                            bVar2.y(eVar.f18858d);
                            bVar2.O(eVar.f18859e);
                            bVar2.C(eVar.f18861g);
                            bVar2.H(true);
                            bVar2.J(eVar.f18863i);
                            bVar2.F(PbFragment.this.n0.J0());
                            bVar2.w(concurrentHashMap2);
                            bVar2.K(false);
                            bVar2.G(PbFragment.this.c5());
                            bVar2.L(eVar.f18860f);
                            bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.n0 != null) {
                                bVar2.A(PbFragment.this.n0.getFromForumId());
                                if (PbFragment.this.n0.y0() != null) {
                                    bVar2.N(PbFragment.this.n0.y0().L());
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
                    arrayList3.add(ListUtils.getItem(eVar.f18855a, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!ListUtils.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, eVar.f18856b.get(str3));
                    }
                    ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                    bVar3.x(arrayList3);
                    bVar3.z(eVar.f18857c);
                    bVar3.y(eVar.f18858d);
                    bVar3.O(eVar.f18859e);
                    bVar3.C(eVar.f18861g);
                    bVar3.H(true);
                    bVar3.J(eVar.f18855a.get(0));
                    bVar3.F(PbFragment.this.n0.J0());
                    bVar3.w(concurrentHashMap3);
                    bVar3.K(false);
                    bVar3.G(PbFragment.this.c5());
                    bVar3.L(eVar.f18860f);
                    bVar3.D(false);
                    if (PbFragment.this.n0 != null) {
                        bVar3.A(PbFragment.this.n0.getFromForumId());
                        if (PbFragment.this.n0.y0() != null) {
                            bVar3.N(PbFragment.this.n0.y0().L());
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
            if (message.what == 2 && PbFragment.this.n0 != null && PbFragment.this.n0.k0()) {
                PbFragment.this.n5();
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class v0 implements PbModel.g {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19019e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f19020f;

            public a(int i2, int i3) {
                this.f19019e = i2;
                this.f19020f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PbFragment.this.getListView() != null) {
                    PbFragment.this.getListView().setSelectionFromTop(this.f19019e, this.f19020f);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19022e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f19023f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f19024g;

            public b(int i2, boolean z, int i3) {
                this.f19022e = i2;
                this.f19023f = z;
                this.f19024g = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f19022e == -1 || PbFragment.this.getListView() == null) {
                    return;
                }
                if (this.f19023f) {
                    PbFragment.this.u0.O2(this.f19022e, this.f19024g);
                } else {
                    PbFragment.this.u0.O2(this.f19022e - 1, this.f19024g);
                }
            }
        }

        public v0() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            if (d.a.m0.m0.k.d().g()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.r : j;
                if (PbFragment.this.s == 0) {
                    PbFragment.this.s = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                d.a.m0.m0.h hVar = new d.a.m0.m0.h(i2, z, responsedMessage, PbFragment.this.v, PbFragment.this.u, PbFragment.this.s, z2, 0L, 0L, j3);
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
                if (z2 || PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || PbFragment.this.n0.y0().L() == null) {
                    return;
                }
                int u1 = PbFragment.this.n0.y0().L().u1();
                if (u1 == 0 || u1 == 40) {
                    if (!StringHelper.equals(PbFragment.this.O, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                        if (StringHelper.equals(PbFragment.this.O, "from_frs")) {
                            d.a.m0.m0.h hVar2 = new d.a.m0.m0.h();
                            hVar2.a(1000);
                            hVar2.D = j2;
                            hVar2.d(u1);
                            return;
                        }
                        return;
                    }
                    d.a.m0.m0.d dVar = new d.a.m0.m0.d();
                    dVar.F = 1;
                    dVar.a(1005);
                    dVar.D = j2;
                    dVar.d(u1);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.a.n0.e2.h.e eVar) {
            PbFragment.this.u0.l1(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, d.a.n0.e2.h.e eVar, String str, int i5) {
            d.a.m0.w.h m;
            if (!z || eVar == null || eVar.T() != null || ListUtils.getCount(eVar.D()) >= 1) {
                PbFragment.this.l = true;
                PbFragment.this.u0.I2();
                if (eVar == null || !eVar.c0()) {
                    PbFragment pbFragment = PbFragment.this;
                    pbFragment.hideLoadingView(pbFragment.u0.U0());
                }
                PbFragment.this.u0.c1();
                if (PbFragment.this.L || PbFragment.this.u0.x1()) {
                    PbFragment.this.u0.W0();
                } else if (!PbFragment.this.u0.q1()) {
                    PbFragment.this.u0.V2(false);
                }
                if (PbFragment.this.m) {
                    PbFragment.this.m = false;
                }
                if (i5 == 0 && eVar != null) {
                    PbFragment.this.C0 = true;
                }
                if (eVar != null) {
                    PbFragment pbFragment2 = PbFragment.this;
                    pbFragment2.hideNetRefreshView(pbFragment2.u0.U0());
                    PbFragment.this.u0.S2();
                }
                if (z && eVar != null) {
                    d.a.m0.r.q.a2 L = eVar.L();
                    if (L != null && L.B2()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = PbFragment.this;
                        pbFragment3.L5(pbFragment3.N0);
                    }
                    PbFragment.this.u0.J0().l(eVar);
                    PbFragment.this.u0.b3();
                    if (L != null && L.W() != null) {
                        PbFragment.this.m6(L.W());
                    }
                    if (PbFragment.this.O0 != null) {
                        PbFragment.this.u0.o2(PbFragment.this.O0.C());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.R().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.R().getBimg_end_time());
                    if (eVar.D() != null && eVar.D().size() >= 1 && eVar.D().get(0) != null) {
                        PbFragment.this.n0.I1(eVar.D().get(0).E());
                    } else if (eVar.T() != null) {
                        PbFragment.this.n0.I1(eVar.T().E());
                    }
                    if (PbFragment.this.O0 != null) {
                        PbFragment.this.O0.M(eVar.d());
                        PbFragment.this.O0.N(eVar.l(), eVar.R());
                        PbFragment.this.O0.r0(L);
                        PbFragment.this.O0.O(PbFragment.this.n0.c0(), PbFragment.this.n0.O0(), PbFragment.this.n0.Z());
                        if (L != null) {
                            PbFragment.this.O0.h0(L.n2());
                        }
                    }
                    if (PbFragment.this.p0 != null) {
                        PbFragment.this.p0.h(eVar.r());
                    }
                    if (eVar.s() == 1) {
                        PbFragment.this.w = true;
                    } else {
                        PbFragment.this.w = false;
                    }
                    if (eVar.a0()) {
                        PbFragment.this.w = true;
                    }
                    PbFragment.this.u0.p2(PbFragment.this.w);
                    PbFragment.this.u0.e3(eVar, i3, i4, PbFragment.this.n0.M0(), i5, PbFragment.this.n0.i0());
                    PbFragment.this.u0.q3(eVar, PbFragment.this.n0.M0());
                    PbFragment.this.u0.w3(PbFragment.this.n0.d0());
                    AntiData d2 = eVar.d();
                    if (d2 != null) {
                        PbFragment.this.D = d2.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.D) && PbFragment.this.O0 != null && PbFragment.this.O0.a() != null && (m = PbFragment.this.O0.a().m(6)) != null && !TextUtils.isEmpty(PbFragment.this.D)) {
                            ((View) m).setOnClickListener(PbFragment.this.z1);
                        }
                    }
                    if (PbFragment.this.E0) {
                        PbFragment.this.E0 = false;
                        int s4 = PbFragment.this.s4();
                        if (!eVar.f0()) {
                            PbFragment.this.u0.P2(s4);
                        } else {
                            d.a.c.e.m.e.a().post(new a(s4, (int) (d.a.c.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)));
                        }
                    }
                    if (!PbFragment.this.a0 && !ListUtils.isEmpty(PbFragment.this.n0.y0().D()) && !PbFragment.this.n0.Y0()) {
                        PbFragment.this.a0 = true;
                        PbFragment.this.T3(false);
                    }
                    if (PbFragment.this.K0) {
                        PbFragment.this.K0 = false;
                        int s42 = PbFragment.this.s4();
                        boolean z2 = s42 != -1;
                        if (!z2) {
                            s42 = PbFragment.this.p4();
                        }
                        if (PbFragment.this.u0 != null) {
                            if (!eVar.f0()) {
                                PbFragment.this.u0.P2(s42);
                            } else {
                                d.a.c.e.m.e.a().post(new b(s42, z2, (int) (d.a.c.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)));
                                PbFragment.this.u0.q2(true);
                                PbFragment.this.u0.V2(false);
                            }
                        }
                    } else if (PbFragment.this.L0) {
                        PbFragment.this.L0 = false;
                        PbFragment.this.u0.O2(0, 0);
                    } else {
                        PbFragment.this.u0.a3();
                    }
                    PbFragment.this.n0.g1(eVar.l(), PbFragment.this.D1);
                    PbFragment.this.n0.m1(PbFragment.this.F1);
                    if (PbFragment.this.R0 != null && L != null && L.T() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(L.T());
                        PbFragment.this.R0.setLikeUserData(attentionHostData);
                    }
                } else if (str != null) {
                    if (PbFragment.this.C0 || i5 != 1) {
                        PbFragment.this.showToast(str);
                    } else if (i3 == 3 || i3 == 4 || i3 == 6) {
                        if (i2 == 4) {
                            if (PbFragment.this.n0.Q() != null && !StringUtils.isNull(PbFragment.this.n0.Q().f52915c)) {
                                PbFragment.this.u0.y3(PbFragment.this.n0.Q());
                            } else {
                                PbFragment pbFragment4 = PbFragment.this;
                                pbFragment4.showNetRefreshView(pbFragment4.u0.U0(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                                PbFragment pbFragment5 = PbFragment.this;
                                pbFragment5.setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(pbFragment5.getContext(), R.dimen.ds360));
                            }
                        } else {
                            PbFragment pbFragment6 = PbFragment.this;
                            pbFragment6.showNetRefreshView(pbFragment6.u0.U0(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                            PbFragment pbFragment7 = PbFragment.this;
                            pbFragment7.setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(pbFragment7.getContext(), R.dimen.ds360));
                        }
                        PbFragment.this.u0.W0();
                        PbFragment.this.u0.V0();
                    }
                    if (i2 == 4 || i2 == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.n0.O0());
                            jSONObject.put("fid", PbFragment.this.n0.getForumId());
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
                        if (PbFragment.this.n0 != null && PbFragment.this.n0.y0() != null) {
                            arrayList = PbFragment.this.n0.y0().D();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                            PbFragment.this.u0.l2(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.c5()) {
                                PbFragment.this.u0.m2(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.u0.m2(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.u0.l1(PbFragment.this.n0.y0());
                        }
                    } else {
                        PbFragment.this.u0.l2("");
                    }
                    PbFragment.this.u0.g0();
                }
                if (eVar != null && eVar.m && PbFragment.this.s == 0) {
                    PbFragment.this.s = System.currentTimeMillis() - PbFragment.this.r;
                }
                if (PbFragment.this.z().M0() && PbFragment.this.z().y0().w().c() == 0 && !PbFragment.this.z().W0()) {
                    return;
                }
                PbFragment.this.P0 = true;
                return;
            }
            PbFragment.this.n0.R1(1);
            if (PbFragment.this.f18903i != null) {
                PbFragment.this.f18903i.x();
            }
        }

        public final void d() {
            if (PbFragment.this.n0 == null) {
                return;
            }
            if (PbFragment.this.O0 == null || !PbFragment.this.O0.z) {
                d.a.m0.w.w.d dVar = new d.a.m0.w.w.d();
                PbFragment.this.L5(dVar);
                PbFragment pbFragment = PbFragment.this;
                pbFragment.O0 = (d.a.m0.w.w.e) dVar.a(pbFragment.getContext());
                PbFragment.this.O0.e0(PbFragment.this.f18899e.getPageContext());
                PbFragment.this.O0.n0(PbFragment.this.X1);
                PbFragment.this.O0.o0(PbFragment.this.V0);
                PbFragment.this.O0.F(PbFragment.this.f18899e.getPageContext(), PbFragment.this.f18899e.getIntent() == null ? null : PbFragment.this.f18899e.getIntent().getExtras());
                PbFragment.this.O0.a().C(true);
                PbFragment.this.u0.k2(PbFragment.this.O0.a());
                if (!PbFragment.this.n0.m0()) {
                    PbFragment.this.O0.s(PbFragment.this.n0.O0());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    PbFragment.this.O0.k0(TbSingleton.getInstance().getAdVertiComment());
                } else if (PbFragment.this.n0.X0()) {
                    PbFragment.this.O0.k0(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else if (PbFragment.this.u0 != null) {
                    PbFragment.this.O0.k0(PbFragment.this.u0.M0());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements b.c {
        public v1() {
        }

        @Override // d.a.m0.r.s.b.c
        public void a(d.a.m0.r.s.b bVar, int i2, View view) {
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
                    pbFragment2.q5(pbFragment2.n2);
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
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && PbFragment.this.u0 != null && PbFragment.this.u0.J0() != null && PbFragment.this.u0.J0().b() != null) {
                    PbFragment.this.u0.J0().b().D();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = PbFragment.this;
                    pbFragment.F5(pbFragment.U0);
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
                PbFragment.this.l6();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements b.c {
        public w1() {
        }

        @Override // d.a.m0.r.s.b.c
        public void a(d.a.m0.r.s.b bVar, int i2, View view) {
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
                    aVar.f48819a = PbFragment.this.g1;
                    String str = "";
                    if (PbFragment.this.h1.memeInfo.pck_id.intValue() >= 0) {
                        str = "" + PbFragment.this.h1.memeInfo.pck_id;
                    }
                    aVar.f48820b = str;
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
                    pbFragment.e1 = new d.a.n0.e2.k.e.x0(pbFragment.getPageContext());
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
            PbFragment.this.u0.a1();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i2 == 0) {
                    Integer num = 0;
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    }
                    PbFragment.this.b6(num.intValue());
                } else if (i2 == 1990055) {
                    TiebaStatic.log("c12142");
                    d.a.n0.y0.a.d();
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
            if (PbFragment.this.u0 != null) {
                PbFragment pbFragment = PbFragment.this;
                pbFragment.hideLoadingView(pbFragment.u0.U0());
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
                        PbFragment.this.M5(type);
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
            if (PbFragment.this.n0 == null || PbFragment.this.n0.H0() == i2 + 1) {
                return;
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.J5(pbFragment.J4(i2));
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
            PbFragment.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.n0.y0().l().getId(), PbFragment.this.n0.y0().l().getName(), PbFragment.this.n0.y0().L().o0(), String.valueOf(PbFragment.this.n0.y0().R().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
        }
    }

    /* loaded from: classes5.dex */
    public class y0 implements a.InterfaceC1124a {
        public y0() {
        }

        @Override // d.a.m0.h.a.InterfaceC1124a
        public void a(boolean z, boolean z2, String str) {
            PbFragment.this.u0.I2();
            if (z) {
                if (PbFragment.this.p0 != null) {
                    PbFragment.this.p0.h(z2);
                }
                PbFragment.this.n0.T1(z2);
                if (PbFragment.this.n0.k0()) {
                    PbFragment.this.n5();
                } else {
                    PbFragment.this.u0.l1(PbFragment.this.n0.y0());
                }
                if (z2) {
                    if (PbFragment.this.p0 != null) {
                        if (PbFragment.this.p0.f() == null || PbFragment.this.n0 == null || PbFragment.this.n0.y0() == null || PbFragment.this.n0.y0().L() == null || PbFragment.this.n0.y0().L().T() == null) {
                            return;
                        }
                        MarkData f2 = PbFragment.this.p0.f();
                        MetaData T = PbFragment.this.n0.y0().L().T();
                        if (f2 != null && T != null) {
                            if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), T.getUserId()) && !T.hadConcerned()) {
                                PbFragment.this.W5(T);
                            } else {
                                PbFragment.this.showToast(R.string.add_mark_on_pb);
                                if (d.a.m0.s.h.a.e(PbFragment.this.getContext(), 0)) {
                                    d.a.m0.s.h.a.g(PbFragment.this.getPageContext(), 6, 2000L);
                                }
                            }
                        } else {
                            PbFragment pbFragment = PbFragment.this;
                            pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                        }
                    }
                    PbFragment.this.Q3();
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
            if (PbFragment.this.u0 != null && PbFragment.this.u0.J0() != null) {
                d.a.n0.e2.k.e.u J0 = PbFragment.this.u0.J0();
                if (J0.f()) {
                    J0.d();
                    return true;
                }
            }
            if (PbFragment.this.u0 == null || !PbFragment.this.u0.z1()) {
                return false;
            }
            PbFragment.this.u0.e1();
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class z implements c.a {
        public z() {
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                if (view != null) {
                    if (view.getId() == R.id.richText) {
                        if (PbFragment.this.E5(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.f6((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.u0.s1() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.getEventController() != null && PbFragment.this.getEventController().f53195b != null) {
                                PbFragment.this.getEventController().f53195b.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                        if (sparseArray == null) {
                            return false;
                        }
                        PbFragment.this.f6(sparseArray);
                    }
                }
                if (PbFragment.this.O0 != null) {
                    PbFragment.this.u0.o2(PbFragment.this.O0.C());
                }
                PbFragment.this.u0.h2();
                PbFragment.this.u0.a0();
                return true;
            }
            return true;
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.h4();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f19037e;

        public z0(MetaData metaData) {
            this.f19037e = metaData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f19037e.getUserId()).param("obj_locate", 2));
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
            pbFragment.f18900f = true;
            return pbFragment.b4(view);
        }
    }

    public static PbFragment s5() {
        return new PbFragment();
    }

    @Override // d.a.n0.e2.o.i
    public PbActivity A() {
        return this.f18899e;
    }

    public final boolean A4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return false;
        }
        return tbRichTextData.x().B();
    }

    public void A5(boolean z2, MarkData markData) {
        this.u0.I2();
        this.n0.T1(z2);
        d.a.m0.h.a aVar = this.p0;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.p0.i(markData);
            }
        }
        if (this.n0.k0()) {
            n5();
        } else {
            this.u0.l1(this.n0.y0());
        }
    }

    public boolean B4() {
        return this.M;
    }

    public void B5(d.a.n0.e2.h.r rVar) {
        boolean z2;
        MetaData metaData;
        if (rVar.i() == null) {
            return;
        }
        String E = rVar.i().E();
        ArrayList<PostData> D = this.n0.y0().D();
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
                            next.z0(getPageContext(), this.n0.f1(metaData.getUserId()));
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
        if (!this.n0.i0() && z2) {
            this.u0.l1(this.n0.y0());
        }
        if (z2) {
            z5(rVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.b1.m.h
    /* renamed from: C4 */
    public BdListView getListView() {
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        if (t0Var == null) {
            return null;
        }
        return t0Var.B0();
    }

    public final void C5() {
        hideNetRefreshView(this.u0.U0());
        Z5();
        if (this.n0.n1()) {
            this.u0.J2();
        }
        this.u0.S2();
    }

    public int D4() {
        return this.x2;
    }

    public void D5(p2 p2Var) {
        List<p2> list;
        if (p2Var == null || (list = this.l1) == null) {
            return;
        }
        list.remove(p2Var);
    }

    public int E4() {
        return this.w2;
    }

    public final boolean E5(View view) {
        PbModel pbModel;
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.r0 && !TextUtils.isEmpty(postData.u()) && d.a.m0.r.k.c().g()) {
                    return r5(postData.E());
                }
                if (checkUpIsLogin() && (pbModel = this.n0) != null && pbModel.y0() != null) {
                    if (K4().J0() != null) {
                        K4().J0().c();
                    }
                    d.a.n0.e2.h.r rVar = new d.a.n0.e2.h.r();
                    rVar.A(this.n0.y0().l());
                    rVar.E(this.n0.y0().L());
                    rVar.C(postData);
                    K4().I0().E(rVar);
                    K4().I0().setPostId(postData.E());
                    m5(view, postData.t().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    d.a.m0.w.w.e eVar = this.O0;
                    if (eVar != null) {
                        this.u0.o2(eVar.C());
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final String F4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return null;
        }
        return tbRichTextData.x().w();
    }

    public final void F5(EmotionImageData emotionImageData) {
        if (emotionImageData == null) {
            return;
        }
        if (this.S == null) {
            d.a.n0.e2.k.e.b1.f.a aVar = new d.a.n0.e2.k.e.b1.f.a(this.f18899e);
            this.S = aVar;
            aVar.n(this.V0);
            this.S.m(this.X1);
        }
        this.S.k(emotionImageData, z(), z().y0());
    }

    public final long G4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return 0L;
        }
        return tbRichTextData.x().getOriginalSize();
    }

    public final void G5() {
        PbModel pbModel = this.n0;
        if (pbModel == null || pbModel.y0() == null || this.n0.y0().L() == null || !this.n0.y0().L().C2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public d.a.m0.w.w.e H4() {
        return this.O0;
    }

    public final void H5(boolean z2, PostData postData) {
        d.a.n0.e2.k.e.t0 t0Var;
        d.a.n0.e2.k.e.i l02;
        ArrayList<PostData> D;
        String str;
        String str2;
        String str3;
        String str4;
        d.a.m0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense == null || !adAdSense.h() || (t0Var = this.u0) == null || (l02 = t0Var.l0()) == null || (D = l02.D()) == null) {
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
                    cVar.f54075b = E;
                    cVar.f54076c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.E == 1 && !TextUtils.isEmpty(E)) {
                next.E = 2;
                a.c cVar2 = new a.c();
                cVar2.f54075b = E;
                cVar2.f54076c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.n0;
            if (pbModel == null || pbModel.y0() == null || this.n0.y0().l() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.n0.y0().l().getFirst_class();
                str2 = this.n0.y0().l().getSecond_class();
                str3 = this.n0.y0().l().getId();
                str4 = this.n0.O0();
                str = first_class;
            }
            d.a.n0.t2.y.v(z2, str, str2, str3, str4, arrayList, adAdSense.j());
        }
    }

    public d.a.n0.e2.k.e.c1.b I4() {
        return this.f18903i;
    }

    public final void I5() {
        PbModel pbModel = this.n0;
        if (pbModel == null || pbModel.y0() == null || this.n0.y0().L() == null || !this.n0.y0().L().C2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public final int J4(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return i3 != 3 ? 1 : 7;
            }
            return 6;
        }
        return 5;
    }

    public final void J5(int i3) {
        if (this.n0 != null) {
            Z5();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
            privacySettingMessage.setTid(this.n0.f19095e);
            sendMessage(privacySettingMessage);
        }
    }

    public d.a.n0.e2.k.e.t0 K4() {
        return this.u0;
    }

    public void K5(boolean z2) {
        this.P = z2;
    }

    public d.a.m0.r.q.k1 L4() {
        return this.f0;
    }

    public final void L5(d.a.m0.w.w.g gVar) {
        PbModel pbModel;
        if (gVar == null || (pbModel = this.n0) == null) {
            return;
        }
        gVar.o(pbModel.a0());
        if (this.n0.y0() != null && this.n0.y0().l() != null) {
            gVar.n(this.n0.y0().l());
        }
        gVar.p("pb");
        gVar.q(this.n0);
    }

    public String M4() {
        return this.Y;
    }

    public final void M5(int i3) {
        PbModel pbModel = this.n0;
        if (pbModel == null) {
            return;
        }
        int H0 = pbModel.H0();
        if (i3 == 5) {
            this.n0.Q1(2);
        } else if (i3 == 6) {
            this.n0.Q1(3);
        } else if (i3 != 7) {
            this.n0.Q1(1);
        } else {
            this.n0.Q1(4);
        }
        int H02 = this.n0.H0();
        if (H0 == 4 || H02 == 4) {
            t5();
        }
    }

    public final int N4(d.a.n0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return 0;
        }
        if (eVar.L().u1() == 0) {
            return 1;
        }
        if (eVar.L().u1() == 54) {
            return 2;
        }
        return eVar.L().u1() == 40 ? 3 : 4;
    }

    public void N5(boolean z2) {
        this.M = z2;
    }

    public void O3(p2 p2Var) {
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

    public String O4() {
        return this.R;
    }

    public final void O5(boolean z2) {
        this.O0.f0(z2);
        this.O0.i0(z2);
        this.O0.p0(z2);
    }

    public void P3(p2 p2Var) {
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

    public void P4() {
        if (this.k) {
            this.Q = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.n0.y0() == null || this.n0.y0().L() == null || this.n0.y0().L().p1() == null) {
        } else {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.n0.y0().L().p1().g(), this.n0.y0().L().p1().f(), this.n0.y0().L().p1().b(), this.n0.y0().L().p1().c(), this.n0.y0().L().y0(), this.n0.y0().L().x0())));
            this.f18899e.finish();
        }
    }

    public final void P5(int i3, AntiData antiData, String str) {
        if (AntiHelper.m(i3, str)) {
            if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new e1()) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        } else if (i3 == 230277) {
            c6(str);
        } else {
            this.u0.r3(str);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.r
    public void Q(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (d.a.m0.b1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d.a.m0.b1.m.f.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (d.a.n0.e2.k.e.y0.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new d.a.m0.b1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void Q3() {
        d.a.n0.e2.h.e eVar;
        PbModel pbModel = this.n0;
        if (pbModel == null || (eVar = pbModel.I) == null || eVar.L() == null) {
            return;
        }
        d.a.m0.r.q.a2 L = this.n0.I.L();
        L.U0 = this.n0.D0();
        L.T0 = this.n0.G0();
        L.S0 = this.n0.F0();
        L.V0 = this.n0.E0();
        L.A2 = this.n0.m0();
        if (L.c0() == 0) {
            L.x3(d.a.c.e.m.b.f(this.n0.getForumId(), 0L));
        }
        StatisticItem i3 = d.a.m0.j0.c.i(getContext(), L, "c13562");
        TbPageTag l3 = d.a.m0.j0.c.l(getContext());
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

    public final void Q4(int i3, Intent intent) {
        d.a.m0.w.n nVar;
        d.a.m0.w.n nVar2;
        if (i3 == 0) {
            this.u0.Y0();
            this.u0.J0().c();
            this.u0.V2(false);
        }
        this.u0.h2();
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
                if (editorType != 1 || this.u0.J0() == null || this.u0.J0().b() == null) {
                    return;
                }
                d.a.m0.w.w.h b3 = this.u0.J0().b();
                b3.X(this.n0.y0().L());
                b3.z(writeData);
                b3.Y(pbEditorData.getVoiceModel());
                d.a.m0.w.m n3 = b3.a().n(6);
                if (n3 != null && (nVar2 = n3.k) != null) {
                    nVar2.onAction(new d.a.m0.w.a(52, 0, pbEditorData.getVoiceModel()));
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
            d.a.m0.w.m n4 = this.O0.a().n(6);
            if (n4 != null && (nVar = n4.k) != null) {
                nVar.onAction(new d.a.m0.w.a(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i3 == -1) {
                this.O0.L(null, null);
            }
        }
    }

    public final void Q5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (K4() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    d.a.m0.s.h.b.a(getPageContext(), postWriteCallBackData);
                    return;
                } else {
                    d.a.n0.e3.q0.g.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.n0.m0()) {
            antiData.setBlock_forum_name(this.n0.y0().l().getName());
            antiData.setBlock_forum_id(this.n0.y0().l().getId());
            antiData.setUser_name(this.n0.y0().R().getUserName());
            antiData.setUser_id(this.n0.y0().R().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void R3(boolean z2) {
        d.a.n0.e2.h.e eVar;
        PbModel pbModel = this.n0;
        if (pbModel == null || (eVar = pbModel.I) == null || eVar.L() == null) {
            return;
        }
        d.a.m0.r.q.a2 L = this.n0.I.L();
        L.U0 = this.n0.D0();
        L.T0 = this.n0.G0();
        L.S0 = this.n0.F0();
        L.V0 = this.n0.E0();
        if (L.c0() == 0) {
            L.x3(d.a.c.e.m.b.f(this.n0.getForumId(), 0L));
        }
        StatisticItem i3 = d.a.m0.j0.c.i(getContext(), L, "c13563");
        TbPageTag l3 = d.a.m0.j0.c.l(getContext());
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
            d.a.m0.i0.c k3 = TbPageExtraHelper.k(getContext());
            if (k3 != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, k3.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i3);
        }
    }

    public void R4(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
        String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
        String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
        String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
        String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.c1);
        userMuteAddAndDelCustomMessage.setTag(this.c1);
        d6(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public final void R5(long j3, String str, long j4) {
        d.a.n0.e2.k.e.e1.b.j(this, j3, str, j4);
    }

    public final void S3(d.a.n0.e2.h.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar == null || eVar.Q() == null || eVar.Q().f52976a == null || (list = eVar.Q().f52976a) == null || arrayList == null) {
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

    public final void S4(String str) {
        PbModel pbModel = this.n0;
        if (pbModel != null && pbModel.y0() != null && this.n0.y0().a0()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.n0.O0(), str);
            d.a.m0.r.q.a2 L = this.n0.y0().L();
            if (L.Q1()) {
                format = format + "&channelid=33833";
            } else if (L.V1()) {
                format = format + "&channelid=33842";
            } else if (L.T1()) {
                format = format + "&channelid=33840";
            }
            h5(format);
            return;
        }
        this.o0.i(str);
    }

    public final void S5(SparseArray<Object> sparseArray, int i3, boolean z2) {
        d.a.n0.e2.k.e.e1.a.d(getActivity(), getPageContext(), new j0(sparseArray, i3, z2), new k0());
    }

    public void T3(boolean z2) {
        int v2;
        int v3;
        PostData postData;
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        if (t0Var == null || t0Var.B0() == null) {
            return;
        }
        int firstVisiblePosition = this.u0.B0().getFirstVisiblePosition();
        int lastVisiblePosition = this.u0.B0().getLastVisiblePosition();
        d.a.n0.e2.k.e.i l02 = this.u0.l0();
        if (l02 == null || this.n0.y0() == null) {
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
                if (this.u0.B0().G(v2) != null && (this.u0.B0().G(v2) instanceof PostData) && (postData = (PostData) this.u0.B0().G(v2)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.n0.y0().D(), postData.A() - 1);
                    if (postData.q() == null && postData2 != null) {
                        postData.f0(postData2.q());
                    }
                    if (postData.q() != null) {
                        postData.q().j(postData.A());
                        arrayList.add(postData.q());
                    }
                }
                v2++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new d1());
            if (((d.a.m0.t.a) ListUtils.getItem(arrayList, 0)).c() != 1) {
                this.u0.u3();
                this.u0.V1((d.a.m0.t.a) ListUtils.getItem(arrayList, 0), 1);
            } else if (z2) {
            } else {
                this.u0.u3();
                this.u0.V1((d.a.m0.t.a) ListUtils.getItem(arrayList, 0), 0);
            }
        }
    }

    public final void T4(Intent intent) {
        d.a.n0.e2.k.e.e1.b.i(this, intent);
    }

    public final boolean T5(boolean z2) {
        d.a.m0.r.q.d0 d0Var;
        int i3;
        PbModel pbModel = this.n0;
        if (pbModel == null || pbModel.y0() == null) {
            return false;
        }
        d.a.n0.e2.h.e y02 = this.n0.y0();
        d.a.m0.r.q.a2 L = y02.L();
        if (L != null) {
            if (L.Q1() || L.T1()) {
                return false;
            }
            if (L.R1() || L.S1()) {
                return z2;
            }
        }
        if (z2) {
            return true;
        }
        if (L == null || L.T() == null || !L.T().isForumBusinessAccount() || d.a.n0.r0.w0.isOn()) {
            if (y02.l() == null || !y02.l().isBlockBawuDelete) {
                if (y02.S() != 0) {
                    return y02.S() != 3;
                }
                List<d.a.m0.r.q.w1> p3 = y02.p();
                if (ListUtils.getCount(p3) > 0) {
                    for (d.a.m0.r.q.w1 w1Var : p3) {
                        if (w1Var != null && (d0Var = w1Var.f50163g) != null && d0Var.f49988a && !d0Var.f49990c && ((i3 = d0Var.f49989b) == 1 || i3 == 2)) {
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

    public final boolean U3() {
        PbModel pbModel = this.n0;
        if (pbModel == null || pbModel.y0() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.n0.y0().L()) || AntiHelper.d(getPageContext(), this.n0.y0().d());
    }

    public void U4() {
        if (this.f18899e == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.f18899e.getCurrentFocus() == null) {
            return;
        }
        d.a.c.e.p.l.x(getPageContext().getPageActivity(), this.f18899e.getCurrentFocus());
    }

    public final boolean U5(boolean z2) {
        PbModel pbModel;
        if (z2 || (pbModel = this.n0) == null || pbModel.y0() == null || (this.n0.y0().l() != null && this.n0.y0().l().isBlockBawuDelete)) {
            return false;
        }
        d.a.n0.e2.h.e y02 = this.n0.y0();
        return ((y02.L() != null && y02.L().T() != null && y02.L().T().isForumBusinessAccount() && !d.a.n0.r0.w0.isOn()) || this.n0.y0().S() == 0 || this.n0.y0().S() == 3) ? false : true;
    }

    public final boolean V3(int i3) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
            return false;
        }
        return true;
    }

    public void V4() {
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        if (t0Var != null) {
            t0Var.Y0();
            U4();
        }
    }

    public final boolean V5() {
        PbModel pbModel = this.n0;
        if (pbModel != null && pbModel.M0()) {
            return this.n0.w0() == null || this.n0.w0().c() != 0;
        }
        return false;
    }

    @Override // d.a.n0.e2.o.i
    public PbModel.g W() {
        return this.a2;
    }

    public void W3(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.u0.c3();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = d.a.c.e.m.b.f(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = d.a.c.e.m.b.f((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        BdUniqueId bdUniqueId = this.c1;
        userMuteCheckCustomMessage.mId = bdUniqueId;
        userMuteCheckCustomMessage.setTag(bdUniqueId);
        this.Z0 = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public final void W4(int i3) {
        d.a.m0.z0.h0.b(new m2(), new n2(i3));
        StatisticItem statisticItem = new StatisticItem("c13833");
        statisticItem.param("obj_locate", 1);
        if (i3 == 3) {
            statisticItem.param("obj_type", 1);
        } else if (i3 == 8) {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void W5(MetaData metaData) {
        if (metaData == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getActivity());
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

    public boolean X3() {
        if ((this.n0.y0() != null && (this.n0.y0().a0() || ThreadCardUtils.isSelf(this.n0.y0().L()))) || this.R0 == null || this.n0.y0() == null || this.n0.y0().d() == null) {
            return true;
        }
        return this.R0.checkPrivacyBeforeInvokeEditor(this.n0.y0().d().replyPrivateFlag);
    }

    public final void X4(Bundle bundle) {
        d.a.m0.h.a c3 = d.a.m0.h.a.c(this.f18899e);
        this.p0 = c3;
        if (c3 != null) {
            c3.j(this.d2);
        }
        ForumManageModel forumManageModel = new ForumManageModel(this.f18899e);
        this.q0 = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.f2);
        this.r0 = new d.a.m0.s.e.a(getPageContext());
        this.H1.setUniqueId(getUniqueId());
        this.H1.registerListener();
    }

    public final void X5() {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessage(getResources().getString(R.string.mute_is_super_member_function));
        aVar.setPositiveButton(R.string.open_now, new g2());
        aVar.setNegativeButton(R.string.cancel, new h2());
        aVar.create(this.a1).show();
    }

    public boolean Y3(int i3) {
        if (this.R0 == null || this.n0.y0() == null || ThreadCardUtils.isSelf(this.n0.y0().L()) || this.n0.y0().d() == null) {
            return true;
        }
        return this.R0.checkPrivacyBeforeSend(this.n0.y0().d().replyPrivateFlag, i3);
    }

    public final void Y4() {
        this.T = new LikeModel(getPageContext());
    }

    public final void Y5(boolean z2, SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            d.a.m0.r.s.j jVar = this.z0;
            if (jVar != null && jVar.isShowing()) {
                this.z0.dismiss();
                this.z0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                d.a.m0.r.s.l lVar = new d.a.m0.r.s.l(getContext());
                lVar.n(new r(sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new d.a.m0.r.s.h(0, getResources().getString(R.string.delete), lVar));
                }
                if (z2) {
                    arrayList.add(new d.a.m0.r.s.h(1, getResources().getString(R.string.un_mute), lVar));
                } else {
                    arrayList.add(new d.a.m0.r.s.h(1, getResources().getString(R.string.mute), lVar));
                }
                lVar.k(arrayList);
                d.a.m0.r.s.j jVar2 = new d.a.m0.r.s.j(getPageContext(), lVar);
                this.z0 = jVar2;
                jVar2.l();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Z3(AgreeData agreeData) {
        d.a.m0.i0.c k3;
        PbModel pbModel;
        if (agreeData == null) {
            return;
        }
        if (this.h0 == null) {
            this.h0 = new d.a.m0.r.b0.a();
        }
        if (this.j0 == null) {
            d.a.n0.e3.h0.e eVar = new d.a.n0.e3.h0.e();
            this.j0 = eVar;
            eVar.f53996a = getUniqueId();
        }
        d.a.m0.r.q.e eVar2 = new d.a.m0.r.q.e();
        eVar2.f49994b = 5;
        eVar2.f50000h = 8;
        eVar2.f49999g = 2;
        if (z() != null) {
            eVar2.f49998f = z().x0();
        }
        eVar2.f49993a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                eVar2.f50001i = 0;
                k3 = TbPageExtraHelper.k(getContext());
                if (k3 != null) {
                    agreeData.objSource = k3.a();
                }
                this.h0.c(agreeData, i3, getUniqueId(), false);
                this.h0.d(agreeData, this.j0);
                pbModel = this.n0;
                if (pbModel != null || pbModel.y0() == null) {
                }
                this.h0.b(A(), eVar2, agreeData, this.n0.y0().L());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            eVar2.f50001i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            eVar2.f50001i = 1;
        }
        i3 = 0;
        k3 = TbPageExtraHelper.k(getContext());
        if (k3 != null) {
        }
        this.h0.c(agreeData, i3, getUniqueId(), false);
        this.h0.d(agreeData, this.j0);
        pbModel = this.n0;
        if (pbModel != null) {
        }
    }

    public final void Z4() {
        if (this.q != null) {
            return;
        }
        this.q = new d.a.m0.r.s.b(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        d.a.m0.r.s.b bVar = this.q;
        bVar.j(strArr, new a0());
        bVar.g(b.C1147b.f50224a);
        bVar.h(17);
        bVar.c(getPageContext());
    }

    public final void Z5() {
        showLoadingView(this.u0.U0(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View i3 = getLoadingView().i();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) i3.getLayoutParams();
        layoutParams.addRule(3, this.u0.T0().getId());
        i3.setLayoutParams(layoutParams);
    }

    public final void a4() {
        if (this.n0.e0() || this.n0.h0()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.n0.O0());
            this.f18899e.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.n0.O0()));
        if (j6()) {
            this.f18899e.finish();
        }
    }

    public boolean a5() {
        PbModel pbModel = this.n0;
        if (pbModel != null) {
            return pbModel.e0();
        }
        return false;
    }

    public final void a6(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && z() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            z().K(postWriteCallBackData.getPostId());
            int p02 = this.u0.p0();
            this.j1 = p02;
            this.n0.H1(p02, this.u0.w0());
        }
        this.u0.a0();
        this.y0.c();
        d.a.m0.w.w.e eVar = this.O0;
        if (eVar != null) {
            this.u0.o2(eVar.C());
        }
        this.u0.Y0();
        this.u0.V2(true);
        this.n0.V0();
    }

    public final boolean b4(View view) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        List<d.a.m0.r.s.h> b3;
        d.a.m0.r.s.h hVar;
        d.a.m0.r.s.h hVar2;
        d.a.m0.r.s.h hVar3;
        d.a.m0.r.s.h hVar4;
        d.a.c.j.d.a aVar;
        SparseArray sparseArray2;
        if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
            d.a.n0.e2.k.e.t0 t0Var = this.u0;
            if (t0Var != null) {
                if (t0Var.p1()) {
                    return true;
                }
                this.u0.j0();
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e3) {
                e3.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (d5(view)) {
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
                        this.u0.g3(this.p2, this.f1.t());
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
            if (postData.A() == 1 && d5(view)) {
                this.u0.g3(this.p2, this.f1.t());
                return true;
            }
            d.a.m0.h.a aVar2 = this.p0;
            if (aVar2 == null) {
                return true;
            }
            boolean z4 = aVar2.e() && this.n2.E() != null && this.n2.E().equals(this.n0.t0());
            boolean z5 = z().y0() != null && z().y0().a0();
            if (this.n2.A() == 1) {
                if (!z5) {
                    this.u0.h3(this.o2, z4, false);
                }
                return true;
            }
            if (this.A0 == null) {
                d.a.m0.r.s.l lVar = new d.a.m0.r.s.l(getContext());
                this.A0 = lVar;
                lVar.n(this.T1);
            }
            ArrayList arrayList = new ArrayList();
            if (view == null || sparseArray == null) {
                return true;
            }
            boolean z6 = d5(view) && !z5;
            boolean z7 = (!d5(view) || (aVar = this.f1) == null || aVar.t()) ? false : true;
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
                arrayList.add(new d.a.m0.r.s.h(1, getString(R.string.save_to_emotion), this.A0));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
            }
            if (z7) {
                arrayList.add(new d.a.m0.r.s.h(2, getString(R.string.save_to_local), this.A0));
            }
            if (!z6 && !z7) {
                d.a.m0.r.s.h hVar5 = new d.a.m0.r.s.h(3, getString(R.string.copy), this.A0);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.n2);
                hVar5.f50254d.setTag(sparseArray3);
                arrayList.add(hVar5);
            }
            if (!booleanValue && !z5) {
                if (z4) {
                    hVar4 = new d.a.m0.r.s.h(4, getString(R.string.remove_mark), this.A0);
                } else {
                    hVar4 = new d.a.m0.r.s.h(4, getString(R.string.mark), this.A0);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.n2);
                sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                hVar4.f50254d.setTag(sparseArray4);
                arrayList.add(hVar4);
            }
            if (this.mIsLogin && !this.k0) {
                if (!d.a.n0.e2.k.e.e1.a.h(this.n0) && !booleanValue4 && booleanValue3) {
                    d.a.m0.r.s.h hVar6 = new d.a.m0.r.s.h(5, getString(R.string.mute_option), this.A0);
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
                    hVar6.f50254d.setTag(sparseArray5);
                    arrayList.add(hVar6);
                } else {
                    if ((g5(booleanValue2) && TbadkCoreApplication.isLogin()) && !z5) {
                        d.a.m0.r.s.h hVar7 = new d.a.m0.r.s.h(5, getString(R.string.report_text), this.A0);
                        hVar7.f50254d.setTag(str);
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
                    if (!d.a.n0.e2.k.e.e1.a.h(this.n0) && z2) {
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
                        hVar2 = new d.a.m0.r.s.h(6, getString(R.string.delete), this.A0);
                        hVar2.f50254d.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        hVar2 = null;
                    }
                    hVar = new d.a.m0.r.s.h(7, getString(R.string.bar_manager), this.A0);
                    hVar.f50254d.setTag(sparseArray6);
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
                    if (this.n0.y0().S() == 1002 && !booleanValue2) {
                        hVar3 = new d.a.m0.r.s.h(6, getString(R.string.report_text), this.A0);
                    } else {
                        hVar3 = new d.a.m0.r.s.h(6, getString(R.string.delete), this.A0);
                    }
                    hVar3.f50254d.setTag(sparseArray7);
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
                d.a.n0.e2.k.e.e1.a.a(arrayList, this.A0, this.n2, this.n0);
            }
            if (d.a.m0.b.d.z()) {
                b3 = d.a.n0.e2.k.e.e1.a.c(arrayList, this.n2.r(), sparseArray, this.A0);
            } else {
                b3 = d.a.n0.e2.k.e.e1.a.b(arrayList, this.n2.r(), sparseArray, this.A0);
            }
            d.a.n0.e2.k.e.e1.a.k(b3, this.f18900f);
            d.a.n0.e2.k.e.e1.a.e(b3);
            this.A0.o(d.a.n0.e2.k.e.e1.a.f(this.n2));
            if (d.a.m0.b.d.z()) {
                this.A0.l(b3, false);
            } else {
                this.A0.l(b3, true);
            }
            d.a.m0.r.s.j jVar = new d.a.m0.r.s.j(getPageContext(), this.A0);
            this.z0 = jVar;
            jVar.l();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.n0.f19095e).param("fid", this.n0.getForumId()).param("uid", this.n0.y0().L().T().getUserId()).param("post_id", this.n0.s()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return true;
    }

    public final boolean b5() {
        PostData c3 = d.a.n0.e2.h.f.c(this.n0.y0(), this.n0.M0(), this.n0.I0());
        return (c3 == null || c3.t() == null || c3.t().getGodUserData() == null || c3.t().getGodUserData().getType() != 2) ? false : true;
    }

    public final void b6(int i3) {
        d.a.n0.e2.k.e.e1.b.m(this, o4(), i3);
    }

    public void c4(ForumManageModel.b bVar, d.a.n0.e2.k.e.t0 t0Var) {
        List<PostData> list = this.n0.y0().Q().f52976a;
        int size = list.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= list.get(i3).M().size()) {
                    break;
                } else if (bVar.f20831g.equals(list.get(i3).M().get(i4).E())) {
                    list.get(i3).M().remove(i4);
                    list.get(i3).m();
                    z2 = true;
                    break;
                } else {
                    i4++;
                }
            }
            list.get(i3).o(bVar.f20831g);
        }
        if (z2) {
            t0Var.l1(this.n0.y0());
        }
    }

    public boolean c5() {
        PbModel pbModel = this.n0;
        if (pbModel != null) {
            return pbModel.d0();
        }
        return false;
    }

    public final void c6(String str) {
        if (str == null) {
            str = "";
        }
        d.a.c.a.f fVar = this.a1;
        if (fVar == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(fVar.getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new i2());
        aVar.create(this.a1).show();
    }

    public final void d4(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.n0.e3.h0.o x2 = this.n0.y0().x();
        if (x2 != null && str.equals(x2.D0())) {
            if (x2.getAdvertAppInfo() != null) {
                x2.getAdvertAppInfo().O3 = null;
            }
            this.n0.y0().b();
        }
        d.a.n0.e3.h0.o U = this.n0.U();
        if (U == null || !str.equals(U.D0())) {
            return;
        }
        this.n0.J();
    }

    public boolean d5(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public final void d6(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z2) {
            this.u0.c3();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.a1.getPageActivity());
        if (d.a.c.e.p.k.isEmpty(str)) {
            aVar.setMessage(this.a1.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.setMessage(str);
        }
        aVar.setPositiveButton(R.string.confirm, new k2(userMuteAddAndDelCustomMessage));
        aVar.setNegativeButton(R.string.cancel, new l2());
        aVar.create(this.a1).show();
    }

    public void e4(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        int intValue = ((Integer) sparseArray.get(d.a.n0.e2.k.e.t0.X1)).intValue();
        if (intValue == d.a.n0.e2.k.e.t0.Y1) {
            if (this.q0.K()) {
                return;
            }
            this.u0.t3();
            String str = (String) sparseArray.get(R.id.tag_del_post_id);
            int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            if (jSONArray != null) {
                this.q0.M(StringHelper.JsonArrayToString(jSONArray));
            }
            this.q0.N(this.n0.y0().l().getId(), this.n0.y0().l().getName(), this.n0.y0().L().o0(), str, intValue3, intValue2, booleanValue, this.n0.y0().L().V());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
        } else if (intValue == d.a.n0.e2.k.e.t0.Z1 || intValue == d.a.n0.e2.k.e.t0.b2) {
            if (this.n0.W() != null) {
                this.n0.W().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
            }
            if (intValue == d.a.n0.e2.k.e.t0.Z1) {
                TiebaStatic.log("c10499");
            }
        }
    }

    public boolean e5(int i3) {
        List<ForumToolPerm> forumToolAuth;
        if (i3 == 1) {
            return true;
        }
        if (this.n0.y0().R() != null && (forumToolAuth = this.n0.y0().R().getForumToolAuth()) != null) {
            for (int i4 = 0; i4 < forumToolAuth.size(); i4++) {
                ForumToolPerm forumToolPerm = forumToolAuth.get(i4);
                if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void e6() {
        PbModel pbModel = this.n0;
        if (pbModel == null || d.a.c.e.p.k.isEmpty(pbModel.O0())) {
            return;
        }
        d.a.m0.a.c.y().P(d.a.m0.a.b.W, d.a.c.e.m.b.f(this.n0.O0(), 0L));
    }

    public void f4(d.a.m0.r.s.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (aVar.getYesButtonTag() instanceof SparseArray) {
                e4((SparseArray) aVar.getYesButtonTag(), jSONArray);
                return;
            }
            return;
        }
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
    }

    public final boolean f5(int i3) {
        return i3 == 2 || i3 == 1;
    }

    public final void f6(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            g6(postData, false);
        }
    }

    @Override // d.a.n0.e2.o.i
    public void finish() {
        d.a.n0.e2.k.e.t0 t0Var;
        CardHListViewData q3;
        d.a.n0.e2.k.e.t0 t0Var2 = this.u0;
        if (t0Var2 != null) {
            t0Var2.a0();
        }
        PbModel pbModel = this.n0;
        if (pbModel != null && pbModel.y0() != null && !this.n0.y0().a0()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.n0.y0().L().o0();
            if (this.n0.isShareThread() && this.n0.y0().L().s1 != null) {
                historyMessage.threadName = this.n0.y0().L().s1.f12034b;
            } else {
                historyMessage.threadName = this.n0.y0().L().z1();
            }
            if (this.n0.isShareThread() && !isSimpleForum()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.n0.y0().l().getName();
            }
            ArrayList<PostData> D = this.n0.y0().D();
            d.a.n0.e2.k.e.t0 t0Var3 = this.u0;
            int s02 = t0Var3 != null ? t0Var3.s0() : 0;
            if (D != null && s02 >= 0 && s02 < D.size()) {
                historyMessage.postID = D.get(s02).E();
            }
            historyMessage.isHostOnly = this.n0.d0();
            historyMessage.isSquence = this.n0.M0();
            historyMessage.isShareThread = this.n0.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        d.a.m0.w.w.e eVar = this.O0;
        if (eVar != null) {
            eVar.I();
        }
        if (this.n && K4() != null) {
            K4().f0();
        }
        PbModel pbModel2 = this.n0;
        if (pbModel2 != null && (pbModel2.e0() || this.n0.h0())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.n0.O0());
            if (this.v0) {
                if (this.x0) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.n0.n0());
                }
                if (this.w0) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.n0.j0());
                }
            }
            if (this.n0.y0() != null && System.currentTimeMillis() - this.t >= 40000 && (q3 = this.n0.y0().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                intent.putExtra("guess_like_data", q3);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.k1);
            }
            this.f18899e.setResult(-1, intent);
        }
        if (j6()) {
            if (this.n0 != null && (t0Var = this.u0) != null && t0Var.B0() != null) {
                d.a.n0.e2.h.e y02 = this.n0.y0();
                if (y02 != null) {
                    if (y02.R() != null) {
                        y02.R().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!y02.c0() && !this.K && y02.f52926h == null) {
                        d.a.n0.e2.k.e.m0.b().n(this.n0.z0(), this.u0.B0().onSaveInstanceState(), this.n0.M0(), this.n0.d0(), this.u0.H0() != null && this.u0.H0().getVisibility() == 0);
                        if (this.j1 >= 0 || this.n0.Q0() != null) {
                            d.a.n0.e2.k.e.m0.b().q(this.n0.Q0());
                            d.a.n0.e2.k.e.m0.b().r(this.n0.R0());
                            d.a.n0.e2.k.e.m0.b().o(this.n0.r0());
                        }
                    }
                }
            } else {
                d.a.n0.e2.k.e.m0.b().m();
            }
            i6();
        }
    }

    public void g4(int i3, String str, int i4, boolean z2) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
        sparseArray.put(d.a.n0.e2.k.e.t0.X1, Integer.valueOf(d.a.n0.e2.k.e.t0.Y1));
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            e4(sparseArray, null);
        } else {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final boolean g5(boolean z2) {
        PbModel pbModel = this.n0;
        if (pbModel != null && pbModel.y0() != null) {
            return ((this.n0.y0().S() != 0) || this.n0.y0().L() == null || this.n0.y0().L().T() == null || TextUtils.equals(this.n0.y0().L().T().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
        }
        return false;
    }

    public final void g6(PostData postData, boolean z2) {
        PbModel pbModel;
        if (postData == null || (pbModel = this.n0) == null || pbModel.y0() == null || postData.A() == 1) {
            return;
        }
        String O0 = this.n0.O0();
        String E = postData.E();
        int S = this.n0.y0() != null ? this.n0.y0().S() : 0;
        PbActivity.e x5 = x5(E);
        if (x5 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(O0, E, "pb", true, null, false, null, S, postData.O(), this.n0.y0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null).addBigImageData(x5.f18855a, x5.f18856b, x5.f18861g, x5.j);
        addBigImageData.setKeyPageStartFrom(this.n0.x0());
        addBigImageData.setFromFrsForumId(this.n0.getFromForumId());
        addBigImageData.setKeyFromForumId(this.n0.getForumId());
        addBigImageData.setBjhData(this.n0.T());
        addBigImageData.setIsOpenEditor(z2);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public d.a.n0.e2.k.e.c1.a getEventController() {
        return this.f18899e.getEventController();
    }

    @Override // d.a.m0.b1.m.h
    public d.a.c.e.k.b<GifView> getGifViewPool() {
        if (this.N == null) {
            this.N = new d.a.c.e.k.b<>(new r1(), 20, 0);
        }
        return this.N;
    }

    @Override // d.a.m0.b1.m.h
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

    @Override // d.a.m0.b1.m.h
    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        d.a.c.e.k.b<RelativeLayout> bVar = new d.a.c.e.k.b<>(new t1(), 10, 0);
        this.J = bVar;
        return bVar;
    }

    @Override // d.a.m0.b1.m.h
    public int getRichTextViewId() {
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        if (t0Var == null) {
            return 0;
        }
        return t0Var.O0();
    }

    @Override // d.a.m0.b1.m.h
    public d.a.c.e.k.b<TextView> getTextViewPool() {
        if (this.E == null) {
            this.E = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.E;
    }

    @Override // d.a.m0.b1.m.h
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

    @Override // d.a.m0.b1.m.h
    public d.a.c.e.k.b<View> getVoiceViewPool() {
        if (this.H == null) {
            this.H = new d.a.c.e.k.b<>(new s1(), 8, 0);
        }
        return this.H;
    }

    public void h4() {
        TiebaStatic.log("c12181");
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        if (t0Var == null || this.n0 == null) {
            return;
        }
        if ((t0Var != null && !t0Var.n1()) || this.n0.y0() == null || this.n0.y0().P() == null) {
            return;
        }
        d.a.n0.e2.k.e.t0 t0Var2 = this.u0;
        if (t0Var2 == null || t0Var2.r0() == null || !this.u0.r0().c()) {
            d.a.n0.e2.h.p P = this.n0.y0().P();
            if (checkUpIsLogin()) {
                if ((!P.h() || P.c() != 2) && this.u0.l0() != null && this.u0.l0().y() != null) {
                    this.u0.l0().y().h0(this.n0.O0());
                }
                if (System.currentTimeMillis() - this.B > 2000) {
                    new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                    this.B = System.currentTimeMillis();
                }
            }
        }
    }

    public final void h5(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    public final void h6() {
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
        PbActivity pbActivity = this.f18899e;
        if (pbActivity != null) {
            pbActivity.stopVoice();
        }
    }

    public void i4() {
        PbModel pbModel;
        if (this.u0 == null || (pbModel = this.n0) == null) {
            return;
        }
        if ((pbModel.y0() == null && this.n0.y0().P() == null) || !checkUpIsLogin() || this.u0.l0() == null || this.u0.l0().y() == null) {
            return;
        }
        this.u0.l0().y().h0(this.n0.O0());
    }

    public final void i5() {
        if (this.z2 != null) {
            if (this.x2 == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.z2.a(), this.x2, 0)));
                this.f18899e.finish();
            }
        }
    }

    public final void i6() {
        this.f18899e.superCloseActivity();
    }

    public boolean isSimpleForum() {
        PbModel pbModel = this.n0;
        if (pbModel == null) {
            return false;
        }
        return pbModel.e1();
    }

    @Override // d.a.n0.e2.p.e.b
    public void j0(boolean z2) {
        this.D0 = z2;
    }

    public final void j4(String str) {
        PbModel pbModel = this.n0;
        if (pbModel == null || pbModel.y0() == null || this.n0.y0().L() == null || !this.n0.y0().L().B2()) {
            return;
        }
        d.a.m0.r.q.a2 L = this.n0.y0().L();
        int i3 = 0;
        if (L.Q1()) {
            i3 = 1;
        } else if (L.T1()) {
            i3 = 2;
        } else if (L.R1()) {
            i3 = 3;
        } else if (L.S1()) {
            i3 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i3);
        TiebaStatic.log(statisticItem);
    }

    public void j5(String str) {
        d.a.n0.e2.k.e.t0 t0Var;
        if (this.n0 == null || StringUtils.isNull(str) || (t0Var = this.u0) == null) {
            return;
        }
        t0Var.t2(true);
        this.n0.j1(str);
        this.K = true;
        this.u0.a0();
        this.u0.W0();
    }

    public final boolean j6() {
        PbModel pbModel = this.n0;
        if (pbModel == null) {
            return true;
        }
        if (pbModel.y0() == null || !this.n0.y0().a0()) {
            if (this.n0.k0()) {
                MarkData X = this.n0.X();
                if (X != null && this.n0.i0()) {
                    MarkData R = this.n0.R(this.u0.s0());
                    if (R == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", X);
                        this.f18899e.setResult(-1, intent);
                        return true;
                    } else if (R.getPostId() != null && !R.getPostId().equals(X.getPostId())) {
                        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getPageContext().getPageActivity());
                        aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                        aVar.setPositiveButton(R.string.confirm, new m1(R, X, aVar));
                        aVar.setNegativeButton(R.string.cancel, new o1(X, aVar));
                        aVar.setOnCalcelListener(new p1(X, aVar));
                        aVar.create(getPageContext());
                        aVar.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", X);
                        this.f18899e.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (this.n0.y0() != null && this.n0.y0().D() != null && this.n0.y0().D().size() > 0 && this.n0.i0()) {
                this.f18899e.setResult(1);
            }
            return true;
        }
        return true;
    }

    public final void k4(ForumManageModel.b bVar, boolean z2) {
        if (bVar == null || !isAdded()) {
            return;
        }
        String string = !TextUtils.isEmpty(bVar.f20826b) ? bVar.f20826b : getString(R.string.delete_fail);
        int i3 = 0;
        if (bVar.f20827c == 1211066) {
            hideProgressBar();
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getPageContext().getPageActivity());
            aVar.setMessage(string);
            aVar.setPositiveButton(R.string.dialog_known, new g1());
            aVar.setCancelable(true);
            aVar.create(getPageContext());
            aVar.show();
        } else {
            this.u0.i0(0, bVar.f20825a, bVar.f20826b, z2);
        }
        if (bVar.f20825a) {
            int i4 = bVar.f20828d;
            if (i4 == 1) {
                ArrayList<PostData> D = this.n0.y0().D();
                int size = D.size();
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (bVar.f20831g.equals(D.get(i3).E())) {
                        D.remove(i3);
                        break;
                    } else {
                        i3++;
                    }
                }
                this.n0.y0().L().c4(this.n0.y0().L().a1() - 1);
                this.u0.l1(this.n0.y0());
            } else if (i4 == 0) {
                a4();
            } else if (i4 == 2) {
                ArrayList<PostData> D2 = this.n0.y0().D();
                int size2 = D2.size();
                boolean z3 = false;
                for (int i5 = 0; i5 < size2 && !z3; i5++) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= D2.get(i5).M().size()) {
                            break;
                        } else if (bVar.f20831g.equals(D2.get(i5).M().get(i6).E())) {
                            D2.get(i5).M().remove(i6);
                            D2.get(i5).m();
                            z3 = true;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    D2.get(i5).o(bVar.f20831g);
                }
                if (z3) {
                    this.u0.l1(this.n0.y0());
                }
                c4(bVar, this.u0);
            }
        }
    }

    public final void k5(Bundle bundle) {
        PbModel pbModel = this.f18899e.getPbModel();
        this.n0 = pbModel;
        if (pbModel.W() != null) {
            this.n0.W().c(this.v2);
        }
        if (this.n0.u0() != null) {
            this.n0.u0().f(this.q1);
        }
        if (StringUtils.isNull(this.n0.O0())) {
            this.f18899e.finish();
        } else if (!"from_tieba_kuang".equals(this.O) || this.O == null) {
        } else {
            this.n0.N1(6);
        }
    }

    public final void k6(int i3) {
        TiebaStatic.log(new StatisticItem("c14000").param("tid", this.n0.f19095e).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(d.a.n0.e2.k.e.e1.a.m(i3))));
    }

    public final void l4(int i3, ForumManageModel.g gVar) {
        String string;
        if (gVar == null) {
            return;
        }
        this.u0.i0(this.q0.getLoadDataMode(), gVar.f20846a, gVar.f20847b, false);
        if (gVar.f20846a) {
            this.v0 = true;
            if (i3 == 2 || i3 == 3) {
                this.w0 = true;
                this.x0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.w0 = false;
                this.x0 = true;
            }
            if (i3 == 2) {
                this.n0.y0().L().O3(1);
                this.n0.J1(1);
            } else if (i3 == 3) {
                this.n0.y0().L().O3(0);
                this.n0.J1(0);
            } else if (i3 == 4) {
                this.n0.y0().L().P3(1);
                this.n0.K1(1);
            } else if (i3 == 5) {
                this.n0.y0().L().P3(0);
                this.n0.K1(0);
            }
            this.u0.A3(this.n0.y0(), this.n0.M0());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f20847b)) {
            string = gVar.f20847b;
        } else {
            string = getString(R.string.operation_failed);
        }
        d.a.c.e.p.l.M(getPageContext().getPageActivity(), string);
    }

    public final void l5() {
        if (this.z2 != null) {
            if (this.w2 == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.z2.a(), this.w2, 0)));
                this.f18899e.finish();
            }
        }
    }

    public final void l6() {
        if (!TbadkCoreApplication.isLogin() || !AddExperiencedModel.x(this.n0.getForumId()) || this.n0.y0() == null || this.n0.y0().l() == null) {
            return;
        }
        if (this.n0.y0().l().isLike() == 1) {
            this.n0.O().w(this.n0.getForumId(), this.n0.O0());
        }
    }

    public final void m4(Rect rect) {
        d.a.n0.e2.k.e.t0 t0Var;
        if (rect == null || (t0Var = this.u0) == null || t0Var.T0() == null || rect.top > this.u0.T0().getHeight()) {
            return;
        }
        rect.top += this.u0.T0().getHeight() - rect.top;
    }

    public final void m5(View view, String str, String str2, PostData postData) {
        if (view == null || str == null || str2 == null || U3() || !X3()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.b0);
            this.c0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (K4().J0() != null && postData != null) {
            K4().J0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
        }
        if (this.n0.y0() != null && this.n0.y0().a0()) {
            d.a.c.e.m.e.a().postDelayed(new n0(str, str2), 0L);
            return;
        }
        if (this.T0 == null) {
            d.a.n0.r0.f2.a.c cVar = new d.a.n0.r0.f2.a.c(getPageContext());
            this.T0 = cVar;
            cVar.k(1);
            this.T0.j(new o0(str, str2));
        }
        PbModel pbModel = this.n0;
        if (pbModel == null || pbModel.y0() == null || this.n0.y0().l() == null) {
            return;
        }
        this.T0.g(this.n0.y0().l().getId(), d.a.c.e.m.b.f(this.n0.O0(), 0L));
    }

    public final void m6(d.a.m0.r.q.t tVar) {
        if (tVar != null) {
            this.z2 = tVar;
            this.f18901g = true;
            this.u0.e2();
            this.u0.x2(this.y2);
        }
    }

    public AntiData n4() {
        PbModel pbModel = this.n0;
        if (pbModel == null || pbModel.y0() == null) {
            return null;
        }
        return this.n0.y0().d();
    }

    public final void n5() {
        d.a.n0.e2.h.e y02 = this.n0.y0();
        this.n0.T1(true);
        d.a.m0.h.a aVar = this.p0;
        if (aVar != null) {
            y02.q0(aVar.g());
        }
        this.u0.l1(y02);
    }

    public final void n6(int i3) {
        d.a.m0.r.q.a2 L;
        PbModel pbModel = this.n0;
        if (pbModel == null || pbModel.y0() == null || (L = this.n0.y0().L()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData Q0 = L.Q0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (Q0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i3);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    L.b4(praiseData);
                } else {
                    L.Q0().getUser().add(0, metaData);
                    L.Q0().setNum(L.Q0().getNum() + 1);
                    L.Q0().setIsLike(i3);
                }
            }
            if (L.Q0() != null) {
                if (L.Q0().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    StringHelper.numFormatOver10000(L.Q0().getNum());
                }
            }
        } else if (L.Q0() != null) {
            L.Q0().setIsLike(i3);
            L.Q0().setNum(L.Q0().getNum() - 1);
            ArrayList<MetaData> user = L.Q0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        L.Q0().getUser().remove(next);
                        break;
                    }
                }
            }
            if (L.Q0().getNum() < 1) {
                getResources().getString(R.string.zan);
            } else {
                String str = L.Q0().getNum() + "";
            }
        }
        if (this.n0.M0()) {
            this.u0.l0().U();
        } else {
            this.u0.C3(this.n0.y0());
        }
    }

    public final int o4() {
        if (this.n0.y0() == null || this.n0.y0().L() == null) {
            return -1;
        }
        return this.n0.y0().L().G();
    }

    public final void o5() {
        MarkData R;
        if (this.p0 != null) {
            if (this.n0.y0() != null && this.n0.y0().a0()) {
                R = this.n0.R(0);
            } else {
                R = this.n0.R(this.u0.A0());
            }
            if (R == null) {
                return;
            }
            if (R.isApp() && (R = this.n0.R(this.u0.A0() + 1)) == null) {
                return;
            }
            this.u0.J2();
            this.p0.i(R);
            if (!this.p0.e()) {
                this.p0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.p0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final TbRichText o6(String str, int i3) {
        PbModel pbModel = this.n0;
        TbRichText tbRichText = null;
        if (pbModel == null || pbModel.y0() == null || str == null || i3 < 0) {
            return null;
        }
        d.a.n0.e2.h.e y02 = this.n0.y0();
        if (y02.j() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(y02.j());
            tbRichText = v4(arrayList, str, i3);
        }
        if (tbRichText == null) {
            ArrayList<PostData> D = y02.D();
            S3(y02, D);
            return v4(D, str, i3);
        }
        return tbRichText;
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
        d.a.n0.e2.k.e.b1.f.a aVar = this.S;
        if (aVar != null) {
            aVar.i(i3, i4, intent);
        }
        if (K4().J0() != null) {
            K4().J0().g(i3, i4, intent);
        }
        if (i3 == 25035) {
            Q4(i4, intent);
        }
        if (i4 == -1) {
            if (i3 == 11009) {
                o5();
            } else if (i3 == 13008) {
                d.a.n0.e2.k.e.m0.b().m();
                this.m0.postDelayed(new k1(), 1000L);
            } else if (i3 == 13011) {
                d.a.n0.s2.a.g().m(getPageContext());
            } else if (i3 == 23003) {
                if (intent == null || this.n0 == null) {
                    return;
                }
                R5(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
            } else if (i3 == 23007) {
                T4(intent);
            } else if (i3 == 25012) {
                intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                intent.getStringExtra("KEY_FORUM_NAME");
            } else if (i3 == 25016 || i3 == 25023) {
                Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                    return;
                }
                this.U0 = emotionImageData;
                if (Y3(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                    F5(emotionImageData);
                }
            } else if (i3 == 25033) {
                View view = this.U;
                if (view != null) {
                    this.u0.Z2(view);
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
                    d.a.n0.s2.a.g().m(getPageContext());
                    l6();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.t0;
                    if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.t) == null) {
                        return;
                    }
                    shareSuccessReplyToServerModel.s(str, intExtra, new l1());
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
                        d.a.n0.e2.k.e.t0 t0Var = this.u0;
                        if (t0Var == null || t0Var.m0() == null) {
                            return;
                        }
                        this.u0.m0().performClick();
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
                this.u0.L2(false);
                if (this.n0.y0() == null || this.n0.y0().L() == null || this.n0.y0().L().T0() == null) {
                    return;
                }
                this.n0.y0().L().T0().setStatus(2);
            }
        }
    }

    @Override // d.a.m0.b1.m.h
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.A = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f18899e = (PbActivity) context;
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
        this.u0.E1(i3);
        d.a.m0.w.w.e eVar = this.O0;
        if (eVar != null && eVar.a() != null) {
            this.O0.a().w(i3);
        }
        if (this.u0.a() != null) {
            this.u0.a().c(getPageContext(), i3);
        }
        this.y0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.Z = i3;
        h6();
    }

    @Override // d.a.m0.r.s.a.e
    public void onClick(d.a.m0.r.s.a aVar) {
        f4(aVar, null);
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
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        if (t0Var != null) {
            t0Var.F1(configuration);
        }
        d.a.m0.r.s.j jVar = this.z0;
        if (jVar != null) {
            jVar.dismiss();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        d.a.n0.e2.k.e.t0 t0Var;
        d.a.n0.e2.k.e.t0 t0Var2;
        this.t = System.currentTimeMillis();
        this.a1 = getPageContext();
        Intent intent = this.f18899e.getIntent();
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
            this.E0 = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.K0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.L0 = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (z4()) {
                this.f18899e.setUseStyleImmersiveSticky(false);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.R = stringExtra;
            this.R = d.a.c.e.p.k.isEmpty(stringExtra) ? "" : this.R;
            this.k1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            d.a.m0.r.q.k1 k1Var = new d.a.m0.r.q.k1();
            this.f0 = k1Var;
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
        k5(bundle);
        if (this.n0.y0() != null) {
            this.n0.y0().x0(this.R);
        }
        Y4();
        if (intent != null && (t0Var2 = this.u0) != null) {
            t0Var2.f53441b = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.d1 == null) {
                    this.d1 = new u(intent);
                }
                d.a.c.e.m.e.a().postDelayed(this.d1, 1500L);
            }
            String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra2) && this.n0.y0() != null) {
                this.n0.O1(stringExtra2);
            }
        }
        VoiceManager voiceManager = new VoiceManager();
        this.o = voiceManager;
        voiceManager.onCreate(getPageContext());
        X4(bundle);
        d.a.m0.w.w.g gVar = new d.a.m0.w.w.g();
        this.N0 = gVar;
        L5(gVar);
        d.a.m0.w.w.e eVar = (d.a.m0.w.w.e) this.N0.a(getActivity());
        this.O0 = eVar;
        eVar.e0(this.f18899e.getPageContext());
        this.O0.n0(this.X1);
        this.O0.o0(this.V0);
        this.O0.g0(1);
        this.O0.F(this.f18899e.getPageContext(), bundle);
        this.O0.a().b(new d.a.m0.w.k(getActivity()));
        this.O0.a().C(true);
        O5(true);
        this.O0.O(this.n0.c0(), this.n0.O0(), this.n0.Z());
        registerListener(this.u1);
        if (!this.n0.m0()) {
            this.O0.s(this.n0.O0());
        }
        if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
            this.O0.k0(TbSingleton.getInstance().getAdVertiComment());
        } else if (this.n0.X0()) {
            this.O0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            d.a.n0.e2.k.e.t0 t0Var3 = this.u0;
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
        d.a.n0.e3.h0.f fVar = new d.a.n0.e3.h0.f("pb", d.a.n0.e3.h0.f.f53999d);
        this.M0 = fVar;
        fVar.d();
        registerListener(this.A1);
        registerListener(this.J1);
        this.n0.q1();
        registerListener(this.b2);
        registerListener(this.R1);
        registerListener(this.W1);
        registerListener(this.E1);
        d.a.n0.e2.k.e.t0 t0Var4 = this.u0;
        if (t0Var4 != null && t0Var4.T0() != null && this.u0.R0() != null) {
            d.a.n0.e2.k.e.c1.b bVar = new d.a.n0.e2.k.e.c1.b(getActivity(), this.u0.T0(), this.u0.R0(), this.u0.H0());
            this.f18903i = bVar;
            bVar.t(this.I1);
        }
        if (this.f18901g && (t0Var = this.u0) != null && t0Var.R0() != null) {
            this.u0.R0().setVisibility(8);
        }
        d.a.m0.r.f0.c cVar = new d.a.m0.r.f0.c();
        this.b1 = cVar;
        cVar.f49709a = 1000L;
        registerListener(this.P1);
        registerListener(this.N1);
        registerListener(this.O1);
        registerListener(this.C1);
        registerListener(this.y1);
        this.B1.setSelfListener(true);
        this.B1.setTag(this.f18899e.getUniqueId());
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
        this.n0.V().w(this.L1);
        this.y0 = new d.a.n0.e2.k.e.v0();
        if (this.O0.v() != null) {
            this.y0.m(this.O0.v().i());
        }
        this.O0.d0(this.W0);
        this.t0 = new ShareSuccessReplyToServerModel();
        O3(this.p1);
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
        this.R0 = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new w());
        d.a.n0.e2.k.f.a aVar = new d.a.n0.e2.k.f.a(getContext());
        this.o0 = aVar;
        aVar.a(getUniqueId());
        d.a.n0.d3.c.g().i(getUniqueId());
        d.a.m0.r.o.a.b().l("3", "");
        this.o1 = new d.a.n0.y.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && d.a.c.e.p.j.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
        }
        this.u = System.currentTimeMillis() - this.t;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u0 = new d.a.n0.e2.k.e.t0(this, this.V1, this.M1);
        d.a.n0.g0.b bVar = new d.a.n0.g0.b(getActivity());
        this.f18902h = bVar;
        bVar.i(B2);
        this.f18902h.d(this.u2);
        this.u0.D2(this.e2);
        this.u0.C2(this.j2);
        this.u0.w2(this.h2);
        this.u0.u2(d.a.m0.r.k.c().g());
        this.u0.A2(this.l2);
        this.u0.F2(this.r2);
        this.u0.B2(this.s2);
        this.u0.z2(this.g2);
        this.u0.x3(this.mIsLogin);
        if (this.f18899e.getIntent() != null) {
            this.u0.s2(this.f18899e.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.u0.I0().setFromForumId(this.n0.getFromForumId());
        this.u0.k2(this.O0.a());
        if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
            this.O0.k0(TbSingleton.getInstance().getAdVertiComment());
        } else {
            this.O0.k0(this.u0.M0());
        }
        this.u0.n2(new y());
        this.u0.r2(this.n0.h0());
        this.u0.E2(this.n0.x0());
        return this.u0.U0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.a.n0.e2.k.e.f1.c cVar;
        d.a.n0.d3.c.g().k(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            StatisticItem statisticItem = new StatisticItem("c13266");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.n0.y0().m());
            statisticItem.param("tid", this.n0.O0());
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(statisticItem);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.x && this.u0 != null) {
            this.x = true;
            H5(false, null);
        }
        PbModel pbModel = this.n0;
        if (pbModel != null) {
            pbModel.cancelLoadData();
            this.n0.destory();
            if (this.n0.u0() != null) {
                this.n0.u0().d();
            }
        }
        d.a.m0.w.w.e eVar = this.O0;
        if (eVar != null) {
            eVar.I();
        }
        ForumManageModel forumManageModel = this.q0;
        if (forumManageModel != null) {
            forumManageModel.cancelLoadData();
        }
        LikeModel likeModel = this.T;
        if (likeModel != null) {
            likeModel.E();
        }
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        if (t0Var != null) {
            t0Var.G1();
            d.a.n0.e2.k.e.f1.c cVar2 = this.u0.f53447h;
            if (cVar2 != null) {
                cVar2.p();
            }
        }
        d.a.m0.m0.b bVar = this.y;
        if (bVar != null) {
            bVar.c();
        }
        d.a.n0.e2.k.e.c1.b bVar2 = this.f18903i;
        if (bVar2 != null) {
            bVar2.k();
        }
        super.onDestroy();
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.a.n0.e2.k.e.t0 t0Var2 = this.u0;
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
        d.a.n0.t2.g0.a.e().g();
        if (this.d1 != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.d1);
        }
        d.a.n0.e2.k.e.b1.f.a aVar = this.S;
        if (aVar != null) {
            aVar.f();
        }
        d.a.n0.e2.k.e.t0 t0Var3 = this.u0;
        if (t0Var3 != null && (cVar = t0Var3.f53447h) != null) {
            cVar.j();
        }
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.t0;
        if (shareSuccessReplyToServerModel != null) {
            shareSuccessReplyToServerModel.cancelLoadData();
        }
        d.a.n0.e2.k.e.v0 v0Var = this.y0;
        if (v0Var != null) {
            v0Var.j();
        }
        PbModel pbModel2 = this.n0;
        if (pbModel2 != null && pbModel2.O() != null) {
            this.n0.O().onDestroy();
        }
        ReplyPrivacyCheckController replyPrivacyCheckController = this.R0;
        if (replyPrivacyCheckController != null) {
            replyPrivacyCheckController.onDestroy();
        }
        d.a.n0.e2.k.e.t0 t0Var4 = this.u0;
        if (t0Var4 != null) {
            t0Var4.u3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.g0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.c.j.e.q onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        d.a.n0.e2.k.e.t0 t0Var;
        return (keyEvent == null || (t0Var = this.u0) == null || !t0Var.I1(i3)) ? false : true;
    }

    @Override // d.a.m0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        this.A = true;
    }

    @Override // d.a.m0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        PbModel pbModel;
        if (d.a.n0.e2.k.e.y0.c(str) && (pbModel = this.n0) != null && pbModel.O0() != null) {
            TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.n0.O0()));
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                d.a.m0.t.m mVar = new d.a.m0.t.m();
                mVar.f50797a = str;
                mVar.f50798b = 3;
                mVar.f50799c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, mVar));
            }
        } else {
            d.a.n0.e2.k.e.y0.a().e(getPageContext(), str);
        }
        this.A = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        C5();
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
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        if (t0Var != null) {
            t0Var.L1();
        }
        if (!this.n0.m0()) {
            this.O0.U(this.n0.O0());
        }
        PbModel pbModel = this.n0;
        if (pbModel != null) {
            pbModel.p1();
        }
        d.a.m0.a.c.y().E();
        MessageManager.getInstance().unRegisterListener(this.x1);
        G5();
        MessageManager.getInstance().unRegisterListener(this.N1);
        MessageManager.getInstance().unRegisterListener(this.O1);
        MessageManager.getInstance().unRegisterListener(this.P1);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    @Override // d.a.m0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.B0 = str;
        if (this.q == null) {
            Z4();
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
    public void onPreLoad(d.a.c.j.e.q qVar) {
        PreLoadImageHelper.load(qVar, getUniqueId(), 3);
        PreLoadVideoHelper.load(qVar, getUniqueId(), this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.k = false;
        super.onResume();
        if (this.Q) {
            this.Q = false;
            P4();
        }
        if (b5()) {
            this.z = System.currentTimeMillis();
        } else {
            this.z = -1L;
        }
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        if (t0Var != null && t0Var.U0() != null) {
            if (!this.l) {
                Z5();
            } else {
                hideLoadingView(this.u0.U0());
            }
            this.u0.M1();
        }
        if (this.p == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        d.a.n0.e2.k.e.t0 t0Var2 = this.u0;
        NoNetworkView a3 = t0Var2 != null ? t0Var2.a() : null;
        if (a3 != null && a3.getVisibility() == 0 && d.a.c.e.p.j.z()) {
            a3.e(false);
        }
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        registerListener(this.x1);
        this.D0 = false;
        I5();
        registerListener(this.N1);
        registerListener(this.O1);
        registerListener(this.P1);
        if (this.i1) {
            C5();
            this.i1 = false;
        }
        e6();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.n0.E1(bundle);
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.O0.K(bundle);
    }

    @Override // d.a.m0.b1.m.h
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
        if (K4().J0() != null) {
            K4().J0().i();
        }
        d.a.n0.e2.k.e.f1.c cVar = this.u0.f53447h;
        if (cVar != null && !cVar.l()) {
            this.u0.f53447h.p();
        }
        PbModel pbModel = this.n0;
        if (pbModel != null && pbModel.y0() != null && this.n0.y0().l() != null && this.n0.y0().L() != null) {
            d.a.m0.u.a.k().y(getPageContext().getPageActivity(), "pb", this.n0.y0().l().getId(), d.a.c.e.m.b.f(this.n0.y0().L().o0(), 0L));
        }
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
        d.a.n0.d3.c.g().h(getUniqueId(), false);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        super.onUserChanged(z2);
        this.u0.x3(z2);
        d.a.m0.r.s.j jVar = this.z0;
        if (jVar != null) {
            jVar.dismiss();
        }
        if (z2 && this.D0) {
            this.u0.K2();
            this.n0.h1(true);
        }
    }

    @Override // d.a.m0.b1.m.h
    public void onVideoClicked(Context context, String str) {
        d.a.n0.e2.k.e.y0.a().e(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.A = true;
    }

    @Override // d.a.m0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
    }

    public final int p4() {
        if (K4() != null && K4().B0() != null) {
            BdTypeListView B0 = K4().B0();
            List<d.a.c.j.e.n> data = B0.getData();
            int headerViewsCount = B0.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i3 = 0; i3 < size; i3++) {
                    d.a.c.j.e.n nVar = data.get(i3);
                    if ((nVar instanceof PostData) && nVar.getType() == PostData.p0) {
                        return i3 + headerViewsCount;
                    }
                }
            }
        }
        return -1;
    }

    public final void p5(View view) {
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
        q5(postData);
    }

    public PostData q4() {
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        PbModel pbModel = this.n0;
        return t0Var.t0(pbModel.I, pbModel.M0());
    }

    public void q5(PostData postData) {
        PostData q4;
        if (postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.E() != null && postData.E().equals(this.n0.t0())) {
            z2 = true;
        }
        MarkData s02 = this.n0.s0(postData);
        if (this.n0.y0() != null && this.n0.y0().a0() && (q4 = q4()) != null) {
            s02 = this.n0.s0(q4);
        }
        if (s02 == null) {
            return;
        }
        this.u0.J2();
        d.a.m0.h.a aVar = this.p0;
        if (aVar != null) {
            aVar.i(s02);
            if (!z2) {
                this.p0.a();
            } else {
                this.p0.d();
            }
        }
    }

    public String r4() {
        return this.O;
    }

    public final boolean r5(String str) {
        if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String p3 = d.a.m0.r.d0.b.j().p("bubble_link", "");
            if (StringUtils.isNull(p3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                d.a.m0.l.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p3 + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return false;
    }

    public int s4() {
        if (K4() != null && K4().B0() != null) {
            BdTypeListView B0 = K4().B0();
            List<d.a.c.j.e.n> data = B0.getData();
            int headerViewsCount = B0.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i3 = 0; i3 < size; i3++) {
                    d.a.c.j.e.n nVar = data.get(i3);
                    if ((nVar instanceof d.a.n0.e2.h.o) && ((d.a.n0.e2.h.o) nVar).f52956f == d.a.n0.e2.h.o.m) {
                        return i3 + headerViewsCount;
                    }
                }
            }
        }
        return -1;
    }

    public final String t4() {
        d.a.n0.e2.h.e y02;
        PbModel pbModel = this.n0;
        if (pbModel == null || (y02 = pbModel.y0()) == null) {
            return null;
        }
        return y02.Q().f52978c;
    }

    public final void t5() {
        if (!d.a.c.e.p.j.z()) {
            showToast(R.string.network_not_available);
            return;
        }
        this.u0.a0();
        if (this.m) {
            return;
        }
        h6();
        this.u0.J2();
        if (this.n0.LoadData()) {
            this.u0.l3();
        }
    }

    public final String u4() {
        ArrayList<PostData> D;
        int count;
        PbModel pbModel = this.n0;
        if (pbModel == null || pbModel.y0() == null || this.n0.y0().D() == null || (count = ListUtils.getCount((D = this.n0.y0().D()))) == 0) {
            return "";
        }
        if (this.n0.J0()) {
            Iterator<PostData> it = D.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.A() == 1) {
                    return next.E();
                }
            }
        }
        int s02 = this.u0.s0();
        PostData postData = (PostData) ListUtils.getItem(D, s02);
        if (postData != null && postData.t() != null) {
            if (this.n0.f1(postData.t().getUserId())) {
                return postData.E();
            }
            for (int i3 = s02 - 1; i3 != 0; i3--) {
                PostData postData2 = (PostData) ListUtils.getItem(D, i3);
                if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                    break;
                } else if (this.n0.f1(postData2.t().getUserId())) {
                    return postData2.E();
                }
            }
            for (int i4 = s02 + 1; i4 < count; i4++) {
                PostData postData3 = (PostData) ListUtils.getItem(D, i4);
                if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                    break;
                } else if (this.n0.f1(postData3.t().getUserId())) {
                    return postData3.E();
                }
            }
        }
        return "";
    }

    public void u5() {
        d.a.n0.e2.h.e y02;
        d.a.m0.r.q.a2 L;
        PbModel pbModel = this.n0;
        if (pbModel == null || pbModel.y0() == null || (L = (y02 = this.n0.y0()).L()) == null || L.T() == null) {
            return;
        }
        this.u0.Y0();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), L.T().getUserId());
        d.a.n0.e2.k.e.g0 g0Var = new d.a.n0.e2.k.e.g0();
        int S = this.n0.y0().S();
        if (S != 1 && S != 3) {
            g0Var.f53342g = false;
        } else {
            g0Var.f53342g = true;
            g0Var.q = L.y0() == 1;
        }
        if (e5(S)) {
            g0Var.f53343h = true;
            g0Var.p = L.x0() == 1;
        } else {
            g0Var.f53343h = false;
        }
        if (S == 1002 && !equals) {
            g0Var.r = true;
        }
        g0Var.f53340e = T5(equals);
        g0Var.f53344i = V5();
        g0Var.f53341f = U5(equals);
        g0Var.k = equals && y02.R() != null && y02.R().showPbPrivate();
        g0Var.o = this.n0.M0();
        g0Var.f53337b = true;
        g0Var.f53336a = g5(equals);
        if (equals) {
            this.u0.m1();
        }
        g0Var.n = TbadkCoreApplication.getInst().getSkinType() == 1;
        g0Var.j = true;
        g0Var.m = this.n0.d0();
        g0Var.f53339d = true;
        if (L.w1() == null) {
            g0Var.f53338c = true;
        } else {
            g0Var.f53338c = false;
        }
        if (y02.a0()) {
            g0Var.f53337b = false;
            g0Var.f53339d = false;
            g0Var.f53338c = false;
            g0Var.f53342g = false;
            g0Var.f53343h = false;
        }
        g0Var.s = TbSingleton.getInstance().mShowCallFans && equals && !y02.a0();
        d.a.n0.e2.k.e.t0 t0Var = this.u0;
        if (t0Var != null) {
            PbModel pbModel2 = this.n0;
            PostData t02 = t0Var.t0(pbModel2.I, pbModel2.M0());
            g0Var.t = t02 != null ? t02.S : false;
        }
        g0Var.l = true;
        if (d.a.m0.c1.b.e.d()) {
            g0Var.f53339d = false;
            g0Var.f53337b = false;
            g0Var.f53338c = false;
            g0Var.l = false;
        }
        this.u0.f53447h.w(g0Var);
    }

    public final TbRichText v4(ArrayList<PostData> arrayList, String str, int i3) {
        ArrayList<TbRichTextData> u2;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                TbRichText K = arrayList.get(i4).K();
                if (K != null && (u2 = K.u()) != null) {
                    int size = u2.size();
                    int i5 = -1;
                    for (int i6 = 0; i6 < size; i6++) {
                        if (u2.get(i6) != null && u2.get(i6).getType() == 8) {
                            i5++;
                            if (u2.get(i6).x().u().equals(str) || u2.get(i6).x().v().equals(str)) {
                                int h3 = (int) d.a.c.e.p.l.h(TbadkCoreApplication.getInst());
                                int width = u2.get(i6).x().getWidth() * h3;
                                int height = u2.get(i6).x().getHeight() * h3;
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

    public final void v5(String str, int i3, PbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        if (eVar == null) {
            return;
        }
        d.a.n0.e2.h.e y02 = this.n0.y0();
        TbRichText o6 = o6(str, i3);
        if (o6 == null || (tbRichTextData = o6.u().get(this.k2)) == null) {
            return;
        }
        eVar.f18860f = String.valueOf(o6.getPostId());
        eVar.f18855a = new ArrayList<>();
        eVar.f18856b = new ConcurrentHashMap<>();
        if (!tbRichTextData.x().z()) {
            eVar.f18862h = false;
            String a3 = d.a.n0.e2.h.f.a(tbRichTextData);
            eVar.f18855a.add(a3);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.w ? 17 : 18;
            }
            imageUrlData.originalUrl = F4(tbRichTextData);
            imageUrlData.originalUrl = F4(tbRichTextData);
            imageUrlData.originalSize = G4(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = A4(tbRichTextData);
            imageUrlData.isLongPic = y4(tbRichTextData);
            imageUrlData.postId = o6.getPostId();
            imageUrlData.mIsReserver = this.n0.J0();
            imageUrlData.mIsSeeHost = this.n0.d0();
            eVar.f18856b.put(a3, imageUrlData);
            if (y02 != null) {
                if (y02.l() != null) {
                    eVar.f18857c = y02.l().getName();
                    eVar.f18858d = y02.l().getId();
                }
                if (y02.L() != null) {
                    eVar.f18859e = y02.L().o0();
                }
                eVar.f18861g = y02.s() == 1;
            }
            imageUrlData.threadId = d.a.c.e.m.b.f(eVar.f18859e, -1L);
            return;
        }
        eVar.f18862h = true;
        int size = y02.D().size();
        this.m2 = false;
        eVar.j = -1;
        int w4 = y02.j() != null ? w4(y02.j().K(), o6, i3, i3, eVar.f18855a, eVar.f18856b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = y02.D().get(i4);
            if (postData.E() == null || y02.j() == null || y02.j().E() == null || !postData.E().equals(y02.j().E())) {
                w4 = w4(postData.K(), o6, w4, i3, eVar.f18855a, eVar.f18856b);
            }
        }
        if (eVar.f18855a.size() > 0) {
            ArrayList<String> arrayList = eVar.f18855a;
            eVar.f18863i = arrayList.get(arrayList.size() - 1);
        }
        if (y02 != null) {
            if (y02.l() != null) {
                eVar.f18857c = y02.l().getName();
                eVar.f18858d = y02.l().getId();
            }
            if (y02.L() != null) {
                eVar.f18859e = y02.L().o0();
            }
            eVar.f18861g = y02.s() == 1;
        }
        eVar.j = w4;
    }

    @Override // d.a.n0.e2.o.i
    public VideoPbFragment w() {
        return null;
    }

    public final int w4(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        TbRichTextImageInfo x2;
        if (tbRichText == tbRichText2) {
            this.m2 = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.u().size();
            int i5 = i3;
            int i6 = -1;
            for (int i7 = 0; i7 < size; i7++) {
                TbRichTextData tbRichTextData = tbRichText.u().get(i7);
                if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                    i6++;
                    int h3 = (int) d.a.c.e.p.l.h(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.x().getWidth() * h3;
                    int height = tbRichTextData.x().getHeight() * h3;
                    if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.x().z()) {
                        if (tbRichText == tbRichText2) {
                            if (i6 <= i4) {
                                i5--;
                            }
                        }
                    } else if (tbRichTextData.getType() != 20) {
                        String a3 = d.a.n0.e2.h.f.a(tbRichTextData);
                        if (!TextUtils.isEmpty(a3)) {
                            arrayList.add(a3);
                            if (tbRichTextData != null && (x2 = tbRichTextData.x()) != null) {
                                String u2 = x2.u();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    u2 = x2.v();
                                } else {
                                    imageUrlData.urlType = this.w ? 17 : 18;
                                }
                                imageUrlData.imageUrl = u2;
                                imageUrlData.originalUrl = F4(tbRichTextData);
                                imageUrlData.originalSize = G4(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = A4(tbRichTextData);
                                imageUrlData.isLongPic = y4(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = d.a.c.e.m.b.f(this.n0.O0(), -1L);
                                imageUrlData.mIsReserver = this.n0.J0();
                                imageUrlData.mIsSeeHost = this.n0.d0();
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

    public void w5() {
        PbModel pbModel;
        if (!checkUpIsLogin() || (pbModel = this.n0) == null || pbModel.y0() == null || this.n0.y0().l() == null || U3()) {
            return;
        }
        if (this.n0.y0().a0()) {
            this.u0.T();
            return;
        }
        if (this.S0 == null) {
            d.a.n0.r0.f2.a.c cVar = new d.a.n0.r0.f2.a.c(getPageContext());
            this.S0 = cVar;
            cVar.k(0);
            this.S0.j(new l0());
        }
        this.S0.g(this.n0.y0().l().getId(), d.a.c.e.m.b.f(this.n0.O0(), 0L));
    }

    public PbInterviewStatusView.f x4() {
        return this.l0;
    }

    public final PbActivity.e x5(String str) {
        String str2 = null;
        if (this.n0.y0() != null && this.n0.y0().D() != null && this.n0.y0().D().size() != 0 && !StringUtils.isNull(str)) {
            PbActivity.e eVar = new PbActivity.e();
            int i3 = 0;
            while (true) {
                if (i3 >= this.n0.y0().D().size()) {
                    i3 = 0;
                    break;
                } else if (str.equals(this.n0.y0().D().get(i3).E())) {
                    break;
                } else {
                    i3++;
                }
            }
            PostData postData = this.n0.y0().D().get(i3);
            if (postData.K() != null && postData.K().u() != null) {
                Iterator<TbRichTextData> it = postData.K().u().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        if (next.x() != null) {
                            str2 = next.x().u();
                        }
                    }
                }
                v5(str2, 0, eVar);
                d.a.n0.e2.h.f.b(postData, eVar);
                return eVar;
            }
        }
        return null;
    }

    public final boolean y4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return false;
        }
        return tbRichTextData.x().A();
    }

    public final void y5(View view) {
        if (view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.f18900f ? 2 : 3));
        view.setTag(sparseArray);
    }

    @Override // d.a.n0.e2.o.i
    public PbModel z() {
        return this.n0;
    }

    @Override // d.a.n0.e2.o.i
    public PbFragment z0() {
        return this;
    }

    public boolean z4() {
        return (!this.f18901g && this.w2 == -1 && this.x2 == -1) ? false : true;
    }

    public void z5(d.a.n0.e2.h.r rVar) {
        String E = rVar.i().E();
        List<PostData> list = this.n0.y0().Q().f52976a;
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
        if (this.n0.i0()) {
            return;
        }
        this.u0.l1(this.n0.y0());
    }
}
