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
import d.b.h0.a0.d;
import d.b.h0.b1.m.f;
import d.b.h0.h.a;
import d.b.h0.r.f0.f;
import d.b.h0.r.q.b1;
import d.b.h0.r.s.a;
import d.b.h0.r.s.b;
import d.b.h0.r.s.l;
import d.b.i0.c2.i.c;
import d.b.i0.c2.k.e.c0;
import d.b.i0.c2.k.e.o;
import d.b.i0.c2.k.e.z0.b;
import d.b.i0.c2.p.a;
import d.b.i0.c3.j0.a;
import d.b.i0.f0.a;
import d.b.i0.f0.b;
import d.b.i0.p0.f2.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ForumToolPerm;
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class PbFragment extends BaseFragment implements d.b.h0.b1.m.h, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a.e, TbRichTextView.q, TbPageContextSupport, d.b.i0.c2.o.b, a.b {
    public static final AntiHelper.k y2 = new g0();
    public static final b.InterfaceC1245b z2 = new a2();
    public String A0;
    public boolean C0;
    public d.b.b.e.k.b<TextView> E;
    public boolean E1;
    public d.b.b.e.k.b<TbImageView> F;
    public d.b.b.e.k.b<ImageView> G;
    public d.b.b.e.k.b<View> H;
    public d.b.b.e.k.b<LinearLayout> I;
    public d.b.b.e.k.b<RelativeLayout> J;
    public d.b.i0.c3.h0.f L0;
    public d.b.h0.w.w.g M0;
    public d.b.b.e.k.b<GifView> N;
    public d.b.h0.w.w.e N0;
    public boolean O0;
    public PermissionJudgePolicy P0;
    public ReplyPrivacyCheckController Q0;
    public d.b.i0.p0.f2.a.c R0;
    public d.b.i0.c2.k.e.y0.f.a S;
    public d.b.i0.p0.f2.a.c S0;
    public LikeModel T;
    public EmotionImageData T0;
    public View U;
    public View V;
    public View W;
    public View X;
    public String Y;
    public Object Y0;
    public d.b.b.a.f Z0;
    public d.b.h0.r.f0.c a1;
    public int b0;
    public BdUniqueId b1;
    public Runnable c1;
    public d.b.i0.c2.k.e.u0 d1;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19547e;
    public d.b.h0.r.q.k1 e0;
    public d.b.b.j.d.a e1;
    public String f1;
    public d.b.h0.r.b0.a g0;
    public TbRichTextMemeInfo g1;
    public boolean g2;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.f0.b f19550h;
    public d.b.i0.c2.k.e.z0.b i;
    public d.b.i0.c3.h0.e i0;
    public boolean j;
    public List<l2> k1;
    public boolean m;
    public String m1;
    public d.b.i0.c2.k.f.a n0;
    public d.b.i0.w.a n1;
    public VoiceManager o;
    public boolean w;
    public String w2;
    public d.b.i0.c2.k.e.s0 x0;
    public d.b.h0.r.q.t x2;
    public d.b.h0.r.s.j y0;
    public d.b.h0.r.s.l z0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19548f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19549g = false;
    public boolean k = false;
    public boolean l = false;
    public boolean n = true;
    public int p = 0;
    public d.b.h0.r.s.b q = null;
    public long r = -1;
    public long s = 0;
    public long t = 0;
    public long u = 0;
    public long v = 0;
    public boolean x = false;
    public d.b.h0.m0.b y = null;
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
    public int[] a0 = new int[2];
    public int c0 = -1;
    public int d0 = -1;
    public BdUniqueId f0 = BdUniqueId.gen();
    public boolean h0 = false;
    public boolean j0 = d.b.h0.b.d.S();
    public PbInterviewStatusView.f k0 = new k();
    public final Handler l0 = new Handler(new v());
    public PbModel m0 = null;
    public d.b.h0.h.a o0 = null;
    public ForumManageModel p0 = null;
    public d.b.h0.s.e.a q0 = null;
    public d.b.i0.c2.h.r r0 = null;
    public ShareSuccessReplyToServerModel s0 = null;
    public d.b.i0.c2.k.e.q0 t0 = null;
    public boolean u0 = false;
    public boolean v0 = false;
    public boolean w0 = false;
    public boolean B0 = false;
    public boolean D0 = false;
    public boolean E0 = false;
    public boolean K0 = false;
    public d.b.h0.w.w.c U0 = new r0();
    public d.b.h0.w.w.b V0 = new c1();
    public d.b.h0.w.w.b W0 = new n1();
    public int X0 = 0;
    public boolean h1 = false;
    public int i1 = 0;
    public int j1 = -1;
    public int l1 = 0;
    public final l2 o1 = new y1();
    public final c0.b p1 = new j2();
    public final CustomMessageListener q1 = new k2(2004016);
    public CustomMessageListener r1 = new a(2016485);
    public CustomMessageListener s1 = new b(2001269);
    public CustomMessageListener t1 = new c(2004008);
    public CustomMessageListener u1 = new d(2004007);
    public CustomMessageListener v1 = new e(2004005);
    public CustomMessageListener w1 = new f(2001332);
    public final CustomMessageListener x1 = new g(2921391);
    public View.OnClickListener y1 = new h();
    public CustomMessageListener z1 = new i(2001369);
    public CustomMessageListener A1 = new j(2016488);
    public CustomMessageListener B1 = new l(2016331);
    public SuggestEmotionModel.c C1 = new m();
    public GetSugMatchWordsModel.b D1 = new n();
    public PraiseModel F1 = new PraiseModel(getPageContext(), new o());
    public b.h G1 = new p();
    public CustomMessageListener H1 = new r(2001115);
    public d.b.h0.f0.h I1 = new s();
    public CheckRealNameModel.b J1 = new w();
    public d.b.i0.c2.i.c K1 = new d.b.i0.c2.i.c(new y());
    public CustomMessageListener L1 = new a0(2001427);
    public CustomMessageListener M1 = new b0(2001428);
    public CustomMessageListener N1 = new c0(2001426);
    public CustomMessageListener O1 = new d0(2004021);
    public CustomMessageListener P1 = new e0(2921033);
    public a.e Q1 = new f0();
    public l.e R1 = new h0();
    public SortSwitchButton.f S1 = new j0();
    public final View.OnClickListener T1 = new m0();
    public CustomMessageListener U1 = new n0(2921480);
    public final NewWriteModel.g V1 = new o0();
    public NewWriteModel.g W1 = new p0();
    public d.b.b.c.g.a X1 = new q0(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
    public final PbModel.g Y1 = new s0();
    public CustomMessageListener Z1 = new t0(2016450);
    public HttpMessageListener a2 = new u0(CmdConfigHttp.SET_PRIVATE_CMD, true);
    public final a.InterfaceC1065a b2 = new v0();
    public final AbsListView.OnScrollListener c2 = new y0();
    public final d.b.b.a.e d2 = new a1();
    public final n2 e2 = new d1();
    public final f.g f2 = new e1();
    public final BdListView.p h2 = new f1();
    public int i2 = 0;
    public final TbRichTextView.w j2 = new q1();
    public boolean k2 = false;
    public PostData l2 = null;
    public final b.c m2 = new r1();
    public final b.c n2 = new s1();
    public final AdapterView.OnItemClickListener o2 = new t1();
    public final View.OnLongClickListener p2 = new u1();
    public final NoNetworkView.b q2 = new v1();
    public View.OnTouchListener r2 = new x1();
    public a.b s2 = new z1();
    public final o.b t2 = new b2();
    public int u2 = -1;
    public int v2 = -1;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.b.h0.t.m)) {
                PbFragment.this.m0.Z1((d.b.h0.t.m) customResponsedMessage.getData());
                if (PbFragment.this.t0 != null && PbFragment.this.m0 != null) {
                    PbFragment.this.t0.M1(PbFragment.this.m0.y0(), PbFragment.this.m0.M0(), PbFragment.this.m0.I0(), PbFragment.this.t0.I0());
                }
                if (PbFragment.this.t0 == null || PbFragment.this.t0.e0() == null) {
                    return;
                }
                PbFragment.this.t0.e0().U();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends CustomMessageListener {
        public a0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.b1) {
                PbFragment.this.t0.S0();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                d.b.i0.c2.h.e y0 = PbFragment.this.m0.y0();
                if (y0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    y0.u().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.a1.c(PbFragment.this.Z0.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.Z0.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.X5(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.S5();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.b.b.e.p.k.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.Z0.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.a1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a1 extends d.b.b.a.e {
        public a1() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (PbFragment.this.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (PbFragment.this.p0.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.m0.V0();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            PbFragment.this.h4(bVar, (bVar.f21384e != 1002 || bVar.f21385f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.t0.b0(1, dVar.f21387a, dVar.f21388b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = PbFragment.this;
                            pbFragment.i4(pbFragment.p0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.t0.b0(PbFragment.this.p0.getLoadDataMode(), gVar.f21401a, gVar.f21402b, false);
                            PbFragment.this.t0.C1(gVar.f21403c);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.t0.b0(PbFragment.this.p0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a2 implements b.InterfaceC1245b {
        @Override // d.b.i0.f0.b.InterfaceC1245b
        public void a(boolean z) {
            if (z) {
                d.b.i0.c2.i.b.d();
            } else {
                d.b.i0.c2.i.b.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (PbFragment.this.t0 == null) {
                return;
            }
            if (booleanValue) {
                PbFragment.this.t0.T2();
            } else {
                PbFragment.this.t0.U0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends CustomMessageListener {
        public b0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.b1) {
                PbFragment.this.t0.S0();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.a1.c(PbFragment.this.Z0.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.b.b.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.Z0.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.a1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b1 implements a.e {
        public b1() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b2 implements o.b {
        public b2() {
        }

        @Override // d.b.i0.c2.k.e.o.b
        public void a(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.t0.R(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (PbFragment.this.N0 != null) {
                PbFragment.this.t0.Z1(PbFragment.this.N0.C());
            }
            PbFragment.this.t0.F2(false);
        }
    }

    /* loaded from: classes4.dex */
    public class c0 extends CustomMessageListener {
        public c0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.b.i0.n3.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.b1) {
                d.b.i0.n3.a aVar = (d.b.i0.n3.a) customResponsedMessage.getData();
                PbFragment.this.t0.S0();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.Y0;
                DataRes dataRes = aVar.f57157a;
                if (aVar.f57159c == 0 && dataRes != null) {
                    int d2 = d.b.b.e.m.b.d(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = d2 == 1;
                    if (d.b.b.e.p.k.isEmpty(str)) {
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
                    PbFragment.this.T5(r2, sparseArray);
                } else if (intValue == 1) {
                    PbFragment.this.t0.F1(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c1 implements d.b.h0.w.w.b {
        public c1() {
        }

        @Override // d.b.h0.w.w.b
        public boolean a() {
            d.b.i0.c2.k.e.s0 s0Var = PbFragment.this.x0;
            if (s0Var == null || s0Var.e() == null || !PbFragment.this.x0.e().d()) {
                return !PbFragment.this.V3(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.showToast(pbFragment.x0.e().c());
            if (PbFragment.this.N0 != null && (PbFragment.this.N0.B() || PbFragment.this.N0.D())) {
                PbFragment.this.N0.z(false, PbFragment.this.x0.h());
            }
            PbFragment.this.x0.a(true);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class c2 implements a.e {
        public c2() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (Build.VERSION.SDK_INT < 11) {
                aVar.dismiss();
                ((TbPageContext) PbFragment.this.Z0).showToast(R.string.frs_header_games_unavailable);
                return;
            }
            TiebaStatic.log("c10025");
            aVar.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.Z0.getPageActivity(), 2, true, 4);
            if (!StringUtils.isNULL("4010001001")) {
                memberPayActivityConfig.setSceneId("4010001001");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.b.i0.c2.e eVar = (d.b.i0.c2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                PbFragment.this.x5((d.b.i0.c2.h.q) eVar.a());
            } else if (b2 == 1) {
                PbFragment.this.h4((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    PbFragment.this.w5(false, null);
                } else {
                    PbFragment.this.w5(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 extends CustomMessageListener {
        public d0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.t0.d1() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.e4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d1 implements n2 {
        public d1() {
        }
    }

    /* loaded from: classes4.dex */
    public class d2 implements a.e {
        public d2() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.t0 == null || PbFragment.this.t0.e0() == null) {
                return;
            }
            PbFragment.this.t0.e0().U();
        }
    }

    /* loaded from: classes4.dex */
    public class e0 extends CustomMessageListener {
        public e0(int i) {
            super(i);
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
            PbFragment.this.h1 = true;
        }
    }

    /* loaded from: classes4.dex */
    public class e1 implements f.g {
        public e1() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.v4()) {
                PbFragment.this.f19547e.finish();
            }
            if (!PbFragment.this.m0.l1(true)) {
                PbFragment.this.t0.a0();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e2 implements a.e {
        public e2() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof f.a)) {
                return;
            }
            f.a aVar = (f.a) customResponsedMessage.getData();
            d.b.h0.b1.m.f.c(PbFragment.this.getPageContext(), PbFragment.this, aVar.f49979a, aVar.f49980b, aVar.f49981c);
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements a.e {
        public f0() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            PbFragment.this.Q4();
            d.b.h0.r.q.z0 w0 = PbFragment.this.m0.w0();
            int y0 = PbFragment.this.t0.y0();
            if (y0 <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (w0 == null || y0 <= w0.h()) {
                PbFragment.this.t0.T();
                PbFragment.this.c6();
                PbFragment.this.t0.u2();
                if (d.b.b.e.p.j.z()) {
                    PbFragment.this.m0.R1(PbFragment.this.t0.y0());
                    if (PbFragment.this.i != null) {
                        PbFragment.this.i.x();
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

    /* loaded from: classes4.dex */
    public class f1 implements BdListView.p {
        public f1() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (PbFragment.this.g2 && PbFragment.this.v4()) {
                PbFragment.this.e5();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.h0 && PbFragment.this.t0 != null && PbFragment.this.t0.M() && PbFragment.this.m0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", PbFragment.this.m0.O0());
                    statisticItem.param("fid", PbFragment.this.m0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (PbFragment.this.m0.e0()) {
                        i = 4;
                    } else if (PbFragment.this.m0.f0()) {
                        i = 3;
                    } else if (PbFragment.this.m0.h0()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    PbFragment.this.h0 = true;
                }
                if (PbFragment.this.m0.h1(false)) {
                    PbFragment.this.t0.v2();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.m0.y0() != null) {
                    PbFragment.this.t0.O1();
                }
                PbFragment.this.g2 = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f2 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f19573e;

        public f2(UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            this.f19573e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            PbFragment.this.t0.M2();
            MessageManager.getInstance().sendMessage(this.f19573e);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.k) {
                return;
            }
            PbFragment.this.Z5();
        }
    }

    /* loaded from: classes4.dex */
    public static class g0 implements AntiHelper.k {
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    /* loaded from: classes4.dex */
    public class g1 implements Runnable {
        public g1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PbFragment.this.m0 != null) {
                PbFragment.this.m0.LoadData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g2 implements a.e {
        public g2() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment pbFragment = PbFragment.this;
            pbFragment.showToast(pbFragment.D);
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements l.e {

        /* loaded from: classes4.dex */
        public class a implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SparseArray f19580e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f19581f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f19582g;

            public a(SparseArray sparseArray, int i, boolean z) {
                this.f19580e = sparseArray;
                this.f19581f = i;
                this.f19582g = z;
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                PbFragment.this.d4(((Integer) this.f19580e.get(R.id.tag_del_post_type)).intValue(), (String) this.f19580e.get(R.id.tag_del_post_id), this.f19581f, this.f19582g);
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b(h0 h0Var) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public h0() {
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(d.b.h0.r.s.l lVar, int i, View view) {
            SparseArray sparseArray;
            if (PbFragment.this.y0 != null) {
                PbFragment.this.y0.dismiss();
            }
            PbFragment.this.f6(i);
            int i2 = 4;
            switch (i) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    PbFragment.this.u5(view2);
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    }
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    PbFragment.this.u5(view3);
                    if (view3 != null) {
                        view3.performClick();
                        return;
                    }
                    return;
                case -2:
                    View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                    if (view4 != null) {
                        AgreeView agreeView = (AgreeView) view4;
                        PbFragment.this.u5(view4);
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
                        PbFragment.this.u5(view5);
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
                    if (PbFragment.this.e1 == null || TextUtils.isEmpty(PbFragment.this.f1)) {
                        return;
                    }
                    if (PbFragment.this.g1 == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbFragment.this.f1));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f49686a = PbFragment.this.f1;
                        String str = "";
                        if (PbFragment.this.g1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + PbFragment.this.g1.memeInfo.pck_id;
                        }
                        aVar.f49687b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                    PbFragment.this.e1 = null;
                    PbFragment.this.f1 = null;
                    return;
                case 2:
                    if (PbFragment.this.e1 == null || TextUtils.isEmpty(PbFragment.this.f1)) {
                        return;
                    }
                    if (PbFragment.this.P0 == null) {
                        PbFragment.this.P0 = new PermissionJudgePolicy();
                    }
                    PbFragment.this.P0.clearRequestPermissionList();
                    PbFragment.this.P0.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (PbFragment.this.P0.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (PbFragment.this.d1 == null) {
                        PbFragment pbFragment = PbFragment.this;
                        pbFragment.d1 = new d.b.i0.c2.k.e.u0(pbFragment.getPageContext());
                    }
                    PbFragment.this.d1.b(PbFragment.this.f1, PbFragment.this.e1.n());
                    PbFragment.this.e1 = null;
                    PbFragment.this.f1 = null;
                    return;
                case 3:
                    PbFragment pbFragment2 = PbFragment.this;
                    PostData postData = pbFragment2.l2;
                    if (postData != null) {
                        postData.f0(pbFragment2.getPageContext().getPageActivity());
                        PbFragment.this.l2 = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.l5(view);
                        if (PbFragment.this.m0.y0().L() == null || PbFragment.this.m0.y0().L().T() == null || PbFragment.this.m0.y0().L().T().getUserId() == null || PbFragment.this.o0 == null) {
                            return;
                        }
                        PbFragment pbFragment3 = PbFragment.this;
                        int J4 = pbFragment3.J4(pbFragment3.m0.y0());
                        d.b.h0.r.q.a2 L = PbFragment.this.m0.y0().L();
                        if (L.O1()) {
                            i2 = 2;
                        } else if (L.R1()) {
                            i2 = 3;
                        } else if (!L.P1()) {
                            i2 = L.Q1() ? 5 : 1;
                        }
                        TiebaStatic.log(new StatisticItem("c12526").param("tid", PbFragment.this.m0.f19731e).param("obj_locate", 2).param("obj_id", PbFragment.this.m0.y0().L().T().getUserId()).param("obj_type", !PbFragment.this.o0.e()).param("obj_source", J4).param("obj_param1", i2));
                        return;
                    }
                    return;
                case 5:
                    if (!d.b.b.e.p.j.z()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new StatisticItem("c13079"));
                        PbFragment.this.O4((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.T3(sparseArray2);
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
                        if (!((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue()) {
                            d.b.i0.c2.k.e.b1.a.d(PbFragment.this.getActivity(), PbFragment.this.getPageContext(), new a(sparseArray3, intValue, booleanValue), new b(this));
                            return;
                        } else {
                            PbFragment.this.t0.D1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                            return;
                        }
                    }
                    return;
                case 7:
                    if (!d.b.b.e.p.j.z()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 == null) {
                        return;
                    }
                    boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                    boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                    boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                    if (!booleanValue2) {
                        if (booleanValue3) {
                            PbFragment.this.t0.D1(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        }
                        return;
                    } else if (booleanValue4) {
                        sparseArray4.put(R.id.tag_from, 1);
                        sparseArray4.put(R.id.tag_check_mute_from, 2);
                        PbFragment.this.T3(sparseArray4);
                        return;
                    } else {
                        sparseArray4.put(R.id.tag_check_mute_from, 2);
                        PbFragment.this.t0.G1(view);
                        return;
                    }
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData2.q() == null) {
                            return;
                        }
                        PbFragment.this.W3(postData2.q());
                        return;
                    }
                    return;
                case 9:
                    if (!PbFragment.this.checkUpIsLogin() || PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null) {
                        return;
                    }
                    PbFragment.this.f19547e.showBlockDialog(d.b.i0.m3.a.b(view));
                    return;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h1 implements ShareSuccessReplyToServerModel.b {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f19585e;

            public a(CustomDialogData customDialogData) {
                this.f19585e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.i0.c2.j.c.a(PbFragment.this.getPageContext(), this.f19585e).show();
            }
        }

        public h1() {
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            d.b.b.e.m.e.a().postDelayed(new a(customDialogData), 1000L);
        }
    }

    /* loaded from: classes4.dex */
    public class h2 extends d.b.h0.z0.f0<ShareItem> {
        public h2() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.b.i0.c2.k.e.b1.b.c(PbFragment.this.getContext(), PbFragment.this.k4(), ShareSwitch.isOn() ? 1 : 6, PbFragment.this.m0);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.h0.r.q.i0)) {
                return;
            }
            d.b.h0.r.q.i0 i0Var = (d.b.h0.r.q.i0) customResponsedMessage.getData();
            b1.a aVar = new b1.a();
            int i = i0Var.f50809a;
            String str = i0Var.f50810b;
            aVar.f50719a = i0Var.f50812d;
            d.b.i0.c2.h.e y0 = PbFragment.this.m0.y0();
            if (y0 == null) {
                return;
            }
            if (PbFragment.this.m0.c0() != null && PbFragment.this.m0.c0().getUserIdLong() == i0Var.p) {
                PbFragment.this.t0.L1(i0Var.l, PbFragment.this.m0.y0(), PbFragment.this.m0.M0(), PbFragment.this.m0.I0());
            }
            if (y0.D() == null || y0.D().size() < 1 || y0.D().get(0) == null) {
                return;
            }
            long f2 = d.b.b.e.m.b.f(y0.D().get(0).D(), 0L);
            long f3 = d.b.b.e.m.b.f(PbFragment.this.m0.O0(), 0L);
            if (f2 == i0Var.n && f3 == i0Var.m) {
                d.b.h0.r.q.b1 C = y0.D().get(0).C();
                if (C == null) {
                    C = new d.b.h0.r.q.b1();
                }
                ArrayList<b1.a> a2 = C.a();
                if (a2 == null) {
                    a2 = new ArrayList<>();
                }
                a2.add(0, aVar);
                C.e(C.b() + i0Var.l);
                C.d(a2);
                y0.D().get(0).i0(C);
                PbFragment.this.t0.e0().U();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements c.d {
        public i0() {
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void a(boolean z, int i) {
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                if (PbFragment.this.N0 != null && PbFragment.this.N0.a() != null) {
                    PbFragment.this.N0.a().A(new d.b.h0.w.a(45, 27, null));
                }
                PbFragment.this.t0.N();
            }
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class i1 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f19591f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f19592g;

        public i1(MarkData markData, MarkData markData2, d.b.h0.r.s.a aVar) {
            this.f19590e = markData;
            this.f19591f = markData2;
            this.f19592g = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            if (PbFragment.this.o0 != null) {
                if (PbFragment.this.o0.e()) {
                    PbFragment.this.o0.d();
                    PbFragment.this.o0.h(false);
                }
                PbFragment.this.o0.i(this.f19590e);
                PbFragment.this.o0.h(true);
                PbFragment.this.o0.a();
            }
            this.f19591f.setPostId(this.f19590e.getPostId());
            Intent intent = new Intent();
            intent.putExtra("mark", this.f19591f);
            PbFragment.this.f19547e.setResult(-1, intent);
            this.f19592g.dismiss();
            PbFragment.this.d6();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
        }
    }

    /* loaded from: classes4.dex */
    public class i2 implements d.b.h0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19594a;

        public i2(int i) {
            this.f19594a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Bundle bundle = new Bundle();
            bundle.putInt("source", 2);
            shareItem.i(bundle);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(PbFragment.this.getContext(), this.f19594a, shareItem, false));
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null) {
                return;
            }
            PbFragment.this.m0.y0().a();
            PbFragment.this.m0.V0();
            if (PbFragment.this.t0.e0() != null) {
                PbFragment.this.t0.b1(PbFragment.this.m0.y0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements SortSwitchButton.f {
        public j0() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            PbFragment.this.t0.T();
            boolean z = false;
            if (d.b.b.e.p.j.z()) {
                if (PbFragment.this.m0 != null && !PbFragment.this.m0.isLoading) {
                    PbFragment.this.c6();
                    PbFragment.this.t0.u2();
                    z = true;
                    if (PbFragment.this.m0.y0() != null && PbFragment.this.m0.y0().f52425f != null && PbFragment.this.m0.y0().f52425f.size() > i) {
                        int intValue = PbFragment.this.m0.y0().f52425f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", PbFragment.this.m0.P0()).param("fid", PbFragment.this.m0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (PbFragment.this.m0.X1(intValue)) {
                            PbFragment.this.m = true;
                            PbFragment.this.t0.j2(true);
                        }
                    }
                }
                return z;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        public final int b(int i) {
            if (i == 2) {
                return 1;
            }
            if (i == 0) {
                return 2;
            }
            return i == 1 ? 3 : 0;
        }
    }

    /* loaded from: classes4.dex */
    public class j1 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19598e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f19599f;

        public j1(MarkData markData, d.b.h0.r.s.a aVar) {
            this.f19598e = markData;
            this.f19599f = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            Intent intent = new Intent();
            intent.putExtra("mark", this.f19598e);
            PbFragment.this.f19547e.setResult(-1, intent);
            this.f19599f.dismiss();
            PbFragment.this.d6();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
        }
    }

    /* loaded from: classes4.dex */
    public class j2 implements c0.b {
        public j2() {
        }

        @Override // d.b.i0.c2.k.e.c0.b
        public void a(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                return;
            }
            PbFragment.this.t0.Y2(str);
        }

        @Override // d.b.i0.c2.k.e.c0.b
        public void onSuccess(List<PostData> list) {
        }
    }

    /* loaded from: classes4.dex */
    public class k implements PbInterviewStatusView.f {
        public k() {
        }

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            PbFragment.this.t0.V2(!PbFragment.this.P);
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19603e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19604f;

        /* loaded from: classes4.dex */
        public class a implements TextWatcher {
            public a() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.b.i0.c2.k.e.s0 s0Var = PbFragment.this.x0;
                if (s0Var == null || s0Var.g() == null) {
                    return;
                }
                if (!PbFragment.this.x0.g().e()) {
                    PbFragment.this.x0.b(false);
                }
                PbFragment.this.x0.g().l(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        }

        public k0(String str, String str2) {
            this.f19603e = str;
            this.f19604f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int g2;
            int i2 = d.b.b.e.p.l.i(PbFragment.this.f19547e.getApplicationContext());
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                i = TbadkCoreApplication.getInst().getKeyboardHeight();
                g2 = d.b.b.e.p.l.g(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
            } else {
                i = i2 / 2;
                g2 = d.b.b.e.p.l.g(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
            }
            int i3 = i2 - (i + g2);
            PbFragment pbFragment = PbFragment.this;
            boolean z = true;
            pbFragment.G4().t0().smoothScrollBy((pbFragment.a0[1] + pbFragment.b0) - i3, 50);
            if (PbFragment.this.G4().B0() != null) {
                PbFragment.this.N0.a().setVisibility(8);
                PbFragment.this.G4().B0().n(this.f19603e, this.f19604f, PbFragment.this.G4().E0(), (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || PbFragment.this.m0.y0().L() == null || !PbFragment.this.m0.y0().L().S1()) ? false : false);
                d.b.h0.w.w.h b2 = PbFragment.this.G4().B0().b();
                if (b2 != null && PbFragment.this.m0 != null && PbFragment.this.m0.y0() != null) {
                    b2.E(PbFragment.this.m0.y0().d());
                    b2.X(PbFragment.this.m0.y0().L());
                }
                if (PbFragment.this.x0.f() == null && PbFragment.this.G4().B0().b().s() != null) {
                    PbFragment.this.G4().B0().b().s().g(new a());
                    PbFragment pbFragment2 = PbFragment.this;
                    pbFragment2.x0.n(pbFragment2.G4().B0().b().s().i());
                    PbFragment.this.G4().B0().b().K(PbFragment.this.W0);
                }
            }
            PbFragment.this.G4().O0();
        }
    }

    /* loaded from: classes4.dex */
    public class k1 implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19607e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f19608f;

        public k1(MarkData markData, d.b.h0.r.s.a aVar) {
            this.f19607e = markData;
            this.f19608f = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            int[] iArr = new int[2];
            if (PbFragment.this.t0 != null && PbFragment.this.t0.M0() != null) {
                PbFragment.this.t0.M0().getLocationOnScreen(iArr);
            }
            if (iArr[0] > 0) {
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19607e);
                PbFragment.this.f19547e.setResult(-1, intent);
                this.f19608f.dismiss();
                PbFragment.this.d6();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k2 extends CustomMessageListener {
        public k2(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.m0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (PbFragment.this.N0 != null) {
                PbFragment.this.t0.Z1(PbFragment.this.N0.C());
            }
            PbFragment.this.t0.S1();
            PbFragment.this.t0.T();
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public l(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            PbFragment.this.a4(str);
            PbFragment.this.m0.V0();
            if (!TextUtils.isEmpty(str) && PbFragment.this.m0.y0().D() != null) {
                ArrayList<PostData> D = PbFragment.this.m0.y0().D();
                d.b.i0.c3.h0.o oVar = null;
                Iterator<PostData> it = D.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof d.b.i0.c3.h0.o) {
                        d.b.i0.c3.h0.o oVar2 = (d.b.i0.c3.h0.o) next;
                        if (str.equals(oVar2.A0())) {
                            oVar = oVar2;
                            break;
                        }
                    }
                }
                if (oVar != null) {
                    D.remove(oVar);
                    if (PbFragment.this.t0.e0() != null && PbFragment.this.t0.e0().r() != null) {
                        PbFragment.this.t0.e0().r().remove(oVar);
                    }
                    if (PbFragment.this.t0.t0() != null && PbFragment.this.t0.t0().getData() != null) {
                        PbFragment.this.t0.t0().getData().remove(oVar);
                    }
                    if (PbFragment.this.t0.e0() != null) {
                        PbFragment.this.t0.e0().U();
                        return;
                    }
                }
            }
            if (PbFragment.this.t0.e0() != null) {
                PbFragment.this.t0.b1(PbFragment.this.m0.y0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f19612a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19613b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$l0$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0216a implements TextWatcher {
                public C0216a() {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    d.b.i0.c2.k.e.s0 s0Var = PbFragment.this.x0;
                    if (s0Var == null || s0Var.g() == null) {
                        return;
                    }
                    if (!PbFragment.this.x0.g().e()) {
                        PbFragment.this.x0.b(false);
                    }
                    PbFragment.this.x0.g().l(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int g2;
                int i2 = d.b.b.e.p.l.i(PbFragment.this.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                } else {
                    i = i2 / 2;
                    g2 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                }
                int i3 = i2 - (i + g2);
                PbFragment pbFragment = PbFragment.this;
                boolean z = true;
                pbFragment.G4().t0().smoothScrollBy((pbFragment.a0[1] + pbFragment.b0) - i3, 50);
                if (PbFragment.this.G4().B0() != null) {
                    PbFragment.this.N0.a().setVisibility(8);
                    z = (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || PbFragment.this.m0.y0().L() == null || !PbFragment.this.m0.y0().L().S1()) ? false : false;
                    d.b.i0.c2.k.e.s B0 = PbFragment.this.G4().B0();
                    l0 l0Var = l0.this;
                    B0.n(l0Var.f19612a, l0Var.f19613b, PbFragment.this.G4().E0(), z);
                    d.b.h0.w.w.h b2 = PbFragment.this.G4().B0().b();
                    if (b2 != null && PbFragment.this.m0 != null && PbFragment.this.m0.y0() != null) {
                        b2.E(PbFragment.this.m0.y0().d());
                        b2.X(PbFragment.this.m0.y0().L());
                    }
                    if (PbFragment.this.x0.f() == null && PbFragment.this.G4().B0().b().s() != null) {
                        PbFragment.this.G4().B0().b().s().g(new C0216a());
                        PbFragment pbFragment2 = PbFragment.this;
                        pbFragment2.x0.n(pbFragment2.G4().B0().b().s().i());
                        PbFragment.this.G4().B0().b().K(PbFragment.this.W0);
                    }
                }
                PbFragment.this.G4().O0();
            }
        }

        public l0(String str, String str2) {
            this.f19612a = str;
            this.f19613b = str2;
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void a(boolean z, int i) {
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                d.b.b.e.m.e.a().postDelayed(new a(), 0L);
            }
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class l1 implements d.b.b.e.k.c<ImageView> {
        public l1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setTag(null);
                if (d.b.h0.r.k.c().g()) {
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
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.c0();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
            boolean g2 = d.b.h0.r.k.c().g();
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
                foreDrawableImageView.c0();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                foreDrawableImageView.S();
            }
            return imageView;
        }
    }

    /* loaded from: classes4.dex */
    public interface l2 {
        boolean onBackPressed();
    }

    /* loaded from: classes4.dex */
    public class m implements SuggestEmotionModel.c {
        public m() {
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(d.b.i0.c2.k.e.y0.e.a aVar) {
            if (aVar == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.c()));
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class a implements l.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.r.s.j f19620e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ View f19621f;

            public a(d.b.h0.r.s.j jVar, View view) {
                this.f19620e = jVar;
                this.f19621f = view;
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
                if (r4.f19622g.f19619e.m0.L0() != 3) goto L5;
             */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
            /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
            @Override // d.b.h0.r.s.l.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(d.b.h0.r.s.l lVar, int i, View view) {
                boolean X1;
                this.f19620e.dismiss();
                int i2 = 3;
                if (PbFragment.this.m0.L0() != 1 || i != 1) {
                    if (PbFragment.this.m0.L0() == 2 && i == 0) {
                        i2 = 1;
                    } else if (PbFragment.this.m0.L0() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f19621f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i2));
                    if (PbFragment.this.m0.y0().f52425f != null && PbFragment.this.m0.y0().f52425f.size() > i) {
                        i = PbFragment.this.m0.y0().f52425f.get(i).sort_type.intValue();
                    }
                    X1 = PbFragment.this.m0.X1(i);
                    this.f19621f.setTag(Integer.valueOf(PbFragment.this.m0.K0()));
                    if (X1) {
                        return;
                    }
                    PbFragment.this.m = true;
                    PbFragment.this.t0.j2(true);
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f19621f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i2));
                if (PbFragment.this.m0.y0().f52425f != null) {
                    i = PbFragment.this.m0.y0().f52425f.get(i).sort_type.intValue();
                }
                X1 = PbFragment.this.m0.X1(i);
                this.f19621f.setTag(Integer.valueOf(PbFragment.this.m0.K0()));
                if (X1) {
                }
            }
        }

        public m0() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:841:0x1dd0, code lost:
            if (r36.f19619e.t0.N0.f52785c.a().getTop() <= ((r36.f19619e.t0.C0() == null || r36.f19619e.t0.C0().c() == null) ? 0 : r36.f19619e.t0.C0().c().getBottom())) goto L790;
         */
        /* JADX WARN: Code restructure failed: missing block: B:842:0x1dd2, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:844:0x1ddb, code lost:
            if (r0 >= r36.f19619e.l4()) goto L790;
         */
        /* JADX WARN: Code restructure failed: missing block: B:866:0x1e82, code lost:
            if ((r36.f19619e.t0.N0.f52785c.a().getTop() - r36.f19619e.t0.f52767g.f52649a.getBottom()) < (r36.f19619e.t0.N0.f52785c.f19769g.getHeight() + 10)) goto L790;
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
            d.b.h0.r.s.h hVar;
            d.b.h0.r.s.h hVar2;
            d.b.h0.r.s.h hVar3;
            PbFragment pbFragment;
            int i;
            boolean z;
            d.b.h0.r.s.h hVar4;
            d.b.h0.r.s.h hVar5;
            d.b.h0.r.s.h hVar6;
            String name;
            int i2;
            boolean z2;
            int fixedNavHeight;
            int i3;
            d.b.h0.r.q.f2 f2Var;
            String[] strArr;
            d.b.i0.c2.h.e y0;
            int i4;
            int i5;
            boolean W1;
            int i6;
            int i7;
            String name2;
            if (view == null || !PbFragment.this.isAdded()) {
                return;
            }
            if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                if (view == PbFragment.this.t0.x0()) {
                    if (PbFragment.this.m) {
                        return;
                    }
                    if (PbFragment.this.m0.h1(true)) {
                        PbFragment.this.m = true;
                        PbFragment.this.t0.v2();
                    }
                } else if (PbFragment.this.t0.f52767g.g() == null || view != PbFragment.this.t0.f52767g.g().l()) {
                    if (PbFragment.this.t0.f52767g.g() == null || view != PbFragment.this.t0.f52767g.g().d()) {
                        if (view == PbFragment.this.t0.f52767g.f52654f) {
                            if (PbFragment.this.t0.L(PbFragment.this.m0.m0())) {
                                PbFragment.this.c6();
                                return;
                            }
                            PbFragment.this.n = false;
                            PbFragment.this.j = false;
                            d.b.b.e.p.l.w(PbFragment.this.f19547e, PbFragment.this.t0.f52767g.f52654f);
                            PbFragment.this.f19547e.finish();
                        } else if (view != PbFragment.this.t0.g0() && (PbFragment.this.t0.f52767g.g() == null || (view != PbFragment.this.t0.f52767g.g().m() && view != PbFragment.this.t0.f52767g.g().n()))) {
                            if (view == PbFragment.this.t0.n0()) {
                                if (PbFragment.this.m0 != null) {
                                    d.b.h0.l.a.l(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.m0.y0().L().A1().b());
                                }
                            } else if (view != PbFragment.this.t0.f52767g.f52651c) {
                                if (view == PbFragment.this.t0.f52767g.f52652d) {
                                    if (d.b.h0.z0.l.a()) {
                                        return;
                                    }
                                    if (PbFragment.this.m0 != null && PbFragment.this.m0.y0() != null) {
                                        ArrayList<PostData> D = PbFragment.this.m0.y0().D();
                                        if ((D == null || D.size() <= 0) && PbFragment.this.m0.M0()) {
                                            d.b.b.e.p.l.L(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new StatisticItem("c12378").param("tid", PbFragment.this.m0.O0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", PbFragment.this.m0.getForumId()));
                                        if (!PbFragment.this.t0.n1()) {
                                            PbFragment.this.t0.S1();
                                        }
                                        PbFragment.this.q5();
                                    } else {
                                        d.b.b.e.p.l.L(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (d.b.b.e.p.j.z()) {
                                        PbFragment.this.t0.g2(true);
                                        PbFragment.this.t0.S1();
                                        if (PbFragment.this.m) {
                                            return;
                                        }
                                        PbFragment.this.m = true;
                                        PbFragment.this.t0.T2();
                                        PbFragment.this.c6();
                                        PbFragment.this.t0.u2();
                                        PbFragment.this.m0.V1(PbFragment.this.q4());
                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.t0.f52767g.g() == null || view != PbFragment.this.t0.f52767g.g().i()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.t0.f52767g.g() != null && view == PbFragment.this.t0.f52767g.g().e()) {
                                            PbFragment.this.t0.f52767g.e();
                                        } else if (view.getId() == R.id.share_num_container) {
                                            if (!PbFragment.this.S3(11009)) {
                                                return;
                                            }
                                            PbFragment.this.S4(3);
                                        } else if (view.getId() != R.id.pb_editor_tool_share) {
                                            if (PbFragment.this.t0.f52767g.g() == null || view != PbFragment.this.t0.f52767g.g().k()) {
                                                if (PbFragment.this.t0.f52767g.g() == null || view != PbFragment.this.t0.f52767g.g().s()) {
                                                    if (PbFragment.this.t0.f52767g.g() == null || view != PbFragment.this.t0.f52767g.g().r()) {
                                                        if (PbFragment.this.t0.f52767g.g() == null || view != PbFragment.this.t0.f52767g.g().o()) {
                                                            if (PbFragment.this.t0.q0() == view) {
                                                                if (PbFragment.this.t0.q0().getIndicateStatus()) {
                                                                    d.b.i0.c2.h.e y02 = PbFragment.this.m0.y0();
                                                                    if (y02 != null && y02.L() != null && y02.L().o1() != null) {
                                                                        String d2 = y02.L().o1().d();
                                                                        if (StringUtils.isNull(d2)) {
                                                                            d2 = y02.L().o1().f();
                                                                        }
                                                                        TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d2));
                                                                    }
                                                                } else {
                                                                    d.b.i0.c3.j0.a.d("c10725", null);
                                                                }
                                                                PbFragment.this.L4();
                                                            } else if (PbFragment.this.t0.f52767g.g() == null || view != PbFragment.this.t0.f52767g.g().h()) {
                                                                if (PbFragment.this.t0.f52767g.g() != null && view == PbFragment.this.t0.f52767g.g().f()) {
                                                                    if (d.b.b.e.p.j.z()) {
                                                                        SparseArray<Object> u0 = PbFragment.this.t0.u0(PbFragment.this.m0.y0(), PbFragment.this.m0.M0(), 1);
                                                                        if (u0 != null) {
                                                                            if (StringUtils.isNull((String) u0.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.t0.D1(((Integer) u0.get(R.id.tag_del_post_type)).intValue(), (String) u0.get(R.id.tag_del_post_id), ((Integer) u0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) u0.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.t0.E1(((Integer) u0.get(R.id.tag_del_post_type)).intValue(), (String) u0.get(R.id.tag_del_post_id), ((Integer) u0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) u0.get(R.id.tag_del_post_is_self)).booleanValue(), (String) u0.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.t0.f52767g.e();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.m0 == null) {
                                                                            return;
                                                                        }
                                                                        StatisticItem statisticItem2 = new StatisticItem("c13398");
                                                                        statisticItem2.param("tid", PbFragment.this.m0.O0());
                                                                        statisticItem2.param("fid", PbFragment.this.m0.getForumId());
                                                                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        statisticItem2.param("obj_locate", 5);
                                                                        TiebaStatic.log(statisticItem2);
                                                                        if (view.getId() == R.id.pb_post_reply_count && !DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
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
                                                                            if (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null) {
                                                                                return;
                                                                            }
                                                                            String O0 = PbFragment.this.m0.O0();
                                                                            String D2 = postData.D();
                                                                            int R = PbFragment.this.m0.y0() != null ? PbFragment.this.m0.y0().R() : 0;
                                                                            PbActivity.e t5 = PbFragment.this.t5(D2);
                                                                            if (t5 == null) {
                                                                                return;
                                                                            }
                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(O0, D2, "pb", true, null, false, null, R, postData.N(), PbFragment.this.m0.y0().d(), false, postData.s().getIconInfo()).addBigImageData(t5.f19507a, t5.f19508b, t5.f19513g, t5.j);
                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.m0.x0());
                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.m0.getFromForumId());
                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.m0.getForumId());
                                                                            addBigImageData.setBjhData(PbFragment.this.m0.T());
                                                                            if (PbFragment.this.m0.y0().o() != null) {
                                                                                addBigImageData.setHasForumRule(PbFragment.this.m0.y0().o().has_forum_rule.intValue());
                                                                            }
                                                                            if (PbFragment.this.m0.y0().Q() != null) {
                                                                                addBigImageData.setIsManager(PbFragment.this.m0.y0().Q().getIs_manager());
                                                                            }
                                                                            if (PbFragment.this.m0.y0().l().getDeletedReasonInfo() != null) {
                                                                                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.m0.y0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.m0.y0().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                            }
                                                                            if (PbFragment.this.m0.y0().l() != null) {
                                                                                addBigImageData.setForumHeadUrl(PbFragment.this.m0.y0().l().getImage_url());
                                                                                addBigImageData.setUserLevel(PbFragment.this.m0.y0().l().getUser_level());
                                                                            }
                                                                            if (PbFragment.this.t0 != null) {
                                                                                addBigImageData.setMainPostMaskVisibly(PbFragment.this.t0.l0(PbFragment.this.m0.I, PbFragment.this.m0.M0()).S || postData.S);
                                                                            }
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                        if (PbFragment.this.m0 == null) {
                                                                            return;
                                                                        }
                                                                        if (view.getId() == R.id.pb_post_reply) {
                                                                            StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                                            statisticItem4.param("tid", PbFragment.this.m0.O0());
                                                                            statisticItem4.param("fid", PbFragment.this.m0.getForumId());
                                                                            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            statisticItem4.param("obj_locate", 6);
                                                                            TiebaStatic.log(statisticItem4);
                                                                        }
                                                                        if (view.getId() == R.id.post_info_commont_img) {
                                                                            if (!DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                PbFragment.this.W = view;
                                                                                return;
                                                                            }
                                                                        } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
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
                                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", PbFragment.this.m0.P0()).param("fid", PbFragment.this.m0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.D()).param("obj_source", 1).param("obj_type", 3));
                                                                        }
                                                                        if (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || PbFragment.this.G4().A0() == null || postData2.s() == null || postData2.z() == 1) {
                                                                            return;
                                                                        }
                                                                        if (PbFragment.this.G4().B0() != null) {
                                                                            PbFragment.this.G4().B0().c();
                                                                        }
                                                                        if (PbFragment.this.j0 && postData2.L() != null && postData2.L().size() != 0) {
                                                                            PbFragment.this.b6(postData2, true);
                                                                        } else {
                                                                            d.b.i0.c2.h.q qVar = new d.b.i0.c2.h.q();
                                                                            qVar.A(PbFragment.this.m0.y0().l());
                                                                            qVar.E(PbFragment.this.m0.y0().L());
                                                                            qVar.C(postData2);
                                                                            PbFragment.this.G4().A0().E(qVar);
                                                                            PbFragment.this.G4().A0().setPostId(postData2.D());
                                                                            PbFragment.this.i5(view, postData2.s().getUserId(), "", postData2);
                                                                            if (PbFragment.this.N0 != null) {
                                                                                PbFragment.this.t0.Z1(PbFragment.this.N0.C());
                                                                            }
                                                                        }
                                                                    } else if (view.getId() != R.id.pb_floor_feedback) {
                                                                        if (view != PbFragment.this.t0.p0()) {
                                                                            if (view == PbFragment.this.t0.f52767g.h()) {
                                                                                PbFragment.this.t0.D2();
                                                                            } else if (PbFragment.this.t0.f52767g.g() != null && view == PbFragment.this.t0.f52767g.g().q()) {
                                                                                PbFragment.this.t0.f52767g.f();
                                                                                PbFragment.this.t0.R2(PbFragment.this.o2);
                                                                            } else {
                                                                                int id = view.getId();
                                                                                if (id == R.id.pb_u9_text_view) {
                                                                                    if (!PbFragment.this.checkUpIsLogin() || (f2Var = (d.b.h0.r.q.f2) view.getTag()) == null || StringUtils.isNull(f2Var.A0())) {
                                                                                        return;
                                                                                    }
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                    UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{f2Var.A0()});
                                                                                } else if (id != R.id.replybtn && id != R.id.cover_reply_content && id != R.id.replybtn_top_right && id != R.id.cover_reply_content_top_right) {
                                                                                    if (id == R.id.pb_act_btn) {
                                                                                        if (PbFragment.this.m0.y0() != null && PbFragment.this.m0.y0().L() != null && PbFragment.this.m0.y0().L().H() != null) {
                                                                                            d.b.h0.l.a.l(PbFragment.this.getActivity(), PbFragment.this.m0.y0().L().H());
                                                                                            if (PbFragment.this.m0.y0().L().G() != 1) {
                                                                                                if (PbFragment.this.m0.y0().L().G() == 2) {
                                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                }
                                                                                            } else {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.lottery_tail) {
                                                                                        if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                            String str = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                            TiebaStatic.log(new StatisticItem("c10912").param("fid", PbFragment.this.m0.y0().m()).param("tid", PbFragment.this.m0.y0().N()).param("lotterytail", StringUtils.string(str, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                            if (PbFragment.this.m0.y0().N().equals(str)) {
                                                                                                PbFragment.this.t0.y2(0);
                                                                                            } else {
                                                                                                PbFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str, (String) null, (String) null, (String) null)));
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.pb_item_tail_content) {
                                                                                        if (ViewHelper.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                            String o = d.b.h0.r.d0.b.i().o("tail_link", "");
                                                                                            if (!StringUtils.isNull(o)) {
                                                                                                TiebaStatic.log("c10056");
                                                                                                d.b.h0.l.a.o(view.getContext(), string, o, true, true, true);
                                                                                            }
                                                                                            PbFragment.this.t0.S1();
                                                                                        }
                                                                                    } else if (id == R.id.join_vote_tv) {
                                                                                        if (view != null) {
                                                                                            d.b.h0.l.a.l(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                            if (PbFragment.this.k4() == 1 && PbFragment.this.m0 != null && PbFragment.this.m0.y0() != null) {
                                                                                                TiebaStatic.log(new StatisticItem("c10397").param("fid", PbFragment.this.m0.y0().m()).param("tid", PbFragment.this.m0.y0().N()).param("uid", currentAccount));
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.look_all_tv) {
                                                                                        if (view != null) {
                                                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                            d.b.h0.l.a.l(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                            if (PbFragment.this.k4() == 1 && PbFragment.this.m0 != null && PbFragment.this.m0.y0() != null) {
                                                                                                TiebaStatic.log(new StatisticItem("c10507").param("fid", PbFragment.this.m0.y0().m()).param("tid", PbFragment.this.m0.y0().N()).param("uid", currentAccount2));
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.manga_prev_btn) {
                                                                                        PbFragment.this.h5();
                                                                                    } else if (id == R.id.manga_next_btn) {
                                                                                        PbFragment.this.e5();
                                                                                    } else if (id == R.id.yule_head_img_img) {
                                                                                        if (PbFragment.this.m0 != null && PbFragment.this.m0.y0() != null && PbFragment.this.m0.y0().y() != null) {
                                                                                            d.b.i0.c2.h.e y03 = PbFragment.this.m0.y0();
                                                                                            TiebaStatic.log(new StatisticItem("c11679").param("fid", y03.m()));
                                                                                            UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{y03.y().b()});
                                                                                        }
                                                                                    } else if (id == R.id.yule_head_img_all_rank) {
                                                                                        if (PbFragment.this.m0 != null && PbFragment.this.m0.y0() != null && PbFragment.this.m0.y0().y() != null) {
                                                                                            d.b.i0.c2.h.e y04 = PbFragment.this.m0.y0();
                                                                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", y04.m()));
                                                                                            UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{y04.y().b()});
                                                                                        }
                                                                                    } else if (id == R.id.tv_pb_reply_more) {
                                                                                        if (PbFragment.this.i1 >= 0) {
                                                                                            if (PbFragment.this.m0 != null) {
                                                                                                PbFragment.this.m0.D1();
                                                                                            }
                                                                                            if (PbFragment.this.m0 == null || PbFragment.this.t0.e0() == null) {
                                                                                                i3 = 0;
                                                                                            } else {
                                                                                                i3 = 0;
                                                                                                PbFragment.this.t0.e0().Z(PbFragment.this.m0.y0(), false);
                                                                                            }
                                                                                            PbFragment.this.i1 = i3;
                                                                                            if (PbFragment.this.m0 != null) {
                                                                                                PbFragment.this.t0.t0().setSelection(PbFragment.this.m0.r0());
                                                                                                PbFragment.this.m0.H1(0, 0);
                                                                                            }
                                                                                        }
                                                                                    } else if (id == R.id.pb_post_recommend_live_layout) {
                                                                                        if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                            TiebaStatic.log("c12640");
                                                                                        }
                                                                                    } else if (id == R.id.qq_share_container) {
                                                                                        if (!PbFragment.this.S3(11009)) {
                                                                                            return;
                                                                                        }
                                                                                        PbFragment.this.S4(8);
                                                                                    } else if (id == R.id.new_sub_pb_list_richText) {
                                                                                        SparseArray sparseArray4 = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                                                                                        if (sparseArray4 == null) {
                                                                                            return;
                                                                                        }
                                                                                        PbFragment.this.a6(sparseArray4);
                                                                                    } else if (id == R.id.pb_editor_tool_comment_icon) {
                                                                                        if (PbFragment.this.t0.t0() == null || PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null) {
                                                                                            return;
                                                                                        }
                                                                                        int firstVisiblePosition = PbFragment.this.t0.t0().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.t0.t0().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean e0 = PbFragment.this.m0.y0().e0();
                                                                                        boolean z3 = PbFragment.this.t0.C0() != null && PbFragment.this.t0.C0().g();
                                                                                        boolean l1 = PbFragment.this.t0.l1();
                                                                                        boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                        if (!e0 || PbFragment.this.t0.C0() == null || PbFragment.this.t0.C0().c() == null) {
                                                                                            i2 = 0;
                                                                                        } else {
                                                                                            int k = ((int) (d.b.b.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.t0.C0().e();
                                                                                            i2 = k;
                                                                                            z4 = firstVisiblePosition == 0 && (top == k || top == PbFragment.this.t0.C0().c().getHeight() - PbFragment.this.t0.C0().e());
                                                                                        }
                                                                                        PbFragment.this.g4(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                        if ((PbFragment.this.m0.y0().L() != null && PbFragment.this.m0.y0().L().Z0() <= 0) || (l1 && z4)) {
                                                                                            if (!PbFragment.this.checkUpIsLogin()) {
                                                                                                return;
                                                                                            }
                                                                                            PbFragment.this.s5();
                                                                                            if (PbFragment.this.m0.y0().L().T() != null) {
                                                                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.m0.f19731e).param("fid", PbFragment.this.m0.y0().m()).param("obj_locate", 2).param("uid", PbFragment.this.m0.y0().L().T().getUserId()));
                                                                                            }
                                                                                        } else {
                                                                                            int i8 = (int) (d.b.b.e.p.l.i(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (e0) {
                                                                                                if (PbFragment.this.t0.N0 != null && PbFragment.this.t0.N0.f52785c != null && PbFragment.this.t0.N0.f52785c.a() != null) {
                                                                                                    if (PbFragment.this.t0.N0.f52785c.a().getParent() != null) {
                                                                                                    }
                                                                                                }
                                                                                                z2 = false;
                                                                                            } else {
                                                                                                if (PbFragment.this.t0.z0() != null) {
                                                                                                    z2 = PbFragment.this.t0.z0().getVisibility() == 0;
                                                                                                    if (!z2 && PbFragment.this.t0.N0 != null && PbFragment.this.t0.N0.f52785c != null && PbFragment.this.t0.N0.f52785c.a() != null && PbFragment.this.t0.N0.f52785c.a().getParent() != null && PbFragment.this.t0.f52767g != null && PbFragment.this.t0.f52767g.f52649a != null) {
                                                                                                    }
                                                                                                }
                                                                                                z2 = false;
                                                                                            }
                                                                                            if (z2 || l1) {
                                                                                                PbFragment.this.c0 = firstVisiblePosition;
                                                                                                PbFragment.this.d0 = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i8))) {
                                                                                                    PbFragment.this.t0.t0().setSelectionFromTop(0, i2 - i8);
                                                                                                    PbFragment.this.t0.t0().smoothScrollBy(-i8, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.t0.t0().E(0, i2, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.c0 > 0) {
                                                                                                if (PbFragment.this.t0.t0().getChildAt(PbFragment.this.c0) != null) {
                                                                                                    PbFragment.this.t0.t0().E(PbFragment.this.c0, PbFragment.this.d0, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.t0.t0().setSelectionFromTop(PbFragment.this.c0, PbFragment.this.d0 + i8);
                                                                                                    PbFragment.this.t0.t0().smoothScrollBy(i8, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int l4 = PbFragment.this.l4();
                                                                                                if (PbFragment.this.o4() != -1) {
                                                                                                    l4--;
                                                                                                }
                                                                                                int g2 = d.b.b.e.p.l.g(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (l4 < 0) {
                                                                                                    l4 = (ListUtils.getCount(PbFragment.this.t0.t0().getData()) - 1) + PbFragment.this.t0.t0().getHeaderViewsCount();
                                                                                                    g2 = 0;
                                                                                                }
                                                                                                if (!z3) {
                                                                                                    if (!e0 || PbFragment.this.t0.C0() == null) {
                                                                                                        if (PbFragment.this.t0.f52767g != null && PbFragment.this.t0.f52767g.f52649a != null) {
                                                                                                            fixedNavHeight = PbFragment.this.t0.f52767g.f52649a.getFixedNavHeight() - 10;
                                                                                                        }
                                                                                                        if (PbFragment.this.t0.N0 != null || PbFragment.this.t0.N0.f52785c == null || PbFragment.this.t0.N0.f52785c.a() == null || PbFragment.this.t0.N0.f52785c.a().getParent() == null) {
                                                                                                            PbFragment.this.t0.t0().setSelectionFromTop(l4, g2 + i8);
                                                                                                            PbFragment.this.t0.t0().smoothScrollBy(i8, 500);
                                                                                                        } else if (!z3) {
                                                                                                            PbFragment.this.t0.t0().E(l4, g2, 200);
                                                                                                        } else {
                                                                                                            PbFragment.this.t0.t0().smoothScrollBy(PbFragment.this.t0.N0.f52785c.a().getTop() - ((int) (d.b.b.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                        }
                                                                                                    } else {
                                                                                                        fixedNavHeight = PbFragment.this.t0.C0().d();
                                                                                                    }
                                                                                                } else {
                                                                                                    fixedNavHeight = (int) (d.b.b.e.p.l.k(PbFragment.this.getContext()) * 0.5625d);
                                                                                                }
                                                                                                g2 += fixedNavHeight;
                                                                                                if (PbFragment.this.t0.N0 != null) {
                                                                                                }
                                                                                                PbFragment.this.t0.t0().setSelectionFromTop(l4, g2 + i8);
                                                                                                PbFragment.this.t0.t0().smoothScrollBy(i8, 500);
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.m0.y0().L() != null && PbFragment.this.m0.y0().L().T() != null) {
                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.m0.f19731e).param("fid", PbFragment.this.m0.y0().m()).param("obj_locate", 2).param("uid", PbFragment.this.m0.y0().L().T().getUserId()));
                                                                                        }
                                                                                    } else if (id == R.id.pb_nav_title_forum_image || id == R.id.pb_nav_title_forum_name) {
                                                                                        if (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || PbFragment.this.m0.y0().l() == null || d.b.b.e.p.k.isEmpty(PbFragment.this.m0.y0().l().getName())) {
                                                                                            return;
                                                                                        }
                                                                                        if (PbFragment.this.m0.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.m0.a0()) || PbFragment.this.m0.Q() == null) {
                                                                                                PbFragment.this.f19547e.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.m0.Q().f52415b;
                                                                                        } else {
                                                                                            name = PbFragment.this.m0.y0().l().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.f19547e.finish();
                                                                                            return;
                                                                                        }
                                                                                        String a0 = PbFragment.this.m0.a0();
                                                                                        if (PbFragment.this.m0.e0() && a0 != null && a0.equals(name)) {
                                                                                            PbFragment.this.f19547e.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.m0.y0().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13401");
                                                                                        statisticItem5.param("tid", PbFragment.this.m0.O0());
                                                                                        statisticItem5.param("fid", PbFragment.this.m0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.m0.y0().L() != null) {
                                                                                            statisticItem5.param("nid", PbFragment.this.m0.y0().L().L0());
                                                                                        }
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    } else if (id != R.id.forum_name_text && id != R.id.forum_enter_button_one && id != R.id.forum_enter_button_two && id != R.id.forum_enter_button_three) {
                                                                                        if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                            if (PbFragment.this.m0 == null) {
                                                                                                return;
                                                                                            }
                                                                                            StatisticItem statisticItem6 = new StatisticItem("c13398");
                                                                                            statisticItem6.param("tid", PbFragment.this.m0.O0());
                                                                                            statisticItem6.param("fid", PbFragment.this.m0.getForumId());
                                                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                            statisticItem6.param("obj_locate", 2);
                                                                                            TiebaStatic.log(statisticItem6);
                                                                                        } else if (id == R.id.pb_thread_post_button) {
                                                                                            if (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null) {
                                                                                                return;
                                                                                            }
                                                                                            d.b.i0.c2.h.e y05 = PbFragment.this.m0.y0();
                                                                                            if (PbFragment.this.r0 == null) {
                                                                                                PbFragment pbFragment2 = PbFragment.this;
                                                                                                pbFragment2.r0 = new d.b.i0.c2.h.r(pbFragment2.getPageContext());
                                                                                            }
                                                                                            long f2 = d.b.b.e.m.b.f(y05.N(), 0L);
                                                                                            long f3 = d.b.b.e.m.b.f(y05.m(), 0L);
                                                                                            new StatisticItem("c13446").param("forum_id", f3).eventStat();
                                                                                            PbFragment pbFragment3 = PbFragment.this;
                                                                                            pbFragment3.registerListener(pbFragment3.X1);
                                                                                            PbFragment.this.r0.a(f2, f3);
                                                                                        } else if (id == R.id.pb_video_thread_smart_app_layout) {
                                                                                            if (view.getTag() instanceof SmartApp) {
                                                                                                SmartApp smartApp = (SmartApp) view.getTag();
                                                                                                if (!d.b.i0.s.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                    if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    d.b.h0.l.a.l(PbFragment.this.getActivity(), smartApp.h5_url);
                                                                                                }
                                                                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", PbFragment.this.m0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", PbFragment.this.m0.O0()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                            }
                                                                                        } else if (id == R.id.id_pb_business_promotion_wrapper) {
                                                                                            if (!(view.getTag() instanceof d.b.h0.r.q.a2)) {
                                                                                                return;
                                                                                            }
                                                                                            d.b.h0.r.q.a2 a2Var = (d.b.h0.r.q.a2) view.getTag();
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(a2Var.i0(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", a2Var.c0()).param("tid", a2Var.o0()).param("thread_type", a2Var.s1()).param(TiebaStatic.Params.IS_ZP, a2Var.C2() ? 1 : 0));
                                                                                        } else if (id == R.id.id_pb_business_promotion_attention) {
                                                                                            if (!(view.getTag() instanceof d.b.h0.r.q.a2) || !PbFragment.this.checkUpIsLogin()) {
                                                                                                return;
                                                                                            }
                                                                                            d.b.h0.r.q.a2 a2Var2 = (d.b.h0.r.q.a2) view.getTag();
                                                                                            if (PbFragment.this.T != null) {
                                                                                                PbFragment.this.T.H(a2Var2.i0(), String.valueOf(a2Var2.c0()));
                                                                                            }
                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", a2Var2.c0()).param("tid", a2Var2.o0()).param("thread_type", a2Var2.s1()).param(TiebaStatic.Params.IS_ZP, a2Var2.C2() ? 1 : 0));
                                                                                        } else if (id == R.id.pb_floor_right_top_feedback || id == R.id.pb_post_op_more) {
                                                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                            statisticItem7.param("tid", PbFragment.this.m0.O0());
                                                                                            statisticItem7.param("fid", PbFragment.this.m0.getForumId());
                                                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                            statisticItem7.param("obj_locate", 7);
                                                                                            TiebaStatic.log(statisticItem7);
                                                                                            PbFragment pbFragment4 = PbFragment.this;
                                                                                            pbFragment4.f19548f = false;
                                                                                            pbFragment4.Y3(view);
                                                                                        }
                                                                                    } else if (!(view.getTag() instanceof d.b.h0.r.q.a2)) {
                                                                                        return;
                                                                                    } else {
                                                                                        d.b.h0.r.q.a2 a2Var3 = (d.b.h0.r.q.a2) view.getTag();
                                                                                        if (PbFragment.this.m0.x0() == 3 && PbFragment.this.isSimpleForum() && PbFragment.this.m0.y0() != null && ListUtils.isEmpty(PbFragment.this.m0.y0().p())) {
                                                                                            PbFragment.this.f19547e.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(a2Var3.i0(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg2.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                        }
                                                                                        StatisticItem statisticItem8 = new StatisticItem("c13399");
                                                                                        statisticItem8.param("tid", a2Var3.o0());
                                                                                        statisticItem8.param("fid", a2Var3.c0());
                                                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem8.param("nid", a2Var3.L0());
                                                                                        TiebaStatic.log(statisticItem8);
                                                                                    }
                                                                                } else {
                                                                                    d.b.h0.r.s.h hVar7 = null;
                                                                                    if (!PbFragment.this.checkUpIsLogin()) {
                                                                                        return;
                                                                                    }
                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                    if (view != null && view.getTag() != null) {
                                                                                        SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                        PostData postData3 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                        if (id == R.id.replybtn_top_right || id == R.id.cover_reply_content_top_right) {
                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", PbFragment.this.m0.f19731e));
                                                                                        }
                                                                                        if (PbFragment.this.z0 == null) {
                                                                                            PbFragment pbFragment5 = PbFragment.this;
                                                                                            pbFragment5.z0 = new d.b.h0.r.s.l(pbFragment5.getContext());
                                                                                            PbFragment.this.z0.n(PbFragment.this.R1);
                                                                                        }
                                                                                        ArrayList arrayList = new ArrayList();
                                                                                        PbFragment.this.Z4(view);
                                                                                        if (PbFragment.this.Z4(view) && PbFragment.this.e1 != null) {
                                                                                            PbFragment.this.e1.t();
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
                                                                                            if (postData3.J() != null && postData3.J().toString().length() > 0) {
                                                                                                d.b.h0.r.s.h hVar8 = new d.b.h0.r.s.h(3, PbFragment.this.getString(R.string.copy), PbFragment.this.z0);
                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                sparseArray6.put(R.id.tag_clip_board, postData3);
                                                                                                hVar8.f51005d.setTag(sparseArray6);
                                                                                                arrayList.add(hVar8);
                                                                                            }
                                                                                            PbFragment.this.l2 = postData3;
                                                                                        }
                                                                                        if (PbFragment.this.m0.y0().r()) {
                                                                                            String t = PbFragment.this.m0.y0().t();
                                                                                            if (postData3 != null && !d.b.b.e.p.k.isEmpty(t) && t.equals(postData3.D())) {
                                                                                                z = true;
                                                                                                if (!z) {
                                                                                                    hVar4 = new d.b.h0.r.s.h(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.z0);
                                                                                                } else {
                                                                                                    hVar4 = new d.b.h0.r.s.h(4, PbFragment.this.getString(R.string.mark), PbFragment.this.z0);
                                                                                                }
                                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                                sparseArray7.put(R.id.tag_clip_board, PbFragment.this.l2);
                                                                                                sparseArray7.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                                hVar4.f51005d.setTag(sparseArray7);
                                                                                                arrayList.add(hVar4);
                                                                                                if (PbFragment.this.mIsLogin) {
                                                                                                    if (d.b.i0.c2.k.e.b1.a.h(PbFragment.this.m0) || booleanValue3 || !booleanValue2) {
                                                                                                        if (PbFragment.this.c5(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                            d.b.h0.r.s.h hVar9 = new d.b.h0.r.s.h(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.z0);
                                                                                                            hVar9.f51005d.setTag(str2);
                                                                                                            arrayList.add(hVar9);
                                                                                                        }
                                                                                                    } else {
                                                                                                        d.b.h0.r.s.h hVar10 = new d.b.h0.r.s.h(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.z0);
                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                        sparseArray8.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                                        int i9 = R.id.tag_is_mem;
                                                                                                        sparseArray8.put(i9, sparseArray5.get(i9));
                                                                                                        int i10 = R.id.tag_user_mute_mute_userid;
                                                                                                        sparseArray8.put(i10, sparseArray5.get(i10));
                                                                                                        int i11 = R.id.tag_user_mute_mute_username;
                                                                                                        sparseArray8.put(i11, sparseArray5.get(i11));
                                                                                                        int i12 = R.id.tag_user_mute_mute_nameshow;
                                                                                                        sparseArray8.put(i12, sparseArray5.get(i12));
                                                                                                        int i13 = R.id.tag_user_mute_post_id;
                                                                                                        sparseArray8.put(i13, sparseArray5.get(i13));
                                                                                                        int i14 = R.id.tag_user_mute_thread_id;
                                                                                                        sparseArray8.put(i14, sparseArray5.get(i14));
                                                                                                        int i15 = R.id.tag_del_post_is_self;
                                                                                                        sparseArray8.put(i15, sparseArray5.get(i15));
                                                                                                        int i16 = R.id.tag_del_post_type;
                                                                                                        sparseArray8.put(i16, sparseArray5.get(i16));
                                                                                                        int i17 = R.id.tag_del_post_id;
                                                                                                        sparseArray8.put(i17, sparseArray5.get(i17));
                                                                                                        int i18 = R.id.tag_manage_user_identity;
                                                                                                        sparseArray8.put(i18, sparseArray5.get(i18));
                                                                                                        hVar4.f51005d.setTag(sparseArray8);
                                                                                                        arrayList.add(hVar10);
                                                                                                    }
                                                                                                    if (booleanValue3) {
                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                        sparseArray9.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                                                                                                        int i19 = R.id.tag_manage_user_identity;
                                                                                                        sparseArray9.put(i19, sparseArray5.get(i19));
                                                                                                        int i20 = R.id.tag_forbid_user_name;
                                                                                                        sparseArray9.put(i20, sparseArray5.get(i20));
                                                                                                        int i21 = R.id.tag_forbid_user_name_show;
                                                                                                        sparseArray9.put(i21, sparseArray5.get(i21));
                                                                                                        int i22 = R.id.tag_forbid_user_portrait;
                                                                                                        sparseArray9.put(i22, sparseArray5.get(i22));
                                                                                                        sparseArray9.put(R.id.tag_forbid_user_post_id, str2);
                                                                                                        if (booleanValue4) {
                                                                                                            sparseArray9.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                                            int i23 = R.id.tag_is_mem;
                                                                                                            sparseArray9.put(i23, sparseArray5.get(i23));
                                                                                                            int i24 = R.id.tag_user_mute_mute_userid;
                                                                                                            sparseArray9.put(i24, sparseArray5.get(i24));
                                                                                                            int i25 = R.id.tag_user_mute_mute_username;
                                                                                                            sparseArray9.put(i25, sparseArray5.get(i25));
                                                                                                            int i26 = R.id.tag_user_mute_mute_nameshow;
                                                                                                            sparseArray9.put(i26, sparseArray5.get(i26));
                                                                                                            int i27 = R.id.tag_user_mute_post_id;
                                                                                                            sparseArray9.put(i27, sparseArray5.get(i27));
                                                                                                            int i28 = R.id.tag_user_mute_thread_id;
                                                                                                            sparseArray9.put(i28, sparseArray5.get(i28));
                                                                                                        } else {
                                                                                                            sparseArray9.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                                        }
                                                                                                        if (booleanValue5) {
                                                                                                            sparseArray9.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                                            sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                                                            int i29 = R.id.tag_del_post_id;
                                                                                                            sparseArray9.put(i29, sparseArray5.get(i29));
                                                                                                            int i30 = R.id.tag_del_post_type;
                                                                                                            sparseArray9.put(i30, sparseArray5.get(i30));
                                                                                                            int i31 = R.id.tag_has_sub_post;
                                                                                                            sparseArray9.put(i31, sparseArray5.get(i31));
                                                                                                            hVar7 = new d.b.h0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.z0);
                                                                                                            hVar7.f51005d.setTag(sparseArray9);
                                                                                                        } else {
                                                                                                            sparseArray9.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                                        }
                                                                                                        hVar5 = new d.b.h0.r.s.h(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.z0);
                                                                                                        hVar5.f51005d.setTag(sparseArray9);
                                                                                                    } else if (booleanValue5) {
                                                                                                        SparseArray sparseArray10 = new SparseArray();
                                                                                                        sparseArray10.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                                                                                                        sparseArray10.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                                        sparseArray10.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                                        int i32 = R.id.tag_manage_user_identity;
                                                                                                        sparseArray10.put(i32, sparseArray5.get(i32));
                                                                                                        sparseArray10.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                                                        int i33 = R.id.tag_del_post_id;
                                                                                                        sparseArray10.put(i33, sparseArray5.get(i33));
                                                                                                        int i34 = R.id.tag_del_post_type;
                                                                                                        sparseArray10.put(i34, sparseArray5.get(i34));
                                                                                                        int i35 = R.id.tag_has_sub_post;
                                                                                                        sparseArray10.put(i35, sparseArray5.get(i35));
                                                                                                        if (PbFragment.this.m0.y0().R() == 1002 && !booleanValue) {
                                                                                                            hVar6 = new d.b.h0.r.s.h(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.z0);
                                                                                                        } else {
                                                                                                            hVar6 = new d.b.h0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.z0);
                                                                                                        }
                                                                                                        hVar6.f51005d.setTag(sparseArray10);
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
                                                                                                PbFragment.this.z0.k(arrayList);
                                                                                                PbFragment.this.y0 = new d.b.h0.r.s.j(PbFragment.this.getPageContext(), PbFragment.this.z0);
                                                                                                PbFragment.this.y0.l();
                                                                                            }
                                                                                        }
                                                                                        z = false;
                                                                                        if (!z) {
                                                                                        }
                                                                                        SparseArray sparseArray72 = new SparseArray();
                                                                                        sparseArray72.put(R.id.tag_clip_board, PbFragment.this.l2);
                                                                                        sparseArray72.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                        hVar4.f51005d.setTag(sparseArray72);
                                                                                        arrayList.add(hVar4);
                                                                                        if (PbFragment.this.mIsLogin) {
                                                                                        }
                                                                                        PbFragment.this.z0.k(arrayList);
                                                                                        PbFragment.this.y0 = new d.b.h0.r.s.j(PbFragment.this.getPageContext(), PbFragment.this.z0);
                                                                                        PbFragment.this.y0.l();
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), 24008, d.b.b.e.m.b.f(PbFragment.this.m0.y0().m(), 0L), d.b.b.e.m.b.f(PbFragment.this.m0.O0(), 0L), d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.m0.y0().L().S0())));
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
                                                                        if (PbFragment.this.z0 == null) {
                                                                            PbFragment pbFragment6 = PbFragment.this;
                                                                            pbFragment6.z0 = new d.b.h0.r.s.l(pbFragment6.getContext());
                                                                            PbFragment.this.z0.n(PbFragment.this.R1);
                                                                        }
                                                                        ArrayList arrayList2 = new ArrayList();
                                                                        boolean z5 = PbFragment.this.L().y0() != null && PbFragment.this.L().y0().Z();
                                                                        if (view != null && sparseArray != null) {
                                                                            boolean booleanValue6 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                            boolean booleanValue7 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                            boolean booleanValue8 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                            boolean booleanValue9 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                            boolean booleanValue10 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                            String str3 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                                                                            if (postData4.q() != null) {
                                                                                boolean z6 = postData4.q().hasAgree;
                                                                                int r = postData4.r();
                                                                                if (z6 && r == 5) {
                                                                                    pbFragment = PbFragment.this;
                                                                                    i = R.string.action_cancel_dislike;
                                                                                } else {
                                                                                    pbFragment = PbFragment.this;
                                                                                    i = R.string.action_dislike;
                                                                                }
                                                                                d.b.h0.r.s.h hVar11 = new d.b.h0.r.s.h(8, pbFragment.getString(i), PbFragment.this.z0);
                                                                                SparseArray sparseArray11 = new SparseArray();
                                                                                sparseArray11.put(R.id.tag_clip_board, postData4);
                                                                                hVar11.f51005d.setTag(sparseArray11);
                                                                                arrayList2.add(hVar11);
                                                                            }
                                                                            if (PbFragment.this.mIsLogin) {
                                                                                if (d.b.i0.c2.k.e.b1.a.h(PbFragment.this.m0) || booleanValue8 || !booleanValue7) {
                                                                                    if ((PbFragment.this.c5(booleanValue6) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                        d.b.h0.r.s.h hVar12 = new d.b.h0.r.s.h(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.z0);
                                                                                        hVar12.f51005d.setTag(str3);
                                                                                        arrayList2.add(hVar12);
                                                                                    }
                                                                                } else {
                                                                                    d.b.h0.r.s.h hVar13 = new d.b.h0.r.s.h(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.z0);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                    int i36 = R.id.tag_is_mem;
                                                                                    sparseArray12.put(i36, sparseArray.get(i36));
                                                                                    int i37 = R.id.tag_user_mute_mute_userid;
                                                                                    sparseArray12.put(i37, sparseArray.get(i37));
                                                                                    int i38 = R.id.tag_user_mute_mute_username;
                                                                                    sparseArray12.put(i38, sparseArray.get(i38));
                                                                                    int i39 = R.id.tag_user_mute_mute_nameshow;
                                                                                    sparseArray12.put(i39, sparseArray.get(i39));
                                                                                    int i40 = R.id.tag_user_mute_post_id;
                                                                                    sparseArray12.put(i40, sparseArray.get(i40));
                                                                                    int i41 = R.id.tag_user_mute_thread_id;
                                                                                    sparseArray12.put(i41, sparseArray.get(i41));
                                                                                    int i42 = R.id.tag_del_post_is_self;
                                                                                    sparseArray12.put(i42, sparseArray.get(i42));
                                                                                    int i43 = R.id.tag_del_post_type;
                                                                                    sparseArray12.put(i43, sparseArray.get(i43));
                                                                                    int i44 = R.id.tag_del_post_id;
                                                                                    sparseArray12.put(i44, sparseArray.get(i44));
                                                                                    int i45 = R.id.tag_manage_user_identity;
                                                                                    sparseArray12.put(i45, sparseArray.get(i45));
                                                                                    hVar13.f51005d.setTag(sparseArray12);
                                                                                    arrayList2.add(hVar13);
                                                                                }
                                                                                if (booleanValue8) {
                                                                                    SparseArray sparseArray13 = new SparseArray();
                                                                                    sparseArray13.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                                                                                    int i46 = R.id.tag_manage_user_identity;
                                                                                    sparseArray13.put(i46, sparseArray.get(i46));
                                                                                    int i47 = R.id.tag_forbid_user_name;
                                                                                    sparseArray13.put(i47, sparseArray.get(i47));
                                                                                    int i48 = R.id.tag_forbid_user_name_show;
                                                                                    sparseArray13.put(i48, sparseArray.get(i48));
                                                                                    int i49 = R.id.tag_forbid_user_portrait;
                                                                                    sparseArray13.put(i49, sparseArray.get(i49));
                                                                                    sparseArray13.put(R.id.tag_forbid_user_post_id, str3);
                                                                                    if (booleanValue9) {
                                                                                        sparseArray13.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                        int i50 = R.id.tag_is_mem;
                                                                                        sparseArray13.put(i50, sparseArray.get(i50));
                                                                                        int i51 = R.id.tag_user_mute_mute_userid;
                                                                                        sparseArray13.put(i51, sparseArray.get(i51));
                                                                                        int i52 = R.id.tag_user_mute_mute_username;
                                                                                        sparseArray13.put(i52, sparseArray.get(i52));
                                                                                        int i53 = R.id.tag_user_mute_mute_nameshow;
                                                                                        sparseArray13.put(i53, sparseArray.get(i53));
                                                                                        int i54 = R.id.tag_user_mute_post_id;
                                                                                        sparseArray13.put(i54, sparseArray.get(i54));
                                                                                        int i55 = R.id.tag_user_mute_thread_id;
                                                                                        sparseArray13.put(i55, sparseArray.get(i55));
                                                                                    } else {
                                                                                        sparseArray13.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                    }
                                                                                    if (booleanValue10) {
                                                                                        sparseArray13.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                        sparseArray13.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue6));
                                                                                        int i56 = R.id.tag_del_post_id;
                                                                                        sparseArray13.put(i56, sparseArray.get(i56));
                                                                                        int i57 = R.id.tag_del_post_type;
                                                                                        sparseArray13.put(i57, sparseArray.get(i57));
                                                                                        int i58 = R.id.tag_has_sub_post;
                                                                                        sparseArray13.put(i58, sparseArray.get(i58));
                                                                                        hVar2 = new d.b.h0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.z0);
                                                                                        hVar2.f51005d.setTag(sparseArray13);
                                                                                    } else {
                                                                                        sparseArray13.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                        hVar2 = null;
                                                                                    }
                                                                                    hVar = new d.b.h0.r.s.h(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.z0);
                                                                                    hVar.f51005d.setTag(sparseArray13);
                                                                                } else if (booleanValue10) {
                                                                                    SparseArray sparseArray14 = new SparseArray();
                                                                                    sparseArray14.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                                                                                    sparseArray14.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                    sparseArray14.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                    int i59 = R.id.tag_manage_user_identity;
                                                                                    sparseArray14.put(i59, sparseArray.get(i59));
                                                                                    sparseArray14.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue6));
                                                                                    int i60 = R.id.tag_del_post_id;
                                                                                    sparseArray14.put(i60, sparseArray.get(i60));
                                                                                    int i61 = R.id.tag_del_post_type;
                                                                                    sparseArray14.put(i61, sparseArray.get(i61));
                                                                                    int i62 = R.id.tag_has_sub_post;
                                                                                    sparseArray14.put(i62, sparseArray.get(i62));
                                                                                    if (PbFragment.this.m0.y0().R() == 1002 && !booleanValue6) {
                                                                                        hVar3 = new d.b.h0.r.s.h(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.z0);
                                                                                    } else {
                                                                                        hVar3 = new d.b.h0.r.s.h(6, PbFragment.this.getString(R.string.delete), PbFragment.this.z0);
                                                                                    }
                                                                                    hVar3.f51005d.setTag(sparseArray14);
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
                                                                            PbFragment.this.z0.k(arrayList2);
                                                                            PbFragment.this.y0 = new d.b.h0.r.s.j(PbFragment.this.getPageContext(), PbFragment.this.z0);
                                                                            PbFragment.this.y0.l();
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                                        statisticItem9.param("tid", PbFragment.this.m0.O0());
                                                                        statisticItem9.param("fid", PbFragment.this.m0.getForumId());
                                                                        statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        statisticItem9.param("obj_locate", 4);
                                                                        TiebaStatic.log(statisticItem9);
                                                                    }
                                                                    if (view.getId() == R.id.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                                                        PbFragment.this.V = view;
                                                                        return;
                                                                    } else if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null) {
                                                                            return;
                                                                        }
                                                                        PbFragment.this.t0.T();
                                                                        SparseArray sparseArray15 = (SparseArray) view.getTag();
                                                                        PostData postData5 = (PostData) sparseArray15.get(R.id.tag_load_sub_data);
                                                                        PostData postData6 = (PostData) sparseArray15.get(R.id.tag_load_sub_reply_data);
                                                                        View view2 = (View) sparseArray15.get(R.id.tag_load_sub_view);
                                                                        if (postData5 == null || view2 == null) {
                                                                            return;
                                                                        }
                                                                        if (postData5.B() == 1) {
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
                                                                        String O02 = PbFragment.this.m0.O0();
                                                                        String D3 = postData5.D();
                                                                        String D4 = postData6 != null ? postData6.D() : "";
                                                                        int R2 = PbFragment.this.m0.y0() != null ? PbFragment.this.m0.y0().R() : 0;
                                                                        PbFragment.this.c6();
                                                                        if (view.getId() == R.id.replybtn) {
                                                                            PbActivity.e t52 = PbFragment.this.t5(D3);
                                                                            if (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || t52 == null) {
                                                                                return;
                                                                            }
                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(O02, D3, "pb", true, null, true, null, R2, postData5.N(), PbFragment.this.m0.y0().d(), false, postData5.s().getIconInfo()).addBigImageData(t52.f19507a, t52.f19508b, t52.f19513g, t52.j);
                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.m0.x0());
                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.m0.getFromForumId());
                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.m0.getForumId());
                                                                            addBigImageData2.setBjhData(PbFragment.this.m0.T());
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                        } else {
                                                                            TiebaStatic.log("c11742");
                                                                            PbActivity.e t53 = PbFragment.this.t5(D3);
                                                                            if (postData5 == null || PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || t53 == null) {
                                                                                return;
                                                                            }
                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(O02, D3, "pb", true, null, false, D4, R2, postData5.N(), PbFragment.this.m0.y0().d(), false, postData5.s().getIconInfo()).addBigImageData(t53.f19507a, t53.f19508b, t53.f19513g, t53.j);
                                                                            if (!d.b.b.e.p.k.isEmpty(D4)) {
                                                                                addBigImageData3.setHighLightPostId(D4);
                                                                                addBigImageData3.setKeyIsUseSpid(true);
                                                                            }
                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.m0.getForumId());
                                                                            addBigImageData3.setBjhData(PbFragment.this.m0.T());
                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.m0.x0());
                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.m0.getFromForumId());
                                                                            if (PbFragment.this.t0 != null) {
                                                                                addBigImageData3.setMainPostMaskVisibly(PbFragment.this.t0.l0(PbFragment.this.m0.I, PbFragment.this.m0.M0()).S || postData5.S);
                                                                            }
                                                                            PbFragment.this.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                        }
                                                                    } else {
                                                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", PbFragment.this.m0.y0().m()));
                                                                        return;
                                                                    }
                                                                }
                                                            } else if (d.b.b.e.p.j.z()) {
                                                                PbFragment.this.t0.T();
                                                                SparseArray<Object> u02 = PbFragment.this.t0.u0(PbFragment.this.m0.y0(), PbFragment.this.m0.M0(), 1);
                                                                if (u02 == null) {
                                                                    return;
                                                                }
                                                                PbFragment.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.m0.y0().l().getId(), PbFragment.this.m0.y0().l().getName(), PbFragment.this.m0.y0().L().o0(), String.valueOf(PbFragment.this.m0.y0().Q().getUserId()), (String) u02.get(R.id.tag_forbid_user_name), (String) u02.get(R.id.tag_forbid_user_name_show), (String) u02.get(R.id.tag_forbid_user_post_id), (String) u02.get(R.id.tag_forbid_user_portrait))));
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
                                                            PbFragment.this.t0.f52767g.f();
                                                        }
                                                    } else if (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || PbFragment.this.m0.y0().L() == null) {
                                                        return;
                                                    } else {
                                                        PbFragment.this.t0.f52767g.e();
                                                        TiebaStatic.log(new StatisticItem("c13062"));
                                                        PbFragment pbFragment7 = PbFragment.this;
                                                        pbFragment7.O4(pbFragment7.m0.y0().L().f0());
                                                    }
                                                } else {
                                                    PbFragment.this.t0.T();
                                                    if (d.b.b.e.p.j.z()) {
                                                        if (PbFragment.this.m) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.m0.K0()));
                                                            return;
                                                        }
                                                        PbFragment.this.c6();
                                                        PbFragment.this.t0.u2();
                                                        d.b.h0.r.s.j jVar = new d.b.h0.r.s.j(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.m0.y0().f52425f == null || PbFragment.this.m0.y0().f52425f.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            strArr = new String[PbFragment.this.m0.y0().f52425f.size()];
                                                            for (int i63 = 0; i63 < PbFragment.this.m0.y0().f52425f.size(); i63++) {
                                                                strArr[i63] = PbFragment.this.m0.y0().f52425f.get(i63).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
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
                                                PbFragment.this.t0.T();
                                                if (PbFragment.this.L().y0().f52426g != 2) {
                                                    if (PbFragment.this.m0.w0() != null) {
                                                        PbFragment.this.t0.U2(PbFragment.this.m0.w0(), PbFragment.this.Q1);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (!(ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) || (y0 = PbFragment.this.m0.y0()) == null) {
                                            return;
                                        } else {
                                            d.b.h0.r.q.a2 L = y0.L();
                                            if (L != null && L.T() != null) {
                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.m0.f19731e).param("fid", y0.m()).param("obj_locate", 4).param("uid", L.T().getUserId()));
                                            }
                                            if (L != null) {
                                                if (L.O1()) {
                                                    i4 = 2;
                                                } else if (L.R1()) {
                                                    i4 = 3;
                                                } else if (L.P1()) {
                                                    i4 = 4;
                                                } else if (L.Q1()) {
                                                    i4 = 5;
                                                }
                                                StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                statisticItem11.param("tid", PbFragment.this.m0.O0());
                                                statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem11.param("fid", PbFragment.this.m0.getForumId());
                                                if (view.getId() != R.id.share_num_container) {
                                                    statisticItem11.param("obj_locate", 5);
                                                } else {
                                                    statisticItem11.param("obj_locate", 6);
                                                }
                                                statisticItem11.param("obj_name", i4);
                                                statisticItem11.param("obj_type", 1);
                                                if (L != null) {
                                                    if (L.O1()) {
                                                        statisticItem11.param("obj_type", 10);
                                                    } else if (L.R1()) {
                                                        statisticItem11.param("obj_type", 9);
                                                    } else if (L.Q1()) {
                                                        statisticItem11.param("obj_type", 8);
                                                    } else if (L.P1()) {
                                                        statisticItem11.param("obj_type", 7);
                                                    } else if (L.s1) {
                                                        statisticItem11.param("obj_type", 6);
                                                    } else {
                                                        int i64 = L.Z;
                                                        if (i64 == 0) {
                                                            statisticItem11.param("obj_type", 1);
                                                        } else if (i64 == 40) {
                                                            statisticItem11.param("obj_type", 2);
                                                        } else if (i64 == 49) {
                                                            statisticItem11.param("obj_type", 3);
                                                        } else if (i64 == 54) {
                                                            statisticItem11.param("obj_type", 4);
                                                        } else {
                                                            statisticItem11.param("obj_type", 5);
                                                        }
                                                    }
                                                    statisticItem11.param("card_type", L.U0());
                                                    statisticItem11.param("recom_source", L.R0);
                                                    statisticItem11.param("ab_tag", L.T0);
                                                    statisticItem11.param("weight", L.S0);
                                                    statisticItem11.param("extra", L.U0);
                                                    statisticItem11.param("nid", L.L0());
                                                    if (L.V() != null && !d.b.b.e.p.k.isEmpty(L.V().oriUgcVid)) {
                                                        statisticItem11.param(TiebaStatic.Params.OBJ_PARAM6, L.V().oriUgcVid);
                                                    }
                                                }
                                                if (!d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    statisticItem11.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.P() != null) {
                                                    d.b.h0.j0.c.e(PbFragment.this.P(), statisticItem11);
                                                }
                                                TiebaStatic.log(statisticItem11);
                                                if (d.b.b.e.p.l.C()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (y0 != null) {
                                                    ArrayList<PostData> D5 = PbFragment.this.m0.y0().D();
                                                    if ((D5 != null && D5.size() > 0) || !PbFragment.this.m0.M0()) {
                                                        PbFragment.this.t0.T();
                                                        PbFragment.this.c6();
                                                        if (y0.y() != null && !StringUtils.isNull(y0.y().a(), true)) {
                                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", PbFragment.this.m0.y0().m()));
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c11939"));
                                                        if (AntiHelper.e(PbFragment.this.getContext(), L)) {
                                                            return;
                                                        }
                                                        if (PbFragment.this.t0 != null) {
                                                            PbFragment.this.t0.V();
                                                            PbFragment.this.t0.e3(y0);
                                                        }
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.t0.M2();
                                                            PbFragment.this.m0.V().u(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                        } else {
                                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                                i5 = 2;
                                                            } else {
                                                                i5 = view.getId() == R.id.share_num_container ? 1 : 6;
                                                            }
                                                            PbFragment.this.W5(i5);
                                                        }
                                                    } else {
                                                        d.b.b.e.p.l.L(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                        return;
                                                    }
                                                } else {
                                                    d.b.b.e.p.l.L(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            i4 = 1;
                                            StatisticItem statisticItem112 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            statisticItem112.param("tid", PbFragment.this.m0.O0());
                                            statisticItem112.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem112.param("fid", PbFragment.this.m0.getForumId());
                                            if (view.getId() != R.id.share_num_container) {
                                            }
                                            statisticItem112.param("obj_name", i4);
                                            statisticItem112.param("obj_type", 1);
                                            if (L != null) {
                                            }
                                            if (!d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                            }
                                            if (PbFragment.this.P() != null) {
                                            }
                                            TiebaStatic.log(statisticItem112);
                                            if (d.b.b.e.p.l.C()) {
                                            }
                                        }
                                    } else if (d.b.b.e.p.j.z()) {
                                        PbFragment.this.t0.T();
                                        if (PbFragment.this.t0.f52767g.g() != null && view == PbFragment.this.t0.f52767g.g().i() && !PbFragment.this.t0.n1()) {
                                            PbFragment.this.t0.S1();
                                        }
                                        if (!PbFragment.this.m) {
                                            PbFragment.this.c6();
                                            PbFragment.this.t0.u2();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                W1 = PbFragment.this.m0.W1(true, PbFragment.this.q4());
                                            } else {
                                                W1 = view.getId() == R.id.reply_title ? PbFragment.this.m0.W1(false, PbFragment.this.q4()) : PbFragment.this.m0.V1(PbFragment.this.q4());
                                            }
                                            view.setTag(Boolean.valueOf(W1));
                                            if (W1) {
                                                i6 = 1;
                                                PbFragment.this.t0.g2(true);
                                                PbFragment.this.t0.T2();
                                                PbFragment.this.m = true;
                                                PbFragment.this.t0.j2(true);
                                            } else {
                                                i6 = 1;
                                            }
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i6, new Object[0]);
                                        } else {
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        view.setTag(Boolean.FALSE);
                                        return;
                                    }
                                } else if (d.b.b.e.p.j.z()) {
                                    PbFragment.this.t0.T();
                                    if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(PbFragment.this.getActivity(), "pb_shoucang"))) {
                                        if (!PbFragment.this.S3(11009) || PbFragment.this.m0.R(PbFragment.this.t0.s0()) == null) {
                                            return;
                                        }
                                        PbFragment.this.k5();
                                        if (PbFragment.this.m0.y0() != null && PbFragment.this.m0.y0().L() != null && PbFragment.this.m0.y0().L().T() != null) {
                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", PbFragment.this.m0.f19731e).param("fid", PbFragment.this.m0.y0().m()).param("obj_locate", 3).param("uid", PbFragment.this.m0.y0().L().T().getUserId()));
                                        }
                                        if (PbFragment.this.m0.y0().L() != null && PbFragment.this.m0.y0().L().T() != null && PbFragment.this.m0.y0().L().T().getUserId() != null && PbFragment.this.o0 != null) {
                                            PbFragment pbFragment8 = PbFragment.this;
                                            int J4 = pbFragment8.J4(pbFragment8.m0.y0());
                                            d.b.h0.r.q.a2 L2 = PbFragment.this.m0.y0().L();
                                            if (L2.O1()) {
                                                i7 = 2;
                                            } else if (L2.R1()) {
                                                i7 = 3;
                                            } else if (L2.P1()) {
                                                i7 = 4;
                                            } else {
                                                i7 = L2.Q1() ? 5 : 1;
                                            }
                                            TiebaStatic.log(new StatisticItem("c12526").param("tid", PbFragment.this.m0.f19731e).param("obj_locate", 1).param("obj_id", PbFragment.this.m0.y0().L().T().getUserId()).param("obj_type", !PbFragment.this.o0.e()).param("obj_source", J4).param("obj_param1", i7));
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
                                if (PbFragment.this.m0.y0() != null && PbFragment.this.m0.y0().L() != null && PbFragment.this.m0.y0().L().y2() && PbFragment.this.m0.y0().L().u1() != null) {
                                    TiebaStatic.log(new StatisticItem("c11922"));
                                }
                                if (PbFragment.this.m0.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.m0.a0()) || PbFragment.this.m0.Q() == null) {
                                        PbFragment.this.f19547e.finish();
                                        return;
                                    }
                                    name2 = PbFragment.this.m0.Q().f52415b;
                                } else {
                                    name2 = PbFragment.this.m0.y0().l().getName();
                                }
                                if (StringUtils.isNull(name2)) {
                                    PbFragment.this.f19547e.finish();
                                    return;
                                }
                                String a02 = PbFragment.this.m0.a0();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.m0.e0() && a02 != null && a02.equals(name2)) {
                                    PbFragment.this.f19547e.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                }
                            }
                        } else if (d.b.b.e.p.j.z()) {
                            if (PbFragment.this.m0.y0() == null || PbFragment.this.p0.K()) {
                                return;
                            }
                            PbFragment.this.t0.T();
                            int i65 = (PbFragment.this.t0.f52767g.g() == null || view != PbFragment.this.t0.f52767g.g().n()) ? (PbFragment.this.t0.f52767g.g() == null || view != PbFragment.this.t0.f52767g.g().m()) ? view == PbFragment.this.t0.g0() ? 2 : 0 : PbFragment.this.m0.y0().L().w0() == 1 ? 3 : 6 : PbFragment.this.m0.y0().L().x0() == 1 ? 5 : 4;
                            ForumData l = PbFragment.this.m0.y0().l();
                            String name3 = l.getName();
                            String id2 = l.getId();
                            String o0 = PbFragment.this.m0.y0().L().o0();
                            PbFragment.this.t0.Z2();
                            PbFragment.this.p0.O(id2, name3, o0, i65, PbFragment.this.t0.h0());
                        } else {
                            PbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                    } else {
                        PbFragment.this.t0.f52767g.f();
                        if (PbFragment.this.m0 != null) {
                            PbFragment.this.n1.i(PbFragment.this.m0.O0());
                        }
                        if (PbFragment.this.m0 == null || !PbFragment.this.m0.isPrivacy()) {
                            PbFragment.this.n1.c();
                            int i66 = (TbSingleton.getInstance().mCanCallFans || PbFragment.this.L() == null || PbFragment.this.L().y0() == null || PbFragment.this.L().y0().N() == null || !PbFragment.this.L().y0().N().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                            if (PbFragment.this.L() != null && PbFragment.this.L().y0() != null) {
                                PbFragment.this.n1.e(3, i66, PbFragment.this.L().y0().N());
                            }
                        } else {
                            PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                            if (PbFragment.this.L() == null || PbFragment.this.L().y0() == null) {
                                return;
                            }
                            PbFragment.this.n1.e(3, 3, PbFragment.this.L().y0().N());
                            return;
                        }
                    }
                } else if (d.b.b.e.p.j.z()) {
                    PbFragment.this.t0.T();
                    PbFragment.this.c6();
                    PbFragment.this.t0.u2();
                    PbFragment.this.t0.M2();
                    if (PbFragment.this.t0.z0() != null) {
                        PbFragment.this.t0.z0().setVisibility(8);
                    }
                    PbFragment.this.m0.R1(1);
                    if (PbFragment.this.i != null) {
                        PbFragment.this.i.x();
                    }
                } else {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                    String p4 = PbFragment.this.p4();
                    if (TextUtils.isEmpty(p4)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(PbFragment.this.getPageContext(), new String[]{p4});
                    return;
                }
                return;
            }
            StatisticItem statisticItem12 = new StatisticItem("c13398");
            statisticItem12.param("tid", PbFragment.this.m0.O0());
            statisticItem12.param("fid", PbFragment.this.m0.getForumId());
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
                    if (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || PbFragment.this.G4().A0() == null || postData7.s() == null || postData7.z() == 1 || !PbFragment.this.checkUpIsLogin()) {
                        return;
                    }
                    if (PbFragment.this.G4().B0() != null) {
                        PbFragment.this.G4().B0().c();
                    }
                    d.b.i0.c2.h.q qVar2 = new d.b.i0.c2.h.q();
                    qVar2.A(PbFragment.this.m0.y0().l());
                    qVar2.E(PbFragment.this.m0.y0().L());
                    qVar2.C(postData7);
                    PbFragment.this.G4().A0().E(qVar2);
                    PbFragment.this.G4().A0().setPostId(postData7.D());
                    PbFragment.this.i5(view, postData7.s().getUserId(), "", postData7);
                    TiebaStatic.log("c11743");
                    d.b.i0.c2.m.a.b(PbFragment.this.m0.y0(), postData7, postData7.d0, 8, 1);
                    if (PbFragment.this.N0 != null) {
                        PbFragment.this.t0.Z1(PbFragment.this.N0.C());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m1 implements d.b.b.e.k.c<GifView> {
        public m1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            gifView.setTag(null);
            if (d.b.h0.r.k.c().g()) {
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
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            gifView.setBackgroundDrawable(null);
            gifView.setImageDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            gifView.p0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public GifView d() {
            GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
            boolean g2 = d.b.h0.r.k.c().g();
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
            gifView.p0();
            gifView.setImageDrawable(null);
            gifView.t0();
            gifView.setBackgroundDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            return gifView;
        }
    }

    /* loaded from: classes4.dex */
    public interface m2 {
        void a(Object obj);
    }

    /* loaded from: classes4.dex */
    public class n implements GetSugMatchWordsModel.b {
        public n() {
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onFail(int i, String str) {
            BdLog.e(str);
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            if (ListUtils.isEmpty(list) || PbFragment.this.t0 == null) {
                return;
            }
            PbFragment.this.t0.B2(list);
        }
    }

    /* loaded from: classes4.dex */
    public class n0 extends CustomMessageListener {
        public n0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || PbFragment.this.m0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.m0.f19731e)) {
                return;
            }
            PbFragment.this.V5((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class n1 implements d.b.h0.w.w.b {
        public n1() {
        }

        @Override // d.b.h0.w.w.b
        public boolean a() {
            d.b.i0.c2.k.e.s0 s0Var = PbFragment.this.x0;
            if (s0Var == null || s0Var.g() == null || !PbFragment.this.x0.g().d()) {
                return !PbFragment.this.V3(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.showToast(pbFragment.x0.g().c());
            if (PbFragment.this.t0 != null && PbFragment.this.t0.B0() != null && PbFragment.this.t0.B0().b() != null && PbFragment.this.t0.B0().b().v()) {
                PbFragment.this.t0.B0().b().t(PbFragment.this.x0.h());
            }
            PbFragment.this.x0.b(true);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public interface n2 {
    }

    /* loaded from: classes4.dex */
    public class o implements PraiseModel.b {
        public o() {
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            PbFragment.this.E1 = false;
            if (PbFragment.this.F1 == null) {
                return;
            }
            d.b.i0.c2.h.e y0 = PbFragment.this.m0.y0();
            if (y0.L().P0().getIsLike() == 1) {
                PbFragment.this.i6(0);
            } else {
                PbFragment.this.i6(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, y0.L()));
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i, String str) {
            PbFragment.this.E1 = false;
            if (PbFragment.this.F1 == null || str == null) {
                return;
            }
            if (AntiHelper.m(i, str)) {
                AntiHelper.u(PbFragment.this.getPageContext().getPageActivity(), str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o0 implements NewWriteModel.g {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a(o0 o0Var) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b() {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
                PbFragment.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public o0() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.b.h0.s.c.f0 f0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            if (!d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13268");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.m0.y0() != null) {
                    statisticItem.param("fid", PbFragment.this.m0.y0().m());
                }
                statisticItem.param("tid", PbFragment.this.m0.O0());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
            }
            PbFragment.this.c6();
            PbFragment.this.t0.s2(z, postWriteCallBackData);
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            } else {
                str = "";
            }
            boolean z2 = false;
            if (z) {
                PbFragment.this.V5(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbFragment.this.M5(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (PbFragment.this.m0.d0()) {
                        d.b.i0.c2.h.e y0 = PbFragment.this.m0.y0();
                        if (y0 != null && y0.L() != null && y0.L().T() != null && (userId = y0.L().T().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.m0.U1()) {
                            PbFragment.this.t0.u2();
                        }
                    } else if (!PbReplySwitch.getInOn() && PbFragment.this.m0.U1()) {
                        PbFragment.this.t0.u2();
                    }
                } else if (floor != null) {
                    PbFragment.this.t0.b1(PbFragment.this.m0.y0());
                }
                if (PbFragment.this.m0.g0()) {
                    TiebaStatic.log(new StatisticItem("c10369").param("tid", PbFragment.this.m0.O0()));
                }
                PbFragment pbFragment = PbFragment.this;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                pbFragment.P3(z2);
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.N0.B() || PbFragment.this.N0.D()) {
                    PbFragment.this.N0.z(false, postWriteCallBackData);
                }
                PbFragment.this.x0.k(postWriteCallBackData);
            } else if (i == 238010) {
                ReplyPrivacyCheckController replyPrivacyCheckController = PbFragment.this.Q0;
                if (replyPrivacyCheckController != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (d.b.b.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(PbFragment.this.getActivity());
                if (d.b.b.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new a(this));
                aVar.setPositiveButton(R.string.open_now, new b());
                aVar.create(PbFragment.this.getPageContext()).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
            } else if (d.b.i0.m3.a.c(i) || f0Var != null || i == 227001) {
            } else {
                PbFragment.this.L5(i, antiData, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o1 implements d.b.b.e.k.c<View> {
        public o1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            ((PlayVoiceBntNew) view).o();
            return view;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(View view) {
            ((PlayVoiceBntNew) view).n();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public View d() {
            PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
            playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
            playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
            return playVoiceBntNew;
        }

        public View h(View view) {
            ((PlayVoiceBntNew) view).n();
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public class p implements b.h {
        public p() {
        }

        @Override // d.b.i0.c2.k.e.z0.b.h
        public void a(boolean z) {
            PbFragment.this.G5(z);
            if (PbFragment.this.t0.q0() != null && z) {
                PbFragment.this.t0.V2(false);
            }
            PbFragment.this.t0.x1(z);
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements NewWriteModel.g {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a(p0 p0Var) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b() {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
                PbFragment.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public p0() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.b.h0.s.c.f0 f0Var, WriteData writeData, AntiData antiData) {
            if (!d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13268");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.m0 != null && PbFragment.this.m0.y0() != null) {
                    statisticItem.param("fid", PbFragment.this.m0.y0().m());
                }
                if (PbFragment.this.m0 != null) {
                    statisticItem.param("tid", PbFragment.this.m0.O0());
                }
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
            }
            if (z) {
                d.b.i0.c2.k.e.s0 s0Var = PbFragment.this.x0;
                if (s0Var != null) {
                    s0Var.d();
                }
                if (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) {
                    return;
                }
                d.b.h0.s.h.b.a(PbFragment.this.getPageContext(), postWriteCallBackData);
                return;
            }
            if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                ReplyPrivacyCheckController replyPrivacyCheckController = PbFragment.this.Q0;
                if (replyPrivacyCheckController != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (d.b.b.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(PbFragment.this.getActivity());
                if (d.b.b.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new a(this));
                aVar.setPositiveButton(R.string.open_now, new b());
                aVar.create(PbFragment.this.getPageContext()).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
            }
            if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                return;
            }
            PbFragment pbFragment = PbFragment.this;
            if (pbFragment.x0 == null) {
                return;
            }
            if (pbFragment.t0 != null && PbFragment.this.t0.B0() != null && PbFragment.this.t0.B0().b() != null && PbFragment.this.t0.B0().b().v()) {
                PbFragment.this.t0.B0().b().t(postWriteCallBackData);
            }
            PbFragment.this.x0.l(postWriteCallBackData);
        }
    }

    /* loaded from: classes4.dex */
    public class p1 implements d.b.b.e.k.c<RelativeLayout> {
        public p1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        public RelativeLayout e(RelativeLayout relativeLayout) {
            return relativeLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            return new RelativeLayout(PbFragment.this.getPageContext().getPageActivity());
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            return relativeLayout;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19635e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19636f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19637g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19638h;

        public q(SparseArray sparseArray, boolean z, String str, String str2) {
            this.f19635e = sparseArray;
            this.f19636f = z;
            this.f19637g = str;
            this.f19638h = str2;
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(d.b.h0.r.s.l lVar, int i, View view) {
            if (PbFragment.this.y0 != null) {
                PbFragment.this.y0.dismiss();
            }
            if (i == 0) {
                PbFragment.this.t0.D1(((Integer) this.f19635e.get(R.id.tag_del_post_type)).intValue(), (String) this.f19635e.get(R.id.tag_del_post_id), ((Integer) this.f19635e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f19635e.get(R.id.tag_del_post_is_self)).booleanValue());
            } else if (i == 1) {
                String str = (String) this.f19635e.get(R.id.tag_user_mute_mute_username);
                String str2 = (String) this.f19635e.get(R.id.tag_user_mute_thread_id);
                String str3 = (String) this.f19635e.get(R.id.tag_user_mute_post_id);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(this.f19636f, this.f19637g, str, str2, str3, 1, this.f19638h, PbFragment.this.b1);
                userMuteAddAndDelCustomMessage.setTag(PbFragment.this.b1);
                PbFragment.this.Y5(this.f19636f, userMuteAddAndDelCustomMessage, this.f19638h, str, (String) this.f19635e.get(R.id.tag_user_mute_mute_nameshow));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 extends d.b.b.c.g.a {
        public q0(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView K0;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.f19547e.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    d.b.b.e.p.l.K(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                    if (PbFragment.this.t0 == null || (K0 = PbFragment.this.t0.K0()) == null || PbFragment.this.t0.t0() == null) {
                        return;
                    }
                    PbFragment.this.t0.t0().removeHeaderView(K0);
                    return;
                }
                d.b.b.e.p.l.L(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q1 implements TbRichTextView.w {
        public q1() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.w
        public void a(View view, String str, int i, boolean z, boolean z2) {
            d.b.i0.c2.k.e.g e0;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.t0.u1((TbRichText) view.getTag());
                        TiebaStatic.log(new StatisticItem("c12490"));
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13398");
                statisticItem.param("tid", PbFragment.this.m0.O0());
                statisticItem.param("fid", PbFragment.this.m0.getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_locate", 3);
                statisticItem.param("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(statisticItem);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.m0.I.Z()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        int i3 = -1;
                        if (tbRichTextView == null || tbRichTextView.getRichText() == null || tbRichTextView.getRichText().w() == null) {
                            i2 = -1;
                        } else {
                            ArrayList<TbRichTextImageInfo> w = tbRichTextView.getRichText().w();
                            int i4 = 0;
                            int i5 = -1;
                            while (i4 < w.size()) {
                                if (w.get(i4) != null) {
                                    arrayList.add(w.get(i4).x());
                                    if (i5 == i3 && str != null && (str.equals(w.get(i4).x()) || str.equals(w.get(i4).u()) || str.equals(w.get(i4).s()) || str.equals(w.get(i4).t()) || str.equals(w.get(i4).w()))) {
                                        i5 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = w.get(i4).x();
                                    imageUrlData.originalUrl = w.get(i4).x();
                                    imageUrlData.isLongPic = w.get(i4).A();
                                    concurrentHashMap.put(w.get(i4).x(), imageUrlData);
                                }
                                i4++;
                                i3 = -1;
                            }
                            i2 = i5;
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.j4(rect);
                        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                        bVar.x(arrayList);
                        bVar.B(i2);
                        bVar.C(false);
                        bVar.G(PbFragment.this.m0.J0());
                        bVar.w(concurrentHashMap);
                        bVar.I(true);
                        bVar.L(false);
                        bVar.H(PbFragment.this.Y4());
                        bVar.N(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.m0 != null) {
                            bVar.A(PbFragment.this.m0.getFromForumId());
                            if (PbFragment.this.m0.y0() != null) {
                                bVar.O(PbFragment.this.m0.y0().L());
                            }
                        }
                        ImageViewerConfig v = bVar.v(PbFragment.this.getPageContext().getPageActivity());
                        v.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage(2010000, v));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    PbActivity.e eVar = new PbActivity.e();
                    PbFragment.this.r5(str, i, eVar);
                    if (eVar.f19514h) {
                        TbRichText j6 = PbFragment.this.j6(str, i);
                        if (j6 != null && PbFragment.this.i2 >= 0 && PbFragment.this.i2 < j6.u().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a2 = d.b.i0.c2.h.f.a(j6.u().get(PbFragment.this.i2));
                            int i6 = 0;
                            while (true) {
                                if (i6 >= eVar.f19507a.size()) {
                                    break;
                                } else if (eVar.f19507a.get(i6).equals(a2)) {
                                    eVar.j = i6;
                                    arrayList2.add(a2);
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            if (j6.getPostId() != 0 && (e0 = PbFragment.this.t0.e0()) != null) {
                                ArrayList<d.b.b.j.e.n> r = e0.r();
                                if (ListUtils.getCount(r) > 0) {
                                    Iterator<d.b.b.j.e.n> it = r.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        d.b.b.j.e.n next = it.next();
                                        if ((next instanceof PostData) && j6.getPostId() == d.b.b.e.m.b.f(((PostData) next).D(), 0L)) {
                                            d.b.i0.c2.m.a.b(PbFragment.this.m0.y0(), (PostData) next, ((PostData) next).d0, j6.getPostId() == d.b.b.e.m.b.f(PbFragment.this.m0.Z(), 0L) ? 1 : 8, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.f19508b.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.j4(rect2);
                            ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                            bVar2.x(arrayList2);
                            bVar2.z(eVar.f19509c);
                            bVar2.y(eVar.f19510d);
                            bVar2.P(eVar.f19511e);
                            bVar2.C(eVar.f19513g);
                            bVar2.I(true);
                            bVar2.K(eVar.i);
                            bVar2.G(PbFragment.this.m0.J0());
                            bVar2.w(concurrentHashMap2);
                            bVar2.L(false);
                            bVar2.H(PbFragment.this.Y4());
                            bVar2.M(eVar.f19512f);
                            bVar2.N(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.m0 != null) {
                                bVar2.A(PbFragment.this.m0.getFromForumId());
                                if (PbFragment.this.m0.y0() != null) {
                                    bVar2.O(PbFragment.this.m0.y0().L());
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
                    arrayList3.add(ListUtils.getItem(eVar.f19507a, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!ListUtils.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, eVar.f19508b.get(str3));
                    }
                    ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                    bVar3.x(arrayList3);
                    bVar3.z(eVar.f19509c);
                    bVar3.y(eVar.f19510d);
                    bVar3.P(eVar.f19511e);
                    bVar3.C(eVar.f19513g);
                    bVar3.I(true);
                    bVar3.K(eVar.f19507a.get(0));
                    bVar3.G(PbFragment.this.m0.J0());
                    bVar3.w(concurrentHashMap3);
                    bVar3.L(false);
                    bVar3.H(PbFragment.this.Y4());
                    bVar3.M(eVar.f19512f);
                    bVar3.D(false);
                    if (PbFragment.this.m0 != null) {
                        bVar3.A(PbFragment.this.m0.getFromForumId());
                        if (PbFragment.this.m0.y0() != null) {
                            bVar3.O(PbFragment.this.m0.y0().L());
                        }
                    }
                    ImageViewerConfig v3 = bVar3.v(PbFragment.this.getPageContext().getPageActivity());
                    v3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage(2010000, v3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean I = ((TbImageView) view).I();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, I)));
                }
                PbFragment.this.U = view;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends CustomMessageListener {
        public r(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f13695c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().k != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != PbFragment.this.getUniqueId() || AntiHelper.t(PbFragment.this.getActivity(), updateAttentionMessage.getData().k, PbFragment.y2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().f13693a) {
                    if (PbFragment.this.m4().s() != null && PbFragment.this.m4().s().getGodUserData() != null) {
                        PbFragment.this.m4().s().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || PbFragment.this.m0.y0().L() == null || PbFragment.this.m0.y0().L().T() == null) {
                        return;
                    }
                    PbFragment.this.m0.y0().L().T().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r0 implements d.b.h0.w.w.c {
        public r0() {
        }

        @Override // d.b.h0.w.w.c
        public void a() {
            PbFragment.this.showProgressBar();
        }
    }

    /* loaded from: classes4.dex */
    public class r1 implements b.c {
        public r1() {
        }

        @Override // d.b.h0.r.s.b.c
        public void a(d.b.h0.r.s.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.e();
            }
            PbFragment pbFragment = PbFragment.this;
            PostData postData = pbFragment.l2;
            if (postData != null) {
                if (i == 0) {
                    postData.f0(pbFragment.getPageContext().getPageActivity());
                    PbFragment.this.l2 = null;
                } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                    PbFragment pbFragment2 = PbFragment.this;
                    pbFragment2.m5(pbFragment2.l2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends d.b.h0.f0.h<TipEvent> {
        public s() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.f0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            if (tipEvent.pageId <= 0 || PbFragment.this.f19547e.getPageId() != tipEvent.pageId) {
                return true;
            }
            DefaultNavigationBarCoverTip.s(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class s0 implements PbModel.g {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19646e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f19647f;

            public a(int i, int i2) {
                this.f19646e = i;
                this.f19647f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PbFragment.this.getListView() != null) {
                    PbFragment.this.getListView().setSelectionFromTop(this.f19646e, this.f19647f);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19649e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f19650f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f19651g;

            public b(int i, boolean z, int i2) {
                this.f19649e = i;
                this.f19650f = z;
                this.f19651g = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f19649e == -1 || PbFragment.this.getListView() == null) {
                    return;
                }
                if (this.f19650f) {
                    PbFragment.this.t0.z2(this.f19649e, this.f19651g);
                } else {
                    PbFragment.this.t0.z2(this.f19649e - 1, this.f19651g);
                }
            }
        }

        public s0() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            if (d.b.h0.m0.k.d().g()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.r : j;
                if (PbFragment.this.s == 0) {
                    PbFragment.this.s = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                d.b.h0.m0.h hVar = new d.b.h0.m0.h(i, z, responsedMessage, PbFragment.this.v, PbFragment.this.u, PbFragment.this.s, z2, 0L, 0L, j3);
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
                if (z2 || PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || PbFragment.this.m0.y0().L() == null) {
                    return;
                }
                int s1 = PbFragment.this.m0.y0().L().s1();
                if (s1 == 0 || s1 == 40) {
                    if (!StringHelper.equals(PbFragment.this.O, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                        if (StringHelper.equals(PbFragment.this.O, "from_frs")) {
                            d.b.h0.m0.h hVar2 = new d.b.h0.m0.h();
                            hVar2.a(1000);
                            hVar2.D = j2;
                            hVar2.d(s1);
                            return;
                        }
                        return;
                    }
                    d.b.h0.m0.d dVar = new d.b.h0.m0.d();
                    dVar.F = 1;
                    dVar.a(1005);
                    dVar.D = j2;
                    dVar.d(s1);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.b.i0.c2.h.e eVar) {
            PbFragment.this.t0.b1(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i, int i2, int i3, d.b.i0.c2.h.e eVar, String str, int i4) {
            d.b.h0.w.h m;
            if (!z || eVar == null || eVar.S() != null || ListUtils.getCount(eVar.D()) >= 1) {
                PbFragment.this.l = true;
                PbFragment.this.t0.t2();
                if (eVar == null || !eVar.b0()) {
                    PbFragment pbFragment = PbFragment.this;
                    pbFragment.hideLoadingView(pbFragment.t0.M0());
                }
                PbFragment.this.t0.U0();
                if (PbFragment.this.L || PbFragment.this.t0.n1()) {
                    PbFragment.this.t0.O0();
                } else if (!PbFragment.this.t0.g1()) {
                    PbFragment.this.t0.F2(false);
                }
                if (PbFragment.this.m) {
                    PbFragment.this.m = false;
                }
                if (i4 == 0 && eVar != null) {
                    PbFragment.this.B0 = true;
                }
                if (eVar != null) {
                    PbFragment pbFragment2 = PbFragment.this;
                    pbFragment2.hideNetRefreshView(pbFragment2.t0.M0());
                    PbFragment.this.t0.C2();
                }
                if (z && eVar != null) {
                    d.b.h0.r.q.a2 L = eVar.L();
                    if (L != null && L.x2()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = PbFragment.this;
                        pbFragment3.H5(pbFragment3.M0);
                    }
                    PbFragment.this.t0.B0().l(eVar);
                    PbFragment.this.t0.L2();
                    if (L != null && L.W() != null) {
                        PbFragment.this.h6(L.W());
                    }
                    if (PbFragment.this.N0 != null) {
                        PbFragment.this.t0.Z1(PbFragment.this.N0.C());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.Q().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.Q().getBimg_end_time());
                    if (eVar.D() != null && eVar.D().size() >= 1 && eVar.D().get(0) != null) {
                        PbFragment.this.m0.I1(eVar.D().get(0).D());
                    } else if (eVar.S() != null) {
                        PbFragment.this.m0.I1(eVar.S().D());
                    }
                    if (PbFragment.this.N0 != null) {
                        PbFragment.this.N0.M(eVar.d());
                        PbFragment.this.N0.N(eVar.l(), eVar.Q());
                        PbFragment.this.N0.r0(L);
                        PbFragment.this.N0.O(PbFragment.this.m0.c0(), PbFragment.this.m0.O0(), PbFragment.this.m0.Z());
                        if (L != null) {
                            PbFragment.this.N0.h0(L.k2());
                        }
                    }
                    if (PbFragment.this.o0 != null) {
                        PbFragment.this.o0.h(eVar.r());
                    }
                    if (eVar.s() == 1) {
                        PbFragment.this.w = true;
                    } else {
                        PbFragment.this.w = false;
                    }
                    if (eVar.Z()) {
                        PbFragment.this.w = true;
                    }
                    PbFragment.this.t0.a2(PbFragment.this.w);
                    PbFragment.this.t0.N2(eVar, i2, i3, PbFragment.this.m0.M0(), i4, PbFragment.this.m0.i0());
                    PbFragment.this.t0.X2(eVar, PbFragment.this.m0.M0());
                    PbFragment.this.t0.b3(PbFragment.this.m0.d0());
                    AntiData d2 = eVar.d();
                    if (d2 != null) {
                        PbFragment.this.D = d2.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.D) && PbFragment.this.N0 != null && PbFragment.this.N0.a() != null && (m = PbFragment.this.N0.a().m(6)) != null && !TextUtils.isEmpty(PbFragment.this.D)) {
                            ((View) m).setOnClickListener(PbFragment.this.y1);
                        }
                    }
                    if (PbFragment.this.D0) {
                        PbFragment.this.D0 = false;
                        int o4 = PbFragment.this.o4();
                        if (!eVar.e0()) {
                            PbFragment.this.t0.A2(o4);
                        } else {
                            d.b.b.e.m.e.a().post(new a(o4, (int) (d.b.b.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)));
                        }
                    }
                    if (PbFragment.this.E0) {
                        PbFragment.this.E0 = false;
                        int o42 = PbFragment.this.o4();
                        boolean z2 = o42 != -1;
                        if (!z2) {
                            o42 = PbFragment.this.l4();
                        }
                        if (PbFragment.this.t0 != null) {
                            if (!eVar.e0()) {
                                PbFragment.this.t0.A2(o42);
                            } else {
                                d.b.b.e.m.e.a().post(new b(o42, z2, (int) (d.b.b.e.p.l.k(PbFragment.this.getContext()) * 0.5625d)));
                                PbFragment.this.t0.b2(true);
                                PbFragment.this.t0.F2(false);
                            }
                        }
                    } else if (PbFragment.this.K0) {
                        PbFragment.this.K0 = false;
                        PbFragment.this.t0.z2(0, 0);
                    } else {
                        PbFragment.this.t0.K2();
                    }
                    PbFragment.this.m0.g1(eVar.l(), PbFragment.this.C1);
                    PbFragment.this.m0.m1(PbFragment.this.D1);
                    if (PbFragment.this.Q0 != null && L != null && L.T() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(L.T());
                        PbFragment.this.Q0.setLikeUserData(attentionHostData);
                    }
                } else if (str != null) {
                    if (PbFragment.this.B0 || i4 != 1) {
                        PbFragment.this.showToast(str);
                    } else if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            if (PbFragment.this.m0.Q() != null && !StringUtils.isNull(PbFragment.this.m0.Q().f52416c)) {
                                PbFragment.this.t0.d3(PbFragment.this.m0.Q());
                            } else {
                                PbFragment pbFragment4 = PbFragment.this;
                                pbFragment4.showNetRefreshView(pbFragment4.t0.M0(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment pbFragment5 = PbFragment.this;
                                pbFragment5.setNetRefreshViewEmotionMarginTop(d.b.b.e.p.l.g(pbFragment5.getContext(), R.dimen.ds360));
                            }
                        } else {
                            PbFragment pbFragment6 = PbFragment.this;
                            pbFragment6.showNetRefreshView(pbFragment6.t0.M0(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                            PbFragment pbFragment7 = PbFragment.this;
                            pbFragment7.setNetRefreshViewEmotionMarginTop(d.b.b.e.p.l.g(pbFragment7.getContext(), R.dimen.ds360));
                        }
                        PbFragment.this.t0.O0();
                        PbFragment.this.t0.N0();
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.m0.O0());
                            jSONObject.put("fid", PbFragment.this.m0.getForumId());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.m0 != null && PbFragment.this.m0.y0() != null) {
                            arrayList = PbFragment.this.m0.y0().D();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).z() != 1)) {
                            PbFragment.this.t0.W1(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.Y4()) {
                                PbFragment.this.t0.X1(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.t0.X1(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.t0.b1(PbFragment.this.m0.y0());
                        }
                    } else {
                        PbFragment.this.t0.W1("");
                    }
                    PbFragment.this.t0.Z();
                }
                if (eVar != null && eVar.m && PbFragment.this.s == 0) {
                    PbFragment.this.s = System.currentTimeMillis() - PbFragment.this.r;
                }
                if (PbFragment.this.L().M0() && PbFragment.this.L().y0().w().c() == 0 && !PbFragment.this.L().W0()) {
                    return;
                }
                PbFragment.this.O0 = true;
                return;
            }
            PbFragment.this.m0.R1(1);
            if (PbFragment.this.i != null) {
                PbFragment.this.i.x();
            }
        }

        public final void d() {
            if (PbFragment.this.m0 == null) {
                return;
            }
            if (PbFragment.this.N0 == null || !PbFragment.this.N0.z) {
                d.b.h0.w.w.d dVar = new d.b.h0.w.w.d();
                PbFragment.this.H5(dVar);
                PbFragment pbFragment = PbFragment.this;
                pbFragment.N0 = (d.b.h0.w.w.e) dVar.a(pbFragment.getContext());
                PbFragment.this.N0.e0(PbFragment.this.f19547e.getPageContext());
                PbFragment.this.N0.n0(PbFragment.this.V1);
                PbFragment.this.N0.o0(PbFragment.this.U0);
                PbFragment.this.N0.F(PbFragment.this.f19547e.getPageContext(), PbFragment.this.f19547e.getIntent() == null ? null : PbFragment.this.f19547e.getIntent().getExtras());
                PbFragment.this.N0.a().C(true);
                PbFragment.this.t0.V1(PbFragment.this.N0.a());
                if (!PbFragment.this.m0.m0()) {
                    PbFragment.this.N0.s(PbFragment.this.m0.O0());
                }
                if (PbFragment.this.m0.X0()) {
                    PbFragment.this.N0.k0(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else if (PbFragment.this.t0 != null) {
                    PbFragment.this.N0.k0(PbFragment.this.t0.E0());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s1 implements b.c {
        public s1() {
        }

        @Override // d.b.h0.r.s.b.c
        public void a(d.b.h0.r.s.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.e();
            }
            if (PbFragment.this.e1 == null || TextUtils.isEmpty(PbFragment.this.f1)) {
                return;
            }
            if (i == 0) {
                if (PbFragment.this.g1 == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbFragment.this.f1));
                } else {
                    d.a aVar = new d.a();
                    aVar.f49686a = PbFragment.this.f1;
                    String str = "";
                    if (PbFragment.this.g1.memeInfo.pck_id.intValue() >= 0) {
                        str = "" + PbFragment.this.g1.memeInfo.pck_id;
                    }
                    aVar.f49687b = str;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                }
            } else if (i == 1) {
                if (PbFragment.this.P0 == null) {
                    PbFragment.this.P0 = new PermissionJudgePolicy();
                }
                PbFragment.this.P0.clearRequestPermissionList();
                PbFragment.this.P0.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (PbFragment.this.P0.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                    return;
                }
                if (PbFragment.this.d1 == null) {
                    PbFragment pbFragment = PbFragment.this;
                    pbFragment.d1 = new d.b.i0.c2.k.e.u0(pbFragment.getPageContext());
                }
                PbFragment.this.d1.b(PbFragment.this.f1, PbFragment.this.e1.n());
            }
            PbFragment.this.e1 = null;
            PbFragment.this.f1 = null;
        }
    }

    /* loaded from: classes4.dex */
    public class t implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f19654e;

        public t(Intent intent) {
            this.f19654e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.c2.k.e.q0 q0Var = PbFragment.this.t0;
            q0Var.x2("@" + this.f19654e.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes4.dex */
    public class t0 extends CustomMessageListener {
        public t0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.g6();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t1 implements AdapterView.OnItemClickListener {
        public t1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (PbFragment.this.m0 == null || PbFragment.this.m0.H0() == i + 1) {
                return;
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.F5(pbFragment.F4(i));
        }
    }

    /* loaded from: classes4.dex */
    public class u implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public u() {
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            if (z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    PbFragment.this.N0.L(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && PbFragment.this.t0 != null && PbFragment.this.t0.B0() != null && PbFragment.this.t0.B0().b() != null) {
                    PbFragment.this.t0.B0().b().D();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = PbFragment.this;
                    pbFragment.B5(pbFragment.T0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u0 extends HttpMessageListener {
        public u0(int i, boolean z) {
            super(i, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (PbFragment.this.t0 != null) {
                PbFragment pbFragment = PbFragment.this;
                pbFragment.hideLoadingView(pbFragment.t0.M0());
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
                        PbFragment.this.I5(type);
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

    /* loaded from: classes4.dex */
    public class u1 implements View.OnLongClickListener {
        public u1() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PbFragment pbFragment = PbFragment.this;
            pbFragment.f19548f = true;
            return pbFragment.Y3(view);
        }
    }

    /* loaded from: classes4.dex */
    public class v implements Handler.Callback {
        public v() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 2 && PbFragment.this.m0 != null && PbFragment.this.m0.k0()) {
                PbFragment.this.j5();
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class v0 implements a.InterfaceC1065a {
        public v0() {
        }

        @Override // d.b.h0.h.a.InterfaceC1065a
        public void a(boolean z, boolean z2, String str) {
            PbFragment.this.t0.t2();
            if (z) {
                if (PbFragment.this.o0 != null) {
                    PbFragment.this.o0.h(z2);
                }
                PbFragment.this.m0.T1(z2);
                if (PbFragment.this.m0.k0()) {
                    PbFragment.this.j5();
                } else {
                    PbFragment.this.t0.b1(PbFragment.this.m0.y0());
                }
                if (z2) {
                    if (PbFragment.this.o0 != null) {
                        if (PbFragment.this.o0.f() == null || PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || PbFragment.this.m0.y0().L() == null || PbFragment.this.m0.y0().L().T() == null) {
                            return;
                        }
                        MarkData f2 = PbFragment.this.o0.f();
                        MetaData T = PbFragment.this.m0.y0().L().T();
                        if (f2 != null && T != null) {
                            if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), T.getUserId()) && !T.hadConcerned()) {
                                PbFragment.this.R5(T);
                            } else {
                                PbFragment.this.showToast(R.string.add_mark_on_pb);
                                if (d.b.h0.s.h.a.e(PbFragment.this.getContext(), 0)) {
                                    d.b.h0.s.h.a.g(PbFragment.this.getPageContext(), 6, 2000L);
                                }
                            }
                        } else {
                            PbFragment pbFragment = PbFragment.this;
                            pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                        }
                    }
                    PbFragment.this.O3();
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

    /* loaded from: classes4.dex */
    public class v1 implements NoNetworkView.b {
        public v1() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (!PbFragment.this.k && z && !PbFragment.this.m0.o0()) {
                PbFragment.this.y5();
            }
            PbFragment pbFragment = PbFragment.this;
            pbFragment.setNetRefreshViewEmotionMarginTop(d.b.b.e.p.l.g(pbFragment.getContext(), R.dimen.ds360));
        }
    }

    /* loaded from: classes4.dex */
    public class w implements CheckRealNameModel.b {
        public w() {
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            PbFragment.this.t0.S0();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    Integer num = 0;
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    }
                    PbFragment.this.W5(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    d.b.i0.w0.a.d();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f19665e;

        public w0(MetaData metaData) {
            this.f19665e = metaData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f19665e.getUserId()).param("obj_locate", 2));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class w1 implements d.b.b.e.k.c<LinearLayout> {
        public w1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        public LinearLayout e(LinearLayout linearLayout) {
            return linearLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            linearLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
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

    /* loaded from: classes4.dex */
    public class x implements m2 {
        public x() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.m2
        public void a(Object obj) {
            if (!d.b.b.e.p.j.z()) {
                PbFragment.this.showToast(R.string.network_not_available);
                return;
            }
            Object[] objArr = (Object[]) obj;
            PbFragment.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.m0.y0().l().getId(), PbFragment.this.m0.y0().l().getName(), PbFragment.this.m0.y0().L().o0(), String.valueOf(PbFragment.this.m0.y0().Q().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
        }
    }

    /* loaded from: classes4.dex */
    public class x0 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f19669e;

        public x0(MetaData metaData) {
            this.f19669e = metaData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f19669e.getUserId()).param("obj_locate", 1));
            aVar.dismiss();
            PbFragment.this.q0.m(!this.f19669e.hadConcerned(), this.f19669e.getPortrait(), this.f19669e.getUserId(), this.f19669e.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.m0.getForumId(), "0");
        }
    }

    /* loaded from: classes4.dex */
    public class x1 implements View.OnTouchListener {
        public x1() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.f19550h.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class y implements c.a {
        public y() {
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                if (view != null) {
                    if (view.getId() == R.id.richText) {
                        if (PbFragment.this.A5(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.a6((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.t0.i1() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.getEventController() != null && PbFragment.this.getEventController().f52995b != null) {
                                PbFragment.this.getEventController().f52995b.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                        if (sparseArray == null) {
                            return false;
                        }
                        PbFragment.this.a6(sparseArray);
                    }
                }
                if (PbFragment.this.N0 != null) {
                    PbFragment.this.t0.Z1(PbFragment.this.N0.C());
                }
                PbFragment.this.t0.S1();
                PbFragment.this.t0.T();
                return true;
            }
            return true;
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.e4();
                return true;
            }
            return true;
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class y0 implements AbsListView.OnScrollListener {
        public y0() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> D;
            if (PbFragment.this.m0 == null || PbFragment.this.m0.y0() == null || PbFragment.this.t0 == null || PbFragment.this.t0.e0() == null) {
                return;
            }
            PbFragment.this.t0.A1(absListView, i, i2, i3);
            if (PbFragment.this.i != null) {
                PbFragment.this.i.q(absListView, i, i2, i3);
            }
            if (!PbFragment.this.m0.Z0() || (D = PbFragment.this.m0.y0().D()) == null || D.isEmpty()) {
                return;
            }
            int v = ((i + i2) - PbFragment.this.t0.e0().v()) - 1;
            d.b.i0.c2.h.e y0 = PbFragment.this.m0.y0();
            if (y0 == null) {
                return;
            }
            if (y0.B() != null && y0.B().A0()) {
                v--;
            }
            if (y0.C() != null && y0.C().A0()) {
                v--;
            }
            int size = D.size();
            if (v < 0 || v >= size) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            PbFragment pbFragment = PbFragment.this;
            if (!pbFragment.b5(pbFragment.X0) && PbFragment.this.b5(i)) {
                if (PbFragment.this.t0 != null) {
                    PbFragment.this.t0.T();
                    if (PbFragment.this.N0 != null && !PbFragment.this.t0.d1()) {
                        PbFragment.this.t0.Z1(PbFragment.this.N0.C());
                    }
                    if (!PbFragment.this.L) {
                        PbFragment.this.t0.S1();
                    }
                }
                if (!PbFragment.this.x) {
                    PbFragment.this.x = true;
                }
            }
            if (PbFragment.this.t0 != null) {
                PbFragment.this.t0.B1(absListView, i);
            }
            if (PbFragment.this.i != null) {
                PbFragment.this.i.r(absListView, i);
            }
            if (PbFragment.this.y == null) {
                PbFragment.this.y = new d.b.h0.m0.b();
                PbFragment.this.y.a(1001);
            }
            if (i == 0) {
                PbFragment.this.y.e();
            } else {
                PbFragment.this.y.d();
            }
            PbFragment.this.X0 = i;
            if (i == 0) {
                PbFragment.this.D5(false, null);
                d.b.i0.b3.c.g().h(PbFragment.this.getUniqueId(), true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y1 implements l2 {
        public y1() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.l2
        public boolean onBackPressed() {
            if (PbFragment.this.t0 != null && PbFragment.this.t0.B0() != null) {
                d.b.i0.c2.k.e.s B0 = PbFragment.this.t0.B0();
                if (B0.f()) {
                    B0.d();
                    return true;
                }
            }
            if (PbFragment.this.t0 == null || !PbFragment.this.t0.p1()) {
                return false;
            }
            PbFragment.this.t0.V0();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class z implements b.c {
        public z() {
        }

        @Override // d.b.h0.r.s.b.c
        public void a(d.b.h0.r.s.b bVar, int i, View view) {
            if (i == 0) {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                PbFragment pbFragment = PbFragment.this;
                pbFragment.A0 = pbFragment.A0.trim();
                UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.A0);
                new d.b.i0.c2.k.e.b(PbFragment.this.m0.O0(), PbFragment.this.A0, "1").start();
                bVar.e();
            } else if (i == 1) {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                PbFragment pbFragment2 = PbFragment.this;
                pbFragment2.A0 = pbFragment2.A0.trim();
                UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.A0);
                new d.b.i0.c2.k.e.b(PbFragment.this.m0.O0(), PbFragment.this.A0, "2").start();
                bVar.e();
            } else if (i == 2) {
                PbFragment pbFragment3 = PbFragment.this;
                pbFragment3.A0 = pbFragment3.A0.trim();
                UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.A0);
                bVar.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z0 implements AntiHelper.k {
        public z0() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }
    }

    /* loaded from: classes4.dex */
    public class z1 implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final int f19677a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        public z1() {
        }

        @Override // d.b.i0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.i0.f0.a.b
        public void b(int i, int i2) {
            if (!e(i2) || PbFragment.this.t0 == null || PbFragment.this.i == null) {
                return;
            }
            PbFragment.this.i.u(true);
            if (Math.abs(i2) > this.f19677a) {
                PbFragment.this.i.l();
            }
            if (PbFragment.this.v4()) {
                PbFragment.this.t0.T0();
                PbFragment.this.t0.U1();
            }
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            if (!e(i2) || PbFragment.this.t0 == null || PbFragment.this.i == null) {
                return;
            }
            PbFragment.this.t0.S2();
            PbFragment.this.i.u(false);
            PbFragment.this.i.x();
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }

        public final boolean e(float f2) {
            return Math.abs(f2) >= 1.0f;
        }
    }

    public static PbFragment o5() {
        return new PbFragment();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.q
    public void A0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (d.b.h0.b1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d.b.h0.b1.m.f.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (d.b.i0.c2.k.e.v0.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new d.b.h0.b1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public int A4() {
        return this.u2;
    }

    public final boolean A5(View view) {
        PbModel pbModel;
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.q0 && !TextUtils.isEmpty(postData.t()) && d.b.h0.r.k.c().g()) {
                    return n5(postData.D());
                }
                if (checkUpIsLogin() && (pbModel = this.m0) != null && pbModel.y0() != null) {
                    if (G4().B0() != null) {
                        G4().B0().c();
                    }
                    d.b.i0.c2.h.q qVar = new d.b.i0.c2.h.q();
                    qVar.A(this.m0.y0().l());
                    qVar.E(this.m0.y0().L());
                    qVar.C(postData);
                    G4().A0().E(qVar);
                    G4().A0().setPostId(postData.D());
                    i5(view, postData.s().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    d.b.h0.w.w.e eVar = this.N0;
                    if (eVar != null) {
                        this.t0.Z1(eVar.C());
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final String B4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return null;
        }
        return tbRichTextData.x().w();
    }

    public final void B5(EmotionImageData emotionImageData) {
        if (emotionImageData == null) {
            return;
        }
        if (this.S == null) {
            d.b.i0.c2.k.e.y0.f.a aVar = new d.b.i0.c2.k.e.y0.f.a(this.f19547e);
            this.S = aVar;
            aVar.n(this.U0);
            this.S.m(this.V1);
        }
        this.S.k(emotionImageData, L(), L().y0());
    }

    public final long C4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return 0L;
        }
        return tbRichTextData.x().getOriginalSize();
    }

    public final void C5() {
        PbModel pbModel = this.m0;
        if (pbModel == null || pbModel.y0() == null || this.m0.y0().L() == null || !this.m0.y0().L().y2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public d.b.h0.w.w.e D4() {
        return this.N0;
    }

    public final void D5(boolean z3, PostData postData) {
        d.b.i0.c2.k.e.q0 q0Var;
        d.b.i0.c2.k.e.g e02;
        ArrayList<PostData> D;
        String str;
        String str2;
        String str3;
        String str4;
        d.b.h0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense == null || !adAdSense.h() || (q0Var = this.t0) == null || (e02 = q0Var.e0()) == null || (D = e02.D()) == null) {
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
            String D2 = next.D();
            i3++;
            if (z3) {
                if (next == postData) {
                    a.c cVar = new a.c();
                    cVar.f53451b = D2;
                    cVar.f53452c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.E == 1 && !TextUtils.isEmpty(D2)) {
                next.E = 2;
                a.c cVar2 = new a.c();
                cVar2.f53451b = D2;
                cVar2.f53452c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.m0;
            if (pbModel == null || pbModel.y0() == null || this.m0.y0().l() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.m0.y0().l().getFirst_class();
                str2 = this.m0.y0().l().getSecond_class();
                str3 = this.m0.y0().l().getId();
                str4 = this.m0.O0();
                str = first_class;
            }
            d.b.i0.r2.t.v(z3, str, str2, str3, str4, arrayList, adAdSense.j());
        }
    }

    public d.b.i0.c2.k.e.z0.b E4() {
        return this.i;
    }

    public final void E5() {
        PbModel pbModel = this.m0;
        if (pbModel == null || pbModel.y0() == null || this.m0.y0().L() == null || !this.m0.y0().L().y2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public final int F4(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return i3 != 3 ? 1 : 7;
            }
            return 6;
        }
        return 5;
    }

    public final void F5(int i3) {
        if (this.m0 != null) {
            U5();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
            privacySettingMessage.setTid(this.m0.f19731e);
            sendMessage(privacySettingMessage);
        }
    }

    public d.b.i0.c2.k.e.q0 G4() {
        return this.t0;
    }

    public void G5(boolean z3) {
        this.P = z3;
    }

    public d.b.h0.r.q.k1 H4() {
        return this.e0;
    }

    public final void H5(d.b.h0.w.w.g gVar) {
        PbModel pbModel;
        if (gVar == null || (pbModel = this.m0) == null) {
            return;
        }
        gVar.o(pbModel.a0());
        if (this.m0.y0() != null && this.m0.y0().l() != null) {
            gVar.n(this.m0.y0().l());
        }
        gVar.p("pb");
        gVar.q(this.m0);
    }

    @Override // d.b.i0.c2.o.b
    public VideoPbFragment I() {
        return null;
    }

    public String I4() {
        return this.Y;
    }

    public final void I5(int i3) {
        PbModel pbModel = this.m0;
        if (pbModel == null) {
            return;
        }
        int H0 = pbModel.H0();
        if (i3 == 5) {
            this.m0.Q1(2);
        } else if (i3 == 6) {
            this.m0.Q1(3);
        } else if (i3 != 7) {
            this.m0.Q1(1);
        } else {
            this.m0.Q1(4);
        }
        int H02 = this.m0.H0();
        if (H0 == 4 || H02 == 4) {
            p5();
        }
    }

    public final int J4(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return 0;
        }
        if (eVar.L().s1() == 0) {
            return 1;
        }
        if (eVar.L().s1() == 54) {
            return 2;
        }
        return eVar.L().s1() == 40 ? 3 : 4;
    }

    public void J5(boolean z3) {
        this.M = z3;
    }

    public String K4() {
        return this.R;
    }

    public final void K5(boolean z3) {
        this.N0.f0(z3);
        this.N0.i0(z3);
        this.N0.p0(z3);
    }

    @Override // d.b.i0.c2.o.b
    public PbModel L() {
        return this.m0;
    }

    public void L4() {
        if (this.k) {
            this.Q = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.m0.y0() == null || this.m0.y0().L() == null || this.m0.y0().L().o1() == null) {
        } else {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.m0.y0().L().o1().g(), this.m0.y0().L().o1().f(), this.m0.y0().L().o1().b(), this.m0.y0().L().o1().c(), this.m0.y0().L().x0(), this.m0.y0().L().w0())));
            this.f19547e.finish();
        }
    }

    public final void L5(int i3, AntiData antiData, String str) {
        if (AntiHelper.m(i3, str)) {
            if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new z0()) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        } else if (i3 == 230277) {
            X5(str);
        } else {
            this.t0.Y2(str);
        }
    }

    public void M3(l2 l2Var) {
        if (l2Var != null) {
            if (this.k1 == null) {
                this.k1 = new ArrayList();
            }
            if (this.k1.contains(l2Var)) {
                return;
            }
            this.k1.add(l2Var);
        }
    }

    public final void M4(int i3, Intent intent) {
        d.b.h0.w.n nVar;
        d.b.h0.w.n nVar2;
        if (i3 == 0) {
            this.t0.Q0();
            this.t0.B0().c();
            this.t0.F2(false);
        }
        this.t0.S1();
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
                if (editorType != 1 || this.t0.B0() == null || this.t0.B0().b() == null) {
                    return;
                }
                d.b.h0.w.w.h b3 = this.t0.B0().b();
                b3.X(this.m0.y0().L());
                b3.z(writeData);
                b3.Y(pbEditorData.getVoiceModel());
                d.b.h0.w.m n3 = b3.a().n(6);
                if (n3 != null && (nVar2 = n3.k) != null) {
                    nVar2.onAction(new d.b.h0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    b3.D();
                    return;
                }
                return;
            }
            this.N0.S();
            this.N0.t0(pbEditorData.getVoiceModel());
            this.N0.G(writeData);
            d.b.h0.w.m n4 = this.N0.a().n(6);
            if (n4 != null && (nVar = n4.k) != null) {
                nVar.onAction(new d.b.h0.w.a(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i3 == -1) {
                this.N0.L(null, null);
            }
        }
    }

    public final void M5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (G4() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    d.b.h0.s.h.b.a(getPageContext(), postWriteCallBackData);
                    return;
                } else {
                    d.b.i0.c3.q0.g.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.m0.m0()) {
            antiData.setBlock_forum_name(this.m0.y0().l().getName());
            antiData.setBlock_forum_id(this.m0.y0().l().getId());
            antiData.setUser_name(this.m0.y0().Q().getUserName());
            antiData.setUser_id(this.m0.y0().Q().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void N3(l2 l2Var) {
        if (l2Var != null) {
            if (this.k1 == null) {
                this.k1 = new ArrayList();
            }
            if (this.k1.contains(l2Var)) {
                return;
            }
            this.k1.add(0, l2Var);
        }
    }

    public void N4(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
        String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
        String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
        String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
        String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.b1);
        userMuteAddAndDelCustomMessage.setTag(this.b1);
        Y5(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public final void N5(long j3, String str, long j4) {
        d.b.i0.c2.k.e.b1.b.j(this, j3, str, j4);
    }

    public final void O3() {
        d.b.i0.c2.h.e eVar;
        PbModel pbModel = this.m0;
        if (pbModel == null || (eVar = pbModel.I) == null || eVar.L() == null) {
            return;
        }
        d.b.h0.r.q.a2 L = this.m0.I.L();
        L.T0 = this.m0.D0();
        L.S0 = this.m0.G0();
        L.R0 = this.m0.F0();
        L.U0 = this.m0.E0();
        L.z2 = this.m0.m0();
        if (L.c0() == 0) {
            L.t3(d.b.b.e.m.b.f(this.m0.getForumId(), 0L));
        }
        StatisticItem i3 = d.b.h0.j0.c.i(getContext(), L, "c13562");
        TbPageTag l3 = d.b.h0.j0.c.l(getContext());
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

    public final void O4(String str) {
        PbModel pbModel = this.m0;
        if (pbModel != null && pbModel.y0() != null && this.m0.y0().Z()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.m0.O0(), str);
            d.b.h0.r.q.a2 L = this.m0.y0().L();
            if (L.O1()) {
                format = format + "&channelid=33833";
            } else if (L.T1()) {
                format = format + "&channelid=33842";
            } else if (L.R1()) {
                format = format + "&channelid=33840";
            }
            d5(format);
            return;
        }
        this.n0.i(str);
    }

    public final boolean O5(boolean z3) {
        d.b.h0.r.q.d0 d0Var;
        int i3;
        PbModel pbModel = this.m0;
        if (pbModel == null || pbModel.y0() == null) {
            return false;
        }
        d.b.i0.c2.h.e y02 = this.m0.y0();
        d.b.h0.r.q.a2 L = y02.L();
        if (L != null) {
            if (L.O1() || L.R1()) {
                return false;
            }
            if (L.P1() || L.Q1()) {
                return z3;
            }
        }
        if (z3) {
            return true;
        }
        if (L == null || L.T() == null || !L.T().isForumBusinessAccount() || d.b.i0.p0.w0.isOn()) {
            if (y02.l() == null || !y02.l().isBlockBawuDelete) {
                if (y02.R() != 0) {
                    return y02.R() != 3;
                }
                List<d.b.h0.r.q.w1> p2 = y02.p();
                if (ListUtils.getCount(p2) > 0) {
                    for (d.b.h0.r.q.w1 w1Var : p2) {
                        if (w1Var != null && (d0Var = w1Var.f50922g) != null && d0Var.f50757a && !d0Var.f50759c && ((i3 = d0Var.f50758b) == 1 || i3 == 2)) {
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

    @Override // d.b.i0.c2.o.b
    public PbActivity P() {
        return this.f19547e;
    }

    public final void P3(boolean z3) {
        d.b.i0.c2.h.e eVar;
        PbModel pbModel = this.m0;
        if (pbModel == null || (eVar = pbModel.I) == null || eVar.L() == null) {
            return;
        }
        d.b.h0.r.q.a2 L = this.m0.I.L();
        L.T0 = this.m0.D0();
        L.S0 = this.m0.G0();
        L.R0 = this.m0.F0();
        L.U0 = this.m0.E0();
        if (L.c0() == 0) {
            L.t3(d.b.b.e.m.b.f(this.m0.getForumId(), 0L));
        }
        StatisticItem i3 = d.b.h0.j0.c.i(getContext(), L, "c13563");
        TbPageTag l3 = d.b.h0.j0.c.l(getContext());
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
            if (z3) {
                i3.param("obj_type", 2);
            } else {
                i3.param("obj_type", 1);
            }
            d.b.h0.i0.c k3 = TbPageExtraHelper.k(getContext());
            if (k3 != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, k3.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i3);
        }
    }

    public final void P4(Intent intent) {
        d.b.i0.c2.k.e.b1.b.i(this, intent);
    }

    public final boolean P5(boolean z3) {
        PbModel pbModel;
        if (z3 || (pbModel = this.m0) == null || pbModel.y0() == null || (this.m0.y0().l() != null && this.m0.y0().l().isBlockBawuDelete)) {
            return false;
        }
        d.b.i0.c2.h.e y02 = this.m0.y0();
        return ((y02.L() != null && y02.L().T() != null && y02.L().T().isForumBusinessAccount() && !d.b.i0.p0.w0.isOn()) || this.m0.y0().R() == 0 || this.m0.y0().R() == 3) ? false : true;
    }

    public final void Q3(d.b.i0.c2.h.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar == null || eVar.P() == null || eVar.P().f52471a == null || (list = eVar.P().f52471a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.D()) && !TextUtils.isEmpty(postData.D()) && next.D().equals(postData.D())) {
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

    public void Q4() {
        if (this.f19547e == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.f19547e.getCurrentFocus() == null) {
            return;
        }
        d.b.b.e.p.l.w(getPageContext().getPageActivity(), this.f19547e.getCurrentFocus());
    }

    public final boolean Q5() {
        PbModel pbModel = this.m0;
        if (pbModel != null && pbModel.M0()) {
            return this.m0.w0() == null || this.m0.w0().c() != 0;
        }
        return false;
    }

    public final boolean R3() {
        PbModel pbModel = this.m0;
        if (pbModel == null || pbModel.y0() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.m0.y0().L()) || AntiHelper.d(getPageContext(), this.m0.y0().d());
    }

    public void R4() {
        d.b.i0.c2.k.e.q0 q0Var = this.t0;
        if (q0Var != null) {
            q0Var.Q0();
            Q4();
        }
    }

    public final void R5(MetaData metaData) {
        if (metaData == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getActivity());
        aVar.setTitle(getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(getResources().getString(R.string.mark_like_cancel), new w0(metaData));
        aVar.setPositiveButton(getResources().getString(R.string.mark_like_confirm), new x0(metaData));
        aVar.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final boolean S3(int i3) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
            return false;
        }
        return true;
    }

    public final void S4(int i3) {
        d.b.h0.z0.h0.b(new h2(), new i2(i3));
        StatisticItem statisticItem = new StatisticItem("c13833");
        statisticItem.param("obj_locate", 1);
        if (i3 == 3) {
            statisticItem.param("obj_type", 1);
        } else if (i3 == 8) {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void S5() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessage(getResources().getString(R.string.mute_is_super_member_function));
        aVar.setPositiveButton(R.string.open_now, new c2());
        aVar.setNegativeButton(R.string.cancel, new d2());
        aVar.create(this.Z0).show();
    }

    public void T3(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.t0.M2();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = d.b.b.e.m.b.f(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = d.b.b.e.m.b.f((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        BdUniqueId bdUniqueId = this.b1;
        userMuteCheckCustomMessage.mId = bdUniqueId;
        userMuteCheckCustomMessage.setTag(bdUniqueId);
        this.Y0 = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public final void T4(Bundle bundle) {
        d.b.h0.h.a c3 = d.b.h0.h.a.c(this.f19547e);
        this.o0 = c3;
        if (c3 != null) {
            c3.j(this.b2);
        }
        ForumManageModel forumManageModel = new ForumManageModel(this.f19547e);
        this.p0 = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.d2);
        this.q0 = new d.b.h0.s.e.a(getPageContext());
        this.F1.setUniqueId(getUniqueId());
        this.F1.registerListener();
    }

    public final void T5(boolean z3, SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            d.b.h0.r.s.j jVar = this.y0;
            if (jVar != null && jVar.isShowing()) {
                this.y0.dismiss();
                this.y0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                d.b.h0.r.s.l lVar = new d.b.h0.r.s.l(getContext());
                lVar.n(new q(sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new d.b.h0.r.s.h(0, getResources().getString(R.string.delete), lVar));
                }
                if (z3) {
                    arrayList.add(new d.b.h0.r.s.h(1, getResources().getString(R.string.un_mute), lVar));
                } else {
                    arrayList.add(new d.b.h0.r.s.h(1, getResources().getString(R.string.mute), lVar));
                }
                lVar.k(arrayList);
                d.b.h0.r.s.j jVar2 = new d.b.h0.r.s.j(getPageContext(), lVar);
                this.y0 = jVar2;
                jVar2.l();
            }
        }
    }

    public boolean U3() {
        if ((this.m0.y0() != null && (this.m0.y0().Z() || ThreadCardUtils.isSelf(this.m0.y0().L()))) || this.Q0 == null || this.m0.y0() == null || this.m0.y0().d() == null) {
            return true;
        }
        return this.Q0.checkPrivacyBeforeInvokeEditor(this.m0.y0().d().replyPrivateFlag);
    }

    public final void U4() {
        this.T = new LikeModel(getPageContext());
    }

    public final void U5() {
        showLoadingView(this.t0.M0(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View i3 = getLoadingView().i();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) i3.getLayoutParams();
        layoutParams.addRule(3, this.t0.L0().getId());
        i3.setLayoutParams(layoutParams);
    }

    public boolean V3(int i3) {
        if (this.Q0 == null || this.m0.y0() == null || ThreadCardUtils.isSelf(this.m0.y0().L()) || this.m0.y0().d() == null) {
            return true;
        }
        return this.Q0.checkPrivacyBeforeSend(this.m0.y0().d().replyPrivateFlag, i3);
    }

    public final void V4() {
        if (this.q != null) {
            return;
        }
        this.q = new d.b.h0.r.s.b(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        d.b.h0.r.s.b bVar = this.q;
        bVar.j(strArr, new z());
        bVar.g(b.C1089b.f50979a);
        bVar.h(17);
        bVar.c(getPageContext());
    }

    public final void V5(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && L() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            L().K(postWriteCallBackData.getPostId());
            int i02 = this.t0.i0();
            this.i1 = i02;
            this.m0.H1(i02, this.t0.o0());
        }
        this.t0.T();
        this.x0.c();
        d.b.h0.w.w.e eVar = this.N0;
        if (eVar != null) {
            this.t0.Z1(eVar.C());
        }
        this.t0.Q0();
        this.t0.F2(true);
        this.m0.V0();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W3(AgreeData agreeData) {
        d.b.h0.i0.c k3;
        PbModel pbModel;
        if (agreeData == null) {
            return;
        }
        if (this.g0 == null) {
            this.g0 = new d.b.h0.r.b0.a();
        }
        if (this.i0 == null) {
            d.b.i0.c3.h0.e eVar = new d.b.i0.c3.h0.e();
            this.i0 = eVar;
            eVar.f53376a = getUniqueId();
        }
        d.b.h0.r.q.e eVar2 = new d.b.h0.r.q.e();
        eVar2.f50763b = 5;
        eVar2.f50769h = 8;
        eVar2.f50768g = 2;
        if (L() != null) {
            eVar2.f50767f = L().x0();
        }
        eVar2.f50762a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                eVar2.i = 0;
                k3 = TbPageExtraHelper.k(getContext());
                if (k3 != null) {
                    agreeData.objSource = k3.a();
                }
                this.g0.c(agreeData, i3, getUniqueId(), false);
                this.g0.d(agreeData, this.i0);
                pbModel = this.m0;
                if (pbModel != null || pbModel.y0() == null) {
                }
                this.g0.b(P(), eVar2, agreeData, this.m0.y0().L());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            eVar2.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            eVar2.i = 1;
        }
        i3 = 0;
        k3 = TbPageExtraHelper.k(getContext());
        if (k3 != null) {
        }
        this.g0.c(agreeData, i3, getUniqueId(), false);
        this.g0.d(agreeData, this.i0);
        pbModel = this.m0;
        if (pbModel != null) {
        }
    }

    public boolean W4() {
        PbModel pbModel = this.m0;
        if (pbModel != null) {
            return pbModel.e0();
        }
        return false;
    }

    public final void W5(int i3) {
        d.b.i0.c2.k.e.b1.b.m(this, k4(), i3);
    }

    public final void X3() {
        if (this.m0.e0() || this.m0.h0()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.m0.O0());
            this.f19547e.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.m0.O0()));
        if (e6()) {
            this.f19547e.finish();
        }
    }

    public final boolean X4() {
        PostData c3 = d.b.i0.c2.h.f.c(this.m0.y0(), this.m0.M0(), this.m0.I0());
        return (c3 == null || c3.s() == null || c3.s().getGodUserData() == null || c3.s().getGodUserData().getType() != 2) ? false : true;
    }

    public final void X5(String str) {
        if (str == null) {
            str = "";
        }
        d.b.b.a.f fVar = this.Z0;
        if (fVar == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(fVar.getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new e2());
        aVar.create(this.Z0).show();
    }

    @Override // d.b.i0.c2.p.a.b
    public void Y(boolean z3) {
        this.C0 = z3;
    }

    public final boolean Y3(View view) {
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        List<d.b.h0.r.s.h> b3;
        d.b.h0.r.s.h hVar;
        d.b.h0.r.s.h hVar2;
        d.b.h0.r.s.h hVar3;
        d.b.h0.r.s.h hVar4;
        d.b.b.j.d.a aVar;
        SparseArray sparseArray2;
        if (isAdded()) {
            d.b.i0.c2.k.e.q0 q0Var = this.t0;
            if (q0Var != null) {
                if (q0Var.f1()) {
                    return true;
                }
                this.t0.c0();
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e3) {
                e3.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (Z4(view)) {
                    if (view instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view;
                        this.e1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.f1 = url;
                        if (this.e1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.g1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.g1 = null;
                        }
                    } else if (view instanceof GifView) {
                        GifView gifView = (GifView) view;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.e1 = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.f1 = gifView.getBdImage().q();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.g1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.g1 = null;
                        }
                    } else if (view instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.e1 = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.f1 = tbMemeImageView.getBdImage().q();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.g1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.g1 = null;
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
                        this.t0.P2(this.n2, this.e1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            this.l2 = postData;
            if (postData == null) {
                return true;
            }
            if (postData.z() == 1 && Z4(view)) {
                this.t0.P2(this.n2, this.e1.t());
                return true;
            }
            d.b.h0.h.a aVar2 = this.o0;
            if (aVar2 == null) {
                return true;
            }
            boolean z5 = aVar2.e() && this.l2.D() != null && this.l2.D().equals(this.m0.t0());
            boolean z6 = L().y0() != null && L().y0().Z();
            if (this.l2.z() == 1) {
                if (!z6) {
                    this.t0.Q2(this.m2, z5, false);
                }
                return true;
            }
            if (this.z0 == null) {
                d.b.h0.r.s.l lVar = new d.b.h0.r.s.l(getContext());
                this.z0 = lVar;
                lVar.n(this.R1);
            }
            ArrayList arrayList = new ArrayList();
            if (view == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Z4(view) && !z6;
            boolean z8 = (!Z4(view) || (aVar = this.e1) == null || aVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (z7) {
                z4 = booleanValue6;
                z3 = booleanValue5;
                arrayList.add(new d.b.h0.r.s.h(1, getString(R.string.save_to_emotion), this.z0));
            } else {
                z3 = booleanValue5;
                z4 = booleanValue6;
            }
            if (z8) {
                arrayList.add(new d.b.h0.r.s.h(2, getString(R.string.save_to_local), this.z0));
            }
            if (!z7 && !z8) {
                d.b.h0.r.s.h hVar5 = new d.b.h0.r.s.h(3, getString(R.string.copy), this.z0);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.l2);
                hVar5.f51005d.setTag(sparseArray3);
                arrayList.add(hVar5);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    hVar4 = new d.b.h0.r.s.h(4, getString(R.string.remove_mark), this.z0);
                } else {
                    hVar4 = new d.b.h0.r.s.h(4, getString(R.string.mark), this.z0);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.l2);
                sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                hVar4.f51005d.setTag(sparseArray4);
                arrayList.add(hVar4);
            }
            if (this.mIsLogin && !this.j0) {
                if (!d.b.i0.c2.k.e.b1.a.h(this.m0) && !booleanValue4 && booleanValue3) {
                    d.b.h0.r.s.h hVar6 = new d.b.h0.r.s.h(5, getString(R.string.mute_option), this.z0);
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
                    hVar6.f51005d.setTag(sparseArray5);
                    arrayList.add(hVar6);
                } else {
                    if ((c5(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        d.b.h0.r.s.h hVar7 = new d.b.h0.r.s.h(5, getString(R.string.report_text), this.z0);
                        hVar7.f51005d.setTag(str);
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
                    if (!d.b.i0.c2.k.e.b1.a.h(this.m0) && z3) {
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
                    if (z4) {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i23 = R.id.tag_del_post_id;
                        sparseArray6.put(i23, sparseArray.get(i23));
                        int i24 = R.id.tag_del_post_type;
                        sparseArray6.put(i24, sparseArray.get(i24));
                        int i25 = R.id.tag_has_sub_post;
                        sparseArray6.put(i25, sparseArray.get(i25));
                        hVar2 = new d.b.h0.r.s.h(6, getString(R.string.delete), this.z0);
                        hVar2.f51005d.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        hVar2 = null;
                    }
                    hVar = new d.b.h0.r.s.h(7, getString(R.string.bar_manager), this.z0);
                    hVar.f51005d.setTag(sparseArray6);
                } else if (z4) {
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
                    if (this.m0.y0().R() == 1002 && !booleanValue2) {
                        hVar3 = new d.b.h0.r.s.h(6, getString(R.string.report_text), this.z0);
                    } else {
                        hVar3 = new d.b.h0.r.s.h(6, getString(R.string.delete), this.z0);
                    }
                    hVar3.f51005d.setTag(sparseArray7);
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
                d.b.i0.c2.k.e.b1.a.a(arrayList, this.z0, this.l2, this.m0);
            }
            if (d.b.h0.b.d.y()) {
                b3 = d.b.i0.c2.k.e.b1.a.c(arrayList, this.l2.q(), sparseArray, this.z0);
            } else {
                b3 = d.b.i0.c2.k.e.b1.a.b(arrayList, this.l2.q(), sparseArray, this.z0);
            }
            d.b.i0.c2.k.e.b1.a.k(b3, this.f19548f);
            d.b.i0.c2.k.e.b1.a.e(b3);
            this.z0.o(d.b.i0.c2.k.e.b1.a.f(this.l2));
            if (d.b.h0.b.d.y()) {
                this.z0.l(b3, false);
            } else {
                this.z0.l(b3, true);
            }
            d.b.h0.r.s.j jVar = new d.b.h0.r.s.j(getPageContext(), this.z0);
            this.y0 = jVar;
            jVar.l();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.m0.f19731e).param("fid", this.m0.getForumId()).param("uid", this.m0.y0().L().T().getUserId()).param("post_id", this.m0.s()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return true;
    }

    public boolean Y4() {
        PbModel pbModel = this.m0;
        if (pbModel != null) {
            return pbModel.d0();
        }
        return false;
    }

    public final void Y5(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z3) {
            this.t0.M2();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.Z0.getPageActivity());
        if (d.b.b.e.p.k.isEmpty(str)) {
            aVar.setMessage(this.Z0.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.setMessage(str);
        }
        aVar.setPositiveButton(R.string.confirm, new f2(userMuteAddAndDelCustomMessage));
        aVar.setNegativeButton(R.string.cancel, new g2());
        aVar.create(this.Z0).show();
    }

    public void Z3(ForumManageModel.b bVar, d.b.i0.c2.k.e.q0 q0Var) {
        List<PostData> list = this.m0.y0().P().f52471a;
        int size = list.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= list.get(i3).L().size()) {
                    break;
                } else if (bVar.f21386g.equals(list.get(i3).L().get(i4).D())) {
                    list.get(i3).L().remove(i4);
                    list.get(i3).n();
                    z3 = true;
                    break;
                } else {
                    i4++;
                }
            }
            list.get(i3).o(bVar.f21386g);
        }
        if (z3) {
            q0Var.b1(this.m0.y0());
        }
    }

    public boolean Z4(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public final void Z5() {
        PbModel pbModel = this.m0;
        if (pbModel == null || d.b.b.e.p.k.isEmpty(pbModel.O0())) {
            return;
        }
        d.b.h0.a.c.y().P(d.b.h0.a.b.W, d.b.b.e.m.b.f(this.m0.O0(), 0L));
    }

    public final void a4(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.i0.c3.h0.o x2 = this.m0.y0().x();
        if (x2 != null && str.equals(x2.A0())) {
            if (x2.B0() != null) {
                x2.B0().legoCard = null;
            }
            this.m0.y0().b();
        }
        d.b.i0.c3.h0.o U = this.m0.U();
        if (U == null || !str.equals(U.A0())) {
            return;
        }
        this.m0.J();
    }

    public boolean a5(int i3) {
        List<ForumToolPerm> forumToolAuth;
        if (i3 == 1) {
            return true;
        }
        if (this.m0.y0().Q() != null && (forumToolAuth = this.m0.y0().Q().getForumToolAuth()) != null) {
            for (int i4 = 0; i4 < forumToolAuth.size(); i4++) {
                ForumToolPerm forumToolPerm = forumToolAuth.get(i4);
                if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a6(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            b6(postData, false);
        }
    }

    public void b4(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        int intValue = ((Integer) sparseArray.get(d.b.i0.c2.k.e.q0.M1)).intValue();
        if (intValue == d.b.i0.c2.k.e.q0.N1) {
            if (this.p0.K()) {
                return;
            }
            this.t0.Z2();
            String str = (String) sparseArray.get(R.id.tag_del_post_id);
            int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            if (jSONArray != null) {
                this.p0.M(StringHelper.JsonArrayToString(jSONArray));
            }
            this.p0.N(this.m0.y0().l().getId(), this.m0.y0().l().getName(), this.m0.y0().L().o0(), str, intValue3, intValue2, booleanValue, this.m0.y0().L().V());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
        } else if (intValue == d.b.i0.c2.k.e.q0.O1 || intValue == d.b.i0.c2.k.e.q0.Q1) {
            if (this.m0.W() != null) {
                this.m0.W().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
            }
            if (intValue == d.b.i0.c2.k.e.q0.O1) {
                TiebaStatic.log("c10499");
            }
        }
    }

    public final boolean b5(int i3) {
        return i3 == 2 || i3 == 1;
    }

    public final void b6(PostData postData, boolean z3) {
        PbModel pbModel;
        if (postData == null || (pbModel = this.m0) == null || pbModel.y0() == null || postData.z() == 1) {
            return;
        }
        String O0 = this.m0.O0();
        String D = postData.D();
        int R = this.m0.y0() != null ? this.m0.y0().R() : 0;
        PbActivity.e t5 = t5(D);
        if (t5 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(O0, D, "pb", true, null, false, null, R, postData.N(), this.m0.y0().d(), false, postData.s() != null ? postData.s().getIconInfo() : null).addBigImageData(t5.f19507a, t5.f19508b, t5.f19513g, t5.j);
        addBigImageData.setKeyPageStartFrom(this.m0.x0());
        addBigImageData.setFromFrsForumId(this.m0.getFromForumId());
        addBigImageData.setKeyFromForumId(this.m0.getForumId());
        addBigImageData.setBjhData(this.m0.T());
        addBigImageData.setIsOpenEditor(z3);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public void c4(d.b.h0.r.s.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (aVar.getYesButtonTag() instanceof SparseArray) {
                b4((SparseArray) aVar.getYesButtonTag(), jSONArray);
                return;
            }
            return;
        }
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
    }

    public final boolean c5(boolean z3) {
        PbModel pbModel = this.m0;
        if (pbModel != null && pbModel.y0() != null) {
            return ((this.m0.y0().R() != 0) || this.m0.y0().L() == null || this.m0.y0().L().T() == null || TextUtils.equals(this.m0.y0().L().T().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
        }
        return false;
    }

    public final void c6() {
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
        PbActivity pbActivity = this.f19547e;
        if (pbActivity != null) {
            pbActivity.stopVoice();
        }
    }

    public void d4(int i3, String str, int i4, boolean z3) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
        sparseArray.put(d.b.i0.c2.k.e.q0.M1, Integer.valueOf(d.b.i0.c2.k.e.q0.N1));
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            b4(sparseArray, null);
        } else {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final void d5(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    public final void d6() {
        this.f19547e.superCloseActivity();
    }

    public void e4() {
        TiebaStatic.log("c12181");
        d.b.i0.c2.k.e.q0 q0Var = this.t0;
        if (q0Var == null || this.m0 == null) {
            return;
        }
        if ((q0Var != null && !q0Var.d1()) || this.m0.y0() == null || this.m0.y0().O() == null) {
            return;
        }
        d.b.i0.c2.h.p O = this.m0.y0().O();
        if (checkUpIsLogin()) {
            if ((!O.g() || O.a() != 2) && this.t0.e0() != null && this.t0.e0().y() != null) {
                this.t0.e0().y().l0(this.m0.O0());
            }
            if (System.currentTimeMillis() - this.B > 2000) {
                new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                this.B = System.currentTimeMillis();
            }
        }
    }

    public final void e5() {
        if (this.x2 != null) {
            if (this.v2 == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.x2.a(), this.v2, 0)));
                this.f19547e.finish();
            }
        }
    }

    public final boolean e6() {
        PbModel pbModel = this.m0;
        if (pbModel == null) {
            return true;
        }
        if (pbModel.y0() == null || !this.m0.y0().Z()) {
            if (this.m0.k0()) {
                MarkData X = this.m0.X();
                if (X != null && this.m0.i0()) {
                    MarkData R = this.m0.R(this.t0.k0());
                    if (R == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", X);
                        this.f19547e.setResult(-1, intent);
                        return true;
                    } else if (R.getPostId() != null && !R.getPostId().equals(X.getPostId())) {
                        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
                        aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                        aVar.setPositiveButton(R.string.confirm, new i1(R, X, aVar));
                        aVar.setNegativeButton(R.string.cancel, new j1(X, aVar));
                        aVar.setOnCalcelListener(new k1(X, aVar));
                        aVar.create(getPageContext());
                        aVar.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", X);
                        this.f19547e.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (this.m0.y0() != null && this.m0.y0().D() != null && this.m0.y0().D().size() > 0 && this.m0.i0()) {
                this.f19547e.setResult(1);
            }
            return true;
        }
        return true;
    }

    public void f4() {
        PbModel pbModel;
        if (this.t0 == null || (pbModel = this.m0) == null) {
            return;
        }
        if ((pbModel.y0() == null && this.m0.y0().O() == null) || !checkUpIsLogin() || this.t0.e0() == null || this.t0.e0().y() == null) {
            return;
        }
        this.t0.e0().y().l0(this.m0.O0());
    }

    public void f5(String str) {
        d.b.i0.c2.k.e.q0 q0Var;
        if (this.m0 == null || StringUtils.isNull(str) || (q0Var = this.t0) == null) {
            return;
        }
        q0Var.e2(true);
        this.m0.j1(str);
        this.K = true;
        this.t0.T();
        this.t0.O0();
    }

    public final void f6(int i3) {
        TiebaStatic.log(new StatisticItem("c14000").param("tid", this.m0.f19731e).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(d.b.i0.c2.k.e.b1.a.m(i3))));
    }

    @Override // d.b.i0.c2.o.b
    public void finish() {
        d.b.i0.c2.k.e.q0 q0Var;
        CardHListViewData q2;
        d.b.i0.c2.k.e.q0 q0Var2 = this.t0;
        if (q0Var2 != null) {
            q0Var2.T();
        }
        PbModel pbModel = this.m0;
        if (pbModel != null && pbModel.y0() != null && !this.m0.y0().Z()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.m0.y0().L().o0();
            if (this.m0.isShareThread() && this.m0.y0().L().r1 != null) {
                historyMessage.threadName = this.m0.y0().L().r1.f13212b;
            } else {
                historyMessage.threadName = this.m0.y0().L().x1();
            }
            if (this.m0.isShareThread() && !isSimpleForum()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.m0.y0().l().getName();
            }
            ArrayList<PostData> D = this.m0.y0().D();
            d.b.i0.c2.k.e.q0 q0Var3 = this.t0;
            int k02 = q0Var3 != null ? q0Var3.k0() : 0;
            if (D != null && k02 >= 0 && k02 < D.size()) {
                historyMessage.postID = D.get(k02).D();
            }
            historyMessage.isHostOnly = this.m0.d0();
            historyMessage.isSquence = this.m0.M0();
            historyMessage.isShareThread = this.m0.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        d.b.h0.w.w.e eVar = this.N0;
        if (eVar != null) {
            eVar.I();
        }
        if (this.n && G4() != null) {
            G4().Y();
        }
        PbModel pbModel2 = this.m0;
        if (pbModel2 != null && (pbModel2.e0() || this.m0.h0())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.m0.O0());
            if (this.u0) {
                if (this.w0) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.m0.n0());
                }
                if (this.v0) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.m0.j0());
                }
            }
            if (this.m0.y0() != null && System.currentTimeMillis() - this.t >= 40000 && (q2 = this.m0.y0().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                intent.putExtra("guess_like_data", q2);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.j1);
            }
            this.f19547e.setResult(-1, intent);
        }
        if (e6()) {
            if (this.m0 != null && (q0Var = this.t0) != null && q0Var.t0() != null) {
                d.b.i0.c2.h.e y02 = this.m0.y0();
                if (y02 != null) {
                    if (y02.Q() != null) {
                        y02.Q().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!y02.b0() && !this.K && y02.f52427h == null) {
                        d.b.i0.c2.k.e.k0.b().n(this.m0.z0(), this.t0.t0().onSaveInstanceState(), this.m0.M0(), this.m0.d0(), this.t0.z0() != null && this.t0.z0().getVisibility() == 0);
                        if (this.i1 >= 0 || this.m0.Q0() != null) {
                            d.b.i0.c2.k.e.k0.b().q(this.m0.Q0());
                            d.b.i0.c2.k.e.k0.b().r(this.m0.R0());
                            d.b.i0.c2.k.e.k0.b().o(this.m0.r0());
                        }
                    }
                }
            } else {
                d.b.i0.c2.k.e.k0.b().m();
            }
            d6();
        }
    }

    public final void g4(String str) {
        PbModel pbModel = this.m0;
        if (pbModel == null || pbModel.y0() == null || this.m0.y0().L() == null || !this.m0.y0().L().x2()) {
            return;
        }
        d.b.h0.r.q.a2 L = this.m0.y0().L();
        int i3 = 0;
        if (L.O1()) {
            i3 = 1;
        } else if (L.R1()) {
            i3 = 2;
        } else if (L.P1()) {
            i3 = 3;
        } else if (L.Q1()) {
            i3 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i3);
        TiebaStatic.log(statisticItem);
    }

    public final void g5(Bundle bundle) {
        PbModel pbModel = this.f19547e.getPbModel();
        this.m0 = pbModel;
        if (pbModel.W() != null) {
            this.m0.W().c(this.t2);
        }
        if (this.m0.u0() != null) {
            this.m0.u0().f(this.p1);
        }
        if (StringUtils.isNull(this.m0.O0())) {
            this.f19547e.finish();
        } else if (!"from_tieba_kuang".equals(this.O) || this.O == null) {
        } else {
            this.m0.N1(6);
        }
    }

    public final void g6() {
        if (!TbadkCoreApplication.isLogin() || !AddExperiencedModel.x(this.m0.getForumId()) || this.m0.y0() == null || this.m0.y0().l() == null) {
            return;
        }
        if (this.m0.y0().l().isLike() == 1) {
            this.m0.O().w(this.m0.getForumId(), this.m0.O0());
        }
    }

    public d.b.i0.c2.k.e.z0.a getEventController() {
        return this.f19547e.getEventController();
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<GifView> getGifViewPool() {
        if (this.N == null) {
            this.N = new d.b.b.e.k.b<>(new m1(), 20, 0);
        }
        return this.N;
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<ImageView> getImageViewPool() {
        if (this.G == null) {
            this.G = new d.b.b.e.k.b<>(new l1(), 8, 0);
        }
        return this.G;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        d.b.b.e.k.b<RelativeLayout> bVar = new d.b.b.e.k.b<>(new p1(), 10, 0);
        this.J = bVar;
        return bVar;
    }

    @Override // d.b.h0.b1.m.h
    public int getRichTextViewId() {
        d.b.i0.c2.k.e.q0 q0Var = this.t0;
        if (q0Var == null) {
            return 0;
        }
        return q0Var.G0();
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<TextView> getTextViewPool() {
        if (this.E == null) {
            this.E = TbRichTextView.w(getPageContext().getPageActivity(), 8);
        }
        return this.E;
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<LinearLayout> getTextVoiceViewPool() {
        if (this.I == null) {
            this.I = new d.b.b.e.k.b<>(new w1(), 15, 0);
        }
        return this.I;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.b.b.e.k.b<TbImageView> getUserIconPool() {
        if (this.F == null) {
            this.F = UserIconBox.c(getPageContext().getPageActivity(), 8);
        }
        return this.F;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        return this.o;
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<View> getVoiceViewPool() {
        if (this.H == null) {
            this.H = new d.b.b.e.k.b<>(new o1(), 8, 0);
        }
        return this.H;
    }

    public final void h4(ForumManageModel.b bVar, boolean z3) {
        if (bVar == null || !isAdded()) {
            return;
        }
        String string = !TextUtils.isEmpty(bVar.f21381b) ? bVar.f21381b : getString(R.string.delete_fail);
        int i3 = 0;
        if (bVar.f21382c == 1211066) {
            hideProgressBar();
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
            aVar.setMessage(string);
            aVar.setPositiveButton(R.string.dialog_known, new b1());
            aVar.setCancelable(true);
            aVar.create(getPageContext());
            aVar.show();
        } else {
            this.t0.b0(0, bVar.f21380a, bVar.f21381b, z3);
        }
        if (bVar.f21380a) {
            int i4 = bVar.f21383d;
            if (i4 == 1) {
                ArrayList<PostData> D = this.m0.y0().D();
                int size = D.size();
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (bVar.f21386g.equals(D.get(i3).D())) {
                        D.remove(i3);
                        break;
                    } else {
                        i3++;
                    }
                }
                this.m0.y0().L().Y3(this.m0.y0().L().Z0() - 1);
                this.t0.b1(this.m0.y0());
            } else if (i4 == 0) {
                X3();
            } else if (i4 == 2) {
                ArrayList<PostData> D2 = this.m0.y0().D();
                int size2 = D2.size();
                boolean z4 = false;
                for (int i5 = 0; i5 < size2 && !z4; i5++) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= D2.get(i5).L().size()) {
                            break;
                        } else if (bVar.f21386g.equals(D2.get(i5).L().get(i6).D())) {
                            D2.get(i5).L().remove(i6);
                            D2.get(i5).n();
                            z4 = true;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    D2.get(i5).o(bVar.f21386g);
                }
                if (z4) {
                    this.t0.b1(this.m0.y0());
                }
                Z3(bVar, this.t0);
            }
        }
    }

    public final void h5() {
        if (this.x2 != null) {
            if (this.u2 == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.x2.a(), this.u2, 0)));
                this.f19547e.finish();
            }
        }
    }

    public final void h6(d.b.h0.r.q.t tVar) {
        if (tVar != null) {
            this.x2 = tVar;
            this.f19549g = true;
            this.t0.P1();
            this.t0.i2(this.w2);
        }
    }

    public final void i4(int i3, ForumManageModel.g gVar) {
        String string;
        if (gVar == null) {
            return;
        }
        this.t0.b0(this.p0.getLoadDataMode(), gVar.f21401a, gVar.f21402b, false);
        if (gVar.f21401a) {
            this.u0 = true;
            if (i3 == 2 || i3 == 3) {
                this.v0 = true;
                this.w0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.v0 = false;
                this.w0 = true;
            }
            if (i3 == 2) {
                this.m0.y0().L().K3(1);
                this.m0.J1(1);
            } else if (i3 == 3) {
                this.m0.y0().L().K3(0);
                this.m0.J1(0);
            } else if (i3 == 4) {
                this.m0.y0().L().L3(1);
                this.m0.K1(1);
            } else if (i3 == 5) {
                this.m0.y0().L().L3(0);
                this.m0.K1(0);
            }
            this.t0.f3(this.m0.y0(), this.m0.M0());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f21402b)) {
            string = gVar.f21402b;
        } else {
            string = getString(R.string.operation_failed);
        }
        d.b.b.e.p.l.L(getPageContext().getPageActivity(), string);
    }

    public final void i5(View view, String str, String str2, PostData postData) {
        if (view == null || str == null || str2 == null || R3() || !U3()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.a0);
            this.b0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (G4().B0() != null && postData != null) {
            G4().B0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.s().getName_show(), postData.J() != null ? postData.J().toString() : ""));
        }
        if (this.m0.y0() != null && this.m0.y0().Z()) {
            d.b.b.e.m.e.a().postDelayed(new k0(str, str2), 0L);
            return;
        }
        if (this.S0 == null) {
            d.b.i0.p0.f2.a.c cVar = new d.b.i0.p0.f2.a.c(getPageContext());
            this.S0 = cVar;
            cVar.k(1);
            this.S0.j(new l0(str, str2));
        }
        PbModel pbModel = this.m0;
        if (pbModel == null || pbModel.y0() == null || this.m0.y0().l() == null) {
            return;
        }
        this.S0.h(this.m0.y0().l().getId(), d.b.b.e.m.b.f(this.m0.O0(), 0L));
    }

    public final void i6(int i3) {
        d.b.h0.r.q.a2 L;
        PbModel pbModel = this.m0;
        if (pbModel == null || pbModel.y0() == null || (L = this.m0.y0().L()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData P0 = L.P0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (P0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i3);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    L.X3(praiseData);
                } else {
                    L.P0().getUser().add(0, metaData);
                    L.P0().setNum(L.P0().getNum() + 1);
                    L.P0().setIsLike(i3);
                }
            }
            if (L.P0() != null) {
                if (L.P0().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    StringHelper.numFormatOver10000(L.P0().getNum());
                }
            }
        } else if (L.P0() != null) {
            L.P0().setIsLike(i3);
            L.P0().setNum(L.P0().getNum() - 1);
            ArrayList<MetaData> user = L.P0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        L.P0().getUser().remove(next);
                        break;
                    }
                }
            }
            if (L.P0().getNum() < 1) {
                getResources().getString(R.string.zan);
            } else {
                String str = L.P0().getNum() + "";
            }
        }
        if (this.m0.M0()) {
            this.t0.e0().U();
        } else {
            this.t0.h3(this.m0.y0());
        }
    }

    public boolean isSimpleForum() {
        PbModel pbModel = this.m0;
        if (pbModel == null) {
            return false;
        }
        return pbModel.e1();
    }

    public final void j4(Rect rect) {
        d.b.i0.c2.k.e.q0 q0Var;
        if (rect == null || (q0Var = this.t0) == null || q0Var.L0() == null || rect.top > this.t0.L0().getHeight()) {
            return;
        }
        rect.top += this.t0.L0().getHeight() - rect.top;
    }

    public final void j5() {
        d.b.i0.c2.h.e y02 = this.m0.y0();
        this.m0.T1(true);
        d.b.h0.h.a aVar = this.o0;
        if (aVar != null) {
            y02.p0(aVar.g());
        }
        this.t0.b1(y02);
    }

    public final TbRichText j6(String str, int i3) {
        PbModel pbModel = this.m0;
        TbRichText tbRichText = null;
        if (pbModel == null || pbModel.y0() == null || str == null || i3 < 0) {
            return null;
        }
        d.b.i0.c2.h.e y02 = this.m0.y0();
        if (y02.j() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(y02.j());
            tbRichText = r4(arrayList, str, i3);
        }
        if (tbRichText == null) {
            ArrayList<PostData> D = y02.D();
            Q3(y02, D);
            return r4(D, str, i3);
        }
        return tbRichText;
    }

    public final int k4() {
        if (this.m0.y0() == null || this.m0.y0().L() == null) {
            return -1;
        }
        return this.m0.y0().L().G();
    }

    public final void k5() {
        MarkData R;
        if (this.o0 != null) {
            if (this.m0.y0() != null && this.m0.y0().Z()) {
                R = this.m0.R(0);
            } else {
                R = this.m0.R(this.t0.s0());
            }
            if (R == null) {
                return;
            }
            if (R.isApp() && (R = this.m0.R(this.t0.s0() + 1)) == null) {
                return;
            }
            this.t0.u2();
            this.o0.i(R);
            if (!this.o0.e()) {
                this.o0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.o0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final int l4() {
        if (G4() != null && G4().t0() != null) {
            BdTypeListView t02 = G4().t0();
            List<d.b.b.j.e.n> data = t02.getData();
            int headerViewsCount = t02.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i3 = 0; i3 < size; i3++) {
                    d.b.b.j.e.n nVar = data.get(i3);
                    if ((nVar instanceof PostData) && nVar.getType() == PostData.o0) {
                        return i3 + headerViewsCount;
                    }
                }
            }
        }
        return -1;
    }

    public final void l5(View view) {
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
        m5(postData);
    }

    public PostData m4() {
        d.b.i0.c2.k.e.q0 q0Var = this.t0;
        PbModel pbModel = this.m0;
        return q0Var.l0(pbModel.I, pbModel.M0());
    }

    public void m5(PostData postData) {
        PostData m4;
        if (postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.D() != null && postData.D().equals(this.m0.t0())) {
            z3 = true;
        }
        MarkData s02 = this.m0.s0(postData);
        if (this.m0.y0() != null && this.m0.y0().Z() && (m4 = m4()) != null) {
            s02 = this.m0.s0(m4);
        }
        if (s02 == null) {
            return;
        }
        this.t0.u2();
        d.b.h0.h.a aVar = this.o0;
        if (aVar != null) {
            aVar.i(s02);
            if (!z3) {
                this.o0.a();
            } else {
                this.o0.d();
            }
        }
    }

    public String n4() {
        return this.O;
    }

    public final boolean n5(String str) {
        if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String o2 = d.b.h0.r.d0.b.i().o("bubble_link", "");
            if (StringUtils.isNull(o2)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                d.b.h0.l.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), o2 + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return false;
    }

    public int o4() {
        if (G4() != null && G4().t0() != null) {
            BdTypeListView t02 = G4().t0();
            List<d.b.b.j.e.n> data = t02.getData();
            int headerViewsCount = t02.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i3 = 0; i3 < size; i3++) {
                    d.b.b.j.e.n nVar = data.get(i3);
                    if ((nVar instanceof d.b.i0.c2.h.o) && ((d.b.i0.c2.h.o) nVar).f52455f == d.b.i0.c2.h.o.m) {
                        return i3 + headerViewsCount;
                    }
                }
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.Y1.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d(), "", 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        EmotionImageData emotionImageData;
        String str;
        super.onActivityResult(i3, i4, intent);
        this.N0.H(i3, i4, intent);
        d.b.i0.c2.k.e.y0.f.a aVar = this.S;
        if (aVar != null) {
            aVar.i(i3, i4, intent);
        }
        if (G4().B0() != null) {
            G4().B0().g(i3, i4, intent);
        }
        if (i3 == 25035) {
            M4(i4, intent);
        }
        if (i4 == -1) {
            if (i3 == 11009) {
                k5();
            } else if (i3 == 13008) {
                d.b.i0.c2.k.e.k0.b().m();
                this.l0.postDelayed(new g1(), 1000L);
            } else if (i3 == 13011) {
                d.b.i0.q2.a.g().m(getPageContext());
            } else if (i3 == 23003) {
                if (intent == null || this.m0 == null) {
                    return;
                }
                N5(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
            } else if (i3 == 23007) {
                P4(intent);
            } else if (i3 == 25012) {
                intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                intent.getStringExtra("KEY_FORUM_NAME");
            } else if (i3 == 25016 || i3 == 25023) {
                Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                    return;
                }
                this.T0 = emotionImageData;
                if (V3(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                    B5(emotionImageData);
                }
            } else if (i3 == 25033) {
                View view = this.U;
                if (view != null) {
                    this.t0.J2(view);
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
                    d.b.i0.q2.a.g().m(getPageContext());
                    g6();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.s0;
                    if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.t) == null) {
                        return;
                    }
                    shareSuccessReplyToServerModel.s(str, intExtra, new h1());
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
                        d.b.i0.c2.k.e.q0 q0Var = this.t0;
                        if (q0Var == null || q0Var.f0() == null) {
                            return;
                        }
                        this.t0.f0().performClick();
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
                this.t0.w2(false);
                if (this.m0.y0() == null || this.m0.y0().L() == null || this.m0.y0().L().S0() == null) {
                    return;
                }
                this.m0.y0().L().S0().setStatus(2);
            }
        }
    }

    @Override // d.b.h0.b1.m.h
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.A = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f19547e = (PbActivity) context;
    }

    public void onBackPressed() {
        List<l2> list = this.k1;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.k1.size();
        while (true) {
            size--;
            if (size <= -1 || this.k1.get(size).onBackPressed()) {
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
        this.t0.r1(i3);
        d.b.h0.w.w.e eVar = this.N0;
        if (eVar != null && eVar.a() != null) {
            this.N0.a().w(i3);
        }
        if (this.t0.a() != null) {
            this.t0.a().c(getPageContext(), i3);
        }
        this.x0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.Z = i3;
        c6();
    }

    @Override // d.b.h0.r.s.a.e
    public void onClick(d.b.h0.r.s.a aVar) {
        c4(aVar, null);
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
        d.b.i0.c2.k.e.q0 q0Var = this.t0;
        if (q0Var != null) {
            q0Var.s1(configuration);
        }
        d.b.h0.r.s.j jVar = this.y0;
        if (jVar != null) {
            jVar.dismiss();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        d.b.i0.c2.k.e.q0 q0Var;
        d.b.i0.c2.k.e.q0 q0Var2;
        this.t = System.currentTimeMillis();
        this.Z0 = getPageContext();
        Intent intent = this.f19547e.getIntent();
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
            this.u2 = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.v2 = intent.getIntExtra("key_manga_next_chapter", -1);
            this.w2 = intent.getStringExtra("key_manga_title");
            this.D0 = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.E0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.K0 = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (v4()) {
                this.f19547e.setUseStyleImmersiveSticky(false);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.R = stringExtra;
            this.R = d.b.b.e.p.k.isEmpty(stringExtra) ? "" : this.R;
            this.j1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            d.b.h0.r.q.k1 k1Var = new d.b.h0.r.q.k1();
            this.e0 = k1Var;
            k1Var.a(intent);
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            this.l1 = intExtra;
            if (intExtra == 0) {
                this.l1 = intent.getIntExtra("key_start_from", 0);
            }
            this.m1 = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.r = System.currentTimeMillis();
        }
        this.v = this.t - this.r;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.p = 0;
        g5(bundle);
        if (this.m0.y0() != null) {
            this.m0.y0().w0(this.R);
        }
        U4();
        if (intent != null && (q0Var2 = this.t0) != null) {
            q0Var2.f52761a = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.c1 == null) {
                    this.c1 = new t(intent);
                }
                d.b.b.e.m.e.a().postDelayed(this.c1, 1500L);
            }
            String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra2) && this.m0.y0() != null) {
                this.m0.O1(stringExtra2);
            }
        }
        VoiceManager voiceManager = new VoiceManager();
        this.o = voiceManager;
        voiceManager.onCreate(getPageContext());
        T4(bundle);
        d.b.h0.w.w.g gVar = new d.b.h0.w.w.g();
        this.M0 = gVar;
        H5(gVar);
        d.b.h0.w.w.e eVar = (d.b.h0.w.w.e) this.M0.a(getActivity());
        this.N0 = eVar;
        eVar.e0(this.f19547e.getPageContext());
        this.N0.n0(this.V1);
        this.N0.o0(this.U0);
        this.N0.g0(1);
        this.N0.F(this.f19547e.getPageContext(), bundle);
        this.N0.a().b(new d.b.h0.w.k(getActivity()));
        this.N0.a().C(true);
        K5(true);
        this.N0.O(this.m0.c0(), this.m0.O0(), this.m0.Z());
        registerListener(this.t1);
        if (!this.m0.m0()) {
            this.N0.s(this.m0.O0());
        }
        if (this.m0.X0()) {
            this.N0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            d.b.i0.c2.k.e.q0 q0Var3 = this.t0;
            if (q0Var3 != null) {
                this.N0.k0(q0Var3.E0());
            }
        }
        registerListener(this.s1);
        registerListener(this.u1);
        registerListener(this.v1);
        registerListener(this.r1);
        registerListener(this.O1);
        registerListener(this.a2);
        registerListener(this.q1);
        d.b.i0.c3.h0.f fVar = new d.b.i0.c3.h0.f("pb", d.b.i0.c3.h0.f.f53379d);
        this.L0 = fVar;
        fVar.d();
        registerListener(this.z1);
        registerListener(this.H1);
        this.m0.q1();
        registerListener(this.Z1);
        registerListener(this.P1);
        registerListener(this.U1);
        d.b.i0.c2.k.e.q0 q0Var4 = this.t0;
        if (q0Var4 != null && q0Var4.L0() != null && this.t0.J0() != null) {
            d.b.i0.c2.k.e.z0.b bVar = new d.b.i0.c2.k.e.z0.b(getActivity(), this.t0.L0(), this.t0.J0(), this.t0.z0());
            this.i = bVar;
            bVar.t(this.G1);
        }
        if (this.f19549g && (q0Var = this.t0) != null && q0Var.J0() != null) {
            this.t0.J0().setVisibility(8);
        }
        d.b.h0.r.f0.c cVar = new d.b.h0.r.f0.c();
        this.a1 = cVar;
        cVar.f50484a = 1000L;
        registerListener(this.N1);
        registerListener(this.L1);
        registerListener(this.M1);
        registerListener(this.B1);
        registerListener(this.x1);
        this.A1.setSelfListener(true);
        this.A1.setTag(this.f19547e.getUniqueId());
        this.A1.setPriority(-1);
        MessageManager.getInstance().registerListener(this.A1);
        registerResponsedEventListener(TipEvent.class, this.I1);
        this.b1 = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        BdUniqueId bdUniqueId = this.b1;
        userMuteAddAndDelCustomMessage.mId = bdUniqueId;
        userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        BdUniqueId bdUniqueId2 = this.b1;
        userMuteCheckCustomMessage.mId = bdUniqueId2;
        userMuteCheckCustomMessage.setTag(bdUniqueId2);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.m0.V().w(this.J1);
        this.x0 = new d.b.i0.c2.k.e.s0();
        if (this.N0.v() != null) {
            this.x0.m(this.N0.v().i());
        }
        this.N0.d0(this.V0);
        this.s0 = new ShareSuccessReplyToServerModel();
        M3(this.o1);
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
        this.Q0 = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new u());
        d.b.i0.c2.k.f.a aVar = new d.b.i0.c2.k.f.a(getContext());
        this.n0 = aVar;
        aVar.a(getUniqueId());
        d.b.i0.b3.c.g().i(getUniqueId());
        d.b.h0.r.o.b.b().l("3", "");
        this.n1 = new d.b.i0.w.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && d.b.b.e.p.j.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
        }
        this.u = System.currentTimeMillis() - this.t;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.t0 = new d.b.i0.c2.k.e.q0(this, this.T1, this.K1);
        d.b.i0.f0.b bVar = new d.b.i0.f0.b(getActivity());
        this.f19550h = bVar;
        bVar.i(z2);
        this.f19550h.d(this.s2);
        this.t0.o2(this.c2);
        this.t0.n2(this.h2);
        this.t0.h2(this.f2);
        this.t0.f2(d.b.h0.r.k.c().g());
        this.t0.l2(this.j2);
        this.t0.q2(this.p2);
        this.t0.m2(this.q2);
        this.t0.k2(this.e2);
        this.t0.c3(this.mIsLogin);
        if (this.f19547e.getIntent() != null) {
            this.t0.d2(this.f19547e.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.t0.A0().setFromForumId(this.m0.getFromForumId());
        this.t0.V1(this.N0.a());
        this.N0.k0(this.t0.E0());
        this.t0.Y1(new x());
        this.t0.c2(this.m0.h0());
        this.t0.p2(this.m0.x0());
        return this.t0.M0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.b.i0.c2.k.e.c1.c cVar;
        d.b.i0.b3.c.g().k(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            StatisticItem statisticItem = new StatisticItem("c13266");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.m0.y0().m());
            statisticItem.param("tid", this.m0.O0());
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(statisticItem);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.x && this.t0 != null) {
            this.x = true;
            D5(false, null);
        }
        PbModel pbModel = this.m0;
        if (pbModel != null) {
            pbModel.cancelLoadData();
            this.m0.destory();
            if (this.m0.u0() != null) {
                this.m0.u0().d();
            }
        }
        d.b.h0.w.w.e eVar = this.N0;
        if (eVar != null) {
            eVar.I();
        }
        ForumManageModel forumManageModel = this.p0;
        if (forumManageModel != null) {
            forumManageModel.cancelLoadData();
        }
        LikeModel likeModel = this.T;
        if (likeModel != null) {
            likeModel.E();
        }
        d.b.i0.c2.k.e.q0 q0Var = this.t0;
        if (q0Var != null) {
            q0Var.t1();
            d.b.i0.c2.k.e.c1.c cVar2 = this.t0.f52767g;
            if (cVar2 != null) {
                cVar2.p();
            }
        }
        d.b.h0.m0.b bVar = this.y;
        if (bVar != null) {
            bVar.c();
        }
        d.b.i0.c2.k.e.z0.b bVar2 = this.i;
        if (bVar2 != null) {
            bVar2.k();
        }
        super.onDestroy();
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.b.i0.c2.k.e.q0 q0Var2 = this.t0;
        if (q0Var2 != null) {
            q0Var2.T();
        }
        MessageManager.getInstance().unRegisterListener(this.L1);
        MessageManager.getInstance().unRegisterListener(this.M1);
        MessageManager.getInstance().unRegisterListener(this.N1);
        MessageManager.getInstance().unRegisterListener(this.b1);
        MessageManager.getInstance().unRegisterListener(this.O1);
        MessageManager.getInstance().unRegisterListener(this.P1);
        MessageManager.getInstance().unRegisterListener(this.B1);
        MessageManager.getInstance().unRegisterListener(this.X1);
        MessageManager.getInstance().unRegisterListener(this.A1);
        this.Z0 = null;
        this.a1 = null;
        d.b.i0.r2.a0.a.e().g();
        if (this.c1 != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.c1);
        }
        d.b.i0.c2.k.e.y0.f.a aVar = this.S;
        if (aVar != null) {
            aVar.f();
        }
        d.b.i0.c2.k.e.q0 q0Var3 = this.t0;
        if (q0Var3 != null && (cVar = q0Var3.f52767g) != null) {
            cVar.j();
        }
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.s0;
        if (shareSuccessReplyToServerModel != null) {
            shareSuccessReplyToServerModel.cancelLoadData();
        }
        this.x0.j();
        PbModel pbModel2 = this.m0;
        if (pbModel2 != null && pbModel2.O() != null) {
            this.m0.O().onDestroy();
        }
        ReplyPrivacyCheckController replyPrivacyCheckController = this.Q0;
        if (replyPrivacyCheckController != null) {
            replyPrivacyCheckController.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.f0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.b.b.j.e.q onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        d.b.i0.c2.k.e.q0 q0Var;
        return (keyEvent == null || (q0Var = this.t0) == null || !q0Var.v1(i3)) ? false : true;
    }

    @Override // d.b.h0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        this.A = true;
    }

    @Override // d.b.h0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z3) {
        PbModel pbModel;
        if (d.b.i0.c2.k.e.v0.c(str) && (pbModel = this.m0) != null && pbModel.O0() != null) {
            TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.m0.O0()));
        }
        if (z3) {
            if (!TextUtils.isEmpty(str)) {
                d.b.h0.t.l lVar = new d.b.h0.t.l();
                lVar.f51482a = str;
                lVar.f51483b = 3;
                lVar.f51484c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, lVar));
            }
        } else {
            d.b.i0.c2.k.e.v0.a().e(getPageContext(), str);
        }
        this.A = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        y5();
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
        d.b.i0.c2.k.e.q0 q0Var = this.t0;
        if (q0Var != null) {
            q0Var.y1();
        }
        if (!this.m0.m0()) {
            this.N0.U(this.m0.O0());
        }
        PbModel pbModel = this.m0;
        if (pbModel != null) {
            pbModel.p1();
        }
        d.b.h0.a.c.y().E();
        MessageManager.getInstance().unRegisterListener(this.w1);
        C5();
        MessageManager.getInstance().unRegisterListener(this.L1);
        MessageManager.getInstance().unRegisterListener(this.M1);
        MessageManager.getInstance().unRegisterListener(this.N1);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    @Override // d.b.h0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.A0 = str;
        if (this.q == null) {
            V4();
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

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.b.a.i
    public void onPreLoad(d.b.b.j.e.q qVar) {
        PreLoadImageHelper.load(qVar, getUniqueId(), 3);
        PreLoadVideoHelper.load(qVar, getUniqueId(), this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.k = false;
        super.onResume();
        if (this.Q) {
            this.Q = false;
            L4();
        }
        if (X4()) {
            this.z = System.currentTimeMillis();
        } else {
            this.z = -1L;
        }
        d.b.i0.c2.k.e.q0 q0Var = this.t0;
        if (q0Var != null && q0Var.M0() != null) {
            if (!this.l) {
                U5();
            } else {
                hideLoadingView(this.t0.M0());
            }
            this.t0.z1();
        }
        if (this.p == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        d.b.i0.c2.k.e.q0 q0Var2 = this.t0;
        NoNetworkView a3 = q0Var2 != null ? q0Var2.a() : null;
        if (a3 != null && a3.getVisibility() == 0 && d.b.b.e.p.j.z()) {
            a3.e(false);
        }
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        registerListener(this.w1);
        this.C0 = false;
        E5();
        registerListener(this.L1);
        registerListener(this.M1);
        registerListener(this.N1);
        if (this.h1) {
            y5();
            this.h1 = false;
        }
        Z5();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.m0.E1(bundle);
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.N0.K(bundle);
    }

    @Override // d.b.h0.b1.m.h
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
        if (G4().B0() != null) {
            G4().B0().i();
        }
        d.b.i0.c2.k.e.c1.c cVar = this.t0.f52767g;
        if (cVar != null && !cVar.l()) {
            this.t0.f52767g.p();
        }
        PbModel pbModel = this.m0;
        if (pbModel != null && pbModel.y0() != null && this.m0.y0().l() != null && this.m0.y0().L() != null) {
            d.b.h0.u.a.l().A(getPageContext().getPageActivity(), "pb", this.m0.y0().l().getId(), d.b.b.e.m.b.f(this.m0.y0().L().o0(), 0L));
        }
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
        d.b.i0.b3.c.g().h(getUniqueId(), false);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        super.onUserChanged(z3);
        this.t0.c3(z3);
        d.b.h0.r.s.j jVar = this.y0;
        if (jVar != null) {
            jVar.dismiss();
        }
        if (z3 && this.C0) {
            this.t0.v2();
            this.m0.h1(true);
        }
    }

    @Override // d.b.h0.b1.m.h
    public void onVideoClicked(Context context, String str) {
        d.b.i0.c2.k.e.v0.a().e(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.A = true;
    }

    @Override // d.b.h0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
    }

    public final String p4() {
        d.b.i0.c2.h.e y02;
        PbModel pbModel = this.m0;
        if (pbModel == null || (y02 = pbModel.y0()) == null) {
            return null;
        }
        return y02.P().f52473c;
    }

    public final void p5() {
        if (!d.b.b.e.p.j.z()) {
            showToast(R.string.network_not_available);
            return;
        }
        this.t0.T();
        if (this.m) {
            return;
        }
        c6();
        this.t0.u2();
        if (this.m0.LoadData()) {
            this.t0.T2();
        }
    }

    public final String q4() {
        ArrayList<PostData> D;
        int count;
        PbModel pbModel = this.m0;
        if (pbModel == null || pbModel.y0() == null || this.m0.y0().D() == null || (count = ListUtils.getCount((D = this.m0.y0().D()))) == 0) {
            return "";
        }
        if (this.m0.J0()) {
            Iterator<PostData> it = D.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.z() == 1) {
                    return next.D();
                }
            }
        }
        int k02 = this.t0.k0();
        PostData postData = (PostData) ListUtils.getItem(D, k02);
        if (postData != null && postData.s() != null) {
            if (this.m0.f1(postData.s().getUserId())) {
                return postData.D();
            }
            for (int i3 = k02 - 1; i3 != 0; i3--) {
                PostData postData2 = (PostData) ListUtils.getItem(D, i3);
                if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                    break;
                } else if (this.m0.f1(postData2.s().getUserId())) {
                    return postData2.D();
                }
            }
            for (int i4 = k02 + 1; i4 < count; i4++) {
                PostData postData3 = (PostData) ListUtils.getItem(D, i4);
                if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                    break;
                } else if (this.m0.f1(postData3.s().getUserId())) {
                    return postData3.D();
                }
            }
        }
        return "";
    }

    public void q5() {
        d.b.i0.c2.h.e y02;
        d.b.h0.r.q.a2 L;
        PbModel pbModel = this.m0;
        if (pbModel == null || pbModel.y0() == null || (L = (y02 = this.m0.y0()).L()) == null || L.T() == null) {
            return;
        }
        this.t0.Q0();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), L.T().getUserId());
        d.b.i0.c2.k.e.e0 e0Var = new d.b.i0.c2.k.e.e0();
        int R = this.m0.y0().R();
        boolean z3 = true;
        if (R != 1 && R != 3) {
            e0Var.f52675g = false;
        } else {
            e0Var.f52675g = true;
            e0Var.p = L.x0() == 1;
        }
        if (a5(R)) {
            e0Var.f52676h = true;
            e0Var.o = L.w0() == 1;
        } else {
            e0Var.f52676h = false;
        }
        if (R == 1002 && !equals) {
            e0Var.q = true;
        }
        e0Var.f52673e = O5(equals);
        e0Var.i = Q5();
        e0Var.f52674f = P5(equals);
        e0Var.k = equals && y02.Q() != null && y02.Q().showPbPrivate();
        e0Var.n = this.m0.M0();
        e0Var.f52670b = true;
        e0Var.f52669a = c5(equals);
        if (equals) {
            this.t0.c1();
        }
        e0Var.m = TbadkCoreApplication.getInst().getSkinType() == 1;
        e0Var.j = true;
        e0Var.l = this.m0.d0();
        e0Var.f52672d = true;
        if (L.u1() == null) {
            e0Var.f52671c = true;
        } else {
            e0Var.f52671c = false;
        }
        if (y02.Z()) {
            e0Var.f52670b = false;
            e0Var.f52672d = false;
            e0Var.f52671c = false;
            e0Var.f52675g = false;
            e0Var.f52676h = false;
        }
        e0Var.r = (TbSingleton.getInstance().mShowCallFans && equals && !y02.Z()) ? false : false;
        d.b.i0.c2.k.e.q0 q0Var = this.t0;
        if (q0Var != null) {
            PbModel pbModel2 = this.m0;
            PostData l02 = q0Var.l0(pbModel2.I, pbModel2.M0());
            e0Var.s = l02 != null ? l02.S : false;
        }
        this.t0.f52767g.w(e0Var);
    }

    @Override // d.b.i0.c2.o.b
    public PbModel.g r() {
        return this.Y1;
    }

    public final TbRichText r4(ArrayList<PostData> arrayList, String str, int i3) {
        ArrayList<TbRichTextData> u2;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                TbRichText J = arrayList.get(i4).J();
                if (J != null && (u2 = J.u()) != null) {
                    int size = u2.size();
                    int i5 = -1;
                    for (int i6 = 0; i6 < size; i6++) {
                        if (u2.get(i6) != null && u2.get(i6).getType() == 8) {
                            i5++;
                            if (u2.get(i6).x().u().equals(str) || u2.get(i6).x().v().equals(str)) {
                                int h3 = (int) d.b.b.e.p.l.h(TbadkCoreApplication.getInst());
                                int width = u2.get(i6).x().getWidth() * h3;
                                int height = u2.get(i6).x().getHeight() * h3;
                                if (width < 80 || height < 80 || width * height < 10000) {
                                    return null;
                                }
                                this.i2 = i6;
                                return J;
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

    public final void r5(String str, int i3, PbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        if (eVar == null) {
            return;
        }
        d.b.i0.c2.h.e y02 = this.m0.y0();
        TbRichText j6 = j6(str, i3);
        if (j6 == null || (tbRichTextData = j6.u().get(this.i2)) == null) {
            return;
        }
        eVar.f19512f = String.valueOf(j6.getPostId());
        eVar.f19507a = new ArrayList<>();
        eVar.f19508b = new ConcurrentHashMap<>();
        if (!tbRichTextData.x().z()) {
            eVar.f19514h = false;
            String a3 = d.b.i0.c2.h.f.a(tbRichTextData);
            eVar.f19507a.add(a3);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.w ? 17 : 18;
            }
            imageUrlData.originalUrl = B4(tbRichTextData);
            imageUrlData.originalUrl = B4(tbRichTextData);
            imageUrlData.originalSize = C4(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = w4(tbRichTextData);
            imageUrlData.isLongPic = u4(tbRichTextData);
            imageUrlData.postId = j6.getPostId();
            imageUrlData.mIsReserver = this.m0.J0();
            imageUrlData.mIsSeeHost = this.m0.d0();
            eVar.f19508b.put(a3, imageUrlData);
            if (y02 != null) {
                if (y02.l() != null) {
                    eVar.f19509c = y02.l().getName();
                    eVar.f19510d = y02.l().getId();
                }
                if (y02.L() != null) {
                    eVar.f19511e = y02.L().o0();
                }
                eVar.f19513g = y02.s() == 1;
            }
            imageUrlData.threadId = d.b.b.e.m.b.f(eVar.f19511e, -1L);
            return;
        }
        eVar.f19514h = true;
        int size = y02.D().size();
        this.k2 = false;
        eVar.j = -1;
        int s4 = y02.j() != null ? s4(y02.j().J(), j6, i3, i3, eVar.f19507a, eVar.f19508b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = y02.D().get(i4);
            if (postData.D() == null || y02.j() == null || y02.j().D() == null || !postData.D().equals(y02.j().D())) {
                s4 = s4(postData.J(), j6, s4, i3, eVar.f19507a, eVar.f19508b);
            }
        }
        if (eVar.f19507a.size() > 0) {
            ArrayList<String> arrayList = eVar.f19507a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (y02 != null) {
            if (y02.l() != null) {
                eVar.f19509c = y02.l().getName();
                eVar.f19510d = y02.l().getId();
            }
            if (y02.L() != null) {
                eVar.f19511e = y02.L().o0();
            }
            eVar.f19513g = y02.s() == 1;
        }
        eVar.j = s4;
    }

    public final int s4(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        TbRichTextImageInfo x2;
        if (tbRichText == tbRichText2) {
            this.k2 = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.u().size();
            int i5 = i3;
            int i6 = -1;
            for (int i7 = 0; i7 < size; i7++) {
                TbRichTextData tbRichTextData = tbRichText.u().get(i7);
                if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                    i6++;
                    int h3 = (int) d.b.b.e.p.l.h(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.x().getWidth() * h3;
                    int height = tbRichTextData.x().getHeight() * h3;
                    if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.x().z()) {
                        if (tbRichText == tbRichText2) {
                            if (i6 <= i4) {
                                i5--;
                            }
                        }
                    } else if (tbRichTextData.getType() != 20) {
                        String a3 = d.b.i0.c2.h.f.a(tbRichTextData);
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
                                imageUrlData.originalUrl = B4(tbRichTextData);
                                imageUrlData.originalSize = C4(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = w4(tbRichTextData);
                                imageUrlData.isLongPic = u4(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = d.b.b.e.m.b.f(this.m0.O0(), -1L);
                                imageUrlData.mIsReserver = this.m0.J0();
                                imageUrlData.mIsSeeHost = this.m0.d0();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(a3, imageUrlData);
                                }
                            }
                        }
                        if (!this.k2) {
                            i5++;
                        }
                    }
                }
            }
            return i5;
        }
        return i3;
    }

    public void s5() {
        PbModel pbModel;
        if (!checkUpIsLogin() || (pbModel = this.m0) == null || pbModel.y0() == null || this.m0.y0().l() == null || R3()) {
            return;
        }
        if (this.m0.y0().Z()) {
            this.t0.N();
            return;
        }
        if (this.R0 == null) {
            d.b.i0.p0.f2.a.c cVar = new d.b.i0.p0.f2.a.c(getPageContext());
            this.R0 = cVar;
            cVar.k(0);
            this.R0.j(new i0());
        }
        this.R0.h(this.m0.y0().l().getId(), d.b.b.e.m.b.f(this.m0.O0(), 0L));
    }

    public PbInterviewStatusView.f t4() {
        return this.k0;
    }

    public final PbActivity.e t5(String str) {
        String str2 = null;
        if (this.m0.y0() != null && this.m0.y0().D() != null && this.m0.y0().D().size() != 0 && !StringUtils.isNull(str)) {
            PbActivity.e eVar = new PbActivity.e();
            int i3 = 0;
            while (true) {
                if (i3 >= this.m0.y0().D().size()) {
                    i3 = 0;
                    break;
                } else if (str.equals(this.m0.y0().D().get(i3).D())) {
                    break;
                } else {
                    i3++;
                }
            }
            PostData postData = this.m0.y0().D().get(i3);
            if (postData.J() != null && postData.J().u() != null) {
                Iterator<TbRichTextData> it = postData.J().u().iterator();
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
                r5(str2, 0, eVar);
                d.b.i0.c2.h.f.b(postData, eVar);
                return eVar;
            }
        }
        return null;
    }

    public final boolean u4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return false;
        }
        return tbRichTextData.x().A();
    }

    public final void u5(View view) {
        if (view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.f19548f ? 2 : 3));
        view.setTag(sparseArray);
    }

    public boolean v4() {
        return (!this.f19549g && this.u2 == -1 && this.v2 == -1) ? false : true;
    }

    public void v5(d.b.i0.c2.h.q qVar) {
        String D = qVar.i().D();
        List<PostData> list = this.m0.y0().P().f52471a;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                break;
            }
            PostData postData = list.get(i3);
            if (postData.D() == null || !postData.D().equals(D)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = qVar.k();
                postData.s0(qVar.m());
                if (postData.L() != null) {
                    postData.L().clear();
                    postData.L().addAll(k3);
                }
            }
        }
        if (this.m0.i0()) {
            return;
        }
        this.t0.b1(this.m0.y0());
    }

    public final boolean w4(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return false;
        }
        return tbRichTextData.x().B();
    }

    public void w5(boolean z3, MarkData markData) {
        this.t0.t2();
        this.m0.T1(z3);
        d.b.h0.h.a aVar = this.o0;
        if (aVar != null) {
            aVar.h(z3);
            if (markData != null) {
                this.o0.i(markData);
            }
        }
        if (this.m0.k0()) {
            j5();
        } else {
            this.t0.b1(this.m0.y0());
        }
    }

    public boolean x4() {
        return this.M;
    }

    public void x5(d.b.i0.c2.h.q qVar) {
        boolean z3;
        MetaData metaData;
        if (qVar.i() == null) {
            return;
        }
        String D = qVar.i().D();
        ArrayList<PostData> D2 = this.m0.y0().D();
        int i3 = 0;
        while (true) {
            z3 = true;
            if (i3 >= D2.size()) {
                break;
            }
            PostData postData = D2.get(i3);
            if (postData.D() == null || !postData.D().equals(D)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = qVar.k();
                postData.s0(qVar.m());
                if (postData.L() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.R() != null && next != null && next.s() != null && (metaData = postData.R().get(next.s().getUserId())) != null) {
                            next.e0(metaData);
                            next.m0(true);
                            next.x0(getPageContext(), this.m0.f1(metaData.getUserId()));
                        }
                    }
                    boolean z4 = k3.size() != postData.L().size();
                    if (postData.L() != null && postData.L().size() < 2) {
                        postData.L().clear();
                        postData.L().addAll(k3);
                    }
                    z3 = z4;
                }
                if (postData.w() != null) {
                    postData.d0();
                }
            }
        }
        if (!this.m0.i0() && z3) {
            this.t0.b1(this.m0.y0());
        }
        if (z3) {
            v5(qVar);
        }
    }

    @Override // d.b.i0.c2.o.b
    public PbFragment y0() {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.b1.m.h
    /* renamed from: y4 */
    public BdListView getListView() {
        d.b.i0.c2.k.e.q0 q0Var = this.t0;
        if (q0Var == null) {
            return null;
        }
        return q0Var.t0();
    }

    public final void y5() {
        hideNetRefreshView(this.t0.M0());
        U5();
        if (this.m0.n1()) {
            this.t0.u2();
        }
        this.t0.C2();
    }

    public int z4() {
        return this.v2;
    }

    public void z5(l2 l2Var) {
        List<l2> list;
        if (l2Var == null || (list = this.k1) == null) {
            return;
        }
        list.remove(l2Var);
    }
}
