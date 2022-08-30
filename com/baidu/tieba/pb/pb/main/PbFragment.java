package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ForumUserLiveActiivtyConfig;
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
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.FirstPraiseToast;
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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
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
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tbadk.switchs.PbLoadingViewOptimizeSwitch;
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
import com.baidu.tieba.a18;
import com.baidu.tieba.aa5;
import com.baidu.tieba.al8;
import com.baidu.tieba.an;
import com.baidu.tieba.au7;
import com.baidu.tieba.ay7;
import com.baidu.tieba.b28;
import com.baidu.tieba.ba7;
import com.baidu.tieba.bb;
import com.baidu.tieba.bx7;
import com.baidu.tieba.c9;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cm4;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cp4;
import com.baidu.tieba.cu7;
import com.baidu.tieba.cw7;
import com.baidu.tieba.d25;
import com.baidu.tieba.d9;
import com.baidu.tieba.dj4;
import com.baidu.tieba.ds4;
import com.baidu.tieba.ds8;
import com.baidu.tieba.dv4;
import com.baidu.tieba.dx7;
import com.baidu.tieba.dz4;
import com.baidu.tieba.ej4;
import com.baidu.tieba.eo4;
import com.baidu.tieba.eu6;
import com.baidu.tieba.eu7;
import com.baidu.tieba.f15;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.fg5;
import com.baidu.tieba.fs4;
import com.baidu.tieba.g25;
import com.baidu.tieba.gg;
import com.baidu.tieba.gr4;
import com.baidu.tieba.gs8;
import com.baidu.tieba.hg;
import com.baidu.tieba.hs4;
import com.baidu.tieba.hz5;
import com.baidu.tieba.il8;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.iq4;
import com.baidu.tieba.j05;
import com.baidu.tieba.jb8;
import com.baidu.tieba.jf5;
import com.baidu.tieba.jx7;
import com.baidu.tieba.kj8;
import com.baidu.tieba.km4;
import com.baidu.tieba.kq4;
import com.baidu.tieba.kw7;
import com.baidu.tieba.kz7;
import com.baidu.tieba.l05;
import com.baidu.tieba.lv4;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mp4;
import com.baidu.tieba.mt7;
import com.baidu.tieba.mv4;
import com.baidu.tieba.mz7;
import com.baidu.tieba.n05;
import com.baidu.tieba.n25;
import com.baidu.tieba.n45;
import com.baidu.tieba.ne5;
import com.baidu.tieba.nf5;
import com.baidu.tieba.ni5;
import com.baidu.tieba.no4;
import com.baidu.tieba.nr4;
import com.baidu.tieba.nt7;
import com.baidu.tieba.nu7;
import com.baidu.tieba.nz7;
import com.baidu.tieba.o05;
import com.baidu.tieba.o45;
import com.baidu.tieba.og6;
import com.baidu.tieba.ol8;
import com.baidu.tieba.ou7;
import com.baidu.tieba.ow7;
import com.baidu.tieba.oz7;
import com.baidu.tieba.p05;
import com.baidu.tieba.p08;
import com.baidu.tieba.p45;
import com.baidu.tieba.p55;
import com.baidu.tieba.pa5;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pd8;
import com.baidu.tieba.pg;
import com.baidu.tieba.pi;
import com.baidu.tieba.pn;
import com.baidu.tieba.po5;
import com.baidu.tieba.ps7;
import com.baidu.tieba.pu4;
import com.baidu.tieba.py7;
import com.baidu.tieba.pz7;
import com.baidu.tieba.q45;
import com.baidu.tieba.q87;
import com.baidu.tieba.qe5;
import com.baidu.tieba.qi;
import com.baidu.tieba.qi5;
import com.baidu.tieba.qw4;
import com.baidu.tieba.qx4;
import com.baidu.tieba.r05;
import com.baidu.tieba.ra5;
import com.baidu.tieba.ri;
import com.baidu.tieba.rp4;
import com.baidu.tieba.rs7;
import com.baidu.tieba.ru7;
import com.baidu.tieba.s45;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sg;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.ss7;
import com.baidu.tieba.t87;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tn;
import com.baidu.tieba.tn4;
import com.baidu.tieba.tq4;
import com.baidu.tieba.tu4;
import com.baidu.tieba.ty7;
import com.baidu.tieba.tz4;
import com.baidu.tieba.u25;
import com.baidu.tieba.u45;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.ux7;
import com.baidu.tieba.uy7;
import com.baidu.tieba.uz7;
import com.baidu.tieba.v56;
import com.baidu.tieba.v75;
import com.baidu.tieba.v95;
import com.baidu.tieba.va5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vz7;
import com.baidu.tieba.w56;
import com.baidu.tieba.wr4;
import com.baidu.tieba.x25;
import com.baidu.tieba.xv7;
import com.baidu.tieba.xx7;
import com.baidu.tieba.y15;
import com.baidu.tieba.y25;
import com.baidu.tieba.yo6;
import com.baidu.tieba.yr4;
import com.baidu.tieba.yy7;
import com.baidu.tieba.z25;
import com.baidu.tieba.zk8;
import com.baidu.tieba.zu4;
import com.baidu.tieba.zx7;
import com.baidu.tieba.zy7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public class PbFragment extends BaseFragment implements qi5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, wr4.e, TbRichTextView.s, TbPageContextSupport, a18, b28.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k T2;
    public static final w56.b U2;
    public transient /* synthetic */ FieldHolder $fh;
    public gg<TextView> A;
    public cm4 A0;
    public CustomMessageListener A1;
    public final BdListView.p A2;
    public gg<TbImageView> B;
    public ForumManageModel B0;
    public CustomMessageListener B1;
    public int B2;
    public gg<ImageView> C;
    public tz4 C0;
    public CustomMessageListener C1;
    public final TbRichTextView.y C2;
    public gg<View> D;
    public eu7 D0;
    public CustomMessageListener D1;
    public boolean D2;
    public gg<TiebaPlusRecommendCard> E;
    public PollingModel E0;
    public CustomMessageListener E1;
    public PostData E2;
    public gg<LinearLayout> F;
    public ShareSuccessReplyToServerModel F0;
    public CustomMessageListener F1;
    public final yr4.c F2;
    public gg<RelativeLayout> G;
    public ux7 G0;
    public final CustomMessageListener G1;
    public final yr4.c G2;
    public gg<ItemCardView> H;
    public boolean H0;
    public CustomMessageListener H1;
    public final AdapterView.OnItemClickListener H2;
    public boolean I;
    public boolean I0;
    public CustomMessageListener I1;
    public final View.OnLongClickListener I2;
    public boolean J;
    public boolean J0;
    public View.OnClickListener J1;
    public final View.OnClickListener J2;
    public boolean K;
    public xx7 K0;
    public CustomMessageListener K1;
    public final ItemCardHelper.c K2;
    public gg<GifView> L;
    public fs4 L0;
    public CustomMessageListener L1;
    public final NoNetworkView.b L2;
    public String M;
    public hs4 M0;
    public CustomMessageListener M1;
    public View.OnTouchListener M2;
    public boolean N;
    public String N0;
    public SuggestEmotionModel.c N1;
    public v56.b N2;
    public boolean O;
    public boolean O0;
    public CustomMessageListener O1;
    public final kw7.b O2;
    public String P;
    public boolean P0;
    public CustomMessageListener P1;
    public int P2;
    public uy7 Q;
    public boolean Q0;
    public GetSugMatchWordsModel.b Q1;
    public int Q2;
    public LikeModel R;
    public String R0;
    public boolean R1;
    public String R2;
    public View S;
    public boolean S0;
    public PraiseModel S1;
    public cp4 S2;
    public View T;
    public al8 T0;
    public zy7.h T1;
    public View U;
    public s45 U0;
    public CustomMessageListener U1;
    public View V;
    public q45 V0;
    public v75 V1;
    public String W;
    public boolean W0;
    public CheckRealNameModel.b W1;
    public int X;
    public PermissionJudgePolicy X0;
    public ou7 X1;
    public boolean Y;
    public ReplyPrivacyCheckController Y0;
    public final Runnable Y1;
    public int[] Z;
    public yo6 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public yo6 a1;
    public CustomMessageListener a2;
    public boolean b;
    public int b0;
    public EmotionImageData b1;
    public CustomMessageListener b2;
    public boolean c;
    public int c0;
    public o45 c1;
    public CustomMessageListener c2;
    public w56 d;
    public tq4 d0;
    public n45 d1;
    public CustomMessageListener d2;
    public zy7 e;
    public BdUniqueId e0;
    public n45 e1;
    public CustomMessageListener e2;
    public boolean f;
    public pu4 f0;
    public int f1;
    public CustomMessageListener f2;
    public boolean g;
    public boolean g0;
    public Object g1;
    public CustomMessageListener g2;
    public boolean h;
    public boolean h0;
    public d9 h1;
    public wr4.e h2;
    public boolean i;
    public Object i0;
    public zu4 i1;
    public hs4.e i2;
    public boolean j;
    public zk8 j0;
    public BdUniqueId j1;
    public SortSwitchButton.f j2;
    public VoiceManager k;
    public Runnable k1;
    public final View.OnClickListener k2;
    public int l;
    public zx7 l1;
    public CustomMessageListener l2;
    public yr4 m;
    public an m1;
    public final NewWriteModel.e m2;
    public long n;
    public String n1;
    public Boolean n2;
    public long o;
    public TbRichTextImageInfo o1;
    public NewWriteModel.e o2;
    public long p;
    public TbRichTextMemeInfo p1;
    public bb p2;
    public long q;
    public boolean q0;
    public boolean q1;
    public final PbModel.h q2;
    public long r;
    public o05 r0;
    public int r1;
    public CustomMessageListener r2;
    public boolean s;
    public boolean s0;
    public int s1;
    public HttpMessageListener s2;
    public boolean t;
    public boolean t0;
    public List<g3> t1;
    public final cm4.a t2;
    public pa5 u;
    @NonNull
    public TiePlusEventController.f u0;
    public int u1;
    public final AbsListView.OnScrollListener u2;
    public long v;
    public kz7 v0;
    public String v1;
    public final c9 v2;
    public boolean w;
    public PbInterviewStatusView.f w0;
    public hz5 w1;
    public final i3 w2;
    public long x;
    public final Handler x0;
    public final g3 x1;
    public final dv4.g x2;
    public int y;
    public PbModel y0;
    public final bx7.b y1;
    public final View.OnClickListener y2;
    public String z;
    public vz7 z0;
    public final CustomMessageListener z1;
    public boolean z2;

    /* loaded from: classes5.dex */
    public static class a implements w56.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.w56.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    nu7.d();
                } else {
                    nu7.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public a0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(ty7 ty7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ty7Var) == null) || ty7Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, ty7Var.c()));
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.S5() == null) {
                return;
            }
            this.a.S5().p2();
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public a2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a3 implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public a3(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.x(this.a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.getView(), j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.a.getContext(), ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.getView(), 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements kw7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public b(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.kw7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f14cf);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c40);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.G0.k0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.a.G0 == null || this.a.y0 == null) {
                return;
            }
            this.a.G0.g0(false);
            if (this.a.y0.N2(false)) {
                this.a.G0.x3();
            } else if (this.a.y0.S1() != null) {
                this.a.G0.N2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
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
            this.a.q1 = true;
        }
    }

    /* loaded from: classes5.dex */
    public class b2 extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public b2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.a.B0.getLoadDataMode()) {
                        case 0:
                            this.a.y0.v2();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.s5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.G0.w0(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.a;
                            pbFragment.t5(pbFragment.B0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.a.G0.w0(this.a.B0.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.G0.u2(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                this.a.G0.w0(this.a.B0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b3 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public b3(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.g && z && !this.a.y0.H1()) {
                    this.a.V6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(ri.f(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public c(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    wr4Var.dismiss();
                    ((TbPageContext) this.a.h1).showToast(R.string.obfuscated_res_0x7f0f070d);
                    return;
                }
                TiebaStatic.log("c10025");
                wr4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.h1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (this.a.s0) {
                this.a.s0 = false;
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.M6();
            } else {
                this.a.X6();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c1() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public c2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) || wr4Var == null) {
                return;
            }
            wr4Var.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c3 implements hg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public c3(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
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
        @Override // com.baidu.tieba.hg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f091849);
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

    /* loaded from: classes5.dex */
    public class d implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements GetSugMatchWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                BdLog.e(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.a.G0 == null) {
                return;
            }
            this.a.G0.B3(list);
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.a.e6();
                iq4 Q1 = this.a.y0.Q1();
                int Y0 = this.a.G0.Y0();
                if (Y0 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0de4);
                } else if (Q1 == null || Y0 <= Q1.h()) {
                    this.a.G0.m0();
                    this.a.H7();
                    this.a.G0.w3();
                    if (pi.z()) {
                        this.a.y0.F3(this.a.G0.Y0());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c40);
                    }
                    wr4Var.dismiss();
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0de4);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements i3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }
    }

    /* loaded from: classes5.dex */
    public class d3 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d3(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                FrameLayout frameLayout = (FrameLayout) this.a.getPageContext().getPageActivity().getWindow().getDecorView();
                for (int i = 0; i < frameLayout.getChildCount(); i++) {
                    View childAt = frameLayout.getChildAt(i);
                    if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                        break;
                    }
                }
                this.a.d.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public e(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public e0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.R1 = false;
                if (this.a.S1 == null || str == null) {
                    return;
                }
                if (AntiHelper.m(i, str)) {
                    AntiHelper.u(this.a.getPageContext().getPageActivity(), str);
                } else {
                    this.a.showToast(str);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.R1 = false;
                if (this.a.S1 == null) {
                    return;
                }
                mt7 S1 = this.a.y0.S1();
                if (S1.O().getPraise().getIsLike() == 1) {
                    this.a.P7(0);
                } else {
                    this.a.P7(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, S1.O()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements hs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public e1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.hs4.e
        public void i0(hs4 hs4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hs4Var, i, view2) == null) {
                if (this.a.L0 != null) {
                    this.a.L0.dismiss();
                }
                this.a.M7(i);
                if (i == -4) {
                    View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b9);
                    this.a.R6(view3);
                    if (view3 != null) {
                        view3.performClick();
                    }
                } else if (i == -3) {
                    SparseArray sparseArray2 = (SparseArray) view2.getTag();
                    View view4 = (View) sparseArray2.get(R.id.obfuscated_res_0x7f0917b8);
                    this.a.R6(view4);
                    if (view4 != null) {
                        if (sparseArray2 != null && (sparseArray2.get(R.id.obfuscated_res_0x7f092004) instanceof Boolean)) {
                            if (((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092004)).booleanValue()) {
                                this.a.e7(true);
                            } else {
                                this.a.e7(false);
                            }
                        }
                        view4.performClick();
                    }
                } else if (i == -2) {
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917bb);
                    if (view5 != null) {
                        AgreeView agreeView = (AgreeView) view5;
                        this.a.R6(view5);
                        if (agreeView.getImgDisagree() != null) {
                            agreeView.getImgDisagree().performClick();
                        }
                    }
                } else if (i == -1) {
                    View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917bb);
                    if (view6 != null) {
                        this.a.R6(view6);
                        AgreeView agreeView2 = (AgreeView) view6;
                        if (agreeView2.getImgAgree() != null) {
                            agreeView2.getImgAgree().performClick();
                        }
                    }
                } else if (i != 13) {
                    int i2 = 4;
                    switch (i) {
                        case 1:
                            if (this.a.m1 == null || TextUtils.isEmpty(this.a.n1)) {
                                return;
                            }
                            if (this.a.p1 == null) {
                                this.a.Y4();
                            } else {
                                p55.a aVar = new p55.a();
                                aVar.a = this.a.n1;
                                String str = "";
                                if (this.a.p1.memeInfo.pck_id.intValue() >= 0) {
                                    str = "" + this.a.p1.memeInfo.pck_id;
                                }
                                aVar.b = str;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                            }
                            this.a.m1 = null;
                            this.a.n1 = null;
                            return;
                        case 2:
                            if (this.a.m1 == null || TextUtils.isEmpty(this.a.n1)) {
                                return;
                            }
                            if (this.a.X0 == null) {
                                this.a.X0 = new PermissionJudgePolicy();
                            }
                            this.a.X0.clearRequestPermissionList();
                            this.a.X0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (this.a.X0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                return;
                            }
                            if (this.a.l1 == null) {
                                PbFragment pbFragment = this.a;
                                pbFragment.l1 = new zx7(pbFragment.getPageContext());
                            }
                            this.a.l1.b(this.a.n1, this.a.m1.n());
                            this.a.m1 = null;
                            this.a.n1 = null;
                            return;
                        case 3:
                            PostData postData = this.a.E2;
                            if (postData != null) {
                                postData.B0();
                                this.a.E2 = null;
                                return;
                            }
                            return;
                        case 4:
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                            if (this.a.checkUpIsLogin()) {
                                this.a.E6(view2);
                                if (this.a.y0.S1().O() == null || this.a.y0.S1().O().getAuthor() == null || this.a.y0.S1().O().getAuthor().getUserId() == null || this.a.A0 == null) {
                                    return;
                                }
                                PbFragment pbFragment2 = this.a;
                                int W5 = pbFragment2.W5(pbFragment2.y0.S1());
                                ThreadData O = this.a.y0.S1().O();
                                if (O.isBJHArticleThreadType()) {
                                    i2 = 2;
                                } else if (O.isBJHVideoThreadType()) {
                                    i2 = 3;
                                } else if (!O.isBJHNormalThreadType()) {
                                    i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.y0.b).param("obj_locate", 2).param("obj_id", this.a.y0.S1().O().getAuthor().getUserId()).param("obj_type", !this.a.A0.e()).param("obj_source", W5).param("obj_param1", i2));
                                return;
                            }
                            return;
                        case 5:
                            if (!pi.z()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                return;
                            }
                            Object tag = view2.getTag();
                            if (tag instanceof String) {
                                TiebaStatic.log(new StatisticItem("c13079"));
                                this.a.c6((String) tag);
                                return;
                            } else if (tag instanceof SparseArray) {
                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                SparseArray<Object> sparseArray3 = (SparseArray) tag;
                                if ((sparseArray3.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean) && ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092046)).booleanValue()) {
                                    sparseArray3.put(R.id.obfuscated_res_0x7f091ffd, 0);
                                    sparseArray3.put(R.id.obfuscated_res_0x7f091fe6, 2);
                                    this.a.e5(sparseArray3);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        case 6:
                            SparseArray sparseArray4 = (SparseArray) view2.getTag();
                            if (sparseArray4 != null && (sparseArray4.get(R.id.obfuscated_res_0x7f091fee) instanceof Integer) && (sparseArray4.get(R.id.obfuscated_res_0x7f091fec) instanceof String) && (sparseArray4.get(R.id.obfuscated_res_0x7f09200a) instanceof Integer) && (sparseArray4.get(R.id.obfuscated_res_0x7f091fed) instanceof Boolean) && (sparseArray4.get(R.id.obfuscated_res_0x7f091ffe) instanceof Boolean)) {
                                boolean booleanValue = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091fed)).booleanValue();
                                int intValue = ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09200a)).intValue();
                                boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ffe)).booleanValue();
                                boolean E = this.a.P().E(TbadkCoreApplication.getCurrentAccount());
                                if (E) {
                                    if (!booleanValue2) {
                                        this.a.p7(sparseArray4, intValue, booleanValue);
                                        return;
                                    } else {
                                        this.a.G0.x2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091fec), intValue, booleanValue, null, E);
                                        return;
                                    }
                                } else if (booleanValue && !booleanValue2) {
                                    this.a.p7(sparseArray4, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.G0.v2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091fec), intValue, booleanValue);
                                    return;
                                }
                            }
                            return;
                        case 7:
                            if (!pi.z()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                return;
                            }
                            SparseArray<Object> sparseArray5 = (SparseArray) view2.getTag();
                            if (sparseArray5 == null) {
                                return;
                            }
                            boolean booleanValue3 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092032)).booleanValue();
                            boolean booleanValue4 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092030)).booleanValue();
                            boolean booleanValue5 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092046)).booleanValue();
                            boolean booleanValue6 = sparseArray5.get(R.id.obfuscated_res_0x7f092002) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092002)).booleanValue() : false;
                            if (!booleanValue3) {
                                if (booleanValue4) {
                                    this.a.G0.v2(((Integer) sparseArray5.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray5.get(R.id.obfuscated_res_0x7f091fec), ((Integer) sparseArray5.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
                                    return;
                                }
                                return;
                            } else if (!booleanValue5) {
                                if (booleanValue6) {
                                    sparseArray5.put(R.id.obfuscated_res_0x7f091fe6, 2);
                                }
                                this.a.G0.A2(view2);
                                return;
                            } else {
                                sparseArray5.put(R.id.obfuscated_res_0x7f091ffd, 1);
                                sparseArray5.put(R.id.obfuscated_res_0x7f091fe6, 2);
                                this.a.e5(sparseArray5);
                                return;
                            }
                        case 8:
                            if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
                                PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fea);
                                if (postData2.q() == null) {
                                    return;
                                }
                                this.a.h5(postData2.q());
                                return;
                            }
                            return;
                        case 9:
                            if (!this.a.checkUpIsLogin() || this.a.y0 == null || this.a.y0.S1() == null) {
                                return;
                            }
                            this.a.a.o1(ds8.c(view2));
                            return;
                        default:
                            return;
                    }
                } else if (!this.a.checkUpIsLogin() || this.a.y0 == null || this.a.y0.S1() == null) {
                } else {
                    this.a.G0.u4(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e2 implements dv4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public e2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.dv4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.F5()) {
                    this.a.a.finish();
                }
                if (!this.a.y0.R2(true)) {
                    this.a.G0.v0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e3 implements v56.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        public e3(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // com.baidu.tieba.v56.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || !e(i2) || this.b.G0 == null || this.b.e == null) {
                return;
            }
            this.b.e.u(true);
            if (Math.abs(i2) > this.a) {
                this.b.e.l();
            }
            if (this.b.F5()) {
                this.b.G0.t1();
                this.b.G0.U2();
            }
        }

        @Override // com.baidu.tieba.v56.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || !e(i2) || this.b.G0 == null || this.b.e == null) {
                return;
            }
            this.b.G0.Z3();
            this.b.e.u(false);
            this.b.e.x();
        }

        @Override // com.baidu.tieba.v56.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.v56.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public final boolean e(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) ? Math.abs(f) >= 1.0f : invokeF.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public f(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.b.G0.R3();
                MessageManager.getInstance().sendMessage(this.a);
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements zy7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public f0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.zy7.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.g7(z);
                if (this.a.G0.O0() != null && z) {
                    this.a.G0.g4(false);
                }
                this.a.G0.m2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public f1(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pbFragment;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                if (wr4Var != null) {
                    wr4Var.dismiss();
                }
                this.d.o5(((Integer) this.a.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091fec), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public f2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.F5()) {
                    this.a.a.finish();
                }
                if (!this.a.y0.R2(true)) {
                    this.a.G0.v0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f3 implements bx7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public f3(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.bx7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.G0.j4(str);
        }

        @Override // com.baidu.tieba.bx7.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public g(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements PbInterviewStatusView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public g0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.G0.g4(!this.a.N);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public g1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g2 implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public g2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.z2 && this.a.F5()) {
                    this.a.v6();
                }
                if (this.a.mIsLogin) {
                    if (!this.a.g0 && this.a.G0 != null && this.a.G0.d0() && this.a.y0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.a.y0.m2());
                        statisticItem.param("fid", this.a.y0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i = 5;
                        if (this.a.y0.x1()) {
                            i = 4;
                        } else if (this.a.y0.y1()) {
                            i = 3;
                        } else if (this.a.y0.A1()) {
                            i = 1;
                        }
                        statisticItem.param("obj_type", i);
                        TiebaStatic.log(statisticItem);
                        this.a.g0 = true;
                    }
                    if (this.a.y0.N2(false)) {
                        this.a.G0.x3();
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if ((this.a.v0 == null || !this.a.y0.H2() || !this.a.v0.d()) && this.a.y0.S1() != null) {
                        this.a.G0.N2();
                    }
                    this.a.z2 = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface g3 {
        boolean onBackPressed();
    }

    /* loaded from: classes5.dex */
    public class h extends jf5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public h(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return oz7.d(this.a.w5(), ShareSwitch.isOn() ? 1 : 6, this.a.y0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements hs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PbFragment e;

        public h0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = pbFragment;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.hs4.e
        public void i0(hs4 hs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hs4Var, i, view2) == null) {
                if (this.e.L0 != null) {
                    this.e.L0.dismiss();
                }
                if (i == 0) {
                    this.e.G0.v2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091fec), ((Integer) this.a.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f092043);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f092045);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f092044);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.j1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.j1);
                    this.e.D7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f092041));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements yo6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public h1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.yo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.yo6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", z ? 5 : 6).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (z) {
                    if (this.a.V0 != null && this.a.V0.a() != null) {
                        this.a.V0.a().A(new n25(45, 27, null));
                    }
                    this.a.G0.f0();
                }
            }
        }

        @Override // com.baidu.tieba.yo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h2 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public h2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.y0 == null) {
                return;
            }
            this.a.y0.loadData();
        }
    }

    /* loaded from: classes5.dex */
    public interface h3 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public class i implements qe5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public i(PbFragment pbFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qe5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.a.getUniqueId() || AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, PbFragment.T2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().a) {
                    if (this.a.x5().s() != null && this.a.x5().s().getGodUserData() != null) {
                        this.a.x5().s().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.y0 == null || this.a.y0.S1() == null || this.a.y0.S1().O() == null || this.a.y0.S1().O().getAuthor() == null) {
                        return;
                    }
                    this.a.y0.S1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public i1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a.G0.m0();
                boolean z = false;
                if (pi.z()) {
                    if (this.a.y0 != null && !this.a.y0.isLoading) {
                        this.a.H7();
                        this.a.G0.w3();
                        z = true;
                        if (this.a.y0.S1() != null && this.a.y0.S1().f != null && this.a.y0.S1().f.size() > i) {
                            int intValue = this.a.y0.S1().f.get(i).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.y0.n2()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.a.y0.L3(intValue)) {
                                this.a.i = true;
                                this.a.G0.k3(true);
                            }
                        }
                    }
                    return z;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                return false;
            }
            return invokeI.booleanValue;
        }

        public final int b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (i == 2) {
                    return 1;
                }
                if (i == 0) {
                    return 2;
                }
                return i == 1 ? 3 : 0;
            }
            return invokeI.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ i2 b;

            public a(i2 i2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {i2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = i2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ru7.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

        public i2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
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
                sg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface i3 {
    }

    /* loaded from: classes5.dex */
    public class j extends jf5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public j(PbFragment pbFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel K = this.b.K();
                if (K != null) {
                    K.t3(this.a);
                }
                return oz7.d(this.b.w5(), 2, K);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j0 extends v75<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment c;

        public j0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o75
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.c.a.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.s(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j1 a;

            public a(j1 j1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                xx7 xx7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (xx7Var = this.a.c.K0) == null || xx7Var.g() == null) {
                    return;
                }
                if (!this.a.c.K0.g().e()) {
                    this.a.c.K0.b(false);
                }
                this.a.c.K0.g().l(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                }
            }
        }

        public j1(PbFragment pbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = ri.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = ri.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = ri.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                PbFragment pbFragment = this.c;
                boolean z = true;
                pbFragment.S5().R0().smoothScrollBy((pbFragment.Z[1] + pbFragment.a0) - i3, 50);
                if (this.c.S5().b1() != null) {
                    this.c.V0.a().setVisibility(8);
                    this.c.S5().b1().o(this.a, this.b, this.c.S5().e1(), (this.c.y0 == null || this.c.y0.S1() == null || this.c.y0.S1().O() == null || !this.c.y0.S1().O().isBjh()) ? false : false);
                    u45 b = this.c.S5().b1().b();
                    if (b != null && this.c.y0 != null && this.c.y0.S1() != null) {
                        b.G(this.c.y0.S1().d());
                        b.c0(this.c.y0.S1().O());
                    }
                    if (this.c.K0.f() == null && this.c.S5().b1().b().t() != null) {
                        this.c.S5().b1().b().t().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.K0.n(pbFragment2.S5().b1().b().t().i());
                        this.c.S5().b1().b().M(this.c.e1);
                    }
                }
                this.c.S5().o1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j2 implements n45 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public j2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.n45
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                xx7 xx7Var = this.a.K0;
                if (xx7Var == null || xx7Var.g() == null || !this.a.K0.g().d()) {
                    return !this.a.g5(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.K0.g().c());
                if (this.a.G0 != null && this.a.G0.b1() != null && this.a.G0.b1().b() != null && this.a.G0.b1().b().x()) {
                    this.a.G0.b1().b().v(this.a.K0.h());
                }
                this.a.K0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.y0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.V0 != null) {
                this.a.G0.a3(this.a.V0.C());
            }
            this.a.G0.S2();
            this.a.G0.m0();
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public k0(PbFragment pbFragment, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux7 ux7Var = this.b.G0;
                ux7Var.z3("@" + this.a.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements yo6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$k1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0361a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0361a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    xx7 xx7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (xx7Var = this.a.a.c.K0) == null || xx7Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.c.K0.g().e()) {
                        this.a.a.c.K0.b(false);
                    }
                    this.a.a.c.K0.g().l(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                    }
                }
            }

            public a(k1 k1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = k1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = ri.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    PbFragment pbFragment = this.a.c;
                    boolean z = true;
                    pbFragment.S5().R0().smoothScrollBy((pbFragment.Z[1] + pbFragment.a0) - i3, 50);
                    if (this.a.c.S5().b1() != null) {
                        this.a.c.V0.a().setVisibility(8);
                        z = (this.a.c.y0 == null || this.a.c.y0.S1() == null || this.a.c.y0.S1().O() == null || !this.a.c.y0.S1().O().isBjh()) ? false : false;
                        ow7 b1 = this.a.c.S5().b1();
                        k1 k1Var = this.a;
                        b1.o(k1Var.a, k1Var.b, k1Var.c.S5().e1(), z);
                        u45 b = this.a.c.S5().b1().b();
                        if (b != null && this.a.c.y0 != null && this.a.c.y0.S1() != null) {
                            b.G(this.a.c.y0.S1().d());
                            b.c0(this.a.c.y0.S1().O());
                        }
                        if (this.a.c.K0.f() == null && this.a.c.S5().b1().b().t() != null) {
                            this.a.c.S5().b1().b().t().g(new C0361a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.K0.n(pbFragment2.S5().b1().b().t().i());
                            this.a.c.S5().b1().b().M(this.a.c.e1);
                        }
                    }
                    this.a.c.S5().o1();
                }
            }
        }

        public k1(PbFragment pbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.yo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.yo6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", z ? 5 : 6).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (z) {
                    sg.a().postDelayed(new a(this), 200L);
                }
            }
        }

        @Override // com.baidu.tieba.yo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ wr4 c;
        public final /* synthetic */ PbFragment d;

        public k2(PbFragment pbFragment, MarkData markData, MarkData markData2, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, wr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pbFragment;
            this.a = markData;
            this.b = markData2;
            this.c = wr4Var;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
                if (this.d.A0 != null) {
                    if (this.d.A0.e()) {
                        this.d.A0.d();
                        this.d.A0.h(false);
                    }
                    this.d.A0.i(this.a);
                    this.d.A0.h(true);
                    this.d.A0.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.I7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements qe5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbFragment c;

        public l(PbFragment pbFragment, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
            this.a = i;
            this.b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qe5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.c.getContext(), this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public l0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.V0.M(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.G0 != null && this.a.G0.b1() != null && this.a.G0.b1().b() != null) {
                    this.a.G0.b1().b().F();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.a;
                    pbFragment.Z6(pbFragment.b1);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements hs4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fs4 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ l1 c;

            public a(l1 l1Var, fs4 fs4Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var, fs4Var, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = l1Var;
                this.a = fs4Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.y0.j2() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.hs4.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void i0(hs4 hs4Var, int i, View view2) {
                boolean L3;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, hs4Var, i, view2) != null) {
                    return;
                }
                this.a.dismiss();
                int i2 = 3;
                if (this.c.a.y0.j2() != 1 || i != 1) {
                    if (this.c.a.y0.j2() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.y0.j2() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091845 ? 1 : 0).param("obj_type", i2));
                    if (this.c.a.y0.S1().f != null && this.c.a.y0.S1().f.size() > i) {
                        i = this.c.a.y0.S1().f.get(i).sort_type.intValue();
                    }
                    L3 = this.c.a.y0.L3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.y0.i2()));
                    if (L3) {
                        return;
                    }
                    this.c.a.i = true;
                    this.c.a.G0.k3(true);
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091845 ? 1 : 0).param("obj_type", i2));
                if (this.c.a.y0.S1().f != null) {
                    i = this.c.a.y0.S1().f.get(i).sort_type.intValue();
                }
                L3 = this.c.a.y0.L3(i);
                this.b.setTag(Integer.valueOf(this.c.a.y0.i2()));
                if (L3) {
                }
            }
        }

        public l1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX WARN: Code restructure failed: missing block: B:909:0x21ba, code lost:
            if (r7 == (r32.a.G0.c1().c().getHeight() - r32.a.G0.c1().e())) goto L957;
         */
        /* JADX WARN: Code restructure failed: missing block: B:947:0x2346, code lost:
            if (r32.a.G0.d1.c.getView().getTop() <= ((r32.a.G0.c1() == null || r32.a.G0.c1().c() == null) ? 0 : r32.a.G0.c1().c().getBottom())) goto L886;
         */
        /* JADX WARN: Code restructure failed: missing block: B:948:0x2348, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:950:0x2355, code lost:
            if (r0 >= com.baidu.tieba.py7.d(r32.a.J5())) goto L886;
         */
        /* JADX WARN: Code restructure failed: missing block: B:972:0x23fc, code lost:
            if ((r32.a.G0.d1.c.getView().getTop() - r32.a.G0.h.a.getBottom()) < (r32.a.G0.d1.c.g.getHeight() + 10)) goto L886;
         */
        /* JADX WARN: Removed duplicated region for block: B:1235:0x2d48  */
        /* JADX WARN: Removed duplicated region for block: B:1236:0x2d5e  */
        /* JADX WARN: Removed duplicated region for block: B:1239:0x2d9a  */
        /* JADX WARN: Removed duplicated region for block: B:332:0x0b8b  */
        /* JADX WARN: Removed duplicated region for block: B:333:0x0b8f  */
        /* JADX WARN: Removed duplicated region for block: B:336:0x0b9d  */
        /* JADX WARN: Removed duplicated region for block: B:371:0x0c54  */
        /* JADX WARN: Removed duplicated region for block: B:374:0x0c67  */
        /* JADX WARN: Removed duplicated region for block: B:377:0x0c78  */
        /* JADX WARN: Removed duplicated region for block: B:380:0x0c8e  */
        /* JADX WARN: Removed duplicated region for block: B:382:0x0c97  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            ds4 ds4Var;
            ds4 ds4Var2;
            ds4 ds4Var3;
            PbFragment pbFragment;
            int i;
            boolean z;
            ds4 ds4Var4;
            ds4 ds4Var5;
            ds4 ds4Var6;
            ds4 ds4Var7;
            String name;
            int i2;
            boolean z2;
            int fixedNavHeight;
            int i3;
            int i4;
            nr4 nr4Var;
            String jumpUrlWithTid;
            String[] strArr;
            mt7 S1;
            int i5;
            int i6;
            boolean K3;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (this.a.t0 && (view2 == this.a.G0.h.c || view2 == this.a.G0.h.d || view2.getId() == R.id.obfuscated_res_0x7f091824 || view2.getId() == R.id.obfuscated_res_0x7f0909f5 || view2.getId() == R.id.obfuscated_res_0x7f091bb6 || view2.getId() == R.id.obfuscated_res_0x7f0917c5)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.G0.U0() && this.a.getPageContext().getPageActivity() != null && this.a.y0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.m2(), this.a.y0.C2(), this.a.y0.B2())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.y0.getForumId());
                        statisticItem2.param("fname", this.a.y0.r1());
                        statisticItem2.param("tid", this.a.y0.m2());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.G0.W0()) {
                        if (this.a.i) {
                            return;
                        }
                        if (this.a.y0.N2(true)) {
                            this.a.i = true;
                            this.a.G0.x3();
                        }
                    } else if (view2 != this.a.G0.h.m()) {
                        if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().r()) {
                            if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().k()) {
                                if (view2 == this.a.G0.h.f) {
                                    if (this.a.G0.c0(this.a.y0.F1())) {
                                        this.a.H7();
                                        return;
                                    }
                                    this.a.j = false;
                                    this.a.f = false;
                                    ri.x(this.a.a, this.a.G0.h.f);
                                    this.a.a.finish();
                                } else if (view2 != this.a.G0.C0() && (this.a.G0.h.n() == null || (view2 != this.a.G0.h.n().s() && view2 != this.a.G0.h.n().t()))) {
                                    if (view2 == this.a.G0.K0()) {
                                        if (this.a.y0 != null) {
                                            km4.o(this.a.getPageContext().getPageActivity(), this.a.y0.S1().O().getTopicData().b());
                                        }
                                    } else if (view2 != this.a.G0.h.c) {
                                        if (view2 == this.a.G0.h.d) {
                                            if (ne5.a()) {
                                                return;
                                            }
                                            if (this.a.y0 != null && this.a.y0.S1() != null) {
                                                ArrayList<PostData> F = this.a.y0.S1().F();
                                                if ((F == null || F.size() <= 0) && this.a.y0.k2()) {
                                                    ri.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0de0));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.y0.m2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.y0.getForumId()));
                                                if (!this.a.G0.R1()) {
                                                    this.a.G0.S2();
                                                }
                                                this.a.L6();
                                            } else {
                                                ri.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0de0));
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0917e5) {
                                            if (pi.z()) {
                                                this.a.G0.g3(true);
                                                this.a.G0.S2();
                                                if (this.a.i) {
                                                    return;
                                                }
                                                this.a.i = true;
                                                this.a.G0.b4();
                                                this.a.H7();
                                                this.a.G0.w3();
                                                this.a.y0.J3(this.a.A5());
                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                                return;
                                            }
                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f0917c0) {
                                            if ((this.a.G0.h.n() == null || view2 != this.a.G0.h.n().p()) && view2.getId() != R.id.obfuscated_res_0x7f0909f5 && view2.getId() != R.id.obfuscated_res_0x7f091bb6) {
                                                if (this.a.G0.h.n() != null && view2 == this.a.G0.h.n().l()) {
                                                    this.a.G0.h.k();
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e45) {
                                                    if (!this.a.d5(11009)) {
                                                        return;
                                                    }
                                                    this.a.h6(3);
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f0917c5) {
                                                    if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().q()) {
                                                        if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().x()) {
                                                            if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().w()) {
                                                                if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().u()) {
                                                                    if (this.a.G0.O0() == view2) {
                                                                        if (this.a.G0.O0().getIndicateStatus()) {
                                                                            mt7 S12 = this.a.y0.S1();
                                                                            if (S12 != null && S12.O() != null && S12.O().getTaskInfoData() != null) {
                                                                                String d = S12.O().getTaskInfoData().d();
                                                                                if (StringUtils.isNull(d)) {
                                                                                    d = S12.O().getTaskInfoData().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                                            }
                                                                        } else {
                                                                            ol8.d("c10725", null);
                                                                        }
                                                                        this.a.Z5();
                                                                    } else if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().n()) {
                                                                        if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().j()) {
                                                                            if (this.a.G0.h.n() != null && view2 == this.a.G0.h.n().m()) {
                                                                                if (pi.z()) {
                                                                                    SparseArray<Object> S0 = this.a.G0.S0(this.a.y0.S1(), this.a.y0.k2(), 1);
                                                                                    if (S0 != null) {
                                                                                        if (StringUtils.isNull((String) S0.get(R.id.obfuscated_res_0x7f091feb))) {
                                                                                            this.a.G0.v2(((Integer) S0.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) S0.get(R.id.obfuscated_res_0x7f091fec), ((Integer) S0.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) S0.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
                                                                                        } else {
                                                                                            this.a.G0.w2(((Integer) S0.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) S0.get(R.id.obfuscated_res_0x7f091fec), ((Integer) S0.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) S0.get(R.id.obfuscated_res_0x7f091fed)).booleanValue(), (String) S0.get(R.id.obfuscated_res_0x7f091feb));
                                                                                        }
                                                                                    }
                                                                                    this.a.G0.h.k();
                                                                                } else {
                                                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                                                                    return;
                                                                                }
                                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f091f4c && view2.getId() != R.id.obfuscated_res_0x7f091f4a && view2.getId() != R.id.obfuscated_res_0x7f0917d5 && view2.getId() != R.id.obfuscated_res_0x7f09166a) {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f091837) {
                                                                                    if (this.a.y0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                                                                                    statisticItem3.param("tid", this.a.y0.m2());
                                                                                    statisticItem3.param("fid", this.a.y0.getForumId());
                                                                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem3.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem3);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091837 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                        this.a.T = view2;
                                                                                        return;
                                                                                    } else if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                                        if (!(sparseArray2.get(R.id.obfuscated_res_0x7f092007) instanceof PostData)) {
                                                                                            return;
                                                                                        }
                                                                                        PostData postData = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f092007);
                                                                                        StatisticItem statisticItem4 = postData.c0;
                                                                                        if (statisticItem4 != null) {
                                                                                            StatisticItem copy = statisticItem4.copy();
                                                                                            copy.delete("obj_locate");
                                                                                            copy.param("obj_locate", 8);
                                                                                            TiebaStatic.log(copy);
                                                                                        }
                                                                                        if (this.a.y0 == null || this.a.y0.S1() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String m2 = this.a.y0.m2();
                                                                                        String K = postData.K();
                                                                                        int W = this.a.y0.S1() != null ? this.a.y0.S1().W() : 0;
                                                                                        AbsPbActivity.e P6 = this.a.P6(K);
                                                                                        if (P6 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, K, "pb", true, false, null, false, null, W, postData.b0(), this.a.y0.S1().d(), false, postData.s().getIconInfo(), 5).addBigImageData(P6.a, P6.b, P6.g, P6.j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.a.y0.R1());
                                                                                        addBigImageData.setFromFrsForumId(this.a.y0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.a.y0.r2());
                                                                                        addBigImageData.setKeyFromForumId(this.a.y0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.a.y0.I(), this.a.y0.E(), this.a.y0.F(), this.a.y0.D(), this.a.y0.J());
                                                                                        addBigImageData.setBjhData(this.a.y0.k1());
                                                                                        if (this.a.y0.S1().o() != null) {
                                                                                            addBigImageData.setHasForumRule(this.a.y0.S1().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.a.y0.S1().V() != null) {
                                                                                            addBigImageData.setIsManager(this.a.y0.S1().V().getIs_manager());
                                                                                        }
                                                                                        if (this.a.y0.S1().l().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.y0.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.y0.S1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.a.y0.S1().l() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.a.y0.S1().l().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.a.y0.S1().l().getUser_level());
                                                                                        }
                                                                                        if (this.a.G0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.a.G0.I0(this.a.y0.G, this.a.y0.k2()).Q || postData.Q);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091835 || view2.getId() == R.id.obfuscated_res_0x7f091a03 || view2.getId() == R.id.obfuscated_res_0x7f0917cf) {
                                                                                    if (this.a.y0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091835) {
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                                                        statisticItem5.param("tid", this.a.y0.m2());
                                                                                        statisticItem5.param("fid", this.a.y0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem5.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091a03) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                            this.a.U = view2;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091835 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                        this.a.U = view2;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                                                                    if (!(sparseArray3.get(R.id.obfuscated_res_0x7f092007) instanceof PostData)) {
                                                                                        return;
                                                                                    }
                                                                                    PostData postData2 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f092007);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091835 && (statisticItem = postData2.c0) != null) {
                                                                                        StatisticItem copy2 = statisticItem.copy();
                                                                                        copy2.delete("obj_locate");
                                                                                        copy2.param("obj_locate", 8);
                                                                                        TiebaStatic.log(copy2);
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a03 || view2.getId() == R.id.obfuscated_res_0x7f0917cf) {
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.y0.n2()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.K()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.a.y0 == null || this.a.y0.S1() == null || this.a.S5().a1() == null || postData2.s() == null || postData2.B() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.S5().b1() != null) {
                                                                                        this.a.S5().b1().c();
                                                                                    }
                                                                                    if (this.a.q0 && postData2.Y() != null && postData2.Y().size() != 0) {
                                                                                        this.a.G7(postData2, true);
                                                                                    } else {
                                                                                        cu7 cu7Var = new cu7();
                                                                                        cu7Var.A(this.a.y0.S1().l());
                                                                                        cu7Var.E(this.a.y0.S1().O());
                                                                                        cu7Var.C(postData2);
                                                                                        this.a.S5().a1().V(cu7Var);
                                                                                        this.a.S5().a1().setPostId(postData2.K());
                                                                                        this.a.z6(view2, postData2.s().getUserId(), "", postData2);
                                                                                        if (this.a.V0 != null) {
                                                                                            this.a.G0.a3(this.a.V0.C());
                                                                                        }
                                                                                    }
                                                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f0917d3) {
                                                                                    if (view2 != this.a.G0.M0()) {
                                                                                        if (view2 == this.a.G0.h.o()) {
                                                                                            this.a.G0.F3();
                                                                                        } else if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().v()) {
                                                                                            if (this.a.G0.h.n() != null && view2 == this.a.G0.h.n().o()) {
                                                                                                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.y0.m2())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                                                    this.a.G0.h.k();
                                                                                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                                                                }
                                                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f09076f && view2.getId() != R.id.obfuscated_res_0x7f0909f2) {
                                                                                                int id = view2.getId();
                                                                                                if (id == R.id.obfuscated_res_0x7f091855) {
                                                                                                    if (!this.a.checkUpIsLogin() || (nr4Var = (nr4) view2.getTag()) == null || StringUtils.isNull(nr4Var.i1())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{nr4Var.i1()});
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091bb9 || id == R.id.obfuscated_res_0x7f090705 || id == R.id.obfuscated_res_0x7f091bba || id == R.id.obfuscated_res_0x7f090706) {
                                                                                                    if (!this.a.checkUpIsLogin()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view2 != null && view2.getTag() != null) {
                                                                                                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f092007);
                                                                                                        if (id == R.id.obfuscated_res_0x7f091bba || id == R.id.obfuscated_res_0x7f090706) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.y0.b));
                                                                                                        }
                                                                                                        if (this.a.M0 == null) {
                                                                                                            PbFragment pbFragment2 = this.a;
                                                                                                            pbFragment2.M0 = new hs4(pbFragment2.getContext());
                                                                                                            this.a.M0.n(this.a.i2);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.a.p6(view2);
                                                                                                        if (this.a.p6(view2) && this.a.m1 != null) {
                                                                                                            this.a.m1.t();
                                                                                                        }
                                                                                                        if (sparseArray4.get(R.id.obfuscated_res_0x7f092003) instanceof Boolean) {
                                                                                                            ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092003)).booleanValue();
                                                                                                        }
                                                                                                        boolean booleanValue = sparseArray4.get(R.id.obfuscated_res_0x7f091fed) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091fed)).booleanValue() : false;
                                                                                                        boolean booleanValue2 = sparseArray4.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
                                                                                                        boolean booleanValue3 = sparseArray4.get(R.id.obfuscated_res_0x7f092032) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092032)).booleanValue() : false;
                                                                                                        boolean booleanValue4 = sparseArray4.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
                                                                                                        boolean booleanValue5 = sparseArray4.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
                                                                                                        String str = sparseArray4.get(R.id.obfuscated_res_0x7f091ffa) instanceof String ? (String) sparseArray4.get(R.id.obfuscated_res_0x7f091ffa) : null;
                                                                                                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f092002) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092002)).booleanValue() : false;
                                                                                                        if (postData3 != null) {
                                                                                                            if (postData3.V() != null && postData3.V().toString().length() > 0) {
                                                                                                                ds4 ds4Var8 = new ds4(3, this.a.getString(R.string.obfuscated_res_0x7f0f044e), this.a.M0);
                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                sparseArray5.put(R.id.obfuscated_res_0x7f091fea, postData3);
                                                                                                                ds4Var8.d.setTag(sparseArray5);
                                                                                                                arrayList.add(ds4Var8);
                                                                                                            }
                                                                                                            this.a.E2 = postData3;
                                                                                                        }
                                                                                                        if (this.a.y0.S1().r()) {
                                                                                                            String u = this.a.y0.S1().u();
                                                                                                            if (postData3 != null && !qi.isEmpty(u) && u.equals(postData3.K())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    ds4Var4 = new ds4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0fd5), this.a.M0);
                                                                                                                } else {
                                                                                                                    ds4Var4 = new ds4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0a94), this.a.M0);
                                                                                                                }
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f091fea, this.a.E2);
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f092003, Boolean.FALSE);
                                                                                                                ds4Var4.d.setTag(sparseArray6);
                                                                                                                arrayList.add(ds4Var4);
                                                                                                                if (this.a.mIsLogin) {
                                                                                                                    if (mz7.i(this.a.y0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.a.t6(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            ds4 ds4Var9 = new ds4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0ffa), this.a.M0);
                                                                                                                            ds4Var9.d.setTag(str);
                                                                                                                            arrayList.add(ds4Var9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        ds4 ds4Var10 = new ds4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b37), this.a.M0);
                                                                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092001, sparseArray4.get(R.id.obfuscated_res_0x7f092001));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092042, sparseArray4.get(R.id.obfuscated_res_0x7f092042));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092043, sparseArray4.get(R.id.obfuscated_res_0x7f092043));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092041, sparseArray4.get(R.id.obfuscated_res_0x7f092041));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092044, sparseArray4.get(R.id.obfuscated_res_0x7f092044));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092045, sparseArray4.get(R.id.obfuscated_res_0x7f092045));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091fed, sparseArray4.get(R.id.obfuscated_res_0x7f091fed));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091fee, sparseArray4.get(R.id.obfuscated_res_0x7f091fee));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091fec, sparseArray4.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f09200a, sparseArray4.get(R.id.obfuscated_res_0x7f09200a));
                                                                                                                        ds4Var4.d.setTag(sparseArray7);
                                                                                                                        arrayList.add(ds4Var10);
                                                                                                                    }
                                                                                                                    if (booleanValue3) {
                                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f092032, Boolean.TRUE);
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f09200a, sparseArray4.get(R.id.obfuscated_res_0x7f09200a));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091ff7, sparseArray4.get(R.id.obfuscated_res_0x7f091ff7));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091ff8, sparseArray4.get(R.id.obfuscated_res_0x7f091ff8));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091ff9, sparseArray4.get(R.id.obfuscated_res_0x7f091ff9));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091ffa, str);
                                                                                                                        if (booleanValue4) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092001, sparseArray4.get(R.id.obfuscated_res_0x7f092001));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092042, sparseArray4.get(R.id.obfuscated_res_0x7f092042));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092043, sparseArray4.get(R.id.obfuscated_res_0x7f092043));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092041, sparseArray4.get(R.id.obfuscated_res_0x7f092041));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092044, sparseArray4.get(R.id.obfuscated_res_0x7f092044));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092045, sparseArray4.get(R.id.obfuscated_res_0x7f092045));
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        if (booleanValue5) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(booleanValue));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091fec, sparseArray4.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091fee, sparseArray4.get(R.id.obfuscated_res_0x7f091fee));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ffe, sparseArray4.get(R.id.obfuscated_res_0x7f091ffe));
                                                                                                                            if (booleanValue6) {
                                                                                                                                ds4 ds4Var11 = new ds4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.a.M0);
                                                                                                                                ds4Var11.d.setTag(sparseArray8);
                                                                                                                                ds4Var6 = ds4Var11;
                                                                                                                                ds4Var5 = new ds4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e4), this.a.M0);
                                                                                                                                ds4Var5.d.setTag(sparseArray8);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        ds4Var6 = null;
                                                                                                                        ds4Var5 = new ds4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e4), this.a.M0);
                                                                                                                        ds4Var5.d.setTag(sparseArray8);
                                                                                                                    } else if (booleanValue5) {
                                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092032, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f09200a, sparseArray4.get(R.id.obfuscated_res_0x7f09200a));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(booleanValue));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091fec, sparseArray4.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091fee, sparseArray4.get(R.id.obfuscated_res_0x7f091fee));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091ffe, sparseArray4.get(R.id.obfuscated_res_0x7f091ffe));
                                                                                                                        if (this.a.y0.S1().W() == 1002 && !booleanValue) {
                                                                                                                            ds4Var7 = new ds4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0ffa), this.a.M0);
                                                                                                                        } else {
                                                                                                                            ds4Var7 = new ds4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.a.M0);
                                                                                                                        }
                                                                                                                        ds4Var7.d.setTag(sparseArray9);
                                                                                                                        ds4Var6 = ds4Var7;
                                                                                                                        ds4Var5 = null;
                                                                                                                    } else {
                                                                                                                        ds4Var5 = null;
                                                                                                                        ds4Var6 = null;
                                                                                                                    }
                                                                                                                    if (ds4Var6 != null) {
                                                                                                                        arrayList.add(ds4Var6);
                                                                                                                    }
                                                                                                                    if (ds4Var5 != null) {
                                                                                                                        arrayList.add(ds4Var5);
                                                                                                                    }
                                                                                                                }
                                                                                                                this.a.M0.j(arrayList);
                                                                                                                this.a.L0 = new fs4(this.a.getPageContext(), this.a.M0);
                                                                                                                this.a.L0.k();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray62 = new SparseArray();
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f091fea, this.a.E2);
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f092003, Boolean.FALSE);
                                                                                                        ds4Var4.d.setTag(sparseArray62);
                                                                                                        arrayList.add(ds4Var4);
                                                                                                        if (this.a.mIsLogin) {
                                                                                                        }
                                                                                                        this.a.M0.j(arrayList);
                                                                                                        this.a.L0 = new fs4(this.a.getPageContext(), this.a.M0);
                                                                                                        this.a.L0.k();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0917a3) {
                                                                                                    if (this.a.y0.S1() != null && this.a.y0.S1().O() != null && this.a.y0.S1().O().getActUrl() != null) {
                                                                                                        km4.o(this.a.getActivity(), this.a.y0.S1().O().getActUrl());
                                                                                                        if (this.a.y0.S1().O().getActInfoType() != 1) {
                                                                                                            if (this.a.y0.S1().O().getActInfoType() == 2) {
                                                                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                            }
                                                                                                        } else {
                                                                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09142e) {
                                                                                                    if (view2.getTag(R.id.obfuscated_res_0x7f092019) instanceof String) {
                                                                                                        String str2 = (String) view2.getTag(R.id.obfuscated_res_0x7f092019);
                                                                                                        TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.y0.S1().m()).param("tid", this.a.y0.S1().Q()).param("lotterytail", StringUtils.string(str2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                        if (this.a.y0.S1().Q().equals(str2)) {
                                                                                                            this.a.G0.A3(0);
                                                                                                        } else {
                                                                                                            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0917ff) {
                                                                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f136b);
                                                                                                        String q = tu4.k().q("tail_link", "");
                                                                                                        if (!StringUtils.isNull(q)) {
                                                                                                            TiebaStatic.log("c10056");
                                                                                                            km4.s(view2.getContext(), string, q, true, true, true);
                                                                                                        }
                                                                                                        this.a.G0.S2();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091012) {
                                                                                                    if (view2 != null) {
                                                                                                        km4.o(this.a.getActivity(), (String) view2.getTag());
                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                        if (this.a.w5() == 1 && this.a.y0 != null && this.a.y0.S1() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10397").param("fid", this.a.y0.S1().m()).param("tid", this.a.y0.S1().Q()).param("uid", currentAccount));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091421) {
                                                                                                    if (view2 != null) {
                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                        km4.o(this.a.getActivity(), (String) view2.getTag());
                                                                                                        if (this.a.w5() == 1 && this.a.y0 != null && this.a.y0.S1() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10507").param("fid", this.a.y0.S1().m()).param("tid", this.a.y0.S1().Q()).param("uid", currentAccount2));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091480) {
                                                                                                    this.a.y6();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09147f) {
                                                                                                    this.a.v6();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09268e) {
                                                                                                    if (this.a.y0 != null && this.a.y0.S1() != null && this.a.y0.S1().A() != null) {
                                                                                                        mt7 S13 = this.a.y0.S1();
                                                                                                        TiebaStatic.log(new StatisticItem("c11679").param("fid", S13.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{S13.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09268b) {
                                                                                                    if (this.a.y0 != null && this.a.y0.S1() != null && this.a.y0.S1().A() != null) {
                                                                                                        mt7 S14 = this.a.y0.S1();
                                                                                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", S14.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{S14.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f092382) {
                                                                                                    if (this.a.r1 >= 0) {
                                                                                                        if (this.a.y0 != null) {
                                                                                                            this.a.y0.m3();
                                                                                                        }
                                                                                                        if (this.a.y0 == null || this.a.G0.A0() == null) {
                                                                                                            i4 = 0;
                                                                                                        } else {
                                                                                                            i4 = 0;
                                                                                                            this.a.G0.A0().i0(this.a.y0.S1(), false);
                                                                                                        }
                                                                                                        this.a.r1 = i4;
                                                                                                        if (this.a.y0 != null) {
                                                                                                            this.a.G0.R0().setSelection(this.a.y0.L1());
                                                                                                            this.a.y0.q3(0, 0);
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091ae0) {
                                                                                                    if (!this.a.d5(11009)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.h6(8);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09166a) {
                                                                                                    SparseArray sparseArray10 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                                                    if (sparseArray10 == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.F7(sparseArray10);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0917c2) {
                                                                                                    if (this.a.G0.R0() == null || this.a.y0 == null || this.a.y0.S1() == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    int firstVisiblePosition = this.a.G0.R0().getFirstVisiblePosition();
                                                                                                    View childAt = this.a.G0.R0().getChildAt(0);
                                                                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                                                                    boolean u0 = this.a.y0.S1().u0();
                                                                                                    boolean z3 = this.a.G0.c1() != null && this.a.G0.c1().g();
                                                                                                    boolean P1 = this.a.G0.P1();
                                                                                                    boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                    if (!u0 || this.a.G0.c1() == null || this.a.G0.c1().c() == null) {
                                                                                                        i2 = 0;
                                                                                                    } else {
                                                                                                        int k = ((int) (ri.k(this.a.getContext()) * 0.5625d)) - this.a.G0.c1().e();
                                                                                                        if (firstVisiblePosition == 0) {
                                                                                                            if (top != k) {
                                                                                                                i3 = k;
                                                                                                            } else {
                                                                                                                i3 = k;
                                                                                                            }
                                                                                                            z4 = true;
                                                                                                            i2 = i3;
                                                                                                        } else {
                                                                                                            i3 = k;
                                                                                                        }
                                                                                                        z4 = false;
                                                                                                        i2 = i3;
                                                                                                    }
                                                                                                    int i9 = i2;
                                                                                                    this.a.r5(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                    if ((this.a.y0.S1().O() != null && this.a.y0.S1().O().getReply_num() <= 0) || (P1 && z4)) {
                                                                                                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                                                        if (!this.a.checkUpIsLogin()) {
                                                                                                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.O6();
                                                                                                        if (this.a.y0.S1().O().getAuthor() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.S1().m()).param("obj_locate", 2).param("uid", this.a.y0.S1().O().getAuthor().getUserId()));
                                                                                                        }
                                                                                                    } else {
                                                                                                        int i10 = (int) (ri.i(this.a.getContext()) * 0.6d);
                                                                                                        if (u0) {
                                                                                                            if (this.a.G0.d1 != null && this.a.G0.d1.c != null && this.a.G0.d1.c.getView() != null) {
                                                                                                                if (this.a.G0.d1.c.getView().getParent() != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        } else {
                                                                                                            if (this.a.G0.Z0() != null) {
                                                                                                                z2 = this.a.G0.Z0().getVisibility() == 0;
                                                                                                                if (!z2 && this.a.G0.d1 != null && this.a.G0.d1.c != null && this.a.G0.d1.c.getView() != null && this.a.G0.d1.c.getView().getParent() != null && this.a.G0.h != null && this.a.G0.h.a != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        }
                                                                                                        if (z2 || P1) {
                                                                                                            this.a.b0 = firstVisiblePosition;
                                                                                                            this.a.c0 = top;
                                                                                                            if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i10))) {
                                                                                                                this.a.G0.R0().setSelectionFromTop(0, i9 - i10);
                                                                                                                this.a.G0.R0().smoothScrollBy(-i10, 500);
                                                                                                            } else {
                                                                                                                this.a.G0.R0().E(0, i9, 500);
                                                                                                            }
                                                                                                        } else if (this.a.b0 > 0) {
                                                                                                            if (this.a.G0.R0().getChildAt(this.a.b0) != null) {
                                                                                                                this.a.G0.R0().E(this.a.b0, this.a.c0, 200);
                                                                                                            } else {
                                                                                                                this.a.G0.R0().setSelectionFromTop(this.a.b0, this.a.c0 + i10);
                                                                                                                this.a.G0.R0().smoothScrollBy(i10, 500);
                                                                                                            }
                                                                                                        } else {
                                                                                                            int d2 = py7.d(this.a.getListView());
                                                                                                            if (py7.e(this.a.getListView()) != -1) {
                                                                                                                d2--;
                                                                                                            }
                                                                                                            int f = ri.f(this.a.getContext(), R.dimen.tbds100);
                                                                                                            if (d2 < 0) {
                                                                                                                d2 = (ListUtils.getCount(this.a.G0.R0().getData()) - 1) + this.a.G0.R0().getHeaderViewsCount();
                                                                                                                f = 0;
                                                                                                            }
                                                                                                            if (!z3) {
                                                                                                                if (!u0 || this.a.G0.c1() == null) {
                                                                                                                    if (this.a.G0.h != null && this.a.G0.h.a != null) {
                                                                                                                        fixedNavHeight = this.a.G0.h.a.getFixedNavHeight() - 10;
                                                                                                                    }
                                                                                                                    if (this.a.G0.d1 != null || this.a.G0.d1.c == null || this.a.G0.d1.c.getView() == null || this.a.G0.d1.c.getView().getParent() == null) {
                                                                                                                        this.a.G0.R0().setSelectionFromTop(d2, f + i10);
                                                                                                                        this.a.G0.R0().smoothScrollBy(i10, 500);
                                                                                                                    } else if (!z3) {
                                                                                                                        this.a.G0.R0().E(d2, f, 200);
                                                                                                                    } else {
                                                                                                                        this.a.G0.R0().smoothScrollBy(this.a.G0.d1.c.getView().getTop() - ((int) (ri.k(this.a.getContext()) * 0.5625d)), 500);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = this.a.G0.c1().d();
                                                                                                                }
                                                                                                            } else {
                                                                                                                fixedNavHeight = (int) (ri.k(this.a.getContext()) * 0.5625d);
                                                                                                            }
                                                                                                            f += fixedNavHeight;
                                                                                                            if (this.a.G0.d1 != null) {
                                                                                                            }
                                                                                                            this.a.G0.R0().setSelectionFromTop(d2, f + i10);
                                                                                                            this.a.G0.R0().smoothScrollBy(i10, 500);
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.a.y0.S1().O() != null && this.a.y0.S1().O().getAuthor() != null) {
                                                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.S1().m()).param("obj_locate", 2).param("uid", this.a.y0.S1().O().getAuthor().getUserId()));
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091823 || id == R.id.obfuscated_res_0x7f091824) {
                                                                                                    if (this.a.y0 == null || this.a.y0.S1() == null || this.a.y0.S1().l() == null || qi.isEmpty(this.a.y0.S1().l().getName())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    if (this.a.y0.getErrorNo() == 4) {
                                                                                                        if (!StringUtils.isNull(this.a.y0.r1()) || this.a.y0.h1() == null) {
                                                                                                            this.a.a.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        name = this.a.y0.h1().b;
                                                                                                    } else {
                                                                                                        name = this.a.y0.S1().l().getName();
                                                                                                    }
                                                                                                    if (StringUtils.isNull(name)) {
                                                                                                        this.a.a.finish();
                                                                                                        return;
                                                                                                    }
                                                                                                    String r1 = this.a.y0.r1();
                                                                                                    if (this.a.y0.x1() && r1 != null && r1.equals(name)) {
                                                                                                        this.a.a.finish();
                                                                                                    } else {
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.y0.S1().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                    }
                                                                                                    StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                                                    statisticItem6.param("tid", this.a.y0.m2());
                                                                                                    statisticItem6.param("fid", this.a.y0.getForumId());
                                                                                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    if (this.a.y0.S1().O() != null) {
                                                                                                        statisticItem6.param("nid", this.a.y0.S1().O().getNid());
                                                                                                    }
                                                                                                    TiebaStatic.log(statisticItem6);
                                                                                                } else if (id != R.id.obfuscated_res_0x7f090a75 && id != R.id.obfuscated_res_0x7f090a4e && id != R.id.obfuscated_res_0x7f090a50 && id != R.id.obfuscated_res_0x7f090a4f) {
                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                        if (this.a.y0 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                        statisticItem7.param("tid", this.a.y0.m2());
                                                                                                        statisticItem7.param("fid", this.a.y0.getForumId());
                                                                                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem7.param("obj_locate", 2);
                                                                                                        TiebaStatic.log(statisticItem7);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f09184a) {
                                                                                                        if (this.a.y0 == null || this.a.y0.S1() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        mt7 S15 = this.a.y0.S1();
                                                                                                        if (this.a.D0 == null) {
                                                                                                            PbFragment pbFragment3 = this.a;
                                                                                                            pbFragment3.D0 = new eu7(pbFragment3.getPageContext());
                                                                                                        }
                                                                                                        long g = pg.g(S15.Q(), 0L);
                                                                                                        long g2 = pg.g(S15.m(), 0L);
                                                                                                        new StatisticItem("c13446").param("forum_id", g2).eventStat();
                                                                                                        PbFragment pbFragment4 = this.a;
                                                                                                        pbFragment4.registerListener(pbFragment4.p2);
                                                                                                        this.a.D0.a(g, g2);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f09186e) {
                                                                                                        if (view2.getTag() instanceof SmartApp) {
                                                                                                            SmartApp smartApp = (SmartApp) view2.getTag();
                                                                                                            if (!po5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                    return;
                                                                                                                }
                                                                                                                km4.o(this.a.getActivity(), smartApp.h5_url);
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.y0.m2()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                        }
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090e2e) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData = (ThreadData) view2.getTag();
                                                                                                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090e2b) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                                                        if (this.a.R != null) {
                                                                                                            this.a.R.Q(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                                                        }
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f0917d7 || id == R.id.obfuscated_res_0x7f09182f) {
                                                                                                        if (this.a.t0) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                                                        statisticItem8.param("tid", this.a.y0.m2());
                                                                                                        statisticItem8.param("fid", this.a.y0.getForumId());
                                                                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem8.param("obj_locate", 7);
                                                                                                        TiebaStatic.log(statisticItem8);
                                                                                                        SparseArray sparseArray11 = (SparseArray) view2.getTag();
                                                                                                        if (sparseArray11 != null && (sparseArray11.get(R.id.obfuscated_res_0x7f092004) instanceof Boolean) && ((Boolean) sparseArray11.get(R.id.obfuscated_res_0x7f092004)).booleanValue()) {
                                                                                                            p08.o(6);
                                                                                                        }
                                                                                                        PbFragment pbFragment5 = this.a;
                                                                                                        pbFragment5.b = false;
                                                                                                        pbFragment5.j5(view2);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f0923a0) {
                                                                                                        if (view2.getTag(R.id.obfuscated_res_0x7f092004) instanceof Boolean) {
                                                                                                            p08.o(5);
                                                                                                        }
                                                                                                        this.a.e7(false);
                                                                                                        this.a.G7((PostData) view2.getTag(R.id.obfuscated_res_0x7f09201a), false);
                                                                                                    }
                                                                                                } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                    return;
                                                                                                } else {
                                                                                                    ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                                                    if (this.a.y0.R1() == 3 && this.a.u0() && this.a.y0.S1() != null && ListUtils.isEmpty(this.a.y0.S1().p())) {
                                                                                                        this.a.a.finish();
                                                                                                    } else {
                                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData3.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                                    }
                                                                                                    StatisticItem statisticItem9 = new StatisticItem("c13399");
                                                                                                    statisticItem9.param("tid", threadData3.getId());
                                                                                                    statisticItem9.param("fid", threadData3.getFid());
                                                                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    statisticItem9.param("nid", threadData3.getNid());
                                                                                                    TiebaStatic.log(statisticItem9);
                                                                                                }
                                                                                            } else {
                                                                                                SparseArray sparseArray12 = (SparseArray) view2.getTag();
                                                                                                if (sparseArray12 == null || !(sparseArray12.get(R.id.obfuscated_res_0x7f092007) instanceof PostData)) {
                                                                                                    return;
                                                                                                }
                                                                                                PostData postData4 = (PostData) sparseArray12.get(R.id.obfuscated_res_0x7f092007);
                                                                                                View view3 = (View) sparseArray12.get(R.id.obfuscated_res_0x7f092009);
                                                                                                if (postData4 == null || view3 == null) {
                                                                                                    return;
                                                                                                }
                                                                                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090770);
                                                                                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090771);
                                                                                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f0909f2);
                                                                                                if (postData4.p0()) {
                                                                                                    postData4.P0(false);
                                                                                                    nz7.e(postData4);
                                                                                                } else if (this.a.K() != null ? nz7.c(this.a.K().S1(), postData4) : false) {
                                                                                                    postData4.P0(true);
                                                                                                }
                                                                                                SkinManager.setBackgroundColor(findViewById, postData4.p0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                                                SkinManager.setViewTextColor(eMTextView, postData4.p0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                                                WebPManager.setPureDrawable(imageView, postData4.p0() ? R.drawable.obfuscated_res_0x7f080966 : R.drawable.obfuscated_res_0x7f080965, postData4.p0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                                            }
                                                                                        } else {
                                                                                            this.a.G0.h.l();
                                                                                            this.a.G0.Y3(this.a.H2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, pg.g(this.a.y0.S1().m(), 0L), pg.g(this.a.y0.m2(), 0L), pg.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.y0.S1().O().getPushStatusData())));
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        sparseArray = (SparseArray) view2.getTag();
                                                                                    } catch (ClassCastException e) {
                                                                                        e.printStackTrace();
                                                                                        sparseArray = null;
                                                                                    }
                                                                                    PostData postData5 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fea);
                                                                                    if (postData5 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.M0 == null) {
                                                                                        PbFragment pbFragment6 = this.a;
                                                                                        pbFragment6.M0 = new hs4(pbFragment6.getContext());
                                                                                        this.a.M0.n(this.a.i2);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.a.K().S1() != null && this.a.K().S1().i0();
                                                                                    if (view2 != null && sparseArray != null) {
                                                                                        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091fed) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091fed)).booleanValue() : false;
                                                                                        boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
                                                                                        boolean booleanValue9 = sparseArray.get(R.id.obfuscated_res_0x7f092032) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092032)).booleanValue() : false;
                                                                                        boolean booleanValue10 = sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
                                                                                        boolean booleanValue11 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
                                                                                        String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091ffa) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ffa) : null;
                                                                                        boolean booleanValue12 = sparseArray.get(R.id.obfuscated_res_0x7f092002) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092002)).booleanValue() : false;
                                                                                        if (postData5.q() != null) {
                                                                                            boolean z6 = postData5.q().hasAgree;
                                                                                            int r = postData5.r();
                                                                                            if (z6 && r == 5) {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0085;
                                                                                            } else {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0087;
                                                                                            }
                                                                                            ds4 ds4Var12 = new ds4(8, pbFragment.getString(i), this.a.M0);
                                                                                            SparseArray sparseArray13 = new SparseArray();
                                                                                            sparseArray13.put(R.id.obfuscated_res_0x7f091fea, postData5);
                                                                                            ds4Var12.d.setTag(sparseArray13);
                                                                                            arrayList2.add(ds4Var12);
                                                                                        }
                                                                                        if (this.a.mIsLogin) {
                                                                                            if (mz7.i(this.a.y0) || booleanValue9 || !booleanValue8) {
                                                                                                if ((this.a.t6(booleanValue7) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    ds4 ds4Var13 = new ds4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0ffa), this.a.M0);
                                                                                                    ds4Var13.d.setTag(str3);
                                                                                                    arrayList2.add(ds4Var13);
                                                                                                }
                                                                                            } else {
                                                                                                ds4 ds4Var14 = new ds4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b37), this.a.M0);
                                                                                                SparseArray sparseArray14 = new SparseArray();
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092001, sparseArray.get(R.id.obfuscated_res_0x7f092001));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092044, sparseArray.get(R.id.obfuscated_res_0x7f092044));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092045, sparseArray.get(R.id.obfuscated_res_0x7f092045));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091fed, sparseArray.get(R.id.obfuscated_res_0x7f091fed));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                                                                                                ds4Var14.d.setTag(sparseArray14);
                                                                                                arrayList2.add(ds4Var14);
                                                                                            }
                                                                                            if (booleanValue9) {
                                                                                                SparseArray sparseArray15 = new SparseArray();
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f092032, Boolean.TRUE);
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f091ff8, sparseArray.get(R.id.obfuscated_res_0x7f091ff8));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f091ff9, sparseArray.get(R.id.obfuscated_res_0x7f091ff9));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f091ffa, str3);
                                                                                                if (booleanValue10) {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092001, sparseArray.get(R.id.obfuscated_res_0x7f092001));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092044, sparseArray.get(R.id.obfuscated_res_0x7f092044));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092045, sparseArray.get(R.id.obfuscated_res_0x7f092045));
                                                                                                } else {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                                                                                                }
                                                                                                if (booleanValue11) {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(booleanValue7));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f091ffe, sparseArray.get(R.id.obfuscated_res_0x7f091ffe));
                                                                                                    if (booleanValue12) {
                                                                                                        ds4 ds4Var15 = new ds4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.a.M0);
                                                                                                        ds4Var15.d.setTag(sparseArray15);
                                                                                                        ds4Var2 = ds4Var15;
                                                                                                        ds4Var = new ds4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e4), this.a.M0);
                                                                                                        ds4Var.d.setTag(sparseArray15);
                                                                                                    }
                                                                                                } else {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                                                                                                }
                                                                                                ds4Var2 = null;
                                                                                                ds4Var = new ds4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e4), this.a.M0);
                                                                                                ds4Var.d.setTag(sparseArray15);
                                                                                            } else if (booleanValue11) {
                                                                                                SparseArray sparseArray16 = new SparseArray();
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092032, Boolean.FALSE);
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(booleanValue7));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f091ffe, sparseArray.get(R.id.obfuscated_res_0x7f091ffe));
                                                                                                if (this.a.y0.S1().W() == 1002 && !booleanValue7) {
                                                                                                    ds4Var3 = new ds4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0ffa), this.a.M0);
                                                                                                } else {
                                                                                                    ds4Var3 = new ds4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.a.M0);
                                                                                                }
                                                                                                ds4Var3.d.setTag(sparseArray16);
                                                                                                ds4Var2 = ds4Var3;
                                                                                                ds4Var = null;
                                                                                            } else {
                                                                                                ds4Var = null;
                                                                                                ds4Var2 = null;
                                                                                            }
                                                                                            if (ds4Var2 != null) {
                                                                                                arrayList2.add(ds4Var2);
                                                                                            }
                                                                                            if (ds4Var != null) {
                                                                                                arrayList2.add(ds4Var);
                                                                                            }
                                                                                        }
                                                                                        this.a.M0.j(arrayList2);
                                                                                        this.a.L0 = new fs4(this.a.getPageContext(), this.a.M0);
                                                                                        this.a.L0.k();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f09166a) {
                                                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                                                    statisticItem10.param("tid", this.a.y0.m2());
                                                                                    statisticItem10.param("fid", this.a.y0.getForumId());
                                                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem10.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem10);
                                                                                }
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f0917d5 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                    this.a.T = view2;
                                                                                    return;
                                                                                } else if (this.a.checkUpIsLogin()) {
                                                                                    if (this.a.y0 == null || this.a.y0.S1() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.a.G0.m0();
                                                                                    SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                                                    PostData postData6 = (PostData) sparseArray17.get(R.id.obfuscated_res_0x7f092007);
                                                                                    PostData postData7 = (PostData) sparseArray17.get(R.id.obfuscated_res_0x7f092008);
                                                                                    View view4 = (View) sparseArray17.get(R.id.obfuscated_res_0x7f092009);
                                                                                    if (postData6 == null || view4 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (postData6.F() == 1) {
                                                                                        TiebaStatic.log(new StatisticItem("c12630"));
                                                                                    }
                                                                                    StatisticItem statisticItem11 = postData6.c0;
                                                                                    if (statisticItem11 != null) {
                                                                                        StatisticItem copy3 = statisticItem11.copy();
                                                                                        copy3.delete("obj_locate");
                                                                                        if (view2.getId() == R.id.obfuscated_res_0x7f09166a) {
                                                                                            copy3.param("obj_locate", 6);
                                                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d5) {
                                                                                            copy3.param("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(copy3);
                                                                                    }
                                                                                    String m22 = this.a.y0.m2();
                                                                                    String K2 = postData6.K();
                                                                                    String K4 = postData7 != null ? postData7.K() : "";
                                                                                    int W2 = this.a.y0.S1() != null ? this.a.y0.S1().W() : 0;
                                                                                    this.a.H7();
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091bb9) {
                                                                                        AbsPbActivity.e P62 = this.a.P6(K2);
                                                                                        if (this.a.y0 == null || this.a.y0.S1() == null || P62 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m22, K2, "pb", true, false, null, true, null, W2, postData6.b0(), this.a.y0.S1().d(), false, postData6.s().getIconInfo(), 5).addBigImageData(P62.a, P62.b, P62.g, P62.j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.a.y0.R1());
                                                                                        addBigImageData2.setFromFrsForumId(this.a.y0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.a.y0.r2());
                                                                                        addBigImageData2.setKeyFromForumId(this.a.y0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.a.y0.k1());
                                                                                        addBigImageData2.setTiebaPlusData(this.a.y0.I(), this.a.y0.E(), this.a.y0.F(), this.a.y0.D(), this.a.y0.J());
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e P63 = this.a.P6(K2);
                                                                                        if (postData6 == null || this.a.y0 == null || this.a.y0.S1() == null || P63 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m22, K2, "pb", true, false, null, false, K4, W2, postData6.b0(), this.a.y0.S1().d(), false, postData6.s().getIconInfo(), 5).addBigImageData(P63.a, P63.b, P63.g, P63.j);
                                                                                        if (!qi.isEmpty(K4)) {
                                                                                            addBigImageData3.setHighLightPostId(K4);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.a.y0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.a.y0.I(), this.a.y0.E(), this.a.y0.F(), this.a.y0.D(), this.a.y0.J());
                                                                                        addBigImageData3.setBjhData(this.a.y0.k1());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.a.y0.R1());
                                                                                        addBigImageData3.setFromFrsForumId(this.a.y0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.a.y0.r2());
                                                                                        if (this.a.G0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.a.G0.I0(this.a.y0.G, this.a.y0.k2()).Q || postData6.Q);
                                                                                        }
                                                                                        if (this.a.y0.S1() != null && this.a.y0.S1().o() != null) {
                                                                                            addBigImageData3.setHasForumRule(this.a.y0.S1().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.y0.S1().m()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (pi.z()) {
                                                                            SparseArray<Object> S02 = this.a.G0.S0(this.a.y0.S1(), this.a.y0.k2(), 1);
                                                                            if (S02 != null) {
                                                                                this.a.G0.y2(((Integer) S02.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) S02.get(R.id.obfuscated_res_0x7f091fec), ((Integer) S02.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) S02.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
                                                                            }
                                                                            this.a.G0.h.k();
                                                                            if (this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().O() != null) {
                                                                                ThreadData O = this.a.K().S1().O();
                                                                                StatisticItem statisticItem12 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                                                                statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                                                statisticItem12.param("tid", O.getId());
                                                                                statisticItem12.param("fid", O.getFid());
                                                                                statisticItem12.param("fname", O.getForum_name());
                                                                                TiebaStatic.log(statisticItem12);
                                                                                StatisticItem statisticItem13 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                                                                statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                                                statisticItem13.param("tid", O.getId());
                                                                                statisticItem13.param("fid", O.getFid());
                                                                                statisticItem13.param("fname", O.getForum_name());
                                                                                statisticItem13.param("obj_source", 3);
                                                                                TiebaStatic.log(statisticItem13);
                                                                            }
                                                                        } else {
                                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                                                            return;
                                                                        }
                                                                    } else if (pi.z()) {
                                                                        this.a.G0.m0();
                                                                        SparseArray<Object> S03 = this.a.G0.S0(this.a.y0.S1(), this.a.y0.k2(), 1);
                                                                        if (S03 == null) {
                                                                            return;
                                                                        }
                                                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.S1().l().getId(), this.a.y0.S1().l().getName(), this.a.y0.S1().O().getId(), String.valueOf(this.a.y0.S1().V().getUserId()), (String) S03.get(R.id.obfuscated_res_0x7f091ff7), (String) S03.get(R.id.obfuscated_res_0x7f091ff8), (String) S03.get(R.id.obfuscated_res_0x7f091ffa), (String) S03.get(R.id.obfuscated_res_0x7f091ff9))));
                                                                    } else {
                                                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        this.a.onChangeSkinType(skinType);
                                                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                                                    } else if (skinType == 0 || skinType == 4) {
                                                                        UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                                                        this.a.onChangeSkinType(skinType);
                                                                        UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_1));
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                                                    }
                                                                    this.a.G0.h.l();
                                                                }
                                                            } else if (this.a.y0 == null || this.a.y0.S1() == null || this.a.y0.S1().O() == null) {
                                                                return;
                                                            } else {
                                                                this.a.G0.h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.a;
                                                                pbFragment7.c6(pbFragment7.y0.S1().O().getFirstPostId());
                                                            }
                                                        } else {
                                                            this.a.G0.m0();
                                                            if (pi.z()) {
                                                                if (this.a.i) {
                                                                    view2.setTag(Integer.valueOf(this.a.y0.i2()));
                                                                    return;
                                                                }
                                                                this.a.H7();
                                                                this.a.G0.w3();
                                                                fs4 fs4Var = new fs4(this.a.getPageContext());
                                                                if (this.a.y0.S1().f == null || this.a.y0.S1().f.size() <= 0) {
                                                                    strArr = new String[]{this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11b4), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11b5)};
                                                                } else {
                                                                    strArr = new String[this.a.y0.S1().f.size()];
                                                                    for (int i11 = 0; i11 < this.a.y0.S1().f.size(); i11++) {
                                                                        strArr[i11] = this.a.y0.S1().f.get(i11).sort_name + this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11b2);
                                                                    }
                                                                }
                                                                fs4Var.i(null, strArr, new a(this, fs4Var, view2));
                                                                fs4Var.k();
                                                            } else {
                                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.a.G0.m0();
                                                        if (this.a.K().S1().g != 2) {
                                                            if (this.a.y0.Q1() != null) {
                                                                this.a.G0.f4(this.a.y0.Q1(), this.a.h2);
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0874);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.a.checkUpIsLogin()) || (S1 = this.a.y0.S1()) == null) {
                                                    return;
                                                } else {
                                                    ThreadData O2 = S1.O();
                                                    if (O2 != null && O2.getAuthor() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", S1.m()).param("obj_locate", 4).param("uid", O2.getAuthor().getUserId()));
                                                    }
                                                    if (O2 != null) {
                                                        if (O2.isBJHArticleThreadType()) {
                                                            i5 = 2;
                                                        } else if (O2.isBJHVideoThreadType()) {
                                                            i5 = 3;
                                                        } else if (O2.isBJHNormalThreadType()) {
                                                            i5 = 4;
                                                        } else if (O2.isBJHVideoDynamicThreadType()) {
                                                            i5 = 5;
                                                        }
                                                        StatisticItem statisticItem14 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                        statisticItem14.param("tid", this.a.y0.m2());
                                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem14.param("fid", this.a.y0.getForumId());
                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091e45) {
                                                            statisticItem14.param("obj_locate", 5);
                                                        } else {
                                                            statisticItem14.param("obj_locate", 6);
                                                        }
                                                        statisticItem14.param("obj_name", i5);
                                                        statisticItem14.param("obj_type", 1);
                                                        if (O2 != null) {
                                                            if (O2.isBJHArticleThreadType()) {
                                                                statisticItem14.param("obj_type", 10);
                                                            } else if (O2.isBJHVideoThreadType()) {
                                                                statisticItem14.param("obj_type", 9);
                                                            } else if (O2.isBJHVideoDynamicThreadType()) {
                                                                statisticItem14.param("obj_type", 8);
                                                            } else if (O2.isBJHNormalThreadType()) {
                                                                statisticItem14.param("obj_type", 7);
                                                            } else if (O2.isShareThread) {
                                                                statisticItem14.param("obj_type", 6);
                                                            } else {
                                                                int i12 = O2.threadType;
                                                                if (i12 == 0) {
                                                                    statisticItem14.param("obj_type", 1);
                                                                } else if (i12 == 40) {
                                                                    statisticItem14.param("obj_type", 2);
                                                                } else if (i12 == 49) {
                                                                    statisticItem14.param("obj_type", 3);
                                                                } else if (i12 == 54) {
                                                                    statisticItem14.param("obj_type", 4);
                                                                } else {
                                                                    statisticItem14.param("obj_type", 5);
                                                                }
                                                            }
                                                            statisticItem14.param("card_type", O2.getRecomCardType());
                                                            statisticItem14.param("recom_source", O2.mRecomSource);
                                                            statisticItem14.param("ab_tag", O2.mRecomAbTag);
                                                            statisticItem14.param("weight", O2.mRecomWeight);
                                                            statisticItem14.param("extra", O2.mRecomExtra);
                                                            statisticItem14.param("nid", O2.getNid());
                                                            if (O2.getBaijiahaoData() != null && !qi.isEmpty(O2.getBaijiahaoData().oriUgcVid)) {
                                                                statisticItem14.param(TiebaStatic.Params.OBJ_PARAM6, O2.getBaijiahaoData().oriUgcVid);
                                                            }
                                                        }
                                                        if (!qi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem14.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.a.P() != null) {
                                                            aa5.e(this.a.P(), statisticItem14);
                                                        }
                                                        if (this.a.G0 != null) {
                                                            statisticItem14.param("obj_param1", this.a.G0.N0());
                                                        }
                                                        TiebaStatic.log(statisticItem14);
                                                        if (ri.D()) {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c40);
                                                            return;
                                                        } else if (S1 != null) {
                                                            ArrayList<PostData> F2 = this.a.y0.S1().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.a.y0.k2()) {
                                                                this.a.G0.m0();
                                                                this.a.H7();
                                                                if (S1.A() != null && !StringUtils.isNull(S1.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.y0.S1().m()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.a.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.a.G0 != null) {
                                                                    this.a.G0.o0();
                                                                    this.a.G0.r4(S1);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.a.G0.R3();
                                                                    this.a.y0.m1().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0917c5) {
                                                                        i6 = 2;
                                                                    } else {
                                                                        i6 = view2.getId() == R.id.obfuscated_res_0x7f091e45 ? 1 : 6;
                                                                    }
                                                                    if ((!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) || !this.a.G0.T1() || S1.m0()) {
                                                                        this.a.B7(i6);
                                                                    } else if (UbsABTestHelper.isPbSharePathTestA()) {
                                                                        this.a.B7(i6);
                                                                    } else if (j05.c() > 0) {
                                                                        this.a.l7();
                                                                    } else {
                                                                        int N0 = this.a.G0.N0();
                                                                        this.a.G0.b0();
                                                                        this.a.g6(j05.a(), N0);
                                                                    }
                                                                }
                                                            } else {
                                                                ri.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0de0));
                                                                return;
                                                            }
                                                        } else {
                                                            ri.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0de0));
                                                            return;
                                                        }
                                                    }
                                                    i5 = 1;
                                                    StatisticItem statisticItem142 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem142.param("tid", this.a.y0.m2());
                                                    statisticItem142.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem142.param("fid", this.a.y0.getForumId());
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091e45) {
                                                    }
                                                    statisticItem142.param("obj_name", i5);
                                                    statisticItem142.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!qi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.a.P() != null) {
                                                    }
                                                    if (this.a.G0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem142);
                                                    if (ri.D()) {
                                                    }
                                                }
                                            } else if (pi.z()) {
                                                this.a.G0.m0();
                                                if (this.a.G0.h.n() != null && view2 == this.a.G0.h.n().p() && !this.a.G0.R1()) {
                                                    this.a.G0.S2();
                                                }
                                                if (!this.a.i) {
                                                    this.a.H7();
                                                    this.a.G0.w3();
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0909f5) {
                                                        K3 = this.a.y0.K3(true, this.a.A5());
                                                    } else {
                                                        K3 = view2.getId() == R.id.obfuscated_res_0x7f091bb6 ? this.a.y0.K3(false, this.a.A5()) : this.a.y0.J3(this.a.A5());
                                                    }
                                                    view2.setTag(Boolean.valueOf(K3));
                                                    if (K3) {
                                                        i7 = 1;
                                                        this.a.G0.g3(true);
                                                        this.a.G0.b4();
                                                        this.a.i = true;
                                                        this.a.G0.k3(true);
                                                    } else {
                                                        i7 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                                } else {
                                                    view2.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                                view2.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (pi.z()) {
                                            this.a.G0.m0();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0917c0 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.d5(11009) || this.a.y0.i1(this.a.G0.Q0()) == null) {
                                                    return;
                                                }
                                                this.a.D6();
                                                if (this.a.y0.S1() != null && this.a.y0.S1().O() != null && this.a.y0.S1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.S1().m()).param("obj_locate", 3).param("uid", this.a.y0.S1().O().getAuthor().getUserId()));
                                                }
                                                if (this.a.y0.S1().O() != null && this.a.y0.S1().O().getAuthor() != null && this.a.y0.S1().O().getAuthor().getUserId() != null && this.a.A0 != null) {
                                                    PbFragment pbFragment8 = this.a;
                                                    int W5 = pbFragment8.W5(pbFragment8.y0.S1());
                                                    ThreadData O3 = this.a.y0.S1().O();
                                                    if (O3.isBJHArticleThreadType()) {
                                                        i8 = 2;
                                                    } else if (O3.isBJHVideoThreadType()) {
                                                        i8 = 3;
                                                    } else if (O3.isBJHNormalThreadType()) {
                                                        i8 = 4;
                                                    } else {
                                                        i8 = O3.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.y0.b).param("obj_locate", 1).param("obj_id", this.a.y0.S1().O().getAuthor().getUserId()).param("obj_type", !this.a.A0.e()).param("obj_source", W5).param("obj_param1", i8));
                                                }
                                            } else {
                                                this.a.V = view2;
                                                return;
                                            }
                                        } else {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.a.y0.S1() != null && this.a.y0.S1().O() != null && this.a.y0.S1().O().isVideoThreadType() && this.a.y0.S1().O().getThreadVideoInfo() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.a.y0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.a.y0.r1()) || this.a.y0.h1() == null) {
                                                this.a.a.finish();
                                                return;
                                            }
                                            name2 = this.a.y0.h1().b;
                                        } else {
                                            name2 = this.a.y0.S1().l().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.a.a.finish();
                                            return;
                                        }
                                        String r12 = this.a.y0.r1();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.a.y0.x1() && r12 != null && r12.equals(name2)) {
                                            this.a.a.finish();
                                        } else {
                                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (pi.z()) {
                                    if (this.a.y0.S1() == null || this.a.B0.S()) {
                                        return;
                                    }
                                    this.a.G0.m0();
                                    int i13 = (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().t()) ? (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().s()) ? view2 == this.a.G0.C0() ? 2 : 0 : this.a.y0.S1().O().getIs_good() == 1 ? 3 : 6 : this.a.y0.S1().O().getIs_top() == 1 ? 5 : 4;
                                    ForumData l = this.a.y0.S1().l();
                                    String name3 = l.getName();
                                    String id2 = l.getId();
                                    String id3 = this.a.y0.S1().O().getId();
                                    this.a.G0.k4();
                                    this.a.B0.W(id2, name3, id3, i13, this.a.G0.D0());
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                    return;
                                }
                            } else {
                                this.a.G0.h.l();
                                if (this.a.y0 != null) {
                                    this.a.w1.f(this.a.y0.m2());
                                }
                                if (this.a.y0 == null || !this.a.y0.isPrivacy()) {
                                    this.a.w1.b();
                                    int i14 = (TbSingleton.getInstance().mCanCallFans || this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().Q() == null || !this.a.K().S1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.a.K() != null && this.a.K().S1() != null) {
                                        this.a.w1.d(3, i14, this.a.K().S1().Q());
                                    }
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0f0f);
                                    if (this.a.K() == null || this.a.K().S1() == null) {
                                        return;
                                    }
                                    this.a.w1.d(3, 3, this.a.K().S1().Q());
                                    return;
                                }
                            }
                        } else if (pi.z()) {
                            this.a.G0.m0();
                            this.a.H7();
                            this.a.G0.w3();
                            this.a.G0.R3();
                            if (this.a.G0.Z0() != null) {
                                this.a.G0.Z0().setVisibility(8);
                            }
                            this.a.y0.F3(1);
                            if (this.a.e != null) {
                                this.a.e.x();
                            }
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                            return;
                        }
                    } else {
                        String str4 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a74);
                        String str5 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a5f);
                        String str6 = (String) view2.getTag(R.id.obfuscated_res_0x7f09213d);
                        if (this.a.R != null) {
                            this.a.R.Q(str4, str5);
                        }
                        TbPageTag l2 = aa5.l(this.a.getContext());
                        pz7.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l2 != null ? l2.locatePage : "");
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dd1).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091ba9) {
                        String z52 = this.a.z5();
                        if (TextUtils.isEmpty(z52)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{z52});
                    }
                } else if (!this.a.t0) {
                    StatisticItem statisticItem15 = new StatisticItem("c13398");
                    statisticItem15.param("tid", this.a.y0.m2());
                    statisticItem15.param("fid", this.a.y0.getForumId());
                    statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem15.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem15);
                    SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                    if (sparseArray18 != null && (sparseArray18.get(R.id.obfuscated_res_0x7f092004) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.obfuscated_res_0x7f092004)).booleanValue()) {
                        p08.o(2);
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    if (this.a.w) {
                        this.a.w = false;
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091fea);
                    if (!(obj instanceof PostData)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    PostData postData8 = (PostData) obj;
                    if (this.a.y0 != null && this.a.y0.S1() != null && this.a.S5().a1() != null && postData8.s() != null && postData8.B() != 1) {
                        if (!this.a.checkUpIsLogin()) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        if (this.a.S5().b1() != null) {
                            this.a.S5().b1().c();
                        }
                        cu7 cu7Var2 = new cu7();
                        cu7Var2.A(this.a.y0.S1().l());
                        cu7Var2.E(this.a.y0.S1().O());
                        cu7Var2.C(postData8);
                        this.a.S5().a1().V(cu7Var2);
                        this.a.S5().a1().setPostId(postData8.K());
                        this.a.z6(view2, postData8.s().getUserId(), "", postData8);
                        TiebaStatic.log("c11743");
                        p08.b(this.a.y0.S1(), postData8, postData8.b0, 8, 1);
                        if (this.a.V0 != null) {
                            this.a.G0.a3(this.a.V0.C());
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ wr4 b;
        public final /* synthetic */ PbFragment c;

        public l2(PbFragment pbFragment, MarkData markData, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, wr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
            this.a = markData;
            this.b = wr4Var;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.I7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.a.y0.N3((UserPendantData) customResponsedMessage.getData());
                if (this.a.G0 != null && this.a.y0 != null) {
                    this.a.G0.L2(this.a.y0.S1(), this.a.y0.k2(), this.a.y0.c2(), this.a.G0.i1());
                }
                if (this.a.G0 == null || this.a.G0.A0() == null) {
                    return;
                }
                this.a.G0.A0().a0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public m0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                this.a.G0.s1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.a.B7(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        eu6.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c40);
                        }
                        this.a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.y0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.y0.b)) {
                this.a.A7((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ wr4 b;
        public final /* synthetic */ PbFragment c;

        public m2(PbFragment pbFragment, MarkData markData, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, wr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
            this.a = markData;
            this.b = wr4Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.G0 != null && this.c.G0.m1() != null) {
                    this.c.G0.m1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.I7();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.a.G0 == null) {
                return;
            }
            if (booleanValue) {
                this.a.G0.b4();
            } else {
                this.a.G0.u1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public n0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements o45 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public n1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.o45
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements hg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public n2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
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
                    if (tn4.c().g()) {
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
        @Override // com.baidu.tieba.hg
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
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = tn4.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
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
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.F();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.V0 != null) {
                this.a.G0.a3(this.a.V0.C());
            }
            this.a.G0.J3(false);
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public o0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!pi.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.S1().l().getId(), this.a.y0.S1().l().getName(), this.a.y0.S1().O().getId(), String.valueOf(this.a.y0.S1().V().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o1 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ o1 b;

            public a(o1 o1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = o1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.G0 == null || this.a == null) {
                    return;
                }
                this.b.a.G0.D2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements wr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(o1 o1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.wr4.e
            public void onClick(wr4 wr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                    wr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements wr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o1 a;

            public c(o1 o1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = o1Var;
            }

            @Override // com.baidu.tieba.wr4.e
            public void onClick(wr4 wr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                    wr4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public o1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, dz4 dz4Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, dz4Var, writeData, antiData}) == null) {
                if (!qi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0.S1() != null) {
                        statisticItem.param("fid", this.a.y0.S1().m());
                    }
                    statisticItem.param("tid", this.a.y0.m2());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (qi.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.H7();
                this.a.G0.u3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.E0 != null) {
                    this.a.E0.M(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    sg.a().postDelayed(this.a.Y1, 300000L);
                }
                boolean z2 = false;
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.V0.B() || this.a.V0.D()) {
                            this.a.V0.z(false, postWriteCallBackData);
                        }
                        this.a.K0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.Y0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (qi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f047c), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        wr4 wr4Var = new wr4(this.a.getActivity());
                        if (qi.isEmpty(postWriteCallBackData.getErrorString())) {
                            wr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cf7));
                        } else {
                            wr4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new b(this));
                        wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf9, new c(this));
                        wr4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (ds8.d(i) || dz4Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.m7(i, antiData, str);
                        return;
                    }
                }
                this.a.A7(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.n7(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.y0.v1()) {
                        mt7 S1 = this.a.y0.S1();
                        if (S1 != null && S1.O() != null && S1.O().getAuthor() != null && (userId = S1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.y0.I3()) {
                            this.a.G0.w3();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.y0.I3()) {
                        this.a.G0.w3();
                    }
                } else if (floor != null) {
                    this.a.G0.F1(this.a.y0.S1());
                }
                if (this.a.y0.z1()) {
                    TiebaStatic.log(new StatisticItem("c10369").param("tid", this.a.y0.m2()));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    sg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                PbFragment pbFragment = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                pbFragment.Z4(z2);
                if (writeData != null) {
                    qw4.b(writeData.getContent(), "1");
                }
                if (this.a.m6()) {
                    this.a.K7();
                }
                this.a.y7();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o2 implements hg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public o2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
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
                if (tn4.c().g()) {
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
        @Override // com.baidu.tieba.hg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.b0();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = tn4.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
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
                gifView.e0();
                gifView.b0();
                gifView.setImageDrawable(null);
                gifView.f0();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            ss7 ss7Var = (ss7) customResponsedMessage.getData();
            int type = ss7Var.getType();
            if (type == 0) {
                this.a.U6((cu7) ss7Var.a());
            } else if (type == 1) {
                this.a.s5((ForumManageModel.b) ss7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (ss7Var.a() == null) {
                    this.a.T6(false, null);
                } else {
                    this.a.T6(true, (MarkData) ss7Var.a());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements ps7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public p0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.ps7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ p1 b;

            public a(p1 p1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = p1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.G0 == null || this.a == null) {
                    return;
                }
                this.b.a.G0.D2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements wr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(p1 p1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.wr4.e
            public void onClick(wr4 wr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                    wr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements wr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p1 a;

            public c(p1 p1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = p1Var;
            }

            @Override // com.baidu.tieba.wr4.e
            public void onClick(wr4 wr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                    wr4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public p1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, dz4 dz4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, dz4Var, writeData, antiData}) == null) {
                if (!qi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0 != null && this.a.y0.S1() != null) {
                        statisticItem.param("fid", this.a.y0.S1().m());
                    }
                    if (this.a.y0 != null) {
                        statisticItem.param("tid", this.a.y0.m2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.H5()) {
                        this.a.e7(false);
                        rs7.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f120d));
                    }
                    xx7 xx7Var = this.a.K0;
                    if (xx7Var != null) {
                        xx7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        r05.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        qw4.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        sg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.m6()) {
                        this.a.K7();
                    }
                    this.a.y7();
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.Y0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (qi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f047c), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    wr4 wr4Var = new wr4(this.a.getActivity());
                    if (qi.isEmpty(postWriteCallBackData.getErrorString())) {
                        wr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cf7));
                    } else {
                        wr4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new b(this));
                    wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf9, new c(this));
                    wr4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.a;
                if (pbFragment.K0 == null) {
                    return;
                }
                if (pbFragment.G0 != null && this.a.G0.b1() != null && this.a.G0.b1().b() != null && this.a.G0.b1().b().x()) {
                    this.a.G0.b1().b().v(postWriteCallBackData);
                }
                this.a.K0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p2 implements hg<TiebaPlusRecommendCard> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public p2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard c(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            h(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        public TiebaPlusRecommendCard e(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.o();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.p();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: g */
        public TiebaPlusRecommendCard d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new TiebaPlusRecommendCard(this.a.getPageContext().getPageActivity()) : (TiebaPlusRecommendCard) invokeV.objValue;
        }

        public TiebaPlusRecommendCard h(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.p();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.G0 == null || this.a.G0.A0() == null) {
                return;
            }
            this.a.G0.A0().a0();
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements ou7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public q0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.ou7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ou7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091bd4) {
                            if (this.a.Y6(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d4) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f091ffd) instanceof SparseArray) {
                                this.a.F7((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091ffd));
                            }
                        } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.obfuscated_res_0x7f09182e) {
                            if (this.a.G0.M1() && view2.getId() == R.id.obfuscated_res_0x7f0917f3) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f09203f) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.obfuscated_res_0x7f09203f)));
                                }
                                if (this.a.z0() != null && this.a.z0().b != null) {
                                    this.a.z0().b.onClick(view2);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.F7(sparseArray);
                        }
                    }
                    if (this.a.V0 != null) {
                        this.a.G0.a3(this.a.V0.C());
                    }
                    this.a.G0.S2();
                    this.a.G0.m0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ou7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    this.a.p5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class q1 extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q1(PbFragment pbFragment, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.bb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView k1;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    ri.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f13cb);
                    if (this.a.G0 == null || (k1 = this.a.G0.k1()) == null || this.a.G0.R0() == null) {
                        return;
                    }
                    this.a.G0.R0().removeHeaderView(k1);
                    return;
                }
                ri.N(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q2 implements hg<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public q2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ View c(View view2) {
            View view3 = view2;
            h(view3);
            return view3;
        }

        public View e(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).o();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.t0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }

        public View h(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).n();
                return view2;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ni5.a)) {
                ni5.a aVar = (ni5.a) customResponsedMessage.getData();
                ni5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public r0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.y0 != null && this.a.y0.D1()) {
                    this.a.B6();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class r1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r1 a;

            public a(r1 r1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = r1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || BreatheTipWidget.e() || this.a.a.getContext() == null) {
                    return;
                }
                lv4 lv4Var = new lv4();
                lv4Var.b = R.raw.obfuscated_res_0x7f110027;
                lv4Var.a = BreatheTipWidget.PointType.LOTTIE;
                lv4Var.c = ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                mv4 mv4Var = new mv4();
                mv4Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f04fb);
                mv4Var.b = this.a.a.getString(R.string.obfuscated_res_0x7f0f00e9);
                mv4Var.e = R.drawable.pic_guidecard;
                mv4Var.f = ri.f(this.a.a.getContext(), R.dimen.tbds156);
                mv4Var.g = ri.f(this.a.a.getContext(), R.dimen.tbds489);
                mv4Var.h = ri.f(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.G0.g1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.G0.g1()));
                breatheTipWidget.f(mv4Var, lv4Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    tu4 k = tu4.k();
                    k.u("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    n05.a("c14828");
                }
            }
        }

        public r1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.a.n : j;
                if (this.a.o == 0) {
                    this.a.o = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                va5 va5Var = new va5(i, z, responsedMessage, this.a.r, this.a.q, this.a.o, z2, 0L, 0L, j3);
                this.a.q = 0L;
                this.a.r = 0L;
                va5Var.c();
                if (z2) {
                    j2 = j3;
                    va5Var.B = j2;
                    va5Var.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || this.a.y0 == null || this.a.y0.S1() == null || this.a.y0.S1().O() == null) {
                    return;
                }
                int threadType = this.a.y0.S1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (!StringHelper.equals(this.a.M, "from_personalize")) {
                        if (StringHelper.equals(this.a.M, "from_frs")) {
                            va5 va5Var2 = new va5();
                            va5Var2.a(1000);
                            va5Var2.D = j2;
                            va5Var2.d(threadType);
                            return;
                        }
                        return;
                    }
                    ra5 ra5Var = new ra5();
                    ra5Var.F = 1;
                    ra5Var.a(1005);
                    ra5Var.D = j2;
                    ra5Var.d(threadType);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(mt7 mt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mt7Var) == null) {
                this.a.G0.F1(mt7Var);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, mt7 mt7Var, String str, int i4) {
            u25 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), mt7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906bd));
                }
                if (!z || mt7Var == null || mt7Var.X() != null || ListUtils.getCount(mt7Var.F()) >= 1) {
                    if (!this.a.h0) {
                        this.a.h0 = true;
                    } else if (this.a.K() != null) {
                        this.a.K().Z0();
                    }
                    this.a.h = true;
                    if (this.a.G0 == null) {
                        return;
                    }
                    this.a.G0.v3();
                    if (mt7Var == null || !mt7Var.p0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.G0.m1());
                    }
                    this.a.G0.u1();
                    if (this.a.J || this.a.G0.R1()) {
                        this.a.G0.o1();
                    } else if (!this.a.G0.K1()) {
                        this.a.G0.J3(false);
                    }
                    if (this.a.i) {
                        this.a.i = false;
                    }
                    if (i4 == 0 && mt7Var != null) {
                        this.a.O0 = true;
                    }
                    if (mt7Var != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.G0.m1());
                        this.a.G0.E3();
                    }
                    ArrayList<PostData> arrayList = null;
                    String e1 = null;
                    arrayList = null;
                    if (z && mt7Var != null) {
                        ThreadData O = mt7Var.O();
                        if (O != null && O.isUgcThreadType()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.h7(pbFragment3.U0);
                        }
                        this.a.G0.b1().m(mt7Var);
                        this.a.G0.Q3();
                        if (O != null && O.getCartoonThreadData() != null) {
                            this.a.O7(O.getCartoonThreadData());
                        }
                        if (this.a.V0 != null) {
                            this.a.G0.a3(this.a.V0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(mt7Var.V().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(mt7Var.V().getBimg_end_time());
                        if (mt7Var.F() != null && mt7Var.F().size() >= 1 && mt7Var.F().get(0) != null) {
                            this.a.y0.r3(mt7Var.F().get(0).K());
                        } else if (mt7Var.X() != null) {
                            this.a.y0.r3(mt7Var.X().K());
                        }
                        if (this.a.V0 != null) {
                            this.a.V0.N(mt7Var.d());
                            this.a.V0.O(mt7Var.l(), mt7Var.V());
                            this.a.V0.u0(O);
                            this.a.V0.P(this.a.y0.u1(), this.a.y0.m2(), this.a.y0.q1());
                            if (O != null) {
                                this.a.V0.j0(O.isMutiForumThread());
                            }
                        }
                        if (this.a.A0 != null) {
                            this.a.A0.h(mt7Var.r());
                        }
                        if (mt7Var.s() == 1) {
                            this.a.s = true;
                        } else {
                            this.a.s = false;
                        }
                        if (mt7Var.i0()) {
                            this.a.s = true;
                        }
                        this.a.G0.b3(this.a.s);
                        if (this.a.v0.f.size() > 0) {
                            mt7Var.O0(this.a.v0.f);
                        }
                        this.a.G0.U3(mt7Var, i2, i3, this.a.y0.k2(), i4, this.a.y0.B1());
                        this.a.G0.i4(mt7Var, this.a.y0.k2());
                        this.a.G0.n4(this.a.y0.v1());
                        AntiData d = mt7Var.d();
                        if (d != null) {
                            this.a.z = d.getVoice_message();
                            if (!StringUtils.isNull(this.a.z) && this.a.V0 != null && this.a.V0.a() != null && (m = this.a.V0.a().m(6)) != null && !TextUtils.isEmpty(this.a.z)) {
                                ((View) m).setOnClickListener(this.a.J1);
                            }
                        }
                        if (!this.a.Y && !ListUtils.isEmpty(this.a.y0.S1().F()) && !this.a.y0.D2()) {
                            this.a.Y = true;
                            this.a.b5(false);
                        }
                        if (TextUtils.isEmpty(this.a.R0)) {
                            if (this.a.Q0) {
                                this.a.Q0 = false;
                                py7.g(this.a.getListView());
                            } else if (this.a.S0) {
                                this.a.S0 = false;
                                py7.j(this.a.getListView());
                            } else if (!TextUtils.isEmpty(this.a.y0.I1())) {
                                py7.f(this.a.getListView(), this.a.y0.I1());
                                this.a.y0.L2();
                            } else {
                                this.a.G0.P3();
                            }
                        } else {
                            py7.i(this.a.y0.R1(), this.a.getListView(), this.a.R0);
                            this.a.R0 = null;
                        }
                        this.a.y0.M2(mt7Var.l(), this.a.N1);
                        this.a.y0.S2(this.a.Q1);
                        if (this.a.Y0 != null && O != null && O.getAuthor() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.getAuthor());
                            this.a.Y0.setLikeUserData(attentionHostData);
                        }
                        if (this.a.y0 == null || !this.a.y0.A2()) {
                            if (this.a.G0 != null) {
                                e1 = this.a.G0.e1();
                            }
                        } else {
                            e1 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0df0);
                        }
                        if (!StringUtils.isNull(e1)) {
                            this.a.V0.m0(TbSingleton.getInstance().getAdVertiComment(mt7Var.n0(), mt7Var.o0(), e1));
                        }
                    } else if (str != null) {
                        if (this.a.O0 || i4 != 1) {
                            this.a.showToast(str);
                        } else if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.y0.h1() != null && !StringUtils.isNull(this.a.y0.h1().c)) {
                                    this.a.G0.p4(this.a.y0.h1());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.G0.m1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c3f, str, Integer.valueOf(i)), true);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(ri.f(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.G0.m1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c3f, str, Integer.valueOf(i)), true);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(ri.f(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                            }
                            this.a.G0.o1();
                            this.a.G0.n1();
                        }
                        if (i == 4 || i == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.y0.m2());
                                jSONObject.put("fid", this.a.y0.getForumId());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        }
                        if (i != 0) {
                            EnterForePvThread enterForePvThread = new EnterForePvThread();
                            enterForePvThread.setOpType("2");
                            enterForePvThread.start();
                        }
                        if (i != -1) {
                            if (this.a.y0 != null && this.a.y0.S1() != null) {
                                arrayList = this.a.y0.S1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).B() != 1)) {
                                this.a.G0.W2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ef));
                            } else {
                                if (this.a.o6()) {
                                    this.a.G0.X2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0de1));
                                } else {
                                    this.a.G0.X2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0de2));
                                }
                                this.a.G0.F1(this.a.y0.S1());
                            }
                        } else {
                            this.a.G0.W2("");
                        }
                        this.a.G0.u0();
                    }
                    if (mt7Var != null && mt7Var.m && this.a.o == 0) {
                        this.a.o = System.currentTimeMillis() - this.a.n;
                    }
                    if (!this.a.K().k2() || this.a.K().S1().y().c() != 0 || this.a.K().x2()) {
                        this.a.W0 = true;
                    }
                    if (this.a.a instanceof PbActivity) {
                        ((PbActivity) this.a.a).u1(mt7Var != null ? mt7Var.g() : 0, this.a.G0);
                    }
                    e();
                    return;
                }
                this.a.y0.F3(1);
                if (this.a.e != null) {
                    this.a.e.x();
                }
                if (this.a.G0 != null) {
                    this.a.G0.c4();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.y0 == null) {
                return;
            }
            if (this.a.V0 == null || !this.a.V0.v) {
                p45 p45Var = new p45();
                this.a.h7(p45Var);
                PbFragment pbFragment = this.a;
                pbFragment.V0 = (q45) p45Var.a(pbFragment.getContext());
                this.a.V0.f0(this.a.a.getPageContext());
                this.a.V0.p0(this.a.m2);
                this.a.V0.q0(this.a.c1);
                this.a.V0.F(this.a.a.getPageContext(), this.a.a.getIntent() == null ? null : this.a.a.getIntent().getExtras());
                this.a.V0.a().C(true);
                this.a.G0.V2(this.a.V0.a());
                if (!this.a.y0.F1()) {
                    this.a.V0.s(this.a.y0.m2());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.a.V0.m0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.a.y0.A2()) {
                    this.a.V0.m0(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0df0));
                } else if (this.a.G0 != null) {
                    this.a.V0.m0(this.a.G0.e1());
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                tu4 k = tu4.k();
                if (k.h("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    return;
                }
                sg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r2 implements hg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public r2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
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
        @Override // com.baidu.tieba.hg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.g) {
                return;
            }
            this.a.E7();
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements yr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public s0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.yr4.c
        public void a(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.N0 = pbFragment.N0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.N0);
                    new xv7(this.a.y0.m2(), this.a.N0, "1").start();
                    yr4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.N0 = pbFragment2.N0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.N0);
                    new xv7(this.a.y0.m2(), this.a.N0, "2").start();
                    yr4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.N0 = pbFragment3.N0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.N0);
                    yr4Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.N7();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s2 implements hg<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public s2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ ItemCardView c(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            h(itemCardView2);
            return itemCardView2;
        }

        public ItemCardView e(ItemCardView itemCardView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, itemCardView)) == null) {
                itemCardView.G();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: g */
        public ItemCardView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ItemCardView(this.a.getPageContext().getPageActivity()) : (ItemCardView) invokeV.objValue;
        }

        public ItemCardView h(ItemCardView itemCardView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, itemCardView)) == null) {
                itemCardView.H();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0cc6));
                bdTopToast.i((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public t0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t1(PbFragment pbFragment, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.a.G0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.G0.m1());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.h(true);
                            bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0323));
                            bdTopToast.i((ViewGroup) this.a.getView());
                            this.a.i7(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c40) : httpResponsedMessage.getErrorString();
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.h(false);
                        bdTopToast2.g(string);
                        bdTopToast2.i((ViewGroup) this.a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t2 implements TbRichTextView.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public t2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            cw7 A0;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.G0.j2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.y0.m2());
                    statisticItem.param("fid", this.a.y0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view2.getTag(R.id.obfuscated_res_0x7f092026) == null || !(view2.getTag(R.id.obfuscated_res_0x7f092026) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
                        if (this.a.y0.G.i0()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            TbRichTextView tbRichTextView = null;
                            if (view2.getParent() instanceof TbRichTextView) {
                                tbRichTextView = (TbRichTextView) view2.getParent();
                            } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                                tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                            }
                            int i3 = -1;
                            if (tbRichTextView == null || tbRichTextView.getRichText() == null || tbRichTextView.getRichText().D() == null) {
                                i2 = -1;
                            } else {
                                ArrayList<TbRichTextImageInfo> D = tbRichTextView.getRichText().D();
                                int i4 = 0;
                                int i5 = -1;
                                while (i4 < D.size()) {
                                    if (D.get(i4) != null) {
                                        arrayList.add(D.get(i4).F());
                                        if (i5 == i3 && str != null && (str.equals(D.get(i4).F()) || str.equals(D.get(i4).B()) || str.equals(D.get(i4).z()) || str.equals(D.get(i4).A()) || str.equals(D.get(i4).D()))) {
                                            i5 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = D.get(i4).F();
                                        imageUrlData.originalUrl = D.get(i4).F();
                                        imageUrlData.isLongPic = D.get(i4).I();
                                        concurrentHashMap.put(D.get(i4).F(), imageUrlData);
                                    }
                                    i4++;
                                    i3 = -1;
                                }
                                i2 = i5;
                            }
                            Rect rect = new Rect();
                            view2.getGlobalVisibleRect(rect);
                            this.a.u5(rect);
                            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                            builder.y(arrayList);
                            builder.C(i2);
                            builder.D(false);
                            builder.G(this.a.y0.d2());
                            builder.x(concurrentHashMap);
                            builder.I(true);
                            builder.L(false);
                            builder.H(this.a.o6());
                            builder.N(rect, UtilHelper.fixedDrawableRect(rect, view2));
                            if (this.a.y0 != null) {
                                builder.B(this.a.y0.getFromForumId());
                                if (this.a.y0.S1() != null) {
                                    builder.O(this.a.y0.S1().O());
                                }
                            }
                            ImageViewerConfig w = builder.w(this.a.getPageContext().getPageActivity());
                            w.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, w));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.N6(str, i, eVar);
                        if (eVar.h) {
                            TbRichText Q7 = this.a.Q7(str, i);
                            if (Q7 != null && this.a.B2 >= 0 && this.a.B2 < Q7.B().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = nt7.a(Q7.B().get(this.a.B2));
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= eVar.a.size()) {
                                        break;
                                    } else if (eVar.a.get(i6).equals(a)) {
                                        eVar.j = i6;
                                        arrayList2.add(a);
                                        break;
                                    } else {
                                        i6++;
                                    }
                                }
                                if (Q7.getPostId() != 0 && (A0 = this.a.G0.A0()) != null) {
                                    ArrayList<pn> t = A0.t();
                                    if (ListUtils.getCount(t) > 0) {
                                        Iterator<pn> it = t.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            pn next = it.next();
                                            if ((next instanceof PostData) && Q7.getPostId() == pg.g(((PostData) next).K(), 0L)) {
                                                p08.b(this.a.y0.S1(), (PostData) next, ((PostData) next).b0, Q7.getPostId() == pg.g(this.a.y0.q1(), 0L) ? 1 : 8, 3);
                                            }
                                        }
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.b.get(str2));
                                }
                                Rect rect2 = new Rect();
                                view2.getGlobalVisibleRect(rect2);
                                this.a.u5(rect2);
                                ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                                builder2.y(arrayList2);
                                builder2.A(eVar.c);
                                builder2.z(eVar.d);
                                builder2.P(eVar.e);
                                builder2.D(eVar.g);
                                builder2.I(true);
                                builder2.K(eVar.i);
                                builder2.G(this.a.y0.d2());
                                builder2.x(concurrentHashMap2);
                                builder2.L(false);
                                builder2.H(this.a.o6());
                                builder2.M(eVar.f);
                                builder2.N(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                                if (this.a.y0 != null) {
                                    builder2.B(this.a.y0.getFromForumId());
                                    if (this.a.y0.S1() != null) {
                                        builder2.O(this.a.y0.S1().O());
                                    }
                                }
                                ImageViewerConfig w2 = builder2.w(this.a.getPageContext().getPageActivity());
                                w2.getIntent().putExtra("from", "pb");
                                this.a.sendMessage(new CustomMessage(2010000, w2));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.b.get(str3));
                        }
                        ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                        builder3.y(arrayList3);
                        builder3.A(eVar.c);
                        builder3.z(eVar.d);
                        builder3.P(eVar.e);
                        builder3.D(eVar.g);
                        builder3.I(true);
                        builder3.K(eVar.a.get(0));
                        builder3.G(this.a.y0.d2());
                        builder3.x(concurrentHashMap3);
                        builder3.L(false);
                        builder3.H(this.a.o6());
                        builder3.M(eVar.f);
                        builder3.E(false);
                        if (this.a.y0 != null) {
                            builder3.B(this.a.y0.getFromForumId());
                            if (this.a.y0.S1() != null) {
                                builder3.O(this.a.y0.S1().O());
                            }
                        }
                        ImageViewerConfig w3 = builder3.w(this.a.getPageContext().getPageActivity());
                        w3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, w3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092026);
                    boolean w4 = ((TbImageView) view2).w();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w4)));
                    }
                    this.a.S = view2;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (customResponsedMessage.getData() instanceof Boolean) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (error == 0 && booleanValue && TbadkCoreApplication.isLogin() && this.a.A0 != null && !this.a.A0.e()) {
                        this.a.D6();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                this.a.G0.s1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                mt7 S1 = this.a.y0.S1();
                if (S1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    S1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.d(this.a.h1.getResources().getString(R.string.obfuscated_res_0x7f0f0b38));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.h1.getResources().getString(R.string.obfuscated_res_0x7f0f0b34);
                    }
                    this.a.C7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.v7();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (qi.isEmpty(errorString2)) {
                        errorString2 = this.a.h1.getResources().getString(R.string.obfuscated_res_0x7f0f0b35);
                    }
                    this.a.i1.c(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements cm4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public u1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.cm4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.G0.v3();
                if (z) {
                    if (this.a.A0 != null) {
                        this.a.A0.h(z2);
                    }
                    this.a.y0.H3(z2);
                    if (this.a.y0.D1()) {
                        this.a.B6();
                    } else {
                        this.a.G0.F1(this.a.y0.S1());
                    }
                    if (z2) {
                        boolean m0 = this.a.y0.S1().m0();
                        if (this.a.A0 != null && !m0) {
                            if (this.a.A0.f() == null || this.a.y0 == null || this.a.y0.S1() == null || this.a.y0.S1().O() == null || this.a.y0.S1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.A0.f();
                            MetaData author = this.a.y0.S1().O().getAuthor();
                            if (f != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.u7(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d1);
                                    this.a.z7();
                                }
                            } else {
                                PbFragment pbFragment = this.a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d0));
                            }
                        }
                        this.a.X4();
                        return;
                    }
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fd5));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14c5));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u2 implements g3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public u2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.g3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.G0 != null && this.a.G0.b1() != null) {
                    ow7 b1 = this.a.G0.b1();
                    if (b1.f()) {
                        b1.d();
                        return true;
                    }
                }
                if (this.a.G0 == null || !this.a.G0.U1()) {
                    return false;
                }
                this.a.G0.w1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements TiePlusEventController.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public v(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.f
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                this.a.G0.s1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.d(this.a.h1.getResources().getString(R.string.obfuscated_res_0x7f0f149e));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (qi.isEmpty(muteMessage)) {
                    muteMessage = this.a.h1.getResources().getString(R.string.obfuscated_res_0x7f0f149d);
                }
                this.a.i1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public v1(PbFragment pbFragment, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v2 implements yr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public v2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.yr4.c
        public void a(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                if (yr4Var != null) {
                    yr4Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.E2;
                if (postData != null) {
                    if (i == 0) {
                        postData.B0();
                        this.a.E2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.F6(pbFragment2.E2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public w(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.a.m6() || this.a.a == null || this.a.a.b1() == null || !str.equals(this.a.a.b1().getTopicId())) {
                    return;
                }
                this.a.L7(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public w1(PbFragment pbFragment, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                wr4Var.dismiss();
                this.b.C0.l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.y0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w2 implements yr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public w2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.yr4.c
        public void a(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                if (yr4Var != null) {
                    yr4Var.e();
                }
                if (this.a.m1 == null || TextUtils.isEmpty(this.a.n1)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.p1 == null) {
                        this.a.Y4();
                    } else {
                        p55.a aVar = new p55.a();
                        aVar.a = this.a.n1;
                        String str = "";
                        if (this.a.p1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.p1.memeInfo.pck_id;
                        }
                        aVar.b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (this.a.X0 == null) {
                        this.a.X0 = new PermissionJudgePolicy();
                    }
                    this.a.X0.clearRequestPermissionList();
                    this.a.X0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.X0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.a.l1 == null) {
                        PbFragment pbFragment = this.a;
                        pbFragment.l1 = new zx7(pbFragment.getPageContext());
                    }
                    this.a.l1.b(this.a.n1, this.a.m1.n());
                }
                this.a.m1 = null;
                this.a.n1 = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof rp4)) {
                rp4 rp4Var = (rp4) customResponsedMessage.getData();
                kq4.a aVar = new kq4.a();
                int i = rp4Var.a;
                String str = rp4Var.b;
                aVar.a = rp4Var.d;
                mt7 S1 = this.a.y0.S1();
                if (S1 == null) {
                    return;
                }
                if (this.a.y0.u1() != null && this.a.y0.u1().getUserIdLong() == rp4Var.p) {
                    this.a.G0.K2(rp4Var.l, this.a.y0.S1(), this.a.y0.k2(), this.a.y0.c2());
                }
                if (S1.F() == null || S1.F().size() < 1 || S1.F().get(0) == null) {
                    return;
                }
                long g = pg.g(S1.F().get(0).K(), 0L);
                long g2 = pg.g(this.a.y0.m2(), 0L);
                if (g == rp4Var.n && g2 == rp4Var.m) {
                    kq4 I = S1.F().get(0).I();
                    if (I == null) {
                        I = new kq4();
                    }
                    ArrayList<kq4.a> a = I.a();
                    if (a == null) {
                        a = new ArrayList<>();
                    }
                    a.add(0, aVar);
                    I.e(I.b() + rp4Var.l);
                    I.d(a);
                    S1.F().get(0).G0(I);
                    this.a.G0.A0().a0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gs8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                gs8 gs8Var = (gs8) customResponsedMessage.getData();
                this.a.G0.s1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.g1;
                DataRes dataRes = gs8Var.a;
                if (gs8Var.c == 0 && dataRes != null) {
                    int e = pg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (qi.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092040, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f092040, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ffd)).intValue();
                if (intValue == 0) {
                    this.a.w7(r3, sparseArray);
                } else if (intValue == 1) {
                    this.a.G0.z2(sparseArray, r3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public x1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> F;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) || this.a.y0 == null || this.a.y0.S1() == null || this.a.G0 == null || this.a.G0.A0() == null) {
                return;
            }
            this.a.G0.s2(absListView, i, i2, i3);
            if (this.a.e != null) {
                this.a.e.q(absListView, i, i2, i3);
            }
            if (!this.a.y0.E2() || (F = this.a.y0.S1().F()) == null || F.isEmpty()) {
                return;
            }
            int w = ((i + i2) - this.a.G0.A0().w()) - 1;
            mt7 S1 = this.a.y0.S1();
            if (S1 == null) {
                return;
            }
            if (S1.D() != null && S1.D().i1()) {
                w--;
            }
            if (S1.E() != null && S1.E().i1()) {
                w--;
            }
            int size = F.size();
            if (w < 0 || w >= size) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                PbFragment pbFragment = this.a;
                if (!pbFragment.s6(pbFragment.f1) && this.a.s6(i)) {
                    if (this.a.G0 != null) {
                        this.a.s0 = true;
                        this.a.G0.m0();
                        if (this.a.V0 != null && !this.a.G0.H1()) {
                            this.a.G0.a3(this.a.V0.C());
                        }
                        if (!this.a.J) {
                            this.a.s0 = true;
                            this.a.G0.S2();
                        }
                    }
                    if (!this.a.t) {
                        this.a.t = true;
                    }
                }
                if (this.a.G0 != null) {
                    this.a.G0.t2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.u == null) {
                    this.a.u = new pa5();
                    this.a.u.a(1001);
                }
                if (i == 0) {
                    this.a.u.e();
                    if (this.a.i0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.i0);
                        this.a.i0 = null;
                    }
                } else {
                    if (this.a.i0 == null) {
                        this.a.i0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("pb", "1", "scroll");
                    }
                    this.a.u.d();
                }
                this.a.f1 = i;
                if (i == 0) {
                    this.a.b7(false, null);
                    kj8.g().h(this.a.getUniqueId(), true);
                    this.a.b5(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x2 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public x2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.y0 == null || this.a.y0.b2() == i + 1) {
                return;
            }
            PbFragment pbFragment = this.a;
            pbFragment.d7(pbFragment.Q5(i));
        }
    }

    /* loaded from: classes5.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.y0 == null || this.a.y0.S1() == null) {
                return;
            }
            this.a.y0.S1().a();
            this.a.y0.v2();
            if (this.a.G0.A0() != null) {
                this.a.G0.F1(this.a.y0.S1());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.G0.H1() && (customResponsedMessage.getData() instanceof MotionEvent)) {
                MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
                this.a.p5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements n45 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public y1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.n45
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                xx7 xx7Var = this.a.K0;
                if (xx7Var == null || xx7Var.e() == null || !this.a.K0.e().d()) {
                    return !this.a.g5(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.K0.e().c());
                if (this.a.V0 != null && (this.a.V0.B() || this.a.V0.D())) {
                    this.a.V0.z(false, this.a.K0.h());
                }
                this.a.K0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class y2 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public y2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.b = true;
                return pbFragment.j5(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.y0 == null || this.a.y0.S1() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.a.l5(str);
            this.a.y0.v2();
            if (!TextUtils.isEmpty(str) && this.a.y0.S1().F() != null) {
                ArrayList<PostData> F = this.a.y0.S1().F();
                il8 il8Var = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof il8) {
                        il8 il8Var2 = (il8) next;
                        if (str.equals(il8Var2.j1())) {
                            il8Var = il8Var2;
                            break;
                        }
                    }
                }
                if (il8Var != null) {
                    F.remove(il8Var);
                    if (this.a.G0.A0() != null && this.a.G0.A0().t() != null) {
                        this.a.G0.A0().t().remove(il8Var);
                    }
                    if (this.a.G0.R0() != null && this.a.G0.R0().getData() != null) {
                        this.a.G0.R0().getData().remove(il8Var);
                    }
                    if (this.a.G0.A0() != null) {
                        this.a.G0.A0().a0();
                        return;
                    }
                }
            }
            if (this.a.G0.A0() != null) {
                this.a.G0.F1(this.a.y0.S1());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            zk8 zk8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof zk8) || (zk8Var = (zk8) customResponsedMessage.getData()) == null || (agreeData = zk8Var.b) == null) {
                return;
            }
            if (this.a.G0 != null) {
                this.a.G0.f2(zk8Var);
            }
            if (agreeData.agreeType != 2 || this.a.G0 == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || oz7.k(this.a.y0.b)) {
                return;
            }
            this.a.G0.e4();
            oz7.b(this.a.y0.b);
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements Comparator<f15> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public z1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f15 f15Var, f15 f15Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, f15Var, f15Var2)) == null) ? f15Var.compareTo(f15Var2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public z2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view2, (ViewGroup) this.a.getView());
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
        T2 = new c1();
        U2 = new a();
    }

    public PbFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = false;
        this.g = false;
        this.h = false;
        this.j = true;
        this.l = 0;
        this.m = null;
        this.n = -1L;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.t = false;
        this.u = null;
        this.v = 0L;
        this.w = false;
        this.x = 0L;
        this.y = 1;
        this.z = null;
        this.I = false;
        this.J = false;
        this.K = false;
        this.M = "";
        this.N = true;
        this.O = false;
        this.P = "";
        this.X = 3;
        this.Z = new int[2];
        this.b0 = -1;
        this.c0 = -1;
        this.e0 = BdUniqueId.gen();
        this.g0 = false;
        this.q0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.u0 = new v(this);
        this.w0 = new g0(this);
        this.x0 = new Handler(new r0(this));
        this.y0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = false;
        this.I0 = false;
        this.J0 = false;
        this.O0 = false;
        this.Q0 = false;
        this.S0 = false;
        this.c1 = new n1(this);
        this.d1 = new y1(this);
        this.e1 = new j2(this);
        this.f1 = 0;
        this.q1 = false;
        this.r1 = 0;
        this.s1 = -1;
        this.u1 = 0;
        this.x1 = new u2(this);
        this.y1 = new f3(this);
        this.z1 = new k(this, 2004016);
        this.A1 = new m(this, 2016485);
        this.B1 = new n(this, 2001269);
        this.C1 = new o(this, 2004008);
        this.D1 = new p(this, 2004007);
        this.E1 = new q(this, 2004005);
        this.F1 = new r(this, 2001332);
        this.G1 = new s(this, 2921391);
        this.H1 = new t(this, 2921606);
        this.I1 = new u(this, 2921658);
        this.J1 = new w(this);
        this.K1 = new x(this, 2001369);
        this.L1 = new y(this, 2016488);
        this.M1 = new z(this, 2016331);
        this.N1 = new a0(this);
        this.O1 = new b0(this, 2921509);
        this.P1 = new c0(this, 2010045);
        this.Q1 = new d0(this);
        this.S1 = new PraiseModel(getPageContext(), new e0(this));
        this.T1 = new f0(this);
        this.U1 = new i0(this, 2001115);
        this.V1 = new j0(this);
        this.W1 = new m0(this);
        this.X1 = new ou7(new q0(this));
        this.Y1 = new t0(this);
        this.Z1 = new u0(this, 2001427);
        this.a2 = new v0(this, 2001428);
        this.b2 = new w0(this, 2921634);
        this.c2 = new x0(this, 2001426);
        this.d2 = new y0(this, 2004021);
        this.e2 = new z0(this, 2016528);
        this.f2 = new a1(this, 2921724);
        this.g2 = new b1(this, 2921033);
        this.h2 = new d1(this);
        this.i2 = new e1(this);
        this.j2 = new i1(this);
        this.k2 = new l1(this);
        this.l2 = new m1(this, 2921480);
        this.m2 = new o1(this);
        this.n2 = Boolean.FALSE;
        this.o2 = new p1(this);
        this.p2 = new q1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.q2 = new r1(this);
        this.r2 = new s1(this, 2016450);
        this.s2 = new t1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.t2 = new u1(this);
        this.u2 = new x1(this);
        this.v2 = new b2(this);
        this.w2 = new d2(this);
        this.x2 = new e2(this);
        this.y2 = new f2(this);
        this.A2 = new g2(this);
        this.B2 = 0;
        this.C2 = new t2(this);
        this.D2 = false;
        this.E2 = null;
        this.F2 = new v2(this);
        this.G2 = new w2(this);
        this.H2 = new x2(this);
        this.I2 = new y2(this);
        this.J2 = new z2(this);
        this.K2 = new a3(this);
        this.L2 = new b3(this);
        this.M2 = new d3(this);
        this.N2 = new e3(this);
        this.O2 = new b(this);
        this.P2 = -1;
        this.Q2 = -1;
    }

    public static PbFragment H6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public final String A5() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.S1() == null || this.y0.S1().F() == null || (count = ListUtils.getCount((F = this.y0.S1().F()))) == 0) {
                return "";
            }
            if (this.y0.d2()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.B() == 1) {
                        return next.K();
                    }
                }
            }
            int H0 = this.G0.H0();
            PostData postData = (PostData) ListUtils.getItem(F, H0);
            if (postData != null && postData.s() != null) {
                if (this.y0.K2(postData.s().getUserId())) {
                    return postData.K();
                }
                for (int i4 = H0 - 1; i4 != 0; i4--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i4);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (this.y0.K2(postData2.s().getUserId())) {
                        return postData2.K();
                    }
                }
                for (int i5 = H0 + 1; i5 < count; i5++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i5);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (this.y0.K2(postData3.s().getUserId())) {
                        return postData3.K();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void A6() {
        PbModel pbModel;
        mt7 mt7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pbModel = this.y0) == null || (mt7Var = pbModel.G) == null || mt7Var.O() == null || !this.y0.G.O().isQuestionThread()) {
            return;
        }
        ThreadData O = this.y0.G.O();
        String e22 = this.y0.e2();
        int i4 = 3;
        if ("3".equals(this.y0.f2())) {
            i4 = 1;
        } else if ("question_answer_invite".equals(e22)) {
            i4 = 2;
        }
        TiebaStatic.log(new StatisticItem("c14923").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i4));
    }

    public final void A7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && K() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                K().a1(postWriteCallBackData.getPostId());
                int E0 = this.G0.E0();
                this.r1 = E0;
                this.y0.q3(E0, this.G0.L0());
            }
            this.G0.m0();
            this.K0.c();
            q45 q45Var = this.V0;
            if (q45Var != null) {
                this.G0.a3(q45Var.C());
            }
            this.G0.q1();
            this.G0.J3(true);
            this.y0.v2();
        }
    }

    public final TbRichText B5(ArrayList<PostData> arrayList, String str, int i4) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, arrayList, str, i4)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    TbRichText V = arrayList.get(i5).V();
                    if (V != null && (B = V.B()) != null) {
                        int size = B.size();
                        int i6 = -1;
                        for (int i7 = 0; i7 < size; i7++) {
                            if (B.get(i7) != null && B.get(i7).getType() == 8) {
                                i6++;
                                if (B.get(i7).F().B().equals(str) || B.get(i7).F().C().equals(str)) {
                                    int h4 = (int) ri.h(TbadkCoreApplication.getInst());
                                    int width = B.get(i7).F().getWidth() * h4;
                                    int height = B.get(i7).F().getHeight() * h4;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.B2 = i7;
                                    return V;
                                } else if (i6 > i4) {
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

    public final void B6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            mt7 S1 = this.y0.S1();
            this.y0.H3(true);
            cm4 cm4Var = this.A0;
            if (cm4Var != null) {
                S1.H0(cm4Var.g());
            }
            this.G0.F1(S1);
        }
    }

    public final void B7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i4) == null) {
            oz7.o(this, w5(), i4);
        }
    }

    @Override // com.baidu.tieba.qi5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ux7 ux7Var = this.G0;
            if (ux7Var == null) {
                return 0;
            }
            return ux7Var.g1();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.a18
    public PbModel.h C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q2 : (PbModel.h) invokeV.objValue;
    }

    public final int C5(TbRichText tbRichText, TbRichText tbRichText2, int i4, int i5, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i4), Integer.valueOf(i5), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.D2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.B().size();
                int i6 = i4;
                int i7 = -1;
                for (int i8 = 0; i8 < size; i8++) {
                    TbRichTextData tbRichTextData = tbRichText.B().get(i8);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i7++;
                        int h4 = (int) ri.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * h4;
                        int height = tbRichTextData.F().getHeight() * h4;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.F().H()) {
                            if (tbRichText == tbRichText2) {
                                if (i7 <= i5) {
                                    i6--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a4 = nt7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a4)) {
                                arrayList.add(a4);
                                if (tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                    String B = F.B();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        B = F.C();
                                    } else {
                                        imageUrlData.urlType = this.s ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = B;
                                    imageUrlData.originalUrl = M5(tbRichTextData);
                                    imageUrlData.originalSize = N5(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = G5(tbRichTextData);
                                    imageUrlData.isLongPic = E5(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = pg.g(this.y0.m2(), -1L);
                                    imageUrlData.mIsReserver = this.y0.d2();
                                    imageUrlData.mIsSeeHost = this.y0.v1();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a4, imageUrlData);
                                    }
                                }
                            }
                            if (!this.D2) {
                                i6++;
                            }
                        }
                    }
                }
                return i6;
            }
            return i4;
        }
        return invokeCommon.intValue;
    }

    public void C6() {
        ux7 ux7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (ux7Var = this.G0) == null) {
            return;
        }
        ux7Var.c2();
    }

    public final void C7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (str == null) {
                str = "";
            }
            d9 d9Var = this.h1;
            if (d9Var == null) {
                return;
            }
            wr4 wr4Var = new wr4(d9Var.getPageActivity());
            wr4Var.setMessage(str);
            wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09a4, new e(this));
            wr4Var.create(this.h1).show();
        }
    }

    public PbInterviewStatusView.f D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.w0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public final void D6() {
        MarkData i12;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.A0 == null) {
            return;
        }
        if (this.y0.S1() != null && this.y0.S1().i0()) {
            i12 = this.y0.i1(0);
        } else {
            i12 = this.y0.i1(this.G0.Q0());
        }
        if (i12 == null) {
            return;
        }
        if (i12.isApp() && (i12 = this.y0.i1(this.G0.Q0() + 1)) == null) {
            return;
        }
        this.G0.w3();
        this.A0.i(i12);
        if (!this.A0.e()) {
            if (this.G0 != null && this.y0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !oz7.k(this.y0.b)) {
                this.G0.e4();
                oz7.b(this.y0.b);
            }
            this.A0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.A0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final void D7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.G0.R3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            wr4 wr4Var = new wr4(this.h1.getPageActivity());
            if (qi.isEmpty(str)) {
                wr4Var.setMessage(this.h1.getResources().getString(R.string.obfuscated_res_0x7f0f031f, str3));
            } else {
                wr4Var.setMessage(str);
            }
            wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0432, new f(this, userMuteAddAndDelCustomMessage));
            wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new g(this));
            wr4Var.create(this.h1).show();
        }
    }

    public final boolean E5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().I();
        }
        return invokeL.booleanValue;
    }

    public final void E6(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fea)) == null) {
                return;
            }
            F6(postData);
        }
    }

    public final void E7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (pbModel = this.y0) == null || qi.isEmpty(pbModel.m2())) {
            return;
        }
        ej4.w().P(dj4.Z, pg.g(this.y0.m2(), 0L));
    }

    @Override // com.baidu.tieba.qi5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.w = true;
        }
    }

    public boolean F5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (!this.c && this.P2 == -1 && this.Q2 == -1) ? false : true : invokeV.booleanValue;
    }

    public void F6(PostData postData) {
        PostData x5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.K() != null && postData.K().equals(this.y0.N1())) {
            z3 = true;
        }
        MarkData M1 = this.y0.M1(postData);
        if (this.y0.S1() != null && this.y0.S1().i0() && (x5 = x5()) != null) {
            M1 = this.y0.M1(x5);
        }
        if (M1 == null) {
            return;
        }
        this.G0.w3();
        cm4 cm4Var = this.A0;
        if (cm4Var != null) {
            cm4Var.i(M1);
            if (!z3) {
                this.A0.a();
            } else {
                this.A0.d();
            }
        }
    }

    public final void F7(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f091fea) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fea)) != null) {
            G7(postData, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public gg<TbImageView> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.B == null) {
                this.B = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.B;
        }
        return (gg) invokeV.objValue;
    }

    public final boolean G5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().J();
        }
        return invokeL.booleanValue;
    }

    public final boolean G6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q3 = tu4.k().q("bubble_link", "");
                if (StringUtils.isNull(q3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    km4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f053e), q3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void G7(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, postData, z3) == null) {
            e7(false);
            if (postData == null || (pbModel = this.y0) == null || pbModel.S1() == null || postData.B() == 1) {
                return;
            }
            String m22 = this.y0.m2();
            String K = postData.K();
            int W = this.y0.S1() != null ? this.y0.S1().W() : 0;
            AbsPbActivity.e P6 = P6(K);
            if (P6 == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(m22, K, "pb", true, false, null, false, null, W, postData.b0(), this.y0.S1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(P6.a, P6.b, P6.g, P6.j);
            addBigImageData.setKeyPageStartFrom(this.y0.R1());
            addBigImageData.setFromFrsForumId(this.y0.getFromForumId());
            addBigImageData.setWorksInfoData(this.y0.r2());
            addBigImageData.setKeyFromForumId(this.y0.getForumId());
            addBigImageData.setBjhData(this.y0.k1());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    @Override // com.baidu.tieba.qi5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, str) == null) {
            ay7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.w = true;
        }
    }

    public boolean H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.n2.booleanValue() : invokeV.booleanValue;
    }

    public final void H7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                absPbActivity.p1();
            }
        }
    }

    public boolean I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.K : invokeV.booleanValue;
    }

    public void I6() {
        List<g3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (list = this.t1) == null || list.isEmpty()) {
            return;
        }
        int size = this.t1.size();
        while (true) {
            size--;
            if (size <= -1 || this.t1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    public final void I7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.q1();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qi5
    /* renamed from: J5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ux7 ux7Var = this.G0;
            if (ux7Var == null) {
                return null;
            }
            return ux7Var.R0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public boolean J6(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        ux7 ux7Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048609, this, i4, keyEvent)) == null) ? (keyEvent == null || (ux7Var = this.G0) == null || !ux7Var.k2(i4)) ? false : true : invokeIL.booleanValue;
    }

    public final boolean J7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.S1() == null || !this.y0.S1().i0()) {
                if (this.y0.D1()) {
                    MarkData o12 = this.y0.o1();
                    if (o12 != null && this.y0.B1()) {
                        MarkData i12 = this.y0.i1(this.G0.H0());
                        if (i12 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", o12);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (i12.getPostId() != null && !i12.getPostId().equals(o12.getPostId())) {
                            wr4 wr4Var = new wr4(getPageContext().getPageActivity());
                            wr4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0265));
                            wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0432, new k2(this, i12, o12, wr4Var));
                            wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new l2(this, o12, wr4Var));
                            wr4Var.setOnCalcelListener(new m2(this, o12, wr4Var));
                            wr4Var.create(getPageContext());
                            wr4Var.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", o12);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.y0.S1() != null && this.y0.S1().F() != null && this.y0.S1().F().size() > 0 && this.y0.B1()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a18
    public PbModel K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.y0 : (PbModel) invokeV.objValue;
    }

    public int K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.Q2 : invokeV.intValue;
    }

    public final void K6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (!pi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c41);
                return;
            }
            this.G0.m0();
            if (this.i) {
                return;
            }
            H7();
            this.G0.w3();
            if (this.y0.loadData()) {
                this.G0.b4();
            }
        }
    }

    public final void K7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (absPbActivity = this.a) == null || absPbActivity.b1() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.b1().m2()).param("topic_id", this.a.b1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.b1().q2()));
    }

    @Override // com.baidu.tieba.qi5
    public gg<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            gg<RelativeLayout> ggVar = new gg<>(new r2(this), 10, 0);
            this.G = ggVar;
            return ggVar;
        }
        return (gg) invokeV.objValue;
    }

    public int L5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.P2 : invokeV.intValue;
    }

    public void L6() {
        PbModel pbModel;
        mt7 S1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (pbModel = this.y0) == null || pbModel.S1() == null || (O = (S1 = this.y0.S1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.G0.q1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        dx7 dx7Var = new dx7();
        int W = this.y0.S1().W();
        if (W != 1 && W != 3) {
            dx7Var.g = false;
        } else {
            dx7Var.g = true;
            dx7Var.s = O.getIs_top() == 1;
        }
        if (q6(W)) {
            dx7Var.h = true;
            dx7Var.r = O.getIs_good() == 1;
        } else {
            dx7Var.h = false;
        }
        if (W == 1002 && !equals) {
            dx7Var.u = true;
        }
        dx7Var.n = s7(O.isBlocked(), S1.k0(), equals, W, O.isWorksInfo(), O.isScoreThread());
        dx7Var.e = q7(equals, S1.k0());
        dx7Var.i = t7();
        dx7Var.f = r7(equals);
        dx7Var.k = equals && S1.V() != null && S1.V().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            dx7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        dx7Var.t = equals;
        dx7Var.q = this.y0.k2();
        dx7Var.b = true;
        dx7Var.a = t6(equals);
        if (equals) {
            this.G0.G1();
        }
        dx7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        dx7Var.j = true;
        dx7Var.o = this.y0.v1();
        dx7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            dx7Var.c = true;
        } else {
            dx7Var.c = false;
        }
        if (S1.i0()) {
            dx7Var.b = false;
            dx7Var.d = false;
            dx7Var.c = false;
            dx7Var.g = false;
            dx7Var.h = false;
        }
        dx7Var.v = TbSingleton.getInstance().mShowCallFans && equals && !S1.i0();
        ux7 ux7Var = this.G0;
        if (ux7Var != null) {
            PbModel pbModel2 = this.y0;
            PostData I0 = ux7Var.I0(pbModel2.G, pbModel2.k2());
            dx7Var.w = I0 != null ? I0.Q : false;
        }
        dx7Var.m = true;
        if (O.isBlocked()) {
            dx7Var.n = false;
            dx7Var.g = false;
            dx7Var.h = false;
        }
        this.G0.h.F(dx7Var);
    }

    public final void L7(boolean z3) {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z3) == null) || (absPbActivity = this.a) == null || absPbActivity.b1() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(!z3 ? "c14397" : "c14398").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.b1().m2()).param("topic_id", this.a.b1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.b1().q2()));
    }

    public final String M5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return null;
            }
            return tbRichTextData.F().D();
        }
        return (String) invokeL.objValue;
    }

    public void M6() {
        o05 o05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (o05Var = this.r0) == null) {
            return;
        }
        o05Var.q();
    }

    public final void M7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.y0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(mz7.m(i4))));
        }
    }

    @Override // com.baidu.tieba.qi5
    public gg<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.C == null) {
                this.C = new gg<>(new n2(this), 8, 0);
            }
            return this.C;
        }
        return (gg) invokeV.objValue;
    }

    public final long N5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return 0L;
            }
            return tbRichTextData.F().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void N6(String str, int i4, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048624, this, str, i4, eVar) == null) || eVar == null) {
            return;
        }
        mt7 S1 = this.y0.S1();
        TbRichText Q7 = Q7(str, i4);
        if (Q7 == null || (tbRichTextData = Q7.B().get(this.B2)) == null) {
            return;
        }
        eVar.f = String.valueOf(Q7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a4 = nt7.a(tbRichTextData);
            eVar.a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.s ? 17 : 18;
            }
            imageUrlData.originalUrl = M5(tbRichTextData);
            imageUrlData.originalUrl = M5(tbRichTextData);
            imageUrlData.originalSize = N5(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = G5(tbRichTextData);
            imageUrlData.isLongPic = E5(tbRichTextData);
            imageUrlData.postId = Q7.getPostId();
            imageUrlData.mIsReserver = this.y0.d2();
            imageUrlData.mIsSeeHost = this.y0.v1();
            eVar.b.put(a4, imageUrlData);
            if (S1 != null) {
                if (S1.l() != null) {
                    eVar.c = S1.l().getName();
                    eVar.d = S1.l().getId();
                }
                if (S1.O() != null) {
                    eVar.e = S1.O().getId();
                }
                eVar.g = S1.s() == 1;
            }
            imageUrlData.threadId = pg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = S1.F().size();
        this.D2 = false;
        eVar.j = -1;
        int C5 = S1.j() != null ? C5(S1.j().V(), Q7, i4, i4, eVar.a, eVar.b) : i4;
        for (int i5 = 0; i5 < size; i5++) {
            PostData postData = S1.F().get(i5);
            if (postData.K() == null || S1.j() == null || S1.j().K() == null || !postData.K().equals(S1.j().K())) {
                C5 = C5(postData.V(), Q7, C5, i4, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (S1 != null) {
            if (S1.l() != null) {
                eVar.c = S1.l().getName();
                eVar.d = S1.l().getId();
            }
            if (S1.O() != null) {
                eVar.e = S1.O().getId();
            }
            eVar.g = S1.s() == 1;
        }
        eVar.j = C5;
    }

    public final void N7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.E(this.y0.getForumId()) && this.y0.S1() != null && this.y0.S1().l() != null) {
            if (this.y0.S1().l().isLike() == 1) {
                this.y0.f1().D(this.y0.getForumId(), this.y0.m2());
            }
        }
    }

    @Override // com.baidu.tieba.qi5
    public gg<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.D == null) {
                this.D = new gg<>(new q2(this), 8, 0);
            }
            return this.D;
        }
        return (gg) invokeV.objValue;
    }

    public q45 O5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.V0 : (q45) invokeV.objValue;
    }

    public void O6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.S1() != null && this.y0.S1().l() != null) {
                if (c5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.y0.S1().i0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.G0.f0();
                    return;
                } else {
                    if (this.Z0 == null) {
                        yo6 yo6Var = new yo6(getPageContext());
                        this.Z0 = yo6Var;
                        yo6Var.j(0);
                        this.Z0.i(new h1(this));
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.Z0.g(this.y0.S1().l().getId(), pg.g(this.y0.m2(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void O7(cp4 cp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, cp4Var) == null) || cp4Var == null) {
            return;
        }
        this.S2 = cp4Var;
        this.c = true;
        this.G0.P2();
        this.G0.j3(this.R2);
    }

    @Override // com.baidu.tieba.a18
    public AbsPbActivity P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public zy7 P5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.e : (zy7) invokeV.objValue;
    }

    public final AbsPbActivity.e P6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
            String str2 = null;
            if (this.y0.S1() != null && this.y0.S1().F() != null && this.y0.S1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 >= this.y0.S1().F().size()) {
                        i4 = 0;
                        break;
                    } else if (str.equals(this.y0.S1().F().get(i4).K())) {
                        break;
                    } else {
                        i4++;
                    }
                }
                PostData postData = this.y0.S1().F().get(i4);
                if (postData.V() != null && postData.V().B() != null) {
                    Iterator<TbRichTextData> it = postData.V().B().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.F() != null) {
                                str2 = next.F().B();
                            }
                        }
                    }
                    N6(str2, 0, eVar);
                    nt7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void P7(int i4) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048633, this, i4) == null) || (pbModel = this.y0) == null || pbModel.S1() == null || (O = this.y0.S1().O()) == null) {
            return;
        }
        if (i4 == 1) {
            PraiseData praise = O.getPraise();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (praise == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i4);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    O.setPraise(praiseData);
                } else {
                    O.getPraise().getUser().add(0, metaData);
                    O.getPraise().setNum(O.getPraise().getNum() + 1);
                    O.getPraise().setIsLike(i4);
                }
            }
            if (O.getPraise() != null) {
                if (O.getPraise().getNum() < 1) {
                    getResources().getString(R.string.obfuscated_res_0x7f0f1637);
                } else {
                    StringHelper.numFormatOver10000(O.getPraise().getNum());
                }
            }
        } else if (O.getPraise() != null) {
            O.getPraise().setIsLike(i4);
            O.getPraise().setNum(O.getPraise().getNum() - 1);
            ArrayList<MetaData> user = O.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        O.getPraise().getUser().remove(next);
                        break;
                    }
                }
            }
            if (O.getPraise().getNum() < 1) {
                getResources().getString(R.string.obfuscated_res_0x7f0f1637);
            } else {
                String str = O.getPraise().getNum() + "";
            }
        }
        if (this.y0.k2()) {
            this.G0.A0().a0();
        } else {
            this.G0.v4(this.y0.S1());
        }
    }

    @Override // com.baidu.tieba.qi5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, context, str) == null) {
        }
    }

    public final int Q5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i4)) == null) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return i4 != 3 ? 1 : 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeI.intValue;
    }

    public boolean Q6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            o05 o05Var = this.r0;
            return o05Var != null && o05Var.t();
        }
        return invokeV.booleanValue;
    }

    public final TbRichText Q7(String str, int i4) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048637, this, str, i4)) == null) {
            PbModel pbModel = this.y0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.S1() == null || str == null || i4 < 0) {
                return null;
            }
            mt7 S1 = this.y0.S1();
            if (S1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(S1.j());
                tbRichText = B5(arrayList, str, i4);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = S1.F();
                a5(S1, F);
                return B5(F, str, i4);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.qi5
    public void R(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048638, this, context, str, z3) == null) {
            if (ay7.c(str) && (pbModel = this.y0) != null && pbModel.m2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.y0.m2()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    y15 y15Var = new y15();
                    y15Var.a = str;
                    y15Var.b = 3;
                    y15Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, y15Var));
                }
            } else {
                ay7.a().e(getPageContext(), str);
            }
            this.w = true;
        }
    }

    public kz7 R5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.v0 : (kz7) invokeV.objValue;
    }

    public final void R6(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048640, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091854, Integer.valueOf(this.b ? 2 : 3));
        view2.setTag(sparseArray);
    }

    public ux7 S5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.G0 : (ux7) invokeV.objValue;
    }

    public void S6(cu7 cu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, cu7Var) == null) {
            String K = cu7Var.i().K();
            List<PostData> list = this.y0.S1().T().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i4);
                if (postData.K() == null || !postData.K().equals(K)) {
                    i4++;
                } else {
                    ArrayList<PostData> k3 = cu7Var.k();
                    postData.W0(cu7Var.m());
                    if (postData.Y() != null) {
                        postData.Y().clear();
                        postData.Y().addAll(k3);
                    }
                }
            }
            if (this.y0.B1()) {
                return;
            }
            this.G0.F1(this.y0.S1());
        }
    }

    public final void T5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            if (this.E0 == null) {
                this.E0 = new PollingModel(getPageContext(), getUniqueId());
            }
            this.E0.M(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            sg.a().postDelayed(this.Y1, 10000L);
        }
    }

    public void T6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048644, this, z3, markData) == null) {
            this.G0.v3();
            this.y0.H3(z3);
            cm4 cm4Var = this.A0;
            if (cm4Var != null) {
                cm4Var.h(z3);
                if (markData != null) {
                    this.A0.i(markData);
                }
            }
            if (this.y0.D1()) {
                B6();
            } else {
                this.G0.F1(this.y0.S1());
            }
        }
    }

    public tq4 U5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.d0 : (tq4) invokeV.objValue;
    }

    public void U6(cu7 cu7Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048646, this, cu7Var) == null) || cu7Var.i() == null) {
            return;
        }
        String K = cu7Var.i().K();
        ArrayList<PostData> F = this.y0.S1().F();
        int i4 = 0;
        while (true) {
            if (i4 >= F.size()) {
                break;
            }
            PostData postData = F.get(i4);
            if (postData.K() == null || !postData.K().equals(K)) {
                i4++;
            } else {
                ArrayList<PostData> k3 = cu7Var.k();
                postData.W0(cu7Var.m());
                if (postData.Y() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.f0() != null && next != null && next.s() != null && (metaData = postData.f0().get(next.s().getUserId())) != null) {
                            next.A0(metaData);
                            next.M0(true);
                            next.f1(getPageContext(), this.y0.K2(metaData.getUserId()));
                        }
                    }
                    z3 = k3.size() != postData.Y().size();
                    if (!postData.m0(false)) {
                        postData.Y().clear();
                        postData.Y().addAll(k3);
                    }
                }
                if (postData.y() != null) {
                    postData.y0();
                }
            }
        }
        if (!this.y0.B1() && z3) {
            this.G0.F1(this.y0.S1());
        }
        if (z3) {
            S6(cu7Var);
        }
    }

    @Override // com.baidu.tieba.qi5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048647, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.N0 = str;
        if (this.m == null) {
            k6();
        }
        TiebaStatic.log("pb_show_phonedialog");
        if (str2.equals("2")) {
            this.m.f(1).setVisibility(8);
        } else {
            this.m.f(1).setVisibility(0);
        }
        this.m.m();
        this.w = true;
    }

    public void V4(g3 g3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048648, this, g3Var) == null) || g3Var == null) {
            return;
        }
        if (this.t1 == null) {
            this.t1 = new ArrayList();
        }
        if (this.t1.contains(g3Var)) {
            return;
        }
        this.t1.add(g3Var);
    }

    public String V5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public final void V6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            hideNetRefreshView(this.G0.m1());
            x7();
            if (this.y0.T2()) {
                this.G0.w3();
            }
            this.G0.E3();
        }
    }

    @Override // com.baidu.tieba.b28.b
    public void W0(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z3) == null) {
            this.P0 = z3;
        }
    }

    public void W4(g3 g3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048652, this, g3Var) == null) || g3Var == null) {
            return;
        }
        if (this.t1 == null) {
            this.t1 = new ArrayList();
        }
        if (this.t1.contains(g3Var)) {
            return;
        }
        this.t1.add(0, g3Var);
    }

    public final int W5(mt7 mt7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, mt7Var)) == null) {
            if (mt7Var == null || mt7Var.O() == null) {
                return 0;
            }
            if (mt7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (mt7Var.O().getThreadType() == 54) {
                return 2;
            }
            return mt7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void W6(g3 g3Var) {
        List<g3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048654, this, g3Var) == null) || g3Var == null || (list = this.t1) == null) {
            return;
        }
        list.remove(g3Var);
    }

    public final void X4() {
        PbModel pbModel;
        mt7 mt7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048655, this) == null) || (pbModel = this.y0) == null || (mt7Var = pbModel.G) == null || mt7Var.O() == null) {
            return;
        }
        ThreadData O = this.y0.G.O();
        O.mRecomAbTag = this.y0.X1();
        O.mRecomWeight = this.y0.a2();
        O.mRecomSource = this.y0.Z1();
        O.mRecomExtra = this.y0.Y1();
        O.isSubPb = this.y0.F1();
        if (O.getFid() == 0) {
            O.setFid(pg.g(this.y0.getForumId(), 0L));
        }
        StatisticItem i4 = aa5.i(getContext(), O, "c13562");
        TbPageTag l3 = aa5.l(getContext());
        if (l3 != null && "a008".equals(l3.locatePage)) {
            i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
        }
        if (l3 != null && "a002".equals(l3.locatePage)) {
            i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
        }
        if (i4 != null) {
            TiebaStatic.log(i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a18
    /* renamed from: X5 */
    public VideoPbFragment B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public void X6() {
        o05 o05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || (o05Var = this.r0) == null) {
            return;
        }
        o05Var.x();
    }

    @Override // com.baidu.tieba.qi5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, context, str) == null) {
            this.w = true;
        }
    }

    @Override // com.baidu.tieba.qi5
    public gg<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (this.A == null) {
                this.A = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (gg) invokeV.objValue;
    }

    public final void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            if (this.o1 != null) {
                p55.b bVar = new p55.b();
                bVar.a = this.o1.D();
                bVar.b = this.o1.B();
                bVar.c = String.valueOf(this.o1.E());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.n1));
        }
    }

    public String Y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public final boolean Y6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091fea);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.N0 && !TextUtils.isEmpty(postData.t()) && tn4.c().g()) {
                        return G6(postData.K());
                    }
                    if (!checkUpIsLogin()) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return true;
                    }
                    PbModel pbModel = this.y0;
                    if (pbModel != null && pbModel.S1() != null) {
                        if (S5().b1() != null) {
                            S5().b1().c();
                        }
                        cu7 cu7Var = new cu7();
                        cu7Var.A(this.y0.S1().l());
                        cu7Var.E(this.y0.S1().O());
                        cu7Var.C(postData);
                        S5().a1().V(cu7Var);
                        S5().a1().setPostId(postData.K());
                        z6(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        q45 q45Var = this.V0;
                        if (q45Var != null) {
                            this.G0.a3(q45Var.C());
                        }
                        return true;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void Z4(boolean z3) {
        PbModel pbModel;
        mt7 mt7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048663, this, z3) == null) || (pbModel = this.y0) == null || (mt7Var = pbModel.G) == null || mt7Var.O() == null) {
            return;
        }
        ThreadData O = this.y0.G.O();
        O.mRecomAbTag = this.y0.X1();
        O.mRecomWeight = this.y0.a2();
        O.mRecomSource = this.y0.Z1();
        O.mRecomExtra = this.y0.Y1();
        if (O.getFid() == 0) {
            O.setFid(pg.g(this.y0.getForumId(), 0L));
        }
        StatisticItem i4 = aa5.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l3 = aa5.l(getContext());
        if (l3 != null && "a008".equals(l3.locatePage)) {
            i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
        }
        if (l3 != null && "a002".equals(l3.locatePage)) {
            i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
        }
        if (i4 != null) {
            i4.param(TiebaStatic.Params.REPLY_TYPE, 1);
            v95 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(i4);
        }
        if (z3) {
            return;
        }
        A6();
    }

    public void Z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            if (this.g) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.y0.S1() == null || this.y0.S1().O() == null || this.y0.S1().O().getTaskInfoData() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.y0.S1().O().getTaskInfoData().g(), this.y0.S1().O().getTaskInfoData().f(), this.y0.S1().O().getTaskInfoData().b(), this.y0.S1().O().getTaskInfoData().c(), this.y0.S1().O().getIs_top(), this.y0.S1().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void Z6(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048665, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.Q == null) {
            uy7 uy7Var = new uy7(this.a);
            this.Q = uy7Var;
            uy7Var.n(this.c1);
            this.Q.m(this.m2);
        }
        this.Q.k(emotionImageData, K(), K().S1());
    }

    public final void a5(mt7 mt7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048666, this, mt7Var, arrayList) == null) || mt7Var == null || mt7Var.T() == null || mt7Var.T().a == null || (list = mt7Var.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.K()) && !TextUtils.isEmpty(postData.K()) && next.K().equals(postData.K())) {
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

    public final void a6(int i4, Intent intent) {
        z25 z25Var;
        z25 z25Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048667, this, i4, intent) == null) {
            if (i4 == 0) {
                this.G0.q1();
                this.G0.b1().c();
                this.G0.J3(false);
            }
            this.G0.S2();
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
                    if (editorType != 1 || this.G0.b1() == null || this.G0.b1().b() == null) {
                        return;
                    }
                    u45 b4 = this.G0.b1().b();
                    b4.c0(this.y0.S1().O());
                    b4.B(writeData);
                    b4.d0(pbEditorData.getVoiceModel());
                    y25 n3 = b4.a().n(6);
                    if (n3 != null && (z25Var2 = n3.m) != null) {
                        z25Var2.A(new n25(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        b4.F();
                        return;
                    }
                    return;
                }
                this.V0.T();
                this.V0.w0(pbEditorData.getVoiceModel());
                this.V0.G(writeData);
                y25 n4 = this.V0.a().n(6);
                if (n4 != null && (z25Var = n4.m) != null) {
                    z25Var.A(new n25(52, 0, pbEditorData.getVoiceModel()));
                }
                this.V0.r0(pbEditorData.isShowCustomFigure());
                if (i4 == -1) {
                    this.V0.M(null, null);
                }
            }
        }
    }

    public final void a7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || (pbModel = this.y0) == null || pbModel.S1() == null || this.y0.S1().O() == null || !this.y0.S1().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public void b5(boolean z3) {
        ux7 ux7Var;
        int w3;
        int w4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048669, this, z3) == null) || (ux7Var = this.G0) == null || ux7Var.R0() == null) {
            return;
        }
        int firstVisiblePosition = this.G0.R0().getFirstVisiblePosition();
        int lastVisiblePosition = this.G0.R0().getLastVisiblePosition();
        cw7 A0 = this.G0.A0();
        if (A0 == null || this.y0.S1() == null) {
            return;
        }
        if (lastVisiblePosition <= A0.w()) {
            w3 = 0;
            w4 = 1;
        } else {
            w3 = firstVisiblePosition > A0.w() ? firstVisiblePosition - A0.w() : 0;
            w4 = (lastVisiblePosition - A0.w()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (w4 > w3) {
            while (w3 < w4) {
                if (this.G0.R0().G(w3) != null && (this.G0.R0().G(w3) instanceof PostData) && (postData = (PostData) this.G0.R0().G(w3)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.y0.S1().F(), postData.B() - 1);
                    if (postData.o() == null && postData2 != null) {
                        postData.z0(postData2.o());
                    }
                    if (postData.o() != null) {
                        postData.o().q(postData.B());
                        arrayList.add(postData.o());
                    }
                }
                w3++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new z1(this));
            f15 f15Var = (f15) ListUtils.getItem(arrayList, 0);
            if (f15Var == null || f15Var.e() != 1) {
                this.G0.D2(f15Var, 1);
            } else if (z3) {
            } else {
                this.G0.D2(f15Var, 0);
            }
        }
    }

    public void b6(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048670, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092043) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092043) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092045) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092045) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092044) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092040) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f092041) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092041) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.j1);
            userMuteAddAndDelCustomMessage.setTag(this.j1);
            D7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void b7(boolean z3, PostData postData) {
        qx4 adAdSense;
        ux7 ux7Var;
        cw7 A0;
        ArrayList<PostData> E;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048671, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e() || (ux7Var = this.G0) == null || (A0 = ux7Var.A0()) == null || (E = A0.E()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PostData> it = E.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PostData next = it.next();
            String K = next.K();
            if (z3) {
                if (next == postData) {
                    arrayList.add(new ol8.c());
                    break;
                }
            } else if (next.C == 1 && !TextUtils.isEmpty(K)) {
                next.C = 2;
                arrayList.add(new ol8.c());
            }
        }
        if (arrayList.size() <= 0 || (pbModel = this.y0) == null || pbModel.S1() == null || this.y0.S1().l() == null) {
            return;
        }
        this.y0.S1().l().getFirst_class();
        this.y0.S1().l().getSecond_class();
        this.y0.S1().l().getId();
        this.y0.m2();
    }

    public final boolean c5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.S1() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.y0.S1().O()) || AntiHelper.d(getPageContext(), this.y0.S1().d());
        }
        return invokeV.booleanValue;
    }

    public final void c6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, str) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.S1() != null && this.y0.S1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.y0.m2(), str);
                ThreadData O = this.y0.S1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                u6(format);
                return;
            }
            this.z0.a(str);
        }
    }

    public final void c7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048674, this) == null) || (pbModel = this.y0) == null || pbModel.S1() == null || this.y0.S1().O() == null || !this.y0.S1().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public final boolean d5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048675, this, i4)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i4)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void d6(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, intent) == null) {
            oz7.j(this, intent);
        }
    }

    public final void d7(int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048677, this, i4) == null) || this.y0 == null) {
            return;
        }
        x7();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
        privacySettingMessage.setTid(this.y0.b);
        sendMessage(privacySettingMessage);
    }

    @Override // com.baidu.tieba.qi5
    public gg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            if (this.H == null) {
                this.H = new gg<>(new s2(this), 10, 0);
            }
            return this.H;
        }
        return (gg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public void e5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.G0.R3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = pg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = pg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092042), 0L);
            BdUniqueId bdUniqueId = this.j1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.g1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void e6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048681, this) == null) || this.a == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.a.getCurrentFocus() == null) {
            return;
        }
        ri.x(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public void e7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048682, this, z3) == null) {
            this.n2 = Boolean.valueOf(z3);
        }
    }

    public boolean f5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if ((this.y0.S1() != null && (this.y0.S1().i0() || ThreadCardUtils.isSelf(this.y0.S1().O()))) || this.Y0 == null || this.y0.S1() == null || this.y0.S1().d() == null) {
                return true;
            }
            return this.Y0.checkPrivacyBeforeInvokeEditor(this.y0.S1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void f6() {
        ux7 ux7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048684, this) == null) || (ux7Var = this.G0) == null) {
            return;
        }
        ux7Var.q1();
        e6();
    }

    public void f7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z3) == null) {
            this.t0 = z3;
        }
    }

    @Override // com.baidu.tieba.a18
    public void finish() {
        ux7 ux7Var;
        CardHListViewData q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            ux7 ux7Var2 = this.G0;
            if (ux7Var2 != null) {
                ux7Var2.m0();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.S1() != null && !this.y0.S1().i0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.y0.S1().O().getId();
                if (this.y0.isShareThread() && this.y0.S1().O().originalThreadData != null) {
                    historyMessage.threadName = this.y0.S1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.y0.S1().O().getTitle();
                }
                if (this.y0.isShareThread() && !u0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.y0.S1().l().getName();
                }
                ArrayList<PostData> F = this.y0.S1().F();
                ux7 ux7Var3 = this.G0;
                int H0 = ux7Var3 != null ? ux7Var3.H0() : 0;
                if (F != null && H0 >= 0 && H0 < F.size()) {
                    historyMessage.postID = F.get(H0).K();
                }
                historyMessage.isHostOnly = this.y0.v1();
                historyMessage.isSquence = this.y0.k2();
                historyMessage.isShareThread = this.y0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            q45 q45Var = this.V0;
            if (q45Var != null) {
                q45Var.I();
            }
            if (this.j && S5() != null) {
                S5().r0();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && (pbModel2.x1() || this.y0.A1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.y0.m2());
                if (this.H0) {
                    if (this.J0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.y0.G1());
                    }
                    if (this.I0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.y0.C1());
                    }
                }
                if (this.y0.S1() != null && System.currentTimeMillis() - this.p >= 40000 && (q3 = this.y0.S1().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.s1);
                }
                this.a.setResult(-1, intent);
            }
            if (J7()) {
                if (this.y0 != null && (ux7Var = this.G0) != null && ux7Var.R0() != null) {
                    mt7 S1 = this.y0.S1();
                    if (S1 != null) {
                        if (S1.V() != null) {
                            S1.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!S1.p0() && !this.I && S1.h == null) {
                            jx7.b().n(this.y0.T1(), this.G0.R0().onSaveInstanceState(), this.y0.k2(), this.y0.v1(), this.G0.Z0() != null && this.G0.Z0().getVisibility() == 0);
                            if (this.r1 >= 0 || this.y0.o2() != null) {
                                jx7.b().q(this.y0.o2());
                                jx7.b().r(this.y0.p2());
                                jx7.b().o(this.y0.L1());
                            }
                        }
                    }
                } else {
                    jx7.b().m();
                }
                I7();
            }
        }
    }

    @Override // com.baidu.tieba.qi5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048687, this, context, str) == null) {
        }
    }

    public boolean g5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048688, this, i4)) == null) {
            if (this.Y0 == null || this.y0.S1() == null || ThreadCardUtils.isSelf(this.y0.S1().O()) || this.y0.S1().d() == null) {
                return true;
            }
            return this.Y0.checkPrivacyBeforeSend(this.y0.S1().d().replyPrivateFlag, i4);
        }
        return invokeI.booleanValue;
    }

    public final void g6(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048689, this, i4, i5) == null) {
            nf5.b(new j(this, i5), new l(this, i5, i4));
        }
    }

    public void g7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048690, this, z3) == null) {
            this.N = z3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h5(AgreeData agreeData) {
        v95 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048692, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.f0 == null) {
            this.f0 = new pu4();
        }
        if (this.j0 == null) {
            zk8 zk8Var = new zk8();
            this.j0 = zk8Var;
            zk8Var.a = getUniqueId();
        }
        no4 no4Var = new no4();
        no4Var.b = 5;
        no4Var.h = 8;
        no4Var.g = 2;
        if (K() != null) {
            no4Var.f = K().R1();
        }
        no4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                no4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.f0.c(agreeData, i4, getUniqueId(), false);
                this.f0.d(agreeData, this.j0);
                pbModel = this.y0;
                if (pbModel != null || pbModel.S1() == null) {
                }
                this.f0.b(P(), no4Var, agreeData, this.y0.S1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            no4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            no4Var.i = 1;
        }
        i4 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.f0.c(agreeData, i4, getUniqueId(), false);
        this.f0.d(agreeData, this.j0);
        pbModel = this.y0;
        if (pbModel != null) {
        }
    }

    public final void h6(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i4) == null) {
            nf5.b(new h(this), new i(this, i4));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i4 == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i4 == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void h7(s45 s45Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048694, this, s45Var) == null) || s45Var == null || (pbModel = this.y0) == null) {
            return;
        }
        s45Var.p(pbModel.r1());
        if (this.y0.S1() != null && this.y0.S1().l() != null) {
            s45Var.o(this.y0.S1().l());
        }
        s45Var.q("pb");
        s45Var.r(this.y0);
    }

    public final void i5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            if (this.y0.x1() || this.y0.A1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.y0.m2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.y0.m2()));
            if (J7()) {
                this.a.finish();
            }
        }
    }

    public final void i6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, bundle) == null) {
            cm4 c4 = cm4.c(this.a);
            this.A0 = c4;
            if (c4 != null) {
                c4.j(this.t2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.B0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.v2);
            this.C0 = new tz4(getPageContext());
            T5();
            this.S1.setUniqueId(getUniqueId());
            this.S1.registerListener();
        }
    }

    public final void i7(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048697, this, i4) == null) || (pbModel = this.y0) == null) {
            return;
        }
        int b22 = pbModel.b2();
        if (i4 == 5) {
            this.y0.B3(2);
        } else if (i4 == 6) {
            this.y0.B3(3);
        } else if (i4 != 7) {
            this.y0.B3(1);
        } else {
            this.y0.B3(4);
        }
        int b23 = this.y0.b2();
        if (b22 == 4 || b23 == 4) {
            K6();
        }
    }

    public final boolean j5(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        boolean z5;
        List<ds4> c4;
        ds4 ds4Var;
        ds4 ds4Var2;
        ds4 ds4Var3;
        ds4 ds4Var4;
        ds4 ds4Var5;
        ds4 ds4Var6;
        an anVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048698, this, view2)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                ux7 ux7Var = this.G0;
                if (ux7Var != null) {
                    if (ux7Var.J1()) {
                        return true;
                    }
                    this.G0.x0();
                }
                try {
                    sparseArray = (SparseArray) view2.getTag();
                } catch (ClassCastException e4) {
                    e4.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (p6(view2)) {
                        if (view2 instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view2;
                            this.m1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.n1 = url;
                            if (this.m1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f092025) != null && (view2.getTag(R.id.obfuscated_res_0x7f092025) instanceof TbRichTextImageInfo)) {
                                this.o1 = (TbRichTextImageInfo) view2.getTag(R.id.obfuscated_res_0x7f092025);
                            } else {
                                this.o1 = null;
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f092026) != null && (view2.getTag(R.id.obfuscated_res_0x7f092026) instanceof TbRichTextImageInfo)) {
                                this.p1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092026);
                            } else {
                                this.p1 = null;
                            }
                        } else if (view2 instanceof GifView) {
                            GifView gifView = (GifView) view2;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.m1 = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                                this.n1 = gifView.getBdImage().q();
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f092026) != null && (view2.getTag(R.id.obfuscated_res_0x7f092026) instanceof TbRichTextImageInfo)) {
                                this.p1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092026);
                            } else {
                                this.p1 = null;
                            }
                        } else if (view2 instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.m1 = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                    this.n1 = tbMemeImageView.getBdImage().q();
                                }
                                if (view2.getTag(R.id.obfuscated_res_0x7f092026) != null && (view2.getTag(R.id.obfuscated_res_0x7f092026) instanceof TbRichTextImageInfo)) {
                                    this.p1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092026);
                                } else {
                                    this.p1 = null;
                                }
                            }
                        }
                        if (view2.getParent() instanceof TbRichTextView) {
                            try {
                                sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                            } catch (ClassCastException e5) {
                                e5.printStackTrace();
                            }
                        } else if (view2.getParent().getParent() instanceof TbRichTextView) {
                            try {
                                sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent().getParent()).getTag();
                            } catch (ClassCastException e6) {
                                e6.printStackTrace();
                            }
                        } else {
                            this.G0.W3(this.G2, this.m1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fea);
                this.E2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.B() == 1 && p6(view2)) {
                    this.G0.W3(this.G2, this.m1.t());
                    return true;
                }
                cm4 cm4Var = this.A0;
                if (cm4Var == null) {
                    return true;
                }
                boolean z6 = cm4Var.e() && this.E2.K() != null && this.E2.K().equals(this.y0.N1());
                boolean z7 = K().S1() != null && K().S1().i0();
                boolean z8 = K().S1() != null && K().S1().m0();
                boolean z9 = K().S1() != null && K().S1().l0();
                if (this.E2.B() == 1) {
                    if (!z7) {
                        this.G0.X3(this.F2, z6, false, z8, z9);
                    }
                    return true;
                }
                if (this.M0 == null) {
                    hs4 hs4Var = new hs4(getContext());
                    this.M0 = hs4Var;
                    hs4Var.n(this.i2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 == null || sparseArray == null) {
                    return true;
                }
                boolean z10 = p6(view2) && !z7;
                boolean z11 = (!p6(view2) || (anVar = this.m1) == null || anVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092003) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092003)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091fed) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091fed)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092032) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092032)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
                String str = sparseArray.get(R.id.obfuscated_res_0x7f091ffa) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ffa) : null;
                boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092002) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092002)).booleanValue() : false;
                boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f09200b) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09200b)).booleanValue() : false;
                if (z10) {
                    z3 = booleanValue8;
                    z5 = booleanValue6;
                    z4 = booleanValue5;
                    arrayList.add(new ds4(1, getString(R.string.obfuscated_res_0x7f0f1091), this.M0));
                } else {
                    z3 = booleanValue8;
                    z4 = booleanValue5;
                    z5 = booleanValue6;
                }
                if (z11) {
                    arrayList.add(new ds4(2, getString(R.string.obfuscated_res_0x7f0f1092), this.M0));
                }
                if (!z10 && !z11) {
                    ds4 ds4Var7 = new ds4(3, getString(R.string.obfuscated_res_0x7f0f044e), this.M0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fea, this.E2);
                    ds4Var7.d.setTag(sparseArray3);
                    arrayList.add(ds4Var7);
                }
                if (!booleanValue && !z7) {
                    if (z6) {
                        ds4Var6 = new ds4(4, getString(R.string.obfuscated_res_0x7f0f0fd5), this.M0);
                    } else {
                        ds4Var6 = new ds4(4, getString(R.string.obfuscated_res_0x7f0f0a94), this.M0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091fea, this.E2);
                    sparseArray4.put(R.id.obfuscated_res_0x7f092003, Boolean.FALSE);
                    ds4Var6.d.setTag(sparseArray4);
                    arrayList.add(ds4Var6);
                }
                if (this.mIsLogin && !this.q0) {
                    if (!mz7.i(this.y0) && !booleanValue4 && booleanValue3) {
                        ds4 ds4Var8 = new ds4(5, getString(R.string.obfuscated_res_0x7f0f0b37), this.M0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f092001, sparseArray.get(R.id.obfuscated_res_0x7f092001));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092044, sparseArray.get(R.id.obfuscated_res_0x7f092044));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092045, sparseArray.get(R.id.obfuscated_res_0x7f092045));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091fed, sparseArray.get(R.id.obfuscated_res_0x7f091fed));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                        ds4Var8.d.setTag(sparseArray5);
                        arrayList.add(ds4Var8);
                    } else {
                        if ((t6(booleanValue2) && TbadkCoreApplication.isLogin()) && !z7) {
                            ds4 ds4Var9 = new ds4(5, getString(R.string.obfuscated_res_0x7f0f0ffa), this.M0);
                            ds4Var9.d.setTag(str);
                            arrayList.add(ds4Var9);
                        }
                    }
                    if (booleanValue4) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.obfuscated_res_0x7f092032, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ff8, sparseArray.get(R.id.obfuscated_res_0x7f091ff8));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ff9, sparseArray.get(R.id.obfuscated_res_0x7f091ff9));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ffa, str);
                        sparseArray6.put(R.id.obfuscated_res_0x7f09200b, sparseArray.get(R.id.obfuscated_res_0x7f09200b));
                        if (!mz7.i(this.y0) && z4) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f092001, sparseArray.get(R.id.obfuscated_res_0x7f092001));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092044, sparseArray.get(R.id.obfuscated_res_0x7f092044));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092045, sparseArray.get(R.id.obfuscated_res_0x7f092045));
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                        }
                        if (z5) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(booleanValue2));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ffe, sparseArray.get(R.id.obfuscated_res_0x7f091ffe));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092002, Boolean.valueOf(booleanValue7));
                            if (booleanValue7) {
                                ds4Var5 = new ds4(6, getString(R.string.obfuscated_res_0x7f0f04ac), this.M0);
                                ds4Var5.d.setTag(sparseArray6);
                                ds4Var2 = new ds4(7, getString(R.string.obfuscated_res_0x7f0f02e4), this.M0);
                                ds4Var2.d.setTag(sparseArray6);
                                ds4Var3 = ds4Var5;
                                ds4Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                        }
                        ds4Var5 = null;
                        ds4Var2 = new ds4(7, getString(R.string.obfuscated_res_0x7f0f02e4), this.M0);
                        ds4Var2.d.setTag(sparseArray6);
                        ds4Var3 = ds4Var5;
                        ds4Var = null;
                    } else if (z5) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.obfuscated_res_0x7f092032, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(booleanValue2));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091ffe, sparseArray.get(R.id.obfuscated_res_0x7f091ffe));
                        if (this.y0.S1().W() == 1002 && !booleanValue2) {
                            ds4Var4 = new ds4(6, getString(R.string.obfuscated_res_0x7f0f0ffa), this.M0);
                        } else {
                            ds4Var4 = new ds4(6, getString(R.string.obfuscated_res_0x7f0f04ac), this.M0);
                        }
                        ds4Var4.d.setTag(sparseArray7);
                        if (z3) {
                            ds4Var = new ds4(13, getString(R.string.obfuscated_res_0x7f0f0b27), this.M0);
                            ds4Var3 = ds4Var4;
                        } else {
                            ds4Var3 = ds4Var4;
                            ds4Var = null;
                        }
                        ds4Var2 = null;
                    } else {
                        ds4Var = null;
                        ds4Var2 = null;
                        ds4Var3 = null;
                    }
                    if (ds4Var3 != null) {
                        arrayList.add(ds4Var3);
                    }
                    if (ds4Var != null) {
                        arrayList.add(ds4Var);
                    }
                    if (ds4Var2 != null) {
                        arrayList.add(ds4Var2);
                    }
                    mz7.b(arrayList, this.M0, this.E2, this.y0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = mz7.d(arrayList, this.E2.q(), sparseArray, this.M0);
                } else {
                    c4 = mz7.c(arrayList, this.E2.q(), sparseArray, this.M0);
                }
                mz7.l(c4, this.b);
                mz7.f(c4);
                this.M0.o(mz7.g(this.E2));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.M0.k(c4, false);
                } else {
                    this.M0.k(c4, true);
                }
                fs4 fs4Var = new fs4(getPageContext(), this.M0);
                this.L0 = fs4Var;
                fs4Var.k();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.y0.b).param("fid", this.y0.getForumId()).param("uid", this.y0.S1().O().getAuthor().getUserId()).param("post_id", this.y0.B()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.R = likeModel;
            likeModel.setLoadDataCallBack(new n0(this));
        }
    }

    public void j7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z3) == null) {
            this.K = z3;
        }
    }

    public void k5(ForumManageModel.b bVar, ux7 ux7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048701, this, bVar, ux7Var) == null) {
            List<PostData> list = this.y0.S1().T().a;
            int size = list.size();
            boolean z3 = false;
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= list.get(i4).Y().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i4).Y().get(i5).K())) {
                        list.get(i4).Y().remove(i5);
                        list.get(i4).k();
                        z3 = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                list.get(i4).l(bVar.g);
            }
            if (z3) {
                ux7Var.F1(this.y0.S1());
            }
        }
    }

    public final void k6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048702, this) == null) && this.m == null) {
            this.m = new yr4(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f0366), getPageContext().getString(R.string.obfuscated_res_0x7f0f11ae), getPageContext().getString(R.string.obfuscated_res_0x7f0f10c3)};
            yr4 yr4Var = this.m;
            yr4Var.j(strArr, new s0(this));
            yr4Var.g(yr4.b.obfuscated_res_0x7f1003ac);
            yr4Var.h(17);
            yr4Var.c(getPageContext());
        }
    }

    public final void k7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z3) == null) {
            this.V0.g0(z3);
            this.V0.k0(z3);
            this.V0.s0(z3);
        }
    }

    @Override // com.baidu.tieba.a18
    public PbFragment l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    public final void l5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048705, this, str) == null) || TextUtils.isEmpty(str) || (pbModel = this.y0) == null || pbModel.S1() == null) {
            return;
        }
        il8 z3 = this.y0.S1().z();
        if (z3 != null && str.equals(z3.j1())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().h = null;
            }
            this.y0.S1().b();
        }
        il8 l12 = this.y0.l1();
        if (l12 == null || !str.equals(l12.j1())) {
            return;
        }
        this.y0.X0();
    }

    public boolean l6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.x1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l7() {
        PbModel pbModel;
        ImMessageCenterPojo i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048707, this) == null) || (pbModel = this.y0) == null || pbModel.G == null) {
            return;
        }
        long c4 = j05.c();
        if (c4 <= 0 || (i4 = t87.o().i(String.valueOf(c4), 2)) == null || q87.a(getContext())) {
            return;
        }
        MetaData metaData = new MetaData();
        metaData.setUserIdLong(c4);
        metaData.setUserName(i4.getGroup_name());
        metaData.setName_show(i4.getNameShow());
        metaData.setPortrait(i4.getGroup_head());
        metaData.setIsMyFriend(i4.getIsFriend() != 1 ? 0 : 1);
        ba7 ba7Var = new ba7(getContext());
        ba7Var.o(this.y0.G.O(), metaData);
        ba7Var.p();
    }

    public void m5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048708, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(ux7.k2)).intValue();
            if (intValue == ux7.l2) {
                if (this.B0.S()) {
                    return;
                }
                this.G0.k4();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091fec);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09200a)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091fed)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fee)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092000) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092000)).booleanValue() : false;
                if (jSONArray != null) {
                    this.B0.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.B0.V(this.y0.S1().l().getId(), this.y0.S1().l().getName(), this.y0.S1().O().getId(), str, intValue3, intValue2, booleanValue, this.y0.S1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == ux7.m2 || intValue == ux7.o2) {
                PbModel pbModel = this.y0;
                if (pbModel != null && pbModel.n1() != null) {
                    this.y0.n1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ux7.m2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final boolean m6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return (absPbActivity == null || absPbActivity.b1() == null || this.a.b1().R1() != 17) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void m7(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048710, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new a2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                C7(str);
            } else {
                this.G0.j4(str);
            }
        }
    }

    public void n5(wr4 wr4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048711, this, wr4Var, jSONArray) == null) {
            wr4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (wr4Var.getYesButtonTag() instanceof SparseArray) {
                    m5((SparseArray) wr4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final boolean n6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            PostData c4 = nt7.c(this.y0.S1(), this.y0.k2(), this.y0.c2());
            return (c4 == null || c4.s() == null || c4.s().getGodUserData() == null || c4.s().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void n7(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048713, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (S5() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                String questionMsg = postWriteCallBackData.getQuestionMsg();
                String questionExp = postWriteCallBackData.getQuestionExp();
                if (postWriteCallBackData.getIconStampData() != null) {
                    r05.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                PbModel pbModel = this.y0;
                if (pbModel == null || pbModel.S1() == null || this.y0.S1().O() == null || this.y0.S1().O().getThreadType() == 71) {
                    if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                        rs7.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                        return;
                    } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                        rs7.f(errorString + " " + preMsg, colorMsg);
                        return;
                    } else if (StringUtils.isNull(errorString)) {
                        rs7.e(getResources().getString(R.string.obfuscated_res_0x7f0f120d));
                        return;
                    } else {
                        rs7.e(errorString);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (!this.y0.F1()) {
            antiData.setBlock_forum_name(this.y0.S1().l().getName());
            antiData.setBlock_forum_id(this.y0.S1().l().getId());
            antiData.setUser_name(this.y0.S1().V().getUserName());
            antiData.setUser_id(this.y0.S1().V().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void o5(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048714, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fee, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(i5));
            sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z3));
            sparseArray.put(ux7.k2, Integer.valueOf(ux7.l2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                m5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public boolean o6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o7(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048716, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            oz7.l(this, j3, str, j4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906bd));
            this.q2.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d(), "", 1);
            this.a.d1().k(this.u0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048718, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            this.V0.H(i4, i5, intent);
            uy7 uy7Var = this.Q;
            if (uy7Var != null) {
                uy7Var.i(i4, i5, intent);
            }
            if (S5().b1() != null) {
                S5().b1().g(i4, i5, intent);
            }
            if (i4 == 25035) {
                a6(i5, intent);
            }
            if (i5 == -1) {
                if (i4 == 11009) {
                    D6();
                } else if (i4 == 13008) {
                    jx7.b().m();
                    this.x0.postDelayed(new h2(this), 1000L);
                } else if (i4 == 13011) {
                    jb8.g().m(getPageContext());
                } else if (i4 == 23003) {
                    if (intent == null || this.y0 == null) {
                        return;
                    }
                    o7(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i4 == 23007) {
                    d6(intent);
                } else if (i4 == 25012) {
                    intent.getLongExtra("KEY_FORUM_ID", 0L);
                    intent.getStringExtra(ForumUserLiveActiivtyConfig.KEY_FORUM_NAME);
                } else if (i4 == 25033) {
                    View view2 = this.S;
                    if (view2 != null) {
                        this.G0.O3(view2);
                    }
                } else if (i4 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        jb8.g().m(getPageContext());
                        N7();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.F0;
                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.w) != null) {
                            shareSuccessReplyToServerModel.z(str, intExtra, new i2(this));
                        }
                        if (m6()) {
                            L7(true);
                        }
                    }
                } else if (i4 != 24008) {
                    switch (i4) {
                        case 25055:
                            View view3 = this.T;
                            if (view3 != null) {
                                view3.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view4 = this.U;
                            if (view4 != null) {
                                view4.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            ux7 ux7Var = this.G0;
                            if (ux7Var == null || ux7Var.B0() == null) {
                                return;
                            }
                            this.G0.B0().performClick();
                            return;
                        case 25058:
                            View view5 = this.V;
                            if (view5 != null) {
                                view5.performClick();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    this.G0.y3(false);
                    if (this.y0.S1() == null || this.y0.S1().O() == null || this.y0.S1().O().getPushStatusData() == null) {
                        return;
                    }
                    this.y0.S1().O().getPushStatusData().setStatus(2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048720, this, i4) == null) || this.X == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.G0.g2(i4);
        q45 q45Var = this.V0;
        if (q45Var != null && q45Var.a() != null) {
            this.V0.a().w(i4);
        }
        if (this.G0.a() != null) {
            this.G0.a().d(getPageContext(), i4);
        }
        this.K0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201));
        this.X = i4;
        H7();
        o05 o05Var = this.r0;
        if (o05Var != null) {
            o05Var.w();
        }
    }

    @Override // com.baidu.tieba.wr4.e
    public void onClick(wr4 wr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, wr4Var) == null) {
            n5(wr4Var, null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int i4 = configuration.orientation;
            if (i4 == this.y) {
                return;
            }
            this.y = i4;
            if (i4 == 2) {
                this.J = true;
            } else {
                this.J = false;
            }
            ux7 ux7Var = this.G0;
            if (ux7Var != null) {
                ux7Var.h2(configuration);
            }
            fs4 fs4Var = this.L0;
            if (fs4Var != null) {
                fs4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        ux7 ux7Var;
        ux7 ux7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, bundle) == null) {
            this.p = System.currentTimeMillis();
            this.h1 = getPageContext();
            Intent intent = this.a.getIntent();
            if (intent != null) {
                this.n = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.M = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.M)) {
                        this.M = data.getQueryParameter("from");
                    }
                }
                this.W = intent.getStringExtra("st_type");
                "from_interview_live".equals(this.M);
                this.P2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.Q2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.R2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.Q0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.R0 = intent.getStringExtra("high_light_post_id");
                this.S0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (F5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                this.P = qi.isEmpty(stringExtra) ? "" : this.P;
                this.s1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                tq4 tq4Var = new tq4();
                this.d0 = tq4Var;
                tq4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.u1 = intExtra;
                if (intExtra == 0) {
                    this.u1 = intent.getIntExtra("key_start_from", 0);
                }
                this.v1 = intent.getStringExtra("last_tid");
            } else {
                this.n = System.currentTimeMillis();
            }
            this.r = this.p - this.n;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.l = 0;
            x6(bundle);
            if (this.y0.S1() != null) {
                this.y0.S1().Q0(this.P);
            }
            j6();
            if (intent != null && (ux7Var2 = this.G0) != null) {
                ux7Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.k1 == null) {
                        this.k1 = new k0(this, intent);
                    }
                    sg.a().postDelayed(this.k1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.y0.S1() != null) {
                    this.y0.z3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.k = voiceManager;
            voiceManager.onCreate(getPageContext());
            i6(bundle);
            s45 s45Var = new s45();
            this.U0 = s45Var;
            h7(s45Var);
            q45 q45Var = (q45) this.U0.a(getActivity());
            this.V0 = q45Var;
            q45Var.f0(this.a.getPageContext());
            this.V0.p0(this.m2);
            this.V0.q0(this.c1);
            this.V0.i0(1);
            this.V0.F(this.a.getPageContext(), bundle);
            this.V0.a().b(new x25(getActivity()));
            this.V0.a().C(true);
            k7(true);
            this.V0.P(this.y0.u1(), this.y0.m2(), this.y0.q1());
            registerListener(this.C1);
            if (!this.y0.F1()) {
                this.V0.s(this.y0.m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.V0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.y0.A2()) {
                this.V0.m0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0df0));
            } else {
                ux7 ux7Var3 = this.G0;
                if (ux7Var3 != null) {
                    this.V0.m0(ux7Var3.e1());
                }
            }
            registerListener(this.B1);
            registerListener(this.D1);
            registerListener(this.E1);
            registerListener(this.A1);
            registerListener(this.d2);
            registerListener(this.e2);
            registerListener(this.s2);
            registerListener(this.z1);
            al8 al8Var = new al8("pb", al8.d);
            this.T0 = al8Var;
            al8Var.d();
            registerListener(this.K1);
            registerListener(this.U1);
            this.y0.W2();
            registerListener(this.r2);
            registerListener(this.g2);
            registerListener(this.l2);
            registerListener(this.O1);
            registerListener(this.P1);
            registerListener(this.f2);
            ux7 ux7Var4 = this.G0;
            if (ux7Var4 != null && ux7Var4.l1() != null && this.G0.j1() != null) {
                zy7 zy7Var = new zy7(getActivity(), this.G0.l1(), this.G0.j1(), this.G0.Z0());
                this.e = zy7Var;
                zy7Var.t(this.T1);
            }
            if (this.c && (ux7Var = this.G0) != null && ux7Var.j1() != null) {
                this.G0.j1().setVisibility(8);
            }
            zu4 zu4Var = new zu4();
            this.i1 = zu4Var;
            zu4Var.a = 1000L;
            registerListener(this.c2);
            registerListener(this.b2);
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.M1);
            registerListener(this.G1);
            registerListener(this.H1);
            registerListener(this.I1);
            this.L1.setSelfListener(true);
            this.L1.setTag(this.a.getUniqueId());
            this.L1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.L1);
            registerResponsedEventListener(TipEvent.class, this.V1);
            this.j1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.j1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.j1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.y0.m1().D(this.W1);
            this.K0 = new xx7();
            if (this.V0.v() != null) {
                this.K0.m(this.V0.v().i());
            }
            this.V0.e0(this.d1);
            this.F0 = new ShareSuccessReplyToServerModel();
            V4(this.x1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.Y0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new l0(this));
            vz7 vz7Var = new vz7(getContext());
            this.z0 = vz7Var;
            vz7Var.b(getUniqueId());
            kj8.g().i(getUniqueId());
            eo4.b().l("3", "");
            this.w1 = new hz5(getPageContext());
            this.v0 = new kz7(this, getUniqueId(), this.G0, this.y0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && pi.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.q = System.currentTimeMillis() - this.p;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048724, this, layoutInflater, viewGroup, bundle)) == null) {
            this.G0 = new ux7(this, this.k2, this.X1);
            w56 w56Var = new w56(getActivity());
            this.d = w56Var;
            w56Var.i(U2);
            this.d.d(this.N2);
            this.G0.p3(this.u2);
            this.G0.o3(this.A2);
            this.G0.h3(this.x2);
            this.G0.i3(this.y2);
            this.G0.f3(tn4.c().g());
            this.G0.m3(this.C2);
            this.G0.s3(this.I2);
            this.G0.q3(this.J2);
            this.G0.n3(this.L2);
            this.G0.l3(this.w2);
            this.G0.o4(this.mIsLogin);
            if (this.a.getIntent() != null) {
                this.G0.d3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.G0.a1().setFromForumId(this.y0.getFromForumId());
            this.G0.V2(this.V0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.V0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.V0.m0(this.G0.e1());
            }
            this.G0.Z2(new o0(this));
            this.G0.c3(this.y0.A1());
            this.G0.r3(this.y0.R1());
            this.v0.f(this.G0, this.y0);
            if ("1".equals(K().showReplyPanel)) {
                this.G0.p2();
            }
            return this.G0.m1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        uz7 uz7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            kj8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!qi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.y0.S1().m());
                statisticItem.param("tid", this.y0.m2());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.t && this.G0 != null) {
                this.t = true;
                b7(false, null);
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.y0.destory();
                if (this.y0.O1() != null) {
                    this.y0.O1().d();
                }
            }
            q45 q45Var = this.V0;
            if (q45Var != null) {
                q45Var.I();
            }
            ForumManageModel forumManageModel = this.B0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.R;
            if (likeModel != null) {
                likeModel.M();
            }
            ux7 ux7Var = this.G0;
            if (ux7Var != null) {
                ux7Var.i2();
                uz7 uz7Var2 = this.G0.h;
                if (uz7Var2 != null) {
                    uz7Var2.y();
                }
            }
            pa5 pa5Var = this.u;
            if (pa5Var != null) {
                pa5Var.c();
            }
            zy7 zy7Var = this.e;
            if (zy7Var != null) {
                zy7Var.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            ux7 ux7Var2 = this.G0;
            if (ux7Var2 != null) {
                ux7Var2.m0();
            }
            if (this.Y1 != null) {
                sg.a().removeCallbacks(this.Y1);
            }
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.j1);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().unRegisterListener(this.e2);
            MessageManager.getInstance().unRegisterListener(this.g2);
            MessageManager.getInstance().unRegisterListener(this.M1);
            MessageManager.getInstance().unRegisterListener(this.p2);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.H1);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.f2);
            this.h1 = null;
            this.i1 = null;
            pd8.e().g();
            if (this.k1 != null) {
                sg.a().removeCallbacks(this.k1);
            }
            uy7 uy7Var = this.Q;
            if (uy7Var != null) {
                uy7Var.f();
            }
            ux7 ux7Var3 = this.G0;
            if (ux7Var3 != null && (uz7Var = ux7Var3.h) != null) {
                uz7Var.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.F0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            xx7 xx7Var = this.K0;
            if (xx7Var != null) {
                xx7Var.j();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && pbModel2.f1() != null) {
                this.y0.f1().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.Y0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ux7 ux7Var4 = this.G0;
            if (ux7Var4 != null) {
                ux7Var4.l4();
            }
            kz7 kz7Var = this.v0;
            if (kz7Var != null) {
                kz7Var.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.e0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public tn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (tn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            V6();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
                this.g = false;
            } else {
                this.g = true;
            }
            super.onPause();
            nz7.a();
            BdTypeListView listView = getListView();
            int viewLayer = CompatibleUtile.getInstance().getViewLayer(listView);
            this.l = viewLayer;
            if (viewLayer == 1) {
                CompatibleUtile.getInstance().noneViewGpu(listView);
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            ux7 ux7Var = this.G0;
            if (ux7Var != null) {
                ux7Var.n2();
            }
            if (!this.y0.F1()) {
                this.V0.V(this.y0.m2());
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.V2();
            }
            ej4.w().E();
            MessageManager.getInstance().unRegisterListener(this.F1);
            a7();
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.v(null);
            o05 o05Var = this.r0;
            if (o05Var != null) {
                o05Var.q();
                this.r0.p();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.h9
    public void onPreLoad(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, tnVar) == null) {
            PreLoadImageHelper.load(tnVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(tnVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            this.g = false;
            super.onResume();
            if (this.O) {
                this.O = false;
                Z5();
            }
            if (n6()) {
                this.v = System.currentTimeMillis();
            } else {
                this.v = -1L;
            }
            ux7 ux7Var = this.G0;
            if (ux7Var != null && ux7Var.m1() != null) {
                if (!this.h) {
                    x7();
                } else {
                    hideLoadingView(this.G0.m1());
                }
                this.G0.q2();
            }
            if (this.l == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            ux7 ux7Var2 = this.G0;
            NoNetworkView a4 = ux7Var2 != null ? ux7Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && pi.z()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.F1);
            this.P0 = false;
            c7();
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.c2);
            if (this.q1) {
                V6();
                this.q1 = false;
            }
            E7();
            ItemCardHelper.v(this.K2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                g25.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.y0.n3(bundle);
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.V0.L(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            super.onStop();
            if (this.v > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.v;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.v = 0L;
            }
            if (S5().b1() != null) {
                S5().b1().i();
            }
            uz7 uz7Var = this.G0.h;
            if (uz7Var != null && !uz7Var.u()) {
                this.G0.h.y();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.S1() != null && this.y0.S1().l() != null && this.y0.S1().O() != null) {
                d25.j().x(getPageContext().getPageActivity(), "pb", this.y0.S1().l().getId(), pg.g(this.y0.S1().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            kj8.g().h(getUniqueId(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048735, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z3) == null) {
            super.onUserChanged(z3);
            this.G0.o4(z3);
            fs4 fs4Var = this.L0;
            if (fs4Var != null) {
                fs4Var.dismiss();
            }
            if (z3 && this.P0) {
                this.G0.x3();
                this.y0.N2(true);
            }
            if (this.G0.A0() != null) {
                this.G0.A0().e0(z3);
            }
        }
    }

    public void p5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048737, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            ux7 ux7Var = this.G0;
            if (ux7Var == null || this.y0 == null) {
                return;
            }
            if ((ux7Var != null && !ux7Var.H1()) || this.y0.S1() == null || this.y0.S1().S() == null) {
                return;
            }
            ux7 ux7Var2 = this.G0;
            if (ux7Var2 == null || ux7Var2.G0() == null || !this.G0.G0().r()) {
                au7 S = this.y0.S1().S();
                if (checkUpIsLogin()) {
                    if ((!S.f() || S.a() != 2) && this.G0.A0() != null && this.G0.A0().z() != null) {
                        this.G0.A0().z().v(this.y0.m2(), this.y0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        ps7 ps7Var = new ps7(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.y0;
                        ps7Var.m(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        ps7Var.l(new p0(this));
                    } else if (System.currentTimeMillis() - this.x > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.x = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public boolean p6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048738, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public final void p7(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048739, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            mz7.e(getActivity(), getPageContext(), new f1(this, sparseArray, i4, z3), new g1(this));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void q0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048740, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (ni5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ni5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (ay7.c(objArr[i4].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new fg5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i4], spannableStringBuilder.getSpanStart(objArr[i4]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void q5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || this.G0 == null || (pbModel = this.y0) == null) {
            return;
        }
        if ((pbModel.S1() == null && this.y0.S1().S() == null) || !checkUpIsLogin() || this.G0.A0() == null || this.G0.A0().z() == null) {
            return;
        }
        this.G0.A0().z().v(this.y0.m2(), this.y0.getFromForumId());
    }

    public boolean q6(int i4) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048742, this, i4)) == null) {
            if (i4 == 1) {
                return true;
            }
            if (this.y0.S1().V() != null && (forumToolAuth = this.y0.S1().V().getForumToolAuth()) != null) {
                for (int i5 = 0; i5 < forumToolAuth.size(); i5++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i5);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final boolean q7(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        mp4 mp4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048743, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.S1() == null) {
                return false;
            }
            mt7 S1 = this.y0.S1();
            ThreadData O = S1.O();
            if (O != null) {
                if (O.isBJHArticleThreadType() || O.isBJHVideoThreadType()) {
                    return false;
                }
                if (O.isBJHNormalThreadType() || O.isBJHVideoDynamicThreadType()) {
                    return z3;
                }
            }
            if (z3) {
                return true;
            }
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !og6.isOn()) || this.y0.H() || O.isWorksInfo() || O.isScoreThread() || z4) {
                return false;
            }
            if (S1.l() == null || !S1.l().isBlockBawuDelete) {
                if (S1.O() == null || !S1.O().isBlocked()) {
                    if (S1.W() != 0) {
                        return S1.W() != 3;
                    }
                    List<gr4> p3 = S1.p();
                    if (ListUtils.getCount(p3) > 0) {
                        for (gr4 gr4Var : p3) {
                            if (gr4Var != null && (mp4Var = gr4Var.g) != null && mp4Var.a && !mp4Var.c && ((i4 = mp4Var.b) == 1 || i4 == 2)) {
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
        return invokeCommon.booleanValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) ? this.t0 : invokeV.booleanValue;
    }

    public final void r5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048745, this, str) == null) || (pbModel = this.y0) == null || pbModel.S1() == null || this.y0.S1().O() == null || !this.y0.S1().O().isUgcThreadType()) {
            return;
        }
        ThreadData O = this.y0.S1().O();
        int i4 = 0;
        if (O.isBJHArticleThreadType()) {
            i4 = 1;
        } else if (O.isBJHVideoThreadType()) {
            i4 = 2;
        } else if (O.isBJHNormalThreadType()) {
            i4 = 3;
        } else if (O.isBJHVideoDynamicThreadType()) {
            i4 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i4);
        TiebaStatic.log(statisticItem);
    }

    public boolean r6(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048746, this, i4)) == null) ? i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 : invokeI.booleanValue;
    }

    public final boolean r7(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048747, this, z3)) == null) {
            if (z3 || (pbModel = this.y0) == null || pbModel.S1() == null || (this.y0.S1().l() != null && this.y0.S1().l().isBlockBawuDelete)) {
                return false;
            }
            mt7 S1 = this.y0.S1();
            if ((S1.O() == null || S1.O().getAuthor() == null || !S1.O().getAuthor().isForumBusinessAccount() || og6.isOn()) && !this.y0.H()) {
                return ((S1.O() != null && S1.O().isBlocked()) || this.y0.S1().W() == 0 || this.y0.S1().W() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void s5(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048748, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04b1);
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                wr4 wr4Var = new wr4(getPageContext().getPageActivity());
                wr4Var.setMessage(string);
                wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04ed, new c2(this));
                wr4Var.setCancelable(true);
                wr4Var.create(getPageContext());
                wr4Var.show();
            } else if (bVar.d != 0) {
                this.G0.w0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<PostData> F = this.y0.S1().F();
                    int size = F.size();
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i4).K())) {
                            F.remove(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.y0.S1().O().setReply_num(this.y0.S1().O().getReply_num() - 1);
                    this.G0.F1(this.y0.S1());
                } else if (i5 == 0) {
                    i5();
                } else if (i5 == 2) {
                    ArrayList<PostData> F2 = this.y0.S1().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i6 = 0; i6 < size2 && !z4; i6++) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= F2.get(i6).Y().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i6).Y().get(i7).K())) {
                                F2.get(i6).Y().remove(i7);
                                F2.get(i6).k();
                                z4 = true;
                                break;
                            } else {
                                i7++;
                            }
                        }
                        F2.get(i6).l(bVar.g);
                    }
                    if (z4) {
                        this.G0.F1(this.y0.S1());
                    }
                    k5(bVar, this.G0);
                }
            }
        }
    }

    public final boolean s6(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048749, this, i4)) == null) ? i4 == 2 || i4 == 1 : invokeI.booleanValue;
    }

    public final boolean s7(boolean z3, boolean z4, boolean z5, int i4, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048750, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i4), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
            if (z3) {
                return false;
            }
            if (z6 || z7) {
                return true;
            }
            return z4 && (z5 || r6(i4));
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) ? this.k : (VoiceManager) invokeV.objValue;
    }

    public final void t5(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048752, this, i4, gVar) == null) || gVar == null) {
            return;
        }
        this.G0.w0(this.B0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.H0 = true;
            if (i4 == 2 || i4 == 3) {
                this.I0 = true;
                this.J0 = false;
            } else if (i4 == 4 || i4 == 5) {
                this.I0 = false;
                this.J0 = true;
            }
            if (i4 == 2) {
                this.y0.S1().O().setIs_good(1);
                this.y0.u3(1);
            } else if (i4 == 3) {
                this.y0.S1().O().setIs_good(0);
                this.y0.u3(0);
            } else if (i4 == 4) {
                this.y0.S1().O().setIs_top(1);
                this.y0.v3(1);
            } else if (i4 == 5) {
                this.y0.S1().O().setIs_top(0);
                this.y0.v3(0);
            }
            this.G0.s4(this.y0.S1(), this.y0.k2());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f0d08);
        }
        ri.N(getPageContext().getPageActivity(), string);
    }

    public final boolean t6(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048753, this, z3)) == null) {
            PbModel pbModel = this.y0;
            return (pbModel == null || pbModel.S1() == null || this.y0.S1().O() == null || this.y0.S1().O().getAuthor() == null || TextUtils.equals(this.y0.S1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean t7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.k2()) {
                return this.y0.Q1() == null || this.y0.Q1().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048756, this) == null) || (pbModel = this.y0) == null || qi.isEmpty(pbModel.m2())) {
            return;
        }
        super.taskStart();
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.J2();
        }
        return invokeV.booleanValue;
    }

    public final void u5(Rect rect) {
        ux7 ux7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048758, this, rect) == null) || rect == null || (ux7Var = this.G0) == null || ux7Var.l1() == null || rect.top > this.G0.l1().getHeight()) {
            return;
        }
        rect.top += this.G0.l1().getHeight() - rect.top;
    }

    public final void u6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void u7(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048760, this, metaData) == null) || metaData == null) {
            return;
        }
        wr4 wr4Var = new wr4(getActivity());
        wr4Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0a96));
        wr4Var.setTitleShowCenter(true);
        wr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0a97));
        wr4Var.setMessageShowCenter(true);
        wr4Var.setCancelable(false);
        wr4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a98), new v1(this, metaData));
        wr4Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a99), new w1(this, metaData));
        wr4Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    @Override // com.baidu.tieba.qi5
    public gg<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            if (this.L == null) {
                this.L = new gg<>(new o2(this), 20, 0);
            }
            return this.L;
        }
        return (gg) invokeV.objValue;
    }

    public AntiData v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.S1() == null) {
                return null;
            }
            return this.y0.S1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void v6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048763, this) == null) || this.S2 == null) {
            return;
        }
        if (this.Q2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0dde);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.Q2, 0)));
            this.a.finish();
        }
    }

    public final void v7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048764, this) == null) {
            wr4 wr4Var = new wr4(getPageContext().getPageActivity());
            wr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b36));
            wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf9, new c(this));
            wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new d(this));
            wr4Var.create(this.h1).show();
        }
    }

    public final int w5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) {
            if (this.y0.S1() == null || this.y0.S1().O() == null) {
                return -1;
            }
            return this.y0.S1().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public void w6(String str) {
        ux7 ux7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048766, this, str) == null) || this.y0 == null || StringUtils.isNull(str) || (ux7Var = this.G0) == null) {
            return;
        }
        ux7Var.e3(true);
        this.y0.P2(str);
        this.I = true;
        this.G0.m0();
        this.G0.o1();
    }

    public final void w7(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048767, this, z3, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f092042) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091fe6) instanceof Integer)) {
            fs4 fs4Var = this.L0;
            if (fs4Var != null && fs4Var.isShowing()) {
                this.L0.dismiss();
                this.L0 = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f092040);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092042);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue()) {
                hs4 hs4Var = new hs4(getContext());
                hs4Var.n(new h0(this, sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091fe6) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fe6)).intValue() : -1) == 1) {
                    arrayList.add(new ds4(0, getResources().getString(R.string.obfuscated_res_0x7f0f04ac), hs4Var));
                }
                if (z3) {
                    arrayList.add(new ds4(1, getResources().getString(R.string.obfuscated_res_0x7f0f149c), hs4Var));
                } else {
                    arrayList.add(new ds4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0b33), hs4Var));
                }
                hs4Var.j(arrayList);
                fs4 fs4Var2 = new fs4(getPageContext(), hs4Var);
                this.L0 = fs4Var2;
                fs4Var2.k();
            }
        }
    }

    public PostData x5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            ux7 ux7Var = this.G0;
            PbModel pbModel = this.y0;
            return ux7Var.I0(pbModel.G, pbModel.k2());
        }
        return (PostData) invokeV.objValue;
    }

    public final void x6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048769, this, bundle) == null) {
            PbModel b12 = this.a.b1();
            this.y0 = b12;
            if (b12 != null) {
                if (b12.n1() != null) {
                    this.y0.n1().c(this.O2);
                }
                if (this.y0.O1() != null) {
                    this.y0.O1().f(this.y1);
                }
                if (StringUtils.isNull(this.y0.m2())) {
                    this.a.finish();
                } else if (!"from_tieba_kuang".equals(this.M) || this.M == null) {
                } else {
                    this.y0.y3(6);
                }
            }
        }
    }

    public final void x7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048770, this) == null) {
            showLoadingView(this.G0.m1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bb));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.G0.l1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.qi5
    public gg<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            if (this.F == null) {
                this.F = new gg<>(new c3(this), 15, 0);
            }
            return this.F;
        }
        return (gg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi5
    public gg<TiebaPlusRecommendCard> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) {
            if (this.E == null) {
                this.E = new gg<>(new p2(this), 5, 0);
            }
            return this.E;
        }
        return (gg) invokeV.objValue;
    }

    public String y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) ? this.M : (String) invokeV.objValue;
    }

    public final void y6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048774, this) == null) || this.S2 == null) {
            return;
        }
        if (this.P2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0ddf);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.P2, 0)));
            this.a.finish();
        }
    }

    public final void y7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048775, this) == null) && UbsABTestHelper.isPushOpenNewStyle() && p05.g(TbadkCoreApplication.getInst(), 0) && !this.G0.C2()) {
            this.r0 = p05.i(getPageContext(), "reply_pb", 0L);
        }
    }

    public yy7 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? this.a.z0() : (yy7) invokeV.objValue;
    }

    public final String z5() {
        InterceptResult invokeV;
        mt7 S1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || (S1 = pbModel.S1()) == null) {
                return null;
            }
            return S1.T().c;
        }
        return (String) invokeV.objValue;
    }

    public final void z6(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048778, this, view2, str, str2, postData) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (c5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!f5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Z);
                        this.a0 = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (S5().b1() != null && postData != null) {
                        S5().b1().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ff0), postData.s().getName_show(), postData.V() != null ? postData.V().toString() : ""));
                    }
                    if (this.y0.S1() != null && this.y0.S1().i0()) {
                        sg.a().postDelayed(new j1(this, str, str2), 0L);
                        return;
                    }
                    if (this.a1 == null) {
                        yo6 yo6Var = new yo6(getPageContext());
                        this.a1 = yo6Var;
                        yo6Var.j(1);
                        this.a1.i(new k1(this, str, str2));
                    }
                    PbModel pbModel = this.y0;
                    if (pbModel == null || pbModel.S1() == null || this.y0.S1().l() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.a1.g(this.y0.S1().l().getId(), pg.g(this.y0.m2(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void z7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048779, this) == null) {
            if (UbsABTestHelper.isPushOpenNewStyle()) {
                if (NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() || !p05.g(TbadkCoreApplication.getInst(), 0) || this.G0.C2()) {
                    return;
                }
                this.r0 = p05.i(getPageContext(), "collect", 0L);
            } else if (l05.g(getContext(), 0)) {
                l05.i(getPageContext(), 6, 2000L);
            }
        }
    }
}
