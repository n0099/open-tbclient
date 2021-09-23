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
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import c.a.q0.c0.d;
import c.a.q0.f1.m.e;
import c.a.q0.i.a;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.d1;
import c.a.q0.s.s.a;
import c.a.q0.s.s.b;
import c.a.q0.s.s.i;
import c.a.r0.j0.a;
import c.a.r0.j0.b;
import c.a.r0.j2.i.c;
import c.a.r0.j2.k.e.c0;
import c.a.r0.j2.k.e.c1.b;
import c.a.r0.j2.k.e.p;
import c.a.r0.j2.p.f;
import c.a.r0.j3.k0.a;
import c.a.r0.w0.g2.a.c;
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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.download.DownloadData;
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
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
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
/* loaded from: classes7.dex */
public class PbFragment extends BaseFragment implements c.a.q0.f1.m.g, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a.e, TbRichTextView.t, TbPageContextSupport, c.a.r0.j2.o.b, f.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHECK_MUTE_FROM_DIALOG = 2;

    /* renamed from: CHECK_MUTE_FROM＿FLOOR  reason: contains not printable characters */
    public static final int f3CHECK_MUTE_FROMFLOOR = 1;
    public static final String GOD_CALL_URL = "http://tieba.baidu.com/mo/q/god/call/?";
    public static final String PHONE = "2";
    public static final int UPDATE_TYPE_DELETE = 1;
    public static final int UPDATE_TYPE_MARK = 2;
    public static final int UPDATE_TYPE_WRITE = 0;
    public static final AntiHelper.k x2;
    public static final b.InterfaceC0936b y2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public c.a.r0.j2.h.t A0;
    public CustomMessageListener A1;
    public long B;
    public ShareSuccessReplyToServerModel B0;
    public CustomMessageListener B1;
    public int C;
    public c.a.r0.j2.k.e.s0 C0;
    public CustomMessageListener C1;
    public String D;
    public boolean D0;
    public SuggestEmotionModel.c D1;
    public c.a.e.e.k.b<TextView> E;
    public boolean E0;
    public CustomMessageListener E1;
    public c.a.e.e.k.b<TbImageView> F;
    public boolean F0;
    public GetSugMatchWordsModel.b F1;
    public c.a.e.e.k.b<ImageView> G;
    public PopupDialog G0;
    public boolean G1;
    public c.a.e.e.k.b<View> H;
    public c.a.q0.s.s.i H0;
    public PraiseModel H1;
    public c.a.e.e.k.b<TiebaPlusRecommendCard> I;
    public String I0;
    public b.h I1;
    public c.a.e.e.k.b<LinearLayout> J;
    public boolean J0;
    public CustomMessageListener J1;
    public c.a.e.e.k.b<RelativeLayout> K;
    public boolean K0;
    public c.a.q0.j0.i K1;
    public boolean L;
    public boolean L0;
    public CheckRealNameModel.b L1;
    public boolean M;
    public String M0;
    public c.a.r0.j2.i.c M1;
    public boolean N;
    public boolean N0;
    public CustomMessageListener N1;
    public c.a.e.e.k.b<GifView> O;
    public c.a.r0.j3.i0.f O0;
    public CustomMessageListener O1;
    public String P;
    public c.a.q0.x.w.g P0;
    public CustomMessageListener P1;
    public boolean Q;
    public c.a.q0.x.w.e Q0;
    public CustomMessageListener Q1;
    public boolean R;
    public boolean R0;
    public CustomMessageListener R1;
    public String S;
    public PermissionJudgePolicy S0;
    public i.e S1;
    public c.a.r0.j2.k.e.b1.f.a T;
    public c.a.r0.w0.g2.a.c T0;
    public CustomMessageListener T1;
    public LikeModel U;
    public c.a.r0.w0.g2.a.c U0;
    public final NewWriteModel.g U1;
    public View V;
    public EmotionImageData V0;
    public c.a.e.c.g.a V1;
    public View W;
    public c.a.q0.x.w.c W0;
    public final PbModel.g W1;
    public View X;
    public c.a.q0.x.w.b X0;
    public CustomMessageListener X1;
    public View Y;
    public c.a.q0.x.w.b Y0;
    public HttpMessageListener Y1;
    public String Z;
    public int Z0;
    public final a.InterfaceC0668a Z1;
    public int a0;
    public Object a1;
    public final AbsListView.OnScrollListener a2;
    public boolean b0;
    public c.a.e.a.f b1;
    public final c.a.e.a.e b2;
    public int bjhFrom;
    public int[] c0;
    public c.a.q0.s.f0.c c1;
    public final a3 c2;
    public BdUniqueId d1;
    public final f.g d2;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f55086e;
    public Runnable e1;
    public boolean e2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55087f;
    public c.a.r0.j2.k.e.w0 f1;
    public final BdListView.p f2;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55088g;
    public c.a.e.l.d.a g1;
    public int g2;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j0.b f55089h;
    public String h1;
    public final TbRichTextView.z h2;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.j2.k.e.c1.b f55090i;
    public int i0;
    public TbRichTextMemeInfo i1;
    public boolean i2;

    /* renamed from: j  reason: collision with root package name */
    public boolean f55091j;
    public int j0;
    public boolean j1;
    public PostData j2;
    public boolean k;
    public int k0;
    public int k1;
    public final b.c k2;
    public boolean l;
    public c.a.q0.s.q.n1 l0;
    public int l1;
    public final b.c l2;
    public String lastTid;
    public boolean m;
    public c.a.q0.s.b0.a m0;
    public List<y2> m1;
    public final AdapterView.OnItemClickListener m2;
    public final View.OnClickListener mCommonOnClickListener;
    public c.a.r0.j2.k.e.u0 mContentProcessController;
    public a.e mDialogClickListener;
    public CustomMessageListener mFirstFloorPraiseListener;
    public boolean mKeyboardIsVisible;
    public NewWriteModel.g mOnFloorPostWriteNewCallback;
    public View.OnTouchListener mOnTouchListener;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public boolean n;
    public boolean n0;
    public c.a.r0.z.a n1;
    public final View.OnLongClickListener n2;
    public VoiceManager o;
    public boolean o0;
    public final y2 o1;
    public final View.OnClickListener o2;
    public SortSwitchButton.f onSwitchChangeListener;
    public int p;
    public c.a.r0.j3.i0.e p0;
    public final c0.b p1;
    public final ItemCardHelper.c p2;
    public c.a.q0.s.s.b q;
    public boolean q0;
    public final CustomMessageListener q1;
    public final NoNetworkView.b q2;
    public long r;
    @NonNull
    public TiePlusEventController.d r0;
    public CustomMessageListener r1;
    public a.b r2;
    public long s;
    public c.a.r0.j2.k.e.e1.a s0;
    public CustomMessageListener s1;
    public final p.b s2;
    public BdUniqueId sortSwitchId;
    public long t;
    public PbInterviewStatusView.f t0;
    public CustomMessageListener t1;
    public int t2;
    public long u;
    public final Handler u0;
    public CustomMessageListener u1;
    public int u2;
    public long v;
    public PbModel v0;
    public CustomMessageListener v1;
    public String v2;
    public boolean w;
    public c.a.r0.j2.k.f.a w0;
    public CustomMessageListener w1;
    public c.a.q0.s.q.u w2;
    public boolean x;
    public c.a.q0.i.a x0;
    public final CustomMessageListener x1;
    public c.a.q0.q0.b y;
    public ForumManageModel y0;
    public CustomMessageListener y1;
    public long z;
    public c.a.q0.t.e.a z0;
    public View.OnClickListener z1;

    /* loaded from: classes7.dex */
    public class a implements c.a.q0.d1.r<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55092a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55093b;

        public a(PbFragment pbFragment, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55093b = pbFragment;
            this.f55092a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.r
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f55093b.getContext(), this.f55092a, shareItem, false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f55094e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55095f;

        public a0(PbFragment pbFragment, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55095f = pbFragment;
            this.f55094e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.j2.k.e.s0 s0Var = this.f55095f.C0;
                s0Var.V2(TNCManager.TNC_PROBE_HEADER_SECEPTOR + this.f55094e.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55096a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f55097e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a1 f55098f;

            public a(a1 a1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55098f = a1Var;
                this.f55097e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55098f.f55096a.C0 == null || this.f55097e == null) {
                    return;
                }
                this.f55098f.f55096a.C0.e2(this.f55097e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(a1 a1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a1 f55099e;

            public c(a1 a1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55099e = a1Var;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f55099e.f55096a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f55099e.f55096a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public a1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55096a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.q0.t.c.k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f55096a.v0 != null && this.f55096a.v0.P0() != null) {
                        statisticItem.param("fid", this.f55096a.v0.P0().n());
                    }
                    if (this.f55096a.v0 != null) {
                        statisticItem.param("tid", this.f55096a.v0.f1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    c.a.r0.j2.k.e.u0 u0Var = this.f55096a.mContentProcessController;
                    if (u0Var != null) {
                        u0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        c.a.q0.t.h.b.a(this.f55096a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getmAdverSegmentData() == null) {
                        return;
                    }
                    c.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f55096a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f55096a.getActivity(), this.f55096a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f55096a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f55096a.getActivity());
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f55096a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f55096a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.f55096a;
                if (pbFragment.mContentProcessController == null) {
                    return;
                }
                if (pbFragment.C0 != null && this.f55096a.C0.P0() != null && this.f55096a.C0.P0().b() != null && this.f55096a.C0.P0().b().y()) {
                    this.f55096a.C0.P0().b().w(postWriteCallBackData);
                }
                this.f55096a.mContentProcessController.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements c.a.e.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55100a;

        public a2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55100a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
                ((PlayVoiceBntNew) view).resetLayoutParams();
                return view;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).reset();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f55100a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f55100a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }

        public View h(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                ((PlayVoiceBntNew) view).reset();
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface a3 {
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.q0.d1.j0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55101a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55102b;

        public b(PbFragment pbFragment, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55102b = pbFragment;
            this.f55101a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.j0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel pbModel = this.f55102b.getPbModel();
                if (pbModel != null) {
                    pbModel.c2(this.f55101a);
                }
                return c.a.r0.j2.k.e.f1.b.d(this.f55102b.getContext(), this.f55102b.I2(), 2, pbModel);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55103a;

        public b0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55103a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f55103a.Q0.N(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f55103a.C0 != null && this.f55103a.C0.P0() != null && this.f55103a.C0.P0().b() != null) {
                    this.f55103a.C0.P0().b().G();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.f55103a;
                    pbFragment.s3(pbFragment.V0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b1 extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55104a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(PbFragment pbFragment, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55104a = pbFragment;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView Y0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.f55104a.f55086e.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    c.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                    if (this.f55104a.C0 == null || (Y0 = this.f55104a.C0.Y0()) == null || this.f55104a.C0.G0() == null) {
                        return;
                    }
                    this.f55104a.C0.G0().removeHeaderView(Y0);
                    return;
                }
                c.a.e.e.p.l.M(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b2 implements c.a.q0.x.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55105a;

        public b2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55105a = pbFragment;
        }

        @Override // c.a.q0.x.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.j2.k.e.u0 u0Var = this.f55105a.mContentProcessController;
                if (u0Var == null || u0Var.g() == null || !this.f55105a.mContentProcessController.g().d()) {
                    return !this.f55105a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.f55105a;
                pbFragment.showToast(pbFragment.mContentProcessController.g().c());
                if (this.f55105a.C0 != null && this.f55105a.C0.P0() != null && this.f55105a.C0.P0().b() != null && this.f55105a.C0.P0().b().y()) {
                    this.f55105a.C0.P0().b().w(this.f55105a.mContentProcessController.h());
                }
                this.f55105a.mContentProcessController.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.q0.d1.r<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55106a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f55107b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55108c;

        public c(PbFragment pbFragment, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55108c = pbFragment;
            this.f55106a = i2;
            this.f55107b = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.r
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.f55106a);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f55108c.getContext(), this.f55107b, shareItem, false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55109a;

        public c0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55109a = pbFragment;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i2, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, obj}) == null) {
                this.f55109a.C0.h1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i2 == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.f55109a.N3(num.intValue());
                    } else if (i2 == 1990055) {
                        TiebaStatic.log("c12142");
                        c.a.r0.d1.a.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.f55109a.getResources().getString(R.string.neterror);
                        }
                        this.f55109a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c1 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55110a;

        public c1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55110a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2) {
            long j3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j2)}) == null) && c.a.q0.q0.k.d().g()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.f55110a.r : j2;
                if (this.f55110a.s == 0) {
                    this.f55110a.s = currentTimeMillis;
                }
                long j4 = currentTimeMillis;
                c.a.q0.q0.h hVar = new c.a.q0.q0.h(i2, z, responsedMessage, this.f55110a.v, this.f55110a.u, this.f55110a.s, z2, 0L, 0L, j4);
                this.f55110a.u = 0L;
                this.f55110a.v = 0L;
                hVar.c();
                if (z2) {
                    j3 = j4;
                    hVar.B = j3;
                    hVar.e(true);
                } else {
                    j3 = j4;
                }
                if (z2 || this.f55110a.v0 == null || this.f55110a.v0.P0() == null || this.f55110a.v0.P0().O() == null) {
                    return;
                }
                int o1 = this.f55110a.v0.P0().O().o1();
                if (o1 == 0 || o1 == 40) {
                    if (!StringHelper.equals(this.f55110a.P, "from_personalize")) {
                        if (StringHelper.equals(this.f55110a.P, "from_frs")) {
                            c.a.q0.q0.h hVar2 = new c.a.q0.q0.h();
                            hVar2.a(1000);
                            hVar2.D = j3;
                            hVar2.d(o1);
                            return;
                        }
                        return;
                    }
                    c.a.q0.q0.d dVar = new c.a.q0.q0.d();
                    dVar.F = 1;
                    dVar.a(1005);
                    dVar.D = j3;
                    dVar.d(o1);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(c.a.r0.j2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                this.f55110a.C0.u1(eVar);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, c.a.r0.j2.h.e eVar, String str, int i5) {
            c.a.q0.x.h findLauncherById;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
                if (!z || eVar == null || eVar.W() != null || ListUtils.getCount(eVar.F()) >= 1) {
                    if (!this.f55110a.o0) {
                        this.f55110a.o0 = true;
                    } else if (this.f55110a.getPbModel() != null) {
                        this.f55110a.getPbModel().X();
                    }
                    this.f55110a.l = true;
                    this.f55110a.C0.R2();
                    if (eVar == null || !eVar.l0()) {
                        PbFragment pbFragment = this.f55110a;
                        pbFragment.hideLoadingView(pbFragment.C0.b1());
                    }
                    this.f55110a.C0.j1();
                    if (this.f55110a.M || this.f55110a.C0.G1()) {
                        this.f55110a.C0.d1();
                    } else if (!this.f55110a.C0.z1()) {
                        this.f55110a.C0.e3(false);
                    }
                    if (this.f55110a.m) {
                        this.f55110a.m = false;
                    }
                    if (i5 == 0 && eVar != null) {
                        this.f55110a.J0 = true;
                    }
                    if (eVar != null) {
                        PbFragment pbFragment2 = this.f55110a;
                        pbFragment2.hideNetRefreshView(pbFragment2.C0.b1());
                        this.f55110a.C0.Z2();
                    }
                    ArrayList<PostData> arrayList = null;
                    String S0 = null;
                    arrayList = null;
                    if (z && eVar != null) {
                        c.a.q0.s.q.d2 O = eVar.O();
                        if (O != null && O.D2()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.f55110a;
                            pbFragment3.x3(pbFragment3.P0);
                        }
                        this.f55110a.C0.P0().l(eVar);
                        this.f55110a.C0.l3();
                        if (O != null && O.M() != null) {
                            this.f55110a.X3(O.M());
                        }
                        if (this.f55110a.Q0 != null) {
                            this.f55110a.C0.x2(this.f55110a.Q0.E());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(eVar.U().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.U().getBimg_end_time());
                        if (eVar.F() != null && eVar.F().size() >= 1 && eVar.F().get(0) != null) {
                            this.f55110a.v0.a2(eVar.F().get(0).E());
                        } else if (eVar.W() != null) {
                            this.f55110a.v0.a2(eVar.W().E());
                        }
                        if (this.f55110a.Q0 != null) {
                            this.f55110a.Q0.O(eVar.d());
                            this.f55110a.Q0.P(eVar.m(), eVar.U());
                            this.f55110a.Q0.t0(O);
                            this.f55110a.Q0.Q(this.f55110a.v0.s0(), this.f55110a.v0.f1(), this.f55110a.v0.p0());
                            if (O != null) {
                                this.f55110a.Q0.j0(O.l2());
                            }
                        }
                        if (this.f55110a.x0 != null) {
                            this.f55110a.x0.h(eVar.s());
                        }
                        if (eVar.t() == 1) {
                            this.f55110a.w = true;
                        } else {
                            this.f55110a.w = false;
                        }
                        if (eVar.f0()) {
                            this.f55110a.w = true;
                        }
                        this.f55110a.C0.y2(this.f55110a.w);
                        this.f55110a.C0.p3(eVar, i3, i4, this.f55110a.v0.d1(), i5, this.f55110a.v0.z0());
                        this.f55110a.C0.B3(eVar, this.f55110a.v0.d1());
                        this.f55110a.C0.G3(this.f55110a.v0.t0());
                        AntiData d2 = eVar.d();
                        if (d2 != null) {
                            this.f55110a.D = d2.getVoice_message();
                            if (!StringUtils.isNull(this.f55110a.D) && this.f55110a.Q0 != null && this.f55110a.Q0.a() != null && (findLauncherById = this.f55110a.Q0.a().findLauncherById(6)) != null && !TextUtils.isEmpty(this.f55110a.D)) {
                                ((View) findLauncherById).setOnClickListener(this.f55110a.z1);
                            }
                        }
                        if (!this.f55110a.b0 && !ListUtils.isEmpty(this.f55110a.v0.P0().F()) && !this.f55110a.v0.q1()) {
                            this.f55110a.b0 = true;
                            this.f55110a.checkEasterEgg(false);
                        }
                        if (!TextUtils.isEmpty(this.f55110a.M0)) {
                            c.a.r0.j2.k.e.a1.k.f(this.f55110a.getListView(), this.f55110a.M0);
                            this.f55110a.M0 = null;
                        } else if (this.f55110a.L0) {
                            this.f55110a.L0 = false;
                            c.a.r0.j2.k.e.a1.k.e(this.f55110a.getListView());
                        } else if (this.f55110a.N0) {
                            this.f55110a.N0 = false;
                            c.a.r0.j2.k.e.a1.k.g(this.f55110a.getListView());
                        } else {
                            this.f55110a.C0.k3();
                        }
                        this.f55110a.v0.y1(eVar.m(), this.f55110a.D1);
                        this.f55110a.v0.E1(this.f55110a.F1);
                        if (this.f55110a.mReplyPrivacyController != null && O != null && O.J() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.J());
                            this.f55110a.mReplyPrivacyController.setLikeUserData(attentionHostData);
                        }
                        if (this.f55110a.v0 == null || !this.f55110a.v0.p1()) {
                            if (this.f55110a.C0 != null) {
                                S0 = this.f55110a.C0.S0();
                            }
                        } else {
                            S0 = this.f55110a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                        }
                        if (!StringUtils.isNull(S0)) {
                            this.f55110a.Q0.m0(TbSingleton.getInstance().getAdVertiComment(eVar.j0(), eVar.k0(), S0));
                        }
                    } else if (str != null) {
                        if (this.f55110a.J0 || i5 != 1) {
                            this.f55110a.showToast(str);
                        } else if (i3 == 3 || i3 == 4 || i3 == 6) {
                            if (i2 == 4) {
                                if (this.f55110a.v0.g0() != null && !StringUtils.isNull(this.f55110a.v0.g0().f19622c)) {
                                    this.f55110a.C0.I3(this.f55110a.v0.g0());
                                } else {
                                    PbFragment pbFragment4 = this.f55110a;
                                    pbFragment4.showNetRefreshView(pbFragment4.C0.b1(), this.f55110a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                                    PbFragment pbFragment5 = this.f55110a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(c.a.e.e.p.l.g(pbFragment5.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment pbFragment6 = this.f55110a;
                                pbFragment6.showNetRefreshView(pbFragment6.C0.b1(), this.f55110a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                                PbFragment pbFragment7 = this.f55110a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(c.a.e.e.p.l.g(pbFragment7.getContext(), R.dimen.ds360));
                            }
                            this.f55110a.C0.d1();
                            this.f55110a.C0.c1();
                        }
                        if (i2 == 4 || i2 == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.f55110a.v0.f1());
                                jSONObject.put("fid", this.f55110a.v0.getForumId());
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
                            if (this.f55110a.v0 != null && this.f55110a.v0.P0() != null) {
                                arrayList = this.f55110a.v0.P0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f55110a.C0.u2(this.f55110a.getResources().getString(R.string.list_no_more_new));
                            } else {
                                if (this.f55110a.isHostOnlyMode()) {
                                    this.f55110a.C0.v2(this.f55110a.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    this.f55110a.C0.v2(this.f55110a.getResources().getString(R.string.pb_no_replay));
                                }
                                this.f55110a.C0.u1(this.f55110a.v0.P0());
                            }
                        } else {
                            this.f55110a.C0.u2("");
                        }
                        this.f55110a.C0.k0();
                    }
                    if (eVar != null && eVar.m && this.f55110a.s == 0) {
                        this.f55110a.s = System.currentTimeMillis() - this.f55110a.r;
                    }
                    if (this.f55110a.getPbModel().d1() && this.f55110a.getPbModel().P0().y().c() == 0 && !this.f55110a.getPbModel().o1()) {
                        return;
                    }
                    this.f55110a.R0 = true;
                    return;
                }
                this.f55110a.v0.m2(1);
                if (this.f55110a.f55090i != null) {
                    this.f55110a.f55090i.x();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f55110a.v0 == null) {
                return;
            }
            if (this.f55110a.Q0 == null || !this.f55110a.Q0.z) {
                c.a.q0.x.w.d dVar = new c.a.q0.x.w.d();
                this.f55110a.x3(dVar);
                PbFragment pbFragment = this.f55110a;
                pbFragment.Q0 = (c.a.q0.x.w.e) dVar.a(pbFragment.getContext());
                this.f55110a.Q0.g0(this.f55110a.f55086e.getPageContext());
                this.f55110a.Q0.p0(this.f55110a.U1);
                this.f55110a.Q0.q0(this.f55110a.W0);
                this.f55110a.Q0.H(this.f55110a.f55086e.getPageContext(), this.f55110a.f55086e.getIntent() == null ? null : this.f55110a.f55086e.getIntent().getExtras());
                this.f55110a.Q0.a().showLinePositionBottom(true);
                this.f55110a.C0.t2(this.f55110a.Q0.a());
                if (!this.f55110a.v0.D0()) {
                    this.f55110a.Q0.t(this.f55110a.v0.f1());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.f55110a.Q0.m0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.f55110a.v0.p1()) {
                    this.f55110a.Q0.m0(this.f55110a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else if (this.f55110a.C0 != null) {
                    this.f55110a.Q0.m0(this.f55110a.C0.S0());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements c.a.e.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55111a;

        public c2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55111a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f55111a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55112a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55112a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55112a.v0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.f55112a.Q0 != null) {
                this.f55112a.C0.x2(this.f55112a.Q0.E());
            }
            this.f55112a.C0.q2();
            this.f55112a.C0.e0();
        }
    }

    /* loaded from: classes7.dex */
    public class d0 extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55113a;

        public d0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55113a = pbFragment;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55114a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d1(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55114a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f55114a.W3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d2 implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55115a;

        public d2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55115a = pbFragment;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            c.a.r0.j2.k.e.h p0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view.getTag() instanceof TbRichText) && str == null) {
                        if (this.f55115a.checkUpIsLogin()) {
                            this.f55115a.C0.P1((TbRichText) view.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.f55115a.v0.f1());
                    statisticItem.param("fid", this.f55115a.v0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.f55115a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        if (this.f55115a.v0.J.f0()) {
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
                            this.f55115a.H2(rect);
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i3);
                            bVar.C(false);
                            bVar.F(this.f55115a.v0.a1());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.f55115a.isHostOnlyMode());
                            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
                            if (this.f55115a.v0 != null) {
                                bVar.A(this.f55115a.v0.getFromForumId());
                                if (this.f55115a.v0.P0() != null) {
                                    bVar.N(this.f55115a.v0.P0().O());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.f55115a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.f55115a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.f55115a.o3(str, i2, eVar);
                        if (eVar.f55060h) {
                            TbRichText Z3 = this.f55115a.Z3(str, i2);
                            if (Z3 != null && this.f55115a.g2 >= 0 && this.f55115a.g2 < Z3.y().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a2 = c.a.r0.j2.h.f.a(Z3.y().get(this.f55115a.g2));
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= eVar.f55053a.size()) {
                                        break;
                                    } else if (eVar.f55053a.get(i7).equals(a2)) {
                                        eVar.f55062j = i7;
                                        arrayList2.add(a2);
                                        break;
                                    } else {
                                        i7++;
                                    }
                                }
                                if (Z3.getPostId() != 0 && (p0 = this.f55115a.C0.p0()) != null) {
                                    ArrayList<c.a.e.l.e.n> s = p0.s();
                                    if (ListUtils.getCount(s) > 0) {
                                        Iterator<c.a.e.l.e.n> it = s.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            c.a.e.l.e.n next = it.next();
                                            if ((next instanceof PostData) && Z3.getPostId() == c.a.e.e.m.b.g(((PostData) next).E(), 0L)) {
                                                c.a.r0.j2.m.a.b(this.f55115a.v0.P0(), (PostData) next, ((PostData) next).i0, Z3.getPostId() == c.a.e.e.m.b.g(this.f55115a.v0.p0(), 0L) ? 1 : 8, 3);
                                            }
                                        }
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.f55054b.get(str2));
                                }
                                Rect rect2 = new Rect();
                                view.getGlobalVisibleRect(rect2);
                                this.f55115a.H2(rect2);
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.f55055c);
                                bVar2.y(eVar.f55056d);
                                bVar2.O(eVar.f55057e);
                                bVar2.C(eVar.f55059g);
                                bVar2.H(true);
                                bVar2.J(eVar.f55061i);
                                bVar2.F(this.f55115a.v0.a1());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.f55115a.isHostOnlyMode());
                                bVar2.L(eVar.f55058f);
                                bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                                if (this.f55115a.v0 != null) {
                                    bVar2.A(this.f55115a.v0.getFromForumId());
                                    if (this.f55115a.v0.P0() != null) {
                                        bVar2.N(this.f55115a.v0.P0().O());
                                    }
                                }
                                ImageViewerConfig v2 = bVar2.v(this.f55115a.getPageContext().getPageActivity());
                                v2.getIntent().putExtra("from", "pb");
                                this.f55115a.sendMessage(new CustomMessage(2010000, v2));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.f55053a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.f55054b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.f55055c);
                        bVar3.y(eVar.f55056d);
                        bVar3.O(eVar.f55057e);
                        bVar3.C(eVar.f55059g);
                        bVar3.H(true);
                        bVar3.J(eVar.f55053a.get(0));
                        bVar3.F(this.f55115a.v0.a1());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.f55115a.isHostOnlyMode());
                        bVar3.L(eVar.f55058f);
                        bVar3.D(false);
                        if (this.f55115a.v0 != null) {
                            bVar3.A(this.f55115a.v0.getFromForumId());
                            if (this.f55115a.v0.P0() != null) {
                                bVar3.N(this.f55115a.v0.P0().O());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.f55115a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.f55115a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.f55115a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.f55115a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    this.f55115a.V = view;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55116a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55116a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.f55116a.v0.u2((UserPendantData) customResponsedMessage.getData());
                if (this.f55116a.C0 != null && this.f55116a.v0 != null) {
                    this.f55116a.C0.k2(this.f55116a.v0.P0(), this.f55116a.v0.d1(), this.f55116a.v0.Z0(), this.f55116a.C0.W0());
                }
                if (this.f55116a.C0 == null || this.f55116a.C0.p0() == null) {
                    return;
                }
                this.f55116a.C0.p0().X();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements z2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55117a;

        public e0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55117a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.z2
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!c.a.e.e.p.j.z()) {
                    this.f55117a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f55117a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f55117a.getPageContext().getPageActivity(), this.f55117a.v0.P0().m().getId(), this.f55117a.v0.P0().m().getName(), this.f55117a.v0.P0().O().f0(), String.valueOf(this.f55117a.v0.P0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55118a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e1(PbFragment pbFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55118a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f55118a.C0 != null) {
                    PbFragment pbFragment = this.f55118a;
                    pbFragment.hideLoadingView(pbFragment.C0.b1());
                    this.f55118a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            new BdTopToast(this.f55118a.getContext()).setIcon(true).setContent(this.f55118a.getString(R.string.block_user_success)).show((ViewGroup) this.f55118a.getView());
                            this.f55118a.y3(type);
                            return;
                        }
                        new BdTopToast(this.f55118a.getContext()).setIcon(false).setContent(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f55118a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString()).show((ViewGroup) this.f55118a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e2 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55119a;

        public e2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55119a = pbFragment;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                PbFragment pbFragment = this.f55119a;
                PostData postData = pbFragment.j2;
                if (postData != null) {
                    if (i2 == 0) {
                        postData.j0(pbFragment.getPageContext().getPageActivity());
                        this.f55119a.j2 = null;
                    } else if (i2 == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.f55119a;
                        pbFragment2.markFloor(pbFragment2.j2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55120a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55120a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.f55120a.C0 == null) {
                return;
            }
            if (booleanValue) {
                this.f55120a.C0.w3();
            } else {
                this.f55120a.C0.j1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55121a;

        public f0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55121a = pbFragment;
        }

        @Override // c.a.r0.j2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.j2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f55121a.isAdded()) {
                    if (view != null) {
                        if (view.getId() == R.id.richText) {
                            if (this.f55121a.richTextHandleSingleTap(view)) {
                                return true;
                            }
                        } else if (view.getId() == R.id.pb_floor_item_layout) {
                            if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                                this.f55121a.R3((SparseArray) view.getTag(R.id.tag_from));
                            }
                        } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                            if (this.f55121a.C0.B1() && view.getId() == R.id.pb_head_user_info_root) {
                                if (view.getTag(R.id.tag_user_id) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view.getTag(R.id.tag_user_id)));
                                }
                                if (this.f55121a.getEventController() != null && this.f55121a.getEventController().f19960b != null) {
                                    this.f55121a.getEventController().f19960b.onClick(view);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.f55121a.R3(sparseArray);
                        }
                    }
                    if (this.f55121a.Q0 != null) {
                        this.f55121a.C0.x2(this.f55121a.Q0.E());
                    }
                    this.f55121a.C0.q2();
                    this.f55121a.C0.e0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.j2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.f55121a.isAdded()) {
                    this.f55121a.doDoubleClick();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f1 implements c.a.q0.x.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55122a;

        public f1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55122a = pbFragment;
        }

        @Override // c.a.q0.x.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55122a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f2 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55123a;

        public f2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55123a = pbFragment;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.f55123a.g1 == null || TextUtils.isEmpty(this.f55123a.h1)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f55123a.i1 == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f55123a.h1));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f12816a = this.f55123a.h1;
                        String str = "";
                        if (this.f55123a.i1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f55123a.i1.memeInfo.pck_id;
                        }
                        aVar.f12817b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f55123a.S0 == null) {
                        this.f55123a.S0 = new PermissionJudgePolicy();
                    }
                    this.f55123a.S0.clearRequestPermissionList();
                    this.f55123a.S0.appendRequestPermission(this.f55123a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.f55123a.S0.startRequestPermission(this.f55123a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f55123a.f1 == null) {
                        PbFragment pbFragment = this.f55123a;
                        pbFragment.f1 = new c.a.r0.j2.k.e.w0(pbFragment.getPageContext());
                    }
                    this.f55123a.f1.b(this.f55123a.h1, this.f55123a.g1.n());
                }
                this.f55123a.g1 = null;
                this.f55123a.h1 = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55124a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55124a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f55124a.Q0 != null) {
                this.f55124a.C0.x2(this.f55124a.Q0.E());
            }
            this.f55124a.C0.e3(false);
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55125a;

        public g0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55125a = pbFragment;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f55125a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.f55125a;
                    pbFragment.I0 = pbFragment.I0.trim();
                    UtilHelper.callPhone(this.f55125a.getPageContext().getPageActivity(), this.f55125a.I0);
                    new c.a.r0.j2.k.e.c(this.f55125a.v0.f1(), this.f55125a.I0, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f55125a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    PbFragment pbFragment2 = this.f55125a;
                    pbFragment2.I0 = pbFragment2.I0.trim();
                    UtilHelper.smsPhone(this.f55125a.getPageContext().getPageActivity(), this.f55125a.I0);
                    new c.a.r0.j2.k.e.c(this.f55125a.v0.f1(), this.f55125a.I0, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    PbFragment pbFragment3 = this.f55125a;
                    pbFragment3.I0 = pbFragment3.I0.trim();
                    UtilHelper.startBaiDuBar(this.f55125a.getPageContext().getPageActivity(), this.f55125a.I0);
                    bVar.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g1 implements a.InterfaceC0668a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55126a;

        public g1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55126a = pbFragment;
        }

        @Override // c.a.q0.i.a.InterfaceC0668a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f55126a.C0.R2();
                if (z) {
                    if (this.f55126a.x0 != null) {
                        this.f55126a.x0.h(z2);
                    }
                    this.f55126a.v0.o2(z2);
                    if (this.f55126a.v0.B0()) {
                        this.f55126a.j3();
                    } else {
                        this.f55126a.C0.u1(this.f55126a.v0.P0());
                    }
                    if (z2) {
                        if (this.f55126a.x0 != null) {
                            if (this.f55126a.x0.f() == null || this.f55126a.v0 == null || this.f55126a.v0.P0() == null || this.f55126a.v0.P0().O() == null || this.f55126a.v0.P0().O().J() == null) {
                                return;
                            }
                            MarkData f2 = this.f55126a.x0.f();
                            MetaData J = this.f55126a.v0.P0().O().J();
                            if (f2 != null && J != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), J.getUserId()) && !J.hadConcerned()) {
                                    this.f55126a.I3(J);
                                } else {
                                    this.f55126a.showToast(R.string.add_mark_on_pb);
                                    if (c.a.q0.t.h.a.e(this.f55126a.getContext(), 0)) {
                                        c.a.q0.t.h.a.g(this.f55126a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment pbFragment = this.f55126a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                            }
                        }
                        this.f55126a.v2();
                        return;
                    }
                    PbFragment pbFragment2 = this.f55126a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                PbFragment pbFragment3 = this.f55126a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g2 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55127e;

        public g2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55127e = pbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f55127e.v0 == null || this.f55127e.v0.Y0() == i2 + 1) {
                return;
            }
            PbFragment pbFragment = this.f55127e;
            pbFragment.w3(pbFragment.R2(i2));
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55128a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55128a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            c.a.r0.j2.e eVar = (c.a.r0.j2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                this.f55128a.refreshWrite((c.a.r0.j2.h.r) eVar.a());
            } else if (b2 == 1) {
                this.f55128a.F2((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    this.f55128a.refreshMark(false, null);
                } else {
                    this.f55128a.refreshMark(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55129a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55129a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f55129a.d1) {
                this.f55129a.C0.h1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                c.a.r0.j2.h.e P0 = this.f55129a.v0.P0();
                if (P0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    P0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f55129a.c1.c(this.f55129a.b1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f55129a.b1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.f55129a.O3(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f55129a.J3();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (c.a.e.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f55129a.b1.getResources().getString(R.string.mute_fail);
                    }
                    this.f55129a.c1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f55130e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55131f;

        public h1(PbFragment pbFragment, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55131f = pbFragment;
            this.f55130e = metaData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f55130e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h2 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55132e;

        public h2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55132e = pbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                PbFragment pbFragment = this.f55132e;
                pbFragment.f55087f = true;
                return pbFragment.C2(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55133a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55133a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55133a.C0 == null || this.f55133a.C0.p0() == null) {
                return;
            }
            this.f55133a.C0.p0().X();
        }
    }

    /* loaded from: classes7.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55134a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55134a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f55134a.d1) {
                this.f55134a.C0.h1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f55134a.c1.c(this.f55134a.b1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (c.a.e.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f55134a.b1.getResources().getString(R.string.un_mute_fail);
                }
                this.f55134a.c1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f55135e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55136f;

        public i1(PbFragment pbFragment, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55136f = pbFragment;
            this.f55135e = metaData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f55135e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                this.f55136f.z0.m(!this.f55135e.hadConcerned(), this.f55135e.getPortrait(), this.f55135e.getUserId(), this.f55135e.isGod(), "6", this.f55136f.getPageContext().getUniqueId(), this.f55136f.v0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55137e;

        public i2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55137e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.l(this.f55137e.getContext(), this.f55137e.getUniqueId(), view, (ViewGroup) this.f55137e.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55138a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55138a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e.a)) {
                e.a aVar = (e.a) customResponsedMessage.getData();
                c.a.q0.f1.m.e.c(this.f55138a.getPageContext(), this.f55138a, aVar.f13280a, aVar.f13281b, aVar.f13282c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55139e;

        public j0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55139e = pbFragment;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.f55139e.v0 != null && this.f55139e.v0.B0()) {
                    this.f55139e.j3();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55140e;

        public j1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55140e = pbFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            ArrayList<PostData> F;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || this.f55140e.v0 == null || this.f55140e.v0.P0() == null || this.f55140e.C0 == null || this.f55140e.C0.p0() == null) {
                return;
            }
            this.f55140e.C0.V1(absListView, i2, i3, i4);
            if (this.f55140e.f55090i != null) {
                this.f55140e.f55090i.q(absListView, i2, i3, i4);
            }
            if (!this.f55140e.v0.r1() || (F = this.f55140e.v0.P0().F()) == null || F.isEmpty()) {
                return;
            }
            int w = ((i2 + i3) - this.f55140e.C0.p0().w()) - 1;
            c.a.r0.j2.h.e P0 = this.f55140e.v0.P0();
            if (P0 == null) {
                return;
            }
            if (P0.D() != null && P0.D().E0()) {
                w--;
            }
            if (P0.E() != null && P0.E().E0()) {
                w--;
            }
            int size = F.size();
            if (w < 0 || w >= size) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                PbFragment pbFragment = this.f55140e;
                if (!pbFragment.c3(pbFragment.Z0) && this.f55140e.c3(i2)) {
                    if (this.f55140e.C0 != null) {
                        this.f55140e.C0.e0();
                        if (this.f55140e.Q0 != null && !this.f55140e.C0.w1()) {
                            this.f55140e.C0.x2(this.f55140e.Q0.E());
                        }
                        if (!this.f55140e.M) {
                            this.f55140e.C0.q2();
                        }
                    }
                    if (!this.f55140e.x) {
                        this.f55140e.x = true;
                    }
                }
                if (this.f55140e.C0 != null) {
                    this.f55140e.C0.W1(absListView, i2);
                }
                if (this.f55140e.f55090i != null) {
                    this.f55140e.f55090i.r(absListView, i2);
                }
                if (this.f55140e.y == null) {
                    this.f55140e.y = new c.a.q0.q0.b();
                    this.f55140e.y.a(1001);
                }
                if (i2 == 0) {
                    this.f55140e.y.e();
                } else {
                    this.f55140e.y.d();
                }
                this.f55140e.Z0 = i2;
                if (i2 == 0) {
                    this.f55140e.u3(false, null);
                    c.a.r0.i3.c.g().h(this.f55140e.getUniqueId(), true);
                    this.f55140e.checkEasterEgg(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55141a;

        public j2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55141a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                ItemCardHelper.w(this.f55141a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.f55141a.getView(), j2);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.w(this.f55141a.getContext(), ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.f55141a.getView(), 0L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55142a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55142a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55142a.k) {
                return;
            }
            this.f55142a.Q3();
        }
    }

    /* loaded from: classes7.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55143a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55143a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.u3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f55143a.d1) {
                c.a.r0.u3.a aVar = (c.a.r0.u3.a) customResponsedMessage.getData();
                this.f55143a.C0.h1();
                SparseArray<Object> sparseArray = (SparseArray) this.f55143a.a1;
                DataRes dataRes = aVar.f25467a;
                if (aVar.f25469c == 0 && dataRes != null) {
                    int e2 = c.a.e.e.m.b.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = e2 == 1;
                    if (c.a.e.e.p.k.isEmpty(str)) {
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
                    this.f55143a.K3(r2, sparseArray);
                } else if (intValue == 1) {
                    this.f55143a.C0.c2(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k1 implements Comparator<c.a.q0.u.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55144e;

        public k1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55144e = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c.a.q0.u.a aVar, c.a.q0.u.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) ? aVar.compareTo(aVar2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k2 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55145e;

        public k2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55145e = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.f55145e.k && z && !this.f55145e.v0.F0()) {
                    this.f55145e.r3();
                }
                PbFragment pbFragment = this.f55145e;
                pbFragment.setNetRefreshViewEmotionMarginTop(c.a.e.e.p.l.g(pbFragment.getContext(), R.dimen.ds360));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55146a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55146a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.f55146a.getContext()).setIcon(false).setContent(this.f55146a.getString(R.string.novel_thread_mask_click_tip)).show((ViewGroup) this.f55146a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55147a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55147a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f55147a.C0.w1() && (customResponsedMessage.getData() instanceof Integer)) {
                this.f55147a.doDoubleClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55148a;

        public l1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55148a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements c.a.e.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55149a;

        public l2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55149a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.f55149a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.pb_text_voice_layout);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setGravity(16);
                linearLayout.setBaselineAligned(true);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(layoutParams);
                return linearLayout;
            }
            return (LinearLayout) invokeV.objValue;
        }

        public LinearLayout h(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linearLayout)) == null) {
                linearLayout.removeAllViews();
                return linearLayout;
            }
            return (LinearLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55150e;

        public m(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55150e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PbFragment pbFragment = this.f55150e;
                pbFragment.showToast(pbFragment.D);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55151a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55151a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.r0.j3.i0.e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.r0.j3.i0.e) || (eVar = (c.a.r0.j3.i0.e) customResponsedMessage.getData()) == null || (agreeData = eVar.f20853b) == null || agreeData.agreeType != 2 || this.f55151a.C0 == null || !c.a.q0.b.d.Q() || c.a.r0.j2.k.e.f1.b.k(this.f55151a.v0.f55294f)) {
                return;
            }
            this.f55151a.C0.x3();
            c.a.r0.j2.k.e.f1.b.b(this.f55151a.v0.f55294f);
        }
    }

    /* loaded from: classes7.dex */
    public class m1 extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55152a;

        public m1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55152a = pbFragment;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.f55152a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.f55152a.y0.getLoadDataMode()) {
                        case 0:
                            this.f55152a.v0.m1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.f55152a.F2(bVar, (bVar.f57246e != 1002 || bVar.f57247f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.f55152a.C0.m0(1, dVar.f57250a, dVar.f57251b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.f55152a;
                            pbFragment.G2(pbFragment.y0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.f55152a.C0.m0(this.f55152a.y0.getLoadDataMode(), gVar.f57264a, gVar.f57265b, false);
                            this.f55152a.C0.X1(gVar.f57266c);
                            return;
                        default:
                            return;
                    }
                }
                this.f55152a.C0.m0(this.f55152a.y0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m2 implements y2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55153a;

        public m2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55153a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.y2
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f55153a.C0 != null && this.f55153a.C0.P0() != null) {
                    c.a.r0.j2.k.e.t P0 = this.f55153a.C0.P0();
                    if (P0.f()) {
                        P0.d();
                        return true;
                    }
                }
                if (this.f55153a.C0 == null || !this.f55153a.C0.J1()) {
                    return false;
                }
                this.f55153a.C0.l1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class n implements TiePlusEventController.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55154a;

        public n(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55154a = pbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.d
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55154a.A = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55155a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55155a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            this.f55155a.j1 = true;
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55156e;

        public n1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55156e = pbFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class n2 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55157e;

        public n2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55157e = pbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                FrameLayout frameLayout = (FrameLayout) this.f55157e.getPageContext().getPageActivity().getWindow().getDecorView();
                for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                    View childAt = frameLayout.getChildAt(i2);
                    if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                        break;
                    }
                }
                this.f55157e.f55089h.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55158a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55158a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.s.q.j0)) {
                c.a.q0.s.q.j0 j0Var = (c.a.q0.s.q.j0) customResponsedMessage.getData();
                d1.a aVar = new d1.a();
                int i2 = j0Var.f14220a;
                String str = j0Var.f14221b;
                aVar.f14135a = j0Var.f14223d;
                c.a.r0.j2.h.e P0 = this.f55158a.v0.P0();
                if (P0 == null) {
                    return;
                }
                if (this.f55158a.v0.s0() != null && this.f55158a.v0.s0().getUserIdLong() == j0Var.p) {
                    this.f55158a.C0.j2(j0Var.l, this.f55158a.v0.P0(), this.f55158a.v0.d1(), this.f55158a.v0.Z0());
                }
                if (P0.F() == null || P0.F().size() < 1 || P0.F().get(0) == null) {
                    return;
                }
                long g2 = c.a.e.e.m.b.g(P0.F().get(0).E(), 0L);
                long g3 = c.a.e.e.m.b.g(this.f55158a.v0.f1(), 0L);
                if (g2 == j0Var.n && g3 == j0Var.m) {
                    c.a.q0.s.q.d1 D = P0.F().get(0).D();
                    if (D == null) {
                        D = new c.a.q0.s.q.d1();
                    }
                    ArrayList<d1.a> a2 = D.a();
                    if (a2 == null) {
                        a2 = new ArrayList<>();
                    }
                    a2.add(0, aVar);
                    D.e(D.b() + j0Var.l);
                    D.d(a2);
                    P0.F().get(0).m0(D);
                    this.f55158a.C0.p0().X();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55159e;

        public o0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55159e = pbFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f55159e.hideKeyBroad();
                c.a.q0.s.q.b1 N0 = this.f55159e.v0.N0();
                int M0 = this.f55159e.C0.M0();
                if (M0 <= 0) {
                    this.f55159e.showToast(R.string.pb_page_error);
                } else if (N0 == null || M0 <= N0.h()) {
                    this.f55159e.C0.e0();
                    this.f55159e.stopVoice();
                    this.f55159e.C0.S2();
                    if (c.a.e.e.p.j.z()) {
                        this.f55159e.v0.m2(this.f55159e.C0.M0());
                        if (this.f55159e.f55090i != null) {
                            this.f55159e.f55090i.x();
                        }
                    } else {
                        this.f55159e.showToast(R.string.neterror);
                    }
                    aVar.dismiss();
                } else {
                    this.f55159e.showToast(R.string.pb_page_error);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o1 implements a3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55160a;

        public o1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55160a = pbFragment;
        }
    }

    /* loaded from: classes7.dex */
    public class o2 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f55161a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55162b;

        public o2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55162b = pbFragment;
            this.f55161a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);
        }

        @Override // c.a.r0.j0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || !e(i3) || this.f55162b.C0 == null || this.f55162b.f55090i == null) {
                return;
            }
            this.f55162b.f55090i.u(true);
            if (Math.abs(i3) > this.f55161a) {
                this.f55162b.f55090i.l();
            }
            if (this.f55162b.getIsMangaThread()) {
                this.f55162b.C0.i1();
                this.f55162b.C0.s2();
            }
        }

        @Override // c.a.r0.j0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || !e(i3) || this.f55162b.C0 == null || this.f55162b.f55090i == null) {
                return;
            }
            this.f55162b.C0.u3();
            this.f55162b.f55090i.u(false);
            this.f55162b.f55090i.x();
        }

        @Override // c.a.r0.j0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.r0.j0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }

        public final boolean e(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) ? Math.abs(f2) >= 1.0f : invokeF.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55163a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55163a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f55163a.v0 == null || this.f55163a.v0.P0() == null) {
                return;
            }
            this.f55163a.v0.P0().a();
            this.f55163a.v0.m1();
            if (this.f55163a.C0.p0() != null) {
                this.f55163a.C0.u1(this.f55163a.v0.P0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes7.dex */
    public class p0 implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55164e;

        public p0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55164e = pbFragment;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f55164e.G0 != null) {
                    this.f55164e.G0.dismiss();
                }
                this.f55164e.V3(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                        this.f55164e.q3(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                        this.f55164e.q3(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view4 != null) {
                            AgreeView agreeView = (AgreeView) view4;
                            this.f55164e.q3(view4);
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
                            this.f55164e.q3(view5);
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
                        if (this.f55164e.g1 == null || TextUtils.isEmpty(this.f55164e.h1)) {
                            return;
                        }
                        if (this.f55164e.i1 == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f55164e.h1));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f12816a = this.f55164e.h1;
                            String str = "";
                            if (this.f55164e.i1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f55164e.i1.memeInfo.pck_id;
                            }
                            aVar.f12817b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f55164e.g1 = null;
                        this.f55164e.h1 = null;
                        return;
                    case 2:
                        if (this.f55164e.g1 == null || TextUtils.isEmpty(this.f55164e.h1)) {
                            return;
                        }
                        if (this.f55164e.S0 == null) {
                            this.f55164e.S0 = new PermissionJudgePolicy();
                        }
                        this.f55164e.S0.clearRequestPermissionList();
                        this.f55164e.S0.appendRequestPermission(this.f55164e.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f55164e.S0.startRequestPermission(this.f55164e.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f55164e.f1 == null) {
                            PbFragment pbFragment = this.f55164e;
                            pbFragment.f1 = new c.a.r0.j2.k.e.w0(pbFragment.getPageContext());
                        }
                        this.f55164e.f1.b(this.f55164e.h1, this.f55164e.g1.n());
                        this.f55164e.g1 = null;
                        this.f55164e.h1 = null;
                        return;
                    case 3:
                        PbFragment pbFragment2 = this.f55164e;
                        PostData postData = pbFragment2.j2;
                        if (postData != null) {
                            postData.j0(pbFragment2.getPageContext().getPageActivity());
                            this.f55164e.j2 = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f55164e.checkUpIsLogin()) {
                            this.f55164e.l3(view);
                            if (this.f55164e.v0.P0().O() == null || this.f55164e.v0.P0().O().J() == null || this.f55164e.v0.P0().O().J().getUserId() == null || this.f55164e.x0 == null) {
                                return;
                            }
                            PbFragment pbFragment3 = this.f55164e;
                            int S2 = pbFragment3.S2(pbFragment3.v0.P0());
                            c.a.q0.s.q.d2 O = this.f55164e.v0.P0().O();
                            if (O.M1()) {
                                i3 = 2;
                            } else if (O.P1()) {
                                i3 = 3;
                            } else if (!O.N1()) {
                                i3 = O.O1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f55164e.v0.f55294f).param("obj_locate", 2).param("obj_id", this.f55164e.v0.P0().O().J().getUserId()).param("obj_type", !this.f55164e.x0.e()).param("obj_source", S2).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!c.a.e.e.p.j.z()) {
                            this.f55164e.showToast(R.string.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f55164e.U2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.f55164e.checkMuteState(sparseArray2);
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
                            boolean isHost = this.f55164e.getPbActivity().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f55164e.D3(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f55164e.C0.a2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f55164e.D3(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f55164e.C0.Y1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!c.a.e.e.p.j.z()) {
                            this.f55164e.showToast(R.string.network_not_available);
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
                                this.f55164e.C0.Y1(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.tag_from, 1);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f55164e.checkMuteState(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f55164e.C0.d2(view);
                            return;
                        }
                    case 8:
                        if (this.f55164e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.f55164e.A2(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.f55164e.checkUpIsLogin() || this.f55164e.v0 == null || this.f55164e.v0.P0() == null) {
                            return;
                        }
                        this.f55164e.f55086e.showBlockDialog(c.a.r0.t3.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p1 implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55165e;

        public p1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55165e = pbFragment;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f55165e.getIsMangaThread()) {
                    this.f55165e.f55086e.finish();
                }
                if (!this.f55165e.v0.D1(true)) {
                    this.f55165e.C0.l0();
                } else {
                    TiebaStatic.eventStat(this.f55165e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class p2 implements b.InterfaceC0936b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p2() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.j0.b.InterfaceC0936b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.r0.j2.i.b.d();
                } else {
                    c.a.r0.j2.i.b.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55166a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55166a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f55166a.v0 == null || this.f55166a.v0.P0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.f55166a.D2(str);
            this.f55166a.v0.m1();
            if (!TextUtils.isEmpty(str) && this.f55166a.v0.P0().F() != null) {
                ArrayList<PostData> F = this.f55166a.v0.P0().F();
                c.a.r0.j3.i0.p pVar = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof c.a.r0.j3.i0.p) {
                        c.a.r0.j3.i0.p pVar2 = (c.a.r0.j3.i0.p) next;
                        if (str.equals(pVar2.F0())) {
                            pVar = pVar2;
                            break;
                        }
                    }
                }
                if (pVar != null) {
                    F.remove(pVar);
                    if (this.f55166a.C0.p0() != null && this.f55166a.C0.p0().s() != null) {
                        this.f55166a.C0.p0().s().remove(pVar);
                    }
                    if (this.f55166a.C0.G0() != null && this.f55166a.C0.G0().getData() != null) {
                        this.f55166a.C0.G0().getData().remove(pVar);
                    }
                    if (this.f55166a.C0.p0() != null) {
                        this.f55166a.C0.p0().X();
                        return;
                    }
                }
            }
            if (this.f55166a.C0.p0() != null) {
                this.f55166a.C0.u1(this.f55166a.v0.P0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f55167e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55168f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f55169g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55170h;

        public q0(PbFragment pbFragment, SparseArray sparseArray, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55170h = pbFragment;
            this.f55167e = sparseArray;
            this.f55168f = i2;
            this.f55169g = z;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f55170h.deleteThreadDirect(((Integer) this.f55167e.get(R.id.tag_del_post_type)).intValue(), (String) this.f55167e.get(R.id.tag_del_post_id), this.f55168f, this.f55169g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q1 implements c.a.q0.x.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55171a;

        public q1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55171a = pbFragment;
        }

        @Override // c.a.q0.x.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.j2.k.e.u0 u0Var = this.f55171a.mContentProcessController;
                if (u0Var == null || u0Var.e() == null || !this.f55171a.mContentProcessController.e().d()) {
                    return !this.f55171a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.f55171a;
                pbFragment.showToast(pbFragment.mContentProcessController.e().c());
                if (this.f55171a.Q0 != null && (this.f55171a.Q0.D() || this.f55171a.Q0.F())) {
                    this.f55171a.Q0.B(false, this.f55171a.mContentProcessController.h());
                }
                this.f55171a.mContentProcessController.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q2 implements p.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55172a;

        public q2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55172a = pbFragment;
        }

        @Override // c.a.r0.j2.k.e.p.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i2 == 0) {
                        this.f55172a.showToast(R.string.upgrage_toast_dialog);
                    } else {
                        this.f55172a.showToast(R.string.neterror);
                    }
                } else if (i2 != 0 && !TextUtils.isEmpty(str2)) {
                    this.f55172a.C0.c0(str);
                } else {
                    this.f55172a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55173a;

        public r(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55173a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(c.a.r0.j2.k.e.b1.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.c()));
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55174e;

        public r0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55174e = pbFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r1 implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55175e;

        public r1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55175e = pbFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f55175e.e2 && this.f55175e.getIsMangaThread()) {
                    this.f55175e.f3();
                }
                if (this.f55175e.mIsLogin) {
                    if (!this.f55175e.n0 && this.f55175e.C0 != null && this.f55175e.C0.V() && this.f55175e.v0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.f55175e.v0.f1());
                        statisticItem.param("fid", this.f55175e.v0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i2 = 5;
                        if (this.f55175e.v0.v0()) {
                            i2 = 4;
                        } else if (this.f55175e.v0.w0()) {
                            i2 = 3;
                        } else if (this.f55175e.v0.y0()) {
                            i2 = 1;
                        }
                        statisticItem.param("obj_type", i2);
                        TiebaStatic.log(statisticItem);
                        this.f55175e.n0 = true;
                    }
                    if (this.f55175e.v0.z1(false)) {
                        this.f55175e.C0.T2();
                        TiebaStatic.eventStat(this.f55175e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if (this.f55175e.s0 == null || !this.f55175e.s0.d()) {
                        if (this.f55175e.v0.P0() != null) {
                            this.f55175e.C0.m2();
                        }
                    } else {
                        this.f55175e.C0.T2();
                    }
                    this.f55175e.e2 = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55176e;

        public r2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55176e = pbFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.f55176e.b1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f55176e.b1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55177a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55177a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.f55177a.C0 == null || this.f55177a.v0 == null) {
                return;
            }
            this.f55177a.C0.Y(false);
            if (this.f55177a.v0.z1(false)) {
                this.f55177a.C0.T2();
            } else if (this.f55177a.v0.P0() != null) {
                this.f55177a.C0.m2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55178a;

        public s0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55178a = pbFragment;
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f55178a.Q0 != null && this.f55178a.Q0.a() != null) {
                    this.f55178a.Q0.a().sendAction(new c.a.q0.x.a(45, 27, null));
                }
                this.f55178a.C0.X();
            }
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55179e;

        public s1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55179e = pbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55179e.v0 == null) {
                return;
            }
            this.f55179e.v0.LoadData();
        }
    }

    /* loaded from: classes7.dex */
    public class s2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55180e;

        public s2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55180e = pbFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements GetSugMatchWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55181a;

        public t(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55181a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                BdLog.e(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f55181a.C0 == null) {
                return;
            }
            this.f55181a.C0.X2(list);
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55182a;

        public t0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55182a = pbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f55182a.C0.e0();
                boolean z = false;
                if (c.a.e.e.p.j.z()) {
                    if (this.f55182a.v0 != null && !this.f55182a.v0.isLoading) {
                        this.f55182a.stopVoice();
                        this.f55182a.C0.S2();
                        z = true;
                        if (this.f55182a.v0.P0() != null && this.f55182a.v0.P0().f19631f != null && this.f55182a.v0.P0().f19631f.size() > i2) {
                            int intValue = this.f55182a.v0.P0().f19631f.get(i2).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.f55182a.v0.g1()).param("fid", this.f55182a.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.f55182a.v0.s2(intValue)) {
                                this.f55182a.m = true;
                                this.f55182a.C0.G2(true);
                            }
                        }
                    }
                    return z;
                }
                this.f55182a.showToast(R.string.network_not_available);
                return false;
            }
            return invokeI.booleanValue;
        }

        public final int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 == 2) {
                    return 1;
                }
                if (i2 == 0) {
                    return 2;
                }
                return i2 == 1 ? 3 : 0;
            }
            return invokeI.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class t1 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55183a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f55184e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ t1 f55185f;

            public a(t1 t1Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t1Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55185f = t1Var;
                this.f55184e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.j2.j.c.a(this.f55185f.f55183a.getPageContext(), this.f55184e).show();
                }
            }
        }

        public t1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55183a = pbFragment;
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
    public class t2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55186e;

        public t2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55186e = pbFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55187a;

        public u(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55187a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f55187a.G1 = false;
                if (this.f55187a.H1 == null) {
                    return;
                }
                c.a.r0.j2.h.e P0 = this.f55187a.v0.P0();
                if (P0.O().L0().getIsLike() == 1) {
                    this.f55187a.Y3(0);
                } else {
                    this.f55187a.Y3(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, P0.O()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f55187a.G1 = false;
                if (this.f55187a.H1 == null || str == null) {
                    return;
                }
                if (AntiHelper.m(i2, str)) {
                    AntiHelper.u(this.f55187a.getPageContext().getPageActivity(), str);
                } else {
                    this.f55187a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class u0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public u0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
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
    public class u1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f55188e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f55189f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f55190g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55191h;

        public u1(PbFragment pbFragment, MarkData markData, MarkData markData2, c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55191h = pbFragment;
            this.f55188e = markData;
            this.f55189f = markData2;
            this.f55190g = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f55191h.x0 != null) {
                    if (this.f55191h.x0.e()) {
                        this.f55191h.x0.d();
                        this.f55191h.x0.h(false);
                    }
                    this.f55191h.x0.i(this.f55188e);
                    this.f55191h.x0.h(true);
                    this.f55191h.x0.a();
                }
                this.f55189f.setPostId(this.f55188e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f55189f);
                this.f55191h.f55086e.setResult(-1, intent);
                this.f55190g.dismiss();
                this.f55191h.T3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f55192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55193f;

        public u2(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55193f = pbFragment;
            this.f55192e = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f55193f.C0.m3();
                MessageManager.getInstance().sendMessage(this.f55192e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements b.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55194a;

        public v(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55194a = pbFragment;
        }

        @Override // c.a.r0.j2.k.e.c1.b.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f55194a.setNavigationBarShowFlag(z);
                if (this.f55194a.C0.D0() != null && z) {
                    this.f55194a.C0.z3(false);
                }
                this.f55194a.C0.S1(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55195e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55196f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55197g;

        /* loaded from: classes7.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ v0 f55198e;

            public a(v0 v0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {v0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55198e = v0Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.a.r0.j2.k.e.u0 u0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f55198e.f55197g.mContentProcessController) == null || u0Var.g() == null) {
                    return;
                }
                if (!this.f55198e.f55197g.mContentProcessController.g().e()) {
                    this.f55198e.f55197g.mContentProcessController.b(false);
                }
                this.f55198e.f55197g.mContentProcessController.g().l(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                }
            }
        }

        public v0(PbFragment pbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55197g = pbFragment;
            this.f55195e = str;
            this.f55196f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = c.a.e.e.p.l.i(this.f55197g.f55086e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = c.a.e.e.p.l.g(this.f55197g.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = c.a.e.e.p.l.g(this.f55197g.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                PbFragment pbFragment = this.f55197g;
                boolean z = true;
                pbFragment.getPbView().G0().smoothScrollBy((pbFragment.c0[1] + pbFragment.i0) - i4, 50);
                if (this.f55197g.getPbView().P0() != null) {
                    this.f55197g.Q0.a().setVisibility(8);
                    this.f55197g.getPbView().P0().n(this.f55195e, this.f55196f, this.f55197g.getPbView().S0(), (this.f55197g.v0 == null || this.f55197g.v0.P0() == null || this.f55197g.v0.P0().O() == null || !this.f55197g.v0.P0().O().Q1()) ? false : false);
                    c.a.q0.x.w.h b2 = this.f55197g.getPbView().P0().b();
                    if (b2 != null && this.f55197g.v0 != null && this.f55197g.v0.P0() != null) {
                        b2.H(this.f55197g.v0.P0().d());
                        b2.c0(this.f55197g.v0.P0().O());
                    }
                    if (this.f55197g.mContentProcessController.f() == null && this.f55197g.getPbView().P0().b().u() != null) {
                        this.f55197g.getPbView().P0().b().u().g(new a(this));
                        PbFragment pbFragment2 = this.f55197g;
                        pbFragment2.mContentProcessController.n(pbFragment2.getPbView().P0().b().u().i());
                        this.f55197g.getPbView().P0().b().N(this.f55197g.Y0);
                    }
                }
                this.f55197g.getPbView().d1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f55199e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f55200f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55201g;

        public v1(PbFragment pbFragment, MarkData markData, c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55201g = pbFragment;
            this.f55199e = markData;
            this.f55200f = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f55199e);
                this.f55201g.f55086e.setResult(-1, intent);
                this.f55200f.dismiss();
                this.f55201g.T3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55202e;

        public v2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55202e = pbFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f55203e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f55204f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f55205g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f55206h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55207i;

        public w(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55207i = pbFragment;
            this.f55203e = sparseArray;
            this.f55204f = z;
            this.f55205g = str;
            this.f55206h = str2;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f55207i.G0 != null) {
                    this.f55207i.G0.dismiss();
                }
                if (i2 == 0) {
                    this.f55207i.C0.Y1(((Integer) this.f55203e.get(R.id.tag_del_post_type)).intValue(), (String) this.f55203e.get(R.id.tag_del_post_id), ((Integer) this.f55203e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f55203e.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f55203e.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.f55203e.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.f55203e.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f55204f, this.f55205g, str, str2, str3, 1, this.f55206h, this.f55207i.d1);
                    userMuteAddAndDelCustomMessage.setTag(this.f55207i.d1);
                    this.f55207i.P3(this.f55204f, userMuteAddAndDelCustomMessage, this.f55206h, str, (String) this.f55203e.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55209b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55210c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w0 f55211e;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$w0$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1791a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f55212e;

                public C1791a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f55212e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    c.a.r0.j2.k.e.u0 u0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f55212e.f55211e.f55210c.mContentProcessController) == null || u0Var.g() == null) {
                        return;
                    }
                    if (!this.f55212e.f55211e.f55210c.mContentProcessController.g().e()) {
                        this.f55212e.f55211e.f55210c.mContentProcessController.b(false);
                    }
                    this.f55212e.f55211e.f55210c.mContentProcessController.g().l(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            }

            public a(w0 w0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55211e = w0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = c.a.e.e.p.l.i(this.f55211e.f55210c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i2 = i3 / 2;
                        g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i4 = i3 - (i2 + g2);
                    PbFragment pbFragment = this.f55211e.f55210c;
                    boolean z = true;
                    pbFragment.getPbView().G0().smoothScrollBy((pbFragment.c0[1] + pbFragment.i0) - i4, 50);
                    if (this.f55211e.f55210c.getPbView().P0() != null) {
                        this.f55211e.f55210c.Q0.a().setVisibility(8);
                        z = (this.f55211e.f55210c.v0 == null || this.f55211e.f55210c.v0.P0() == null || this.f55211e.f55210c.v0.P0().O() == null || !this.f55211e.f55210c.v0.P0().O().Q1()) ? false : false;
                        c.a.r0.j2.k.e.t P0 = this.f55211e.f55210c.getPbView().P0();
                        w0 w0Var = this.f55211e;
                        P0.n(w0Var.f55208a, w0Var.f55209b, w0Var.f55210c.getPbView().S0(), z);
                        c.a.q0.x.w.h b2 = this.f55211e.f55210c.getPbView().P0().b();
                        if (b2 != null && this.f55211e.f55210c.v0 != null && this.f55211e.f55210c.v0.P0() != null) {
                            b2.H(this.f55211e.f55210c.v0.P0().d());
                            b2.c0(this.f55211e.f55210c.v0.P0().O());
                        }
                        if (this.f55211e.f55210c.mContentProcessController.f() == null && this.f55211e.f55210c.getPbView().P0().b().u() != null) {
                            this.f55211e.f55210c.getPbView().P0().b().u().g(new C1791a(this));
                            PbFragment pbFragment2 = this.f55211e.f55210c;
                            pbFragment2.mContentProcessController.n(pbFragment2.getPbView().P0().b().u().i());
                            this.f55211e.f55210c.getPbView().P0().b().N(this.f55211e.f55210c.Y0);
                        }
                    }
                    this.f55211e.f55210c.getPbView().d1();
                }
            }
        }

        public w0(PbFragment pbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55210c = pbFragment;
            this.f55208a = str;
            this.f55209b = str2;
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                c.a.e.e.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w1 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f55213e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f55214f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55215g;

        public w1(PbFragment pbFragment, MarkData markData, c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55215g = pbFragment;
            this.f55213e = markData;
            this.f55214f = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.f55215g.C0 != null && this.f55215g.C0.b1() != null) {
                    this.f55215g.C0.b1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.f55213e);
                    this.f55215g.f55086e.setResult(-1, intent);
                    this.f55214f.dismiss();
                    this.f55215g.T3();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w2 extends c.a.q0.d1.j0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55216a;

        public w2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55216a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.j0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.r0.j2.k.e.f1.b.d(this.f55216a.getContext(), this.f55216a.I2(), ShareSwitch.isOn() ? 1 : 6, this.f55216a.v0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55217a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55217a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f48192c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.f55217a.getUniqueId() || AntiHelper.t(this.f55217a.getActivity(), updateAttentionMessage.getData().l, PbFragment.x2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().f48190a) {
                    if (this.f55217a.getFirstPostData().t() != null && this.f55217a.getFirstPostData().t().getGodUserData() != null) {
                        this.f55217a.getFirstPostData().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.f55217a.v0 == null || this.f55217a.v0.P0() == null || this.f55217a.v0.P0().O() == null || this.f55217a.v0.P0().O().J() == null) {
                        return;
                    }
                    this.f55217a.v0.P0().O().J().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55218e;

        /* loaded from: classes7.dex */
        public class a implements i.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PopupDialog f55219e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ View f55220f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ x0 f55221g;

            public a(x0 x0Var, PopupDialog popupDialog, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {x0Var, popupDialog, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55221g = x0Var;
                this.f55219e = popupDialog;
                this.f55220f = view;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.f55221g.f55218e.v0.c1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // c.a.q0.s.s.i.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
                boolean s2;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, iVar, i2, view) != null) {
                    return;
                }
                this.f55219e.dismiss();
                int i3 = 3;
                if (this.f55221g.f55218e.v0.c1() != 1 || i2 != 1) {
                    if (this.f55221g.f55218e.v0.c1() == 2 && i2 == 0) {
                        i3 = 1;
                    } else if (this.f55221g.f55218e.v0.c1() == 3 && i2 != 2) {
                        i3 = 2;
                    } else if (i2 == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f55220f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                    if (this.f55221g.f55218e.v0.P0().f19631f != null && this.f55221g.f55218e.v0.P0().f19631f.size() > i2) {
                        i2 = this.f55221g.f55218e.v0.P0().f19631f.get(i2).sort_type.intValue();
                    }
                    s2 = this.f55221g.f55218e.v0.s2(i2);
                    this.f55220f.setTag(Integer.valueOf(this.f55221g.f55218e.v0.b1()));
                    if (s2) {
                        return;
                    }
                    this.f55221g.f55218e.m = true;
                    this.f55221g.f55218e.C0.G2(true);
                    return;
                }
                i3 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f55220f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f55221g.f55218e.v0.P0().f19631f != null) {
                    i2 = this.f55221g.f55218e.v0.P0().f19631f.get(i2).sort_type.intValue();
                }
                s2 = this.f55221g.f55218e.v0.s2(i2);
                this.f55220f.setTag(Integer.valueOf(this.f55221g.f55218e.v0.b1()));
                if (s2) {
                }
            }
        }

        public x0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55218e = pbFragment;
        }

        /* JADX WARN: Code restructure failed: missing block: B:884:0x1ff0, code lost:
            if (r39.f55218e.C0.R0.f20296c.getView().getTop() <= ((r39.f55218e.C0.Q0() == null || r39.f55218e.C0.Q0().c() == null) ? 0 : r39.f55218e.C0.Q0().c().getBottom())) goto L833;
         */
        /* JADX WARN: Code restructure failed: missing block: B:885:0x1ff2, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:887:0x1fff, code lost:
            if (r0 >= c.a.r0.j2.k.e.a1.k.c(r39.f55218e.getListView())) goto L833;
         */
        /* JADX WARN: Code restructure failed: missing block: B:909:0x20a6, code lost:
            if ((r39.f55218e.C0.R0.f20296c.getView().getTop() - r39.f55218e.C0.f20240h.f20111a.getBottom()) < (r39.f55218e.C0.R0.f20296c.mDivideLineTop.getHeight() + 10)) goto L833;
         */
        /* JADX WARN: Removed duplicated region for block: B:1152:0x294d  */
        /* JADX WARN: Removed duplicated region for block: B:1153:0x2962  */
        /* JADX WARN: Removed duplicated region for block: B:1156:0x299b  */
        /* JADX WARN: Removed duplicated region for block: B:294:0x096d  */
        /* JADX WARN: Removed duplicated region for block: B:295:0x0972  */
        /* JADX WARN: Removed duplicated region for block: B:298:0x0980  */
        /* JADX WARN: Removed duplicated region for block: B:333:0x0a37  */
        /* JADX WARN: Removed duplicated region for block: B:336:0x0a4a  */
        /* JADX WARN: Removed duplicated region for block: B:339:0x0a5b  */
        /* JADX WARN: Removed duplicated region for block: B:342:0x0a73  */
        /* JADX WARN: Removed duplicated region for block: B:344:0x0a7b  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            c.a.q0.s.s.f fVar;
            c.a.q0.s.s.f fVar2;
            c.a.q0.s.s.f fVar3;
            PbFragment pbFragment;
            int i2;
            boolean z;
            c.a.q0.s.s.f fVar4;
            c.a.q0.s.s.f fVar5;
            c.a.q0.s.s.f fVar6;
            String name;
            int i3;
            boolean z2;
            int fixedNavHeight;
            int i4;
            c.a.q0.s.q.i2 i2Var;
            String d2;
            String[] strArr;
            c.a.r0.j2.h.e P0;
            int i5;
            int i6;
            boolean r2;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f55218e.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == this.f55218e.C0.K0()) {
                        if (this.f55218e.m) {
                            return;
                        }
                        if (this.f55218e.v0.z1(true)) {
                            this.f55218e.m = true;
                            this.f55218e.C0.T2();
                        }
                    } else if (view != this.f55218e.C0.f20240h.m()) {
                        if (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().k()) {
                            if (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().d()) {
                                if (view == this.f55218e.C0.f20240h.f20116f) {
                                    if (this.f55218e.C0.U(this.f55218e.v0.D0())) {
                                        this.f55218e.stopVoice();
                                        return;
                                    }
                                    this.f55218e.n = false;
                                    this.f55218e.f55091j = false;
                                    c.a.e.e.p.l.x(this.f55218e.f55086e, this.f55218e.C0.f20240h.f20116f);
                                    this.f55218e.f55086e.finish();
                                } else if (view != this.f55218e.C0.r0() && (this.f55218e.C0.f20240h.n() == null || (view != this.f55218e.C0.f20240h.n().l() && view != this.f55218e.C0.f20240h.n().m()))) {
                                    if (view == this.f55218e.C0.z0()) {
                                        if (this.f55218e.v0 != null) {
                                            c.a.q0.m.a.l(this.f55218e.getPageContext().getPageActivity(), this.f55218e.v0.P0().O().w1().b());
                                        }
                                    } else if (view != this.f55218e.C0.f20240h.f20113c) {
                                        if (view == this.f55218e.C0.f20240h.f20114d) {
                                            if (c.a.q0.d1.p.a()) {
                                                return;
                                            }
                                            if (this.f55218e.v0 != null && this.f55218e.v0.P0() != null) {
                                                ArrayList<PostData> F = this.f55218e.v0.P0().F();
                                                if ((F == null || F.size() <= 0) && this.f55218e.v0.d1()) {
                                                    c.a.e.e.p.l.M(this.f55218e.getPageContext().getPageActivity(), this.f55218e.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f55218e.v0.f1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f55218e.v0.getForumId()));
                                                if (!this.f55218e.C0.G1()) {
                                                    this.f55218e.C0.q2();
                                                }
                                                this.f55218e.openMore();
                                            } else {
                                                c.a.e.e.p.l.M(this.f55218e.getPageContext().getPageActivity(), this.f55218e.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                        } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                            if (c.a.e.e.p.j.z()) {
                                                this.f55218e.C0.D2(true);
                                                this.f55218e.C0.q2();
                                                if (this.f55218e.m) {
                                                    return;
                                                }
                                                this.f55218e.m = true;
                                                this.f55218e.C0.w3();
                                                this.f55218e.stopVoice();
                                                this.f55218e.C0.S2();
                                                this.f55218e.v0.q2(this.f55218e.K2());
                                                TiebaStatic.eventStat(this.f55218e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.f55218e.showToast(R.string.network_not_available);
                                                return;
                                            }
                                        } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                            if ((this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().i()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                                if (this.f55218e.C0.f20240h.n() != null && view == this.f55218e.C0.f20240h.n().e()) {
                                                    this.f55218e.C0.f20240h.k();
                                                } else if (view.getId() == R.id.share_num_container) {
                                                    if (!this.f55218e.z2(11009)) {
                                                        return;
                                                    }
                                                    this.f55218e.X2(3);
                                                } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                    if (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().j()) {
                                                        if (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().q()) {
                                                            if (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().p()) {
                                                                if (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().n()) {
                                                                    if (this.f55218e.C0.D0() == view) {
                                                                        if (this.f55218e.C0.D0().getIndicateStatus()) {
                                                                            c.a.r0.j2.h.e P02 = this.f55218e.v0.P0();
                                                                            if (P02 != null && P02.O() != null && P02.O().j1() != null) {
                                                                                String d3 = P02.O().j1().d();
                                                                                if (StringUtils.isNull(d3)) {
                                                                                    d3 = P02.O().j1().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d3));
                                                                            }
                                                                        } else {
                                                                            c.a.r0.j3.k0.a.d("c10725", null);
                                                                        }
                                                                        this.f55218e.goInterviewLivePage();
                                                                    } else if (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().g()) {
                                                                        if (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().c()) {
                                                                            if (this.f55218e.C0.f20240h.n() != null && view == this.f55218e.C0.f20240h.n().f()) {
                                                                                if (c.a.e.e.p.j.z()) {
                                                                                    SparseArray<Object> H0 = this.f55218e.C0.H0(this.f55218e.v0.P0(), this.f55218e.v0.d1(), 1);
                                                                                    if (H0 != null) {
                                                                                        if (StringUtils.isNull((String) H0.get(R.id.tag_del_multi_forum))) {
                                                                                            this.f55218e.C0.Y1(((Integer) H0.get(R.id.tag_del_post_type)).intValue(), (String) H0.get(R.id.tag_del_post_id), ((Integer) H0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) H0.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                        } else {
                                                                                            this.f55218e.C0.Z1(((Integer) H0.get(R.id.tag_del_post_type)).intValue(), (String) H0.get(R.id.tag_del_post_id), ((Integer) H0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) H0.get(R.id.tag_del_post_is_self)).booleanValue(), (String) H0.get(R.id.tag_del_multi_forum));
                                                                                        }
                                                                                    }
                                                                                    this.f55218e.C0.f20240h.k();
                                                                                } else {
                                                                                    this.f55218e.showToast(R.string.network_not_available);
                                                                                    return;
                                                                                }
                                                                            } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText) {
                                                                                if (view.getId() == R.id.pb_post_reply_count) {
                                                                                    if (this.f55218e.v0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                                                                                    statisticItem2.param("tid", this.f55218e.v0.f1());
                                                                                    statisticItem2.param("fid", this.f55218e.v0.getForumId());
                                                                                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem2.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem2);
                                                                                    if (view.getId() == R.id.pb_post_reply_count && !DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f55218e.getActivity(), "pb_chakanhuifu"))) {
                                                                                        this.f55218e.W = view;
                                                                                        return;
                                                                                    } else if (!this.f55218e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
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
                                                                                        if (this.f55218e.v0 == null || this.f55218e.v0.P0() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String f1 = this.f55218e.v0.f1();
                                                                                        String E = postData.E();
                                                                                        int V = this.f55218e.v0.P0() != null ? this.f55218e.v0.P0().V() : 0;
                                                                                        AbsPbActivity.e p3 = this.f55218e.p3(E);
                                                                                        if (p3 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f55218e.getPageContext().getPageActivity()).createSubPbActivityConfig(f1, E, "pb", true, false, null, false, null, V, postData.P(), this.f55218e.v0.P0().d(), false, postData.t().getIconInfo(), 5).addBigImageData(p3.f55053a, p3.f55054b, p3.f55059g, p3.f55062j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.f55218e.v0.O0());
                                                                                        addBigImageData.setFromFrsForumId(this.f55218e.v0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.f55218e.v0.j1());
                                                                                        addBigImageData.setKeyFromForumId(this.f55218e.v0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.f55218e.v0.F(), this.f55218e.v0.B(), this.f55218e.v0.C(), this.f55218e.v0.A(), this.f55218e.v0.G());
                                                                                        addBigImageData.setBjhData(this.f55218e.v0.j0());
                                                                                        if (this.f55218e.v0.P0().p() != null) {
                                                                                            addBigImageData.setHasForumRule(this.f55218e.v0.P0().p().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.f55218e.v0.P0().U() != null) {
                                                                                            addBigImageData.setIsManager(this.f55218e.v0.P0().U().getIs_manager());
                                                                                        }
                                                                                        if (this.f55218e.v0.P0().m().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.f55218e.v0.P0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.f55218e.v0.P0().m().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.f55218e.v0.P0().m() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.f55218e.v0.P0().m().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.f55218e.v0.P0().m().getUser_level());
                                                                                        }
                                                                                        if (this.f55218e.C0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.f55218e.C0.x0(this.f55218e.v0.J, this.f55218e.v0.d1()).S || postData.S);
                                                                                        }
                                                                                        this.f55218e.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                    if (this.f55218e.v0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view.getId() == R.id.pb_post_reply) {
                                                                                        StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                                                        statisticItem4.param("tid", this.f55218e.v0.f1());
                                                                                        statisticItem4.param("fid", this.f55218e.v0.getForumId());
                                                                                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem4.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem4);
                                                                                    }
                                                                                    if (view.getId() == R.id.post_info_commont_img) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f55218e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                            this.f55218e.X = view;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f55218e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                        this.f55218e.X = view;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.f55218e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
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
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f55218e.v0.g1()).param("fid", this.f55218e.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.f55218e.v0 == null || this.f55218e.v0.P0() == null || this.f55218e.getPbView().O0() == null || postData2.t() == null || postData2.A() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.f55218e.getPbView().P0() != null) {
                                                                                        this.f55218e.getPbView().P0().c();
                                                                                    }
                                                                                    if (this.f55218e.q0 && postData2.M() != null && postData2.M().size() != 0) {
                                                                                        this.f55218e.S3(postData2, true);
                                                                                    } else {
                                                                                        c.a.r0.j2.h.r rVar = new c.a.r0.j2.h.r();
                                                                                        rVar.A(this.f55218e.v0.P0().m());
                                                                                        rVar.E(this.f55218e.v0.P0().O());
                                                                                        rVar.C(postData2);
                                                                                        this.f55218e.getPbView().O0().S(rVar);
                                                                                        this.f55218e.getPbView().O0().setPostId(postData2.E());
                                                                                        this.f55218e.i3(view, postData2.t().getUserId(), "", postData2);
                                                                                        if (this.f55218e.Q0 != null) {
                                                                                            this.f55218e.C0.x2(this.f55218e.Q0.E());
                                                                                        }
                                                                                    }
                                                                                } else if (view.getId() != R.id.pb_floor_feedback) {
                                                                                    if (view != this.f55218e.C0.B0()) {
                                                                                        if (view == this.f55218e.C0.f20240h.o()) {
                                                                                            this.f55218e.C0.a3();
                                                                                        } else if (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().o()) {
                                                                                            if (this.f55218e.C0.f20240h.n() != null && view == this.f55218e.C0.f20240h.n().h()) {
                                                                                                c.a.q0.t.c.i0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (d2 = tiebaPlusConfigData.d(this.f55218e.v0.f1())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.f55218e.getPageContext(), new String[]{d2});
                                                                                                    this.f55218e.C0.f20240h.k();
                                                                                                    c.a.q0.t.c.i0.a(3);
                                                                                                }
                                                                                            } else {
                                                                                                int id = view.getId();
                                                                                                if (id == R.id.pb_u9_text_view) {
                                                                                                    if (!this.f55218e.checkUpIsLogin() || (i2Var = (c.a.q0.s.q.i2) view.getTag()) == null || StringUtils.isNull(i2Var.E0())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.f55218e.getPageContext().getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.f55218e.getPageContext(), new String[]{i2Var.E0()});
                                                                                                } else if (id != R.id.replybtn && id != R.id.cover_reply_content && id != R.id.replybtn_top_right && id != R.id.cover_reply_content_top_right) {
                                                                                                    if (id == R.id.pb_act_btn) {
                                                                                                        if (this.f55218e.v0.P0() != null && this.f55218e.v0.P0().O() != null && this.f55218e.v0.P0().O().x() != null) {
                                                                                                            c.a.q0.m.a.l(this.f55218e.getActivity(), this.f55218e.v0.P0().O().x());
                                                                                                            if (this.f55218e.v0.P0().O().w() != 1) {
                                                                                                                if (this.f55218e.v0.P0().O().w() == 2) {
                                                                                                                    TiebaStatic.eventStat(this.f55218e.getPageContext().getPageActivity(), "show_picture", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                                }
                                                                                                            } else {
                                                                                                                TiebaStatic.eventStat(this.f55218e.getPageContext().getPageActivity(), "lottery", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == R.id.lottery_tail) {
                                                                                                        if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                            String str = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                                            TiebaStatic.log(new StatisticItem("c10912").param("fid", this.f55218e.v0.P0().n()).param("tid", this.f55218e.v0.P0().Q()).param("lotterytail", StringUtils.string(str, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                            if (this.f55218e.v0.P0().Q().equals(str)) {
                                                                                                                this.f55218e.C0.W2(0);
                                                                                                            } else {
                                                                                                                this.f55218e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f55218e.getActivity()).createNormalCfg(str, (String) null, (String) null, (String) null)));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == R.id.pb_item_tail_content) {
                                                                                                        if (ViewHelper.checkUpIsLogin(this.f55218e.getPageContext().getPageActivity())) {
                                                                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                                            String p = c.a.q0.s.d0.b.j().p("tail_link", "");
                                                                                                            if (!StringUtils.isNull(p)) {
                                                                                                                TiebaStatic.log("c10056");
                                                                                                                c.a.q0.m.a.o(view.getContext(), string, p, true, true, true);
                                                                                                            }
                                                                                                            this.f55218e.C0.q2();
                                                                                                        }
                                                                                                    } else if (id == R.id.join_vote_tv) {
                                                                                                        if (view != null) {
                                                                                                            c.a.q0.m.a.l(this.f55218e.getActivity(), (String) view.getTag());
                                                                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                            if (this.f55218e.I2() == 1 && this.f55218e.v0 != null && this.f55218e.v0.P0() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c10397").param("fid", this.f55218e.v0.P0().n()).param("tid", this.f55218e.v0.P0().Q()).param("uid", currentAccount));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == R.id.look_all_tv) {
                                                                                                        if (view != null) {
                                                                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                            c.a.q0.m.a.l(this.f55218e.getActivity(), (String) view.getTag());
                                                                                                            if (this.f55218e.I2() == 1 && this.f55218e.v0 != null && this.f55218e.v0.P0() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c10507").param("fid", this.f55218e.v0.P0().n()).param("tid", this.f55218e.v0.P0().Q()).param("uid", currentAccount2));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == R.id.manga_prev_btn) {
                                                                                                        this.f55218e.h3();
                                                                                                    } else if (id == R.id.manga_next_btn) {
                                                                                                        this.f55218e.f3();
                                                                                                    } else if (id == R.id.yule_head_img_img) {
                                                                                                        if (this.f55218e.v0 != null && this.f55218e.v0.P0() != null && this.f55218e.v0.P0().A() != null) {
                                                                                                            c.a.r0.j2.h.e P03 = this.f55218e.v0.P0();
                                                                                                            TiebaStatic.log(new StatisticItem("c11679").param("fid", P03.n()));
                                                                                                            UrlManager.getInstance().dealOneLink(this.f55218e.getPageContext(), new String[]{P03.A().b()});
                                                                                                        }
                                                                                                    } else if (id == R.id.yule_head_img_all_rank) {
                                                                                                        if (this.f55218e.v0 != null && this.f55218e.v0.P0() != null && this.f55218e.v0.P0().A() != null) {
                                                                                                            c.a.r0.j2.h.e P04 = this.f55218e.v0.P0();
                                                                                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", P04.n()));
                                                                                                            UrlManager.getInstance().dealOneLink(this.f55218e.getPageContext(), new String[]{P04.A().b()});
                                                                                                        }
                                                                                                    } else if (id == R.id.tv_pb_reply_more) {
                                                                                                        if (this.f55218e.k1 >= 0) {
                                                                                                            if (this.f55218e.v0 != null) {
                                                                                                                this.f55218e.v0.V1();
                                                                                                            }
                                                                                                            if (this.f55218e.v0 == null || this.f55218e.C0.p0() == null) {
                                                                                                                i4 = 0;
                                                                                                            } else {
                                                                                                                i4 = 0;
                                                                                                                this.f55218e.C0.p0().c0(this.f55218e.v0.P0(), false);
                                                                                                            }
                                                                                                            this.f55218e.k1 = i4;
                                                                                                            if (this.f55218e.v0 != null) {
                                                                                                                this.f55218e.C0.G0().setSelection(this.f55218e.v0.I0());
                                                                                                                this.f55218e.v0.Z1(0, 0);
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == R.id.qq_share_container) {
                                                                                                        if (!this.f55218e.z2(11009)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.f55218e.X2(8);
                                                                                                    } else if (id == R.id.new_sub_pb_list_richText) {
                                                                                                        SparseArray sparseArray4 = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                                                                                                        if (sparseArray4 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.f55218e.R3(sparseArray4);
                                                                                                    } else if (id == R.id.pb_editor_tool_comment_icon) {
                                                                                                        if (this.f55218e.C0.G0() == null || this.f55218e.v0 == null || this.f55218e.v0.P0() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        int firstVisiblePosition = this.f55218e.C0.G0().getFirstVisiblePosition();
                                                                                                        View childAt = this.f55218e.C0.G0().getChildAt(0);
                                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                                        boolean p0 = this.f55218e.v0.P0().p0();
                                                                                                        boolean z3 = this.f55218e.C0.Q0() != null && this.f55218e.C0.Q0().g();
                                                                                                        boolean E1 = this.f55218e.C0.E1();
                                                                                                        boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                        if (!p0 || this.f55218e.C0.Q0() == null || this.f55218e.C0.Q0().c() == null) {
                                                                                                            i3 = 0;
                                                                                                        } else {
                                                                                                            int k = ((int) (c.a.e.e.p.l.k(this.f55218e.getContext()) * 0.5625d)) - this.f55218e.C0.Q0().e();
                                                                                                            i3 = k;
                                                                                                            z4 = firstVisiblePosition == 0 && (top == k || top == this.f55218e.C0.Q0().c().getHeight() - this.f55218e.C0.Q0().e());
                                                                                                        }
                                                                                                        this.f55218e.E2(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                        if ((this.f55218e.v0.P0().O() != null && this.f55218e.v0.P0().O().U0() <= 0) || (E1 && z4)) {
                                                                                                            if (!this.f55218e.checkUpIsLogin()) {
                                                                                                                return;
                                                                                                            }
                                                                                                            this.f55218e.processProfessionPermission();
                                                                                                            if (this.f55218e.v0.P0().O().J() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55218e.v0.f55294f).param("fid", this.f55218e.v0.P0().n()).param("obj_locate", 2).param("uid", this.f55218e.v0.P0().O().J().getUserId()));
                                                                                                            }
                                                                                                        } else {
                                                                                                            int i9 = (int) (c.a.e.e.p.l.i(this.f55218e.getContext()) * 0.6d);
                                                                                                            if (p0) {
                                                                                                                if (this.f55218e.C0.R0 != null && this.f55218e.C0.R0.f20296c != null && this.f55218e.C0.R0.f20296c.getView() != null) {
                                                                                                                    if (this.f55218e.C0.R0.f20296c.getView().getParent() != null) {
                                                                                                                    }
                                                                                                                }
                                                                                                                z2 = false;
                                                                                                            } else {
                                                                                                                if (this.f55218e.C0.N0() != null) {
                                                                                                                    z2 = this.f55218e.C0.N0().getVisibility() == 0;
                                                                                                                    if (!z2 && this.f55218e.C0.R0 != null && this.f55218e.C0.R0.f20296c != null && this.f55218e.C0.R0.f20296c.getView() != null && this.f55218e.C0.R0.f20296c.getView().getParent() != null && this.f55218e.C0.f20240h != null && this.f55218e.C0.f20240h.f20111a != null) {
                                                                                                                    }
                                                                                                                }
                                                                                                                z2 = false;
                                                                                                            }
                                                                                                            if (z2 || E1) {
                                                                                                                this.f55218e.j0 = firstVisiblePosition;
                                                                                                                this.f55218e.k0 = top;
                                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i9))) {
                                                                                                                    this.f55218e.C0.G0().setSelectionFromTop(0, i3 - i9);
                                                                                                                    this.f55218e.C0.G0().smoothScrollBy(-i9, 500);
                                                                                                                } else {
                                                                                                                    this.f55218e.C0.G0().smoothScrollToPosition(0, i3, 500);
                                                                                                                }
                                                                                                            } else if (this.f55218e.j0 > 0) {
                                                                                                                if (this.f55218e.C0.G0().getChildAt(this.f55218e.j0) != null) {
                                                                                                                    this.f55218e.C0.G0().smoothScrollToPosition(this.f55218e.j0, this.f55218e.k0, 200);
                                                                                                                } else {
                                                                                                                    this.f55218e.C0.G0().setSelectionFromTop(this.f55218e.j0, this.f55218e.k0 + i9);
                                                                                                                    this.f55218e.C0.G0().smoothScrollBy(i9, 500);
                                                                                                                }
                                                                                                            } else {
                                                                                                                int c2 = c.a.r0.j2.k.e.a1.k.c(this.f55218e.getListView());
                                                                                                                if (c.a.r0.j2.k.e.a1.k.d(this.f55218e.getListView()) != -1) {
                                                                                                                    c2--;
                                                                                                                }
                                                                                                                int g2 = c.a.e.e.p.l.g(this.f55218e.getContext(), R.dimen.tbds100);
                                                                                                                if (c2 < 0) {
                                                                                                                    c2 = (ListUtils.getCount(this.f55218e.C0.G0().getData()) - 1) + this.f55218e.C0.G0().getHeaderViewsCount();
                                                                                                                    g2 = 0;
                                                                                                                }
                                                                                                                if (!z3) {
                                                                                                                    if (!p0 || this.f55218e.C0.Q0() == null) {
                                                                                                                        if (this.f55218e.C0.f20240h != null && this.f55218e.C0.f20240h.f20111a != null) {
                                                                                                                            fixedNavHeight = this.f55218e.C0.f20240h.f20111a.getFixedNavHeight() - 10;
                                                                                                                        }
                                                                                                                        if (this.f55218e.C0.R0 != null || this.f55218e.C0.R0.f20296c == null || this.f55218e.C0.R0.f20296c.getView() == null || this.f55218e.C0.R0.f20296c.getView().getParent() == null) {
                                                                                                                            this.f55218e.C0.G0().setSelectionFromTop(c2, g2 + i9);
                                                                                                                            this.f55218e.C0.G0().smoothScrollBy(i9, 500);
                                                                                                                        } else if (!z3) {
                                                                                                                            this.f55218e.C0.G0().smoothScrollToPosition(c2, g2, 200);
                                                                                                                        } else {
                                                                                                                            this.f55218e.C0.G0().smoothScrollBy(this.f55218e.C0.R0.f20296c.getView().getTop() - ((int) (c.a.e.e.p.l.k(this.f55218e.getContext()) * 0.5625d)), 500);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        fixedNavHeight = this.f55218e.C0.Q0().d();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = (int) (c.a.e.e.p.l.k(this.f55218e.getContext()) * 0.5625d);
                                                                                                                }
                                                                                                                g2 += fixedNavHeight;
                                                                                                                if (this.f55218e.C0.R0 != null) {
                                                                                                                }
                                                                                                                this.f55218e.C0.G0().setSelectionFromTop(c2, g2 + i9);
                                                                                                                this.f55218e.C0.G0().smoothScrollBy(i9, 500);
                                                                                                            }
                                                                                                        }
                                                                                                        if (this.f55218e.v0.P0().O() != null && this.f55218e.v0.P0().O().J() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55218e.v0.f55294f).param("fid", this.f55218e.v0.P0().n()).param("obj_locate", 2).param("uid", this.f55218e.v0.P0().O().J().getUserId()));
                                                                                                        }
                                                                                                    } else if (id == R.id.pb_nav_title_forum_image || id == R.id.pb_nav_title_forum_name) {
                                                                                                        if (this.f55218e.v0 == null || this.f55218e.v0.P0() == null || this.f55218e.v0.P0().m() == null || c.a.e.e.p.k.isEmpty(this.f55218e.v0.P0().m().getName())) {
                                                                                                            return;
                                                                                                        }
                                                                                                        if (this.f55218e.v0.getErrorNo() == 4) {
                                                                                                            if (!StringUtils.isNull(this.f55218e.v0.q0()) || this.f55218e.v0.g0() == null) {
                                                                                                                this.f55218e.f55086e.finish();
                                                                                                                return;
                                                                                                            }
                                                                                                            name = this.f55218e.v0.g0().f19621b;
                                                                                                        } else {
                                                                                                            name = this.f55218e.v0.P0().m().getName();
                                                                                                        }
                                                                                                        if (StringUtils.isNull(name)) {
                                                                                                            this.f55218e.f55086e.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        String q0 = this.f55218e.v0.q0();
                                                                                                        if (this.f55218e.v0.v0() && q0 != null && q0.equals(name)) {
                                                                                                            this.f55218e.f55086e.finish();
                                                                                                        } else {
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f55218e.getActivity()).createNormalCfg(this.f55218e.v0.P0().m().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                        }
                                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13401");
                                                                                                        statisticItem5.param("tid", this.f55218e.v0.f1());
                                                                                                        statisticItem5.param("fid", this.f55218e.v0.getForumId());
                                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        if (this.f55218e.v0.P0().O() != null) {
                                                                                                            statisticItem5.param("nid", this.f55218e.v0.P0().O().F0());
                                                                                                        }
                                                                                                        TiebaStatic.log(statisticItem5);
                                                                                                    } else if (id != R.id.forum_name_text && id != R.id.forum_enter_button_one && id != R.id.forum_enter_button_two && id != R.id.forum_enter_button_three) {
                                                                                                        if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                                            if (this.f55218e.v0 == null) {
                                                                                                                return;
                                                                                                            }
                                                                                                            StatisticItem statisticItem6 = new StatisticItem("c13398");
                                                                                                            statisticItem6.param("tid", this.f55218e.v0.f1());
                                                                                                            statisticItem6.param("fid", this.f55218e.v0.getForumId());
                                                                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                            statisticItem6.param("obj_locate", 2);
                                                                                                            TiebaStatic.log(statisticItem6);
                                                                                                        } else if (id == R.id.pb_thread_post_button) {
                                                                                                            if (this.f55218e.v0 == null || this.f55218e.v0.P0() == null) {
                                                                                                                return;
                                                                                                            }
                                                                                                            c.a.r0.j2.h.e P05 = this.f55218e.v0.P0();
                                                                                                            if (this.f55218e.A0 == null) {
                                                                                                                PbFragment pbFragment2 = this.f55218e;
                                                                                                                pbFragment2.A0 = new c.a.r0.j2.h.t(pbFragment2.getPageContext());
                                                                                                            }
                                                                                                            long g3 = c.a.e.e.m.b.g(P05.Q(), 0L);
                                                                                                            long g4 = c.a.e.e.m.b.g(P05.n(), 0L);
                                                                                                            new StatisticItem("c13446").param("forum_id", g4).eventStat();
                                                                                                            PbFragment pbFragment3 = this.f55218e;
                                                                                                            pbFragment3.registerListener(pbFragment3.V1);
                                                                                                            this.f55218e.A0.a(g3, g4);
                                                                                                        } else if (id == R.id.pb_video_thread_smart_app_layout) {
                                                                                                            if (view.getTag() instanceof SmartApp) {
                                                                                                                SmartApp smartApp = (SmartApp) view.getTag();
                                                                                                                if (!c.a.r0.u.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                    if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    c.a.q0.m.a.l(this.f55218e.getActivity(), smartApp.h5_url);
                                                                                                                }
                                                                                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.f55218e.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", AppletsCellView.PB_SHARE_CARD_LITE_PROGRAM_FROM).param("tid", this.f55218e.v0.f1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                            }
                                                                                                        } else if (id == R.id.id_pb_business_promotion_wrapper) {
                                                                                                            if (!(view.getTag() instanceof c.a.q0.s.q.d2)) {
                                                                                                                return;
                                                                                                            }
                                                                                                            c.a.q0.s.q.d2 d2Var = (c.a.q0.s.q.d2) view.getTag();
                                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f55218e.getActivity()).createNormalCfg(d2Var.Z(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                            createNormalCfg.setCallFrom(14);
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", d2Var.T()).param("tid", d2Var.f0()).param("thread_type", d2Var.o1()).param(TiebaStatic.Params.IS_ZP, d2Var.I2() ? 1 : 0));
                                                                                                        } else if (id == R.id.id_pb_business_promotion_attention) {
                                                                                                            if (!(view.getTag() instanceof c.a.q0.s.q.d2) || !this.f55218e.checkUpIsLogin()) {
                                                                                                                return;
                                                                                                            }
                                                                                                            c.a.q0.s.q.d2 d2Var2 = (c.a.q0.s.q.d2) view.getTag();
                                                                                                            if (this.f55218e.U != null) {
                                                                                                                this.f55218e.U.L(d2Var2.Z(), String.valueOf(d2Var2.T()));
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", d2Var2.T()).param("tid", d2Var2.f0()).param("thread_type", d2Var2.o1()).param(TiebaStatic.Params.IS_ZP, d2Var2.I2() ? 1 : 0));
                                                                                                        } else if (id == R.id.pb_floor_right_top_feedback || id == R.id.pb_post_op_more) {
                                                                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                            statisticItem7.param("tid", this.f55218e.v0.f1());
                                                                                                            statisticItem7.param("fid", this.f55218e.v0.getForumId());
                                                                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                            statisticItem7.param("obj_locate", 7);
                                                                                                            TiebaStatic.log(statisticItem7);
                                                                                                            PbFragment pbFragment4 = this.f55218e;
                                                                                                            pbFragment4.f55087f = false;
                                                                                                            pbFragment4.C2(view);
                                                                                                        }
                                                                                                    } else if (!(view.getTag() instanceof c.a.q0.s.q.d2)) {
                                                                                                        return;
                                                                                                    } else {
                                                                                                        c.a.q0.s.q.d2 d2Var3 = (c.a.q0.s.q.d2) view.getTag();
                                                                                                        if (this.f55218e.v0.O0() == 3 && this.f55218e.isSimpleForum() && this.f55218e.v0.P0() != null && ListUtils.isEmpty(this.f55218e.v0.P0().q())) {
                                                                                                            this.f55218e.f55086e.finish();
                                                                                                        } else {
                                                                                                            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.f55218e.getActivity()).createNormalCfg(d2Var3.Z(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                            createNormalCfg2.setCallFrom(14);
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                                        }
                                                                                                        StatisticItem statisticItem8 = new StatisticItem("c13399");
                                                                                                        statisticItem8.param("tid", d2Var3.f0());
                                                                                                        statisticItem8.param("fid", d2Var3.T());
                                                                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem8.param("nid", d2Var3.F0());
                                                                                                        TiebaStatic.log(statisticItem8);
                                                                                                    }
                                                                                                } else {
                                                                                                    c.a.q0.s.s.f fVar7 = null;
                                                                                                    if (!this.f55218e.checkUpIsLogin()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view != null && view.getTag() != null) {
                                                                                                        SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                                        if (id == R.id.replybtn_top_right || id == R.id.cover_reply_content_top_right) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.f55218e.v0.f55294f));
                                                                                                        }
                                                                                                        if (this.f55218e.H0 == null) {
                                                                                                            PbFragment pbFragment5 = this.f55218e;
                                                                                                            pbFragment5.H0 = new c.a.q0.s.s.i(pbFragment5.getContext());
                                                                                                            this.f55218e.H0.n(this.f55218e.S1);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.f55218e.isImage(view);
                                                                                                        if (this.f55218e.isImage(view) && this.f55218e.g1 != null) {
                                                                                                            this.f55218e.g1.t();
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
                                                                                                                c.a.q0.s.s.f fVar8 = new c.a.q0.s.s.f(3, this.f55218e.getString(R.string.copy), this.f55218e.H0);
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(R.id.tag_clip_board, postData3);
                                                                                                                fVar8.f14428d.setTag(sparseArray6);
                                                                                                                arrayList.add(fVar8);
                                                                                                            }
                                                                                                            this.f55218e.j2 = postData3;
                                                                                                        }
                                                                                                        if (this.f55218e.v0.P0().s()) {
                                                                                                            String u = this.f55218e.v0.P0().u();
                                                                                                            if (postData3 != null && !c.a.e.e.p.k.isEmpty(u) && u.equals(postData3.E())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    fVar4 = new c.a.q0.s.s.f(4, this.f55218e.getString(R.string.remove_mark), this.f55218e.H0);
                                                                                                                } else {
                                                                                                                    fVar4 = new c.a.q0.s.s.f(4, this.f55218e.getString(R.string.mark), this.f55218e.H0);
                                                                                                                }
                                                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                                                sparseArray7.put(R.id.tag_clip_board, this.f55218e.j2);
                                                                                                                sparseArray7.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                                                fVar4.f14428d.setTag(sparseArray7);
                                                                                                                arrayList.add(fVar4);
                                                                                                                if (this.f55218e.mIsLogin) {
                                                                                                                    if (c.a.r0.j2.k.e.f1.a.h(this.f55218e.v0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.f55218e.d3(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            c.a.q0.s.s.f fVar9 = new c.a.q0.s.s.f(5, this.f55218e.getString(R.string.report_text), this.f55218e.H0);
                                                                                                                            fVar9.f14428d.setTag(str2);
                                                                                                                            arrayList.add(fVar9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        c.a.q0.s.s.f fVar10 = new c.a.q0.s.s.f(5, this.f55218e.getString(R.string.mute_option), this.f55218e.H0);
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
                                                                                                                        fVar4.f14428d.setTag(sparseArray8);
                                                                                                                        arrayList.add(fVar10);
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
                                                                                                                            fVar7 = new c.a.q0.s.s.f(6, this.f55218e.getString(R.string.delete), this.f55218e.H0);
                                                                                                                            fVar7.f14428d.setTag(sparseArray9);
                                                                                                                        } else {
                                                                                                                            sparseArray9.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        fVar5 = new c.a.q0.s.s.f(7, this.f55218e.getString(R.string.bar_manager), this.f55218e.H0);
                                                                                                                        fVar5.f14428d.setTag(sparseArray9);
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
                                                                                                                        if (this.f55218e.v0.P0().V() == 1002 && !booleanValue) {
                                                                                                                            fVar6 = new c.a.q0.s.s.f(6, this.f55218e.getString(R.string.report_text), this.f55218e.H0);
                                                                                                                        } else {
                                                                                                                            fVar6 = new c.a.q0.s.s.f(6, this.f55218e.getString(R.string.delete), this.f55218e.H0);
                                                                                                                        }
                                                                                                                        fVar6.f14428d.setTag(sparseArray10);
                                                                                                                        fVar7 = fVar6;
                                                                                                                        fVar5 = null;
                                                                                                                    } else {
                                                                                                                        fVar5 = null;
                                                                                                                    }
                                                                                                                    if (fVar7 != null) {
                                                                                                                        arrayList.add(fVar7);
                                                                                                                    }
                                                                                                                    if (fVar5 != null) {
                                                                                                                        arrayList.add(fVar5);
                                                                                                                    }
                                                                                                                }
                                                                                                                this.f55218e.H0.k(arrayList);
                                                                                                                this.f55218e.G0 = new PopupDialog(this.f55218e.getPageContext(), this.f55218e.H0);
                                                                                                                this.f55218e.G0.showDialog();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray72 = new SparseArray();
                                                                                                        sparseArray72.put(R.id.tag_clip_board, this.f55218e.j2);
                                                                                                        sparseArray72.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                                        fVar4.f14428d.setTag(sparseArray72);
                                                                                                        arrayList.add(fVar4);
                                                                                                        if (this.f55218e.mIsLogin) {
                                                                                                        }
                                                                                                        this.f55218e.H0.k(arrayList);
                                                                                                        this.f55218e.G0 = new PopupDialog(this.f55218e.getPageContext(), this.f55218e.H0);
                                                                                                        this.f55218e.G0.showDialog();
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            this.f55218e.C0.f20240h.l();
                                                                                            this.f55218e.C0.t3(this.f55218e.m2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.f55218e.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.f55218e.getPageContext().getPageActivity(), 24008, c.a.e.e.m.b.g(this.f55218e.v0.P0().n(), 0L), c.a.e.e.m.b.g(this.f55218e.v0.f1(), 0L), c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.f55218e.v0.P0().O().O0())));
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
                                                                                    if (this.f55218e.H0 == null) {
                                                                                        PbFragment pbFragment6 = this.f55218e;
                                                                                        pbFragment6.H0 = new c.a.q0.s.s.i(pbFragment6.getContext());
                                                                                        this.f55218e.H0.n(this.f55218e.S1);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.f55218e.getPbModel().P0() != null && this.f55218e.getPbModel().P0().f0();
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
                                                                                                pbFragment = this.f55218e;
                                                                                                i2 = R.string.action_cancel_dislike;
                                                                                            } else {
                                                                                                pbFragment = this.f55218e;
                                                                                                i2 = R.string.action_dislike;
                                                                                            }
                                                                                            c.a.q0.s.s.f fVar11 = new c.a.q0.s.s.f(8, pbFragment.getString(i2), this.f55218e.H0);
                                                                                            SparseArray sparseArray11 = new SparseArray();
                                                                                            sparseArray11.put(R.id.tag_clip_board, postData4);
                                                                                            fVar11.f14428d.setTag(sparseArray11);
                                                                                            arrayList2.add(fVar11);
                                                                                        }
                                                                                        if (this.f55218e.mIsLogin) {
                                                                                            if (c.a.r0.j2.k.e.f1.a.h(this.f55218e.v0) || booleanValue8 || !booleanValue7) {
                                                                                                if ((this.f55218e.d3(booleanValue6) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    c.a.q0.s.s.f fVar12 = new c.a.q0.s.s.f(5, this.f55218e.getString(R.string.report_text), this.f55218e.H0);
                                                                                                    fVar12.f14428d.setTag(str3);
                                                                                                    arrayList2.add(fVar12);
                                                                                                }
                                                                                            } else {
                                                                                                c.a.q0.s.s.f fVar13 = new c.a.q0.s.s.f(5, this.f55218e.getString(R.string.mute_option), this.f55218e.H0);
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
                                                                                                fVar13.f14428d.setTag(sparseArray12);
                                                                                                arrayList2.add(fVar13);
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
                                                                                                    fVar2 = new c.a.q0.s.s.f(6, this.f55218e.getString(R.string.delete), this.f55218e.H0);
                                                                                                    fVar2.f14428d.setTag(sparseArray13);
                                                                                                } else {
                                                                                                    sparseArray13.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                                    fVar2 = null;
                                                                                                }
                                                                                                fVar = new c.a.q0.s.s.f(7, this.f55218e.getString(R.string.bar_manager), this.f55218e.H0);
                                                                                                fVar.f14428d.setTag(sparseArray13);
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
                                                                                                if (this.f55218e.v0.P0().V() == 1002 && !booleanValue6) {
                                                                                                    fVar3 = new c.a.q0.s.s.f(6, this.f55218e.getString(R.string.report_text), this.f55218e.H0);
                                                                                                } else {
                                                                                                    fVar3 = new c.a.q0.s.s.f(6, this.f55218e.getString(R.string.delete), this.f55218e.H0);
                                                                                                }
                                                                                                fVar3.f14428d.setTag(sparseArray14);
                                                                                                fVar2 = fVar3;
                                                                                                fVar = null;
                                                                                            } else {
                                                                                                fVar = null;
                                                                                                fVar2 = null;
                                                                                            }
                                                                                            if (fVar2 != null) {
                                                                                                arrayList2.add(fVar2);
                                                                                            }
                                                                                            if (fVar != null) {
                                                                                                arrayList2.add(fVar);
                                                                                            }
                                                                                        }
                                                                                        this.f55218e.H0.k(arrayList2);
                                                                                        this.f55218e.G0 = new PopupDialog(this.f55218e.getPageContext(), this.f55218e.H0);
                                                                                        this.f55218e.G0.showDialog();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                    StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                                                    statisticItem9.param("tid", this.f55218e.v0.f1());
                                                                                    statisticItem9.param("fid", this.f55218e.v0.getForumId());
                                                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem9.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem9);
                                                                                }
                                                                                if (view.getId() == R.id.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f55218e.getActivity(), "pb_chakanhuifu"))) {
                                                                                    this.f55218e.W = view;
                                                                                    return;
                                                                                } else if (this.f55218e.checkUpIsLogin()) {
                                                                                    if (this.f55218e.v0 == null || this.f55218e.v0.P0() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.f55218e.C0.e0();
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
                                                                                    String f12 = this.f55218e.v0.f1();
                                                                                    String E2 = postData5.E();
                                                                                    String E3 = postData6 != null ? postData6.E() : "";
                                                                                    int V2 = this.f55218e.v0.P0() != null ? this.f55218e.v0.P0().V() : 0;
                                                                                    this.f55218e.stopVoice();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        AbsPbActivity.e p32 = this.f55218e.p3(E2);
                                                                                        if (this.f55218e.v0 == null || this.f55218e.v0.P0() == null || p32 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.f55218e.getPageContext().getPageActivity()).createSubPbActivityConfig(f12, E2, "pb", true, false, null, true, null, V2, postData5.P(), this.f55218e.v0.P0().d(), false, postData5.t().getIconInfo(), 5).addBigImageData(p32.f55053a, p32.f55054b, p32.f55059g, p32.f55062j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.f55218e.v0.O0());
                                                                                        addBigImageData2.setFromFrsForumId(this.f55218e.v0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.f55218e.v0.j1());
                                                                                        addBigImageData2.setKeyFromForumId(this.f55218e.v0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.f55218e.v0.j0());
                                                                                        addBigImageData2.setTiebaPlusData(this.f55218e.v0.F(), this.f55218e.v0.B(), this.f55218e.v0.C(), this.f55218e.v0.A(), this.f55218e.v0.G());
                                                                                        this.f55218e.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e p33 = this.f55218e.p3(E2);
                                                                                        if (postData5 == null || this.f55218e.v0 == null || this.f55218e.v0.P0() == null || p33 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.f55218e.getPageContext().getPageActivity()).createSubPbActivityConfig(f12, E2, "pb", true, false, null, false, E3, V2, postData5.P(), this.f55218e.v0.P0().d(), false, postData5.t().getIconInfo(), 5).addBigImageData(p33.f55053a, p33.f55054b, p33.f55059g, p33.f55062j);
                                                                                        if (!c.a.e.e.p.k.isEmpty(E3)) {
                                                                                            addBigImageData3.setHighLightPostId(E3);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.f55218e.v0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.f55218e.v0.F(), this.f55218e.v0.B(), this.f55218e.v0.C(), this.f55218e.v0.A(), this.f55218e.v0.G());
                                                                                        addBigImageData3.setBjhData(this.f55218e.v0.j0());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.f55218e.v0.O0());
                                                                                        addBigImageData3.setFromFrsForumId(this.f55218e.v0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.f55218e.v0.j1());
                                                                                        if (this.f55218e.C0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.f55218e.C0.x0(this.f55218e.v0.J, this.f55218e.v0.d1()).S || postData5.S);
                                                                                        }
                                                                                        this.f55218e.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f55218e.v0.P0().n()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (c.a.e.e.p.j.z()) {
                                                                            SparseArray<Object> H02 = this.f55218e.C0.H0(this.f55218e.v0.P0(), this.f55218e.v0.d1(), 1);
                                                                            if (H02 != null) {
                                                                                this.f55218e.C0.b2(((Integer) H02.get(R.id.tag_del_post_type)).intValue(), (String) H02.get(R.id.tag_del_post_id), ((Integer) H02.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) H02.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            }
                                                                            this.f55218e.C0.f20240h.k();
                                                                            if (this.f55218e.getPbModel() != null && this.f55218e.getPbModel().P0() != null && this.f55218e.getPbModel().P0().O() != null) {
                                                                                c.a.q0.s.q.d2 O = this.f55218e.getPbModel().P0().O();
                                                                                StatisticItem statisticItem11 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                                                                statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                                                statisticItem11.param("tid", O.f0());
                                                                                statisticItem11.param("fid", O.T());
                                                                                statisticItem11.param("fname", O.Z());
                                                                                TiebaStatic.log(statisticItem11);
                                                                                StatisticItem statisticItem12 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                                                                statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                                                statisticItem12.param("tid", O.f0());
                                                                                statisticItem12.param("fid", O.T());
                                                                                statisticItem12.param("fname", O.Z());
                                                                                statisticItem12.param("obj_source", 3);
                                                                                TiebaStatic.log(statisticItem12);
                                                                            }
                                                                        } else {
                                                                            this.f55218e.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (c.a.e.e.p.j.z()) {
                                                                        this.f55218e.C0.e0();
                                                                        SparseArray<Object> H03 = this.f55218e.C0.H0(this.f55218e.v0.P0(), this.f55218e.v0.d1(), 1);
                                                                        if (H03 == null) {
                                                                            return;
                                                                        }
                                                                        this.f55218e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f55218e.getPageContext().getPageActivity(), this.f55218e.v0.P0().m().getId(), this.f55218e.v0.P0().m().getName(), this.f55218e.v0.P0().O().f0(), String.valueOf(this.f55218e.v0.P0().U().getUserId()), (String) H03.get(R.id.tag_forbid_user_name), (String) H03.get(R.id.tag_forbid_user_name_show), (String) H03.get(R.id.tag_forbid_user_post_id), (String) H03.get(R.id.tag_forbid_user_portrait))));
                                                                    } else {
                                                                        this.f55218e.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        this.f55218e.onChangeSkinType(skinType);
                                                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                                                    } else if (skinType == 0 || skinType == 4) {
                                                                        UtilHelper.showSkinChangeAnimation(this.f55218e.getActivity());
                                                                        this.f55218e.onChangeSkinType(skinType);
                                                                        UtilHelper.setNavigationBarBackground(this.f55218e.getActivity(), this.f55218e.getResources().getColor(R.color.CAM_X0201_1));
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                                                    }
                                                                    this.f55218e.C0.f20240h.l();
                                                                }
                                                            } else if (this.f55218e.v0 == null || this.f55218e.v0.P0() == null || this.f55218e.v0.P0().O() == null) {
                                                                return;
                                                            } else {
                                                                this.f55218e.C0.f20240h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.f55218e;
                                                                pbFragment7.U2(pbFragment7.v0.P0().O().W());
                                                            }
                                                        } else {
                                                            this.f55218e.C0.e0();
                                                            if (c.a.e.e.p.j.z()) {
                                                                if (this.f55218e.m) {
                                                                    view.setTag(Integer.valueOf(this.f55218e.v0.b1()));
                                                                    return;
                                                                }
                                                                this.f55218e.stopVoice();
                                                                this.f55218e.C0.S2();
                                                                PopupDialog popupDialog = new PopupDialog(this.f55218e.getPageContext());
                                                                if (this.f55218e.v0.P0().f19631f == null || this.f55218e.v0.P0().f19631f.size() <= 0) {
                                                                    strArr = new String[]{this.f55218e.getResources().getString(R.string.sort_type_new), this.f55218e.getResources().getString(R.string.sort_type_old)};
                                                                } else {
                                                                    strArr = new String[this.f55218e.v0.P0().f19631f.size()];
                                                                    for (int i64 = 0; i64 < this.f55218e.v0.P0().f19631f.size(); i64++) {
                                                                        strArr[i64] = this.f55218e.v0.P0().f19631f.get(i64).sort_name + this.f55218e.getResources().getString(R.string.sort_static);
                                                                    }
                                                                }
                                                                popupDialog.setDefaultContentView(null, strArr, new a(this, popupDialog, view));
                                                                popupDialog.showDialog();
                                                            } else {
                                                                this.f55218e.showToast(R.string.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.f55218e.C0.e0();
                                                        if (this.f55218e.getPbModel().P0().f19632g != 2) {
                                                            if (this.f55218e.v0.N0() != null) {
                                                                this.f55218e.C0.y3(this.f55218e.v0.N0(), this.f55218e.mDialogClickListener);
                                                            }
                                                            TiebaStatic.eventStat(this.f55218e.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.f55218e.showToast(R.string.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.f55218e.checkUpIsLogin()) || (P0 = this.f55218e.v0.P0()) == null) {
                                                    return;
                                                } else {
                                                    c.a.q0.s.q.d2 O2 = P0.O();
                                                    if (O2 != null && O2.J() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55218e.v0.f55294f).param("fid", P0.n()).param("obj_locate", 4).param("uid", O2.J().getUserId()));
                                                    }
                                                    if (O2 != null) {
                                                        if (O2.M1()) {
                                                            i5 = 2;
                                                        } else if (O2.P1()) {
                                                            i5 = 3;
                                                        } else if (O2.N1()) {
                                                            i5 = 4;
                                                        } else if (O2.O1()) {
                                                            i5 = 5;
                                                        }
                                                        StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                        statisticItem13.param("tid", this.f55218e.v0.f1());
                                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem13.param("fid", this.f55218e.v0.getForumId());
                                                        if (view.getId() != R.id.share_num_container) {
                                                            statisticItem13.param("obj_locate", 5);
                                                        } else {
                                                            statisticItem13.param("obj_locate", 6);
                                                        }
                                                        statisticItem13.param("obj_name", i5);
                                                        statisticItem13.param("obj_type", 1);
                                                        if (O2 != null) {
                                                            if (O2.M1()) {
                                                                statisticItem13.param("obj_type", 10);
                                                            } else if (O2.P1()) {
                                                                statisticItem13.param("obj_type", 9);
                                                            } else if (O2.O1()) {
                                                                statisticItem13.param("obj_type", 8);
                                                            } else if (O2.N1()) {
                                                                statisticItem13.param("obj_type", 7);
                                                            } else if (O2.z1) {
                                                                statisticItem13.param("obj_type", 6);
                                                            } else {
                                                                int i65 = O2.i0;
                                                                if (i65 == 0) {
                                                                    statisticItem13.param("obj_type", 1);
                                                                } else if (i65 == 40) {
                                                                    statisticItem13.param("obj_type", 2);
                                                                } else if (i65 == 49) {
                                                                    statisticItem13.param("obj_type", 3);
                                                                } else if (i65 == 54) {
                                                                    statisticItem13.param("obj_type", 4);
                                                                } else {
                                                                    statisticItem13.param("obj_type", 5);
                                                                }
                                                            }
                                                            statisticItem13.param("card_type", O2.Q0());
                                                            statisticItem13.param("recom_source", O2.X0);
                                                            statisticItem13.param("ab_tag", O2.Z0);
                                                            statisticItem13.param("weight", O2.Y0);
                                                            statisticItem13.param("extra", O2.a1);
                                                            statisticItem13.param("nid", O2.F0());
                                                            if (O2.L() != null && !c.a.e.e.p.k.isEmpty(O2.L().oriUgcVid)) {
                                                                statisticItem13.param(TiebaStatic.Params.OBJ_PARAM6, O2.L().oriUgcVid);
                                                            }
                                                        }
                                                        if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem13.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.f55218e.getPbActivity() != null) {
                                                            c.a.q0.n0.c.e(this.f55218e.getPbActivity(), statisticItem13);
                                                        }
                                                        if (this.f55218e.C0 != null) {
                                                            statisticItem13.param("obj_param1", this.f55218e.C0.C0());
                                                        }
                                                        TiebaStatic.log(statisticItem13);
                                                        if (c.a.e.e.p.l.D()) {
                                                            this.f55218e.showToast(R.string.neterror);
                                                            return;
                                                        } else if (P0 != null) {
                                                            ArrayList<PostData> F2 = this.f55218e.v0.P0().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.f55218e.v0.d1()) {
                                                                this.f55218e.C0.e0();
                                                                this.f55218e.stopVoice();
                                                                if (P0.A() != null && !StringUtils.isNull(P0.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.f55218e.v0.P0().n()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.f55218e.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.f55218e.C0 != null) {
                                                                    this.f55218e.C0.g0();
                                                                    this.f55218e.C0.J3(P0);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.f55218e.C0.m3();
                                                                    this.f55218e.v0.l0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view.getId() == R.id.pb_editor_tool_share) {
                                                                        i6 = 2;
                                                                    } else {
                                                                        i6 = view.getId() == R.id.share_num_container ? 1 : 6;
                                                                    }
                                                                    if ((c.a.q0.b.d.P() || c.a.q0.b.d.Q()) && this.f55218e.C0.I1()) {
                                                                        int C0 = this.f55218e.C0.C0();
                                                                        this.f55218e.C0.T();
                                                                        this.f55218e.W2(c.a.q0.t.g.f.a(), C0);
                                                                    } else {
                                                                        this.f55218e.N3(i6);
                                                                    }
                                                                }
                                                            } else {
                                                                c.a.e.e.p.l.M(this.f55218e.getPageContext().getPageActivity(), this.f55218e.getPageContext().getString(R.string.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            c.a.e.e.p.l.M(this.f55218e.getPageContext().getPageActivity(), this.f55218e.getPageContext().getString(R.string.pb_no_data_tips));
                                                            return;
                                                        }
                                                    }
                                                    i5 = 1;
                                                    StatisticItem statisticItem132 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem132.param("tid", this.f55218e.v0.f1());
                                                    statisticItem132.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem132.param("fid", this.f55218e.v0.getForumId());
                                                    if (view.getId() != R.id.share_num_container) {
                                                    }
                                                    statisticItem132.param("obj_name", i5);
                                                    statisticItem132.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.f55218e.getPbActivity() != null) {
                                                    }
                                                    if (this.f55218e.C0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem132);
                                                    if (c.a.e.e.p.l.D()) {
                                                    }
                                                }
                                            } else if (c.a.e.e.p.j.z()) {
                                                this.f55218e.C0.e0();
                                                if (this.f55218e.C0.f20240h.n() != null && view == this.f55218e.C0.f20240h.n().i() && !this.f55218e.C0.G1()) {
                                                    this.f55218e.C0.q2();
                                                }
                                                if (!this.f55218e.m) {
                                                    this.f55218e.stopVoice();
                                                    this.f55218e.C0.S2();
                                                    if (view.getId() == R.id.floor_owner_reply) {
                                                        r2 = this.f55218e.v0.r2(true, this.f55218e.K2());
                                                    } else {
                                                        r2 = view.getId() == R.id.reply_title ? this.f55218e.v0.r2(false, this.f55218e.K2()) : this.f55218e.v0.q2(this.f55218e.K2());
                                                    }
                                                    view.setTag(Boolean.valueOf(r2));
                                                    if (r2) {
                                                        i7 = 1;
                                                        this.f55218e.C0.D2(true);
                                                        this.f55218e.C0.w3();
                                                        this.f55218e.m = true;
                                                        this.f55218e.C0.G2(true);
                                                    } else {
                                                        i7 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.f55218e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                                } else {
                                                    view.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.f55218e.showToast(R.string.network_not_available);
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (c.a.e.e.p.j.z()) {
                                            this.f55218e.C0.e0();
                                            if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f55218e.getActivity(), "pb_shoucang"))) {
                                                if (!this.f55218e.z2(11009) || this.f55218e.v0.h0(this.f55218e.C0.F0()) == null) {
                                                    return;
                                                }
                                                this.f55218e.k3();
                                                if (this.f55218e.v0.P0() != null && this.f55218e.v0.P0().O() != null && this.f55218e.v0.P0().O().J() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55218e.v0.f55294f).param("fid", this.f55218e.v0.P0().n()).param("obj_locate", 3).param("uid", this.f55218e.v0.P0().O().J().getUserId()));
                                                }
                                                if (this.f55218e.v0.P0().O() != null && this.f55218e.v0.P0().O().J() != null && this.f55218e.v0.P0().O().J().getUserId() != null && this.f55218e.x0 != null) {
                                                    PbFragment pbFragment8 = this.f55218e;
                                                    int S2 = pbFragment8.S2(pbFragment8.v0.P0());
                                                    c.a.q0.s.q.d2 O3 = this.f55218e.v0.P0().O();
                                                    if (O3.M1()) {
                                                        i8 = 2;
                                                    } else if (O3.P1()) {
                                                        i8 = 3;
                                                    } else if (O3.N1()) {
                                                        i8 = 4;
                                                    } else {
                                                        i8 = O3.O1() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f55218e.v0.f55294f).param("obj_locate", 1).param("obj_id", this.f55218e.v0.P0().O().J().getUserId()).param("obj_type", !this.f55218e.x0.e()).param("obj_source", S2).param("obj_param1", i8));
                                                }
                                            } else {
                                                this.f55218e.Y = view;
                                                return;
                                            }
                                        } else {
                                            this.f55218e.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.f55218e.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.f55218e.v0.P0() != null && this.f55218e.v0.P0().O() != null && this.f55218e.v0.P0().O().E2() && this.f55218e.v0.P0().O().q1() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.f55218e.v0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.f55218e.v0.q0()) || this.f55218e.v0.g0() == null) {
                                                this.f55218e.f55086e.finish();
                                                return;
                                            }
                                            name2 = this.f55218e.v0.g0().f19621b;
                                        } else {
                                            name2 = this.f55218e.v0.P0().m().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.f55218e.f55086e.finish();
                                            return;
                                        }
                                        String q02 = this.f55218e.v0.q0();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.f55218e.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.f55218e.v0.v0() && q02 != null && q02.equals(name2)) {
                                            this.f55218e.f55086e.finish();
                                        } else {
                                            this.f55218e.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (c.a.e.e.p.j.z()) {
                                    if (this.f55218e.v0.P0() == null || this.f55218e.y0.P()) {
                                        return;
                                    }
                                    this.f55218e.C0.e0();
                                    int i66 = (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().m()) ? (this.f55218e.C0.f20240h.n() == null || view != this.f55218e.C0.f20240h.n().l()) ? view == this.f55218e.C0.r0() ? 2 : 0 : this.f55218e.v0.P0().O().q0() == 1 ? 3 : 6 : this.f55218e.v0.P0().O().r0() == 1 ? 5 : 4;
                                    ForumData m = this.f55218e.v0.P0().m();
                                    String name3 = m.getName();
                                    String id2 = m.getId();
                                    String f0 = this.f55218e.v0.P0().O().f0();
                                    this.f55218e.C0.D3();
                                    this.f55218e.y0.T(id2, name3, f0, i66, this.f55218e.C0.s0());
                                } else {
                                    this.f55218e.showToast(R.string.network_not_available);
                                    return;
                                }
                            } else {
                                this.f55218e.C0.f20240h.l();
                                if (this.f55218e.v0 != null) {
                                    this.f55218e.n1.f(this.f55218e.v0.f1());
                                }
                                if (this.f55218e.v0 == null || !this.f55218e.v0.isPrivacy()) {
                                    this.f55218e.n1.b();
                                    int i67 = (TbSingleton.getInstance().mCanCallFans || this.f55218e.getPbModel() == null || this.f55218e.getPbModel().P0() == null || this.f55218e.getPbModel().P0().Q() == null || !this.f55218e.getPbModel().P0().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.f55218e.getPbModel() != null && this.f55218e.getPbModel().P0() != null) {
                                        this.f55218e.n1.d(3, i67, this.f55218e.getPbModel().P0().Q());
                                    }
                                } else {
                                    this.f55218e.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                    if (this.f55218e.getPbModel() == null || this.f55218e.getPbModel().P0() == null) {
                                        return;
                                    }
                                    this.f55218e.n1.d(3, 3, this.f55218e.getPbModel().P0().Q());
                                    return;
                                }
                            }
                        } else if (c.a.e.e.p.j.z()) {
                            this.f55218e.C0.e0();
                            this.f55218e.stopVoice();
                            this.f55218e.C0.S2();
                            this.f55218e.C0.m3();
                            if (this.f55218e.C0.N0() != null) {
                                this.f55218e.C0.N0().setVisibility(8);
                            }
                            this.f55218e.v0.m2(1);
                            if (this.f55218e.f55090i != null) {
                                this.f55218e.f55090i.x();
                            }
                        } else {
                            this.f55218e.showToast(R.string.network_not_available);
                            return;
                        }
                    } else {
                        String str4 = (String) view.getTag(R.id.forum_name);
                        String str5 = (String) view.getTag(R.id.forum_id);
                        String str6 = (String) view.getTag(R.id.thread_id);
                        if (this.f55218e.U != null) {
                            this.f55218e.U.L(str4, str5);
                        }
                        TbPageTag l = c.a.q0.n0.c.l(this.f55218e.getContext());
                        c.a.r0.j2.k.e.f1.c.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l != null ? l.locatePage : "");
                    }
                    if (this.f55218e.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String J2 = this.f55218e.J2();
                        if (TextUtils.isEmpty(J2)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.f55218e.getPageContext(), new String[]{J2});
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem14 = new StatisticItem("c13398");
                statisticItem14.param("tid", this.f55218e.v0.f1());
                statisticItem14.param("fid", this.f55218e.v0.getForumId());
                statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem14.param("obj_locate", 1);
                TiebaStatic.log(statisticItem14);
                if (this.f55218e.A) {
                    this.f55218e.A = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (this.f55218e.v0 == null || this.f55218e.v0.P0() == null || this.f55218e.getPbView().O0() == null || postData7.t() == null || postData7.A() == 1 || !this.f55218e.checkUpIsLogin()) {
                            return;
                        }
                        if (this.f55218e.getPbView().P0() != null) {
                            this.f55218e.getPbView().P0().c();
                        }
                        c.a.r0.j2.h.r rVar2 = new c.a.r0.j2.h.r();
                        rVar2.A(this.f55218e.v0.P0().m());
                        rVar2.E(this.f55218e.v0.P0().O());
                        rVar2.C(postData7);
                        this.f55218e.getPbView().O0().S(rVar2);
                        this.f55218e.getPbView().O0().setPostId(postData7.E());
                        this.f55218e.i3(view, postData7.t().getUserId(), "", postData7);
                        TiebaStatic.log("c11743");
                        c.a.r0.j2.m.a.b(this.f55218e.v0.P0(), postData7, postData7.i0, 8, 1);
                        if (this.f55218e.Q0 != null) {
                            this.f55218e.C0.x2(this.f55218e.Q0.E());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x1 implements c.a.e.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55222a;

        public x1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55222a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (c.a.q0.s.k.c().g()) {
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
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f55222a.getPageContext().getPageActivity());
                boolean g2 = c.a.q0.s.k.c().g();
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
            return (ImageView) invokeV.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class x2 implements c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55223a;

        public x2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55223a = pbFragment;
        }

        @Override // c.a.r0.j2.k.e.c0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f55223a.C0.C3(str);
        }

        @Override // c.a.r0.j2.k.e.c0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements PbInterviewStatusView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55224a;

        public y(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55224a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f55224a.C0.z3(!this.f55224a.Q);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55225a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
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
            this.f55225a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f55225a.v0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.f55225a.v0.f55294f)) {
                this.f55225a.M3((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y1 implements c.a.e.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55226a;

        public y1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55226a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (c.a.q0.s.k.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.onDestroy();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.f55226a.getPageContext().getPageActivity());
                boolean g2 = c.a.q0.s.k.c().g();
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
            return (GifView) invokeV.objValue;
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.release();
                gifView.onDestroy();
                gifView.setImageDrawable(null);
                gifView.resetDefaultNoImageDay();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface y2 {
        boolean onBackPressed();
    }

    /* loaded from: classes7.dex */
    public class z extends c.a.q0.j0.i<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55227g;

        public z(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55227g = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.j0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.f55227g.f55086e.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.makeText(this.f55227g.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class z0 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55228a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f55229e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ z0 f55230f;

            public a(z0 z0Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {z0Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55230f = z0Var;
                this.f55229e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55230f.f55228a.C0 == null || this.f55229e == null) {
                    return;
                }
                this.f55230f.f55228a.C0.e2(this.f55229e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(z0 z0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {z0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ z0 f55231e;

            public c(z0 z0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {z0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55231e = z0Var;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f55231e.f55228a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f55231e.f55228a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public z0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55228a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.q0.t.c.k0 k0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f55228a.v0.P0() != null) {
                        statisticItem.param("fid", this.f55228a.v0.P0().n());
                    }
                    statisticItem.param("tid", this.f55228a.v0.f1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (c.a.e.e.p.k.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.f55228a.stopVoice();
                this.f55228a.C0.Q2(z, postWriteCallBackData);
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                boolean z2 = false;
                if (z) {
                    this.f55228a.M3(postWriteCallBackData);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.f55228a.B3(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (this.f55228a.v0.t0()) {
                            c.a.r0.j2.h.e P0 = this.f55228a.v0.P0();
                            if (P0 != null && P0.O() != null && P0.O().J() != null && (userId = P0.O().J().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.f55228a.v0.p2()) {
                                this.f55228a.C0.S2();
                            }
                        } else if (!PbReplySwitch.getInOn() && this.f55228a.v0.p2()) {
                            this.f55228a.C0.S2();
                        }
                    } else if (floor != null) {
                        this.f55228a.C0.u1(this.f55228a.v0.P0());
                    }
                    if (this.f55228a.v0.x0()) {
                        TiebaStatic.log(new StatisticItem("c10369").param("tid", this.f55228a.v0.f1()));
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        c.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    PbFragment pbFragment = this.f55228a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    pbFragment.w2(z2);
                } else if (i2 == 220015) {
                    this.f55228a.showToast(str);
                    if (this.f55228a.Q0.D() || this.f55228a.Q0.F()) {
                        this.f55228a.Q0.B(false, postWriteCallBackData);
                    }
                    this.f55228a.mContentProcessController.k(postWriteCallBackData);
                } else if (i2 == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f55228a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f55228a.getActivity(), this.f55228a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f55228a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f55228a.getActivity());
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f55228a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f55228a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (c.a.r0.t3.a.c(i2) || k0Var != null || i2 == 227001) {
                } else {
                    this.f55228a.A3(i2, antiData, str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z1 implements c.a.e.e.k.c<TiebaPlusRecommendCard> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55232a;

        public z1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55232a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard c(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            h(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        public TiebaPlusRecommendCard e(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.onSkinChanged();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.resetData();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public TiebaPlusRecommendCard d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new TiebaPlusRecommendCard(this.f55232a.getPageContext().getPageActivity()) : (TiebaPlusRecommendCard) invokeV.objValue;
        }

        public TiebaPlusRecommendCard h(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.resetData();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface z2 {
        void a(Object obj);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1073013551, "Lcom/baidu/tieba/pb/pb/main/PbFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1073013551, "Lcom/baidu/tieba/pb/pb/main/PbFragment;");
                return;
            }
        }
        x2 = new u0();
        y2 = new p2();
    }

    public PbFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55087f = true;
        this.f55088g = false;
        this.k = false;
        this.l = false;
        this.n = true;
        this.p = 0;
        this.q = null;
        this.r = -1L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.v = 0L;
        this.x = false;
        this.y = null;
        this.z = 0L;
        this.A = false;
        this.B = 0L;
        this.C = 1;
        this.D = null;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = "";
        this.Q = true;
        this.R = false;
        this.S = "";
        this.a0 = 3;
        this.c0 = new int[2];
        this.j0 = -1;
        this.k0 = -1;
        this.sortSwitchId = BdUniqueId.gen();
        this.n0 = false;
        this.q0 = c.a.q0.b.d.i0();
        this.r0 = new n(this);
        this.t0 = new y(this);
        this.u0 = new Handler(new j0(this));
        this.v0 = null;
        this.x0 = null;
        this.y0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = false;
        this.E0 = false;
        this.F0 = false;
        this.J0 = false;
        this.L0 = false;
        this.N0 = false;
        this.mKeyboardIsVisible = false;
        this.W0 = new f1(this);
        this.X0 = new q1(this);
        this.Y0 = new b2(this);
        this.Z0 = 0;
        this.j1 = false;
        this.k1 = 0;
        this.l1 = -1;
        this.bjhFrom = 0;
        this.o1 = new m2(this);
        this.p1 = new x2(this);
        this.q1 = new d(this, 2004016);
        this.r1 = new e(this, 2016485);
        this.s1 = new f(this, 2001269);
        this.t1 = new g(this, 2004008);
        this.u1 = new h(this, 2004007);
        this.v1 = new i(this, 2004005);
        this.w1 = new j(this, 2001332);
        this.x1 = new k(this, 2921391);
        this.y1 = new l(this, 2921606);
        this.z1 = new m(this);
        this.A1 = new o(this, 2001369);
        this.B1 = new p(this, 2016488);
        this.C1 = new q(this, 2016331);
        this.D1 = new r(this);
        this.E1 = new s(this, 2921509);
        this.F1 = new t(this);
        this.H1 = new PraiseModel(getPageContext(), new u(this));
        this.I1 = new v(this);
        this.J1 = new x(this, 2001115);
        this.K1 = new z(this);
        this.L1 = new c0(this);
        this.M1 = new c.a.r0.j2.i.c(new f0(this));
        this.N1 = new h0(this, 2001427);
        this.O1 = new i0(this, 2001428);
        this.P1 = new k0(this, 2001426);
        this.mFirstFloorPraiseListener = new l0(this, 2004021);
        this.Q1 = new m0(this, 2016528);
        this.R1 = new n0(this, 2921033);
        this.mDialogClickListener = new o0(this);
        this.S1 = new p0(this);
        this.onSwitchChangeListener = new t0(this);
        this.mCommonOnClickListener = new x0(this);
        this.T1 = new y0(this, 2921480);
        this.U1 = new z0(this);
        this.mOnFloorPostWriteNewCallback = new a1(this);
        this.V1 = new b1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.W1 = new c1(this);
        this.X1 = new d1(this, 2016450);
        this.Y1 = new e1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.Z1 = new g1(this);
        this.a2 = new j1(this);
        this.b2 = new m1(this);
        this.c2 = new o1(this);
        this.d2 = new p1(this);
        this.f2 = new r1(this);
        this.g2 = 0;
        this.h2 = new d2(this);
        this.i2 = false;
        this.j2 = null;
        this.k2 = new e2(this);
        this.l2 = new f2(this);
        this.m2 = new g2(this);
        this.n2 = new h2(this);
        this.o2 = new i2(this);
        this.p2 = new j2(this);
        this.q2 = new k2(this);
        this.mOnTouchListener = new n2(this);
        this.r2 = new o2(this);
        this.s2 = new q2(this);
        this.t2 = -1;
        this.u2 = -1;
    }

    public static PbFragment newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65665, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A2(AgreeData agreeData) {
        c.a.q0.m0.c k3;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.m0 == null) {
            this.m0 = new c.a.q0.s.b0.a();
        }
        if (this.p0 == null) {
            c.a.r0.j3.i0.e eVar = new c.a.r0.j3.i0.e();
            this.p0 = eVar;
            eVar.f20852a = getUniqueId();
        }
        c.a.q0.s.q.f fVar = new c.a.q0.s.q.f();
        fVar.f14167b = 5;
        fVar.f14173h = 8;
        fVar.f14172g = 2;
        if (getPbModel() != null) {
            fVar.f14171f = getPbModel().O0();
        }
        fVar.f14166a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f14174i = 0;
                k3 = TbPageExtraHelper.k(getContext());
                if (k3 != null) {
                    agreeData.objSource = k3.a();
                }
                this.m0.c(agreeData, i3, getUniqueId(), false);
                this.m0.d(agreeData, this.p0);
                pbModel = this.v0;
                if (pbModel != null || pbModel.P0() == null) {
                }
                this.m0.b(getPbActivity(), fVar, agreeData, this.v0.P0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f14174i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f14174i = 1;
        }
        i3 = 0;
        k3 = TbPageExtraHelper.k(getContext());
        if (k3 != null) {
        }
        this.m0.c(agreeData, i3, getUniqueId(), false);
        this.m0.d(agreeData, this.p0);
        pbModel = this.v0;
        if (pbModel != null) {
        }
    }

    public final void A3(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new l1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                O3(str);
            } else {
                this.C0.C3(str);
            }
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.v0.v0() || this.v0.y0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.v0.f1());
                this.f55086e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.v0.f1()));
            if (U3()) {
                this.f55086e.finish();
            }
        }
    }

    public final void B3(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (getPbView() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    c.a.q0.t.h.b.a(getPageContext(), postWriteCallBackData);
                    return;
                } else {
                    c.a.r0.j3.r0.m.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.v0.D0()) {
            antiData.setBlock_forum_name(this.v0.P0().m().getName());
            antiData.setBlock_forum_id(this.v0.P0().m().getId());
            antiData.setUser_name(this.v0.P0().U().getUserName());
            antiData.setUser_id(this.v0.P0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final boolean C2(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        List<c.a.q0.s.s.f> b3;
        c.a.q0.s.s.f fVar;
        c.a.q0.s.s.f fVar2;
        c.a.q0.s.s.f fVar3;
        c.a.q0.s.s.f fVar4;
        c.a.e.l.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                c.a.r0.j2.k.e.s0 s0Var = this.C0;
                if (s0Var != null) {
                    if (s0Var.y1()) {
                        return true;
                    }
                    this.C0.n0();
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e3) {
                    e3.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (isImage(view)) {
                        if (view instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view;
                            this.g1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.h1 = url;
                            if (this.g1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.i1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.i1 = null;
                            }
                        } else if (view instanceof GifView) {
                            GifView gifView = (GifView) view;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.g1 = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                                this.h1 = gifView.getBdImage().q();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.i1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.i1 = null;
                            }
                        } else if (view instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.g1 = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                    this.h1 = tbMemeImageView.getBdImage().q();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    this.i1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                } else {
                                    this.i1 = null;
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
                            this.C0.r3(this.l2, this.g1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                this.j2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.A() == 1 && isImage(view)) {
                    this.C0.r3(this.l2, this.g1.t());
                    return true;
                }
                c.a.q0.i.a aVar2 = this.x0;
                if (aVar2 == null) {
                    return true;
                }
                boolean z5 = aVar2.e() && this.j2.E() != null && this.j2.E().equals(this.v0.K0());
                boolean z6 = getPbModel().P0() != null && getPbModel().P0().f0();
                boolean z7 = getPbModel().P0() != null && getPbModel().P0().i0();
                if (this.j2.A() == 1) {
                    if (!z6) {
                        this.C0.s3(this.k2, z5, false, z7);
                    }
                    return true;
                }
                if (this.H0 == null) {
                    c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(getContext());
                    this.H0 = iVar;
                    iVar.n(this.S1);
                }
                ArrayList arrayList = new ArrayList();
                if (view == null || sparseArray == null) {
                    return true;
                }
                boolean z8 = isImage(view) && !z6;
                boolean z9 = (!isImage(view) || (aVar = this.g1) == null || aVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                if (z8) {
                    z4 = booleanValue6;
                    z3 = booleanValue5;
                    arrayList.add(new c.a.q0.s.s.f(1, getString(R.string.save_to_emotion), this.H0));
                } else {
                    z3 = booleanValue5;
                    z4 = booleanValue6;
                }
                if (z9) {
                    arrayList.add(new c.a.q0.s.s.f(2, getString(R.string.save_to_local), this.H0));
                }
                if (!z8 && !z9) {
                    c.a.q0.s.s.f fVar5 = new c.a.q0.s.s.f(3, getString(R.string.copy), this.H0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.j2);
                    fVar5.f14428d.setTag(sparseArray3);
                    arrayList.add(fVar5);
                }
                if (!booleanValue && !z6) {
                    if (z5) {
                        fVar4 = new c.a.q0.s.s.f(4, getString(R.string.remove_mark), this.H0);
                    } else {
                        fVar4 = new c.a.q0.s.s.f(4, getString(R.string.mark), this.H0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.j2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    fVar4.f14428d.setTag(sparseArray4);
                    arrayList.add(fVar4);
                }
                if (this.mIsLogin && !this.q0) {
                    if (!c.a.r0.j2.k.e.f1.a.h(this.v0) && !booleanValue4 && booleanValue3) {
                        c.a.q0.s.s.f fVar6 = new c.a.q0.s.s.f(5, getString(R.string.mute_option), this.H0);
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
                        fVar6.f14428d.setTag(sparseArray5);
                        arrayList.add(fVar6);
                    } else {
                        if ((d3(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                            c.a.q0.s.s.f fVar7 = new c.a.q0.s.s.f(5, getString(R.string.report_text), this.H0);
                            fVar7.f14428d.setTag(str);
                            arrayList.add(fVar7);
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
                        if (!c.a.r0.j2.k.e.f1.a.h(this.v0) && z3) {
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
                            fVar2 = new c.a.q0.s.s.f(6, getString(R.string.delete), this.H0);
                            fVar2.f14428d.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            fVar2 = null;
                        }
                        fVar = new c.a.q0.s.s.f(7, getString(R.string.bar_manager), this.H0);
                        fVar.f14428d.setTag(sparseArray6);
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
                        if (this.v0.P0().V() == 1002 && !booleanValue2) {
                            fVar3 = new c.a.q0.s.s.f(6, getString(R.string.report_text), this.H0);
                        } else {
                            fVar3 = new c.a.q0.s.s.f(6, getString(R.string.delete), this.H0);
                        }
                        fVar3.f14428d.setTag(sparseArray7);
                        fVar2 = fVar3;
                        fVar = null;
                    } else {
                        fVar = null;
                        fVar2 = null;
                    }
                    if (fVar2 != null) {
                        arrayList.add(fVar2);
                    }
                    if (fVar != null) {
                        arrayList.add(fVar);
                    }
                    c.a.r0.j2.k.e.f1.a.a(arrayList, this.H0, this.j2, this.v0);
                }
                if (c.a.q0.b.d.E()) {
                    b3 = c.a.r0.j2.k.e.f1.a.c(arrayList, this.j2.q(), sparseArray, this.H0);
                } else {
                    b3 = c.a.r0.j2.k.e.f1.a.b(arrayList, this.j2.q(), sparseArray, this.H0);
                }
                c.a.r0.j2.k.e.f1.a.k(b3, this.f55087f);
                c.a.r0.j2.k.e.f1.a.e(b3);
                this.H0.o(c.a.r0.j2.k.e.f1.a.f(this.j2));
                if (c.a.q0.b.d.E()) {
                    this.H0.l(b3, false);
                } else {
                    this.H0.l(b3, true);
                }
                PopupDialog popupDialog = new PopupDialog(getPageContext(), this.H0);
                this.G0 = popupDialog;
                popupDialog.showDialog();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.v0.f55294f).param("fid", this.v0.getForumId()).param("uid", this.v0.P0().O().J().getUserId()).param("post_id", this.v0.y()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void C3(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            c.a.r0.j2.k.e.f1.b.l(this, j3, str, j4);
        }
    }

    public final void D2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.r0.j3.i0.p z3 = this.v0.P0().z();
        if (z3 != null && str.equals(z3.F0())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().f4 = null;
            }
            this.v0.P0().b();
        }
        c.a.r0.j3.i0.p k02 = this.v0.k0();
        if (k02 == null || !str.equals(k02.F0())) {
            return;
        }
        this.v0.W();
    }

    public final void D3(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            c.a.r0.j2.k.e.f1.a.d(getActivity(), getPageContext(), new q0(this, sparseArray, i3, z3), new r0(this));
        }
    }

    public final void E2(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (pbModel = this.v0) == null || pbModel.P0() == null || this.v0.P0().O() == null || !this.v0.P0().O().D2()) {
            return;
        }
        c.a.q0.s.q.d2 O = this.v0.P0().O();
        int i3 = 0;
        if (O.M1()) {
            i3 = 1;
        } else if (O.P1()) {
            i3 = 2;
        } else if (O.N1()) {
            i3 = 3;
        } else if (O.O1()) {
            i3 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i3);
        TiebaStatic.log(statisticItem);
    }

    public final boolean E3(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        c.a.q0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.P0() == null) {
                return false;
            }
            c.a.r0.j2.h.e P0 = this.v0.P0();
            c.a.q0.s.q.d2 O = P0.O();
            if (O != null) {
                if (O.M1() || O.P1()) {
                    return false;
                }
                if (O.N1() || O.O1()) {
                    return z3;
                }
            }
            if (z3) {
                return true;
            }
            if ((O != null && O.J() != null && O.J().isForumBusinessAccount() && !c.a.r0.w0.v0.isOn()) || this.v0.E() || O.I2() || O.s2() || z4) {
                return false;
            }
            if (P0.m() == null || !P0.m().isBlockBawuDelete) {
                if (P0.V() != 0) {
                    return P0.V() != 3;
                }
                List<c.a.q0.s.q.z1> q3 = P0.q();
                if (ListUtils.getCount(q3) > 0) {
                    for (c.a.q0.s.q.z1 z1Var : q3) {
                        if (z1Var != null && (e0Var = z1Var.f14379g) != null && e0Var.f14152a && !e0Var.f14154c && ((i3 = e0Var.f14153b) == 1 || i3 == 2)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void F2(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048586, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f57243b) ? bVar.f57243b : getString(R.string.delete_fail);
            int i3 = 0;
            if (bVar.f57244c == 1211066) {
                hideProgressBar();
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(R.string.dialog_known, new n1(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else if (bVar.f57245d != 0) {
                this.C0.m0(0, bVar.f57242a, bVar.f57243b, z3);
            }
            if (bVar.f57242a) {
                int i4 = bVar.f57245d;
                if (i4 == 1) {
                    ArrayList<PostData> F = this.v0.P0().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.f57248g.equals(F.get(i3).E())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.v0.P0().O().m4(this.v0.P0().O().U0() - 1);
                    this.C0.u1(this.v0.P0());
                } else if (i4 == 0) {
                    B2();
                } else if (i4 == 2) {
                    ArrayList<PostData> F2 = this.v0.P0().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).M().size()) {
                                break;
                            } else if (bVar.f57248g.equals(F2.get(i5).M().get(i6).E())) {
                                F2.get(i5).M().remove(i6);
                                F2.get(i5).l();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).n(bVar.f57248g);
                    }
                    if (z4) {
                        this.C0.u1(this.v0.P0());
                    }
                    delGodReplyFloor(bVar, this.C0);
                }
            }
        }
    }

    public final boolean F3(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z3)) == null) {
            if (z3 || (pbModel = this.v0) == null || pbModel.P0() == null || (this.v0.P0().m() != null && this.v0.P0().m().isBlockBawuDelete)) {
                return false;
            }
            c.a.r0.j2.h.e P0 = this.v0.P0();
            return ((P0.O() != null && P0.O().J() != null && P0.O().J().isForumBusinessAccount() && !c.a.r0.w0.v0.isOn()) || this.v0.E() || this.v0.P0().V() == 0 || this.v0.P0().V() == 3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final void G2(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048588, this, i3, gVar) == null) || gVar == null) {
            return;
        }
        this.C0.m0(this.y0.getLoadDataMode(), gVar.f57264a, gVar.f57265b, false);
        if (gVar.f57264a) {
            this.D0 = true;
            if (i3 == 2 || i3 == 3) {
                this.E0 = true;
                this.F0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.E0 = false;
                this.F0 = true;
            }
            if (i3 == 2) {
                this.v0.P0().O().W3(1);
                this.v0.d2(1);
            } else if (i3 == 3) {
                this.v0.P0().O().W3(0);
                this.v0.d2(0);
            } else if (i3 == 4) {
                this.v0.P0().O().X3(1);
                this.v0.e2(1);
            } else if (i3 == 5) {
                this.v0.P0().O().X3(0);
                this.v0.e2(0);
            }
            this.C0.K3(this.v0.P0(), this.v0.d1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f57265b)) {
            string = gVar.f57265b;
        } else {
            string = getString(R.string.operation_failed);
        }
        c.a.e.e.p.l.M(getPageContext().getPageActivity(), string);
    }

    public final boolean G3(boolean z3, boolean z4, boolean z5, int i3, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i3), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
            if (z3) {
                return false;
            }
            if (z6 || z7) {
                return true;
            }
            return z4 && (z5 || isManagerCanBlockThread(i3));
        }
        return invokeCommon.booleanValue;
    }

    public final void H2(Rect rect) {
        c.a.r0.j2.k.e.s0 s0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, rect) == null) || rect == null || (s0Var = this.C0) == null || s0Var.Z0() == null || rect.top > this.C0.Z0().getHeight()) {
            return;
        }
        rect.top += this.C0.Z0().getHeight() - rect.top;
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.d1()) {
                return this.v0.N0() == null || this.v0.N0().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.v0.P0() == null || this.v0.P0().O() == null) {
                return -1;
            }
            return this.v0.P0().O().w();
        }
        return invokeV.intValue;
    }

    public final void I3(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, metaData) == null) || metaData == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getActivity());
        aVar.setTitle(getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(getResources().getString(R.string.mark_like_cancel), new h1(this, metaData));
        aVar.setPositiveButton(getResources().getString(R.string.mark_like_confirm), new i1(this, metaData));
        aVar.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final String J2() {
        InterceptResult invokeV;
        c.a.r0.j2.h.e P0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || (P0 = pbModel.P0()) == null) {
                return null;
            }
            return P0.T().f19696c;
        }
        return (String) invokeV.objValue;
    }

    public final void J3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new r2(this));
            aVar.setNegativeButton(R.string.cancel, new s2(this));
            aVar.create(this.b1).show();
        }
    }

    public final String K2() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.P0() == null || this.v0.P0().F() == null || (count = ListUtils.getCount((F = this.v0.P0().F()))) == 0) {
                return "";
            }
            if (this.v0.a1()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.E();
                    }
                }
            }
            int w02 = this.C0.w0();
            PostData postData = (PostData) ListUtils.getItem(F, w02);
            if (postData != null && postData.t() != null) {
                if (this.v0.x1(postData.t().getUserId())) {
                    return postData.E();
                }
                for (int i3 = w02 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (this.v0.x1(postData2.t().getUserId())) {
                        return postData2.E();
                    }
                }
                for (int i4 = w02 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (this.v0.x1(postData3.t().getUserId())) {
                        return postData3.E();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void K3(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048597, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            PopupDialog popupDialog = this.G0;
            if (popupDialog != null && popupDialog.isShowing()) {
                this.G0.dismiss();
                this.G0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(getContext());
                iVar.n(new w(this, sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new c.a.q0.s.s.f(0, getResources().getString(R.string.delete), iVar));
                }
                if (z3) {
                    arrayList.add(new c.a.q0.s.s.f(1, getResources().getString(R.string.un_mute), iVar));
                } else {
                    arrayList.add(new c.a.q0.s.s.f(1, getResources().getString(R.string.mute), iVar));
                }
                iVar.k(arrayList);
                PopupDialog popupDialog2 = new PopupDialog(getPageContext(), iVar);
                this.G0 = popupDialog2;
                popupDialog2.showDialog();
            }
        }
    }

    public final TbRichText L2(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> y3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText K = arrayList.get(i4).K();
                    if (K != null && (y3 = K.y()) != null) {
                        int size = y3.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (y3.get(i6) != null && y3.get(i6).getType() == 8) {
                                i5++;
                                if (y3.get(i6).C().y().equals(str) || y3.get(i6).C().z().equals(str)) {
                                    int h3 = (int) c.a.e.e.p.l.h(TbadkCoreApplication.getInst());
                                    int width = y3.get(i6).C().getWidth() * h3;
                                    int height = y3.get(i6).C().getHeight() * h3;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.g2 = i6;
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
        return (TbRichText) invokeLLI.objValue;
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            showLoadingView(this.C0.b1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
            View i3 = getLoadingView().i();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) i3.getLayoutParams();
            layoutParams.addRule(3, this.C0.Z0().getId());
            i3.setLayoutParams(layoutParams);
        }
    }

    public final int M2(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.i2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.y().size();
                int i5 = i3;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.y().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int h3 = (int) c.a.e.e.p.l.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.C().getWidth() * h3;
                        int height = tbRichTextData.C().getHeight() * h3;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.C().D()) {
                            if (tbRichText == tbRichText2) {
                                if (i6 <= i4) {
                                    i5--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a4 = c.a.r0.j2.h.f.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a4)) {
                                arrayList.add(a4);
                                if (tbRichTextData != null && (C = tbRichTextData.C()) != null) {
                                    String y3 = C.y();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        y3 = C.z();
                                    } else {
                                        imageUrlData.urlType = this.w ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = y3;
                                    imageUrlData.originalUrl = P2(tbRichTextData);
                                    imageUrlData.originalSize = Q2(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = O2(tbRichTextData);
                                    imageUrlData.isLongPic = N2(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = c.a.e.e.m.b.g(this.v0.f1(), -1L);
                                    imageUrlData.mIsReserver = this.v0.a1();
                                    imageUrlData.mIsSeeHost = this.v0.t0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a4, imageUrlData);
                                    }
                                }
                            }
                            if (!this.i2) {
                                i5++;
                            }
                        }
                    }
                }
                return i5;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public final void M3(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && getPbModel() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                getPbModel().Y(postWriteCallBackData.getPostId());
                int t02 = this.C0.t0();
                this.k1 = t02;
                this.v0.Z1(t02, this.C0.A0());
            }
            this.C0.e0();
            this.mContentProcessController.c();
            c.a.q0.x.w.e eVar = this.Q0;
            if (eVar != null) {
                this.C0.x2(eVar.E());
            }
            this.C0.f1();
            this.C0.e3(true);
            this.v0.m1();
        }
    }

    public final boolean N2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return false;
            }
            return tbRichTextData.C().E();
        }
        return invokeL.booleanValue;
    }

    public final void N3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i3) == null) {
            c.a.r0.j2.k.e.f1.b.o(this, I2(), i3);
        }
    }

    public final boolean O2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return false;
            }
            return tbRichTextData.C().F();
        }
        return invokeL.booleanValue;
    }

    public final void O3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (str == null) {
                str = "";
            }
            c.a.e.a.f fVar = this.b1;
            if (fVar == null) {
                return;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(fVar.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new t2(this));
            aVar.create(this.b1).show();
        }
    }

    public final String P2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return null;
            }
            return tbRichTextData.C().A();
        }
        return (String) invokeL.objValue;
    }

    public final void P3(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.C0.m3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.b1.getPageActivity());
            if (c.a.e.e.p.k.isEmpty(str)) {
                aVar.setMessage(this.b1.getResources().getString(R.string.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new u2(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new v2(this));
            aVar.create(this.b1).show();
        }
    }

    public final long Q2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return 0L;
            }
            return tbRichTextData.C().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void Q3() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (pbModel = this.v0) == null || c.a.e.e.p.k.isEmpty(pbModel.f1())) {
            return;
        }
        c.a.q0.a.d.y().P(c.a.q0.a.c.W, c.a.e.e.m.b.g(this.v0.f1(), 0L));
    }

    public final int R2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i3)) == null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return i3 != 3 ? 1 : 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeI.intValue;
    }

    public final void R3(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            S3(postData, false);
        }
    }

    public final int S2(c.a.r0.j2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null) {
                return 0;
            }
            if (eVar.O().o1() == 0) {
                return 1;
            }
            if (eVar.O().o1() == 54) {
                return 2;
            }
            return eVar.O().o1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public final void S3(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048613, this, postData, z3) == null) || postData == null || (pbModel = this.v0) == null || pbModel.P0() == null || postData.A() == 1) {
            return;
        }
        String f12 = this.v0.f1();
        String E = postData.E();
        int V = this.v0.P0() != null ? this.v0.P0().V() : 0;
        AbsPbActivity.e p3 = p3(E);
        if (p3 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(f12, E, "pb", true, false, null, false, null, V, postData.P(), this.v0.P0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null, 5).addBigImageData(p3.f55053a, p3.f55054b, p3.f55059g, p3.f55062j);
        addBigImageData.setKeyPageStartFrom(this.v0.O0());
        addBigImageData.setFromFrsForumId(this.v0.getFromForumId());
        addBigImageData.setWorksInfoData(this.v0.j1());
        addBigImageData.setKeyFromForumId(this.v0.getForumId());
        addBigImageData.setBjhData(this.v0.j0());
        addBigImageData.setIsOpenEditor(z3);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final void T2(int i3, Intent intent) {
        c.a.q0.x.n nVar;
        c.a.q0.x.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048614, this, i3, intent) == null) {
            if (i3 == 0) {
                this.C0.f1();
                this.C0.P0().c();
                this.C0.e3(false);
            }
            this.C0.q2();
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
                    if (editorType != 1 || this.C0.P0() == null || this.C0.P0().b() == null) {
                        return;
                    }
                    c.a.q0.x.w.h b3 = this.C0.P0().b();
                    b3.c0(this.v0.P0().O());
                    b3.C(writeData);
                    b3.d0(pbEditorData.getVoiceModel());
                    c.a.q0.x.m findToolById = b3.a().findToolById(6);
                    if (findToolById != null && (nVar2 = findToolById.k) != null) {
                        nVar2.onAction(new c.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        b3.G();
                        return;
                    }
                    return;
                }
                this.Q0.U();
                this.Q0.v0(pbEditorData.getVoiceModel());
                this.Q0.I(writeData);
                c.a.q0.x.m findToolById2 = this.Q0.a().findToolById(6);
                if (findToolById2 != null && (nVar = findToolById2.k) != null) {
                    nVar.onAction(new c.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    this.Q0.N(null, null);
                }
            }
        }
    }

    public final void T3() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (absPbActivity = this.f55086e) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public final void U2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.P0() != null && this.v0.P0().f0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.v0.f1(), str);
                c.a.q0.s.q.d2 O = this.v0.P0().O();
                if (O.M1()) {
                    format = format + "&channelid=33833";
                } else if (O.R1()) {
                    format = format + "&channelid=33842";
                } else if (O.P1()) {
                    format = format + "&channelid=33840";
                }
                e3(format);
                return;
            }
            this.w0.a(str);
        }
    }

    public final boolean U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.P0() == null || !this.v0.P0().f0()) {
                if (this.v0.B0()) {
                    MarkData n02 = this.v0.n0();
                    if (n02 != null && this.v0.z0()) {
                        MarkData h02 = this.v0.h0(this.C0.w0());
                        if (h02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", n02);
                            this.f55086e.setResult(-1, intent);
                            return true;
                        } else if (h02.getPostId() != null && !h02.getPostId().equals(n02.getPostId())) {
                            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
                            aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                            aVar.setPositiveButton(R.string.confirm, new u1(this, h02, n02, aVar));
                            aVar.setNegativeButton(R.string.cancel, new v1(this, n02, aVar));
                            aVar.setOnCalcelListener(new w1(this, n02, aVar));
                            aVar.create(getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", n02);
                            this.f55086e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.v0.P0() != null && this.v0.P0().F() != null && this.v0.P0().F().size() > 0 && this.v0.z0()) {
                    this.f55086e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void V2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            c.a.r0.j2.k.e.f1.b.j(this, intent);
        }
    }

    public final void V3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.v0.f55294f).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(c.a.r0.j2.k.e.f1.a.m(i3))));
        }
    }

    public final void W2(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048620, this, i3, i4) == null) {
            c.a.q0.d1.m0.b(new b(this, i4), new c(this, i4, i3));
        }
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.B(this.v0.getForumId()) && this.v0.P0() != null && this.v0.P0().m() != null) {
            if (this.v0.P0().m().isLike() == 1) {
                this.v0.e0().A(this.v0.getForumId(), this.v0.f1());
            }
        }
    }

    public final void X2(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i3) == null) {
            c.a.q0.d1.m0.b(new w2(this), new a(this, i3));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i3 == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i3 == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void X3(c.a.q0.s.q.u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, uVar) == null) || uVar == null) {
            return;
        }
        this.w2 = uVar;
        this.f55088g = true;
        this.C0.n2();
        this.C0.F2(this.v2);
    }

    public final void Y2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, bundle) == null) {
            c.a.q0.i.a c3 = c.a.q0.i.a.c(this.f55086e);
            this.x0 = c3;
            if (c3 != null) {
                c3.j(this.Z1);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f55086e);
            this.y0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.b2);
            this.z0 = new c.a.q0.t.e.a(getPageContext());
            this.H1.setUniqueId(getUniqueId());
            this.H1.registerListener();
        }
    }

    public final void Y3(int i3) {
        PbModel pbModel;
        c.a.q0.s.q.d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i3) == null) || (pbModel = this.v0) == null || pbModel.P0() == null || (O = this.v0.P0().O()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData L0 = O.L0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (L0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i3);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    O.l4(praiseData);
                } else {
                    O.L0().getUser().add(0, metaData);
                    O.L0().setNum(O.L0().getNum() + 1);
                    O.L0().setIsLike(i3);
                }
            }
            if (O.L0() != null) {
                if (O.L0().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    StringHelper.numFormatOver10000(O.L0().getNum());
                }
            }
        } else if (O.L0() != null) {
            O.L0().setIsLike(i3);
            O.L0().setNum(O.L0().getNum() - 1);
            ArrayList<MetaData> user = O.L0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        O.L0().getUser().remove(next);
                        break;
                    }
                }
            }
            if (O.L0().getNum() < 1) {
                getResources().getString(R.string.zan);
            } else {
                String str = O.L0().getNum() + "";
            }
        }
        if (this.v0.d1()) {
            this.C0.p0().X();
        } else {
            this.C0.M3(this.v0.P0());
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.U = likeModel;
            likeModel.setLoadDataCallBack(new d0(this));
        }
    }

    public final TbRichText Z3(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048627, this, str, i3)) == null) {
            PbModel pbModel = this.v0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.P0() == null || str == null || i3 < 0) {
                return null;
            }
            c.a.r0.j2.h.e P0 = this.v0.P0();
            if (P0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(P0.j());
                tbRichText = L2(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = P0.F();
                x2(P0, F);
                return L2(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.q == null) {
            this.q = new c.a.q0.s.s.b(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
            c.a.q0.s.s.b bVar = this.q;
            bVar.j(strArr, new g0(this));
            bVar.g(b.C0694b.f14406a);
            bVar.h(17);
            bVar.c(getPageContext());
        }
    }

    public void addBackInterceptor(y2 y2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, y2Var) == null) || y2Var == null) {
            return;
        }
        if (this.m1 == null) {
            this.m1 = new ArrayList();
        }
        if (this.m1.contains(y2Var)) {
            return;
        }
        this.m1.add(y2Var);
    }

    public void addBackInterceptorAtFirst(y2 y2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, y2Var) == null) || y2Var == null) {
            return;
        }
        if (this.m1 == null) {
            this.m1 = new ArrayList();
        }
        if (this.m1.contains(y2Var)) {
            return;
        }
        this.m1.add(0, y2Var);
    }

    public final boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            PostData c3 = c.a.r0.j2.h.f.c(this.v0.P0(), this.v0.d1(), this.v0.Z0());
            return (c3 == null || c3.t() == null || c3.t().getGodUserData() == null || c3.t().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean c3(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i3)) == null) ? i3 == 2 || i3 == 1 : invokeI.booleanValue;
    }

    public void checkEasterEgg(boolean z3) {
        c.a.r0.j2.k.e.s0 s0Var;
        int w3;
        int w4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048633, this, z3) == null) || (s0Var = this.C0) == null || s0Var.G0() == null) {
            return;
        }
        int firstVisiblePosition = this.C0.G0().getFirstVisiblePosition();
        int lastVisiblePosition = this.C0.G0().getLastVisiblePosition();
        c.a.r0.j2.k.e.h p02 = this.C0.p0();
        if (p02 == null || this.v0.P0() == null) {
            return;
        }
        if (lastVisiblePosition <= p02.w()) {
            w3 = 0;
            w4 = 1;
        } else {
            w3 = firstVisiblePosition > p02.w() ? firstVisiblePosition - p02.w() : 0;
            w4 = (lastVisiblePosition - p02.w()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (w4 > w3) {
            while (w3 < w4) {
                if (this.C0.G0().getItem(w3) != null && (this.C0.G0().getItem(w3) instanceof PostData) && (postData = (PostData) this.C0.G0().getItem(w3)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.v0.P0().F(), postData.A() - 1);
                    if (postData.p() == null && postData2 != null) {
                        postData.h0(postData2.p());
                    }
                    if (postData.p() != null) {
                        postData.p().p(postData.A());
                        arrayList.add(postData.p());
                    }
                }
                w3++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new k1(this));
            c.a.q0.u.a aVar = (c.a.q0.u.a) ListUtils.getItem(arrayList, 0);
            if (aVar == null || aVar.e() != 1) {
                this.C0.e2(aVar, 1);
            } else if (z3) {
            } else {
                this.C0.e2(aVar, 0);
            }
        }
    }

    public void checkMuteState(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.C0.m3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = c.a.e.e.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.e.e.m.b.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.d1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.a1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean checkPrivacyBeforeInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if ((this.v0.P0() != null && (this.v0.P0().f0() || ThreadCardUtils.isSelf(this.v0.P0().O()))) || this.mReplyPrivacyController == null || this.v0.P0() == null || this.v0.P0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.v0.P0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public boolean checkPrivacyBeforePost(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i3)) == null) {
            if (this.mReplyPrivacyController == null || this.v0.P0() == null || ThreadCardUtils.isSelf(this.v0.P0().O()) || this.v0.P0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeSend(this.v0.P0().d().replyPrivateFlag, i3);
        }
        return invokeI.booleanValue;
    }

    public final boolean d3(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048637, this, z3)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.P0() != null) {
                return ((this.v0.P0().V() != 0) || this.v0.P0().O() == null || this.v0.P0().O().J() == null || TextUtils.equals(this.v0.P0().O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048638, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (c.a.q0.f1.m.e[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), c.a.q0.f1.m.e.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (c.a.r0.j2.k.e.x0.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new c.a.q0.f1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void delGodReplyFloor(ForumManageModel.b bVar, c.a.r0.j2.k.e.s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, bVar, s0Var) == null) {
            List<PostData> list = this.v0.P0().T().f19694a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).M().size()) {
                        break;
                    } else if (bVar.f57248g.equals(list.get(i3).M().get(i4).E())) {
                        list.get(i3).M().remove(i4);
                        list.get(i3).l();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).n(bVar.f57248g);
            }
            if (z3) {
                s0Var.u1(this.v0.P0());
            }
        }
    }

    public void deleteThread(c.a.q0.s.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (aVar.getYesButtonTag() instanceof SparseArray) {
                    deleteThread((SparseArray) aVar.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public void deleteThreadDirect(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(c.a.r0.j2.k.e.s0.W1, Integer.valueOf(c.a.r0.j2.k.e.s0.X1));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                deleteThread(sparseArray, (JSONArray) null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void doDoubleClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            TiebaStatic.log("c12181");
            c.a.r0.j2.k.e.s0 s0Var = this.C0;
            if (s0Var == null || this.v0 == null) {
                return;
            }
            if ((s0Var != null && !s0Var.w1()) || this.v0.P0() == null || this.v0.P0().S() == null) {
                return;
            }
            c.a.r0.j2.k.e.s0 s0Var2 = this.C0;
            if (s0Var2 == null || s0Var2.v0() == null || !this.C0.v0().isFalling()) {
                c.a.r0.j2.h.p S = this.v0.P0().S();
                if (checkUpIsLogin()) {
                    if ((!S.g() || S.b() != 2) && this.C0.p0() != null && this.C0.p0().z() != null) {
                        this.C0.p0().z().k0(this.v0.f1(), this.v0.getFromForumId());
                    }
                    if (System.currentTimeMillis() - this.B > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).startAnimation(false);
                        this.B = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void doPraiseClick() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || this.C0 == null || (pbModel = this.v0) == null) {
            return;
        }
        if ((pbModel.P0() == null && this.v0.P0().S() == null) || !checkUpIsLogin() || this.C0.p0() == null || this.C0.p0().z() == null) {
            return;
        }
        this.C0.p0().z().k0(this.v0.f1(), this.v0.getFromForumId());
    }

    public final void e3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || this.w2 == null) {
            return;
        }
        if (this.u2 == -1) {
            showToast(R.string.pb_manga_not_next_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.w2.a(), this.u2, 0)));
            this.f55086e.finish();
        }
    }

    @Override // c.a.r0.j2.o.b
    public void finish() {
        c.a.r0.j2.k.e.s0 s0Var;
        CardHListViewData r3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            c.a.r0.j2.k.e.s0 s0Var2 = this.C0;
            if (s0Var2 != null) {
                s0Var2.e0();
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.P0() != null && !this.v0.P0().f0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.v0.P0().O().f0();
                if (this.v0.isShareThread() && this.v0.P0().O().y1 != null) {
                    historyMessage.threadName = this.v0.P0().O().y1.f47520b;
                } else {
                    historyMessage.threadName = this.v0.P0().O().getTitle();
                }
                if (this.v0.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.v0.P0().m().getName();
                }
                ArrayList<PostData> F = this.v0.P0().F();
                c.a.r0.j2.k.e.s0 s0Var3 = this.C0;
                int w02 = s0Var3 != null ? s0Var3.w0() : 0;
                if (F != null && w02 >= 0 && w02 < F.size()) {
                    historyMessage.postID = F.get(w02).E();
                }
                historyMessage.isHostOnly = this.v0.t0();
                historyMessage.isSquence = this.v0.d1();
                historyMessage.isShareThread = this.v0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            c.a.q0.x.w.e eVar = this.Q0;
            if (eVar != null) {
                eVar.K();
            }
            if (this.n && getPbView() != null) {
                getPbView().j0();
            }
            PbModel pbModel2 = this.v0;
            if (pbModel2 != null && (pbModel2.v0() || this.v0.y0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.v0.f1());
                if (this.D0) {
                    if (this.F0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.v0.E0());
                    }
                    if (this.E0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.v0.A0());
                    }
                }
                if (this.v0.P0() != null && System.currentTimeMillis() - this.t >= 40000 && (r3 = this.v0.P0().r()) != null && !ListUtils.isEmpty(r3.getDataList())) {
                    intent.putExtra("guess_like_data", r3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.l1);
                }
                this.f55086e.setResult(-1, intent);
            }
            if (U3()) {
                if (this.v0 != null && (s0Var = this.C0) != null && s0Var.G0() != null) {
                    c.a.r0.j2.h.e P0 = this.v0.P0();
                    if (P0 != null) {
                        if (P0.U() != null) {
                            P0.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!P0.l0() && !this.L && P0.f19633h == null) {
                            c.a.r0.j2.k.e.k0.b().n(this.v0.Q0(), this.C0.G0().onSaveInstanceState(), this.v0.d1(), this.v0.t0(), this.C0.N0() != null && this.C0.N0().getVisibility() == 0);
                            if (this.k1 >= 0 || this.v0.h1() != null) {
                                c.a.r0.j2.k.e.k0.b().q(this.v0.h1());
                                c.a.r0.j2.k.e.k0.b().r(this.v0.i1());
                                c.a.r0.j2.k.e.k0.b().o(this.v0.I0());
                            }
                        }
                    }
                } else {
                    c.a.r0.j2.k.e.k0.b().m();
                }
                T3();
            }
        }
    }

    public final void g3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, bundle) == null) {
            PbModel pbModel = this.f55086e.getPbModel();
            this.v0 = pbModel;
            if (pbModel.m0() != null) {
                this.v0.m0().c(this.s2);
            }
            if (this.v0.L0() != null) {
                this.v0.L0().f(this.p1);
            }
            if (StringUtils.isNull(this.v0.f1())) {
                this.f55086e.finish();
            } else if (!"from_tieba_kuang".equals(this.P) || this.P == null) {
            } else {
                this.v0.h2(6);
            }
        }
    }

    public AntiData getAntiData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.P0() == null) {
                return null;
            }
            return this.v0.P0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public c.a.r0.j2.k.e.c1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.f55086e.getEventController() : (c.a.r0.j2.k.e.c1.a) invokeV.objValue;
    }

    public PostData getFirstPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            c.a.r0.j2.k.e.s0 s0Var = this.C0;
            PbModel pbModel = this.v0;
            return s0Var.x0(pbModel.J, pbModel.d1());
        }
        return (PostData) invokeV.objValue;
    }

    public String getFromWhere() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.g
    public c.a.e.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this.O == null) {
                this.O = new c.a.e.e.k.b<>(new y1(this), 20, 0);
            }
            return this.O;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.g
    public c.a.e.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (this.G == null) {
                this.G = new c.a.e.e.k.b<>(new x1(this), 8, 0);
            }
            return this.G;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public PbInterviewStatusView.f getInterviewStatusCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.t0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean getIsMangaThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? (!this.f55088g && this.t2 == -1 && this.u2 == -1) ? false : true : invokeV.booleanValue;
    }

    public boolean getLinkGoodsMoreShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.N : invokeV.booleanValue;
    }

    public int getMangaNextChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.u2 : invokeV.intValue;
    }

    public int getMangaPrevChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.t2 : invokeV.intValue;
    }

    @Override // c.a.r0.j2.o.b
    public AbsPbActivity getPbActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.f55086e : (AbsPbActivity) invokeV.objValue;
    }

    public c.a.q0.x.w.e getPbEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.Q0 : (c.a.q0.x.w.e) invokeV.objValue;
    }

    @Override // c.a.r0.j2.o.b
    public PbFragment getPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // c.a.r0.j2.o.b
    public PbModel.g getPbFragmentDataCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.W1 : (PbModel.g) invokeV.objValue;
    }

    @Override // c.a.r0.j2.o.b
    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.v0 : (PbModel) invokeV.objValue;
    }

    public c.a.r0.j2.k.e.c1.b getPbNavigationAnimDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.f55090i : (c.a.r0.j2.k.e.c1.b) invokeV.objValue;
    }

    public c.a.r0.j2.k.e.e1.a getPbRecThreadController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.s0 : (c.a.r0.j2.k.e.e1.a) invokeV.objValue;
    }

    public c.a.r0.j2.k.e.s0 getPbView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.C0 : (c.a.r0.j2.k.e.s0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048671, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public c.a.q0.s.q.n1 getRecomStatisticData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.l0 : (c.a.q0.s.q.n1) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.g
    public c.a.e.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            c.a.e.e.k.b<RelativeLayout> bVar = new c.a.e.e.k.b<>(new c2(this), 10, 0);
            this.K = bVar;
            return bVar;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.g
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            c.a.r0.j2.k.e.s0 s0Var = this.C0;
            if (s0Var == null) {
                return 0;
            }
            return s0Var.U0();
        }
        return invokeV.intValue;
    }

    public String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.Z : (String) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.g
    public c.a.e.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (this.E == null) {
                this.E = TbRichTextView.createTextViewPool(getPageContext().getPageActivity(), 8);
            }
            return this.E;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.g
    public c.a.e.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            if (this.J == null) {
                this.J = new c.a.e.e.k.b<>(new l2(this), 15, 0);
            }
            return this.J;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.g
    public c.a.e.e.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            if (this.I == null) {
                this.I = new c.a.e.e.k.b<>(new z1(this), 5, 0);
            }
            return this.I;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.e.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            if (this.F == null) {
                this.F = UserIconBox.createUserIconPool(getPageContext().getPageActivity(), 8);
            }
            return this.F;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            c.a.r0.j2.k.e.s0 s0Var = this.C0;
            if (s0Var == null) {
                return 0;
            }
            return s0Var.a1();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.j2.o.b
    public VideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public String getVideoSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.S : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.o : (VoiceManager) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.g
    public c.a.e.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (this.H == null) {
                this.H = new c.a.e.e.k.b<>(new a2(this), 8, 0);
            }
            return this.H;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public void goInterviewLivePage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            if (this.k) {
                this.R = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.v0.P0() == null || this.v0.P0().O() == null || this.v0.P0().O().j1() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.v0.P0().O().j1().g(), this.v0.P0().O().j1().f(), this.v0.P0().O().j1().b(), this.v0.P0().O().j1().c(), this.v0.P0().O().r0(), this.v0.P0().O().q0())));
                this.f55086e.finish();
            }
        }
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048687, this) == null) || this.w2 == null) {
            return;
        }
        if (this.t2 == -1) {
            showToast(R.string.pb_manga_not_prev_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.w2.a(), this.t2, 0)));
            this.f55086e.finish();
        }
    }

    public void handleMuteClick(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048688, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.d1);
            userMuteAddAndDelCustomMessage.setTag(this.d1);
            P3(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void hideKeyBroad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048689, this) == null) || this.f55086e == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.f55086e.getCurrentFocus() == null) {
            return;
        }
        c.a.e.e.p.l.x(getPageContext().getPageActivity(), this.f55086e.getCurrentFocus());
    }

    public void hideKeyboardAndEditor() {
        c.a.r0.j2.k.e.s0 s0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048690, this) == null) || (s0Var = this.C0) == null) {
            return;
        }
        s0Var.f1();
        hideKeyBroad();
    }

    public final void i3(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048691, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || y2() || !checkPrivacyBeforeInput()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.c0);
            this.i0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (getPbView().P0() != null && postData != null) {
            getPbView().P0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
        }
        if (this.v0.P0() != null && this.v0.P0().f0()) {
            c.a.e.e.m.e.a().postDelayed(new v0(this, str, str2), 0L);
            return;
        }
        if (this.U0 == null) {
            c.a.r0.w0.g2.a.c cVar = new c.a.r0.w0.g2.a.c(getPageContext());
            this.U0 = cVar;
            cVar.j(1);
            this.U0.i(new w0(this, str, str2));
        }
        PbModel pbModel = this.v0;
        if (pbModel == null || pbModel.P0() == null || this.v0.P0().m() == null) {
            return;
        }
        this.U0.g(this.v0.P0().m().getId(), c.a.e.e.m.b.g(this.v0.f1(), 0L));
    }

    public boolean isActivityPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                return pbModel.v0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isHostOnlyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                return pbModel.t0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isImage(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048695, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public boolean isMakeGoodsShowing(int i3) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048696, this, i3)) == null) {
            if (i3 == 1) {
                return true;
            }
            if (this.v0.P0().U() != null && (forumToolAuth = this.v0.P0().U().getForumToolAuth()) != null) {
                for (int i4 = 0; i4 < forumToolAuth.size(); i4++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i4);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isManagerCanBlockThread(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048697, this, i3)) == null) ? i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 : invokeI.booleanValue;
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.w1();
        }
        return invokeV.booleanValue;
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            c.a.r0.j2.h.e P0 = this.v0.P0();
            this.v0.o2(true);
            c.a.q0.i.a aVar = this.x0;
            if (aVar != null) {
                P0.B0(aVar.g());
            }
            this.C0.u1(P0);
        }
    }

    public final void k3() {
        MarkData h02;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048700, this) == null) || this.x0 == null) {
            return;
        }
        if (this.v0.P0() != null && this.v0.P0().f0()) {
            h02 = this.v0.h0(0);
        } else {
            h02 = this.v0.h0(this.C0.F0());
        }
        if (h02 == null) {
            return;
        }
        if (h02.isApp() && (h02 = this.v0.h0(this.C0.F0() + 1)) == null) {
            return;
        }
        this.C0.S2();
        this.x0.i(h02);
        if (!this.x0.e()) {
            if (this.C0 != null && this.v0 != null && c.a.q0.b.d.Q() && !c.a.r0.j2.k.e.f1.b.k(this.v0.f55294f)) {
                this.C0.x3();
                c.a.r0.j2.k.e.f1.b.b(this.v0.f55294f);
            }
            this.x0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.x0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final void l3(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, view) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e3) {
                e3.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            markFloor(postData);
        }
    }

    public void loadNextVideoPb(String str) {
        c.a.r0.j2.k.e.s0 s0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048702, this, str) == null) || this.v0 == null || StringUtils.isNull(str) || (s0Var = this.C0) == null) {
            return;
        }
        s0Var.B2(true);
        this.v0.B1(str);
        this.L = true;
        this.C0.e0();
        this.C0.d1();
    }

    public final boolean m3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048703, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p3 = c.a.q0.s.d0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    c.a.q0.m.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void markFloor(PostData postData) {
        PostData firstPostData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048704, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.E() != null && postData.E().equals(this.v0.K0())) {
            z3 = true;
        }
        MarkData J0 = this.v0.J0(postData);
        if (this.v0.P0() != null && this.v0.P0().f0() && (firstPostData = getFirstPostData()) != null) {
            J0 = this.v0.J0(firstPostData);
        }
        if (J0 == null) {
            return;
        }
        this.C0.S2();
        c.a.q0.i.a aVar = this.x0;
        if (aVar != null) {
            aVar.i(J0);
            if (!z3) {
                this.x0.a();
            } else {
                this.x0.d();
            }
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            if (!c.a.e.e.p.j.z()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.C0.e0();
            if (this.m) {
                return;
            }
            stopVoice();
            this.C0.S2();
            if (this.v0.LoadData()) {
                this.C0.w3();
            }
        }
    }

    public final void o3(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048706, this, str, i3, eVar) == null) || eVar == null) {
            return;
        }
        c.a.r0.j2.h.e P0 = this.v0.P0();
        TbRichText Z3 = Z3(str, i3);
        if (Z3 == null || (tbRichTextData = Z3.y().get(this.g2)) == null) {
            return;
        }
        eVar.f55058f = String.valueOf(Z3.getPostId());
        eVar.f55053a = new ArrayList<>();
        eVar.f55054b = new ConcurrentHashMap<>();
        if (!tbRichTextData.C().D()) {
            eVar.f55060h = false;
            String a4 = c.a.r0.j2.h.f.a(tbRichTextData);
            eVar.f55053a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.w ? 17 : 18;
            }
            imageUrlData.originalUrl = P2(tbRichTextData);
            imageUrlData.originalUrl = P2(tbRichTextData);
            imageUrlData.originalSize = Q2(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = O2(tbRichTextData);
            imageUrlData.isLongPic = N2(tbRichTextData);
            imageUrlData.postId = Z3.getPostId();
            imageUrlData.mIsReserver = this.v0.a1();
            imageUrlData.mIsSeeHost = this.v0.t0();
            eVar.f55054b.put(a4, imageUrlData);
            if (P0 != null) {
                if (P0.m() != null) {
                    eVar.f55055c = P0.m().getName();
                    eVar.f55056d = P0.m().getId();
                }
                if (P0.O() != null) {
                    eVar.f55057e = P0.O().f0();
                }
                eVar.f55059g = P0.t() == 1;
            }
            imageUrlData.threadId = c.a.e.e.m.b.g(eVar.f55057e, -1L);
            return;
        }
        eVar.f55060h = true;
        int size = P0.F().size();
        this.i2 = false;
        eVar.f55062j = -1;
        int M2 = P0.j() != null ? M2(P0.j().K(), Z3, i3, i3, eVar.f55053a, eVar.f55054b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = P0.F().get(i4);
            if (postData.E() == null || P0.j() == null || P0.j().E() == null || !postData.E().equals(P0.j().E())) {
                M2 = M2(postData.K(), Z3, M2, i3, eVar.f55053a, eVar.f55054b);
            }
        }
        if (eVar.f55053a.size() > 0) {
            ArrayList<String> arrayList = eVar.f55053a;
            eVar.f55061i = arrayList.get(arrayList.size() - 1);
        }
        if (P0 != null) {
            if (P0.m() != null) {
                eVar.f55055c = P0.m().getName();
                eVar.f55056d = P0.m().getId();
            }
            if (P0.O() != null) {
                eVar.f55057e = P0.O().f0();
            }
            eVar.f55059g = P0.t() == 1;
        }
        eVar.f55062j = M2;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
            this.W1.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).getFirstLoadData(), "", 1);
            this.f55086e.getTiePlusEventController().addEventAckedCallbackWeaked(this.r0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        EmotionImageData emotionImageData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048708, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.Q0.J(i3, i4, intent);
            c.a.r0.j2.k.e.b1.f.a aVar = this.T;
            if (aVar != null) {
                aVar.i(i3, i4, intent);
            }
            if (getPbView().P0() != null) {
                getPbView().P0().g(i3, i4, intent);
            }
            if (i3 == 25035) {
                T2(i4, intent);
            }
            if (i4 == -1) {
                if (i3 == 11009) {
                    k3();
                } else if (i3 == 13008) {
                    c.a.r0.j2.k.e.k0.b().m();
                    this.u0.postDelayed(new s1(this), 1000L);
                } else if (i3 == 13011) {
                    c.a.r0.x2.a.g().m(getPageContext());
                } else if (i3 == 23003) {
                    if (intent == null || this.v0 == null) {
                        return;
                    }
                    C3(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i3 == 23007) {
                    V2(intent);
                } else if (i3 == 25012) {
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                } else if (i3 == 25016 || i3 == 25023) {
                    Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                    if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                        return;
                    }
                    this.V0 = emotionImageData;
                    if (checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        s3(emotionImageData);
                    }
                } else if (i3 == 25033) {
                    View view = this.V;
                    if (view != null) {
                        this.C0.j3(view);
                    }
                } else if (i3 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        c.a.r0.x2.a.g().m(getPageContext());
                        W3();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.B0;
                        if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.t) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.w(str, intExtra, new t1(this));
                    }
                } else if (i3 != 24008) {
                    switch (i3) {
                        case 25055:
                            View view2 = this.W;
                            if (view2 != null) {
                                view2.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view3 = this.X;
                            if (view3 != null) {
                                view3.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            c.a.r0.j2.k.e.s0 s0Var = this.C0;
                            if (s0Var == null || s0Var.q0() == null) {
                                return;
                            }
                            this.C0.q0().performClick();
                            return;
                        case 25058:
                            View view4 = this.Y;
                            if (view4 != null) {
                                view4.performClick();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    this.C0.U2(false);
                    if (this.v0.P0() == null || this.v0.P0().O() == null || this.v0.P0().O().O0() == null) {
                        return;
                    }
                    this.v0.P0().O().O0().setStatus(2);
                }
            }
        }
    }

    @Override // c.a.q0.f1.m.g
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048709, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.A = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, context) == null) {
            super.onAttach(context);
            this.f55086e = (AbsPbActivity) context;
        }
    }

    public void onBackPressed() {
        List<y2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048711, this) == null) || (list = this.m1) == null || list.isEmpty()) {
            return;
        }
        int size = this.m1.size();
        while (true) {
            size--;
            if (size <= -1 || this.m1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048712, this, i3) == null) || this.a0 == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.C0.M1(i3);
        c.a.q0.x.w.e eVar = this.Q0;
        if (eVar != null && eVar.a() != null) {
            this.Q0.a().onChangeSkinType(i3);
        }
        if (this.C0.a() != null) {
            this.C0.a().onChangeSkinType(getPageContext(), i3);
        }
        this.mContentProcessController.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.a0 = i3;
        stopVoice();
    }

    @Override // c.a.q0.s.s.a.e
    public void onClick(c.a.q0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, aVar) == null) {
            deleteThread(aVar, (JSONArray) null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int i3 = configuration.orientation;
            if (i3 == this.C) {
                return;
            }
            this.C = i3;
            if (i3 == 2) {
                this.M = true;
            } else {
                this.M = false;
            }
            c.a.r0.j2.k.e.s0 s0Var = this.C0;
            if (s0Var != null) {
                s0Var.N1(configuration);
            }
            PopupDialog popupDialog = this.G0;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        c.a.r0.j2.k.e.s0 s0Var;
        c.a.r0.j2.k.e.s0 s0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, bundle) == null) {
            this.t = System.currentTimeMillis();
            this.b1 = getPageContext();
            Intent intent = this.f55086e.getIntent();
            if (intent != null) {
                this.r = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.P = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.P)) {
                        this.P = data.getQueryParameter("from");
                    }
                }
                this.Z = intent.getStringExtra("st_type");
                "from_interview_live".equals(this.P);
                this.t2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.u2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.v2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.L0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.M0 = intent.getStringExtra("high_light_post_id");
                this.N0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (getIsMangaThread()) {
                    this.f55086e.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.S = stringExtra;
                this.S = c.a.e.e.p.k.isEmpty(stringExtra) ? "" : this.S;
                this.l1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                c.a.q0.s.q.n1 n1Var = new c.a.q0.s.q.n1();
                this.l0 = n1Var;
                n1Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.bjhFrom = intExtra;
                if (intExtra == 0) {
                    this.bjhFrom = intent.getIntExtra("key_start_from", 0);
                }
                this.lastTid = intent.getStringExtra("last_tid");
            } else {
                this.r = System.currentTimeMillis();
            }
            this.v = this.t - this.r;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.p = 0;
            g3(bundle);
            if (this.v0.P0() != null) {
                this.v0.P0().K0(this.S);
            }
            Z2();
            if (intent != null && (s0Var2 = this.C0) != null) {
                s0Var2.f20234b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.e1 == null) {
                        this.e1 = new a0(this, intent);
                    }
                    c.a.e.e.m.e.a().postDelayed(this.e1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.v0.P0() != null) {
                    this.v0.i2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.o = voiceManager;
            voiceManager.onCreate(getPageContext());
            Y2(bundle);
            c.a.q0.x.w.g gVar = new c.a.q0.x.w.g();
            this.P0 = gVar;
            x3(gVar);
            c.a.q0.x.w.e eVar = (c.a.q0.x.w.e) this.P0.a(getActivity());
            this.Q0 = eVar;
            eVar.g0(this.f55086e.getPageContext());
            this.Q0.p0(this.U1);
            this.Q0.q0(this.W0);
            this.Q0.i0(1);
            this.Q0.H(this.f55086e.getPageContext(), bundle);
            this.Q0.a().addHideLauncher(new c.a.q0.x.k(getActivity()));
            this.Q0.a().showLinePositionBottom(true);
            z3(true);
            this.Q0.Q(this.v0.s0(), this.v0.f1(), this.v0.p0());
            registerListener(this.t1);
            if (!this.v0.D0()) {
                this.Q0.t(this.v0.f1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.Q0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.v0.p1()) {
                this.Q0.m0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                c.a.r0.j2.k.e.s0 s0Var3 = this.C0;
                if (s0Var3 != null) {
                    this.Q0.m0(s0Var3.S0());
                }
            }
            registerListener(this.s1);
            registerListener(this.u1);
            registerListener(this.v1);
            registerListener(this.r1);
            registerListener(this.mFirstFloorPraiseListener);
            registerListener(this.Q1);
            registerListener(this.Y1);
            registerListener(this.q1);
            c.a.r0.j3.i0.f fVar = new c.a.r0.j3.i0.f("pb", c.a.r0.j3.i0.f.f20855d);
            this.O0 = fVar;
            fVar.d();
            registerListener(this.A1);
            registerListener(this.J1);
            this.v0.I1();
            registerListener(this.X1);
            registerListener(this.R1);
            registerListener(this.T1);
            registerListener(this.E1);
            c.a.r0.j2.k.e.s0 s0Var4 = this.C0;
            if (s0Var4 != null && s0Var4.Z0() != null && this.C0.X0() != null) {
                c.a.r0.j2.k.e.c1.b bVar = new c.a.r0.j2.k.e.c1.b(getActivity(), this.C0.Z0(), this.C0.X0(), this.C0.N0());
                this.f55090i = bVar;
                bVar.t(this.I1);
            }
            if (this.f55088g && (s0Var = this.C0) != null && s0Var.X0() != null) {
                this.C0.X0().setVisibility(8);
            }
            c.a.q0.s.f0.c cVar = new c.a.q0.s.f0.c();
            this.c1 = cVar;
            cVar.f13812a = 1000L;
            registerListener(this.P1);
            registerListener(this.N1);
            registerListener(this.O1);
            registerListener(this.C1);
            registerListener(this.x1);
            registerListener(this.y1);
            this.B1.setSelfListener(true);
            this.B1.setTag(this.f55086e.getUniqueId());
            this.B1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.B1);
            registerResponsedEventListener(TipEvent.class, this.K1);
            this.d1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.d1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.d1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.v0.l0().A(this.L1);
            this.mContentProcessController = new c.a.r0.j2.k.e.u0();
            if (this.Q0.w() != null) {
                this.mContentProcessController.m(this.Q0.w().i());
            }
            this.Q0.f0(this.X0);
            this.B0 = new ShareSuccessReplyToServerModel();
            addBackInterceptor(this.o1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new b0(this));
            c.a.r0.j2.k.f.a aVar = new c.a.r0.j2.k.f.a(getContext());
            this.w0 = aVar;
            aVar.b(getUniqueId());
            c.a.r0.i3.c.g().i(getUniqueId());
            c.a.q0.s.o.a.b().l("3", "");
            this.n1 = new c.a.r0.z.a(getPageContext());
            this.s0 = new c.a.r0.j2.k.e.e1.a(this, getUniqueId(), this.C0, this.v0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && c.a.e.e.p.j.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.u = System.currentTimeMillis() - this.t;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048716, this, layoutInflater, viewGroup, bundle)) == null) {
            this.C0 = new c.a.r0.j2.k.e.s0(this, this.mCommonOnClickListener, this.M1);
            c.a.r0.j0.b bVar = new c.a.r0.j0.b(getActivity());
            this.f55089h = bVar;
            bVar.i(y2);
            this.f55089h.d(this.r2);
            this.C0.L2(this.a2);
            this.C0.K2(this.f2);
            this.C0.E2(this.d2);
            this.C0.C2(c.a.q0.s.k.c().g());
            this.C0.I2(this.h2);
            this.C0.O2(this.n2);
            this.C0.M2(this.o2);
            this.C0.J2(this.q2);
            this.C0.H2(this.c2);
            this.C0.H3(this.mIsLogin);
            if (this.f55086e.getIntent() != null) {
                this.C0.A2(this.f55086e.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.C0.O0().setFromForumId(this.v0.getFromForumId());
            this.C0.t2(this.Q0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.Q0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.Q0.m0(this.C0.S0());
            }
            this.C0.w2(new e0(this));
            this.C0.z2(this.v0.y0());
            this.C0.N2(this.v0.O0());
            this.s0.f(this.C0, this.v0);
            return this.C0.b1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        c.a.r0.j2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            c.a.r0.i3.c.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.v0.P0().n());
                statisticItem.param("tid", this.v0.f1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.x && this.C0 != null) {
                this.x = true;
                u3(false, null);
            }
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.v0.destory();
                if (this.v0.L0() != null) {
                    this.v0.L0().d();
                }
            }
            c.a.q0.x.w.e eVar = this.Q0;
            if (eVar != null) {
                eVar.K();
            }
            ForumManageModel forumManageModel = this.y0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.U;
            if (likeModel != null) {
                likeModel.I();
            }
            c.a.r0.j2.k.e.s0 s0Var = this.C0;
            if (s0Var != null) {
                s0Var.O1();
                c.a.r0.j2.k.e.g1.c cVar2 = this.C0.f20240h;
                if (cVar2 != null) {
                    cVar2.x();
                }
            }
            c.a.q0.q0.b bVar = this.y;
            if (bVar != null) {
                bVar.c();
            }
            c.a.r0.j2.k.e.c1.b bVar2 = this.f55090i;
            if (bVar2 != null) {
                bVar2.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            c.a.r0.j2.k.e.s0 s0Var2 = this.C0;
            if (s0Var2 != null) {
                s0Var2.e0();
            }
            MessageManager.getInstance().unRegisterListener(this.N1);
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.d1);
            MessageManager.getInstance().unRegisterListener(this.mFirstFloorPraiseListener);
            MessageManager.getInstance().unRegisterListener(this.Q1);
            MessageManager.getInstance().unRegisterListener(this.R1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.V1);
            MessageManager.getInstance().unRegisterListener(this.B1);
            MessageManager.getInstance().unRegisterListener(this.E1);
            MessageManager.getInstance().unRegisterListener(this.y1);
            this.b1 = null;
            this.c1 = null;
            c.a.r0.y2.j0.a.e().g();
            if (this.e1 != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.e1);
            }
            c.a.r0.j2.k.e.b1.f.a aVar = this.T;
            if (aVar != null) {
                aVar.f();
            }
            c.a.r0.j2.k.e.s0 s0Var3 = this.C0;
            if (s0Var3 != null && (cVar = s0Var3.f20240h) != null) {
                cVar.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.B0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            c.a.r0.j2.k.e.u0 u0Var = this.mContentProcessController;
            if (u0Var != null) {
                u0Var.j();
            }
            PbModel pbModel2 = this.v0;
            if (pbModel2 != null && pbModel2.e0() != null) {
                this.v0.e0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.mReplyPrivacyController;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            c.a.r0.j2.k.e.s0 s0Var4 = this.C0;
            if (s0Var4 != null) {
                s0Var4.E3();
            }
            c.a.r0.j2.k.e.e1.a aVar2 = this.s0;
            if (aVar2 != null) {
                aVar2.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.sortSwitchId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.e.l.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (c.a.e.l.e.q) invokeV.objValue;
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        c.a.r0.j2.k.e.s0 s0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048720, this, i3, keyEvent)) == null) ? (keyEvent == null || (s0Var = this.C0) == null || !s0Var.Q1(i3)) ? false : true : invokeIL.booleanValue;
    }

    @Override // c.a.q0.f1.m.g
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048721, this, context, str) == null) {
            this.A = true;
        }
    }

    @Override // c.a.q0.f1.m.g
    public void onLinkClicked(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048722, this, context, str, z3) == null) {
            if (c.a.r0.j2.k.e.x0.c(str) && (pbModel = this.v0) != null && pbModel.f1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.v0.f1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    c.a.q0.u.l lVar = new c.a.q0.u.l();
                    lVar.f15049a = str;
                    lVar.f15050b = 3;
                    lVar.f15051c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, lVar));
                }
            } else {
                c.a.r0.j2.k.e.x0.a().e(getPageContext(), str);
            }
            this.A = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            r3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
                this.k = false;
            } else {
                this.k = true;
            }
            super.onPause();
            BdTypeListView listView = getListView();
            int viewLayer = CompatibleUtile.getInstance().getViewLayer(listView);
            this.p = viewLayer;
            if (viewLayer == 1) {
                CompatibleUtile.getInstance().noneViewGpu(listView);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            c.a.r0.j2.k.e.s0 s0Var = this.C0;
            if (s0Var != null) {
                s0Var.T1();
            }
            if (!this.v0.D0()) {
                this.Q0.W(this.v0.f1());
            }
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                pbModel.H1();
            }
            c.a.q0.a.d.y().E();
            MessageManager.getInstance().unRegisterListener(this.w1);
            t3();
            MessageManager.getInstance().unRegisterListener(this.N1);
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
        }
    }

    @Override // c.a.q0.f1.m.g
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048725, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.I0 = str;
        if (this.q == null) {
            a3();
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

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.e.a.i
    public void onPreLoad(c.a.e.l.e.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            this.k = false;
            super.onResume();
            if (this.R) {
                this.R = false;
                goInterviewLivePage();
            }
            if (b3()) {
                this.z = System.currentTimeMillis();
            } else {
                this.z = -1L;
            }
            c.a.r0.j2.k.e.s0 s0Var = this.C0;
            if (s0Var != null && s0Var.b1() != null) {
                if (!this.l) {
                    L3();
                } else {
                    hideLoadingView(this.C0.b1());
                }
                this.C0.U1();
            }
            if (this.p == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            c.a.r0.j2.k.e.s0 s0Var2 = this.C0;
            NoNetworkView a4 = s0Var2 != null ? s0Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && c.a.e.e.p.j.z()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.w1);
            this.K0 = false;
            v3();
            registerListener(this.N1);
            registerListener(this.O1);
            registerListener(this.P1);
            if (this.j1) {
                r3();
                this.j1 = false;
            }
            Q3();
            ItemCardHelper.u(this.p2);
            DownloadData downloadData = new DownloadData();
            downloadData.setStatus(10);
            c.a.q0.w.c.q().w(downloadData);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.v0.W1(bundle);
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.Q0.M(bundle);
        }
    }

    @Override // c.a.q0.f1.m.g
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048729, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            super.onStop();
            if (this.z > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.z;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.z = 0L;
            }
            if (getPbView().P0() != null) {
                getPbView().P0().i();
            }
            c.a.r0.j2.k.e.g1.c cVar = this.C0.f20240h;
            if (cVar != null && !cVar.t()) {
                this.C0.f20240h.x();
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.P0() != null && this.v0.P0().m() != null && this.v0.P0().O() != null) {
                c.a.q0.v.a.k().y(getPageContext().getPageActivity(), "pb", this.v0.P0().m().getId(), c.a.e.e.m.b.g(this.v0.P0().O().f0(), 0L));
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            c.a.r0.i3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048732, this, view, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048733, this, z3) == null) {
            super.onUserChanged(z3);
            this.C0.H3(z3);
            PopupDialog popupDialog = this.G0;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            if (z3 && this.K0) {
                this.C0.T2();
                this.v0.z1(true);
            }
        }
    }

    @Override // c.a.q0.f1.m.g
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048734, this, context, str) == null) {
            c.a.r0.j2.k.e.x0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.A = true;
        }
    }

    @Override // c.a.q0.f1.m.g
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048735, this, context, str) == null) {
        }
    }

    public void openMore() {
        PbModel pbModel;
        c.a.r0.j2.h.e P0;
        c.a.q0.s.q.d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (pbModel = this.v0) == null || pbModel.P0() == null || (O = (P0 = this.v0.P0()).O()) == null || O.J() == null) {
            return;
        }
        this.C0.f1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.J().getUserId());
        c.a.r0.j2.k.e.e0 e0Var = new c.a.r0.j2.k.e.e0();
        int V = this.v0.P0().V();
        if (V != 1 && V != 3) {
            e0Var.f20057g = false;
        } else {
            e0Var.f20057g = true;
            e0Var.s = O.r0() == 1;
        }
        if (isMakeGoodsShowing(V)) {
            e0Var.f20058h = true;
            e0Var.r = O.q0() == 1;
        } else {
            e0Var.f20058h = false;
        }
        if (V == 1002 && !equals) {
            e0Var.u = true;
        }
        e0Var.n = G3(O.S1(), P0.h0(), equals, V, O.I2(), O.s2());
        e0Var.f20055e = E3(equals, P0.h0());
        e0Var.f20059i = H3();
        e0Var.f20056f = F3(equals);
        e0Var.k = equals && P0.U() != null && P0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            e0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().f();
        }
        e0Var.t = equals;
        e0Var.q = this.v0.d1();
        e0Var.f20052b = true;
        e0Var.f20051a = d3(equals);
        if (equals) {
            this.C0.v1();
        }
        e0Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        e0Var.f20060j = true;
        e0Var.o = this.v0.t0();
        e0Var.f20054d = true;
        if (O.q1() == null) {
            e0Var.f20053c = true;
        } else {
            e0Var.f20053c = false;
        }
        if (P0.f0()) {
            e0Var.f20052b = false;
            e0Var.f20054d = false;
            e0Var.f20053c = false;
            e0Var.f20057g = false;
            e0Var.f20058h = false;
        }
        e0Var.v = TbSingleton.getInstance().mShowCallFans && equals && !P0.f0();
        c.a.r0.j2.k.e.s0 s0Var = this.C0;
        if (s0Var != null) {
            PbModel pbModel2 = this.v0;
            PostData x02 = s0Var.x0(pbModel2.J, pbModel2.d1());
            e0Var.w = x02 != null ? x02.S : false;
        }
        e0Var.m = true;
        if (c.a.q0.g1.b.c.d()) {
            e0Var.f20054d = false;
            e0Var.f20052b = false;
            e0Var.f20053c = false;
            e0Var.m = false;
        }
        if (O.S1()) {
            e0Var.n = false;
            e0Var.f20057g = false;
            e0Var.f20058h = false;
        }
        this.C0.f20240h.E(e0Var);
    }

    public final AbsPbActivity.e p3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048737, this, str)) == null) {
            String str2 = null;
            if (this.v0.P0() != null && this.v0.P0().F() != null && this.v0.P0().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.v0.P0().F().size()) {
                        i3 = 0;
                        break;
                    } else if (str.equals(this.v0.P0().F().get(i3).E())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                PostData postData = this.v0.P0().F().get(i3);
                if (postData.K() != null && postData.K().y() != null) {
                    Iterator<TbRichTextData> it = postData.K().y().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.C() != null) {
                                str2 = next.C().y();
                            }
                        }
                    }
                    o3(str2, 0, eVar);
                    c.a.r0.j2.h.f.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public void processProfessionPermission() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048738, this) == null) || !checkUpIsLogin() || (pbModel = this.v0) == null || pbModel.P0() == null || this.v0.P0().m() == null || y2()) {
            return;
        }
        if (this.v0.P0().f0()) {
            this.C0.X();
            return;
        }
        if (this.T0 == null) {
            c.a.r0.w0.g2.a.c cVar = new c.a.r0.w0.g2.a.c(getPageContext());
            this.T0 = cVar;
            cVar.j(0);
            this.T0.i(new s0(this));
        }
        this.T0.g(this.v0.P0().m().getId(), c.a.e.e.m.b.g(this.v0.f1(), 0L));
    }

    public final void q3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048739, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.f55087f ? 2 : 3));
        view.setTag(sparseArray);
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            hideNetRefreshView(this.C0.b1());
            L3();
            if (this.v0.F1()) {
                this.C0.S2();
            }
            this.C0.Z2();
        }
    }

    public void refGodReplyFloor(c.a.r0.j2.h.r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, rVar) == null) {
            String E = rVar.i().E();
            List<PostData> list = this.v0.P0().T().f19694a;
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
                    postData.w0(rVar.m());
                    if (postData.M() != null) {
                        postData.M().clear();
                        postData.M().addAll(k3);
                    }
                }
            }
            if (this.v0.z0()) {
                return;
            }
            this.C0.u1(this.v0.P0());
        }
    }

    public void refreshMark(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048742, this, z3, markData) == null) {
            this.C0.R2();
            this.v0.o2(z3);
            c.a.q0.i.a aVar = this.x0;
            if (aVar != null) {
                aVar.h(z3);
                if (markData != null) {
                    this.x0.i(markData);
                }
            }
            if (this.v0.B0()) {
                j3();
            } else {
                this.C0.u1(this.v0.P0());
            }
        }
    }

    public void refreshWrite(c.a.r0.j2.h.r rVar) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048743, this, rVar) == null) || rVar.i() == null) {
            return;
        }
        String E = rVar.i().E();
        ArrayList<PostData> F = this.v0.P0().F();
        int i3 = 0;
        while (true) {
            if (i3 >= F.size()) {
                break;
            }
            PostData postData = F.get(i3);
            if (postData.E() == null || !postData.E().equals(E)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = rVar.k();
                postData.w0(rVar.m());
                if (postData.M() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.T() != null && next != null && next.t() != null && (metaData = postData.T().get(next.t().getUserId())) != null) {
                            next.i0(metaData);
                            next.q0(true);
                            next.B0(getPageContext(), this.v0.x1(metaData.getUserId()));
                        }
                    }
                    z3 = k3.size() != postData.M().size();
                    if (!postData.X(false)) {
                        postData.M().clear();
                        postData.M().addAll(k3);
                    }
                }
                if (postData.x() != null) {
                    postData.g0();
                }
            }
        }
        if (!this.v0.z0() && z3) {
            this.C0.u1(this.v0.P0());
        }
        if (z3) {
            refGodReplyFloor(rVar);
        }
    }

    public void removeBackInterceptor(y2 y2Var) {
        List<y2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048744, this, y2Var) == null) || y2Var == null || (list = this.m1) == null) {
            return;
        }
        list.remove(y2Var);
    }

    @Override // c.a.r0.j2.p.f.b
    public void resetLoadMoreFlag(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048745, this, z3) == null) {
            this.K0 = z3;
        }
    }

    public final boolean richTextHandleSingleTap(View view) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048746, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.x0 && !TextUtils.isEmpty(postData.u()) && c.a.q0.s.k.c().g()) {
                        return m3(postData.E());
                    }
                    if (checkUpIsLogin() && (pbModel = this.v0) != null && pbModel.P0() != null) {
                        if (getPbView().P0() != null) {
                            getPbView().P0().c();
                        }
                        c.a.r0.j2.h.r rVar = new c.a.r0.j2.h.r();
                        rVar.A(this.v0.P0().m());
                        rVar.E(this.v0.P0().O());
                        rVar.C(postData);
                        getPbView().O0().S(rVar);
                        getPbView().O0().setPostId(postData.E());
                        i3(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        c.a.q0.x.w.e eVar = this.Q0;
                        if (eVar != null) {
                            this.C0.x2(eVar.E());
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void s3(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048747, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.T == null) {
            c.a.r0.j2.k.e.b1.f.a aVar = new c.a.r0.j2.k.e.b1.f.a(this.f55086e);
            this.T = aVar;
            aVar.n(this.W0);
            this.T.m(this.U1);
        }
        this.T.k(emotionImageData, getPbModel(), getPbModel().P0());
    }

    public void setNavigationBarShowFlag(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048748, this, z3) == null) {
            this.Q = z3;
        }
    }

    public void setShowLinkGoodsMore(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z3) == null) {
            this.N = z3;
        }
    }

    public final void stopVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            AbsPbActivity absPbActivity = this.f55086e;
            if (absPbActivity != null) {
                absPbActivity.stopVoice();
            }
        }
    }

    public final void t3() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || (pbModel = this.v0) == null || pbModel.P0() == null || this.v0.P0().O() == null || !this.v0.P0().O().E2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public final void u3(boolean z3, PostData postData) {
        c.a.q0.t.c.d adAdSense;
        c.a.r0.j2.k.e.s0 s0Var;
        c.a.r0.j2.k.e.h p02;
        ArrayList<PostData> E;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048752, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g() || (s0Var = this.C0) == null || (p02 = s0Var.p0()) == null || (E = p02.E()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        Iterator<PostData> it = E.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PostData next = it.next();
            String E2 = next.E();
            i3++;
            if (z3) {
                if (next == postData) {
                    a.c cVar = new a.c();
                    cVar.f20931b = E2;
                    cVar.f20932c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.E == 1 && !TextUtils.isEmpty(E2)) {
                next.E = 2;
                a.c cVar2 = new a.c();
                cVar2.f20931b = E2;
                cVar2.f20932c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.P0() == null || this.v0.P0().m() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.v0.P0().m().getFirst_class();
                str2 = this.v0.P0().m().getSecond_class();
                str3 = this.v0.P0().m().getId();
                str4 = this.v0.f1();
                str = first_class;
            }
            c.a.r0.y2.z.v(z3, str, str2, str3, str4, arrayList, adAdSense.i());
        }
    }

    public final void v2() {
        PbModel pbModel;
        c.a.r0.j2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048753, this) == null) || (pbModel = this.v0) == null || (eVar = pbModel.J) == null || eVar.O() == null) {
            return;
        }
        c.a.q0.s.q.d2 O = this.v0.J.O();
        O.Z0 = this.v0.U0();
        O.Y0 = this.v0.X0();
        O.X0 = this.v0.W0();
        O.a1 = this.v0.V0();
        O.H2 = this.v0.D0();
        if (O.T() == 0) {
            O.D3(c.a.e.e.m.b.g(this.v0.getForumId(), 0L));
        }
        StatisticItem i3 = c.a.q0.n0.c.i(getContext(), O, "c13562");
        TbPageTag l3 = c.a.q0.n0.c.l(getContext());
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

    public final void v3() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048754, this) == null) || (pbModel = this.v0) == null || pbModel.P0() == null || this.v0.P0().O() == null || !this.v0.P0().O().E2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public final void w2(boolean z3) {
        PbModel pbModel;
        c.a.r0.j2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048755, this, z3) == null) || (pbModel = this.v0) == null || (eVar = pbModel.J) == null || eVar.O() == null) {
            return;
        }
        c.a.q0.s.q.d2 O = this.v0.J.O();
        O.Z0 = this.v0.U0();
        O.Y0 = this.v0.X0();
        O.X0 = this.v0.W0();
        O.a1 = this.v0.V0();
        if (O.T() == 0) {
            O.D3(c.a.e.e.m.b.g(this.v0.getForumId(), 0L));
        }
        StatisticItem i3 = c.a.q0.n0.c.i(getContext(), O, "c13563");
        TbPageTag l3 = c.a.q0.n0.c.l(getContext());
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
            c.a.q0.m0.c k3 = TbPageExtraHelper.k(getContext());
            if (k3 != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, k3.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i3);
        }
    }

    public final void w3(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048756, this, i3) == null) || this.v0 == null) {
            return;
        }
        L3();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
        privacySettingMessage.setTid(this.v0.f55294f);
        sendMessage(privacySettingMessage);
    }

    public final void x2(c.a.r0.j2.h.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048757, this, eVar, arrayList) == null) || eVar == null || eVar.T() == null || eVar.T().f19694a == null || (list = eVar.T().f19694a) == null || arrayList == null) {
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

    public final void x3(c.a.q0.x.w.g gVar) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048758, this, gVar) == null) || gVar == null || (pbModel = this.v0) == null) {
            return;
        }
        gVar.p(pbModel.q0());
        if (this.v0.P0() != null && this.v0.P0().m() != null) {
            gVar.o(this.v0.P0().m());
        }
        gVar.q("pb");
        gVar.r(this.v0);
    }

    public final boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.P0() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.v0.P0().O()) || AntiHelper.d(getPageContext(), this.v0.P0().d());
        }
        return invokeV.booleanValue;
    }

    public final void y3(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048760, this, i3) == null) || (pbModel = this.v0) == null) {
            return;
        }
        int Y0 = pbModel.Y0();
        if (i3 == 5) {
            this.v0.k2(2);
        } else if (i3 == 6) {
            this.v0.k2(3);
        } else if (i3 != 7) {
            this.v0.k2(1);
        } else {
            this.v0.k2(4);
        }
        int Y02 = this.v0.Y0();
        if (Y0 == 4 || Y02 == 4) {
            n3();
        }
    }

    public final boolean z2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048761, this, i3)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void z3(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048762, this, z3) == null) {
            this.Q0.h0(z3);
            this.Q0.k0(z3);
            this.Q0.r0(z3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.f1.m.g
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            c.a.r0.j2.k.e.s0 s0Var = this.C0;
            if (s0Var == null) {
                return null;
            }
            return s0Var.G0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void deleteThread(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(c.a.r0.j2.k.e.s0.W1)).intValue();
            if (intValue == c.a.r0.j2.k.e.s0.X1) {
                if (this.y0.P()) {
                    return;
                }
                this.C0.D3();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.tag_is_block_thread) != null ? ((Boolean) sparseArray.get(R.id.tag_is_block_thread)).booleanValue() : false;
                if (jSONArray != null) {
                    this.y0.R(StringHelper.JsonArrayToString(jSONArray));
                }
                this.y0.S(this.v0.P0().m().getId(), this.v0.P0().m().getName(), this.v0.P0().O().f0(), str, intValue3, intValue2, booleanValue, this.v0.P0().O().L(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == c.a.r0.j2.k.e.s0.Y1 || intValue == c.a.r0.j2.k.e.s0.a2) {
                if (this.v0.m0() != null) {
                    this.v0.m0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == c.a.r0.j2.k.e.s0.Y1) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }
}
