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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.liveremind.LiveRemindModel;
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
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.model.CheckRealNameModel;
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
import com.repackage.a87;
import com.repackage.ab8;
import com.repackage.bs7;
import com.repackage.c15;
import com.repackage.c9;
import com.repackage.cr4;
import com.repackage.cu4;
import com.repackage.d05;
import com.repackage.d9;
import com.repackage.de5;
import com.repackage.dp8;
import com.repackage.dx7;
import com.repackage.eg;
import com.repackage.ei8;
import com.repackage.er4;
import com.repackage.es6;
import com.repackage.fg;
import com.repackage.fi8;
import com.repackage.fu4;
import com.repackage.fu7;
import com.repackage.fv7;
import com.repackage.fx7;
import com.repackage.fy4;
import com.repackage.fy7;
import com.repackage.gd5;
import com.repackage.gp8;
import com.repackage.gx7;
import com.repackage.he5;
import com.repackage.hx5;
import com.repackage.hx7;
import com.repackage.io4;
import com.repackage.iw7;
import com.repackage.iz4;
import com.repackage.j15;
import com.repackage.j95;
import com.repackage.jd5;
import com.repackage.jl4;
import com.repackage.jr4;
import com.repackage.jr7;
import com.repackage.ju7;
import com.repackage.k35;
import com.repackage.ki4;
import com.repackage.kn4;
import com.repackage.kr7;
import com.repackage.ks7;
import com.repackage.kx7;
import com.repackage.kz4;
import com.repackage.l35;
import com.repackage.l95;
import com.repackage.li4;
import com.repackage.lr4;
import com.repackage.ls7;
import com.repackage.lx7;
import com.repackage.lz4;
import com.repackage.m35;
import com.repackage.m45;
import com.repackage.mq4;
import com.repackage.mw7;
import com.repackage.mz4;
import com.repackage.n35;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.ni8;
import com.repackage.nn;
import com.repackage.nq7;
import com.repackage.nr4;
import com.repackage.nu4;
import com.repackage.nv7;
import com.repackage.nw7;
import com.repackage.nz4;
import com.repackage.oe6;
import com.repackage.oi;
import com.repackage.op4;
import com.repackage.os7;
import com.repackage.ou4;
import com.repackage.p35;
import com.repackage.p67;
import com.repackage.p85;
import com.repackage.p95;
import com.repackage.pg8;
import com.repackage.pi;
import com.repackage.pm5;
import com.repackage.pq7;
import com.repackage.pz4;
import com.repackage.q15;
import com.repackage.qg;
import com.repackage.qp4;
import com.repackage.qv7;
import com.repackage.qy7;
import com.repackage.r35;
import com.repackage.rk8;
import com.repackage.rl4;
import com.repackage.rn;
import com.repackage.rw7;
import com.repackage.rz7;
import com.repackage.s65;
import com.repackage.s67;
import com.repackage.sg5;
import com.repackage.so4;
import com.repackage.st7;
import com.repackage.sv4;
import com.repackage.sv7;
import com.repackage.sw4;
import com.repackage.sw7;
import com.repackage.t15;
import com.repackage.ti8;
import com.repackage.tn4;
import com.repackage.tq4;
import com.repackage.tt4;
import com.repackage.tv7;
import com.repackage.ty4;
import com.repackage.u15;
import com.repackage.u85;
import com.repackage.v15;
import com.repackage.v36;
import com.repackage.v88;
import com.repackage.vg5;
import com.repackage.w05;
import com.repackage.w36;
import com.repackage.xm6;
import com.repackage.xo4;
import com.repackage.xr7;
import com.repackage.xt4;
import com.repackage.xt7;
import com.repackage.xu7;
import com.repackage.ym;
import com.repackage.z05;
import com.repackage.za;
import com.repackage.ze5;
import com.repackage.zm4;
import com.repackage.zp4;
import com.repackage.zr7;
import com.repackage.zu7;
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
/* loaded from: classes3.dex */
public class PbFragment extends BaseFragment implements vg5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, cr4.e, TbRichTextView.s, TbPageContextSupport, qy7, rz7.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k P2;
    public static final w36.b Q2;
    public transient /* synthetic */ FieldHolder $fh;
    public eg<TextView> A;
    public ForumManageModel A0;
    public CustomMessageListener A1;
    public PostData A2;
    public eg<TbImageView> B;
    public ty4 B0;
    public CustomMessageListener B1;
    public final er4.c B2;
    public eg<ImageView> C;
    public bs7 C0;
    public CustomMessageListener C1;
    public final er4.c C2;
    public eg<View> D;
    public LiveRemindModel D0;
    public CustomMessageListener D1;
    public final AdapterView.OnItemClickListener D2;
    public eg<TiebaPlusRecommendCard> E;
    public ShareSuccessReplyToServerModel E0;
    public CustomMessageListener E1;
    public final View.OnLongClickListener E2;
    public eg<LinearLayout> F;
    public nv7 F0;
    public final CustomMessageListener F1;
    public final View.OnClickListener F2;
    public eg<RelativeLayout> G;
    public boolean G0;
    public CustomMessageListener G1;
    public final ItemCardHelper.c G2;
    public eg<ItemCardView> H;
    public boolean H0;
    public CustomMessageListener H1;
    public final NoNetworkView.b H2;
    public boolean I;
    public boolean I0;
    public View.OnClickListener I1;
    public View.OnTouchListener I2;
    public boolean J;
    public qv7 J0;
    public CustomMessageListener J1;
    public v36.b J2;
    public boolean K;
    public lr4 K0;
    public CustomMessageListener K1;
    public final fu7.b K2;
    public eg<GifView> L;
    public nr4 L0;
    public CustomMessageListener L1;
    public int L2;
    public String M;
    public String M0;
    public SuggestEmotionModel.c M1;
    public int M2;
    public boolean N;
    public boolean N0;
    public CustomMessageListener N1;
    public String N2;
    public boolean O;
    public boolean O0;
    public CustomMessageListener O1;
    public io4 O2;
    public String P;
    public boolean P0;
    public GetSugMatchWordsModel.b P1;
    public nw7 Q;
    public String Q0;
    public boolean Q1;
    public LikeModel R;
    public boolean R0;
    public PraiseModel R1;
    public View S;
    public fi8 S0;
    public sw7.h S1;
    public View T;
    public p35 T0;
    public CustomMessageListener T1;
    public View U;
    public n35 U0;
    public s65 U1;
    public View V;
    public boolean V0;
    public CheckRealNameModel.b V1;
    public String W;
    public PermissionJudgePolicy W0;
    public ls7 W1;
    public int X;
    public ReplyPrivacyCheckController X0;
    public CustomMessageListener X1;
    public boolean Y;
    public xm6 Y0;
    public CustomMessageListener Y1;
    public int[] Z;
    public xm6 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public EmotionImageData a1;
    public CustomMessageListener a2;
    public boolean b;
    public l35 b1;
    public CustomMessageListener b2;
    public boolean c;
    public k35 c1;
    public CustomMessageListener c2;
    public w36 d;
    public k35 d1;
    public CustomMessageListener d2;
    public sw7 e;
    public int e1;
    public cr4.e e2;
    public boolean f;
    public Object f1;
    public nr4.e f2;
    public boolean g;
    public int g0;
    public d9 g1;
    public SortSwitchButton.f g2;
    public boolean h;
    public int h0;
    public cu4 h1;
    public final View.OnClickListener h2;
    public boolean i;
    public int i0;
    public BdUniqueId i1;
    public CustomMessageListener i2;
    public boolean j;
    public zp4 j0;
    public Runnable j1;
    public final NewWriteModel.e j2;
    public VoiceManager k;
    public BdUniqueId k0;
    public sv7 k1;
    public NewWriteModel.e k2;
    public int l;
    public tt4 l0;
    public ym l1;
    public za l2;
    public er4 m;
    public boolean m0;
    public String m1;
    public final PbModel.h m2;
    public long n;
    public boolean n0;
    public TbRichTextImageInfo n1;
    public CustomMessageListener n2;
    public long o;
    public Object o0;
    public TbRichTextMemeInfo o1;
    public HttpMessageListener o2;
    public long p;
    public ei8 p0;
    public boolean p1;
    public final jl4.a p2;
    public long q;
    public boolean q0;
    public int q1;
    public final AbsListView.OnScrollListener q2;
    public long r;
    public mz4 r0;
    public int r1;
    public final c9 r2;
    public boolean s;
    public boolean s0;
    public List<e3> s1;
    public final g3 s2;
    public boolean t;
    @NonNull
    public TiePlusEventController.f t0;
    public int t1;
    public final fu4.g t2;
    public j95 u;
    public dx7 u0;
    public String u1;
    public final View.OnClickListener u2;
    public long v;
    public PbInterviewStatusView.f v0;
    public hx5 v1;
    public boolean v2;
    public boolean w;
    public final Handler w0;
    public final e3 w1;
    public final BdListView.p w2;
    public long x;
    public PbModel x0;
    public final xu7.b x1;
    public int x2;
    public int y;
    public lx7 y0;
    public final CustomMessageListener y1;
    public final TbRichTextView.y y2;
    public String z;
    public jl4 z0;
    public CustomMessageListener z1;
    public boolean z2;

    /* loaded from: classes3.dex */
    public class a implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public a(PbFragment pbFragment) {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    cr4Var.dismiss();
                    ((TbPageContext) this.a.g1).showToast(R.string.obfuscated_res_0x7f0f0701);
                    return;
                }
                TiebaStatic.log("c10025");
                cr4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.g1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(PbFragment pbFragment, int i) {
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
                this.a.G6();
            } else {
                this.a.Q6();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a1() {
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
    public class a2 implements fu4.g {
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

        @Override // com.repackage.fu4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.C5()) {
                    this.a.a.finish();
                }
                if (!this.a.x0.O2(true)) {
                    this.a.F0.v0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a3 implements v36.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

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
            this.b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // com.repackage.v36.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || !e(i2) || this.b.F0 == null || this.b.e == null) {
                return;
            }
            this.b.e.u(true);
            if (Math.abs(i2) > this.a) {
                this.b.e.l();
            }
            if (this.b.C5()) {
                this.b.F0.t1();
                this.b.F0.O2();
            }
        }

        @Override // com.repackage.v36.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || !e(i2) || this.b.F0 == null || this.b.e == null) {
                return;
            }
            this.b.F0.T3();
            this.b.e.u(false);
            this.b.e.x();
        }

        @Override // com.repackage.v36.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.v36.b
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

    /* loaded from: classes3.dex */
    public class b implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements GetSugMatchWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public b0(PbFragment pbFragment) {
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.a.F0 == null) {
                return;
            }
            this.a.F0.v3(list);
        }
    }

    /* loaded from: classes3.dex */
    public class b1 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public b1(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (cr4Var != null) {
                    cr4Var.dismiss();
                }
                this.d.l5(((Integer) this.a.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091eef), this.b, this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.C5()) {
                    this.a.a.finish();
                }
                if (!this.a.x0.O2(true)) {
                    this.a.F0.v0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b3 implements w36.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b3() {
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

        @Override // com.repackage.w36.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ks7.d();
                } else {
                    ks7.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public c0(PbFragment pbFragment) {
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
                this.a.Q1 = false;
                if (this.a.R1 == null || str == null) {
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
                this.a.Q1 = false;
                if (this.a.R1 == null) {
                    return;
                }
                jr7 R1 = this.a.x0.R1();
                if (R1.O().getPraise().getIsLike() == 1) {
                    this.a.G7(0);
                } else {
                    this.a.G7(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, R1.O()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c1 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public c1(PbFragment pbFragment) {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c2 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.v2 && this.a.C5()) {
                    this.a.q6();
                }
                if (this.a.mIsLogin) {
                    if (!this.a.m0 && this.a.F0 != null && this.a.F0.d0() && this.a.x0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.a.x0.j2());
                        statisticItem.param("fid", this.a.x0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i = 5;
                        if (this.a.x0.w1()) {
                            i = 4;
                        } else if (this.a.x0.x1()) {
                            i = 3;
                        } else if (this.a.x0.z1()) {
                            i = 1;
                        }
                        statisticItem.param("obj_type", i);
                        TiebaStatic.log(statisticItem);
                        this.a.m0 = true;
                    }
                    if (this.a.x0.K2(false)) {
                        this.a.F0.r3();
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if ((this.a.u0 == null || !this.a.x0.E2() || !this.a.u0.d()) && this.a.x0.R1() != null) {
                        this.a.F0.H2();
                    }
                    this.a.v2 = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c3 implements fu7.b {
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

        @Override // com.repackage.fu7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f14dd);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2b);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.F0.k0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public d(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.b.F0.L3();
                MessageManager.getInstance().sendMessage(this.a);
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements sw7.h {
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

        @Override // com.repackage.sw7.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.X6(z);
                if (this.a.F0.O0() != null && z) {
                    this.a.F0.a4(false);
                }
                this.a.F0.j2(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d1 implements xm6.d {
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

        @Override // com.repackage.xm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.xm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", z ? 5 : 6).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (z) {
                    if (this.a.U0 != null && this.a.U0.a() != null) {
                        this.a.U0.a().A(new j15(45, 27, null));
                    }
                    this.a.F0.f0();
                }
            }
        }

        @Override // com.repackage.xm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d2 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.x0 == null) {
                return;
            }
            this.a.x0.loadData();
        }
    }

    /* loaded from: classes3.dex */
    public class d3 implements xu7.b {
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

        @Override // com.repackage.xu7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.F0.d4(str);
        }

        @Override // com.repackage.xu7.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements PbInterviewStatusView.f {
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

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.F0.a4(!this.a.N);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e1 implements SortSwitchButton.f {
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

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a.F0.m0();
                boolean z = false;
                if (ni.z()) {
                    if (this.a.x0 != null && !this.a.x0.isLoading) {
                        this.a.y7();
                        this.a.F0.q3();
                        z = true;
                        if (this.a.x0.R1() != null && this.a.x0.R1().f != null && this.a.x0.R1().f.size() > i) {
                            int intValue = this.a.x0.R1().f.get(i).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.x0.k2()).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.a.x0.I3(intValue)) {
                                this.a.i = true;
                                this.a.F0.e3(true);
                            }
                        }
                    }
                    return z;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
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

    /* loaded from: classes3.dex */
    public class e2 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ e2 b;

            public a(e2 e2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = e2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    os7.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

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
    public interface e3 {
        boolean onBackPressed();
    }

    /* loaded from: classes3.dex */
    public class f extends de5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public f(PbFragment pbFragment) {
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
        @Override // com.repackage.de5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return gx7.d(this.a.t5(), ShareSwitch.isOn() ? 1 : 6, this.a.x0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PbFragment e;

        public f0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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

        @Override // com.repackage.nr4.e
        public void N(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                if (this.e.K0 != null) {
                    this.e.K0.dismiss();
                }
                if (i == 0) {
                    this.e.F0.r2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091eef), ((Integer) this.a.get(R.id.obfuscated_res_0x7f091f0c)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f091f41);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f091f43);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f091f42);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.i1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.i1);
                    this.e.u7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f091f3f));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes3.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f1 a;

            public a(f1 f1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = f1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                qv7 qv7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qv7Var = this.a.c.J0) == null || qv7Var.g() == null) {
                    return;
                }
                if (!this.a.c.J0.g().e()) {
                    this.a.c.J0.b(false);
                }
                this.a.c.J0.g().l(false);
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

        public f1(PbFragment pbFragment, String str, String str2) {
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
                int i2 = pi.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = pi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = pi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                PbFragment pbFragment = this.c;
                boolean z = true;
                pbFragment.O5().R0().smoothScrollBy((pbFragment.Z[1] + pbFragment.g0) - i3, 50);
                if (this.c.O5().b1() != null) {
                    this.c.U0.a().setVisibility(8);
                    this.c.O5().b1().o(this.a, this.b, this.c.O5().e1(), (this.c.x0 == null || this.c.x0.R1() == null || this.c.x0.R1().O() == null || !this.c.x0.R1().O().isBjh()) ? false : false);
                    r35 b = this.c.O5().b1().b();
                    if (b != null && this.c.x0 != null && this.c.x0.R1() != null) {
                        b.G(this.c.x0.R1().d());
                        b.c0(this.c.x0.R1().O());
                    }
                    if (this.c.J0.f() == null && this.c.O5().b1().b().t() != null) {
                        this.c.O5().b1().b().t().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.J0.n(pbFragment2.O5().b1().b().t().i());
                        this.c.O5().b1().b().M(this.c.d1);
                    }
                }
                this.c.O5().o1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f2 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ cr4 c;
        public final /* synthetic */ PbFragment d;

        public f2(PbFragment pbFragment, MarkData markData, MarkData markData2, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, cr4Var};
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
            this.c = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                if (this.d.z0 != null) {
                    if (this.d.z0.e()) {
                        this.d.z0.d();
                        this.d.z0.h(false);
                    }
                    this.d.z0.i(this.a);
                    this.d.z0.h(true);
                    this.d.z0.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.z7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f3 {
        void a(Object obj);
    }

    /* loaded from: classes3.dex */
    public class g implements jd5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public g(PbFragment pbFragment, int i) {
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
        @Override // com.repackage.jd5
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

    /* loaded from: classes3.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(PbFragment pbFragment, int i) {
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.a.getUniqueId() || AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, PbFragment.P2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().a) {
                    if (this.a.u5().s() != null && this.a.u5().s().getGodUserData() != null) {
                        this.a.u5().s().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.x0 == null || this.a.x0.R1() == null || this.a.x0.R1().O() == null || this.a.x0.R1().O().getAuthor() == null) {
                        return;
                    }
                    this.a.x0.R1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g1 implements xm6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$g1$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0232a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0232a(a aVar) {
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
                    qv7 qv7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qv7Var = this.a.a.c.J0) == null || qv7Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.c.J0.g().e()) {
                        this.a.a.c.J0.b(false);
                    }
                    this.a.a.c.J0.g().l(false);
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

            public a(g1 g1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {g1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = g1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = pi.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    PbFragment pbFragment = this.a.c;
                    boolean z = true;
                    pbFragment.O5().R0().smoothScrollBy((pbFragment.Z[1] + pbFragment.g0) - i3, 50);
                    if (this.a.c.O5().b1() != null) {
                        this.a.c.U0.a().setVisibility(8);
                        z = (this.a.c.x0 == null || this.a.c.x0.R1() == null || this.a.c.x0.R1().O() == null || !this.a.c.x0.R1().O().isBjh()) ? false : false;
                        ju7 b1 = this.a.c.O5().b1();
                        g1 g1Var = this.a;
                        b1.o(g1Var.a, g1Var.b, g1Var.c.O5().e1(), z);
                        r35 b = this.a.c.O5().b1().b();
                        if (b != null && this.a.c.x0 != null && this.a.c.x0.R1() != null) {
                            b.G(this.a.c.x0.R1().d());
                            b.c0(this.a.c.x0.R1().O());
                        }
                        if (this.a.c.J0.f() == null && this.a.c.O5().b1().b().t() != null) {
                            this.a.c.O5().b1().b().t().g(new C0232a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.J0.n(pbFragment2.O5().b1().b().t().i());
                            this.a.c.O5().b1().b().M(this.a.c.d1);
                        }
                    }
                    this.a.c.O5().o1();
                }
            }
        }

        public g1(PbFragment pbFragment, String str, String str2) {
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

        @Override // com.repackage.xm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.xm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", z ? 5 : 6).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (z) {
                    qg.a().postDelayed(new a(this), 0L);
                }
            }
        }

        @Override // com.repackage.xm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g2 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ cr4 b;
        public final /* synthetic */ PbFragment c;

        public g2(PbFragment pbFragment, MarkData markData, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, cr4Var};
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
            this.b = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.z7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g3 {
    }

    /* loaded from: classes3.dex */
    public class h extends de5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public h(PbFragment pbFragment, int i) {
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
        @Override // com.repackage.de5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel F = this.b.F();
                if (F != null) {
                    F.q3(this.a);
                }
                return gx7.d(this.b.t5(), 2, F);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h0 extends s65<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment c;

        public h0(PbFragment pbFragment) {
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
        @Override // com.repackage.l65
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

    /* loaded from: classes3.dex */
    public class h1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements nr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ lr4 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ h1 c;

            public a(h1 h1Var, lr4 lr4Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h1Var, lr4Var, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = h1Var;
                this.a = lr4Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.x0.g2() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.repackage.nr4.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void N(nr4 nr4Var, int i, View view2) {
                boolean I3;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, nr4Var, i, view2) != null) {
                    return;
                }
                this.a.dismiss();
                int i2 = 3;
                if (this.c.a.x0.g2() != 1 || i != 1) {
                    if (this.c.a.x0.g2() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.x0.g2() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f09179b ? 1 : 0).param("obj_type", i2));
                    if (this.c.a.x0.R1().f != null && this.c.a.x0.R1().f.size() > i) {
                        i = this.c.a.x0.R1().f.get(i).sort_type.intValue();
                    }
                    I3 = this.c.a.x0.I3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.x0.f2()));
                    if (I3) {
                        return;
                    }
                    this.c.a.i = true;
                    this.c.a.F0.e3(true);
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f09179b ? 1 : 0).param("obj_type", i2));
                if (this.c.a.x0.R1().f != null) {
                    i = this.c.a.x0.R1().f.get(i).sort_type.intValue();
                }
                I3 = this.c.a.x0.I3(i);
                this.b.setTag(Integer.valueOf(this.c.a.x0.f2()));
                if (I3) {
                }
            }
        }

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

        /* JADX WARN: Code restructure failed: missing block: B:879:0x212c, code lost:
            if (r7 == (r32.a.F0.c1().c().getHeight() - r32.a.F0.c1().e())) goto L923;
         */
        /* JADX WARN: Code restructure failed: missing block: B:917:0x22b8, code lost:
            if (r32.a.F0.b1.c.b().getTop() <= ((r32.a.F0.c1() == null || r32.a.F0.c1().c() == null) ? 0 : r32.a.F0.c1().c().getBottom())) goto L852;
         */
        /* JADX WARN: Code restructure failed: missing block: B:918:0x22ba, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:920:0x22c7, code lost:
            if (r0 >= com.repackage.iw7.d(r32.a.F5())) goto L852;
         */
        /* JADX WARN: Code restructure failed: missing block: B:942:0x236e, code lost:
            if ((r32.a.F0.b1.c.b().getTop() - r32.a.F0.h.a.getBottom()) < (r32.a.F0.b1.c.g.getHeight() + 10)) goto L852;
         */
        /* JADX WARN: Removed duplicated region for block: B:1188:0x2c61  */
        /* JADX WARN: Removed duplicated region for block: B:1189:0x2c77  */
        /* JADX WARN: Removed duplicated region for block: B:1192:0x2cb3  */
        /* JADX WARN: Removed duplicated region for block: B:307:0x0b12  */
        /* JADX WARN: Removed duplicated region for block: B:308:0x0b16  */
        /* JADX WARN: Removed duplicated region for block: B:311:0x0b24  */
        /* JADX WARN: Removed duplicated region for block: B:346:0x0bdb  */
        /* JADX WARN: Removed duplicated region for block: B:349:0x0bee  */
        /* JADX WARN: Removed duplicated region for block: B:352:0x0bff  */
        /* JADX WARN: Removed duplicated region for block: B:355:0x0c15  */
        /* JADX WARN: Removed duplicated region for block: B:357:0x0c1e  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            jr4 jr4Var;
            jr4 jr4Var2;
            jr4 jr4Var3;
            PbFragment pbFragment;
            int i;
            boolean z;
            jr4 jr4Var4;
            jr4 jr4Var5;
            jr4 jr4Var6;
            jr4 jr4Var7;
            String name;
            int i2;
            boolean z2;
            int fixedNavHeight;
            int i3;
            int i4;
            tq4 tq4Var;
            String jumpUrlWithTid;
            String[] strArr;
            jr7 R1;
            int i5;
            int i6;
            boolean H3;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.F0.U0() && this.a.getPageContext().getPageActivity() != null && this.a.x0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.j2(), this.a.x0.z2(), this.a.x0.y2())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.x0.getForumId());
                        statisticItem2.param("fname", this.a.x0.q1());
                        statisticItem2.param("tid", this.a.x0.j2());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.F0.W0()) {
                        if (this.a.i) {
                            return;
                        }
                        if (this.a.x0.K2(true)) {
                            this.a.i = true;
                            this.a.F0.r3();
                        }
                    } else if (view2 != this.a.F0.h.m()) {
                        if (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().p()) {
                            if (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().h()) {
                                if (view2 == this.a.F0.h.f) {
                                    if (this.a.F0.c0(this.a.x0.E1())) {
                                        this.a.y7();
                                        return;
                                    }
                                    this.a.j = false;
                                    this.a.f = false;
                                    pi.x(this.a.a, this.a.F0.h.f);
                                    this.a.a.finish();
                                } else if (view2 != this.a.F0.C0() && (this.a.F0.h.n() == null || (view2 != this.a.F0.h.n().q() && view2 != this.a.F0.h.n().r()))) {
                                    if (view2 == this.a.F0.K0()) {
                                        if (this.a.x0 != null) {
                                            rl4.o(this.a.getPageContext().getPageActivity(), this.a.x0.R1().O().getTopicData().b());
                                        }
                                    } else if (view2 != this.a.F0.h.c) {
                                        if (view2 == this.a.F0.h.d) {
                                            if (gd5.a()) {
                                                return;
                                            }
                                            if (this.a.x0 != null && this.a.x0.R1() != null) {
                                                ArrayList<PostData> F = this.a.x0.R1().F();
                                                if ((F == null || F.size() <= 0) && this.a.x0.h2()) {
                                                    pi.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dc7));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.x0.j2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.x0.getForumId()));
                                                if (!this.a.F0.R1()) {
                                                    this.a.F0.M2();
                                                }
                                                this.a.F6();
                                            } else {
                                                pi.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dc7));
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09173c) {
                                            if (ni.z()) {
                                                this.a.F0.a3(true);
                                                this.a.F0.M2();
                                                if (this.a.i) {
                                                    return;
                                                }
                                                this.a.i = true;
                                                this.a.F0.V3();
                                                this.a.y7();
                                                this.a.F0.q3();
                                                this.a.x0.G3(this.a.x5());
                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                                                return;
                                            }
                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f091718) {
                                            if ((this.a.F0.h.n() == null || view2 != this.a.F0.h.n().n()) && view2.getId() != R.id.obfuscated_res_0x7f0909c0 && view2.getId() != R.id.obfuscated_res_0x7f091afa) {
                                                if (this.a.F0.h.n() != null && view2 == this.a.F0.h.n().j()) {
                                                    this.a.F0.h.k();
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d51) {
                                                    if (!this.a.a5(11009)) {
                                                        return;
                                                    }
                                                    this.a.c6(3);
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f09171d) {
                                                    if (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().o()) {
                                                        if (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().v()) {
                                                            if (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().u()) {
                                                                if (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().s()) {
                                                                    if (this.a.F0.O0() == view2) {
                                                                        if (this.a.F0.O0().getIndicateStatus()) {
                                                                            jr7 R12 = this.a.x0.R1();
                                                                            if (R12 != null && R12.O() != null && R12.O().getTaskInfoData() != null) {
                                                                                String d = R12.O().getTaskInfoData().d();
                                                                                if (StringUtils.isNull(d)) {
                                                                                    d = R12.O().getTaskInfoData().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                                            }
                                                                        } else {
                                                                            ti8.d("c10725", null);
                                                                        }
                                                                        this.a.U5();
                                                                    } else if (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().l()) {
                                                                        if (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().a()) {
                                                                            if (this.a.F0.h.n() != null && view2 == this.a.F0.h.n().k()) {
                                                                                if (ni.z()) {
                                                                                    SparseArray<Object> S0 = this.a.F0.S0(this.a.x0.R1(), this.a.x0.h2(), 1);
                                                                                    if (S0 != null) {
                                                                                        if (StringUtils.isNull((String) S0.get(R.id.obfuscated_res_0x7f091eee))) {
                                                                                            this.a.F0.r2(((Integer) S0.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) S0.get(R.id.obfuscated_res_0x7f091eef), ((Integer) S0.get(R.id.obfuscated_res_0x7f091f0c)).intValue(), ((Boolean) S0.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue());
                                                                                        } else {
                                                                                            this.a.F0.s2(((Integer) S0.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) S0.get(R.id.obfuscated_res_0x7f091eef), ((Integer) S0.get(R.id.obfuscated_res_0x7f091f0c)).intValue(), ((Boolean) S0.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue(), (String) S0.get(R.id.obfuscated_res_0x7f091eee));
                                                                                        }
                                                                                    }
                                                                                    this.a.F0.h.k();
                                                                                } else {
                                                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                                                                                    return;
                                                                                }
                                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f091e50 && view2.getId() != R.id.obfuscated_res_0x7f091e4e && view2.getId() != R.id.obfuscated_res_0x7f09172c && view2.getId() != R.id.obfuscated_res_0x7f0915cf) {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f09178d) {
                                                                                    if (this.a.x0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                                                                                    statisticItem3.param("tid", this.a.x0.j2());
                                                                                    statisticItem3.param("fid", this.a.x0.getForumId());
                                                                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem3.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem3);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09178d && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                        this.a.T = view2;
                                                                                        return;
                                                                                    } else if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                                        if (!(sparseArray2.get(R.id.obfuscated_res_0x7f091f09) instanceof PostData)) {
                                                                                            return;
                                                                                        }
                                                                                        PostData postData = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091f09);
                                                                                        StatisticItem statisticItem4 = postData.i0;
                                                                                        if (statisticItem4 != null) {
                                                                                            StatisticItem copy = statisticItem4.copy();
                                                                                            copy.delete("obj_locate");
                                                                                            copy.param("obj_locate", 8);
                                                                                            TiebaStatic.log(copy);
                                                                                        }
                                                                                        if (this.a.x0 == null || this.a.x0.R1() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String j2 = this.a.x0.j2();
                                                                                        String J = postData.J();
                                                                                        int V = this.a.x0.R1() != null ? this.a.x0.R1().V() : 0;
                                                                                        AbsPbActivity.e J6 = this.a.J6(J);
                                                                                        if (J6 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(j2, J, "pb", true, false, null, false, null, V, postData.V(), this.a.x0.R1().d(), false, postData.s().getIconInfo(), 5).addBigImageData(J6.a, J6.b, J6.g, J6.j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.a.x0.Q1());
                                                                                        addBigImageData.setFromFrsForumId(this.a.x0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.a.x0.o2());
                                                                                        addBigImageData.setKeyFromForumId(this.a.x0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.a.x0.J(), this.a.x0.F(), this.a.x0.G(), this.a.x0.E(), this.a.x0.K());
                                                                                        addBigImageData.setBjhData(this.a.x0.j1());
                                                                                        if (this.a.x0.R1().o() != null) {
                                                                                            addBigImageData.setHasForumRule(this.a.x0.R1().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.a.x0.R1().U() != null) {
                                                                                            addBigImageData.setIsManager(this.a.x0.R1().U().getIs_manager());
                                                                                        }
                                                                                        if (this.a.x0.R1().l().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.x0.R1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.x0.R1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.a.x0.R1().l() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.a.x0.R1().l().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.a.x0.R1().l().getUser_level());
                                                                                        }
                                                                                        if (this.a.F0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.a.F0.I0(this.a.x0.G, this.a.x0.h2()).Q || postData.Q);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f09178b || view2.getId() == R.id.obfuscated_res_0x7f091953 || view2.getId() == R.id.obfuscated_res_0x7f091726) {
                                                                                    if (this.a.x0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09178b) {
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                                                        statisticItem5.param("tid", this.a.x0.j2());
                                                                                        statisticItem5.param("fid", this.a.x0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem5.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091953) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                            this.a.U = view2;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09178b && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                        this.a.U = view2;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                                                                    if (!(sparseArray3.get(R.id.obfuscated_res_0x7f091f09) instanceof PostData)) {
                                                                                        return;
                                                                                    }
                                                                                    PostData postData2 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091f09);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09178b && (statisticItem = postData2.i0) != null) {
                                                                                        StatisticItem copy2 = statisticItem.copy();
                                                                                        copy2.delete("obj_locate");
                                                                                        copy2.param("obj_locate", 8);
                                                                                        TiebaStatic.log(copy2);
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091953 || view2.getId() == R.id.obfuscated_res_0x7f091726) {
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.x0.k2()).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.J()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.a.x0 == null || this.a.x0.R1() == null || this.a.O5().a1() == null || postData2.s() == null || postData2.B() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.O5().b1() != null) {
                                                                                        this.a.O5().b1().c();
                                                                                    }
                                                                                    if (this.a.q0 && postData2.S() != null && postData2.S().size() != 0) {
                                                                                        this.a.x7(postData2, true);
                                                                                    } else {
                                                                                        zr7 zr7Var = new zr7();
                                                                                        zr7Var.A(this.a.x0.R1().l());
                                                                                        zr7Var.E(this.a.x0.R1().O());
                                                                                        zr7Var.C(postData2);
                                                                                        this.a.O5().a1().W(zr7Var);
                                                                                        this.a.O5().a1().setPostId(postData2.J());
                                                                                        this.a.u6(view2, postData2.s().getUserId(), "", postData2);
                                                                                        if (this.a.U0 != null) {
                                                                                            this.a.F0.U2(this.a.U0.C());
                                                                                        }
                                                                                    }
                                                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f09172a) {
                                                                                    if (view2 != this.a.F0.M0()) {
                                                                                        if (view2 == this.a.F0.h.o()) {
                                                                                            this.a.F0.z3();
                                                                                        } else if (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().t()) {
                                                                                            if (this.a.F0.h.n() != null && view2 == this.a.F0.h.n().m()) {
                                                                                                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.x0.j2())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                                                    this.a.F0.h.k();
                                                                                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                                                                }
                                                                                            } else {
                                                                                                int id = view2.getId();
                                                                                                if (id == R.id.obfuscated_res_0x7f0917aa) {
                                                                                                    if (!this.a.checkUpIsLogin() || (tq4Var = (tq4) view2.getTag()) == null || StringUtils.isNull(tq4Var.Q0())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{tq4Var.Q0()});
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091afd || id == R.id.obfuscated_res_0x7f0906e6 || id == R.id.obfuscated_res_0x7f091afe || id == R.id.obfuscated_res_0x7f0906e7) {
                                                                                                    if (!this.a.checkUpIsLogin()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view2 != null && view2.getTag() != null) {
                                                                                                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f091f09);
                                                                                                        if (id == R.id.obfuscated_res_0x7f091afe || id == R.id.obfuscated_res_0x7f0906e7) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.x0.b));
                                                                                                        }
                                                                                                        if (this.a.L0 == null) {
                                                                                                            PbFragment pbFragment2 = this.a;
                                                                                                            pbFragment2.L0 = new nr4(pbFragment2.getContext());
                                                                                                            this.a.L0.n(this.a.f2);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.a.k6(view2);
                                                                                                        if (this.a.k6(view2) && this.a.l1 != null) {
                                                                                                            this.a.l1.t();
                                                                                                        }
                                                                                                        if (sparseArray4.get(R.id.obfuscated_res_0x7f091f06) instanceof Boolean) {
                                                                                                            ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f06)).booleanValue();
                                                                                                        }
                                                                                                        boolean booleanValue = sparseArray4.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue() : false;
                                                                                                        boolean booleanValue2 = sparseArray4.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f44)).booleanValue() : false;
                                                                                                        boolean booleanValue3 = sparseArray4.get(R.id.obfuscated_res_0x7f091f30) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f30)).booleanValue() : false;
                                                                                                        boolean booleanValue4 = sparseArray4.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f44)).booleanValue() : false;
                                                                                                        boolean booleanValue5 = sparseArray4.get(R.id.obfuscated_res_0x7f091f2e) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f2e)).booleanValue() : false;
                                                                                                        String str = sparseArray4.get(R.id.obfuscated_res_0x7f091efd) instanceof String ? (String) sparseArray4.get(R.id.obfuscated_res_0x7f091efd) : null;
                                                                                                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091f05) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f05)).booleanValue() : false;
                                                                                                        if (postData3 != null) {
                                                                                                            if (postData3.Q() != null && postData3.Q().toString().length() > 0) {
                                                                                                                jr4 jr4Var8 = new jr4(3, this.a.getString(R.string.obfuscated_res_0x7f0f0443), this.a.L0);
                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                sparseArray5.put(R.id.obfuscated_res_0x7f091eed, postData3);
                                                                                                                jr4Var8.d.setTag(sparseArray5);
                                                                                                                arrayList.add(jr4Var8);
                                                                                                            }
                                                                                                            this.a.A2 = postData3;
                                                                                                        }
                                                                                                        if (this.a.x0.R1().r()) {
                                                                                                            String u = this.a.x0.R1().u();
                                                                                                            if (postData3 != null && !oi.isEmpty(u) && u.equals(postData3.J())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    jr4Var4 = new jr4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0fb3), this.a.L0);
                                                                                                                } else {
                                                                                                                    jr4Var4 = new jr4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0a80), this.a.L0);
                                                                                                                }
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f091eed, this.a.A2);
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f091f06, Boolean.FALSE);
                                                                                                                jr4Var4.d.setTag(sparseArray6);
                                                                                                                arrayList.add(jr4Var4);
                                                                                                                if (this.a.mIsLogin) {
                                                                                                                    if (fx7.h(this.a.x0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.a.o6(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            jr4 jr4Var9 = new jr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fd6), this.a.L0);
                                                                                                                            jr4Var9.d.setTag(str);
                                                                                                                            arrayList.add(jr4Var9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        jr4 jr4Var10 = new jr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b23), this.a.L0);
                                                                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091f44, Boolean.TRUE);
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091f04, sparseArray4.get(R.id.obfuscated_res_0x7f091f04));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091f40, sparseArray4.get(R.id.obfuscated_res_0x7f091f40));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091f41, sparseArray4.get(R.id.obfuscated_res_0x7f091f41));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091f3f, sparseArray4.get(R.id.obfuscated_res_0x7f091f3f));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091f42, sparseArray4.get(R.id.obfuscated_res_0x7f091f42));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091f43, sparseArray4.get(R.id.obfuscated_res_0x7f091f43));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ef0, sparseArray4.get(R.id.obfuscated_res_0x7f091ef0));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ef1, sparseArray4.get(R.id.obfuscated_res_0x7f091ef1));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091eef, sparseArray4.get(R.id.obfuscated_res_0x7f091eef));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091f0c, sparseArray4.get(R.id.obfuscated_res_0x7f091f0c));
                                                                                                                        jr4Var4.d.setTag(sparseArray7);
                                                                                                                        arrayList.add(jr4Var10);
                                                                                                                    }
                                                                                                                    if (booleanValue3) {
                                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091f30, Boolean.TRUE);
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091f0c, sparseArray4.get(R.id.obfuscated_res_0x7f091f0c));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091efa, sparseArray4.get(R.id.obfuscated_res_0x7f091efa));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091efb, sparseArray4.get(R.id.obfuscated_res_0x7f091efb));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091efc, sparseArray4.get(R.id.obfuscated_res_0x7f091efc));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091efd, str);
                                                                                                                        if (booleanValue4) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f44, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f04, sparseArray4.get(R.id.obfuscated_res_0x7f091f04));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f40, sparseArray4.get(R.id.obfuscated_res_0x7f091f40));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f41, sparseArray4.get(R.id.obfuscated_res_0x7f091f41));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f3f, sparseArray4.get(R.id.obfuscated_res_0x7f091f3f));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f42, sparseArray4.get(R.id.obfuscated_res_0x7f091f42));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f43, sparseArray4.get(R.id.obfuscated_res_0x7f091f43));
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f44, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        if (booleanValue5) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f2e, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(booleanValue));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091eef, sparseArray4.get(R.id.obfuscated_res_0x7f091eef));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ef1, sparseArray4.get(R.id.obfuscated_res_0x7f091ef1));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f01, sparseArray4.get(R.id.obfuscated_res_0x7f091f01));
                                                                                                                            if (booleanValue6) {
                                                                                                                                jr4 jr4Var11 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f049f), this.a.L0);
                                                                                                                                jr4Var11.d.setTag(sparseArray8);
                                                                                                                                jr4Var6 = jr4Var11;
                                                                                                                                jr4Var5 = new jr4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02df), this.a.L0);
                                                                                                                                jr4Var5.d.setTag(sparseArray8);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f2e, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        jr4Var6 = null;
                                                                                                                        jr4Var5 = new jr4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02df), this.a.L0);
                                                                                                                        jr4Var5.d.setTag(sparseArray8);
                                                                                                                    } else if (booleanValue5) {
                                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091f30, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091f44, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091f2e, Boolean.TRUE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091f0c, sparseArray4.get(R.id.obfuscated_res_0x7f091f0c));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(booleanValue));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091eef, sparseArray4.get(R.id.obfuscated_res_0x7f091eef));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091ef1, sparseArray4.get(R.id.obfuscated_res_0x7f091ef1));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091f01, sparseArray4.get(R.id.obfuscated_res_0x7f091f01));
                                                                                                                        if (this.a.x0.R1().V() == 1002 && !booleanValue) {
                                                                                                                            jr4Var7 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fd6), this.a.L0);
                                                                                                                        } else {
                                                                                                                            jr4Var7 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f049f), this.a.L0);
                                                                                                                        }
                                                                                                                        jr4Var7.d.setTag(sparseArray9);
                                                                                                                        jr4Var6 = jr4Var7;
                                                                                                                        jr4Var5 = null;
                                                                                                                    } else {
                                                                                                                        jr4Var5 = null;
                                                                                                                        jr4Var6 = null;
                                                                                                                    }
                                                                                                                    if (jr4Var6 != null) {
                                                                                                                        arrayList.add(jr4Var6);
                                                                                                                    }
                                                                                                                    if (jr4Var5 != null) {
                                                                                                                        arrayList.add(jr4Var5);
                                                                                                                    }
                                                                                                                }
                                                                                                                this.a.L0.j(arrayList);
                                                                                                                this.a.K0 = new lr4(this.a.getPageContext(), this.a.L0);
                                                                                                                this.a.K0.m();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray62 = new SparseArray();
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f091eed, this.a.A2);
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f091f06, Boolean.FALSE);
                                                                                                        jr4Var4.d.setTag(sparseArray62);
                                                                                                        arrayList.add(jr4Var4);
                                                                                                        if (this.a.mIsLogin) {
                                                                                                        }
                                                                                                        this.a.L0.j(arrayList);
                                                                                                        this.a.K0 = new lr4(this.a.getPageContext(), this.a.L0);
                                                                                                        this.a.K0.m();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0916fd) {
                                                                                                    if (this.a.x0.R1() != null && this.a.x0.R1().O() != null && this.a.x0.R1().O().getActUrl() != null) {
                                                                                                        rl4.o(this.a.getActivity(), this.a.x0.R1().O().getActUrl());
                                                                                                        if (this.a.x0.R1().O().getActInfoType() != 1) {
                                                                                                            if (this.a.x0.R1().O().getActInfoType() == 2) {
                                                                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                            }
                                                                                                        } else {
                                                                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0913ac) {
                                                                                                    if (view2.getTag(R.id.obfuscated_res_0x7f091f18) instanceof String) {
                                                                                                        String str2 = (String) view2.getTag(R.id.obfuscated_res_0x7f091f18);
                                                                                                        TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.x0.R1().m()).param("tid", this.a.x0.R1().Q()).param("lotterytail", StringUtils.string(str2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                        if (this.a.x0.R1().Q().equals(str2)) {
                                                                                                            this.a.F0.u3(0);
                                                                                                        } else {
                                                                                                            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091755) {
                                                                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f137b);
                                                                                                        String q = xt4.k().q("tail_link", "");
                                                                                                        if (!StringUtils.isNull(q)) {
                                                                                                            TiebaStatic.log("c10056");
                                                                                                            rl4.s(view2.getContext(), string, q, true, true, true);
                                                                                                        }
                                                                                                        this.a.F0.M2();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f090fc5) {
                                                                                                    if (view2 != null) {
                                                                                                        rl4.o(this.a.getActivity(), (String) view2.getTag());
                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                        if (this.a.t5() == 1 && this.a.x0 != null && this.a.x0.R1() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10397").param("fid", this.a.x0.R1().m()).param("tid", this.a.x0.R1().Q()).param("uid", currentAccount));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09139f) {
                                                                                                    if (view2 != null) {
                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                        rl4.o(this.a.getActivity(), (String) view2.getTag());
                                                                                                        if (this.a.t5() == 1 && this.a.x0 != null && this.a.x0.R1() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10507").param("fid", this.a.x0.R1().m()).param("tid", this.a.x0.R1().Q()).param("uid", currentAccount2));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0913fb) {
                                                                                                    this.a.t6();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0913fa) {
                                                                                                    this.a.q6();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09255e) {
                                                                                                    if (this.a.x0 != null && this.a.x0.R1() != null && this.a.x0.R1().A() != null) {
                                                                                                        jr7 R13 = this.a.x0.R1();
                                                                                                        TiebaStatic.log(new StatisticItem("c11679").param("fid", R13.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{R13.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09255b) {
                                                                                                    if (this.a.x0 != null && this.a.x0.R1() != null && this.a.x0.R1().A() != null) {
                                                                                                        jr7 R14 = this.a.x0.R1();
                                                                                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", R14.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{R14.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09226b) {
                                                                                                    if (this.a.q1 >= 0) {
                                                                                                        if (this.a.x0 != null) {
                                                                                                            this.a.x0.j3();
                                                                                                        }
                                                                                                        if (this.a.x0 == null || this.a.F0.A0() == null) {
                                                                                                            i4 = 0;
                                                                                                        } else {
                                                                                                            i4 = 0;
                                                                                                            this.a.F0.A0().f0(this.a.x0.R1(), false);
                                                                                                        }
                                                                                                        this.a.q1 = i4;
                                                                                                        if (this.a.x0 != null) {
                                                                                                            this.a.F0.R0().setSelection(this.a.x0.K1());
                                                                                                            this.a.x0.n3(0, 0);
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091a2e) {
                                                                                                    if (!this.a.a5(11009)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.c6(8);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0915cf) {
                                                                                                    SparseArray sparseArray10 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                                                    if (sparseArray10 == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.w7(sparseArray10);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09171a) {
                                                                                                    if (this.a.F0.R0() == null || this.a.x0 == null || this.a.x0.R1() == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    int firstVisiblePosition = this.a.F0.R0().getFirstVisiblePosition();
                                                                                                    View childAt = this.a.F0.R0().getChildAt(0);
                                                                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                                                                    boolean r0 = this.a.x0.R1().r0();
                                                                                                    boolean z3 = this.a.F0.c1() != null && this.a.F0.c1().g();
                                                                                                    boolean P1 = this.a.F0.P1();
                                                                                                    boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                    if (!r0 || this.a.F0.c1() == null || this.a.F0.c1().c() == null) {
                                                                                                        i2 = 0;
                                                                                                    } else {
                                                                                                        int k = ((int) (pi.k(this.a.getContext()) * 0.5625d)) - this.a.F0.c1().e();
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
                                                                                                    this.a.o5(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                    if ((this.a.x0.R1().O() != null && this.a.x0.R1().O().getReply_num() <= 0) || (P1 && z4)) {
                                                                                                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                                                        if (!this.a.checkUpIsLogin()) {
                                                                                                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.I6();
                                                                                                        if (this.a.x0.R1().O().getAuthor() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.R1().m()).param("obj_locate", 2).param("uid", this.a.x0.R1().O().getAuthor().getUserId()));
                                                                                                        }
                                                                                                    } else {
                                                                                                        int i10 = (int) (pi.i(this.a.getContext()) * 0.6d);
                                                                                                        if (r0) {
                                                                                                            if (this.a.F0.b1 != null && this.a.F0.b1.c != null && this.a.F0.b1.c.b() != null) {
                                                                                                                if (this.a.F0.b1.c.b().getParent() != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        } else {
                                                                                                            if (this.a.F0.Z0() != null) {
                                                                                                                z2 = this.a.F0.Z0().getVisibility() == 0;
                                                                                                                if (!z2 && this.a.F0.b1 != null && this.a.F0.b1.c != null && this.a.F0.b1.c.b() != null && this.a.F0.b1.c.b().getParent() != null && this.a.F0.h != null && this.a.F0.h.a != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        }
                                                                                                        if (z2 || P1) {
                                                                                                            this.a.h0 = firstVisiblePosition;
                                                                                                            this.a.i0 = top;
                                                                                                            if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i10))) {
                                                                                                                this.a.F0.R0().setSelectionFromTop(0, i9 - i10);
                                                                                                                this.a.F0.R0().smoothScrollBy(-i10, 500);
                                                                                                            } else {
                                                                                                                this.a.F0.R0().E(0, i9, 500);
                                                                                                            }
                                                                                                        } else if (this.a.h0 > 0) {
                                                                                                            if (this.a.F0.R0().getChildAt(this.a.h0) != null) {
                                                                                                                this.a.F0.R0().E(this.a.h0, this.a.i0, 200);
                                                                                                            } else {
                                                                                                                this.a.F0.R0().setSelectionFromTop(this.a.h0, this.a.i0 + i10);
                                                                                                                this.a.F0.R0().smoothScrollBy(i10, 500);
                                                                                                            }
                                                                                                        } else {
                                                                                                            int d2 = iw7.d(this.a.getListView());
                                                                                                            if (iw7.e(this.a.getListView()) != -1) {
                                                                                                                d2--;
                                                                                                            }
                                                                                                            int f = pi.f(this.a.getContext(), R.dimen.tbds100);
                                                                                                            if (d2 < 0) {
                                                                                                                d2 = (ListUtils.getCount(this.a.F0.R0().getData()) - 1) + this.a.F0.R0().getHeaderViewsCount();
                                                                                                                f = 0;
                                                                                                            }
                                                                                                            if (!z3) {
                                                                                                                if (!r0 || this.a.F0.c1() == null) {
                                                                                                                    if (this.a.F0.h != null && this.a.F0.h.a != null) {
                                                                                                                        fixedNavHeight = this.a.F0.h.a.getFixedNavHeight() - 10;
                                                                                                                    }
                                                                                                                    if (this.a.F0.b1 != null || this.a.F0.b1.c == null || this.a.F0.b1.c.b() == null || this.a.F0.b1.c.b().getParent() == null) {
                                                                                                                        this.a.F0.R0().setSelectionFromTop(d2, f + i10);
                                                                                                                        this.a.F0.R0().smoothScrollBy(i10, 500);
                                                                                                                    } else if (!z3) {
                                                                                                                        this.a.F0.R0().E(d2, f, 200);
                                                                                                                    } else {
                                                                                                                        this.a.F0.R0().smoothScrollBy(this.a.F0.b1.c.b().getTop() - ((int) (pi.k(this.a.getContext()) * 0.5625d)), 500);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = this.a.F0.c1().d();
                                                                                                                }
                                                                                                            } else {
                                                                                                                fixedNavHeight = (int) (pi.k(this.a.getContext()) * 0.5625d);
                                                                                                            }
                                                                                                            f += fixedNavHeight;
                                                                                                            if (this.a.F0.b1 != null) {
                                                                                                            }
                                                                                                            this.a.F0.R0().setSelectionFromTop(d2, f + i10);
                                                                                                            this.a.F0.R0().smoothScrollBy(i10, 500);
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.a.x0.R1().O() != null && this.a.x0.R1().O().getAuthor() != null) {
                                                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.R1().m()).param("obj_locate", 2).param("uid", this.a.x0.R1().O().getAuthor().getUserId()));
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091779 || id == R.id.obfuscated_res_0x7f09177a) {
                                                                                                    if (this.a.x0 == null || this.a.x0.R1() == null || this.a.x0.R1().l() == null || oi.isEmpty(this.a.x0.R1().l().getName())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    if (this.a.x0.getErrorNo() == 4) {
                                                                                                        if (!StringUtils.isNull(this.a.x0.q1()) || this.a.x0.g1() == null) {
                                                                                                            this.a.a.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        name = this.a.x0.g1().b;
                                                                                                    } else {
                                                                                                        name = this.a.x0.R1().l().getName();
                                                                                                    }
                                                                                                    if (StringUtils.isNull(name)) {
                                                                                                        this.a.a.finish();
                                                                                                        return;
                                                                                                    }
                                                                                                    String q1 = this.a.x0.q1();
                                                                                                    if (this.a.x0.w1() && q1 != null && q1.equals(name)) {
                                                                                                        this.a.a.finish();
                                                                                                    } else {
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.x0.R1().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                    }
                                                                                                    StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                                                    statisticItem6.param("tid", this.a.x0.j2());
                                                                                                    statisticItem6.param("fid", this.a.x0.getForumId());
                                                                                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    if (this.a.x0.R1().O() != null) {
                                                                                                        statisticItem6.param("nid", this.a.x0.R1().O().getNid());
                                                                                                    }
                                                                                                    TiebaStatic.log(statisticItem6);
                                                                                                } else if (id != R.id.obfuscated_res_0x7f090a40 && id != R.id.obfuscated_res_0x7f090a19 && id != R.id.obfuscated_res_0x7f090a1b && id != R.id.obfuscated_res_0x7f090a1a) {
                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                        if (this.a.x0 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                        statisticItem7.param("tid", this.a.x0.j2());
                                                                                                        statisticItem7.param("fid", this.a.x0.getForumId());
                                                                                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem7.param("obj_locate", 2);
                                                                                                        TiebaStatic.log(statisticItem7);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f0917a0) {
                                                                                                        if (this.a.x0 == null || this.a.x0.R1() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        jr7 R15 = this.a.x0.R1();
                                                                                                        if (this.a.C0 == null) {
                                                                                                            PbFragment pbFragment3 = this.a;
                                                                                                            pbFragment3.C0 = new bs7(pbFragment3.getPageContext());
                                                                                                        }
                                                                                                        long g = ng.g(R15.Q(), 0L);
                                                                                                        long g2 = ng.g(R15.m(), 0L);
                                                                                                        new StatisticItem("c13446").param("forum_id", g2).eventStat();
                                                                                                        PbFragment pbFragment4 = this.a;
                                                                                                        pbFragment4.registerListener(pbFragment4.l2);
                                                                                                        this.a.C0.a(g, g2);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f0917c3) {
                                                                                                        if (view2.getTag() instanceof SmartApp) {
                                                                                                            SmartApp smartApp = (SmartApp) view2.getTag();
                                                                                                            if (!pm5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                    return;
                                                                                                                }
                                                                                                                rl4.o(this.a.getActivity(), smartApp.h5_url);
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.x0.j2()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                        }
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090dea) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData = (ThreadData) view2.getTag();
                                                                                                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090de7) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                                                        if (this.a.R != null) {
                                                                                                            this.a.R.R(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                                                        }
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f09172e || id == R.id.obfuscated_res_0x7f091785) {
                                                                                                        StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                                                        statisticItem8.param("tid", this.a.x0.j2());
                                                                                                        statisticItem8.param("fid", this.a.x0.getForumId());
                                                                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem8.param("obj_locate", 7);
                                                                                                        TiebaStatic.log(statisticItem8);
                                                                                                        PbFragment pbFragment5 = this.a;
                                                                                                        pbFragment5.b = false;
                                                                                                        pbFragment5.g5(view2);
                                                                                                    }
                                                                                                } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                    return;
                                                                                                } else {
                                                                                                    ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                                                    if (this.a.x0.Q1() == 3 && this.a.v0() && this.a.x0.R1() != null && ListUtils.isEmpty(this.a.x0.R1().p())) {
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
                                                                                            }
                                                                                        } else {
                                                                                            this.a.F0.h.l();
                                                                                            this.a.F0.S3(this.a.D2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, ng.g(this.a.x0.R1().m(), 0L), ng.g(this.a.x0.j2(), 0L), ng.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.x0.R1().O().getPushStatusData())));
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        sparseArray = (SparseArray) view2.getTag();
                                                                                    } catch (ClassCastException e) {
                                                                                        e.printStackTrace();
                                                                                        sparseArray = null;
                                                                                    }
                                                                                    PostData postData4 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eed);
                                                                                    if (postData4 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.L0 == null) {
                                                                                        PbFragment pbFragment6 = this.a;
                                                                                        pbFragment6.L0 = new nr4(pbFragment6.getContext());
                                                                                        this.a.L0.n(this.a.f2);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.a.F().R1() != null && this.a.F().R1().g0();
                                                                                    if (view2 != null && sparseArray != null) {
                                                                                        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue() : false;
                                                                                        boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f44)).booleanValue() : false;
                                                                                        boolean booleanValue9 = sparseArray.get(R.id.obfuscated_res_0x7f091f30) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f30)).booleanValue() : false;
                                                                                        boolean booleanValue10 = sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f44)).booleanValue() : false;
                                                                                        boolean booleanValue11 = sparseArray.get(R.id.obfuscated_res_0x7f091f2e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f2e)).booleanValue() : false;
                                                                                        String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091efd) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091efd) : null;
                                                                                        boolean booleanValue12 = sparseArray.get(R.id.obfuscated_res_0x7f091f05) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f05)).booleanValue() : false;
                                                                                        if (postData4.p() != null) {
                                                                                            boolean z6 = postData4.p().hasAgree;
                                                                                            int r = postData4.r();
                                                                                            if (z6 && r == 5) {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0085;
                                                                                            } else {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0087;
                                                                                            }
                                                                                            jr4 jr4Var12 = new jr4(8, pbFragment.getString(i), this.a.L0);
                                                                                            SparseArray sparseArray11 = new SparseArray();
                                                                                            sparseArray11.put(R.id.obfuscated_res_0x7f091eed, postData4);
                                                                                            jr4Var12.d.setTag(sparseArray11);
                                                                                            arrayList2.add(jr4Var12);
                                                                                        }
                                                                                        if (this.a.mIsLogin) {
                                                                                            if (fx7.h(this.a.x0) || booleanValue9 || !booleanValue8) {
                                                                                                if ((this.a.o6(booleanValue7) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    jr4 jr4Var13 = new jr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fd6), this.a.L0);
                                                                                                    jr4Var13.d.setTag(str3);
                                                                                                    arrayList2.add(jr4Var13);
                                                                                                }
                                                                                            } else {
                                                                                                jr4 jr4Var14 = new jr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b23), this.a.L0);
                                                                                                SparseArray sparseArray12 = new SparseArray();
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091f44, Boolean.TRUE);
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091f04, sparseArray.get(R.id.obfuscated_res_0x7f091f04));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091f40, sparseArray.get(R.id.obfuscated_res_0x7f091f40));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091f41, sparseArray.get(R.id.obfuscated_res_0x7f091f41));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091f3f, sparseArray.get(R.id.obfuscated_res_0x7f091f3f));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091f42, sparseArray.get(R.id.obfuscated_res_0x7f091f42));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091f43, sparseArray.get(R.id.obfuscated_res_0x7f091f43));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ef0, sparseArray.get(R.id.obfuscated_res_0x7f091ef0));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ef1, sparseArray.get(R.id.obfuscated_res_0x7f091ef1));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091eef, sparseArray.get(R.id.obfuscated_res_0x7f091eef));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                                                                                                jr4Var14.d.setTag(sparseArray12);
                                                                                                arrayList2.add(jr4Var14);
                                                                                            }
                                                                                            if (booleanValue9) {
                                                                                                SparseArray sparseArray13 = new SparseArray();
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091f30, Boolean.TRUE);
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091efa, sparseArray.get(R.id.obfuscated_res_0x7f091efa));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091efb, sparseArray.get(R.id.obfuscated_res_0x7f091efb));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091efc, sparseArray.get(R.id.obfuscated_res_0x7f091efc));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091efd, str3);
                                                                                                if (booleanValue10) {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f44, Boolean.TRUE);
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f04, sparseArray.get(R.id.obfuscated_res_0x7f091f04));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f40, sparseArray.get(R.id.obfuscated_res_0x7f091f40));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f41, sparseArray.get(R.id.obfuscated_res_0x7f091f41));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f3f, sparseArray.get(R.id.obfuscated_res_0x7f091f3f));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f42, sparseArray.get(R.id.obfuscated_res_0x7f091f42));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f43, sparseArray.get(R.id.obfuscated_res_0x7f091f43));
                                                                                                } else {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f44, Boolean.FALSE);
                                                                                                }
                                                                                                if (booleanValue11) {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f2e, Boolean.TRUE);
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(booleanValue7));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091eef, sparseArray.get(R.id.obfuscated_res_0x7f091eef));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ef1, sparseArray.get(R.id.obfuscated_res_0x7f091ef1));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                                                                                                    if (booleanValue12) {
                                                                                                        jr4 jr4Var15 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f049f), this.a.L0);
                                                                                                        jr4Var15.d.setTag(sparseArray13);
                                                                                                        jr4Var2 = jr4Var15;
                                                                                                        jr4Var = new jr4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02df), this.a.L0);
                                                                                                        jr4Var.d.setTag(sparseArray13);
                                                                                                    }
                                                                                                } else {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091f2e, Boolean.FALSE);
                                                                                                }
                                                                                                jr4Var2 = null;
                                                                                                jr4Var = new jr4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02df), this.a.L0);
                                                                                                jr4Var.d.setTag(sparseArray13);
                                                                                            } else if (booleanValue11) {
                                                                                                SparseArray sparseArray14 = new SparseArray();
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091f30, Boolean.FALSE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091f44, Boolean.FALSE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091f2e, Boolean.TRUE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(booleanValue7));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091eef, sparseArray.get(R.id.obfuscated_res_0x7f091eef));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091ef1, sparseArray.get(R.id.obfuscated_res_0x7f091ef1));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                                                                                                if (this.a.x0.R1().V() == 1002 && !booleanValue7) {
                                                                                                    jr4Var3 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fd6), this.a.L0);
                                                                                                } else {
                                                                                                    jr4Var3 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f049f), this.a.L0);
                                                                                                }
                                                                                                jr4Var3.d.setTag(sparseArray14);
                                                                                                jr4Var2 = jr4Var3;
                                                                                                jr4Var = null;
                                                                                            } else {
                                                                                                jr4Var = null;
                                                                                                jr4Var2 = null;
                                                                                            }
                                                                                            if (jr4Var2 != null) {
                                                                                                arrayList2.add(jr4Var2);
                                                                                            }
                                                                                            if (jr4Var != null) {
                                                                                                arrayList2.add(jr4Var);
                                                                                            }
                                                                                        }
                                                                                        this.a.L0.j(arrayList2);
                                                                                        this.a.K0 = new lr4(this.a.getPageContext(), this.a.L0);
                                                                                        this.a.K0.m();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f0915cf) {
                                                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                                                    statisticItem10.param("tid", this.a.x0.j2());
                                                                                    statisticItem10.param("fid", this.a.x0.getForumId());
                                                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem10.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem10);
                                                                                }
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f09172c && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                    this.a.T = view2;
                                                                                    return;
                                                                                } else if (this.a.checkUpIsLogin()) {
                                                                                    if (this.a.x0 == null || this.a.x0.R1() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.a.F0.m0();
                                                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                                                    PostData postData5 = (PostData) sparseArray15.get(R.id.obfuscated_res_0x7f091f09);
                                                                                    PostData postData6 = (PostData) sparseArray15.get(R.id.obfuscated_res_0x7f091f0a);
                                                                                    View view3 = (View) sparseArray15.get(R.id.obfuscated_res_0x7f091f0b);
                                                                                    if (postData5 == null || view3 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (postData5.F() == 1) {
                                                                                        TiebaStatic.log(new StatisticItem("c12630"));
                                                                                    }
                                                                                    StatisticItem statisticItem11 = postData5.i0;
                                                                                    if (statisticItem11 != null) {
                                                                                        StatisticItem copy3 = statisticItem11.copy();
                                                                                        copy3.delete("obj_locate");
                                                                                        if (view2.getId() == R.id.obfuscated_res_0x7f0915cf) {
                                                                                            copy3.param("obj_locate", 6);
                                                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09172c) {
                                                                                            copy3.param("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(copy3);
                                                                                    }
                                                                                    String j22 = this.a.x0.j2();
                                                                                    String J2 = postData5.J();
                                                                                    String J3 = postData6 != null ? postData6.J() : "";
                                                                                    int V2 = this.a.x0.R1() != null ? this.a.x0.R1().V() : 0;
                                                                                    this.a.y7();
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091afd) {
                                                                                        AbsPbActivity.e J62 = this.a.J6(J2);
                                                                                        if (this.a.x0 == null || this.a.x0.R1() == null || J62 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(j22, J2, "pb", true, false, null, true, null, V2, postData5.V(), this.a.x0.R1().d(), false, postData5.s().getIconInfo(), 5).addBigImageData(J62.a, J62.b, J62.g, J62.j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.a.x0.Q1());
                                                                                        addBigImageData2.setFromFrsForumId(this.a.x0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.a.x0.o2());
                                                                                        addBigImageData2.setKeyFromForumId(this.a.x0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.a.x0.j1());
                                                                                        addBigImageData2.setTiebaPlusData(this.a.x0.J(), this.a.x0.F(), this.a.x0.G(), this.a.x0.E(), this.a.x0.K());
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e J63 = this.a.J6(J2);
                                                                                        if (postData5 == null || this.a.x0 == null || this.a.x0.R1() == null || J63 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(j22, J2, "pb", true, false, null, false, J3, V2, postData5.V(), this.a.x0.R1().d(), false, postData5.s().getIconInfo(), 5).addBigImageData(J63.a, J63.b, J63.g, J63.j);
                                                                                        if (!oi.isEmpty(J3)) {
                                                                                            addBigImageData3.setHighLightPostId(J3);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.a.x0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.a.x0.J(), this.a.x0.F(), this.a.x0.G(), this.a.x0.E(), this.a.x0.K());
                                                                                        addBigImageData3.setBjhData(this.a.x0.j1());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.a.x0.Q1());
                                                                                        addBigImageData3.setFromFrsForumId(this.a.x0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.a.x0.o2());
                                                                                        if (this.a.F0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.a.F0.I0(this.a.x0.G, this.a.x0.h2()).Q || postData5.Q);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.x0.R1().m()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (ni.z()) {
                                                                            SparseArray<Object> S02 = this.a.F0.S0(this.a.x0.R1(), this.a.x0.h2(), 1);
                                                                            if (S02 != null) {
                                                                                this.a.F0.u2(((Integer) S02.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) S02.get(R.id.obfuscated_res_0x7f091eef), ((Integer) S02.get(R.id.obfuscated_res_0x7f091f0c)).intValue(), ((Boolean) S02.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue());
                                                                            }
                                                                            this.a.F0.h.k();
                                                                            if (this.a.F() != null && this.a.F().R1() != null && this.a.F().R1().O() != null) {
                                                                                ThreadData O = this.a.F().R1().O();
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
                                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                                                                            return;
                                                                        }
                                                                    } else if (ni.z()) {
                                                                        this.a.F0.m0();
                                                                        SparseArray<Object> S03 = this.a.F0.S0(this.a.x0.R1(), this.a.x0.h2(), 1);
                                                                        if (S03 == null) {
                                                                            return;
                                                                        }
                                                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.R1().l().getId(), this.a.x0.R1().l().getName(), this.a.x0.R1().O().getId(), String.valueOf(this.a.x0.R1().U().getUserId()), (String) S03.get(R.id.obfuscated_res_0x7f091efa), (String) S03.get(R.id.obfuscated_res_0x7f091efb), (String) S03.get(R.id.obfuscated_res_0x7f091efd), (String) S03.get(R.id.obfuscated_res_0x7f091efc))));
                                                                    } else {
                                                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
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
                                                                    this.a.F0.h.l();
                                                                }
                                                            } else if (this.a.x0 == null || this.a.x0.R1() == null || this.a.x0.R1().O() == null) {
                                                                return;
                                                            } else {
                                                                this.a.F0.h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.a;
                                                                pbFragment7.X5(pbFragment7.x0.R1().O().getFirstPostId());
                                                            }
                                                        } else {
                                                            this.a.F0.m0();
                                                            if (ni.z()) {
                                                                if (this.a.i) {
                                                                    view2.setTag(Integer.valueOf(this.a.x0.f2()));
                                                                    return;
                                                                }
                                                                this.a.y7();
                                                                this.a.F0.q3();
                                                                lr4 lr4Var = new lr4(this.a.getPageContext());
                                                                if (this.a.x0.R1().f == null || this.a.x0.R1().f.size() <= 0) {
                                                                    strArr = new String[]{this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11c6), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11c7)};
                                                                } else {
                                                                    strArr = new String[this.a.x0.R1().f.size()];
                                                                    for (int i11 = 0; i11 < this.a.x0.R1().f.size(); i11++) {
                                                                        strArr[i11] = this.a.x0.R1().f.get(i11).sort_name + this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11c4);
                                                                    }
                                                                }
                                                                lr4Var.j(null, strArr, new a(this, lr4Var, view2));
                                                                lr4Var.m();
                                                            } else {
                                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.a.F0.m0();
                                                        if (this.a.F().R1().g != 2) {
                                                            if (this.a.x0.P1() != null) {
                                                                this.a.F0.Z3(this.a.x0.P1(), this.a.e2);
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0874);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.a.checkUpIsLogin()) || (R1 = this.a.x0.R1()) == null) {
                                                    return;
                                                } else {
                                                    ThreadData O2 = R1.O();
                                                    if (O2 != null && O2.getAuthor() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", R1.m()).param("obj_locate", 4).param("uid", O2.getAuthor().getUserId()));
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
                                                        statisticItem14.param("tid", this.a.x0.j2());
                                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem14.param("fid", this.a.x0.getForumId());
                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091d51) {
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
                                                            if (O2.getBaijiahaoData() != null && !oi.isEmpty(O2.getBaijiahaoData().oriUgcVid)) {
                                                                statisticItem14.param(TiebaStatic.Params.OBJ_PARAM6, O2.getBaijiahaoData().oriUgcVid);
                                                            }
                                                        }
                                                        if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem14.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.a.N() != null) {
                                                            u85.e(this.a.N(), statisticItem14);
                                                        }
                                                        if (this.a.F0 != null) {
                                                            statisticItem14.param("obj_param1", this.a.F0.N0());
                                                        }
                                                        TiebaStatic.log(statisticItem14);
                                                        if (pi.D()) {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2b);
                                                            return;
                                                        } else if (R1 != null) {
                                                            ArrayList<PostData> F2 = this.a.x0.R1().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.a.x0.h2()) {
                                                                this.a.F0.m0();
                                                                this.a.y7();
                                                                if (R1.A() != null && !StringUtils.isNull(R1.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.x0.R1().m()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.a.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.a.F0 != null) {
                                                                    this.a.F0.o0();
                                                                    this.a.F0.l4(R1);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.a.F0.L3();
                                                                    this.a.x0.l1().C(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09171d) {
                                                                        i6 = 2;
                                                                    } else {
                                                                        i6 = view2.getId() == R.id.obfuscated_res_0x7f091d51 ? 1 : 6;
                                                                    }
                                                                    if ((!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) || !this.a.F0.T1() || R1.j0()) {
                                                                        this.a.s7(i6);
                                                                    } else if (UbsABTestHelper.isPbSharePathTestA()) {
                                                                        this.a.s7(i6);
                                                                    } else if (iz4.c() > 0) {
                                                                        this.a.c7();
                                                                    } else {
                                                                        int N0 = this.a.F0.N0();
                                                                        this.a.F0.b0();
                                                                        this.a.b6(iz4.a(), N0);
                                                                    }
                                                                }
                                                            } else {
                                                                pi.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dc7));
                                                                return;
                                                            }
                                                        } else {
                                                            pi.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dc7));
                                                            return;
                                                        }
                                                    }
                                                    i5 = 1;
                                                    StatisticItem statisticItem142 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem142.param("tid", this.a.x0.j2());
                                                    statisticItem142.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem142.param("fid", this.a.x0.getForumId());
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091d51) {
                                                    }
                                                    statisticItem142.param("obj_name", i5);
                                                    statisticItem142.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.a.N() != null) {
                                                    }
                                                    if (this.a.F0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem142);
                                                    if (pi.D()) {
                                                    }
                                                }
                                            } else if (ni.z()) {
                                                this.a.F0.m0();
                                                if (this.a.F0.h.n() != null && view2 == this.a.F0.h.n().n() && !this.a.F0.R1()) {
                                                    this.a.F0.M2();
                                                }
                                                if (!this.a.i) {
                                                    this.a.y7();
                                                    this.a.F0.q3();
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0909c0) {
                                                        H3 = this.a.x0.H3(true, this.a.x5());
                                                    } else {
                                                        H3 = view2.getId() == R.id.obfuscated_res_0x7f091afa ? this.a.x0.H3(false, this.a.x5()) : this.a.x0.G3(this.a.x5());
                                                    }
                                                    view2.setTag(Boolean.valueOf(H3));
                                                    if (H3) {
                                                        i7 = 1;
                                                        this.a.F0.a3(true);
                                                        this.a.F0.V3();
                                                        this.a.i = true;
                                                        this.a.F0.e3(true);
                                                    } else {
                                                        i7 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                                } else {
                                                    view2.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                                                view2.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (ni.z()) {
                                            this.a.F0.m0();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091718 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.a5(11009) || this.a.x0.h1(this.a.F0.Q0()) == null) {
                                                    return;
                                                }
                                                this.a.x6();
                                                if (this.a.x0.R1() != null && this.a.x0.R1().O() != null && this.a.x0.R1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.R1().m()).param("obj_locate", 3).param("uid", this.a.x0.R1().O().getAuthor().getUserId()));
                                                }
                                                if (this.a.x0.R1().O() != null && this.a.x0.R1().O().getAuthor() != null && this.a.x0.R1().O().getAuthor().getUserId() != null && this.a.z0 != null) {
                                                    PbFragment pbFragment8 = this.a;
                                                    int R5 = pbFragment8.R5(pbFragment8.x0.R1());
                                                    ThreadData O3 = this.a.x0.R1().O();
                                                    if (O3.isBJHArticleThreadType()) {
                                                        i8 = 2;
                                                    } else if (O3.isBJHVideoThreadType()) {
                                                        i8 = 3;
                                                    } else if (O3.isBJHNormalThreadType()) {
                                                        i8 = 4;
                                                    } else {
                                                        i8 = O3.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.x0.b).param("obj_locate", 1).param("obj_id", this.a.x0.R1().O().getAuthor().getUserId()).param("obj_type", !this.a.z0.e()).param("obj_source", R5).param("obj_param1", i8));
                                                }
                                            } else {
                                                this.a.V = view2;
                                                return;
                                            }
                                        } else {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.a.x0.R1() != null && this.a.x0.R1().O() != null && this.a.x0.R1().O().isVideoThreadType() && this.a.x0.R1().O().getThreadVideoInfo() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.a.x0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.a.x0.q1()) || this.a.x0.g1() == null) {
                                                this.a.a.finish();
                                                return;
                                            }
                                            name2 = this.a.x0.g1().b;
                                        } else {
                                            name2 = this.a.x0.R1().l().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.a.a.finish();
                                            return;
                                        }
                                        String q12 = this.a.x0.q1();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.a.x0.w1() && q12 != null && q12.equals(name2)) {
                                            this.a.a.finish();
                                        } else {
                                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (ni.z()) {
                                    if (this.a.x0.R1() == null || this.a.A0.T()) {
                                        return;
                                    }
                                    this.a.F0.m0();
                                    int i13 = (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().r()) ? (this.a.F0.h.n() == null || view2 != this.a.F0.h.n().q()) ? view2 == this.a.F0.C0() ? 2 : 0 : this.a.x0.R1().O().getIs_good() == 1 ? 3 : 6 : this.a.x0.R1().O().getIs_top() == 1 ? 5 : 4;
                                    ForumData l = this.a.x0.R1().l();
                                    String name3 = l.getName();
                                    String id2 = l.getId();
                                    String id3 = this.a.x0.R1().O().getId();
                                    this.a.F0.e4();
                                    this.a.A0.X(id2, name3, id3, i13, this.a.F0.D0());
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                                    return;
                                }
                            } else {
                                this.a.F0.h.l();
                                if (this.a.x0 != null) {
                                    this.a.v1.f(this.a.x0.j2());
                                }
                                if (this.a.x0 == null || !this.a.x0.isPrivacy()) {
                                    this.a.v1.b();
                                    int i14 = (TbSingleton.getInstance().mCanCallFans || this.a.F() == null || this.a.F().R1() == null || this.a.F().R1().Q() == null || !this.a.F().R1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.a.F() != null && this.a.F().R1() != null) {
                                        this.a.v1.d(3, i14, this.a.F().R1().Q());
                                    }
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ef4);
                                    if (this.a.F() == null || this.a.F().R1() == null) {
                                        return;
                                    }
                                    this.a.v1.d(3, 3, this.a.F().R1().Q());
                                    return;
                                }
                            }
                        } else if (ni.z()) {
                            this.a.F0.m0();
                            this.a.y7();
                            this.a.F0.q3();
                            this.a.F0.L3();
                            if (this.a.F0.Z0() != null) {
                                this.a.F0.Z0().setVisibility(8);
                            }
                            this.a.x0.C3(1);
                            if (this.a.e != null) {
                                this.a.e.x();
                            }
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                            return;
                        }
                    } else {
                        String str4 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a3f);
                        String str5 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a2a);
                        String str6 = (String) view2.getTag(R.id.obfuscated_res_0x7f09203a);
                        if (this.a.R != null) {
                            this.a.R.R(str4, str5);
                        }
                        TbPageTag l2 = u85.l(this.a.getContext());
                        hx7.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l2 != null ? l2.locatePage : "");
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0db8).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091aed) {
                        String w5 = this.a.w5();
                        if (TextUtils.isEmpty(w5)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{w5});
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.x0.j2());
                statisticItem15.param("fid", this.a.x0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
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
                Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091eed);
                if (!(obj instanceof PostData)) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                PostData postData7 = (PostData) obj;
                if (this.a.x0 != null && this.a.x0.R1() != null && this.a.O5().a1() != null && postData7.s() != null && postData7.B() != 1) {
                    if (!this.a.checkUpIsLogin()) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    if (this.a.O5().b1() != null) {
                        this.a.O5().b1().c();
                    }
                    zr7 zr7Var2 = new zr7();
                    zr7Var2.A(this.a.x0.R1().l());
                    zr7Var2.E(this.a.x0.R1().O());
                    zr7Var2.C(postData7);
                    this.a.O5().a1().W(zr7Var2);
                    this.a.O5().a1().setPostId(postData7.J());
                    this.a.u6(view2, postData7.s().getUserId(), "", postData7);
                    TiebaStatic.log("c11743");
                    fy7.b(this.a.x0.R1(), postData7, postData7.h0, 8, 1);
                    if (this.a.U0 != null) {
                        this.a.F0.U2(this.a.U0.C());
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h2 implements k35 {
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

        @Override // com.repackage.k35
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qv7 qv7Var = this.a.J0;
                if (qv7Var == null || qv7Var.g() == null || !this.a.J0.g().d()) {
                    return !this.a.d5(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.J0.g().c());
                if (this.a.F0 != null && this.a.F0.b1() != null && this.a.F0.b1().b() != null && this.a.F0.b1().b().x()) {
                    this.a.F0.b1().b().v(this.a.J0.h());
                }
                this.a.J0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements jd5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbFragment c;

        public i(PbFragment pbFragment, int i, int i2) {
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
        @Override // com.repackage.jd5
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

    /* loaded from: classes3.dex */
    public class i0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public i0(PbFragment pbFragment, Intent intent) {
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
                nv7 nv7Var = this.b.F0;
                nv7Var.t3("@" + this.a.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i1(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.x0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.x0.b)) {
                this.a.r7((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ cr4 b;
        public final /* synthetic */ PbFragment c;

        public i2(PbFragment pbFragment, MarkData markData, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, cr4Var};
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
            this.b = cr4Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.F0 != null && this.c.F0.m1() != null) {
                    this.c.F0.m1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.z7();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PbFragment pbFragment, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.x0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.U0 != null) {
                this.a.F0.U2(this.a.U0.C());
            }
            this.a.F0.M2();
            this.a.F0.m0();
        }
    }

    /* loaded from: classes3.dex */
    public class j0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.U0.M(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.F0 != null && this.a.F0.b1() != null && this.a.F0.b1().b() != null) {
                    this.a.F0.b1().b().F();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.a;
                    pbFragment.S6(pbFragment.a1);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j1 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ j1 b;

            public a(j1 j1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = j1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.F0 == null || this.a == null) {
                    return;
                }
                this.b.a.F0.y2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(j1 j1Var) {
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
                    }
                }
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j1 a;

            public c(j1 j1Var) {
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

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public j1(PbFragment pbFragment) {
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, fy4 fy4Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, fy4Var, writeData, antiData}) == null) {
                if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.x0.R1() != null) {
                        statisticItem.param("fid", this.a.x0.R1().m());
                    }
                    statisticItem.param("tid", this.a.x0.j2());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (oi.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.y7();
                this.a.F0.o3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                boolean z2 = false;
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.U0.B() || this.a.U0.D()) {
                            this.a.U0.z(false, postWriteCallBackData);
                        }
                        this.a.J0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.X0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f046e), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        cr4 cr4Var = new cr4(this.a.getActivity());
                        if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                            cr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce1));
                        } else {
                            cr4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new b(this));
                        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ce3, new c(this));
                        cr4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (dp8.d(i) || fy4Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.d7(i, antiData, str);
                        return;
                    }
                }
                this.a.r7(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.e7(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.x0.u1()) {
                        jr7 R1 = this.a.x0.R1();
                        if (R1 != null && R1.O() != null && R1.O().getAuthor() != null && (userId = R1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.x0.F3()) {
                            this.a.F0.q3();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.x0.F3()) {
                        this.a.F0.q3();
                    }
                } else if (floor != null) {
                    this.a.F0.F1(this.a.x0.R1());
                }
                if (this.a.x0.y1()) {
                    TiebaStatic.log(new StatisticItem("c10369").param("tid", this.a.x0.j2()));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    qg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                PbFragment pbFragment = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                pbFragment.W4(z2);
                if (writeData != null) {
                    sv4.b(writeData.getContent(), "1");
                }
                if (this.a.h6()) {
                    this.a.B7();
                }
                this.a.p7();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j2 implements fg<ImageView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
                    if (zm4.c().g()) {
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
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = zm4.c().g();
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.a.x0.K3((UserPendantData) customResponsedMessage.getData());
                if (this.a.F0 != null && this.a.x0 != null) {
                    this.a.F0.F2(this.a.x0.R1(), this.a.x0.h2(), this.a.x0.b2(), this.a.F0.i1());
                }
                if (this.a.F0 == null || this.a.F0.A0() == null) {
                    return;
                }
                this.a.F0.A0().Y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k0 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public k0(PbFragment pbFragment) {
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
                this.a.F0.s1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.a.s7(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        es6.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2b);
                        }
                        this.a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k1 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ k1 b;

            public a(k1 k1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = k1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.F0 == null || this.a == null) {
                    return;
                }
                this.b.a.F0.y2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(k1 k1Var) {
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
                    }
                }
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k1 a;

            public c(k1 k1Var) {
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

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public k1(PbFragment pbFragment) {
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, fy4 fy4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, fy4Var, writeData, antiData}) == null) {
                if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.x0 != null && this.a.x0.R1() != null) {
                        statisticItem.param("fid", this.a.x0.R1().m());
                    }
                    if (this.a.x0 != null) {
                        statisticItem.param("tid", this.a.x0.j2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    qv7 qv7Var = this.a.J0;
                    if (qv7Var != null) {
                        qv7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        pz4.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        sv4.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        qg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.h6()) {
                        this.a.B7();
                    }
                    this.a.p7();
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.X0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f046e), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    cr4 cr4Var = new cr4(this.a.getActivity());
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        cr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce1));
                    } else {
                        cr4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new b(this));
                    cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ce3, new c(this));
                    cr4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.a;
                if (pbFragment.J0 == null) {
                    return;
                }
                if (pbFragment.F0 != null && this.a.F0.b1() != null && this.a.F0.b1().b() != null && this.a.F0.b1().b().x()) {
                    this.a.F0.b1().b().v(postWriteCallBackData);
                }
                this.a.J0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k2 implements fg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public k2(PbFragment pbFragment) {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
                if (zm4.c().g()) {
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
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = zm4.c().g();
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

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PbFragment pbFragment, int i) {
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
            if (this.a.F0 == null) {
                return;
            }
            if (booleanValue) {
                this.a.F0.V3();
            } else {
                this.a.F0.u1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l0 extends c9 {
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l1 implements l35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.repackage.l35
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l2 implements fg<TiebaPlusRecommendCard> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public l2(PbFragment pbFragment) {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.p();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.U0 != null) {
                this.a.F0.U2(this.a.U0.C());
            }
            this.a.F0.D3(false);
        }
    }

    /* loaded from: classes3.dex */
    public class m0 implements f3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.f3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!ni.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.R1().l().getId(), this.a.x0.R1().l().getName(), this.a.x0.R1().O().getId(), String.valueOf(this.a.x0.R1().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m1 extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m1(PbFragment pbFragment, int i, int i2) {
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

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView k1;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f13da);
                    if (this.a.F0 == null || (k1 = this.a.F0.k1()) == null || this.a.F0.R0() == null) {
                        return;
                    }
                    this.a.F0.R0().removeHeaderView(k1);
                    return;
                }
                pi.O(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m2 implements fg<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public m2(PbFragment pbFragment) {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.u0());
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            pq7 pq7Var = (pq7) customResponsedMessage.getData();
            int type = pq7Var.getType();
            if (type == 0) {
                this.a.N6((zr7) pq7Var.a());
            } else if (type == 1) {
                this.a.p5((ForumManageModel.b) pq7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (pq7Var.a() == null) {
                    this.a.M6(false, null);
                } else {
                    this.a.M6(true, (MarkData) pq7Var.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements nq7.d {
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

        @Override // com.repackage.nq7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n1 a;

            public a(n1 n1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = n1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || BreatheTipWidget.e() || this.a.a.getContext() == null) {
                    return;
                }
                nu4 nu4Var = new nu4();
                nu4Var.b = R.raw.obfuscated_res_0x7f110025;
                nu4Var.a = BreatheTipWidget.PointType.LOTTIE;
                nu4Var.c = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                ou4 ou4Var = new ou4();
                ou4Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f04f1);
                ou4Var.b = this.a.a.getString(R.string.obfuscated_res_0x7f0f00e6);
                ou4Var.e = R.drawable.pic_guidecard;
                ou4Var.f = pi.f(this.a.a.getContext(), R.dimen.tbds156);
                ou4Var.g = pi.f(this.a.a.getContext(), R.dimen.tbds489);
                ou4Var.h = pi.f(this.a.a.getContext(), R.dimen.tbds286);
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.F0.g1()));
                breatheTipWidget.f(ou4Var, nu4Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    xt4 k = xt4.k();
                    k.u("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    lz4.a("c14828");
                }
            }
        }

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
                p95 p95Var = new p95(i, z, responsedMessage, this.a.r, this.a.q, this.a.o, z2, 0L, 0L, j3);
                this.a.q = 0L;
                this.a.r = 0L;
                p95Var.c();
                if (z2) {
                    j2 = j3;
                    p95Var.B = j2;
                    p95Var.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || this.a.x0 == null || this.a.x0.R1() == null || this.a.x0.R1().O() == null) {
                    return;
                }
                int threadType = this.a.x0.R1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (!StringHelper.equals(this.a.M, "from_personalize")) {
                        if (StringHelper.equals(this.a.M, "from_frs")) {
                            p95 p95Var2 = new p95();
                            p95Var2.a(1000);
                            p95Var2.D = j2;
                            p95Var2.d(threadType);
                            return;
                        }
                        return;
                    }
                    l95 l95Var = new l95();
                    l95Var.F = 1;
                    l95Var.a(1005);
                    l95Var.D = j2;
                    l95Var.d(threadType);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(jr7 jr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jr7Var) == null) {
                this.a.F0.F1(jr7Var);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, jr7 jr7Var, String str, int i4) {
            q15 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jr7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906a0));
                }
                if (!z || jr7Var == null || jr7Var.W() != null || ListUtils.getCount(jr7Var.F()) >= 1) {
                    if (!this.a.n0) {
                        this.a.n0 = true;
                    } else if (this.a.F() != null) {
                        this.a.F().Y0();
                    }
                    this.a.h = true;
                    if (this.a.F0 == null) {
                        return;
                    }
                    this.a.F0.p3();
                    if (jr7Var == null || !jr7Var.m0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.F0.m1());
                    }
                    this.a.F0.u1();
                    if (this.a.J || this.a.F0.R1()) {
                        this.a.F0.o1();
                    } else if (!this.a.F0.K1()) {
                        this.a.F0.D3(false);
                    }
                    if (this.a.i) {
                        this.a.i = false;
                    }
                    if (i4 == 0 && jr7Var != null) {
                        this.a.N0 = true;
                    }
                    if (jr7Var != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.F0.m1());
                        this.a.F0.y3();
                    }
                    ArrayList<PostData> arrayList = null;
                    String e1 = null;
                    arrayList = null;
                    if (z && jr7Var != null) {
                        ThreadData O = jr7Var.O();
                        if (O != null && O.isUgcThreadType()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.Y6(pbFragment3.T0);
                        }
                        this.a.F0.b1().m(jr7Var);
                        this.a.F0.K3();
                        if (O != null && O.getCartoonThreadData() != null) {
                            this.a.F7(O.getCartoonThreadData());
                        }
                        if (this.a.U0 != null) {
                            this.a.F0.U2(this.a.U0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(jr7Var.U().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(jr7Var.U().getBimg_end_time());
                        if (jr7Var.F() != null && jr7Var.F().size() >= 1 && jr7Var.F().get(0) != null) {
                            this.a.x0.o3(jr7Var.F().get(0).J());
                        } else if (jr7Var.W() != null) {
                            this.a.x0.o3(jr7Var.W().J());
                        }
                        if (this.a.U0 != null) {
                            this.a.U0.N(jr7Var.d());
                            this.a.U0.O(jr7Var.l(), jr7Var.U());
                            this.a.U0.u0(O);
                            this.a.U0.P(this.a.x0.t1(), this.a.x0.j2(), this.a.x0.p1());
                            if (O != null) {
                                this.a.U0.j0(O.isMutiForumThread());
                            }
                        }
                        if (this.a.z0 != null) {
                            this.a.z0.h(jr7Var.r());
                        }
                        if (jr7Var.s() == 1) {
                            this.a.s = true;
                        } else {
                            this.a.s = false;
                        }
                        if (jr7Var.g0()) {
                            this.a.s = true;
                        }
                        this.a.F0.V2(this.a.s);
                        if (this.a.u0.f.size() > 0) {
                            jr7Var.L0(this.a.u0.f);
                        }
                        this.a.F0.O3(jr7Var, i2, i3, this.a.x0.h2(), i4, this.a.x0.A1());
                        this.a.F0.c4(jr7Var, this.a.x0.h2());
                        this.a.F0.h4(this.a.x0.u1());
                        AntiData d = jr7Var.d();
                        if (d != null) {
                            this.a.z = d.getVoice_message();
                            if (!StringUtils.isNull(this.a.z) && this.a.U0 != null && this.a.U0.a() != null && (m = this.a.U0.a().m(6)) != null && !TextUtils.isEmpty(this.a.z)) {
                                ((View) m).setOnClickListener(this.a.I1);
                            }
                        }
                        if (!this.a.Y && !ListUtils.isEmpty(this.a.x0.R1().F()) && !this.a.x0.A2()) {
                            this.a.Y = true;
                            this.a.Y4(false);
                        }
                        if (TextUtils.isEmpty(this.a.Q0)) {
                            if (this.a.P0) {
                                this.a.P0 = false;
                                iw7.g(this.a.getListView());
                            } else if (this.a.R0) {
                                this.a.R0 = false;
                                iw7.j(this.a.getListView());
                            } else if (!TextUtils.isEmpty(this.a.x0.H1())) {
                                iw7.f(this.a.getListView(), this.a.x0.H1());
                                this.a.x0.I2();
                            } else {
                                this.a.F0.J3();
                            }
                        } else {
                            iw7.i(this.a.x0.Q1(), this.a.getListView(), this.a.Q0);
                            this.a.Q0 = null;
                        }
                        this.a.x0.J2(jr7Var.l(), this.a.M1);
                        this.a.x0.P2(this.a.P1);
                        if (this.a.X0 != null && O != null && O.getAuthor() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.getAuthor());
                            this.a.X0.setLikeUserData(attentionHostData);
                        }
                        if (this.a.x0 == null || !this.a.x0.x2()) {
                            if (this.a.F0 != null) {
                                e1 = this.a.F0.e1();
                            }
                        } else {
                            e1 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dd7);
                        }
                        if (!StringUtils.isNull(e1)) {
                            this.a.U0.m0(TbSingleton.getInstance().getAdVertiComment(jr7Var.k0(), jr7Var.l0(), e1));
                        }
                    } else if (str != null) {
                        if (this.a.N0 || i4 != 1) {
                            this.a.showToast(str);
                        } else if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.x0.g1() != null && !StringUtils.isNull(this.a.x0.g1().c)) {
                                    this.a.F0.j4(this.a.x0.g1());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.F0.m1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2a, str, Integer.valueOf(i)), true);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(pi.f(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702ac));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.F0.m1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2a, str, Integer.valueOf(i)), true);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(pi.f(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702ac));
                            }
                            this.a.F0.o1();
                            this.a.F0.n1();
                        }
                        if (i == 4 || i == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.x0.j2());
                                jSONObject.put("fid", this.a.x0.getForumId());
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
                            if (this.a.x0 != null && this.a.x0.R1() != null) {
                                arrayList = this.a.x0.R1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).B() != 1)) {
                                this.a.F0.Q2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
                            } else {
                                if (this.a.j6()) {
                                    this.a.F0.R2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dc8));
                                } else {
                                    this.a.F0.R2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dc9));
                                }
                                this.a.F0.F1(this.a.x0.R1());
                            }
                        } else {
                            this.a.F0.Q2("");
                        }
                        this.a.F0.u0();
                    }
                    if (jr7Var != null && jr7Var.m && this.a.o == 0) {
                        this.a.o = System.currentTimeMillis() - this.a.n;
                    }
                    if (!this.a.F().h2() || this.a.F().R1().y().c() != 0 || this.a.F().u2()) {
                        this.a.V0 = true;
                    }
                    if (this.a.a instanceof PbActivity) {
                        ((PbActivity) this.a.a).k1(jr7Var != null ? jr7Var.g() : 0, this.a.F0);
                    }
                    e();
                    return;
                }
                this.a.x0.C3(1);
                if (this.a.e != null) {
                    this.a.e.x();
                }
                if (this.a.F0 != null) {
                    this.a.F0.W3();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.x0 == null) {
                return;
            }
            if (this.a.U0 == null || !this.a.U0.v) {
                m35 m35Var = new m35();
                this.a.Y6(m35Var);
                PbFragment pbFragment = this.a;
                pbFragment.U0 = (n35) m35Var.a(pbFragment.getContext());
                this.a.U0.f0(this.a.a.getPageContext());
                this.a.U0.p0(this.a.j2);
                this.a.U0.q0(this.a.b1);
                this.a.U0.F(this.a.a.getPageContext(), this.a.a.getIntent() == null ? null : this.a.a.getIntent().getExtras());
                this.a.U0.a().C(true);
                this.a.F0.P2(this.a.U0.a());
                if (!this.a.x0.E1()) {
                    this.a.U0.s(this.a.x0.j2());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.a.U0.m0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.a.x0.x2()) {
                    this.a.U0.m0(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dd7));
                } else if (this.a.F0 != null) {
                    this.a.U0.m0(this.a.F0.e1());
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                xt4 k = xt4.k();
                if (k.h("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    return;
                }
                qg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n2 implements fg<RelativeLayout> {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.F0 == null || this.a.F0.A0() == null) {
                return;
            }
            this.a.F0.A0().Y();
        }
    }

    /* loaded from: classes3.dex */
    public class o0 implements ls7.a {
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

        @Override // com.repackage.ls7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091b17) {
                            if (this.a.R6(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09172b) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f091f00) instanceof SparseArray) {
                                this.a.w7((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091f00));
                            }
                        } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.obfuscated_res_0x7f091784) {
                            if (this.a.F0.M1() && view2.getId() == R.id.obfuscated_res_0x7f091749) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f091f3d) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.obfuscated_res_0x7f091f3d)));
                                }
                                if (this.a.A0() != null && this.a.A0().b != null) {
                                    this.a.A0().b.onClick(view2);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.w7(sparseArray);
                        }
                    }
                    if (this.a.U0 != null) {
                        this.a.F0.U2(this.a.U0.C());
                    }
                    this.a.F0.M2();
                    this.a.F0.m0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    this.a.m5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class o1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o1(PbFragment pbFragment, int i) {
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
                this.a.E7();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o2 implements fg<ItemCardView> {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof sg5.a)) {
                sg5.a aVar = (sg5.a) customResponsedMessage.getData();
                sg5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p0 implements Handler.Callback {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.x0 != null && this.a.x0.C1()) {
                    this.a.v6();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class p1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p1(PbFragment pbFragment, int i, boolean z) {
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
                if (this.a.F0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.F0.m1());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.i(true);
                            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f031d));
                            bdTopToast.j((ViewGroup) this.a.getView());
                            this.a.Z6(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2b) : httpResponsedMessage.getErrorString();
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(string);
                        bdTopToast2.j((ViewGroup) this.a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p2 implements TbRichTextView.y {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            xt7 A0;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.F0.g2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.x0.j2());
                    statisticItem.param("fid", this.a.x0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view2.getTag(R.id.obfuscated_res_0x7f091f24) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091f24) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
                        if (this.a.x0.G.g0()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            TbRichTextView tbRichTextView = null;
                            if (view2.getParent() instanceof TbRichTextView) {
                                tbRichTextView = (TbRichTextView) view2.getParent();
                            } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                                tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                            }
                            int i3 = -1;
                            if (tbRichTextView == null || tbRichTextView.getRichText() == null || tbRichTextView.getRichText().E() == null) {
                                i2 = -1;
                            } else {
                                ArrayList<TbRichTextImageInfo> E = tbRichTextView.getRichText().E();
                                int i4 = 0;
                                int i5 = -1;
                                while (i4 < E.size()) {
                                    if (E.get(i4) != null) {
                                        arrayList.add(E.get(i4).G());
                                        if (i5 == i3 && str != null && (str.equals(E.get(i4).G()) || str.equals(E.get(i4).C()) || str.equals(E.get(i4).A()) || str.equals(E.get(i4).B()) || str.equals(E.get(i4).E()))) {
                                            i5 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = E.get(i4).G();
                                        imageUrlData.originalUrl = E.get(i4).G();
                                        imageUrlData.isLongPic = E.get(i4).J();
                                        concurrentHashMap.put(E.get(i4).G(), imageUrlData);
                                    }
                                    i4++;
                                    i3 = -1;
                                }
                                i2 = i5;
                            }
                            Rect rect = new Rect();
                            view2.getGlobalVisibleRect(rect);
                            this.a.r5(rect);
                            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                            builder.y(arrayList);
                            builder.C(i2);
                            builder.D(false);
                            builder.G(this.a.x0.c2());
                            builder.x(concurrentHashMap);
                            builder.I(true);
                            builder.L(false);
                            builder.H(this.a.j6());
                            builder.N(rect, UtilHelper.fixedDrawableRect(rect, view2));
                            if (this.a.x0 != null) {
                                builder.B(this.a.x0.getFromForumId());
                                if (this.a.x0.R1() != null) {
                                    builder.O(this.a.x0.R1().O());
                                }
                            }
                            ImageViewerConfig w = builder.w(this.a.getPageContext().getPageActivity());
                            w.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, w));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.H6(str, i, eVar);
                        if (eVar.h) {
                            TbRichText H7 = this.a.H7(str, i);
                            if (H7 != null && this.a.x2 >= 0 && this.a.x2 < H7.C().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = kr7.a(H7.C().get(this.a.x2));
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
                                if (H7.getPostId() != 0 && (A0 = this.a.F0.A0()) != null) {
                                    ArrayList<nn> s = A0.s();
                                    if (ListUtils.getCount(s) > 0) {
                                        Iterator<nn> it = s.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            nn next = it.next();
                                            if ((next instanceof PostData) && H7.getPostId() == ng.g(((PostData) next).J(), 0L)) {
                                                fy7.b(this.a.x0.R1(), (PostData) next, ((PostData) next).h0, H7.getPostId() == ng.g(this.a.x0.p1(), 0L) ? 1 : 8, 3);
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
                                this.a.r5(rect2);
                                ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                                builder2.y(arrayList2);
                                builder2.A(eVar.c);
                                builder2.z(eVar.d);
                                builder2.P(eVar.e);
                                builder2.D(eVar.g);
                                builder2.I(true);
                                builder2.K(eVar.i);
                                builder2.G(this.a.x0.c2());
                                builder2.x(concurrentHashMap2);
                                builder2.L(false);
                                builder2.H(this.a.j6());
                                builder2.M(eVar.f);
                                builder2.N(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                                if (this.a.x0 != null) {
                                    builder2.B(this.a.x0.getFromForumId());
                                    if (this.a.x0.R1() != null) {
                                        builder2.O(this.a.x0.R1().O());
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
                        builder3.G(this.a.x0.c2());
                        builder3.x(concurrentHashMap3);
                        builder3.L(false);
                        builder3.H(this.a.j6());
                        builder3.M(eVar.f);
                        builder3.E(false);
                        if (this.a.x0 != null) {
                            builder3.B(this.a.x0.getFromForumId());
                            if (this.a.x0.R1() != null) {
                                builder3.O(this.a.x0.R1().O());
                            }
                        }
                        ImageViewerConfig w3 = builder3.w(this.a.getPageContext().getPageActivity());
                        w3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, w3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091f24);
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.g) {
                return;
            }
            this.a.v7();
        }
    }

    /* loaded from: classes3.dex */
    public class q0 implements er4.c {
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

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.M0 = pbFragment.M0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.M0);
                    new st7(this.a.x0.j2(), this.a.M0, "1").start();
                    er4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.M0 = pbFragment2.M0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.M0);
                    new st7(this.a.x0.j2(), this.a.M0, "2").start();
                    er4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.M0 = pbFragment3.M0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.M0);
                    er4Var.e();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q1 implements jl4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public q1(PbFragment pbFragment) {
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

        @Override // com.repackage.jl4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.F0.p3();
                if (z) {
                    if (this.a.z0 != null) {
                        this.a.z0.h(z2);
                    }
                    this.a.x0.E3(z2);
                    if (this.a.x0.C1()) {
                        this.a.v6();
                    } else {
                        this.a.F0.F1(this.a.x0.R1());
                    }
                    if (z2) {
                        boolean j0 = this.a.x0.R1().j0();
                        if (this.a.z0 != null && !j0) {
                            if (this.a.z0.f() == null || this.a.x0 == null || this.a.x0.R1() == null || this.a.x0.R1().O() == null || this.a.x0.R1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.z0.f();
                            MetaData author = this.a.x0.R1().O().getAuthor();
                            if (f != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.l7(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d1);
                                    this.a.q7();
                                }
                            } else {
                                PbFragment pbFragment = this.a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d0));
                            }
                        }
                        this.a.U4();
                        return;
                    }
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fb3));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14d3));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q2 implements er4.c {
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

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                if (er4Var != null) {
                    er4Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.A2;
                if (postData != null) {
                    if (i == 0) {
                        postData.r0();
                        this.a.A2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.z6(pbFragment2.A2);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0cb1));
                bdTopToast.j((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.i1) {
                this.a.F0.s1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                jr7 R1 = this.a.x0.R1();
                if (R1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    R1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.h1.c(this.a.g1.getResources().getString(R.string.obfuscated_res_0x7f0f0b24));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.g1.getResources().getString(R.string.obfuscated_res_0x7f0f0b20);
                    }
                    this.a.t7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.m7();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (oi.isEmpty(errorString2)) {
                        errorString2 = this.a.g1.getResources().getString(R.string.obfuscated_res_0x7f0f0b21);
                    }
                    this.a.h1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r1 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public r1(PbFragment pbFragment, MetaData metaData) {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r2 implements er4.c {
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

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                if (er4Var != null) {
                    er4Var.e();
                }
                if (this.a.l1 == null || TextUtils.isEmpty(this.a.m1)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.o1 == null) {
                        this.a.V4();
                    } else {
                        m45.a aVar = new m45.a();
                        aVar.a = this.a.m1;
                        String str = "";
                        if (this.a.o1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.o1.memeInfo.pck_id;
                        }
                        aVar.b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (this.a.W0 == null) {
                        this.a.W0 = new PermissionJudgePolicy();
                    }
                    this.a.W0.clearRequestPermissionList();
                    this.a.W0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.W0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.a.k1 == null) {
                        PbFragment pbFragment = this.a;
                        pbFragment.k1 = new sv7(pbFragment.getPageContext());
                    }
                    this.a.k1.b(this.a.m1, this.a.l1.n());
                }
                this.a.l1 = null;
                this.a.m1 = null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (customResponsedMessage.getData() instanceof Boolean) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (error == 0 && booleanValue && TbadkCoreApplication.isLogin() && this.a.z0 != null && !this.a.z0.e()) {
                        this.a.x6();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.i1) {
                this.a.F0.s1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.h1.c(this.a.g1.getResources().getString(R.string.obfuscated_res_0x7f0f14ac));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (oi.isEmpty(muteMessage)) {
                    muteMessage = this.a.g1.getResources().getString(R.string.obfuscated_res_0x7f0f14ab);
                }
                this.a.h1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s1 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public s1(PbFragment pbFragment, MetaData metaData) {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                cr4Var.dismiss();
                this.b.B0.l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.x0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s2 implements e3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.e3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.F0 != null && this.a.F0.b1() != null) {
                    ju7 b1 = this.a.F0.b1();
                    if (b1.f()) {
                        b1.d();
                        return true;
                    }
                }
                if (this.a.F0 == null || !this.a.F0.U1()) {
                    return false;
                }
                this.a.F0.w1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class t implements TiePlusEventController.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public t(PbFragment pbFragment) {
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

    /* loaded from: classes3.dex */
    public class t0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t0(PbFragment pbFragment, int i) {
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
                if (!this.a.h6() || this.a.a == null || this.a.a.M0() == null || !str.equals(this.a.a.M0().getTopicId())) {
                    return;
                }
                this.a.C7(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public t1(PbFragment pbFragment) {
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
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) || this.a.x0 == null || this.a.x0.R1() == null || this.a.F0 == null || this.a.F0.A0() == null) {
                return;
            }
            this.a.F0.o2(absListView, i, i2, i3);
            if (this.a.e != null) {
                this.a.e.q(absListView, i, i2, i3);
            }
            if (!this.a.x0.B2() || (F = this.a.x0.R1().F()) == null || F.isEmpty()) {
                return;
            }
            int v = ((i + i2) - this.a.F0.A0().v()) - 1;
            jr7 R1 = this.a.x0.R1();
            if (R1 == null) {
                return;
            }
            if (R1.D() != null && R1.D().Q0()) {
                v--;
            }
            if (R1.E() != null && R1.E().Q0()) {
                v--;
            }
            int size = F.size();
            if (v < 0 || v >= size) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                PbFragment pbFragment = this.a;
                if (!pbFragment.n6(pbFragment.e1) && this.a.n6(i)) {
                    if (this.a.F0 != null) {
                        this.a.s0 = true;
                        this.a.F0.m0();
                        if (this.a.U0 != null && !this.a.F0.H1()) {
                            this.a.F0.U2(this.a.U0.C());
                        }
                        if (!this.a.J) {
                            this.a.s0 = true;
                            this.a.F0.M2();
                        }
                    }
                    if (!this.a.t) {
                        this.a.t = true;
                    }
                }
                if (this.a.F0 != null) {
                    this.a.F0.p2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.u == null) {
                    this.a.u = new j95();
                    this.a.u.a(1001);
                }
                if (i == 0) {
                    this.a.u.e();
                    if (this.a.o0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.o0);
                        this.a.o0 = null;
                    }
                } else {
                    if (this.a.o0 == null) {
                        this.a.o0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("pb", "1", "scroll");
                    }
                    this.a.u.d();
                }
                this.a.e1 = i;
                if (i == 0) {
                    this.a.U6(false, null);
                    pg8.g().h(this.a.getUniqueId(), true);
                    this.a.Y4(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t2 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.x0 == null || this.a.x0.a2() == i + 1) {
                return;
            }
            PbFragment pbFragment = this.a;
            pbFragment.W6(pbFragment.M5(i));
        }
    }

    /* loaded from: classes3.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public u(PbFragment pbFragment) {
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gp8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.i1) {
                gp8 gp8Var = (gp8) customResponsedMessage.getData();
                this.a.F0.s1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.f1;
                DataRes dataRes = gp8Var.a;
                if (gp8Var.c == 0 && dataRes != null) {
                    int e = ng.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (oi.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f3e, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f3e, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091f44, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f44, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091f00)).intValue();
                if (intValue == 0) {
                    this.a.n7(r3, sparseArray);
                } else if (intValue == 1) {
                    this.a.F0.v2(sparseArray, r3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u1 implements Comparator<d05> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d05 d05Var, d05 d05Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d05Var, d05Var2)) == null) ? d05Var.compareTo(d05Var2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class u2 implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.b = true;
                return pbFragment.g5(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof xo4)) {
                xo4 xo4Var = (xo4) customResponsedMessage.getData();
                qp4.a aVar = new qp4.a();
                int i = xo4Var.a;
                String str = xo4Var.b;
                aVar.a = xo4Var.d;
                jr7 R1 = this.a.x0.R1();
                if (R1 == null) {
                    return;
                }
                if (this.a.x0.t1() != null && this.a.x0.t1().getUserIdLong() == xo4Var.p) {
                    this.a.F0.E2(xo4Var.l, this.a.x0.R1(), this.a.x0.h2(), this.a.x0.b2());
                }
                if (R1.F() == null || R1.F().size() < 1 || R1.F().get(0) == null) {
                    return;
                }
                long g = ng.g(R1.F().get(0).J(), 0L);
                long g2 = ng.g(this.a.x0.j2(), 0L);
                if (g == xo4Var.n && g2 == xo4Var.m) {
                    qp4 I = R1.F().get(0).I();
                    if (I == null) {
                        I = new qp4();
                    }
                    ArrayList<qp4.a> a = I.a();
                    if (a == null) {
                        a = new ArrayList<>();
                    }
                    a.add(0, aVar);
                    I.e(I.b() + xo4Var.l);
                    I.d(a);
                    R1.F().get(0).w0(I);
                    this.a.F0.A0().Y();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.F0.H1() && (customResponsedMessage.getData() instanceof MotionEvent)) {
                MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
                this.a.m5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public v1(PbFragment pbFragment) {
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
        public void onNavigationButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view2, (ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(PbFragment pbFragment, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.x0 == null || this.a.x0.R1() == null) {
                return;
            }
            this.a.x0.R1().a();
            this.a.x0.s2();
            if (this.a.F0.A0() != null) {
                this.a.F0.F1(this.a.x0.R1());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
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
            ei8 ei8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ei8) || (ei8Var = (ei8) customResponsedMessage.getData()) == null || (agreeData = ei8Var.b) == null) {
                return;
            }
            if (this.a.F0 != null) {
                this.a.F0.c2(ei8Var);
            }
            if (agreeData.agreeType != 2 || this.a.F0 == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || gx7.k(this.a.x0.b)) {
                return;
            }
            this.a.F0.Y3();
            gx7.b(this.a.x0.b);
        }
    }

    /* loaded from: classes3.dex */
    public class w1 implements k35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public w1(PbFragment pbFragment) {
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

        @Override // com.repackage.k35
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qv7 qv7Var = this.a.J0;
                if (qv7Var == null || qv7Var.e() == null || !this.a.J0.e().d()) {
                    return !this.a.d5(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.J0.e().c());
                if (this.a.U0 != null && (this.a.U0.B() || this.a.U0.D())) {
                    this.a.U0.z(false, this.a.J0.h());
                }
                this.a.J0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class w2 implements ItemCardHelper.c {
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.x0 == null || this.a.x0.R1() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.a.i5(str);
            this.a.x0.s2();
            if (!TextUtils.isEmpty(str) && this.a.x0.R1().F() != null) {
                ArrayList<PostData> F = this.a.x0.R1().F();
                ni8 ni8Var = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof ni8) {
                        ni8 ni8Var2 = (ni8) next;
                        if (str.equals(ni8Var2.R0())) {
                            ni8Var = ni8Var2;
                            break;
                        }
                    }
                }
                if (ni8Var != null) {
                    F.remove(ni8Var);
                    if (this.a.F0.A0() != null && this.a.F0.A0().s() != null) {
                        this.a.F0.A0().s().remove(ni8Var);
                    }
                    if (this.a.F0.R0() != null && this.a.F0.R0().getData() != null) {
                        this.a.F0.R0().getData().remove(ni8Var);
                    }
                    if (this.a.F0.A0() != null) {
                        this.a.F0.A0().Y();
                        return;
                    }
                }
            }
            if (this.a.F0.A0() != null) {
                this.a.F0.F1(this.a.x0.R1());
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            this.a.p1 = true;
        }
    }

    /* loaded from: classes3.dex */
    public class x1 extends c9 {
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.a.A0.getLoadDataMode()) {
                        case 0:
                            this.a.x0.s2();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.p5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.F0.w0(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.a;
                            pbFragment.q5(pbFragment.A0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.a.F0.w0(this.a.A0.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.F0.q2(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                this.a.F0.w0(this.a.A0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x2 implements NoNetworkView.b {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.g && z && !this.a.x0.G1()) {
                    this.a.O6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(pi.f(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702ac));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public y(PbFragment pbFragment) {
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
        public void a(mw7 mw7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, mw7Var) == null) || mw7Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, mw7Var.c()));
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public y0(PbFragment pbFragment) {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.Z5();
                op4 P1 = this.a.x0.P1();
                int Y0 = this.a.F0.Y0();
                if (Y0 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0dcb);
                } else if (P1 == null || Y0 <= P1.h()) {
                    this.a.F0.m0();
                    this.a.y7();
                    this.a.F0.q3();
                    if (ni.z()) {
                        this.a.x0.C3(this.a.F0.Y0());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2b);
                    }
                    cr4Var.dismiss();
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0dcb);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y1 implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) || cr4Var == null) {
                return;
            }
            cr4Var.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class y2 implements fg<LinearLayout> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f09179f);
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.a.F0 == null || this.a.x0 == null) {
                return;
            }
            this.a.F0.g0(false);
            if (this.a.x0.K2(false)) {
                this.a.F0.r3();
            } else if (this.a.x0.R1() != null) {
                this.a.F0.H2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public z0(PbFragment pbFragment) {
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

        @Override // com.repackage.nr4.e
        public void N(nr4 nr4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                if (this.a.K0 != null) {
                    this.a.K0.dismiss();
                }
                this.a.D7(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091711);
                        this.a.K6(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091710);
                        this.a.K6(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091713);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.K6(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091713);
                        if (view6 != null) {
                            this.a.K6(view6);
                            AgreeView agreeView2 = (AgreeView) view6;
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
                        if (this.a.l1 == null || TextUtils.isEmpty(this.a.m1)) {
                            return;
                        }
                        if (this.a.o1 == null) {
                            this.a.V4();
                        } else {
                            m45.a aVar = new m45.a();
                            aVar.a = this.a.m1;
                            String str = "";
                            if (this.a.o1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.o1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.a.l1 = null;
                        this.a.m1 = null;
                        return;
                    case 2:
                        if (this.a.l1 == null || TextUtils.isEmpty(this.a.m1)) {
                            return;
                        }
                        if (this.a.W0 == null) {
                            this.a.W0 = new PermissionJudgePolicy();
                        }
                        this.a.W0.clearRequestPermissionList();
                        this.a.W0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.W0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.k1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.k1 = new sv7(pbFragment.getPageContext());
                        }
                        this.a.k1.b(this.a.m1, this.a.l1.n());
                        this.a.l1 = null;
                        this.a.m1 = null;
                        return;
                    case 3:
                        PostData postData = this.a.A2;
                        if (postData != null) {
                            postData.r0();
                            this.a.A2 = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            this.a.y6(view2);
                            if (this.a.x0.R1().O() == null || this.a.x0.R1().O().getAuthor() == null || this.a.x0.R1().O().getAuthor().getUserId() == null || this.a.z0 == null) {
                                return;
                            }
                            PbFragment pbFragment2 = this.a;
                            int R5 = pbFragment2.R5(pbFragment2.x0.R1());
                            ThreadData O = this.a.x0.R1().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.x0.b).param("obj_locate", 2).param("obj_id", this.a.x0.R1().O().getAuthor().getUserId()).param("obj_type", !this.a.z0.e()).param("obj_source", R5).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!ni.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                            return;
                        }
                        Object tag = view2.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.X5((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091f44)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091f00, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091ee9, 2);
                                this.a.b5(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091ef1) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091eef) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091f0c) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f091f01) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091f0c)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091f01)).booleanValue();
                            boolean G = this.a.N().G(TbadkCoreApplication.getCurrentAccount());
                            if (G) {
                                if (!booleanValue2) {
                                    this.a.g7(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.F0.t2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091eef), intValue, booleanValue, null, G);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.g7(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.F0.r2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091eef), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!ni.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f30)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f2e)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f44)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091f05) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f05)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.F0.r2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091eef), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091f0c)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue());
                                return;
                            }
                            return;
                        } else if (!booleanValue5) {
                            if (booleanValue6) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091ee9, 2);
                            }
                            this.a.F0.w2(view2);
                            return;
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091f00, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091ee9, 2);
                            this.a.b5(sparseArray4);
                            return;
                        }
                    case 8:
                        if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eed);
                            if (postData2.p() == null) {
                                return;
                            }
                            this.a.e5(postData2.p());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.a.checkUpIsLogin() || this.a.x0 == null || this.a.x0.R1() == null) {
                            return;
                        }
                        this.a.a.c1(dp8.c(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z1 implements g3 {
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
    }

    /* loaded from: classes3.dex */
    public class z2 implements View.OnTouchListener {
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
        P2 = new a1();
        Q2 = new b3();
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
        this.h0 = -1;
        this.i0 = -1;
        this.k0 = BdUniqueId.gen();
        this.m0 = false;
        this.q0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.t0 = new t(this);
        this.v0 = new e0(this);
        this.w0 = new Handler(new p0(this));
        this.x0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = false;
        this.H0 = false;
        this.I0 = false;
        this.N0 = false;
        this.P0 = false;
        this.R0 = false;
        this.b1 = new l1(this);
        this.c1 = new w1(this);
        this.d1 = new h2(this);
        this.e1 = 0;
        this.p1 = false;
        this.q1 = 0;
        this.r1 = -1;
        this.t1 = 0;
        this.w1 = new s2(this);
        this.x1 = new d3(this);
        this.y1 = new j(this, 2004016);
        this.z1 = new k(this, 2016485);
        this.A1 = new l(this, 2001269);
        this.B1 = new m(this, 2004008);
        this.C1 = new n(this, 2004007);
        this.D1 = new o(this, 2004005);
        this.E1 = new p(this, 2001332);
        this.F1 = new q(this, 2921391);
        this.G1 = new r(this, 2921606);
        this.H1 = new s(this, 2921658);
        this.I1 = new u(this);
        this.J1 = new v(this, 2001369);
        this.K1 = new w(this, 2016488);
        this.L1 = new x(this, 2016331);
        this.M1 = new y(this);
        this.N1 = new z(this, 2921509);
        this.O1 = new a0(this, 2010045);
        this.P1 = new b0(this);
        this.R1 = new PraiseModel(getPageContext(), new c0(this));
        this.S1 = new d0(this);
        this.T1 = new g0(this, 2001115);
        this.U1 = new h0(this);
        this.V1 = new k0(this);
        this.W1 = new ls7(new o0(this));
        this.X1 = new r0(this, 2001427);
        this.Y1 = new s0(this, 2001428);
        this.Z1 = new t0(this, 2921634);
        this.a2 = new u0(this, 2001426);
        this.b2 = new v0(this, 2004021);
        this.c2 = new w0(this, 2016528);
        this.d2 = new x0(this, 2921033);
        this.e2 = new y0(this);
        this.f2 = new z0(this);
        this.g2 = new e1(this);
        this.h2 = new h1(this);
        this.i2 = new i1(this, 2921480);
        this.j2 = new j1(this);
        this.k2 = new k1(this);
        this.l2 = new m1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.m2 = new n1(this);
        this.n2 = new o1(this, 2016450);
        this.o2 = new p1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.p2 = new q1(this);
        this.q2 = new t1(this);
        this.r2 = new x1(this);
        this.s2 = new z1(this);
        this.t2 = new a2(this);
        this.u2 = new b2(this);
        this.w2 = new c2(this);
        this.x2 = 0;
        this.y2 = new p2(this);
        this.z2 = false;
        this.A2 = null;
        this.B2 = new q2(this);
        this.C2 = new r2(this);
        this.D2 = new t2(this);
        this.E2 = new u2(this);
        this.F2 = new v2(this);
        this.G2 = new w2(this);
        this.H2 = new x2(this);
        this.I2 = new z2(this);
        this.J2 = new a3(this);
        this.K2 = new c3(this);
        this.L2 = -1;
        this.M2 = -1;
    }

    public static PbFragment B6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    @Override // com.repackage.vg5
    public eg<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.F == null) {
                this.F = new eg<>(new y2(this), 15, 0);
            }
            return this.F;
        }
        return (eg) invokeV.objValue;
    }

    public rw7 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.A0() : (rw7) invokeV.objValue;
    }

    public PbInterviewStatusView.f A5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.v0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public final boolean A6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q3 = xt4.k().q("bubble_link", "");
                if (StringUtils.isNull(q3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    rl4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0533), q3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean A7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.R1() == null || !this.x0.R1().g0()) {
                if (this.x0.C1()) {
                    MarkData n12 = this.x0.n1();
                    if (n12 != null && this.x0.A1()) {
                        MarkData h12 = this.x0.h1(this.F0.H0());
                        if (h12 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", n12);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (h12.getPostId() != null && !h12.getPostId().equals(n12.getPostId())) {
                            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
                            cr4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0261));
                            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0427, new f2(this, h12, n12, cr4Var));
                            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new g2(this, n12, cr4Var));
                            cr4Var.setOnCalcelListener(new i2(this, n12, cr4Var));
                            cr4Var.create(getPageContext());
                            cr4Var.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", n12);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.x0.R1() != null && this.x0.R1().F() != null && this.x0.R1().F().size() > 0 && this.x0.A1()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean B5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return false;
            }
            return tbRichTextData.G().J();
        }
        return invokeL.booleanValue;
    }

    public final void B7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (absPbActivity = this.a) == null || absPbActivity.M0() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.M0().j2()).param("topic_id", this.a.M0().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.M0().n2()));
    }

    public boolean C5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (!this.c && this.L2 == -1 && this.M2 == -1) ? false : true : invokeV.booleanValue;
    }

    public void C6() {
        List<e3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.s1) == null || list.isEmpty()) {
            return;
        }
        int size = this.s1.size();
        while (true) {
            size--;
            if (size <= -1 || this.s1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    public final void C7(boolean z3) {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z3) == null) || (absPbActivity = this.a) == null || absPbActivity.M0() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(!z3 ? "c14397" : "c14398").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.M0().j2()).param("topic_id", this.a.M0().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.M0().n2()));
    }

    @Override // com.repackage.qy7
    public PbModel.h D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m2 : (PbModel.h) invokeV.objValue;
    }

    public final boolean D5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return false;
            }
            return tbRichTextData.G().K();
        }
        return invokeL.booleanValue;
    }

    public boolean D6(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        nv7 nv7Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i3, keyEvent)) == null) ? (keyEvent == null || (nv7Var = this.F0) == null || !nv7Var.h2(i3)) ? false : true : invokeIL.booleanValue;
    }

    public final void D7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.x0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(fx7.m(i3))));
        }
    }

    @Override // com.repackage.vg5
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            nv7 nv7Var = this.F0;
            if (nv7Var == null) {
                return 0;
            }
            return nv7Var.g1();
        }
        return invokeV.intValue;
    }

    public boolean E5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.K : invokeV.booleanValue;
    }

    public final void E6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!ni.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c2c);
                return;
            }
            this.F0.m0();
            if (this.i) {
                return;
            }
            y7();
            this.F0.q3();
            if (this.x0.loadData()) {
                this.F0.V3();
            }
        }
    }

    public final void E7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.F(this.x0.getForumId()) && this.x0.R1() != null && this.x0.R1().l() != null) {
            if (this.x0.R1().l().isLike() == 1) {
                this.x0.e1().E(this.x0.getForumId(), this.x0.j2());
            }
        }
    }

    @Override // com.repackage.qy7
    public PbModel F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.x0 : (PbModel) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.vg5
    /* renamed from: F5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            nv7 nv7Var = this.F0;
            if (nv7Var == null) {
                return null;
            }
            return nv7Var.R0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void F6() {
        PbModel pbModel;
        jr7 R1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (pbModel = this.x0) == null || pbModel.R1() == null || (O = (R1 = this.x0.R1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.F0.q1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        zu7 zu7Var = new zu7();
        int V = this.x0.R1().V();
        if (V != 1 && V != 3) {
            zu7Var.g = false;
        } else {
            zu7Var.g = true;
            zu7Var.s = O.getIs_top() == 1;
        }
        if (l6(V)) {
            zu7Var.h = true;
            zu7Var.r = O.getIs_good() == 1;
        } else {
            zu7Var.h = false;
        }
        if (V == 1002 && !equals) {
            zu7Var.u = true;
        }
        zu7Var.n = j7(O.isBlocked(), R1.i0(), equals, V, O.isWorksInfo(), O.isScoreThread());
        zu7Var.e = h7(equals, R1.i0());
        zu7Var.i = k7();
        zu7Var.f = i7(equals);
        zu7Var.k = equals && R1.U() != null && R1.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            zu7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        zu7Var.t = equals;
        zu7Var.q = this.x0.h2();
        zu7Var.b = true;
        zu7Var.a = o6(equals);
        if (equals) {
            this.F0.G1();
        }
        zu7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        zu7Var.j = true;
        zu7Var.o = this.x0.u1();
        zu7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            zu7Var.c = true;
        } else {
            zu7Var.c = false;
        }
        if (R1.g0()) {
            zu7Var.b = false;
            zu7Var.d = false;
            zu7Var.c = false;
            zu7Var.g = false;
            zu7Var.h = false;
        }
        zu7Var.v = TbSingleton.getInstance().mShowCallFans && equals && !R1.g0();
        nv7 nv7Var = this.F0;
        if (nv7Var != null) {
            PbModel pbModel2 = this.x0;
            PostData I0 = nv7Var.I0(pbModel2.G, pbModel2.h2());
            zu7Var.w = I0 != null ? I0.Q : false;
        }
        zu7Var.m = true;
        if (O.isBlocked()) {
            zu7Var.n = false;
            zu7Var.g = false;
            zu7Var.h = false;
        }
        this.F0.h.E(zu7Var);
    }

    public final void F7(io4 io4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, io4Var) == null) || io4Var == null) {
            return;
        }
        this.O2 = io4Var;
        this.c = true;
        this.F0.J2();
        this.F0.d3(this.N2);
    }

    public int G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.M2 : invokeV.intValue;
    }

    public void G6() {
        mz4 mz4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (mz4Var = this.r0) == null) {
            return;
        }
        mz4Var.q();
    }

    public final void G7(int i3) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i3) == null) || (pbModel = this.x0) == null || pbModel.R1() == null || (O = this.x0.R1().O()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData praise = O.getPraise();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (praise == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i3);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    O.setPraise(praiseData);
                } else {
                    O.getPraise().getUser().add(0, metaData);
                    O.getPraise().setNum(O.getPraise().getNum() + 1);
                    O.getPraise().setIsLike(i3);
                }
            }
            if (O.getPraise() != null) {
                if (O.getPraise().getNum() < 1) {
                    getResources().getString(R.string.obfuscated_res_0x7f0f1638);
                } else {
                    StringHelper.numFormatOver10000(O.getPraise().getNum());
                }
            }
        } else if (O.getPraise() != null) {
            O.getPraise().setIsLike(i3);
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
                getResources().getString(R.string.obfuscated_res_0x7f0f1638);
            } else {
                String str = O.getPraise().getNum() + "";
            }
        }
        if (this.x0.h2()) {
            this.F0.A0().Y();
        } else {
            this.F0.o4(this.x0.R1());
        }
    }

    @Override // com.repackage.vg5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.w = true;
        }
    }

    public int H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.L2 : invokeV.intValue;
    }

    public final void H6(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048604, this, str, i3, eVar) == null) || eVar == null) {
            return;
        }
        jr7 R1 = this.x0.R1();
        TbRichText H7 = H7(str, i3);
        if (H7 == null || (tbRichTextData = H7.C().get(this.x2)) == null) {
            return;
        }
        eVar.f = String.valueOf(H7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.G().I()) {
            eVar.h = false;
            String a4 = kr7.a(tbRichTextData);
            eVar.a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.s ? 17 : 18;
            }
            imageUrlData.originalUrl = I5(tbRichTextData);
            imageUrlData.originalUrl = I5(tbRichTextData);
            imageUrlData.originalSize = J5(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = D5(tbRichTextData);
            imageUrlData.isLongPic = B5(tbRichTextData);
            imageUrlData.postId = H7.getPostId();
            imageUrlData.mIsReserver = this.x0.c2();
            imageUrlData.mIsSeeHost = this.x0.u1();
            eVar.b.put(a4, imageUrlData);
            if (R1 != null) {
                if (R1.l() != null) {
                    eVar.c = R1.l().getName();
                    eVar.d = R1.l().getId();
                }
                if (R1.O() != null) {
                    eVar.e = R1.O().getId();
                }
                eVar.g = R1.s() == 1;
            }
            imageUrlData.threadId = ng.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = R1.F().size();
        this.z2 = false;
        eVar.j = -1;
        int z5 = R1.j() != null ? z5(R1.j().Q(), H7, i3, i3, eVar.a, eVar.b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = R1.F().get(i4);
            if (postData.J() == null || R1.j() == null || R1.j().J() == null || !postData.J().equals(R1.j().J())) {
                z5 = z5(postData.Q(), H7, z5, i3, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (R1 != null) {
            if (R1.l() != null) {
                eVar.c = R1.l().getName();
                eVar.d = R1.l().getId();
            }
            if (R1.O() != null) {
                eVar.e = R1.O().getId();
            }
            eVar.g = R1.s() == 1;
        }
        eVar.j = z5;
    }

    public final TbRichText H7(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, str, i3)) == null) {
            PbModel pbModel = this.x0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.R1() == null || str == null || i3 < 0) {
                return null;
            }
            jr7 R1 = this.x0.R1();
            if (R1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(R1.j());
                tbRichText = y5(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = R1.F();
                X4(R1, F);
                return y5(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public eg<TbImageView> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.B == null) {
                this.B = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.B;
        }
        return (eg) invokeV.objValue;
    }

    public final String I5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return null;
            }
            return tbRichTextData.G().E();
        }
        return (String) invokeL.objValue;
    }

    public void I6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.R1() != null && this.x0.R1().l() != null) {
                if (Z4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.x0.R1().g0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.F0.f0();
                    return;
                } else {
                    if (this.Y0 == null) {
                        xm6 xm6Var = new xm6(getPageContext());
                        this.Y0 = xm6Var;
                        xm6Var.j(0);
                        this.Y0.i(new d1(this));
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.Y0.g(this.x0.R1().l().getId(), ng.g(this.x0.j2(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    @Override // com.repackage.vg5
    public void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, context, str) == null) {
            tv7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.w = true;
        }
    }

    public final long J5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return 0L;
            }
            return tbRichTextData.G().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final AbsPbActivity.e J6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            String str2 = null;
            if (this.x0.R1() != null && this.x0.R1().F() != null && this.x0.R1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.x0.R1().F().size()) {
                        i3 = 0;
                        break;
                    } else if (str.equals(this.x0.R1().F().get(i3).J())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                PostData postData = this.x0.R1().F().get(i3);
                if (postData.Q() != null && postData.Q().C() != null) {
                    Iterator<TbRichTextData> it = postData.Q().C().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.G() != null) {
                                str2 = next.G().C();
                            }
                        }
                    }
                    H6(str2, 0, eVar);
                    kr7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public n35 K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.U0 : (n35) invokeV.objValue;
    }

    public final void K6(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f0917a9, Integer.valueOf(this.b ? 2 : 3));
        view2.setTag(sparseArray);
    }

    public sw7 L5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.e : (sw7) invokeV.objValue;
    }

    public void L6(zr7 zr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, zr7Var) == null) {
            String J = zr7Var.i().J();
            List<PostData> list = this.x0.R1().T().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i3);
                if (postData.J() == null || !postData.J().equals(J)) {
                    i3++;
                } else {
                    ArrayList<PostData> k3 = zr7Var.k();
                    postData.G0(zr7Var.m());
                    if (postData.S() != null) {
                        postData.S().clear();
                        postData.S().addAll(k3);
                    }
                }
            }
            if (this.x0.A1()) {
                return;
            }
            this.F0.F1(this.x0.R1());
        }
    }

    @Override // com.repackage.vg5
    public eg<RelativeLayout> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            eg<RelativeLayout> egVar = new eg<>(new n2(this), 10, 0);
            this.G = egVar;
            return egVar;
        }
        return (eg) invokeV.objValue;
    }

    public final int M5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i3)) == null) {
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

    public void M6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048618, this, z3, markData) == null) {
            this.F0.p3();
            this.x0.E3(z3);
            jl4 jl4Var = this.z0;
            if (jl4Var != null) {
                jl4Var.h(z3);
                if (markData != null) {
                    this.z0.i(markData);
                }
            }
            if (this.x0.C1()) {
                v6();
            } else {
                this.F0.F1(this.x0.R1());
            }
        }
    }

    @Override // com.repackage.qy7
    public AbsPbActivity N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public dx7 N5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.u0 : (dx7) invokeV.objValue;
    }

    public void N6(zr7 zr7Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, zr7Var) == null) || zr7Var.i() == null) {
            return;
        }
        String J = zr7Var.i().J();
        ArrayList<PostData> F = this.x0.R1().F();
        int i3 = 0;
        while (true) {
            if (i3 >= F.size()) {
                break;
            }
            PostData postData = F.get(i3);
            if (postData.J() == null || !postData.J().equals(J)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = zr7Var.k();
                postData.G0(zr7Var.m());
                if (postData.S() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.Z() != null && next != null && next.s() != null && (metaData = postData.Z().get(next.s().getUserId())) != null) {
                            next.q0(metaData);
                            next.A0(true);
                            next.N0(getPageContext(), this.x0.H2(metaData.getUserId()));
                        }
                    }
                    z3 = k3.size() != postData.S().size();
                    if (!postData.f0(false)) {
                        postData.S().clear();
                        postData.S().addAll(k3);
                    }
                }
                if (postData.y() != null) {
                    postData.o0();
                }
            }
        }
        if (!this.x0.A1() && z3) {
            this.F0.F1(this.x0.R1());
        }
        if (z3) {
            L6(zr7Var);
        }
    }

    @Override // com.repackage.vg5
    public eg<ImageView> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.C == null) {
                this.C = new eg<>(new j2(this), 8, 0);
            }
            return this.C;
        }
        return (eg) invokeV.objValue;
    }

    public nv7 O5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.F0 : (nv7) invokeV.objValue;
    }

    public final void O6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            hideNetRefreshView(this.F0.m1());
            o7();
            if (this.x0.Q2()) {
                this.F0.q3();
            }
            this.F0.y3();
        }
    }

    @Override // com.repackage.vg5
    public eg<View> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (this.D == null) {
                this.D = new eg<>(new m2(this), 8, 0);
            }
            return this.D;
        }
        return (eg) invokeV.objValue;
    }

    public zp4 P5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.j0 : (zp4) invokeV.objValue;
    }

    public void P6(e3 e3Var) {
        List<e3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, e3Var) == null) || e3Var == null || (list = this.s1) == null) {
            return;
        }
        list.remove(e3Var);
    }

    @Override // com.repackage.vg5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, context, str) == null) {
        }
    }

    public String Q5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public void Q6() {
        mz4 mz4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (mz4Var = this.r0) == null) {
            return;
        }
        mz4Var.w();
    }

    @Override // com.repackage.vg5
    public void R(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048631, this, context, str, z3) == null) {
            if (tv7.c(str) && (pbModel = this.x0) != null && pbModel.j2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.x0.j2()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    w05 w05Var = new w05();
                    w05Var.a = str;
                    w05Var.b = 3;
                    w05Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, w05Var));
                }
            } else {
                tv7.a().e(getPageContext(), str);
            }
            this.w = true;
        }
    }

    public final int R5(jr7 jr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, jr7Var)) == null) {
            if (jr7Var == null || jr7Var.O() == null) {
                return 0;
            }
            if (jr7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (jr7Var.O().getThreadType() == 54) {
                return 2;
            }
            return jr7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public final boolean R6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091eed);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.C0 && !TextUtils.isEmpty(postData.t()) && zm4.c().g()) {
                        return A6(postData.J());
                    }
                    if (!checkUpIsLogin()) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return true;
                    }
                    PbModel pbModel = this.x0;
                    if (pbModel != null && pbModel.R1() != null) {
                        if (O5().b1() != null) {
                            O5().b1().c();
                        }
                        zr7 zr7Var = new zr7();
                        zr7Var.A(this.x0.R1().l());
                        zr7Var.E(this.x0.R1().O());
                        zr7Var.C(postData);
                        O5().a1().W(zr7Var);
                        O5().a1().setPostId(postData.J());
                        u6(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        n35 n35Var = this.U0;
                        if (n35Var != null) {
                            this.F0.U2(n35Var.C());
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

    public void S4(e3 e3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, e3Var) == null) || e3Var == null) {
            return;
        }
        if (this.s1 == null) {
            this.s1 = new ArrayList();
        }
        if (this.s1.contains(e3Var)) {
            return;
        }
        this.s1.add(e3Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.qy7
    /* renamed from: S5 */
    public VideoPbFragment B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public final void S6(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.Q == null) {
            nw7 nw7Var = new nw7(this.a);
            this.Q = nw7Var;
            nw7Var.n(this.b1);
            this.Q.m(this.j2);
        }
        this.Q.k(emotionImageData, F(), F().R1());
    }

    public void T4(e3 e3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, e3Var) == null) || e3Var == null) {
            return;
        }
        if (this.s1 == null) {
            this.s1 = new ArrayList();
        }
        if (this.s1.contains(e3Var)) {
            return;
        }
        this.s1.add(0, e3Var);
    }

    public String T5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public final void T6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (pbModel = this.x0) == null || pbModel.R1() == null || this.x0.R1().O() == null || !this.x0.R1().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public final void U4() {
        PbModel pbModel;
        jr7 jr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || (pbModel = this.x0) == null || (jr7Var = pbModel.G) == null || jr7Var.O() == null) {
            return;
        }
        ThreadData O = this.x0.G.O();
        O.mRecomAbTag = this.x0.W1();
        O.mRecomWeight = this.x0.Z1();
        O.mRecomSource = this.x0.Y1();
        O.mRecomExtra = this.x0.X1();
        O.isSubPb = this.x0.E1();
        if (O.getFid() == 0) {
            O.setFid(ng.g(this.x0.getForumId(), 0L));
        }
        StatisticItem i3 = u85.i(getContext(), O, "c13562");
        TbPageTag l3 = u85.l(getContext());
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

    public void U5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (this.g) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.x0.R1() == null || this.x0.R1().O() == null || this.x0.R1().O().getTaskInfoData() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.x0.R1().O().getTaskInfoData().g(), this.x0.R1().O().getTaskInfoData().f(), this.x0.R1().O().getTaskInfoData().b(), this.x0.R1().O().getTaskInfoData().c(), this.x0.R1().O().getIs_top(), this.x0.R1().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void U6(boolean z3, PostData postData) {
        sw4 adAdSense;
        nv7 nv7Var;
        xt7 A0;
        ArrayList<PostData> D;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048642, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e() || (nv7Var = this.F0) == null || (A0 = nv7Var.A0()) == null || (D = A0.D()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PostData> it = D.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PostData next = it.next();
            String J = next.J();
            if (z3) {
                if (next == postData) {
                    arrayList.add(new ti8.c());
                    break;
                }
            } else if (next.C == 1 && !TextUtils.isEmpty(J)) {
                next.C = 2;
                arrayList.add(new ti8.c());
            }
        }
        if (arrayList.size() <= 0 || (pbModel = this.x0) == null || pbModel.R1() == null || this.x0.R1().l() == null) {
            return;
        }
        this.x0.R1().l().getFirst_class();
        this.x0.R1().l().getSecond_class();
        this.x0.R1().l().getId();
        this.x0.j2();
    }

    @Override // com.repackage.vg5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048643, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.M0 = str;
        if (this.m == null) {
            f6();
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

    public final void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            if (this.n1 != null) {
                m45.b bVar = new m45.b();
                bVar.a = this.n1.E();
                bVar.b = this.n1.C();
                bVar.c = String.valueOf(this.n1.F());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.m1));
        }
    }

    public final void V5(int i3, Intent intent) {
        v15 v15Var;
        v15 v15Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048645, this, i3, intent) == null) {
            if (i3 == 0) {
                this.F0.q1();
                this.F0.b1().c();
                this.F0.D3(false);
            }
            this.F0.M2();
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
                    if (editorType != 1 || this.F0.b1() == null || this.F0.b1().b() == null) {
                        return;
                    }
                    r35 b4 = this.F0.b1().b();
                    b4.c0(this.x0.R1().O());
                    b4.B(writeData);
                    b4.d0(pbEditorData.getVoiceModel());
                    u15 n3 = b4.a().n(6);
                    if (n3 != null && (v15Var2 = n3.m) != null) {
                        v15Var2.C(new j15(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        b4.F();
                        return;
                    }
                    return;
                }
                this.U0.T();
                this.U0.w0(pbEditorData.getVoiceModel());
                this.U0.G(writeData);
                u15 n4 = this.U0.a().n(6);
                if (n4 != null && (v15Var = n4.m) != null) {
                    v15Var.C(new j15(52, 0, pbEditorData.getVoiceModel()));
                }
                this.U0.r0(pbEditorData.isShowCustomFigure());
                if (i3 == -1) {
                    this.U0.M(null, null);
                }
            }
        }
    }

    public final void V6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (pbModel = this.x0) == null || pbModel.R1() == null || this.x0.R1().O() == null || !this.x0.R1().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public final void W4(boolean z3) {
        PbModel pbModel;
        jr7 jr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048647, this, z3) == null) || (pbModel = this.x0) == null || (jr7Var = pbModel.G) == null || jr7Var.O() == null) {
            return;
        }
        ThreadData O = this.x0.G.O();
        O.mRecomAbTag = this.x0.W1();
        O.mRecomWeight = this.x0.Z1();
        O.mRecomSource = this.x0.Y1();
        O.mRecomExtra = this.x0.X1();
        if (O.getFid() == 0) {
            O.setFid(ng.g(this.x0.getForumId(), 0L));
        }
        StatisticItem i3 = u85.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l3 = u85.l(getContext());
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
            p85 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(i3);
        }
    }

    public void W5(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091f41) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f41) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091f43) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f43) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091f42) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f42) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091f3e) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f3e) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091f3f) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f3f) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.i1);
            userMuteAddAndDelCustomMessage.setTag(this.i1);
            u7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void W6(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048649, this, i3) == null) || this.x0 == null) {
            return;
        }
        o7();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
        privacySettingMessage.setTid(this.x0.b);
        sendMessage(privacySettingMessage);
    }

    @Override // com.repackage.rz7.b
    public void X0(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z3) == null) {
            this.O0 = z3;
        }
    }

    public final void X4(jr7 jr7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048651, this, jr7Var, arrayList) == null) || jr7Var == null || jr7Var.T() == null || jr7Var.T().a == null || (list = jr7Var.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.J()) && !TextUtils.isEmpty(postData.J()) && next.J().equals(postData.J())) {
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

    public final void X5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.R1() != null && this.x0.R1().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.x0.j2(), str);
                ThreadData O = this.x0.R1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                p6(format);
                return;
            }
            this.y0.a(str);
        }
    }

    public void X6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z3) == null) {
            this.N = z3;
        }
    }

    @Override // com.repackage.vg5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048654, this, context, str) == null) {
            this.w = true;
        }
    }

    public void Y4(boolean z3) {
        nv7 nv7Var;
        int v3;
        int v4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048655, this, z3) == null) || (nv7Var = this.F0) == null || nv7Var.R0() == null) {
            return;
        }
        int firstVisiblePosition = this.F0.R0().getFirstVisiblePosition();
        int lastVisiblePosition = this.F0.R0().getLastVisiblePosition();
        xt7 A0 = this.F0.A0();
        if (A0 == null || this.x0.R1() == null) {
            return;
        }
        if (lastVisiblePosition <= A0.v()) {
            v3 = 0;
            v4 = 1;
        } else {
            v3 = firstVisiblePosition > A0.v() ? firstVisiblePosition - A0.v() : 0;
            v4 = (lastVisiblePosition - A0.v()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (v4 > v3) {
            while (v3 < v4) {
                if (this.F0.R0().G(v3) != null && (this.F0.R0().G(v3) instanceof PostData) && (postData = (PostData) this.F0.R0().G(v3)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.x0.R1().F(), postData.B() - 1);
                    if (postData.o() == null && postData2 != null) {
                        postData.p0(postData2.o());
                    }
                    if (postData.o() != null) {
                        postData.o().q(postData.B());
                        arrayList.add(postData.o());
                    }
                }
                v3++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new u1(this));
            d05 d05Var = (d05) ListUtils.getItem(arrayList, 0);
            if (d05Var == null || d05Var.e() != 1) {
                this.F0.y2(d05Var, 1);
            } else if (z3) {
            } else {
                this.F0.y2(d05Var, 0);
            }
        }
    }

    public final void Y5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, intent) == null) {
            gx7.j(this, intent);
        }
    }

    public final void Y6(p35 p35Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048657, this, p35Var) == null) || p35Var == null || (pbModel = this.x0) == null) {
            return;
        }
        p35Var.p(pbModel.q1());
        if (this.x0.R1() != null && this.x0.R1().l() != null) {
            p35Var.o(this.x0.R1().l());
        }
        p35Var.q("pb");
        p35Var.r(this.x0);
    }

    @Override // com.repackage.vg5
    public eg<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if (this.A == null) {
                this.A = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (eg) invokeV.objValue;
    }

    public final boolean Z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.R1() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.x0.R1().O()) || AntiHelper.d(getPageContext(), this.x0.R1().d());
        }
        return invokeV.booleanValue;
    }

    public void Z5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048660, this) == null) || this.a == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.a.getCurrentFocus() == null) {
            return;
        }
        pi.x(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public final void Z6(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048661, this, i3) == null) || (pbModel = this.x0) == null) {
            return;
        }
        int a22 = pbModel.a2();
        if (i3 == 5) {
            this.x0.y3(2);
        } else if (i3 == 6) {
            this.x0.y3(3);
        } else if (i3 != 7) {
            this.x0.y3(1);
        } else {
            this.x0.y3(4);
        }
        int a23 = this.x0.a2();
        if (a22 == 4 || a23 == 4) {
            E6();
        }
    }

    public final boolean a5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048662, this, i3)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void a6() {
        nv7 nv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048663, this) == null) || (nv7Var = this.F0) == null) {
            return;
        }
        nv7Var.q1();
        Z5();
    }

    public void a7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z3) == null) {
            this.K = z3;
        }
    }

    public void b5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.F0.L3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = ng.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = ng.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091f40), 0L);
            BdUniqueId bdUniqueId = this.i1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.f1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void b6(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048666, this, i3, i4) == null) {
            he5.b(new h(this, i4), new i(this, i4, i3));
        }
    }

    public final void b7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z3) == null) {
            this.U0.g0(z3);
            this.U0.k0(z3);
            this.U0.s0(z3);
        }
    }

    public boolean c5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if ((this.x0.R1() != null && (this.x0.R1().g0() || ThreadCardUtils.isSelf(this.x0.R1().O()))) || this.X0 == null || this.x0.R1() == null || this.x0.R1().d() == null) {
                return true;
            }
            return this.X0.checkPrivacyBeforeInvokeEditor(this.x0.R1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void c6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i3) == null) {
            he5.b(new f(this), new g(this, i3));
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

    public final void c7() {
        PbModel pbModel;
        ImMessageCenterPojo i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048670, this) == null) || (pbModel = this.x0) == null || pbModel.G == null) {
            return;
        }
        long c4 = iz4.c();
        if (c4 <= 0 || (i3 = s67.o().i(String.valueOf(c4), 2)) == null || p67.a(getContext())) {
            return;
        }
        MetaData metaData = new MetaData();
        metaData.setUserIdLong(c4);
        metaData.setUserName(i3.getGroup_name());
        metaData.setName_show(i3.getNameShow());
        metaData.setPortrait(i3.getGroup_head());
        metaData.setIsMyFriend(i3.getIsFriend() != 1 ? 0 : 1);
        a87 a87Var = new a87(getContext());
        a87Var.o(this.x0.G.O(), metaData);
        a87Var.p();
    }

    public boolean d5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048671, this, i3)) == null) {
            if (this.X0 == null || this.x0.R1() == null || ThreadCardUtils.isSelf(this.x0.R1().O()) || this.x0.R1().d() == null) {
                return true;
            }
            return this.X0.checkPrivacyBeforeSend(this.x0.R1().d().replyPrivateFlag, i3);
        }
        return invokeI.booleanValue;
    }

    public final void d6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, bundle) == null) {
            jl4 c4 = jl4.c(this.a);
            this.z0 = c4;
            if (c4 != null) {
                c4.j(this.p2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.A0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.r2);
            this.B0 = new ty4(getPageContext());
            if (TbSingleton.getInstance().getIsNeedRemindLiveRoom()) {
                LiveRemindModel liveRemindModel = new LiveRemindModel(getPageContext(), getUniqueId());
                this.D0 = liveRemindModel;
                liveRemindModel.B();
            }
            this.R1.setUniqueId(getUniqueId());
            this.R1.registerListener();
        }
    }

    public final void d7(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048673, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new v1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                t7(str);
            } else {
                this.F0.d4(str);
            }
        }
    }

    @Override // com.repackage.vg5
    public eg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            if (this.H == null) {
                this.H = new eg<>(new o2(this), 10, 0);
            }
            return this.H;
        }
        return (eg) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e5(AgreeData agreeData) {
        p85 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048675, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.l0 == null) {
            this.l0 = new tt4();
        }
        if (this.p0 == null) {
            ei8 ei8Var = new ei8();
            this.p0 = ei8Var;
            ei8Var.a = getUniqueId();
        }
        tn4 tn4Var = new tn4();
        tn4Var.b = 5;
        tn4Var.h = 8;
        tn4Var.g = 2;
        if (F() != null) {
            tn4Var.f = F().Q1();
        }
        tn4Var.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                tn4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l0.c(agreeData, i3, getUniqueId(), false);
                this.l0.d(agreeData, this.p0);
                pbModel = this.x0;
                if (pbModel != null || pbModel.R1() == null) {
                }
                this.l0.b(N(), tn4Var, agreeData, this.x0.R1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            tn4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            tn4Var.i = 1;
        }
        i3 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.l0.c(agreeData, i3, getUniqueId(), false);
        this.l0.d(agreeData, this.p0);
        pbModel = this.x0;
        if (pbModel != null) {
        }
    }

    public final void e6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.R = likeModel;
            likeModel.setLoadDataCallBack(new l0(this));
        }
    }

    public final void e7(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048677, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (O5() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    pz4.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                } else {
                    rk8.b(getFragmentActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.x0.E1()) {
            antiData.setBlock_forum_name(this.x0.R1().l().getName());
            antiData.setBlock_forum_id(this.x0.R1().l().getId());
            antiData.setUser_name(this.x0.R1().U().getUserName());
            antiData.setUser_id(this.x0.R1().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            if (this.x0.w1() || this.x0.z1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.x0.j2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.x0.j2()));
            if (A7()) {
                this.a.finish();
            }
        }
    }

    public final void f6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048680, this) == null) && this.m == null) {
            this.m = new er4(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f035f), getPageContext().getString(R.string.obfuscated_res_0x7f0f11c0), getPageContext().getString(R.string.obfuscated_res_0x7f0f10ca)};
            er4 er4Var = this.m;
            er4Var.j(strArr, new q0(this));
            er4Var.g(er4.b.obfuscated_res_0x7f1003a5);
            er4Var.h(17);
            er4Var.c(getPageContext());
        }
    }

    public final void f7(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            gx7.l(this, j3, str, j4);
        }
    }

    @Override // com.repackage.qy7
    public void finish() {
        nv7 nv7Var;
        CardHListViewData q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            nv7 nv7Var2 = this.F0;
            if (nv7Var2 != null) {
                nv7Var2.m0();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.R1() != null && !this.x0.R1().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.x0.R1().O().getId();
                if (this.x0.isShareThread() && this.x0.R1().O().originalThreadData != null) {
                    historyMessage.threadName = this.x0.R1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.x0.R1().O().getTitle();
                }
                if (this.x0.isShareThread() && !v0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.x0.R1().l().getName();
                }
                ArrayList<PostData> F = this.x0.R1().F();
                nv7 nv7Var3 = this.F0;
                int H0 = nv7Var3 != null ? nv7Var3.H0() : 0;
                if (F != null && H0 >= 0 && H0 < F.size()) {
                    historyMessage.postID = F.get(H0).J();
                }
                historyMessage.isHostOnly = this.x0.u1();
                historyMessage.isSquence = this.x0.h2();
                historyMessage.isShareThread = this.x0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            n35 n35Var = this.U0;
            if (n35Var != null) {
                n35Var.I();
            }
            if (this.j && O5() != null) {
                O5().r0();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && (pbModel2.w1() || this.x0.z1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.x0.j2());
                if (this.G0) {
                    if (this.I0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.x0.F1());
                    }
                    if (this.H0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.x0.B1());
                    }
                }
                if (this.x0.R1() != null && System.currentTimeMillis() - this.p >= 40000 && (q3 = this.x0.R1().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.r1);
                }
                this.a.setResult(-1, intent);
            }
            if (A7()) {
                if (this.x0 != null && (nv7Var = this.F0) != null && nv7Var.R0() != null) {
                    jr7 R1 = this.x0.R1();
                    if (R1 != null) {
                        if (R1.U() != null) {
                            R1.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!R1.m0() && !this.I && R1.h == null) {
                            fv7.b().n(this.x0.S1(), this.F0.R0().onSaveInstanceState(), this.x0.h2(), this.x0.u1(), this.F0.Z0() != null && this.F0.Z0().getVisibility() == 0);
                            if (this.q1 >= 0 || this.x0.l2() != null) {
                                fv7.b().q(this.x0.l2());
                                fv7.b().r(this.x0.m2());
                                fv7.b().o(this.x0.K1());
                            }
                        }
                    }
                } else {
                    fv7.b().m();
                }
                z7();
            }
        }
    }

    public final boolean g5(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        boolean z5;
        List<jr4> b4;
        jr4 jr4Var;
        jr4 jr4Var2;
        jr4 jr4Var3;
        jr4 jr4Var4;
        ym ymVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048683, this, view2)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                nv7 nv7Var = this.F0;
                if (nv7Var != null) {
                    if (nv7Var.J1()) {
                        return true;
                    }
                    this.F0.x0();
                }
                try {
                    sparseArray = (SparseArray) view2.getTag();
                } catch (ClassCastException e4) {
                    e4.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (k6(view2)) {
                        if (view2 instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view2;
                            this.l1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.m1 = url;
                            if (this.l1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f091f23) != null && (view2.getTag(R.id.obfuscated_res_0x7f091f23) instanceof TbRichTextImageInfo)) {
                                this.n1 = (TbRichTextImageInfo) view2.getTag(R.id.obfuscated_res_0x7f091f23);
                            } else {
                                this.n1 = null;
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f091f24) != null && (view2.getTag(R.id.obfuscated_res_0x7f091f24) instanceof TbRichTextImageInfo)) {
                                this.o1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091f24);
                            } else {
                                this.o1 = null;
                            }
                        } else if (view2 instanceof GifView) {
                            GifView gifView = (GifView) view2;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.l1 = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                                this.m1 = gifView.getBdImage().q();
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f091f24) != null && (view2.getTag(R.id.obfuscated_res_0x7f091f24) instanceof TbRichTextImageInfo)) {
                                this.o1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091f24);
                            } else {
                                this.o1 = null;
                            }
                        } else if (view2 instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.l1 = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                    this.m1 = tbMemeImageView.getBdImage().q();
                                }
                                if (view2.getTag(R.id.obfuscated_res_0x7f091f24) != null && (view2.getTag(R.id.obfuscated_res_0x7f091f24) instanceof TbRichTextImageInfo)) {
                                    this.o1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091f24);
                                } else {
                                    this.o1 = null;
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
                            this.F0.Q3(this.C2, this.l1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eed);
                this.A2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.B() == 1 && k6(view2)) {
                    this.F0.Q3(this.C2, this.l1.t());
                    return true;
                }
                jl4 jl4Var = this.z0;
                if (jl4Var == null) {
                    return true;
                }
                boolean z6 = jl4Var.e() && this.A2.J() != null && this.A2.J().equals(this.x0.M1());
                boolean z7 = F().R1() != null && F().R1().g0();
                boolean z8 = F().R1() != null && F().R1().j0();
                if (this.A2.B() == 1) {
                    if (!z7) {
                        this.F0.R3(this.B2, z6, false, z8);
                    }
                    return true;
                }
                if (this.L0 == null) {
                    nr4 nr4Var = new nr4(getContext());
                    this.L0 = nr4Var;
                    nr4Var.n(this.f2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 == null || sparseArray == null) {
                    return true;
                }
                boolean z9 = k6(view2) && !z7;
                boolean z10 = (!k6(view2) || (ymVar = this.l1) == null || ymVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091f06) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f06)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f44)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091f30) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f30)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f44)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091f2e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f2e)).booleanValue() : false;
                String str = sparseArray.get(R.id.obfuscated_res_0x7f091efd) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091efd) : null;
                boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091f05) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f05)).booleanValue() : false;
                if (z9) {
                    z5 = booleanValue7;
                    z4 = booleanValue6;
                    z3 = booleanValue5;
                    arrayList.add(new jr4(1, getString(R.string.obfuscated_res_0x7f0f1098), this.L0));
                } else {
                    z3 = booleanValue5;
                    z4 = booleanValue6;
                    z5 = booleanValue7;
                }
                if (z10) {
                    arrayList.add(new jr4(2, getString(R.string.obfuscated_res_0x7f0f1099), this.L0));
                }
                if (!z9 && !z10) {
                    jr4 jr4Var5 = new jr4(3, getString(R.string.obfuscated_res_0x7f0f0443), this.L0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eed, this.A2);
                    jr4Var5.d.setTag(sparseArray3);
                    arrayList.add(jr4Var5);
                }
                if (!booleanValue && !z7) {
                    if (z6) {
                        jr4Var4 = new jr4(4, getString(R.string.obfuscated_res_0x7f0f0fb3), this.L0);
                    } else {
                        jr4Var4 = new jr4(4, getString(R.string.obfuscated_res_0x7f0f0a80), this.L0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091eed, this.A2);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091f06, Boolean.FALSE);
                    jr4Var4.d.setTag(sparseArray4);
                    arrayList.add(jr4Var4);
                }
                if (this.mIsLogin && !this.q0) {
                    if (!fx7.h(this.x0) && !booleanValue4 && booleanValue3) {
                        jr4 jr4Var6 = new jr4(5, getString(R.string.obfuscated_res_0x7f0f0b23), this.L0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f44, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f04, sparseArray.get(R.id.obfuscated_res_0x7f091f04));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f40, sparseArray.get(R.id.obfuscated_res_0x7f091f40));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f41, sparseArray.get(R.id.obfuscated_res_0x7f091f41));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f3f, sparseArray.get(R.id.obfuscated_res_0x7f091f3f));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f42, sparseArray.get(R.id.obfuscated_res_0x7f091f42));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f43, sparseArray.get(R.id.obfuscated_res_0x7f091f43));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ef0, sparseArray.get(R.id.obfuscated_res_0x7f091ef0));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ef1, sparseArray.get(R.id.obfuscated_res_0x7f091ef1));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eef, sparseArray.get(R.id.obfuscated_res_0x7f091eef));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                        jr4Var6.d.setTag(sparseArray5);
                        arrayList.add(jr4Var6);
                    } else {
                        if ((o6(booleanValue2) && TbadkCoreApplication.isLogin()) && !z7) {
                            jr4 jr4Var7 = new jr4(5, getString(R.string.obfuscated_res_0x7f0f0fd6), this.L0);
                            jr4Var7.d.setTag(str);
                            arrayList.add(jr4Var7);
                        }
                    }
                    if (booleanValue4) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.obfuscated_res_0x7f091f30, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091efa, sparseArray.get(R.id.obfuscated_res_0x7f091efa));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091efb, sparseArray.get(R.id.obfuscated_res_0x7f091efb));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091efc, sparseArray.get(R.id.obfuscated_res_0x7f091efc));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091efd, str);
                        if (!fx7.h(this.x0) && z3) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f44, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f04, sparseArray.get(R.id.obfuscated_res_0x7f091f04));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f40, sparseArray.get(R.id.obfuscated_res_0x7f091f40));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f41, sparseArray.get(R.id.obfuscated_res_0x7f091f41));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f3f, sparseArray.get(R.id.obfuscated_res_0x7f091f3f));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f42, sparseArray.get(R.id.obfuscated_res_0x7f091f42));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f43, sparseArray.get(R.id.obfuscated_res_0x7f091f43));
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f44, Boolean.FALSE);
                        }
                        if (z4) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f2e, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(booleanValue2));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091eef, sparseArray.get(R.id.obfuscated_res_0x7f091eef));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ef1, sparseArray.get(R.id.obfuscated_res_0x7f091ef1));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f05, Boolean.valueOf(z5));
                            if (z5) {
                                jr4 jr4Var8 = new jr4(6, getString(R.string.obfuscated_res_0x7f0f049f), this.L0);
                                jr4Var8.d.setTag(sparseArray6);
                                jr4Var2 = jr4Var8;
                                jr4Var = new jr4(7, getString(R.string.obfuscated_res_0x7f0f02df), this.L0);
                                jr4Var.d.setTag(sparseArray6);
                            }
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091f2e, Boolean.FALSE);
                        }
                        jr4Var2 = null;
                        jr4Var = new jr4(7, getString(R.string.obfuscated_res_0x7f0f02df), this.L0);
                        jr4Var.d.setTag(sparseArray6);
                    } else if (z4) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.obfuscated_res_0x7f091f30, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091f44, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091f2e, Boolean.TRUE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(booleanValue2));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091eef, sparseArray.get(R.id.obfuscated_res_0x7f091eef));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091ef1, sparseArray.get(R.id.obfuscated_res_0x7f091ef1));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                        if (this.x0.R1().V() == 1002 && !booleanValue2) {
                            jr4Var3 = new jr4(6, getString(R.string.obfuscated_res_0x7f0f0fd6), this.L0);
                        } else {
                            jr4Var3 = new jr4(6, getString(R.string.obfuscated_res_0x7f0f049f), this.L0);
                        }
                        jr4Var3.d.setTag(sparseArray7);
                        jr4Var2 = jr4Var3;
                        jr4Var = null;
                    } else {
                        jr4Var = null;
                        jr4Var2 = null;
                    }
                    if (jr4Var2 != null) {
                        arrayList.add(jr4Var2);
                    }
                    if (jr4Var != null) {
                        arrayList.add(jr4Var);
                    }
                    fx7.a(arrayList, this.L0, this.A2, this.x0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    b4 = fx7.c(arrayList, this.A2.p(), sparseArray, this.L0);
                } else {
                    b4 = fx7.b(arrayList, this.A2.p(), sparseArray, this.L0);
                }
                fx7.k(b4, this.b);
                fx7.e(b4);
                this.L0.o(fx7.f(this.A2));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.L0.k(b4, false);
                } else {
                    this.L0.k(b4, true);
                }
                lr4 lr4Var = new lr4(getPageContext(), this.L0);
                this.K0 = lr4Var;
                lr4Var.m();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.x0.b).param("fid", this.x0.getForumId()).param("uid", this.x0.R1().O().getAuthor().getUserId()).param("post_id", this.x0.C()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean g6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.w1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g7(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048685, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            fx7.d(getActivity(), getPageContext(), new b1(this, sparseArray, i3, z3), new c1(this));
        }
    }

    @Override // com.repackage.vg5
    public void h1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048687, this, context, str) == null) {
        }
    }

    public void h5(ForumManageModel.b bVar, nv7 nv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048688, this, bVar, nv7Var) == null) {
            List<PostData> list = this.x0.R1().T().a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).S().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i3).S().get(i4).J())) {
                        list.get(i3).S().remove(i4);
                        list.get(i3).k();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).l(bVar.g);
            }
            if (z3) {
                nv7Var.F1(this.x0.R1());
            }
        }
    }

    public final boolean h6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return (absPbActivity == null || absPbActivity.M0() == null || this.a.M0().Q1() != 17) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean h7(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        so4 so4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048690, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.R1() == null) {
                return false;
            }
            jr7 R1 = this.x0.R1();
            ThreadData O = R1.O();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !oe6.isOn()) || this.x0.I() || O.isWorksInfo() || O.isScoreThread() || z4) {
                return false;
            }
            if (R1.l() == null || !R1.l().isBlockBawuDelete) {
                if (R1.O() == null || !R1.O().isBlocked()) {
                    if (R1.V() != 0) {
                        return R1.V() != 3;
                    }
                    List<mq4> p3 = R1.p();
                    if (ListUtils.getCount(p3) > 0) {
                        for (mq4 mq4Var : p3) {
                            if (mq4Var != null && (so4Var = mq4Var.g) != null && so4Var.a && !so4Var.c && ((i3 = so4Var.b) == 1 || i3 == 2)) {
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

    public final void i5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048691, this, str) == null) || TextUtils.isEmpty(str) || (pbModel = this.x0) == null || pbModel.R1() == null) {
            return;
        }
        ni8 z3 = this.x0.R1().z();
        if (z3 != null && str.equals(z3.R0())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().h = null;
            }
            this.x0.R1().b();
        }
        ni8 k12 = this.x0.k1();
        if (k12 == null || !str.equals(k12.R0())) {
            return;
        }
        this.x0.W0();
    }

    public final boolean i6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            PostData c4 = kr7.c(this.x0.R1(), this.x0.h2(), this.x0.b2());
            return (c4 == null || c4.s() == null || c4.s().getGodUserData() == null || c4.s().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i7(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048693, this, z3)) == null) {
            if (z3 || (pbModel = this.x0) == null || pbModel.R1() == null || (this.x0.R1().l() != null && this.x0.R1().l().isBlockBawuDelete)) {
                return false;
            }
            jr7 R1 = this.x0.R1();
            if ((R1.O() == null || R1.O().getAuthor() == null || !R1.O().getAuthor().isForumBusinessAccount() || oe6.isOn()) && !this.x0.I()) {
                return ((R1.O() != null && R1.O().isBlocked()) || this.x0.R1().V() == 0 || this.x0.R1().V() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void j5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048694, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(nv7.i2)).intValue();
            if (intValue == nv7.j2) {
                if (this.A0.T()) {
                    return;
                }
                this.F0.e4();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091eef);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091f0c)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ef1)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091f03) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue() : false;
                if (jSONArray != null) {
                    this.A0.V(StringHelper.JsonArrayToString(jSONArray));
                }
                this.A0.W(this.x0.R1().l().getId(), this.x0.R1().l().getName(), this.x0.R1().O().getId(), str, intValue3, intValue2, booleanValue, this.x0.R1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == nv7.k2 || intValue == nv7.m2) {
                PbModel pbModel = this.x0;
                if (pbModel != null && pbModel.m1() != null) {
                    this.x0.m1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == nv7.k2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public boolean j6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.u1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean j7(boolean z3, boolean z4, boolean z5, int i3, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048696, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i3), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
            if (z3) {
                return false;
            }
            if (z6 || z7) {
                return true;
            }
            return z4 && (z5 || m6(i3));
        }
        return invokeCommon.booleanValue;
    }

    public void k5(cr4 cr4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048697, this, cr4Var, jSONArray) == null) {
            cr4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (cr4Var.getYesButtonTag() instanceof SparseArray) {
                    j5((SparseArray) cr4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean k6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048698, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public final boolean k7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.h2()) {
                return this.x0.P1() == null || this.x0.P1().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l5(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048700, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091eef, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091ef1, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091f0c, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(z3));
            sparseArray.put(nv7.i2, Integer.valueOf(nv7.j2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                j5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public boolean l6(int i3) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048701, this, i3)) == null) {
            if (i3 == 1) {
                return true;
            }
            if (this.x0.R1().U() != null && (forumToolAuth = this.x0.R1().U().getForumToolAuth()) != null) {
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

    public final void l7(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048702, this, metaData) == null) || metaData == null) {
            return;
        }
        cr4 cr4Var = new cr4(getActivity());
        cr4Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0a82));
        cr4Var.setTitleShowCenter(true);
        cr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0a83));
        cr4Var.setMessageShowCenter(true);
        cr4Var.setCancelable(false);
        cr4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a84), new r1(this, metaData));
        cr4Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a85), new s1(this, metaData));
        cr4Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    @Override // com.repackage.qy7
    public PbFragment m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    public void m5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048704, this, i3, i4) == null) {
            TiebaStatic.log("c12181");
            nv7 nv7Var = this.F0;
            if (nv7Var == null || this.x0 == null) {
                return;
            }
            if ((nv7Var != null && !nv7Var.H1()) || this.x0.R1() == null || this.x0.R1().S() == null) {
                return;
            }
            nv7 nv7Var2 = this.F0;
            if (nv7Var2 == null || nv7Var2.G0() == null || !this.F0.G0().r()) {
                xr7 S = this.x0.R1().S();
                if (checkUpIsLogin()) {
                    if ((!S.d() || S.a() != 2) && this.F0.A0() != null && this.F0.A0().y() != null) {
                        this.F0.A0().y().c0(this.x0.j2(), this.x0.getFromForumId());
                    }
                    if (i3 > -1 && i4 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        nq7 nq7Var = new nq7(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.x0;
                        nq7Var.m(findViewById, i3, i4, pbModel.b, pbModel.getForumId());
                        nq7Var.l(new n0(this));
                    } else if (System.currentTimeMillis() - this.x > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.x = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public boolean m6(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048705, this, i3)) == null) ? i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 : invokeI.booleanValue;
    }

    public final void m7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
            cr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b22));
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ce3, new a(this));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new b(this));
            cr4Var.create(this.g1).show();
        }
    }

    public void n5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048707, this) == null) || this.F0 == null || (pbModel = this.x0) == null) {
            return;
        }
        if ((pbModel.R1() == null && this.x0.R1().S() == null) || !checkUpIsLogin() || this.F0.A0() == null || this.F0.A0().y() == null) {
            return;
        }
        this.F0.A0().y().c0(this.x0.j2(), this.x0.getFromForumId());
    }

    public final boolean n6(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048708, this, i3)) == null) ? i3 == 2 || i3 == 1 : invokeI.booleanValue;
    }

    public final void n7(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048709, this, z3, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f091f40) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091ee9) instanceof Integer)) {
            lr4 lr4Var = this.K0;
            if (lr4Var != null && lr4Var.isShowing()) {
                this.K0.dismiss();
                this.K0 = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091f3e);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091f40);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f44)).booleanValue()) {
                nr4 nr4Var = new nr4(getContext());
                nr4Var.n(new f0(this, sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091ee9) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ee9)).intValue() : -1) == 1) {
                    arrayList.add(new jr4(0, getResources().getString(R.string.obfuscated_res_0x7f0f049f), nr4Var));
                }
                if (z3) {
                    arrayList.add(new jr4(1, getResources().getString(R.string.obfuscated_res_0x7f0f14aa), nr4Var));
                } else {
                    arrayList.add(new jr4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0b1f), nr4Var));
                }
                nr4Var.j(arrayList);
                lr4 lr4Var2 = new lr4(getPageContext(), nr4Var);
                this.K0 = lr4Var2;
                lr4Var2.m();
            }
        }
    }

    public final void o5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048710, this, str) == null) || (pbModel = this.x0) == null || pbModel.R1() == null || this.x0.R1().O() == null || !this.x0.R1().O().isUgcThreadType()) {
            return;
        }
        ThreadData O = this.x0.R1().O();
        int i3 = 0;
        if (O.isBJHArticleThreadType()) {
            i3 = 1;
        } else if (O.isBJHVideoThreadType()) {
            i3 = 2;
        } else if (O.isBJHNormalThreadType()) {
            i3 = 3;
        } else if (O.isBJHVideoDynamicThreadType()) {
            i3 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i3);
        TiebaStatic.log(statisticItem);
    }

    public final boolean o6(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048711, this, z3)) == null) {
            PbModel pbModel = this.x0;
            return (pbModel == null || pbModel.R1() == null || this.x0.R1().O() == null || this.x0.R1().O().getAuthor() == null || TextUtils.equals(this.x0.R1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final void o7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            showLoadingView(this.F0.m1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bd));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.F0.l1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906a0));
            this.m2.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d(), "", 1);
            this.a.P0().l(this.t0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048714, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.U0.H(i3, i4, intent);
            nw7 nw7Var = this.Q;
            if (nw7Var != null) {
                nw7Var.i(i3, i4, intent);
            }
            if (O5().b1() != null) {
                O5().b1().g(i3, i4, intent);
            }
            if (i3 == 25035) {
                V5(i4, intent);
            }
            if (i4 == -1) {
                if (i3 == 11009) {
                    x6();
                } else if (i3 == 13008) {
                    fv7.b().m();
                    this.w0.postDelayed(new d2(this), 1000L);
                } else if (i3 == 13011) {
                    v88.g().m(getPageContext());
                } else if (i3 == 23003) {
                    if (intent == null || this.x0 == null) {
                        return;
                    }
                    f7(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i3 == 23007) {
                    Y5(intent);
                } else if (i3 == 25012) {
                    intent.getLongExtra("KEY_FORUM_ID", 0L);
                    intent.getStringExtra(ForumUserLiveActiivtyConfig.KEY_FORUM_NAME);
                } else if (i3 == 25033) {
                    View view2 = this.S;
                    if (view2 != null) {
                        this.F0.I3(view2);
                    }
                } else if (i3 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        v88.g().m(getPageContext());
                        E7();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.E0;
                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.w) != null) {
                            shareSuccessReplyToServerModel.A(str, intExtra, new e2(this));
                        }
                        if (h6()) {
                            C7(true);
                        }
                    }
                } else if (i3 != 24008) {
                    switch (i3) {
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
                            nv7 nv7Var = this.F0;
                            if (nv7Var == null || nv7Var.B0() == null) {
                                return;
                            }
                            this.F0.B0().performClick();
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
                    this.F0.s3(false);
                    if (this.x0.R1() == null || this.x0.R1().O() == null || this.x0.R1().O().getPushStatusData() == null) {
                        return;
                    }
                    this.x0.R1().O().getPushStatusData().setStatus(2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048716, this, i3) == null) || this.X == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.F0.d2(i3);
        n35 n35Var = this.U0;
        if (n35Var != null && n35Var.a() != null) {
            this.U0.a().w(i3);
        }
        if (this.F0.a() != null) {
            this.F0.a().d(getPageContext(), i3);
        }
        this.J0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.X = i3;
        y7();
        mz4 mz4Var = this.r0;
        if (mz4Var != null) {
            mz4Var.v();
        }
    }

    @Override // com.repackage.cr4.e
    public void onClick(cr4 cr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, cr4Var) == null) {
            k5(cr4Var, null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int i3 = configuration.orientation;
            if (i3 == this.y) {
                return;
            }
            this.y = i3;
            if (i3 == 2) {
                this.J = true;
            } else {
                this.J = false;
            }
            nv7 nv7Var = this.F0;
            if (nv7Var != null) {
                nv7Var.e2(configuration);
            }
            lr4 lr4Var = this.K0;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        nv7 nv7Var;
        nv7 nv7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, bundle) == null) {
            this.p = System.currentTimeMillis();
            this.g1 = getPageContext();
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
                this.L2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.M2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.N2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.P0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.Q0 = intent.getStringExtra("high_light_post_id");
                this.R0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (C5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                this.P = oi.isEmpty(stringExtra) ? "" : this.P;
                this.r1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                zp4 zp4Var = new zp4();
                this.j0 = zp4Var;
                zp4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.t1 = intExtra;
                if (intExtra == 0) {
                    this.t1 = intent.getIntExtra("key_start_from", 0);
                }
                this.u1 = intent.getStringExtra("last_tid");
            } else {
                this.n = System.currentTimeMillis();
            }
            this.r = this.p - this.n;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.l = 0;
            s6(bundle);
            if (this.x0.R1() != null) {
                this.x0.R1().N0(this.P);
            }
            e6();
            if (intent != null && (nv7Var2 = this.F0) != null) {
                nv7Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.j1 == null) {
                        this.j1 = new i0(this, intent);
                    }
                    qg.a().postDelayed(this.j1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.x0.R1() != null) {
                    this.x0.w3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.k = voiceManager;
            voiceManager.onCreate(getPageContext());
            d6(bundle);
            p35 p35Var = new p35();
            this.T0 = p35Var;
            Y6(p35Var);
            n35 n35Var = (n35) this.T0.a(getActivity());
            this.U0 = n35Var;
            n35Var.f0(this.a.getPageContext());
            this.U0.p0(this.j2);
            this.U0.q0(this.b1);
            this.U0.h0(1);
            this.U0.F(this.a.getPageContext(), bundle);
            this.U0.a().b(new t15(getActivity()));
            this.U0.a().C(true);
            b7(true);
            this.U0.P(this.x0.t1(), this.x0.j2(), this.x0.p1());
            registerListener(this.B1);
            if (!this.x0.E1()) {
                this.U0.s(this.x0.j2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.U0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.x0.x2()) {
                this.U0.m0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dd7));
            } else {
                nv7 nv7Var3 = this.F0;
                if (nv7Var3 != null) {
                    this.U0.m0(nv7Var3.e1());
                }
            }
            registerListener(this.A1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.z1);
            registerListener(this.b2);
            registerListener(this.c2);
            registerListener(this.o2);
            registerListener(this.y1);
            fi8 fi8Var = new fi8("pb", fi8.d);
            this.S0 = fi8Var;
            fi8Var.d();
            registerListener(this.J1);
            registerListener(this.T1);
            this.x0.T2();
            registerListener(this.n2);
            registerListener(this.d2);
            registerListener(this.i2);
            registerListener(this.N1);
            registerListener(this.O1);
            nv7 nv7Var4 = this.F0;
            if (nv7Var4 != null && nv7Var4.l1() != null && this.F0.j1() != null) {
                sw7 sw7Var = new sw7(getActivity(), this.F0.l1(), this.F0.j1(), this.F0.Z0());
                this.e = sw7Var;
                sw7Var.t(this.S1);
            }
            if (this.c && (nv7Var = this.F0) != null && nv7Var.j1() != null) {
                this.F0.j1().setVisibility(8);
            }
            cu4 cu4Var = new cu4();
            this.h1 = cu4Var;
            cu4Var.a = 1000L;
            registerListener(this.a2);
            registerListener(this.Z1);
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.L1);
            registerListener(this.F1);
            registerListener(this.G1);
            registerListener(this.H1);
            this.K1.setSelfListener(true);
            this.K1.setTag(this.a.getUniqueId());
            this.K1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.K1);
            registerResponsedEventListener(TipEvent.class, this.U1);
            this.i1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.i1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.i1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.x0.l1().E(this.V1);
            this.J0 = new qv7();
            if (this.U0.v() != null) {
                this.J0.m(this.U0.v().i());
            }
            this.U0.e0(this.c1);
            this.E0 = new ShareSuccessReplyToServerModel();
            S4(this.w1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.X0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new j0(this));
            lx7 lx7Var = new lx7(getContext());
            this.y0 = lx7Var;
            lx7Var.b(getUniqueId());
            pg8.g().i(getUniqueId());
            kn4.b().l("3", "");
            this.v1 = new hx5(getPageContext());
            this.u0 = new dx7(this, getUniqueId(), this.F0, this.x0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && ni.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.q = System.currentTimeMillis() - this.p;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048720, this, layoutInflater, viewGroup, bundle)) == null) {
            this.F0 = new nv7(this, this.h2, this.W1);
            w36 w36Var = new w36(getActivity());
            this.d = w36Var;
            w36Var.i(Q2);
            this.d.d(this.J2);
            this.F0.j3(this.q2);
            this.F0.i3(this.w2);
            this.F0.b3(this.t2);
            this.F0.c3(this.u2);
            this.F0.Z2(zm4.c().g());
            this.F0.g3(this.y2);
            this.F0.m3(this.E2);
            this.F0.k3(this.F2);
            this.F0.h3(this.H2);
            this.F0.f3(this.s2);
            this.F0.i4(this.mIsLogin);
            if (this.a.getIntent() != null) {
                this.F0.X2(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.F0.a1().setFromForumId(this.x0.getFromForumId());
            this.F0.P2(this.U0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.U0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.U0.m0(this.F0.e1());
            }
            this.F0.T2(new m0(this));
            this.F0.W2(this.x0.z1());
            this.F0.l3(this.x0.Q1());
            this.u0.f(this.F0, this.x0);
            return this.F0.m1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        kx7 kx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            pg8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.x0.R1().m());
                statisticItem.param("tid", this.x0.j2());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.t && this.F0 != null) {
                this.t = true;
                U6(false, null);
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.x0.destory();
                if (this.x0.N1() != null) {
                    this.x0.N1().d();
                }
            }
            n35 n35Var = this.U0;
            if (n35Var != null) {
                n35Var.I();
            }
            ForumManageModel forumManageModel = this.A0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.R;
            if (likeModel != null) {
                likeModel.N();
            }
            nv7 nv7Var = this.F0;
            if (nv7Var != null) {
                nv7Var.f2();
                kx7 kx7Var2 = this.F0.h;
                if (kx7Var2 != null) {
                    kx7Var2.x();
                }
            }
            j95 j95Var = this.u;
            if (j95Var != null) {
                j95Var.c();
            }
            sw7 sw7Var = this.e;
            if (sw7Var != null) {
                sw7Var.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            nv7 nv7Var2 = this.F0;
            if (nv7Var2 != null) {
                nv7Var2.m0();
            }
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.i1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.l2);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.N1);
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.G1);
            MessageManager.getInstance().unRegisterListener(this.H1);
            this.g1 = null;
            this.h1 = null;
            ab8.e().g();
            if (this.j1 != null) {
                qg.a().removeCallbacks(this.j1);
            }
            nw7 nw7Var = this.Q;
            if (nw7Var != null) {
                nw7Var.f();
            }
            nv7 nv7Var3 = this.F0;
            if (nv7Var3 != null && (kx7Var = nv7Var3.h) != null) {
                kx7Var.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.E0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            qv7 qv7Var = this.J0;
            if (qv7Var != null) {
                qv7Var.j();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && pbModel2.e1() != null) {
                this.x0.e1().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.X0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            nv7 nv7Var4 = this.F0;
            if (nv7Var4 != null) {
                nv7Var4.f4();
            }
            dx7 dx7Var = this.u0;
            if (dx7Var != null) {
                dx7Var.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.k0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public rn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (rn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            O6();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
                this.g = false;
            } else {
                this.g = true;
            }
            super.onPause();
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
            nv7 nv7Var = this.F0;
            if (nv7Var != null) {
                nv7Var.k2();
            }
            if (!this.x0.E1()) {
                this.U0.V(this.x0.j2());
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.S2();
            }
            li4.w().E();
            MessageManager.getInstance().unRegisterListener(this.E1);
            T6();
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.v(null);
            mz4 mz4Var = this.r0;
            if (mz4Var != null) {
                mz4Var.q();
                this.r0.p();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.g9
    public void onPreLoad(rn rnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, rnVar) == null) {
            PreLoadImageHelper.load(rnVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(rnVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            this.g = false;
            super.onResume();
            if (this.O) {
                this.O = false;
                U5();
            }
            if (i6()) {
                this.v = System.currentTimeMillis();
            } else {
                this.v = -1L;
            }
            nv7 nv7Var = this.F0;
            if (nv7Var != null && nv7Var.m1() != null) {
                if (!this.h) {
                    o7();
                } else {
                    hideLoadingView(this.F0.m1());
                }
                this.F0.m2();
            }
            if (this.l == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            nv7 nv7Var2 = this.F0;
            NoNetworkView a4 = nv7Var2 != null ? nv7Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && ni.z()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.E1);
            this.O0 = false;
            V6();
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.a2);
            if (this.p1) {
                O6();
                this.p1 = false;
            }
            v7();
            ItemCardHelper.v(this.G2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                c15.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.x0.k3(bundle);
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.U0.L(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            super.onStop();
            if (this.v > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.v;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.v = 0L;
            }
            if (O5().b1() != null) {
                O5().b1().i();
            }
            kx7 kx7Var = this.F0.h;
            if (kx7Var != null && !kx7Var.t()) {
                this.F0.h.x();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.R1() != null && this.x0.R1().l() != null && this.x0.R1().O() != null) {
                z05.j().x(getPageContext().getPageActivity(), "pb", this.x0.R1().l().getId(), ng.g(this.x0.R1().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            pg8.g().h(getUniqueId(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048731, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z3) == null) {
            super.onUserChanged(z3);
            this.F0.i4(z3);
            lr4 lr4Var = this.K0;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
            if (z3 && this.O0) {
                this.F0.r3();
                this.x0.K2(true);
            }
            if (this.F0.A0() != null) {
                this.F0.A0().b0(z3);
            }
        }
    }

    public final void p5(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048733, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04a4);
            int i3 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                cr4 cr4Var = new cr4(getPageContext().getPageActivity());
                cr4Var.setMessage(string);
                cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04e3, new y1(this));
                cr4Var.setCancelable(true);
                cr4Var.create(getPageContext());
                cr4Var.show();
            } else if (bVar.d != 0) {
                this.F0.w0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.d;
                if (i4 == 1) {
                    ArrayList<PostData> F = this.x0.R1().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i3).J())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.x0.R1().O().setReply_num(this.x0.R1().O().getReply_num() - 1);
                    this.F0.F1(this.x0.R1());
                } else if (i4 == 0) {
                    f5();
                } else if (i4 == 2) {
                    ArrayList<PostData> F2 = this.x0.R1().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).S().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i5).S().get(i6).J())) {
                                F2.get(i5).S().remove(i6);
                                F2.get(i5).k();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).l(bVar.g);
                    }
                    if (z4) {
                        this.F0.F1(this.x0.R1());
                    }
                    h5(bVar, this.F0);
                }
            }
        }
    }

    public final void p6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void p7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048735, this) == null) && UbsABTestHelper.isPushOpenNewStyle() && nz4.g(TbadkCoreApplication.getInst(), 0)) {
            this.r0 = nz4.i(getPageContext(), "reply_pb", 0L);
        }
    }

    public final void q5(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048736, this, i3, gVar) == null) || gVar == null) {
            return;
        }
        this.F0.w0(this.A0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.G0 = true;
            if (i3 == 2 || i3 == 3) {
                this.H0 = true;
                this.I0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.H0 = false;
                this.I0 = true;
            }
            if (i3 == 2) {
                this.x0.R1().O().setIs_good(1);
                this.x0.r3(1);
            } else if (i3 == 3) {
                this.x0.R1().O().setIs_good(0);
                this.x0.r3(0);
            } else if (i3 == 4) {
                this.x0.R1().O().setIs_top(1);
                this.x0.s3(1);
            } else if (i3 == 5) {
                this.x0.R1().O().setIs_top(0);
                this.x0.s3(0);
            }
            this.F0.m4(this.x0.R1(), this.x0.h2());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f0cf2);
        }
        pi.O(getPageContext().getPageActivity(), string);
    }

    public final void q6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048737, this) == null) || this.O2 == null) {
            return;
        }
        if (this.M2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0dc5);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.O2.a(), this.M2, 0)));
            this.a.finish();
        }
    }

    public final void q7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            if (UbsABTestHelper.isPushOpenNewStyle()) {
                if (!NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && nz4.g(TbadkCoreApplication.getInst(), 0)) {
                    this.r0 = nz4.i(getPageContext(), "collect", 0L);
                }
            } else if (kz4.g(getContext(), 0)) {
                kz4.i(getPageContext(), 6, 2000L);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void r0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048739, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (sg5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), sg5.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (tv7.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new ze5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void r5(Rect rect) {
        nv7 nv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048740, this, rect) == null) || rect == null || (nv7Var = this.F0) == null || nv7Var.l1() == null || rect.top > this.F0.l1().getHeight()) {
            return;
        }
        rect.top += this.F0.l1().getHeight() - rect.top;
    }

    public void r6(String str) {
        nv7 nv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048741, this, str) == null) || this.x0 == null || StringUtils.isNull(str) || (nv7Var = this.F0) == null) {
            return;
        }
        nv7Var.Y2(true);
        this.x0.M2(str);
        this.I = true;
        this.F0.m0();
        this.F0.o1();
    }

    public final void r7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && F() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                F().Z0(postWriteCallBackData.getPostId());
                int E0 = this.F0.E0();
                this.q1 = E0;
                this.x0.n3(E0, this.F0.L0());
            }
            this.F0.m0();
            this.J0.c();
            n35 n35Var = this.U0;
            if (n35Var != null) {
                this.F0.U2(n35Var.C());
            }
            this.F0.q1();
            this.F0.D3(true);
            this.x0.s2();
        }
    }

    public AntiData s5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.R1() == null) {
                return null;
            }
            return this.x0.R1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void s6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, bundle) == null) {
            PbModel M0 = this.a.M0();
            this.x0 = M0;
            if (M0 != null) {
                if (M0.m1() != null) {
                    this.x0.m1().c(this.K2);
                }
                if (this.x0.N1() != null) {
                    this.x0.N1().f(this.x1);
                }
                if (StringUtils.isNull(this.x0.j2())) {
                    this.a.finish();
                } else if (!"from_tieba_kuang".equals(this.M) || this.M == null) {
                } else {
                    this.x0.v3(6);
                }
            }
        }
    }

    public final void s7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048745, this, i3) == null) {
            gx7.o(this, t5(), i3);
        }
    }

    public final int t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            if (this.x0.R1() == null || this.x0.R1().O() == null) {
                return -1;
            }
            return this.x0.R1().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void t6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048747, this) == null) || this.O2 == null) {
            return;
        }
        if (this.L2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0dc6);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.O2.a(), this.L2, 0)));
            this.a.finish();
        }
    }

    public final void t7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, str) == null) {
            if (str == null) {
                str = "";
            }
            d9 d9Var = this.g1;
            if (d9Var == null) {
                return;
            }
            cr4 cr4Var = new cr4(d9Var.getPageActivity());
            cr4Var.setMessage(str);
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f099e, new c(this));
            cr4Var.create(this.g1).show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048750, this) == null) || (pbModel = this.x0) == null || oi.isEmpty(pbModel.j2())) {
            return;
        }
        super.taskStart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) ? this.k : (VoiceManager) invokeV.objValue;
    }

    public PostData u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            nv7 nv7Var = this.F0;
            PbModel pbModel = this.x0;
            return nv7Var.I0(pbModel.G, pbModel.h2());
        }
        return (PostData) invokeV.objValue;
    }

    public final void u6(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048753, this, view2, str, str2, postData) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (Z4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!c5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Z);
                        this.g0 = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (O5().b1() != null && postData != null) {
                        O5().b1().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fcc), postData.s().getName_show(), postData.Q() != null ? postData.Q().toString() : ""));
                    }
                    if (this.x0.R1() != null && this.x0.R1().g0()) {
                        qg.a().postDelayed(new f1(this, str, str2), 0L);
                        return;
                    }
                    if (this.Z0 == null) {
                        xm6 xm6Var = new xm6(getPageContext());
                        this.Z0 = xm6Var;
                        xm6Var.j(1);
                        this.Z0.i(new g1(this, str, str2));
                    }
                    PbModel pbModel = this.x0;
                    if (pbModel == null || pbModel.R1() == null || this.x0.R1().l() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.Z0.g(this.x0.R1().l().getId(), ng.g(this.x0.j2(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void u7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048754, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.F0.L3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            cr4 cr4Var = new cr4(this.g1.getPageActivity());
            if (oi.isEmpty(str)) {
                cr4Var.setMessage(this.g1.getResources().getString(R.string.obfuscated_res_0x7f0f0319, str3));
            } else {
                cr4Var.setMessage(str);
            }
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0427, new d(this, userMuteAddAndDelCustomMessage));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new e(this));
            cr4Var.create(this.g1).show();
        }
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.G2();
        }
        return invokeV.booleanValue;
    }

    public String v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? this.M : (String) invokeV.objValue;
    }

    public final void v6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            jr7 R1 = this.x0.R1();
            this.x0.E3(true);
            jl4 jl4Var = this.z0;
            if (jl4Var != null) {
                R1.E0(jl4Var.g());
            }
            this.F0.F1(R1);
        }
    }

    public final void v7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048758, this) == null) || (pbModel = this.x0) == null || oi.isEmpty(pbModel.j2())) {
            return;
        }
        li4.w().P(ki4.Z, ng.g(this.x0.j2(), 0L));
    }

    public final String w5() {
        InterceptResult invokeV;
        jr7 R1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || (R1 = pbModel.R1()) == null) {
                return null;
            }
            return R1.T().c;
        }
        return (String) invokeV.objValue;
    }

    public void w6() {
        nv7 nv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048760, this) == null) || (nv7Var = this.F0) == null) {
            return;
        }
        nv7Var.Z1();
    }

    public final void w7(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048761, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f091eed) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eed)) != null) {
            x7(postData, false);
        }
    }

    @Override // com.repackage.vg5
    public eg<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            if (this.L == null) {
                this.L = new eg<>(new k2(this), 20, 0);
            }
            return this.L;
        }
        return (eg) invokeV.objValue;
    }

    public final String x5() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.R1() == null || this.x0.R1().F() == null || (count = ListUtils.getCount((F = this.x0.R1().F()))) == 0) {
                return "";
            }
            if (this.x0.c2()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.B() == 1) {
                        return next.J();
                    }
                }
            }
            int H0 = this.F0.H0();
            PostData postData = (PostData) ListUtils.getItem(F, H0);
            if (postData != null && postData.s() != null) {
                if (this.x0.H2(postData.s().getUserId())) {
                    return postData.J();
                }
                for (int i3 = H0 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (this.x0.H2(postData2.s().getUserId())) {
                        return postData2.J();
                    }
                }
                for (int i4 = H0 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (this.x0.H2(postData3.s().getUserId())) {
                        return postData3.J();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void x6() {
        MarkData h12;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048764, this) == null) || this.z0 == null) {
            return;
        }
        if (this.x0.R1() != null && this.x0.R1().g0()) {
            h12 = this.x0.h1(0);
        } else {
            h12 = this.x0.h1(this.F0.Q0());
        }
        if (h12 == null) {
            return;
        }
        if (h12.isApp() && (h12 = this.x0.h1(this.F0.Q0() + 1)) == null) {
            return;
        }
        this.F0.q3();
        this.z0.i(h12);
        if (!this.z0.e()) {
            if (this.F0 != null && this.x0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !gx7.k(this.x0.b)) {
                this.F0.Y3();
                gx7.b(this.x0.b);
            }
            this.z0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.z0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final void x7(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048765, this, postData, z3) == null) || postData == null || (pbModel = this.x0) == null || pbModel.R1() == null || postData.B() == 1) {
            return;
        }
        String j22 = this.x0.j2();
        String J = postData.J();
        int V = this.x0.R1() != null ? this.x0.R1().V() : 0;
        AbsPbActivity.e J6 = J6(J);
        if (J6 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(j22, J, "pb", true, false, null, false, null, V, postData.V(), this.x0.R1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(J6.a, J6.b, J6.g, J6.j);
        addBigImageData.setKeyPageStartFrom(this.x0.Q1());
        addBigImageData.setFromFrsForumId(this.x0.getFromForumId());
        addBigImageData.setWorksInfoData(this.x0.o2());
        addBigImageData.setKeyFromForumId(this.x0.getForumId());
        addBigImageData.setBjhData(this.x0.j1());
        addBigImageData.setIsOpenEditor(z3);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText y5(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048766, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText Q = arrayList.get(i4).Q();
                    if (Q != null && (C = Q.C()) != null) {
                        int size = C.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (C.get(i6) != null && C.get(i6).getType() == 8) {
                                i5++;
                                if (C.get(i6).G().C().equals(str) || C.get(i6).G().D().equals(str)) {
                                    int h3 = (int) pi.h(TbadkCoreApplication.getInst());
                                    int width = C.get(i6).G().getWidth() * h3;
                                    int height = C.get(i6).G().getHeight() * h3;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.x2 = i6;
                                    return Q;
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

    public final void y6(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048767, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eed)) == null) {
                return;
            }
            z6(postData);
        }
    }

    public final void y7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048768, this) == null) {
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                absPbActivity.d1();
            }
        }
    }

    @Override // com.repackage.vg5
    public eg<TiebaPlusRecommendCard> z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
            if (this.E == null) {
                this.E = new eg<>(new l2(this), 5, 0);
            }
            return this.E;
        }
        return (eg) invokeV.objValue;
    }

    public final int z5(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048770, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.z2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.C().size();
                int i5 = i3;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.C().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int h3 = (int) pi.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.G().getWidth() * h3;
                        int height = tbRichTextData.G().getHeight() * h3;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.G().I()) {
                            if (tbRichText == tbRichText2) {
                                if (i6 <= i4) {
                                    i5--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a4 = kr7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a4)) {
                                arrayList.add(a4);
                                if (tbRichTextData != null && (G = tbRichTextData.G()) != null) {
                                    String C = G.C();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        C = G.D();
                                    } else {
                                        imageUrlData.urlType = this.s ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = C;
                                    imageUrlData.originalUrl = I5(tbRichTextData);
                                    imageUrlData.originalSize = J5(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = D5(tbRichTextData);
                                    imageUrlData.isLongPic = B5(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = ng.g(this.x0.j2(), -1L);
                                    imageUrlData.mIsReserver = this.x0.c2();
                                    imageUrlData.mIsSeeHost = this.x0.u1();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a4, imageUrlData);
                                    }
                                }
                            }
                            if (!this.z2) {
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

    public void z6(PostData postData) {
        PostData u5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048771, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.J() != null && postData.J().equals(this.x0.M1())) {
            z3 = true;
        }
        MarkData L1 = this.x0.L1(postData);
        if (this.x0.R1() != null && this.x0.R1().g0() && (u5 = u5()) != null) {
            L1 = this.x0.L1(u5);
        }
        if (L1 == null) {
            return;
        }
        this.F0.q3();
        jl4 jl4Var = this.z0;
        if (jl4Var != null) {
            jl4Var.i(L1);
            if (!z3) {
                this.z0.a();
            } else {
                this.z0.d();
            }
        }
    }

    public final void z7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048772, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.e1();
    }
}
