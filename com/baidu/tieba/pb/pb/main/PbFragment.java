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
import c.a.q0.f1.m.f;
import c.a.q0.i.a;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.d1;
import c.a.q0.s.s.a;
import c.a.q0.s.s.b;
import c.a.q0.s.s.i;
import c.a.r0.k0.a;
import c.a.r0.k0.b;
import c.a.r0.k2.i.c;
import c.a.r0.k2.k.e.c0;
import c.a.r0.k2.k.e.c1.b;
import c.a.r0.k2.k.e.p;
import c.a.r0.k2.p.f;
import c.a.r0.k3.k0.a;
import c.a.r0.x0.g2.a.c;
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
import com.baidu.tbadk.core.view.ItemCardView;
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
public class PbFragment extends BaseFragment implements c.a.q0.f1.m.i, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a.e, TbRichTextView.t, TbPageContextSupport, c.a.r0.k2.o.b, f.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final b.InterfaceC0945b A2;
    public static final int CHECK_MUTE_FROM_DIALOG = 2;

    /* renamed from: CHECK_MUTE_FROM＿FLOOR  reason: contains not printable characters */
    public static final int f3CHECK_MUTE_FROMFLOOR = 1;
    public static final String GOD_CALL_URL = "http://tieba.baidu.com/mo/q/god/call/?";
    public static final String PHONE = "2";
    public static final int UPDATE_TYPE_DELETE = 1;
    public static final int UPDATE_TYPE_MARK = 2;
    public static final int UPDATE_TYPE_WRITE = 0;
    public static final AntiHelper.k z2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public c.a.q0.t.e.a A0;
    public View.OnClickListener A1;
    public long B;
    public c.a.r0.k2.h.t B0;
    public CustomMessageListener B1;
    public int C;
    public ShareSuccessReplyToServerModel C0;
    public CustomMessageListener C1;
    public String D;
    public c.a.r0.k2.k.e.s0 D0;
    public CustomMessageListener D1;
    public c.a.e.e.k.b<TextView> E;
    public boolean E0;
    public SuggestEmotionModel.c E1;
    public c.a.e.e.k.b<TbImageView> F;
    public boolean F0;
    public CustomMessageListener F1;
    public c.a.e.e.k.b<ImageView> G;
    public boolean G0;
    public GetSugMatchWordsModel.b G1;
    public c.a.e.e.k.b<View> H;
    public PopupDialog H0;
    public boolean H1;
    public c.a.e.e.k.b<TiebaPlusRecommendCard> I;
    public c.a.q0.s.s.i I0;
    public PraiseModel I1;
    public c.a.e.e.k.b<LinearLayout> J;
    public String J0;
    public b.h J1;
    public c.a.e.e.k.b<RelativeLayout> K;
    public boolean K0;
    public CustomMessageListener K1;
    public c.a.e.e.k.b<ItemCardView> L;
    public boolean L0;
    public c.a.q0.j0.i L1;
    public boolean M;
    public boolean M0;
    public CheckRealNameModel.b M1;
    public boolean N;
    public String N0;
    public c.a.r0.k2.i.c N1;
    public boolean O;
    public boolean O0;
    public CustomMessageListener O1;
    public c.a.e.e.k.b<GifView> P;
    public c.a.r0.k3.i0.f P0;
    public CustomMessageListener P1;
    public String Q;
    public c.a.q0.x.x.g Q0;
    public CustomMessageListener Q1;
    public boolean R;
    public c.a.q0.x.x.e R0;
    public CustomMessageListener R1;
    public boolean S;
    public boolean S0;
    public CustomMessageListener S1;
    public String T;
    public PermissionJudgePolicy T0;
    public CustomMessageListener T1;
    public c.a.r0.k2.k.e.b1.f.a U;
    public c.a.r0.x0.g2.a.c U0;
    public i.e U1;
    public LikeModel V;
    public c.a.r0.x0.g2.a.c V0;
    public CustomMessageListener V1;
    public View W;
    public EmotionImageData W0;
    public final NewWriteModel.g W1;
    public View X;
    public c.a.q0.x.x.c X0;
    public c.a.e.c.g.a X1;
    public View Y;
    public c.a.q0.x.x.b Y0;
    public final PbModel.g Y1;
    public View Z;
    public c.a.q0.x.x.b Z0;
    public CustomMessageListener Z1;
    public String a0;
    public int a1;
    public HttpMessageListener a2;
    public int b0;
    public Object b1;
    public final a.InterfaceC0669a b2;
    public int bjhFrom;
    public boolean c0;
    public c.a.e.a.f c1;
    public final AbsListView.OnScrollListener c2;
    public c.a.q0.s.f0.c d1;
    public final c.a.e.a.e d2;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f55017e;
    public BdUniqueId e1;
    public final c3 e2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55018f;
    public Runnable f1;
    public final f.g f2;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55019g;
    public c.a.r0.k2.k.e.w0 g1;
    public boolean g2;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.k0.b f55020h;
    public c.a.e.l.d.a h1;
    public final BdListView.p h2;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.k2.k.e.c1.b f55021i;
    public int[] i0;
    public String i1;
    public int i2;

    /* renamed from: j  reason: collision with root package name */
    public boolean f55022j;
    public int j0;
    public TbRichTextMemeInfo j1;
    public final TbRichTextView.z j2;
    public boolean k;
    public int k0;
    public boolean k1;
    public boolean k2;
    public boolean l;
    public int l0;
    public int l1;
    public PostData l2;
    public String lastTid;
    public boolean m;
    public c.a.q0.s.q.n1 m0;
    public int m1;
    public final b.c m2;
    public final View.OnClickListener mCommonOnClickListener;
    public c.a.r0.k2.k.e.u0 mContentProcessController;
    public a.e mDialogClickListener;
    public CustomMessageListener mFirstFloorPraiseListener;
    public boolean mKeyboardIsVisible;
    public NewWriteModel.g mOnFloorPostWriteNewCallback;
    public View.OnTouchListener mOnTouchListener;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public boolean n;
    public c.a.q0.s.b0.a n0;
    public List<a3> n1;
    public final b.c n2;
    public VoiceManager o;
    public boolean o0;
    public c.a.r0.a0.a o1;
    public final AdapterView.OnItemClickListener o2;
    public SortSwitchButton.f onSwitchChangeListener;
    public int p;
    public boolean p0;
    public final a3 p1;
    public final View.OnLongClickListener p2;
    public c.a.q0.s.s.b q;
    public c.a.r0.k3.i0.e q0;
    public final c0.b q1;
    public final View.OnClickListener q2;
    public long r;
    public boolean r0;
    public final CustomMessageListener r1;
    public final ItemCardHelper.c r2;
    public long s;
    @NonNull
    public TiePlusEventController.d s0;
    public CustomMessageListener s1;
    public final NoNetworkView.b s2;
    public BdUniqueId sortSwitchId;
    public long t;
    public c.a.r0.k2.k.e.e1.a t0;
    public CustomMessageListener t1;
    public a.b t2;
    public long u;
    public PbInterviewStatusView.f u0;
    public CustomMessageListener u1;
    public final p.b u2;
    public long v;
    public final Handler v0;
    public CustomMessageListener v1;
    public int v2;
    public boolean w;
    public PbModel w0;
    public CustomMessageListener w1;
    public int w2;
    public boolean x;
    public c.a.r0.k2.k.f.a x0;
    public CustomMessageListener x1;
    public String x2;
    public c.a.q0.q0.b y;
    public c.a.q0.i.a y0;
    public final CustomMessageListener y1;
    public c.a.q0.s.q.u y2;
    public long z;
    public ForumManageModel z0;
    public CustomMessageListener z1;

    /* loaded from: classes7.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55023e;

        public a(PbFragment pbFragment) {
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
            this.f55023e = pbFragment;
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
    public class a0 implements PbInterviewStatusView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55024a;

        public a0(PbFragment pbFragment) {
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
            this.f55024a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f55024a.D0.z3(!this.f55024a.R);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55025e;

        /* loaded from: classes7.dex */
        public class a implements i.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PopupDialog f55026e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ View f55027f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a1 f55028g;

            public a(a1 a1Var, PopupDialog popupDialog, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a1Var, popupDialog, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55028g = a1Var;
                this.f55026e = popupDialog;
                this.f55027f = view;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.f55028g.f55025e.w0.c1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // c.a.q0.s.s.i.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
                boolean t2;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, iVar, i2, view) != null) {
                    return;
                }
                this.f55026e.dismiss();
                int i3 = 3;
                if (this.f55028g.f55025e.w0.c1() != 1 || i2 != 1) {
                    if (this.f55028g.f55025e.w0.c1() == 2 && i2 == 0) {
                        i3 = 1;
                    } else if (this.f55028g.f55025e.w0.c1() == 3 && i2 != 2) {
                        i3 = 2;
                    } else if (i2 == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f55027f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                    if (this.f55028g.f55025e.w0.P0().f19808f != null && this.f55028g.f55025e.w0.P0().f19808f.size() > i2) {
                        i2 = this.f55028g.f55025e.w0.P0().f19808f.get(i2).sort_type.intValue();
                    }
                    t2 = this.f55028g.f55025e.w0.t2(i2);
                    this.f55027f.setTag(Integer.valueOf(this.f55028g.f55025e.w0.b1()));
                    if (t2) {
                        return;
                    }
                    this.f55028g.f55025e.m = true;
                    this.f55028g.f55025e.D0.G2(true);
                    return;
                }
                i3 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f55027f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f55028g.f55025e.w0.P0().f19808f != null) {
                    i2 = this.f55028g.f55025e.w0.P0().f19808f.get(i2).sort_type.intValue();
                }
                t2 = this.f55028g.f55025e.w0.t2(i2);
                this.f55027f.setTag(Integer.valueOf(this.f55028g.f55025e.w0.b1()));
                if (t2) {
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
            this.f55025e = pbFragment;
        }

        /* JADX WARN: Code restructure failed: missing block: B:884:0x1ff0, code lost:
            if (r39.f55025e.D0.R0.f20473c.getView().getTop() <= ((r39.f55025e.D0.Q0() == null || r39.f55025e.D0.Q0().c() == null) ? 0 : r39.f55025e.D0.Q0().c().getBottom())) goto L833;
         */
        /* JADX WARN: Code restructure failed: missing block: B:885:0x1ff2, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:887:0x1fff, code lost:
            if (r0 >= c.a.r0.k2.k.e.a1.k.c(r39.f55025e.getListView())) goto L833;
         */
        /* JADX WARN: Code restructure failed: missing block: B:909:0x20a6, code lost:
            if ((r39.f55025e.D0.R0.f20473c.getView().getTop() - r39.f55025e.D0.f20417h.f20288a.getBottom()) < (r39.f55025e.D0.R0.f20473c.mDivideLineTop.getHeight() + 10)) goto L833;
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
            c.a.r0.k2.h.e P0;
            int i5;
            int i6;
            boolean s2;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f55025e.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == this.f55025e.D0.K0()) {
                        if (this.f55025e.m) {
                            return;
                        }
                        if (this.f55025e.w0.A1(true)) {
                            this.f55025e.m = true;
                            this.f55025e.D0.T2();
                        }
                    } else if (view != this.f55025e.D0.f20417h.m()) {
                        if (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().k()) {
                            if (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().d()) {
                                if (view == this.f55025e.D0.f20417h.f20293f) {
                                    if (this.f55025e.D0.U(this.f55025e.w0.D0())) {
                                        this.f55025e.stopVoice();
                                        return;
                                    }
                                    this.f55025e.n = false;
                                    this.f55025e.f55022j = false;
                                    c.a.e.e.p.l.x(this.f55025e.f55017e, this.f55025e.D0.f20417h.f20293f);
                                    this.f55025e.f55017e.finish();
                                } else if (view != this.f55025e.D0.r0() && (this.f55025e.D0.f20417h.n() == null || (view != this.f55025e.D0.f20417h.n().l() && view != this.f55025e.D0.f20417h.n().m()))) {
                                    if (view == this.f55025e.D0.z0()) {
                                        if (this.f55025e.w0 != null) {
                                            c.a.q0.m.a.l(this.f55025e.getPageContext().getPageActivity(), this.f55025e.w0.P0().O().w1().b());
                                        }
                                    } else if (view != this.f55025e.D0.f20417h.f20290c) {
                                        if (view == this.f55025e.D0.f20417h.f20291d) {
                                            if (c.a.q0.d1.o.a()) {
                                                return;
                                            }
                                            if (this.f55025e.w0 != null && this.f55025e.w0.P0() != null) {
                                                ArrayList<PostData> F = this.f55025e.w0.P0().F();
                                                if ((F == null || F.size() <= 0) && this.f55025e.w0.d1()) {
                                                    c.a.e.e.p.l.M(this.f55025e.getPageContext().getPageActivity(), this.f55025e.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f55025e.w0.f1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f55025e.w0.getForumId()));
                                                if (!this.f55025e.D0.G1()) {
                                                    this.f55025e.D0.q2();
                                                }
                                                this.f55025e.openMore();
                                            } else {
                                                c.a.e.e.p.l.M(this.f55025e.getPageContext().getPageActivity(), this.f55025e.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                        } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                            if (c.a.e.e.p.j.z()) {
                                                this.f55025e.D0.D2(true);
                                                this.f55025e.D0.q2();
                                                if (this.f55025e.m) {
                                                    return;
                                                }
                                                this.f55025e.m = true;
                                                this.f55025e.D0.w3();
                                                this.f55025e.stopVoice();
                                                this.f55025e.D0.S2();
                                                this.f55025e.w0.r2(this.f55025e.N2());
                                                TiebaStatic.eventStat(this.f55025e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.f55025e.showToast(R.string.network_not_available);
                                                return;
                                            }
                                        } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                            if ((this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().i()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                                if (this.f55025e.D0.f20417h.n() != null && view == this.f55025e.D0.f20417h.n().e()) {
                                                    this.f55025e.D0.f20417h.k();
                                                } else if (view.getId() == R.id.share_num_container) {
                                                    if (!this.f55025e.C2(11009)) {
                                                        return;
                                                    }
                                                    this.f55025e.a3(3);
                                                } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                    if (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().j()) {
                                                        if (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().q()) {
                                                            if (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().p()) {
                                                                if (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().n()) {
                                                                    if (this.f55025e.D0.D0() == view) {
                                                                        if (this.f55025e.D0.D0().getIndicateStatus()) {
                                                                            c.a.r0.k2.h.e P02 = this.f55025e.w0.P0();
                                                                            if (P02 != null && P02.O() != null && P02.O().j1() != null) {
                                                                                String d3 = P02.O().j1().d();
                                                                                if (StringUtils.isNull(d3)) {
                                                                                    d3 = P02.O().j1().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d3));
                                                                            }
                                                                        } else {
                                                                            c.a.r0.k3.k0.a.d("c10725", null);
                                                                        }
                                                                        this.f55025e.goInterviewLivePage();
                                                                    } else if (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().g()) {
                                                                        if (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().c()) {
                                                                            if (this.f55025e.D0.f20417h.n() != null && view == this.f55025e.D0.f20417h.n().f()) {
                                                                                if (c.a.e.e.p.j.z()) {
                                                                                    SparseArray<Object> H0 = this.f55025e.D0.H0(this.f55025e.w0.P0(), this.f55025e.w0.d1(), 1);
                                                                                    if (H0 != null) {
                                                                                        if (StringUtils.isNull((String) H0.get(R.id.tag_del_multi_forum))) {
                                                                                            this.f55025e.D0.Y1(((Integer) H0.get(R.id.tag_del_post_type)).intValue(), (String) H0.get(R.id.tag_del_post_id), ((Integer) H0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) H0.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                        } else {
                                                                                            this.f55025e.D0.Z1(((Integer) H0.get(R.id.tag_del_post_type)).intValue(), (String) H0.get(R.id.tag_del_post_id), ((Integer) H0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) H0.get(R.id.tag_del_post_is_self)).booleanValue(), (String) H0.get(R.id.tag_del_multi_forum));
                                                                                        }
                                                                                    }
                                                                                    this.f55025e.D0.f20417h.k();
                                                                                } else {
                                                                                    this.f55025e.showToast(R.string.network_not_available);
                                                                                    return;
                                                                                }
                                                                            } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText) {
                                                                                if (view.getId() == R.id.pb_post_reply_count) {
                                                                                    if (this.f55025e.w0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                                                                                    statisticItem2.param("tid", this.f55025e.w0.f1());
                                                                                    statisticItem2.param("fid", this.f55025e.w0.getForumId());
                                                                                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem2.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem2);
                                                                                    if (view.getId() == R.id.pb_post_reply_count && !DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f55025e.getActivity(), "pb_chakanhuifu"))) {
                                                                                        this.f55025e.X = view;
                                                                                        return;
                                                                                    } else if (!this.f55025e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
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
                                                                                        if (this.f55025e.w0 == null || this.f55025e.w0.P0() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String f1 = this.f55025e.w0.f1();
                                                                                        String E = postData.E();
                                                                                        int V = this.f55025e.w0.P0() != null ? this.f55025e.w0.P0().V() : 0;
                                                                                        AbsPbActivity.e t3 = this.f55025e.t3(E);
                                                                                        if (t3 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f55025e.getPageContext().getPageActivity()).createSubPbActivityConfig(f1, E, "pb", true, false, null, false, null, V, postData.P(), this.f55025e.w0.P0().d(), false, postData.t().getIconInfo(), 5).addBigImageData(t3.f54984a, t3.f54985b, t3.f54990g, t3.f54993j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.f55025e.w0.O0());
                                                                                        addBigImageData.setFromFrsForumId(this.f55025e.w0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.f55025e.w0.k1());
                                                                                        addBigImageData.setKeyFromForumId(this.f55025e.w0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.f55025e.w0.F(), this.f55025e.w0.B(), this.f55025e.w0.C(), this.f55025e.w0.A(), this.f55025e.w0.G());
                                                                                        addBigImageData.setBjhData(this.f55025e.w0.j0());
                                                                                        if (this.f55025e.w0.P0().p() != null) {
                                                                                            addBigImageData.setHasForumRule(this.f55025e.w0.P0().p().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.f55025e.w0.P0().U() != null) {
                                                                                            addBigImageData.setIsManager(this.f55025e.w0.P0().U().getIs_manager());
                                                                                        }
                                                                                        if (this.f55025e.w0.P0().m().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.f55025e.w0.P0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.f55025e.w0.P0().m().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.f55025e.w0.P0().m() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.f55025e.w0.P0().m().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.f55025e.w0.P0().m().getUser_level());
                                                                                        }
                                                                                        if (this.f55025e.D0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.f55025e.D0.x0(this.f55025e.w0.J, this.f55025e.w0.d1()).S || postData.S);
                                                                                        }
                                                                                        this.f55025e.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                    if (this.f55025e.w0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view.getId() == R.id.pb_post_reply) {
                                                                                        StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                                                        statisticItem4.param("tid", this.f55025e.w0.f1());
                                                                                        statisticItem4.param("fid", this.f55025e.w0.getForumId());
                                                                                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem4.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem4);
                                                                                    }
                                                                                    if (view.getId() == R.id.post_info_commont_img) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f55025e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                            this.f55025e.Y = view;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f55025e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                        this.f55025e.Y = view;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.f55025e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
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
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f55025e.w0.g1()).param("fid", this.f55025e.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.f55025e.w0 == null || this.f55025e.w0.P0() == null || this.f55025e.getPbView().O0() == null || postData2.t() == null || postData2.A() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.f55025e.getPbView().P0() != null) {
                                                                                        this.f55025e.getPbView().P0().c();
                                                                                    }
                                                                                    if (this.f55025e.r0 && postData2.M() != null && postData2.M().size() != 0) {
                                                                                        this.f55025e.W3(postData2, true);
                                                                                    } else {
                                                                                        c.a.r0.k2.h.r rVar = new c.a.r0.k2.h.r();
                                                                                        rVar.A(this.f55025e.w0.P0().m());
                                                                                        rVar.E(this.f55025e.w0.P0().O());
                                                                                        rVar.C(postData2);
                                                                                        this.f55025e.getPbView().O0().S(rVar);
                                                                                        this.f55025e.getPbView().O0().setPostId(postData2.E());
                                                                                        this.f55025e.m3(view, postData2.t().getUserId(), "", postData2);
                                                                                        if (this.f55025e.R0 != null) {
                                                                                            this.f55025e.D0.x2(this.f55025e.R0.E());
                                                                                        }
                                                                                    }
                                                                                } else if (view.getId() != R.id.pb_floor_feedback) {
                                                                                    if (view != this.f55025e.D0.B0()) {
                                                                                        if (view == this.f55025e.D0.f20417h.o()) {
                                                                                            this.f55025e.D0.a3();
                                                                                        } else if (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().o()) {
                                                                                            if (this.f55025e.D0.f20417h.n() != null && view == this.f55025e.D0.f20417h.n().h()) {
                                                                                                c.a.q0.t.c.j0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (d2 = tiebaPlusConfigData.d(this.f55025e.w0.f1())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.f55025e.getPageContext(), new String[]{d2});
                                                                                                    this.f55025e.D0.f20417h.k();
                                                                                                    c.a.q0.t.c.j0.a(3);
                                                                                                }
                                                                                            } else {
                                                                                                int id = view.getId();
                                                                                                if (id == R.id.pb_u9_text_view) {
                                                                                                    if (!this.f55025e.checkUpIsLogin() || (i2Var = (c.a.q0.s.q.i2) view.getTag()) == null || StringUtils.isNull(i2Var.E0())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.f55025e.getPageContext().getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.f55025e.getPageContext(), new String[]{i2Var.E0()});
                                                                                                } else if (id != R.id.replybtn && id != R.id.cover_reply_content && id != R.id.replybtn_top_right && id != R.id.cover_reply_content_top_right) {
                                                                                                    if (id == R.id.pb_act_btn) {
                                                                                                        if (this.f55025e.w0.P0() != null && this.f55025e.w0.P0().O() != null && this.f55025e.w0.P0().O().x() != null) {
                                                                                                            c.a.q0.m.a.l(this.f55025e.getActivity(), this.f55025e.w0.P0().O().x());
                                                                                                            if (this.f55025e.w0.P0().O().w() != 1) {
                                                                                                                if (this.f55025e.w0.P0().O().w() == 2) {
                                                                                                                    TiebaStatic.eventStat(this.f55025e.getPageContext().getPageActivity(), "show_picture", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                                }
                                                                                                            } else {
                                                                                                                TiebaStatic.eventStat(this.f55025e.getPageContext().getPageActivity(), "lottery", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == R.id.lottery_tail) {
                                                                                                        if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                            String str = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                                            TiebaStatic.log(new StatisticItem("c10912").param("fid", this.f55025e.w0.P0().n()).param("tid", this.f55025e.w0.P0().Q()).param("lotterytail", StringUtils.string(str, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                            if (this.f55025e.w0.P0().Q().equals(str)) {
                                                                                                                this.f55025e.D0.W2(0);
                                                                                                            } else {
                                                                                                                this.f55025e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f55025e.getActivity()).createNormalCfg(str, (String) null, (String) null, (String) null)));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == R.id.pb_item_tail_content) {
                                                                                                        if (ViewHelper.checkUpIsLogin(this.f55025e.getPageContext().getPageActivity())) {
                                                                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                                            String p = c.a.q0.s.d0.b.j().p("tail_link", "");
                                                                                                            if (!StringUtils.isNull(p)) {
                                                                                                                TiebaStatic.log("c10056");
                                                                                                                c.a.q0.m.a.p(view.getContext(), string, p, true, true, true);
                                                                                                            }
                                                                                                            this.f55025e.D0.q2();
                                                                                                        }
                                                                                                    } else if (id == R.id.join_vote_tv) {
                                                                                                        if (view != null) {
                                                                                                            c.a.q0.m.a.l(this.f55025e.getActivity(), (String) view.getTag());
                                                                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                            if (this.f55025e.L2() == 1 && this.f55025e.w0 != null && this.f55025e.w0.P0() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c10397").param("fid", this.f55025e.w0.P0().n()).param("tid", this.f55025e.w0.P0().Q()).param("uid", currentAccount));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == R.id.look_all_tv) {
                                                                                                        if (view != null) {
                                                                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                            c.a.q0.m.a.l(this.f55025e.getActivity(), (String) view.getTag());
                                                                                                            if (this.f55025e.L2() == 1 && this.f55025e.w0 != null && this.f55025e.w0.P0() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c10507").param("fid", this.f55025e.w0.P0().n()).param("tid", this.f55025e.w0.P0().Q()).param("uid", currentAccount2));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == R.id.manga_prev_btn) {
                                                                                                        this.f55025e.l3();
                                                                                                    } else if (id == R.id.manga_next_btn) {
                                                                                                        this.f55025e.j3();
                                                                                                    } else if (id == R.id.yule_head_img_img) {
                                                                                                        if (this.f55025e.w0 != null && this.f55025e.w0.P0() != null && this.f55025e.w0.P0().A() != null) {
                                                                                                            c.a.r0.k2.h.e P03 = this.f55025e.w0.P0();
                                                                                                            TiebaStatic.log(new StatisticItem("c11679").param("fid", P03.n()));
                                                                                                            UrlManager.getInstance().dealOneLink(this.f55025e.getPageContext(), new String[]{P03.A().b()});
                                                                                                        }
                                                                                                    } else if (id == R.id.yule_head_img_all_rank) {
                                                                                                        if (this.f55025e.w0 != null && this.f55025e.w0.P0() != null && this.f55025e.w0.P0().A() != null) {
                                                                                                            c.a.r0.k2.h.e P04 = this.f55025e.w0.P0();
                                                                                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", P04.n()));
                                                                                                            UrlManager.getInstance().dealOneLink(this.f55025e.getPageContext(), new String[]{P04.A().b()});
                                                                                                        }
                                                                                                    } else if (id == R.id.tv_pb_reply_more) {
                                                                                                        if (this.f55025e.l1 >= 0) {
                                                                                                            if (this.f55025e.w0 != null) {
                                                                                                                this.f55025e.w0.W1();
                                                                                                            }
                                                                                                            if (this.f55025e.w0 == null || this.f55025e.D0.p0() == null) {
                                                                                                                i4 = 0;
                                                                                                            } else {
                                                                                                                i4 = 0;
                                                                                                                this.f55025e.D0.p0().c0(this.f55025e.w0.P0(), false);
                                                                                                            }
                                                                                                            this.f55025e.l1 = i4;
                                                                                                            if (this.f55025e.w0 != null) {
                                                                                                                this.f55025e.D0.G0().setSelection(this.f55025e.w0.I0());
                                                                                                                this.f55025e.w0.a2(0, 0);
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == R.id.qq_share_container) {
                                                                                                        if (!this.f55025e.C2(11009)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.f55025e.a3(8);
                                                                                                    } else if (id == R.id.new_sub_pb_list_richText) {
                                                                                                        SparseArray sparseArray4 = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                                                                                                        if (sparseArray4 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.f55025e.V3(sparseArray4);
                                                                                                    } else if (id == R.id.pb_editor_tool_comment_icon) {
                                                                                                        if (this.f55025e.D0.G0() == null || this.f55025e.w0 == null || this.f55025e.w0.P0() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        int firstVisiblePosition = this.f55025e.D0.G0().getFirstVisiblePosition();
                                                                                                        View childAt = this.f55025e.D0.G0().getChildAt(0);
                                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                                        boolean q0 = this.f55025e.w0.P0().q0();
                                                                                                        boolean z3 = this.f55025e.D0.Q0() != null && this.f55025e.D0.Q0().g();
                                                                                                        boolean E1 = this.f55025e.D0.E1();
                                                                                                        boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                        if (!q0 || this.f55025e.D0.Q0() == null || this.f55025e.D0.Q0().c() == null) {
                                                                                                            i3 = 0;
                                                                                                        } else {
                                                                                                            int k = ((int) (c.a.e.e.p.l.k(this.f55025e.getContext()) * 0.5625d)) - this.f55025e.D0.Q0().e();
                                                                                                            i3 = k;
                                                                                                            z4 = firstVisiblePosition == 0 && (top == k || top == this.f55025e.D0.Q0().c().getHeight() - this.f55025e.D0.Q0().e());
                                                                                                        }
                                                                                                        this.f55025e.H2(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                        if ((this.f55025e.w0.P0().O() != null && this.f55025e.w0.P0().O().U0() <= 0) || (E1 && z4)) {
                                                                                                            if (!this.f55025e.checkUpIsLogin()) {
                                                                                                                return;
                                                                                                            }
                                                                                                            this.f55025e.processProfessionPermission();
                                                                                                            if (this.f55025e.w0.P0().O().J() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55025e.w0.f55227f).param("fid", this.f55025e.w0.P0().n()).param("obj_locate", 2).param("uid", this.f55025e.w0.P0().O().J().getUserId()));
                                                                                                            }
                                                                                                        } else {
                                                                                                            int i9 = (int) (c.a.e.e.p.l.i(this.f55025e.getContext()) * 0.6d);
                                                                                                            if (q0) {
                                                                                                                if (this.f55025e.D0.R0 != null && this.f55025e.D0.R0.f20473c != null && this.f55025e.D0.R0.f20473c.getView() != null) {
                                                                                                                    if (this.f55025e.D0.R0.f20473c.getView().getParent() != null) {
                                                                                                                    }
                                                                                                                }
                                                                                                                z2 = false;
                                                                                                            } else {
                                                                                                                if (this.f55025e.D0.N0() != null) {
                                                                                                                    z2 = this.f55025e.D0.N0().getVisibility() == 0;
                                                                                                                    if (!z2 && this.f55025e.D0.R0 != null && this.f55025e.D0.R0.f20473c != null && this.f55025e.D0.R0.f20473c.getView() != null && this.f55025e.D0.R0.f20473c.getView().getParent() != null && this.f55025e.D0.f20417h != null && this.f55025e.D0.f20417h.f20288a != null) {
                                                                                                                    }
                                                                                                                }
                                                                                                                z2 = false;
                                                                                                            }
                                                                                                            if (z2 || E1) {
                                                                                                                this.f55025e.k0 = firstVisiblePosition;
                                                                                                                this.f55025e.l0 = top;
                                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i9))) {
                                                                                                                    this.f55025e.D0.G0().setSelectionFromTop(0, i3 - i9);
                                                                                                                    this.f55025e.D0.G0().smoothScrollBy(-i9, 500);
                                                                                                                } else {
                                                                                                                    this.f55025e.D0.G0().smoothScrollToPosition(0, i3, 500);
                                                                                                                }
                                                                                                            } else if (this.f55025e.k0 > 0) {
                                                                                                                if (this.f55025e.D0.G0().getChildAt(this.f55025e.k0) != null) {
                                                                                                                    this.f55025e.D0.G0().smoothScrollToPosition(this.f55025e.k0, this.f55025e.l0, 200);
                                                                                                                } else {
                                                                                                                    this.f55025e.D0.G0().setSelectionFromTop(this.f55025e.k0, this.f55025e.l0 + i9);
                                                                                                                    this.f55025e.D0.G0().smoothScrollBy(i9, 500);
                                                                                                                }
                                                                                                            } else {
                                                                                                                int c2 = c.a.r0.k2.k.e.a1.k.c(this.f55025e.getListView());
                                                                                                                if (c.a.r0.k2.k.e.a1.k.d(this.f55025e.getListView()) != -1) {
                                                                                                                    c2--;
                                                                                                                }
                                                                                                                int g2 = c.a.e.e.p.l.g(this.f55025e.getContext(), R.dimen.tbds100);
                                                                                                                if (c2 < 0) {
                                                                                                                    c2 = (ListUtils.getCount(this.f55025e.D0.G0().getData()) - 1) + this.f55025e.D0.G0().getHeaderViewsCount();
                                                                                                                    g2 = 0;
                                                                                                                }
                                                                                                                if (!z3) {
                                                                                                                    if (!q0 || this.f55025e.D0.Q0() == null) {
                                                                                                                        if (this.f55025e.D0.f20417h != null && this.f55025e.D0.f20417h.f20288a != null) {
                                                                                                                            fixedNavHeight = this.f55025e.D0.f20417h.f20288a.getFixedNavHeight() - 10;
                                                                                                                        }
                                                                                                                        if (this.f55025e.D0.R0 != null || this.f55025e.D0.R0.f20473c == null || this.f55025e.D0.R0.f20473c.getView() == null || this.f55025e.D0.R0.f20473c.getView().getParent() == null) {
                                                                                                                            this.f55025e.D0.G0().setSelectionFromTop(c2, g2 + i9);
                                                                                                                            this.f55025e.D0.G0().smoothScrollBy(i9, 500);
                                                                                                                        } else if (!z3) {
                                                                                                                            this.f55025e.D0.G0().smoothScrollToPosition(c2, g2, 200);
                                                                                                                        } else {
                                                                                                                            this.f55025e.D0.G0().smoothScrollBy(this.f55025e.D0.R0.f20473c.getView().getTop() - ((int) (c.a.e.e.p.l.k(this.f55025e.getContext()) * 0.5625d)), 500);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        fixedNavHeight = this.f55025e.D0.Q0().d();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = (int) (c.a.e.e.p.l.k(this.f55025e.getContext()) * 0.5625d);
                                                                                                                }
                                                                                                                g2 += fixedNavHeight;
                                                                                                                if (this.f55025e.D0.R0 != null) {
                                                                                                                }
                                                                                                                this.f55025e.D0.G0().setSelectionFromTop(c2, g2 + i9);
                                                                                                                this.f55025e.D0.G0().smoothScrollBy(i9, 500);
                                                                                                            }
                                                                                                        }
                                                                                                        if (this.f55025e.w0.P0().O() != null && this.f55025e.w0.P0().O().J() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55025e.w0.f55227f).param("fid", this.f55025e.w0.P0().n()).param("obj_locate", 2).param("uid", this.f55025e.w0.P0().O().J().getUserId()));
                                                                                                        }
                                                                                                    } else if (id == R.id.pb_nav_title_forum_image || id == R.id.pb_nav_title_forum_name) {
                                                                                                        if (this.f55025e.w0 == null || this.f55025e.w0.P0() == null || this.f55025e.w0.P0().m() == null || c.a.e.e.p.k.isEmpty(this.f55025e.w0.P0().m().getName())) {
                                                                                                            return;
                                                                                                        }
                                                                                                        if (this.f55025e.w0.getErrorNo() == 4) {
                                                                                                            if (!StringUtils.isNull(this.f55025e.w0.q0()) || this.f55025e.w0.g0() == null) {
                                                                                                                this.f55025e.f55017e.finish();
                                                                                                                return;
                                                                                                            }
                                                                                                            name = this.f55025e.w0.g0().f19798b;
                                                                                                        } else {
                                                                                                            name = this.f55025e.w0.P0().m().getName();
                                                                                                        }
                                                                                                        if (StringUtils.isNull(name)) {
                                                                                                            this.f55025e.f55017e.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        String q02 = this.f55025e.w0.q0();
                                                                                                        if (this.f55025e.w0.v0() && q02 != null && q02.equals(name)) {
                                                                                                            this.f55025e.f55017e.finish();
                                                                                                        } else {
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f55025e.getActivity()).createNormalCfg(this.f55025e.w0.P0().m().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                        }
                                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13401");
                                                                                                        statisticItem5.param("tid", this.f55025e.w0.f1());
                                                                                                        statisticItem5.param("fid", this.f55025e.w0.getForumId());
                                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        if (this.f55025e.w0.P0().O() != null) {
                                                                                                            statisticItem5.param("nid", this.f55025e.w0.P0().O().F0());
                                                                                                        }
                                                                                                        TiebaStatic.log(statisticItem5);
                                                                                                    } else if (id != R.id.forum_name_text && id != R.id.forum_enter_button_one && id != R.id.forum_enter_button_two && id != R.id.forum_enter_button_three) {
                                                                                                        if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                                            if (this.f55025e.w0 == null) {
                                                                                                                return;
                                                                                                            }
                                                                                                            StatisticItem statisticItem6 = new StatisticItem("c13398");
                                                                                                            statisticItem6.param("tid", this.f55025e.w0.f1());
                                                                                                            statisticItem6.param("fid", this.f55025e.w0.getForumId());
                                                                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                            statisticItem6.param("obj_locate", 2);
                                                                                                            TiebaStatic.log(statisticItem6);
                                                                                                        } else if (id == R.id.pb_thread_post_button) {
                                                                                                            if (this.f55025e.w0 == null || this.f55025e.w0.P0() == null) {
                                                                                                                return;
                                                                                                            }
                                                                                                            c.a.r0.k2.h.e P05 = this.f55025e.w0.P0();
                                                                                                            if (this.f55025e.B0 == null) {
                                                                                                                PbFragment pbFragment2 = this.f55025e;
                                                                                                                pbFragment2.B0 = new c.a.r0.k2.h.t(pbFragment2.getPageContext());
                                                                                                            }
                                                                                                            long g3 = c.a.e.e.m.b.g(P05.Q(), 0L);
                                                                                                            long g4 = c.a.e.e.m.b.g(P05.n(), 0L);
                                                                                                            new StatisticItem("c13446").param("forum_id", g4).eventStat();
                                                                                                            PbFragment pbFragment3 = this.f55025e;
                                                                                                            pbFragment3.registerListener(pbFragment3.X1);
                                                                                                            this.f55025e.B0.a(g3, g4);
                                                                                                        } else if (id == R.id.pb_video_thread_smart_app_layout) {
                                                                                                            if (view.getTag() instanceof SmartApp) {
                                                                                                                SmartApp smartApp = (SmartApp) view.getTag();
                                                                                                                if (!c.a.r0.v.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                    if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    c.a.q0.m.a.l(this.f55025e.getActivity(), smartApp.h5_url);
                                                                                                                }
                                                                                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.f55025e.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", AppletsCellView.PB_SHARE_CARD_LITE_PROGRAM_FROM).param("tid", this.f55025e.w0.f1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                            }
                                                                                                        } else if (id == R.id.id_pb_business_promotion_wrapper) {
                                                                                                            if (!(view.getTag() instanceof c.a.q0.s.q.d2)) {
                                                                                                                return;
                                                                                                            }
                                                                                                            c.a.q0.s.q.d2 d2Var = (c.a.q0.s.q.d2) view.getTag();
                                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f55025e.getActivity()).createNormalCfg(d2Var.Z(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                            createNormalCfg.setCallFrom(14);
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", d2Var.T()).param("tid", d2Var.f0()).param("thread_type", d2Var.o1()).param(TiebaStatic.Params.IS_ZP, d2Var.I2() ? 1 : 0));
                                                                                                        } else if (id == R.id.id_pb_business_promotion_attention) {
                                                                                                            if (!(view.getTag() instanceof c.a.q0.s.q.d2) || !this.f55025e.checkUpIsLogin()) {
                                                                                                                return;
                                                                                                            }
                                                                                                            c.a.q0.s.q.d2 d2Var2 = (c.a.q0.s.q.d2) view.getTag();
                                                                                                            if (this.f55025e.V != null) {
                                                                                                                this.f55025e.V.L(d2Var2.Z(), String.valueOf(d2Var2.T()));
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", d2Var2.T()).param("tid", d2Var2.f0()).param("thread_type", d2Var2.o1()).param(TiebaStatic.Params.IS_ZP, d2Var2.I2() ? 1 : 0));
                                                                                                        } else if (id == R.id.pb_floor_right_top_feedback || id == R.id.pb_post_op_more) {
                                                                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                            statisticItem7.param("tid", this.f55025e.w0.f1());
                                                                                                            statisticItem7.param("fid", this.f55025e.w0.getForumId());
                                                                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                            statisticItem7.param("obj_locate", 7);
                                                                                                            TiebaStatic.log(statisticItem7);
                                                                                                            PbFragment pbFragment4 = this.f55025e;
                                                                                                            pbFragment4.f55018f = false;
                                                                                                            pbFragment4.F2(view);
                                                                                                        }
                                                                                                    } else if (!(view.getTag() instanceof c.a.q0.s.q.d2)) {
                                                                                                        return;
                                                                                                    } else {
                                                                                                        c.a.q0.s.q.d2 d2Var3 = (c.a.q0.s.q.d2) view.getTag();
                                                                                                        if (this.f55025e.w0.O0() == 3 && this.f55025e.isSimpleForum() && this.f55025e.w0.P0() != null && ListUtils.isEmpty(this.f55025e.w0.P0().q())) {
                                                                                                            this.f55025e.f55017e.finish();
                                                                                                        } else {
                                                                                                            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.f55025e.getActivity()).createNormalCfg(d2Var3.Z(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
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
                                                                                                    if (!this.f55025e.checkUpIsLogin()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view != null && view.getTag() != null) {
                                                                                                        SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                                        if (id == R.id.replybtn_top_right || id == R.id.cover_reply_content_top_right) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.f55025e.w0.f55227f));
                                                                                                        }
                                                                                                        if (this.f55025e.I0 == null) {
                                                                                                            PbFragment pbFragment5 = this.f55025e;
                                                                                                            pbFragment5.I0 = new c.a.q0.s.s.i(pbFragment5.getContext());
                                                                                                            this.f55025e.I0.n(this.f55025e.U1);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.f55025e.isImage(view);
                                                                                                        if (this.f55025e.isImage(view) && this.f55025e.h1 != null) {
                                                                                                            this.f55025e.h1.t();
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
                                                                                                                c.a.q0.s.s.f fVar8 = new c.a.q0.s.s.f(3, this.f55025e.getString(R.string.copy), this.f55025e.I0);
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(R.id.tag_clip_board, postData3);
                                                                                                                fVar8.f14448d.setTag(sparseArray6);
                                                                                                                arrayList.add(fVar8);
                                                                                                            }
                                                                                                            this.f55025e.l2 = postData3;
                                                                                                        }
                                                                                                        if (this.f55025e.w0.P0().s()) {
                                                                                                            String u = this.f55025e.w0.P0().u();
                                                                                                            if (postData3 != null && !c.a.e.e.p.k.isEmpty(u) && u.equals(postData3.E())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    fVar4 = new c.a.q0.s.s.f(4, this.f55025e.getString(R.string.remove_mark), this.f55025e.I0);
                                                                                                                } else {
                                                                                                                    fVar4 = new c.a.q0.s.s.f(4, this.f55025e.getString(R.string.mark), this.f55025e.I0);
                                                                                                                }
                                                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                                                sparseArray7.put(R.id.tag_clip_board, this.f55025e.l2);
                                                                                                                sparseArray7.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                                                fVar4.f14448d.setTag(sparseArray7);
                                                                                                                arrayList.add(fVar4);
                                                                                                                if (this.f55025e.mIsLogin) {
                                                                                                                    if (c.a.r0.k2.k.e.f1.a.h(this.f55025e.w0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.f55025e.h3(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            c.a.q0.s.s.f fVar9 = new c.a.q0.s.s.f(5, this.f55025e.getString(R.string.report_text), this.f55025e.I0);
                                                                                                                            fVar9.f14448d.setTag(str2);
                                                                                                                            arrayList.add(fVar9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        c.a.q0.s.s.f fVar10 = new c.a.q0.s.s.f(5, this.f55025e.getString(R.string.mute_option), this.f55025e.I0);
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
                                                                                                                        fVar4.f14448d.setTag(sparseArray8);
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
                                                                                                                            fVar7 = new c.a.q0.s.s.f(6, this.f55025e.getString(R.string.delete), this.f55025e.I0);
                                                                                                                            fVar7.f14448d.setTag(sparseArray9);
                                                                                                                        } else {
                                                                                                                            sparseArray9.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        fVar5 = new c.a.q0.s.s.f(7, this.f55025e.getString(R.string.bar_manager), this.f55025e.I0);
                                                                                                                        fVar5.f14448d.setTag(sparseArray9);
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
                                                                                                                        if (this.f55025e.w0.P0().V() == 1002 && !booleanValue) {
                                                                                                                            fVar6 = new c.a.q0.s.s.f(6, this.f55025e.getString(R.string.report_text), this.f55025e.I0);
                                                                                                                        } else {
                                                                                                                            fVar6 = new c.a.q0.s.s.f(6, this.f55025e.getString(R.string.delete), this.f55025e.I0);
                                                                                                                        }
                                                                                                                        fVar6.f14448d.setTag(sparseArray10);
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
                                                                                                                this.f55025e.I0.k(arrayList);
                                                                                                                this.f55025e.H0 = new PopupDialog(this.f55025e.getPageContext(), this.f55025e.I0);
                                                                                                                this.f55025e.H0.showDialog();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray72 = new SparseArray();
                                                                                                        sparseArray72.put(R.id.tag_clip_board, this.f55025e.l2);
                                                                                                        sparseArray72.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                                        fVar4.f14448d.setTag(sparseArray72);
                                                                                                        arrayList.add(fVar4);
                                                                                                        if (this.f55025e.mIsLogin) {
                                                                                                        }
                                                                                                        this.f55025e.I0.k(arrayList);
                                                                                                        this.f55025e.H0 = new PopupDialog(this.f55025e.getPageContext(), this.f55025e.I0);
                                                                                                        this.f55025e.H0.showDialog();
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            this.f55025e.D0.f20417h.l();
                                                                                            this.f55025e.D0.t3(this.f55025e.o2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.f55025e.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.f55025e.getPageContext().getPageActivity(), 24008, c.a.e.e.m.b.g(this.f55025e.w0.P0().n(), 0L), c.a.e.e.m.b.g(this.f55025e.w0.f1(), 0L), c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.f55025e.w0.P0().O().O0())));
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
                                                                                    if (this.f55025e.I0 == null) {
                                                                                        PbFragment pbFragment6 = this.f55025e;
                                                                                        pbFragment6.I0 = new c.a.q0.s.s.i(pbFragment6.getContext());
                                                                                        this.f55025e.I0.n(this.f55025e.U1);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.f55025e.getPbModel().P0() != null && this.f55025e.getPbModel().P0().f0();
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
                                                                                                pbFragment = this.f55025e;
                                                                                                i2 = R.string.action_cancel_dislike;
                                                                                            } else {
                                                                                                pbFragment = this.f55025e;
                                                                                                i2 = R.string.action_dislike;
                                                                                            }
                                                                                            c.a.q0.s.s.f fVar11 = new c.a.q0.s.s.f(8, pbFragment.getString(i2), this.f55025e.I0);
                                                                                            SparseArray sparseArray11 = new SparseArray();
                                                                                            sparseArray11.put(R.id.tag_clip_board, postData4);
                                                                                            fVar11.f14448d.setTag(sparseArray11);
                                                                                            arrayList2.add(fVar11);
                                                                                        }
                                                                                        if (this.f55025e.mIsLogin) {
                                                                                            if (c.a.r0.k2.k.e.f1.a.h(this.f55025e.w0) || booleanValue8 || !booleanValue7) {
                                                                                                if ((this.f55025e.h3(booleanValue6) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    c.a.q0.s.s.f fVar12 = new c.a.q0.s.s.f(5, this.f55025e.getString(R.string.report_text), this.f55025e.I0);
                                                                                                    fVar12.f14448d.setTag(str3);
                                                                                                    arrayList2.add(fVar12);
                                                                                                }
                                                                                            } else {
                                                                                                c.a.q0.s.s.f fVar13 = new c.a.q0.s.s.f(5, this.f55025e.getString(R.string.mute_option), this.f55025e.I0);
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
                                                                                                fVar13.f14448d.setTag(sparseArray12);
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
                                                                                                    fVar2 = new c.a.q0.s.s.f(6, this.f55025e.getString(R.string.delete), this.f55025e.I0);
                                                                                                    fVar2.f14448d.setTag(sparseArray13);
                                                                                                } else {
                                                                                                    sparseArray13.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                                    fVar2 = null;
                                                                                                }
                                                                                                fVar = new c.a.q0.s.s.f(7, this.f55025e.getString(R.string.bar_manager), this.f55025e.I0);
                                                                                                fVar.f14448d.setTag(sparseArray13);
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
                                                                                                if (this.f55025e.w0.P0().V() == 1002 && !booleanValue6) {
                                                                                                    fVar3 = new c.a.q0.s.s.f(6, this.f55025e.getString(R.string.report_text), this.f55025e.I0);
                                                                                                } else {
                                                                                                    fVar3 = new c.a.q0.s.s.f(6, this.f55025e.getString(R.string.delete), this.f55025e.I0);
                                                                                                }
                                                                                                fVar3.f14448d.setTag(sparseArray14);
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
                                                                                        this.f55025e.I0.k(arrayList2);
                                                                                        this.f55025e.H0 = new PopupDialog(this.f55025e.getPageContext(), this.f55025e.I0);
                                                                                        this.f55025e.H0.showDialog();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                    StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                                                    statisticItem9.param("tid", this.f55025e.w0.f1());
                                                                                    statisticItem9.param("fid", this.f55025e.w0.getForumId());
                                                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem9.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem9);
                                                                                }
                                                                                if (view.getId() == R.id.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f55025e.getActivity(), "pb_chakanhuifu"))) {
                                                                                    this.f55025e.X = view;
                                                                                    return;
                                                                                } else if (this.f55025e.checkUpIsLogin()) {
                                                                                    if (this.f55025e.w0 == null || this.f55025e.w0.P0() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.f55025e.D0.e0();
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
                                                                                    String f12 = this.f55025e.w0.f1();
                                                                                    String E2 = postData5.E();
                                                                                    String E3 = postData6 != null ? postData6.E() : "";
                                                                                    int V2 = this.f55025e.w0.P0() != null ? this.f55025e.w0.P0().V() : 0;
                                                                                    this.f55025e.stopVoice();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        AbsPbActivity.e t32 = this.f55025e.t3(E2);
                                                                                        if (this.f55025e.w0 == null || this.f55025e.w0.P0() == null || t32 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.f55025e.getPageContext().getPageActivity()).createSubPbActivityConfig(f12, E2, "pb", true, false, null, true, null, V2, postData5.P(), this.f55025e.w0.P0().d(), false, postData5.t().getIconInfo(), 5).addBigImageData(t32.f54984a, t32.f54985b, t32.f54990g, t32.f54993j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.f55025e.w0.O0());
                                                                                        addBigImageData2.setFromFrsForumId(this.f55025e.w0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.f55025e.w0.k1());
                                                                                        addBigImageData2.setKeyFromForumId(this.f55025e.w0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.f55025e.w0.j0());
                                                                                        addBigImageData2.setTiebaPlusData(this.f55025e.w0.F(), this.f55025e.w0.B(), this.f55025e.w0.C(), this.f55025e.w0.A(), this.f55025e.w0.G());
                                                                                        this.f55025e.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e t33 = this.f55025e.t3(E2);
                                                                                        if (postData5 == null || this.f55025e.w0 == null || this.f55025e.w0.P0() == null || t33 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.f55025e.getPageContext().getPageActivity()).createSubPbActivityConfig(f12, E2, "pb", true, false, null, false, E3, V2, postData5.P(), this.f55025e.w0.P0().d(), false, postData5.t().getIconInfo(), 5).addBigImageData(t33.f54984a, t33.f54985b, t33.f54990g, t33.f54993j);
                                                                                        if (!c.a.e.e.p.k.isEmpty(E3)) {
                                                                                            addBigImageData3.setHighLightPostId(E3);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.f55025e.w0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.f55025e.w0.F(), this.f55025e.w0.B(), this.f55025e.w0.C(), this.f55025e.w0.A(), this.f55025e.w0.G());
                                                                                        addBigImageData3.setBjhData(this.f55025e.w0.j0());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.f55025e.w0.O0());
                                                                                        addBigImageData3.setFromFrsForumId(this.f55025e.w0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.f55025e.w0.k1());
                                                                                        if (this.f55025e.D0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.f55025e.D0.x0(this.f55025e.w0.J, this.f55025e.w0.d1()).S || postData5.S);
                                                                                        }
                                                                                        this.f55025e.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f55025e.w0.P0().n()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (c.a.e.e.p.j.z()) {
                                                                            SparseArray<Object> H02 = this.f55025e.D0.H0(this.f55025e.w0.P0(), this.f55025e.w0.d1(), 1);
                                                                            if (H02 != null) {
                                                                                this.f55025e.D0.b2(((Integer) H02.get(R.id.tag_del_post_type)).intValue(), (String) H02.get(R.id.tag_del_post_id), ((Integer) H02.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) H02.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            }
                                                                            this.f55025e.D0.f20417h.k();
                                                                            if (this.f55025e.getPbModel() != null && this.f55025e.getPbModel().P0() != null && this.f55025e.getPbModel().P0().O() != null) {
                                                                                c.a.q0.s.q.d2 O = this.f55025e.getPbModel().P0().O();
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
                                                                            this.f55025e.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (c.a.e.e.p.j.z()) {
                                                                        this.f55025e.D0.e0();
                                                                        SparseArray<Object> H03 = this.f55025e.D0.H0(this.f55025e.w0.P0(), this.f55025e.w0.d1(), 1);
                                                                        if (H03 == null) {
                                                                            return;
                                                                        }
                                                                        this.f55025e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f55025e.getPageContext().getPageActivity(), this.f55025e.w0.P0().m().getId(), this.f55025e.w0.P0().m().getName(), this.f55025e.w0.P0().O().f0(), String.valueOf(this.f55025e.w0.P0().U().getUserId()), (String) H03.get(R.id.tag_forbid_user_name), (String) H03.get(R.id.tag_forbid_user_name_show), (String) H03.get(R.id.tag_forbid_user_post_id), (String) H03.get(R.id.tag_forbid_user_portrait))));
                                                                    } else {
                                                                        this.f55025e.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        this.f55025e.onChangeSkinType(skinType);
                                                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                                                    } else if (skinType == 0 || skinType == 4) {
                                                                        UtilHelper.showSkinChangeAnimation(this.f55025e.getActivity());
                                                                        this.f55025e.onChangeSkinType(skinType);
                                                                        UtilHelper.setNavigationBarBackground(this.f55025e.getActivity(), this.f55025e.getResources().getColor(R.color.CAM_X0201_1));
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                                                    }
                                                                    this.f55025e.D0.f20417h.l();
                                                                }
                                                            } else if (this.f55025e.w0 == null || this.f55025e.w0.P0() == null || this.f55025e.w0.P0().O() == null) {
                                                                return;
                                                            } else {
                                                                this.f55025e.D0.f20417h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.f55025e;
                                                                pbFragment7.X2(pbFragment7.w0.P0().O().W());
                                                            }
                                                        } else {
                                                            this.f55025e.D0.e0();
                                                            if (c.a.e.e.p.j.z()) {
                                                                if (this.f55025e.m) {
                                                                    view.setTag(Integer.valueOf(this.f55025e.w0.b1()));
                                                                    return;
                                                                }
                                                                this.f55025e.stopVoice();
                                                                this.f55025e.D0.S2();
                                                                PopupDialog popupDialog = new PopupDialog(this.f55025e.getPageContext());
                                                                if (this.f55025e.w0.P0().f19808f == null || this.f55025e.w0.P0().f19808f.size() <= 0) {
                                                                    strArr = new String[]{this.f55025e.getResources().getString(R.string.sort_type_new), this.f55025e.getResources().getString(R.string.sort_type_old)};
                                                                } else {
                                                                    strArr = new String[this.f55025e.w0.P0().f19808f.size()];
                                                                    for (int i64 = 0; i64 < this.f55025e.w0.P0().f19808f.size(); i64++) {
                                                                        strArr[i64] = this.f55025e.w0.P0().f19808f.get(i64).sort_name + this.f55025e.getResources().getString(R.string.sort_static);
                                                                    }
                                                                }
                                                                popupDialog.setDefaultContentView(null, strArr, new a(this, popupDialog, view));
                                                                popupDialog.showDialog();
                                                            } else {
                                                                this.f55025e.showToast(R.string.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.f55025e.D0.e0();
                                                        if (this.f55025e.getPbModel().P0().f19809g != 2) {
                                                            if (this.f55025e.w0.N0() != null) {
                                                                this.f55025e.D0.y3(this.f55025e.w0.N0(), this.f55025e.mDialogClickListener);
                                                            }
                                                            TiebaStatic.eventStat(this.f55025e.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.f55025e.showToast(R.string.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.f55025e.checkUpIsLogin()) || (P0 = this.f55025e.w0.P0()) == null) {
                                                    return;
                                                } else {
                                                    c.a.q0.s.q.d2 O2 = P0.O();
                                                    if (O2 != null && O2.J() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55025e.w0.f55227f).param("fid", P0.n()).param("obj_locate", 4).param("uid", O2.J().getUserId()));
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
                                                        statisticItem13.param("tid", this.f55025e.w0.f1());
                                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem13.param("fid", this.f55025e.w0.getForumId());
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
                                                        if (this.f55025e.getPbActivity() != null) {
                                                            c.a.q0.n0.c.e(this.f55025e.getPbActivity(), statisticItem13);
                                                        }
                                                        if (this.f55025e.D0 != null) {
                                                            statisticItem13.param("obj_param1", this.f55025e.D0.C0());
                                                        }
                                                        TiebaStatic.log(statisticItem13);
                                                        if (c.a.e.e.p.l.D()) {
                                                            this.f55025e.showToast(R.string.neterror);
                                                            return;
                                                        } else if (P0 != null) {
                                                            ArrayList<PostData> F2 = this.f55025e.w0.P0().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.f55025e.w0.d1()) {
                                                                this.f55025e.D0.e0();
                                                                this.f55025e.stopVoice();
                                                                if (P0.A() != null && !StringUtils.isNull(P0.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.f55025e.w0.P0().n()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.f55025e.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.f55025e.D0 != null) {
                                                                    this.f55025e.D0.g0();
                                                                    this.f55025e.D0.J3(P0);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.f55025e.D0.m3();
                                                                    this.f55025e.w0.l0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view.getId() == R.id.pb_editor_tool_share) {
                                                                        i6 = 2;
                                                                    } else {
                                                                        i6 = view.getId() == R.id.share_num_container ? 1 : 6;
                                                                    }
                                                                    if ((c.a.q0.b.d.S() || c.a.q0.b.d.T()) && this.f55025e.D0.I1()) {
                                                                        int C0 = this.f55025e.D0.C0();
                                                                        this.f55025e.D0.T();
                                                                        this.f55025e.Z2(c.a.q0.t.g.f.a(), C0);
                                                                    } else {
                                                                        this.f55025e.R3(i6);
                                                                    }
                                                                }
                                                            } else {
                                                                c.a.e.e.p.l.M(this.f55025e.getPageContext().getPageActivity(), this.f55025e.getPageContext().getString(R.string.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            c.a.e.e.p.l.M(this.f55025e.getPageContext().getPageActivity(), this.f55025e.getPageContext().getString(R.string.pb_no_data_tips));
                                                            return;
                                                        }
                                                    }
                                                    i5 = 1;
                                                    StatisticItem statisticItem132 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem132.param("tid", this.f55025e.w0.f1());
                                                    statisticItem132.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem132.param("fid", this.f55025e.w0.getForumId());
                                                    if (view.getId() != R.id.share_num_container) {
                                                    }
                                                    statisticItem132.param("obj_name", i5);
                                                    statisticItem132.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.f55025e.getPbActivity() != null) {
                                                    }
                                                    if (this.f55025e.D0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem132);
                                                    if (c.a.e.e.p.l.D()) {
                                                    }
                                                }
                                            } else if (c.a.e.e.p.j.z()) {
                                                this.f55025e.D0.e0();
                                                if (this.f55025e.D0.f20417h.n() != null && view == this.f55025e.D0.f20417h.n().i() && !this.f55025e.D0.G1()) {
                                                    this.f55025e.D0.q2();
                                                }
                                                if (!this.f55025e.m) {
                                                    this.f55025e.stopVoice();
                                                    this.f55025e.D0.S2();
                                                    if (view.getId() == R.id.floor_owner_reply) {
                                                        s2 = this.f55025e.w0.s2(true, this.f55025e.N2());
                                                    } else {
                                                        s2 = view.getId() == R.id.reply_title ? this.f55025e.w0.s2(false, this.f55025e.N2()) : this.f55025e.w0.r2(this.f55025e.N2());
                                                    }
                                                    view.setTag(Boolean.valueOf(s2));
                                                    if (s2) {
                                                        i7 = 1;
                                                        this.f55025e.D0.D2(true);
                                                        this.f55025e.D0.w3();
                                                        this.f55025e.m = true;
                                                        this.f55025e.D0.G2(true);
                                                    } else {
                                                        i7 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.f55025e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                                } else {
                                                    view.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.f55025e.showToast(R.string.network_not_available);
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (c.a.e.e.p.j.z()) {
                                            this.f55025e.D0.e0();
                                            if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f55025e.getActivity(), "pb_shoucang"))) {
                                                if (!this.f55025e.C2(11009) || this.f55025e.w0.h0(this.f55025e.D0.F0()) == null) {
                                                    return;
                                                }
                                                this.f55025e.o3();
                                                if (this.f55025e.w0.P0() != null && this.f55025e.w0.P0().O() != null && this.f55025e.w0.P0().O().J() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55025e.w0.f55227f).param("fid", this.f55025e.w0.P0().n()).param("obj_locate", 3).param("uid", this.f55025e.w0.P0().O().J().getUserId()));
                                                }
                                                if (this.f55025e.w0.P0().O() != null && this.f55025e.w0.P0().O().J() != null && this.f55025e.w0.P0().O().J().getUserId() != null && this.f55025e.y0 != null) {
                                                    PbFragment pbFragment8 = this.f55025e;
                                                    int V22 = pbFragment8.V2(pbFragment8.w0.P0());
                                                    c.a.q0.s.q.d2 O3 = this.f55025e.w0.P0().O();
                                                    if (O3.M1()) {
                                                        i8 = 2;
                                                    } else if (O3.P1()) {
                                                        i8 = 3;
                                                    } else if (O3.N1()) {
                                                        i8 = 4;
                                                    } else {
                                                        i8 = O3.O1() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f55025e.w0.f55227f).param("obj_locate", 1).param("obj_id", this.f55025e.w0.P0().O().J().getUserId()).param("obj_type", !this.f55025e.y0.e()).param("obj_source", V22).param("obj_param1", i8));
                                                }
                                            } else {
                                                this.f55025e.Z = view;
                                                return;
                                            }
                                        } else {
                                            this.f55025e.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.f55025e.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.f55025e.w0.P0() != null && this.f55025e.w0.P0().O() != null && this.f55025e.w0.P0().O().E2() && this.f55025e.w0.P0().O().q1() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.f55025e.w0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.f55025e.w0.q0()) || this.f55025e.w0.g0() == null) {
                                                this.f55025e.f55017e.finish();
                                                return;
                                            }
                                            name2 = this.f55025e.w0.g0().f19798b;
                                        } else {
                                            name2 = this.f55025e.w0.P0().m().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.f55025e.f55017e.finish();
                                            return;
                                        }
                                        String q03 = this.f55025e.w0.q0();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.f55025e.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.f55025e.w0.v0() && q03 != null && q03.equals(name2)) {
                                            this.f55025e.f55017e.finish();
                                        } else {
                                            this.f55025e.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (c.a.e.e.p.j.z()) {
                                    if (this.f55025e.w0.P0() == null || this.f55025e.z0.P()) {
                                        return;
                                    }
                                    this.f55025e.D0.e0();
                                    int i66 = (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().m()) ? (this.f55025e.D0.f20417h.n() == null || view != this.f55025e.D0.f20417h.n().l()) ? view == this.f55025e.D0.r0() ? 2 : 0 : this.f55025e.w0.P0().O().q0() == 1 ? 3 : 6 : this.f55025e.w0.P0().O().r0() == 1 ? 5 : 4;
                                    ForumData m = this.f55025e.w0.P0().m();
                                    String name3 = m.getName();
                                    String id2 = m.getId();
                                    String f0 = this.f55025e.w0.P0().O().f0();
                                    this.f55025e.D0.D3();
                                    this.f55025e.z0.T(id2, name3, f0, i66, this.f55025e.D0.s0());
                                } else {
                                    this.f55025e.showToast(R.string.network_not_available);
                                    return;
                                }
                            } else {
                                this.f55025e.D0.f20417h.l();
                                if (this.f55025e.w0 != null) {
                                    this.f55025e.o1.f(this.f55025e.w0.f1());
                                }
                                if (this.f55025e.w0 == null || !this.f55025e.w0.isPrivacy()) {
                                    this.f55025e.o1.b();
                                    int i67 = (TbSingleton.getInstance().mCanCallFans || this.f55025e.getPbModel() == null || this.f55025e.getPbModel().P0() == null || this.f55025e.getPbModel().P0().Q() == null || !this.f55025e.getPbModel().P0().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.f55025e.getPbModel() != null && this.f55025e.getPbModel().P0() != null) {
                                        this.f55025e.o1.d(3, i67, this.f55025e.getPbModel().P0().Q());
                                    }
                                } else {
                                    this.f55025e.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                    if (this.f55025e.getPbModel() == null || this.f55025e.getPbModel().P0() == null) {
                                        return;
                                    }
                                    this.f55025e.o1.d(3, 3, this.f55025e.getPbModel().P0().Q());
                                    return;
                                }
                            }
                        } else if (c.a.e.e.p.j.z()) {
                            this.f55025e.D0.e0();
                            this.f55025e.stopVoice();
                            this.f55025e.D0.S2();
                            this.f55025e.D0.m3();
                            if (this.f55025e.D0.N0() != null) {
                                this.f55025e.D0.N0().setVisibility(8);
                            }
                            this.f55025e.w0.n2(1);
                            if (this.f55025e.f55021i != null) {
                                this.f55025e.f55021i.x();
                            }
                        } else {
                            this.f55025e.showToast(R.string.network_not_available);
                            return;
                        }
                    } else {
                        String str4 = (String) view.getTag(R.id.forum_name);
                        String str5 = (String) view.getTag(R.id.forum_id);
                        String str6 = (String) view.getTag(R.id.thread_id);
                        if (this.f55025e.V != null) {
                            this.f55025e.V.L(str4, str5);
                        }
                        TbPageTag l = c.a.q0.n0.c.l(this.f55025e.getContext());
                        c.a.r0.k2.k.e.f1.c.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l != null ? l.locatePage : "");
                    }
                    if (this.f55025e.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String M2 = this.f55025e.M2();
                        if (TextUtils.isEmpty(M2)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.f55025e.getPageContext(), new String[]{M2});
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem14 = new StatisticItem("c13398");
                statisticItem14.param("tid", this.f55025e.w0.f1());
                statisticItem14.param("fid", this.f55025e.w0.getForumId());
                statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem14.param("obj_locate", 1);
                TiebaStatic.log(statisticItem14);
                if (this.f55025e.A) {
                    this.f55025e.A = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (this.f55025e.w0 == null || this.f55025e.w0.P0() == null || this.f55025e.getPbView().O0() == null || postData7.t() == null || postData7.A() == 1 || !this.f55025e.checkUpIsLogin()) {
                            return;
                        }
                        if (this.f55025e.getPbView().P0() != null) {
                            this.f55025e.getPbView().P0().c();
                        }
                        c.a.r0.k2.h.r rVar2 = new c.a.r0.k2.h.r();
                        rVar2.A(this.f55025e.w0.P0().m());
                        rVar2.E(this.f55025e.w0.P0().O());
                        rVar2.C(postData7);
                        this.f55025e.getPbView().O0().S(rVar2);
                        this.f55025e.getPbView().O0().setPostId(postData7.E());
                        this.f55025e.m3(view, postData7.t().getUserId(), "", postData7);
                        TiebaStatic.log("c11743");
                        c.a.r0.k2.m.a.b(this.f55025e.w0.P0(), postData7, postData7.i0, 8, 1);
                        if (this.f55025e.R0 != null) {
                            this.f55025e.D0.x2(this.f55025e.R0.E());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements c.a.e.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55029a;

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
            this.f55029a = pbFragment;
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
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f55029a.getPageContext().getPageActivity());
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
    public interface a3 {
        boolean onBackPressed();
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.q0.d1.i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55030a;

        public b(PbFragment pbFragment) {
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
            this.f55030a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.r0.k2.k.e.f1.b.d(this.f55030a.getContext(), this.f55030a.L2(), ShareSwitch.isOn() ? 1 : 6, this.f55030a.w0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends c.a.q0.j0.i<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55031g;

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
            this.f55031g = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.j0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.f55031g.f55017e.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.makeText(this.f55031g.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55032a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(PbFragment pbFragment, int i2) {
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
            this.f55032a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f55032a.w0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.f55032a.w0.f55227f)) {
                this.f55032a.Q3((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b2 implements c.a.e.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55033a;

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
            this.f55033a = pbFragment;
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
                GifView gifView = new GifView(this.f55033a.getPageContext().getPageActivity());
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
    public interface b3 {
        void a(Object obj);
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.q0.d1.q<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55034a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55035b;

        public c(PbFragment pbFragment, int i2) {
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
            this.f55035b = pbFragment;
            this.f55034a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f55035b.getContext(), this.f55034a, shareItem, false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f55036e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55037f;

        public c0(PbFragment pbFragment, Intent intent) {
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
            this.f55037f = pbFragment;
            this.f55036e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.k2.k.e.s0 s0Var = this.f55037f.D0;
                s0Var.V2(TNCManager.TNC_PROBE_HEADER_SECEPTOR + this.f55036e.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55038a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f55039e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c1 f55040f;

            public a(c1 c1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55040f = c1Var;
                this.f55039e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55040f.f55038a.D0 == null || this.f55039e == null) {
                    return;
                }
                this.f55040f.f55038a.D0.e2(this.f55039e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c1 c1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1Var};
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
            public final /* synthetic */ c1 f55041e;

            public c(c1 c1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55041e = c1Var;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f55041e.f55038a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f55041e.f55038a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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
            this.f55038a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.q0.t.c.l0 l0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f55038a.w0.P0() != null) {
                        statisticItem.param("fid", this.f55038a.w0.P0().n());
                    }
                    statisticItem.param("tid", this.f55038a.w0.f1());
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
                this.f55038a.stopVoice();
                this.f55038a.D0.Q2(z, postWriteCallBackData);
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                boolean z2 = false;
                if (z) {
                    this.f55038a.Q3(postWriteCallBackData);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.f55038a.F3(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (this.f55038a.w0.t0()) {
                            c.a.r0.k2.h.e P0 = this.f55038a.w0.P0();
                            if (P0 != null && P0.O() != null && P0.O().J() != null && (userId = P0.O().J().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.f55038a.w0.q2()) {
                                this.f55038a.D0.S2();
                            }
                        } else if (!PbReplySwitch.getInOn() && this.f55038a.w0.q2()) {
                            this.f55038a.D0.S2();
                        }
                    } else if (floor != null) {
                        this.f55038a.D0.u1(this.f55038a.w0.P0());
                    }
                    if (this.f55038a.w0.x0()) {
                        TiebaStatic.log(new StatisticItem("c10369").param("tid", this.f55038a.w0.f1()));
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        c.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    PbFragment pbFragment = this.f55038a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    pbFragment.z2(z2);
                    if (this.f55038a.e3()) {
                        this.f55038a.Z3();
                    }
                } else if (i2 == 220015) {
                    this.f55038a.showToast(str);
                    if (this.f55038a.R0.D() || this.f55038a.R0.F()) {
                        this.f55038a.R0.B(false, postWriteCallBackData);
                    }
                    this.f55038a.mContentProcessController.k(postWriteCallBackData);
                } else if (i2 == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f55038a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f55038a.getActivity(), this.f55038a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f55038a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f55038a.getActivity());
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f55038a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f55038a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (c.a.r0.u3.a.c(i2) || l0Var != null || i2 == 227001) {
                } else {
                    this.f55038a.E3(i2, antiData, str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements c.a.e.e.k.c<TiebaPlusRecommendCard> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55042a;

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
            this.f55042a = pbFragment;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new TiebaPlusRecommendCard(this.f55042a.getPageContext().getPageActivity()) : (TiebaPlusRecommendCard) invokeV.objValue;
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
    public interface c3 {
    }

    /* loaded from: classes7.dex */
    public class d extends c.a.q0.d1.i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55043a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55044b;

        public d(PbFragment pbFragment, int i2) {
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
            this.f55044b = pbFragment;
            this.f55043a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel pbModel = this.f55044b.getPbModel();
                if (pbModel != null) {
                    pbModel.d2(this.f55043a);
                }
                return c.a.r0.k2.k.e.f1.b.d(this.f55044b.getContext(), this.f55044b.L2(), 2, pbModel);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55045a;

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
            this.f55045a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f55045a.R0.N(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f55045a.D0 != null && this.f55045a.D0.P0() != null && this.f55045a.D0.P0().b() != null) {
                    this.f55045a.D0.P0().b().G();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.f55045a;
                    pbFragment.w3(pbFragment.W0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55046a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f55047e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d1 f55048f;

            public a(d1 d1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55048f = d1Var;
                this.f55047e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55048f.f55046a.D0 == null || this.f55047e == null) {
                    return;
                }
                this.f55048f.f55046a.D0.e2(this.f55047e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(d1 d1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d1Var};
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
            public final /* synthetic */ d1 f55049e;

            public c(d1 d1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55049e = d1Var;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f55049e.f55046a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f55049e.f55046a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public d1(PbFragment pbFragment) {
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
            this.f55046a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.q0.t.c.l0 l0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f55046a.w0 != null && this.f55046a.w0.P0() != null) {
                        statisticItem.param("fid", this.f55046a.w0.P0().n());
                    }
                    if (this.f55046a.w0 != null) {
                        statisticItem.param("tid", this.f55046a.w0.f1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    c.a.r0.k2.k.e.u0 u0Var = this.f55046a.mContentProcessController;
                    if (u0Var != null) {
                        u0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        c.a.q0.t.h.b.a(this.f55046a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        c.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.f55046a.e3()) {
                        this.f55046a.Z3();
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f55046a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f55046a.getActivity(), this.f55046a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f55046a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f55046a.getActivity());
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f55046a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f55046a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.f55046a;
                if (pbFragment.mContentProcessController == null) {
                    return;
                }
                if (pbFragment.D0 != null && this.f55046a.D0.P0() != null && this.f55046a.D0.P0().b() != null && this.f55046a.D0.P0().b().y()) {
                    this.f55046a.D0.P0().b().w(postWriteCallBackData);
                }
                this.f55046a.mContentProcessController.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d2 implements c.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55050a;

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
            this.f55050a = pbFragment;
        }

        @Override // c.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.k2.k.e.u0 u0Var = this.f55050a.mContentProcessController;
                if (u0Var == null || u0Var.g() == null || !this.f55050a.mContentProcessController.g().d()) {
                    return !this.f55050a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.f55050a;
                pbFragment.showToast(pbFragment.mContentProcessController.g().c());
                if (this.f55050a.D0 != null && this.f55050a.D0.P0() != null && this.f55050a.D0.P0().b() != null && this.f55050a.D0.P0().b().y()) {
                    this.f55050a.D0.P0().b().w(this.f55050a.mContentProcessController.h());
                }
                this.f55050a.mContentProcessController.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements c.a.q0.d1.q<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55051a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f55052b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55053c;

        public e(PbFragment pbFragment, int i2, int i3) {
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
            this.f55053c = pbFragment;
            this.f55051a = i2;
            this.f55052b = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.f55051a);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f55053c.getContext(), this.f55052b, shareItem, false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55054a;

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
            this.f55054a = pbFragment;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i2, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, obj}) == null) {
                this.f55054a.D0.h1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i2 == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.f55054a.R3(num.intValue());
                    } else if (i2 == 1990055) {
                        TiebaStatic.log("c12142");
                        c.a.r0.e1.a.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.f55054a.getResources().getString(R.string.neterror);
                        }
                        this.f55054a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e1 extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55055a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e1(PbFragment pbFragment, int i2, int i3) {
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
            this.f55055a = pbFragment;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView Y0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.f55055a.f55017e.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    c.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                    if (this.f55055a.D0 == null || (Y0 = this.f55055a.D0.Y0()) == null || this.f55055a.D0.G0() == null) {
                        return;
                    }
                    this.f55055a.D0.G0().removeHeaderView(Y0);
                    return;
                }
                c.a.e.e.p.l.M(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e2 implements c.a.e.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55056a;

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
            this.f55056a = pbFragment;
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
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f55056a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f55056a.getVoiceManager());
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
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55057a;

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
            this.f55057a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55057a.w0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.f55057a.R0 != null) {
                this.f55057a.D0.x2(this.f55057a.R0.E());
            }
            this.f55057a.D0.q2();
            this.f55057a.D0.e0();
        }
    }

    /* loaded from: classes7.dex */
    public class f0 extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55058a;

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
            this.f55058a = pbFragment;
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
    public class f1 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55059a;

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
            this.f55059a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2) {
            long j3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j2)}) == null) && c.a.q0.q0.k.d().g()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.f55059a.r : j2;
                if (this.f55059a.s == 0) {
                    this.f55059a.s = currentTimeMillis;
                }
                long j4 = currentTimeMillis;
                c.a.q0.q0.h hVar = new c.a.q0.q0.h(i2, z, responsedMessage, this.f55059a.v, this.f55059a.u, this.f55059a.s, z2, 0L, 0L, j4);
                this.f55059a.u = 0L;
                this.f55059a.v = 0L;
                hVar.c();
                if (z2) {
                    j3 = j4;
                    hVar.B = j3;
                    hVar.e(true);
                } else {
                    j3 = j4;
                }
                if (z2 || this.f55059a.w0 == null || this.f55059a.w0.P0() == null || this.f55059a.w0.P0().O() == null) {
                    return;
                }
                int o1 = this.f55059a.w0.P0().O().o1();
                if (o1 == 0 || o1 == 40) {
                    if (!StringHelper.equals(this.f55059a.Q, "from_personalize")) {
                        if (StringHelper.equals(this.f55059a.Q, "from_frs")) {
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
        public void b(c.a.r0.k2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                this.f55059a.D0.u1(eVar);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, c.a.r0.k2.h.e eVar, String str, int i5) {
            c.a.q0.x.h findLauncherById;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
                if (!z || eVar == null || eVar.W() != null || ListUtils.getCount(eVar.F()) >= 1) {
                    if (!this.f55059a.p0) {
                        this.f55059a.p0 = true;
                    } else if (this.f55059a.getPbModel() != null) {
                        this.f55059a.getPbModel().X();
                    }
                    this.f55059a.l = true;
                    this.f55059a.D0.R2();
                    if (eVar == null || !eVar.l0()) {
                        PbFragment pbFragment = this.f55059a;
                        pbFragment.hideLoadingView(pbFragment.D0.b1());
                    }
                    this.f55059a.D0.j1();
                    if (this.f55059a.N || this.f55059a.D0.G1()) {
                        this.f55059a.D0.d1();
                    } else if (!this.f55059a.D0.z1()) {
                        this.f55059a.D0.e3(false);
                    }
                    if (this.f55059a.m) {
                        this.f55059a.m = false;
                    }
                    if (i5 == 0 && eVar != null) {
                        this.f55059a.K0 = true;
                    }
                    if (eVar != null) {
                        PbFragment pbFragment2 = this.f55059a;
                        pbFragment2.hideNetRefreshView(pbFragment2.D0.b1());
                        this.f55059a.D0.Z2();
                    }
                    ArrayList<PostData> arrayList = null;
                    String S0 = null;
                    arrayList = null;
                    if (z && eVar != null) {
                        c.a.q0.s.q.d2 O = eVar.O();
                        if (O != null && O.D2()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.f55059a;
                            pbFragment3.B3(pbFragment3.Q0);
                        }
                        this.f55059a.D0.P0().l(eVar);
                        this.f55059a.D0.l3();
                        if (O != null && O.M() != null) {
                            this.f55059a.d4(O.M());
                        }
                        if (this.f55059a.R0 != null) {
                            this.f55059a.D0.x2(this.f55059a.R0.E());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(eVar.U().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.U().getBimg_end_time());
                        if (eVar.F() != null && eVar.F().size() >= 1 && eVar.F().get(0) != null) {
                            this.f55059a.w0.b2(eVar.F().get(0).E());
                        } else if (eVar.W() != null) {
                            this.f55059a.w0.b2(eVar.W().E());
                        }
                        if (this.f55059a.R0 != null) {
                            this.f55059a.R0.O(eVar.d());
                            this.f55059a.R0.P(eVar.m(), eVar.U());
                            this.f55059a.R0.t0(O);
                            this.f55059a.R0.Q(this.f55059a.w0.s0(), this.f55059a.w0.f1(), this.f55059a.w0.p0());
                            if (O != null) {
                                this.f55059a.R0.j0(O.l2());
                            }
                        }
                        if (this.f55059a.y0 != null) {
                            this.f55059a.y0.h(eVar.s());
                        }
                        if (eVar.t() == 1) {
                            this.f55059a.w = true;
                        } else {
                            this.f55059a.w = false;
                        }
                        if (eVar.f0()) {
                            this.f55059a.w = true;
                        }
                        this.f55059a.D0.y2(this.f55059a.w);
                        this.f55059a.D0.p3(eVar, i3, i4, this.f55059a.w0.d1(), i5, this.f55059a.w0.z0());
                        this.f55059a.D0.B3(eVar, this.f55059a.w0.d1());
                        this.f55059a.D0.G3(this.f55059a.w0.t0());
                        AntiData d2 = eVar.d();
                        if (d2 != null) {
                            this.f55059a.D = d2.getVoice_message();
                            if (!StringUtils.isNull(this.f55059a.D) && this.f55059a.R0 != null && this.f55059a.R0.a() != null && (findLauncherById = this.f55059a.R0.a().findLauncherById(6)) != null && !TextUtils.isEmpty(this.f55059a.D)) {
                                ((View) findLauncherById).setOnClickListener(this.f55059a.A1);
                            }
                        }
                        if (!this.f55059a.c0 && !ListUtils.isEmpty(this.f55059a.w0.P0().F()) && !this.f55059a.w0.r1()) {
                            this.f55059a.c0 = true;
                            this.f55059a.checkEasterEgg(false);
                        }
                        if (!TextUtils.isEmpty(this.f55059a.N0)) {
                            c.a.r0.k2.k.e.a1.k.f(this.f55059a.getListView(), this.f55059a.N0);
                            this.f55059a.N0 = null;
                        } else if (this.f55059a.M0) {
                            this.f55059a.M0 = false;
                            c.a.r0.k2.k.e.a1.k.e(this.f55059a.getListView());
                        } else if (this.f55059a.O0) {
                            this.f55059a.O0 = false;
                            c.a.r0.k2.k.e.a1.k.g(this.f55059a.getListView());
                        } else {
                            this.f55059a.D0.k3();
                        }
                        this.f55059a.w0.z1(eVar.m(), this.f55059a.E1);
                        this.f55059a.w0.F1(this.f55059a.G1);
                        if (this.f55059a.mReplyPrivacyController != null && O != null && O.J() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.J());
                            this.f55059a.mReplyPrivacyController.setLikeUserData(attentionHostData);
                        }
                        if (this.f55059a.w0 == null || !this.f55059a.w0.q1()) {
                            if (this.f55059a.D0 != null) {
                                S0 = this.f55059a.D0.S0();
                            }
                        } else {
                            S0 = this.f55059a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                        }
                        if (!StringUtils.isNull(S0)) {
                            this.f55059a.R0.m0(TbSingleton.getInstance().getAdVertiComment(eVar.j0(), eVar.k0(), S0));
                        }
                    } else if (str != null) {
                        if (this.f55059a.K0 || i5 != 1) {
                            this.f55059a.showToast(str);
                        } else if (i3 == 3 || i3 == 4 || i3 == 6) {
                            if (i2 == 4) {
                                if (this.f55059a.w0.g0() != null && !StringUtils.isNull(this.f55059a.w0.g0().f19799c)) {
                                    this.f55059a.D0.I3(this.f55059a.w0.g0());
                                } else {
                                    PbFragment pbFragment4 = this.f55059a;
                                    pbFragment4.showNetRefreshView(pbFragment4.D0.b1(), this.f55059a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                                    PbFragment pbFragment5 = this.f55059a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(c.a.e.e.p.l.g(pbFragment5.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment pbFragment6 = this.f55059a;
                                pbFragment6.showNetRefreshView(pbFragment6.D0.b1(), this.f55059a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                                PbFragment pbFragment7 = this.f55059a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(c.a.e.e.p.l.g(pbFragment7.getContext(), R.dimen.ds360));
                            }
                            this.f55059a.D0.d1();
                            this.f55059a.D0.c1();
                        }
                        if (i2 == 4 || i2 == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.f55059a.w0.f1());
                                jSONObject.put("fid", this.f55059a.w0.getForumId());
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
                            if (this.f55059a.w0 != null && this.f55059a.w0.P0() != null) {
                                arrayList = this.f55059a.w0.P0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f55059a.D0.u2(this.f55059a.getResources().getString(R.string.list_no_more_new));
                            } else {
                                if (this.f55059a.isHostOnlyMode()) {
                                    this.f55059a.D0.v2(this.f55059a.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    this.f55059a.D0.v2(this.f55059a.getResources().getString(R.string.pb_no_replay));
                                }
                                this.f55059a.D0.u1(this.f55059a.w0.P0());
                            }
                        } else {
                            this.f55059a.D0.u2("");
                        }
                        this.f55059a.D0.k0();
                    }
                    if (eVar != null && eVar.m && this.f55059a.s == 0) {
                        this.f55059a.s = System.currentTimeMillis() - this.f55059a.r;
                    }
                    if (this.f55059a.getPbModel().d1() && this.f55059a.getPbModel().P0().y().c() == 0 && !this.f55059a.getPbModel().p1()) {
                        return;
                    }
                    this.f55059a.S0 = true;
                    return;
                }
                this.f55059a.w0.n2(1);
                if (this.f55059a.f55021i != null) {
                    this.f55059a.f55021i.x();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f55059a.w0 == null) {
                return;
            }
            if (this.f55059a.R0 == null || !this.f55059a.R0.z) {
                c.a.q0.x.x.d dVar = new c.a.q0.x.x.d();
                this.f55059a.B3(dVar);
                PbFragment pbFragment = this.f55059a;
                pbFragment.R0 = (c.a.q0.x.x.e) dVar.a(pbFragment.getContext());
                this.f55059a.R0.g0(this.f55059a.f55017e.getPageContext());
                this.f55059a.R0.p0(this.f55059a.W1);
                this.f55059a.R0.q0(this.f55059a.X0);
                this.f55059a.R0.H(this.f55059a.f55017e.getPageContext(), this.f55059a.f55017e.getIntent() == null ? null : this.f55059a.f55017e.getIntent().getExtras());
                this.f55059a.R0.a().showLinePositionBottom(true);
                this.f55059a.D0.t2(this.f55059a.R0.a());
                if (!this.f55059a.w0.D0()) {
                    this.f55059a.R0.t(this.f55059a.w0.f1());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.f55059a.R0.m0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.f55059a.w0.q1()) {
                    this.f55059a.R0.m0(this.f55059a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else if (this.f55059a.D0 != null) {
                    this.f55059a.R0.m0(this.f55059a.D0.S0());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f2 implements c.a.e.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55060a;

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
            this.f55060a = pbFragment;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f55060a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55061a;

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
            this.f55061a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.f55061a.w0.v2((UserPendantData) customResponsedMessage.getData());
                if (this.f55061a.D0 != null && this.f55061a.w0 != null) {
                    this.f55061a.D0.k2(this.f55061a.w0.P0(), this.f55061a.w0.d1(), this.f55061a.w0.Z0(), this.f55061a.D0.W0());
                }
                if (this.f55061a.D0 == null || this.f55061a.D0.p0() == null) {
                    return;
                }
                this.f55061a.D0.p0().X();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements b3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55062a;

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
            this.f55062a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.b3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!c.a.e.e.p.j.z()) {
                    this.f55062a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f55062a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f55062a.getPageContext().getPageActivity(), this.f55062a.w0.P0().m().getId(), this.f55062a.w0.P0().m().getName(), this.f55062a.w0.P0().O().f0(), String.valueOf(this.f55062a.w0.P0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55063a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g1(PbFragment pbFragment, int i2) {
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
            this.f55063a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f55063a.c4();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g2 implements c.a.e.e.k.c<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55064a;

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
            this.f55064a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ ItemCardView c(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            h(itemCardView2);
            return itemCardView2;
        }

        public ItemCardView e(ItemCardView itemCardView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, itemCardView)) == null) {
                itemCardView.onChangeSkinType();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public ItemCardView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ItemCardView(this.f55064a.getPageContext().getPageActivity()) : (ItemCardView) invokeV.objValue;
        }

        public ItemCardView h(ItemCardView itemCardView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, itemCardView)) == null) {
                itemCardView.reset();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55065a;

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
            this.f55065a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.f55065a.D0 == null) {
                return;
            }
            if (booleanValue) {
                this.f55065a.D0.w3();
            } else {
                this.f55065a.D0.j1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55066a;

        public h0(PbFragment pbFragment) {
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
            this.f55066a = pbFragment;
        }

        @Override // c.a.r0.k2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.k2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f55066a.isAdded()) {
                    if (view != null) {
                        if (view.getId() == R.id.richText) {
                            if (this.f55066a.richTextHandleSingleTap(view)) {
                                return true;
                            }
                        } else if (view.getId() == R.id.pb_floor_item_layout) {
                            if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                                this.f55066a.V3((SparseArray) view.getTag(R.id.tag_from));
                            }
                        } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                            if (this.f55066a.D0.B1() && view.getId() == R.id.pb_head_user_info_root) {
                                if (view.getTag(R.id.tag_user_id) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view.getTag(R.id.tag_user_id)));
                                }
                                if (this.f55066a.getEventController() != null && this.f55066a.getEventController().f20137b != null) {
                                    this.f55066a.getEventController().f20137b.onClick(view);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.f55066a.V3(sparseArray);
                        }
                    }
                    if (this.f55066a.R0 != null) {
                        this.f55066a.D0.x2(this.f55066a.R0.E());
                    }
                    this.f55066a.D0.q2();
                    this.f55066a.D0.e0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.k2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.f55066a.isAdded()) {
                    this.f55066a.doDoubleClick();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h1 implements c.a.q0.x.x.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55067a;

        public h1(PbFragment pbFragment) {
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
            this.f55067a = pbFragment;
        }

        @Override // c.a.q0.x.x.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55067a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h2 implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55068a;

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
            this.f55068a = pbFragment;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            c.a.r0.k2.k.e.h p0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view.getTag() instanceof TbRichText) && str == null) {
                        if (this.f55068a.checkUpIsLogin()) {
                            this.f55068a.D0.P1((TbRichText) view.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.f55068a.w0.f1());
                    statisticItem.param("fid", this.f55068a.w0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.f55068a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        if (this.f55068a.w0.J.f0()) {
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
                            this.f55068a.K2(rect);
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i3);
                            bVar.C(false);
                            bVar.F(this.f55068a.w0.a1());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.f55068a.isHostOnlyMode());
                            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
                            if (this.f55068a.w0 != null) {
                                bVar.A(this.f55068a.w0.getFromForumId());
                                if (this.f55068a.w0.P0() != null) {
                                    bVar.N(this.f55068a.w0.P0().O());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.f55068a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.f55068a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.f55068a.s3(str, i2, eVar);
                        if (eVar.f54991h) {
                            TbRichText f4 = this.f55068a.f4(str, i2);
                            if (f4 != null && this.f55068a.i2 >= 0 && this.f55068a.i2 < f4.y().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a2 = c.a.r0.k2.h.f.a(f4.y().get(this.f55068a.i2));
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= eVar.f54984a.size()) {
                                        break;
                                    } else if (eVar.f54984a.get(i7).equals(a2)) {
                                        eVar.f54993j = i7;
                                        arrayList2.add(a2);
                                        break;
                                    } else {
                                        i7++;
                                    }
                                }
                                if (f4.getPostId() != 0 && (p0 = this.f55068a.D0.p0()) != null) {
                                    ArrayList<c.a.e.l.e.n> s = p0.s();
                                    if (ListUtils.getCount(s) > 0) {
                                        Iterator<c.a.e.l.e.n> it = s.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            c.a.e.l.e.n next = it.next();
                                            if ((next instanceof PostData) && f4.getPostId() == c.a.e.e.m.b.g(((PostData) next).E(), 0L)) {
                                                c.a.r0.k2.m.a.b(this.f55068a.w0.P0(), (PostData) next, ((PostData) next).i0, f4.getPostId() == c.a.e.e.m.b.g(this.f55068a.w0.p0(), 0L) ? 1 : 8, 3);
                                            }
                                        }
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.f54985b.get(str2));
                                }
                                Rect rect2 = new Rect();
                                view.getGlobalVisibleRect(rect2);
                                this.f55068a.K2(rect2);
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.f54986c);
                                bVar2.y(eVar.f54987d);
                                bVar2.O(eVar.f54988e);
                                bVar2.C(eVar.f54990g);
                                bVar2.H(true);
                                bVar2.J(eVar.f54992i);
                                bVar2.F(this.f55068a.w0.a1());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.f55068a.isHostOnlyMode());
                                bVar2.L(eVar.f54989f);
                                bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                                if (this.f55068a.w0 != null) {
                                    bVar2.A(this.f55068a.w0.getFromForumId());
                                    if (this.f55068a.w0.P0() != null) {
                                        bVar2.N(this.f55068a.w0.P0().O());
                                    }
                                }
                                ImageViewerConfig v2 = bVar2.v(this.f55068a.getPageContext().getPageActivity());
                                v2.getIntent().putExtra("from", "pb");
                                this.f55068a.sendMessage(new CustomMessage(2010000, v2));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.f54984a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.f54985b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.f54986c);
                        bVar3.y(eVar.f54987d);
                        bVar3.O(eVar.f54988e);
                        bVar3.C(eVar.f54990g);
                        bVar3.H(true);
                        bVar3.J(eVar.f54984a.get(0));
                        bVar3.F(this.f55068a.w0.a1());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.f55068a.isHostOnlyMode());
                        bVar3.L(eVar.f54989f);
                        bVar3.D(false);
                        if (this.f55068a.w0 != null) {
                            bVar3.A(this.f55068a.w0.getFromForumId());
                            if (this.f55068a.w0.P0() != null) {
                                bVar3.N(this.f55068a.w0.P0().O());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.f55068a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.f55068a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.f55068a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.f55068a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    this.f55068a.W = view;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55069a;

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
            this.f55069a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f55069a.R0 != null) {
                this.f55069a.D0.x2(this.f55069a.R0.E());
            }
            this.f55069a.D0.e3(false);
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55070a;

        public i0(PbFragment pbFragment) {
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
            this.f55070a = pbFragment;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f55070a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.f55070a;
                    pbFragment.J0 = pbFragment.J0.trim();
                    UtilHelper.callPhone(this.f55070a.getPageContext().getPageActivity(), this.f55070a.J0);
                    new c.a.r0.k2.k.e.c(this.f55070a.w0.f1(), this.f55070a.J0, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f55070a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    PbFragment pbFragment2 = this.f55070a;
                    pbFragment2.J0 = pbFragment2.J0.trim();
                    UtilHelper.smsPhone(this.f55070a.getPageContext().getPageActivity(), this.f55070a.J0);
                    new c.a.r0.k2.k.e.c(this.f55070a.w0.f1(), this.f55070a.J0, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    PbFragment pbFragment3 = this.f55070a;
                    pbFragment3.J0 = pbFragment3.J0.trim();
                    UtilHelper.startBaiDuBar(this.f55070a.getPageContext().getPageActivity(), this.f55070a.J0);
                    bVar.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55071a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i1(PbFragment pbFragment, int i2, boolean z) {
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
            this.f55071a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f55071a.D0 != null) {
                    PbFragment pbFragment = this.f55071a;
                    pbFragment.hideLoadingView(pbFragment.D0.b1());
                    this.f55071a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            new BdTopToast(this.f55071a.getContext()).setIcon(true).setContent(this.f55071a.getString(R.string.block_user_success)).show((ViewGroup) this.f55071a.getView());
                            this.f55071a.C3(type);
                            return;
                        }
                        new BdTopToast(this.f55071a.getContext()).setIcon(false).setContent(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f55071a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString()).show((ViewGroup) this.f55071a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i2 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55072a;

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
            this.f55072a = pbFragment;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                PbFragment pbFragment = this.f55072a;
                PostData postData = pbFragment.l2;
                if (postData != null) {
                    if (i2 == 0) {
                        postData.j0(pbFragment.getPageContext().getPageActivity());
                        this.f55072a.l2 = null;
                    } else if (i2 == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.f55072a;
                        pbFragment2.markFloor(pbFragment2.l2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55073a;

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
            this.f55073a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            c.a.r0.k2.e eVar = (c.a.r0.k2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                this.f55073a.refreshWrite((c.a.r0.k2.h.r) eVar.a());
            } else if (b2 == 1) {
                this.f55073a.I2((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    this.f55073a.refreshMark(false, null);
                } else {
                    this.f55073a.refreshMark(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55074a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(PbFragment pbFragment, int i2) {
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
            this.f55074a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f55074a.e1) {
                this.f55074a.D0.h1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                c.a.r0.k2.h.e P0 = this.f55074a.w0.P0();
                if (P0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    P0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f55074a.d1.c(this.f55074a.c1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f55074a.c1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.f55074a.S3(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f55074a.N3();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (c.a.e.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f55074a.c1.getResources().getString(R.string.mute_fail);
                    }
                    this.f55074a.d1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j1 implements a.InterfaceC0669a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55075a;

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
            this.f55075a = pbFragment;
        }

        @Override // c.a.q0.i.a.InterfaceC0669a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f55075a.D0.R2();
                if (z) {
                    if (this.f55075a.y0 != null) {
                        this.f55075a.y0.h(z2);
                    }
                    this.f55075a.w0.p2(z2);
                    if (this.f55075a.w0.B0()) {
                        this.f55075a.n3();
                    } else {
                        this.f55075a.D0.u1(this.f55075a.w0.P0());
                    }
                    if (z2) {
                        if (this.f55075a.y0 != null) {
                            if (this.f55075a.y0.f() == null || this.f55075a.w0 == null || this.f55075a.w0.P0() == null || this.f55075a.w0.P0().O() == null || this.f55075a.w0.P0().O().J() == null) {
                                return;
                            }
                            MarkData f2 = this.f55075a.y0.f();
                            MetaData J = this.f55075a.w0.P0().O().J();
                            if (f2 != null && J != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), J.getUserId()) && !J.hadConcerned()) {
                                    this.f55075a.M3(J);
                                } else {
                                    this.f55075a.showToast(R.string.add_mark_on_pb);
                                    if (c.a.q0.t.h.a.e(this.f55075a.getContext(), 0)) {
                                        c.a.q0.t.h.a.g(this.f55075a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment pbFragment = this.f55075a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                            }
                        }
                        this.f55075a.y2();
                        return;
                    }
                    PbFragment pbFragment2 = this.f55075a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                PbFragment pbFragment3 = this.f55075a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55076a;

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
            this.f55076a = pbFragment;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.f55076a.h1 == null || TextUtils.isEmpty(this.f55076a.i1)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f55076a.j1 == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f55076a.i1));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f12822a = this.f55076a.i1;
                        String str = "";
                        if (this.f55076a.j1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f55076a.j1.memeInfo.pck_id;
                        }
                        aVar.f12823b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f55076a.T0 == null) {
                        this.f55076a.T0 = new PermissionJudgePolicy();
                    }
                    this.f55076a.T0.clearRequestPermissionList();
                    this.f55076a.T0.appendRequestPermission(this.f55076a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.f55076a.T0.startRequestPermission(this.f55076a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f55076a.g1 == null) {
                        PbFragment pbFragment = this.f55076a;
                        pbFragment.g1 = new c.a.r0.k2.k.e.w0(pbFragment.getPageContext());
                    }
                    this.f55076a.g1.b(this.f55076a.i1, this.f55076a.h1.n());
                }
                this.f55076a.h1 = null;
                this.f55076a.i1 = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55077a;

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
            this.f55077a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55077a.D0 == null || this.f55077a.D0.p0() == null) {
                return;
            }
            this.f55077a.D0.p0().X();
        }
    }

    /* loaded from: classes7.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55078a;

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
            this.f55078a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f55078a.e1) {
                this.f55078a.D0.h1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f55078a.d1.c(this.f55078a.c1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (c.a.e.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f55078a.c1.getResources().getString(R.string.un_mute_fail);
                }
                this.f55078a.d1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f55079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55080f;

        public k1(PbFragment pbFragment, MetaData metaData) {
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
            this.f55080f = pbFragment;
            this.f55079e = metaData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f55079e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k2 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55081e;

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
            this.f55081e = pbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f55081e.w0 == null || this.f55081e.w0.Y0() == i2 + 1) {
                return;
            }
            PbFragment pbFragment = this.f55081e;
            pbFragment.A3(pbFragment.U2(i2));
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55082a;

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
            this.f55082a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                c.a.q0.f1.m.f.c(this.f55082a.getPageContext(), this.f55082a, aVar.f13288a, aVar.f13289b, aVar.f13290c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55083e;

        public l0(PbFragment pbFragment) {
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
            this.f55083e = pbFragment;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.f55083e.w0 != null && this.f55083e.w0.B0()) {
                    this.f55083e.n3();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f55084e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55085f;

        public l1(PbFragment pbFragment, MetaData metaData) {
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
            this.f55085f = pbFragment;
            this.f55084e = metaData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f55084e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                this.f55085f.A0.m(!this.f55084e.hadConcerned(), this.f55084e.getPortrait(), this.f55084e.getUserId(), this.f55084e.isGod(), "6", this.f55085f.getPageContext().getUniqueId(), this.f55085f.w0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55086e;

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
            this.f55086e = pbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                PbFragment pbFragment = this.f55086e;
                pbFragment.f55018f = true;
                return pbFragment.F2(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55087a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(PbFragment pbFragment, int i2) {
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
            this.f55087a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55087a.k) {
                return;
            }
            this.f55087a.U3();
        }
    }

    /* loaded from: classes7.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55088a;

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
            this.f55088a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.f55088a.e3() || this.f55088a.f55017e == null || this.f55088a.f55017e.getPbModel() == null || !str.equals(this.f55088a.f55017e.getPbModel().getTopicId())) {
                    return;
                }
                this.f55088a.a4(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55089e;

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
            this.f55089e = pbFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            ArrayList<PostData> F;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || this.f55089e.w0 == null || this.f55089e.w0.P0() == null || this.f55089e.D0 == null || this.f55089e.D0.p0() == null) {
                return;
            }
            this.f55089e.D0.V1(absListView, i2, i3, i4);
            if (this.f55089e.f55021i != null) {
                this.f55089e.f55021i.q(absListView, i2, i3, i4);
            }
            if (!this.f55089e.w0.s1() || (F = this.f55089e.w0.P0().F()) == null || F.isEmpty()) {
                return;
            }
            int w = ((i2 + i3) - this.f55089e.D0.p0().w()) - 1;
            c.a.r0.k2.h.e P0 = this.f55089e.w0.P0();
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
                PbFragment pbFragment = this.f55089e;
                if (!pbFragment.g3(pbFragment.a1) && this.f55089e.g3(i2)) {
                    if (this.f55089e.D0 != null) {
                        this.f55089e.D0.e0();
                        if (this.f55089e.R0 != null && !this.f55089e.D0.w1()) {
                            this.f55089e.D0.x2(this.f55089e.R0.E());
                        }
                        if (!this.f55089e.N) {
                            this.f55089e.D0.q2();
                        }
                    }
                    if (!this.f55089e.x) {
                        this.f55089e.x = true;
                    }
                }
                if (this.f55089e.D0 != null) {
                    this.f55089e.D0.W1(absListView, i2);
                }
                if (this.f55089e.f55021i != null) {
                    this.f55089e.f55021i.r(absListView, i2);
                }
                if (this.f55089e.y == null) {
                    this.f55089e.y = new c.a.q0.q0.b();
                    this.f55089e.y.a(1001);
                }
                if (i2 == 0) {
                    this.f55089e.y.e();
                } else {
                    this.f55089e.y.d();
                }
                this.f55089e.a1 = i2;
                if (i2 == 0) {
                    this.f55089e.y3(false, null);
                    c.a.r0.j3.c.g().h(this.f55089e.getUniqueId(), true);
                    this.f55089e.checkEasterEgg(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55090e;

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
            this.f55090e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.l(this.f55090e.getContext(), this.f55090e.getUniqueId(), view, (ViewGroup) this.f55090e.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55091a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(PbFragment pbFragment, int i2) {
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
            this.f55091a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.f55091a.getContext()).setIcon(false).setContent(this.f55091a.getString(R.string.novel_thread_mask_click_tip)).show((ViewGroup) this.f55091a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55092a;

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
            this.f55092a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.v3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f55092a.e1) {
                c.a.r0.v3.a aVar = (c.a.r0.v3.a) customResponsedMessage.getData();
                this.f55092a.D0.h1();
                SparseArray<Object> sparseArray = (SparseArray) this.f55092a.b1;
                DataRes dataRes = aVar.f25642a;
                if (aVar.f25644c == 0 && dataRes != null) {
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
                    this.f55092a.O3(r2, sparseArray);
                } else if (intValue == 1) {
                    this.f55092a.D0.c2(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements Comparator<c.a.q0.u.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55093e;

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
            this.f55093e = pbFragment;
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
    public class n2 implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55094a;

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
            this.f55094a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                ItemCardHelper.x(this.f55094a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.f55094a.getView(), j2);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.f55094a.getContext(), ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.f55094a.getView(), 0L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55095e;

        public o(PbFragment pbFragment) {
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
            this.f55095e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PbFragment pbFragment = this.f55095e;
                pbFragment.showToast(pbFragment.D);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55096a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(PbFragment pbFragment, int i2) {
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
            this.f55096a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f55096a.D0.w1() && (customResponsedMessage.getData() instanceof Integer)) {
                this.f55096a.doDoubleClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55097a;

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
            this.f55097a = pbFragment;
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
    public class o2 implements a3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55098a;

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
            this.f55098a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f55098a.D0 != null && this.f55098a.D0.P0() != null) {
                    c.a.r0.k2.k.e.t P0 = this.f55098a.D0.P0();
                    if (P0.f()) {
                        P0.d();
                        return true;
                    }
                }
                if (this.f55098a.D0 == null || !this.f55098a.D0.J1()) {
                    return false;
                }
                this.f55098a.D0.l1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class p implements TiePlusEventController.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55099a;

        public p(PbFragment pbFragment) {
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
            this.f55099a = pbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.d
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55099a.A = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55100a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(PbFragment pbFragment, int i2) {
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
            this.f55100a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.r0.k3.i0.e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.r0.k3.i0.e) || (eVar = (c.a.r0.k3.i0.e) customResponsedMessage.getData()) == null || (agreeData = eVar.f21031b) == null || agreeData.agreeType != 2 || this.f55100a.D0 == null || !c.a.q0.b.d.T() || c.a.r0.k2.k.e.f1.b.k(this.f55100a.w0.f55227f)) {
                return;
            }
            this.f55100a.D0.x3();
            c.a.r0.k2.k.e.f1.b.b(this.f55100a.w0.f55227f);
        }
    }

    /* loaded from: classes7.dex */
    public class p1 extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55101a;

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
            this.f55101a = pbFragment;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.f55101a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.f55101a.z0.getLoadDataMode()) {
                        case 0:
                            this.f55101a.w0.n1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.f55101a.I2(bVar, (bVar.f57180e != 1002 || bVar.f57181f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.f55101a.D0.m0(1, dVar.f57184a, dVar.f57185b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.f55101a;
                            pbFragment.J2(pbFragment.z0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.f55101a.D0.m0(this.f55101a.z0.getLoadDataMode(), gVar.f57198a, gVar.f57199b, false);
                            this.f55101a.D0.X1(gVar.f57200c);
                            return;
                        default:
                            return;
                    }
                }
                this.f55101a.D0.m0(this.f55101a.z0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p2 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55102e;

        public p2(PbFragment pbFragment) {
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
            this.f55102e = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.f55102e.k && z && !this.f55102e.w0.F0()) {
                    this.f55102e.v3();
                }
                PbFragment pbFragment = this.f55102e;
                pbFragment.setNetRefreshViewEmotionMarginTop(c.a.e.e.p.l.g(pbFragment.getContext(), R.dimen.ds360));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55103a;

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
            this.f55103a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.s.q.j0)) {
                c.a.q0.s.q.j0 j0Var = (c.a.q0.s.q.j0) customResponsedMessage.getData();
                d1.a aVar = new d1.a();
                int i2 = j0Var.f14243a;
                String str = j0Var.f14244b;
                aVar.f14158a = j0Var.f14246d;
                c.a.r0.k2.h.e P0 = this.f55103a.w0.P0();
                if (P0 == null) {
                    return;
                }
                if (this.f55103a.w0.s0() != null && this.f55103a.w0.s0().getUserIdLong() == j0Var.p) {
                    this.f55103a.D0.j2(j0Var.l, this.f55103a.w0.P0(), this.f55103a.w0.d1(), this.f55103a.w0.Z0());
                }
                if (P0.F() == null || P0.F().size() < 1 || P0.F().get(0) == null) {
                    return;
                }
                long g2 = c.a.e.e.m.b.g(P0.F().get(0).E(), 0L);
                long g3 = c.a.e.e.m.b.g(this.f55103a.w0.f1(), 0L);
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
                    this.f55103a.D0.p0().X();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55104a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(PbFragment pbFragment, int i2) {
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
            this.f55104a = pbFragment;
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
            this.f55104a.k1 = true;
        }
    }

    /* loaded from: classes7.dex */
    public class q1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55105e;

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
            this.f55105e = pbFragment;
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
    public class q2 implements c.a.e.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55106a;

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
            this.f55106a = pbFragment;
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
                LinearLayout linearLayout = new LinearLayout(this.f55106a.getPageContext().getPageActivity());
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
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55107a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(PbFragment pbFragment, int i2) {
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
            this.f55107a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f55107a.w0 == null || this.f55107a.w0.P0() == null) {
                return;
            }
            this.f55107a.w0.P0().a();
            this.f55107a.w0.n1();
            if (this.f55107a.D0.p0() != null) {
                this.f55107a.D0.u1(this.f55107a.w0.P0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55108e;

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
            this.f55108e = pbFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f55108e.hideKeyBroad();
                c.a.q0.s.q.b1 N0 = this.f55108e.w0.N0();
                int M0 = this.f55108e.D0.M0();
                if (M0 <= 0) {
                    this.f55108e.showToast(R.string.pb_page_error);
                } else if (N0 == null || M0 <= N0.h()) {
                    this.f55108e.D0.e0();
                    this.f55108e.stopVoice();
                    this.f55108e.D0.S2();
                    if (c.a.e.e.p.j.z()) {
                        this.f55108e.w0.n2(this.f55108e.D0.M0());
                        if (this.f55108e.f55021i != null) {
                            this.f55108e.f55021i.x();
                        }
                    } else {
                        this.f55108e.showToast(R.string.neterror);
                    }
                    aVar.dismiss();
                } else {
                    this.f55108e.showToast(R.string.pb_page_error);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r1 implements c3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55109a;

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
            this.f55109a = pbFragment;
        }
    }

    /* loaded from: classes7.dex */
    public class r2 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55110e;

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
            this.f55110e = pbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                FrameLayout frameLayout = (FrameLayout) this.f55110e.getPageContext().getPageActivity().getWindow().getDecorView();
                for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                    View childAt = frameLayout.getChildAt(i2);
                    if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                        break;
                    }
                }
                this.f55110e.f55020h.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55111a;

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
            this.f55111a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f55111a.w0 == null || this.f55111a.w0.P0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.f55111a.G2(str);
            this.f55111a.w0.n1();
            if (!TextUtils.isEmpty(str) && this.f55111a.w0.P0().F() != null) {
                ArrayList<PostData> F = this.f55111a.w0.P0().F();
                c.a.r0.k3.i0.p pVar = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof c.a.r0.k3.i0.p) {
                        c.a.r0.k3.i0.p pVar2 = (c.a.r0.k3.i0.p) next;
                        if (str.equals(pVar2.F0())) {
                            pVar = pVar2;
                            break;
                        }
                    }
                }
                if (pVar != null) {
                    F.remove(pVar);
                    if (this.f55111a.D0.p0() != null && this.f55111a.D0.p0().s() != null) {
                        this.f55111a.D0.p0().s().remove(pVar);
                    }
                    if (this.f55111a.D0.G0() != null && this.f55111a.D0.G0().getData() != null) {
                        this.f55111a.D0.G0().getData().remove(pVar);
                    }
                    if (this.f55111a.D0.p0() != null) {
                        this.f55111a.D0.p0().X();
                        return;
                    }
                }
            }
            if (this.f55111a.D0.p0() != null) {
                this.f55111a.D0.u1(this.f55111a.w0.P0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55112e;

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
            this.f55112e = pbFragment;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f55112e.H0 != null) {
                    this.f55112e.H0.dismiss();
                }
                this.f55112e.b4(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                        this.f55112e.u3(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                        this.f55112e.u3(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view4 != null) {
                            AgreeView agreeView = (AgreeView) view4;
                            this.f55112e.u3(view4);
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
                            this.f55112e.u3(view5);
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
                        if (this.f55112e.h1 == null || TextUtils.isEmpty(this.f55112e.i1)) {
                            return;
                        }
                        if (this.f55112e.j1 == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f55112e.i1));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f12822a = this.f55112e.i1;
                            String str = "";
                            if (this.f55112e.j1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f55112e.j1.memeInfo.pck_id;
                            }
                            aVar.f12823b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f55112e.h1 = null;
                        this.f55112e.i1 = null;
                        return;
                    case 2:
                        if (this.f55112e.h1 == null || TextUtils.isEmpty(this.f55112e.i1)) {
                            return;
                        }
                        if (this.f55112e.T0 == null) {
                            this.f55112e.T0 = new PermissionJudgePolicy();
                        }
                        this.f55112e.T0.clearRequestPermissionList();
                        this.f55112e.T0.appendRequestPermission(this.f55112e.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f55112e.T0.startRequestPermission(this.f55112e.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f55112e.g1 == null) {
                            PbFragment pbFragment = this.f55112e;
                            pbFragment.g1 = new c.a.r0.k2.k.e.w0(pbFragment.getPageContext());
                        }
                        this.f55112e.g1.b(this.f55112e.i1, this.f55112e.h1.n());
                        this.f55112e.h1 = null;
                        this.f55112e.i1 = null;
                        return;
                    case 3:
                        PbFragment pbFragment2 = this.f55112e;
                        PostData postData = pbFragment2.l2;
                        if (postData != null) {
                            postData.j0(pbFragment2.getPageContext().getPageActivity());
                            this.f55112e.l2 = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f55112e.checkUpIsLogin()) {
                            this.f55112e.p3(view);
                            if (this.f55112e.w0.P0().O() == null || this.f55112e.w0.P0().O().J() == null || this.f55112e.w0.P0().O().J().getUserId() == null || this.f55112e.y0 == null) {
                                return;
                            }
                            PbFragment pbFragment3 = this.f55112e;
                            int V2 = pbFragment3.V2(pbFragment3.w0.P0());
                            c.a.q0.s.q.d2 O = this.f55112e.w0.P0().O();
                            if (O.M1()) {
                                i3 = 2;
                            } else if (O.P1()) {
                                i3 = 3;
                            } else if (!O.N1()) {
                                i3 = O.O1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f55112e.w0.f55227f).param("obj_locate", 2).param("obj_id", this.f55112e.w0.P0().O().J().getUserId()).param("obj_type", !this.f55112e.y0.e()).param("obj_source", V2).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!c.a.e.e.p.j.z()) {
                            this.f55112e.showToast(R.string.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f55112e.X2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.f55112e.checkMuteState(sparseArray2);
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
                            boolean isHost = this.f55112e.getPbActivity().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f55112e.H3(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f55112e.D0.a2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f55112e.H3(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f55112e.D0.Y1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!c.a.e.e.p.j.z()) {
                            this.f55112e.showToast(R.string.network_not_available);
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
                                this.f55112e.D0.Y1(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.tag_from, 1);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f55112e.checkMuteState(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f55112e.D0.d2(view);
                            return;
                        }
                    case 8:
                        if (this.f55112e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.f55112e.D2(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.f55112e.checkUpIsLogin() || this.f55112e.w0 == null || this.f55112e.w0.P0() == null) {
                            return;
                        }
                        this.f55112e.f55017e.showBlockDialog(c.a.r0.u3.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements c.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55113a;

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
            this.f55113a = pbFragment;
        }

        @Override // c.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.k2.k.e.u0 u0Var = this.f55113a.mContentProcessController;
                if (u0Var == null || u0Var.e() == null || !this.f55113a.mContentProcessController.e().d()) {
                    return !this.f55113a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.f55113a;
                pbFragment.showToast(pbFragment.mContentProcessController.e().c());
                if (this.f55113a.R0 != null && (this.f55113a.R0.D() || this.f55113a.R0.F())) {
                    this.f55113a.R0.B(false, this.f55113a.mContentProcessController.h());
                }
                this.f55113a.mContentProcessController.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s2 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f55114a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55115b;

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
            this.f55115b = pbFragment;
            this.f55114a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);
        }

        @Override // c.a.r0.k0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || !e(i3) || this.f55115b.D0 == null || this.f55115b.f55021i == null) {
                return;
            }
            this.f55115b.f55021i.u(true);
            if (Math.abs(i3) > this.f55114a) {
                this.f55115b.f55021i.l();
            }
            if (this.f55115b.getIsMangaThread()) {
                this.f55115b.D0.i1();
                this.f55115b.D0.s2();
            }
        }

        @Override // c.a.r0.k0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || !e(i3) || this.f55115b.D0 == null || this.f55115b.f55021i == null) {
                return;
            }
            this.f55115b.D0.u3();
            this.f55115b.f55021i.u(false);
            this.f55115b.f55021i.x();
        }

        @Override // c.a.r0.k0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.r0.k0.a.b
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
    public class t implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55116a;

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
            this.f55116a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(c.a.r0.k2.k.e.b1.e.a aVar) {
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
    public class t0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f55117e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55118f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f55119g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55120h;

        public t0(PbFragment pbFragment, SparseArray sparseArray, int i2, boolean z) {
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
            this.f55120h = pbFragment;
            this.f55117e = sparseArray;
            this.f55118f = i2;
            this.f55119g = z;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f55120h.deleteThreadDirect(((Integer) this.f55117e.get(R.id.tag_del_post_type)).intValue(), (String) this.f55117e.get(R.id.tag_del_post_id), this.f55118f, this.f55119g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t1 implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55121e;

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
            this.f55121e = pbFragment;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f55121e.getIsMangaThread()) {
                    this.f55121e.f55017e.finish();
                }
                if (!this.f55121e.w0.E1(true)) {
                    this.f55121e.D0.l0();
                } else {
                    TiebaStatic.eventStat(this.f55121e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class t2 implements b.InterfaceC0945b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public t2() {
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

        @Override // c.a.r0.k0.b.InterfaceC0945b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.r0.k2.i.b.d();
                } else {
                    c.a.r0.k2.i.b.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55122a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(PbFragment pbFragment, int i2) {
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
            this.f55122a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.f55122a.D0 == null || this.f55122a.w0 == null) {
                return;
            }
            this.f55122a.D0.Y(false);
            if (this.f55122a.w0.A1(false)) {
                this.f55122a.D0.T2();
            } else if (this.f55122a.w0.P0() != null) {
                this.f55122a.D0.m2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55123e;

        public u0(PbFragment pbFragment) {
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
            this.f55123e = pbFragment;
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
    public class u1 implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55124e;

        public u1(PbFragment pbFragment) {
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
            this.f55124e = pbFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f55124e.g2 && this.f55124e.getIsMangaThread()) {
                    this.f55124e.j3();
                }
                if (this.f55124e.mIsLogin) {
                    if (!this.f55124e.o0 && this.f55124e.D0 != null && this.f55124e.D0.V() && this.f55124e.w0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.f55124e.w0.f1());
                        statisticItem.param("fid", this.f55124e.w0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i2 = 5;
                        if (this.f55124e.w0.v0()) {
                            i2 = 4;
                        } else if (this.f55124e.w0.w0()) {
                            i2 = 3;
                        } else if (this.f55124e.w0.y0()) {
                            i2 = 1;
                        }
                        statisticItem.param("obj_type", i2);
                        TiebaStatic.log(statisticItem);
                        this.f55124e.o0 = true;
                    }
                    if (this.f55124e.w0.A1(false)) {
                        this.f55124e.D0.T2();
                        TiebaStatic.eventStat(this.f55124e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if (this.f55124e.t0 == null || !this.f55124e.t0.d()) {
                        if (this.f55124e.w0.P0() != null) {
                            this.f55124e.D0.m2();
                        }
                    } else {
                        this.f55124e.D0.T2();
                    }
                    this.f55124e.g2 = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements p.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55125a;

        public u2(PbFragment pbFragment) {
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

        @Override // c.a.r0.k2.k.e.p.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i2 == 0) {
                        this.f55125a.showToast(R.string.upgrage_toast_dialog);
                    } else {
                        this.f55125a.showToast(R.string.neterror);
                    }
                } else if (i2 != 0 && !TextUtils.isEmpty(str2)) {
                    this.f55125a.D0.c0(str);
                } else {
                    this.f55125a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements GetSugMatchWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55126a;

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
            this.f55126a = pbFragment;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f55126a.D0 == null) {
                return;
            }
            this.f55126a.D0.X2(list);
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55127a;

        public v0(PbFragment pbFragment) {
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
            this.f55127a = pbFragment;
        }

        @Override // c.a.r0.x0.g2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.r0.x0.g2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f55127a.R0 != null && this.f55127a.R0.a() != null) {
                    this.f55127a.R0.a().sendAction(new c.a.q0.x.a(45, 27, null));
                }
                this.f55127a.D0.X();
            }
        }

        @Override // c.a.r0.x0.g2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55128e;

        public v1(PbFragment pbFragment) {
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
            this.f55128e = pbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55128e.w0 == null) {
                return;
            }
            this.f55128e.w0.loadData();
        }
    }

    /* loaded from: classes7.dex */
    public class v2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55129e;

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
            this.f55129e = pbFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.f55129e.c1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f55129e.c1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55130a;

        public w(PbFragment pbFragment) {
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
            this.f55130a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f55130a.H1 = false;
                if (this.f55130a.I1 == null) {
                    return;
                }
                c.a.r0.k2.h.e P0 = this.f55130a.w0.P0();
                if (P0.O().L0().getIsLike() == 1) {
                    this.f55130a.e4(0);
                } else {
                    this.f55130a.e4(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, P0.O()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f55130a.H1 = false;
                if (this.f55130a.I1 == null || str == null) {
                    return;
                }
                if (AntiHelper.m(i2, str)) {
                    AntiHelper.u(this.f55130a.getPageContext().getPageActivity(), str);
                } else {
                    this.f55130a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class w0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public w0() {
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
    public class w1 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55131a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f55132e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ w1 f55133f;

            public a(w1 w1Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w1Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55133f = w1Var;
                this.f55132e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.k2.j.c.a(this.f55133f.f55131a.getPageContext(), this.f55132e).show();
                }
            }
        }

        public w1(PbFragment pbFragment) {
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
            this.f55131a = pbFragment;
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
    public class w2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55134e;

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
            this.f55134e = pbFragment;
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
    public class x implements b.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55135a;

        public x(PbFragment pbFragment) {
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
            this.f55135a = pbFragment;
        }

        @Override // c.a.r0.k2.k.e.c1.b.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f55135a.setNavigationBarShowFlag(z);
                if (this.f55135a.D0.D0() != null && z) {
                    this.f55135a.D0.z3(false);
                }
                this.f55135a.D0.S1(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55136a;

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
            this.f55136a = pbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f55136a.D0.e0();
                boolean z = false;
                if (c.a.e.e.p.j.z()) {
                    if (this.f55136a.w0 != null && !this.f55136a.w0.isLoading) {
                        this.f55136a.stopVoice();
                        this.f55136a.D0.S2();
                        z = true;
                        if (this.f55136a.w0.P0() != null && this.f55136a.w0.P0().f19808f != null && this.f55136a.w0.P0().f19808f.size() > i2) {
                            int intValue = this.f55136a.w0.P0().f19808f.get(i2).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.f55136a.w0.g1()).param("fid", this.f55136a.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.f55136a.w0.t2(intValue)) {
                                this.f55136a.m = true;
                                this.f55136a.D0.G2(true);
                            }
                        }
                    }
                    return z;
                }
                this.f55136a.showToast(R.string.network_not_available);
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
    public class x1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f55137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f55138f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f55139g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55140h;

        public x1(PbFragment pbFragment, MarkData markData, MarkData markData2, c.a.q0.s.s.a aVar) {
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
            this.f55140h = pbFragment;
            this.f55137e = markData;
            this.f55138f = markData2;
            this.f55139g = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f55140h.y0 != null) {
                    if (this.f55140h.y0.e()) {
                        this.f55140h.y0.d();
                        this.f55140h.y0.h(false);
                    }
                    this.f55140h.y0.i(this.f55137e);
                    this.f55140h.y0.h(true);
                    this.f55140h.y0.a();
                }
                this.f55138f.setPostId(this.f55137e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f55138f);
                this.f55140h.f55017e.setResult(-1, intent);
                this.f55139g.dismiss();
                this.f55140h.X3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55141e;

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
            this.f55141e = pbFragment;
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
    public class y implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f55142e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f55143f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f55144g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f55145h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55146i;

        public y(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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
            this.f55146i = pbFragment;
            this.f55142e = sparseArray;
            this.f55143f = z;
            this.f55144g = str;
            this.f55145h = str2;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f55146i.H0 != null) {
                    this.f55146i.H0.dismiss();
                }
                if (i2 == 0) {
                    this.f55146i.D0.Y1(((Integer) this.f55142e.get(R.id.tag_del_post_type)).intValue(), (String) this.f55142e.get(R.id.tag_del_post_id), ((Integer) this.f55142e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f55142e.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f55142e.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.f55142e.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.f55142e.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f55143f, this.f55144g, str, str2, str3, 1, this.f55145h, this.f55146i.e1);
                    userMuteAddAndDelCustomMessage.setTag(this.f55146i.e1);
                    this.f55146i.T3(this.f55143f, userMuteAddAndDelCustomMessage, this.f55145h, str, (String) this.f55142e.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55147e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55148f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55149g;

        /* loaded from: classes7.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ y0 f55150e;

            public a(y0 y0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {y0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55150e = y0Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.a.r0.k2.k.e.u0 u0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f55150e.f55149g.mContentProcessController) == null || u0Var.g() == null) {
                    return;
                }
                if (!this.f55150e.f55149g.mContentProcessController.g().e()) {
                    this.f55150e.f55149g.mContentProcessController.b(false);
                }
                this.f55150e.f55149g.mContentProcessController.g().l(false);
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

        public y0(PbFragment pbFragment, String str, String str2) {
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
            this.f55149g = pbFragment;
            this.f55147e = str;
            this.f55148f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = c.a.e.e.p.l.i(this.f55149g.f55017e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = c.a.e.e.p.l.g(this.f55149g.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = c.a.e.e.p.l.g(this.f55149g.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                PbFragment pbFragment = this.f55149g;
                boolean z = true;
                pbFragment.getPbView().G0().smoothScrollBy((pbFragment.i0[1] + pbFragment.j0) - i4, 50);
                if (this.f55149g.getPbView().P0() != null) {
                    this.f55149g.R0.a().setVisibility(8);
                    this.f55149g.getPbView().P0().n(this.f55147e, this.f55148f, this.f55149g.getPbView().S0(), (this.f55149g.w0 == null || this.f55149g.w0.P0() == null || this.f55149g.w0.P0().O() == null || !this.f55149g.w0.P0().O().Q1()) ? false : false);
                    c.a.q0.x.x.h b2 = this.f55149g.getPbView().P0().b();
                    if (b2 != null && this.f55149g.w0 != null && this.f55149g.w0.P0() != null) {
                        b2.H(this.f55149g.w0.P0().d());
                        b2.c0(this.f55149g.w0.P0().O());
                    }
                    if (this.f55149g.mContentProcessController.f() == null && this.f55149g.getPbView().P0().b().u() != null) {
                        this.f55149g.getPbView().P0().b().u().g(new a(this));
                        PbFragment pbFragment2 = this.f55149g;
                        pbFragment2.mContentProcessController.n(pbFragment2.getPbView().P0().b().u().i());
                        this.f55149g.getPbView().P0().b().N(this.f55149g.Z0);
                    }
                }
                this.f55149g.getPbView().d1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f55151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f55152f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55153g;

        public y1(PbFragment pbFragment, MarkData markData, c.a.q0.s.s.a aVar) {
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
            this.f55153g = pbFragment;
            this.f55151e = markData;
            this.f55152f = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f55151e);
                this.f55153g.f55017e.setResult(-1, intent);
                this.f55152f.dismiss();
                this.f55153g.X3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f55154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55155f;

        public y2(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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
            this.f55155f = pbFragment;
            this.f55154e = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f55155f.D0.m3();
                MessageManager.getInstance().sendMessage(this.f55154e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55156a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(PbFragment pbFragment, int i2) {
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
            this.f55156a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f48113c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.f55156a.getUniqueId() || AntiHelper.t(this.f55156a.getActivity(), updateAttentionMessage.getData().l, PbFragment.z2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().f48111a) {
                    if (this.f55156a.getFirstPostData().t() != null && this.f55156a.getFirstPostData().t().getGodUserData() != null) {
                        this.f55156a.getFirstPostData().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.f55156a.w0 == null || this.f55156a.w0.P0() == null || this.f55156a.w0.P0().O() == null || this.f55156a.w0.P0().O().J() == null) {
                        return;
                    }
                    this.f55156a.w0.P0().O().J().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55157a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55158b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55159c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ z0 f55160e;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$z0$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1793a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f55161e;

                public C1793a(a aVar) {
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
                    this.f55161e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    c.a.r0.k2.k.e.u0 u0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f55161e.f55160e.f55159c.mContentProcessController) == null || u0Var.g() == null) {
                        return;
                    }
                    if (!this.f55161e.f55160e.f55159c.mContentProcessController.g().e()) {
                        this.f55161e.f55160e.f55159c.mContentProcessController.b(false);
                    }
                    this.f55161e.f55160e.f55159c.mContentProcessController.g().l(false);
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

            public a(z0 z0Var) {
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
                this.f55160e = z0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = c.a.e.e.p.l.i(this.f55160e.f55159c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i2 = i3 / 2;
                        g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i4 = i3 - (i2 + g2);
                    PbFragment pbFragment = this.f55160e.f55159c;
                    boolean z = true;
                    pbFragment.getPbView().G0().smoothScrollBy((pbFragment.i0[1] + pbFragment.j0) - i4, 50);
                    if (this.f55160e.f55159c.getPbView().P0() != null) {
                        this.f55160e.f55159c.R0.a().setVisibility(8);
                        z = (this.f55160e.f55159c.w0 == null || this.f55160e.f55159c.w0.P0() == null || this.f55160e.f55159c.w0.P0().O() == null || !this.f55160e.f55159c.w0.P0().O().Q1()) ? false : false;
                        c.a.r0.k2.k.e.t P0 = this.f55160e.f55159c.getPbView().P0();
                        z0 z0Var = this.f55160e;
                        P0.n(z0Var.f55157a, z0Var.f55158b, z0Var.f55159c.getPbView().S0(), z);
                        c.a.q0.x.x.h b2 = this.f55160e.f55159c.getPbView().P0().b();
                        if (b2 != null && this.f55160e.f55159c.w0 != null && this.f55160e.f55159c.w0.P0() != null) {
                            b2.H(this.f55160e.f55159c.w0.P0().d());
                            b2.c0(this.f55160e.f55159c.w0.P0().O());
                        }
                        if (this.f55160e.f55159c.mContentProcessController.f() == null && this.f55160e.f55159c.getPbView().P0().b().u() != null) {
                            this.f55160e.f55159c.getPbView().P0().b().u().g(new C1793a(this));
                            PbFragment pbFragment2 = this.f55160e.f55159c;
                            pbFragment2.mContentProcessController.n(pbFragment2.getPbView().P0().b().u().i());
                            this.f55160e.f55159c.getPbView().P0().b().N(this.f55160e.f55159c.Z0);
                        }
                    }
                    this.f55160e.f55159c.getPbView().d1();
                }
            }
        }

        public z0(PbFragment pbFragment, String str, String str2) {
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
            this.f55159c = pbFragment;
            this.f55157a = str;
            this.f55158b = str2;
        }

        @Override // c.a.r0.x0.g2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.r0.x0.g2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                c.a.e.e.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // c.a.r0.x0.g2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z1 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f55162e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f55163f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55164g;

        public z1(PbFragment pbFragment, MarkData markData, c.a.q0.s.s.a aVar) {
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
            this.f55164g = pbFragment;
            this.f55162e = markData;
            this.f55163f = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.f55164g.D0 != null && this.f55164g.D0.b1() != null) {
                    this.f55164g.D0.b1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.f55162e);
                    this.f55164g.f55017e.setResult(-1, intent);
                    this.f55163f.dismiss();
                    this.f55164g.X3();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z2 implements c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55165a;

        public z2(PbFragment pbFragment) {
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
            this.f55165a = pbFragment;
        }

        @Override // c.a.r0.k2.k.e.c0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f55165a.D0.C3(str);
        }

        @Override // c.a.r0.k2.k.e.c0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
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
        z2 = new w0();
        A2 = new t2();
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
        this.f55018f = true;
        this.f55019g = false;
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
        this.M = false;
        this.N = false;
        this.O = false;
        this.Q = "";
        this.R = true;
        this.S = false;
        this.T = "";
        this.b0 = 3;
        this.i0 = new int[2];
        this.k0 = -1;
        this.l0 = -1;
        this.sortSwitchId = BdUniqueId.gen();
        this.o0 = false;
        this.r0 = c.a.q0.b.d.l0();
        this.s0 = new p(this);
        this.u0 = new a0(this);
        this.v0 = new Handler(new l0(this));
        this.w0 = null;
        this.y0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = false;
        this.F0 = false;
        this.G0 = false;
        this.K0 = false;
        this.M0 = false;
        this.O0 = false;
        this.mKeyboardIsVisible = false;
        this.X0 = new h1(this);
        this.Y0 = new s1(this);
        this.Z0 = new d2(this);
        this.a1 = 0;
        this.k1 = false;
        this.l1 = 0;
        this.m1 = -1;
        this.bjhFrom = 0;
        this.p1 = new o2(this);
        this.q1 = new z2(this);
        this.r1 = new f(this, 2004016);
        this.s1 = new g(this, 2016485);
        this.t1 = new h(this, 2001269);
        this.u1 = new i(this, 2004008);
        this.v1 = new j(this, 2004007);
        this.w1 = new k(this, 2004005);
        this.x1 = new l(this, 2001332);
        this.y1 = new m(this, 2921391);
        this.z1 = new n(this, 2921606);
        this.A1 = new o(this);
        this.B1 = new q(this, 2001369);
        this.C1 = new r(this, 2016488);
        this.D1 = new s(this, 2016331);
        this.E1 = new t(this);
        this.F1 = new u(this, 2921509);
        this.G1 = new v(this);
        this.I1 = new PraiseModel(getPageContext(), new w(this));
        this.J1 = new x(this);
        this.K1 = new z(this, 2001115);
        this.L1 = new b0(this);
        this.M1 = new e0(this);
        this.N1 = new c.a.r0.k2.i.c(new h0(this));
        this.O1 = new j0(this, 2001427);
        this.P1 = new k0(this, 2001428);
        this.Q1 = new m0(this, 2921634);
        this.R1 = new n0(this, 2001426);
        this.mFirstFloorPraiseListener = new o0(this, 2004021);
        this.S1 = new p0(this, 2016528);
        this.T1 = new q0(this, 2921033);
        this.mDialogClickListener = new r0(this);
        this.U1 = new s0(this);
        this.onSwitchChangeListener = new x0(this);
        this.mCommonOnClickListener = new a1(this);
        this.V1 = new b1(this, 2921480);
        this.W1 = new c1(this);
        this.mOnFloorPostWriteNewCallback = new d1(this);
        this.X1 = new e1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.Y1 = new f1(this);
        this.Z1 = new g1(this, 2016450);
        this.a2 = new i1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.b2 = new j1(this);
        this.c2 = new m1(this);
        this.d2 = new p1(this);
        this.e2 = new r1(this);
        this.f2 = new t1(this);
        this.h2 = new u1(this);
        this.i2 = 0;
        this.j2 = new h2(this);
        this.k2 = false;
        this.l2 = null;
        this.m2 = new i2(this);
        this.n2 = new j2(this);
        this.o2 = new k2(this);
        this.p2 = new l2(this);
        this.q2 = new m2(this);
        this.r2 = new n2(this);
        this.s2 = new p2(this);
        this.mOnTouchListener = new r2(this);
        this.t2 = new s2(this);
        this.u2 = new u2(this);
        this.v2 = -1;
        this.w2 = -1;
    }

    public static PbFragment newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65665, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public final void A2(c.a.r0.k2.h.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, eVar, arrayList) == null) || eVar == null || eVar.T() == null || eVar.T().f19871a == null || (list = eVar.T().f19871a) == null || arrayList == null) {
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

    public final void A3(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3) == null) || this.w0 == null) {
            return;
        }
        P3();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
        privacySettingMessage.setTid(this.w0.f55227f);
        sendMessage(privacySettingMessage);
    }

    public final boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.P0() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.w0.P0().O()) || AntiHelper.d(getPageContext(), this.w0.P0().d());
        }
        return invokeV.booleanValue;
    }

    public final void B3(c.a.q0.x.x.g gVar) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || gVar == null || (pbModel = this.w0) == null) {
            return;
        }
        gVar.p(pbModel.q0());
        if (this.w0.P0() != null && this.w0.P0().m() != null) {
            gVar.o(this.w0.P0().m());
        }
        gVar.q("pb");
        gVar.r(this.w0);
    }

    public final boolean C2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i3)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void C3(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i3) == null) || (pbModel = this.w0) == null) {
            return;
        }
        int Y0 = pbModel.Y0();
        if (i3 == 5) {
            this.w0.l2(2);
        } else if (i3 == 6) {
            this.w0.l2(3);
        } else if (i3 != 7) {
            this.w0.l2(1);
        } else {
            this.w0.l2(4);
        }
        int Y02 = this.w0.Y0();
        if (Y0 == 4 || Y02 == 4) {
            r3();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D2(AgreeData agreeData) {
        c.a.q0.m0.c k3;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.n0 == null) {
            this.n0 = new c.a.q0.s.b0.a();
        }
        if (this.q0 == null) {
            c.a.r0.k3.i0.e eVar = new c.a.r0.k3.i0.e();
            this.q0 = eVar;
            eVar.f21030a = getUniqueId();
        }
        c.a.q0.s.q.f fVar = new c.a.q0.s.q.f();
        fVar.f14190b = 5;
        fVar.f14196h = 8;
        fVar.f14195g = 2;
        if (getPbModel() != null) {
            fVar.f14194f = getPbModel().O0();
        }
        fVar.f14189a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f14197i = 0;
                k3 = TbPageExtraHelper.k(getContext());
                if (k3 != null) {
                    agreeData.objSource = k3.a();
                }
                this.n0.c(agreeData, i3, getUniqueId(), false);
                this.n0.d(agreeData, this.q0);
                pbModel = this.w0;
                if (pbModel != null || pbModel.P0() == null) {
                }
                this.n0.b(getPbActivity(), fVar, agreeData, this.w0.P0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f14197i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f14197i = 1;
        }
        i3 = 0;
        k3 = TbPageExtraHelper.k(getContext());
        if (k3 != null) {
        }
        this.n0.c(agreeData, i3, getUniqueId(), false);
        this.n0.d(agreeData, this.q0);
        pbModel = this.w0;
        if (pbModel != null) {
        }
    }

    public final void D3(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z3) == null) {
            this.R0.h0(z3);
            this.R0.k0(z3);
            this.R0.r0(z3);
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.w0.v0() || this.w0.y0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.w0.f1());
                this.f55017e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.w0.f1()));
            if (Y3()) {
                this.f55017e.finish();
            }
        }
    }

    public final void E3(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new o1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                S3(str);
            } else {
                this.D0.C3(str);
            }
        }
    }

    public final boolean F2(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        List<c.a.q0.s.s.f> b4;
        c.a.q0.s.s.f fVar;
        c.a.q0.s.s.f fVar2;
        c.a.q0.s.s.f fVar3;
        c.a.q0.s.s.f fVar4;
        c.a.e.l.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                c.a.r0.k2.k.e.s0 s0Var = this.D0;
                if (s0Var != null) {
                    if (s0Var.y1()) {
                        return true;
                    }
                    this.D0.n0();
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
                            this.h1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.i1 = url;
                            if (this.h1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.j1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.j1 = null;
                            }
                        } else if (view instanceof GifView) {
                            GifView gifView = (GifView) view;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.h1 = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                                this.i1 = gifView.getBdImage().q();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.j1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.j1 = null;
                            }
                        } else if (view instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.h1 = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                    this.i1 = tbMemeImageView.getBdImage().q();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    this.j1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                } else {
                                    this.j1 = null;
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
                            this.D0.r3(this.n2, this.h1.t());
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
                if (postData.A() == 1 && isImage(view)) {
                    this.D0.r3(this.n2, this.h1.t());
                    return true;
                }
                c.a.q0.i.a aVar2 = this.y0;
                if (aVar2 == null) {
                    return true;
                }
                boolean z5 = aVar2.e() && this.l2.E() != null && this.l2.E().equals(this.w0.K0());
                boolean z6 = getPbModel().P0() != null && getPbModel().P0().f0();
                boolean z7 = getPbModel().P0() != null && getPbModel().P0().i0();
                if (this.l2.A() == 1) {
                    if (!z6) {
                        this.D0.s3(this.m2, z5, false, z7);
                    }
                    return true;
                }
                if (this.I0 == null) {
                    c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(getContext());
                    this.I0 = iVar;
                    iVar.n(this.U1);
                }
                ArrayList arrayList = new ArrayList();
                if (view == null || sparseArray == null) {
                    return true;
                }
                boolean z8 = isImage(view) && !z6;
                boolean z9 = (!isImage(view) || (aVar = this.h1) == null || aVar.t()) ? false : true;
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
                    arrayList.add(new c.a.q0.s.s.f(1, getString(R.string.save_to_emotion), this.I0));
                } else {
                    z3 = booleanValue5;
                    z4 = booleanValue6;
                }
                if (z9) {
                    arrayList.add(new c.a.q0.s.s.f(2, getString(R.string.save_to_local), this.I0));
                }
                if (!z8 && !z9) {
                    c.a.q0.s.s.f fVar5 = new c.a.q0.s.s.f(3, getString(R.string.copy), this.I0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.l2);
                    fVar5.f14448d.setTag(sparseArray3);
                    arrayList.add(fVar5);
                }
                if (!booleanValue && !z6) {
                    if (z5) {
                        fVar4 = new c.a.q0.s.s.f(4, getString(R.string.remove_mark), this.I0);
                    } else {
                        fVar4 = new c.a.q0.s.s.f(4, getString(R.string.mark), this.I0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.l2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    fVar4.f14448d.setTag(sparseArray4);
                    arrayList.add(fVar4);
                }
                if (this.mIsLogin && !this.r0) {
                    if (!c.a.r0.k2.k.e.f1.a.h(this.w0) && !booleanValue4 && booleanValue3) {
                        c.a.q0.s.s.f fVar6 = new c.a.q0.s.s.f(5, getString(R.string.mute_option), this.I0);
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
                        fVar6.f14448d.setTag(sparseArray5);
                        arrayList.add(fVar6);
                    } else {
                        if ((h3(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                            c.a.q0.s.s.f fVar7 = new c.a.q0.s.s.f(5, getString(R.string.report_text), this.I0);
                            fVar7.f14448d.setTag(str);
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
                        if (!c.a.r0.k2.k.e.f1.a.h(this.w0) && z3) {
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
                            fVar2 = new c.a.q0.s.s.f(6, getString(R.string.delete), this.I0);
                            fVar2.f14448d.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            fVar2 = null;
                        }
                        fVar = new c.a.q0.s.s.f(7, getString(R.string.bar_manager), this.I0);
                        fVar.f14448d.setTag(sparseArray6);
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
                        if (this.w0.P0().V() == 1002 && !booleanValue2) {
                            fVar3 = new c.a.q0.s.s.f(6, getString(R.string.report_text), this.I0);
                        } else {
                            fVar3 = new c.a.q0.s.s.f(6, getString(R.string.delete), this.I0);
                        }
                        fVar3.f14448d.setTag(sparseArray7);
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
                    c.a.r0.k2.k.e.f1.a.a(arrayList, this.I0, this.l2, this.w0);
                }
                if (c.a.q0.b.d.F()) {
                    b4 = c.a.r0.k2.k.e.f1.a.c(arrayList, this.l2.q(), sparseArray, this.I0);
                } else {
                    b4 = c.a.r0.k2.k.e.f1.a.b(arrayList, this.l2.q(), sparseArray, this.I0);
                }
                c.a.r0.k2.k.e.f1.a.k(b4, this.f55018f);
                c.a.r0.k2.k.e.f1.a.e(b4);
                this.I0.o(c.a.r0.k2.k.e.f1.a.f(this.l2));
                if (c.a.q0.b.d.F()) {
                    this.I0.l(b4, false);
                } else {
                    this.I0.l(b4, true);
                }
                PopupDialog popupDialog = new PopupDialog(getPageContext(), this.I0);
                this.H0 = popupDialog;
                popupDialog.showDialog();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.w0.f55227f).param("fid", this.w0.getForumId()).param("uid", this.w0.P0().O().J().getUserId()).param("post_id", this.w0.y()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void F3(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
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
                    c.a.r0.k3.r0.m.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.w0.D0()) {
            antiData.setBlock_forum_name(this.w0.P0().m().getName());
            antiData.setBlock_forum_id(this.w0.P0().m().getId());
            antiData.setUser_name(this.w0.P0().U().getUserName());
            antiData.setUser_id(this.w0.P0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void G2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.r0.k3.i0.p z3 = this.w0.P0().z();
        if (z3 != null && str.equals(z3.F0())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().f4 = null;
            }
            this.w0.P0().b();
        }
        c.a.r0.k3.i0.p k02 = this.w0.k0();
        if (k02 == null || !str.equals(k02.F0())) {
            return;
        }
        this.w0.W();
    }

    public final void G3(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            c.a.r0.k2.k.e.f1.b.l(this, j3, str, j4);
        }
    }

    public final void H2(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (pbModel = this.w0) == null || pbModel.P0() == null || this.w0.P0().O() == null || !this.w0.P0().O().D2()) {
            return;
        }
        c.a.q0.s.q.d2 O = this.w0.P0().O();
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

    public final void H3(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            c.a.r0.k2.k.e.f1.a.d(getActivity(), getPageContext(), new t0(this, sparseArray, i3, z3), new u0(this));
        }
    }

    public final void I2(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048592, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f57177b) ? bVar.f57177b : getString(R.string.delete_fail);
            int i3 = 0;
            if (bVar.f57178c == 1211066) {
                hideProgressBar();
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(R.string.dialog_known, new q1(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else if (bVar.f57179d != 0) {
                this.D0.m0(0, bVar.f57176a, bVar.f57177b, z3);
            }
            if (bVar.f57176a) {
                int i4 = bVar.f57179d;
                if (i4 == 1) {
                    ArrayList<PostData> F = this.w0.P0().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.f57182g.equals(F.get(i3).E())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.w0.P0().O().m4(this.w0.P0().O().U0() - 1);
                    this.D0.u1(this.w0.P0());
                } else if (i4 == 0) {
                    E2();
                } else if (i4 == 2) {
                    ArrayList<PostData> F2 = this.w0.P0().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).M().size()) {
                                break;
                            } else if (bVar.f57182g.equals(F2.get(i5).M().get(i6).E())) {
                                F2.get(i5).M().remove(i6);
                                F2.get(i5).l();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).n(bVar.f57182g);
                    }
                    if (z4) {
                        this.D0.u1(this.w0.P0());
                    }
                    delGodReplyFloor(bVar, this.D0);
                }
            }
        }
    }

    public final boolean I3(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        c.a.q0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.P0() == null) {
                return false;
            }
            c.a.r0.k2.h.e P0 = this.w0.P0();
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
            if ((O != null && O.J() != null && O.J().isForumBusinessAccount() && !c.a.r0.x0.v0.isOn()) || this.w0.E() || O.I2() || O.s2() || z4) {
                return false;
            }
            if (P0.m() == null || !P0.m().isBlockBawuDelete) {
                if (P0.V() != 0) {
                    return P0.V() != 3;
                }
                List<c.a.q0.s.q.z1> q3 = P0.q();
                if (ListUtils.getCount(q3) > 0) {
                    for (c.a.q0.s.q.z1 z1Var : q3) {
                        if (z1Var != null && (e0Var = z1Var.f14399g) != null && e0Var.f14175a && !e0Var.f14177c && ((i3 = e0Var.f14176b) == 1 || i3 == 2)) {
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

    public final void J2(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048594, this, i3, gVar) == null) || gVar == null) {
            return;
        }
        this.D0.m0(this.z0.getLoadDataMode(), gVar.f57198a, gVar.f57199b, false);
        if (gVar.f57198a) {
            this.E0 = true;
            if (i3 == 2 || i3 == 3) {
                this.F0 = true;
                this.G0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.F0 = false;
                this.G0 = true;
            }
            if (i3 == 2) {
                this.w0.P0().O().W3(1);
                this.w0.e2(1);
            } else if (i3 == 3) {
                this.w0.P0().O().W3(0);
                this.w0.e2(0);
            } else if (i3 == 4) {
                this.w0.P0().O().X3(1);
                this.w0.f2(1);
            } else if (i3 == 5) {
                this.w0.P0().O().X3(0);
                this.w0.f2(0);
            }
            this.D0.K3(this.w0.P0(), this.w0.d1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f57199b)) {
            string = gVar.f57199b;
        } else {
            string = getString(R.string.operation_failed);
        }
        c.a.e.e.p.l.M(getPageContext().getPageActivity(), string);
    }

    public final boolean J3(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z3)) == null) {
            if (z3 || (pbModel = this.w0) == null || pbModel.P0() == null || (this.w0.P0().m() != null && this.w0.P0().m().isBlockBawuDelete)) {
                return false;
            }
            c.a.r0.k2.h.e P0 = this.w0.P0();
            return ((P0.O() != null && P0.O().J() != null && P0.O().J().isForumBusinessAccount() && !c.a.r0.x0.v0.isOn()) || this.w0.E() || this.w0.P0().V() == 0 || this.w0.P0().V() == 3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final void K2(Rect rect) {
        c.a.r0.k2.k.e.s0 s0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, rect) == null) || rect == null || (s0Var = this.D0) == null || s0Var.Z0() == null || rect.top > this.D0.Z0().getHeight()) {
            return;
        }
        rect.top += this.D0.Z0().getHeight() - rect.top;
    }

    public final boolean K3(boolean z3, boolean z4, boolean z5, int i3, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i3), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
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

    public final int L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.w0.P0() == null || this.w0.P0().O() == null) {
                return -1;
            }
            return this.w0.P0().O().w();
        }
        return invokeV.intValue;
    }

    public final boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.d1()) {
                return this.w0.N0() == null || this.w0.N0().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String M2() {
        InterceptResult invokeV;
        c.a.r0.k2.h.e P0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || (P0 = pbModel.P0()) == null) {
                return null;
            }
            return P0.T().f19873c;
        }
        return (String) invokeV.objValue;
    }

    public final void M3(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, metaData) == null) || metaData == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getActivity());
        aVar.setTitle(getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(getResources().getString(R.string.mark_like_cancel), new k1(this, metaData));
        aVar.setPositiveButton(getResources().getString(R.string.mark_like_confirm), new l1(this, metaData));
        aVar.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final String N2() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.P0() == null || this.w0.P0().F() == null || (count = ListUtils.getCount((F = this.w0.P0().F()))) == 0) {
                return "";
            }
            if (this.w0.a1()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.E();
                    }
                }
            }
            int w02 = this.D0.w0();
            PostData postData = (PostData) ListUtils.getItem(F, w02);
            if (postData != null && postData.t() != null) {
                if (this.w0.y1(postData.t().getUserId())) {
                    return postData.E();
                }
                for (int i3 = w02 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (this.w0.y1(postData2.t().getUserId())) {
                        return postData2.E();
                    }
                }
                for (int i4 = w02 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (this.w0.y1(postData3.t().getUserId())) {
                        return postData3.E();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new v2(this));
            aVar.setNegativeButton(R.string.cancel, new w2(this));
            aVar.create(this.c1).show();
        }
    }

    public final TbRichText O2(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> y3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048604, this, arrayList, str, i3)) == null) {
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
                                    this.i2 = i6;
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

    public final void O3(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048605, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            PopupDialog popupDialog = this.H0;
            if (popupDialog != null && popupDialog.isShowing()) {
                this.H0.dismiss();
                this.H0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(getContext());
                iVar.n(new y(this, sparseArray, z3, str2, str));
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
                this.H0 = popupDialog2;
                popupDialog2.showDialog();
            }
        }
    }

    public final int P2(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.k2 = true;
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
                            String a4 = c.a.r0.k2.h.f.a(tbRichTextData);
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
                                    imageUrlData.originalUrl = S2(tbRichTextData);
                                    imageUrlData.originalSize = T2(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = R2(tbRichTextData);
                                    imageUrlData.isLongPic = Q2(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = c.a.e.e.m.b.g(this.w0.f1(), -1L);
                                    imageUrlData.mIsReserver = this.w0.a1();
                                    imageUrlData.mIsSeeHost = this.w0.t0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a4, imageUrlData);
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
        return invokeCommon.intValue;
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            showLoadingView(this.D0.b1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
            View i3 = getLoadingView().i();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) i3.getLayoutParams();
            layoutParams.addRule(3, this.D0.Z0().getId());
            i3.setLayoutParams(layoutParams);
        }
    }

    public final boolean Q2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return false;
            }
            return tbRichTextData.C().E();
        }
        return invokeL.booleanValue;
    }

    public final void Q3(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && getPbModel() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                getPbModel().Y(postWriteCallBackData.getPostId());
                int t02 = this.D0.t0();
                this.l1 = t02;
                this.w0.a2(t02, this.D0.A0());
            }
            this.D0.e0();
            this.mContentProcessController.c();
            c.a.q0.x.x.e eVar = this.R0;
            if (eVar != null) {
                this.D0.x2(eVar.E());
            }
            this.D0.f1();
            this.D0.e3(true);
            this.w0.n1();
        }
    }

    public final boolean R2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return false;
            }
            return tbRichTextData.C().F();
        }
        return invokeL.booleanValue;
    }

    public final void R3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i3) == null) {
            c.a.r0.k2.k.e.f1.b.o(this, L2(), i3);
        }
    }

    public final String S2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return null;
            }
            return tbRichTextData.C().A();
        }
        return (String) invokeL.objValue;
    }

    public final void S3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            if (str == null) {
                str = "";
            }
            c.a.e.a.f fVar = this.c1;
            if (fVar == null) {
                return;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(fVar.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new x2(this));
            aVar.create(this.c1).show();
        }
    }

    public final long T2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return 0L;
            }
            return tbRichTextData.C().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void T3(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.D0.m3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.c1.getPageActivity());
            if (c.a.e.e.p.k.isEmpty(str)) {
                aVar.setMessage(this.c1.getResources().getString(R.string.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new y2(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new a(this));
            aVar.create(this.c1).show();
        }
    }

    public final int U2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i3)) == null) {
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

    public final void U3() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (pbModel = this.w0) == null || c.a.e.e.p.k.isEmpty(pbModel.f1())) {
            return;
        }
        c.a.q0.a.d.y().P(c.a.q0.a.c.W, c.a.e.e.m.b.g(this.w0.f1(), 0L));
    }

    public final int V2(c.a.r0.k2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, eVar)) == null) {
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

    public final void V3(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            W3(postData, false);
        }
    }

    public final void W2(int i3, Intent intent) {
        c.a.q0.x.n nVar;
        c.a.q0.x.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048620, this, i3, intent) == null) {
            if (i3 == 0) {
                this.D0.f1();
                this.D0.P0().c();
                this.D0.e3(false);
            }
            this.D0.q2();
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
                    if (editorType != 1 || this.D0.P0() == null || this.D0.P0().b() == null) {
                        return;
                    }
                    c.a.q0.x.x.h b4 = this.D0.P0().b();
                    b4.c0(this.w0.P0().O());
                    b4.C(writeData);
                    b4.d0(pbEditorData.getVoiceModel());
                    c.a.q0.x.m findToolById = b4.a().findToolById(6);
                    if (findToolById != null && (nVar2 = findToolById.k) != null) {
                        nVar2.onAction(new c.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        b4.G();
                        return;
                    }
                    return;
                }
                this.R0.U();
                this.R0.v0(pbEditorData.getVoiceModel());
                this.R0.I(writeData);
                c.a.q0.x.m findToolById2 = this.R0.a().findToolById(6);
                if (findToolById2 != null && (nVar = findToolById2.k) != null) {
                    nVar.onAction(new c.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    this.R0.N(null, null);
                }
            }
        }
    }

    public final void W3(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048621, this, postData, z3) == null) || postData == null || (pbModel = this.w0) == null || pbModel.P0() == null || postData.A() == 1) {
            return;
        }
        String f12 = this.w0.f1();
        String E = postData.E();
        int V = this.w0.P0() != null ? this.w0.P0().V() : 0;
        AbsPbActivity.e t3 = t3(E);
        if (t3 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(f12, E, "pb", true, false, null, false, null, V, postData.P(), this.w0.P0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null, 5).addBigImageData(t3.f54984a, t3.f54985b, t3.f54990g, t3.f54993j);
        addBigImageData.setKeyPageStartFrom(this.w0.O0());
        addBigImageData.setFromFrsForumId(this.w0.getFromForumId());
        addBigImageData.setWorksInfoData(this.w0.k1());
        addBigImageData.setKeyFromForumId(this.w0.getForumId());
        addBigImageData.setBjhData(this.w0.j0());
        addBigImageData.setIsOpenEditor(z3);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final void X2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.P0() != null && this.w0.P0().f0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.w0.f1(), str);
                c.a.q0.s.q.d2 O = this.w0.P0().O();
                if (O.M1()) {
                    format = format + "&channelid=33833";
                } else if (O.R1()) {
                    format = format + "&channelid=33842";
                } else if (O.P1()) {
                    format = format + "&channelid=33840";
                }
                i3(format);
                return;
            }
            this.x0.a(str);
        }
    }

    public final void X3() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (absPbActivity = this.f55017e) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public final void Y2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, intent) == null) {
            c.a.r0.k2.k.e.f1.b.j(this, intent);
        }
    }

    public final boolean Y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.P0() == null || !this.w0.P0().f0()) {
                if (this.w0.B0()) {
                    MarkData n02 = this.w0.n0();
                    if (n02 != null && this.w0.z0()) {
                        MarkData h02 = this.w0.h0(this.D0.w0());
                        if (h02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", n02);
                            this.f55017e.setResult(-1, intent);
                            return true;
                        } else if (h02.getPostId() != null && !h02.getPostId().equals(n02.getPostId())) {
                            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
                            aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                            aVar.setPositiveButton(R.string.confirm, new x1(this, h02, n02, aVar));
                            aVar.setNegativeButton(R.string.cancel, new y1(this, n02, aVar));
                            aVar.setOnCalcelListener(new z1(this, n02, aVar));
                            aVar.create(getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", n02);
                            this.f55017e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.w0.P0() != null && this.w0.P0().F() != null && this.w0.P0().F().size() > 0 && this.w0.z0()) {
                    this.f55017e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Z2(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048626, this, i3, i4) == null) {
            c.a.q0.d1.l0.b(new d(this, i4), new e(this, i4, i3));
        }
    }

    public final void Z3() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absPbActivity = this.f55017e) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f55017e.getPbModel().f1()).param("topic_id", this.f55017e.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.f55017e.getPbModel().j1()));
    }

    public final void a3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i3) == null) {
            c.a.q0.d1.l0.b(new b(this), new c(this, i3));
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

    public final void a4(boolean z3) {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048629, this, z3) == null) || (absPbActivity = this.f55017e) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(!z3 ? "c14397" : "c14398").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f55017e.getPbModel().f1()).param("topic_id", this.f55017e.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.f55017e.getPbModel().j1()));
    }

    public void addBackInterceptor(a3 a3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, a3Var) == null) || a3Var == null) {
            return;
        }
        if (this.n1 == null) {
            this.n1 = new ArrayList();
        }
        if (this.n1.contains(a3Var)) {
            return;
        }
        this.n1.add(a3Var);
    }

    public void addBackInterceptorAtFirst(a3 a3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, a3Var) == null) || a3Var == null) {
            return;
        }
        if (this.n1 == null) {
            this.n1 = new ArrayList();
        }
        if (this.n1.contains(a3Var)) {
            return;
        }
        this.n1.add(0, a3Var);
    }

    public final void b3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bundle) == null) {
            c.a.q0.i.a c4 = c.a.q0.i.a.c(this.f55017e);
            this.y0 = c4;
            if (c4 != null) {
                c4.j(this.b2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f55017e);
            this.z0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.d2);
            this.A0 = new c.a.q0.t.e.a(getPageContext());
            this.I1.setUniqueId(getUniqueId());
            this.I1.registerListener();
        }
    }

    public final void b4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.w0.f55227f).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(c.a.r0.k2.k.e.f1.a.m(i3))));
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.V = likeModel;
            likeModel.setLoadDataCallBack(new f0(this));
        }
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.B(this.w0.getForumId()) && this.w0.P0() != null && this.w0.P0().m() != null) {
            if (this.w0.P0().m().isLike() == 1) {
                this.w0.e0().A(this.w0.getForumId(), this.w0.f1());
            }
        }
    }

    public void checkEasterEgg(boolean z3) {
        c.a.r0.k2.k.e.s0 s0Var;
        int w3;
        int w4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048636, this, z3) == null) || (s0Var = this.D0) == null || s0Var.G0() == null) {
            return;
        }
        int firstVisiblePosition = this.D0.G0().getFirstVisiblePosition();
        int lastVisiblePosition = this.D0.G0().getLastVisiblePosition();
        c.a.r0.k2.k.e.h p02 = this.D0.p0();
        if (p02 == null || this.w0.P0() == null) {
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
                if (this.D0.G0().getItem(w3) != null && (this.D0.G0().getItem(w3) instanceof PostData) && (postData = (PostData) this.D0.G0().getItem(w3)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.w0.P0().F(), postData.A() - 1);
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
            Collections.sort(arrayList, new n1(this));
            c.a.q0.u.a aVar = (c.a.q0.u.a) ListUtils.getItem(arrayList, 0);
            if (aVar == null || aVar.e() != 1) {
                this.D0.e2(aVar, 1);
            } else if (z3) {
            } else {
                this.D0.e2(aVar, 0);
            }
        }
    }

    public void checkMuteState(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.D0.m3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = c.a.e.e.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.e.e.m.b.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.e1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.b1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean checkPrivacyBeforeInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if ((this.w0.P0() != null && (this.w0.P0().f0() || ThreadCardUtils.isSelf(this.w0.P0().O()))) || this.mReplyPrivacyController == null || this.w0.P0() == null || this.w0.P0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.w0.P0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public boolean checkPrivacyBeforePost(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i3)) == null) {
            if (this.mReplyPrivacyController == null || this.w0.P0() == null || ThreadCardUtils.isSelf(this.w0.P0().O()) || this.w0.P0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeSend(this.w0.P0().d().replyPrivateFlag, i3);
        }
        return invokeI.booleanValue;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && this.q == null) {
            this.q = new c.a.q0.s.s.b(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
            c.a.q0.s.s.b bVar = this.q;
            bVar.j(strArr, new i0(this));
            bVar.g(b.C0696b.f14426a);
            bVar.h(17);
            bVar.c(getPageContext());
        }
    }

    public final void d4(c.a.q0.s.q.u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, uVar) == null) || uVar == null) {
            return;
        }
        this.y2 = uVar;
        this.f55019g = true;
        this.D0.n2();
        this.D0.F2(this.x2);
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048642, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (c.a.q0.f1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), c.a.q0.f1.m.f.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (c.a.r0.k2.k.e.x0.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public void delGodReplyFloor(ForumManageModel.b bVar, c.a.r0.k2.k.e.s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, bVar, s0Var) == null) {
            List<PostData> list = this.w0.P0().T().f19871a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).M().size()) {
                        break;
                    } else if (bVar.f57182g.equals(list.get(i3).M().get(i4).E())) {
                        list.get(i3).M().remove(i4);
                        list.get(i3).l();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).n(bVar.f57182g);
            }
            if (z3) {
                s0Var.u1(this.w0.P0());
            }
        }
    }

    public void deleteThread(c.a.q0.s.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048645, this, aVar, jSONArray) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(c.a.r0.k2.k.e.s0.W1, Integer.valueOf(c.a.r0.k2.k.e.s0.X1));
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
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            TiebaStatic.log("c12181");
            c.a.r0.k2.k.e.s0 s0Var = this.D0;
            if (s0Var == null || this.w0 == null) {
                return;
            }
            if ((s0Var != null && !s0Var.w1()) || this.w0.P0() == null || this.w0.P0().S() == null) {
                return;
            }
            c.a.r0.k2.k.e.s0 s0Var2 = this.D0;
            if (s0Var2 == null || s0Var2.v0() == null || !this.D0.v0().isFalling()) {
                c.a.r0.k2.h.p S = this.w0.P0().S();
                if (checkUpIsLogin()) {
                    if ((!S.g() || S.b() != 2) && this.D0.p0() != null && this.D0.p0().z() != null) {
                        this.D0.p0().z().k0(this.w0.f1(), this.w0.getFromForumId());
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
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || this.D0 == null || (pbModel = this.w0) == null) {
            return;
        }
        if ((pbModel.P0() == null && this.w0.P0().S() == null) || !checkUpIsLogin() || this.D0.p0() == null || this.D0.p0().z() == null) {
            return;
        }
        this.D0.p0().z().k0(this.w0.f1(), this.w0.getFromForumId());
    }

    public final boolean e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            AbsPbActivity absPbActivity = this.f55017e;
            return (absPbActivity == null || absPbActivity.getPbModel() == null || this.f55017e.getPbModel().O0() != 17) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void e4(int i3) {
        PbModel pbModel;
        c.a.q0.s.q.d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048650, this, i3) == null) || (pbModel = this.w0) == null || pbModel.P0() == null || (O = this.w0.P0().O()) == null) {
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
        if (this.w0.d1()) {
            this.D0.p0().X();
        } else {
            this.D0.M3(this.w0.P0());
        }
    }

    public final boolean f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            PostData c4 = c.a.r0.k2.h.f.c(this.w0.P0(), this.w0.d1(), this.w0.Z0());
            return (c4 == null || c4.t() == null || c4.t().getGodUserData() == null || c4.t().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final TbRichText f4(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048652, this, str, i3)) == null) {
            PbModel pbModel = this.w0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.P0() == null || str == null || i3 < 0) {
                return null;
            }
            c.a.r0.k2.h.e P0 = this.w0.P0();
            if (P0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(P0.j());
                tbRichText = O2(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = P0.F();
                A2(P0, F);
                return O2(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // c.a.r0.k2.o.b
    public void finish() {
        c.a.r0.k2.k.e.s0 s0Var;
        CardHListViewData r3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            c.a.r0.k2.k.e.s0 s0Var2 = this.D0;
            if (s0Var2 != null) {
                s0Var2.e0();
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.P0() != null && !this.w0.P0().f0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.w0.P0().O().f0();
                if (this.w0.isShareThread() && this.w0.P0().O().y1 != null) {
                    historyMessage.threadName = this.w0.P0().O().y1.f47433b;
                } else {
                    historyMessage.threadName = this.w0.P0().O().getTitle();
                }
                if (this.w0.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.w0.P0().m().getName();
                }
                ArrayList<PostData> F = this.w0.P0().F();
                c.a.r0.k2.k.e.s0 s0Var3 = this.D0;
                int w02 = s0Var3 != null ? s0Var3.w0() : 0;
                if (F != null && w02 >= 0 && w02 < F.size()) {
                    historyMessage.postID = F.get(w02).E();
                }
                historyMessage.isHostOnly = this.w0.t0();
                historyMessage.isSquence = this.w0.d1();
                historyMessage.isShareThread = this.w0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            c.a.q0.x.x.e eVar = this.R0;
            if (eVar != null) {
                eVar.K();
            }
            if (this.n && getPbView() != null) {
                getPbView().j0();
            }
            PbModel pbModel2 = this.w0;
            if (pbModel2 != null && (pbModel2.v0() || this.w0.y0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.w0.f1());
                if (this.E0) {
                    if (this.G0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.w0.E0());
                    }
                    if (this.F0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.w0.A0());
                    }
                }
                if (this.w0.P0() != null && System.currentTimeMillis() - this.t >= 40000 && (r3 = this.w0.P0().r()) != null && !ListUtils.isEmpty(r3.getDataList())) {
                    intent.putExtra("guess_like_data", r3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.m1);
                }
                this.f55017e.setResult(-1, intent);
            }
            if (Y3()) {
                if (this.w0 != null && (s0Var = this.D0) != null && s0Var.G0() != null) {
                    c.a.r0.k2.h.e P0 = this.w0.P0();
                    if (P0 != null) {
                        if (P0.U() != null) {
                            P0.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!P0.l0() && !this.M && P0.f19810h == null) {
                            c.a.r0.k2.k.e.k0.b().n(this.w0.Q0(), this.D0.G0().onSaveInstanceState(), this.w0.d1(), this.w0.t0(), this.D0.N0() != null && this.D0.N0().getVisibility() == 0);
                            if (this.l1 >= 0 || this.w0.h1() != null) {
                                c.a.r0.k2.k.e.k0.b().q(this.w0.h1());
                                c.a.r0.k2.k.e.k0.b().r(this.w0.i1());
                                c.a.r0.k2.k.e.k0.b().o(this.w0.I0());
                            }
                        }
                    }
                } else {
                    c.a.r0.k2.k.e.k0.b().m();
                }
                X3();
            }
        }
    }

    public final boolean g3(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i3)) == null) ? i3 == 2 || i3 == 1 : invokeI.booleanValue;
    }

    public AntiData getAntiData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.P0() == null) {
                return null;
            }
            return this.w0.P0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public c.a.r0.k2.k.e.c1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.f55017e.getEventController() : (c.a.r0.k2.k.e.c1.a) invokeV.objValue;
    }

    public PostData getFirstPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            c.a.r0.k2.k.e.s0 s0Var = this.D0;
            PbModel pbModel = this.w0;
            return s0Var.x0(pbModel.J, pbModel.d1());
        }
        return (PostData) invokeV.objValue;
    }

    public String getFromWhere() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (this.P == null) {
                this.P = new c.a.e.e.k.b<>(new b2(this), 20, 0);
            }
            return this.P;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (this.G == null) {
                this.G = new c.a.e.e.k.b<>(new a2(this), 8, 0);
            }
            return this.G;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public PbInterviewStatusView.f getInterviewStatusCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.u0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean getIsMangaThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? (!this.f55019g && this.v2 == -1 && this.w2 == -1) ? false : true : invokeV.booleanValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.L == null) {
                this.L = new c.a.e.e.k.b<>(new g2(this), 10, 0);
            }
            return this.L;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public boolean getLinkGoodsMoreShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.O : invokeV.booleanValue;
    }

    public int getMangaNextChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.w2 : invokeV.intValue;
    }

    public int getMangaPrevChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.v2 : invokeV.intValue;
    }

    @Override // c.a.r0.k2.o.b
    public AbsPbActivity getPbActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.f55017e : (AbsPbActivity) invokeV.objValue;
    }

    public c.a.q0.x.x.e getPbEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.R0 : (c.a.q0.x.x.e) invokeV.objValue;
    }

    @Override // c.a.r0.k2.o.b
    public PbFragment getPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // c.a.r0.k2.o.b
    public PbModel.g getPbFragmentDataCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.Y1 : (PbModel.g) invokeV.objValue;
    }

    @Override // c.a.r0.k2.o.b
    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.w0 : (PbModel) invokeV.objValue;
    }

    public c.a.r0.k2.k.e.c1.b getPbNavigationAnimDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.f55021i : (c.a.r0.k2.k.e.c1.b) invokeV.objValue;
    }

    public c.a.r0.k2.k.e.e1.a getPbRecThreadController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.t0 : (c.a.r0.k2.k.e.e1.a) invokeV.objValue;
    }

    public c.a.r0.k2.k.e.s0 getPbView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.D0 : (c.a.r0.k2.k.e.s0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public c.a.q0.s.q.n1 getRecomStatisticData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.m0 : (c.a.q0.s.q.n1) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            c.a.e.e.k.b<RelativeLayout> bVar = new c.a.e.e.k.b<>(new f2(this), 10, 0);
            this.K = bVar;
            return bVar;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            c.a.r0.k2.k.e.s0 s0Var = this.D0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.a0 : (String) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if (this.E == null) {
                this.E = TbRichTextView.createTextViewPool(getPageContext().getPageActivity(), 8);
            }
            return this.E;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            if (this.J == null) {
                this.J = new c.a.e.e.k.b<>(new q2(this), 15, 0);
            }
            return this.J;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (this.I == null) {
                this.I = new c.a.e.e.k.b<>(new c2(this), 5, 0);
            }
            return this.I;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.e.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            c.a.r0.k2.k.e.s0 s0Var = this.D0;
            if (s0Var == null) {
                return 0;
            }
            return s0Var.a1();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.k2.o.b
    public VideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public String getVideoSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.T : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.o : (VoiceManager) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            if (this.H == null) {
                this.H = new c.a.e.e.k.b<>(new e2(this), 8, 0);
            }
            return this.H;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public void goInterviewLivePage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            if (this.k) {
                this.S = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.w0.P0() == null || this.w0.P0().O() == null || this.w0.P0().O().j1() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.w0.P0().O().j1().g(), this.w0.P0().O().j1().f(), this.w0.P0().O().j1().b(), this.w0.P0().O().j1().c(), this.w0.P0().O().r0(), this.w0.P0().O().q0())));
                this.f55017e.finish();
            }
        }
    }

    public final boolean h3(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048694, this, z3)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.P0() != null) {
                return ((this.w0.P0().V() != 0) || this.w0.P0().O() == null || this.w0.P0().O().J() == null || TextUtils.equals(this.w0.P0().O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void handleMuteClick(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048695, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.e1);
            userMuteAddAndDelCustomMessage.setTag(this.e1);
            T3(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void hideKeyBroad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048696, this) == null) || this.f55017e == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.f55017e.getCurrentFocus() == null) {
            return;
        }
        c.a.e.e.p.l.x(getPageContext().getPageActivity(), this.f55017e.getCurrentFocus());
    }

    public void hideKeyboardAndEditor() {
        c.a.r0.k2.k.e.s0 s0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048697, this) == null) || (s0Var = this.D0) == null) {
            return;
        }
        s0Var.f1();
        hideKeyBroad();
    }

    public final void i3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public boolean isActivityPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            PbModel pbModel = this.w0;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            PbModel pbModel = this.w0;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048702, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public boolean isMakeGoodsShowing(int i3) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048703, this, i3)) == null) {
            if (i3 == 1) {
                return true;
            }
            if (this.w0.P0().U() != null && (forumToolAuth = this.w0.P0().U().getForumToolAuth()) != null) {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048704, this, i3)) == null) ? i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 : invokeI.booleanValue;
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.x1();
        }
        return invokeV.booleanValue;
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048706, this) == null) || this.y2 == null) {
            return;
        }
        if (this.w2 == -1) {
            showToast(R.string.pb_manga_not_next_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.y2.a(), this.w2, 0)));
            this.f55017e.finish();
        }
    }

    public final void k3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            PbModel pbModel = this.f55017e.getPbModel();
            this.w0 = pbModel;
            if (pbModel.m0() != null) {
                this.w0.m0().c(this.u2);
            }
            if (this.w0.L0() != null) {
                this.w0.L0().f(this.q1);
            }
            if (StringUtils.isNull(this.w0.f1())) {
                this.f55017e.finish();
            } else if (!"from_tieba_kuang".equals(this.Q) || this.Q == null) {
            } else {
                this.w0.i2(6);
            }
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048708, this) == null) || this.y2 == null) {
            return;
        }
        if (this.v2 == -1) {
            showToast(R.string.pb_manga_not_prev_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.y2.a(), this.v2, 0)));
            this.f55017e.finish();
        }
    }

    public void loadNextVideoPb(String str) {
        c.a.r0.k2.k.e.s0 s0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048709, this, str) == null) || this.w0 == null || StringUtils.isNull(str) || (s0Var = this.D0) == null) {
            return;
        }
        s0Var.B2(true);
        this.w0.C1(str);
        this.M = true;
        this.D0.e0();
        this.D0.d1();
    }

    public final void m3(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048710, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || B2() || !checkPrivacyBeforeInput()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.i0);
            this.j0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (getPbView().P0() != null && postData != null) {
            getPbView().P0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
        }
        if (this.w0.P0() != null && this.w0.P0().f0()) {
            c.a.e.e.m.e.a().postDelayed(new y0(this, str, str2), 0L);
            return;
        }
        if (this.V0 == null) {
            c.a.r0.x0.g2.a.c cVar = new c.a.r0.x0.g2.a.c(getPageContext());
            this.V0 = cVar;
            cVar.j(1);
            this.V0.i(new z0(this, str, str2));
        }
        PbModel pbModel = this.w0;
        if (pbModel == null || pbModel.P0() == null || this.w0.P0().m() == null) {
            return;
        }
        this.V0.g(this.w0.P0().m().getId(), c.a.e.e.m.b.g(this.w0.f1(), 0L));
    }

    public void markFloor(PostData postData) {
        PostData firstPostData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048711, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.E() != null && postData.E().equals(this.w0.K0())) {
            z3 = true;
        }
        MarkData J0 = this.w0.J0(postData);
        if (this.w0.P0() != null && this.w0.P0().f0() && (firstPostData = getFirstPostData()) != null) {
            J0 = this.w0.J0(firstPostData);
        }
        if (J0 == null) {
            return;
        }
        this.D0.S2();
        c.a.q0.i.a aVar = this.y0;
        if (aVar != null) {
            aVar.i(J0);
            if (!z3) {
                this.y0.a();
            } else {
                this.y0.d();
            }
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            c.a.r0.k2.h.e P0 = this.w0.P0();
            this.w0.p2(true);
            c.a.q0.i.a aVar = this.y0;
            if (aVar != null) {
                P0.C0(aVar.g());
            }
            this.D0.u1(P0);
        }
    }

    public final void o3() {
        MarkData h02;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048713, this) == null) || this.y0 == null) {
            return;
        }
        if (this.w0.P0() != null && this.w0.P0().f0()) {
            h02 = this.w0.h0(0);
        } else {
            h02 = this.w0.h0(this.D0.F0());
        }
        if (h02 == null) {
            return;
        }
        if (h02.isApp() && (h02 = this.w0.h0(this.D0.F0() + 1)) == null) {
            return;
        }
        this.D0.S2();
        this.y0.i(h02);
        if (!this.y0.e()) {
            if (this.D0 != null && this.w0 != null && c.a.q0.b.d.T() && !c.a.r0.k2.k.e.f1.b.k(this.w0.f55227f)) {
                this.D0.x3();
                c.a.r0.k2.k.e.f1.b.b(this.w0.f55227f);
            }
            this.y0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.y0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
            this.Y1.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).getFirstLoadData(), "", 1);
            this.f55017e.getTiePlusEventController().addEventAckedCallbackWeaked(this.s0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        EmotionImageData emotionImageData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048715, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.R0.J(i3, i4, intent);
            c.a.r0.k2.k.e.b1.f.a aVar = this.U;
            if (aVar != null) {
                aVar.i(i3, i4, intent);
            }
            if (getPbView().P0() != null) {
                getPbView().P0().g(i3, i4, intent);
            }
            if (i3 == 25035) {
                W2(i4, intent);
            }
            if (i4 == -1) {
                if (i3 == 11009) {
                    o3();
                } else if (i3 == 13008) {
                    c.a.r0.k2.k.e.k0.b().m();
                    this.v0.postDelayed(new v1(this), 1000L);
                } else if (i3 == 13011) {
                    c.a.r0.y2.a.g().m(getPageContext());
                } else if (i3 == 23003) {
                    if (intent == null || this.w0 == null) {
                        return;
                    }
                    G3(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i3 == 23007) {
                    Y2(intent);
                } else if (i3 == 25012) {
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                } else if (i3 == 25016 || i3 == 25023) {
                    Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                    if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                        return;
                    }
                    this.W0 = emotionImageData;
                    if (checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        w3(emotionImageData);
                    }
                } else if (i3 == 25033) {
                    View view = this.W;
                    if (view != null) {
                        this.D0.j3(view);
                    }
                } else if (i3 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        c.a.r0.y2.a.g().m(getPageContext());
                        c4();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.C0;
                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.t) != null) {
                            shareSuccessReplyToServerModel.w(str, intExtra, new w1(this));
                        }
                        if (e3()) {
                            a4(true);
                        }
                    }
                } else if (i3 != 24008) {
                    switch (i3) {
                        case 25055:
                            View view2 = this.X;
                            if (view2 != null) {
                                view2.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view3 = this.Y;
                            if (view3 != null) {
                                view3.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            c.a.r0.k2.k.e.s0 s0Var = this.D0;
                            if (s0Var == null || s0Var.q0() == null) {
                                return;
                            }
                            this.D0.q0().performClick();
                            return;
                        case 25058:
                            View view4 = this.Z;
                            if (view4 != null) {
                                view4.performClick();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    this.D0.U2(false);
                    if (this.w0.P0() == null || this.w0.P0().O() == null || this.w0.P0().O().O0() == null) {
                        return;
                    }
                    this.w0.P0().O().O0().setStatus(2);
                }
            }
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048716, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.A = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, context) == null) {
            super.onAttach(context);
            this.f55017e = (AbsPbActivity) context;
        }
    }

    public void onBackPressed() {
        List<a3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048718, this) == null) || (list = this.n1) == null || list.isEmpty()) {
            return;
        }
        int size = this.n1.size();
        while (true) {
            size--;
            if (size <= -1 || this.n1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048719, this, i3) == null) || this.b0 == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.D0.M1(i3);
        c.a.q0.x.x.e eVar = this.R0;
        if (eVar != null && eVar.a() != null) {
            this.R0.a().onChangeSkinType(i3);
        }
        if (this.D0.a() != null) {
            this.D0.a().onChangeSkinType(getPageContext(), i3);
        }
        this.mContentProcessController.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.b0 = i3;
        stopVoice();
    }

    @Override // c.a.q0.s.s.a.e
    public void onClick(c.a.q0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, aVar) == null) {
            deleteThread(aVar, (JSONArray) null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int i3 = configuration.orientation;
            if (i3 == this.C) {
                return;
            }
            this.C = i3;
            if (i3 == 2) {
                this.N = true;
            } else {
                this.N = false;
            }
            c.a.r0.k2.k.e.s0 s0Var = this.D0;
            if (s0Var != null) {
                s0Var.N1(configuration);
            }
            PopupDialog popupDialog = this.H0;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        c.a.r0.k2.k.e.s0 s0Var;
        c.a.r0.k2.k.e.s0 s0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
            this.t = System.currentTimeMillis();
            this.c1 = getPageContext();
            Intent intent = this.f55017e.getIntent();
            if (intent != null) {
                this.r = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.Q = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.Q)) {
                        this.Q = data.getQueryParameter("from");
                    }
                }
                this.a0 = intent.getStringExtra("st_type");
                "from_interview_live".equals(this.Q);
                this.v2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.w2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.x2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.M0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.N0 = intent.getStringExtra("high_light_post_id");
                this.O0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (getIsMangaThread()) {
                    this.f55017e.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.T = stringExtra;
                this.T = c.a.e.e.p.k.isEmpty(stringExtra) ? "" : this.T;
                this.m1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                c.a.q0.s.q.n1 n1Var = new c.a.q0.s.q.n1();
                this.m0 = n1Var;
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
            k3(bundle);
            if (this.w0.P0() != null) {
                this.w0.P0().L0(this.T);
            }
            c3();
            if (intent != null && (s0Var2 = this.D0) != null) {
                s0Var2.f20411b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.f1 == null) {
                        this.f1 = new c0(this, intent);
                    }
                    c.a.e.e.m.e.a().postDelayed(this.f1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.w0.P0() != null) {
                    this.w0.j2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.o = voiceManager;
            voiceManager.onCreate(getPageContext());
            b3(bundle);
            c.a.q0.x.x.g gVar = new c.a.q0.x.x.g();
            this.Q0 = gVar;
            B3(gVar);
            c.a.q0.x.x.e eVar = (c.a.q0.x.x.e) this.Q0.a(getActivity());
            this.R0 = eVar;
            eVar.g0(this.f55017e.getPageContext());
            this.R0.p0(this.W1);
            this.R0.q0(this.X0);
            this.R0.i0(1);
            this.R0.H(this.f55017e.getPageContext(), bundle);
            this.R0.a().addHideLauncher(new c.a.q0.x.k(getActivity()));
            this.R0.a().showLinePositionBottom(true);
            D3(true);
            this.R0.Q(this.w0.s0(), this.w0.f1(), this.w0.p0());
            registerListener(this.u1);
            if (!this.w0.D0()) {
                this.R0.t(this.w0.f1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.R0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.w0.q1()) {
                this.R0.m0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                c.a.r0.k2.k.e.s0 s0Var3 = this.D0;
                if (s0Var3 != null) {
                    this.R0.m0(s0Var3.S0());
                }
            }
            registerListener(this.t1);
            registerListener(this.v1);
            registerListener(this.w1);
            registerListener(this.s1);
            registerListener(this.mFirstFloorPraiseListener);
            registerListener(this.S1);
            registerListener(this.a2);
            registerListener(this.r1);
            c.a.r0.k3.i0.f fVar = new c.a.r0.k3.i0.f("pb", c.a.r0.k3.i0.f.f21033d);
            this.P0 = fVar;
            fVar.d();
            registerListener(this.B1);
            registerListener(this.K1);
            this.w0.J1();
            registerListener(this.Z1);
            registerListener(this.T1);
            registerListener(this.V1);
            registerListener(this.F1);
            c.a.r0.k2.k.e.s0 s0Var4 = this.D0;
            if (s0Var4 != null && s0Var4.Z0() != null && this.D0.X0() != null) {
                c.a.r0.k2.k.e.c1.b bVar = new c.a.r0.k2.k.e.c1.b(getActivity(), this.D0.Z0(), this.D0.X0(), this.D0.N0());
                this.f55021i = bVar;
                bVar.t(this.J1);
            }
            if (this.f55019g && (s0Var = this.D0) != null && s0Var.X0() != null) {
                this.D0.X0().setVisibility(8);
            }
            c.a.q0.s.f0.c cVar = new c.a.q0.s.f0.c();
            this.d1 = cVar;
            cVar.f13832a = 1000L;
            registerListener(this.R1);
            registerListener(this.Q1);
            registerListener(this.O1);
            registerListener(this.P1);
            registerListener(this.D1);
            registerListener(this.y1);
            registerListener(this.z1);
            this.C1.setSelfListener(true);
            this.C1.setTag(this.f55017e.getUniqueId());
            this.C1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.C1);
            registerResponsedEventListener(TipEvent.class, this.L1);
            this.e1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.e1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.e1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.w0.l0().A(this.M1);
            this.mContentProcessController = new c.a.r0.k2.k.e.u0();
            if (this.R0.w() != null) {
                this.mContentProcessController.m(this.R0.w().i());
            }
            this.R0.f0(this.Y0);
            this.C0 = new ShareSuccessReplyToServerModel();
            addBackInterceptor(this.p1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new d0(this));
            c.a.r0.k2.k.f.a aVar = new c.a.r0.k2.k.f.a(getContext());
            this.x0 = aVar;
            aVar.b(getUniqueId());
            c.a.r0.j3.c.g().i(getUniqueId());
            c.a.q0.s.o.a.b().l("3", "");
            this.o1 = new c.a.r0.a0.a(getPageContext());
            this.t0 = new c.a.r0.k2.k.e.e1.a(this, getUniqueId(), this.D0, this.w0);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048723, this, layoutInflater, viewGroup, bundle)) == null) {
            this.D0 = new c.a.r0.k2.k.e.s0(this, this.mCommonOnClickListener, this.N1);
            c.a.r0.k0.b bVar = new c.a.r0.k0.b(getActivity());
            this.f55020h = bVar;
            bVar.i(A2);
            this.f55020h.d(this.t2);
            this.D0.L2(this.c2);
            this.D0.K2(this.h2);
            this.D0.E2(this.f2);
            this.D0.C2(c.a.q0.s.k.c().g());
            this.D0.I2(this.j2);
            this.D0.O2(this.p2);
            this.D0.M2(this.q2);
            this.D0.J2(this.s2);
            this.D0.H2(this.e2);
            this.D0.H3(this.mIsLogin);
            if (this.f55017e.getIntent() != null) {
                this.D0.A2(this.f55017e.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.D0.O0().setFromForumId(this.w0.getFromForumId());
            this.D0.t2(this.R0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.R0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.R0.m0(this.D0.S0());
            }
            this.D0.w2(new g0(this));
            this.D0.z2(this.w0.y0());
            this.D0.N2(this.w0.O0());
            this.t0.f(this.D0, this.w0);
            return this.D0.b1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        c.a.r0.k2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            c.a.r0.j3.c.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.w0.P0().n());
                statisticItem.param("tid", this.w0.f1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.x && this.D0 != null) {
                this.x = true;
                y3(false, null);
            }
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.w0.destory();
                if (this.w0.L0() != null) {
                    this.w0.L0().d();
                }
            }
            c.a.q0.x.x.e eVar = this.R0;
            if (eVar != null) {
                eVar.K();
            }
            ForumManageModel forumManageModel = this.z0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.V;
            if (likeModel != null) {
                likeModel.I();
            }
            c.a.r0.k2.k.e.s0 s0Var = this.D0;
            if (s0Var != null) {
                s0Var.O1();
                c.a.r0.k2.k.e.g1.c cVar2 = this.D0.f20417h;
                if (cVar2 != null) {
                    cVar2.x();
                }
            }
            c.a.q0.q0.b bVar = this.y;
            if (bVar != null) {
                bVar.c();
            }
            c.a.r0.k2.k.e.c1.b bVar2 = this.f55021i;
            if (bVar2 != null) {
                bVar2.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            c.a.r0.k2.k.e.s0 s0Var2 = this.D0;
            if (s0Var2 != null) {
                s0Var2.e0();
            }
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.R1);
            MessageManager.getInstance().unRegisterListener(this.e1);
            MessageManager.getInstance().unRegisterListener(this.mFirstFloorPraiseListener);
            MessageManager.getInstance().unRegisterListener(this.S1);
            MessageManager.getInstance().unRegisterListener(this.T1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.F1);
            MessageManager.getInstance().unRegisterListener(this.z1);
            this.c1 = null;
            this.d1 = null;
            c.a.r0.z2.j0.a.e().g();
            if (this.f1 != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f1);
            }
            c.a.r0.k2.k.e.b1.f.a aVar = this.U;
            if (aVar != null) {
                aVar.f();
            }
            c.a.r0.k2.k.e.s0 s0Var3 = this.D0;
            if (s0Var3 != null && (cVar = s0Var3.f20417h) != null) {
                cVar.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.C0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            c.a.r0.k2.k.e.u0 u0Var = this.mContentProcessController;
            if (u0Var != null) {
                u0Var.j();
            }
            PbModel pbModel2 = this.w0;
            if (pbModel2 != null && pbModel2.e0() != null) {
                this.w0.e0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.mReplyPrivacyController;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            c.a.r0.k2.k.e.s0 s0Var4 = this.D0;
            if (s0Var4 != null) {
                s0Var4.E3();
            }
            c.a.r0.k2.k.e.e1.a aVar2 = this.t0;
            if (aVar2 != null) {
                aVar2.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.sortSwitchId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.e.l.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (c.a.e.l.e.q) invokeV.objValue;
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        c.a.r0.k2.k.e.s0 s0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048727, this, i3, keyEvent)) == null) ? (keyEvent == null || (s0Var = this.D0) == null || !s0Var.Q1(i3)) ? false : true : invokeIL.booleanValue;
    }

    @Override // c.a.q0.f1.m.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048728, this, context, str) == null) {
            this.A = true;
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onLinkClicked(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048729, this, context, str, z3) == null) {
            if (c.a.r0.k2.k.e.x0.c(str) && (pbModel = this.w0) != null && pbModel.f1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.w0.f1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    c.a.q0.u.l lVar = new c.a.q0.u.l();
                    lVar.f15072a = str;
                    lVar.f15073b = 3;
                    lVar.f15074c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, lVar));
                }
            } else {
                c.a.r0.k2.k.e.x0.a().e(getPageContext(), str);
            }
            this.A = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            v3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
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
            c.a.r0.k2.k.e.s0 s0Var = this.D0;
            if (s0Var != null) {
                s0Var.T1();
            }
            if (!this.w0.D0()) {
                this.R0.W(this.w0.f1());
            }
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                pbModel.I1();
            }
            c.a.q0.a.d.y().E();
            MessageManager.getInstance().unRegisterListener(this.x1);
            x3();
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.R1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048732, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.J0 = str;
        if (this.q == null) {
            d3();
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
        if (interceptable == null || interceptable.invokeL(1048733, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            this.k = false;
            super.onResume();
            if (this.S) {
                this.S = false;
                goInterviewLivePage();
            }
            if (f3()) {
                this.z = System.currentTimeMillis();
            } else {
                this.z = -1L;
            }
            c.a.r0.k2.k.e.s0 s0Var = this.D0;
            if (s0Var != null && s0Var.b1() != null) {
                if (!this.l) {
                    P3();
                } else {
                    hideLoadingView(this.D0.b1());
                }
                this.D0.U1();
            }
            if (this.p == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            c.a.r0.k2.k.e.s0 s0Var2 = this.D0;
            NoNetworkView a4 = s0Var2 != null ? s0Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && c.a.e.e.p.j.z()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.x1);
            this.L0 = false;
            z3();
            registerListener(this.O1);
            registerListener(this.P1);
            registerListener(this.R1);
            if (this.k1) {
                v3();
                this.k1 = false;
            }
            U3();
            ItemCardHelper.v(this.r2);
            DownloadData downloadData = new DownloadData();
            downloadData.setStatus(10);
            c.a.q0.w.c.q().w(downloadData);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.w0.X1(bundle);
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.R0.M(bundle);
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048736, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048737, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
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
            c.a.r0.k2.k.e.g1.c cVar = this.D0.f20417h;
            if (cVar != null && !cVar.t()) {
                this.D0.f20417h.x();
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.P0() != null && this.w0.P0().m() != null && this.w0.P0().O() != null) {
                c.a.q0.v.a.k().y(getPageContext().getPageActivity(), "pb", this.w0.P0().m().getId(), c.a.e.e.m.b.g(this.w0.P0().O().f0(), 0L));
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            c.a.r0.j3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048739, this, view, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048740, this, z3) == null) {
            super.onUserChanged(z3);
            this.D0.H3(z3);
            PopupDialog popupDialog = this.H0;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            if (z3 && this.L0) {
                this.D0.T2();
                this.w0.A1(true);
            }
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048741, this, context, str) == null) {
            c.a.r0.k2.k.e.x0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.A = true;
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048742, this, context, str) == null) {
        }
    }

    public void openMore() {
        PbModel pbModel;
        c.a.r0.k2.h.e P0;
        c.a.q0.s.q.d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048743, this) == null) || (pbModel = this.w0) == null || pbModel.P0() == null || (O = (P0 = this.w0.P0()).O()) == null || O.J() == null) {
            return;
        }
        this.D0.f1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.J().getUserId());
        c.a.r0.k2.k.e.e0 e0Var = new c.a.r0.k2.k.e.e0();
        int V = this.w0.P0().V();
        if (V != 1 && V != 3) {
            e0Var.f20234g = false;
        } else {
            e0Var.f20234g = true;
            e0Var.s = O.r0() == 1;
        }
        if (isMakeGoodsShowing(V)) {
            e0Var.f20235h = true;
            e0Var.r = O.q0() == 1;
        } else {
            e0Var.f20235h = false;
        }
        if (V == 1002 && !equals) {
            e0Var.u = true;
        }
        e0Var.n = K3(O.S1(), P0.h0(), equals, V, O.I2(), O.s2());
        e0Var.f20232e = I3(equals, P0.h0());
        e0Var.f20236i = L3();
        e0Var.f20233f = J3(equals);
        e0Var.k = equals && P0.U() != null && P0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            e0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().f();
        }
        e0Var.t = equals;
        e0Var.q = this.w0.d1();
        e0Var.f20229b = true;
        e0Var.f20228a = h3(equals);
        if (equals) {
            this.D0.v1();
        }
        e0Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        e0Var.f20237j = true;
        e0Var.o = this.w0.t0();
        e0Var.f20231d = true;
        if (O.q1() == null) {
            e0Var.f20230c = true;
        } else {
            e0Var.f20230c = false;
        }
        if (P0.f0()) {
            e0Var.f20229b = false;
            e0Var.f20231d = false;
            e0Var.f20230c = false;
            e0Var.f20234g = false;
            e0Var.f20235h = false;
        }
        e0Var.v = TbSingleton.getInstance().mShowCallFans && equals && !P0.f0();
        c.a.r0.k2.k.e.s0 s0Var = this.D0;
        if (s0Var != null) {
            PbModel pbModel2 = this.w0;
            PostData x02 = s0Var.x0(pbModel2.J, pbModel2.d1());
            e0Var.w = x02 != null ? x02.S : false;
        }
        e0Var.m = true;
        if (c.a.q0.g1.b.c.d()) {
            e0Var.f20231d = false;
            e0Var.f20229b = false;
            e0Var.f20230c = false;
            e0Var.m = false;
        }
        if (O.S1()) {
            e0Var.n = false;
            e0Var.f20234g = false;
            e0Var.f20235h = false;
        }
        this.D0.f20417h.E(e0Var);
    }

    public final void p3(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, view) == null) {
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

    public void processProfessionPermission() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || !checkUpIsLogin() || (pbModel = this.w0) == null || pbModel.P0() == null || this.w0.P0().m() == null || B2()) {
            return;
        }
        if (this.w0.P0().f0()) {
            this.D0.X();
            return;
        }
        if (this.U0 == null) {
            c.a.r0.x0.g2.a.c cVar = new c.a.r0.x0.g2.a.c(getPageContext());
            this.U0 = cVar;
            cVar.j(0);
            this.U0.i(new v0(this));
        }
        this.U0.g(this.w0.P0().m().getId(), c.a.e.e.m.b.g(this.w0.f1(), 0L));
    }

    public final boolean q3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048746, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p3 = c.a.q0.s.d0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    c.a.q0.m.a.p(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            if (!c.a.e.e.p.j.z()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.D0.e0();
            if (this.m) {
                return;
            }
            stopVoice();
            this.D0.S2();
            if (this.w0.loadData()) {
                this.D0.w3();
            }
        }
    }

    public void refGodReplyFloor(c.a.r0.k2.h.r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, rVar) == null) {
            String E = rVar.i().E();
            List<PostData> list = this.w0.P0().T().f19871a;
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
            if (this.w0.z0()) {
                return;
            }
            this.D0.u1(this.w0.P0());
        }
    }

    public void refreshMark(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048749, this, z3, markData) == null) {
            this.D0.R2();
            this.w0.p2(z3);
            c.a.q0.i.a aVar = this.y0;
            if (aVar != null) {
                aVar.h(z3);
                if (markData != null) {
                    this.y0.i(markData);
                }
            }
            if (this.w0.B0()) {
                n3();
            } else {
                this.D0.u1(this.w0.P0());
            }
        }
    }

    public void refreshWrite(c.a.r0.k2.h.r rVar) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048750, this, rVar) == null) || rVar.i() == null) {
            return;
        }
        String E = rVar.i().E();
        ArrayList<PostData> F = this.w0.P0().F();
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
                            next.B0(getPageContext(), this.w0.y1(metaData.getUserId()));
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
        if (!this.w0.z0() && z3) {
            this.D0.u1(this.w0.P0());
        }
        if (z3) {
            refGodReplyFloor(rVar);
        }
    }

    public void removeBackInterceptor(a3 a3Var) {
        List<a3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048751, this, a3Var) == null) || a3Var == null || (list = this.n1) == null) {
            return;
        }
        list.remove(a3Var);
    }

    @Override // c.a.r0.k2.p.f.b
    public void resetLoadMoreFlag(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048752, this, z3) == null) {
            this.L0 = z3;
        }
    }

    public final boolean richTextHandleSingleTap(View view) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048753, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.x0 && !TextUtils.isEmpty(postData.u()) && c.a.q0.s.k.c().g()) {
                        return q3(postData.E());
                    }
                    if (checkUpIsLogin() && (pbModel = this.w0) != null && pbModel.P0() != null) {
                        if (getPbView().P0() != null) {
                            getPbView().P0().c();
                        }
                        c.a.r0.k2.h.r rVar = new c.a.r0.k2.h.r();
                        rVar.A(this.w0.P0().m());
                        rVar.E(this.w0.P0().O());
                        rVar.C(postData);
                        getPbView().O0().S(rVar);
                        getPbView().O0().setPostId(postData.E());
                        m3(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        c.a.q0.x.x.e eVar = this.R0;
                        if (eVar != null) {
                            this.D0.x2(eVar.E());
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

    public final void s3(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048754, this, str, i3, eVar) == null) || eVar == null) {
            return;
        }
        c.a.r0.k2.h.e P0 = this.w0.P0();
        TbRichText f4 = f4(str, i3);
        if (f4 == null || (tbRichTextData = f4.y().get(this.i2)) == null) {
            return;
        }
        eVar.f54989f = String.valueOf(f4.getPostId());
        eVar.f54984a = new ArrayList<>();
        eVar.f54985b = new ConcurrentHashMap<>();
        if (!tbRichTextData.C().D()) {
            eVar.f54991h = false;
            String a4 = c.a.r0.k2.h.f.a(tbRichTextData);
            eVar.f54984a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.w ? 17 : 18;
            }
            imageUrlData.originalUrl = S2(tbRichTextData);
            imageUrlData.originalUrl = S2(tbRichTextData);
            imageUrlData.originalSize = T2(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = R2(tbRichTextData);
            imageUrlData.isLongPic = Q2(tbRichTextData);
            imageUrlData.postId = f4.getPostId();
            imageUrlData.mIsReserver = this.w0.a1();
            imageUrlData.mIsSeeHost = this.w0.t0();
            eVar.f54985b.put(a4, imageUrlData);
            if (P0 != null) {
                if (P0.m() != null) {
                    eVar.f54986c = P0.m().getName();
                    eVar.f54987d = P0.m().getId();
                }
                if (P0.O() != null) {
                    eVar.f54988e = P0.O().f0();
                }
                eVar.f54990g = P0.t() == 1;
            }
            imageUrlData.threadId = c.a.e.e.m.b.g(eVar.f54988e, -1L);
            return;
        }
        eVar.f54991h = true;
        int size = P0.F().size();
        this.k2 = false;
        eVar.f54993j = -1;
        int P2 = P0.j() != null ? P2(P0.j().K(), f4, i3, i3, eVar.f54984a, eVar.f54985b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = P0.F().get(i4);
            if (postData.E() == null || P0.j() == null || P0.j().E() == null || !postData.E().equals(P0.j().E())) {
                P2 = P2(postData.K(), f4, P2, i3, eVar.f54984a, eVar.f54985b);
            }
        }
        if (eVar.f54984a.size() > 0) {
            ArrayList<String> arrayList = eVar.f54984a;
            eVar.f54992i = arrayList.get(arrayList.size() - 1);
        }
        if (P0 != null) {
            if (P0.m() != null) {
                eVar.f54986c = P0.m().getName();
                eVar.f54987d = P0.m().getId();
            }
            if (P0.O() != null) {
                eVar.f54988e = P0.O().f0();
            }
            eVar.f54990g = P0.t() == 1;
        }
        eVar.f54993j = P2;
    }

    public void setNavigationBarShowFlag(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z3) == null) {
            this.R = z3;
        }
    }

    public void setShowLinkGoodsMore(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z3) == null) {
            this.O = z3;
        }
    }

    public final void stopVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            AbsPbActivity absPbActivity = this.f55017e;
            if (absPbActivity != null) {
                absPbActivity.stopVoice();
            }
        }
    }

    public final AbsPbActivity.e t3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048758, this, str)) == null) {
            String str2 = null;
            if (this.w0.P0() != null && this.w0.P0().F() != null && this.w0.P0().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.w0.P0().F().size()) {
                        i3 = 0;
                        break;
                    } else if (str.equals(this.w0.P0().F().get(i3).E())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                PostData postData = this.w0.P0().F().get(i3);
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
                    s3(str2, 0, eVar);
                    c.a.r0.k2.h.f.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void u3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048759, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.f55018f ? 2 : 3));
        view.setTag(sparseArray);
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            hideNetRefreshView(this.D0.b1());
            P3();
            if (this.w0.G1()) {
                this.D0.S2();
            }
            this.D0.Z2();
        }
    }

    public final void w3(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048761, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.U == null) {
            c.a.r0.k2.k.e.b1.f.a aVar = new c.a.r0.k2.k.e.b1.f.a(this.f55017e);
            this.U = aVar;
            aVar.n(this.X0);
            this.U.m(this.W1);
        }
        this.U.k(emotionImageData, getPbModel(), getPbModel().P0());
    }

    public final void x3() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048762, this) == null) || (pbModel = this.w0) == null || pbModel.P0() == null || this.w0.P0().O() == null || !this.w0.P0().O().E2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public final void y2() {
        PbModel pbModel;
        c.a.r0.k2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048763, this) == null) || (pbModel = this.w0) == null || (eVar = pbModel.J) == null || eVar.O() == null) {
            return;
        }
        c.a.q0.s.q.d2 O = this.w0.J.O();
        O.Z0 = this.w0.U0();
        O.Y0 = this.w0.X0();
        O.X0 = this.w0.W0();
        O.a1 = this.w0.V0();
        O.H2 = this.w0.D0();
        if (O.T() == 0) {
            O.D3(c.a.e.e.m.b.g(this.w0.getForumId(), 0L));
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

    public final void y3(boolean z3, PostData postData) {
        c.a.q0.t.c.d adAdSense;
        c.a.r0.k2.k.e.s0 s0Var;
        c.a.r0.k2.k.e.h p02;
        ArrayList<PostData> E;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048764, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g() || (s0Var = this.D0) == null || (p02 = s0Var.p0()) == null || (E = p02.E()) == null) {
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
                    cVar.f21109b = E2;
                    cVar.f21110c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.E == 1 && !TextUtils.isEmpty(E2)) {
                next.E = 2;
                a.c cVar2 = new a.c();
                cVar2.f21109b = E2;
                cVar2.f21110c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.P0() == null || this.w0.P0().m() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.w0.P0().m().getFirst_class();
                str2 = this.w0.P0().m().getSecond_class();
                str3 = this.w0.P0().m().getId();
                str4 = this.w0.f1();
                str = first_class;
            }
            c.a.r0.z2.z.v(z3, str, str2, str3, str4, arrayList, adAdSense.i());
        }
    }

    public final void z2(boolean z3) {
        PbModel pbModel;
        c.a.r0.k2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048765, this, z3) == null) || (pbModel = this.w0) == null || (eVar = pbModel.J) == null || eVar.O() == null) {
            return;
        }
        c.a.q0.s.q.d2 O = this.w0.J.O();
        O.Z0 = this.w0.U0();
        O.Y0 = this.w0.X0();
        O.X0 = this.w0.W0();
        O.a1 = this.w0.V0();
        if (O.T() == 0) {
            O.D3(c.a.e.e.m.b.g(this.w0.getForumId(), 0L));
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

    public final void z3() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048766, this) == null) || (pbModel = this.w0) == null || pbModel.P0() == null || this.w0.P0().O() == null || !this.w0.P0().O().E2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.f1.m.i
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            c.a.r0.k2.k.e.s0 s0Var = this.D0;
            if (s0Var == null) {
                return null;
            }
            return s0Var.G0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void deleteThread(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048644, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(c.a.r0.k2.k.e.s0.W1)).intValue();
            if (intValue == c.a.r0.k2.k.e.s0.X1) {
                if (this.z0.P()) {
                    return;
                }
                this.D0.D3();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.tag_is_block_thread) != null ? ((Boolean) sparseArray.get(R.id.tag_is_block_thread)).booleanValue() : false;
                if (jSONArray != null) {
                    this.z0.R(StringHelper.JsonArrayToString(jSONArray));
                }
                this.z0.S(this.w0.P0().m().getId(), this.w0.P0().m().getName(), this.w0.P0().O().f0(), str, intValue3, intValue2, booleanValue, this.w0.P0().O().L(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == c.a.r0.k2.k.e.s0.Y1 || intValue == c.a.r0.k2.k.e.s0.a2) {
                if (this.w0.m0() != null) {
                    this.w0.m0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == c.a.r0.k2.k.e.s0.Y1) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }
}
